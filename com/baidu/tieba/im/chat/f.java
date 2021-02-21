package com.baidu.tieba.im.chat;

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
    private List<MsgCommonItemAdapter> bns;
    private TbPageContext<MsglistActivity<?>> eUY;
    private BdTypeListView gzp;
    private MsgLeftViewItemAdapter kBg;
    private MsgRightViewItemAdapter kBh;
    private MsgMidViewItemAdapter kBi;
    private CustomMessageListener kBj;
    private List<ChatMessage> mData;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bns = new ArrayList();
        this.kBj = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kAz != null && aVar.context != null) {
                        f.this.bns.addAll(aVar.kAz);
                        f.this.gzp.addAdapters(new ArrayList(f.this.bns));
                    }
                }
            }
        };
        this.eUY = tbPageContext;
        this.gzp = bdTypeListView;
        Kw();
        this.kBg.CH(i);
        this.kBh.CH(i);
    }

    private void Kw() {
        this.kBg = new MsgLeftViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_LEFT);
        this.kBg.sC(true);
        this.kBg.sB(true);
        this.kBh = new MsgRightViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_RIGHT);
        this.kBh.sC(true);
        this.kBh.sB(true);
        this.kBi = new MsgMidViewItemAdapter(this.eUY, ChatMessage.TYPE_MSG_MID);
        this.bns.add(this.kBg);
        this.bns.add(this.kBh);
        this.bns.add(this.kBi);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kAz = new ArrayList();
        aVar.context = this.eUY;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.kBj.setPriority(Integer.MAX_VALUE);
        this.eUY.registerListener(this.kBj);
    }

    public void sD(boolean z) {
        if (this.kBg != null) {
            this.kBg.sD(z);
        }
    }

    public void sE(boolean z) {
        if (this.kBh != null) {
            this.kBh.sE(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bns) {
            if (msgCommonItemAdapter.cUL()) {
                msgCommonItemAdapter.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bns) {
            if (msgCommonItemAdapter.cUK()) {
                msgCommonItemAdapter.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gzp.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gzp.getAdapter().notifyDataSetInvalidated();
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
        this.gzp.setData(arrayList);
    }

    public void onDestory() {
        if (this.kBj != null) {
            MessageManager.getInstance().unRegisterListener(this.kBj);
            this.kBj = null;
        }
    }
}
