package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class EnterForumTabFragment extends BaseFragment {
    private c eZw;
    private PagerSlidingTabBaseStrip.a eZx = new PagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.a
        public void r(View view, int i) {
            if (view != null) {
                if (EnterForumTabFragment.this.bgC() && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, EnterForumTabFragment.this.getPageContext().getUniqueId()));
                }
                if (EnterForumTabFragment.this.bgC()) {
                    TiebaStatic.log(new an("c13366").P("obj_locate", 1));
                } else {
                    TiebaStatic.log(new an("c13366").P("obj_locate", 2));
                }
            }
        }
    };
    private CustomMessageListener eZy = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    if (EnterForumTabFragment.this.bgC() && EnterForumTabFragment.this.getPageContext() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001629, EnterForumTabFragment.this.getPageContext().getUniqueId()));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new an("c13366").P("obj_locate", 1));
            }
        }
    };
    private CustomMessageListener eZz = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (EnterForumTabFragment.this.eZw != null) {
                    EnterForumTabFragment.this.eZw.qB(num.intValue());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bgC() {
        return this.eZw != null && this.eZw.qC(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.eZw = new c(this);
        registerListener(this.eZy);
        registerListener(this.eZz);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.eZw.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.eZw.a(this.eZx);
        TiebaStatic.log(new an("c13366").P("obj_locate", 1));
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eZw.Dr();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eZw != null) {
            this.eZw.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eZw != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eZw != null) {
            this.eZw.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        if (intent != null && "1_recommend".equals(intent.getStringExtra("sub_locate_type"))) {
            if (this.eZw != null) {
                this.eZw.qB(2);
                return;
            }
            return;
        }
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        if (this.eZw != null && this.eZw.bgF() != -1) {
            i = this.eZw.bgF();
        }
        if (i == -1) {
            i = 1;
        }
        if (this.eZw != null) {
            this.eZw.qB(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bDD().bDE();
        MessageManager.getInstance().unRegisterListener(this.eZy);
        MessageManager.getInstance().unRegisterListener(this.eZz);
        if (this.eZw != null) {
            this.eZw.bgI();
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
        if (this.eZw != null) {
            this.eZw.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isPrimary() && getActivity() != null) {
            a(getActivity().getIntent(), null);
        }
        if (this.eZw != null) {
            this.eZw.setPrimary(isPrimary());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.4
            @Override // com.baidu.tbadk.o.b
            public boolean avh() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int avi() {
                return com.baidu.tbadk.o.e.avn().avq();
            }

            @Override // com.baidu.tbadk.o.b
            public boolean a(com.baidu.tbadk.o.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.eZw != null) {
            return this.eZw.getCurrentPageKey();
        }
        return null;
    }
}
