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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private bu flT;
    public TbImageView fpQ;
    public TextView fpR;
    public RelativeLayout fpS;
    public TextView fpT;
    private String fqb;
    private AlphaAnimation fqe;
    public ImageView frU;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i ftC;
    public TextView fuT;
    public TextView fuU;
    public LinearLayout fuV;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fqd = false;
    private boolean fqf = true;
    private boolean fqg = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fuW = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.flT != null && b.this.flT.aSJ() != null && b.this.ftC != null) {
                    b.this.ftC.a(b.this.tabId, b.this.fqb, b.this.flT);
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
        this.fpQ = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fuT = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fpR = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fpS = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fpT = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fuU = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fuV = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fpQ.setBorderSurroundContent(true);
        this.fpQ.setDrawBorder(true);
        this.frU = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fqe = new AlphaAnimation(0.0f, 1.0f);
        this.fqe.setDuration(200L);
        this.fqe.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.fqg = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.fqg = false;
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
        this.ftC = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.flT == null || cVar.flT.aSJ() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fuW != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fuW = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fpS.getLayoutParams();
            layoutParams.width = (this.fuW - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fpS.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.flT = cVar.flT;
        this.tabId = cVar.tabId;
        this.fqb = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fpQ.getTag();
        if (this.fqf) {
            this.fqd = true;
            this.fqf = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.flT.aSJ().cover) && !((String) tag).equals(this.flT.aSJ().cover)) {
            this.fqd = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.flT.aSJ().cover) && !this.mCoverUrl.equals(this.flT.aSJ().cover)) {
            this.fqd = true;
        } else {
            this.fqd = false;
        }
        this.mCoverUrl = this.flT.aSJ().cover;
        this.fpQ.setTag(this.mCoverUrl);
        this.fpQ.startLoad(this.flT.aSJ().cover, 10, false);
        this.fpQ.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fqd && !b.this.fqg) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fpQ.startAnimation(b.this.fqe);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fpR.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, ar.numberUniformFormatExtra(this.flT.aSJ().audience_count)));
        if (this.flT.aSp() != null) {
            String name_show = this.flT.aSp().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fpT.setText(name_show);
        }
        if (!StringUtils.isNull(this.flT.mRecomExtra)) {
            this.fuU.setVisibility(0);
            this.fuV.setVisibility(8);
            this.fuU.setText(this.flT.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fuU.setBackgroundDrawable(gradientDrawable);
        } else if (this.flT.aSJ().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.flT.aSJ().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.flT.aSJ().label.labelColor));
            }
            this.fuU.setBackgroundDrawable(gradientDrawable2);
            this.fuU.setText(this.flT.aSJ().label.labelName);
            this.fuU.setVisibility(0);
            this.fuV.setVisibility(8);
        } else if (this.flT.aSJ().mChallengeInfoData != null && this.flT.aSJ().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fuV.setBackground(gradientDrawable3);
            this.fuV.setVisibility(0);
            this.fuU.setVisibility(8);
        } else {
            this.fuU.setVisibility(8);
            this.fuV.setVisibility(8);
        }
        if (this.flT.aSJ().haveRedpkg) {
            this.frU.setVisibility(0);
        } else {
            this.frU.setVisibility(8);
        }
        if (this.flT != null) {
            if (i == 2) {
                TiebaStatic.log(new ao("c12899").dk("tid", this.flT.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ao("c12903").dk("tid", this.flT.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            an.setBackgroundResource(this.fpS, R.drawable.addresslist_item_bg);
            an.setViewTextColor(this.fpR, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fpT, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.fuU, R.color.cp_cont_g, 1, 0);
            an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fpR.setCompoundDrawablesWithIntrinsicBounds(an.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
