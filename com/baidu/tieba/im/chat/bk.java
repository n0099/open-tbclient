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
public class bk {
    private TbPageContext<MsglistActivity<?>> MX;
    private List<ChatMessage> aLU;
    private MsgLeftViewItemAdapter bZP;
    private MsgRightViewItemAdapter bZQ;
    private MsgMidViewItemAdapter bZR;
    private CustomMessageListener bZS;
    private List<ap> bcG;
    private BdTypeListView bcd;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aLU = null;
        this.bcG = new ArrayList();
        this.bZS = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.MX = tbPageContext;
        this.bcd = bdTypeListView;
        acs();
        this.bZP.jl(i);
        this.bZQ.jl(i);
    }

    private void acs() {
        this.bZP = new MsgLeftViewItemAdapter(this.MX, ChatMessage.TYPE_MSG_LEFT);
        this.bZP.dC(true);
        this.bZP.dB(true);
        this.bZQ = new MsgRightViewItemAdapter(this.MX, ChatMessage.TYPE_MSG_RIGHT);
        this.bZQ.dC(true);
        this.bZQ.dB(true);
        this.bZR = new MsgMidViewItemAdapter(this.MX, ChatMessage.TYPE_MSG_MID);
        this.bcG.add(this.bZP);
        this.bcG.add(this.bZQ);
        this.bcG.add(this.bZR);
        pf();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bZg = new ArrayList();
        aVar.context = this.MX;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void pf() {
        this.bZS.setPriority(Integer.MAX_VALUE);
        this.MX.registerListener(this.bZS);
    }

    public void dD(boolean z) {
        if (this.bZP != null) {
            this.bZP.dD(z);
        }
    }

    public void dE(boolean z) {
        if (this.bZQ != null) {
            this.bZQ.dE(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bcG) {
            if (apVar.acp()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bcG) {
            if (apVar.aco()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aLU;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bcd.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bcd.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aLU = list;
        ArrayList arrayList = new ArrayList();
        if (this.aLU != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aLU);
        }
        this.bcd.setData(arrayList);
    }

    public void onDestory() {
        if (this.bZS != null) {
            MessageManager.getInstance().unRegisterListener(this.bZS);
            this.bZS = null;
        }
    }
}
