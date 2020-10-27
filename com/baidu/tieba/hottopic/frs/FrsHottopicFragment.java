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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aq;
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
/* loaded from: classes21.dex */
public class FrsHottopicFragment extends BaseFragment implements as, au, d.a {
    private String eyL;
    private String eyM;
    private com.baidu.tbadk.k.c iHF;
    private HotRanklistModel jKl;
    private j jKm;
    private d jKn;
    private long mFid;
    private String mFrom;
    private CustomMessageListener iEU = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.iHF != null && FrsHottopicFragment.this.iHF.isViewAttached()) {
                FrsHottopicFragment.this.iHF.rs(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jKo = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.TK();
            FrsHottopicFragment.this.jKn.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jKm = jVar;
                FrsHottopicFragment.this.jKn.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jKm));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jKn.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bMA();
            }
        }
    };
    private CustomMessageListener iCE = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cyn();
    }

    private void cyn() {
        if (isPrimary()) {
            if (this.iHF != null && this.iHF.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iEU);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jKl = new HotRanklistModel(getPageContext());
        this.jKl.a(this.jKo);
        registerListener(this.iCE);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eyL = arguments.getString("first_class_name");
            this.eyM = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jKn = new d(this, inflate, getPageContext());
        this.jKn.b(getTbPageTag());
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
        TiebaStatic.log(new aq("c13008").w("fid", this.mFid).aj("obj_type", 2).aj("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void cvr() {
        this.jKn.cvr();
    }

    @Override // com.baidu.tieba.frs.as
    public void bNv() {
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
        if (this.jKn != null) {
            this.jKn.onChangeSkinType();
        }
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jKn.pI(false);
        showLoadingView(this.jKn.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jKn.pI(true);
        hideLoadingView(this.jKn.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bMA() {
        this.jKn.pI(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.iHF == null) {
            this.iHF = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iHF.setTitle(null);
            this.iHF.setSubText(null);
            this.iHF.setButtonText(null);
            this.iHF.showRefreshButton();
            this.iHF.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iHF.onChangeSkinType();
        this.iHF.attachView(this.jKn.getRootView(), true);
        MessageManager.getInstance().registerListener(this.iEU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void TK() {
        this.jKn.pI(true);
        if (this.iHF != null && this.iHF.isViewAttached()) {
            this.iHF.dettachView(this.jKn.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.iEU);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bMA();
            return;
        }
        TK();
        this.jKn.cvr();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jKn.setRefreshing(true);
        }
        this.jKl.cancelLoadData();
        this.jKl.f("frs", "frstab", "0", this.mFid);
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
        return this.jKn.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cKH())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cKH()) {
            if (topicList != null) {
                bw bwVar = new bw();
                bwVar.setTid(topicList.topic_tid + "");
                bwVar.b(topicList.video_info);
                bwVar.setFid(this.mFid);
                bwVar.AT(this.eyL);
                bwVar.AU(this.eyM);
                bwVar.AV(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bwVar.a(metaData);
                bwVar.cL(topicList.update_time.longValue());
                bwVar.setTitle(topicList.topic_desc);
                bwVar.AS(topicList.topic_user_name);
                bwVar.blG();
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
                bwVar.G(arrayList2);
                arrayList.add(bwVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iEU);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bqb() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void bqc() {
    }
}
