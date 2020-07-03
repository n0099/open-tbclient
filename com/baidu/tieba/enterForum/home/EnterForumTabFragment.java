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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class EnterForumTabFragment extends BaseFragment implements g {
    private c hcW;
    private NewPagerSlidingTabBaseStrip.a hcX = new NewPagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.a
        public void k(View view, int i) {
            if (view != null && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.hcW != null) {
                if (EnterForumTabFragment.this.hcW.bSh() == i) {
                    EnterForumTabFragment.this.hcW.ts(i);
                } else if (i == 0) {
                    TiebaStatic.log(new ao("c13366").ag("obj_locate", 1));
                } else if (i > 0) {
                    TiebaStatic.log(new ao("c13366").ag("obj_locate", 3).dk("resource_id", EnterForumTabFragment.this.hcW.tt(i)));
                }
            }
        }
    };
    private CustomMessageListener hcY = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && EnterForumTabFragment.this.hcW != null) {
                if (EnterForumTabFragment.this.isPrimary()) {
                    EnterForumTabFragment.this.hcW.ts(EnterForumTabFragment.this.hcW.bSh());
                    return;
                }
                int bSh = EnterForumTabFragment.this.hcW.bSh();
                if (bSh == 0) {
                    TiebaStatic.log(new ao("c13366").ag("obj_locate", 1));
                } else if (bSh > 0) {
                    TiebaStatic.log(new ao("c13366").ag("obj_locate", 3).dk("resource_id", EnterForumTabFragment.this.hcW.tt(bSh)));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hcW = new c(this);
        registerListener(this.hcY);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.hcW.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.hcW.a(this.hcX);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hcW.aen();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hcW != null) {
            this.hcW.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hcW != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hcW != null) {
            this.hcW.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (this.hcW != null && intent != null && intent.getExtras() != null && intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int El = this.hcW.El(stringExtra);
            if (this.hcW.bSa()) {
                if (this.hcW.tp(El != -1 ? El : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.hcW.Ek(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cpB().cpC();
        MessageManager.getInstance().unRegisterListener(this.hcY);
        if (this.hcW != null) {
            this.hcW.Ve();
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void setPrimary(boolean z) {
        super.setPrimary(z);
        if (this.hcW != null) {
            this.hcW.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            a(getActivity().getIntent(), null);
        }
        if (this.hcW != null) {
            this.hcW.setPrimary(isPrimary());
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
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean a(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.hcW != null) {
            return this.hcW.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void z(Intent intent) {
        if (intent != null && this.hcW != null) {
            int El = this.hcW.El(intent.getStringExtra("sub_locate_type"));
            if (El == -1) {
                El = 0;
            }
            if (this.hcW.tp(El)) {
                intent.removeExtra("sub_locate_type");
            }
        }
    }
}
