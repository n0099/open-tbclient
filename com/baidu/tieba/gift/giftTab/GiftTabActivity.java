package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.gift.giftTab.ad;
import com.baidu.tieba.gift.giftTab.z;
import com.baidu.tieba.gift.send.b;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    private String addFreeUrl;
    private ad bvf;
    private z bvg;
    private com.baidu.tieba.gift.send.b bvh;
    private String bvi;
    private com.baidu.tbadk.core.data.l bvj;
    private com.baidu.tieba.gift.send.a bvk;
    private int freeChance;
    private String mFrom;
    private long mToUserId;
    private long postId;
    private int sendCount;
    private long threadId;
    private boolean buD = false;
    private boolean bvl = false;
    private View.OnClickListener bvm = new l(this);
    private ad.f bvn = new r(this);
    private ad.e bvo = new s(this);
    private z.a bvp = new t(this);
    private z.b bvq = new u(this);
    private b.a bvr = new v(this);
    private CustomMessageListener bvs = new w(this, CmdConfigCustom.CMD_PAYMENT_CONFIRM_SUCCESS);

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        if (getIntent() != null) {
            this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
            this.bvi = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.mFrom = getIntent().getStringExtra("from");
            this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
        }
        this.bvf = new ad(this, this.bvm);
        this.bvf.bvK.setText(String.format(getResources().getString(n.i.gift_to), this.bvi));
        this.bvf.a(this.bvn);
        this.bvf.a(this.bvo);
        this.bvg = new z(getPageContext());
        this.bvg.a(this.bvq);
        this.bvg.a(this.bvp);
        this.bvh = new com.baidu.tieba.gift.send.b(getPageContext());
        this.bvh.a(this.bvr);
        registerListener(this.bvs);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.bvl && this.bvg != null) {
            this.bvg.hJ(this.mFrom);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.buD) {
            SU();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
        this.bvi = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
        this.mFrom = getIntent().getStringExtra("from");
        this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
        this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    private void SU() {
        this.bvf.bue.setBackgroundColor(as.getColor(n.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.bvf.bue.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new x(this));
        this.bvf.buf.startAnimation(loadAnimation);
        this.buD = true;
    }

    private void SV() {
        this.bvf.bue.setBackgroundColor(as.getColor(n.c.album_list_window_bg));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.bvf.bue.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), n.a.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new y(this));
        this.bvf.buf.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        SV();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvf.buo.getVisibility() == 0) {
            this.bvf.buo.setVisibility(8);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.bvf.Ti();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.bvf.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(com.baidu.tbadk.core.data.l lVar, int i) {
        boolean z = true;
        if (lVar == null || i <= 0) {
            return false;
        }
        switch (lVar.rS()) {
            case 1:
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < lVar.rU()) {
                    new com.baidu.tbadk.core.view.g(getPageContext()).e(getResources().getString(n.i.gift_limit_time_not_start));
                    return false;
                } else if (currentTimeMillis > lVar.getEndTime()) {
                    new com.baidu.tbadk.core.view.g(getPageContext()).e(getResources().getString(n.i.gift_limit_time_has_over));
                    return false;
                }
                break;
            case 2:
                if (lVar.rW() < i) {
                    com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar.ar(true);
                    aVar.bM(n.i.gift_limit_number_not_enough);
                    aVar.cC(String.format(getPageContext().getString(n.i.limit_number_gift_has_left), Integer.valueOf(lVar.rW())));
                    aVar.b(n.i.know, new m(this, aVar));
                    aVar.b(getPageContext());
                    aVar.tv();
                    z = false;
                    break;
                }
                break;
            case 4:
                if (TbadkCoreApplication.getCurrentMemberType() < 2) {
                    com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar2.bO(n.c.cp_link_tip_d);
                    aVar2.bM(n.i.open_vip_can_send_gift);
                    aVar2.b(n.i.cancel_text, new n(this, aVar2));
                    aVar2.a(n.i.open_now, new o(this, aVar2));
                    aVar2.b(getPageContext());
                    aVar2.tv();
                    z = false;
                    break;
                } else {
                    return true;
                }
            case 5:
                if (this.freeChance < i) {
                    com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar3.ar(true);
                    if (this.freeChance <= 0) {
                        aVar3.bM(n.i.have_no_free_chance);
                    } else {
                        aVar3.cB(String.format(getPageContext().getString(n.i.most_free_gift), Integer.valueOf(this.freeChance)));
                    }
                    aVar3.bN(n.i.go_to_get_more_free_chance);
                    aVar3.b(n.i.cancel_text, new p(this, aVar3));
                    aVar3.a(n.i.get_more_chance, new q(this, aVar3));
                    aVar3.b(getPageContext());
                    aVar3.tv();
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }
}
