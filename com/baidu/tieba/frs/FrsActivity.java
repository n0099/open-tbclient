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
    private com.baidu.adp.lib.d.b<TbImageView> flN;
    private FrsTabController jfs;
    private com.baidu.tieba.frs.c.f jft;
    private com.baidu.adp.lib.d.b<TbImageView> jfu;
    private boolean jfv;
    public long jfx;
    private ItemInfo jfy;
    private GuidePopupWindow jfz;
    private WeakReference<Context> mWeakContext;
    private boolean mIsFromSchema = false;
    boolean jfw = true;
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
    private com.baidu.tbadk.mutiprocess.h jfA = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            if (goodsEvent == null || FrsActivity.this.jfs.cBL() == null) {
                return false;
            }
            if (goodsEvent.getDispose()) {
                return true;
            }
            if (WriteActivityConfig.isAsyncWriting()) {
                return false;
            }
            WriteActivityConfig.newInstance(FrsActivity.this).setType(9).setForumWriteData(FrsActivity.this.jfs.cBL().cDk()).setCallFrom("2").setGoodsList(goodsEvent.getGoodsList()).send();
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iQD = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cxC();
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
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.b.kB().bo("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.jfs = new FrsTabController(this);
        this.jfs.init(bundle);
        if (com.baidu.tieba.frs.c.f.U(intent)) {
            this.jfv = true;
            enterExitAnimation();
            if (this.jft == null) {
                this.jft = new com.baidu.tieba.frs.c.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.jft.cKC();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.mTipsEventListener);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.jfz = new GuidePopupWindow(this);
        registerListener(this.iQD);
        this.jfA.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.jfA);
        com.baidu.tieba.h.a.cNq().b(this, "6051001642-2027944992", "c14005", PageStayDurationConstants.PageName.FRS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxC() {
        if (cBJ()) {
            com.baidu.tbadk.core.sharedPref.b.brQ().putBoolean("has_guide_popup_window_been_shown", true);
            cBI();
            com.baidu.adp.lib.f.g.showDialog(this.jfz, this);
        }
    }

    private void cBI() {
        if (this.jfz != null && this.jfs != null && this.jfs.cIP() != null && this.jfs.cIP().getForum() != null) {
            ForumData forum = this.jfs.cIP().getForum();
            this.jfz.dWf();
            this.jfz.e(this.jfs.cIP().getUserData());
            this.jfz.Vb(forum.getName());
            this.jfz.O(forum.getMember_num(), forum.getThread_num());
            this.jfz.setForumId(Integer.parseInt(forum.getId()));
            this.jfz.Ab(forum.getName());
            this.jfz.Vc(String.valueOf(this.jfs.cIP().getUserData().getLevel_id()));
        }
    }

    private boolean cBJ() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.brQ().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.jfs == null || this.jfs.cIP() == null || this.jfs.cIP().getUserData() == null || this.jfs.cIP().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cBK() {
        if (this.jfs != null && this.jfs.cIP() != null && this.jfs.cIP().getForum() != null) {
            com.baidu.tbadk.core.util.aq.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.jfs.cIP().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.jfv || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.jfs != null) {
            this.jfs.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jfw) {
            com.baidu.tbadk.util.ak.b(this.mWeakContext);
            this.jfw = false;
        }
        if (this.jfs != null) {
            this.jfs.onResume();
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
        if (this.jfs != null) {
            this.jfs.onPause();
        }
        if (this.jfx >= 0) {
            long j = currentTimeMillis - this.jfx;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bDS().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.jfw = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBK();
        if (this.jfs != null) {
            this.jfs.onDestroy();
        }
        b.cBy().reset();
        a.cBr().reset();
        a.cBr().destory();
        c.cBC().destory();
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.a((NetModel.b) null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
        com.baidu.tbadk.pageExtra.d.Dn(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.jfs != null) {
            this.jfs.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.jfs != null) {
            this.jfs.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.jfs != null ? this.jfs.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.jfs != null) {
            this.jfs.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.jfs != null) {
            return this.jfs.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.jfs instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jfs.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sM(int i) {
        if (this.jfs instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.jfs.sM(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.jfs instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.jfs.a(bVar);
        }
    }

    public FrsFragment cBL() {
        if (this.jfs == null) {
            return null;
        }
        return this.jfs.cBL();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBM() {
        if (this.jfu == null) {
            this.jfu = FrsCommonImageLayout.Q(getPageContext().getPageActivity(), 12);
        }
        return this.jfu;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.a
    public com.baidu.adp.lib.d.b<TbImageView> buM() {
        if (this.flN == null) {
            this.flN = UserIconBox.E(getPageContext().getPageActivity(), 8);
        }
        return this.flN;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cBL().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void qs(boolean z) {
        FragmentTabHost cEC;
        if (this.jfs != null && (cEC = this.jfs.cEC()) != null && cEC.getFragmentTabWidget() != null) {
            if (z) {
                cEC.changeStyle(2);
            } else {
                cEC.changeStyle(4);
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
            cBN();
        }
    }

    public void cBN() {
        if (this.jft != null) {
            this.jft.cBN();
        }
    }

    @Override // com.baidu.tbadk.core.util.g.b
    public boolean videoNeedPreload() {
        if (this.jfs == null || this.jfs.cBL() == null) {
            return false;
        }
        return this.jfs.cBL().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.jfs != null && this.jfs.cIT() && this.jfs.cEC() != null && (this.jfs.cEC().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.jfs.cEC().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.jfs.cEC().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.jfs.cEC().getCurrentFragment()).getCurrentPageKey());
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
            if (this.jfs != null && this.jfs.cBL() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.jfs.cBL().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Du(TbadkCoreApplication.getInst().getAdAdSense().fqv);
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
                return com.baidu.tbadk.m.e.bDS().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.jfs != null) {
            tbPageTag = this.jfs.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ak
    public void a(ItemInfo itemInfo) {
        this.jfy = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ak
    public ItemInfo cBO() {
        return this.jfy;
    }

    @Override // com.baidu.tieba.frs.ak
    public boolean cBP() {
        return (this.jfs == null || this.jfs.cBL() == null || this.jfs.cBL().cCz() == null || this.jfs.cBL().cCz().cLU() == null || this.jfs.cBL().cCz().cLU().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.jfs != null) {
            this.jfs.onScreenShot(str);
        }
    }
}
