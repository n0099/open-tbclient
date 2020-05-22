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
    private bk fay;
    private String feF;
    private AlphaAnimation feI;
    public TbImageView feu;
    public TextView fev;
    public RelativeLayout few;
    public TextView fex;
    public ImageView fgv;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i fic;
    public TextView fjv;
    public TextView fjw;
    public LinearLayout fjx;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean feH = false;
    private boolean feJ = true;
    private boolean feK = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int fjy = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.fay != null && b.this.fay.aQS() != null && b.this.fic != null) {
                    b.this.fic.a(b.this.tabId, b.this.feF, b.this.fay);
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
        this.feu = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.fjv = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.fev = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.few = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.fex = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.fjw = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.fjx = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.feu.setBorderSurroundContent(true);
        this.feu.setDrawBorder(true);
        this.fgv = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.feI = new AlphaAnimation(0.0f, 1.0f);
        this.feI.setDuration(200L);
        this.feI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.feK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.feK = false;
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
        this.fic = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.fay == null || cVar.fay.aQS() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.fjy != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.fjy = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.few.getLayoutParams();
            layoutParams.width = (this.fjy - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.few.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.fay = cVar.fay;
        this.tabId = cVar.tabId;
        this.feF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.feu.getTag();
        if (this.feJ) {
            this.feH = true;
            this.feJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.fay.aQS().cover) && !((String) tag).equals(this.fay.aQS().cover)) {
            this.feH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.fay.aQS().cover) && !this.mCoverUrl.equals(this.fay.aQS().cover)) {
            this.feH = true;
        } else {
            this.feH = false;
        }
        this.mCoverUrl = this.fay.aQS().cover;
        this.feu.setTag(this.mCoverUrl);
        this.feu.startLoad(this.fay.aQS().cover, 10, false);
        this.feu.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.feH && !b.this.feK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.feu.startAnimation(b.this.feI);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.fev.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.fay.aQS().audience_count)));
        if (this.fay.aQx() != null) {
            String name_show = this.fay.aQx().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.fex.setText(name_show);
        }
        if (!StringUtils.isNull(this.fay.mRecomExtra)) {
            this.fjw.setVisibility(0);
            this.fjx.setVisibility(8);
            this.fjw.setText(this.fay.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.fjw.setBackgroundDrawable(gradientDrawable);
        } else if (this.fay.aQS().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.fay.aQS().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.fay.aQS().label.labelColor));
            }
            this.fjw.setBackgroundDrawable(gradientDrawable2);
            this.fjw.setText(this.fay.aQS().label.labelName);
            this.fjw.setVisibility(0);
            this.fjx.setVisibility(8);
        } else if (this.fay.aQS().mChallengeInfoData != null && this.fay.aQS().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.fjx.setBackground(gradientDrawable3);
            this.fjx.setVisibility(0);
            this.fjw.setVisibility(8);
        } else {
            this.fjw.setVisibility(8);
            this.fjx.setVisibility(8);
        }
        if (this.fay.aQS().haveRedpkg) {
            this.fgv.setVisibility(0);
        } else {
            this.fgv.setVisibility(8);
        }
        if (this.fay != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").dh("tid", this.fay.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").dh("tid", this.fay.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.few, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.fev, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fex, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.fjw, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.fev.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
