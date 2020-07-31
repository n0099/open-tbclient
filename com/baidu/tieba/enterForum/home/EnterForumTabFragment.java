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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class EnterForumTabFragment extends BaseFragment implements g {
    private c hiG;
    private NewPagerSlidingTabBaseStrip.a hiH = new NewPagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.a
        public void l(View view, int i) {
            if (view != null && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.hiG != null) {
                if (EnterForumTabFragment.this.hiG.bVz() == i) {
                    EnterForumTabFragment.this.hiG.tK(i);
                } else if (i == 0) {
                    TiebaStatic.log(new ap("c13366").ah("obj_locate", 1));
                } else if (i > 0) {
                    TiebaStatic.log(new ap("c13366").ah("obj_locate", 3).dn("resource_id", EnterForumTabFragment.this.hiG.tL(i)));
                }
            }
        }
    };
    private CustomMessageListener hiI = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && EnterForumTabFragment.this.hiG != null) {
                if (EnterForumTabFragment.this.isPrimary()) {
                    EnterForumTabFragment.this.hiG.tK(EnterForumTabFragment.this.hiG.bVz());
                    return;
                }
                int bVz = EnterForumTabFragment.this.hiG.bVz();
                if (bVz == 0) {
                    TiebaStatic.log(new ap("c13366").ah("obj_locate", 1));
                } else if (bVz > 0) {
                    TiebaStatic.log(new ap("c13366").ah("obj_locate", 3).dn("resource_id", EnterForumTabFragment.this.hiG.tL(bVz)));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hiG = new c(this);
        registerListener(this.hiI);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.hiG.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.hiG.a(this.hiH);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hiG.afA();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hiG != null) {
            this.hiG.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hiG != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hiG != null) {
            this.hiG.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (this.hiG != null && intent != null && intent.getExtras() != null && intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int EW = this.hiG.EW(stringExtra);
            if (this.hiG.bVs()) {
                if (this.hiG.tH(EW != -1 ? EW : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.hiG.EV(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cth().cti();
        MessageManager.getInstance().unRegisterListener(this.hiI);
        if (this.hiG != null) {
            this.hiG.VJ();
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
        if (this.hiG != null) {
            this.hiG.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            a(getActivity().getIntent(), null);
        }
        if (this.hiG != null) {
            this.hiG.setPrimary(isPrimary());
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
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean a(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.hiG != null) {
            return this.hiG.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void z(Intent intent) {
        if (intent != null && this.hiG != null) {
            int EW = this.hiG.EW(intent.getStringExtra("sub_locate_type"));
            if (EW == -1) {
                EW = 0;
            }
            if (this.hiG.tH(EW)) {
                intent.removeExtra("sub_locate_type");
            }
        }
    }
}
