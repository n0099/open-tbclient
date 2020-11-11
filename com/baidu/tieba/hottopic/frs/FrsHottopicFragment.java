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
    private String eEA;
    private String eEB;
    private com.baidu.tbadk.k.c iNC;
    private HotRanklistModel jQj;
    private j jQk;
    private d jQl;
    private long mFid;
    private String mFrom;
    private CustomMessageListener iKR = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.iNC != null && FrsHottopicFragment.this.iNC.isViewAttached()) {
                FrsHottopicFragment.this.iNC.rC(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jQm = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.Wk();
            FrsHottopicFragment.this.jQl.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jQk = jVar;
                FrsHottopicFragment.this.jQl.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jQk));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jQl.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bPa();
            }
        }
    };
    private CustomMessageListener iIB = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cAO();
    }

    private void cAO() {
        if (isPrimary()) {
            if (this.iNC != null && this.iNC.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iKR);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jQj = new HotRanklistModel(getPageContext());
        this.jQj.a(this.jQm);
        registerListener(this.iIB);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eEA = arguments.getString("first_class_name");
            this.eEB = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jQl = new d(this, inflate, getPageContext());
        this.jQl.b(getTbPageTag());
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
        TiebaStatic.log(new aq("c13008").w("fid", this.mFid).al("obj_type", 2).al("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void cxS() {
        this.jQl.cxS();
    }

    @Override // com.baidu.tieba.frs.as
    public void bPV() {
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
        if (this.jQl != null) {
            this.jQl.onChangeSkinType();
        }
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jQl.pR(false);
        showLoadingView(this.jQl.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jQl.pR(true);
        hideLoadingView(this.jQl.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bPa() {
        this.jQl.pR(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.iNC == null) {
            this.iNC = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.iNC.setTitle(null);
            this.iNC.setSubText(null);
            this.iNC.setButtonText(null);
            this.iNC.showRefreshButton();
            this.iNC.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iNC.onChangeSkinType();
        this.iNC.attachView(this.jQl.getRootView(), true);
        MessageManager.getInstance().registerListener(this.iKR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
        this.jQl.pR(true);
        if (this.iNC != null && this.iNC.isViewAttached()) {
            this.iNC.dettachView(this.jQl.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.iKR);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bPa();
            return;
        }
        Wk();
        this.jQl.cxS();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jQl.setRefreshing(true);
        }
        this.jQj.cancelLoadData();
        this.jQj.f("frs", "frstab", "0", this.mFid);
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
        return this.jQl.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cNi())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cNi()) {
            if (topicList != null) {
                bw bwVar = new bw();
                bwVar.setTid(topicList.topic_tid + "");
                bwVar.b(topicList.video_info);
                bwVar.setFid(this.mFid);
                bwVar.Bh(this.eEA);
                bwVar.Bi(this.eEB);
                bwVar.Bj(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bwVar.a(metaData);
                bwVar.dh(topicList.update_time.longValue());
                bwVar.setTitle(topicList.topic_desc);
                bwVar.Bg(topicList.topic_user_name);
                bwVar.bog();
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
        MessageManager.getInstance().unRegisterListener(this.iKR);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bsB() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void bsC() {
    }
}
