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
    private FrsTabController iRQ;
    private com.baidu.tieba.frs.e.f iRR;
    private com.baidu.adp.lib.d.b<TbImageView> iRS;
    private boolean iRT;
    public long iRV;
    private ItemInfo iRW;
    private GuidePopupWindow iRX;
    private WeakReference<Context> mWeakContext;
    private boolean mIsFromSchema = false;
    boolean iRU = true;
    private com.baidu.tbadk.mutiprocess.h iRY = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private com.baidu.tbadk.mutiprocess.h iRZ = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
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
            ForumWriteData cCN = FrsActivity.this.iRQ.cBq().cCN();
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (cCN == null) {
                str = "";
                str2 = "";
                i = 0;
                str3 = null;
                i2 = -1;
                str4 = null;
                str5 = "0";
            } else {
                String str6 = cCN.forumId;
                String str7 = cCN.forumName;
                postPrefixData = cCN.prefixData;
                antiData = cCN.antiData;
                int i3 = cCN.forumLevel;
                String str8 = cCN.avatar;
                int i4 = cCN.privateThread;
                String str9 = cCN.firstDir;
                str = cCN.secondDir;
                str2 = str9;
                i = i4;
                str3 = str8;
                i2 = i3;
                str4 = str7;
                str5 = str6;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(FrsActivity.this, 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", cCN.mFrom);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(i2);
            writeActivityConfig.setForumAvatar(str3);
            writeActivityConfig.setPrivateThread(i);
            writeActivityConfig.setForumDir(str2, str);
            writeActivityConfig.setProfessionZone(cCN != null ? cCN.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(cCN != null ? cCN.frsTabInfo : null);
            writeActivityConfig.setGoodsList(goodsList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iDa = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cxg();
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
        this.iRQ = new FrsTabController(this);
        this.iRQ.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.iRT = true;
            enterExitAnimation();
            if (this.iRR == null) {
                this.iRR = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.iRR.cJX();
        }
        this.mWeakContext = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.iRY);
        com.baidu.tieba.d.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.iRX = new GuidePopupWindow(this);
        registerListener(this.iDa);
        this.iRZ.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.iRZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cxg() {
        if (cBo()) {
            com.baidu.tbadk.core.sharedPref.b.bsO().putBoolean("has_guide_popup_window_been_shown", true);
            cBn();
            com.baidu.adp.lib.f.g.showDialog(this.iRX, this);
        }
    }

    private void cBn() {
        if (this.iRX != null && this.iRQ != null && this.iRQ.cIl() != null && this.iRQ.cIl().getForum() != null) {
            ForumData forum = this.iRQ.cIl().getForum();
            this.iRX.dXW();
            this.iRX.f(this.iRQ.cIl().getUserData());
            this.iRX.Vu(forum.getName());
            this.iRX.H(forum.getMember_num(), forum.getThread_num());
            this.iRX.setForumId(Integer.parseInt(forum.getId()));
            this.iRX.AX(forum.getName());
            this.iRX.Vv(String.valueOf(this.iRQ.cIl().getUserData().getLevel_id()));
        }
    }

    private boolean cBo() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bsO().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.iRQ == null || this.iRQ.cIl() == null || this.iRQ.cIl().getUserData() == null || this.iRQ.cIl().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cBp() {
        if (this.iRQ != null && this.iRQ.cIl() != null && this.iRQ.cIl().getForum() != null) {
            com.baidu.tbadk.core.util.aq.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.iRQ.cIl().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.iRT || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iRQ != null) {
            this.iRQ.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iRU) {
            com.baidu.tbadk.util.ai.b(this.mWeakContext);
            this.iRU = false;
        }
        if (this.iRQ != null) {
            this.iRQ.onResume();
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
        if (this.iRQ != null) {
            this.iRQ.onPause();
        }
        if (this.iRV >= 0) {
            long j = currentTimeMillis - this.iRV;
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
        this.iRU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cBp();
        if (this.iRQ != null) {
            this.iRQ.onDestroy();
        }
        b.cBd().reset();
        a.cAW().reset();
        a.cAW().destory();
        c.cBh().destory();
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
        if (this.iRQ != null) {
            this.iRQ.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.iRQ != null) {
            this.iRQ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.iRQ != null ? this.iRQ.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.iRQ != null) {
            this.iRQ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iRQ != null) {
            return this.iRQ.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iRQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iRQ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ub(int i) {
        if (this.iRQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iRQ.ub(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iRQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iRQ.a(bVar);
        }
    }

    public FrsFragment cBq() {
        if (this.iRQ == null) {
            return null;
        }
        return this.iRQ.cBq();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cBr() {
        if (this.iRS == null) {
            this.iRS = FrsCommonImageLayout.P(getPageContext().getPageActivity(), 12);
        }
        return this.iRS;
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
        cBq().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void pP(boolean z) {
        FragmentTabHost cEe;
        if (this.iRQ != null && (cEe = this.iRQ.cEe()) != null && cEe.getFragmentTabWidget() != null) {
            if (z) {
                cEe.changeStyle(2);
            } else {
                cEe.changeStyle(4);
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
            cBs();
        }
    }

    public void cBs() {
        if (this.iRR != null) {
            this.iRR.cBs();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iRQ == null || this.iRQ.cBq() == null) {
            return false;
        }
        return this.iRQ.cBq().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.iRQ != null && this.iRQ.cIp() && this.iRQ.cEe() != null && (this.iRQ.cEe().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.iRQ.cEe().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.iRQ.cEe().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.iRQ.cEe().getCurrentFragment()).getCurrentPageKey());
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
            if (this.iRQ != null && this.iRQ.cBq() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iRQ.cBq().forumId, 0L));
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
        if (this.iRQ != null) {
            tbPageTag = this.iRQ.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.an
    public void a(ItemInfo itemInfo) {
        this.iRW = itemInfo;
    }

    @Override // com.baidu.tieba.frs.an
    public ItemInfo cBt() {
        return this.iRW;
    }

    @Override // com.baidu.tieba.frs.an
    public boolean cBu() {
        return (this.iRQ == null || this.iRQ.cBq() == null || this.iRQ.cBq().cCc() == null || this.iRQ.cBq().cCc().cLm() == null || this.iRQ.cBq().cCc().cLm().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.iRQ != null) {
            this.iRQ.onScreenShot(str);
        }
    }
}
