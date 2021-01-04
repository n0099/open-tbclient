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
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
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
/* loaded from: classes2.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.g.b, UserIconBox.a, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ak, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.d.b<TbImageView> fof;
    private FrsTabController jee;
    private com.baidu.tieba.frs.c.f jef;
    private com.baidu.adp.lib.d.b<TbImageView> jeg;
    private boolean jeh;
    public long jej;
    private ItemInfo jek;
    private GuidePopupWindow jel;
    private WeakReference<Context> mWeakContext;
    private boolean mIsFromSchema = false;
    boolean jei = true;
    private com.baidu.tbadk.mutiprocess.h mTipsEventListener = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(TipEvent tipEvent) {
            if (tipEvent.pageId > 0 && FrsActivity.this.getPageId() == tipEvent.pageId) {
                DefaultNavigationBarCoverTip.d(FrsActivity.this.getActivity(), tipEvent.message, tipEvent.linkUrl).show();
                return true;
            }
            return true;
        }
    };
    private com.baidu.tbadk.mutiprocess.h jem = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent == null || FrsActivity.this.jee.cEk() == null) {
                return false;
            }
            if (goodsEvent.getDispose()) {
                return true;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(FrsActivity.this).setType(9).setForumWriteData(FrsActivity.this.jee.cEk().cFI()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iPo = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cAa();
        }
    };
    private CustomMessageListener jen = new CustomMessageListener(2921527) { // from class: com.baidu.tieba.frs.FrsActivity.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            com.baidu.tieba.funad.a.aw(FrsActivity.this);
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        BdUniqueId bdUniqueId;
        Intent intent = getIntent();
        if (intent != null) {
            BdUniqueId bdUniqueId2 = (BdUniqueId) intent.getSerializableExtra(FrsActivityConfig.FRS_PAGE_ID);
            if (bdUniqueId2 != null) {
                setUniqueId(bdUniqueId2);
            }
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kC().bo("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.jee = new FrsTabController(this);
        this.jee.init(bundle);
        if (com.baidu.tieba.frs.c.f.U(intent)) {
            this.jeh = true;
            enterExitAnimation();
            if (this.jef == null) {
                this.jef = new com.baidu.tieba.frs.c.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.jef.cMZ();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.jel = new GuidePopupWindow(this);
        registerListener(this.iPo);
        registerListener(this.jen);
        this.jem.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.jem);
        com.baidu.tieba.funad.a.aw(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cAa() {
        if (cEi()) {
            com.baidu.tbadk.core.sharedPref.b.bvq().putBoolean("has_guide_popup_window_been_shown", true);
            cEh();
            com.baidu.adp.lib.f.g.showDialog(this.jel, this);
        }
    }

    private void cEh() {
        if (this.jel != null && this.jee != null && this.jee.cLm() != null && this.jee.cLm().getForum() != null) {
            ForumData forum = this.jee.cLm().getForum();
            this.jel.dXA();
            this.jel.e(this.jee.cLm().getUserData());
            this.jel.UZ(forum.getName());
            this.jel.K(forum.getMember_num(), forum.getThread_num());
            this.jel.setForumId(Integer.parseInt(forum.getId()));
            this.jel.AW(forum.getName());
            this.jel.Va(String.valueOf(this.jee.cLm().getUserData().getLevel_id()));
        }
    }

    private boolean cEi() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bvq().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.jee == null || this.jee.cLm() == null || this.jee.cLm().getUserData() == null || this.jee.cLm().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cEj() {
        if (this.jee != null && this.jee.cLm() != null && this.jee.cLm().getForum() != null) {
            com.baidu.tbadk.core.util.ap.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.jee.cLm().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.jeh || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jee != null) {
            this.jee.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jei) {
            com.baidu.tbadk.util.ah.b(this.mWeakContext);
            this.jei = false;
        }
        if (this.jee != null) {
            this.jee.onResume();
        }
        TbSingleton.getInstance().isInFrs = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.jee != null) {
            this.jee.onPause();
        }
        if (this.jej >= 0) {
            long j = currentTimeMillis - this.jej;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bHs().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jei = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cEj();
        if (this.jee != null) {
            this.jee.onDestroy();
        }
        b.cDX().reset();
        a.cDQ().reset();
        a.cDQ().destory();
        c.cEb().destory();
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.a((NetModel.b) null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
        com.baidu.tbadk.pageExtra.d.Ek(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.jee != null) {
            this.jee.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jee != null) {
            this.jee.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.jee != null ? this.jee.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.jee != null) {
            this.jee.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jee != null) {
            return this.jee.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jee instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jee.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a un(int i) {
        if (this.jee instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jee.un(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jee instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jee.a(bVar);
        }
    }

    public FrsFragment cEk() {
        if (this.jee == null) {
            return null;
        }
        return this.jee.cEk();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cEl() {
        if (this.jeg == null) {
            this.jeg = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.jeg;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> byl() {
        if (this.fof == null) {
            this.fof = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fof;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cEk().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void qm(boolean z) {
        FragmentTabHost cHa;
        if (this.jee != null && (cHa = this.jee.cHa()) != null && cHa.getFragmentTabWidget() != null) {
            if (z) {
                cHa.changeStyle(2);
            } else {
                cHa.changeStyle(4);
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
            cEm();
        }
    }

    public void cEm() {
        if (this.jef != null) {
            this.jef.cEm();
        }
    }

    @Override // com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jee == null || this.jee.cEk() == null) {
            return false;
        }
        return this.jee.cEk().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.jee != null && this.jee.cLq() && this.jee.cHa() != null && (this.jee.cHa().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.jee.cHa().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.jee.cHa().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.jee.cHa().getCurrentFragment()).getCurrentPageKey());
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
            if (this.jee != null && this.jee.cEk() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jee.cEk().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Er(TbadkCoreApplication.getInst().getAdAdSense().fsN);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.frs.FrsActivity.5
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bHs().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.jee != null) {
            tbPageTag = this.jee.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ItemInfo itemInfo) {
        this.jek = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ak
    public ItemInfo cEn() {
        return this.jek;
    }

    @Override // com.baidu.tieba.frs.ak
    public boolean cEo() {
        return (this.jee == null || this.jee.cEk() == null || this.jee.cEk().cEX() == null || this.jee.cEk().cEX().cOq() == null || this.jee.cEk().cEX().cOq().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.jee != null) {
            this.jee.onScreenShot(str);
        }
    }
}
