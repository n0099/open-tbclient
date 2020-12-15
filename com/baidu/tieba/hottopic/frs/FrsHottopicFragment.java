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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ar;
import com.baidu.tieba.frs.at;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.frs.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes21.dex */
public class FrsHottopicFragment extends BaseFragment implements ar, at, d.a {
    private String eJU;
    private String eJV;
    private com.baidu.tbadk.l.c iZi;
    private j keA;
    private d keB;
    private HotRanklistModel kez;
    private long mFid;
    private String mFrom;
    private CustomMessageListener iWz = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.iZi != null && FrsHottopicFragment.this.iZi.isViewAttached()) {
                FrsHottopicFragment.this.iZi.sB(num.intValue());
            }
        }
    };
    private HotRanklistModel.a keC = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.Yb();
            FrsHottopicFragment.this.keB.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.keA = jVar;
                FrsHottopicFragment.this.keB.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.keA));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.keB.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bSf();
            }
        }
    };
    private CustomMessageListener iUj = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cEI();
    }

    private void cEI() {
        if (isPrimary()) {
            if (this.iZi != null && this.iZi.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.iWz);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kez = new HotRanklistModel(getPageContext());
        this.kez.a(this.keC);
        registerListener(this.iUj);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eJU = arguments.getString("first_class_name");
            this.eJV = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.keB = new d(this, inflate, getPageContext());
        this.keB.b(getTbPageTag());
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.ar("c13008").w("fid", this.mFid).al("obj_type", 2).al("obj_locate", 2).dY("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.ar
    public void cBM() {
        this.keB.cBM();
    }

    @Override // com.baidu.tieba.frs.ar
    public void bTa() {
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
        if (this.keB != null) {
            this.keB.onChangeSkinType();
        }
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.keB.qr(false);
        showLoadingView(this.keB.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.keB.qr(true);
        hideLoadingView(this.keB.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bSf() {
        this.keB.qr(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.iZi == null) {
            this.iZi = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.iZi.setTitle(null);
            this.iZi.setSubText(null);
            this.iZi.setButtonText(null);
            this.iZi.showRefreshButton();
            this.iZi.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.iZi.onChangeSkinType();
        this.iZi.attachView(this.keB.getRootView(), true);
        MessageManager.getInstance().registerListener(this.iWz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yb() {
        this.keB.qr(true);
        if (this.iZi != null && this.iZi.isViewAttached()) {
            this.iZi.dettachView(this.keB.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.iWz);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bSf();
            return;
        }
        Yb();
        this.keB.cBM();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.keB.setRefreshing(true);
        }
        this.kez.cancelLoadData();
        this.kez.g("frs", "frstab", "0", this.mFid);
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
        return this.keB.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<q> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cSe())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cSe()) {
            if (topicList != null) {
                by byVar = new by();
                byVar.setTid(topicList.topic_tid + "");
                byVar.b(topicList.video_info);
                byVar.setFid(this.mFid);
                byVar.Bj(this.eJU);
                byVar.Bk(this.eJV);
                byVar.Bl(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                byVar.a(metaData);
                byVar.dG(topicList.update_time.longValue());
                byVar.setTitle(topicList.topic_desc);
                byVar.Bi(topicList.topic_user_name);
                byVar.bqx();
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
                byVar.G(arrayList2);
                arrayList.add(byVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.iWz);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.at
    public void bvq() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.at
    public void bvr() {
    }
}
