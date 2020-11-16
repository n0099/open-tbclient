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
    private List<e> biN;
    private TbPageContext<MsglistActivity<?>> eGu;
    private BdTypeListView ghN;
    private MsgLeftViewItemAdapter jXc;
    private MsgRightViewItemAdapter jXd;
    private MsgMidViewItemAdapter jXe;
    private CustomMessageListener jXf;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.biN = new ArrayList();
        this.jXf = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jWv != null && aVar.context != null) {
                        h.this.biN.addAll(aVar.jWv);
                        h.this.ghN.addAdapters(new ArrayList(h.this.biN));
                    }
                }
            }
        };
        this.eGu = tbPageContext;
        this.ghN = bdTypeListView;
        Lp();
        this.jXc.CV(i);
        this.jXd.CV(i);
    }

    private void Lp() {
        this.jXc = new MsgLeftViewItemAdapter(this.eGu, ChatMessage.TYPE_MSG_LEFT);
        this.jXc.ry(true);
        this.jXc.rx(true);
        this.jXd = new MsgRightViewItemAdapter(this.eGu, ChatMessage.TYPE_MSG_RIGHT);
        this.jXd.ry(true);
        this.jXd.rx(true);
        this.jXe = new MsgMidViewItemAdapter(this.eGu, ChatMessage.TYPE_MSG_MID);
        this.biN.add(this.jXc);
        this.biN.add(this.jXd);
        this.biN.add(this.jXe);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jWv = new ArrayList();
        aVar.context = this.eGu;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jXf.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eGu.registerListener(this.jXf);
    }

    public void rz(boolean z) {
        if (this.jXc != null) {
            this.jXc.rz(z);
        }
    }

    public void rA(boolean z) {
        if (this.jXd != null) {
            this.jXd.rA(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.biN) {
            if (eVar.cOw()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.biN) {
            if (eVar.cOv()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.ghN.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.ghN.getAdapter().notifyDataSetInvalidated();
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
        this.ghN.setData(arrayList);
    }

    public void onDestory() {
        if (this.jXf != null) {
            MessageManager.getInstance().unRegisterListener(this.jXf);
            this.jXf = null;
        }
    }
}
