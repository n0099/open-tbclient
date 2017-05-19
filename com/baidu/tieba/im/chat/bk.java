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
    private List<ChatMessage> aWb;
    private TbPageContext<MsglistActivity<?>> aat;
    private MsgLeftViewItemAdapter cKA;
    private MsgRightViewItemAdapter cKB;
    private MsgMidViewItemAdapter cKC;
    private CustomMessageListener cKD;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aWb = null;
        this.mAdapters = new ArrayList();
        this.cKD = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aat = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cKA.kW(i);
        this.cKB.kW(i);
    }

    private void initAdapters() {
        this.cKA = new MsgLeftViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_LEFT);
        this.cKA.fa(true);
        this.cKA.eZ(true);
        this.cKB = new MsgRightViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_RIGHT);
        this.cKB.fa(true);
        this.cKB.eZ(true);
        this.cKC = new MsgMidViewItemAdapter(this.aat, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cKA);
        this.mAdapters.add(this.cKB);
        this.mAdapters.add(this.cKC);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cJS = new ArrayList();
        aVar.context = this.aat;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.cKD.setPriority(Integer.MAX_VALUE);
        this.aat.registerListener(this.cKD);
    }

    public void fb(boolean z) {
        if (this.cKA != null) {
            this.cKA.fb(z);
        }
    }

    public void fc(boolean z) {
        if (this.cKB != null) {
            this.cKB.fc(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.alp()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.alo()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aWb;
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
        this.aWb = list;
        ArrayList arrayList = new ArrayList();
        if (this.aWb != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aWb);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cKD != null) {
            MessageManager.getInstance().unRegisterListener(this.cKD);
            this.cKD = null;
        }
    }
}
