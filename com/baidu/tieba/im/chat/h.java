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
/* loaded from: classes2.dex */
public class h {
    private List<e> bbu;
    private TbPageContext<MsglistActivity<?>> efn;
    private BdTypeListView fCP;
    private MsgLeftViewItemAdapter jgn;
    private MsgRightViewItemAdapter jgo;
    private MsgMidViewItemAdapter jgp;
    private CustomMessageListener jgq;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bbu = new ArrayList();
        this.jgq = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jfG != null && aVar.context != null) {
                        h.this.bbu.addAll(aVar.jfG);
                        h.this.fCP.addAdapters(new ArrayList(h.this.bbu));
                    }
                }
            }
        };
        this.efn = tbPageContext;
        this.fCP = bdTypeListView;
        Jv();
        this.jgn.AK(i);
        this.jgo.AK(i);
    }

    private void Jv() {
        this.jgn = new MsgLeftViewItemAdapter(this.efn, ChatMessage.TYPE_MSG_LEFT);
        this.jgn.qe(true);
        this.jgn.qd(true);
        this.jgo = new MsgRightViewItemAdapter(this.efn, ChatMessage.TYPE_MSG_RIGHT);
        this.jgo.qe(true);
        this.jgo.qd(true);
        this.jgp = new MsgMidViewItemAdapter(this.efn, ChatMessage.TYPE_MSG_MID);
        this.bbu.add(this.jgn);
        this.bbu.add(this.jgo);
        this.bbu.add(this.jgp);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jfG = new ArrayList();
        aVar.context = this.efn;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jgq.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.efn.registerListener(this.jgq);
    }

    public void qf(boolean z) {
        if (this.jgn != null) {
            this.jgn.qf(z);
        }
    }

    public void qg(boolean z) {
        if (this.jgo != null) {
            this.jgo.qg(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bbu) {
            if (eVar.cBR()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bbu) {
            if (eVar.cBQ()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fCP.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCP.getAdapter().notifyDataSetInvalidated();
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
        this.fCP.setData(arrayList);
    }

    public void onDestory() {
        if (this.jgq != null) {
            MessageManager.getInstance().unRegisterListener(this.jgq);
            this.jgq = null;
        }
    }
}
