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
    private TbPageContext<MsglistActivity<?>> aaS;
    private MsgLeftViewItemAdapter dgC;
    private MsgRightViewItemAdapter dgD;
    private MsgMidViewItemAdapter dgE;
    private CustomMessageListener dgF;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.dgF = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.dfU != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.dfU);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.aaS = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.dgC.lK(i);
        this.dgD.lK(i);
    }

    private void initAdapters() {
        this.dgC = new MsgLeftViewItemAdapter(this.aaS, ChatMessage.TYPE_MSG_LEFT);
        this.dgC.fT(true);
        this.dgC.fS(true);
        this.dgD = new MsgRightViewItemAdapter(this.aaS, ChatMessage.TYPE_MSG_RIGHT);
        this.dgD.fT(true);
        this.dgD.fS(true);
        this.dgE = new MsgMidViewItemAdapter(this.aaS, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.dgC);
        this.mAdapters.add(this.dgD);
        this.mAdapters.add(this.dgE);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.dfU = new ArrayList();
        aVar.context = this.aaS;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.dgF.setPriority(Integer.MAX_VALUE);
        this.aaS.registerListener(this.dgF);
    }

    public void fU(boolean z) {
        if (this.dgC != null) {
            this.dgC.fU(z);
        }
    }

    public void fV(boolean z) {
        if (this.dgD != null) {
            this.dgD.fV(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.arG()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.arF()) {
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
        if (this.dgF != null) {
            MessageManager.getInstance().unRegisterListener(this.dgF);
            this.dgF = null;
        }
    }
}
