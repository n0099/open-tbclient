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
public class bi {
    private TbPageContext<MsglistActivity<?>> LS;
    private List<ap> aVP;
    private BdTypeListView aVy;
    private MsgLeftViewItemAdapter boJ;
    private MsgRightViewItemAdapter boK;
    private MsgMidViewItemAdapter boL;
    private CustomMessageListener boM;
    private List<ChatMessage> mData;

    public bi(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public bi(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aVP = new ArrayList();
        this.boM = new bj(this, CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN);
        this.LS = tbPageContext;
        this.aVy = bdTypeListView;
        Ri();
        this.boJ.gs(i);
        this.boK.gs(i);
    }

    private void Ri() {
        this.boJ = new MsgLeftViewItemAdapter(this.LS, ChatMessage.TYPE_MSG_LEFT);
        this.boJ.cE(true);
        this.boJ.cD(true);
        this.boK = new MsgRightViewItemAdapter(this.LS, ChatMessage.TYPE_MSG_RIGHT);
        this.boK.cE(true);
        this.boK.cD(true);
        this.boL = new MsgMidViewItemAdapter(this.LS, ChatMessage.TYPE_MSG_MID);
        this.aVP.add(this.boJ);
        this.aVP.add(this.boK);
        this.aVP.add(this.boL);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.bob = new ArrayList();
        aVar.context = this.LS;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.boM.setPriority(Integer.MAX_VALUE);
        this.LS.registerListener(this.boM);
    }

    public void cF(boolean z) {
        if (this.boJ != null) {
            this.boJ.cF(z);
        }
    }

    public void cG(boolean z) {
        if (this.boK != null) {
            this.boK.cG(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (ap apVar : this.aVP) {
            if (apVar.Rf()) {
                apVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (ap apVar : this.aVP) {
            if (apVar.Re()) {
                apVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.aVy.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            ((com.baidu.adp.widget.ListView.e) this.aVy.getAdapter()).notifyDataSetInvalidated();
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
        this.aVy.setData(arrayList);
    }

    public void gs(int i) {
        if (this.boJ != null) {
            this.boJ.gs(i);
        }
        if (this.boK != null) {
            this.boK.gs(i);
        }
    }

    public void onDestory() {
        if (this.boM != null) {
            MessageManager.getInstance().unRegisterListener(this.boM);
            this.boM = null;
        }
    }
}
