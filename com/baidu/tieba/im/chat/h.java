package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private List<e> asE;
    private TbPageContext<MsglistActivity<?>> cVh;
    private BdTypeListView ekb;
    private MsgLeftViewItemAdapter htc;
    private MsgRightViewItemAdapter htd;
    private MsgMidViewItemAdapter hte;
    private CustomMessageListener htf;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.asE = new ArrayList();
        this.htf = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hsv != null && aVar.context != null) {
                        h.this.asE.addAll(aVar.hsv);
                        h.this.ekb.addAdapters(new ArrayList(h.this.asE));
                    }
                }
            }
        };
        this.cVh = tbPageContext;
        this.ekb = bdTypeListView;
        wM();
        this.htc.wa(i);
        this.htd.wa(i);
    }

    private void wM() {
        this.htc = new MsgLeftViewItemAdapter(this.cVh, ChatMessage.TYPE_MSG_LEFT);
        this.htc.nd(true);
        this.htc.nc(true);
        this.htd = new MsgRightViewItemAdapter(this.cVh, ChatMessage.TYPE_MSG_RIGHT);
        this.htd.nd(true);
        this.htd.nc(true);
        this.hte = new MsgMidViewItemAdapter(this.cVh, ChatMessage.TYPE_MSG_MID);
        this.asE.add(this.htc);
        this.asE.add(this.htd);
        this.asE.add(this.hte);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.hsv = new ArrayList();
        aVar.context = this.cVh;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.htf.setPriority(Integer.MAX_VALUE);
        this.cVh.registerListener(this.htf);
    }

    public void ne(boolean z) {
        if (this.htc != null) {
            this.htc.ne(z);
        }
    }

    public void nf(boolean z) {
        if (this.htd != null) {
            this.htd.nf(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.asE) {
            if (eVar.bSl()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.asE) {
            if (eVar.bSk()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.ekb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekb.getAdapter().notifyDataSetInvalidated();
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
        this.ekb.setData(arrayList);
    }

    public void onDestory() {
        if (this.htf != null) {
            MessageManager.getInstance().unRegisterListener(this.htf);
            this.htf = null;
        }
    }
}
