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
    private TbPageContext<MsglistActivity<?>> Gf;
    private BdTypeListView aML;
    private List<ChatMessage> aUV;
    private List<ap> bRh;
    private MsgLeftViewItemAdapter dbd;
    private MsgRightViewItemAdapter dbe;
    private MsgMidViewItemAdapter dbf;
    private CustomMessageListener dbg;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aUV = null;
        this.bRh = new ArrayList();
        this.dbg = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Gf = tbPageContext;
        this.aML = bdTypeListView;
        asB();
        this.dbd.lp(i);
        this.dbe.lp(i);
    }

    private void asB() {
        this.dbd = new MsgLeftViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_LEFT);
        this.dbd.fL(true);
        this.dbd.fK(true);
        this.dbe = new MsgRightViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_RIGHT);
        this.dbe.fL(true);
        this.dbe.fK(true);
        this.dbf = new MsgMidViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_MID);
        this.bRh.add(this.dbd);
        this.bRh.add(this.dbe);
        this.bRh.add(this.dbf);
        VV();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.das = new ArrayList();
        aVar.context = this.Gf;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void VV() {
        this.dbg.setPriority(Integer.MAX_VALUE);
        this.Gf.registerListener(this.dbg);
    }

    public void fM(boolean z) {
        if (this.dbd != null) {
            this.dbd.fM(z);
        }
    }

    public void fN(boolean z) {
        if (this.dbe != null) {
            this.dbe.fN(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bRh) {
            if (apVar.asy()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bRh) {
            if (apVar.asx()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aUV;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aML.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aML.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aUV = list;
        ArrayList arrayList = new ArrayList();
        if (this.aUV != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aUV);
        }
        this.aML.setData(arrayList);
    }

    public void onDestory() {
        if (this.dbg != null) {
            MessageManager.getInstance().unRegisterListener(this.dbg);
            this.dbg = null;
        }
    }
}
