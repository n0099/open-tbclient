package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.IMConnection;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.tieba.im.data.GroupMsgData;
import com.baidu.tieba.im.db.j;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.util.MessageUtils;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import protobuf.NewpushGroupRepair;
/* loaded from: classes.dex */
public class a {
    private static a jGg = null;
    private final CustomMessageListener jFs = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler jGh;
    private ConcurrentHashMap<Long, GroupMsgData> jGi;
    private ConcurrentHashMap<Long, NewpushGroupRepair> jGj;
    private ConcurrentHashMap<Long, Runnable> jGk;
    private Vector<Long> jGl;
    private Handler mHandler;

    public static a cLo() {
        if (jGg == null) {
            synchronized (a.class) {
                if (jGg == null) {
                    jGg = new a();
                }
            }
        }
        return jGg;
    }

    private a() {
        this.mHandler = null;
        this.jGh = null;
        this.jGi = null;
        this.jGj = null;
        this.jGk = null;
        this.jGl = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.jFs);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            a.this.jGl.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.jGh = new Handler(Looper.myLooper());
        this.jGi = new ConcurrentHashMap<>();
        this.jGj = new ConcurrentHashMap<>();
        this.jGk = new ConcurrentHashMap<>();
        this.jGl = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo bd = j.cHO().bd(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(bd != null)) {
                if (!this.jGl.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = bd.getSid();
            long fF = com.baidu.tieba.im.util.d.fF(bd.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.jGi.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.jGi.put(Long.valueOf(groupId), groupMsgData4);
                groupMsgData2 = groupMsgData4;
            } else {
                groupMsgData2 = groupMsgData3;
            }
            Iterator<ChatMessage> it = listMessage.iterator();
            while (it.hasNext()) {
                ChatMessage next = it.next();
                if (next.getSid() > sid) {
                    a(next, groupMsgData2);
                }
            }
            listMessage.clear();
            List<ChatMessage> fw = fw(groupId);
            if (fw != null && fw.size() > 0) {
                if (z || sid <= 0 || fw.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(fw);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    fF = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(fw);
                }
            }
            if (z) {
                this.jGl.remove(Long.valueOf(groupId));
            }
            if (!this.jGl.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), fF);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.jGj.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.jGl.add(Long.valueOf(j));
            fx(j);
        }
    }

    private List<ChatMessage> fw(long j) {
        GroupMsgData groupMsgData = this.jGi.get(Long.valueOf(j));
        if (groupMsgData == null) {
            return null;
        }
        LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
        if (listMessage == null || listMessage.size() == 0) {
            return null;
        }
        LinkedList linkedList = new LinkedList();
        Iterator<ChatMessage> it = listMessage.iterator();
        long sid = listMessage.get(0).getSid() - 1;
        while (true) {
            long j2 = sid;
            if (!it.hasNext()) {
                break;
            }
            ChatMessage next = it.next();
            if (next.getSid() != j2 + 1) {
                break;
            }
            it.remove();
            linkedList.add(next);
            sid = j2 + 1;
        }
        return linkedList;
    }

    private void a(long j, long j2, int i, long j3) {
        GroupMsgData groupMsgData = this.jGi.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                fz(j2);
            } else if (!this.jGk.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.jGi.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.fz(j2);
                    return;
                }
                LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
                long j4 = -1;
                if (listMessage != null && listMessage.size() > 0) {
                    int i2 = 0;
                    while (true) {
                        int i3 = i2;
                        if (i3 >= listMessage.size()) {
                            break;
                        }
                        if (j4 < listMessage.get(i3).getSid()) {
                            j4 = listMessage.get(i3).getSid();
                        }
                        i2 = i3 + 1;
                    }
                    listMessage.clear();
                }
                long j5 = j4;
                a.this.fz(j2);
                if (j5 > j) {
                    a.this.jGj.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.cKX().c(j2, 1L, 0L, true);
                    a.this.jGl.add(Long.valueOf(j2));
                    a.this.fx(j2);
                }
            }
        };
        this.jGh.postDelayed(runnable, b.cLp().lF().getTimeOutAuto());
        this.jGk.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, IMConnection.RETRY_DELAY_TIMES);
    }

    public NewpushGroupRepair fy(long j) {
        if (this.jGj.containsKey(Long.valueOf(j))) {
            return this.jGj.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(long j) {
        Runnable remove = this.jGk.remove(Long.valueOf(j));
        if (remove != null) {
            this.jGh.removeCallbacks(remove);
        }
    }

    private boolean a(ChatMessage chatMessage, GroupMsgData groupMsgData) {
        LinkedList<ChatMessage> listMessage;
        if (chatMessage == null || groupMsgData == null || (listMessage = groupMsgData.getListMessage()) == null) {
            return false;
        }
        if (listMessage.contains(chatMessage)) {
            return true;
        }
        int size = listMessage.size();
        int i = 0;
        while (i < size) {
            ChatMessage chatMessage2 = listMessage.get(i);
            if (chatMessage2 != null) {
                if (chatMessage.getSid() == chatMessage2.getSid()) {
                    return true;
                }
                if (chatMessage.getSid() < chatMessage2.getSid()) {
                    break;
                }
            }
            i++;
        }
        listMessage.add(i, chatMessage);
        return true;
    }

    public void clearAll() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.jGh != null) {
            this.jGh.removeCallbacksAndMessages(null);
        }
        if (this.jGk != null) {
            for (Map.Entry<Long, Runnable> entry : this.jGk.entrySet()) {
                fz(entry.getKey().longValue());
            }
            this.jGk.clear();
        }
        if (this.jGi != null) {
            this.jGi.clear();
        }
        if (this.jGl != null) {
            this.jGl.clear();
        }
    }
}
