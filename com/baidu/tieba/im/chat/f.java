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
public class f {
    private List<MsgCommonItemAdapter> bns;
    private TbPageContext<MsglistActivity<?>> eUY;
    private BdTypeListView gzb;
    private MsgLeftViewItemAdapter kAS;
    private MsgRightViewItemAdapter kAT;
    private MsgMidViewItemAdapter kAU;
    private CustomMessageListener kAV;
    private List<ChatMessage> mData;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bns = new ArrayList();
        this.kAV = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kAl != null && aVar.context != null) {
                        f.this.bns.addAll(aVar.kAl);
                        f.this.gzb.addAdapters(new ArrayList(f.this.bns));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.gzb = bdTypeListView;
        Kw();
        this.kAS.CH(i);
        this.kAT.CH(i);
    }

    private void Kw() {
        this.kAS = new MsgLeftViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_LEFT);
        this.kAS.sC(true);
        this.kAS.sB(true);
        this.kAT = new MsgRightViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_RIGHT);
        this.kAT.sC(true);
        this.kAT.sB(true);
        this.kAU = new MsgMidViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_MID);
        this.bns.add(this.kAS);
        this.bns.add(this.kAT);
        this.bns.add(this.kAU);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kAl = new ArrayList();
        aVar.context = this.eUY;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kAV.setPriority(Integer.MAX_VALUE);
        this.eUY.registerListener(this.kAV);
    }

    public void sD(boolean z) {
        if (this.kAS != null) {
            this.kAS.sD(z);
        }
    }

    public void sE(boolean z) {
        if (this.kAT != null) {
            this.kAT.sE(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bns) {
            if (msgCommonItemAdapter.cUE()) {
                msgCommonItemAdapter.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bns) {
            if (msgCommonItemAdapter.cUD()) {
                msgCommonItemAdapter.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gzb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzb.getAdapter().notifyDataSetInvalidated();
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
        this.gzb.setData(arrayList);
    }

    public void onDestory() {
        if (this.kAV != null) {
            MessageManager.getInstance().unRegisterListener(this.kAV);
            this.kAV = null;
        }
    }
}
