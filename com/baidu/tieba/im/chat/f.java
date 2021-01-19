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
    private List<MsgCommonItemAdapter> bjZ;
    private TbPageContext<MsglistActivity<?>> eSJ;
    private BdTypeListView gwr;
    private MsgLeftViewItemAdapter ksL;
    private MsgRightViewItemAdapter ksM;
    private MsgMidViewItemAdapter ksN;
    private CustomMessageListener ksO;
    private List<ChatMessage> mData;

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
    }

    public f(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        this.mData = null;
        this.bjZ = new ArrayList();
        this.ksO = new CustomMessageListener(CmdConfigCustom.CMD_MSG_LIST_ADAPTER_SCAN) { // from class: com.baidu.tieba.im.chat.f.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && customResponsedMessage.getData() != null) {
                    MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                    if (aVar.kse != null && aVar.context != null) {
                        f.this.bjZ.addAll(aVar.kse);
                        f.this.gwr.addAdapters(new ArrayList(f.this.bjZ));
                    }
                }
            }
        };
        this.eSJ = tbPageContext;
        this.gwr = bdTypeListView;
        IY();
        this.ksL.Cp(i);
        this.ksM.Cp(i);
    }

    private void IY() {
        this.ksL = new MsgLeftViewItemAdapter(this.eSJ, ChatMessage.TYPE_MSG_LEFT);
        this.ksL.sp(true);
        this.ksL.so(true);
        this.ksM = new MsgRightViewItemAdapter(this.eSJ, ChatMessage.TYPE_MSG_RIGHT);
        this.ksM.sp(true);
        this.ksM.so(true);
        this.ksN = new MsgMidViewItemAdapter(this.eSJ, ChatMessage.TYPE_MSG_MID);
        this.bjZ.add(this.ksL);
        this.bjZ.add(this.ksM);
        this.bjZ.add(this.ksN);
        initListener();
        MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
        aVar.kse = new ArrayList();
        aVar.context = this.eSJ;
        MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
    }

    private void initListener() {
        this.ksO.setPriority(ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED);
        this.eSJ.registerListener(this.ksO);
    }

    public void sq(boolean z) {
        if (this.ksL != null) {
            this.ksL.sq(z);
        }
    }

    public void sr(boolean z) {
        if (this.ksM != null) {
            this.ksM.sr(z);
        }
    }

    public void a(com.baidu.adp.lib.b.a aVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bjZ) {
            if (msgCommonItemAdapter.cSG()) {
                msgCommonItemAdapter.a(aVar);
            }
        }
    }

    public void setOnItemViewLongClickListener(com.baidu.adp.lib.b.b bVar) {
        for (MsgCommonItemAdapter msgCommonItemAdapter : this.bjZ) {
            if (msgCommonItemAdapter.cSF()) {
                msgCommonItemAdapter.setOnItemViewLongClickListener(bVar);
            }
        }
    }

    public List<ChatMessage> getData() {
        return this.mData;
    }

    public void e(ChatMessage chatMessage) {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetChanged() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetChanged();
        }
    }

    public void notifyDataSetInvalidated() {
        if (this.gwr.getAdapter() instanceof com.baidu.adp.widget.ListView.e) {
            this.gwr.getAdapter().notifyDataSetInvalidated();
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
        this.gwr.setData(arrayList);
    }

    public void onDestory() {
        if (this.ksO != null) {
            MessageManager.getInstance().unRegisterListener(this.ksO);
            this.ksO = null;
        }
    }
}
