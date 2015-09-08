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
public class bi {
    private BdTypeListView aVN;
    private List<ap> aWg;
    private MsgLeftViewItemAdapter bph;
    private MsgRightViewItemAdapter bpi;
    private MsgMidViewItemAdapter bpj;
    private CustomMessageListener bpk;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bi(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bi(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aWg = new ArrayList();
        this.bpk = new bj(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aVN = bdTypeListView;
        Rk();
        this.bph.gC(i);
        this.bpi.gC(i);
    }

    private void Rk() {
        this.bph = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bph.cJ(true);
        this.bph.cI(true);
        this.bpi = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bpi.cJ(true);
        this.bpi.cI(true);
        this.bpj = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aWg.add(this.bph);
        this.aWg.add(this.bpi);
        this.aWg.add(this.bpj);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.boz = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bpk.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bpk);
    }

    public void cK(boolean z) {
        if (this.bph != null) {
            this.bph.cK(z);
        }
    }

    public void cL(boolean z) {
        if (this.bpi != null) {
            this.bpi.cL(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ap apVar : this.aWg) {
            if (apVar.Rh()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ap apVar : this.aWg) {
            if (apVar.Rg()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVN.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVN.getAdapter()).notifyDataSetInvalidated();
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
        this.aVN.setData(arrayList);
    }

    public void gC(int i) {
        if (this.bph != null) {
            this.bph.gC(i);
        }
        if (this.bpi != null) {
            this.bpi.gC(i);
        }
    }

    public void onDestory() {
        if (this.bpk != null) {
            MessageManager.getInstance().unRegisterListener(this.bpk);
            this.bpk = null;
        }
    }
}
