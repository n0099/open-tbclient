package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsActivityConfig;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData$VoiceModel;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SpecHotTopicHelper;
import com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.frs.mc.FrsNetModel;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import com.baidu.tieba.view.GuidePopupWindow;
import d.a.c.e.m.g;
import d.a.c.e.p.k;
import d.a.j0.f0.i;
import d.a.j0.k0.e;
import d.a.k0.q0.m0;
import d.a.k0.q0.m2.f;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes4.dex */
public class FrsActivity extends BaseFragmentActivity implements d.a.k0.e.e.b, VoiceManager.j, UserIconBox.c, FrsCommonImageLayout.e, IVideoNeedPreload, m0 {
    public GuidePopupWindow frsGuidePopupView;
    public boolean isNeedTransition;
    public ItemInfo mCommentTabItemInfo;
    public d.a.c.e.k.b<TbImageView> mFrsCommonImagePool;
    public long mSpecialTabPageStayTime;
    public FrsTabController mTabController;
    public f mTransitionController;
    public d.a.c.e.k.b<TbImageView> mUserIconPool;
    public WeakReference<Context> mWeakContext;
    public boolean mIsFromSchema = false;
    public boolean doRefresh = true;
    public i mTipsEventListener = new a();
    public i mSwanappReturnProductDateListener = new b();
    public CustomMessageListener mGuideWindowListener = new c(2921476);

