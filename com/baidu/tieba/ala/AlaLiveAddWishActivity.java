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
import com.baidu.tieba.ala.data.k;
import com.baidu.tieba.ala.g.i;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, i.a, i.b, i.c {
    private ViewTreeObserver.OnGlobalLayoutListener aSZ;
    private int aTa;
    private View fxA;
    private FrameLayout fxF;
    private AlaLiveInputEditView fxG;
    private i fxS;
    private String fxT;
    private TbImageView fyh;
    private RelativeLayout fyi;
    private RelativeLayout fyj;
    private RelativeLayout fyk;
    private RelativeLayout fyl;
    private Button fym;
    private TextView fyn;
    private TextView fyo;
    private TextView fyp;
    private TextView fyq;
    private String fyr;
    private int fys;
    private int fyt;
    private RelativeLayout fyu;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aPD = false;
    private boolean aTd = false;
    private boolean aTe = false;
    private String aIB = "";
    private CustomMessageListener aPT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aPU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aPU);
            registerListener(this.aPT);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aTd = false;
            this.mRootView.setVisibility(4);
            this.fxS = new i(getPageContext(), this, this, this);
            this.fyt = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aPD) {
            this.mRootView.setVisibility(0);
            Gd();
            this.aPD = true;
        }
    }

    private void Gd() {
        Animation loadAnimation;
        this.aTd = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.aTd = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Ge() {
        Animation loadAnimation;
        if (!this.aTe && !this.aTd) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0186a.sdk_out_to_bottom);
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
            this.aTe = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Ge();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fyu = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fyu.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fyu.setLayoutParams(layoutParams);
        this.fxA = findViewById(a.g.add_wish_root_bg);
        this.fxA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.fyh = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.fyi = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.fyj = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.fyk = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.fyl = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.fym = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.fyh.setOnClickListener(this);
        this.fyi.setOnClickListener(this);
        this.fyj.setOnClickListener(this);
        this.fyk.setOnClickListener(this);
        this.fyl.setOnClickListener(this);
        this.fym.setOnClickListener(this);
        this.fyn = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.fyo = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.fyp = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.fyq = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.fxF = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.fxF.setOnClickListener(new AnonymousClass6());
        this.fxG = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.fxG.getEditView().setInputType(1);
        this.fxG.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.fxG.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.fxG.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.fxG);
        bEP();
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
                        AlaLiveAddWishActivity.this.fxF.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bER();
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
        if (this.fxS != null) {
            this.fxS.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aSZ);
        this.aSZ = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.b.d dVar = new com.baidu.live.b.d(getPageContext().getPageActivity(), 1, 1001);
            dVar.d(this.aIB, AlaLiveWishListActivity.fyD);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.b.d dVar2 = new com.baidu.live.b.d(getPageContext().getPageActivity(), 2, 1002);
            dVar2.dz(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.b.d dVar3 = new com.baidu.live.b.d(getPageContext().getPageActivity(), 3, 1003);
            dVar3.dA(this.fys);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            bEQ();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aIB)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else if (this.fys <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.fyr)) {
                    this.fyr = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
                }
                this.fxS.b(this.fxT, this.aIB, this.fyr, this.fys, this.mGiftNum);
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
                    this.aIB = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.fyn.setText(optString);
                    this.fyn.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.fyo.setText(String.valueOf(optInt));
                    this.fyo.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.fys = optInt2;
                    this.fyp.setText(String.valueOf(optInt2) + "小时");
                    this.fyp.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                bEP();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bEP() {
        if (this.fym != null) {
            if (!TextUtils.isEmpty(this.aIB) && this.mGiftNum > 0 && this.fys > 0) {
                this.fym.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                this.fym.setBackgroundResource(a.f.ala_live_create_wish_bt_bg);
                return;
            }
            this.fym.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
            this.fym.setBackgroundResource(a.f.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void b(k kVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void aw(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.add_wish_add_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void a(k kVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.a
    public void av(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(k kVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void ax(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fxG = alaLiveInputEditView;
        this.fxG.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.fxG.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.fxG.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.Ey(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fxG.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.b.a
            public void gH(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.fyr = str;
                    AlaLiveAddWishActivity.this.fyq.setText(str);
                    AlaLiveAddWishActivity.this.fyq.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bER();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.fxG.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bEQ() {
        this.fxG.Lh();
        this.fxG.getEditView().setFocusable(true);
        this.fxG.getEditView().setFocusableInTouchMode(true);
        this.fxG.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.fxG.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fxG.getEditView());
            }
        }, 100L);
    }

    public void bER() {
        this.fxG.setVisibility(8);
        this.fxG.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fxG.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aSZ = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.aTa != rect.bottom;
                AlaLiveAddWishActivity.this.aTa = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aSZ);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fxG.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.fxG.setLayoutParams(layoutParams);
            this.fxG.setVisibility(0);
            this.fxF.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fxG.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.fxG.setLayoutParams(layoutParams2);
        this.fxG.setVisibility(8);
        this.fxF.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fxG.getVisibility() == 0) {
            bER();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean Ey(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
