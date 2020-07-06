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
    private List<e> aUP;
    private TbPageContext<MsglistActivity<?>> dPv;
    private BdTypeListView fml;
    private MsgLeftViewItemAdapter iLj;
    private MsgRightViewItemAdapter iLk;
    private MsgMidViewItemAdapter iLl;
    private CustomMessageListener iLm;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aUP = new ArrayList();
        this.iLm = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.iKC != null && aVar.context != null) {
                        h.this.aUP.addAll(aVar.iKC);
                        h.this.fml.addAdapters(new ArrayList(h.this.aUP));
                    }
                }
            }
        };
        this.dPv = tbPageContext;
        this.fml = bdTypeListView;
        Dz();
        this.iLj.xY(i);
        this.iLk.xY(i);
    }

    private void Dz() {
        this.iLj = new MsgLeftViewItemAdapter(this.dPv, ChatMessage.TYPE_MSG_LEFT);
        this.iLj.oT(true);
        this.iLj.oS(true);
        this.iLk = new MsgRightViewItemAdapter(this.dPv, ChatMessage.TYPE_MSG_RIGHT);
        this.iLk.oT(true);
        this.iLk.oS(true);
        this.iLl = new MsgMidViewItemAdapter(this.dPv, ChatMessage.TYPE_MSG_MID);
        this.aUP.add(this.iLj);
        this.aUP.add(this.iLk);
        this.aUP.add(this.iLl);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.iKC = new ArrayList();
        aVar.context = this.dPv;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.iLm.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dPv.registerListener(this.iLm);
    }

    public void oU(boolean z) {
        if (this.iLj != null) {
            this.iLj.oU(z);
        }
    }

    public void oV(boolean z) {
        if (this.iLk != null) {
            this.iLk.oV(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aUP) {
            if (eVar.cnz()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aUP) {
            if (eVar.cny()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fml.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fml.getAdapter().notifyDataSetInvalidated();
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
        this.fml.setData(arrayList);
    }

    public void onDestory() {
        if (this.iLm != null) {
            MessageManager.getInstance().unRegisterListener(this.iLm);
            this.iLm = null;
        }
    }
}