    /* loaded from: classes4.dex */
    public class a extends i<TipEvent> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.f0.b
        /* renamed from: a */
        public boolean onEvent(TipEvent tipEvent) {
            if (tipEvent.pageId <= 0 || FrsActivity.this.getPageId() != tipEvent.pageId) {
                return true;
            }
            DefaultNavigationBarCoverTip.s(FrsActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).u();
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends i<GoodsEvent> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.j0.f0.b
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            if (goodsEvent == null || FrsActivity.this.mTabController.M() == null) {
                return false;
            }
            if (goodsEvent.getDispose()) {
                return true;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(FrsActivity.this).setType(9).setForumWriteData(FrsActivity.this.mTabController.M().o2()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
            goodsEvent.setDispost(true);
            return true;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.showGuideWindow();
        }
    }

    /* loaded from: classes4.dex */
    public class d extends d.a.j0.k0.b {
        public d() {
        }

        @Override // d.a.j0.k0.b
        public int getMaxCost() {
            return e.b().c();
        }

        @Override // d.a.j0.k0.b
        public boolean isCurrentPageCanBeAddToSourceTrace() {
            return false;
        }
    }

    private boolean isShowGuidePopup() {
        if (TbadkCoreApplication.isLogin() && !d.a.j0.r.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
            FrsTabController frsTabController = this.mTabController;
            return frsTabController == null || frsTabController.R() == null || this.mTabController.R().getUserData() == null || this.mTabController.R().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void removeSpecTopicIcon() {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController == null || frsTabController.R() == null || this.mTabController.R().getForum() == null) {
            return;
        }
        SpecHotTopicHelper.removeSpecTopicIconForFrs(Long.valueOf(d.a.c.e.m.b.f(this.mTabController.R().getForum().getId(), 0L)));
    }

    private void setWindowData() {
        FrsTabController frsTabController;
        if (this.frsGuidePopupView == null || (frsTabController = this.mTabController) == null || frsTabController.R() == null || this.mTabController.R().getForum() == null) {
            return;
        }
        ForumData forum = this.mTabController.R().getForum();
        this.frsGuidePopupView.t();
        this.frsGuidePopupView.s(String.valueOf(this.mTabController.R().getUserData().getLevel_id()));
        this.frsGuidePopupView.r(this.mTabController.R().getUserData());
        this.frsGuidePopupView.k(forum.getName());
        this.frsGuidePopupView.p(forum.getMember_num(), forum.getThread_num());
        this.frsGuidePopupView.o(Integer.parseInt(forum.getId()));
        this.frsGuidePopupView.u(forum.getName());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showGuideWindow() {
        if (isShowGuidePopup()) {
            d.a.j0.r.d0.b.j().t("has_guide_popup_window_been_shown", true);
            setWindowData();
            g.i(this.frsGuidePopupView, this);
        }
    }

    @Override // d.a.k0.e.e.b
    public void dispatchInjectPluginMessage(d.a.k0.e.d dVar) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController instanceof d.a.k0.e.e.b) {
            frsTabController.dispatchInjectPluginMessage(dVar);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (!this.isNeedTransition && !this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        if (this.mIsFromSchema) {
            sendMessage(new CustomMessage(2015002, new MainTabActivityConfig(getPageContext().getPageActivity()).createNormalCfg(2)));
        }
        super.finish();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.j0.k0.a
    public String getCurrentPageKey() {
        return "a006";
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public d.a.c.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        if (this.mFrsCommonImagePool == null) {
            this.mFrsCommonImagePool = FrsCommonImageLayout.m(getPageContext().getPageActivity(), 12);
        }
        return this.mFrsCommonImagePool;
    }

    public FrsFragment getFrsFragment() {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController == null) {
            return null;
        }
        return frsTabController.M();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // d.a.k0.e.e.b
    public d.a.k0.e.e.a getInjectPlugin(int i2) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController instanceof d.a.k0.e.e.b) {
            return frsTabController.getInjectPlugin(i2);
        }
        return null;
    }

    @Override // d.a.k0.q0.m0
    public ItemInfo getItemInfo() {
        return this.mCommentTabItemInfo;
    }

    public View getListView() {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.j0.k0.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        if (nextPageSourceKeyList == null) {
            nextPageSourceKeyList = new ArrayList<>();
        }
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null && frsTabController.Y() && this.mTabController.N() != null && (this.mTabController.N().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.mTabController.N().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.mTabController.N().getCurrentFragment()).isPrimary()) {
            nextPageSourceKeyList.add(((BaseFragment) this.mTabController.N().getCurrentFragment()).getCurrentPageKey());
        } else {
            nextPageSourceKeyList.add(getCurrentPageKey());
        }
        return nextPageSourceKeyList;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public d.a.j0.k0.d getPageStayDurationItem() {
        d.a.j0.k0.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            FrsTabController frsTabController = this.mTabController;
            if (frsTabController != null && frsTabController.M() != null) {
                pageStayDurationItem.q(d.a.c.e.m.b.f(this.mTabController.M().p, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.n(TbadkCoreApplication.getInst().getAdAdSense().r);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, d.a.j0.k0.a
    public d.a.j0.k0.b getPageStayFilter() {
        return new d();
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager.i getRealView(VoiceData$VoiceModel voiceData$VoiceModel) {
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        FrsTabController frsTabController = this.mTabController;
        TbPageTag Q = frsTabController != null ? frsTabController.Q() : null;
        return Q == null ? super.getTbPageTag() : Q;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public d.a.c.e.k.b<TbImageView> getUserIconPool() {
        if (this.mUserIconPool == null) {
            this.mUserIconPool = UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return this.mUserIconPool;
    }

    public int getUserIconViewId() {
        return 0;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.j
    public VoiceManager getVoiceManager() {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            return frsTabController.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        updateLoadingViewState(view, false);
    }

    public void hideTransition() {
        f fVar = this.mTransitionController;
        if (fVar != null) {
            fVar.h();
        }
    }

    @Override // d.a.k0.q0.m0
    public boolean isInScoreTab() {
        FrsTabController frsTabController = this.mTabController;
        return (frsTabController == null || frsTabController.M() == null || this.mTabController.M().y2() == null || this.mTabController.M().y2().y() == null || this.mTabController.M().y2().y().f15860d != 16) ? false : true;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.d0(i2, i3, intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i2) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.e0(i2);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        Intent intent = getIntent();
        if (intent != null) {
            BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
            if (bdUniqueId2 != null) {
                setUniqueId(bdUniqueId2);
            }
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !d.a.c.a.b.f().h("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        FrsTabController frsTabController = new FrsTabController(this);
        this.mTabController = frsTabController;
        frsTabController.U(bundle);
        if (f.i(intent)) {
            this.isNeedTransition = true;
            enterExitAnimation();
            if (this.mTransitionController == null) {
                this.mTransitionController = new f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.mTransitionController.l();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        d.a.k0.b0.a.a(getIntent(), getPageContext(), 25050);
        this.frsGuidePopupView = new GuidePopupWindow(this);
        registerListener(this.mGuideWindowListener);
        this.mSwanappReturnProductDateListener.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.mSwanappReturnProductDateListener);
        if (d.a.j0.b.d.m()) {
            FrsTabController frsTabController2 = this.mTabController;
            d.a.k0.r0.a.h().q(this, d.a.k0.r0.d.c.e().d("frs_feed"), d.a.k0.r0.a.a("frs", "1"), (frsTabController2 == null || frsTabController2.M() == null) ? "" : this.mTabController.M().F());
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        removeSpecTopicIcon();
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.f0();
        }
        d.a.k0.q0.b.e().k();
        d.a.k0.q0.a.h().n();
        d.a.k0.q0.a.h().c();
        d.a.k0.q0.c.c().a();
        if (!k.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.V(null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
        TbPageExtraHelper.u(getCurrentPageKey());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            return frsTabController.g0(i2, keyEvent);
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.h0(intent);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        d.a.j0.k0.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.i0();
        }
        long j = this.mSpecialTabPageStayTime;
        if (j >= 0) {
            long j2 = currentTimeMillis - j;
            if (j2 >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.v(j2);
                e.b().i(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i2, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i2, strArr, iArr);
        getFrsFragment().onRequestPermissionsResult(i2, strArr, iArr);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.doRefresh) {
            d.a.j0.z0.m0.f(this.mWeakContext);
            this.doRefresh = false;
        }
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.j0();
        }
        TbSingleton.getInstance().isInFrs = true;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.k0(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController != null) {
            frsTabController.l0(str);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.doRefresh = true;
    }

    public boolean onSuperKeyDown(int i2, KeyEvent keyEvent) {
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // d.a.k0.e.e.b
    public void setInjectPlugin(int i2, d.a.k0.e.e.a aVar) {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController instanceof d.a.k0.e.e.b) {
            frsTabController.setInjectPlugin(i2, aVar);
        }
    }

    @Override // d.a.k0.q0.m0
    public void setItemInfo(ItemInfo itemInfo) {
        this.mCommentTabItemInfo = itemInfo;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i2) {
        super.showLoadingView(view, z, i2);
        updateLoadingViewState(view, true);
    }

    public void showTabHost(boolean z) {
        FragmentTabHost N;
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController == null || (N = frsTabController.N()) == null || N.getFragmentTabWidget() == null) {
            return;
        }
        if (z) {
            N.d(2);
        } else {
            N.d(4);
        }
    }

    public void updateLoadingViewState(View view, boolean z) {
        if (view.getId() == R.id.frs) {
            TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
        } else if (view.getId() == 16908290) {
            TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
        }
        if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
            hideTransition();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.videoPreload.IVideoNeedPreload
    public boolean videoNeedPreload() {
        FrsTabController frsTabController = this.mTabController;
        if (frsTabController == null || frsTabController.M() == null) {
            return false;
        }
        return this.mTabController.M().videoNeedPreload();
    }
}
