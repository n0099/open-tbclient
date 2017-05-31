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
    private List<ChatMessage> aTD;
    private TbPageContext<MsglistActivity<?>> aas;
    private MsgLeftViewItemAdapter cPY;
    private MsgRightViewItemAdapter cPZ;
    private MsgMidViewItemAdapter cQa;
    private CustomMessageListener cQb;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aTD = null;
        this.mAdapters = new ArrayList();
        this.cQb = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aas = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cPY.lq(i);
        this.cPZ.lq(i);
    }

    private void initAdapters() {
        this.cPY = new MsgLeftViewItemAdapter(this.aas, ChatMessage.TYPE_MSG_LEFT);
        this.cPY.fo(true);
        this.cPY.fn(true);
        this.cPZ = new MsgRightViewItemAdapter(this.aas, ChatMessage.TYPE_MSG_RIGHT);
        this.cPZ.fo(true);
        this.cPZ.fn(true);
        this.cQa = new MsgMidViewItemAdapter(this.aas, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cPY);
        this.mAdapters.add(this.cPZ);
        this.mAdapters.add(this.cQa);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cPq = new ArrayList();
        aVar.context = this.aas;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.cQb.setPriority(Integer.MAX_VALUE);
        this.aas.registerListener(this.cQb);
    }

    public void fp(boolean z) {
        if (this.cPY != null) {
            this.cPY.fp(z);
        }
    }

    public void fq(boolean z) {
        if (this.cPZ != null) {
            this.cPZ.fq(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.amp()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.amo()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aTD;
    }

    public void g(ChatMessage chatMessage) {
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
        this.aTD = list;
        ArrayList arrayList = new ArrayList();
        if (this.aTD != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aTD);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cQb != null) {
            MessageManager.getInstance().unRegisterListener(this.cQb);
            this.cQb = null;
        }
    }
}
