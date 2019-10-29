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
    private List<e> agQ;
    private TbPageContext<MsglistActivity<?>> cfl;
    private BdTypeListView dvB;
    private MsgLeftViewItemAdapter gAi;
    private MsgRightViewItemAdapter gAj;
    private MsgMidViewItemAdapter gAk;
    private CustomMessageListener gAl;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.agQ = new ArrayList();
        this.gAl = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.gzA != null && aVar.context != null) {
                        h.this.agQ.addAll(aVar.gzA);
                        h.this.dvB.addAdapters(new ArrayList(h.this.agQ));
                    }
                }
            }
        };
        this.cfl = tbPageContext;
        this.dvB = bdTypeListView;
        sX();
        this.gAi.tO(i);
        this.gAj.tO(i);
    }

    private void sX() {
        this.gAi = new MsgLeftViewItemAdapter(this.cfl, ChatMessage.TYPE_MSG_LEFT);
        this.gAi.lB(true);
        this.gAi.lA(true);
        this.gAj = new MsgRightViewItemAdapter(this.cfl, ChatMessage.TYPE_MSG_RIGHT);
        this.gAj.lB(true);
        this.gAj.lA(true);
        this.gAk = new MsgMidViewItemAdapter(this.cfl, ChatMessage.TYPE_MSG_MID);
        this.agQ.add(this.gAi);
        this.agQ.add(this.gAj);
        this.agQ.add(this.gAk);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.gzA = new ArrayList();
        aVar.context = this.cfl;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.gAl.setPriority(Integer.MAX_VALUE);
        this.cfl.registerListener(this.gAl);
    }

    public void lC(boolean z) {
        if (this.gAi != null) {
            this.gAi.lC(z);
        }
    }

    public void lD(boolean z) {
        if (this.gAj != null) {
            this.gAj.lD(z);
        }
    }

    public void a(com.baidu.adp.lib.c.a aVar) {
        for (e eVar : this.agQ) {
            if (eVar.byj()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.c.b bVar) {
        for (e eVar : this.agQ) {
            if (eVar.byi()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.dvB.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.dvB.getAdapter().notifyDataSetInvalidated();
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
        this.dvB.setData(arrayList);
    }

    public void onDestory() {
        if (this.gAl != null) {
            MessageManager.getInstance().unRegisterListener(this.gAl);
            this.gAl = null;
        }
    }
}
