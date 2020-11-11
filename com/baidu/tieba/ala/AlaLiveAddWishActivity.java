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
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.g.i;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, i.a, i.b, i.c {
    private ViewTreeObserver.OnGlobalLayoutListener aYX;
    private int aYY;
    private View fXU;
    private FrameLayout fXY;
    private AlaLiveInputEditView fXZ;
    private RelativeLayout fYA;
    private RelativeLayout fYB;
    private Button fYC;
    private TextView fYD;
    private TextView fYE;
    private TextView fYF;
    private TextView fYG;
    private String fYH;
    private int fYI;
    private int fYJ;
    private RelativeLayout fYK;
    private i fYl;
    private String fYm;
    private TbImageView fYx;
    private RelativeLayout fYy;
    private RelativeLayout fYz;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aVc = false;
    private boolean aZb = false;
    private boolean aZc = false;
    private String aNj = "";
    private CustomMessageListener aVs = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aVt = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aVt);
            registerListener(this.aVs);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aZb = false;
            this.mRootView.setVisibility(4);
            this.fYl = new i(getPageContext(), this, this, this);
            this.fYJ = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aVc) {
            this.mRootView.setVisibility(0);
            HW();
            this.aVc = true;
        }
    }

    private void HW() {
        Animation loadAnimation;
        this.aZb = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.aZb = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void HX() {
        Animation loadAnimation;
        if (!this.aZc && !this.aZb) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0197a.sdk_out_to_bottom);
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
            this.aZc = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        HX();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fYK = (RelativeLayout) findViewById(a.f.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fYK.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fYK.setLayoutParams(layoutParams);
        this.fXU = findViewById(a.f.add_wish_root_bg);
        this.fXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.fYx = (TbImageView) this.mRootView.findViewById(a.f.add_wish_tile_icon_return);
        this.fYy = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift);
        this.fYz = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num);
        this.fYA = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline);
        this.fYB = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way);
        this.fYC = (Button) this.mRootView.findViewById(a.f.add_wish_next_bt);
        this.fYx.setOnClickListener(this);
        this.fYy.setOnClickListener(this);
        this.fYz.setOnClickListener(this);
        this.fYA.setOnClickListener(this);
        this.fYB.setOnClickListener(this);
        this.fYC.setOnClickListener(this);
        this.fYD = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_action);
        this.fYE = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num_action);
        this.fYF = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline_action);
        this.fYG = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.h.add_wish_title));
        this.fXY = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.fXY.setOnClickListener(new AnonymousClass6());
        this.fXZ = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        this.fXZ.getEditView().setInputType(1);
        this.fXZ.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.fXZ.setHintText(getPageContext().getResources().getString(a.h.add_wish_thank_way_hinit));
        this.fXZ.getTextView().setText(getPageContext().getResources().getString(a.h.add_wish_thank_way_send));
        e(this.fXZ);
        bLR();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaLiveAddWishActivity$6  reason: invalid class name */
    /* loaded from: classes4.dex */
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
                        AlaLiveAddWishActivity.this.fXY.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bLT();
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
        if (this.fYl != null) {
            this.fYl.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aYX);
        this.aYX = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.f.add_wish_center_edit_gift) {
            com.baidu.live.b.e eVar = new com.baidu.live.b.e(getPageContext().getPageActivity(), 1, 1001);
            eVar.d(this.aNj, AlaLiveWishListActivity.fYT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
        } else if (id == a.f.add_wish_center_edit_gift_num) {
            com.baidu.live.b.e eVar2 = new com.baidu.live.b.e(getPageContext().getPageActivity(), 2, 1002);
            eVar2.dE(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar2));
        } else if (id == a.f.add_wish_center_edit_deadline) {
            com.baidu.live.b.e eVar3 = new com.baidu.live.b.e(getPageContext().getPageActivity(), 3, 1003);
            eVar3.dF(this.fYI);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar3));
        } else if (id == a.f.add_wish_center_edit_thank_way) {
            bLS();
        } else if (id == a.f.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aNj)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_num_tip));
            } else if (this.fYI <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.fYH)) {
                    this.fYH = getPageContext().getResources().getString(a.h.add_wish_thank_way_txt);
                }
                this.fYl.b(this.fYm, this.aNj, this.fYH, this.fYI, this.mGiftNum);
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
                    this.aNj = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.fYD.setText(optString);
                    this.fYD.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.fYE.setText(String.valueOf(optInt));
                    this.fYE.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.fYI = optInt2;
                    this.fYF.setText(String.valueOf(optInt2) + "小时");
                    this.fYF.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                }
                bLR();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bLR() {
        if (this.fYC != null) {
            if (!TextUtils.isEmpty(this.aNj) && this.mGiftNum > 0 && this.fYI > 0) {
                this.fYC.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                this.fYC.setBackgroundResource(a.e.ala_live_create_wish_bt_bg);
                return;
            }
            this.fYC.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_i_alpha80));
            this.fYC.setBackgroundResource(a.e.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void b(m mVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void aN(int i, String str) {
        String string = getPageContext().getResources().getString(a.h.add_wish_add_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void a(m mVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void aM(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aO(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fXZ = alaLiveInputEditView;
        this.fXZ.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.fXZ.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.fXZ.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.FQ(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fXZ.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.b.a
            public void hn(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.fYH = str;
                    AlaLiveAddWishActivity.this.fYG.setText(str);
                    AlaLiveAddWishActivity.this.fYG.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bLT();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.fXZ.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bLS() {
        this.fXZ.Ng();
        this.fXZ.getEditView().setFocusable(true);
        this.fXZ.getEditView().setFocusableInTouchMode(true);
        this.fXZ.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.fXZ.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fXZ.getEditView());
            }
        }, 100L);
    }

    public void bLT() {
        this.fXZ.setVisibility(8);
        this.fXZ.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fXZ.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aYX = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.aYY != rect.bottom;
                AlaLiveAddWishActivity.this.aYY = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aYX);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void onKeyboardVisibilityChanged(boolean z) {
        super.onKeyboardVisibilityChanged(z);
        if (z) {
            Rect rect = new Rect();
            this.mRootView.getRootView().getWindowVisibleDisplayFrame(rect);
            int dimensionPixelSize = rect.bottom - getResources().getDimensionPixelSize(a.d.sdk_ds104);
            int statusBarHeight = !UtilHelper.canUseStyleImmersiveSticky() ? dimensionPixelSize - UtilHelper.getStatusBarHeight() : dimensionPixelSize;
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fXZ.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.fXZ.setLayoutParams(layoutParams);
            this.fXZ.setVisibility(0);
            this.fXY.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fXZ.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.fXZ.setLayoutParams(layoutParams2);
        this.fXZ.setVisibility(8);
        this.fXY.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fXZ.getVisibility() == 0) {
            bLT();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean FQ(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
