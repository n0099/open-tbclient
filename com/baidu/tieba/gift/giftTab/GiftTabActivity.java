package com.baidu.tieba.gift.giftTab;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.util.MemberPayStatistic;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.giftTab.GiftTabView;
import com.baidu.tieba.gift.send.SendGiftModel;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import d.a.m0.r.q.i0;
import d.a.m0.r.q.j0;
import d.a.m0.r.s.a;
import d.a.n0.v0.b.f;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public int accountType;
    public String addFreeUrl;
    public int freeChance;
    public String mClickZone;
    public String mFrom;
    public d.a.n0.v0.b.f mModelController;
    public String mReferPage;
    public SendGiftModel mSendGiftModel;
    public String mToNameShow;
    public long mToUserId;
    public String mToUserName;
    public GiftTabView mView;
    public long postId;
    public int sendCount;
    public i0 sendGift;
    public d.a.n0.v0.d.a sendOrder;
    public long threadId;
    public boolean mHasShowAnim = false;
    public boolean shouldRefreshFreechance = false;
    public View.OnClickListener mCommenClickListener = new f();
    public GiftTabView.o mLoadCategoryListCallback = new g();
    public GiftTabView.n mLoadDefaultListCallback = new h();
    public f.d mFreeCountCallback = new i();
    public f.e mRefreshCallback = new j();
    public SendGiftModel.c mGiftSendCallback = new k();
    public CustomMessageListener mSendGiftResultListener = new l(2001367);

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f16026e;

        public a(d.a.m0.r.s.a aVar) {
            this.f16026e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f16026e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f16028e;

        public b(d.a.m0.r.s.a aVar) {
            this.f16028e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f16028e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f16030e;

        public c(d.a.m0.r.s.a aVar) {
            this.f16030e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f16030e.dismiss();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new MemberPayActivityConfig(GiftTabActivity.this.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f16032e;

        public d(d.a.m0.r.s.a aVar) {
            this.f16032e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f16032e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f16034e;

        public e(d.a.m0.r.s.a aVar) {
            this.f16034e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f16034e.dismiss();
            if (StringUtils.isNull(GiftTabActivity.this.addFreeUrl)) {
                return;
            }
            GiftTabActivity.this.shouldRefreshFreechance = true;
            UrlManager.getInstance().dealOneLink(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
        }
    }

    /* loaded from: classes4.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view == null) {
                return;
            }
            d.a.c.e.p.l.x(GiftTabActivity.this.getActivity(), GiftTabActivity.this.mView.k);
            if (view == GiftTabActivity.this.mView.q) {
                if (GiftTabActivity.this.mSendGiftModel == null || GiftTabActivity.this.mView.B() <= 0 || GiftTabActivity.this.mView.C() == null) {
                    return;
                }
                if (!d.a.c.e.p.l.D()) {
                    GiftTabActivity.this.showToast(R.string.neterror);
                } else if (!TbadkCoreApplication.isLogin()) {
                    TbadkCoreApplication.getInst().login(GiftTabActivity.this.getPageContext(), new CustomMessage<>(2002001, new LoginActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity())));
                } else {
                    GiftTabActivity giftTabActivity = GiftTabActivity.this;
                    if (giftTabActivity.resetSendButtonState(giftTabActivity.mView.C(), GiftTabActivity.this.mView.B())) {
                        GiftTabActivity.this.mView.R();
                        GiftTabActivity giftTabActivity2 = GiftTabActivity.this;
                        giftTabActivity2.sendGift = giftTabActivity2.mView.C();
                        GiftTabActivity giftTabActivity3 = GiftTabActivity.this;
                        giftTabActivity3.sendCount = giftTabActivity3.mView.B();
                        GiftTabActivity.this.sendGift.l = GiftTabActivity.this.sendCount;
                        GiftTabActivity.this.sendGift.m = GiftTabActivity.this.threadId;
                        GiftTabActivity.this.sendGift.n = GiftTabActivity.this.postId;
                        GiftTabActivity.this.sendGift.p = GiftTabActivity.this.mToUserId;
                        GiftTabActivity.this.sendGift.o = GiftTabActivity.this.mToUserName;
                        i0 i0Var = GiftTabActivity.this.sendGift;
                        GiftTabActivity giftTabActivity4 = GiftTabActivity.this;
                        i0Var.r = giftTabActivity4.accountType;
                        giftTabActivity4.mSendGiftModel.t(GiftTabActivity.this.mView.C(), GiftTabActivity.this.mView.B(), GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId, GiftTabActivity.this.mToUserName, GiftTabActivity.this.threadId, GiftTabActivity.this.postId);
                    }
                }
            } else if (view != GiftTabActivity.this.mView.s || StringUtils.isNull(GiftTabActivity.this.addFreeUrl)) {
            } else {
                GiftTabActivity.this.shouldRefreshFreechance = true;
                UrlManager.getInstance().dealOneLink(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements GiftTabView.o {
        public g() {
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.o
        public void a(int i2) {
            GiftTabActivity.this.mModelController.p(i2);
            GiftTabActivity.this.mView.R();
        }
    }

    /* loaded from: classes4.dex */
    public class h implements GiftTabView.n {
        public h() {
        }

        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.n
        public void a() {
            GiftTabActivity.this.mModelController.o(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
            GiftTabActivity.this.mView.R();
        }
    }

    /* loaded from: classes4.dex */
    public class i implements f.d {
        public i() {
        }

        @Override // d.a.n0.v0.b.f.d
        public void a(int i2) {
            GiftTabActivity.this.freeChance = i2;
            GiftTabActivity.this.mView.N(i2);
            GiftTabActivity.this.shouldRefreshFreechance = false;
        }
    }

    /* loaded from: classes4.dex */
    public class j implements f.e {
        public j() {
        }

        @Override // d.a.n0.v0.b.f.e
        public void a(int i2, String str, boolean z, String str2, int i3, j0 j0Var, ArrayList<d.a.n0.v0.b.c> arrayList, ArrayList<d.a.n0.v0.b.a> arrayList2, ArrayList<d.a.n0.v0.b.e> arrayList3) {
            if (i2 != 0 && !StringUtils.isNull(str)) {
                GiftTabActivity.this.showToast(str);
            }
            GiftTabActivity.this.addFreeUrl = str2;
            if (GiftTabActivity.this.mView != null) {
                GiftTabActivity.this.mView.M = i3;
                GiftTabActivity.this.mView.N = j0Var;
                GiftTabActivity.this.mView.Q(z, arrayList, arrayList2, arrayList3);
                GiftTabActivity.this.mView.M(str2);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class k implements SendGiftModel.c {
        public k() {
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void a(int i2, String str, d.a.n0.v0.d.a aVar) {
            GiftTabActivity.this.mView.G();
            if (i2 != 0) {
                if (StringUtils.isNull(str)) {
                    GiftTabActivity.this.showToast(R.string.neterror);
                } else {
                    GiftTabActivity.this.showToast(str);
                }
            } else if (aVar == null) {
            } else {
                GiftTabActivity.this.sendOrder = aVar;
                PaymentConfirmRequestData a2 = aVar.a();
                a2.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                GiftTabActivity.this.sendMessage(new CustomMessage(2002001, new PaymentConfirmActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity(), a2, GiftTabActivity.this.mReferPage, GiftTabActivity.this.mClickZone)));
            }
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void b() {
            GiftTabActivity.this.mView.G();
            GiftTabActivity.this.showToast(R.string.gift_send_data_illegal);
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.c
        public void c(int i2, String str, int i3) {
            GiftTabActivity.this.mView.G();
            if (i2 != 0) {
                new d.a.m0.r.f0.c().b(GiftTabActivity.this.getResources().getString(R.string.send_gift_fail));
                return;
            }
            new d.a.m0.r.f0.c().c(GiftTabActivity.this.getResources().getString(R.string.send_gift_succeed));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, GiftTabActivity.this.sendGift));
            Intent intent = new Intent();
            intent.putExtra("success", true);
            GiftTabActivity.this.setResult(-1, intent);
            GiftTabActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof String)) {
                return;
            }
            String str = (String) customResponsedMessage.getData();
            if (GiftTabActivity.this.sendOrder != null && str.equalsIgnoreCase(GiftTabActivity.this.sendOrder.b())) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001369, GiftTabActivity.this.sendGift));
            }
            new d.a.m0.r.f0.c().c(GiftTabActivity.this.getResources().getString(R.string.send_gift_succeed));
            Intent intent = new Intent();
            intent.putExtra("success", true);
            GiftTabActivity.this.setResult(-1, intent);
            GiftTabActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class m implements Animation.AnimationListener {
        public m() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            GiftTabActivity.this.mView.f16049i.setVisibility(0);
            GiftTabActivity.this.mModelController.o(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
            GiftTabActivity.this.mModelController.n(GiftTabActivity.this.mFrom);
            GiftTabActivity.this.mView.R();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    /* loaded from: classes4.dex */
    public class n implements Animation.AnimationListener {
        public n() {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationEnd(Animation animation) {
            GiftTabActivity.this.setResult(-1);
            GiftTabActivity.this.finish();
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationRepeat(Animation animation) {
        }

        @Override // android.view.animation.Animation.AnimationListener
        public void onAnimationStart(Animation animation) {
        }
    }

    private void hideAnimation() {
        this.mView.f16048h.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.mView.f16048h.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new n());
        this.mView.f16049i.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean resetSendButtonState(i0 i0Var, int i2) {
        if (i0Var == null || i2 <= 0) {
            return false;
        }
        int i3 = i0Var.f50048f;
        if (i3 == 1) {
            long currentTimeMillis = System.currentTimeMillis() / 1000;
            if (currentTimeMillis < i0Var.f50050h) {
                new d.a.m0.r.f0.c().b(getResources().getString(R.string.gift_limit_time_not_start));
                return false;
            } else if (currentTimeMillis > i0Var.f50051i) {
                new d.a.m0.r.f0.c().b(getResources().getString(R.string.gift_limit_time_has_over));
                return false;
            }
        } else if (i3 != 2) {
            if (i3 != 4) {
                if (i3 == 5 && this.freeChance < i2) {
                    d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getActivity());
                    aVar.setMessageShowCenter(true);
                    if (this.freeChance <= 0) {
                        aVar.setTitle(R.string.have_no_free_chance);
                    } else {
                        aVar.setTitle(String.format(getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance)));
                    }
                    aVar.setMessageId(R.string.go_to_get_more_free_chance);
                    aVar.setNegativeButton(R.string.cancel, new d(aVar));
                    aVar.setPositiveButton(R.string.get_more_chance, new e(aVar));
                    aVar.create(getPageContext());
                    aVar.show();
                    return false;
                }
            } else if (TbadkCoreApplication.getCurrentMemberType() >= 2) {
                return true;
            } else {
                d.a.m0.r.s.a aVar2 = new d.a.m0.r.s.a(getActivity());
                aVar2.setButtonTextColor(R.color.CAM_X0305);
                aVar2.setTitle(R.string.open_vip_can_send_gift);
                aVar2.setNegativeButton(R.string.cancel, new b(aVar2));
                aVar2.setPositiveButton(R.string.open_now, new c(aVar2));
                aVar2.create(getPageContext());
                aVar2.show();
                return false;
            }
        } else if (i0Var.k < i2) {
            d.a.m0.r.s.a aVar3 = new d.a.m0.r.s.a(getActivity());
            aVar3.setMessageShowCenter(true);
            aVar3.setTitle(R.string.gift_limit_number_not_enough);
            aVar3.setMessage(String.format(getPageContext().getString(R.string.limit_number_gift_has_left), Integer.valueOf(i0Var.k)));
            aVar3.setNegativeButton(R.string.know, new a(aVar3));
            aVar3.create(getPageContext());
            aVar3.show();
            return false;
        }
        return true;
    }

    private void showAnimation() {
        this.mView.f16048h.setBackgroundColor(SkinManager.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.mView.f16048h.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new m());
        this.mView.f16049i.startAnimation(loadAnimation);
        this.mHasShowAnim = true;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        hideAnimation();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        closeActivity();
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        this.mView.K(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        if (getIntent() != null) {
            this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
            this.mToUserName = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.mToNameShow = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
            this.mFrom = getIntent().getStringExtra("from");
            this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
            this.accountType = getIntent().getIntExtra("account_type", 0);
            this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
            this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
        }
        GiftTabView giftTabView = new GiftTabView(this, this.mCommenClickListener);
        this.mView = giftTabView;
        TextView textView = giftTabView.t;
        String string = getResources().getString(R.string.gift_to);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.mToNameShow) ? this.mToUserName : this.mToNameShow;
        textView.setText(String.format(string, objArr));
        this.mView.O(this.mLoadCategoryListCallback);
        this.mView.P(this.mLoadDefaultListCallback);
        d.a.n0.v0.b.f fVar = new d.a.n0.v0.b.f(getPageContext());
        this.mModelController = fVar;
        fVar.s(this.mRefreshCallback);
        this.mModelController.r(this.mFreeCountCallback);
        SendGiftModel sendGiftModel = new SendGiftModel(getPageContext());
        this.mSendGiftModel = sendGiftModel;
        sendGiftModel.u(this.mGiftSendCallback);
        registerListener(this.mSendGiftResultListener);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mView.A();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4 && this.mView.B.getVisibility() == 0) {
            this.mView.B.setVisibility(8);
            return true;
        }
        return super.onKeyDown(i2, keyEvent);
    }

    @Override // android.app.Activity
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
        this.mToUserName = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
        this.mToNameShow = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
        this.mFrom = getIntent().getStringExtra("from");
        this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
        this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
        this.mReferPage = getIntent().getStringExtra(MemberPayStatistic.REFER_PAGE);
        this.mClickZone = getIntent().getStringExtra(MemberPayStatistic.CLICK_ZONE);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        d.a.n0.v0.b.f fVar;
        super.onResume();
        if (!this.shouldRefreshFreechance || (fVar = this.mModelController) == null) {
            return;
        }
        fVar.n(this.mFrom);
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (!z || this.mHasShowAnim) {
            return;
        }
        showAnimation();
    }

    public void setShouldRefreshFreechance(boolean z) {
        this.shouldRefreshFreechance = z;
    }
}
