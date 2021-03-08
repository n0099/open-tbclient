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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
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
/* loaded from: classes7.dex */
public class FrsHottopicFragment extends BaseFragment implements ao, aq, d.a {
    private String eSQ;
    private String eSR;
    private com.baidu.tbadk.l.c jot;
    private HotRanklistModel kxD;
    private j kxE;
    private d kxF;
    private long mFid;
    private String mFrom;
    private CustomMessageListener jlI = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.jot != null && FrsHottopicFragment.this.jot.isViewAttached()) {
                FrsHottopicFragment.this.jot.rn(num.intValue());
            }
        }
    };
    private HotRanklistModel.a kxG = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.Xc();
            FrsHottopicFragment.this.kxF.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.kxE = jVar;
                FrsHottopicFragment.this.kxF.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.kxE));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.kxF.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bRH();
            }
        }
    };
    private CustomMessageListener jjr = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cFl();
    }

    private void cFl() {
        if (isPrimary()) {
            if (this.jot != null && this.jot.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jlI);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kxD = new HotRanklistModel(getPageContext());
        this.kxD.a(this.kxG);
        registerListener(this.jjr);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eSQ = arguments.getString("first_class_name");
            this.eSR = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.kxF = new d(this, inflate, getPageContext());
        this.kxF.b(getTbPageTag());
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
        TiebaStatic.log(new ar("c13008").v("fid", this.mFid).aq("obj_type", 2).aq("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCm() {
        this.kxF.cCm();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSD() {
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
        if (this.kxF != null) {
            this.kxF.onChangeSkinType();
        }
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.kxF.qV(false);
        showLoadingView(this.kxF.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.kxF.qV(true);
        hideLoadingView(this.kxF.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRH() {
        this.kxF.qV(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.jot == null) {
            this.jot = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jot.setTitle(null);
            this.jot.setSubText(null);
            this.jot.setButtonText(null);
            this.jot.showRefreshButton();
            this.jot.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jot.onChangeSkinType();
        this.jot.attachView(this.kxF.getRootView(), true);
        MessageManager.getInstance().registerListener(this.jlI);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        this.kxF.qV(true);
        if (this.jot != null && this.jot.isViewAttached()) {
            this.jot.dettachView(this.kxF.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.jlI);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bRH();
            return;
        }
        Xc();
        this.kxF.cCm();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.kxF.setRefreshing(true);
        }
        this.kxD.cancelLoadData();
        this.kxD.f("frs", "frstab", "0", this.mFid);
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
        return this.kxF.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cTG())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cTG()) {
            if (topicList != null) {
                cb cbVar = new cb();
                cbVar.setTid(topicList.topic_tid + "");
                cbVar.b(topicList.video_info);
                cbVar.setFid(this.mFid);
                cbVar.Au(this.eSQ);
                cbVar.Av(this.eSR);
                cbVar.Aw(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                cbVar.a(metaData);
                cbVar.dM(topicList.update_time.longValue());
                cbVar.setTitle(topicList.topic_desc);
                cbVar.At(topicList.topic_user_name);
                cbVar.bpA();
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
                cbVar.B(arrayList2);
                arrayList.add(cbVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jlI);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bup() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.aq
    public void buq() {
    }
}
