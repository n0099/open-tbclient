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
    private List<MsgCommonItemAdapter> boS;
    private TbPageContext<MsglistActivity<?>> eWx;
    private BdTypeListView gAY;
    private MsgLeftViewItemAdapter kDi;
    private MsgRightViewItemAdapter kDj;
    private MsgMidViewItemAdapter kDk;
    private CustomMessageListener kDl;
    private List<ChatMessage> mData;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.boS = new ArrayList();
        this.kDl = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kCB != null && aVar.context != null) {
                        f.this.boS.addAll(aVar.kCB);
                        f.this.gAY.addAdapters(new ArrayList(f.this.boS));
                    }
                }
            }
        };
        this.eWx = tbPageContext;
        this.gAY = bdTypeListView;
        Kz();
        this.kDi.CK(i);
        this.kDj.CK(i);
    }

    private void Kz() {
        this.kDi = new MsgLeftViewItemAdapter(this.eWx, ChatMessage.TYPE_MSG_LEFT);
        this.kDi.sC(true);
        this.kDi.sB(true);
        this.kDj = new MsgRightViewItemAdapter(this.eWx, ChatMessage.TYPE_MSG_RIGHT);
        this.kDj.sC(true);
        this.kDj.sB(true);
        this.kDk = new MsgMidViewItemAdapter(this.eWx, ChatMessage.TYPE_MSG_MID);
        this.boS.add(this.kDi);
        this.boS.add(this.kDj);
        this.boS.add(this.kDk);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kCB = new ArrayList();
        aVar.context = this.eWx;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kDl.setPriority(Integer.MAX_VALUE);
        this.eWx.registerListener(this.kDl);
    }

    public void sD(boolean z) {
        if (this.kDi != null) {
            this.kDi.sD(z);
        }
    }

    public void sE(boolean z) {
        if (this.kDj != null) {
            this.kDj.sE(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.boS) {
            if (msgCommonItemAdapter.cUS()) {
                msgCommonItemAdapter.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.boS) {
            if (msgCommonItemAdapter.cUR()) {
                msgCommonItemAdapter.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetInvalidated();
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
        this.gAY.setData(arrayList);
    }

    public void onDestory() {
        if (this.kDl != null) {
            MessageManager.getInstance().unRegisterListener(this.kDl);
            this.kDl = null;
        }
    }
}
