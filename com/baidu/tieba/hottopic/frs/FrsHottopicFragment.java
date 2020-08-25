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
/* loaded from: classes15.dex */
public class FrsHottopicFragment extends BaseFragment implements as, au, d.a {
    private String ebR;
    private String ebS;
    private com.baidu.tbadk.k.c hZc;
    private HotRanklistModel jac;
    private j jad;
    private d jae;
    private long mFid;
    private String mFrom;
    private CustomMessageListener hWr = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.hZc != null && FrsHottopicFragment.this.hZc.isViewAttached()) {
                FrsHottopicFragment.this.hZc.qs(num.intValue());
            }
        }
    };
    private HotRanklistModel.a jaf = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.bFW();
            FrsHottopicFragment.this.jae.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.jad = jVar;
                FrsHottopicFragment.this.jae.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.jad));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.jae.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bFV();
            }
        }
    };
    private CustomMessageListener hUb = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cou();
    }

    private void cou() {
        if (isPrimary()) {
            if (this.hZc != null && this.hZc.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.hWr);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.jac = new HotRanklistModel(getPageContext());
        this.jac.a(this.jaf);
        registerListener(this.hUb);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.ebR = arguments.getString("first_class_name");
            this.ebS = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.jae = new d(this, inflate, getPageContext());
        this.jae.b(getTbPageTag());
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
        TiebaStatic.log(new aq("c13008").u("fid", this.mFid).ai("obj_type", 2).ai("obj_locate", 2).dD("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.as
    public void clz() {
        this.jae.clz();
    }

    @Override // com.baidu.tieba.frs.as
    public void bGQ() {
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
        if (this.jae != null) {
            this.jae.onChangeSkinType();
        }
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.jae.oD(false);
        showLoadingView(this.jae.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.jae.oD(true);
        hideLoadingView(this.jae.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFV() {
        this.jae.oD(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.hZc == null) {
            this.hZc = new com.baidu.tbadk.k.c(getPageContext().getContext(), getNetRefreshListener());
            this.hZc.setTitle(null);
            this.hZc.setSubText(null);
            this.hZc.setButtonText(null);
            this.hZc.showRefreshButton();
            this.hZc.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.hZc.onChangeSkinType();
        this.hZc.attachView(this.jae.getRootView(), true);
        MessageManager.getInstance().registerListener(this.hWr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bFW() {
        this.jae.oD(true);
        if (this.hZc != null && this.hZc.isViewAttached()) {
            this.hZc.dettachView(this.jae.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.hWr);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bFV();
            return;
        }
        bFW();
        this.jae.clz();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.jae.setRefreshing(true);
        }
        this.jac.cancelLoadData();
        this.jac.c("frs", "frstab", "0", this.mFid);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = super.getTbPageTag();
        tbPageTag.locatePage = "4";
        return tbPageTag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean hasData() {
        return this.jae.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cAj())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cAj()) {
            if (topicList != null) {
                bw bwVar = new bw();
                bwVar.setTid(topicList.topic_tid + "");
                bwVar.b(topicList.video_info);
                bwVar.setFid(this.mFid);
                bwVar.zs(this.ebR);
                bwVar.zt(this.ebS);
                bwVar.zu(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bwVar.a(metaData);
                bwVar.cA(topicList.update_time.longValue());
                bwVar.setTitle(topicList.topic_desc);
                bwVar.zr(topicList.topic_user_name);
                bwVar.bgk();
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
        MessageManager.getInstance().unRegisterListener(this.hWr);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.au
    public void bkD() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.au
    public void bkE() {
    }
}
