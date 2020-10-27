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
    private bw gbZ;
    public TbImageView gge;
    public TextView ggf;
    public RelativeLayout ggg;
    public TextView ggh;
    private String ggp;
    private AlphaAnimation ggs;
    public ImageView gij;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i gjP;
    public TextView glg;
    public TextView glh;
    public LinearLayout gli;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean ggr = false;
    private boolean ggt = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int glj = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.gbZ != null && b.this.gbZ.bku() != null && b.this.gjP != null) {
                    b.this.gjP.a(b.this.tabId, b.this.ggp, b.this.gbZ);
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
        this.gge = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.glg = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.ggf = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ggg = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ggh = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.glh = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gli = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gge.setBorderSurroundContent(true);
        this.gge.setDrawBorder(true);
        this.gij = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.ggs = new AlphaAnimation(0.0f, 1.0f);
        this.ggs.setDuration(200L);
        this.ggs.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.gjP = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gbZ == null || cVar.gbZ.bku() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.glj != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.glj = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ggg.getLayoutParams();
            layoutParams.width = (this.glj - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.ggg.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gbZ = cVar.gbZ;
        this.tabId = cVar.tabId;
        this.ggp = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gge.getTag();
        if (this.ggt) {
            this.ggr = true;
            this.ggt = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gbZ.bku().cover) && !((String) tag).equals(this.gbZ.bku().cover)) {
            this.ggr = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gbZ.bku().cover) && !this.mCoverUrl.equals(this.gbZ.bku().cover)) {
            this.ggr = true;
        } else {
            this.ggr = false;
        }
        this.mCoverUrl = this.gbZ.bku().cover;
        this.gge.setTag(this.mCoverUrl);
        this.gge.startLoad(this.gbZ.bku().cover, 10, false);
        this.gge.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.ggr && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gge.startAnimation(b.this.ggs);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ggf.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, at.numberUniformFormatExtra(this.gbZ.bku().audience_count)));
        if (this.gbZ.bka() != null) {
            String name_show = this.gbZ.bka().getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 10) {
                name_show = af.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.ggh.setText(name_show);
        }
        if (!StringUtils.isNull(this.gbZ.mRecomExtra)) {
            this.glh.setVisibility(0);
            this.gli.setVisibility(8);
            this.glh.setText(this.gbZ.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.glh.setBackgroundDrawable(gradientDrawable);
        } else if (this.gbZ.bku().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gbZ.bku().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gbZ.bku().label.labelColor));
            }
            this.glh.setBackgroundDrawable(gradientDrawable2);
            this.glh.setText(this.gbZ.bku().label.labelName);
            this.glh.setVisibility(0);
            this.gli.setVisibility(8);
        } else if (this.gbZ.bku().mChallengeInfoData != null && this.gbZ.bku().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gli.setBackground(gradientDrawable3);
            this.gli.setVisibility(0);
            this.glh.setVisibility(8);
        } else {
            this.glh.setVisibility(8);
            this.gli.setVisibility(8);
        }
        if (this.gbZ.bku().haveRedpkg) {
            this.gij.setVisibility(0);
        } else {
            this.gij.setVisibility(8);
        }
        if (this.gbZ != null) {
            if (i == 2) {
                TiebaStatic.log(new aq("c12899").dR("tid", this.gbZ.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new aq("c12903").dR("tid", this.gbZ.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.ggg, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.ggf, R.color.cp_cont_a);
            ap.setViewTextColor(this.ggh, R.color.cp_cont_a);
            ap.setViewTextColor(this.glh, R.color.cp_cont_g, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.ggf.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
