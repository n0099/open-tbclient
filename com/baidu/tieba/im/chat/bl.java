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
    private BdTypeListView aMc;
    private List<ChatMessage> aUm;
    private List<ap> bbV;
    private MsgLeftViewItemAdapter cGn;
    private MsgRightViewItemAdapter cGo;
    private MsgMidViewItemAdapter cGp;
    private CustomMessageListener cGq;

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bl(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aUm = null;
        this.bbV = new ArrayList();
        this.cGq = new bm(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Gf = tbPageContext;
        this.aMc = bdTypeListView;
        Ou();
        this.cGn.kz(i);
        this.cGo.kz(i);
    }

    private void Ou() {
        this.cGn = new MsgLeftViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_LEFT);
        this.cGn.fw(true);
        this.cGn.fv(true);
        this.cGo = new MsgRightViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_RIGHT);
        this.cGo.fw(true);
        this.cGo.fv(true);
        this.cGp = new MsgMidViewItemAdapter(this.Gf, ChatMessage.TYPE_MSG_MID);
        this.bbV.add(this.cGn);
        this.bbV.add(this.cGo);
        this.bbV.add(this.cGp);
        Tc();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cFE = new ArrayList();
        aVar.context = this.Gf;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void Tc() {
        this.cGq.setPriority(Integer.MAX_VALUE);
        this.Gf.registerListener(this.cGq);
    }

    public void fx(boolean z) {
        if (this.cGn != null) {
            this.cGn.fx(z);
        }
    }

    public void fy(boolean z) {
        if (this.cGo != null) {
            this.cGo.fy(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bbV) {
            if (apVar.amZ()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bbV) {
            if (apVar.amY()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aUm;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aMc.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aMc.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aUm = list;
        ArrayList arrayList = new ArrayList();
        if (this.aUm != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aUm);
        }
        this.aMc.setData(arrayList);
    }

    public void onDestory() {
        if (this.cGq != null) {
            MessageManager.getInstance().unRegisterListener(this.cGq);
            this.cGq = null;
        }
    }
}
