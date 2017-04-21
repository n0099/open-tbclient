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
    private List<ChatMessage> aVF;
    private TbPageContext<MsglistActivity<?>> aaY;
    private MsgMidViewItemAdapter cQA;
    private CustomMessageListener cQB;
    private MsgLeftViewItemAdapter cQy;
    private MsgRightViewItemAdapter cQz;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aVF = null;
        this.mAdapters = new ArrayList();
        this.cQB = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aaY = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cQy.lj(i);
        this.cQz.lj(i);
    }

    private void initAdapters() {
        this.cQy = new MsgLeftViewItemAdapter(this.aaY, ChatMessage.TYPE_MSG_LEFT);
        this.cQy.fz(true);
        this.cQy.fy(true);
        this.cQz = new MsgRightViewItemAdapter(this.aaY, ChatMessage.TYPE_MSG_RIGHT);
        this.cQz.fz(true);
        this.cQz.fy(true);
        this.cQA = new MsgMidViewItemAdapter(this.aaY, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cQy);
        this.mAdapters.add(this.cQz);
        this.mAdapters.add(this.cQA);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cPP = new ArrayList();
        aVar.context = this.aaY;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.cQB.setPriority(Integer.MAX_VALUE);
        this.aaY.registerListener(this.cQB);
    }

    public void fA(boolean z) {
        if (this.cQy != null) {
            this.cQy.fA(z);
        }
    }

    public void fB(boolean z) {
        if (this.cQz != null) {
            this.cQz.fB(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.aow()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.aov()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aVF;
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
        this.aVF = list;
        ArrayList arrayList = new ArrayList();
        if (this.aVF != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aVF);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cQB != null) {
            MessageManager.getInstance().unRegisterListener(this.cQB);
            this.cQB = null;
        }
    }
}
