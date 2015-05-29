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
    private TbPageContext<MsglistActivity<?>> LH;
    private List<bd> aMA;
    private BdTypeListView aMl;
    private MsgLeftViewItemAdapter baO;
    private MsgRightViewItemAdapter baP;
    private MsgMidViewItemAdapter baQ;
    private CustomMessageListener baR;
    private List<ChatMessage> mData;

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aMA = new ArrayList();
        this.baR = new cb(this, 2001282);
        this.LH = tbPageContext;
        this.aMl = bdTypeListView;
        Pw();
        this.baO.fR(i);
        this.baP.fR(i);
    }

    private void Pw() {
        this.baO = new MsgLeftViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_LEFT);
        this.baO.cz(true);
        this.baO.cy(true);
        this.baP = new MsgRightViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_RIGHT);
        this.baP.cz(true);
        this.baP.cy(true);
        this.baQ = new MsgMidViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_MID);
        this.aMA.add(this.baO);
        this.aMA.add(this.baP);
        this.aMA.add(this.baQ);
        initListener();
        bc bcVar = new bc();
        bcVar.bae = new ArrayList();
        bcVar.context = this.LH;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(bcVar));
    }

    private void initListener() {
        this.baR.setPriority(Integer.MAX_VALUE);
        this.LH.registerListener(this.baR);
    }

    public void cA(boolean z) {
        if (this.baO != null) {
            this.baO.cA(z);
        }
    }

    public void cB(boolean z) {
        if (this.baP != null) {
            this.baP.cB(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (bd bdVar : this.aMA) {
            if (bdVar.Pt()) {
                bdVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (bd bdVar : this.aMA) {
            if (bdVar.Ps()) {
                bdVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aMl.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMl.getAdapter()).notifyDataSetInvalidated();
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
        this.aMl.setData(arrayList);
    }

    public void fR(int i) {
        if (this.baO != null) {
            this.baO.fR(i);
        }
        if (this.baP != null) {
            this.baP.fR(i);
        }
    }

    public void onDestory() {
        if (this.baR != null) {
            MessageManager.getInstance().unRegisterListener(this.baR);
            this.baR = null;
        }
    }
}
