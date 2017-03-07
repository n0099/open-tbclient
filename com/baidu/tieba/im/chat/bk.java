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
    private List<ChatMessage> aVq;
    private TbPageContext<MsglistActivity<?>> aaI;
    private MsgLeftViewItemAdapter cPK;
    private MsgRightViewItemAdapter cPL;
    private MsgMidViewItemAdapter cPM;
    private CustomMessageListener cPN;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aVq = null;
        this.mAdapters = new ArrayList();
        this.cPN = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aaI = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cPK.lc(i);
        this.cPL.lc(i);
    }

    private void initAdapters() {
        this.cPK = new MsgLeftViewItemAdapter(this.aaI, ChatMessage.TYPE_MSG_LEFT);
        this.cPK.fp(true);
        this.cPK.fo(true);
        this.cPL = new MsgRightViewItemAdapter(this.aaI, ChatMessage.TYPE_MSG_RIGHT);
        this.cPL.fp(true);
        this.cPL.fo(true);
        this.cPM = new MsgMidViewItemAdapter(this.aaI, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cPK);
        this.mAdapters.add(this.cPL);
        this.mAdapters.add(this.cPM);
        MV();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cPb = new ArrayList();
        aVar.context = this.aaI;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void MV() {
        this.cPN.setPriority(Integer.MAX_VALUE);
        this.aaI.registerListener(this.cPN);
    }

    public void fq(boolean z) {
        if (this.cPK != null) {
            this.cPK.fq(z);
        }
    }

    public void fr(boolean z) {
        if (this.cPL != null) {
            this.cPL.fr(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.anB()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.anA()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aVq;
    }

    public void e(ChatMessage chatMessage) {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.mListView.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.mListView.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aVq = list;
        ArrayList arrayList = new ArrayList();
        if (this.aVq != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aVq);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cPN != null) {
            MessageManager.getInstance().unRegisterListener(this.cPN);
            this.cPN = null;
        }
    }
}
