package com.baidu.tieba.im.chat;

import androidx.appcompat.widget.ActivityChooserView;
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
public class f {
    private List<MsgCommonItemAdapter> boM;
    private TbPageContext<MsglistActivity<?>> eXu;
    private BdTypeListView gAY;
    private MsgLeftViewItemAdapter kxq;
    private MsgRightViewItemAdapter kxr;
    private MsgMidViewItemAdapter kxs;
    private CustomMessageListener kxt;
    private List<ChatMessage> mData;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.boM = new ArrayList();
        this.kxt = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kwJ != null && aVar.context != null) {
                        f.this.boM.addAll(aVar.kwJ);
                        f.this.gAY.addAdapters(new ArrayList(f.this.boM));
                    }
                }
            }
        };
        this.eXu = tbPageContext;
        this.gAY = bdTypeListView;
        MT();
        this.kxq.DW(i);
        this.kxr.DW(i);
    }

    private void MT() {
        this.kxq = new MsgLeftViewItemAdapter(this.eXu, ChatMessage.TYPE_MSG_LEFT);
        this.kxq.st(true);
        this.kxq.ss(true);
        this.kxr = new MsgRightViewItemAdapter(this.eXu, ChatMessage.TYPE_MSG_RIGHT);
        this.kxr.st(true);
        this.kxr.ss(true);
        this.kxs = new MsgMidViewItemAdapter(this.eXu, ChatMessage.TYPE_MSG_MID);
        this.boM.add(this.kxq);
        this.boM.add(this.kxr);
        this.boM.add(this.kxs);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kwJ = new ArrayList();
        aVar.context = this.eXu;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kxt.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eXu.registerListener(this.kxt);
    }

    public void su(boolean z) {
        if (this.kxq != null) {
            this.kxq.su(z);
        }
    }

    public void sv(boolean z) {
        if (this.kxr != null) {
            this.kxr.sv(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.boM) {
            if (msgCommonItemAdapter.cWy()) {
                msgCommonItemAdapter.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.boM) {
            if (msgCommonItemAdapter.cWx()) {
                msgCommonItemAdapter.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gAY.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gAY.getAdapter().notifyDataSetInvalidated();
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
        this.gAY.setData(arrayList);
    }

    public void onDestory() {
        if (this.kxt != null) {
            MessageManager.getInstance().unRegisterListener(this.kxt);
            this.kxt = null;
        }
    }
}
