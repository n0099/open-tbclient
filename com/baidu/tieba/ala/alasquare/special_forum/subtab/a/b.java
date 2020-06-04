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
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class b {
    private bk faJ;
    public TbImageView feF;
    public TextView feG;
    public RelativeLayout feH;
    public TextView feI;
    private String feQ;
    private AlphaAnimation feT;
    public ImageView fgG;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fio;
    public TextView fjG;
    public TextView fjH;
    public LinearLayout fjI;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean feS = false;
    private boolean feU = true;
    private boolean feV = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fjJ = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.faJ != null && b.this.faJ.aQS() != null && b.this.fio != null) {
                    b.this.fio.a(b.this.tabId, b.this.feQ, b.this.faJ);
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
        this.feF = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fjG = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.feG = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.feH = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.feI = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fjH = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fjI = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feF.setBorderSurroundContent(true);
        this.feF.setDrawBorder(true);
        this.fgG = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.feT = new AlphaAnimation(0.0f, 1.0f);
        this.feT.setDuration(200L);
        this.feT.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.feV = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.feV = false;
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
        this.fio = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.faJ == null || cVar.faJ.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fjJ != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fjJ = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.feH.getLayoutParams();
            layoutParams.width = (this.fjJ - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.feH.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.faJ = cVar.faJ;
        this.tabId = cVar.tabId;
        this.feQ = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.feF.getTag();
        if (this.feU) {
            this.feS = true;
            this.feU = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.faJ.aQS().cover) && !((String) tag).equals(this.faJ.aQS().cover)) {
            this.feS = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.faJ.aQS().cover) && !this.mCoverUrl.equals(this.faJ.aQS().cover)) {
            this.feS = true;
        } else {
            this.feS = false;
        }
        this.mCoverUrl = this.faJ.aQS().cover;
        this.feF.setTag(this.mCoverUrl);
        this.feF.startLoad(this.faJ.aQS().cover, 10, false);
        this.feF.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.feS && !b.this.feV) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.feF.startAnimation(b.this.feT);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.feG.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.faJ.aQS().audience_count)));
        if (this.faJ.aQx() != null) {
            String name_show = this.faJ.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.feI.setText(name_show);
        }
        if (!StringUtils.isNull(this.faJ.mRecomExtra)) {
            this.fjH.setVisibility(0);
            this.fjI.setVisibility(8);
            this.fjH.setText(this.faJ.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fjH.setBackgroundDrawable(gradientDrawable);
        } else if (this.faJ.aQS().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.faJ.aQS().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.faJ.aQS().label.labelColor));
            }
            this.fjH.setBackgroundDrawable(gradientDrawable2);
            this.fjH.setText(this.faJ.aQS().label.labelName);
            this.fjH.setVisibility(0);
            this.fjI.setVisibility(8);
        } else if (this.faJ.aQS().mChallengeInfoData != null && this.faJ.aQS().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fjI.setBackground(gradientDrawable3);
            this.fjI.setVisibility(0);
            this.fjH.setVisibility(8);
        } else {
            this.fjH.setVisibility(8);
            this.fjI.setVisibility(8);
        }
        if (this.faJ.aQS().haveRedpkg) {
            this.fgG.setVisibility(0);
        } else {
            this.fgG.setVisibility(8);
        }
        if (this.faJ != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").dh("tid", this.faJ.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").dh("tid", this.faJ.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.feH, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.feG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.feI, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fjH, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.feG.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
