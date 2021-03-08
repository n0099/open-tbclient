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
import com.baidu.live.view.input.c;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.g.i;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, i.a, i.b, i.c {
    private ViewTreeObserver.OnGlobalLayoutListener bcd;
    private int bce;
    private View gpP;
    private FrameLayout gpS;
    private AlaLiveInputEditView gpT;
    private com.baidu.tieba.ala.g.i gqC;
    private String gqD;
    private TbImageView gqO;
    private RelativeLayout gqP;
    private RelativeLayout gqQ;
    private RelativeLayout gqR;
    private RelativeLayout gqS;
    private Button gqT;
    private TextView gqU;
    private TextView gqV;
    private TextView gqW;
    private TextView gqX;
    private String gqY;
    private int gqZ;
    private int gra;
    private RelativeLayout grb;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aXT = false;
    private boolean bch = false;
    private boolean bci = false;
    private String aOA = "";
    private CustomMessageListener aYj = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aYk = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (!isFinishing()) {
            registerListener(this.aYk);
            registerListener(this.aYj);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.bch = false;
            this.mRootView.setVisibility(4);
            this.gqC = new com.baidu.tieba.ala.g.i(getPageContext(), this, this, this);
            this.gra = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aXT) {
            this.mRootView.setVisibility(0);
            Ge();
            this.aXT = true;
        }
    }

    private void Ge() {
        Animation loadAnimation;
        this.bch = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.bch = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gf() {
        Animation loadAnimation;
        if (!this.bci && !this.bch) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0201a.sdk_out_to_bottom);
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
            this.bci = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gf();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.grb = (RelativeLayout) findViewById(a.f.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grb.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.grb.setLayoutParams(layoutParams);
        this.gpP = findViewById(a.f.add_wish_root_bg);
        this.gpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.gqO = (TbImageView) this.mRootView.findViewById(a.f.add_wish_tile_icon_return);
        this.gqP = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift);
        this.gqQ = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num);
        this.gqR = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline);
        this.gqS = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way);
        this.gqT = (Button) this.mRootView.findViewById(a.f.add_wish_next_bt);
        this.gqO.setOnClickListener(this);
        this.gqP.setOnClickListener(this);
        this.gqQ.setOnClickListener(this);
        this.gqR.setOnClickListener(this);
        this.gqS.setOnClickListener(this);
        this.gqT.setOnClickListener(this);
        this.gqU = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_action);
        this.gqV = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num_action);
        this.gqW = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline_action);
        this.gqX = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.h.add_wish_title));
        this.gpS = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.gpS.setOnClickListener(new AnonymousClass6());
        this.gpT = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        this.gpT.getEditView().setInputType(1);
        this.gpT.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.gpT.setHintText(getPageContext().getResources().getString(a.h.add_wish_thank_way_hinit));
        this.gpT.getTextView().setText(getPageContext().getResources().getString(a.h.add_wish_thank_way_send));
        e(this.gpT);
        bOr();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaLiveAddWishActivity$6  reason: invalid class name */
    /* loaded from: classes10.dex */
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
                        AlaLiveAddWishActivity.this.gpS.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bOt();
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
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gqC != null) {
            this.gqC.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bcd);
        this.bcd = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.f.add_wish_center_edit_gift) {
            com.baidu.live.d.e eVar = new com.baidu.live.d.e(getPageContext().getPageActivity(), 1, 1001);
            eVar.d(this.aOA, AlaLiveWishListActivity.grk);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
        } else if (id == a.f.add_wish_center_edit_gift_num) {
            com.baidu.live.d.e eVar2 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 2, 1002);
            eVar2.co(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar2));
        } else if (id == a.f.add_wish_center_edit_deadline) {
            com.baidu.live.d.e eVar3 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 3, 1003);
            eVar3.cp(this.gqZ);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar3));
        } else if (id == a.f.add_wish_center_edit_thank_way) {
            bOs();
        } else if (id == a.f.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aOA)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_num_tip));
            } else if (this.gqZ <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.gqY)) {
                    this.gqY = getPageContext().getResources().getString(a.h.add_wish_thank_way_txt);
                }
                this.gqC.c(this.gqD, this.aOA, this.gqY, this.gqZ, this.mGiftNum);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (-1 == i2) {
            try {
                JSONObject jSONObject = new JSONObject(intent.getStringExtra(FrsProfessionIntroActivityConfig.KEY_RESULT));
                if (i == 1001) {
                    String optString = jSONObject.optString("gift_title");
                    jSONObject.optString("gift_url");
                    this.aOA = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.gqU.setText(optString);
                    this.gqU.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.gqV.setText(String.valueOf(optInt));
                    this.gqV.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.gqZ = optInt2;
                    this.gqW.setText(String.valueOf(optInt2) + "小时");
                    this.gqW.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                }
                bOr();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bOr() {
        if (this.gqT != null) {
            if (!TextUtils.isEmpty(this.aOA) && this.mGiftNum > 0 && this.gqZ > 0) {
                this.gqT.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                this.gqT.setBackgroundResource(a.e.ala_live_create_wish_bt_bg);
                return;
            }
            this.gqT.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_i_alpha80));
            this.gqT.setBackgroundResource(a.e.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void b(m mVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void aT(int i, String str) {
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
    public void aS(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aU(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gpT = alaLiveInputEditView;
        this.gpT.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.gpT.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.gpT.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.FA(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gpT.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.c.a
            public void gF(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.gqY = str;
                    AlaLiveAddWishActivity.this.gqX.setText(str);
                    AlaLiveAddWishActivity.this.gqX.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bOt();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.gpT.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bOs() {
        this.gpT.Md();
        this.gpT.getEditView().setFocusable(true);
        this.gpT.getEditView().setFocusableInTouchMode(true);
        this.gpT.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.gpT.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gpT.getEditView());
            }
        }, 100L);
    }

    public void bOt() {
        this.gpT.setVisibility(8);
        this.gpT.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gpT.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.bcd = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.bce != rect.bottom;
                AlaLiveAddWishActivity.this.bce = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bcd);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpT.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gpT.setLayoutParams(layoutParams);
            this.gpT.setVisibility(0);
            this.gpS.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gpT.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.gpT.setLayoutParams(layoutParams2);
        this.gpT.setVisibility(8);
        this.gpS.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gpT.getVisibility() == 0) {
            bOt();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean FA(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
