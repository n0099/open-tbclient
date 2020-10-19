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
    private List<e> bhH;
    private TbPageContext<MsglistActivity<?>> etO;
    private BdTypeListView fSo;
    private MsgLeftViewItemAdapter jDW;
    private MsgRightViewItemAdapter jDX;
    private MsgMidViewItemAdapter jDY;
    private CustomMessageListener jDZ;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bhH = new ArrayList();
        this.jDZ = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jDp != null && aVar.context != null) {
                        h.this.bhH.addAll(aVar.jDp);
                        h.this.fSo.addAdapters(new ArrayList(h.this.bhH));
                    }
                }
            }
        };
        this.etO = tbPageContext;
        this.fSo = bdTypeListView;
        Le();
        this.jDW.BR(i);
        this.jDX.BR(i);
    }

    private void Le() {
        this.jDW = new MsgLeftViewItemAdapter(this.etO, ChatMessage.TYPE_MSG_LEFT);
        this.jDW.qU(true);
        this.jDW.qT(true);
        this.jDX = new MsgRightViewItemAdapter(this.etO, ChatMessage.TYPE_MSG_RIGHT);
        this.jDX.qU(true);
        this.jDX.qT(true);
        this.jDY = new MsgMidViewItemAdapter(this.etO, ChatMessage.TYPE_MSG_MID);
        this.bhH.add(this.jDW);
        this.bhH.add(this.jDX);
        this.bhH.add(this.jDY);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jDp = new ArrayList();
        aVar.context = this.etO;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jDZ.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.etO.registerListener(this.jDZ);
    }

    public void qV(boolean z) {
        if (this.jDW != null) {
            this.jDW.qV(z);
        }
    }

    public void qW(boolean z) {
        if (this.jDX != null) {
            this.jDX.qW(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bhH) {
            if (eVar.cJi()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bhH) {
            if (eVar.cJh()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fSo.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.fSo.getAdapter().notifyDataSetInvalidated();
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
        this.fSo.setData(arrayList);
    }

    public void onDestory() {
        if (this.jDZ != null) {
            MessageManager.getInstance().unRegisterListener(this.jDZ);
            this.jDZ = null;
        }
    }
}
