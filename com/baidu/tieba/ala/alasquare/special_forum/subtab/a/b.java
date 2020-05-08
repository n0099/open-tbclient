package com.baidu.tieba.ala.alasquare.special_forum.subtab.a;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private bj eNR;
    public TbImageView eRM;
    public TextView eRN;
    public RelativeLayout eRO;
    public TextView eRP;
    private String eRX;
    private AlphaAnimation eSa;
    public ImageView eTN;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i eVu;
    public TextView eWL;
    public TextView eWM;
    public LinearLayout eWN;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean eRZ = false;
    private boolean eSb = true;
    private boolean eSc = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int eWO = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.eNR != null && b.this.eNR.aKV() != null && b.this.eVu != null) {
                    b.this.eVu.a(b.this.tabId, b.this.eRX, b.this.eNR);
                    return;
                }
                return;
            }
            l.showLongToast(b.this.mTbPageContext.getPageActivity(), b.this.mTbPageContext.getPageActivity().getString(R.string.no_network_guide));
        }
    };

    public b(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.ala_special_live_item_view, (ViewGroup) null, false);
        this.eRM = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eWL = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.eRN = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eRO = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.eRP = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eWM = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.eWN = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eRM.setBorderSurroundContent(true);
        this.eRM.setDrawBorder(true);
        this.eTN = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.eSa = new AlphaAnimation(0.0f, 1.0f);
        this.eSa.setDuration(200L);
        this.eSa.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.eSc = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.eSc = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(com.baidu.tieba.ala.alasquare.subtablist.c.i iVar) {
        this.eVu = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.eNR == null || cVar.eNR.aKV() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.eWO != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.eWO = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.eRO.getLayoutParams();
            layoutParams.width = (this.eWO - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.eRO.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.eNR = cVar.eNR;
        this.tabId = cVar.tabId;
        this.eRX = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eRM.getTag();
        if (this.eSb) {
            this.eRZ = true;
            this.eSb = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eNR.aKV().cover) && !((String) tag).equals(this.eNR.aKV().cover)) {
            this.eRZ = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eNR.aKV().cover) && !this.mCoverUrl.equals(this.eNR.aKV().cover)) {
            this.eRZ = true;
        } else {
            this.eRZ = false;
        }
        this.mCoverUrl = this.eNR.aKV().cover;
        this.eRM.setTag(this.mCoverUrl);
        this.eRM.startLoad(this.eNR.aKV().cover, 10, false);
        this.eRM.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.eRZ && !b.this.eSc) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.eRM.startAnimation(b.this.eSa);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eRN.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.eNR.aKV().audience_count)));
        if (this.eNR.aKC() != null) {
            String name_show = this.eNR.aKC().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.eRP.setText(name_show);
        }
        if (!StringUtils.isNull(this.eNR.mRecomExtra)) {
            this.eWM.setVisibility(0);
            this.eWN.setVisibility(8);
            this.eWM.setText(this.eNR.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.eWM.setBackgroundDrawable(gradientDrawable);
        } else if (this.eNR.aKV().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.eNR.aKV().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.eNR.aKV().label.labelColor));
            }
            this.eWM.setBackgroundDrawable(gradientDrawable2);
            this.eWM.setText(this.eNR.aKV().label.labelName);
            this.eWM.setVisibility(0);
            this.eWN.setVisibility(8);
        } else if (this.eNR.aKV().mChallengeInfoData != null && this.eNR.aKV().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.eWN.setBackground(gradientDrawable3);
            this.eWN.setVisibility(0);
            this.eWM.setVisibility(8);
        } else {
            this.eWM.setVisibility(8);
            this.eWN.setVisibility(8);
        }
        if (this.eNR.aKV().haveRedpkg) {
            this.eTN.setVisibility(0);
        } else {
            this.eTN.setVisibility(8);
        }
        if (this.eNR != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cI("tid", this.eNR.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cI("tid", this.eNR.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.eRO, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.eRN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eRP, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eWM, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.eRN.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
