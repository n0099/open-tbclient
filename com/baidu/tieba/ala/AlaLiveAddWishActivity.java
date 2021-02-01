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
/* loaded from: classes11.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, i.a, i.b, i.c {
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private int baE;
    private View gnS;
    private FrameLayout gnV;
    private AlaLiveInputEditView gnW;
    private com.baidu.tieba.ala.g.i goF;
    private String goG;
    private TbImageView goR;
    private RelativeLayout goS;
    private RelativeLayout goT;
    private RelativeLayout goU;
    private RelativeLayout goV;
    private Button goW;
    private TextView goX;
    private TextView goY;
    private TextView goZ;
    private TextView gpa;
    private String gpb;
    private int gpc;
    private int gpd;
    private RelativeLayout gpe;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aWt = false;
    private boolean baH = false;
    private boolean baI = false;
    private String aNa = "";
    private CustomMessageListener aWJ = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aWK = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aWK);
            registerListener(this.aWJ);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            this.goF = new com.baidu.tieba.ala.g.i(getPageContext(), this, this, this);
            this.gpd = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWt) {
            this.mRootView.setVisibility(0);
            Gb();
            this.aWt = true;
        }
    }

    private void Gb() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.baH = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void Gc() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0195a.sdk_out_to_bottom);
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
            this.baI = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        Gc();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.gpe = (RelativeLayout) findViewById(a.f.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpe.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.gpe.setLayoutParams(layoutParams);
        this.gnS = findViewById(a.f.add_wish_root_bg);
        this.gnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.goR = (TbImageView) this.mRootView.findViewById(a.f.add_wish_tile_icon_return);
        this.goS = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift);
        this.goT = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num);
        this.goU = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline);
        this.goV = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way);
        this.goW = (Button) this.mRootView.findViewById(a.f.add_wish_next_bt);
        this.goR.setOnClickListener(this);
        this.goS.setOnClickListener(this);
        this.goT.setOnClickListener(this);
        this.goU.setOnClickListener(this);
        this.goV.setOnClickListener(this);
        this.goW.setOnClickListener(this);
        this.goX = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_action);
        this.goY = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num_action);
        this.goZ = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline_action);
        this.gpa = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.h.add_wish_title));
        this.gnV = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.gnV.setOnClickListener(new AnonymousClass6());
        this.gnW = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        this.gnW.getEditView().setInputType(1);
        this.gnW.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.gnW.setHintText(getPageContext().getResources().getString(a.h.add_wish_thank_way_hinit));
        this.gnW.getTextView().setText(getPageContext().getResources().getString(a.h.add_wish_thank_way_send));
        e(this.gnW);
        bOe();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.ala.AlaLiveAddWishActivity$6  reason: invalid class name */
    /* loaded from: classes11.dex */
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
                        AlaLiveAddWishActivity.this.gnV.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bOg();
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
        if (this.goF != null) {
            this.goF.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.baD);
        this.baD = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.f.add_wish_center_edit_gift) {
            com.baidu.live.d.e eVar = new com.baidu.live.d.e(getPageContext().getPageActivity(), 1, 1001);
            eVar.d(this.aNa, AlaLiveWishListActivity.gpn);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
        } else if (id == a.f.add_wish_center_edit_gift_num) {
            com.baidu.live.d.e eVar2 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 2, 1002);
            eVar2.cn(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar2));
        } else if (id == a.f.add_wish_center_edit_deadline) {
            com.baidu.live.d.e eVar3 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 3, 1003);
            eVar3.co(this.gpc);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar3));
        } else if (id == a.f.add_wish_center_edit_thank_way) {
            bOf();
        } else if (id == a.f.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aNa)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_num_tip));
            } else if (this.gpc <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.gpb)) {
                    this.gpb = getPageContext().getResources().getString(a.h.add_wish_thank_way_txt);
                }
                this.goF.c(this.goG, this.aNa, this.gpb, this.gpc, this.mGiftNum);
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
                    this.aNa = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.goX.setText(optString);
                    this.goX.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.goY.setText(String.valueOf(optInt));
                    this.goY.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.gpc = optInt2;
                    this.goZ.setText(String.valueOf(optInt2) + "小时");
                    this.goZ.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                }
                bOe();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bOe() {
        if (this.goW != null) {
            if (!TextUtils.isEmpty(this.aNa) && this.mGiftNum > 0 && this.gpc > 0) {
                this.goW.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                this.goW.setBackgroundResource(a.e.ala_live_create_wish_bt_bg);
                return;
            }
            this.goW.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_i_alpha80));
            this.goW.setBackgroundResource(a.e.ala_add_wish_edit_next_bt_bg);
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
        this.gnW = alaLiveInputEditView;
        this.gnW.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.gnW.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.gnW.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.Fq(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gnW.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.c.a
            public void gz(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.gpb = str;
                    AlaLiveAddWishActivity.this.gpa.setText(str);
                    AlaLiveAddWishActivity.this.gpa.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bOg();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.gnW.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bOf() {
        this.gnW.Ma();
        this.gnW.getEditView().setFocusable(true);
        this.gnW.getEditView().setFocusableInTouchMode(true);
        this.gnW.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.gnW.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gnW.getEditView());
            }
        }, 100L);
    }

    public void bOg() {
        this.gnW.setVisibility(8);
        this.gnW.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gnW.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.baD = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.baE != rect.bottom;
                AlaLiveAddWishActivity.this.baE = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.baD);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gnW.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gnW.setLayoutParams(layoutParams);
            this.gnW.setVisibility(0);
            this.gnV.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gnW.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.gnW.setLayoutParams(layoutParams2);
        this.gnW.setVisibility(8);
        this.gnV.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gnW.getVisibility() == 0) {
            bOg();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean Fq(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
