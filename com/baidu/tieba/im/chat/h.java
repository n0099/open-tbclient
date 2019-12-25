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
    private List<e> aoz;
    private TbPageContext<MsglistActivity<?>> cQU;
    private BdTypeListView efM;
    private MsgMidViewItemAdapter hnA;
    private CustomMessageListener hnB;
    private MsgLeftViewItemAdapter hny;
    private MsgRightViewItemAdapter hnz;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aoz = new ArrayList();
        this.hnB = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hmR != null && aVar.context != null) {
                        h.this.aoz.addAll(aVar.hmR);
                        h.this.efM.addAdapters(new ArrayList(h.this.aoz));
                    }
                }
            }
        };
        this.cQU = tbPageContext;
        this.efM = bdTypeListView;
        uR();
        this.hny.vP(i);
        this.hnz.vP(i);
    }

    private void uR() {
        this.hny = new MsgLeftViewItemAdapter(this.cQU, ChatMessage.TYPE_MSG_LEFT);
        this.hny.mP(true);
        this.hny.mO(true);
        this.hnz = new MsgRightViewItemAdapter(this.cQU, ChatMessage.TYPE_MSG_RIGHT);
        this.hnz.mP(true);
        this.hnz.mO(true);
        this.hnA = new MsgMidViewItemAdapter(this.cQU, ChatMessage.TYPE_MSG_MID);
        this.aoz.add(this.hny);
        this.aoz.add(this.hnz);
        this.aoz.add(this.hnA);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.hmR = new ArrayList();
        aVar.context = this.cQU;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.hnB.setPriority(Integer.MAX_VALUE);
        this.cQU.registerListener(this.hnB);
    }

    public void mQ(boolean z) {
        if (this.hny != null) {
            this.hny.mQ(z);
        }
    }

    public void mR(boolean z) {
        if (this.hnz != null) {
            this.hnz.mR(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aoz) {
            if (eVar.bPz()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aoz) {
            if (eVar.bPy()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.efM.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efM.getAdapter().notifyDataSetInvalidated();
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
        this.efM.setData(arrayList);
    }

    public void onDestory() {
        if (this.hnB != null) {
            MessageManager.getInstance().unRegisterListener(this.hnB);
            this.hnB = null;
        }
    }
}
