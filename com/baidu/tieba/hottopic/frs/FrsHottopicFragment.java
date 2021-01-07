package com.baidu.tieba.hottopic.frs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.n;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ao;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.hottopic.controller.HotRanklistModel;
import com.baidu.tieba.hottopic.data.j;
import com.baidu.tieba.hottopic.frs.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.Media;
import tbclient.TopicList.TopicList;
/* loaded from: classes8.dex */
public class FrsHottopicFragment extends BaseFragment implements ao, aq, d.a {
    private String eTO;
    private String eTP;
    private com.baidu.tbadk.l.c jlv;
    private HotRanklistModel krL;
    private j krM;
    private d krN;
    private long mFid;
    private String mFrom;
    private CustomMessageListener jiM = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.jlv != null && FrsHottopicFragment.this.jlv.isViewAttached()) {
                FrsHottopicFragment.this.jlv.sN(num.intValue());
            }
        }
    };
    private HotRanklistModel.a krO = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.Zj();
            FrsHottopicFragment.this.krN.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.krM = jVar;
                FrsHottopicFragment.this.krN.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.krM));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.krN.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bUI();
            }
        }
    };
    private CustomMessageListener jgu = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cHE();
    }

    private void cHE() {
        if (isPrimary()) {
            if (this.jlv != null && this.jlv.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jiM);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.krL = new HotRanklistModel(getPageContext());
        this.krL.a(this.krO);
        registerListener(this.jgu);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eTO = arguments.getString("first_class_name");
            this.eTP = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.krN = new d(this, inflate, getPageContext());
        this.krN.b(getTbPageTag());
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").w("fid", this.mFid).an("obj_type", 2).an("obj_locate", 2).dX("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.ao
    public void cEG() {
        this.krN.cEG();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bVF() {
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
        if (this.krN != null) {
            this.krN.onChangeSkinType();
        }
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.krN.qP(false);
        showLoadingView(this.krN.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.krN.qP(true);
        hideLoadingView(this.krN.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bUI() {
        this.krN.qP(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.jlv == null) {
            this.jlv = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jlv.setTitle(null);
            this.jlv.setSubText(null);
            this.jlv.setButtonText(null);
            this.jlv.showRefreshButton();
            this.jlv.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jlv.onChangeSkinType();
        this.jlv.attachView(this.krN.getRootView(), true);
        MessageManager.getInstance().registerListener(this.jiM);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Zj() {
        this.krN.qP(true);
        if (this.jlv != null && this.jlv.isViewAttached()) {
            this.jlv.dettachView(this.krN.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.jiM);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bUI();
            return;
        }
        Zj();
        this.krN.cEG();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.krN.setRefreshing(true);
        }
        this.krL.cancelLoadData();
        this.krL.g("frs", "frstab", "0", this.mFid);
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
        return this.krN.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(j jVar) {
        if (jVar == null || x.isEmpty(jVar.cVl())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cVl()) {
            if (topicList != null) {
                bz bzVar = new bz();
                bzVar.setTid(topicList.topic_tid + "");
                bzVar.b(topicList.video_info);
                bzVar.setFid(this.mFid);
                bzVar.Bh(this.eTO);
                bzVar.Bi(this.eTP);
                bzVar.Bj(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bzVar.a(metaData);
                bzVar.dG(topicList.update_time.longValue());
                bzVar.setTitle(topicList.topic_desc);
                bzVar.Bg(topicList.topic_user_name);
                bzVar.bta();
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
                bzVar.G(arrayList2);
                arrayList.add(bzVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jiM);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxM() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bxN() {
    }
}
