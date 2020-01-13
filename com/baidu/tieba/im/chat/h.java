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
    private List<e> apl;
    private TbPageContext<MsglistActivity<?>> cRe;
    private BdTypeListView efW;
    private MsgLeftViewItemAdapter hrb;
    private MsgRightViewItemAdapter hrc;
    private MsgMidViewItemAdapter hrd;
    private CustomMessageListener hre;
    private List<ChatMessage> mData;

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public h(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.apl = new ArrayList();
        this.hre = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.h.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.hqu != null && aVar.context != null) {
                        h.this.apl.addAll(aVar.hqu);
                        h.this.efW.addAdapters(new ArrayList(h.this.apl));
                    }
                }
            }
        };
        this.cRe = tbPageContext;
        this.efW = bdTypeListView;
        vi();
        this.hrb.vU(i);
        this.hrc.vU(i);
    }

    private void vi() {
        this.hrb = new MsgLeftViewItemAdapter(this.cRe, ChatMessage.TYPE_MSG_LEFT);
        this.hrb.nb(true);
        this.hrb.na(true);
        this.hrc = new MsgRightViewItemAdapter(this.cRe, ChatMessage.TYPE_MSG_RIGHT);
        this.hrc.nb(true);
        this.hrc.na(true);
        this.hrd = new MsgMidViewItemAdapter(this.cRe, ChatMessage.TYPE_MSG_MID);
        this.apl.add(this.hrb);
        this.apl.add(this.hrc);
        this.apl.add(this.hrd);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.hqu = new ArrayList();
        aVar.context = this.cRe;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.hre.setPriority(Integer.MAX_VALUE);
        this.cRe.registerListener(this.hre);
    }

    public void nc(boolean z) {
        if (this.hrb != null) {
            this.hrb.nc(z);
        }
    }

    public void nd(boolean z) {
        if (this.hrc != null) {
            this.hrc.nd(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (e eVar : this.apl) {
            if (eVar.bQI()) {
                eVar.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (e eVar : this.apl) {
            if (eVar.bQH()) {
                eVar.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.efW.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.efW.getAdapter().notifyDataSetInvalidated();
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
        this.efW.setData(arrayList);
    }

    public void onDestory() {
        if (this.hre != null) {
            MessageManager.getInstance().unRegisterListener(this.hre);
            this.hre = null;
        }
    }
}
