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
/* loaded from: classes8.dex */
public class ForumEmotionFragment extends BaseFragment implements ForumEmotionModel.a {
    private a jbL;
    private c jbN;
    private ForumEmotionModel jbM = null;
    private boolean gEY = true;
    private boolean isLoading = false;
    private boolean iZT = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && ForumEmotionFragment.this.jbM != null && ForumEmotionFragment.this.jbL != null && ForumEmotionFragment.this.jbL.cAm() != null && ForumEmotionFragment.this.jbL.cAm().getVisibility() == 0) {
                ForumEmotionFragment.this.jbM.a(ForumEmotionFragment.this);
            }
        }
    };
    private CustomMessageListener jbO = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ForumEmotionPackageData) && (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) != null && ForumEmotionFragment.this.jbN != null) {
                ForumEmotionFragment.this.jbN.a(forumEmotionPackageData);
            }
        }
    };
    private final com.baidu.tieba.faceshop.forumpackage.adapter.a jbP = new com.baidu.tieba.faceshop.forumpackage.adapter.a() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.3
        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void yf(int i) {
            ForumEmotionFragment.this.jbN.notifyDataSetChanged();
            ForumEmotionFragment.this.jbM.a(ForumEmotionFragment.this);
        }

        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void cAx() {
            ForumEmotionFragment.this.jbN.notifyDataSetChanged();
        }
    };
    private f.c fkY = new f.c() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.jbM != null && !ForumEmotionFragment.this.isLoading) {
                ForumEmotionFragment.this.jbM.a(ForumEmotionFragment.this);
            }
        }
    };
    private BdListView.e Yb = new BdListView.e() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.jbM != null && !ForumEmotionFragment.this.isLoading) {
                if (ForumEmotionFragment.this.jbM.hasMore()) {
                    ForumEmotionFragment.this.jbL.bRE();
                    ForumEmotionFragment.this.jbM.b(ForumEmotionFragment.this);
                    return;
                }
                ForumEmotionFragment.this.jbL.bRD();
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
        this.jbL = new a(getPageContext(), getUniqueId());
        this.jbL.setListPullRefreshListener(this.fkY);
        this.jbL.b(this.Yb);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.jbO);
        if (this.jbM == null) {
            this.jbM = new ForumEmotionModel(getPageContext());
        }
        this.jbN = new c(getPageContext(), this.jbL.getListView(), this.jbM);
        this.jbN.a(this.jbP);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iZT = arguments.getBoolean("need_check_login");
        }
        if (!this.iZT) {
            if (this.gEY && this.jbM != null) {
                this.jbM.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gEY && this.jbM != null) {
                this.jbM.a(this);
                this.isLoading = true;
                this.gEY = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.jbL.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.jbL != null) {
            this.jbL.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void a(final ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.jbL.completePullRefresh();
        this.jbL.bSE();
        this.jbL.hideLoadingView();
        this.jbL.hideNoDataView();
        if (forumEmotionData != null) {
            this.jbL.c(forumEmotionData);
            this.jbL.cAD().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!TextUtils.isEmpty(forumEmotionData.activity_url)) {
                        bf.bsY().b(ForumEmotionFragment.this.getPageContext(), new String[]{forumEmotionData.activity_url});
                    }
                }
            });
            if (forumEmotionData.rank_pkg_list != null) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.jci = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new com.baidu.tieba.faceshop.forumpackage.data.a());
                }
                this.jbN.setData(arrayList);
            }
            this.jbN.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void b(ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.jbL.bSE();
        this.jbL.hideNoDataView();
        if (forumEmotionData != null) {
            if (!y.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.jci = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.jbN.cv(arrayList);
            }
            this.jbN.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void onFailed(String str) {
        this.isLoading = false;
        this.jbL.completePullRefresh();
        this.jbL.hideLoadingView();
        if (this.jbN != null && this.jbN.bDI() > 0) {
            l.showToast(getPageContext().getContext(), str);
        } else {
            this.jbL.showNoDataView();
        }
    }
}
