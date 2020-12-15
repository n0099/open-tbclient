package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
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
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.PostPrefixData;
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
/* loaded from: classes22.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, an, FrsCommonImageLayout.c {
    private com.baidu.adp.lib.d.b<TbImageView> few;
    private FrsTabController iRS;
    private com.baidu.tieba.frs.e.f iRT;
    private com.baidu.adp.lib.d.b<TbImageView> iRU;
    private boolean iRV;
    public long iRX;
    private ItemInfo iRY;
    private GuidePopupWindow iRZ;
    private WeakReference<Context> mWeakContext;
    private boolean mIsFromSchema = false;
    boolean iRW = true;
    private com.baidu.tbadk.mutiprocess.h iSa = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private com.baidu.tbadk.mutiprocess.h iSb = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tbadk.mutiprocess.b
        public boolean a(GoodsEvent goodsEvent) {
            String str;
            String str2;
            int i;
            String str3;
            int i2;
            String str4;
            String str5;
            if (goodsEvent == null) {
                return false;
            }
            if (goodsEvent.getDispose()) {
                return true;
            }
            String goodsList = goodsEvent.getGoodsList();
            ForumWriteData cCO = FrsActivity.this.iRS.cBr().cCO();
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (cCO == null) {
                str = "";
                str2 = "";
                i = 0;
                str3 = null;
                i2 = -1;
                str4 = null;
                str5 = "0";
            } else {
                String str6 = cCO.forumId;
                String str7 = cCO.forumName;
                postPrefixData = cCO.prefixData;
                antiData = cCO.antiData;
                int i3 = cCO.forumLevel;
                String str8 = cCO.avatar;
                int i4 = cCO.privateThread;
                String str9 = cCO.firstDir;
                str = cCO.secondDir;
                str2 = str9;
                i = i4;
                str3 = str8;
                i2 = i3;
                str4 = str7;
                str5 = str6;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(FrsActivity.this, 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", cCO.mFrom);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(i2);
            writeActivityConfig.setForumAvatar(str3);
            writeActivityConfig.setPrivateThread(i);
            writeActivityConfig.setForumDir(str2, str);
            writeActivityConfig.setProfessionZone(cCO != null ? cCO.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(cCO != null ? cCO.frsTabInfo : null);
            writeActivityConfig.setGoodsList(goodsList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iDc = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cxh();
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
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bt("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.iRS = new FrsTabController(this);
        this.iRS.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.iRV = true;
            enterExitAnimation();
            if (this.iRT == null) {
                this.iRT = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.iRT.cJY();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.iSa);
        com.baidu.tieba.d.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.iRZ = new GuidePopupWindow(this);
        registerListener(this.iDc);
        this.iSb.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.iSb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxh() {
        if (cBp()) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_guide_popup_window_been_shown", true);
            cBo();
            com.baidu.adp.lib.f.g.showDialog(this.iRZ, this);
        }
    }

    private void cBo() {
        if (this.iRZ != null && this.iRS != null && this.iRS.cIm() != null && this.iRS.cIm().getForum() != null) {
            ForumData forum = this.iRS.cIm().getForum();
            this.iRZ.dXX();
            this.iRZ.f(this.iRS.cIm().getUserData());
            this.iRZ.Vu(forum.getName());
            this.iRZ.H(forum.getMember_num(), forum.getThread_num());
            this.iRZ.setForumId(Integer.parseInt(forum.getId()));
            this.iRZ.AX(forum.getName());
            this.iRZ.Vv(String.valueOf(this.iRS.cIm().getUserData().getLevel_id()));
        }
    }

    private boolean cBp() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.iRS == null || this.iRS.cIm() == null || this.iRS.cIm().getUserData() == null || this.iRS.cIm().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cBq() {
        if (this.iRS != null && this.iRS.cIm() != null && this.iRS.cIm().getForum() != null) {
            com.baidu.tbadk.core.util.aq.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.iRS.cIm().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.iRV || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iRS != null) {
            this.iRS.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iRW) {
            com.baidu.tbadk.util.ai.b(this.mWeakContext);
            this.iRW = false;
        }
        if (this.iRS != null) {
            this.iRS.onResume();
        }
        TbSingleton.getInstance().isInFrs = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.iRS != null) {
            this.iRS.onPause();
        }
        if (this.iRX >= 0) {
            long j = currentTimeMillis - this.iRX;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bEZ().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iRW = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBq();
        if (this.iRS != null) {
            this.iRS.onDestroy();
        }
        b.cBe().reset();
        a.cAX().reset();
        a.cAX().destory();
        c.cBi().destory();
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
        FrsNetModel frsNetModel = TbadkCoreApplication.getInst().getFrsModeArray().get(getUniqueId().getId());
        if (frsNetModel != null) {
            frsNetModel.a((NetModel.b) null);
        }
        TbadkCoreApplication.getInst().getFrsModeArray().remove(getUniqueId().getId());
        com.baidu.tbadk.pageExtra.d.En(getCurrentPageKey());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.iRS != null) {
            this.iRS.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.iRS != null) {
            this.iRS.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.iRS != null ? this.iRS.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.iRS != null) {
            this.iRS.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iRS != null) {
            return this.iRS.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iRS instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iRS.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        if (this.iRS instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iRS.ub(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iRS instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iRS.a(bVar);
        }
    }

    public FrsFragment cBr() {
        if (this.iRS == null) {
            return null;
        }
        return this.iRS.cBr();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBs() {
        if (this.iRU == null) {
            this.iRU = FrsCommonImageLayout.P(getPageContext().getPageActivity(), 12);
        }
        return this.iRU;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View bvQ() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bvR() {
        if (this.few == null) {
            this.few = UserIconBox.D(getPageContext().getPageActivity(), 8);
        }
        return this.few;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cBr().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void pP(boolean z) {
        FragmentTabHost cEf;
        if (this.iRS != null && (cEf = this.iRS.cEf()) != null && cEf.getFragmentTabWidget() != null) {
            if (z) {
                cEf.changeStyle(2);
            } else {
                cEf.changeStyle(4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        k(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i) {
        super.showLoadingView(view, z, i);
        k(view, true);
    }

    public void k(View view, boolean z) {
        if (view.getId() == R.id.frs) {
            TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
        } else if (view.getId() == 16908290) {
            TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
        }
        if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
            cBt();
        }
    }

    public void cBt() {
        if (this.iRT != null) {
            this.iRT.cBt();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iRS == null || this.iRS.cBr() == null) {
            return false;
        }
        return this.iRS.cBr().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.iRS != null && this.iRS.cIq() && this.iRS.cEf() != null && (this.iRS.cEf().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.iRS.cEf().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.iRS.cEf().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.iRS.cEf().getCurrentFragment()).getCurrentPageKey());
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
            if (this.iRS != null && this.iRS.cBr() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iRS.cBr().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Eu(TbadkCoreApplication.getInst().getAdAdSense().fje);
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
                return com.baidu.tbadk.m.e.bEZ().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.iRS != null) {
            tbPageTag = this.iRS.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ItemInfo itemInfo) {
        this.iRY = itemInfo;
    }

    @Override // com.baidu.tieba.frs.an
    public ItemInfo cBu() {
        return this.iRY;
    }

    @Override // com.baidu.tieba.frs.an
    public boolean cBv() {
        return (this.iRS == null || this.iRS.cBr() == null || this.iRS.cBr().cCd() == null || this.iRS.cBr().cCd().cLn() == null || this.iRS.cBr().cCd().cLn().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.iRS != null) {
            this.iRS.onScreenShot(str);
        }
    }
}
