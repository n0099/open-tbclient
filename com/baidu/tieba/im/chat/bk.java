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
    private TbPageContext<MsglistActivity<?>> Do;
    private List<ChatMessage> aIe;
    private List<ap> bei;
    private BdTypeListView bej;
    private MsgLeftViewItemAdapter cau;
    private MsgRightViewItemAdapter cav;
    private MsgMidViewItemAdapter caw;
    private CustomMessageListener cax;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aIe = null;
        this.bei = new ArrayList();
        this.cax = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Do = tbPageContext;
        this.bej = bdTypeListView;
        acs();
        this.cau.iP(i);
        this.cav.iP(i);
    }

    private void acs() {
        this.cau = new MsgLeftViewItemAdapter(this.Do, ChatMessage.TYPE_MSG_LEFT);
        this.cau.ed(true);
        this.cau.ec(true);
        this.cav = new MsgRightViewItemAdapter(this.Do, ChatMessage.TYPE_MSG_RIGHT);
        this.cav.ed(true);
        this.cav.ec(true);
        this.caw = new MsgMidViewItemAdapter(this.Do, ChatMessage.TYPE_MSG_MID);
        this.bei.add(this.cau);
        this.bei.add(this.cav);
        this.bei.add(this.caw);
        lr();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bZL = new ArrayList();
        aVar.context = this.Do;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void lr() {
        this.cax.setPriority(Integer.MAX_VALUE);
        this.Do.registerListener(this.cax);
    }

    public void ee(boolean z) {
        if (this.cau != null) {
            this.cau.ee(z);
        }
    }

    public void ef(boolean z) {
        if (this.cav != null) {
            this.cav.ef(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.bei) {
            if (apVar.acp()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.bei) {
            if (apVar.aco()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aIe;
    }

    public void e(ChatMessage chatMessage) {
        if (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.bej.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.bej.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aIe = list;
        ArrayList arrayList = new ArrayList();
        if (this.aIe != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aIe);
        }
        this.bej.setData(arrayList);
    }

    public void onDestory() {
        if (this.cax != null) {
            MessageManager.getInstance().unRegisterListener(this.cax);
            this.cax = null;
        }
    }
}
