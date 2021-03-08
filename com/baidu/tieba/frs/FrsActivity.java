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
    private com.baidu.adp.lib.d.b<TbImageView> fnn;
    private FrsTabController jhb;
    private com.baidu.tieba.frs.c.f jhc;
    private com.baidu.adp.lib.d.b<TbImageView> jhd;
    private boolean jhe;
    public long jhg;
    private ItemInfo jhh;
    private GuidePopupWindow jhi;
    private WeakReference<Context> mWeakContext;
    private boolean mIsFromSchema = false;
    boolean jhf = true;
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
    private com.baidu.tbadk.mutiprocess.h jhj = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent == null || FrsActivity.this.jhb.cBR() == null) {
                return false;
            }
            if (goodsEvent.getDispose()) {
                return true;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(FrsActivity.this).setType(9).setForumWriteData(FrsActivity.this.jhb.cBR().cDq()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iSm = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cxI();
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
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bs("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.jhb = new FrsTabController(this);
        this.jhb.init(bundle);
        if (com.baidu.tieba.frs.c.f.U(intent)) {
            this.jhe = true;
            enterExitAnimation();
            if (this.jhc == null) {
                this.jhc = new com.baidu.tieba.frs.c.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.jhc.cKI();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.jhi = new GuidePopupWindow(this);
        registerListener(this.iSm);
        this.jhj.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.jhj);
        com.baidu.tieba.h.a.cNx().aq(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxI() {
        if (cBP()) {
            com.baidu.tbadk.core.sharedPref.b.brR().putBoolean("has_guide_popup_window_been_shown", true);
            cBO();
            com.baidu.adp.lib.f.g.showDialog(this.jhi, this);
        }
    }

    private void cBO() {
        if (this.jhi != null && this.jhb != null && this.jhb.cIV() != null && this.jhb.cIV().getForum() != null) {
            ForumData forum = this.jhb.cIV().getForum();
            this.jhi.dWn();
            this.jhi.e(this.jhb.cIV().getUserData());
            this.jhi.Vi(forum.getName());
            this.jhi.O(forum.getMember_num(), forum.getThread_num());
            this.jhi.setForumId(Integer.parseInt(forum.getId()));
            this.jhi.Ai(forum.getName());
            this.jhi.Vj(String.valueOf(this.jhb.cIV().getUserData().getLevel_id()));
        }
    }

    private boolean cBP() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brR().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.jhb == null || this.jhb.cIV() == null || this.jhb.cIV().getUserData() == null || this.jhb.cIV().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cBQ() {
        if (this.jhb != null && this.jhb.cIV() != null && this.jhb.cIV().getForum() != null) {
            com.baidu.tbadk.core.util.aq.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.jhb.cIV().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.jhe || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jhb != null) {
            this.jhb.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jhf) {
            com.baidu.tbadk.util.ak.b(this.mWeakContext);
            this.jhf = false;
        }
        if (this.jhb != null) {
            this.jhb.onResume();
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
        if (this.jhb != null) {
            this.jhb.onPause();
        }
        if (this.jhg >= 0) {
            long j = currentTimeMillis - this.jhg;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bDW().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jhf = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBQ();
        if (this.jhb != null) {
            this.jhb.onDestroy();
        }
        b.cBE().reset();
        a.cBx().reset();
        a.cBx().destory();
        c.cBI().destory();
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.a((NetModel.b) null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
        com.baidu.tbadk.pageExtra.d.Du(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.jhb != null) {
            this.jhb.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jhb != null) {
            this.jhb.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.jhb != null ? this.jhb.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.jhb != null) {
            this.jhb.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jhb != null) {
            return this.jhb.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jhb instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jhb.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sO(int i) {
        if (this.jhb instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jhb.sO(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jhb instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jhb.a(bVar);
        }
    }

    public FrsFragment cBR() {
        if (this.jhb == null) {
            return null;
        }
        return this.jhb.cBR();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBS() {
        if (this.jhd == null) {
            this.jhd = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.jhd;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buP() {
        if (this.fnn == null) {
            this.fnn = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.fnn;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cBR().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void qs(boolean z) {
        FragmentTabHost cEI;
        if (this.jhb != null && (cEI = this.jhb.cEI()) != null && cEI.getFragmentTabWidget() != null) {
            if (z) {
                cEI.changeStyle(2);
            } else {
                cEI.changeStyle(4);
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
            cBT();
        }
    }

    public void cBT() {
        if (this.jhc != null) {
            this.jhc.cBT();
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jhb == null || this.jhb.cBR() == null) {
            return false;
        }
        return this.jhb.cBR().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.jhb != null && this.jhb.cIZ() && this.jhb.cEI() != null && (this.jhb.cEI().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.jhb.cEI().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.jhb.cEI().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.jhb.cEI().getCurrentFragment()).getCurrentPageKey());
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
            if (this.jhb != null && this.jhb.cBR() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jhb.cBR().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DB(TbadkCoreApplication.getInst().getAdAdSense().frW);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public com.baidu.tbadk.m.b getPageStayFilter() {
        return new com.baidu.tbadk.m.b() { // from class: com.baidu.tieba.frs.FrsActivity.4
            @Override // com.baidu.tbadk.m.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.m.b
            public int getMaxCost() {
                return com.baidu.tbadk.m.e.bDW().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.jhb != null) {
            tbPageTag = this.jhb.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ItemInfo itemInfo) {
        this.jhh = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ak
    public ItemInfo cBU() {
        return this.jhh;
    }

    @Override // com.baidu.tieba.frs.ak
    public boolean cBV() {
        return (this.jhb == null || this.jhb.cBR() == null || this.jhb.cBR().cCF() == null || this.jhb.cBR().cCF().cMa() == null || this.jhb.cBR().cCF().cMa().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.jhb != null) {
            this.jhb.onScreenShot(str);
        }
    }
}
