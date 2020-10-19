package com.baidu.tieba.im.model;

import android.support.annotation.RequiresApi;
import android.util.LongSparseArray;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.a;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.forum.broadcast.data.BroadcastMajorHistoryRequestMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseHttpMajorHistoryMessage;
import com.baidu.tieba.im.forum.broadcast.data.ResponseSocketMajorHistoryMessage;
import com.baidu.tieba.im.message.LoadOfficialHistoryMessage;
import com.baidu.tieba.im.message.OfficialFeedHeadResponsedMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.OfficialChatMessage;
import com.baidu.tieba.im.message.chat.a;
import com.baidu.tieba.im.message.chat.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes26.dex */
public class OfficialBarFeedMsglistModel extends BdBaseModel<OfficialBarFeedActivity> {
    public static final int MAX_FEED_ITEM_COUNT = 80;
    private IFeedHeadLoadCallback callback;
    private CustomMessageListener mCustomMessageListener;
    private a netMessageListener;

    /* loaded from: classes26.dex */
    public interface IFeedHeadLoadCallback {
        void onListDataLoad(List<b> list, List<com.baidu.tieba.im.db.pojo.a> list2);

        void onReadCountLoad(LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray);
    }

    public OfficialBarFeedMsglistModel(TbPageContext<OfficialBarFeedActivity> tbPageContext) {
        super(tbPageContext);
        this.callback = null;
        this.mCustomMessageListener = new CustomMessageListener(2001154) { // from class: com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001154) {
                    OfficialBarFeedMsglistModel.this.processHeadBarInfo(customResponsedMessage);
                }
            }
        };
        this.netMessageListener = new a(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, 309669) { // from class: com.baidu.tieba.im.model.OfficialBarFeedMsglistModel.2
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
                        List<com.baidu.tieba.im.forum.broadcast.data.b> cLN = data.cLN();
                        if (cLN != null && cLN.size() > 0) {
                            LongSparseArray<com.baidu.tieba.im.forum.broadcast.data.b> longSparseArray2 = new LongSparseArray<>(cLN.size());
                            for (com.baidu.tieba.im.forum.broadcast.data.b bVar : cLN) {
                                longSparseArray2.put(bVar.cLT(), bVar);
                            }
                            longSparseArray = longSparseArray2;
                        }
                        if (OfficialBarFeedMsglistModel.this.callback != null && longSparseArray != null) {
                            OfficialBarFeedMsglistModel.this.callback.onReadCountLoad(longSparseArray);
                        }
                    }
                }
            }
        };
        registerListener();
        registerTask();
    }

    public void LoadData(boolean z) {
        if (!z) {
            LinkedList<CustomMessage<?>> findCustomMessage = MessageManager.getInstance().findCustomMessage(getUniqueId());
            if (findCustomMessage == null || findCustomMessage.size() <= 0) {
                super.sendMessage(new LoadOfficialHistoryMessage(2001154, null));
                return;
            }
            return;
        }
        super.sendMessage(new LoadOfficialHistoryMessage(2001154, null));
    }

    @Override // com.baidu.adp.base.BdBaseModel
    @Deprecated
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        cancelMessage();
        return true;
    }

    public void onDestroy() {
        cancelMessage();
        unRegisterListener();
        unRegisterTask();
    }

    private void registerListener() {
        registerListener(this.mCustomMessageListener);
        registerListener(this.netMessageListener);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    private void registerTask() {
        com.baidu.tieba.tbadkCore.a.a.a(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
    }

    private void unRegisterTask() {
        MessageManager.getInstance().unRegisterTask(309669);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
    }

    public void setHeadLoadCallback(IFeedHeadLoadCallback iFeedHeadLoadCallback) {
        this.callback = iFeedHeadLoadCallback;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHeadBarInfo(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof OfficialFeedHeadResponsedMessage)) {
            OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = (OfficialFeedHeadResponsedMessage) customResponsedMessage;
            if (officialFeedHeadResponsedMessage.getData() != null) {
                List<ChatMessage> list = officialFeedHeadResponsedMessage.getData().jTG;
                ArrayList arrayList = new ArrayList();
                loop0: for (ChatMessage chatMessage : list) {
                    List<a.C0734a> a2 = com.baidu.tieba.im.message.chat.a.a(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                    if (a2 != null && a2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                        int i = 0;
                        while (i < a2.size()) {
                            if (arrayList.size() >= 80) {
                                break loop0;
                            }
                            a.C0734a c0734a = a2.get(i);
                            b a3 = b.a(chatMessage, c0734a);
                            a3.rK(i == 0 && !StringUtils.isNull(c0734a.src));
                            arrayList.add(a3);
                            i++;
                        }
                        continue;
                    }
                }
                sendReadCountMessage(arrayList);
                if (this.callback != null) {
                    this.callback.onListDataLoad(arrayList, officialFeedHeadResponsedMessage.getData().msgList);
                }
            }
        }
    }

    private void sendReadCountMessage(List<b> list) {
        if (list != null && list.size() > 0) {
            ArrayList arrayList = new ArrayList(list.size());
            for (b bVar : list) {
                if (bVar.cOz()) {
                    arrayList.add(Long.valueOf(bVar.cOA().jTT));
                }
            }
            BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
            broadcastMajorHistoryRequestMessage.queryType = 2;
            broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
            sendMessage(broadcastMajorHistoryRequestMessage);
        }
    }
}
