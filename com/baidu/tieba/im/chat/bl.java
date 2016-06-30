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
    private TbPageContext<MsglistActivity<?>> Dp;
    private List<ChatMessage> aLB;
    private List<ap> bAz;
    private BdTypeListView bou;
    private MsgLeftViewItemAdapter cFE;
    private MsgRightViewItemAdapter cFF;
    private MsgMidViewItemAdapter cFG;
    private CustomMessageListener cFH;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aLB = null;
        this.bAz = new ArrayList();
        this.cFH = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Dp = tbPageContext;
        this.bou = bdTypeListView;
        akG();
        this.cFE.kq(i);
        this.cFF.kq(i);
    }

    private void akG() {
        this.cFE = new MsgLeftViewItemAdapter(this.Dp, ChatMessage.TYPE_MSG_LEFT);
        this.cFE.eR(true);
        this.cFE.eQ(true);
        this.cFF = new MsgRightViewItemAdapter(this.Dp, ChatMessage.TYPE_MSG_RIGHT);
        this.cFF.eR(true);
        this.cFF.eQ(true);
        this.cFG = new MsgMidViewItemAdapter(this.Dp, ChatMessage.TYPE_MSG_MID);
        this.bAz.add(this.cFE);
        this.bAz.add(this.cFF);
        this.bAz.add(this.cFG);
        Pk();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cEV = new ArrayList();
        aVar.context = this.Dp;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void Pk() {
        this.cFH.setPriority(Integer.MAX_VALUE);
        this.Dp.registerListener(this.cFH);
    }

    public void eS(boolean z) {
        if (this.cFE != null) {
            this.cFE.eS(z);
        }
    }

    public void eT(boolean z) {
        if (this.cFF != null) {
            this.cFF.eT(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bAz) {
            if (apVar.akD()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bAz) {
            if (apVar.akC()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aLB;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bou.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bou.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aLB = list;
        ArrayList arrayList = new ArrayList();
        if (this.aLB != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aLB);
        }
        this.bou.setData(arrayList);
    }

    public void onDestory() {
        if (this.cFH != null) {
            MessageManager.getInstance().unRegisterListener(this.cFH);
            this.cFH = null;
        }
    }
}
