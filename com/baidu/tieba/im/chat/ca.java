package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class ca {
    private TbPageContext<MsglistActivity<?>> LN;
    private BdTypeListView aJU;
    private List<bd> aKj;
    private MsgLeftViewItemAdapter aXR;
    private MsgRightViewItemAdapter aXS;
    private MsgMidViewItemAdapter aXT;
    private CustomMessageListener aXU;
    private List<ChatMessage> mData;

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aKj = new ArrayList();
        this.aXU = new cb(this, 2001282);
        this.LN = tbPageContext;
        this.aJU = bdTypeListView;
        NU();
        this.aXR.fy(i);
        this.aXS.fy(i);
    }

    private void NU() {
        this.aXR = new MsgLeftViewItemAdapter(this.LN, ChatMessage.TYPE_MSG_LEFT);
        this.aXR.cq(true);
        this.aXR.cp(true);
        this.aXS = new MsgRightViewItemAdapter(this.LN, ChatMessage.TYPE_MSG_RIGHT);
        this.aXS.cq(true);
        this.aXS.cp(true);
        this.aXT = new MsgMidViewItemAdapter(this.LN, ChatMessage.TYPE_MSG_MID);
        this.aKj.add(this.aXR);
        this.aKj.add(this.aXS);
        this.aKj.add(this.aXT);
        HB();
        bc bcVar = new bc();
        bcVar.aXi = new ArrayList();
        bcVar.context = this.LN;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(bcVar));
    }

    private void HB() {
        this.aXU.setPriority(Integer.MAX_VALUE);
        this.LN.registerListener(this.aXU);
    }

    public void cr(boolean z) {
        if (this.aXR != null) {
            this.aXR.cr(z);
        }
    }

    public void cs(boolean z) {
        if (this.aXS != null) {
            this.aXS.cs(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (bd bdVar : this.aKj) {
            if (bdVar.NR()) {
                bdVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (bd bdVar : this.aKj) {
            if (bdVar.NQ()) {
                bdVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aJU.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aJU.getAdapter()).notifyDataSetInvalidated();
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
        this.aJU.setData(arrayList);
    }

    public void fy(int i) {
        if (this.aXR != null) {
            this.aXR.fy(i);
        }
        if (this.aXS != null) {
            this.aXS.fy(i);
        }
    }

    public void onDestory() {
        if (this.aXU != null) {
            MessageManager.getInstance().unRegisterListener(this.aXU);
            this.aXU = null;
        }
    }
}
