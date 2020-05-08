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
    private List<e> aMj;
    private TbPageContext<MsglistActivity<?>> duK;
    private BdTypeListView eOj;
    private MsgLeftViewItemAdapter ieH;
    private MsgRightViewItemAdapter ieI;
    private MsgMidViewItemAdapter ieJ;
    private CustomMessageListener ieK;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aMj = new ArrayList();
        this.ieK = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.iea != null && aVar.context != null) {
                        h.this.aMj.addAll(aVar.iea);
                        h.this.eOj.addAdapters(new ArrayList(h.this.aMj));
                    }
                }
            }
        };
        this.duK = tbPageContext;
        this.eOj = bdTypeListView;
        BB();
        this.ieH.wG(i);
        this.ieI.wG(i);
    }

    private void BB() {
        this.ieH = new MsgLeftViewItemAdapter(this.duK, ChatMessage.TYPE_MSG_LEFT);
        this.ieH.on(true);
        this.ieH.om(true);
        this.ieI = new MsgRightViewItemAdapter(this.duK, ChatMessage.TYPE_MSG_RIGHT);
        this.ieI.on(true);
        this.ieI.om(true);
        this.ieJ = new MsgMidViewItemAdapter(this.duK, ChatMessage.TYPE_MSG_MID);
        this.aMj.add(this.ieH);
        this.aMj.add(this.ieI);
        this.aMj.add(this.ieJ);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.iea = new ArrayList();
        aVar.context = this.duK;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.ieK.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.duK.registerListener(this.ieK);
    }

    public void oo(boolean z) {
        if (this.ieH != null) {
            this.ieH.oo(z);
        }
    }

    public void op(boolean z) {
        if (this.ieI != null) {
            this.ieI.op(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aMj) {
            if (eVar.cdb()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aMj) {
            if (eVar.cda()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eOj.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOj.getAdapter().notifyDataSetInvalidated();
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
        this.eOj.setData(arrayList);
    }

    public void onDestory() {
        if (this.ieK != null) {
            MessageManager.getInstance().unRegisterListener(this.ieK);
            this.ieK = null;
        }
    }
}
