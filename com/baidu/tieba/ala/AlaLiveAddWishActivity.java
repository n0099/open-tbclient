package com.baidu.tieba.ala;

import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.f.g;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, g.a, g.b, g.c {
    private ViewTreeObserver.OnGlobalLayoutListener aHH;
    private int aHI;
    private View eTL;
    private FrameLayout eTQ;
    private AlaLiveInputEditView eTR;
    private g eUd;
    private String eUe;
    private TbImageView eUi;
    private RelativeLayout eUj;
    private RelativeLayout eUk;
    private RelativeLayout eUl;
    private RelativeLayout eUm;
    private Button eUn;
    private TextView eUo;
    private TextView eUp;
    private TextView eUq;
    private TextView eUr;
    private String eUs;
    private int eUt;
    private int eUu;
    private RelativeLayout eUv;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aEB = false;
    private boolean aHL = false;
    private boolean aHM = false;
    private String ayw = "";
    private CustomMessageListener aER = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    CustomMessageListener aES = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aES);
            registerListener(this.aER);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aHL = false;
            this.mRootView.setVisibility(4);
            this.eUd = new g(getPageContext(), this, this, this);
            this.eUu = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aEB) {
            this.mRootView.setVisibility(0);
            yY();
            this.aEB = true;
        }
    }

    private void yY() {
        Animation loadAnimation;
        this.aHL = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.aHL = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void yZ() {
        Animation loadAnimation;
        if (!this.aHM && !this.aHL) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0182a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.4
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AlaLiveAddWishActivity.super.finish();
                    ActivityPendingTransitionFactory.enterExitAnimation(AlaLiveAddWishActivity.this.getPageContext(), 0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }
            });
            this.aHM = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        yZ();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eUv = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eUv.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eUv.setLayoutParams(layoutParams);
        this.eTL = findViewById(a.g.add_wish_root_bg);
        this.eTL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.eUi = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.eUj = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.eUk = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.eUl = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.eUm = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.eUn = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.eUi.setOnClickListener(this);
        this.eUj.setOnClickListener(this);
        this.eUk.setOnClickListener(this);
        this.eUl.setOnClickListener(this);
        this.eUm.setOnClickListener(this);
        this.eUn.setOnClickListener(this);
        this.eUo = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.eUp = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.eUq = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.eUr = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.eTQ = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.eTQ.setOnClickListener(new AnonymousClass6());
        this.eTR = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.eTR.getEditView().setInputType(1);
        this.eTR.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.eTR.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.eTR.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.eTR);
        boZ();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaLiveAddWishActivity$6  reason: invalid class name */
    /* loaded from: classes3.dex */
    public class AnonymousClass6 implements View.OnClickListener {
        AnonymousClass6() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            AsyncTask.execute(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        new Instrumentation().sendKeyDownUpSync(4);
                    } catch (Exception e) {
                        AlaLiveAddWishActivity.this.eTQ.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bpb();
                            }
                        });
                        e.printStackTrace();
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity() {
        finish();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eUd != null) {
            this.eUd.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aHH);
        this.aHH = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(getPageContext().getPageActivity(), 1, 1001);
            cVar.d(this.ayw, AlaLiveWishListActivity.eUE);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.c.c cVar2 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 2, 1002);
            cVar2.bB(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.c.c cVar3 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 3, 1003);
            cVar3.bC(this.eUt);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            bpa();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.eUs)) {
                this.eUs = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
            }
            if (TextUtils.isEmpty(this.ayw)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.eUt <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else {
                this.eUd.b(this.eUe, this.ayw, this.eUs, this.eUt, this.mGiftNum);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(FrsProfessionIntroActivityConfig.KEY_RESULT));
                if (i == 1001) {
                    String optString = jSONObject.optString("gift_title");
                    jSONObject.optString("gift_url");
                    this.ayw = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.eUo.setText(optString);
                    this.eUo.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.eUp.setText(String.valueOf(optInt));
                    this.eUp.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.eUt = optInt2;
                    this.eUq.setText(String.valueOf(optInt2) + "小时");
                    this.eUq.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                boZ();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void boZ() {
        if (this.eUn != null) {
            if (!TextUtils.isEmpty(this.ayw) && this.mGiftNum > 0 && this.eUt > 0) {
                this.eUn.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                this.eUn.setBackgroundResource(a.f.ala_live_create_wish_bt_bg);
                return;
            }
            this.eUn.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
            this.eUn.setBackgroundResource(a.f.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.f.g.c
    public void b(j jVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.f.g.c
    public void au(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.add_wish_add_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    @Override // com.baidu.tieba.ala.f.g.a
    public void a(j jVar) {
    }

    @Override // com.baidu.tieba.ala.f.g.a
    public void at(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void av(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eTR = alaLiveInputEditView;
        this.eTR.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.eTR.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.eTR.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.AC(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eTR.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.b.a
            public void eW(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.eUs = str;
                    AlaLiveAddWishActivity.this.eUr.setText(str);
                    AlaLiveAddWishActivity.this.eUr.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bpb();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.eTR.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bpa() {
        this.eTR.El();
        this.eTR.getEditView().setFocusable(true);
        this.eTR.getEditView().setFocusableInTouchMode(true);
        this.eTR.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.eTR.getEditView().requestFocus();
                AlaLiveAddWishActivity.this.eTR.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.eTR.getEditView());
            }
        }, 100L);
    }

    public void bpb() {
        this.eTR.setVisibility(8);
        this.eTR.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.eTR.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aHH = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.aHI != rect.bottom;
                AlaLiveAddWishActivity.this.aHI = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aHH);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            Rect rect = new Rect();
            this.mRootView.getRootView().getWindowVisibleDisplayFrame(rect);
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.e.sdk_ds104);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eTR.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.eTR.setLayoutParams(layoutParams);
            this.eTR.setVisibility(0);
            this.eTQ.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eTR.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.eTR.setLayoutParams(layoutParams2);
        this.eTR.setVisibility(8);
        this.eTQ.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eTR.getVisibility() == 0) {
            bpb();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean AC(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
