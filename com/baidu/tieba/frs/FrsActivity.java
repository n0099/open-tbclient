package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.mutiprocess.event.TipEvent;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.view.DefaultNavigationBarCoverTip;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.f.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private WeakReference<Context> Pg;
    private com.baidu.adp.lib.d.b<TbImageView> djC;
    private FrsTabController gok;
    private com.baidu.tieba.frs.e.f gol;
    private com.baidu.adp.lib.d.b<TbImageView> gom;
    private boolean gon;
    public long gop;
    private boolean mIsFromSchema = false;
    boolean goo = true;
    private com.baidu.tbadk.mutiprocess.h goq = new com.baidu.tbadk.mutiprocess.h<TipEvent>() { // from class: com.baidu.tieba.frs.FrsActivity.1
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Uri uri;
        Intent intent = getIntent();
        if (intent != null && intent.getParcelableExtra("key_uri") != null && !com.baidu.adp.base.a.eH().T("MainTabActivity")) {
            this.mIsFromSchema = true;
        }
        if (this.mIsFromSchema) {
            setIsAddSwipeBackLayout(false);
        }
        super.onCreate(bundle);
        if (intent != null && (uri = (Uri) intent.getParcelableExtra("key_uri")) != null) {
            String queryParameter = uri.getQueryParameter("obj_source");
            if ("shoubai".equals(queryParameter) || LogConfig.LIVE_SHARE_HK_WEIXIN_FRIEND.equals(queryParameter) || "tbShareH5".equals(queryParameter) || "wise".equals(queryParameter)) {
                String queryParameter2 = uri.getQueryParameter("obj_locate");
                String queryParameter3 = uri.getQueryParameter("obj_type");
                String queryParameter4 = uri.getQueryParameter("obj_param1");
                String queryParameter5 = uri.getQueryParameter(TiebaInitialize.Params.OBJ_PARAM2);
                String queryParameter6 = uri.getQueryParameter("kw");
                com.baidu.tbadk.core.util.an anVar = new com.baidu.tbadk.core.util.an("c13561");
                anVar.cx("obj_locate", queryParameter2);
                anVar.cx("obj_type", queryParameter3);
                anVar.cx("obj_param1", queryParameter4);
                anVar.cx(TiebaInitialize.Params.OBJ_PARAM2, queryParameter5);
                anVar.cx("fname", queryParameter6);
                anVar.cx("obj_source", queryParameter);
                TiebaStatic.log(anVar);
            }
        }
        this.gok = new FrsTabController(this);
        this.gok.init(bundle);
        if (com.baidu.tieba.frs.e.f.ak(intent)) {
            this.gon = true;
            enterExitAnimation();
            if (this.gol == null) {
                this.gol = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.gol.bKn();
        }
        this.Pg = new WeakReference<>(TbadkCoreApplication.getInst());
        registerResponsedEventListener(TipEvent.class, this.goq);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.gon || this.mIsFromSchema) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.gok != null) {
            this.gok.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            com.baidu.tbadk.BdToken.d.axM().check();
            com.baidu.tbadk.BdToken.d.axM().axN();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.goo) {
            com.baidu.tbadk.util.af.b(this.Pg);
            this.goo = false;
        }
        if (this.gok != null) {
            this.gok.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.m.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.gok != null) {
            this.gok.onPause();
        }
        if (this.gop >= 0) {
            long j = currentTimeMillis - this.gop;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.m.e.aRc().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.goo = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.gok != null) {
            this.gok.onDestroy();
        }
        a.bDd().reset();
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.gok != null) {
            this.gok.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.gok != null) {
            this.gok.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.gok != null ? this.gok.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
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
        if (this.gok != null) {
            this.gok.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.gok != null) {
            return this.gok.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.gok instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gok.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a nU(int i) {
        if (this.gok instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.gok.nU(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.gok instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.gok.a(bVar);
        }
    }

    public FrsFragment bDq() {
        if (this.gok == null) {
            return null;
        }
        return this.gok.bDq();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.d.b<TbImageView> bDr() {
        if (this.gom == null) {
            this.gom = FrsCommonImageLayout.G(getPageContext().getPageActivity(), 12);
        }
        return this.gom;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View aIm() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.d.b<TbImageView> aIn() {
        if (this.djC == null) {
            this.djC = UserIconBox.x(getPageContext().getPageActivity(), 8);
        }
        return this.djC;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        bDq().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void li(boolean z) {
        FragmentTabHost bFL;
        if (this.gok != null && (bFL = this.gok.bFL()) != null && bFL.getFragmentTabWidget() != null) {
            if (z) {
                bFL.changeStyle(2);
            } else {
                bFL.changeStyle(4);
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void hideLoadingView(View view) {
        super.hideLoadingView(view);
        g(view, false);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void showLoadingView(View view, boolean z, int i) {
        super.showLoadingView(view, z, i);
        g(view, true);
    }

    public void g(View view, boolean z) {
        if (view.getId() == R.id.frs) {
            TbSingleton.getInstance().setFrsRootViewLoadingShow(z);
        } else if (view.getId() == 16908290) {
            TbSingleton.getInstance().setFrsContentViewLoadingShow(z);
        }
        if (TbSingleton.getInstance().isFrsLoadingViewHided()) {
            bDs();
        }
    }

    public void bDs() {
        if (this.gol != null) {
            this.gol.bDs();
        }
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean videoNeedPreload() {
        if (this.gok == null || this.gok.bDq() == null) {
            return false;
        }
        return this.gok.bDq().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.util.f.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.rH("cyber_player_test") || com.baidu.tbadk.a.b.rG("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.m.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.gok != null && this.gok.bIM() && this.gok.bFL() != null && (this.gok.bFL().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.gok.bFL().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.gok.bFL().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.gok.bFL().getCurrentFragment()).getCurrentPageKey());
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
            if (this.gok != null && this.gok.bDq() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.f.b.toLong(this.gok.bDq().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.vG(TbadkCoreApplication.getInst().getAdAdSense().dmy);
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
                return com.baidu.tbadk.m.e.aRc().getMaxCostFromServer();
            }
        };
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public TbPageTag getTbPageTag() {
        TbPageTag tbPageTag = null;
        if (this.gok != null) {
            tbPageTag = this.gok.getTbPageTag();
        }
        if (tbPageTag == null) {
            return super.getTbPageTag();
        }
        return tbPageTag;
    }
}
