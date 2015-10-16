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
    private List<ap> aVC;
    private BdTypeListView aVg;
    private MsgLeftViewItemAdapter bss;
    private MsgRightViewItemAdapter bst;
    private MsgMidViewItemAdapter bsu;
    private CustomMessageListener bsv;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aVC = new ArrayList();
        this.bsv = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aVg = bdTypeListView;
        RR();
        this.bss.gI(i);
        this.bst.gI(i);
    }

    private void RR() {
        this.bss = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bss.cJ(true);
        this.bss.cI(true);
        this.bst = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bst.cJ(true);
        this.bst.cI(true);
        this.bsu = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aVC.add(this.bss);
        this.aVC.add(this.bst);
        this.aVC.add(this.bsu);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.brJ = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bsv.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bsv);
    }

    public void cK(boolean z) {
        if (this.bss != null) {
            this.bss.cK(z);
        }
    }

    public void cL(boolean z) {
        if (this.bst != null) {
            this.bst.cL(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ap apVar : this.aVC) {
            if (apVar.RO()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ap apVar : this.aVC) {
            if (apVar.RN()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVg.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVg.getAdapter()).notifyDataSetInvalidated();
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
        this.aVg.setData(arrayList);
    }

    public void gI(int i) {
        if (this.bss != null) {
            this.bss.gI(i);
        }
        if (this.bst != null) {
            this.bst.gI(i);
        }
    }

    public void onDestory() {
        if (this.bsv != null) {
            MessageManager.getInstance().unRegisterListener(this.bsv);
            this.bsv = null;
        }
    }
}
