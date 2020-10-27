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
    private List<e> bje;
    private TbPageContext<MsglistActivity<?>> eCn;
    private BdTypeListView gcr;
    private MsgLeftViewItemAdapter jQv;
    private MsgRightViewItemAdapter jQw;
    private MsgMidViewItemAdapter jQx;
    private CustomMessageListener jQy;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bje = new ArrayList();
        this.jQy = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jPO != null && aVar.context != null) {
                        h.this.bje.addAll(aVar.jPO);
                        h.this.gcr.addAdapters(new ArrayList(h.this.bje));
                    }
                }
            }
        };
        this.eCn = tbPageContext;
        this.gcr = bdTypeListView;
        Ly();
        this.jQv.Ck(i);
        this.jQw.Ck(i);
    }

    private void Ly() {
        this.jQv = new MsgLeftViewItemAdapter(this.eCn, ChatMessage.TYPE_MSG_LEFT);
        this.jQv.rm(true);
        this.jQv.rl(true);
        this.jQw = new MsgRightViewItemAdapter(this.eCn, ChatMessage.TYPE_MSG_RIGHT);
        this.jQw.rm(true);
        this.jQw.rl(true);
        this.jQx = new MsgMidViewItemAdapter(this.eCn, ChatMessage.TYPE_MSG_MID);
        this.bje.add(this.jQv);
        this.bje.add(this.jQw);
        this.bje.add(this.jQx);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jPO = new ArrayList();
        aVar.context = this.eCn;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jQy.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eCn.registerListener(this.jQy);
    }

    public void rn(boolean z) {
        if (this.jQv != null) {
            this.jQv.rn(z);
        }
    }

    public void ro(boolean z) {
        if (this.jQw != null) {
            this.jQw.ro(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bje) {
            if (eVar.cMp()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bje) {
            if (eVar.cMo()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gcr.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gcr.getAdapter().notifyDataSetInvalidated();
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
        this.gcr.setData(arrayList);
    }

    public void onDestory() {
        if (this.jQy != null) {
            MessageManager.getInstance().unRegisterListener(this.jQy);
            this.jQy = null;
        }
    }
}
