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
    private List<e> aSj;
    private TbPageContext<MsglistActivity<?>> dIF;
    private BdTypeListView faQ;
    private MsgLeftViewItemAdapter itq;
    private MsgRightViewItemAdapter itr;
    private MsgMidViewItemAdapter its;
    private CustomMessageListener itt;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aSj = new ArrayList();
        this.itt = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.isJ != null && aVar.context != null) {
                        h.this.aSj.addAll(aVar.isJ);
                        h.this.faQ.addAdapters(new ArrayList(h.this.aSj));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.faQ = bdTypeListView;
        CY();
        this.itq.xm(i);
        this.itr.xm(i);
    }

    private void CY() {
        this.itq = new MsgLeftViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_LEFT);
        this.itq.oJ(true);
        this.itq.oI(true);
        this.itr = new MsgRightViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_RIGHT);
        this.itr.oJ(true);
        this.itr.oI(true);
        this.its = new MsgMidViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_MID);
        this.aSj.add(this.itq);
        this.aSj.add(this.itr);
        this.aSj.add(this.its);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.isJ = new ArrayList();
        aVar.context = this.dIF;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.itt.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dIF.registerListener(this.itt);
    }

    public void oK(boolean z) {
        if (this.itq != null) {
            this.itq.oK(z);
        }
    }

    public void oL(boolean z) {
        if (this.itr != null) {
            this.itr.oL(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aSj) {
            if (eVar.cjA()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aSj) {
            if (eVar.cjz()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.faQ.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.faQ.getAdapter().notifyDataSetInvalidated();
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
        this.faQ.setData(arrayList);
    }

    public void onDestory() {
        if (this.itt != null) {
            MessageManager.getInstance().unRegisterListener(this.itt);
            this.itt = null;
        }
    }
}
