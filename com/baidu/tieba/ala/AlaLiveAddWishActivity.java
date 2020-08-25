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
import com.baidu.tieba.ala.f.h;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, h.a, h.b, h.c {
    private ViewTreeObserver.OnGlobalLayoutListener aQU;
    private int aQV;
    private h fuD;
    private String fuE;
    private TbImageView fuS;
    private RelativeLayout fuT;
    private RelativeLayout fuU;
    private RelativeLayout fuV;
    private RelativeLayout fuW;
    private Button fuX;
    private TextView fuY;
    private TextView fuZ;
    private View ful;
    private FrameLayout fuq;
    private AlaLiveInputEditView fur;
    private TextView fva;
    private TextView fvb;
    private String fvc;
    private int fvd;
    private int fve;
    private RelativeLayout fvf;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aND = false;
    private boolean aQY = false;
    private boolean aQZ = false;
    private String aHi = "";
    private CustomMessageListener aNT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aNU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aNU);
            registerListener(this.aNT);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aQY = false;
            this.mRootView.setVisibility(4);
            this.fuD = new h(getPageContext(), this, this, this);
            this.fve = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aND) {
            this.mRootView.setVisibility(0);
            FD();
            this.aND = true;
        }
    }

    private void FD() {
        Animation loadAnimation;
        this.aQY = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.aQY = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void FE() {
        Animation loadAnimation;
        if (!this.aQZ && !this.aQY) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0185a.sdk_out_to_bottom);
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
            this.aQZ = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        FE();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.fvf = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fvf.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.fvf.setLayoutParams(layoutParams);
        this.ful = findViewById(a.g.add_wish_root_bg);
        this.ful.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.fuS = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.fuT = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.fuU = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.fuV = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.fuW = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.fuX = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.fuS.setOnClickListener(this);
        this.fuT.setOnClickListener(this);
        this.fuU.setOnClickListener(this);
        this.fuV.setOnClickListener(this);
        this.fuW.setOnClickListener(this);
        this.fuX.setOnClickListener(this);
        this.fuY = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.fuZ = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.fva = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.fvb = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.fuq = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.fuq.setOnClickListener(new AnonymousClass6());
        this.fur = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.fur.getEditView().setInputType(1);
        this.fur.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.fur.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.fur.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.fur);
        bDB();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaLiveAddWishActivity$6  reason: invalid class name */
    /* loaded from: classes7.dex */
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
                        AlaLiveAddWishActivity.this.fuq.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bDD();
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
        if (this.fuD != null) {
            this.fuD.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aQU);
        this.aQU = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.c.d dVar = new com.baidu.live.c.d(getPageContext().getPageActivity(), 1, 1001);
            dVar.d(this.aHi, AlaLiveWishListActivity.fvo);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.c.d dVar2 = new com.baidu.live.c.d(getPageContext().getPageActivity(), 2, 1002);
            dVar2.dv(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.c.d dVar3 = new com.baidu.live.c.d(getPageContext().getPageActivity(), 3, 1003);
            dVar3.dw(this.fvd);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, dVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            bDC();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aHi)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else if (this.fvd <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.fvc)) {
                    this.fvc = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
                }
                this.fuD.b(this.fuE, this.aHi, this.fvc, this.fvd, this.mGiftNum);
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
                    this.aHi = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.fuY.setText(optString);
                    this.fuY.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.fuZ.setText(String.valueOf(optInt));
                    this.fuZ.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.fvd = optInt2;
                    this.fva.setText(String.valueOf(optInt2) + "小时");
                    this.fva.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                bDB();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bDB() {
        if (this.fuX != null) {
            if (!TextUtils.isEmpty(this.aHi) && this.mGiftNum > 0 && this.fvd > 0) {
                this.fuX.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                this.fuX.setBackgroundResource(a.f.ala_live_create_wish_bt_bg);
                return;
            }
            this.fuX.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
            this.fuX.setBackgroundResource(a.f.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.f.h.c
    public void b(k kVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.f.h.c
    public void aw(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.add_wish_add_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    @Override // com.baidu.tieba.ala.f.h.a
    public void a(k kVar) {
    }

    @Override // com.baidu.tieba.ala.f.h.a
    public void av(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void c(k kVar) {
    }

    @Override // com.baidu.tieba.ala.f.h.b
    public void ax(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.fur = alaLiveInputEditView;
        this.fur.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.fur.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.fur.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.Ea(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.fur.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.b.a
            public void gw(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.fvc = str;
                    AlaLiveAddWishActivity.this.fvb.setText(str);
                    AlaLiveAddWishActivity.this.fvb.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bDD();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.fur.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bDC() {
        this.fur.KA();
        this.fur.getEditView().setFocusable(true);
        this.fur.getEditView().setFocusableInTouchMode(true);
        this.fur.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.fur.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fur.getEditView());
            }
        }, 100L);
    }

    public void bDD() {
        this.fur.setVisibility(8);
        this.fur.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.fur.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aQU = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.aQV != rect.bottom;
                AlaLiveAddWishActivity.this.aQV = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aQU);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fur.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.fur.setLayoutParams(layoutParams);
            this.fur.setVisibility(0);
            this.fuq.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fur.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.fur.setLayoutParams(layoutParams2);
        this.fur.setVisibility(8);
        this.fuq.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.fur.getVisibility() == 0) {
            bDD();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean Ea(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
