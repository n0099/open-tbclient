package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private TbPageContext<MsglistActivity<?>> aRR;
    private MsgLeftViewItemAdapter ewE;
    private MsgRightViewItemAdapter ewF;
    private MsgMidViewItemAdapter ewG;
    private CustomMessageListener ewH;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.ewH = new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.evV != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.evV);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.aRR = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.ewE.pH(i);
        this.ewF.pH(i);
    }

    private void initAdapters() {
        this.ewE = new MsgLeftViewItemAdapter(this.aRR, ChatMessage.TYPE_MSG_LEFT);
        this.ewE.hc(true);
        this.ewE.hb(true);
        this.ewF = new MsgRightViewItemAdapter(this.aRR, ChatMessage.TYPE_MSG_RIGHT);
        this.ewF.hc(true);
        this.ewF.hb(true);
        this.ewG = new MsgMidViewItemAdapter(this.aRR, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.ewE);
        this.mAdapters.add(this.ewF);
        this.mAdapters.add(this.ewG);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.evV = new ArrayList();
        aVar.context = this.aRR;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.ewH.setPriority(Integer.MAX_VALUE);
        this.aRR.registerListener(this.ewH);
    }

    public void hd(boolean z) {
        if (this.ewE != null) {
            this.ewE.hd(z);
        }
    }

    public void he(boolean z) {
        if (this.ewF != null) {
            this.ewF.he(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aFT()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aFS()) {
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
        if (this.ewH != null) {
            MessageManager.getInstance().unRegisterListener(this.ewH);
            this.ewH = null;
        }
    }
}
