package com.baidu.tieba.im.model;

import android.util.LongSparseArray;
import androidx.annotation.RequiresApi;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
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
import d.b.c.c.g.a;
import d.b.i0.e1.l.c.a;
import d.b.i0.e1.l.c.b;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class OfficialBarFeedMsglistModel extends BdBaseModel<OfficialBarFeedActivity> {
    public static final int MAX_FEED_ITEM_COUNT = 80;
    public IFeedHeadLoadCallback callback;
    public CustomMessageListener mCustomMessageListener;
    public a netMessageListener;

    /* loaded from: classes4.dex */
    public interface IFeedHeadLoadCallback {
        void onListDataLoad(List<b> list, List<d.b.i0.e1.h.o.a> list2);

        void onReadCountLoad(LongSparseArray<d.b.i0.e1.i.a.b.b> longSparseArray);
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
            @Override // d.b.c.c.g.a
            @RequiresApi(api = 16)
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                d.b.i0.e1.i.a.b.a data;
                if (responsedMessage == null) {
                    return;
                }
                LongSparseArray<d.b.i0.e1.i.a.b.b> longSparseArray = null;
                if (responsedMessage instanceof ResponseHttpMajorHistoryMessage) {
                    data = ((ResponseHttpMajorHistoryMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ResponseSocketMajorHistoryMessage ? ((ResponseSocketMajorHistoryMessage) responsedMessage).getData() : null;
                }
                if (data == null) {
                    return;
                }
                List<d.b.i0.e1.i.a.b.b> b2 = data.b();
                if (b2 != null && b2.size() > 0) {
                    longSparseArray = new LongSparseArray<>(b2.size());
                    for (d.b.i0.e1.i.a.b.b bVar : b2) {
                        longSparseArray.put(bVar.b(), bVar);
                    }
                }
                if (OfficialBarFeedMsglistModel.this.callback == null || longSparseArray == null) {
                    return;
                }
                OfficialBarFeedMsglistModel.this.callback.onReadCountLoad(longSparseArray);
            }
        };
        registerListener();
        registerTask();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processHeadBarInfo(CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && (customResponsedMessage instanceof OfficialFeedHeadResponsedMessage)) {
            OfficialFeedHeadResponsedMessage officialFeedHeadResponsedMessage = (OfficialFeedHeadResponsedMessage) customResponsedMessage;
            if (officialFeedHeadResponsedMessage.getData() == null) {
                return;
            }
            List<ChatMessage> list = officialFeedHeadResponsedMessage.getData().f17739b;
            ArrayList arrayList = new ArrayList();
            loop0: for (ChatMessage chatMessage : list) {
                List<a.C1266a> b2 = d.b.i0.e1.l.c.a.b(chatMessage.getContent(), chatMessage.getUserInfo().getUserId(), chatMessage.getUserInfo(), chatMessage.getMsgId(), chatMessage.getStatTaskId(), chatMessage.getStatisticsServiceId());
                if (b2 != null && b2.size() > 0 && (chatMessage instanceof OfficialChatMessage)) {
                    int i = 0;
                    while (i < b2.size()) {
                        if (arrayList.size() >= 80) {
                            break loop0;
                        }
                        a.C1266a c1266a = b2.get(i);
                        b b3 = b.b(chatMessage, c1266a);
                        b3.j(i == 0 && !StringUtils.isNull(c1266a.f55431c));
                        arrayList.add(b3);
                        i++;
                    }
                    continue;
                }
            }
            sendReadCountMessage(arrayList);
            IFeedHeadLoadCallback iFeedHeadLoadCallback = this.callback;
            if (iFeedHeadLoadCallback != null) {
                iFeedHeadLoadCallback.onListDataLoad(arrayList, officialFeedHeadResponsedMessage.getData().f17738a);
            }
        }
    }

    private void registerListener() {
        registerListener(this.mCustomMessageListener);
        registerListener(this.netMessageListener);
    }

    private void registerTask() {
        d.b.i0.d3.d0.a.h(309669, ResponseSocketMajorHistoryMessage.class, false, false);
        d.b.i0.d3.d0.a.c(309669, CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY, TbConfig.URL_FORUM_BROADCAST_HISTORY, ResponseHttpMajorHistoryMessage.class, true, false, true, false);
    }

    private void sendReadCountMessage(List<b> list) {
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (b bVar : list) {
            if (bVar.h()) {
                arrayList.add(Long.valueOf(bVar.f().f55436h));
            }
        }
        BroadcastMajorHistoryRequestMessage broadcastMajorHistoryRequestMessage = new BroadcastMajorHistoryRequestMessage();
        broadcastMajorHistoryRequestMessage.queryType = 2;
        broadcastMajorHistoryRequestMessage.bcastIds = arrayList;
        sendMessage(broadcastMajorHistoryRequestMessage);
    }

    private void unRegisterListener() {
        MessageManager.getInstance().unRegisterListener(this.mCustomMessageListener);
        MessageManager.getInstance().unRegisterListener(this.netMessageListener);
    }

    private void unRegisterTask() {
        MessageManager.getInstance().unRegisterTask(309669);
        MessageManager.getInstance().unRegisterTask(CmdConfigHttp.CMD_FORUM_BROADCAST_MAJOR_HISTORY);
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
    public boolean LoadData() {
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

    public void setHeadLoadCallback(IFeedHeadLoadCallback iFeedHeadLoadCallback) {
        this.callback = iFeedHeadLoadCallback;
    }
}
