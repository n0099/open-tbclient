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
    private BdTypeListView aUV;
    private List<ap> aVr;
    private MsgLeftViewItemAdapter bsh;
    private MsgRightViewItemAdapter bsi;
    private MsgMidViewItemAdapter bsj;
    private CustomMessageListener bsk;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aVr = new ArrayList();
        this.bsk = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aUV = bdTypeListView;
        RR();
        this.bsh.gI(i);
        this.bsi.gI(i);
    }

    private void RR() {
        this.bsh = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bsh.cJ(true);
        this.bsh.cI(true);
        this.bsi = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bsi.cJ(true);
        this.bsi.cI(true);
        this.bsj = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aVr.add(this.bsh);
        this.aVr.add(this.bsi);
        this.aVr.add(this.bsj);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bry = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bsk.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bsk);
    }

    public void cK(boolean z) {
        if (this.bsh != null) {
            this.bsh.cK(z);
        }
    }

    public void cL(boolean z) {
        if (this.bsi != null) {
            this.bsi.cL(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ap apVar : this.aVr) {
            if (apVar.RO()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ap apVar : this.aVr) {
            if (apVar.RN()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aUV.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aUV.getAdapter()).notifyDataSetInvalidated();
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
        this.aUV.setData(arrayList);
    }

    public void gI(int i) {
        if (this.bsh != null) {
            this.bsh.gI(i);
        }
        if (this.bsi != null) {
            this.bsi.gI(i);
        }
    }

    public void onDestory() {
        if (this.bsk != null) {
            MessageManager.getInstance().unRegisterListener(this.bsk);
            this.bsk = null;
        }
    }
}
