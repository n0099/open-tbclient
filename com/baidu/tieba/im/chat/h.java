package com.baidu.tieba.im.chat;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h {
    private List<e> asP;
    private TbPageContext<MsglistActivity<?>> cVv;
    private BdTypeListView ekE;
    private MsgLeftViewItemAdapter huO;
    private MsgRightViewItemAdapter huP;
    private MsgMidViewItemAdapter huQ;
    private CustomMessageListener huR;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.asP = new ArrayList();
        this.huR = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.huh != null && aVar.context != null) {
                        h.this.asP.addAll(aVar.huh);
                        h.this.ekE.addAdapters(new ArrayList(h.this.asP));
                    }
                }
            }
        };
        this.cVv = tbPageContext;
        this.ekE = bdTypeListView;
        wR();
        this.huO.wi(i);
        this.huP.wi(i);
    }

    private void wR() {
        this.huO = new MsgLeftViewItemAdapter(this.cVv, ChatMessage.TYPE_MSG_LEFT);
        this.huO.nj(true);
        this.huO.ni(true);
        this.huP = new MsgRightViewItemAdapter(this.cVv, ChatMessage.TYPE_MSG_RIGHT);
        this.huP.nj(true);
        this.huP.ni(true);
        this.huQ = new MsgMidViewItemAdapter(this.cVv, ChatMessage.TYPE_MSG_MID);
        this.asP.add(this.huO);
        this.asP.add(this.huP);
        this.asP.add(this.huQ);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.huh = new ArrayList();
        aVar.context = this.cVv;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.huR.setPriority(Integer.MAX_VALUE);
        this.cVv.registerListener(this.huR);
    }

    public void nk(boolean z) {
        if (this.huO != null) {
            this.huO.nk(z);
        }
    }

    public void nl(boolean z) {
        if (this.huP != null) {
            this.huP.nl(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.asP) {
            if (eVar.bSE()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.asP) {
            if (eVar.bSD()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.ekE.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.ekE.getAdapter().notifyDataSetInvalidated();
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
        this.ekE.setData(arrayList);
    }

    public void onDestory() {
        if (this.huR != null) {
            MessageManager.getInstance().unRegisterListener(this.huR);
            this.huR = null;
        }
    }
}
