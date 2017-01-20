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
    private TbPageContext<MsglistActivity<?>> Fp;
    private List<ChatMessage> aPE;
    private MsgLeftViewItemAdapter cNv;
    private MsgRightViewItemAdapter cNw;
    private MsgMidViewItemAdapter cNx;
    private CustomMessageListener cNy;
    private List<ao> mAdapters;
    private BdTypeListView mListView;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aPE = null;
        this.mAdapters = new ArrayList();
        this.cNy = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.Fp = tbPageContext;
        this.mListView = bdTypeListView;
        initAdapters();
        this.cNv.lm(i);
        this.cNw.lm(i);
    }

    private void initAdapters() {
        this.cNv = new MsgLeftViewItemAdapter(this.Fp, ChatMessage.TYPE_MSG_LEFT);
        this.cNv.fz(true);
        this.cNv.fy(true);
        this.cNw = new MsgRightViewItemAdapter(this.Fp, ChatMessage.TYPE_MSG_RIGHT);
        this.cNw.fz(true);
        this.cNw.fy(true);
        this.cNx = new MsgMidViewItemAdapter(this.Fp, ChatMessage.TYPE_MSG_MID);
        this.mAdapters.add(this.cNv);
        this.mAdapters.add(this.cNw);
        this.mAdapters.add(this.cNx);
        Mj();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.cMM = new ArrayList();
        aVar.context = this.Fp;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void Mj() {
        this.cNy.setPriority(Integer.MAX_VALUE);
        this.Fp.registerListener(this.cNy);
    }

    public void fA(boolean z) {
        if (this.cNv != null) {
            this.cNv.fA(z);
        }
    }

    public void fB(boolean z) {
        if (this.cNw != null) {
            this.cNw.fB(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.aoh()) {
                aoVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ao aoVar : this.mAdapters) {
            if (aoVar.aog()) {
                aoVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aPE;
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
        this.aPE = list;
        ArrayList arrayList = new ArrayList();
        if (this.aPE != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aPE);
        }
        this.mListView.setData(arrayList);
    }

    public void onDestory() {
        if (this.cNy != null) {
            MessageManager.getInstance().unRegisterListener(this.cNy);
            this.cNy = null;
        }
    }
}
