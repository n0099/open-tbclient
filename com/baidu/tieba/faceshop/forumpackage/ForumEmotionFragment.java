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
/* loaded from: classes8.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.a {
    private a iUh;
    private c iUj;
    private ForumEmotionModel iUi = null;
    private boolean gAr = true;
    private boolean isLoading = false;
    private boolean iSp = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && ForumEmotionFragment.this.iUi != null && ForumEmotionFragment.this.iUh != null && ForumEmotionFragment.this.iUh.cyO() != null && ForumEmotionFragment.this.iUh.cyO().getVisibility() == 0) {
                ForumEmotionFragment.this.iUi.a(ForumEmotionFragment.this);
            }
        }
    };
    private CustomMessageListener iUk = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ForumEmotionPackageData) && (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) != null && ForumEmotionFragment.this.iUj != null) {
                ForumEmotionFragment.this.iUj.a(forumEmotionPackageData);
            }
        }
    };
    private final com.baidu.tieba.faceshop.forumpackage.adapter.a iUl = new com.baidu.tieba.faceshop.forumpackage.adapter.a() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.3
        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void xU(int i) {
            ForumEmotionFragment.this.iUj.notifyDataSetChanged();
            ForumEmotionFragment.this.iUi.a(ForumEmotionFragment.this);
        }

        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void cyZ() {
            ForumEmotionFragment.this.iUj.notifyDataSetChanged();
        }
    };
    private f.c fhg = new f.c() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.iUi != null && !ForumEmotionFragment.this.isLoading) {
                ForumEmotionFragment.this.iUi.a(ForumEmotionFragment.this);
            }
        }
    };
    private BdListView.e WL = new BdListView.e() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.iUi != null && !ForumEmotionFragment.this.isLoading) {
                if (ForumEmotionFragment.this.iUi.hasMore()) {
                    ForumEmotionFragment.this.iUh.bQN();
                    ForumEmotionFragment.this.iUi.b(ForumEmotionFragment.this);
                    return;
                }
                ForumEmotionFragment.this.iUh.bQM();
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
        this.iUh = new a(getPageContext(), getUniqueId());
        this.iUh.setListPullRefreshListener(this.fhg);
        this.iUh.b(this.WL);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iUk);
        if (this.iUi == null) {
            this.iUi = new ForumEmotionModel(getPageContext());
        }
        this.iUj = new c(getPageContext(), this.iUh.getListView(), this.iUi);
        this.iUj.a(this.iUl);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iSp = arguments.getBoolean("need_check_login");
        }
        if (!this.iSp) {
            if (this.gAr && this.iUi != null) {
                this.iUi.a(this);
                this.isLoading = true;
                this.gAr = false;
            }
        } else if (bg.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gAr && this.iUi != null) {
                this.iUi.a(this);
                this.isLoading = true;
                this.gAr = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iUh.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iUh != null) {
            this.iUh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void a(final ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iUh.completePullRefresh();
        this.iUh.bRO();
        this.iUh.hideLoadingView();
        this.iUh.hideNoDataView();
        if (forumEmotionData != null) {
            this.iUh.c(forumEmotionData);
            this.iUh.czf().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(forumEmotionData.activity_url)) {
                        be.bsB().b(ForumEmotionFragment.this.getPageContext(), new String[]{forumEmotionData.activity_url});
                    }
                }
            });
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.iUE = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new com.baidu.tieba.faceshop.forumpackage.data.a());
                }
                this.iUj.setData(arrayList);
            }
            this.iUj.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void b(ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iUh.bRO();
        this.iUh.hideNoDataView();
        if (forumEmotionData != null) {
            if (!x.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.iUE = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.iUj.cA(arrayList);
            }
            this.iUj.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void onFailed(String str) {
        this.isLoading = false;
        this.iUh.completePullRefresh();
        this.iUh.hideLoadingView();
        if (this.iUj != null && this.iUj.bDn() > 0) {
            l.showToast(getPageContext().getContext(), str);
        } else {
            this.iUh.showNoDataView();
        }
    }
}
