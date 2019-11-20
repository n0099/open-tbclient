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
public class h {
    private List<e> agy;
    private TbPageContext<MsglistActivity<?>> ceu;
    private BdTypeListView duK;
    private MsgLeftViewItemAdapter gzr;
    private MsgRightViewItemAdapter gzs;
    private MsgMidViewItemAdapter gzt;
    private CustomMessageListener gzu;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.agy = new ArrayList();
        this.gzu = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gyJ != null && aVar.context != null) {
                        h.this.agy.addAll(aVar.gyJ);
                        h.this.duK.addAdapters(new ArrayList(h.this.agy));
                    }
                }
            }
        };
        this.ceu = tbPageContext;
        this.duK = bdTypeListView;
        sY();
        this.gzr.tN(i);
        this.gzs.tN(i);
    }

    private void sY() {
        this.gzr = new MsgLeftViewItemAdapter(this.ceu, ChatMessage.TYPE_MSG_LEFT);
        this.gzr.lB(true);
        this.gzr.lA(true);
        this.gzs = new MsgRightViewItemAdapter(this.ceu, ChatMessage.TYPE_MSG_RIGHT);
        this.gzs.lB(true);
        this.gzs.lA(true);
        this.gzt = new MsgMidViewItemAdapter(this.ceu, ChatMessage.TYPE_MSG_MID);
        this.agy.add(this.gzr);
        this.agy.add(this.gzs);
        this.agy.add(this.gzt);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.gyJ = new ArrayList();
        aVar.context = this.ceu;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.gzu.setPriority(Integer.MAX_VALUE);
        this.ceu.registerListener(this.gzu);
    }

    public void lC(boolean z) {
        if (this.gzr != null) {
            this.gzr.lC(z);
        }
    }

    public void lD(boolean z) {
        if (this.gzs != null) {
            this.gzs.lD(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.agy) {
            if (eVar.byh()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (e eVar : this.agy) {
            if (eVar.byg()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.duK.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.duK.getAdapter().notifyDataSetInvalidated();
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
        this.duK.setData(arrayList);
    }

    public void onDestory() {
        if (this.gzu != null) {
            MessageManager.getInstance().unRegisterListener(this.gzu);
            this.gzu = null;
        }
    }
}
