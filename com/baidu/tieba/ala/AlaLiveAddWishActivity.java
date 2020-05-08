package com.baidu.tieba.ala;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
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
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, g.a, g.b, g.c {
    private ViewTreeObserver.OnGlobalLayoutListener aCi;
    private int aCj;
    private boolean aCk;
    private RelativeLayout eHA;
    private RelativeLayout eHB;
    private RelativeLayout eHC;
    private RelativeLayout eHD;
    private Button eHE;
    private TextView eHF;
    private TextView eHG;
    private TextView eHH;
    private TextView eHI;
    private String eHJ;
    private int eHK;
    private int eHL;
    private RelativeLayout eHM;
    private View eHd;
    private FrameLayout eHi;
    private AlaLiveInputEditView eHj;
    private g eHu;
    private String eHv;
    private TbImageView eHz;
    private Context mContext;
    private int mGiftNum;
    private View mRootView;
    private TextView mTitleTextView;
    private Handler mHandler = new Handler();
    private boolean azj = false;
    private boolean aCn = false;
    private boolean aCo = false;
    private String aty = "";
    private CustomMessageListener azz = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    CustomMessageListener azA = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6
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
            registerListener(this.azA);
            registerListener(this.azz);
            addGlobalLayoutListener();
            initView();
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
            this.aCn = false;
            this.mRootView.setVisibility(4);
            this.eHu = new g(getPageContext(), this, this, this);
            this.eHL = getIntent().getIntExtra("item_count", 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.azj) {
            this.mRootView.setVisibility(0);
            xL();
            this.azj = true;
        }
    }

    private void xL() {
        Animation loadAnimation;
        this.aCn = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.aCn = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void xM() {
        Animation loadAnimation;
        if (!this.aCo && !this.aCn) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0149a.sdk_out_to_bottom);
            }
            loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.3
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
            this.aCo = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        xM();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.eHM = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eHM.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.eHM.setLayoutParams(layoutParams);
        this.eHd = findViewById(a.g.add_wish_root_bg);
        this.eHd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.eHz = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.eHA = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.eHB = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.eHC = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.eHD = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.eHE = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.eHz.setOnClickListener(this);
        this.eHA.setOnClickListener(this);
        this.eHB.setOnClickListener(this);
        this.eHC.setOnClickListener(this);
        this.eHD.setOnClickListener(this);
        this.eHE.setOnClickListener(this);
        this.eHF = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.eHG = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.eHH = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.eHI = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.eHi = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.eHj = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.eHj.getEditView().setInputType(1);
        this.eHj.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.eHj.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.eHj.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.eHj);
        bjD();
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
        if (this.eHu != null) {
            this.eHu.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aCi);
        this.aCi = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(getPageContext().getPageActivity(), 1, 1001);
            cVar.d(this.aty, AlaLiveWishListActivity.eHT);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.c.c cVar2 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 2, 1002);
            cVar2.bs(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.c.c cVar3 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 3, 1003);
            cVar3.bt(this.eHK);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            bjE();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.eHJ)) {
                this.eHJ = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
            }
            if (TextUtils.isEmpty(this.aty)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.eHK <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else {
                this.eHu.b(this.eHv, this.aty, this.eHJ, this.eHK, this.mGiftNum);
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
                    this.aty = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.eHF.setText(optString);
                    this.eHF.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.eHG.setText(String.valueOf(optInt));
                    this.eHG.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.eHK = optInt2;
                    this.eHH.setText(String.valueOf(optInt2) + "小时");
                    this.eHH.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                bjD();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bjD() {
        if (this.eHE != null) {
            if (!TextUtils.isEmpty(this.aty) && this.mGiftNum > 0 && this.eHK > 0) {
                this.eHE.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                this.eHE.setBackgroundResource(a.f.ala_live_create_wish_bt_bg);
                return;
            }
            this.eHE.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
            this.eHE.setBackgroundResource(a.f.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.f.g.c
    public void b(j jVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.f.g.c
    public void ap(int i, String str) {
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
    public void ao(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void c(j jVar) {
    }

    @Override // com.baidu.tieba.ala.f.g.b
    public void aq(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.eHj = alaLiveInputEditView;
        this.eHj.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.eHj.setSendEnabled(false);
                } else {
                    AlaLiveAddWishActivity.this.eHj.setSendEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.eHj.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
            @Override // com.baidu.live.view.input.b.a
            public void em(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.eHJ = str;
                    AlaLiveAddWishActivity.this.eHI.setText(str);
                    AlaLiveAddWishActivity.this.eHI.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bjF();
                }
            }
        });
    }

    public void bjE() {
        this.eHj.CO();
        this.eHj.getEditView().setFocusable(true);
        this.eHj.getEditView().setFocusableInTouchMode(true);
        this.eHj.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.eHj.getEditView().requestFocus();
                AlaLiveAddWishActivity.this.eHj.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.eHj.getEditView());
            }
        }, 100L);
    }

    public void bjF() {
        this.eHj.setVisibility(8);
        this.eHj.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.eHj.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aCi = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.aCj != rect.bottom;
                AlaLiveAddWishActivity.this.aCj = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.aCk || z)) {
                    AlaLiveAddWishActivity.this.aCk = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.aCk) {
                    AlaLiveAddWishActivity.this.aCk = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aCi);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eHj.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.eHj.setLayoutParams(layoutParams);
            this.eHj.setVisibility(0);
            this.eHi.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eHj.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.eHj.setLayoutParams(layoutParams2);
        this.eHj.setVisibility(8);
        this.eHi.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.eHj.getVisibility() == 0) {
            bjF();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
