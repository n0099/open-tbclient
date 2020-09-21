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
/* loaded from: classes20.dex */
public class FrsHottopicFragment extends BaseFragment implements as, au, d.a {
    private String eef;
    private String eeg;
    private com.baidu.tbadk.k.c igm;
    private HotRanklistModel jiO;
    private j jiP;
    private d jiQ;
    private long mFid;
    private String mFrom;
    private CustomMessageListener idB = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.igm != null && FrsHottopicFragment.this.igm.isViewAttached()) {
                FrsHottopicFragment.this.igm.qJ(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jiR = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.bHn();
            FrsHottopicFragment.this.jiQ.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jiP = jVar;
                FrsHottopicFragment.this.jiQ.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jiP));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jiQ.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bHm();
            }
        }
    };
    private CustomMessageListener ibh = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        crI();
    }

    private void crI() {
        if (isPrimary()) {
            if (this.igm != null && this.igm.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.idB);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jiO = new HotRanklistModel(getPageContext());
        this.jiO.a(this.jiR);
        registerListener(this.ibh);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eef = arguments.getString("first_class_name");
            this.eeg = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jiQ = new d(this, inflate, getPageContext());
        this.jiQ.b(getTbPageTag());
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
        TiebaStatic.log(new aq("c13008").u("fid", this.mFid).ai("obj_type", 2).ai("obj_locate", 2).dF("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void coM() {
        this.jiQ.coM();
    }

    @Override // com.baidu.tieba.frs.as
    public void bIh() {
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
        if (this.jiQ != null) {
            this.jiQ.onChangeSkinType();
        }
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jiQ.oL(false);
        showLoadingView(this.jiQ.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jiQ.oL(true);
        hideLoadingView(this.jiQ.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHm() {
        this.jiQ.oL(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.igm == null) {
            this.igm = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.igm.setTitle(null);
            this.igm.setSubText(null);
            this.igm.setButtonText(null);
            this.igm.showRefreshButton();
            this.igm.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.igm.onChangeSkinType();
        this.igm.attachView(this.jiQ.getRootView(), true);
        MessageManager.getInstance().registerListener(this.idB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bHn() {
        this.jiQ.oL(true);
        if (this.igm != null && this.igm.isViewAttached()) {
            this.igm.dettachView(this.jiQ.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.idB);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bHm();
            return;
        }
        bHn();
        this.jiQ.coM();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jiQ.setRefreshing(true);
        }
        this.jiO.cancelLoadData();
        this.jiO.c("frs", "frstab", "0", this.mFid);
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
        return this.jiQ.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cDR())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cDR()) {
            if (topicList != null) {
                bw bwVar = new bw();
                bwVar.setTid(topicList.topic_tid + "");
                bwVar.b(topicList.video_info);
                bwVar.setFid(this.mFid);
                bwVar.zO(this.eef);
                bwVar.zP(this.eeg);
                bwVar.zQ(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bwVar.a(metaData);
                bwVar.cB(topicList.update_time.longValue());
                bwVar.setTitle(topicList.topic_desc);
                bwVar.zN(topicList.topic_user_name);
                bwVar.bhe();
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
        MessageManager.getInstance().unRegisterListener(this.idB);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bly() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void blz() {
    }
}
