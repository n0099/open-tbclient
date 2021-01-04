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
    private ViewTreeObserver.OnGlobalLayoutListener bck;
    private int bcl;
    private View gpT;
    private FrameLayout gpW;
    private AlaLiveInputEditView gpX;
    private i gqD;
    private String gqE;
    private TbImageView gqP;
    private RelativeLayout gqQ;
    private RelativeLayout gqR;
    private RelativeLayout gqS;
    private RelativeLayout gqT;
    private Button gqU;
    private TextView gqV;
    private TextView gqW;
    private TextView gqX;
    private TextView gqY;
    private String gqZ;
    private int gra;
    private int grb;
    private RelativeLayout grc;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aYb = false;
    private boolean bco = false;
    private boolean bcp = false;
    private String aPa = "";
    private CustomMessageListener aYr = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aYs = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aYs);
            registerListener(this.aYr);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.bco = false;
            this.mRootView.setVisibility(4);
            this.gqD = new i(getPageContext(), this, this, this);
            this.grb = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aYb) {
            this.mRootView.setVisibility(0);
            IG();
            this.aYb = true;
        }
    }

    private void IG() {
        Animation loadAnimation;
        this.bco = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.bco = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void IH() {
        Animation loadAnimation;
        if (!this.bcp && !this.bco) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0203a.sdk_out_to_bottom);
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
            this.bcp = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        IH();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.grc = (RelativeLayout) findViewById(a.f.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.grc.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.grc.setLayoutParams(layoutParams);
        this.gpT = findViewById(a.f.add_wish_root_bg);
        this.gpT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.gqP = (TbImageView) this.mRootView.findViewById(a.f.add_wish_tile_icon_return);
        this.gqQ = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift);
        this.gqR = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num);
        this.gqS = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline);
        this.gqT = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way);
        this.gqU = (Button) this.mRootView.findViewById(a.f.add_wish_next_bt);
        this.gqP.setOnClickListener(this);
        this.gqQ.setOnClickListener(this);
        this.gqR.setOnClickListener(this);
        this.gqS.setOnClickListener(this);
        this.gqT.setOnClickListener(this);
        this.gqU.setOnClickListener(this);
        this.gqV = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_action);
        this.gqW = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num_action);
        this.gqX = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline_action);
        this.gqY = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.h.add_wish_title));
        this.gpW = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.gpW.setOnClickListener(new AnonymousClass6());
        this.gpX = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        this.gpX.getEditView().setInputType(1);
        this.gpX.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.gpX.setHintText(getPageContext().getResources().getString(a.h.add_wish_thank_way_hinit));
        this.gpX.getTextView().setText(getPageContext().getResources().getString(a.h.add_wish_thank_way_send));
        e(this.gpX);
        bRu();
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
                        AlaLiveAddWishActivity.this.gpW.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bRw();
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
        if (this.gqD != null) {
            this.gqD.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.bck);
        this.bck = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.f.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.f.add_wish_center_edit_gift) {
            com.baidu.live.d.e eVar = new com.baidu.live.d.e(getPageContext().getPageActivity(), 1, 1001);
            eVar.d(this.aPa, AlaLiveWishListActivity.grl);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
        } else if (id == a.f.add_wish_center_edit_gift_num) {
            com.baidu.live.d.e eVar2 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 2, 1002);
            eVar2.dQ(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar2));
        } else if (id == a.f.add_wish_center_edit_deadline) {
            com.baidu.live.d.e eVar3 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 3, 1003);
            eVar3.dR(this.gra);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar3));
        } else if (id == a.f.add_wish_center_edit_thank_way) {
            bRv();
        } else if (id == a.f.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aPa)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_num_tip));
            } else if (this.gra <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.gqZ)) {
                    this.gqZ = getPageContext().getResources().getString(a.h.add_wish_thank_way_txt);
                }
                this.gqD.c(this.gqE, this.aPa, this.gqZ, this.gra, this.mGiftNum);
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
                    this.aPa = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.gqV.setText(optString);
                    this.gqV.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.gqW.setText(String.valueOf(optInt));
                    this.gqW.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.gra = optInt2;
                    this.gqX.setText(String.valueOf(optInt2) + "小时");
                    this.gqX.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                }
                bRu();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bRu() {
        if (this.gqU != null) {
            if (!TextUtils.isEmpty(this.aPa) && this.mGiftNum > 0 && this.gra > 0) {
                this.gqU.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                this.gqU.setBackgroundResource(a.e.ala_live_create_wish_bt_bg);
                return;
            }
            this.gqU.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_i_alpha80));
            this.gqU.setBackgroundResource(a.e.ala_add_wish_edit_next_bt_bg);
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
        this.gpX = alaLiveInputEditView;
        this.gpX.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.gpX.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.gpX.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.Ge(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gpX.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.c.a
            public void hn(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.gqZ = str;
                    AlaLiveAddWishActivity.this.gqY.setText(str);
                    AlaLiveAddWishActivity.this.gqY.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bRw();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.gpX.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bRv() {
        this.gpX.Ox();
        this.gpX.getEditView().setFocusable(true);
        this.gpX.getEditView().setFocusableInTouchMode(true);
        this.gpX.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.gpX.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gpX.getEditView());
            }
        }, 100L);
    }

    public void bRw() {
        this.gpX.setVisibility(8);
        this.gpX.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gpX.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.bck = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.bcl != rect.bottom;
                AlaLiveAddWishActivity.this.bcl = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.mIsKeyboardOpen || z)) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.mIsKeyboardOpen) {
                    AlaLiveAddWishActivity.this.mIsKeyboardOpen = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.bck);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gpX.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gpX.setLayoutParams(layoutParams);
            this.gpX.setVisibility(0);
            this.gpW.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gpX.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.gpX.setLayoutParams(layoutParams2);
        this.gpX.setVisibility(8);
        this.gpW.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gpX.getVisibility() == 0) {
            bRw();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean Ge(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
