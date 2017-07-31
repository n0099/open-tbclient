package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.c.b;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TbPageContext<MsglistActivity<?>> acp;
    private MsgLeftViewItemAdapter dhU;
    private MsgRightViewItemAdapter dhV;
    private MsgMidViewItemAdapter dhW;
    private CustomMessageListener dhX;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.dhX = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.dhm != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.dhm);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.acp = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.dhU.lK(i);
        this.dhV.lK(i);
    }

    private void initAdapters() {
        this.dhU = new MsgLeftViewItemAdapter(this.acp, ChatMessage.TYPE_MSG_LEFT);
        this.dhU.fT(true);
        this.dhU.fS(true);
        this.dhV = new MsgRightViewItemAdapter(this.acp, ChatMessage.TYPE_MSG_RIGHT);
        this.dhV.fT(true);
        this.dhV.fS(true);
        this.dhW = new MsgMidViewItemAdapter(this.acp, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.dhU);
        this.mAdapters.add(this.dhV);
        this.mAdapters.add(this.dhW);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.dhm = new ArrayList();
        aVar.context = this.acp;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.dhX.setPriority(Integer.MAX_VALUE);
        this.acp.registerListener(this.dhX);
    }

    public void fU(boolean z) {
        if (this.dhU != null) {
            this.dhU.fU(z);
        }
    }

    public void fV(boolean z) {
        if (this.dhV != null) {
            this.dhV.fV(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.arS()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.arR()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void h(ChatMessage chatMessage) {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.d) {
            ((com.baidu.adp.widget.ListView.d) this.mListView.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.mData = list;
        ArrayList arrayList = new ArrayList();
        if (this.mData != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.mData);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.dhX != null) {
            MessageManager.getInstance().unRegisterListener(this.dhX);
            this.dhX = null;
        }
    }
}
