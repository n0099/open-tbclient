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
/* loaded from: classes8.dex */
public class FrsHottopicFragment extends BaseFragment implements ao, aq, d.a {
    private String eRp;
    private String eRq;
    private com.baidu.tbadk.l.c jmK;
    private HotRanklistModel kvB;
    private j kvC;
    private d kvD;
    private long mFid;
    private String mFrom;
    private CustomMessageListener jjZ = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.jmK != null && FrsHottopicFragment.this.jmK.isViewAttached()) {
                FrsHottopicFragment.this.jmK.rm(num.intValue());
            }
        }
    };
    private HotRanklistModel.a kvE = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.WZ();
            FrsHottopicFragment.this.kvD.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.kvC = jVar;
                FrsHottopicFragment.this.kvD.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.kvC));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.kvD.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bRB();
            }
        }
    };
    private CustomMessageListener jhH = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cFf();
    }

    private void cFf() {
        if (isPrimary()) {
            if (this.jmK != null && this.jmK.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjZ);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kvB = new HotRanklistModel(getPageContext());
        this.kvB.a(this.kvE);
        registerListener(this.jhH);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.eRp = arguments.getString("first_class_name");
            this.eRq = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.kvD = new d(this, inflate, getPageContext());
        this.kvD.b(getTbPageTag());
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
        TiebaStatic.log(new ar("c13008").v("fid", this.mFid).ap("obj_type", 2).ap("obj_locate", 2).dR("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.ao
    public void cCg() {
        this.kvD.cCg();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSx() {
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
        if (this.kvD != null) {
            this.kvD.onChangeSkinType();
        }
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.kvD.qV(false);
        showLoadingView(this.kvD.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.kvD.qV(true);
        hideLoadingView(this.kvD.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRB() {
        this.kvD.qV(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.jmK == null) {
            this.jmK = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmK.setTitle(null);
            this.jmK.setSubText(null);
            this.jmK.setButtonText(null);
            this.jmK.showRefreshButton();
            this.jmK.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jmK.onChangeSkinType();
        this.jmK.attachView(this.kvD.getRootView(), true);
        MessageManager.getInstance().registerListener(this.jjZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.kvD.qV(true);
        if (this.jmK != null && this.jmK.isViewAttached()) {
            this.jmK.dettachView(this.kvD.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.jjZ);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bRB();
            return;
        }
        WZ();
        this.kvD.cCg();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.kvD.setRefreshing(true);
        }
        this.kvB.cancelLoadData();
        this.kvB.f("frs", "frstab", "0", this.mFid);
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
        return this.kvD.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cTz())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cTz()) {
            if (topicList != null) {
                cb cbVar = new cb();
                cbVar.setTid(topicList.topic_tid + "");
                cbVar.b(topicList.video_info);
                cbVar.setFid(this.mFid);
                cbVar.An(this.eRp);
                cbVar.Ao(this.eRq);
                cbVar.Ap(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                cbVar.a(metaData);
                cbVar.dM(topicList.update_time.longValue());
                cbVar.setTitle(topicList.topic_desc);
                cbVar.Am(topicList.topic_user_name);
                cbVar.bpy();
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
        MessageManager.getInstance().unRegisterListener(this.jjZ);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bum() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.aq
    public void bun() {
    }
}
