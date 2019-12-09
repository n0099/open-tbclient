package com.baidu.tieba.ala.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.ah;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.SkinManager;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.pay.PayConfig;
import com.baidu.live.tbadk.widget.lottie.TBLottieAnimationView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class a {
    private BaseActivity atk;
    private TBLottieAnimationView dPN;
    private PayConfig dPO;
    private String dPP;
    private boolean isPaying;
    private b mCallback;
    private View mChannelLayout;
    private LinearLayout mChannelList;
    private String mChosenChannel = "NaN";
    private ImageView mCloseBtn;
    private List<com.baidu.tieba.ala.live.a.a> mCommonList;
    private FrameLayout mContentLayout;
    private Context mContext;
    private ah mCurPayOrderInfo;
    private JSONObject mDataJsonObject;
    private List<com.baidu.tieba.ala.live.a.a> mFoldList;
    private TextView mGoodCount;
    private TextView mGoodDesc;
    private View mGoodDivider;
    private TextView mGoodName;
    private TextView mMoneyTv;
    private TextView mPayBtn;
    private LinearLayout mPayBtnLayout;
    private String mPayBtnStr;
    private RelativeLayout mRootView;
    private List<View> mShowedItemViewList;
    private TextView mTitle;
    private View mTopSpaceView;
    private TextView mUnfoldTv;
    private static final int ds24 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private static final int ds22 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds22);
    private static final int ds20 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds20);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public interface b {
        void doFinish();

        void doPay(String str);
    }

    public a(BaseActivity baseActivity, b bVar, PayConfig payConfig) {
        this.atk = baseActivity;
        this.mContext = baseActivity.getPageContext().getPageActivity();
        this.mCallback = bVar;
        this.dPO = payConfig;
        initView();
    }

    private void initView() {
        if (this.atk instanceof AlaSdkWalletOpaqueActivity) {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_wallet_pay_opaque_layout, (ViewGroup) null);
        } else {
            this.mRootView = (RelativeLayout) LayoutInflater.from(this.mContext).inflate(a.h.sdk_wallet_pay_layout, (ViewGroup) null);
        }
        this.atk.setContentView(this.mRootView);
        this.mTitle = (TextView) this.mRootView.findViewById(a.g.pay_channel_title);
        this.mChannelLayout = this.mRootView.findViewById(a.g.pay_channel_layout);
        this.mTopSpaceView = this.mRootView.findViewById(a.g.pay_channel_top_space_view);
        this.mTopSpaceView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mCallback != null) {
                    a.this.mCallback.doFinish();
                }
            }
        });
        this.mContentLayout = (FrameLayout) this.mRootView.findViewById(a.g.pay_channel_content_layout);
        this.mCloseBtn = (ImageView) this.mRootView.findViewById(a.g.pay_channel_close_btn);
        this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.mCallback != null) {
                    a.this.mCallback.doFinish();
                }
            }
        });
        this.mMoneyTv = (TextView) this.mRootView.findViewById(a.g.pay_channel_total_money);
        this.mGoodDesc = (TextView) this.mRootView.findViewById(a.g.pay_channel_good_desc);
        this.mGoodCount = (TextView) this.mRootView.findViewById(a.g.pay_channel_good_count);
        this.mGoodDivider = this.mRootView.findViewById(a.g.pay_channel_good_divider);
        this.mGoodDesc.setVisibility(8);
        this.mGoodCount.setVisibility(8);
        this.mGoodDivider.setVisibility(8);
        this.mGoodName = (TextView) this.mRootView.findViewById(a.g.pay_channel_good_name);
        this.mChannelList = (LinearLayout) this.mRootView.findViewById(a.g.pay_channel_list_layout);
        this.mUnfoldTv = (TextView) this.mRootView.findViewById(a.g.pay_channel_unfold_tv);
        Drawable drawable = this.mContext.getResources().getDrawable(a.f.sdk_icon_common_arrow20_down);
        drawable.setBounds(0, 0, ds24, ds24);
        this.mUnfoldTv.setCompoundDrawables(null, null, drawable, null);
        this.mUnfoldTv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.a.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!a.this.isPaying) {
                    a.this.appendChannelItemView();
                    a.this.mUnfoldTv.setVisibility(8);
                }
            }
        });
        this.mPayBtnLayout = (LinearLayout) this.mRootView.findViewById(a.g.pay_channel_pay_btn_layout);
        this.mPayBtn = (TextView) this.mRootView.findViewById(a.g.pay_channel_pay_btn_tv);
        this.mPayBtnLayout.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.a.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (StringUtils.isNull(a.this.mChosenChannel) || "NaN".equals(a.this.mChosenChannel)) {
                    a.this.atk.showToast(a.i.sdk_pay_choose_one_channel_tip);
                    return;
                }
                a.this.dPN.setVisibility(0);
                a.this.dPN.playAnimation();
                a.this.updatePayBtnText(a.this.mContext.getString(a.i.sdk_pay_loading));
                if (a.this.mCallback != null) {
                    a.this.mCallback.doPay(a.this.mChosenChannel);
                    a.this.isPaying = true;
                }
            }
        });
        this.dPN = (TBLottieAnimationView) this.mRootView.findViewById(a.g.pay_channel_pay_anim_view);
        this.dPN.setAnimation("sdk_wallet_pay_anim.json");
        this.dPN.loop(true);
        onChangeSkinType();
    }

    private void refreshView() {
        String format = String.format("%.2f", Double.valueOf(this.mCurPayOrderInfo.Ub / 100.0d));
        this.mMoneyTv.setText("￥" + format);
        if (this.dPO.getPayType() == 2) {
            this.mGoodDesc.setVisibility(0);
            this.mGoodCount.setVisibility(0);
            this.mGoodDivider.setVisibility(0);
            Drawable drawable = this.mContext.getResources().getDrawable(a.f.sdk_icon_huobi_tdou);
            drawable.setBounds(0, 0, ds20, ds22);
            this.mGoodCount.setCompoundDrawables(drawable, null, null, null);
            this.mGoodCount.setText(this.dPO.getTBeanNum() + "");
        }
        this.mGoodName.setText(this.mCurPayOrderInfo.title);
        handleChannelListView();
        this.mPayBtnStr = String.format(this.mContext.getResources().getString(a.i.sdk_pay_total_pay_confirm_tip), format);
        updatePayBtnText(this.mPayBtnStr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updatePayBtnText(String str) {
        this.mPayBtn.setText(str);
    }

    private void handleChannelListView() {
        if (!ListUtils.isEmpty(this.mCommonList) || !ListUtils.isEmpty(this.mFoldList)) {
            this.mUnfoldTv.setVisibility(!ListUtils.isEmpty(this.mCommonList) && !ListUtils.isEmpty(this.mFoldList) ? 0 : 8);
            ArrayList<com.baidu.tieba.ala.live.a.a> arrayList = null;
            if (!ListUtils.isEmpty(this.mCommonList)) {
                arrayList = new ArrayList(this.mCommonList);
            } else if (!ListUtils.isEmpty(this.mFoldList)) {
                arrayList = new ArrayList(this.mFoldList);
            }
            if (!ListUtils.isEmpty(arrayList)) {
                this.mShowedItemViewList = new ArrayList();
                for (com.baidu.tieba.ala.live.a.a aVar : arrayList) {
                    if (aVar != null) {
                        a(aVar);
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void appendChannelItemView() {
        if (!ListUtils.isEmpty(this.mFoldList)) {
            for (com.baidu.tieba.ala.live.a.a aVar : this.mFoldList) {
                if (aVar != null) {
                    a(aVar);
                }
            }
        }
    }

    private void a(com.baidu.tieba.ala.live.a.a aVar) {
        View inflate = LayoutInflater.from(this.mContext).inflate(a.h.sdk_wallet_channel_item_view, (ViewGroup) null);
        C0347a c0347a = new C0347a(inflate);
        c0347a.b(aVar);
        inflate.setTag(c0347a);
        this.mChannelList.addView(inflate, new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds120)));
        this.mShowedItemViewList.add(inflate);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshChannelListView() {
        C0347a c0347a;
        if (!ListUtils.isEmpty(this.mShowedItemViewList)) {
            for (View view : this.mShowedItemViewList) {
                if (view != null && (c0347a = (C0347a) view.getTag()) != null && !StringUtils.isNull(c0347a.curChannel)) {
                    c0347a.updateSelectorIcon(c0347a.curChannel.equals(this.mChosenChannel));
                }
            }
        }
    }

    public void a(ah ahVar) {
        this.mCurPayOrderInfo = ahVar;
        this.dPP = ahVar.pay_channel;
        parserJson();
        refreshView();
    }

    private void parserJson() {
        JSONArray optJSONArray = this.mDataJsonObject.optJSONArray("list");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            this.mCommonList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    com.baidu.tieba.ala.live.a.a aVar = new com.baidu.tieba.ala.live.a.a();
                    aVar.parserJson(optJSONObject);
                    this.mCommonList.add(aVar);
                }
            }
        }
        JSONArray optJSONArray2 = this.mDataJsonObject.optJSONArray("fold");
        if (optJSONArray2 != null && optJSONArray2.length() > 0) {
            int length2 = optJSONArray2.length();
            this.mFoldList = new ArrayList(length2);
            for (int i2 = 0; i2 < length2; i2++) {
                JSONObject optJSONObject2 = optJSONArray2.optJSONObject(i2);
                if (optJSONObject2 != null) {
                    com.baidu.tieba.ala.live.a.a aVar2 = new com.baidu.tieba.ala.live.a.a();
                    aVar2.parserJson(optJSONObject2);
                    this.mFoldList.add(aVar2);
                }
            }
        }
    }

    public boolean isValidData(String str) {
        if (StringUtils.isNull(str)) {
            return false;
        }
        try {
            this.mDataJsonObject = new JSONObject(str);
            return true;
        } catch (JSONException e) {
            return false;
        }
    }

    public void hideLoadingView() {
        this.atk.hideLoadingView(this.mContentLayout);
    }

    public void payResult(boolean z) {
        this.dPN.cancelAnimation();
        this.dPN.setVisibility(8);
        if (z) {
            updatePayBtnText(this.mContext.getString(a.i.sdk_pay_succ));
        } else {
            updatePayBtnText(this.mPayBtnStr);
        }
        this.isPaying = false;
    }

    public void onChangeSkinType() {
        SkinManager.setBackgroundColor(this.mRootView, a.d.sdk_black_alpha0);
        SkinManager.setImageResource(this.mCloseBtn, a.f.sdk_icon_wallet_close);
        if (this.atk instanceof AlaSdkWalletOpaqueActivity) {
            SkinManager.setBackgroundResource(this.mChannelLayout, a.d.sdk_cp_bg_line_d);
        } else {
            SkinManager.setBackgroundResource(this.mChannelLayout, a.f.sdk_wallet_pay_content_bg);
        }
        SkinManager.setViewTextColor(this.mTitle, a.d.sdk_cp_cont_b);
        SkinManager.setViewTextColor(this.mMoneyTv, a.d.sdk_cp_cont_b);
        SkinManager.setViewTextColor(this.mGoodDesc, a.d.sdk_cp_cont_j);
        SkinManager.setViewTextColor(this.mGoodCount, a.d.sdk_cp_cont_j);
        SkinManager.setViewTextColor(this.mGoodName, a.d.sdk_cp_cont_j);
        SkinManager.setBackgroundColor(this.mGoodDivider, a.d.sdk_cp_cont_e);
        SkinManager.setViewTextColor(this.mUnfoldTv, a.d.sdk_cp_cont_b);
        SkinManager.setViewTextColor(this.mPayBtn, a.d.sdk_cp_bg_line_d);
        SkinManager.setBackgroundResource(this.mPayBtnLayout, a.f.sdk_btn_corner_wallet_pay_selector);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: com.baidu.tieba.ala.live.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class C0347a {
        public String curChannel;
        public HeadImageView dPR;
        private boolean mChosen;
        public TextView promptTv;
        public View rootView;
        public ImageView selectorImg;
        public TextView tagTv;
        public TextView titleTv;

        public C0347a(View view) {
            this.rootView = view;
            this.dPR = (HeadImageView) view.findViewById(a.g.channel_icon);
            this.dPR.setIsRound(true);
            this.dPR.setScaleType(ImageView.ScaleType.CENTER_CROP);
            this.dPR.setDefaultResource(a.d.sdk_cp_cont_e);
            this.dPR.setAutoChangeStyle(false);
            this.titleTv = (TextView) view.findViewById(a.g.channel_title);
            this.promptTv = (TextView) view.findViewById(a.g.channel_prompt);
            this.tagTv = (TextView) view.findViewById(a.g.channel_tag);
            this.selectorImg = (ImageView) view.findViewById(a.g.channel_selector_img);
            onChangeSkinType();
        }

        public void onChangeSkinType() {
            SkinManager.setBackgroundResource(this.rootView, a.f.sdk_list_item_selector);
            SkinManager.setViewTextColor(this.titleTv, a.d.sdk_cp_cont_b);
            SkinManager.setViewTextColor(this.promptTv, a.d.sdk_cp_cont_d);
            SkinManager.setViewTextColor(this.tagTv, a.d.sdk_cp_cont_d);
        }

        public void b(com.baidu.tieba.ala.live.a.a aVar) {
            this.curChannel = aVar.channel;
            this.dPR.startLoad(aVar.iconUrl, 10, false);
            this.titleTv.setText(aVar.title);
            if (!StringUtils.isNull(aVar.prompt)) {
                this.promptTv.setVisibility(0);
                this.promptTv.setText(aVar.prompt);
            } else {
                this.promptTv.setVisibility(8);
            }
            this.tagTv.setText(aVar.tag);
            this.mChosen = aVar.isDefault;
            if (this.mChosen) {
                a.this.mChosenChannel = this.curChannel;
            }
            updateSelectorIcon(this.mChosen);
            this.rootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.live.a.a.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (!C0347a.this.mChosen && !a.this.isPaying) {
                        C0347a.this.mChosen = !C0347a.this.mChosen;
                        C0347a.this.updateSelectorIcon(C0347a.this.mChosen);
                        a.this.mChosenChannel = C0347a.this.curChannel;
                        a.this.refreshChannelListView();
                    }
                }
            });
        }

        public void updateSelectorIcon(boolean z) {
            this.mChosen = z;
            SkinManager.setImageResource(this.selectorImg, z ? a.f.sdk_icon_selection : a.f.sdk_icon_dissselection);
        }
    }
}
