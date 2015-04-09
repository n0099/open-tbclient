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
    private TbPageContext<MsglistActivity<?>> LP;
    private BdTypeListView aKe;
    private List<bd> aKt;
    private MsgLeftViewItemAdapter aYh;
    private MsgRightViewItemAdapter aYi;
    private MsgMidViewItemAdapter aYj;
    private CustomMessageListener aYk;
    private List<ChatMessage> mData;

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public ca(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aKt = new ArrayList();
        this.aYk = new cb(this, 2001282);
        this.LP = tbPageContext;
        this.aKe = bdTypeListView;
        Oh();
        this.aYh.fA(i);
        this.aYi.fA(i);
    }

    private void Oh() {
        this.aYh = new MsgLeftViewItemAdapter(this.LP, ChatMessage.TYPE_MSG_LEFT);
        this.aYh.co(true);
        this.aYh.cn(true);
        this.aYi = new MsgRightViewItemAdapter(this.LP, ChatMessage.TYPE_MSG_RIGHT);
        this.aYi.co(true);
        this.aYi.cn(true);
        this.aYj = new MsgMidViewItemAdapter(this.LP, ChatMessage.TYPE_MSG_MID);
        this.aKt.add(this.aYh);
        this.aKt.add(this.aYi);
        this.aKt.add(this.aYj);
        HH();
        bc bcVar = new bc();
        bcVar.aXy = new ArrayList();
        bcVar.context = this.LP;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(bcVar));
    }

    private void HH() {
        this.aYk.setPriority(Integer.MAX_VALUE);
        this.LP.registerListener(this.aYk);
    }

    public void cp(boolean z) {
        if (this.aYh != null) {
            this.aYh.cp(z);
        }
    }

    public void cq(boolean z) {
        if (this.aYi != null) {
            this.aYi.cq(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (bd bdVar : this.aKt) {
            if (bdVar.Oe()) {
                bdVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (bd bdVar : this.aKt) {
            if (bdVar.Od()) {
                bdVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aKe.getAdapter() instanceof com.baidu.adp.widget.ListView.g) {
            ((com.baidu.adp.widget.ListView.g) this.aKe.getAdapter()).notifyDataSetInvalidated();
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
        this.aKe.setData(arrayList);
    }

    public void fA(int i) {
        if (this.aYh != null) {
            this.aYh.fA(i);
        }
        if (this.aYi != null) {
            this.aYi.fA(i);
        }
    }

    public void onDestory() {
        if (this.aYk != null) {
            MessageManager.getInstance().unRegisterListener(this.aYk);
            this.aYk = null;
        }
    }
}
