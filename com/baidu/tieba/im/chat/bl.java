package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class bl {
    private TbPageContext<MsglistActivity<?>> DQ;
    private List<ChatMessage> aMv;
    private List<ap> bCN;
    private BdTypeListView bqG;
    private MsgLeftViewItemAdapter cIt;
    private MsgRightViewItemAdapter cIu;
    private MsgMidViewItemAdapter cIv;
    private CustomMessageListener cIw;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aMv = null;
        this.bCN = new ArrayList();
        this.cIw = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.DQ = tbPageContext;
        this.bqG = bdTypeListView;
        alq();
        this.cIt.kw(i);
        this.cIu.kw(i);
    }

    private void alq() {
        this.cIt = new MsgLeftViewItemAdapter(this.DQ, ChatMessage.TYPE_MSG_LEFT);
        this.cIt.eS(true);
        this.cIt.eR(true);
        this.cIu = new MsgRightViewItemAdapter(this.DQ, ChatMessage.TYPE_MSG_RIGHT);
        this.cIu.eS(true);
        this.cIu.eR(true);
        this.cIv = new MsgMidViewItemAdapter(this.DQ, ChatMessage.TYPE_MSG_MID);
        this.bCN.add(this.cIt);
        this.bCN.add(this.cIu);
        this.bCN.add(this.cIv);
        PO();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cHK = new ArrayList();
        aVar.context = this.DQ;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void PO() {
        this.cIw.setPriority(Integer.MAX_VALUE);
        this.DQ.registerListener(this.cIw);
    }

    public void eT(boolean z) {
        if (this.cIt != null) {
            this.cIt.eT(z);
        }
    }

    public void eU(boolean z) {
        if (this.cIu != null) {
            this.cIu.eU(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bCN) {
            if (apVar.aln()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bCN) {
            if (apVar.alm()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aMv;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bqG.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bqG.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aMv = list;
        ArrayList arrayList = new ArrayList();
        if (this.aMv != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aMv);
        }
        this.bqG.setData(arrayList);
    }

    public void onDestory() {
        if (this.cIw != null) {
            MessageManager.getInstance().unRegisterListener(this.cIw);
            this.cIw = null;
        }
    }
}
