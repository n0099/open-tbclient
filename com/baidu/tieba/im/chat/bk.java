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
    private TbPageContext<MsglistActivity<?>> MR;
    private List<ChatMessage> aIY;
    private List<ap> aXX;
    private BdTypeListView aXu;
    private CustomMessageListener bPA;
    private MsgLeftViewItemAdapter bPx;
    private MsgRightViewItemAdapter bPy;
    private MsgMidViewItemAdapter bPz;

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bk(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.aIY = null;
        this.aXX = new ArrayList();
        this.bPA = new bl(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.MR = tbPageContext;
        this.aXu = bdTypeListView;
        YZ();
        this.bPx.iE(i);
        this.bPy.iE(i);
    }

    private void YZ() {
        this.bPx = new MsgLeftViewItemAdapter(this.MR, ChatMessage.TYPE_MSG_LEFT);
        this.bPx.di(true);
        this.bPx.dh(true);
        this.bPy = new MsgRightViewItemAdapter(this.MR, ChatMessage.TYPE_MSG_RIGHT);
        this.bPy.di(true);
        this.bPy.dh(true);
        this.bPz = new MsgMidViewItemAdapter(this.MR, ChatMessage.TYPE_MSG_MID);
        this.aXX.add(this.bPx);
        this.aXX.add(this.bPy);
        this.aXX.add(this.bPz);
        pm();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bOO = new ArrayList();
        aVar.context = this.MR;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void pm() {
        this.bPA.setPriority(Integer.MAX_VALUE);
        this.MR.registerListener(this.bPA);
    }

    public void dj(boolean z) {
        if (this.bPx != null) {
            this.bPx.dj(z);
        }
    }

    public void dk(boolean z) {
        if (this.bPy != null) {
            this.bPy.dk(z);
        }
    }

    public void a(com.baidu.adp.lib.d.a aVar) {
        for (ap apVar : this.aXX) {
            if (apVar.YW()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.d.b bVar) {
        for (ap apVar : this.aXX) {
            if (apVar.YV()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.aIY;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aXu.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aXu.getAdapter()).notifyDataSetInvalidated();
        }
    }

    public void setData(List<ChatMessage> list) {
        this.aIY = list;
        ArrayList arrayList = new ArrayList();
        if (this.aIY != null) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                if (i > 0) {
                    if (list.get(i).getCacheData() == null) {
                        list.get(i).setCacheData(new MsgCacheData());
                    }
                    list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                }
            }
            arrayList.addAll(this.aIY);
        }
        this.aXu.setData(arrayList);
    }

    public void onDestory() {
        if (this.bPA != null) {
            MessageManager.getInstance().unRegisterListener(this.bPA);
            this.bPA = null;
        }
    }
}
