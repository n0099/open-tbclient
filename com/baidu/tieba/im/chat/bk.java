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
    private List<ChatMessage> aVD;
    private TbPageContext<MsglistActivity<?>> aaX;
    private MsgLeftViewItemAdapter cOh;
    private MsgRightViewItemAdapter cOi;
    private MsgMidViewItemAdapter cOj;
    private CustomMessageListener cOk;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aVD = null;
        this.mAdapters = new ArrayList();
        this.cOk = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.aaX = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cOh.ld(i);
        this.cOi.ld(i);
    }

    private void initAdapters() {
        this.cOh = new MsgLeftViewItemAdapter(this.aaX, ChatMessage.TYPE_MSG_LEFT);
        this.cOh.fp(true);
        this.cOh.fo(true);
        this.cOi = new MsgRightViewItemAdapter(this.aaX, ChatMessage.TYPE_MSG_RIGHT);
        this.cOi.fp(true);
        this.cOi.fo(true);
        this.cOj = new MsgMidViewItemAdapter(this.aaX, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cOh);
        this.mAdapters.add(this.cOi);
        this.mAdapters.add(this.cOj);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cNy = new ArrayList();
        aVar.context = this.aaX;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.cOk.setPriority(Integer.MAX_VALUE);
        this.aaX.registerListener(this.cOk);
    }

    public void fq(boolean z) {
        if (this.cOh != null) {
            this.cOh.fq(z);
        }
    }

    public void fr(boolean z) {
        if (this.cOi != null) {
            this.cOi.fr(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.anv()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.anu()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aVD;
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
        this.aVD = list;
        ArrayList arrayList = new ArrayList();
        if (this.aVD != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aVD);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cOk != null) {
            MessageManager.getInstance().unRegisterListener(this.cOk);
            this.cOk = null;
        }
    }
}
