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
import com.baidu.tieba.ala.e.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, g.a, g.b, g.c {
    private ViewTreeObserver.OnGlobalLayoutListener aju;
    private int ajv;
    private boolean ajw;
    private View egE;
    private FrameLayout egJ;
    private AlaLiveInputEditView egK;
    private g egV;
    private String egW;
    private TbImageView eha;
    private RelativeLayout ehb;
    private RelativeLayout ehc;
    private RelativeLayout ehd;
    private RelativeLayout ehe;
    private Button ehf;
    private TextView ehg;
    private TextView ehh;
    private TextView ehi;
    private TextView ehj;
    private String ehk;
    private int ehl;
    private int ehm;
    private RelativeLayout ehn;
    private Context mContext;
    private int mGiftNum;
    private View mRootView;
    private TextView mTitleTextView;
    private Handler mHandler = new Handler();
    private boolean agD = false;
    private boolean ajy = false;
    private boolean ajz = false;
    private String aaT = "";
    private CustomMessageListener agT = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    CustomMessageListener agU = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6
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
        registerListener(this.agU);
        registerListener(this.agT);
        addGlobalLayoutListener();
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ajy = false;
        this.mRootView.setVisibility(4);
        this.egV = new g(getPageContext(), this, this, this);
        this.ehm = getIntent().getIntExtra("item_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.agD) {
            this.mRootView.setVisibility(0);
            tn();
            this.agD = true;
        }
    }

    private void tn() {
        Animation loadAnimation;
        this.ajy = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.ajy = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void tp() {
        Animation loadAnimation;
        if (!this.ajz && !this.ajy) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0102a.sdk_out_to_bottom);
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
            this.ajz = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        tp();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.ehn = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ehn.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.ehn.setLayoutParams(layoutParams);
        this.egE = findViewById(a.g.add_wish_root_bg);
        this.egE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.eha = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.ehb = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.ehc = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.ehd = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.ehe = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.ehf = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.eha.setOnClickListener(this);
        this.ehb.setOnClickListener(this);
        this.ehc.setOnClickListener(this);
        this.ehd.setOnClickListener(this);
        this.ehe.setOnClickListener(this);
        this.ehf.setOnClickListener(this);
        this.ehg = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.ehh = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.ehi = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.ehj = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.egJ = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.egK = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.egK.getEditView().setInputType(1);
        this.egK.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.egK.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.egK.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.egK);
        bbv();
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
        if (this.egV != null) {
            this.egV.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.aju);
        this.aju = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(getPageContext().getPageActivity(), 1, 1001);
            cVar.d(this.aaT, AlaLiveWishListActivity.ehu);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.c.c cVar2 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 2, 1002);
            cVar2.bf(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.c.c cVar3 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 3, 1003);
            cVar3.bg(this.ehl);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            bbw();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.ehk)) {
                this.ehk = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
            }
            if (TextUtils.isEmpty(this.aaT)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.ehl <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else {
                this.egV.c(this.egW, this.aaT, this.ehk, this.ehl, this.mGiftNum);
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
                    this.aaT = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.ehg.setText(optString);
                    this.ehg.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.ehh.setText(String.valueOf(optInt));
                    this.ehh.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.ehl = optInt2;
                    this.ehi.setText(String.valueOf(optInt2) + "小时");
                    this.ehi.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                bbv();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void bbv() {
        if (this.ehf != null) {
            if (!TextUtils.isEmpty(this.aaT) && this.mGiftNum > 0 && this.ehl > 0) {
                this.ehf.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                this.ehf.setBackgroundResource(a.f.ala_live_create_wish_bt_bg);
                return;
            }
            this.ehf.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
            this.ehf.setBackgroundResource(a.f.ala_add_wish_edit_next_bt_bg);
        }
    }

    @Override // com.baidu.tieba.ala.e.g.c
    public void b(j jVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.e.g.c
    public void aa(int i, String str) {
        String string = getPageContext().getResources().getString(a.i.add_wish_add_tip_fail);
        if (TextUtils.isEmpty(str)) {
            str = string;
        }
        getPageContext().showToast(str);
    }

    @Override // com.baidu.tieba.ala.e.g.a
    public void a(j jVar) {
    }

    @Override // com.baidu.tieba.ala.e.g.a
    public void Z(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void ab(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.egK = alaLiveInputEditView;
        this.egK.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.egK.setSendEnabled(false);
                } else {
                    AlaLiveAddWishActivity.this.egK.setSendEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.egK.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
            @Override // com.baidu.live.view.input.b.a
            public void dx(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.ehk = str;
                    AlaLiveAddWishActivity.this.ehj.setText(str);
                    AlaLiveAddWishActivity.this.ehj.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.bbx();
                }
            }
        });
    }

    public void bbw() {
        this.egK.xS();
        this.egK.getEditView().setFocusable(true);
        this.egK.getEditView().setFocusableInTouchMode(true);
        this.egK.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.egK.getEditView().requestFocus();
                AlaLiveAddWishActivity.this.egK.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.egK.getEditView());
            }
        }, 100L);
    }

    public void bbx() {
        this.egK.setVisibility(8);
        this.egK.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.egK.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.aju = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.ajv != rect.bottom;
                AlaLiveAddWishActivity.this.ajv = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.ajw || z)) {
                    AlaLiveAddWishActivity.this.ajw = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.ajw) {
                    AlaLiveAddWishActivity.this.ajw = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.aju);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.egK.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.egK.setLayoutParams(layoutParams);
            this.egK.setVisibility(0);
            this.egJ.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.egK.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.egK.setLayoutParams(layoutParams2);
        this.egK.setVisibility(8);
        this.egJ.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.egK.getVisibility() == 0) {
            bbx();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
