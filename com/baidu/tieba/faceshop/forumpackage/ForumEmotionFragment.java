package com.baidu.tieba.faceshop.forumpackage;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.live.adp.framework.MessageConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.faceshop.forumpackage.adapter.c;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.tieba.faceshop.forumpackage.view.a;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.a {
    private a iYO;
    private c iYQ;
    private ForumEmotionModel iYP = null;
    private boolean gEY = true;
    private boolean isLoading = false;
    private boolean iWW = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && ForumEmotionFragment.this.iYP != null && ForumEmotionFragment.this.iYO != null && ForumEmotionFragment.this.iYO.cCG() != null && ForumEmotionFragment.this.iYO.cCG().getVisibility() == 0) {
                ForumEmotionFragment.this.iYP.a(ForumEmotionFragment.this);
            }
        }
    };
    private CustomMessageListener iYR = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ForumEmotionPackageData) && (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) != null && ForumEmotionFragment.this.iYQ != null) {
                ForumEmotionFragment.this.iYQ.a(forumEmotionPackageData);
            }
        }
    };
    private final com.baidu.tieba.faceshop.forumpackage.adapter.a iYS = new com.baidu.tieba.faceshop.forumpackage.adapter.a() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.3
        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void zA(int i) {
            ForumEmotionFragment.this.iYQ.notifyDataSetChanged();
            ForumEmotionFragment.this.iYP.a(ForumEmotionFragment.this);
        }

        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void cCR() {
            ForumEmotionFragment.this.iYQ.notifyDataSetChanged();
        }
    };
    private f.c flR = new f.c() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.iYP != null && !ForumEmotionFragment.this.isLoading) {
                ForumEmotionFragment.this.iYP.a(ForumEmotionFragment.this);
            }
        }
    };
    private BdListView.e WN = new BdListView.e() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.iYP != null && !ForumEmotionFragment.this.isLoading) {
                if (ForumEmotionFragment.this.iYP.hasMore()) {
                    ForumEmotionFragment.this.iYO.bUF();
                    ForumEmotionFragment.this.iYP.b(ForumEmotionFragment.this);
                    return;
                }
                ForumEmotionFragment.this.iYO.bUE();
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.iYO = new a(getPageContext(), getUniqueId());
        this.iYO.setListPullRefreshListener(this.flR);
        this.iYO.b(this.WN);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iYR);
        if (this.iYP == null) {
            this.iYP = new ForumEmotionModel(getPageContext());
        }
        this.iYQ = new c(getPageContext(), this.iYO.getListView(), this.iYP);
        this.iYQ.a(this.iYS);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iWW = arguments.getBoolean("need_check_login");
        }
        if (!this.iWW) {
            if (this.gEY && this.iYP != null) {
                this.iYP.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gEY && this.iYP != null) {
                this.iYP.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iYO.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iYO != null) {
            this.iYO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void a(final ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iYO.completePullRefresh();
        this.iYO.bVG();
        this.iYO.hideLoadingView();
        this.iYO.hideNoDataView();
        if (forumEmotionData != null) {
            this.iYO.c(forumEmotionData);
            this.iYO.cCX().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(forumEmotionData.activity_url)) {
                        be.bwv().b(ForumEmotionFragment.this.getPageContext(), new String[]{forumEmotionData.activity_url});
                    }
                }
            });
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.iZl = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new com.baidu.tieba.faceshop.forumpackage.data.a());
                }
                this.iYQ.setData(arrayList);
            }
            this.iYQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void b(ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iYO.bVG();
        this.iYO.hideNoDataView();
        if (forumEmotionData != null) {
            if (!x.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.iZl = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.iYQ.cA(arrayList);
            }
            this.iYQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void onFailed(String str) {
        this.isLoading = false;
        this.iYO.completePullRefresh();
        this.iYO.hideLoadingView();
        if (this.iYQ != null && this.iYQ.bHg() > 0) {
            l.showToast(getPageContext().getContext(), str);
        } else {
            this.iYO.showNoDataView();
        }
    }
}
