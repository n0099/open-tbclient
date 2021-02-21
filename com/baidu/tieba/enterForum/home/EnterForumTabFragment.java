package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.g;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class EnterForumTabFragment extends BaseFragment implements g {
    private c iJw;
    private NewPagerSlidingTabBaseStrip.a iJx = new NewPagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.a
        public void t(View view, int i) {
            if (view != null && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.iJw != null) {
                if (EnterForumTabFragment.this.iJw.cwy() == i) {
                    EnterForumTabFragment.this.iJw.xF(i);
                } else if (i == 0) {
                    TiebaStatic.log(new ar("c13366").ap("obj_locate", 1));
                } else if (i > 0) {
                    TiebaStatic.log(new ar("c13366").ap("obj_locate", 3).dR("resource_id", EnterForumTabFragment.this.iJw.xG(i)));
                }
            }
        }
    };
    private CustomMessageListener iJy = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && EnterForumTabFragment.this.iJw != null) {
                if (EnterForumTabFragment.this.isPrimary()) {
                    EnterForumTabFragment.this.iJw.xF(EnterForumTabFragment.this.iJw.cwy());
                    return;
                }
                int cwy = EnterForumTabFragment.this.iJw.cwy();
                if (cwy == 0) {
                    TiebaStatic.log(new ar("c13366").ap("obj_locate", 1));
                } else if (cwy > 0) {
                    TiebaStatic.log(new ar("c13366").ap("obj_locate", 3).dR("resource_id", EnterForumTabFragment.this.iJw.xG(cwy)));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.iJw = new c(this);
        registerListener(this.iJy);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.iJw.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.iJw.a(this.iJx);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.iJw.auU();
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.iJw != null) {
            this.iJw.onActivityResult(i, i2, intent);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.iJw != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.iJw != null) {
            this.iJw.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (this.iJw != null && intent != null && intent.getExtras() != null && intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int Jl = this.iJw.Jl(stringExtra);
            if (this.iJw.cwt()) {
                if (this.iJw.xC(Jl != -1 ? Jl : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.iJw.Jk(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cVB().cVC();
        MessageManager.getInstance().unRegisterListener(this.iJy);
        if (this.iJw != null) {
            this.iJw.ajT();
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.iJw != null) {
            this.iJw.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            a(getActivity().getIntent(), null);
        }
        if (this.iJw != null) {
            this.iJw.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.3
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.iJw != null) {
            return this.iJw.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void C(Intent intent) {
        if (intent != null && this.iJw != null) {
            int Jl = this.iJw.Jl(intent.getStringExtra("sub_locate_type"));
            if (Jl == -1) {
                Jl = 0;
            }
            if (this.iJw.xC(Jl)) {
                intent.removeExtra("sub_locate_type");
            }
        }
    }
}
