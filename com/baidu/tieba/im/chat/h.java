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
    private List<e> aSj;
    private TbPageContext<MsglistActivity<?>> dIF;
    private BdTypeListView fbb;
    private MsgLeftViewItemAdapter iud;
    private MsgRightViewItemAdapter iue;
    private MsgMidViewItemAdapter iuf;
    private CustomMessageListener iug;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.aSj = new ArrayList();
        this.iug = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.itw != null && aVar.context != null) {
                        h.this.aSj.addAll(aVar.itw);
                        h.this.fbb.addAdapters(new ArrayList(h.this.aSj));
                    }
                }
            }
        };
        this.dIF = tbPageContext;
        this.fbb = bdTypeListView;
        CY();
        this.iud.xo(i);
        this.iue.xo(i);
    }

    private void CY() {
        this.iud = new MsgLeftViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_LEFT);
        this.iud.oJ(true);
        this.iud.oI(true);
        this.iue = new MsgRightViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_RIGHT);
        this.iue.oJ(true);
        this.iue.oI(true);
        this.iuf = new MsgMidViewItemAdapter(this.dIF, ChatMessage.TYPE_MSG_MID);
        this.aSj.add(this.iud);
        this.aSj.add(this.iue);
        this.aSj.add(this.iuf);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.itw = new ArrayList();
        aVar.context = this.dIF;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.iug.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.dIF.registerListener(this.iug);
    }

    public void oK(boolean z) {
        if (this.iud != null) {
            this.iud.oK(z);
        }
    }

    public void oL(boolean z) {
        if (this.iue != null) {
            this.iue.oL(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.aSj) {
            if (eVar.cjJ()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.aSj) {
            if (eVar.cjI()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.fbb.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.fbb.getAdapter().notifyDataSetInvalidated();
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
        this.fbb.setData(arrayList);
    }

    public void onDestory() {
        if (this.iug != null) {
            MessageManager.getInstance().unRegisterListener(this.iug);
            this.iug = null;
        }
    }
}
