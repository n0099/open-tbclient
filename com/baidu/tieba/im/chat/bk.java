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
    private List<ChatMessage> aUW;
    private TbPageContext<MsglistActivity<?>> aat;
    private MsgLeftViewItemAdapter cXU;
    private MsgRightViewItemAdapter cXV;
    private MsgMidViewItemAdapter cXW;
    private CustomMessageListener cXX;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aUW = null;
        this.mAdapters = new ArrayList();
        this.cXX = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aat = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cXU.lB(i);
        this.cXV.lB(i);
    }

    private void initAdapters() {
        this.cXU = new MsgLeftViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_LEFT);
        this.cXU.fF(true);
        this.cXU.fE(true);
        this.cXV = new MsgRightViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_RIGHT);
        this.cXV.fF(true);
        this.cXV.fE(true);
        this.cXW = new MsgMidViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cXU);
        this.mAdapters.add(this.cXV);
        this.mAdapters.add(this.cXW);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cXm = new ArrayList();
        aVar.context = this.aat;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.cXX.setPriority(Integer.MAX_VALUE);
        this.aat.registerListener(this.cXX);
    }

    public void fG(boolean z) {
        if (this.cXU != null) {
            this.cXU.fG(z);
        }
    }

    public void fH(boolean z) {
        if (this.cXV != null) {
            this.cXV.fH(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.aqa()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.apZ()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aUW;
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
        this.aUW = list;
        ArrayList arrayList = new ArrayList();
        if (this.aUW != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aUW);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cXX != null) {
            MessageManager.getInstance().unRegisterListener(this.cXX);
            this.cXX = null;
        }
    }
}
