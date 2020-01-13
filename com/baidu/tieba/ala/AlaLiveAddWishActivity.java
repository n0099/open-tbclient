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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.ActivityPendingTransitionFactory;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.log.LogConfig;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.view.input.AlaLiveInputEditView;
import com.baidu.live.view.input.b;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.e.g;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class AlaLiveAddWishActivity extends BaseFragmentActivity implements View.OnClickListener, g.a, g.b, g.c {
    private ViewTreeObserver.OnGlobalLayoutListener ahl;
    private int ahm;
    private boolean ahn;
    private View ecB;
    private FrameLayout ecG;
    private AlaLiveInputEditView ecH;
    private g ecS;
    private String ecT;
    private TbImageView ecX;
    private RelativeLayout ecY;
    private RelativeLayout ecZ;
    private RelativeLayout eda;
    private RelativeLayout edb;
    private Button edc;
    private TextView edd;
    private TextView ede;
    private TextView edf;
    private TextView edg;
    private String edh;
    private int edi;
    private int edj;
    private RelativeLayout edk;
    private Context mContext;
    private int mGiftNum;
    private View mRootView;
    private TextView mTitleTextView;
    private Handler mHandler = new Handler();
    private boolean aew = false;
    private boolean ahp = false;
    private boolean ahq = false;
    private String Zb = "";
    private CustomMessageListener aeM = new CustomMessageListener(2913054) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.5
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaLiveAddWishActivity.this.closeActivity();
        }
    };
    CustomMessageListener aeN = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.6
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
        registerListener(this.aeN);
        registerListener(this.aeM);
        addGlobalLayoutListener();
        initView();
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        this.ahp = false;
        this.mRootView.setVisibility(4);
        this.ecS = new g(getPageContext(), this, this, this);
        this.edj = getIntent().getIntExtra("item_count", 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // android.support.v4.app.FragmentActivity, android.app.Activity
    public void onStart() {
        super.onStart();
        if (!this.aew) {
            this.mRootView.setVisibility(0);
            sc();
            this.aew = true;
        }
    }

    private void sc() {
        Animation loadAnimation;
        this.ahp = true;
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_right);
        } else {
            loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_in_from_bottom);
        }
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                AlaLiveAddWishActivity.this.ahp = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
        this.mRootView.startAnimation(loadAnimation);
    }

    private void sd() {
        Animation loadAnimation;
        if (!this.ahq && !this.ahp) {
            if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_right);
            } else {
                loadAnimation = AnimationUtils.loadAnimation(getActivity(), a.C0086a.sdk_out_to_bottom);
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
            this.ahq = true;
            this.mRootView.startAnimation(loadAnimation);
        }
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, android.app.Activity
    public void finish() {
        sd();
    }

    private void initView() {
        this.mRootView = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_live_add_wish_layout, (ViewGroup) null);
        setContentView(this.mRootView);
        this.edk = (RelativeLayout) findViewById(a.g.ala_add_wish_list_content);
        int[] screenDimensions = BdUtilHelper.getScreenDimensions(getPageContext().getPageActivity());
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.edk.getLayoutParams();
        layoutParams.height = (int) (screenDimensions[1] * 0.68d);
        this.edk.setLayoutParams(layoutParams);
        this.ecB = findViewById(a.g.add_wish_root_bg);
        this.ecB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaLiveAddWishActivity.this.finish();
            }
        });
        this.mContext = this;
        this.ecX = (TbImageView) this.mRootView.findViewById(a.g.add_wish_tile_icon_return);
        this.ecY = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift);
        this.ecZ = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num);
        this.eda = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline);
        this.edb = (RelativeLayout) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way);
        this.edc = (Button) this.mRootView.findViewById(a.g.add_wish_next_bt);
        this.ecX.setOnClickListener(this);
        this.ecY.setOnClickListener(this);
        this.ecZ.setOnClickListener(this);
        this.eda.setOnClickListener(this);
        this.edb.setOnClickListener(this);
        this.edc.setOnClickListener(this);
        this.edd = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_action);
        this.ede = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_gift_num_action);
        this.edf = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_deadline_action);
        this.edg = (TextView) this.mRootView.findViewById(a.g.add_wish_center_edit_thank_way_edit);
        this.mTitleTextView = (TextView) this.mRootView.findViewById(a.g.add_wish_tile_txt);
        this.mTitleTextView.setText(getPageContext().getResources().getString(a.i.add_wish_title));
        this.ecG = (FrameLayout) this.mRootView.findViewById(a.g.choose_gift_input_layout);
        this.ecH = (AlaLiveInputEditView) this.mRootView.findViewById(a.g.choose_gift_input_edit);
        this.ecH.getEditView().setInputType(1);
        this.ecH.getEditView().setFilters(new InputFilter[]{new InputFilter.LengthFilter(8)});
        this.ecH.setHintText(getPageContext().getResources().getString(a.i.add_wish_thank_way_hinit));
        this.ecH.getTextView().setText(getPageContext().getResources().getString(a.i.add_wish_thank_way_send));
        e(this.ecH);
        aZg();
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
        if (this.ecS != null) {
            this.ecS.onDestroy();
        }
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        getWindow().getDecorView().getViewTreeObserver().removeGlobalOnLayoutListener(this.ahl);
        this.ahl = null;
    }

    @Override // com.baidu.live.adp.base.BdBaseFragmentActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id == a.g.add_wish_tile_icon_return) {
            finish();
        } else if (id == a.g.add_wish_center_edit_gift) {
            com.baidu.live.c.c cVar = new com.baidu.live.c.c(getPageContext().getPageActivity(), 1, 1001);
            cVar.d(this.Zb, AlaLiveWishListActivity.edr);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar));
        } else if (id == a.g.add_wish_center_edit_gift_num) {
            com.baidu.live.c.c cVar2 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 2, 1002);
            cVar2.aY(this.mGiftNum);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar2));
        } else if (id == a.g.add_wish_center_edit_deadline) {
            com.baidu.live.c.c cVar3 = new com.baidu.live.c.c(getPageContext().getPageActivity(), 3, 1003);
            cVar3.aZ(this.edi);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, cVar3));
        } else if (id == a.g.add_wish_center_edit_thank_way) {
            aZh();
        } else if (id == a.g.add_wish_next_bt) {
            if (TextUtils.isEmpty(this.edh)) {
                this.edh = getPageContext().getResources().getString(a.i.add_wish_thank_way_txt);
            }
            if (TextUtils.isEmpty(this.Zb)) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_tips_txt));
            } else if (this.edi <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_deadline_tip));
            } else if (this.mGiftNum <= 0) {
                getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_gift_num_tip));
            } else {
                this.ecS.c(this.ecT, this.Zb, this.edh, this.edi, this.mGiftNum);
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
                    this.Zb = jSONObject.optString(LogConfig.LOG_GIFT_ID);
                    this.edd.setText(optString);
                    this.edd.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1002) {
                    jSONObject.optBoolean("num_custom");
                    int optInt = jSONObject.optInt("num_number");
                    jSONObject.optString("num_name");
                    this.mGiftNum = optInt;
                    this.ede.setText(String.valueOf(optInt));
                    this.ede.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                } else if (i == 1003) {
                    jSONObject.optBoolean("date_custom");
                    int optInt2 = jSONObject.optInt("date_value");
                    this.edi = optInt2;
                    this.edf.setText(String.valueOf(optInt2) + "小时");
                    this.edf.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                }
                aZg();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    private void aZg() {
        if (!TextUtils.isEmpty(this.Zb) && this.mGiftNum > 0 && this.edi > 0 && this.edc != null) {
            this.edc.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
            this.edc.setBackground(getPageContext().getResources().getDrawable(a.f.ala_live_create_wish_bt_bg));
            return;
        }
        this.edc.setTextColor(getPageContext().getResources().getColor(a.d.sdk_cp_cont_i_alpha80));
        this.edc.setBackground(getPageContext().getResources().getDrawable(a.f.ala_add_wish_edit_next_bt_bg));
    }

    @Override // com.baidu.tieba.ala.e.g.c
    public void b(j jVar) {
        setResult(-1);
        finish();
    }

    @Override // com.baidu.tieba.ala.e.g.c
    public void Z(int i, String str) {
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
    public void Y(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_delete_tip_fail));
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void c(j jVar) {
    }

    @Override // com.baidu.tieba.ala.e.g.b
    public void aa(int i, String str) {
        getPageContext().showToast(getPageContext().getResources().getString(a.i.add_wish_create_tip_fail));
    }

    public void e(AlaLiveInputEditView alaLiveInputEditView) {
        this.ecH = alaLiveInputEditView;
        this.ecH.setTextWatcher(new TextWatcher() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.7
            @Override // android.text.TextWatcher
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            @Override // android.text.TextWatcher
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                if (charSequence == null || TextUtils.isEmpty(charSequence.toString().trim())) {
                    AlaLiveAddWishActivity.this.ecH.setSendEnabled(false);
                } else {
                    AlaLiveAddWishActivity.this.ecH.setSendEnabled(true);
                }
            }

            @Override // android.text.TextWatcher
            public void afterTextChanged(Editable editable) {
            }
        });
        this.ecH.setEditViewConfirmCallBack(new b.a() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.8
            @Override // com.baidu.live.view.input.b.a
            public void dm(String str) {
                if (str != null && !TextUtils.isEmpty(str.trim())) {
                    AlaLiveAddWishActivity.this.edh = str;
                    AlaLiveAddWishActivity.this.edg.setText(str);
                    AlaLiveAddWishActivity.this.edg.setTextColor(AlaLiveAddWishActivity.this.getPageContext().getResources().getColor(a.d.sdk_cp_cont_g));
                    AlaLiveAddWishActivity.this.aZi();
                }
            }
        });
    }

    public void aZh() {
        this.ecH.vT();
        this.ecH.getEditView().setFocusable(true);
        this.ecH.getEditView().setFocusableInTouchMode(true);
        this.ecH.getEditView().postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.9
            @Override // java.lang.Runnable
            public void run() {
                AlaLiveAddWishActivity.this.ecH.getEditView().requestFocus();
                AlaLiveAddWishActivity.this.ecH.getEditView().requestFocusFromTouch();
                BdUtilHelper.showSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.ecH.getEditView());
            }
        }, 100L);
    }

    public void aZi() {
        this.ecH.setVisibility(8);
        this.ecH.getEditView().post(new Runnable() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.10
            @Override // java.lang.Runnable
            public void run() {
                BdUtilHelper.hideSoftKeyPad(AlaLiveAddWishActivity.this.mContext, AlaLiveAddWishActivity.this.ecH.getEditView());
            }
        });
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void addGlobalLayoutListener() {
        this.ahl = new ViewTreeObserver.OnGlobalLayoutListener() { // from class: com.baidu.tieba.ala.AlaLiveAddWishActivity.2
            @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
            public void onGlobalLayout() {
                Rect rect = new Rect();
                AlaLiveAddWishActivity.this.getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
                int statusBarHeight = BdUtilHelper.getStatusBarHeight(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                int[] screenDimensions = BdUtilHelper.getScreenDimensions(AlaLiveAddWishActivity.this.getPageContext().getPageActivity());
                boolean z = AlaLiveAddWishActivity.this.ahm != rect.bottom;
                AlaLiveAddWishActivity.this.ahm = rect.bottom;
                if (screenDimensions[1] - rect.bottom > screenDimensions[1] / 4 && (!AlaLiveAddWishActivity.this.ahn || z)) {
                    AlaLiveAddWishActivity.this.ahn = true;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(true);
                } else if (screenDimensions[1] - rect.height() <= statusBarHeight && AlaLiveAddWishActivity.this.ahn) {
                    AlaLiveAddWishActivity.this.ahn = false;
                    AlaLiveAddWishActivity.this.onKeyboardVisibilityChanged(false);
                }
            }
        };
        getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this.ahl);
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
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ecH.getLayoutParams();
            layoutParams.topMargin = statusBarHeight;
            this.ecH.setLayoutParams(layoutParams);
            this.ecH.setVisibility(0);
            this.ecG.setVisibility(0);
            return;
        }
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ecH.getLayoutParams();
        layoutParams2.topMargin = 0;
        this.ecH.setLayoutParams(layoutParams2);
        this.ecH.setVisibility(8);
        this.ecG.setVisibility(8);
    }

    @Override // android.app.Activity
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.ecH.getVisibility() == 0) {
            aZi();
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
