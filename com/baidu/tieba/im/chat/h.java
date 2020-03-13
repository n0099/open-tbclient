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
    private List<e> asF;
    private TbPageContext<MsglistActivity<?>> cVi;
    private BdTypeListView eko;
    private MsgLeftViewItemAdapter hto;
    private MsgRightViewItemAdapter htp;
    private MsgMidViewItemAdapter htq;
    private CustomMessageListener htr;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.asF = new ArrayList();
        this.htr = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hsH != null && aVar.context != null) {
                        h.this.asF.addAll(aVar.hsH);
                        h.this.eko.addAdapters(new ArrayList(h.this.asF));
                    }
                }
            }
        };
        this.cVi = tbPageContext;
        this.eko = bdTypeListView;
        wM();
        this.hto.wa(i);
        this.htp.wa(i);
    }

    private void wM() {
        this.hto = new MsgLeftViewItemAdapter(this.cVi, ChatMessage.TYPE_MSG_LEFT);
        this.hto.nd(true);
        this.hto.nc(true);
        this.htp = new MsgRightViewItemAdapter(this.cVi, ChatMessage.TYPE_MSG_RIGHT);
        this.htp.nd(true);
        this.htp.nc(true);
        this.htq = new MsgMidViewItemAdapter(this.cVi, ChatMessage.TYPE_MSG_MID);
        this.asF.add(this.hto);
        this.asF.add(this.htp);
        this.asF.add(this.htq);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.hsH = new ArrayList();
        aVar.context = this.cVi;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.htr.setPriority(Integer.MAX_VALUE);
        this.cVi.registerListener(this.htr);
    }

    public void ne(boolean z) {
        if (this.hto != null) {
            this.hto.ne(z);
        }
    }

    public void nf(boolean z) {
        if (this.htp != null) {
            this.htp.nf(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.asF) {
            if (eVar.bSm()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.asF) {
            if (eVar.bSl()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.eko.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.eko.getAdapter().notifyDataSetInvalidated();
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
        this.eko.setData(arrayList);
    }

    public void onDestory() {
        if (this.htr != null) {
            MessageManager.getInstance().unRegisterListener(this.htr);
            this.htr = null;
        }
    }
}
