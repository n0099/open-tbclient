package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private WeakReference<Context> aio;
    private com.baidu.adp.lib.d.b<TbImageView> dXO;
    private FrsTabController hmh;
    private com.baidu.tieba.frs.e.f hmi;
    private com.baidu.adp.lib.d.b<TbImageView> hmj;
    private boolean hmk;
    public long hmm;
    private boolean mIsFromSchema = false;
    boolean hml = true;
    private com.baidu.tbadk.mutiprocess.h hmn = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && FrsActivity.this.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.c(FrsActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jm().bi("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hmh = new FrsTabController(this);
        this.hmh.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.hmk = true;
            enterExitAnimation();
            if (this.hmi == null) {
                this.hmi = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.hmi.cbg();
        }
        this.aio = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.hmn);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.hmk || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hmh != null) {
            this.hmh.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hml) {
            com.baidu.tbadk.util.ag.b(this.aio);
            this.hml = false;
        }
        if (this.hmh != null) {
            this.hmh.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.hmh != null) {
            this.hmh.onPause();
        }
        if (this.hmm >= 0) {
            long j = currentTimeMillis - this.hmm;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bfu().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hml = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hmh != null) {
            this.hmh.onDestroy();
        }
        a.bTX().reset();
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.hmh != null) {
            this.hmh.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hmh != null) {
            this.hmh.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hmh != null ? this.hmh.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage((int) CmdConfigCustom.START_MAINTAB, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.hmh != null) {
            this.hmh.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hmh != null) {
            return this.hmh.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hmh instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hmh.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a oM(int i) {
        if (this.hmh instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hmh.oM(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hmh instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hmh.a(bVar);
        }
    }

    public FrsFragment bUi() {
        if (this.hmh == null) {
            return null;
        }
        return this.hmh.bUi();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bUj() {
        if (this.hmj == null) {
            this.hmj = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.hmj;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View aWN() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aWO() {
        if (this.dXO == null) {
            this.dXO = UserIconBox.s(getPageContext().getPageActivity(), 8);
        }
        return this.dXO;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        bUi().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void mH(boolean z) {
        FragmentTabHost bWI;
        if (this.hmh != null && (bWI = this.hmh.bWI()) != null && bWI.getFragmentTabWidget() != null) {
            if (z) {
                bWI.changeStyle(2);
            } else {
                bWI.changeStyle(4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        j(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i) {
        super.showLoadingView(view, z, i);
        j(view, true);
    }

    public void j(View view, boolean z) {
        if (view.getId() == R.id.frs) {
            TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
        } else if (view.getId() == 16908290) {
            TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
        }
        if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
            bUk();
        }
    }

    public void bUk() {
        if (this.hmi != null) {
            this.hmi.bUk();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.hmh == null || this.hmh.bUi() == null) {
            return false;
        }
        return this.hmh.bUi().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uD("cyber_player_test") || com.baidu.tbadk.a.b.uC("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.hmh != null && this.hmh.bZD() && this.hmh.bWI() != null && (this.hmh.bWI().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.hmh.bWI().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.hmh.bWI().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.hmh.bWI().getCurrentFragment()).getCurrentPageKey());
        } else {
            arrayList.add(getCurrentPageKey());
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.m.d getPageStayDurationItem() {
        com.baidu.tbadk.m.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.hmh != null && this.hmh.bUi() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.hmh.bUi().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yE(TbadkCoreApplication.getInst().getAdAdSense().eaO);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.frs.FrsActivity.2
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bfu().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.hmh != null) {
            tbPageTag = this.hmh.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }
}
