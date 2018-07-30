package com.baidu.tieba.frs.gamerecommend;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.b;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.adp.widget.ListView.h;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.g;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ak;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ak {
    private com.baidu.tieba.frs.gamerecommend.c.a dyr;
    private AlaGameRecommendModel dys;
    private String mForumId;
    private String mForumName;
    private CustomMessageListener bxx = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.g(split[1], 0)) {
                    FrsGameRecommendFragment.this.Ui();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dyt = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.dyr.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.dyr.ayf());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.dyr.ayf());
            FrsGameRecommendFragment.this.dyr.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.dyr.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.dyr.ayf(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(d.j.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.dyr.TL();
        }
    };
    private g.b aww = new g.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.g.b
        public void aS(boolean z) {
            if (j.jE()) {
                if (FrsGameRecommendFragment.this.dys != null) {
                    FrsGameRecommendFragment.this.dys.SS();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(d.j.neterror);
            FrsGameRecommendFragment.this.dyr.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.dys != null) {
                FrsGameRecommendFragment.this.dys.Tn();
            }
        }
    };

    public static FrsGameRecommendFragment be(String str, String str2) {
        FrsGameRecommendFragment frsGameRecommendFragment = new FrsGameRecommendFragment();
        Bundle bundle = new Bundle();
        bundle.putString("forum_id", str);
        bundle.putString("forum_name", str2);
        frsGameRecommendFragment.setArguments(bundle);
        return frsGameRecommendFragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.mForumId = arguments.getString("forum_id");
            this.mForumName = arguments.getString("forum_name");
            this.dyr = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.dyr.a(this.aww);
            this.dyr.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bxx);
            this.dys = new AlaGameRecommendModel(this.mForumId, this.dyt);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.dyr.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ui() {
        this.dyr.Ui();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.dys != null) {
            this.dys.SS();
        }
    }

    @Override // com.baidu.tieba.frs.ak
    public NavigationBar Vf() {
        return this.dyr.Vf();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.dys != null) {
            if (this.dys.hasData()) {
                Ui();
                return;
            }
            this.dys.SS();
            showLoadingView(this.dyr.ayf());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.dyr != null) {
            this.dyr.onDestroy();
        }
        if (this.dys != null) {
            this.dys.onDestroy();
        }
        if (this.bxx != null) {
            MessageManager.getInstance().unRegisterListener(this.bxx);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.dyr != null) {
            this.dyr.onChangeSkinType(i);
        }
    }
}
