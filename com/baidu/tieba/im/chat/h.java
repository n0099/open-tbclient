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
    private List<e> bbw;
    private TbPageContext<MsglistActivity<?>> efr;
    private BdTypeListView fCT;
    private MsgLeftViewItemAdapter jgt;
    private MsgRightViewItemAdapter jgu;
    private MsgMidViewItemAdapter jgv;
    private CustomMessageListener jgw;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bbw = new ArrayList();
        this.jgw = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jfM != null && aVar.context != null) {
                        h.this.bbw.addAll(aVar.jfM);
                        h.this.fCT.addAdapters(new ArrayList(h.this.bbw));
                    }
                }
            }
        };
        this.efr = tbPageContext;
        this.fCT = bdTypeListView;
        Jv();
        this.jgt.AK(i);
        this.jgu.AK(i);
    }

    private void Jv() {
        this.jgt = new MsgLeftViewItemAdapter(this.efr, ChatMessage.TYPE_MSG_LEFT);
        this.jgt.qg(true);
        this.jgt.qf(true);
        this.jgu = new MsgRightViewItemAdapter(this.efr, ChatMessage.TYPE_MSG_RIGHT);
        this.jgu.qg(true);
        this.jgu.qf(true);
        this.jgv = new MsgMidViewItemAdapter(this.efr, ChatMessage.TYPE_MSG_MID);
        this.bbw.add(this.jgt);
        this.bbw.add(this.jgu);
        this.bbw.add(this.jgv);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jfM = new ArrayList();
        aVar.context = this.efr;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jgw.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.efr.registerListener(this.jgw);
    }

    public void qh(boolean z) {
        if (this.jgt != null) {
            this.jgt.qh(z);
        }
    }

    public void qi(boolean z) {
        if (this.jgu != null) {
            this.jgu.qi(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bbw) {
            if (eVar.cBS()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bbw) {
            if (eVar.cBR()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fCT.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fCT.getAdapter().notifyDataSetInvalidated();
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
        this.fCT.setData(arrayList);
    }

    public void onDestory() {
        if (this.jgw != null) {
            MessageManager.getInstance().unRegisterListener(this.jgw);
            this.jgw = null;
        }
    }
}
