package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bx;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.frs.au;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.frs.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes20.dex */
public class FrsHottopicFragment extends BaseFragment implements as, au, d.a {
    private String eCS;
    private String eCT;
    private com.baidu.tbadk.k.c iOp;
    private HotRanklistModel jQT;
    private j jQU;
    private d jQV;
    private long mFid;
    private String mFrom;
    private CustomMessageListener iLE = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.iOp != null && FrsHottopicFragment.this.iOp.isViewAttached()) {
                FrsHottopicFragment.this.iOp.sa(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jQW = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.VB();
            FrsHottopicFragment.this.jQV.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jQU = jVar;
                FrsHottopicFragment.this.jQV.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jQU));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jQV.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bOt();
            }
        }
    };
    private CustomMessageListener iJp = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == 401) {
                    FrsHottopicFragment.this.refresh();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        cAr();
    }

    private void cAr() {
        if (isPrimary()) {
            if (this.iOp != null && this.iOp.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iLE);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jQT = new HotRanklistModel(getPageContext());
        this.jQT.a(this.jQW);
        registerListener(this.iJp);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eCS = arguments.getString("first_class_name");
            this.eCT = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jQV = new d(this, inflate, getPageContext());
        this.jQV.b(getTbPageTag());
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        if (!hasData()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        TiebaStatic.log(new ar("c13008").w("fid", this.mFid).ak("obj_type", 2).ak("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void cxv() {
        this.jQV.cxv();
    }

    @Override // com.baidu.tieba.frs.as
    public void bPo() {
        refresh();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragment
    public void onNetRefreshButtonClicked() {
        if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            refresh();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jQV != null) {
            this.jQV.onChangeSkinType();
        }
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jQV.pU(false);
        showLoadingView(this.jQV.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jQV.pU(true);
        hideLoadingView(this.jQV.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOt() {
        this.jQV.pU(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.iOp == null) {
            this.iOp = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iOp.setTitle(null);
            this.iOp.setSubText(null);
            this.iOp.setButtonText(null);
            this.iOp.showRefreshButton();
            this.iOp.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iOp.onChangeSkinType();
        this.iOp.attachView(this.jQV.getRootView(), true);
        MessageManager.getInstance().registerListener(this.iLE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VB() {
        this.jQV.pU(true);
        if (this.iOp != null && this.iOp.isViewAttached()) {
            this.iOp.dettachView(this.jQV.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.iLE);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bOt();
            return;
        }
        VB();
        this.jQV.cxv();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jQV.setRefreshing(true);
        }
        this.jQT.cancelLoadData();
        this.jQT.f("frs", "frstab", "0", this.mFid);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        tbPageTag.tabId = 401;
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasData() {
        return this.jQV.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cMP())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cMP()) {
            if (topicList != null) {
                bx bxVar = new bx();
                bxVar.setTid(topicList.topic_tid + "");
                bxVar.b(topicList.video_info);
                bxVar.setFid(this.mFid);
                bxVar.AC(this.eCS);
                bxVar.AD(this.eCT);
                bxVar.AE(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bxVar.a(metaData);
                bxVar.dh(topicList.update_time.longValue());
                bxVar.setTitle(topicList.topic_desc);
                bxVar.AB(topicList.topic_user_name);
                bxVar.bnk();
                ArrayList<MediaData> arrayList2 = new ArrayList<>();
                if (topicList.media != null) {
                    List<Media> list = topicList.media;
                    int i = 0;
                    while (true) {
                        int i2 = i;
                        if (i2 >= list.size()) {
                            break;
                        }
                        MediaData mediaData = new MediaData();
                        mediaData.parserProtobuf(list.get(i2));
                        arrayList2.add(mediaData);
                        i = i2 + 1;
                    }
                }
                bxVar.G(arrayList2);
                arrayList.add(bxVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iLE);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void brR() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void brS() {
    }
}
