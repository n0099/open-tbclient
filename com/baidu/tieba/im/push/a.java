package com.baidu.tieba.im.push;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
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
    private static a eAo = null;
    private Handler eAp;
    private ConcurrentHashMap<Long, GroupMsgData> eAq;
    private ConcurrentHashMap<Long, NewpushGroupRepair> eAr;
    private ConcurrentHashMap<Long, Runnable> eAs;
    private Vector<Long> eAt;
    private final CustomMessageListener ezC = new CustomMessageListener(2005016) { // from class: com.baidu.tieba.im.push.a.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016) {
                a.this.clearAll();
            }
        }
    };
    private Handler mHandler;

    public static a aMP() {
        if (eAo == null) {
            synchronized (a.class) {
                if (eAo == null) {
                    eAo = new a();
                }
            }
        }
        return eAo;
    }

    private a() {
        this.mHandler = null;
        this.eAp = null;
        this.eAq = null;
        this.eAr = null;
        this.eAs = null;
        this.eAt = null;
        this.mHandler = new Handler(Looper.getMainLooper()) { // from class: com.baidu.tieba.im.push.a.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                switch (message.what) {
                    case 10001:
                        MessageUtils.updateGroupNotExist(message.getData());
                        return;
                    case 10002:
                        MessageManager.getInstance().registerListener(a.this.ezC);
                        return;
                    case 10003:
                        if (message.getData() != null && message.getData().containsKey("groupId")) {
                            a.this.eAt.remove(Long.valueOf(message.getData().getLong("groupId")));
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        };
        this.eAp = new Handler(Looper.myLooper());
        this.eAq = new ConcurrentHashMap<>();
        this.eAr = new ConcurrentHashMap<>();
        this.eAs = new ConcurrentHashMap<>();
        this.eAt = new Vector<>();
        this.mHandler.sendEmptyMessage(10002);
    }

    public void a(GroupMsgData groupMsgData, boolean z) {
        LinkedList<ChatMessage> listMessage;
        GroupMsgData groupMsgData2;
        if (groupMsgData != null && groupMsgData.getGroupInfo() != null && (listMessage = groupMsgData.getListMessage()) != null && listMessage.size() != 0) {
            long groupId = groupMsgData.getGroupInfo().getGroupId();
            ImMessageCenterPojo aj = j.aJG().aj(String.valueOf(groupId), groupMsgData.getGroupInfo().getCustomType());
            if (!(aj != null)) {
                if (!this.eAt.contains(Long.valueOf(groupId))) {
                    a(groupMsgData, listMessage, groupId);
                    return;
                }
                return;
            }
            long sid = aj.getSid();
            long cq = com.baidu.tieba.im.util.d.cq(aj.getPulled_msgId());
            GroupMsgData groupMsgData3 = this.eAq.get(Long.valueOf(groupId));
            if (groupMsgData3 == null) {
                GroupMsgData groupMsgData4 = new GroupMsgData(groupMsgData.getCmd());
                this.eAq.put(Long.valueOf(groupId), groupMsgData4);
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
            List<ChatMessage> cg = cg(groupId);
            if (cg != null && cg.size() > 0) {
                if (z || sid <= 0 || cg.get(0).getSid() == 1 + sid) {
                    listMessage.addAll(cg);
                    sid = listMessage.get(listMessage.size() - 1).getSid();
                    cq = listMessage.get(listMessage.size() - 1).getMsgId();
                } else {
                    groupMsgData2.getListMessage().addAll(cg);
                }
            }
            if (z) {
                this.eAt.remove(Long.valueOf(groupId));
            }
            if (!this.eAt.contains(Long.valueOf(groupId))) {
                a(sid, groupId, groupMsgData.getGroupInfo().getUserType(), cq);
            }
        }
    }

    private void a(GroupMsgData groupMsgData, LinkedList<ChatMessage> linkedList, long j) {
        if (groupMsgData != null && linkedList != null && linkedList.size() != 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("groupId", j);
            bundle.putLong("lastMid", linkedList.get(0).getMsgId());
            if (linkedList.get(0).getSid() > 0) {
                this.eAr.put(Long.valueOf(j), MessageUtils.makeNewpushGroupRepair(groupMsgData));
            }
            bundle.putInt("type", groupMsgData.getGroupInfo().getCustomType());
            Message message = new Message();
            message.what = 10001;
            message.setData(bundle);
            this.mHandler.sendMessage(message);
            linkedList.clear();
            this.eAt.add(Long.valueOf(j));
            ch(j);
        }
    }

    private List<ChatMessage> cg(long j) {
        GroupMsgData groupMsgData = this.eAq.get(Long.valueOf(j));
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
        GroupMsgData groupMsgData = this.eAq.get(Long.valueOf(j2));
        if (groupMsgData != null) {
            LinkedList<ChatMessage> listMessage = groupMsgData.getListMessage();
            if (listMessage == null || listMessage.size() == 0) {
                cj(j2);
            } else if (!this.eAs.containsKey(Long.valueOf(j2))) {
                b(j, j2, i, j3);
            }
        }
    }

    private void b(final long j, final long j2, final int i, final long j3) {
        Runnable runnable = new Runnable() { // from class: com.baidu.tieba.im.push.a.2
            @Override // java.lang.Runnable
            public void run() {
                GroupMsgData groupMsgData = (GroupMsgData) a.this.eAq.get(Long.valueOf(j2));
                if (groupMsgData == null) {
                    a.this.cj(j2);
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
                a.this.cj(j2);
                if (j5 > j) {
                    a.this.eAr.put(Long.valueOf(j2), MessageUtils.makeNewpushGroupRepair(j2, i, j, j5, j3));
                    com.baidu.tieba.im.a.b.aMy().a(j2, 1L, 0L, true);
                    a.this.eAt.add(Long.valueOf(j2));
                    a.this.ch(j2);
                }
            }
        };
        this.eAp.postDelayed(runnable, b.aMQ().fR().fS());
        this.eAs.put(Long.valueOf(j2), runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(long j) {
        Message message = new Message();
        message.what = 10003;
        Bundle bundle = new Bundle();
        bundle.putLong("groupId", j);
        message.setData(bundle);
        this.mHandler.sendMessageDelayed(message, 3000L);
    }

    public NewpushGroupRepair ci(long j) {
        if (this.eAr.containsKey(Long.valueOf(j))) {
            return this.eAr.remove(Long.valueOf(j));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cj(long j) {
        Runnable remove = this.eAs.remove(Long.valueOf(j));
        if (remove != null) {
            this.eAp.removeCallbacks(remove);
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
        if (this.eAp != null) {
            this.eAp.removeCallbacksAndMessages(null);
        }
        if (this.eAs != null) {
            for (Map.Entry<Long, Runnable> entry : this.eAs.entrySet()) {
                cj(entry.getKey().longValue());
            }
            this.eAs.clear();
        }
        if (this.eAq != null) {
            this.eAq.clear();
        }
        if (this.eAt != null) {
            this.eAt.clear();
        }
    }
}
