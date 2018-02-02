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
    private TbPageContext<MsglistActivity<?>> aQs;
    private MsgLeftViewItemAdapter esu;
    private MsgRightViewItemAdapter esv;
    private MsgMidViewItemAdapter esw;
    private CustomMessageListener esx;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.esx = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.erL != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.erL);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.aQs = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.esu.pG(i);
        this.esv.pG(i);
    }

    private void initAdapters() {
        this.esu = new MsgLeftViewItemAdapter(this.aQs, ChatMessage.TYPE_MSG_LEFT);
        this.esu.gS(true);
        this.esu.gR(true);
        this.esv = new MsgRightViewItemAdapter(this.aQs, ChatMessage.TYPE_MSG_RIGHT);
        this.esv.gS(true);
        this.esv.gR(true);
        this.esw = new MsgMidViewItemAdapter(this.aQs, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.esu);
        this.mAdapters.add(this.esv);
        this.mAdapters.add(this.esw);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.erL = new ArrayList();
        aVar.context = this.aQs;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.esx.setPriority(Integer.MAX_VALUE);
        this.aQs.registerListener(this.esx);
    }

    public void gT(boolean z) {
        if (this.esu != null) {
            this.esu.gT(z);
        }
    }

    public void gU(boolean z) {
        if (this.esv != null) {
            this.esv.gU(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aEz()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aEy()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void j(ChatMessage chatMessage) {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.mListView.getAdapter().notifyDataSetInvalidated();
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
        if (this.esx != null) {
            MessageManager.getInstance().unRegisterListener(this.esx);
            this.esx = null;
        }
    }
}
