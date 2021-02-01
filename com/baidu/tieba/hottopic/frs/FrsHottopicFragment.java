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
    private com.baidu.tbadk.l.c jmw;
    private HotRanklistModel kvn;
    private j kvo;
    private d kvp;
    private long mFid;
    private String mFrom;
    private CustomMessageListener jjL = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.jmw != null && FrsHottopicFragment.this.jmw.isViewAttached()) {
                FrsHottopicFragment.this.jmw.rm(num.intValue());
            }
        }
    };
    private HotRanklistModel.a kvq = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.WZ();
            FrsHottopicFragment.this.kvp.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.kvo = jVar;
                FrsHottopicFragment.this.kvp.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.kvo));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.kvp.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bRu();
            }
        }
    };
    private CustomMessageListener jht = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cEY();
    }

    private void cEY() {
        if (isPrimary()) {
            if (this.jmw != null && this.jmw.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jjL);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kvn = new HotRanklistModel(getPageContext());
        this.kvn.a(this.kvq);
        registerListener(this.jht);
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
        this.kvp = new d(this, inflate, getPageContext());
        this.kvp.b(getTbPageTag());
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
    public void cBZ() {
        this.kvp.cBZ();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bSq() {
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
        if (this.kvp != null) {
            this.kvp.onChangeSkinType();
        }
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.kvp.qV(false);
        showLoadingView(this.kvp.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.kvp.qV(true);
        hideLoadingView(this.kvp.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bRu() {
        this.kvp.qV(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.jmw == null) {
            this.jmw = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jmw.setTitle(null);
            this.jmw.setSubText(null);
            this.jmw.setButtonText(null);
            this.jmw.showRefreshButton();
            this.jmw.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jmw.onChangeSkinType();
        this.jmw.attachView(this.kvp.getRootView(), true);
        MessageManager.getInstance().registerListener(this.jjL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void WZ() {
        this.kvp.qV(true);
        if (this.jmw != null && this.jmw.isViewAttached()) {
            this.jmw.dettachView(this.kvp.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.jjL);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bRu();
            return;
        }
        WZ();
        this.kvp.cBZ();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.kvp.setRefreshing(true);
        }
        this.kvn.cancelLoadData();
        this.kvn.f("frs", "frstab", "0", this.mFid);
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
        return this.kvp.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(j jVar) {
        if (jVar == null || y.isEmpty(jVar.cTs())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cTs()) {
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
        MessageManager.getInstance().unRegisterListener(this.jjL);
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
