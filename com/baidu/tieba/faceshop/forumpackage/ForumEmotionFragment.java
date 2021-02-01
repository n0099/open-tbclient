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
    private a iZO;
    private c iZQ;
    private ForumEmotionModel iZP = null;
    private boolean gDb = true;
    private boolean isLoading = false;
    private boolean iXW = false;
    final CustomMessageListener mNetworkChangedMessageListener = new CustomMessageListener(MessageConfig.CMD_NETWORK_CHANGED) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.isNetWorkAvailable() && ForumEmotionFragment.this.iZP != null && ForumEmotionFragment.this.iZO != null && ForumEmotionFragment.this.iZO.czZ() != null && ForumEmotionFragment.this.iZO.czZ().getVisibility() == 0) {
                ForumEmotionFragment.this.iZP.a(ForumEmotionFragment.this);
            }
        }
    };
    private CustomMessageListener iZR = new CustomMessageListener(CmdConfigCustom.CMD_NOTIFY_EMOTION_CENTER) { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            ForumEmotionPackageData forumEmotionPackageData;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof ForumEmotionPackageData) && (forumEmotionPackageData = (ForumEmotionPackageData) customResponsedMessage.getData()) != null && ForumEmotionFragment.this.iZQ != null) {
                ForumEmotionFragment.this.iZQ.a(forumEmotionPackageData);
            }
        }
    };
    private final com.baidu.tieba.faceshop.forumpackage.adapter.a iZS = new com.baidu.tieba.faceshop.forumpackage.adapter.a() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.3
        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void ye(int i) {
            ForumEmotionFragment.this.iZQ.notifyDataSetChanged();
            ForumEmotionFragment.this.iZP.a(ForumEmotionFragment.this);
        }

        @Override // com.baidu.tieba.faceshop.forumpackage.adapter.a
        public void cAk() {
            ForumEmotionFragment.this.iZQ.notifyDataSetChanged();
        }
    };
    private f.c fjz = new f.c() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.4
        @Override // com.baidu.tbadk.core.view.f.c
        public void onListPullRefresh(boolean z) {
            if (ForumEmotionFragment.this.iZP != null && !ForumEmotionFragment.this.isLoading) {
                ForumEmotionFragment.this.iZP.a(ForumEmotionFragment.this);
            }
        }
    };
    private BdListView.e WH = new BdListView.e() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.5
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (ForumEmotionFragment.this.iZP != null && !ForumEmotionFragment.this.isLoading) {
                if (ForumEmotionFragment.this.iZP.hasMore()) {
                    ForumEmotionFragment.this.iZO.bRr();
                    ForumEmotionFragment.this.iZP.b(ForumEmotionFragment.this);
                    return;
                }
                ForumEmotionFragment.this.iZO.bRq();
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
        this.iZO = new a(getPageContext(), getUniqueId());
        this.iZO.setListPullRefreshListener(this.fjz);
        this.iZO.b(this.WH);
        registerListener(this.mNetworkChangedMessageListener);
        registerListener(this.iZR);
        if (this.iZP == null) {
            this.iZP = new ForumEmotionModel(getPageContext());
        }
        this.iZQ = new c(getPageContext(), this.iZO.getListView(), this.iZP);
        this.iZQ.a(this.iZS);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.iXW = arguments.getBoolean("need_check_login");
        }
        if (!this.iXW) {
            if (this.gDb && this.iZP != null) {
                this.iZP.a(this);
                this.isLoading = true;
                this.gDb = false;
            }
        } else if (bh.checkUpIsLogin(getPageContext().getPageActivity())) {
            if (this.gDb && this.iZP != null) {
                this.iZP.a(this);
                this.isLoading = true;
                this.gDb = false;
            }
        } else {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig((Context) getPageContext().getPageActivity(), true);
            loginActivityConfig.setJumpToAfterDestroy(1);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
            getPageContext().getPageActivity().finish();
        }
        return this.iZO.getView();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iZO != null) {
            this.iZO.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void a(final ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iZO.completePullRefresh();
        this.iZO.bSr();
        this.iZO.hideLoadingView();
        this.iZO.hideNoDataView();
        if (forumEmotionData != null) {
            this.iZO.c(forumEmotionData);
            this.iZO.cAq().setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.forumpackage.ForumEmotionFragment.6
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
                    cVar.jal = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                if (arrayList.isEmpty()) {
                    arrayList.add(new com.baidu.tieba.faceshop.forumpackage.data.a());
                }
                this.iZQ.setData(arrayList);
            }
            this.iZQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void b(ForumEmotionData forumEmotionData) {
        this.isLoading = false;
        this.iZO.bSr();
        this.iZO.hideNoDataView();
        if (forumEmotionData != null) {
            if (!y.isEmpty(forumEmotionData.rank_pkg_list)) {
                ArrayList arrayList = new ArrayList();
                for (ForumEmotionPackageData forumEmotionPackageData : forumEmotionData.rank_pkg_list) {
                    com.baidu.tieba.faceshop.forumpackage.data.c cVar = new com.baidu.tieba.faceshop.forumpackage.data.c();
                    cVar.jal = forumEmotionPackageData;
                    arrayList.add(cVar);
                }
                this.iZQ.cv(arrayList);
            }
            this.iZQ.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.faceshop.forumpackage.model.ForumEmotionModel.a
    public void onFailed(String str) {
        this.isLoading = false;
        this.iZO.completePullRefresh();
        this.iZO.hideLoadingView();
        if (this.iZQ != null && this.iZQ.bDF() > 0) {
            l.showToast(getPageContext().getContext(), str);
        } else {
            this.iZO.showNoDataView();
        }
    }
}
