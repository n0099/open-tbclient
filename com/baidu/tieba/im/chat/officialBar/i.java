package com.baidu.tieba.im.chat.officialBar;

import android.support.annotation.RequiresApi;
import android.util.LongSparseArray;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryMessage;
import com.baidu.tieba.im.message.LoadHistoryResponsedMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes20.dex */
public class i {
    private TbPageContext context;
    private a iUx;
    private CustomMessageListener mCustomMessageListener = new CustomMessageListener(0) { // from class: com.baidu.tieba.im.chat.officialBar.i.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001147) {
                i.this.j(customResponsedMessage);
            }
        }
    };
    private com.baidu.adp.framework.listener.a iUz = new com.baidu.adp.framework.listener.a(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669) { // from class: com.baidu.tieba.im.chat.officialBar.i.2
        @Override // com.baidu.adp.framework.listener.a
        @RequiresApi(api = 16)
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            com.baidu.tieba.im.forum.broadcast.data.a data;
            LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray = null;
            if (responsedMessage != null) {
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
                }
                if (data != null) {
                    List<com.baidu.tieba.im.forum.broadcast.data.b> ctG = data.ctG();
                    if (ctG != null && ctG.size() > 0) {
                        LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray2 = new LongSparseArray<>(ctG.size());
                        for (com.baidu.tieba.im.forum.broadcast.data.b bVar : ctG) {
                            longSparseArray2.put(bVar.ctM(), bVar);
                        }
                        longSparseArray = longSparseArray2;
                    }
                    if (i.this.iUx != null && longSparseArray != null) {
                        i.this.iUx.onReadCountLoad(longSparseArray);
                    }
                }
            }
        }
    };

    /* loaded from: classes20.dex */
    public interface a {
        void dr(List<com.baidu.tieba.im.message.chat.b> list);

        void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray);
    }

    public i(TbPageContext tbPageContext) {
        this.context = tbPageContext;
        tbPageContext.registerListener(CmdConfigCustom.CMD_LOAD_HISTORY_OFFICICAL, this.mCustomMessageListener);
        tbPageContext.registerListener(this.iUz);
    }

    public void GD(String str) {
        LoadHistoryMessage.a aVar = new LoadHistoryMessage.a();
        aVar.limit = 150;
        aVar.id = str;
        this.context.sendMessage(new LoadOfficialHistoryMessage(aVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof LoadHistoryResponsedMessage)) {
            LoadHistoryResponsedMessage loadHistoryResponsedMessage = (LoadHistoryResponsedMessage) customResponsedMessage;
            if (loadHistoryResponsedMessage.getData() != null) {
                List<ChatMessage> list = loadHistoryResponsedMessage.getData().msgList;
                ArrayList arrayList = new ArrayList();
                for (ChatMessage chatMessage : list) {
                    List<a.C0667a> a2 = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId());
                    if (a2 != null && a2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                        int i = 0;
                        while (i < a2.size()) {
                            a.C0667a c0667a = a2.get(i);
                            com.baidu.tieba.im.message.chat.b a3 = com.baidu.tieba.im.message.chat.b.a(chatMessage, c0667a);
                            a3.qo(i == 0 && !StringUtils.isNull(c0667a.src));
                            arrayList.add(a3);
                            i++;
                        }
                    }
                }
                sendReadCountMessage(arrayList);
                if (this.iUx != null) {
                    this.iUx.dr(arrayList);
                }
            }
        }
    }

    private void sendReadCountMessage(List<com.baidu.tieba.im.message.chat.b> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            for (com.baidu.tieba.im.message.chat.b bVar : list) {
                if (bVar.cws()) {
                    arrayList.add(Long.valueOf(bVar.cwt().jhm));
                }
            }
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 2;
            broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
            this.context.sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }

    public void a(a aVar) {
        this.iUx = aVar;
    }
}
