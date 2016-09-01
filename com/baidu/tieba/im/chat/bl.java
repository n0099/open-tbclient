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
    private List<ChatMessage> aRP;
    private BdTypeListView bBT;
    private List<ap> bOr;
    private MsgLeftViewItemAdapter cTY;
    private MsgRightViewItemAdapter cTZ;
    private MsgMidViewItemAdapter cUa;
    private CustomMessageListener cUb;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aRP = null;
        this.bOr = new ArrayList();
        this.cUb = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Gd = tbPageContext;
        this.bBT = bdTypeListView;
        aqf();
        this.cTY.kZ(i);
        this.cTZ.kZ(i);
    }

    private void aqf() {
        this.cTY = new MsgLeftViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_LEFT);
        this.cTY.fo(true);
        this.cTY.fn(true);
        this.cTZ = new MsgRightViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_RIGHT);
        this.cTZ.fo(true);
        this.cTZ.fn(true);
        this.cUa = new MsgMidViewItemAdapter(this.Gd, ChatMessage.TYPE_MSG_MID);
        this.bOr.add(this.cTY);
        this.bOr.add(this.cTZ);
        this.bOr.add(this.cUa);
        UA();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cTq = new ArrayList();
        aVar.context = this.Gd;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void UA() {
        this.cUb.setPriority(Integer.MAX_VALUE);
        this.Gd.registerListener(this.cUb);
    }

    public void fp(boolean z) {
        if (this.cTY != null) {
            this.cTY.fp(z);
        }
    }

    public void fq(boolean z) {
        if (this.cTZ != null) {
            this.cTZ.fq(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bOr) {
            if (apVar.aqc()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bOr) {
            if (apVar.aqb()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aRP;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bBT.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bBT.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aRP = list;
        ArrayList arrayList = new ArrayList();
        if (this.aRP != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aRP);
        }
        this.bBT.setData(arrayList);
    }

    public void onDestory() {
        if (this.cUb != null) {
            MessageManager.getInstance().unRegisterListener(this.cUb);
            this.cUb = null;
        }
    }
}
