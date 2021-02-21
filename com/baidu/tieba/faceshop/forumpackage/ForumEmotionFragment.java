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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.core.view.f;
import com.baidu.tieba.faceshop.forumpackage.adapter.c;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionData;
import com.baidu.tieba.faceshop.forumpackage.data.ForumEmotionPackageData;
import com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel;
import com.baidu.tieba.faceshop.forumpackage.view.a;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.a {
    private a jac;
    private c jae;
    private ForumEmotionModel jad = null;
    private boolean gDp = true;
    private boolean isLoading = false;
    private boolean iYk = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && ForumEmotionFragment.this.jad != null && ForumEmotionFragment.this.jac != null && ForumEmotionFragment.this.jac.cAg() != null && ForumEmotionFragment.this.jac.cAg().getVisibility() == 0) {
                ForumEmotionFragment.this.jad.a(ForumEmotionFragment.this);
            }
        }
    };
    private CustomMessageListener jaf = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ForumEmotionPackageData) && (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) != null && ForumEmotionFragment.this.jae != null) {
                ForumEmotionFragment.this.jae.a(forumEmotionPackageData);
            }
        }
    };
    private final com.baidu.tieba.faceshop.forumpackage.adapter.a jag = new com.baidu.tieba.faceshop.forumpackage.adapter.a() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.3
        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void ye(int i) {
            ForumEmotionFragment.this.jae.notifyDataSetChanged();
            ForumEmotionFragment.this.jad.a(ForumEmotionFragment.this);
        }

        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void cAr() {
            ForumEmotionFragment.this.jae.notifyDataSetChanged();
        }
    };
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.jad != null && !ForumEmotionFragment.this.isLoading) {
                ForumEmotionFragment.this.jad.a(ForumEmotionFragment.this);
            }
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.jad != null && !ForumEmotionFragment.this.isLoading) {
                if (ForumEmotionFragment.this.jad.hasMore()) {
                    ForumEmotionFragment.this.jac.bRy();
                    ForumEmotionFragment.this.jad.b(ForumEmotionFragment.this);
                    return;
                }
                ForumEmotionFragment.this.jac.bRx();
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
        this.jac = new a(getPageContext(), getUniqueId());
        this.jac.setListPullRefreshListener(this.fjz);
        this.jac.b(this.WH);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.jaf);
        if (this.jad == null) {
            this.jad = new ForumEmotionModel(getPageContext());
        }
        this.jae = new c(getPageContext(), this.jac.getListView(), this.jad);
        this.jae.a(this.jag);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iYk = arguments.getBoolean("need_check_login");
        }
        if (!this.iYk) {
            if (this.gDp && this.jad != null) {
                this.jad.a(this);
                this.isLoading = true;
                this.gDp = false;
            }
        } else if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gDp && this.jad != null) {
                this.jad.a(this);
                this.isLoading = true;
                this.gDp = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.jac.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jac != null) {
            this.jac.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void a(final ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.jac.completePullRefresh();
        this.jac.bSy();
        this.jac.hideLoadingView();
        this.jac.hideNoDataView();
        if (forumEmotionData != null) {
            this.jac.c(forumEmotionData);
            this.jac.cAx().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(forumEmotionData.activity_url)) {
                        bf.bsV().b(ForumEmotionFragment.this.getPageContext(), new String[]{forumEmotionData.activity_url});
                    }
                }
            });
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.jaz = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new com.baidu.tieba.faceshop.forumpackage.data.a());
                }
                this.jae.setData(arrayList);
            }
            this.jae.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void b(ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.jac.bSy();
        this.jac.hideNoDataView();
        if (forumEmotionData != null) {
            if (!y.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.jaz = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.jae.cv(arrayList);
            }
            this.jae.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void onFailed(String str) {
        this.isLoading = false;
        this.jac.completePullRefresh();
        this.jac.hideLoadingView();
        if (this.jae != null && this.jae.bDF() > 0) {
            l.showToast(getPageContext().getContext(), str);
        } else {
            this.jac.showNoDataView();
        }
    }
}
