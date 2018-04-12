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
import com.baidu.tbadk.core.view.e;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.ai;
import com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel;
import java.util.List;
/* loaded from: classes3.dex */
public class FrsGameRecommendFragment extends BaseFragment implements ai {
    private com.baidu.tieba.frs.gamerecommend.c.a did;
    private AlaGameRecommendModel die;
    private String mForumId;
    private String mForumName;
    private boolean bvq = true;
    private CustomMessageListener bnc = new CustomMessageListener(0) { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && !TextUtils.isEmpty((String) customResponsedMessage.getData())) {
                String[] split = ((String) customResponsedMessage.getData()).split("_");
                if (split.length == 2 && "FrsGameRecommend".equals(split[0]) && 11 == b.g(split[1], 0)) {
                    FrsGameRecommendFragment.this.Ql();
                }
            }
        }
    };
    private AlaGameRecommendModel.a dif = new AlaGameRecommendModel.a() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.2
        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void a(boolean z, List<h> list) {
            FrsGameRecommendFragment.this.did.completePullRefresh();
            FrsGameRecommendFragment.this.hideNetRefreshView(FrsGameRecommendFragment.this.did.asR());
            FrsGameRecommendFragment.this.hideLoadingView(FrsGameRecommendFragment.this.did.asR());
            FrsGameRecommendFragment.this.did.setData(list, z);
        }

        @Override // com.baidu.tieba.frs.gamerecommend.model.AlaGameRecommendModel.a
        public void b(int i, String str, boolean z) {
            FrsGameRecommendFragment.this.did.completePullRefresh();
            if (!z) {
                FrsGameRecommendFragment.this.showNetRefreshView(FrsGameRecommendFragment.this.did.asR(), str, false);
            } else {
                FrsGameRecommendFragment.this.showToast(d.k.card_vr_video_load_failed);
            }
            FrsGameRecommendFragment.this.did.PO();
        }
    };
    private e.b anZ = new e.b() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.3
        @Override // com.baidu.tbadk.core.view.e.b
        public void aO(boolean z) {
            if (j.gP()) {
                if (FrsGameRecommendFragment.this.die != null) {
                    FrsGameRecommendFragment.this.die.OT();
                    return;
                }
                return;
            }
            FrsGameRecommendFragment.this.showToast(d.k.neterror);
            FrsGameRecommendFragment.this.did.completePullRefresh();
        }
    };
    private BdListView.e mOnScrollToBottomListener = new BdListView.e() { // from class: com.baidu.tieba.frs.gamerecommend.FrsGameRecommendFragment.4
        @Override // com.baidu.adp.widget.ListView.BdListView.e
        public void onScrollToBottom() {
            if (FrsGameRecommendFragment.this.die != null) {
                FrsGameRecommendFragment.this.die.Po();
            }
        }
    };

    public static FrsGameRecommendFragment aU(String str, String str2) {
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
            this.did = new com.baidu.tieba.frs.gamerecommend.c.a(getPageContext(), this.mForumId, this.mForumName);
            this.did.a(this.anZ);
            this.did.a(this.mOnScrollToBottomListener);
            MessageManager.getInstance().registerListener(2001446, this.bnc);
            this.die = new AlaGameRecommendModel(this.mForumId, this.dif);
        }
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.did.getRootView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ql() {
        this.did.Ql();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (this.die != null) {
            this.die.OT();
        }
    }

    @Override // com.baidu.tieba.frs.ai
    public NavigationBar Rg() {
        return this.did.Rg();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary() && this.bvq && this.die != null) {
            this.die.OT();
            this.bvq = false;
            showLoadingView(this.did.asR());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        if (this.did != null) {
            this.did.onDestroy();
        }
        if (this.die != null) {
            this.die.onDestroy();
        }
        if (this.bnc != null) {
            MessageManager.getInstance().unRegisterListener(this.bnc);
        }
    }
}
