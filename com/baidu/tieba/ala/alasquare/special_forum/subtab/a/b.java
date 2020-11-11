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
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    public TextView bxh;
    private bw ghO;
    public TbImageView glT;
    public TextView glU;
    public RelativeLayout glV;
    private String gmd;
    private AlphaAnimation gmg;
    public ImageView gnW;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i gpC;
    public TextView gqT;
    public TextView gqU;
    public LinearLayout gqV;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gmf = false;
    private boolean gmh = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gqW = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ghO != null && b.this.ghO.bmU() != null && b.this.gpC != null) {
                    b.this.gpC.a(b.this.tabId, b.this.gmd, b.this.ghO);
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
        this.glT = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gqT = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.glU = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.glV = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bxh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gqU = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gqV = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.glT.setBorderSurroundContent(true);
        this.glT.setDrawBorder(true);
        this.gnW = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gmg = new AlphaAnimation(0.0f, 1.0f);
        this.gmg.setDuration(200L);
        this.gmg.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.mIsAnimating = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.mIsAnimating = false;
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
        this.gpC = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ghO == null || cVar.ghO.bmU() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gqW != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gqW = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.glV.getLayoutParams();
            layoutParams.width = (this.gqW - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.glV.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ghO = cVar.ghO;
        this.tabId = cVar.tabId;
        this.gmd = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.glT.getTag();
        if (this.gmh) {
            this.gmf = true;
            this.gmh = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ghO.bmU().cover) && !((String) tag).equals(this.ghO.bmU().cover)) {
            this.gmf = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ghO.bmU().cover) && !this.mCoverUrl.equals(this.ghO.bmU().cover)) {
            this.gmf = true;
        } else {
            this.gmf = false;
        }
        this.mCoverUrl = this.ghO.bmU().cover;
        this.glT.setTag(this.mCoverUrl);
        this.glT.startLoad(this.ghO.bmU().cover, 10, false);
        this.glT.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.gmf && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.glT.startAnimation(b.this.gmg);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.glU.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.ghO.bmU().audience_count)));
        if (this.ghO.bmA() != null) {
            String name_show = this.ghO.bmA().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bxh.setText(name_show);
        }
        if (!StringUtils.isNull(this.ghO.mRecomExtra)) {
            this.gqU.setVisibility(0);
            this.gqV.setVisibility(8);
            this.gqU.setText(this.ghO.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gqU.setBackgroundDrawable(gradientDrawable);
        } else if (this.ghO.bmU().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ghO.bmU().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ghO.bmU().label.labelColor));
            }
            this.gqU.setBackgroundDrawable(gradientDrawable2);
            this.gqU.setText(this.ghO.bmU().label.labelName);
            this.gqU.setVisibility(0);
            this.gqV.setVisibility(8);
        } else if (this.ghO.bmU().mChallengeInfoData != null && this.ghO.bmU().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gqV.setBackground(gradientDrawable3);
            this.gqV.setVisibility(0);
            this.gqU.setVisibility(8);
        } else {
            this.gqU.setVisibility(8);
            this.gqV.setVisibility(8);
        }
        if (this.ghO.bmU().haveRedpkg) {
            this.gnW.setVisibility(0);
        } else {
            this.gnW.setVisibility(8);
        }
        if (this.ghO != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dR("tid", this.ghO.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dR("tid", this.ghO.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.glV, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.glU, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.bxh, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.gqU, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.glU.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
