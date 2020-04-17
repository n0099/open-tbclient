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
    private List<e> aMd;
    private TbPageContext<MsglistActivity<?>> duG;
    private BdTypeListView eOe;
    private MsgLeftViewItemAdapter ieB;
    private MsgRightViewItemAdapter ieC;
    private MsgMidViewItemAdapter ieD;
    private CustomMessageListener ieE;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aMd = new ArrayList();
        this.ieE = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.idU != null && aVar.context != null) {
                        h.this.aMd.addAll(aVar.idU);
                        h.this.eOe.addAdapters(new ArrayList(h.this.aMd));
                    }
                }
            }
        };
        this.duG = tbPageContext;
        this.eOe = bdTypeListView;
        BC();
        this.ieB.wG(i);
        this.ieC.wG(i);
    }

    private void BC() {
        this.ieB = new MsgLeftViewItemAdapter(this.duG, ChatMessage.TYPE_MSG_LEFT);
        this.ieB.on(true);
        this.ieB.om(true);
        this.ieC = new MsgRightViewItemAdapter(this.duG, ChatMessage.TYPE_MSG_RIGHT);
        this.ieC.on(true);
        this.ieC.om(true);
        this.ieD = new MsgMidViewItemAdapter(this.duG, ChatMessage.TYPE_MSG_MID);
        this.aMd.add(this.ieB);
        this.aMd.add(this.ieC);
        this.aMd.add(this.ieD);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.idU = new ArrayList();
        aVar.context = this.duG;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.ieE.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.duG.registerListener(this.ieE);
    }

    public void oo(boolean z) {
        if (this.ieB != null) {
            this.ieB.oo(z);
        }
    }

    public void op(boolean z) {
        if (this.ieC != null) {
            this.ieC.op(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aMd) {
            if (eVar.cdd()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aMd) {
            if (eVar.cdc()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eOe.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eOe.getAdapter().notifyDataSetInvalidated();
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
        this.eOe.setData(arrayList);
    }

    public void onDestory() {
        if (this.ieE != null) {
            MessageManager.getInstance().unRegisterListener(this.ieE);
            this.ieE = null;
        }
    }
}
