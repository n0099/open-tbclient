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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
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
/* loaded from: classes8.dex */
public class FrsHottopicFragment extends BaseFragment implements aq, as, d.a {
    private String dMk;
    private String dMl;
    private com.baidu.tbadk.k.c hEZ;
    private HotRanklistModel iEY;
    private j iEZ;
    private d iFa;
    private long mFid;
    private String mFrom;
    private CustomMessageListener hDd = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.hEZ != null && FrsHottopicFragment.this.hEZ.isViewAttached()) {
                FrsHottopicFragment.this.hEZ.nP(num.intValue());
            }
        }
    };
    private HotRanklistModel.a iFb = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.btN();
            FrsHottopicFragment.this.iFa.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.iEZ = jVar;
                FrsHottopicFragment.this.iFa.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.iEZ));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.iFa.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.btM();
            }
        }
    };
    private CustomMessageListener hAR = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        car();
    }

    private void car() {
        if (isPrimary()) {
            if (this.hEZ != null && this.hEZ.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hDd);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iEY = new HotRanklistModel(getPageContext());
        this.iEY.a(this.iFb);
        registerListener(this.hAR);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.dMk = arguments.getString("first_class_name");
            this.dMl = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.iFa = new d(this, inflate, getPageContext());
        this.iFa.b(getTbPageTag());
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
        TiebaStatic.log(new ao("c13008").s("fid", this.mFid).ag("obj_type", 2).ag("obj_locate", 2).dk("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.aq
    public void bXG() {
        this.iFa.bXG();
    }

    @Override // com.baidu.tieba.frs.aq
    public void buH() {
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
        if (this.iFa != null) {
            this.iFa.onChangeSkinType();
        }
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.iFa.nu(false);
        showLoadingView(this.iFa.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.iFa.nu(true);
        hideLoadingView(this.iFa.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btM() {
        this.iFa.nu(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.hEZ == null) {
            this.hEZ = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hEZ.setTitle(null);
            this.hEZ.setSubText(null);
            this.hEZ.setButtonText(null);
            this.hEZ.showRefreshButton();
            this.hEZ.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hEZ.onChangeSkinType();
        this.hEZ.attachView(this.iFa.getRootView(), true);
        MessageManager.getInstance().registerListener(this.hDd);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void btN() {
        this.iFa.nu(true);
        if (this.hEZ != null && this.hEZ.isViewAttached()) {
            this.hEZ.dettachView(this.iFa.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.hDd);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            btM();
            return;
        }
        btN();
        this.iFa.bXG();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.iFa.setRefreshing(true);
        }
        this.iEY.cancelLoadData();
        this.iEY.c("frs", "frstab", "0", this.mFid);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasData() {
        return this.iFa.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || w.isEmpty(jVar.clP())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.clP()) {
            if (topicList != null) {
                bu buVar = new bu();
                buVar.setTid(topicList.topic_tid + "");
                buVar.b(topicList.video_info);
                buVar.setFid(this.mFid);
                buVar.vX(this.dMk);
                buVar.vY(this.dMl);
                buVar.vZ(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                buVar.a(metaData);
                buVar.cb(topicList.update_time.longValue());
                buVar.setTitle(topicList.topic_desc);
                buVar.vW(topicList.topic_user_name);
                buVar.aTV();
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
                buVar.z(arrayList2);
                arrayList.add(buVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.hDd);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.as
    public void aYg() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.as
    public void aYh() {
    }
}
