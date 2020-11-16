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
/* loaded from: classes21.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, FrsCommonImageLayout.c {
    private WeakReference<Context> alV;
    private com.baidu.adp.lib.d.b<TbImageView> eWZ;
    private FrsTabController iGY;
    private com.baidu.tieba.frs.e.f iGZ;
    private com.baidu.adp.lib.d.b<TbImageView> iHa;
    private boolean iHb;
    public long iHd;
    private ItemInfo iHe;
    private GuidePopupWindow iHf;
    private boolean mIsFromSchema = false;
    boolean iHc = true;
    private com.baidu.tbadk.mutiprocess.h iHg = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private com.baidu.tbadk.mutiprocess.h iHh = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
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
            ForumWriteData cyw = FrsActivity.this.iGY.cxb().cyw();
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (cyw == null) {
                str = "";
                str2 = "";
                i = 0;
                str3 = null;
                i2 = -1;
                str4 = null;
                str5 = "0";
            } else {
                String str6 = cyw.forumId;
                String str7 = cyw.forumName;
                postPrefixData = cyw.prefixData;
                antiData = cyw.antiData;
                int i3 = cyw.forumLevel;
                String str8 = cyw.avatar;
                int i4 = cyw.privateThread;
                String str9 = cyw.firstDir;
                str = cyw.secondDir;
                str2 = str9;
                i = i4;
                str3 = str8;
                i2 = i3;
                str4 = str7;
                str5 = str6;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(FrsActivity.this, 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", cyw.mFrom);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(i2);
            writeActivityConfig.setForumAvatar(str3);
            writeActivityConfig.setPrivateThread(i);
            writeActivityConfig.setForumDir(str2, str);
            writeActivityConfig.setProfessionZone(cyw != null ? cyw.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(cyw != null ? cyw.frsTabInfo : null);
            writeActivityConfig.setGoodsList(goodsList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener isi = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.csR();
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
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lg().bq("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.iGY = new FrsTabController(this);
        this.iGY.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.iHb = true;
            enterExitAnimation();
            if (this.iGZ == null) {
                this.iGZ = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.iGZ.cEK();
        }
        this.alV = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.iHg);
        com.baidu.tieba.d.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.iHf = new GuidePopupWindow(this);
        registerListener(this.isi);
        this.iHh.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.iHh);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void csR() {
        if (cwZ()) {
            com.baidu.tbadk.core.sharedPref.b.bpu().putBoolean("has_guide_popup_window_been_shown", true);
            cwY();
            com.baidu.adp.lib.f.g.showDialog(this.iHf, this);
        }
    }

    private void cwY() {
        if (this.iHf != null && this.iGY != null && this.iGY.cCY() != null && this.iGY.cCY().getForum() != null) {
            ForumData forum = this.iGY.cCY().getForum();
            this.iHf.dSC();
            this.iHf.f(this.iGY.cCY().getUserData());
            this.iHf.Uf(forum.getName());
            this.iHf.I(forum.getMember_num(), forum.getThread_num());
            this.iHf.setForumId(Integer.parseInt(forum.getId()));
            this.iHf.Aq(forum.getName());
            this.iHf.Ug(String.valueOf(this.iGY.cCY().getUserData().getLevel_id()));
        }
    }

    private boolean cwZ() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bpu().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.iGY == null || this.iGY.cCY() == null || this.iGY.cCY().getUserData() == null || this.iGY.cCY().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    private void cxa() {
        if (this.iGY != null && this.iGY.cCY() != null && this.iGY.cCY().getForum() != null) {
            com.baidu.tbadk.core.util.aq.e(Long.valueOf(com.baidu.adp.lib.f.b.toLong(this.iGY.cCY().getForum().getId(), 0L)));
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.iHb || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iGY != null) {
            this.iGY.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iHc) {
            com.baidu.tbadk.util.ah.b(this.alV);
            this.iHc = false;
        }
        if (this.iGY != null) {
            this.iGY.onResume();
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
        if (this.iGY != null) {
            this.iGY.onPause();
        }
        if (this.iHd >= 0) {
            long j = currentTimeMillis - this.iHd;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bBw().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iHc = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        cxa();
        if (this.iGY != null) {
            this.iGY.onDestroy();
        }
        b.cwO().reset();
        a.cwH().reset();
        a.cwH().destory();
        c.cwS().destory();
        if (!com.baidu.tbadk.core.util.au.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        if (this.iGY != null) {
            this.iGY.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.iGY != null) {
            this.iGY.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.iGY != null ? this.iGY.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.iGY != null) {
            this.iGY.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iGY != null) {
            return this.iGY.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iGY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iGY.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ty(int i) {
        if (this.iGY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iGY.ty(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iGY instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iGY.a(bVar);
        }
    }

    public FrsFragment cxb() {
        if (this.iGY == null) {
            return null;
        }
        return this.iGY.cxb();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxc() {
        if (this.iHa == null) {
            this.iHa = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.iHa;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View bsq() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> bsr() {
        if (this.eWZ == null) {
            this.eWZ = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eWZ;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cxb().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void ps(boolean z) {
        FragmentTabHost czO;
        if (this.iGY != null && (czO = this.iGY.czO()) != null && czO.getFragmentTabWidget() != null) {
            if (z) {
                czO.changeStyle(2);
            } else {
                czO.changeStyle(4);
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
            cxd();
        }
    }

    public void cxd() {
        if (this.iGZ != null) {
            this.iGZ.cxd();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iGY == null || this.iGY.cxb() == null) {
            return false;
        }
        return this.iGY.cxb().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.iGY != null && this.iGY.cDc() && this.iGY.czO() != null && (this.iGY.czO().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.iGY.czO().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.iGY.czO().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.iGY.czO().getCurrentFragment()).getCurrentPageKey());
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
            if (this.iGY != null && this.iGY.cxb() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iGY.cxb().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.DJ(TbadkCoreApplication.getInst().getAdAdSense().fbE);
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
                return com.baidu.tbadk.m.e.bBw().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.iGY != null) {
            tbPageTag = this.iGY.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ao
    public void a(ItemInfo itemInfo) {
        this.iHe = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ao
    public ItemInfo cxe() {
        return this.iHe;
    }

    @Override // com.baidu.tieba.frs.ao
    public boolean cxf() {
        return (this.iGY == null || this.iGY.cxb() == null || this.iGY.cxb().cxM() == null || this.iGY.cxb().cxM().cFX() == null || this.iGY.cxb().cxM().cFX().tabType != 16) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onScreenShot(String str) {
        super.onScreenShot(str);
        if (this.iGY != null) {
            this.iGY.onScreenShot(str);
        }
    }
}
