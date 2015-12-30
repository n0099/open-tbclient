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
    private List<ap> aVK;
    private BdTypeListView aVi;
    private MsgLeftViewItemAdapter bLJ;
    private MsgRightViewItemAdapter bLK;
    private MsgMidViewItemAdapter bLL;
    private CustomMessageListener bLM;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aVK = new ArrayList();
        this.bLM = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aVi = bdTypeListView;
        Wv();
        this.bLJ.ih(i);
        this.bLK.ih(i);
    }

    private void Wv() {
        this.bLJ = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bLJ.dg(true);
        this.bLJ.df(true);
        this.bLK = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bLK.dg(true);
        this.bLK.df(true);
        this.bLL = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aVK.add(this.bLJ);
        this.aVK.add(this.bLK);
        this.aVK.add(this.bLL);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bLa = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bLM.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bLM);
    }

    public void dh(boolean z) {
        if (this.bLJ != null) {
            this.bLJ.dh(z);
        }
    }

    public void di(boolean z) {
        if (this.bLK != null) {
            this.bLK.di(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.aVK) {
            if (apVar.Ws()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.aVK) {
            if (apVar.Wr()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVi.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVi.getAdapter()).notifyDataSetInvalidated();
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
        this.aVi.setData(arrayList);
    }

    public void ih(int i) {
        if (this.bLJ != null) {
            this.bLJ.ih(i);
        }
        if (this.bLK != null) {
            this.bLK.ih(i);
        }
    }

    public void onDestory() {
        if (this.bLM != null) {
            MessageManager.getInstance().unRegisterListener(this.bLM);
            this.bLM = null;
        }
    }
}
