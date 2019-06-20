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
    private MsgLeftViewItemAdapter gtq;
    private MsgRightViewItemAdapter gtr;
    private MsgMidViewItemAdapter gts;
    private CustomMessageListener gtt;
    private List<e> mAdapters;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.gtt = new CustomMessageListener(2001275) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gsH != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.gsH);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.mContext = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.gtq.uC(i);
        this.gtr.uC(i);
    }

    private void initAdapters() {
        this.gtq = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.gtq.lw(true);
        this.gtq.lv(true);
        this.gtr = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.gtr.lw(true);
        this.gtr.lv(true);
        this.gts = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.gtq);
        this.mAdapters.add(this.gtr);
        this.mAdapters.add(this.gts);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.gsH = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.gtt.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.mContext.registerListener(this.gtt);
    }

    public void lx(boolean z) {
        if (this.gtq != null) {
            this.gtq.lx(z);
        }
    }

    public void ly(boolean z) {
        if (this.gtr != null) {
            this.gtr.ly(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.bxS()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.bxR()) {
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
        if (this.gtt != null) {
            MessageManager.getInstance().unRegisterListener(this.gtt);
            this.gtt = null;
        }
    }
}
