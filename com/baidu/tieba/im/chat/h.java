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
    private List<e> bdV;
    private TbPageContext<MsglistActivity<?>> ehG;
    private BdTypeListView fGf;
    private MsgLeftViewItemAdapter joZ;
    private MsgRightViewItemAdapter jpa;
    private MsgMidViewItemAdapter jpb;
    private CustomMessageListener jpc;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bdV = new ArrayList();
        this.jpc = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jos != null && aVar.context != null) {
                        h.this.bdV.addAll(aVar.jos);
                        h.this.fGf.addAdapters(new ArrayList(h.this.bdV));
                    }
                }
            }
        };
        this.ehG = tbPageContext;
        this.fGf = bdTypeListView;
        JZ();
        this.joZ.Bl(i);
        this.jpa.Bl(i);
    }

    private void JZ() {
        this.joZ = new MsgLeftViewItemAdapter(this.ehG, ChatMessage.TYPE_MSG_LEFT);
        this.joZ.qo(true);
        this.joZ.qn(true);
        this.jpa = new MsgRightViewItemAdapter(this.ehG, ChatMessage.TYPE_MSG_RIGHT);
        this.jpa.qo(true);
        this.jpa.qn(true);
        this.jpb = new MsgMidViewItemAdapter(this.ehG, ChatMessage.TYPE_MSG_MID);
        this.bdV.add(this.joZ);
        this.bdV.add(this.jpa);
        this.bdV.add(this.jpb);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jos = new ArrayList();
        aVar.context = this.ehG;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jpc.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.ehG.registerListener(this.jpc);
    }

    public void qp(boolean z) {
        if (this.joZ != null) {
            this.joZ.qp(z);
        }
    }

    public void qq(boolean z) {
        if (this.jpa != null) {
            this.jpa.qq(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bdV) {
            if (eVar.cFz()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bdV) {
            if (eVar.cFy()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fGf.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fGf.getAdapter().notifyDataSetInvalidated();
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
        this.fGf.setData(arrayList);
    }

    public void onDestory() {
        if (this.jpc != null) {
            MessageManager.getInstance().unRegisterListener(this.jpc);
            this.jpc = null;
        }
    }
}
