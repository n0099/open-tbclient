package com.baidu.tieba.frs.commontab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.card.a.a;
import com.baidu.card.z;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MyBookrackActivityConfig;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.t;
import com.baidu.tieba.frs.ag;
import com.baidu.tieba.frs.view.ProfessionDialogLayout;
import com.baidu.tieba.play.m;
import com.baidu.tieba.tbadkCore.FrsViewData;
/* loaded from: classes4.dex */
public class FrsCommonTabFragment extends BaseFragment implements h.c, VoiceManager.c, ag {
    protected b fBe;
    protected c fBf;
    public FrsViewData fBg;
    public boolean fBh;
    public boolean fBi;
    public String forumId;
    private VoiceManager ftO;
    private z fuf;
    private com.baidu.tbadk.m.c fyL;
    public boolean isBrandForum;
    protected View mRootView;
    public int tabId;
    private int fBj = 3;
    private boolean fBk = true;
    private CustomMessageListener fwP = new CustomMessageListener(2921397) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Integer num;
            if (customResponsedMessage != null && customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof Integer) && (num = (Integer) customResponsedMessage.getData()) != null) {
                FrsCommonTabFragment.this.rT(num.intValue());
            }
        }
    };
    private CustomMessageListener fuT = new CustomMessageListener(2001624) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null) {
                Object data = customResponsedMessage.getData();
                if ((data instanceof Integer) && Integer.parseInt(data.toString()) == FrsCommonTabFragment.this.tabId) {
                    if (FrsCommonTabFragment.this.fBe != null) {
                        FrsCommonTabFragment.this.fBe.setSelection(0);
                    }
                    if (FrsCommonTabFragment.this.fyL != null && FrsCommonTabFragment.this.fyL.isViewAttached()) {
                        FrsCommonTabFragment.this.onNetRefreshButtonClicked();
                        return;
                    }
                    FrsCommonTabFragment.this.fBe.gc(true);
                    FrsCommonTabFragment.this.er(true);
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2003020, true));
                }
            }
        }
    };
    private final CustomMessageListener fBl = new CustomMessageListener(2921031) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (!StringUtils.isNull(str)) {
                    FrsCommonTabFragment.this.fBe.xe(str);
                }
            }
        }
    };
    private CustomMessageListener fvr = new CustomMessageListener(2921381) { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof KeyEvent)) {
                KeyEvent keyEvent = (KeyEvent) customResponsedMessage.getData();
                if (keyEvent.getAction() == 0 && keyEvent.getKeyCode() == 24) {
                    m bmJ = FrsCommonTabFragment.this.fBe.bmJ();
                    if (bmJ != null && bmJ.ced() != null && (bmJ.ced().getTag() instanceof z)) {
                        FrsCommonTabFragment.this.fuf = (z) bmJ.ced().getTag();
                    }
                    if (FrsCommonTabFragment.this.fuf != null && FrsCommonTabFragment.this.fuf.qP() != null) {
                        FrsCommonTabFragment.this.fuf.qP().b(new a.C0038a(3));
                    }
                }
            }
        }
    };

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.tabId = bundle.getInt(MyBookrackActivityConfig.TAB_ID);
            this.forumId = bundle.getString("forum_id");
            this.fBi = bundle.getBoolean("can_auto_play_video");
            this.fBh = bundle.getBoolean("need_log");
            this.isBrandForum = bundle.getBoolean("is_brand_forum");
            this.fBg = (FrsViewData) bundle.getSerializable("view_data");
        } else {
            Bundle arguments = getArguments();
            if (arguments != null) {
                this.tabId = arguments.getInt(MyBookrackActivityConfig.TAB_ID);
                this.forumId = arguments.getString("forum_id");
                this.fBi = arguments.getBoolean("can_auto_play_video");
                this.fBh = arguments.getBoolean("need_log");
                this.isBrandForum = arguments.getBoolean("is_brand_forum");
                this.fBg = (FrsViewData) arguments.getSerializable("view_data");
            }
        }
        this.ftO = getVoiceManager();
        this.ftO.onCreate(getPageContext());
        this.fBf = new c(this, com.baidu.adp.lib.g.b.f(this.forumId, 0), this.tabId);
        registerListener(this.fuT);
        registerListener(this.fBl);
        registerListener(this.fvr);
    }

    @Override // android.support.v4.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.mRootView = layoutInflater.inflate(getLayoutR(), (ViewGroup) null);
        this.fBe = new b(this, this.mRootView, this.fBg);
        return this.mRootView;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLazyLoad() {
        super.onLazyLoad();
        if (j.kc()) {
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            box();
            return;
        }
        showNetRefreshView(this.mRootView, null, true);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onLoad() {
        bu(this.tabId, 2);
    }

    private void bu(int i, int i2) {
        an anVar = new an("c13008");
        anVar.bT("uid", TbadkCoreApplication.getCurrentAccount());
        anVar.bT("fid", this.forumId);
        if (i == 89) {
            anVar.P("obj_type", 1);
        } else if (i == 501) {
            anVar.P("obj_type", 3);
        } else if (i == 502) {
            anVar.P("obj_type", 8);
        }
        anVar.P("obj_locate", i2);
        anVar.aji();
    }

    public int getLayoutR() {
        return R.layout.frs_common_tab_fragment;
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void showNetRefreshView(View view, String str, boolean z) {
        this.fBe.kw(false);
        if (getPageContext() != null && getPageContext().getContext() != null) {
            registerListener(this.fwP);
            if (this.fyL == null) {
                this.fyL = new com.baidu.tbadk.m.c(getPageContext().getContext(), getNetRefreshListener());
            }
            this.fyL.setTitle(null);
            this.fyL.qN(str);
            this.fyL.setButtonText(null);
            this.fyL.attachView(view, z);
            this.fyL.atI();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void hideNetRefreshView(View view) {
        this.fBe.kw(true);
        if (this.fyL != null) {
            this.fyL.dettachView(view);
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
    }

    public void a(d dVar) {
        if (dVar != null) {
            hideLoadingView(this.mRootView);
            if (this.fBe != null) {
                this.fBe.gc(false);
                this.fBe.a(dVar);
            }
            if (this.fBf.boC() && this.tabId == 89) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001612, false));
            }
        }
    }

    public void a(ErrorData errorData) {
        hideLoadingView(this.mRootView);
        if (errorData != null) {
            if (!StringUtils.isNull(errorData.error_msg)) {
                showToast(errorData.error_msg);
            } else {
                showToast(R.string.im_error_default);
            }
        }
        if (!this.fBf.hasData()) {
            String str = null;
            if (errorData != null) {
                str = getPageContext().getResources().getString(R.string.net_error_text, errorData.error_msg, Integer.valueOf(errorData.error_code));
            }
            showNetRefreshView(this.mRootView, str, true);
        }
        if (this.fBe != null) {
            this.fBe.gc(false);
        }
    }

    public void ac(bg bgVar) {
        if (bgVar != null) {
            this.fBf.ac(bgVar);
            this.fBe.blA();
        }
    }

    public void aYo() {
        if (l.kt()) {
            if (this.ftO != null) {
                this.ftO.stopPlay();
            }
            if (this.fBf != null) {
                this.fBf.aIQ();
            }
        }
    }

    private void box() {
        if (l.kt()) {
            if (this.ftO != null) {
                this.ftO.stopPlay();
            }
            if (this.fBf != null) {
                this.fBf.box();
            }
        }
    }

    @Override // com.baidu.tbadk.core.view.h.c
    public void er(boolean z) {
        if (j.kc()) {
            hideNetRefreshView(this.mRootView);
            if (this.fBf.hasData()) {
                hideLoadingView(this.mRootView);
            } else {
                showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            }
            box();
            return;
        }
        this.fBe.gc(false);
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    protected void onNetRefreshButtonClicked() {
        if (j.kc()) {
            hideNetRefreshView(this.mRootView);
            showLoadingView(this.mRootView, false, getResources().getDimensionPixelSize(R.dimen.ds250));
            box();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onDestroy() {
        t.aZN().iE(false);
        MessageManager.getInstance().unRegisterListener(this.fwP);
        super.onDestroy();
        if (this.fBe != null) {
            this.fBe.onDestroy();
        }
        if (this.ftO != null) {
            this.ftO.onDestory(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onPrimary() {
        super.onPrimary();
        if (isAdded() && isPrimary()) {
            if (this.fBe != null) {
                this.fBe.resume();
            }
            if (this.fBk) {
                this.fBk = false;
                if (this.tabId == 502) {
                    if (com.baidu.tbadk.core.sharedPref.b.ahO().getBoolean("first_into_tab_profession", true)) {
                        com.baidu.tbadk.core.sharedPref.b.ahO().putBoolean("first_into_tab_profession", false);
                        boy();
                    }
                    new com.baidu.tieba.frs.profession.permission.c(getPageContext()).xA(this.forumId);
                    onLazyLoad();
                }
                if (this.tabId == 503) {
                    onLazyLoad();
                }
            }
            boA();
        } else if (this.fBe != null) {
            this.fBe.pause();
        }
        bnV();
    }

    private void boy() {
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
        aVar.hx(1);
        ProfessionDialogLayout professionDialogLayout = new ProfessionDialogLayout(getContext());
        professionDialogLayout.setButtonClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        professionDialogLayout.setCloseViewClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.commontab.FrsCommonTabFragment.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        });
        aVar.aH(professionDialogLayout);
        aVar.dQ(false);
        aVar.dR(false);
        aVar.b(getPageContext()).agI();
    }

    private void bnV() {
        if (isPrimary()) {
            if (this.fyL != null && this.fyL.isViewAttached()) {
                MessageManager.getInstance().registerListener(this.fwP);
                return;
            }
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.fwP);
    }

    public void boz() {
        if (this.fBe != null) {
            this.fBe.refreshView();
        }
    }

    private void boA() {
        if (this.tabId == 502) {
            an anVar = new an("c13376");
            anVar.bT("fid", this.forumId);
            anVar.l("uid", TbadkCoreApplication.getCurrentAccountId());
            TiebaStatic.log(anVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onResume() {
        super.onResume();
        if (this.ftO != null) {
            this.ftO.onResume(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment, android.support.v4.app.Fragment
    public void onPause() {
        super.onPause();
        if (this.fBe != null) {
            this.fBe.pause();
        }
        if (this.ftO != null) {
            this.ftO.onPause(getPageContext());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i) {
        if (this.fBj != 3 || this.fBe != null) {
            this.fBj = i;
            super.onChangeSkinType(i);
            this.fBe.onChangeSkinType(i);
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt(MyBookrackActivityConfig.TAB_ID, this.tabId);
        bundle.putString("forum_id", this.forumId);
        bundle.putBoolean("can_auto_play_video", this.fBi);
        bundle.putBoolean("need_log", this.fBh);
        bundle.putBoolean("is_brand_forum", this.isBrandForum);
        if (this.ftO != null) {
            this.ftO.onSaveInstanceState(getPageContext().getPageActivity());
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.ftO == null) {
            this.ftO = VoiceManager.instance();
        }
        return this.ftO;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // android.support.v4.app.Fragment
    public void onStart() {
        super.onStart();
        if (this.ftO != null) {
            this.ftO.onStart(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onStop() {
        super.onStop();
        if (this.ftO != null) {
            this.ftO.onStop(getPageContext());
        }
    }

    @Override // android.support.v4.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            switch (i) {
                case 18003:
                    String stringExtra = intent.getStringExtra("tid");
                    int intExtra = intent.getIntExtra("type", -1);
                    if (!StringUtils.isNull(stringExtra) && intExtra == 0) {
                        this.fBe.xe(stringExtra);
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tieba.frs.ag
    public void blA() {
        this.fBe.blA();
    }

    @Override // com.baidu.tieba.frs.ag
    public void aKh() {
        this.fBe.aKh();
        this.fBe.gc(true);
    }

    public void rT(int i) {
        if (this.fyL != null && this.fyL.isViewAttached()) {
            this.fyL.kH(i);
        }
    }
}
