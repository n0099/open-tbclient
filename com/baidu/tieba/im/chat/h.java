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
    private List<e> aWf;
    private TbPageContext<MsglistActivity<?>> dVN;
    private BdTypeListView frv;
    private MsgLeftViewItemAdapter iRo;
    private MsgRightViewItemAdapter iRp;
    private MsgMidViewItemAdapter iRq;
    private CustomMessageListener iRr;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aWf = new ArrayList();
        this.iRr = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.iQH != null && aVar.context != null) {
                        h.this.aWf.addAll(aVar.iQH);
                        h.this.frv.addAdapters(new ArrayList(h.this.aWf));
                    }
                }
            }
        };
        this.dVN = tbPageContext;
        this.frv = bdTypeListView;
        DS();
        this.iRo.yq(i);
        this.iRp.yq(i);
    }

    private void DS() {
        this.iRo = new MsgLeftViewItemAdapter(this.dVN, ChatMessage.TYPE_MSG_LEFT);
        this.iRo.py(true);
        this.iRo.px(true);
        this.iRp = new MsgRightViewItemAdapter(this.dVN, ChatMessage.TYPE_MSG_RIGHT);
        this.iRp.py(true);
        this.iRp.px(true);
        this.iRq = new MsgMidViewItemAdapter(this.dVN, ChatMessage.TYPE_MSG_MID);
        this.aWf.add(this.iRo);
        this.aWf.add(this.iRp);
        this.aWf.add(this.iRq);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.iQH = new ArrayList();
        aVar.context = this.dVN;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.iRr.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dVN.registerListener(this.iRr);
    }

    public void pz(boolean z) {
        if (this.iRo != null) {
            this.iRo.pz(z);
        }
    }

    public void pA(boolean z) {
        if (this.iRp != null) {
            this.iRp.pA(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aWf) {
            if (eVar.cqZ()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aWf) {
            if (eVar.cqY()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.frv.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.frv.getAdapter().notifyDataSetInvalidated();
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
        this.frv.setData(arrayList);
    }

    public void onDestory() {
        if (this.iRr != null) {
            MessageManager.getInstance().unRegisterListener(this.iRr);
            this.iRr = null;
        }
    }
}
