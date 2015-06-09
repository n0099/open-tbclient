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
    private List<bd> aMB;
    private BdTypeListView aMm;
    private MsgLeftViewItemAdapter baP;
    private MsgRightViewItemAdapter baQ;
    private MsgMidViewItemAdapter baR;
    private CustomMessageListener baS;
    private List<ChatMessage> mData;

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aMB = new ArrayList();
        this.baS = new cb(this, 2001282);
        this.LH = tbPageContext;
        this.aMm = bdTypeListView;
        Px();
        this.baP.fR(i);
        this.baQ.fR(i);
    }

    private void Px() {
        this.baP = new MsgLeftViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_LEFT);
        this.baP.cz(true);
        this.baP.cy(true);
        this.baQ = new MsgRightViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_RIGHT);
        this.baQ.cz(true);
        this.baQ.cy(true);
        this.baR = new MsgMidViewItemAdapter(this.LH, ChatMessage.TYPE_MSG_MID);
        this.aMB.add(this.baP);
        this.aMB.add(this.baQ);
        this.aMB.add(this.baR);
        initListener();
        bc bcVar = new bc();
        bcVar.baf = new ArrayList();
        bcVar.context = this.LH;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(bcVar));
    }

    private void initListener() {
        this.baS.setPriority(Integer.MAX_VALUE);
        this.LH.registerListener(this.baS);
    }

    public void cA(boolean z) {
        if (this.baP != null) {
            this.baP.cA(z);
        }
    }

    public void cB(boolean z) {
        if (this.baQ != null) {
            this.baQ.cB(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (bd bdVar : this.aMB) {
            if (bdVar.Pu()) {
                bdVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (bd bdVar : this.aMB) {
            if (bdVar.Pt()) {
                bdVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aMm.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aMm.getAdapter()).notifyDataSetInvalidated();
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
        this.aMm.setData(arrayList);
    }

    public void fR(int i) {
        if (this.baP != null) {
            this.baP.fR(i);
        }
        if (this.baQ != null) {
            this.baQ.fR(i);
        }
    }

    public void onDestory() {
        if (this.baS != null) {
            MessageManager.getInstance().unRegisterListener(this.baS);
            this.baS = null;
        }
    }
}
