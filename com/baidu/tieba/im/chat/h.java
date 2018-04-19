package com.baidu.tieba.im.chat;

import android.support.v7.widget.ActivityChooserView;
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
    private TbPageContext<MsglistActivity<?>> adf;
    private MsgLeftViewItemAdapter dRo;
    private MsgRightViewItemAdapter dRp;
    private MsgMidViewItemAdapter dRq;
    private CustomMessageListener dRr;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.dRr = new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.dQF != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.dQF);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.adf = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.dRo.ng(i);
        this.dRp.ng(i);
    }

    private void initAdapters() {
        this.dRo = new MsgLeftViewItemAdapter(this.adf, ChatMessage.TYPE_MSG_LEFT);
        this.dRo.gH(true);
        this.dRo.gG(true);
        this.dRp = new MsgRightViewItemAdapter(this.adf, ChatMessage.TYPE_MSG_RIGHT);
        this.dRp.gH(true);
        this.dRp.gG(true);
        this.dRq = new MsgMidViewItemAdapter(this.adf, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.dRo);
        this.mAdapters.add(this.dRp);
        this.mAdapters.add(this.dRq);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.dQF = new ArrayList();
        aVar.context = this.adf;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.dRr.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.adf.registerListener(this.dRr);
    }

    public void gI(boolean z) {
        if (this.dRo != null) {
            this.dRo.gI(z);
        }
    }

    public void gJ(boolean z) {
        if (this.dRp != null) {
            this.dRp.gJ(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aAT()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aAS()) {
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
        if (this.dRr != null) {
            MessageManager.getInstance().unRegisterListener(this.dRr);
            this.dRr = null;
        }
    }
}
