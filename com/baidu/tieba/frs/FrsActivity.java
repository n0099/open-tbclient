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
    private WeakReference<Context> alw;
    private com.baidu.adp.lib.d.b<TbImageView> exy;
    private FrsTabController hYQ;
    private com.baidu.tieba.frs.e.f hYR;
    private com.baidu.adp.lib.d.b<TbImageView> hYS;
    private boolean hYT;
    public long hYV;
    private ItemInfo hYW;
    private GuidePopupWindow hYX;
    private boolean mIsFromSchema = false;
    boolean hYU = true;
    private com.baidu.tbadk.mutiprocess.h hYY = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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
    private com.baidu.tbadk.mutiprocess.h hYZ = new com.baidu.tbadk.mutiprocess.h<GoodsEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.2
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
            ForumWriteData cpN = FrsActivity.this.hYQ.cos().cpN();
            PostPrefixData postPrefixData = null;
            AntiData antiData = null;
            if (cpN == null) {
                str = "";
                str2 = "";
                i = 0;
                str3 = null;
                i2 = -1;
                str4 = null;
                str5 = "0";
            } else {
                String str6 = cpN.forumId;
                String str7 = cpN.forumName;
                postPrefixData = cpN.prefixData;
                antiData = cpN.antiData;
                int i3 = cpN.forumLevel;
                String str8 = cpN.avatar;
                int i4 = cpN.privateThread;
                String str9 = cpN.firstDir;
                str = cpN.secondDir;
                str2 = str9;
                i = i4;
                str3 = str8;
                i2 = i3;
                str4 = str7;
                str5 = str6;
            }
            WriteActivityConfig writeActivityConfig = new WriteActivityConfig(FrsActivity.this, 9, str5, str4, null, null, 0, antiData, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, postPrefixData, 0);
            writeActivityConfig.getIntent().putExtra("from", cpN.mFrom);
            writeActivityConfig.setCallFrom("2");
            writeActivityConfig.setForumLevel(i2);
            writeActivityConfig.setForumAvatar(str3);
            writeActivityConfig.setPrivateThread(i);
            writeActivityConfig.setForumDir(str2, str);
            writeActivityConfig.setProfessionZone(cpN != null ? cpN.defaultZone : -1);
            writeActivityConfig.setFrsTabInfo(cpN != null ? cpN.frsTabInfo : null);
            writeActivityConfig.setGoodsList(goodsList);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
            goodsEvent.setDispost(true);
            return true;
        }
    };
    private CustomMessageListener hKa = new CustomMessageListener(2921476) { // from class: com.baidu.tieba.frs.FrsActivity.3
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            FrsActivity.this.ckk();
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
            if (intent.getParcelableExtra(IntentConfig.KEY_URI) != null && !com.baidu.adp.base.a.lf().bq("MainTabActivity")) {
                this.mIsFromSchema = true;
            }
        } else if (bundle != null && (bdUniqueId = (BdUniqueId) bundle.getSerializable(FrsActivityConfig.FRS_PAGE_ID)) != null) {
            setUniqueId(bdUniqueId);
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        this.hYQ = new FrsTabController(this);
        this.hYQ.init(bundle);
        if (com.baidu.tieba.frs.e.f.V(intent)) {
            this.hYT = true;
            enterExitAnimation();
            if (this.hYR == null) {
                this.hYR = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.hYR.cwa();
        }
        this.alw = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.hYY);
        com.baidu.tieba.c.a.a(getIntent(), getPageContext(), RequestResponseCode.REQUEST_SDK_RENAME);
        this.hYX = new GuidePopupWindow(this);
        registerListener(this.hKa);
        this.hYZ.setPriority(10);
        registerResponsedEventListener(GoodsEvent.class, this.hYZ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ckk() {
        if (cor()) {
            com.baidu.tbadk.core.sharedPref.b.bjf().putBoolean("has_guide_popup_window_been_shown", true);
            coq();
            com.baidu.adp.lib.f.g.showDialog(this.hYX, this);
        }
    }

    private void coq() {
        if (this.hYX != null && this.hYQ != null && this.hYQ.cup() != null && this.hYQ.cup().getForum() != null) {
            ForumData forum = this.hYQ.cup().getForum();
            this.hYX.dJh();
            this.hYX.f(this.hYQ.cup().getUserData());
            this.hYX.SQ(forum.getName());
            this.hYX.G(forum.getMember_num(), forum.getThread_num());
            this.hYX.setForumId(Integer.parseInt(forum.getId()));
            this.hYX.zC(forum.getName());
            this.hYX.SR(String.valueOf(this.hYQ.cup().getUserData().getLevel_id()));
        }
    }

    private boolean cor() {
        if (TbadkCoreApplication.isLogin() && !com.baidu.tbadk.core.sharedPref.b.bjf().getBoolean("has_guide_popup_window_been_shown", false)) {
            return this.hYQ == null || this.hYQ.cup() == null || this.hYQ.cup().getUserData() == null || this.hYQ.cup().getUserData().getIs_manager() == 1;
        }
        return false;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.hYT || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.hYQ != null) {
            this.hYQ.onNewIntent(intent);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.hYU) {
            com.baidu.tbadk.util.ai.b(this.alw);
            this.hYU = false;
        }
        if (this.hYQ != null) {
            this.hYQ.onResume();
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
        if (this.hYQ != null) {
            this.hYQ.onPause();
        }
        if (this.hYV >= 0) {
            long j = currentTimeMillis - this.hYV;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.bve().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
        TbSingleton.getInstance().isInFrs = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.hYU = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.hYQ != null) {
            this.hYQ.onDestroy();
        }
        b.cog().reset();
        a.cnZ().reset();
        a.cnZ().destory();
        c.cok().destory();
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
        if (this.hYQ != null) {
            this.hYQ.onSaveInstanceState(bundle);
        }
        bundle.putSerializable(FrsActivityConfig.FRS_PAGE_ID, getUniqueId());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.hYQ != null) {
            this.hYQ.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.hYQ != null ? this.hYQ.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.hYQ != null) {
            this.hYQ.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.hYQ != null) {
            return this.hYQ.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b d(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.hYQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hYQ.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a sh(int i) {
        if (this.hYQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.hYQ.sh(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.hYQ instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.hYQ.a(bVar);
        }
    }

    public FrsFragment cos() {
        if (this.hYQ == null) {
            return null;
        }
        return this.hYQ.cos();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> cot() {
        if (this.hYS == null) {
            this.hYS = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.hYS;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View blX() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> blY() {
        if (this.exy == null) {
            this.exy = UserIconBox.u(getPageContext().getPageActivity(), 8);
        }
        return this.exy;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        cos().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void oj(boolean z) {
        FragmentTabHost crf;
        if (this.hYQ != null && (crf = this.hYQ.crf()) != null && crf.getFragmentTabWidget() != null) {
            if (z) {
                crf.changeStyle(2);
            } else {
                crf.changeStyle(4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        i(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i) {
        super.showLoadingView(view, z, i);
        i(view, true);
    }

    public void i(View view, boolean z) {
        if (view.getId() == R.id.frs) {
            TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
        } else if (view.getId() == 16908290) {
            TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
        }
        if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
            cou();
        }
    }

    public void cou() {
        if (this.hYR != null) {
            this.hYR.cou();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.b
    public boolean videoNeedPreload() {
        if (this.hYQ == null || this.hYQ.cos() == null) {
            return false;
        }
        return this.hYQ.cos().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.hYQ != null && this.hYQ.cut() && this.hYQ.crf() != null && (this.hYQ.crf().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.hYQ.crf().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.hYQ.crf().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.hYQ.crf().getCurrentFragment()).getCurrentPageKey());
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
            if (this.hYQ != null && this.hYQ.cos() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.hYQ.cos().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.CR(TbadkCoreApplication.getInst().getAdAdSense().eCe);
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
                return com.baidu.tbadk.m.e.bve().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.hYQ != null) {
            tbPageTag = this.hYQ.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }

    @Override // com.baidu.tieba.frs.ao
    public void a(ItemInfo itemInfo) {
        this.hYW = itemInfo;
    }

    @Override // com.baidu.tieba.frs.ao
    public ItemInfo cov() {
        return this.hYW;
    }

    @Override // com.baidu.tieba.frs.ao
    public boolean cow() {
        return (this.hYQ == null || this.hYQ.cos() == null || this.hYQ.cos().cpd() == null || this.hYQ.cos().cpd().cxn() == null || this.hYQ.cos().cpd().cxn().tabType != 16) ? false : true;
    }
}
