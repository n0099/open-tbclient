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
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.as;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.frs.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes15.dex */
public class FrsHottopicFragment extends BaseFragment implements aq, as, d.a {
    private String dSv;
    private String dSw;
    private com.baidu.tbadk.k.c hKX;
    private HotRanklistModel iLc;
    private j iLd;
    private d iLe;
    private long mFid;
    private String mFrom;
    private CustomMessageListener hJb = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.hKX != null && FrsHottopicFragment.this.hKX.isViewAttached()) {
                FrsHottopicFragment.this.hKX.oh(num.intValue());
            }
        }
    };
    private HotRanklistModel.a iLf = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.bwX();
            FrsHottopicFragment.this.iLe.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.iLd = jVar;
                FrsHottopicFragment.this.iLe.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.iLd));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.iLe.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bwW();
            }
        }
    };
    private CustomMessageListener hGL = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cdQ();
    }

    private void cdQ() {
        if (isPrimary()) {
            if (this.hKX != null && this.hKX.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hJb);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iLc = new HotRanklistModel(getPageContext());
        this.iLc.a(this.iLf);
        registerListener(this.hGL);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.dSv = arguments.getString("first_class_name");
            this.dSw = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.iLe = new d(this, inflate, getPageContext());
        this.iLe.b(getTbPageTag());
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
        TiebaStatic.log(new ap("c13008").t("fid", this.mFid).ah("obj_type", 2).ah("obj_locate", 2).dn("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.aq
    public void cbd() {
        this.iLe.cbd();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxR() {
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
        if (this.iLe != null) {
            this.iLe.onChangeSkinType();
        }
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.iLe.nZ(false);
        showLoadingView(this.iLe.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iLe.nZ(true);
        hideLoadingView(this.iLe.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwW() {
        this.iLe.nZ(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.hKX == null) {
            this.hKX = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hKX.setTitle(null);
            this.hKX.setSubText(null);
            this.hKX.setButtonText(null);
            this.hKX.showRefreshButton();
            this.hKX.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hKX.onChangeSkinType();
        this.hKX.attachView(this.iLe.getRootView(), true);
        MessageManager.getInstance().registerListener(this.hJb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bwX() {
        this.iLe.nZ(true);
        if (this.hKX != null && this.hKX.isViewAttached()) {
            this.hKX.dettachView(this.iLe.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.hJb);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bwW();
            return;
        }
        bwX();
        this.iLe.cbd();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.iLe.setRefreshing(true);
        }
        this.iLc.cancelLoadData();
        this.iLc.c("frs", "frstab", "0", this.mFid);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasData() {
        return this.iLe.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || x.isEmpty(jVar.cpq())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cpq()) {
            if (topicList != null) {
                bv bvVar = new bv();
                bvVar.setTid(topicList.topic_tid + "");
                bvVar.b(topicList.video_info);
                bvVar.setFid(this.mFid);
                bvVar.xe(this.dSv);
                bvVar.xf(this.dSw);
                bvVar.xg(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bvVar.a(metaData);
                bvVar.cq(topicList.update_time.longValue());
                bvVar.setTitle(topicList.topic_desc);
                bvVar.xd(topicList.topic_user_name);
                bvVar.aXR();
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
                bvVar.A(arrayList2);
                arrayList.add(bvVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hJb);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.as
    public void bcg() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.as
    public void bch() {
    }
}
