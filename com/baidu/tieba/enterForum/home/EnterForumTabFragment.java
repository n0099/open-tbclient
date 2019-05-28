package com.baidu.tieba.enterForum.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.atomData.MessageCenterActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class EnterForumTabFragment extends BaseFragment {
    private c eSG;
    private PagerSlidingTabBaseStrip.a eSH = new PagerSlidingTabBaseStrip.a() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.1
        @Override // com.baidu.tbadk.widget.tab.PagerSlidingTabBaseStrip.a
        public void r(View view, int i) {
            if (view != null) {
                if (EnterForumTabFragment.this.bdT() && EnterForumTabFragment.this.isPrimary() && EnterForumTabFragment.this.getPageContext() != null) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001631, EnterForumTabFragment.this.getPageContext().getUniqueId()));
                }
                if (EnterForumTabFragment.this.bdT()) {
                    TiebaStatic.log(new am("c13366").P("obj_locate", 1));
                } else {
                    TiebaStatic.log(new am("c13366").P("obj_locate", 2));
                }
            }
        }
    };
    private CustomMessageListener eSI = new CustomMessageListener(2001384) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                if (((Integer) customResponsedMessage.getData()).intValue() == 1) {
                    if (EnterForumTabFragment.this.bdT() && EnterForumTabFragment.this.getPageContext() != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001629, EnterForumTabFragment.this.getPageContext().getUniqueId()));
                        return;
                    }
                    return;
                }
                TiebaStatic.log(new am("c13366").P("obj_locate", 1));
            }
        }
    };
    private CustomMessageListener eSJ = new CustomMessageListener(2001630) { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Integer)) {
                Integer num = (Integer) customResponsedMessage.getData();
                if (EnterForumTabFragment.this.eSG != null) {
                    EnterForumTabFragment.this.eSG.qf(num.intValue());
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: private */
    public boolean bdT() {
        return this.eSG != null && this.eSG.qg(1);
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        registerListener(this.eSI);
        registerListener(this.eSJ);
    }

    @Override // android.support.v4.app.Fragment
    @Nullable
    public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.enter_forum_tab, viewGroup, false);
        this.eSG = new c(this);
        this.eSG.a(inflate, bundle);
        a(getActivity().getIntent(), bundle);
        this.eSG.a(this.eSH);
        TiebaStatic.log(new am("c13366").P("obj_locate", 1));
        return inflate;
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.eSG.CE();
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.eSG != null) {
            this.eSG.onActivityResult(i, i2, intent);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void changeSkinType(int i) {
        if (this.eSG != null) {
            super.changeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        if (this.eSG != null) {
            this.eSG.onChangeSkinType(this.mSkinType);
        }
    }

    private void a(Intent intent, Bundle bundle) {
        int i = (intent == null || intent.getExtras() == null) ? -1 : intent.getExtras().getInt(MessageCenterActivityConfig.SELECTED_TAB_ID, -1);
        if (i == -1 && bundle != null) {
            i = bundle.getInt("Selected_Tab", -1);
        }
        if (i == -1) {
            i = 1;
        }
        if (this.eSG != null) {
            this.eSG.qf(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        com.baidu.tieba.im.db.e.bzV().bzW();
        MessageManager.getInstance().unRegisterListener(this.eSI);
        MessageManager.getInstance().unRegisterListener(this.eSJ);
        if (this.eSG != null) {
            this.eSG.bdY();
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
        if (this.eSG != null) {
            this.eSG.setPrimary(z);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.enterForum.home.EnterForumTabFragment.4
            @Override // com.baidu.tbadk.o.b
            public boolean atL() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int atM() {
                return com.baidu.tbadk.o.e.atQ().atT();
            }

            @Override // com.baidu.tbadk.o.b
            public boolean a(com.baidu.tbadk.o.d dVar) {
                return false;
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragment, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        if (this.eSG != null) {
            return this.eSG.getCurrentPageKey();
        }
        return null;
    }
}
