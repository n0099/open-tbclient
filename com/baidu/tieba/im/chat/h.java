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
    private List<e> bky;
    private TbPageContext<MsglistActivity<?>> eIc;
    private BdTypeListView gih;
    private MsgLeftViewItemAdapter jWs;
    private MsgRightViewItemAdapter jWt;
    private MsgMidViewItemAdapter jWu;
    private CustomMessageListener jWv;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bky = new ArrayList();
        this.jWv = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.jVL != null && aVar.context != null) {
                        h.this.bky.addAll(aVar.jVL);
                        h.this.gih.addAdapters(new ArrayList(h.this.bky));
                    }
                }
            }
        };
        this.eIc = tbPageContext;
        this.gih = bdTypeListView;
        LY();
        this.jWs.Cx(i);
        this.jWt.Cx(i);
    }

    private void LY() {
        this.jWs = new MsgLeftViewItemAdapter(this.eIc, ChatMessage.TYPE_MSG_LEFT);
        this.jWs.rv(true);
        this.jWs.ru(true);
        this.jWt = new MsgRightViewItemAdapter(this.eIc, ChatMessage.TYPE_MSG_RIGHT);
        this.jWt.rv(true);
        this.jWt.ru(true);
        this.jWu = new MsgMidViewItemAdapter(this.eIc, ChatMessage.TYPE_MSG_MID);
        this.bky.add(this.jWs);
        this.bky.add(this.jWt);
        this.bky.add(this.jWu);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.jVL = new ArrayList();
        aVar.context = this.eIc;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.jWv.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eIc.registerListener(this.jWv);
    }

    public void rw(boolean z) {
        if (this.jWs != null) {
            this.jWs.rw(z);
        }
    }

    public void rx(boolean z) {
        if (this.jWt != null) {
            this.jWt.rx(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.bky) {
            if (eVar.cOQ()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.bky) {
            if (eVar.cOP()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gih.getAdapter() instanceof com.baidu.adp.widget.ListView.f) {
            this.gih.getAdapter().notifyDataSetInvalidated();
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
        this.gih.setData(arrayList);
    }

    public void onDestory() {
        if (this.jWv != null) {
            MessageManager.getInstance().unRegisterListener(this.jWv);
            this.jWv = null;
        }
    }
}
