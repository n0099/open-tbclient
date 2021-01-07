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
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GiftTabActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.PaymentConfirmActivityConfig;
import com.baidu.tbadk.core.data.ah;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tieba.R;
import com.baidu.tieba.gift.giftTab.GiftTabView;
import com.baidu.tieba.gift.giftTab.f;
import com.baidu.tieba.gift.send.SendGiftModel;
import com.baidu.tieba.tbadkCore.data.PaymentConfirmRequestData;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public int accountType;
    private String addFreeUrl;
    private int freeChance;
    private GiftTabView jSa;
    private f jSb;
    private SendGiftModel jSc;
    private String jSd;
    private String jSe;
    private ah jSf;
    private com.baidu.tieba.gift.send.a jSg;
    private String mClickZone;
    private String mFrom;
    private String mReferPage;
    private long mToUserId;
    private long postId;
    private int sendCount;
    private long threadId;
    private boolean jRE = false;
    private boolean jSh = false;
    private View.OnClickListener jSi = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                l.hideSoftKeyPad(GiftTabActivity.this.getActivity(), GiftTabActivity.this.jSa.jRl);
                if (view == GiftTabActivity.this.jSa.jRn) {
                    if (GiftTabActivity.this.jSc != null && GiftTabActivity.this.jSa.Jd() > 0 && GiftTabActivity.this.jSa.cPP() != null) {
                        if (!l.isNetOk()) {
                            GiftTabActivity.this.showToast(R.string.neterror);
                        } else if (TbadkCoreApplication.isLogin()) {
                            if (GiftTabActivity.this.a(GiftTabActivity.this.jSa.cPP(), GiftTabActivity.this.jSa.Jd())) {
                                GiftTabActivity.this.jSa.cPN();
                                GiftTabActivity.this.jSf = GiftTabActivity.this.jSa.cPP();
                                GiftTabActivity.this.sendCount = GiftTabActivity.this.jSa.Jd();
                                GiftTabActivity.this.jSf.sendCount = GiftTabActivity.this.sendCount;
                                GiftTabActivity.this.jSf.threadId = GiftTabActivity.this.threadId;
                                GiftTabActivity.this.jSf.postId = GiftTabActivity.this.postId;
                                GiftTabActivity.this.jSf.toUserId = GiftTabActivity.this.mToUserId;
                                GiftTabActivity.this.jSf.toUserName = GiftTabActivity.this.jSd;
                                GiftTabActivity.this.jSf.accountType = GiftTabActivity.this.accountType;
                                GiftTabActivity.this.jSc.a(GiftTabActivity.this.jSa.cPP(), GiftTabActivity.this.jSa.Jd(), GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId, GiftTabActivity.this.jSd, GiftTabActivity.this.threadId, GiftTabActivity.this.postId);
                            }
                        } else {
                            TbadkCoreApplication.getInst().login(GiftTabActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity())));
                        }
                    }
                } else if (view == GiftTabActivity.this.jSa.jSF && !StringUtils.isNull(GiftTabActivity.this.addFreeUrl)) {
                    GiftTabActivity.this.jSh = true;
                    be.bwv().b(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
                }
            }
        }
    };
    private GiftTabView.f jSj = new GiftTabView.f() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.7
        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.f
        public void CC(int i) {
            GiftTabActivity.this.jSb.CE(i);
            GiftTabActivity.this.jSa.cPN();
        }
    };
    private GiftTabView.e jSk = new GiftTabView.e() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.8
        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.e
        public void Jh() {
            GiftTabActivity.this.jSb.J(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
            GiftTabActivity.this.jSa.cPN();
        }
    };
    private f.a jSl = new f.a() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.9
        @Override // com.baidu.tieba.gift.giftTab.f.a
        public void CD(int i) {
            GiftTabActivity.this.freeChance = i;
            GiftTabActivity.this.jSa.CF(i);
            GiftTabActivity.this.jSh = false;
        }
    };
    private f.b jSm = new f.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.10
        @Override // com.baidu.tieba.gift.giftTab.f.b
        public void a(int i, String str, boolean z, String str2, int i2, ai aiVar, ArrayList<c> arrayList, ArrayList<a> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftTabActivity.this.showToast(str);
            }
            GiftTabActivity.this.addFreeUrl = str2;
            if (GiftTabActivity.this.jSa != null) {
                GiftTabActivity.this.jSa.currencyType = i2;
                GiftTabActivity.this.jSa.urlTitleData = aiVar;
                GiftTabActivity.this.jSa.a(z, arrayList, arrayList2, arrayList3);
                GiftTabActivity.this.jSa.LQ(str2);
            }
        }
    };
    private SendGiftModel.a jSn = new SendGiftModel.a() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.11
        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void cPH() {
            GiftTabActivity.this.jSa.cPO();
            GiftTabActivity.this.showToast(R.string.gift_send_data_illegal);
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void c(int i, String str, int i2) {
            GiftTabActivity.this.jSa.cPO();
            if (i != 0) {
                new com.baidu.tbadk.core.view.c().showFailToast(GiftTabActivity.this.getResources().getString(R.string.send_gift_fail));
                return;
            }
            new com.baidu.tbadk.core.view.c().showSuccessToast(GiftTabActivity.this.getResources().getString(R.string.send_gift_succeed));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, GiftTabActivity.this.jSf));
            Intent intent = new Intent();
            intent.putExtra("success", true);
            GiftTabActivity.this.setResult(-1, intent);
            GiftTabActivity.this.finish();
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void a(int i, String str, com.baidu.tieba.gift.send.a aVar) {
            GiftTabActivity.this.jSa.cPO();
            if (i != 0) {
                if (StringUtils.isNull(str)) {
                    GiftTabActivity.this.showToast(R.string.neterror);
                } else {
                    GiftTabActivity.this.showToast(str);
                }
            } else if (aVar != null) {
                GiftTabActivity.this.jSg = aVar;
                PaymentConfirmRequestData cQb = aVar.cQb();
                cQb.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                GiftTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PaymentConfirmActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity(), cQb, GiftTabActivity.this.mReferPage, GiftTabActivity.this.mClickZone)));
            }
        }
    };
    private CustomMessageListener jSo = new CustomMessageListener(CmdConfigCustom.CMD_PAYMENT_CONFIRM_SUCCESS) { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (GiftTabActivity.this.jSg != null && str.equalsIgnoreCase(GiftTabActivity.this.jSg.getOrderId())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, GiftTabActivity.this.jSf));
                }
                new com.baidu.tbadk.core.view.c().showSuccessToast(GiftTabActivity.this.getResources().getString(R.string.send_gift_succeed));
                Intent intent = new Intent();
                intent.putExtra("success", true);
                GiftTabActivity.this.setResult(-1, intent);
                GiftTabActivity.this.finish();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        requestWindowFeature(1);
        super.onCreate(bundle);
        setSwipeBackEnabled(false);
        setActivityBgTransparent();
        if (getIntent() != null) {
            this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
            this.jSd = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.jSe = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
            this.mFrom = getIntent().getStringExtra("from");
            this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
            this.accountType = getIntent().getIntExtra("account_type", 0);
            this.mReferPage = getIntent().getStringExtra("refer_page");
            this.mClickZone = getIntent().getStringExtra("click_zone");
        }
        this.jSa = new GiftTabView(this, this.jSi);
        TextView textView = this.jSa.jSG;
        String string = getResources().getString(R.string.gift_to);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.jSe) ? this.jSd : this.jSe;
        textView.setText(String.format(string, objArr));
        this.jSa.a(this.jSj);
        this.jSa.a(this.jSk);
        this.jSb = new f(getPageContext());
        this.jSb.a(this.jSm);
        this.jSb.a(this.jSl);
        this.jSc = new SendGiftModel(getPageContext());
        this.jSc.a(this.jSn);
        registerListener(this.jSo);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jSh && this.jSb != null) {
            this.jSb.LP(this.mFrom);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.jRE) {
            aFR();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
        this.jSd = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
        this.jSe = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
        this.mFrom = getIntent().getStringExtra("from");
        this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
        this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
        this.mReferPage = getIntent().getStringExtra("refer_page");
        this.mClickZone = getIntent().getStringExtra("click_zone");
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

    private void aFR() {
        this.jSa.jRj.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.jSa.jRj.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_up);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.13
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GiftTabActivity.this.jSa.jRk.setVisibility(0);
                GiftTabActivity.this.jSb.J(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
                GiftTabActivity.this.jSb.LP(GiftTabActivity.this.mFrom);
                GiftTabActivity.this.jSa.cPN();
            }
        });
        this.jSa.jRk.startAnimation(loadAnimation);
        this.jRE = true;
    }

    private void Xj() {
        this.jSa.jRj.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.jSa.jRj.startAnimation(alphaAnimation);
        Animation loadAnimation = AnimationUtils.loadAnimation(getPageContext().getPageActivity(), R.anim.bottom_fold_down);
        loadAnimation.setDuration(300L);
        loadAnimation.setFillAfter(true);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.14
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                GiftTabActivity.this.setResult(-1);
                GiftTabActivity.this.finish();
            }
        });
        this.jSa.jRk.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Xj();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jSa.jRs.getVisibility() == 0) {
            this.jSa.jRs.setVisibility(8);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jSa.cPJ();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jSa.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, int i) {
        boolean z = true;
        if (ahVar == null || i <= 0) {
            return false;
        }
        switch (ahVar.aKj) {
            case 1:
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (currentTimeMillis < ahVar.beginTime) {
                    new com.baidu.tbadk.core.view.c().showFailToast(getResources().getString(R.string.gift_limit_time_not_start));
                    return false;
                } else if (currentTimeMillis > ahVar.endTime) {
                    new com.baidu.tbadk.core.view.c().showFailToast(getResources().getString(R.string.gift_limit_time_has_over));
                    return false;
                }
                break;
            case 2:
                if (ahVar.aZh < i) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar.setMessageShowCenter(true);
                    aVar.oZ(R.string.gift_limit_number_not_enough);
                    aVar.Bo(String.format(getPageContext().getString(R.string.limit_number_gift_has_left), Integer.valueOf(ahVar.aZh)));
                    aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.btY();
                    z = false;
                    break;
                }
                break;
            case 4:
                if (TbadkCoreApplication.getCurrentMemberType() < 2) {
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar2.pb(R.color.CAM_X0305);
                    aVar2.oZ(R.string.open_vip_can_send_gift);
                    aVar2.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.3
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            aVar2.dismiss();
                        }
                    });
                    aVar2.a(R.string.open_now, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.4
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar3) {
                            aVar2.dismiss();
                            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new MemberPayActivityConfig(GiftTabActivity.this.getActivity(), TbadkCoreApplication.getCurrentMemberType(), "", 17)));
                        }
                    });
                    aVar2.b(getPageContext());
                    aVar2.btY();
                    z = false;
                    break;
                } else {
                    return true;
                }
            case 5:
                if (this.freeChance < i) {
                    final com.baidu.tbadk.core.dialog.a aVar3 = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar3.setMessageShowCenter(true);
                    if (this.freeChance <= 0) {
                        aVar3.oZ(R.string.have_no_free_chance);
                    } else {
                        aVar3.Bn(String.format(getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance)));
                    }
                    aVar3.pa(R.string.go_to_get_more_free_chance);
                    aVar3.b(R.string.cancel, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.5
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                            aVar3.dismiss();
                        }
                    });
                    aVar3.a(R.string.get_more_chance, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.6
                        /* JADX DEBUG: Multi-variable search result rejected for r1v0, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
                        /* JADX WARN: Multi-variable type inference failed */
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar4) {
                            aVar3.dismiss();
                            if (!StringUtils.isNull(GiftTabActivity.this.addFreeUrl)) {
                                GiftTabActivity.this.jSh = true;
                                be.bwv().b(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
                            }
                        }
                    });
                    aVar3.b(getPageContext());
                    aVar3.btY();
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }
}
