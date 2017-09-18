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
    private TbPageContext<MsglistActivity<?>> aby;
    private MsgLeftViewItemAdapter drr;
    private MsgRightViewItemAdapter drs;
    private MsgMidViewItemAdapter drt;
    private CustomMessageListener dru;
    private List<e> mAdapters;
    private List<ChatMessage> mData;
    private BdTypeListView mListView;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.mAdapters = new ArrayList();
        this.dru = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.dqI != null && aVar.context != null) {
                        h.this.mAdapters.addAll(aVar.dqI);
                        h.this.mListView.addAdapters(new ArrayList(h.this.mAdapters));
                    }
                }
            }
        };
        this.aby = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.drr.mo(i);
        this.drs.mo(i);
    }

    private void initAdapters() {
        this.drr = new MsgLeftViewItemAdapter(this.aby, ChatMessage.TYPE_MSG_LEFT);
        this.drr.gf(true);
        this.drr.ge(true);
        this.drs = new MsgRightViewItemAdapter(this.aby, ChatMessage.TYPE_MSG_RIGHT);
        this.drs.gf(true);
        this.drs.ge(true);
        this.drt = new MsgMidViewItemAdapter(this.aby, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.drr);
        this.mAdapters.add(this.drs);
        this.mAdapters.add(this.drt);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.dqI = new ArrayList();
        aVar.context = this.aby;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.dru.setPriority(Integer.MAX_VALUE);
        this.aby.registerListener(this.dru);
    }

    public void gg(boolean z) {
        if (this.drr != null) {
            this.drr.gg(z);
        }
    }

    public void gh(boolean z) {
        if (this.drs != null) {
            this.drs.gh(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aun()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(b bVar) {
        for (e eVar : this.mAdapters) {
            if (eVar.aum()) {
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
        if (this.dru != null) {
            MessageManager.getInstance().unRegisterListener(this.dru);
            this.dru = null;
        }
    }
}
