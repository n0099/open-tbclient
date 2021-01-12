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
/* loaded from: classes8.dex */
public class GiftTabActivity extends BaseActivity<GiftTabActivity> {
    public int accountType;
    private String addFreeUrl;
    private int freeChance;
    private ah jNA;
    private com.baidu.tieba.gift.send.a jNB;
    private GiftTabView jNv;
    private f jNw;
    private SendGiftModel jNx;
    private String jNy;
    private String jNz;
    private String mClickZone;
    private String mFrom;
    private String mReferPage;
    private long mToUserId;
    private long postId;
    private int sendCount;
    private long threadId;
    private boolean jMZ = false;
    private boolean jNC = false;
    private View.OnClickListener jND = new View.OnClickListener() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.1
        /* JADX DEBUG: Multi-variable search result rejected for r1v24, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX DEBUG: Multi-variable search result rejected for r1v3, resolved type: com.baidu.tieba.gift.giftTab.GiftTabActivity */
        /* JADX WARN: Multi-variable type inference failed */
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != null) {
                l.hideSoftKeyPad(GiftTabActivity.this.getActivity(), GiftTabActivity.this.jNv.jMG);
                if (view == GiftTabActivity.this.jNv.jMI) {
                    if (GiftTabActivity.this.jNx != null && GiftTabActivity.this.jNv.Fi() > 0 && GiftTabActivity.this.jNv.cLX() != null) {
                        if (!l.isNetOk()) {
                            GiftTabActivity.this.showToast(R.string.neterror);
                        } else if (TbadkCoreApplication.isLogin()) {
                            if (GiftTabActivity.this.a(GiftTabActivity.this.jNv.cLX(), GiftTabActivity.this.jNv.Fi())) {
                                GiftTabActivity.this.jNv.cLV();
                                GiftTabActivity.this.jNA = GiftTabActivity.this.jNv.cLX();
                                GiftTabActivity.this.sendCount = GiftTabActivity.this.jNv.Fi();
                                GiftTabActivity.this.jNA.sendCount = GiftTabActivity.this.sendCount;
                                GiftTabActivity.this.jNA.threadId = GiftTabActivity.this.threadId;
                                GiftTabActivity.this.jNA.postId = GiftTabActivity.this.postId;
                                GiftTabActivity.this.jNA.toUserId = GiftTabActivity.this.mToUserId;
                                GiftTabActivity.this.jNA.toUserName = GiftTabActivity.this.jNy;
                                GiftTabActivity.this.jNA.accountType = GiftTabActivity.this.accountType;
                                GiftTabActivity.this.jNx.a(GiftTabActivity.this.jNv.cLX(), GiftTabActivity.this.jNv.Fi(), GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId, GiftTabActivity.this.jNy, GiftTabActivity.this.threadId, GiftTabActivity.this.postId);
                            }
                        } else {
                            TbadkCoreApplication.getInst().login(GiftTabActivity.this.getPageContext(), new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, new LoginActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity())));
                        }
                    }
                } else if (view == GiftTabActivity.this.jNv.jOa && !StringUtils.isNull(GiftTabActivity.this.addFreeUrl)) {
                    GiftTabActivity.this.jNC = true;
                    be.bsB().b(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
                }
            }
        }
    };
    private GiftTabView.f jNE = new GiftTabView.f() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.7
        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.f
        public void AW(int i) {
            GiftTabActivity.this.jNw.AY(i);
            GiftTabActivity.this.jNv.cLV();
        }
    };
    private GiftTabView.e jNF = new GiftTabView.e() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.8
        @Override // com.baidu.tieba.gift.giftTab.GiftTabView.e
        public void Fm() {
            GiftTabActivity.this.jNw.J(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
            GiftTabActivity.this.jNv.cLV();
        }
    };
    private f.a jNG = new f.a() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.9
        @Override // com.baidu.tieba.gift.giftTab.f.a
        public void AX(int i) {
            GiftTabActivity.this.freeChance = i;
            GiftTabActivity.this.jNv.AZ(i);
            GiftTabActivity.this.jNC = false;
        }
    };
    private f.b jNH = new f.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.10
        @Override // com.baidu.tieba.gift.giftTab.f.b
        public void a(int i, String str, boolean z, String str2, int i2, ai aiVar, ArrayList<c> arrayList, ArrayList<a> arrayList2, ArrayList<e> arrayList3) {
            if (i != 0 && !StringUtils.isNull(str)) {
                GiftTabActivity.this.showToast(str);
            }
            GiftTabActivity.this.addFreeUrl = str2;
            if (GiftTabActivity.this.jNv != null) {
                GiftTabActivity.this.jNv.currencyType = i2;
                GiftTabActivity.this.jNv.urlTitleData = aiVar;
                GiftTabActivity.this.jNv.a(z, arrayList, arrayList2, arrayList3);
                GiftTabActivity.this.jNv.KI(str2);
            }
        }
    };
    private SendGiftModel.a jNI = new SendGiftModel.a() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.11
        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void cLP() {
            GiftTabActivity.this.jNv.cLW();
            GiftTabActivity.this.showToast(R.string.gift_send_data_illegal);
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void d(int i, String str, int i2) {
            GiftTabActivity.this.jNv.cLW();
            if (i != 0) {
                new com.baidu.tbadk.core.view.c().showFailToast(GiftTabActivity.this.getResources().getString(R.string.send_gift_fail));
                return;
            }
            new com.baidu.tbadk.core.view.c().showSuccessToast(GiftTabActivity.this.getResources().getString(R.string.send_gift_succeed));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, GiftTabActivity.this.jNA));
            Intent intent = new Intent();
            intent.putExtra("success", true);
            GiftTabActivity.this.setResult(-1, intent);
            GiftTabActivity.this.finish();
        }

        @Override // com.baidu.tieba.gift.send.SendGiftModel.a
        public void a(int i, String str, com.baidu.tieba.gift.send.a aVar) {
            GiftTabActivity.this.jNv.cLW();
            if (i != 0) {
                if (StringUtils.isNull(str)) {
                    GiftTabActivity.this.showToast(R.string.neterror);
                } else {
                    GiftTabActivity.this.showToast(str);
                }
            } else if (aVar != null) {
                GiftTabActivity.this.jNB = aVar;
                PaymentConfirmRequestData cMj = aVar.cMj();
                cMj.setTerminal(PaymentConfirmRequestData.TERMINAL_ANDROID);
                GiftTabActivity.this.sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new PaymentConfirmActivityConfig(GiftTabActivity.this.getPageContext().getPageActivity(), cMj, GiftTabActivity.this.mReferPage, GiftTabActivity.this.mClickZone)));
            }
        }
    };
    private CustomMessageListener jNJ = new CustomMessageListener(CmdConfigCustom.CMD_PAYMENT_CONFIRM_SUCCESS) { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.12
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                if (GiftTabActivity.this.jNB != null && str.equalsIgnoreCase(GiftTabActivity.this.jNB.getOrderId())) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SEND_GIFT_SUCCESS, GiftTabActivity.this.jNA));
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
            this.jNy = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
            this.jNz = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
            this.mFrom = getIntent().getStringExtra("from");
            this.postId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_POST_ID, 0L);
            this.threadId = getIntent().getLongExtra(GiftTabActivityConfig.GIFT_THREAD_ID, 0L);
            this.accountType = getIntent().getIntExtra("account_type", 0);
            this.mReferPage = getIntent().getStringExtra("refer_page");
            this.mClickZone = getIntent().getStringExtra("click_zone");
        }
        this.jNv = new GiftTabView(this, this.jND);
        TextView textView = this.jNv.jOb;
        String string = getResources().getString(R.string.gift_to);
        Object[] objArr = new Object[1];
        objArr[0] = TextUtils.isEmpty(this.jNz) ? this.jNy : this.jNz;
        textView.setText(String.format(string, objArr));
        this.jNv.a(this.jNE);
        this.jNv.a(this.jNF);
        this.jNw = new f(getPageContext());
        this.jNw.a(this.jNH);
        this.jNw.a(this.jNG);
        this.jNx = new SendGiftModel(getPageContext());
        this.jNx.a(this.jNI);
        registerListener(this.jNJ);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.jNC && this.jNw != null) {
            this.jNw.KH(this.mFrom);
        }
    }

    @Override // android.app.Activity, android.view.Window.Callback
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        if (z && !this.jMZ) {
            aBX();
        }
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        this.mToUserId = getIntent().getLongExtra("gift_receiver_id", 0L);
        this.jNy = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME);
        this.jNz = getIntent().getStringExtra(GiftTabActivityConfig.GIFT_RECEIVER_NAME_SHOW);
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

    private void aBX() {
        this.jNv.jME.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 0.9f);
        alphaAnimation.setDuration(300L);
        this.jNv.jME.startAnimation(alphaAnimation);
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
                GiftTabActivity.this.jNv.jMF.setVisibility(0);
                GiftTabActivity.this.jNw.J(GiftTabActivity.this.mFrom, GiftTabActivity.this.mToUserId);
                GiftTabActivity.this.jNw.KH(GiftTabActivity.this.mFrom);
                GiftTabActivity.this.jNv.cLV();
            }
        });
        this.jNv.jMF.startAnimation(loadAnimation);
        this.jMZ = true;
    }

    private void Tq() {
        this.jNv.jME.setBackgroundColor(ao.getColor(R.color.common_color_10175));
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.9f, 0.0f);
        alphaAnimation.setDuration(300L);
        alphaAnimation.setFillAfter(true);
        this.jNv.jME.startAnimation(alphaAnimation);
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
        this.jNv.jMF.startAnimation(loadAnimation);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void closeActivity() {
        Tq();
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.jNv.jMN.getVisibility() == 0) {
            this.jNv.jMN.setVisibility(8);
            return true;
        }
        return super.onKeyDown(i, keyEvent);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.jNv.cLR();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        this.jNv.onChangeSkinType(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(ah ahVar, int i) {
        boolean z = true;
        if (ahVar == null || i <= 0) {
            return false;
        }
        switch (ahVar.aFw) {
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
                if (ahVar.aUu < i) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar.setMessageShowCenter(true);
                    aVar.nt(R.string.gift_limit_number_not_enough);
                    aVar.Ad(String.format(getPageContext().getString(R.string.limit_number_gift_has_left), Integer.valueOf(ahVar.aUu)));
                    aVar.b(R.string.know, new a.b() { // from class: com.baidu.tieba.gift.giftTab.GiftTabActivity.2
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(getPageContext());
                    aVar.bqe();
                    z = false;
                    break;
                }
                break;
            case 4:
                if (TbadkCoreApplication.getCurrentMemberType() < 2) {
                    final com.baidu.tbadk.core.dialog.a aVar2 = new com.baidu.tbadk.core.dialog.a(getActivity());
                    aVar2.nv(R.color.CAM_X0305);
                    aVar2.nt(R.string.open_vip_can_send_gift);
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
                    aVar2.bqe();
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
                        aVar3.nt(R.string.have_no_free_chance);
                    } else {
                        aVar3.Ac(String.format(getPageContext().getString(R.string.most_free_gift), Integer.valueOf(this.freeChance)));
                    }
                    aVar3.nu(R.string.go_to_get_more_free_chance);
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
                                GiftTabActivity.this.jNC = true;
                                be.bsB().b(GiftTabActivity.this.getPageContext(), new String[]{GiftTabActivity.this.addFreeUrl});
                            }
                        }
                    });
                    aVar3.b(getPageContext());
                    aVar3.bqe();
                    z = false;
                    break;
                }
                break;
        }
        return z;
    }
}
