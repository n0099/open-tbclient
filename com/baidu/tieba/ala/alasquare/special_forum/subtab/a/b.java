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
/* loaded from: classes2.dex */
public class b {
    private bj efE;
    private String ejF;
    private AlphaAnimation ejI;
    public TbImageView eju;
    public TextView ejv;
    public RelativeLayout ejw;
    public TextView ejx;
    public ImageView elq;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i emV;
    public TextView eoq;
    public TextView eor;
    public LinearLayout eos;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean ejH = false;
    private boolean ejJ = true;
    private boolean ejK = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int eot = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.efE != null && b.this.efE.aAq() != null && b.this.emV != null) {
                    b.this.emV.a(b.this.tabId, b.this.ejF, b.this.efE);
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
        this.eju = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eoq = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.ejv = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ejw = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.ejx = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eor = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.eos = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eju.setBorderSurroundContent(true);
        this.eju.setDrawBorder(true);
        this.elq = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.ejI = new AlphaAnimation(0.0f, 1.0f);
        this.ejI.setDuration(200L);
        this.ejI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.ejK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.ejK = false;
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
        this.emV = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.efE == null || cVar.efE.aAq() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.eot != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.eot = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.ejw.getLayoutParams();
            layoutParams.width = (this.eot - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.ejw.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.efE = cVar.efE;
        this.tabId = cVar.tabId;
        this.ejF = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.eju.getTag();
        if (this.ejJ) {
            this.ejH = true;
            this.ejJ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.efE.aAq().cover) && !((String) tag).equals(this.efE.aAq().cover)) {
            this.ejH = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.efE.aAq().cover) && !this.mCoverUrl.equals(this.efE.aAq().cover)) {
            this.ejH = true;
        } else {
            this.ejH = false;
        }
        this.mCoverUrl = this.efE.aAq().cover;
        this.eju.setTag(this.mCoverUrl);
        this.eju.startLoad(this.efE.aAq().cover, 10, false);
        this.eju.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.ejH && !b.this.ejK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.eju.startAnimation(b.this.ejI);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ejv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.efE.aAq().audience_count)));
        if (this.efE.azX() != null) {
            String name_show = this.efE.azX().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.ejx.setText(name_show);
        }
        if (!StringUtils.isNull(this.efE.mRecomExtra)) {
            this.eor.setVisibility(0);
            this.eos.setVisibility(8);
            this.eor.setText(this.efE.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.eor.setBackgroundDrawable(gradientDrawable);
        } else if (this.efE.aAq().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.efE.aAq().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.efE.aAq().label.labelColor));
            }
            this.eor.setBackgroundDrawable(gradientDrawable2);
            this.eor.setText(this.efE.aAq().label.labelName);
            this.eor.setVisibility(0);
            this.eos.setVisibility(8);
        } else if (this.efE.aAq().mChallengeInfoData != null && this.efE.aAq().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.eos.setBackground(gradientDrawable3);
            this.eos.setVisibility(0);
            this.eor.setVisibility(8);
        } else {
            this.eor.setVisibility(8);
            this.eos.setVisibility(8);
        }
        if (this.efE.aAq().haveRedpkg) {
            this.elq.setVisibility(0);
        } else {
            this.elq.setVisibility(8);
        }
        if (this.efE != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cp("tid", this.efE.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cp("tid", this.efE.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.ejw, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.ejv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ejx, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eor, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.ejv.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
