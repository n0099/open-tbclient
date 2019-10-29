package com.baidu.tieba.frs;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.live.tbadk.pagestayduration.PageStayDurationConstants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gametab.FrsTabController;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class FrsActivity extends BaseFragmentActivity implements com.baidu.tbadk.core.util.g.c, UserIconBox.b, VoiceManager.c, com.baidu.tieba.InjectPlugin.a.b, FrsCommonImageLayout.c {
    private WeakReference<Context> bUw;
    private com.baidu.adp.lib.e.b<TbImageView> csh;
    private FrsTabController fut;
    private com.baidu.tieba.frs.e.f fuu;
    private com.baidu.adp.lib.e.b<TbImageView> fuv;
    private boolean fuw;
    boolean fux = true;
    public long fuy;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.fut = new FrsTabController(this);
        this.fut.init(bundle);
        if (com.baidu.tieba.frs.e.f.ar(getIntent())) {
            this.fuw = true;
            enterExitAnimation();
            if (this.fuu == null) {
                this.fuu = new com.baidu.tieba.frs.e.f(this, (ViewGroup) getWindow().getDecorView(), getIntent());
            }
            this.fuu.bqa();
        }
        this.bUw = new WeakReference<>(TbadkCoreApplication.getInst());
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        if (this.fuw) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        } else {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 1);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (this.fut != null) {
            this.fut.onNewIntent(intent);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z) {
            com.baidu.tbadk.BdToken.d.aej().check();
            com.baidu.tbadk.BdToken.d.aej().aek();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.fux) {
            com.baidu.tbadk.util.ac.c(this.bUw);
            this.fux = false;
        }
        if (this.fut != null) {
            this.fut.onResume();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onPause() {
        com.baidu.tbadk.o.d pageStayDurationItem;
        long currentTimeMillis = System.currentTimeMillis() - this.lastResumeTime;
        this.lastResumeTime = 0L;
        super.onPause();
        if (this.fut != null) {
            this.fut.onPause();
        }
        if (this.fuy >= 0) {
            long j = currentTimeMillis - this.fuy;
            if (j >= 0 && (pageStayDurationItem = getPageStayDurationItem()) != null) {
                pageStayDurationItem.setStayDurationTime(j);
                com.baidu.tbadk.o.e.awz().a(getPageContext().getPageActivity(), pageStayDurationItem, getPageStayFilter());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStop() {
        super.onStop();
        this.fux = true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        if (this.fut != null) {
            this.fut.onDestroy();
        }
        a.biW().reset();
        if (!com.baidu.tbadk.core.util.aq.isEmpty(TbadkCoreApplication.getInst().getTaskId())) {
            TbadkCoreApplication.getInst().setTaskId("");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        if (this.fut != null) {
            this.fut.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
        if (this.fut != null) {
            this.fut.onChangeSkinType(i);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public boolean getGpuSwitch() {
        return TbadkCoreApplication.getInst().isGpuOpen();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.fut != null ? this.fut.onKeyDown(i, keyEvent) : super.onKeyDown(i, keyEvent);
    }

    public boolean b(int i, KeyEvent keyEvent) {
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (this.fut != null) {
            this.fut.onActivityResult(i, i2, intent);
        }
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager getVoiceManager() {
        if (this.fut != null) {
            return this.fut.getVoiceManager();
        }
        return null;
    }

    @Override // com.baidu.tbadk.core.voice.VoiceManager.c
    public VoiceManager.b c(VoiceData.VoiceModel voiceModel) {
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(int i, com.baidu.tieba.InjectPlugin.a.a aVar) {
        if (this.fut instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fut.a(i, aVar);
        }
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public com.baidu.tieba.InjectPlugin.a.a lo(int i) {
        if (this.fut instanceof com.baidu.tieba.InjectPlugin.a.b) {
            return this.fut.lo(i);
        }
        return null;
    }

    @Override // com.baidu.tieba.InjectPlugin.a.b
    public void a(com.baidu.tieba.InjectPlugin.b bVar) {
        if (this.fut instanceof com.baidu.tieba.InjectPlugin.a.b) {
            this.fut.a(bVar);
        }
    }

    public FrsFragment bjj() {
        if (this.fut == null) {
            return null;
        }
        return this.fut.bjj();
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.c
    public com.baidu.adp.lib.e.b<TbImageView> bjk() {
        if (this.fuv == null) {
            this.fuv = FrsCommonImageLayout.y(getPageContext().getPageActivity(), 12);
        }
        return this.fuv;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public View aof() {
        return null;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.b
    public com.baidu.adp.lib.e.b<TbImageView> aog() {
        if (this.csh == null) {
            this.csh = UserIconBox.o(getPageContext().getPageActivity(), 8);
        }
        return this.csh;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity, android.support.v4.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        bjj().onRequestPermissionsResult(i, strArr, iArr);
    }

    public void jB(boolean z) {
        FragmentTabHost bly;
        if (this.fut != null && (bly = this.fut.bly()) != null && bly.getFragmentTabWidget() != null) {
            if (z) {
                bly.changeStyle(2);
            } else {
                bly.changeStyle(4);
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
            bjl();
        }
    }

    public void bjl() {
        if (this.fuu != null) {
            this.fuu.bjl();
        }
    }

    @Override // com.baidu.tbadk.core.util.g.c
    public boolean videoNeedPreload() {
        if (this.fut == null || this.fut.bjj() == null) {
            return false;
        }
        return this.fut.bjj().videoNeedPreload();
    }

    @Override // com.baidu.tbadk.core.util.g.c
    public boolean isCyberVideoUsedThisPage() {
        return com.baidu.tbadk.a.b.mb("cyber_player_test");
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.o.a
    public List<String> getNextPageSourceKeyList() {
        List<String> nextPageSourceKeyList = super.getNextPageSourceKeyList();
        ArrayList arrayList = nextPageSourceKeyList == null ? new ArrayList() : nextPageSourceKeyList;
        if (this.fut != null && this.fut.boy() && this.fut.bly() != null && (this.fut.bly().getCurrentFragment() instanceof BaseFragment) && ((BaseFragment) this.fut.bly().getCurrentFragment()).getCurrentPageKey() != null && ((BaseFragment) this.fut.bly().getCurrentFragment()).isPrimary()) {
            arrayList.add(((BaseFragment) this.fut.bly().getCurrentFragment()).getCurrentPageKey());
        } else {
            arrayList.add(getCurrentPageKey());
        }
        return arrayList;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.o.a
    public String getCurrentPageKey() {
        return PageStayDurationConstants.PageName.FRS;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public com.baidu.tbadk.o.d getPageStayDurationItem() {
        com.baidu.tbadk.o.d pageStayDurationItem = super.getPageStayDurationItem();
        if (pageStayDurationItem != null) {
            if (this.fut != null && this.fut.bjj() != null) {
                pageStayDurationItem.setFid(com.baidu.adp.lib.g.b.toLong(this.fut.bjj().forumId, 0L));
            }
            if (TbadkCoreApplication.getInst().getAdAdSense() != null) {
                pageStayDurationItem.qd(TbadkCoreApplication.getInst().getAdAdSense().cuL);
            }
        }
        return pageStayDurationItem;
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.tbadk.o.a
    public com.baidu.tbadk.o.b getPageStayFilter() {
        return new com.baidu.tbadk.o.b() { // from class: com.baidu.tieba.frs.FrsActivity.1
            @Override // com.baidu.tbadk.o.b
            public boolean isCurrentPageCanBeAddToSourceTrace() {
                return false;
            }

            @Override // com.baidu.tbadk.o.b
            public int getMaxCost() {
                return com.baidu.tbadk.o.e.awz().getMaxCostFromServer();
            }
        };
    }
}
