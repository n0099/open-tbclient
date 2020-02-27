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
    private TbPageContext<MsglistActivity<?>> cVg;
    private BdTypeListView eka;
    private MsgLeftViewItemAdapter hta;
    private MsgRightViewItemAdapter htb;
    private MsgMidViewItemAdapter htc;
    private CustomMessageListener htd;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.asE = new ArrayList();
        this.htd = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hst != null && aVar.context != null) {
                        h.this.asE.addAll(aVar.hst);
                        h.this.eka.addAdapters(new ArrayList(h.this.asE));
                    }
                }
            }
        };
        this.cVg = tbPageContext;
        this.eka = bdTypeListView;
        wM();
        this.hta.wa(i);
        this.htb.wa(i);
    }

    private void wM() {
        this.hta = new MsgLeftViewItemAdapter(this.cVg, ChatMessage.TYPE_MSG_LEFT);
        this.hta.nd(true);
        this.hta.nc(true);
        this.htb = new MsgRightViewItemAdapter(this.cVg, ChatMessage.TYPE_MSG_RIGHT);
        this.htb.nd(true);
        this.htb.nc(true);
        this.htc = new MsgMidViewItemAdapter(this.cVg, ChatMessage.TYPE_MSG_MID);
        this.asE.add(this.hta);
        this.asE.add(this.htb);
        this.asE.add(this.htc);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.hst = new ArrayList();
        aVar.context = this.cVg;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.htd.setPriority(Integer.MAX_VALUE);
        this.cVg.registerListener(this.htd);
    }

    public void ne(boolean z) {
        if (this.hta != null) {
            this.hta.ne(z);
        }
    }

    public void nf(boolean z) {
        if (this.htb != null) {
            this.htb.nf(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.asE) {
            if (eVar.bSj()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.asE) {
            if (eVar.bSi()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eka.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eka.getAdapter().notifyDataSetInvalidated();
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
        this.eka.setData(arrayList);
    }

    public void onDestory() {
        if (this.htd != null) {
            MessageManager.getInstance().unRegisterListener(this.htd);
            this.htd = null;
        }
    }
}
