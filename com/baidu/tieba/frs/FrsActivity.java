package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
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
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import tbclient.ItemInfo;
/* loaded from: classes9.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, am, FrsCommonImageLayout.c {
    private WeakReference<Context> ajK;
    private com.baidu.adp.lib.d.b<TbImageView> efk;
    private FrsTabController hyI;
    private com.baidu.tieba.frs.e.f hyJ;
    private com.baidu.adp.lib.d.b<TbImageView> hyK;
    private boolean hyL;
    public long hyN;
    private ItemInfo hyO;
    private boolean mIsFromSchema = false;
    boolean hyM = true;
    private com.baidu.tbadk.mutiprocess.h hyP = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
        this.hyI = new FrsTabController(this);
        this.hyI.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.hyL = true;
            enterExitAnimation();
            if (this.hyJ == null) {
                this.hyJ = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.hyJ.ceH();
        }
        this.ajK = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.hyP);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.hyL || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hyI != null) {
            this.hyI.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hyM) {
            com.baidu.tbadk.util.ag.b(this.ajK);
            this.hyM = false;
        }
        if (this.hyI != null) {
            this.hyI.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.hyI != null) {
            this.hyI.onPause();
        }
        if (this.hyN >= 0) {
            long j = currentTimeMillis - this.hyN;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bhB().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hyM = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hyI != null) {
            this.hyI.onDestroy();
        }
        b.bXd().reset();
        a.bWW().reset();
        a.bWW().destory();
        c.bXh().destory();
        if (!com.baidu.tbadk.core.util.ar.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        if (this.hyI != null) {
            this.hyI.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hyI != null) {
            this.hyI.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hyI != null ? this.hyI.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.hyI != null) {
            this.hyI.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hyI != null) {
            return this.hyI.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hyI instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hyI.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a pm(int i) {
        if (this.hyI instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hyI.pm(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hyI instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hyI.a(bVar);
        }
    }

    public FrsFragment bXn() {
        if (this.hyI == null) {
            return null;
        }
        return this.hyI.bXn();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bXo() {
        if (this.hyK == null) {
            this.hyK = FrsCommonImageLayout.B(getPageContext().getPageActivity(), 12);
        }
        return this.hyK;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View aYH() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aYI() {
        if (this.efk == null) {
            this.efk = UserIconBox.t(getPageContext().getPageActivity(), 8);
        }
        return this.efk;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        bXn().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void mS(boolean z) {
        FragmentTabHost bZV;
        if (this.hyI != null && (bZV = this.hyI.bZV()) != null && bZV.getFragmentTabWidget() != null) {
            if (z) {
                bZV.changeStyle(2);
            } else {
                bZV.changeStyle(4);
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
            bXp();
        }
    }

    public void bXp() {
        if (this.hyJ != null) {
            this.hyJ.bXp();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.hyI == null || this.hyI.bXn() == null) {
            return false;
        }
        return this.hyI.bXn().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.uL("cyber_player_test") || com.baidu.tbadk.a.b.uK("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.hyI != null && this.hyI.ccZ() && this.hyI.bZV() != null && (this.hyI.bZV().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.hyI.bZV().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.hyI.bZV().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.hyI.bZV().getCurrentFragment()).getCurrentPageKey());
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
            if (this.hyI != null && this.hyI.bXn() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.hyI.bXn().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.yX(TbadkCoreApplication.getInst().getAdAdSense().ejy);
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
                return com.baidu.tbadk.m.e.bhB().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.hyI != null) {
            tbPageTag = this.hyI.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.am
    public void a(ItemInfo itemInfo) {
        this.hyO = itemInfo;
    }

    @Override // com.baidu.tieba.frs.am
    public ItemInfo bXq() {
        return this.hyO;
    }

    @Override // com.baidu.tieba.frs.am
    public boolean bXr() {
        return (this.hyI == null || this.hyI.bXn() == null || this.hyI.bXn().bXY() == null || this.hyI.bXn().bXY().cfQ() == null || this.hyI.bXn().bXY().cfQ().tabType != 16) ? false : true;
    }
}
