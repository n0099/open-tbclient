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
    private String eqk;
    private String eql;
    private com.baidu.tbadk.k.c ivj;
    private HotRanklistModel jxM;
    private j jxN;
    private d jxO;
    private long mFid;
    private String mFrom;
    private CustomMessageListener isy = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.ivj != null && FrsHottopicFragment.this.ivj.isViewAttached()) {
                FrsHottopicFragment.this.ivj.rh(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jxP = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.SK();
            FrsHottopicFragment.this.jxO.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jxN = jVar;
                FrsHottopicFragment.this.jxO.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jxN));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jxO.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bJY();
            }
        }
    };
    private CustomMessageListener iqi = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cvg();
    }

    private void cvg() {
        if (isPrimary()) {
            if (this.ivj != null && this.ivj.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.isy);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jxM = new HotRanklistModel(getPageContext());
        this.jxM.a(this.jxP);
        registerListener(this.iqi);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eqk = arguments.getString("first_class_name");
            this.eql = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jxO = new d(this, inflate, getPageContext());
        this.jxO.b(getTbPageTag());
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
        TiebaStatic.log(new aq("c13008").u("fid", this.mFid).aj("obj_type", 2).aj("obj_locate", 2).dK("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void csk() {
        this.jxO.csk();
    }

    @Override // com.baidu.tieba.frs.as
    public void bKT() {
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
        if (this.jxO != null) {
            this.jxO.onChangeSkinType();
        }
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jxO.pq(false);
        showLoadingView(this.jxO.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jxO.pq(true);
        hideLoadingView(this.jxO.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bJY() {
        this.jxO.pq(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.ivj == null) {
            this.ivj = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.ivj.setTitle(null);
            this.ivj.setSubText(null);
            this.ivj.setButtonText(null);
            this.ivj.showRefreshButton();
            this.ivj.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.ivj.onChangeSkinType();
        this.ivj.attachView(this.jxO.getRootView(), true);
        MessageManager.getInstance().registerListener(this.isy);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
        this.jxO.pq(true);
        if (this.ivj != null && this.ivj.isViewAttached()) {
            this.ivj.dettachView(this.jxO.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.isy);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bJY();
            return;
        }
        SK();
        this.jxO.csk();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jxO.setRefreshing(true);
        }
        this.jxM.cancelLoadData();
        this.jxM.f("frs", "frstab", "0", this.mFid);
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
        return this.jxO.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cHA())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cHA()) {
            if (topicList != null) {
                bw bwVar = new bw();
                bwVar.setTid(topicList.topic_tid + "");
                bwVar.b(topicList.video_info);
                bwVar.setFid(this.mFid);
                bwVar.AA(this.eqk);
                bwVar.AB(this.eql);
                bwVar.AC(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bwVar.a(metaData);
                bwVar.cJ(topicList.update_time.longValue());
                bwVar.setTitle(topicList.topic_desc);
                bwVar.Az(topicList.topic_user_name);
                bwVar.bjN();
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
        MessageManager.getInstance().unRegisterListener(this.isy);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void boi() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void boj() {
    }
}
