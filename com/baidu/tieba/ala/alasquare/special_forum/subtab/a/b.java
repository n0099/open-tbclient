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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b {
    private bw fCB;
    public TextView fGA;
    private String fGI;
    private AlphaAnimation fGL;
    public TbImageView fGx;
    public TextView fGy;
    public RelativeLayout fGz;
    public ImageView fIy;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fKf;
    public TextView fLw;
    public TextView fLx;
    public LinearLayout fLy;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean fGK = false;
    private boolean fGM = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fLz = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.fCB != null && b.this.fCB.beY() != null && b.this.fKf != null) {
                    b.this.fKf.a(b.this.tabId, b.this.fGI, b.this.fCB);
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
        this.fGx = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fLw = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fGy = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.fGz = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fGA = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fLx = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fLy = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.fGx.setBorderSurroundContent(true);
        this.fGx.setDrawBorder(true);
        this.fIy = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.fGL = new AlphaAnimation(0.0f, 1.0f);
        this.fGL.setDuration(200L);
        this.fGL.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.fKf = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fCB == null || cVar.fCB.beY() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fLz != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fLz = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.fGz.getLayoutParams();
            layoutParams.width = (this.fLz - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.fGz.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.fCB = cVar.fCB;
        this.tabId = cVar.tabId;
        this.fGI = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.fGx.getTag();
        if (this.fGM) {
            this.fGK = true;
            this.fGM = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fCB.beY().cover) && !((String) tag).equals(this.fCB.beY().cover)) {
            this.fGK = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fCB.beY().cover) && !this.mCoverUrl.equals(this.fCB.beY().cover)) {
            this.fGK = true;
        } else {
            this.fGK = false;
        }
        this.mCoverUrl = this.fCB.beY().cover;
        this.fGx.setTag(this.mCoverUrl);
        this.fGx.startLoad(this.fCB.beY().cover, 10, false);
        this.fGx.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.fGK && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.fGx.startAnimation(b.this.fGL);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fGy.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.fCB.beY().audience_count)));
        if (this.fCB.beE() != null) {
            String name_show = this.fCB.beE().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fGA.setText(name_show);
        }
        if (!StringUtils.isNull(this.fCB.mRecomExtra)) {
            this.fLx.setVisibility(0);
            this.fLy.setVisibility(8);
            this.fLx.setText(this.fCB.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fLx.setBackgroundDrawable(gradientDrawable);
        } else if (this.fCB.beY().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.fCB.beY().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.fCB.beY().label.labelColor));
            }
            this.fLx.setBackgroundDrawable(gradientDrawable2);
            this.fLx.setText(this.fCB.beY().label.labelName);
            this.fLx.setVisibility(0);
            this.fLy.setVisibility(8);
        } else if (this.fCB.beY().mChallengeInfoData != null && this.fCB.beY().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fLy.setBackground(gradientDrawable3);
            this.fLy.setVisibility(0);
            this.fLx.setVisibility(8);
        } else {
            this.fLx.setVisibility(8);
            this.fLy.setVisibility(8);
        }
        if (this.fCB.beY().haveRedpkg) {
            this.fIy.setVisibility(0);
        } else {
            this.fIy.setVisibility(8);
        }
        if (this.fCB != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dD("tid", this.fCB.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dD("tid", this.fCB.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.fGz, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.fGy, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fGA, (int) R.color.cp_cont_a);
            ap.setViewTextColor(this.fLx, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fGy.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
