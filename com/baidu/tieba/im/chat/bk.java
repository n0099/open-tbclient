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
    private BdTypeListView aVo;
    private MsgLeftViewItemAdapter bsW;
    private MsgRightViewItemAdapter bsX;
    private MsgMidViewItemAdapter bsY;
    private CustomMessageListener bsZ;
    private TbPageContext<MsglistActivity<?>> mContext;
    private List<ChatMessage> mData;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aVK = new ArrayList();
        this.bsZ = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.mContext = tbPageContext;
        this.aVo = bdTypeListView;
        Sj();
        this.bsW.gV(i);
        this.bsX.gV(i);
    }

    private void Sj() {
        this.bsW = new MsgLeftViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_LEFT);
        this.bsW.cL(true);
        this.bsW.cK(true);
        this.bsX = new MsgRightViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_RIGHT);
        this.bsX.cL(true);
        this.bsX.cK(true);
        this.bsY = new MsgMidViewItemAdapter(this.mContext, ChatMessage.TYPE_MSG_MID);
        this.aVK.add(this.bsW);
        this.aVK.add(this.bsX);
        this.aVK.add(this.bsY);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bsn = new ArrayList();
        aVar.context = this.mContext;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.bsZ.setPriority(Integer.MAX_VALUE);
        this.mContext.registerListener(this.bsZ);
    }

    public void cM(boolean z) {
        if (this.bsW != null) {
            this.bsW.cM(z);
        }
    }

    public void cN(boolean z) {
        if (this.bsX != null) {
            this.bsX.cN(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ap apVar : this.aVK) {
            if (apVar.Sg()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ap apVar : this.aVK) {
            if (apVar.Sf()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVo.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVo.getAdapter()).notifyDataSetInvalidated();
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
        this.aVo.setData(arrayList);
    }

    public void gV(int i) {
        if (this.bsW != null) {
            this.bsW.gV(i);
        }
        if (this.bsX != null) {
            this.bsX.gV(i);
        }
    }

    public void onDestory() {
        if (this.bsZ != null) {
            MessageManager.getInstance().unRegisterListener(this.bsZ);
            this.bsZ = null;
        }
    }
}
