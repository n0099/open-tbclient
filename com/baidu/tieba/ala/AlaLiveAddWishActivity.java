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
/* loaded from: classes4.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, i.a, i.b, i.c {
    private ViewTreeObserver.OnGlobalLayoutListener baD;
    private int baE;
    private View gfO;
    private FrameLayout gfS;
    private AlaLiveInputEditView gfT;
    private TextView ggA;
    private String ggB;
    private int ggC;
    private int ggD;
    private RelativeLayout ggE;
    private i ggf;
    private String ggg;
    private TbImageView ggr;
    private RelativeLayout ggs;
    private RelativeLayout ggt;
    private RelativeLayout ggu;
    private RelativeLayout ggv;
    private Button ggw;
    private TextView ggx;
    private TextView ggy;
    private TextView ggz;
    private Context mContext;
    private int mGiftNum;
    private boolean mIsKeyboardOpen;
    private View mRootView;
    private TextView mTitleTextView;
    private Pattern pattern;
    private Handler mHandler = new Handler();
    private boolean aWv = false;
    private boolean baH = false;
    private boolean baI = false;
    private String aOt = "";
    private CustomMessageListener aWL = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    private CustomMessageListener aWM = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
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
            registerListener(this.aWM);
            registerListener(this.aWL);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.baH = false;
            this.mRootView.setVisibility(4);
            this.ggf = new i(getPageContext(), this, this, this);
            this.ggD = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aWv) {
            this.mRootView.setVisibility(0);
            Je();
            this.aWv = true;
        }
    }

    private void Je() {
        Animation loadAnimation;
        this.baH = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_in_from_bottom);
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

    private void Jf() {
        Animation loadAnimation;
        if (!this.baI && !this.baH) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0205a.sdk_out_to_bottom);
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
        Jf();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ggE = (RelativeLayout) findViewById(a.f.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ggE.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ggE.setLayoutParams(layoutParams);
        this.gfO = findViewById(a.f.add_wish_root_bg);
        this.gfO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.ggr = (TbImageView) this.mRootView.findViewById(a.f.add_wish_tile_icon_return);
        this.ggs = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift);
        this.ggt = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num);
        this.ggu = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline);
        this.ggv = (RelativeLayout) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way);
        this.ggw = (Button) this.mRootView.findViewById(a.f.add_wish_next_bt);
        this.ggr.setOnClickListener(this);
        this.ggs.setOnClickListener(this);
        this.ggt.setOnClickListener(this);
        this.ggu.setOnClickListener(this);
        this.ggv.setOnClickListener(this);
        this.ggw.setOnClickListener(this);
        this.ggx = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_action);
        this.ggy = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_gift_num_action);
        this.ggz = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_deadline_action);
        this.ggA = (TextView) this.mRootView.findViewById(a.f.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.f.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.h.add_wish_title));
        this.gfS = (FrameLayout) this.mRootView.findViewById(a.f.choose_gift_input_layout);
        this.gfS.setOnClickListener(new AnonymousClass6());
        this.gfT = (AlaLiveInputEditView) this.mRootView.findViewById(a.f.choose_gift_input_edit);
        this.gfT.getEditView().setInputType(1);
        this.gfT.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.gfT.setHintText(getPageContext().getResources().getString(a.h.add_wish_thank_way_hinit));
        this.gfT.getTextView().setText(getPageContext().getResources().getString(a.h.add_wish_thank_way_send));
        e(this.gfT);
        bOU();
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
                        AlaLiveAddWishActivity.this.gfS.post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AlaLiveAddWishActivity.this.bOW();
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
        if (this.ggf != null) {
            this.ggf.onDestroy();
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
            eVar.d(this.aOt, AlaLiveWishListActivity.ggN);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar));
        } else if (id == a.f.add_wish_center_edit_gift_num) {
            com.baidu.live.d.e eVar2 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 2, 1002);
            eVar2.dT(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar2));
        } else if (id == a.f.add_wish_center_edit_deadline) {
            com.baidu.live.d.e eVar3 = new com.baidu.live.d.e(getPageContext().getPageActivity(), 3, 1003);
            eVar3.dU(this.ggC);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, eVar3));
        } else if (id == a.f.add_wish_center_edit_thank_way) {
            bOV();
        } else if (id == a.f.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.aOt)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_tips_txt));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_num_tip));
            } else if (this.ggC <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_deadline_tip));
            } else {
                if (TextUtils.isEmpty(this.ggB)) {
                    this.ggB = getPageContext().getResources().getString(a.h.add_wish_thank_way_txt);
                }
                this.ggf.b(this.ggg, this.aOt, this.ggB, this.ggC, this.mGiftNum);
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
                    this.aOt = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.ggx.setText(optString);
                    this.ggx.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.ggy.setText(String.valueOf(optInt));
                    this.ggy.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.ggC = optInt2;
                    this.ggz.setText(String.valueOf(optInt2) + "小时");
                    this.ggz.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                }
                bOU();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bOU() {
        if (this.ggw != null) {
            if (!TextUtils.isEmpty(this.aOt) && this.mGiftNum > 0 && this.ggC > 0) {
                this.ggw.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                this.ggw.setBackgroundResource(a.e.ala_live_create_wish_bt_bg);
                return;
            }
            this.ggw.setTextColor(getPageContext().getResources().getColor(a.c.sdk_cp_cont_i_alpha80));
            this.ggw.setBackgroundResource(a.e.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void b(m mVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.g.i.c
    public void aL(int i, String str) {
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
    public void aK(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void c(m mVar) {
    }

    @Override // com.baidu.tieba.ala.g.i.b
    public void aM(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.gfT = alaLiveInputEditView;
        this.gfT.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.gfT.setSendEnabled(false);
                    return;
                }
                AlaLiveAddWishActivity.this.gfT.setSendEnabled(true);
                if (!AlaLiveAddWishActivity.this.Gf(charSequence.toString())) {
                    AlaLiveAddWishActivity.this.a(charSequence, i, i3);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.gfT.setEditViewConfirmCallBack(new c.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // com.baidu.live.view.input.c.a
            public void hC(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.ggB = str;
                    AlaLiveAddWishActivity.this.ggA.setText(str);
                    AlaLiveAddWishActivity.this.ggA.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.c.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bOW();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(CharSequence charSequence, int i, int i2) {
        int length = charSequence.length();
        if (i >= 0 && length >= i2 && i + i2 <= length) {
            this.gfT.setEditText(charSequence.toString().substring(0, length - i2));
            getPageContext().showToast(getPageContext().getResources().getString(a.h.add_wish_gift_contain_emoji_tip));
        }
    }

    public void bOV() {
        this.gfT.OS();
        this.gfT.getEditView().setFocusable(true);
        this.gfT.getEditView().setFocusableInTouchMode(true);
        this.gfT.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.11
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.gfT.getEditView().requestFocus();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gfT.getEditView());
            }
        }, 100L);
    }

    public void bOW() {
        this.gfT.setVisibility(8);
        this.gfT.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.gfT.getEditView());
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gfT.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.gfT.setLayoutParams(layoutParams);
            this.gfT.setVisibility(0);
            this.gfS.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gfT.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.gfT.setLayoutParams(layoutParams2);
        this.gfT.setVisibility(8);
        this.gfS.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.gfT.getVisibility() == 0) {
            bOW();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    public boolean Gf(String str) {
        if (this.pattern == null) {
            this.pattern = Pattern.compile("^[a-zA-Z0-9\\u4e00-\\u9fa5]+$");
        }
        return this.pattern.matcher(str).matches();
    }
}
