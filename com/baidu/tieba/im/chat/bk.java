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
    private List<ap> aRI;
    private BdTypeListView aRs;
    private MsgLeftViewItemAdapter bIc;
    private MsgRightViewItemAdapter bId;
    private MsgMidViewItemAdapter bIe;
    private CustomMessageListener bIf;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aRI = new ArrayList();
        this.bIf = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aRs = bdTypeListView;
        Vp();
        this.bIc.hH(i);
        this.bId.hH(i);
    }

    private void Vp() {
        this.bIc = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bIc.dg(true);
        this.bIc.df(true);
        this.bId = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bId.dg(true);
        this.bId.df(true);
        this.bIe = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aRI.add(this.bIc);
        this.aRI.add(this.bId);
        this.aRI.add(this.bIe);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bHt = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bIf.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bIf);
    }

    public void dh(boolean z) {
        if (this.bIc != null) {
            this.bIc.dh(z);
        }
    }

    public void di(boolean z) {
        if (this.bId != null) {
            this.bId.di(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.aRI) {
            if (apVar.Vm()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.aRI) {
            if (apVar.Vl()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aRs.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aRs.getAdapter()).notifyDataSetInvalidated();
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
        this.aRs.setData(arrayList);
    }

    public void hH(int i) {
        if (this.bIc != null) {
            this.bIc.hH(i);
        }
        if (this.bId != null) {
            this.bId.hH(i);
        }
    }

    public void onDestory() {
        if (this.bIf != null) {
            MessageManager.getInstance().unRegisterListener(this.bIf);
            this.bIf = null;
        }
    }
}
