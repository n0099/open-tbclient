package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes16.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, FrsCommonImageLayout.c {
    private WeakReference<Context> ajF;
    private com.baidu.adp.lib.d.b<TbImageView> elu;
    public long hEB;
    private ItemInfo hEC;
    private GuidePopupWindow hED;
    private FrsTabController hEw;
    private com.baidu.tieba.frs.e.f hEx;
    private com.baidu.adp.lib.d.b<TbImageView> hEy;
    private boolean hEz;
    private boolean mIsFromSchema = false;
    boolean hEA = true;
    private com.baidu.tbadk.mutiprocess.h hEE = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private CustomMessageListener hqb = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.bWH();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        Intent intent = getIntent();
        if (intent != null) {
            BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
            if (bdUniqueId2 != null) {
                setUniqueId(bdUniqueId2);
            }
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.jC().bj("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hEw = new FrsTabController(this);
        this.hEw.init(bundle);
        if (com.baidu.tieba.frs.e.f.U(intent)) {
            this.hEz = true;
            enterExitAnimation();
            if (this.hEx == null) {
                this.hEx = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.hEx.cig();
        }
        this.ajF = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.hEE);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.hED = new GuidePopupWindow(this);
        registerListener(this.hqb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bWH() {
        if (caH()) {
            com.baidu.tbadk.core.sharedPref.b.aZP().putBoolean("has_guide_popup_window_been_shown", true);
            caG();
            com.baidu.adp.lib.f.g.showDialog(this.hED, this);
        }
    }

    private void caG() {
        if (this.hED != null && this.hEw != null && this.hEw.cgu() != null && this.hEw.cgu().getForum() != null) {
            ForumData forum = this.hEw.cgu().getForum();
            this.hED.dtI();
            this.hED.f(this.hEw.cgu().getUserData());
            this.hED.Ps(forum.getName());
            this.hED.J(forum.getMember_num(), forum.getThread_num());
            this.hED.setForumId(Integer.parseInt(forum.getId()));
            this.hED.wS(forum.getName());
            this.hED.Pt(String.valueOf(this.hEw.cgu().getUserData().getLevel_id()));
        }
    }

    private boolean caH() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.aZP().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.hEw == null || this.hEw.cgu() == null || this.hEw.cgu().getUserData() == null || !(this.hEw.cgu().getUserData().getIs_manager() == 0 || this.hEw.cgu().getUserData().getIs_manager() == 2);
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.hEz || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hEw != null) {
            this.hEw.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hEA) {
            com.baidu.tbadk.util.ag.b(this.ajF);
            this.hEA = false;
        }
        if (this.hEw != null) {
            this.hEw.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.hEw != null) {
            this.hEw.onPause();
        }
        if (this.hEB >= 0) {
            long j = currentTimeMillis - this.hEB;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.blm().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hEA = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hEw != null) {
            this.hEw.onDestroy();
        }
        b.caw().reset();
        a.cap().reset();
        a.cap().destory();
        c.caA().destory();
        if (!com.baidu.tbadk.core.util.as.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.a((NetModel.b) null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.hEw != null) {
            this.hEw.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hEw != null) {
            this.hEw.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hEw != null ? this.hEw.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.hEw != null) {
            this.hEw.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hEw != null) {
            return this.hEw.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hEw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hEw.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pE(int i) {
        if (this.hEw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hEw.pE(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hEw instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hEw.a(bVar);
        }
    }

    public FrsFragment caI() {
        if (this.hEw == null) {
            return null;
        }
        return this.hEw.caI();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> caJ() {
        if (this.hEy == null) {
            this.hEy = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.hEy;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View bcE() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bcF() {
        if (this.elu == null) {
            this.elu = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.elu;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        caI().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void nx(boolean z) {
        FragmentTabHost cds;
        if (this.hEw != null && (cds = this.hEw.cds()) != null && cds.getFragmentTabWidget() != null) {
            if (z) {
                cds.changeStyle(2);
            } else {
                cds.changeStyle(4);
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
            caK();
        }
    }

    public void caK() {
        if (this.hEx != null) {
            this.hEx.caK();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hEw == null || this.hEw.caI() == null) {
            return false;
        }
        return this.hEw.caI().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.hEw != null && this.hEw.cgy() && this.hEw.cds() != null && (this.hEw.cds().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.hEw.cds().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.hEw.cds().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.hEw.cds().getCurrentFragment()).getCurrentPageKey());
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
            if (this.hEw != null && this.hEw.caI() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.hEw.caI().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ae(TbadkCoreApplication.getInst().getAdAdSense().epK);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.frs.FrsActivity.3
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.blm().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.hEw != null) {
            tbPageTag = this.hEw.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.am
    public void a(ItemInfo itemInfo) {
        this.hEC = itemInfo;
    }

    @Override // com.baidu.tieba.frs.am
    public ItemInfo caL() {
        return this.hEC;
    }

    @Override // com.baidu.tieba.frs.am
    public boolean caM() {
        return (this.hEw == null || this.hEw.caI() == null || this.hEw.caI().cbu() == null || this.hEw.caI().cbu().cjp() == null || this.hEw.caI().cbu().cjp().tabType != 16) ? false : true;
    }
}
