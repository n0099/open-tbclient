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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class EnterForumTabFragment extends BaseFragment implements g {
    private c hCQ;
    private NewPagerSlidingTabBaseStrip.a hCR = new NewPagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.NewPagerSlidingTabBaseStrip.a
        public void m(View view, int i) {
            if (view != null && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.hCQ != null) {
                if (EnterForumTabFragment.this.hCQ.cjg() == i) {
                    EnterForumTabFragment.this.hCQ.wz(i);
                } else if (i == 0) {
                    TiebaStatic.log(new aq("c13366").ai("obj_locate", 1));
                } else if (i > 0) {
                    TiebaStatic.log(new aq("c13366").ai("obj_locate", 3).dF("resource_id", EnterForumTabFragment.this.hCQ.wA(i)));
                }
            }
        }
    };
    private CustomMessageListener mEnterForumTabClickListener = new CustomMessageListener(CmdConfigCustom.CMD_MAIN_TAB_WIDGET_CLICK) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer) && ((Integer) customResponsedMessage.getData()).intValue() == 1 && EnterForumTabFragment.this.hCQ != null) {
                if (EnterForumTabFragment.this.isPrimary()) {
                    EnterForumTabFragment.this.hCQ.wz(EnterForumTabFragment.this.hCQ.cjg());
                    return;
                }
                int cjg = EnterForumTabFragment.this.hCQ.cjg();
                if (cjg == 0) {
                    TiebaStatic.log(new aq("c13366").ai("obj_locate", 1));
                } else if (cjg > 0) {
                    TiebaStatic.log(new aq("c13366").ai("obj_locate", 3).dF("resource_id", EnterForumTabFragment.this.hCQ.wA(cjg)));
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.hCQ = new c(this);
        registerListener(this.mEnterForumTabClickListener);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.hCQ.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.hCQ.a(this.hCR);
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.hCQ.anr();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hCQ != null) {
            this.hCQ.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.hCQ != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.hCQ != null) {
            this.hCQ.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (this.hCQ != null && intent != null && intent.getExtras() != null && intent.getBooleanExtra("is_from_scheme", false)) {
            String stringExtra = intent.getStringExtra("sub_locate_type");
            int HT = this.hCQ.HT(stringExtra);
            if (this.hCQ.cjb()) {
                if (this.hCQ.ww(HT != -1 ? HT : 0)) {
                    intent.removeExtra("sub_locate_type");
                    intent.removeExtra("is_from_scheme");
                    return;
                }
                return;
            }
            this.hCQ.HS(stringExtra);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.cHF().cHG();
        MessageManager.getInstance().unRegisterListener(this.mEnterForumTabClickListener);
        if (this.hCQ != null) {
            this.hCQ.acy();
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
        if (this.hCQ != null) {
            this.hCQ.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            a(getActivity().getIntent(), null);
        }
        if (this.hCQ != null) {
            this.hCQ.setPrimary(isPrimary());
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
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
            }

            @Override // com.baidu.tbadk.m.b
            public boolean canStat(com.baidu.tbadk.m.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        if (this.hCQ != null) {
            return this.hCQ.getCurrentPageKey();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.g
    public void B(Intent intent) {
        if (intent != null && this.hCQ != null) {
            int HT = this.hCQ.HT(intent.getStringExtra("sub_locate_type"));
            if (HT == -1) {
                HT = 0;
            }
            if (this.hCQ.ww(HT)) {
                intent.removeExtra("sub_locate_type");
            }
        }
    }
}
