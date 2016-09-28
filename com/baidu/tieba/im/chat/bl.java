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
    private TbPageContext<MsglistActivity<?>> Gd;
    private List<ChatMessage> aSU;
    private BdTypeListView bCe;
    private List<ap> bOo;
    private MsgLeftViewItemAdapter cVs;
    private MsgRightViewItemAdapter cVt;
    private MsgMidViewItemAdapter cVu;
    private CustomMessageListener cVv;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aSU = null;
        this.bOo = new ArrayList();
        this.cVv = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Gd = tbPageContext;
        this.bCe = bdTypeListView;
        aqE();
        this.cVs.lh(i);
        this.cVt.lh(i);
    }

    private void aqE() {
        this.cVs = new MsgLeftViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_LEFT);
        this.cVs.fr(true);
        this.cVs.fq(true);
        this.cVt = new MsgRightViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_RIGHT);
        this.cVt.fr(true);
        this.cVt.fq(true);
        this.cVu = new MsgMidViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_MID);
        this.bOo.add(this.cVs);
        this.bOo.add(this.cVt);
        this.bOo.add(this.cVu);
        UT();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cUK = new ArrayList();
        aVar.context = this.Gd;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void UT() {
        this.cVv.setPriority(Integer.MAX_VALUE);
        this.Gd.registerListener(this.cVv);
    }

    public void fs(boolean z) {
        if (this.cVs != null) {
            this.cVs.fs(z);
        }
    }

    public void ft(boolean z) {
        if (this.cVt != null) {
            this.cVt.ft(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bOo) {
            if (apVar.aqB()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bOo) {
            if (apVar.aqA()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aSU;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bCe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bCe.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aSU = list;
        ArrayList arrayList = new ArrayList();
        if (this.aSU != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aSU);
        }
        this.bCe.setData(arrayList);
    }

    public void onDestory() {
        if (this.cVv != null) {
            MessageManager.getInstance().unRegisterListener(this.cVv);
            this.cVv = null;
        }
    }
}
