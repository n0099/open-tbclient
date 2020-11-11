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
    private static a knA = null;
    private final CustomMessageListener kmM = new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler knB;
    private ConcurrentHashMap<Long, GroupMsgData> knC;
    private ConcurrentHashMap<Long, NewpushGroupRepair> knD;
    private ConcurrentHashMap<Long, Runnable> knE;
    private Vector<Long> knF;
    private Handler mHandler;

    public static a cUE() {
        if (knA == null) {
            synchronized (a.class) {
                if (knA == null) {
                    knA = new a();
                }
            }
        }
        return knA;
    }

    private a() {
        this.mHandler = null;
        this.knB = null;
        this.knC = null;
        this.knD = null;
        this.knE = null;
        this.knF = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.kmM);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey(TbEnum.SystemMessage.KEY_GROUP_ID)) {
                            a.this.knF.remove(Long.valueOf(message.getData().getLong(TbEnum.SystemMessage.KEY_GROUP_ID)));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.knB = new Handler(Looper.myLooper());
        this.knC = new ConcurrentHashMap<>();
        this.knD = new ConcurrentHashMap<>();
        this.knE = new ConcurrentHashMap<>();
        this.knF = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo bh = j.cRf().bh(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(bh != null)) {
                if (!this.knF.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = bh.getSid();
            long gu = com.baidu.tieba.im.util.d.gu(bh.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.knC.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.knC.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> gl = gl(groupId);
            if (gl != null && gl.size() > 0) {
                if (z || sid <= 0 || gl.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(gl);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    gu = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(gl);
                }
            }
            if (z) {
                this.knF.remove(Long.valueOf(groupId));
            }
            if (!this.knF.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), gu);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.knD.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.knF.add(Long.valueOf(j));
            gm(j);
        }
    }

    private List<ChatMessage> gl(long j) {
        GroupMsgData groupMsgData = this.knC.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.knC.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                go(j2);
            } else if (!this.knE.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.knC.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.go(j2);
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
                a.this.go(j2);
                if (j5 > j) {
                    a.this.knD.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.cUo().c(j2, 1L, 0L, true);
                    a.this.knF.add(Long.valueOf(j2));
                    a.this.gm(j2);
                }
            }
        };
        this.knB.postDelayed(runnable, b.cUF().lG().getTimeOutAuto());
        this.knE.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gm(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong(TbEnum.SystemMessage.KEY_GROUP_ID, j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, IMConnection.RETRY_DELAY_TIMES);
    }

    public NewpushGroupRepair gn(long j) {
        if (this.knD.containsKey(Long.valueOf(j))) {
            return this.knD.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void go(long j) {
        Runnable remove = this.knE.remove(Long.valueOf(j));
        if (remove != null) {
            this.knB.removeCallbacks(remove);
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
        if (this.knB != null) {
            this.knB.removeCallbacksAndMessages(null);
        }
        if (this.knE != null) {
            for (Map.Entry<Long, Runnable> entry : this.knE.entrySet()) {
                go(entry.getKey().longValue());
            }
            this.knE.clear();
        }
        if (this.knC != null) {
            this.knC.clear();
        }
        if (this.knF != null) {
            this.knF.clear();
        }
    }
}
