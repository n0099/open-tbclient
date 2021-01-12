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
/* loaded from: classes7.dex */
public class FrsHottopicFragment extends BaseFragment implements ao, aq, d.a {
    private String ePd;
    private String ePe;
    private com.baidu.tbadk.l.c jgO;
    private HotRanklistModel kng;
    private j knh;
    private d kni;
    private long mFid;
    private String mFrom;
    private CustomMessageListener jee = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null && FrsHottopicFragment.this.jgO != null && FrsHottopicFragment.this.jgO.isViewAttached()) {
                FrsHottopicFragment.this.jgO.rh(num.intValue());
            }
        }
    };
    private HotRanklistModel.a knj = new HotRanklistModel.a() { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.2
        @Override // com.baidu.tieba.hottopic.controller.HotRanklistModel.a
        public void a(boolean z, j jVar, int i, String str) {
            FrsHottopicFragment.this.hideLoadingView();
            FrsHottopicFragment.this.Vq();
            FrsHottopicFragment.this.kni.setRefreshing(false);
            if (z) {
                FrsHottopicFragment.this.knh = jVar;
                FrsHottopicFragment.this.kni.setData(FrsHottopicFragment.this.a(FrsHottopicFragment.this.knh));
                if (!FrsHottopicFragment.this.hasData()) {
                    FrsHottopicFragment.this.kni.showNoDataView();
                }
            } else if (!FrsHottopicFragment.this.hasData()) {
                FrsHottopicFragment.this.bQQ();
            }
        }
    };
    private CustomMessageListener jbN = new CustomMessageListener(CmdConfigCustom.CMD_FRS_TAB_CLICK) { // from class: com.baidu.tieba.hottopic.frs.FrsHottopicFragment.3
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
        cDM();
    }

    private void cDM() {
        if (isPrimary()) {
            if (this.jgO != null && this.jgO.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.jee);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.kng = new HotRanklistModel(getPageContext());
        this.kng.a(this.knj);
        registerListener(this.jbN);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mFid = com.baidu.adp.lib.f.b.toLong(arguments.getString("fid"), 0L);
            this.mFrom = arguments.getString("from");
            this.ePd = arguments.getString("first_class_name");
            this.ePe = arguments.getString("second_class_name");
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.frs_hottopic_fragment, (ViewGroup) null);
        this.kni = new d(this, inflate, getPageContext());
        this.kni.b(getTbPageTag());
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
        TiebaStatic.log(new com.baidu.tbadk.core.util.aq("c13008").w("fid", this.mFid).an("obj_type", 2).an("obj_locate", 2).dW("uid", TbadkCoreApplication.getCurrentAccount()));
    }

    @Override // com.baidu.tieba.frs.ao
    public void cAO() {
        this.kni.cAO();
    }

    @Override // com.baidu.tieba.frs.ao
    public void bRN() {
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
        if (this.kni != null) {
            this.kni.onChangeSkinType();
        }
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.onChangeSkinType();
        }
    }

    private void showLoadingView() {
        this.kni.qL(false);
        showLoadingView(this.kni.getRootView(), true, getResources().getDimensionPixelSize(R.dimen.ds250));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hideLoadingView() {
        this.kni.qL(true);
        hideLoadingView(this.kni.getRootView());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bQQ() {
        this.kni.qL(false);
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_FRS_EXPAND_BAR_HEADER, true));
        if (this.jgO == null) {
            this.jgO = new com.baidu.tbadk.l.c(getPageContext().getContext(), getNetRefreshListener());
            this.jgO.setTitle(null);
            this.jgO.setSubText(null);
            this.jgO.setButtonText(null);
            this.jgO.showRefreshButton();
            this.jgO.getAttachedView().setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        }
        this.jgO.onChangeSkinType();
        this.jgO.attachView(this.kni.getRootView(), true);
        MessageManager.getInstance().registerListener(this.jee);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vq() {
        this.kni.qL(true);
        if (this.jgO != null && this.jgO.isViewAttached()) {
            this.jgO.dettachView(this.kni.getRootView());
        }
        MessageManager.getInstance().unRegisterListener(this.jee);
    }

    public void refresh() {
        if (!com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
            bQQ();
            return;
        }
        Vq();
        this.kni.cAO();
        if (!hasData()) {
            showLoadingView();
        } else {
            this.kni.setRefreshing(true);
        }
        this.kng.cancelLoadData();
        this.kng.g("frs", "frstab", "0", this.mFid);
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
        return this.kni.hasData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public List<n> a(j jVar) {
        if (jVar == null || x.isEmpty(jVar.cRt())) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (TopicList topicList : jVar.cRt()) {
            if (topicList != null) {
                bz bzVar = new bz();
                bzVar.setTid(topicList.topic_tid + "");
                bzVar.b(topicList.video_info);
                bzVar.setFid(this.mFid);
                bzVar.zW(this.ePd);
                bzVar.zX(this.ePe);
                bzVar.zY(topicList.topic_h5_url);
                MetaData metaData = new MetaData();
                metaData.setUserName(topicList.topic_name);
                bzVar.a(metaData);
                bzVar.dG(topicList.update_time.longValue());
                bzVar.setTitle(topicList.topic_desc);
                bzVar.zV(topicList.topic_user_name);
                bzVar.bpg();
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
                bzVar.B(arrayList2);
                arrayList.add(bzVar);
            }
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        MessageManager.getInstance().unRegisterListener(this.jee);
        super.onDestroy();
    }

    @Override // com.baidu.tieba.frs.aq
    public void btS() {
        refresh();
    }

    @Override // com.baidu.tieba.frs.aq
    public void btT() {
    }
}
