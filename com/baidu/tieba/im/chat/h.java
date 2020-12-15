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
    private BdTypeListView gpZ;
    private MsgLeftViewItemAdapter kkK;
    private MsgRightViewItemAdapter kkL;
    private MsgMidViewItemAdapter kkM;
    private CustomMessageListener kkN;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bnf = new ArrayList();
        this.kkN = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kkd != null && aVar.context != null) {
                        h.this.bnf.addAll(aVar.kkd);
                        h.this.gpZ.addAdapters(new ArrayList(h.this.bnf));
                    }
                }
            }
        };
        this.eNx = tbPageContext;
        this.gpZ = bdTypeListView;
        Nt();
        this.kkK.DK(i);
        this.kkL.DK(i);
    }

    private void Nt() {
        this.kkK = new MsgLeftViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_LEFT);
        this.kkK.sa(true);
        this.kkK.rZ(true);
        this.kkL = new MsgRightViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_RIGHT);
        this.kkL.sa(true);
        this.kkL.rZ(true);
        this.kkM = new MsgMidViewItemAdapter(this.eNx, ChatMessage.TYPE_MSG_MID);
        this.bnf.add(this.kkK);
        this.bnf.add(this.kkL);
        this.bnf.add(this.kkM);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kkd = new ArrayList();
        aVar.context = this.eNx;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kkN.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eNx.registerListener(this.kkN);
    }

    public void sb(boolean z) {
        if (this.kkK != null) {
            this.kkK.sb(z);
        }
    }

    public void sc(boolean z) {
        if (this.kkL != null) {
            this.kkL.sc(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bnf) {
            if (eVar.cTL()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bnf) {
            if (eVar.cTK()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gpZ.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gpZ.getAdapter().notifyDataSetInvalidated();
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
        this.gpZ.setData(arrayList);
    }

    public void onDestory() {
        if (this.kkN != null) {
            MessageManager.getInstance().unRegisterListener(this.kkN);
            this.kkN = null;
        }
    }
}
