package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

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
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.a.e;
import com.baidu.tieba.ala.alasquare.subtablist.view.g;
/* loaded from: classes9.dex */
public class b {
    public TextView bFN;
    private cb gAx;
    public TbImageView gEK;
    public TextView gEL;
    public RelativeLayout gEM;
    private String gEU;
    private AlphaAnimation gEX;
    public ImageView gGO;
    private g gIy;
    public TextView gJP;
    public TextView gJQ;
    public LinearLayout gJR;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gEW = false;
    private boolean gEY = true;
    private boolean gEZ = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gJS = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (j.isNetWorkAvailable()) {
                if (b.this.gAx != null && b.this.gAx.bol() != null && b.this.gIy != null) {
                    b.this.gIy.a(b.this.tabId, b.this.gEU, b.this.gAx);
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
        this.gEK = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gJP = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gEL = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gEM = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bFN = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gJQ = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gJR = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gEK.setBorderSurroundContent(true);
        this.gEK.setDrawBorder(true);
        this.gGO = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gEX = new AlphaAnimation(0.0f, 1.0f);
        this.gEX.setDuration(200L);
        this.gEX.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.gEZ = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.gEZ = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void c(g gVar) {
        this.gIy = gVar;
    }

    public void b(e eVar) {
        a(eVar, -1);
    }

    public void a(e eVar, int i) {
        if (eVar == null || eVar.gAx == null || eVar.gAx.bol() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gJS != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gJS = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEM.getLayoutParams();
            layoutParams.width = (this.gJS - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gEM.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gAx = eVar.gAx;
        this.tabId = eVar.tabId;
        this.gEU = !TextUtils.isEmpty(eVar.labelName) ? eVar.labelName : eVar.entryName;
        Object tag = this.gEK.getTag();
        if (this.gEY) {
            this.gEW = true;
            this.gEY = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gAx.bol().cover) && !((String) tag).equals(this.gAx.bol().cover)) {
            this.gEW = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gAx.bol().cover) && !this.mCoverUrl.equals(this.gAx.bol().cover)) {
            this.gEW = true;
        } else {
            this.gEW = false;
        }
        this.mCoverUrl = this.gAx.bol().cover;
        this.gEK.setTag(this.mCoverUrl);
        this.gEK.startLoad(this.gAx.bol().cover, 10, false);
        this.gEK.setEvent(new TbImageView.b() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.view.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onComplete(String str, boolean z) {
                if (z && b.this.gEW && !b.this.gEZ) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gEK.startAnimation(b.this.gEX);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.b
            public void onCancel() {
            }
        });
        this.gEL.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gAx.bol().audience_count)));
        if (this.gAx.bnS() != null) {
            String name_show = this.gAx.bnS().getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ag.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bFN.setText(name_show);
        }
        if (!StringUtils.isNull(this.gAx.mRecomExtra)) {
            this.gJQ.setVisibility(0);
            this.gJR.setVisibility(8);
            this.gJQ.setText(this.gAx.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gJQ.setBackgroundDrawable(gradientDrawable);
        } else if (this.gAx.bol().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gAx.bol().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gAx.bol().label.labelColor));
            }
            this.gJQ.setBackgroundDrawable(gradientDrawable2);
            this.gJQ.setText(this.gAx.bol().label.labelName);
            this.gJQ.setVisibility(0);
            this.gJR.setVisibility(8);
        } else if (this.gAx.bol().mChallengeInfoData != null && this.gAx.bol().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gJR.setBackground(gradientDrawable3);
            this.gJR.setVisibility(0);
            this.gJQ.setVisibility(8);
        } else {
            this.gJQ.setVisibility(8);
            this.gJR.setVisibility(8);
        }
        if (this.gAx.bol().haveRedpkg) {
            this.gGO.setVisibility(0);
        } else {
            this.gGO.setVisibility(8);
        }
        if (this.gAx != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dR("tid", this.gAx.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dR("tid", this.gAx.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gEM, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gEL, R.color.CAM_X0101);
            ap.setViewTextColor(this.bFN, R.color.CAM_X0101);
            ap.setViewTextColor(this.gJQ, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gEL.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
