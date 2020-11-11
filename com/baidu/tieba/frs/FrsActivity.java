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
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.b, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, ao, FrsCommonImageLayout.c {
    private WeakReference<Context> alP;
    private com.baidu.adp.lib.d.b<TbImageView> eXS;
    private FrsTabController iGk;
    private com.baidu.tieba.frs.e.f iGl;
    private com.baidu.adp.lib.d.b<TbImageView> iGm;
    private boolean iGn;
    public long iGp;
    private ItemInfo iGq;
    private GuidePopupWindow iGr;
    private boolean mIsFromSchema = false;
    boolean iGo = true;
    private com.baidu.tbadk.mutiprocess.h iGs = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private com.baidu.tbadk.mutiprocess.h iGt = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
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
            ForumWriteData cyT = FrsActivity.this.iGk.cxy().cyT();
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (cyT == null) {
                str = "";
                str2 = "";
                i = 0;
                str3 = null;
                i2 = -1;
                str4 = null;
                str5 = "0";
            } else {
                String str6 = cyT.forumId;
                String str7 = cyT.forumName;
                postPrefixData = cyT.prefixData;
                antiData = cyT.antiData;
                int i3 = cyT.forumLevel;
                String str8 = cyT.avatar;
                int i4 = cyT.privateThread;
                String str9 = cyT.firstDir;
                str = cyT.secondDir;
                str2 = str9;
                i = i4;
                str3 = str8;
                i2 = i3;
                str4 = str7;
                str5 = str6;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(FrsActivity.this, 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", cyT.mFrom);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(i2);
            writeActivityConfig.setForumAvatar(str3);
            writeActivityConfig.setPrivateThread(i);
            writeActivityConfig.setForumDir(str2, str);
            writeActivityConfig.setProfessionZone(cyT != null ? cyT.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(cyT != null ? cyT.frsTabInfo : null);
            writeActivityConfig.setGoodsList(goodsList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener iru = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.cto();
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
        this.iGk = new FrsTabController(this);
        this.iGk.init(bundle);
        if (com.baidu.tieba.frs.e.f.T(intent)) {
            this.iGn = true;
            enterExitAnimation();
            if (this.iGl == null) {
                this.iGl = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.iGl.cFf();
        }
        this.alP = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.iGs);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.iGr = new GuidePopupWindow(this);
        registerListener(this.iru);
        this.iGt.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.iGt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cto() {
        if (cxx()) {
            com.baidu.tbadk.core.sharedPref.b.bqh().putBoolean("has_guide_popup_window_been_shown", true);
            cxw();
            com.baidu.adp.lib.f.g.showDialog(this.iGr, this);
        }
    }

    private void cxw() {
        if (this.iGr != null && this.iGk != null && this.iGk.cDu() != null && this.iGk.cDu().getForum() != null) {
            ForumData forum = this.iGk.cDu().getForum();
            this.iGr.dSD();
            this.iGr.f(this.iGk.cDu().getUserData());
            this.iGr.Uu(forum.getName());
            this.iGr.I(forum.getMember_num(), forum.getThread_num());
            this.iGr.setForumId(Integer.parseInt(forum.getId()));
            this.iGr.AV(forum.getName());
            this.iGr.Uv(String.valueOf(this.iGk.cDu().getUserData().getLevel_id()));
        }
    }

    private boolean cxx() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bqh().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.iGk == null || this.iGk.cDu() == null || this.iGk.cDu().getUserData() == null || this.iGk.cDu().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.iGn || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.iGk != null) {
            this.iGk.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.iGo) {
            com.baidu.tbadk.util.ai.b(this.alP);
            this.iGo = false;
        }
        if (this.iGk != null) {
            this.iGk.onResume();
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
        if (this.iGk != null) {
            this.iGk.onPause();
        }
        if (this.iGp >= 0) {
            long j = currentTimeMillis - this.iGp;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bCg().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.iGo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.iGk != null) {
            this.iGk.onDestroy();
        }
        b.cxm().reset();
        a.cxf().reset();
        a.cxf().destory();
        c.cxq().destory();
        if (!com.baidu.tbadk.core.util.at.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
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
        if (this.iGk != null) {
            this.iGk.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.iGk != null) {
            this.iGk.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.iGk != null ? this.iGk.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.iGk != null) {
            this.iGk.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.iGk != null) {
            return this.iGk.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.iGk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iGk.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a ta(int i) {
        if (this.iGk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.iGk.ta(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.iGk instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.iGk.a(bVar);
        }
    }

    public FrsFragment cxy() {
        if (this.iGk == null) {
            return null;
        }
        return this.iGk.cxy();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cxz() {
        if (this.iGm == null) {
            this.iGm = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.iGm;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View bta() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> btb() {
        if (this.eXS == null) {
            this.eXS = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.eXS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cxy().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void pp(boolean z) {
        FragmentTabHost cAl;
        if (this.iGk != null && (cAl = this.iGk.cAl()) != null && cAl.getFragmentTabWidget() != null) {
            if (z) {
                cAl.changeStyle(2);
            } else {
                cAl.changeStyle(4);
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
            cxA();
        }
    }

    public void cxA() {
        if (this.iGl != null) {
            this.iGl.cxA();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.iGk == null || this.iGk.cxy() == null) {
            return false;
        }
        return this.iGk.cxy().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.iGk != null && this.iGk.cDy() && this.iGk.cAl() != null && (this.iGk.cAl().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.iGk.cAl().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.iGk.cAl().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.iGk.cAl().getCurrentFragment()).getCurrentPageKey());
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
            if (this.iGk != null && this.iGk.cxy() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.iGk.cxy().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.Ek(TbadkCoreApplication.getInst().getAdAdSense().fcx);
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
                return com.baidu.tbadk.m.e.bCg().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.iGk != null) {
            tbPageTag = this.iGk.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ao
    public void a(ItemInfo itemInfo) {
        this.iGq = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ao
    public ItemInfo cxB() {
        return this.iGq;
    }

    @Override // com.baidu.tieba.frs.ao
    public boolean cxC() {
        return (this.iGk == null || this.iGk.cxy() == null || this.iGk.cxy().cyj() == null || this.iGk.cxy().cyj().cGs() == null || this.iGk.cxy().cyj().cGs().tabType != 16) ? false : true;
    }
}
