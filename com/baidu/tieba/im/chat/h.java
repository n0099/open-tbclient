package com.baidu.tieba.im.chat;

import android.support.v7.widget.ActivityChooserView;
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
    private List<e> bnf;
    private TbPageContext<MsglistActivity<?>> eNx;
    private BdTypeListView gpX;
    private MsgLeftViewItemAdapter kkI;
    private MsgRightViewItemAdapter kkJ;
    private MsgMidViewItemAdapter kkK;
    private CustomMessageListener kkL;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bnf = new ArrayList();
        this.kkL = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kkb != null && aVar.context != null) {
                        h.this.bnf.addAll(aVar.kkb);
                        h.this.gpX.addAdapters(new ArrayList(h.this.bnf));
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.gpX = bdTypeListView;
        Nt();
        this.kkI.DK(i);
        this.kkJ.DK(i);
    }

    private void Nt() {
        this.kkI = new MsgLeftViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_LEFT);
        this.kkI.sa(true);
        this.kkI.rZ(true);
        this.kkJ = new MsgRightViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_RIGHT);
        this.kkJ.sa(true);
        this.kkJ.rZ(true);
        this.kkK = new MsgMidViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_MID);
        this.bnf.add(this.kkI);
        this.bnf.add(this.kkJ);
        this.bnf.add(this.kkK);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kkb = new ArrayList();
        aVar.context = this.eNx;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kkL.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eNx.registerListener(this.kkL);
    }

    public void sb(boolean z) {
        if (this.kkI != null) {
            this.kkI.sb(z);
        }
    }

    public void sc(boolean z) {
        if (this.kkJ != null) {
            this.kkJ.sc(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bnf) {
            if (eVar.cTK()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bnf) {
            if (eVar.cTJ()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gpX.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpX.getAdapter().notifyDataSetInvalidated();
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
        this.gpX.setData(arrayList);
    }

    public void onDestory() {
        if (this.kkL != null) {
            MessageManager.getInstance().unRegisterListener(this.kkL);
            this.kkL = null;
        }
    }
}
