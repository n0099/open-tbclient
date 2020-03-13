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
    private bj ejW;
    public TbImageView enS;
    public TextView enT;
    public RelativeLayout enU;
    public TextView enV;
    private String eod;
    private AlphaAnimation eoh;
    public ImageView epP;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i erx;
    public TextView esO;
    public TextView esP;
    public LinearLayout esQ;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean eog = false;
    private boolean eoi = true;
    private boolean eoj = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int esR = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.ejW != null && b.this.ejW.aCH() != null && b.this.erx != null) {
                    b.this.erx.a(b.this.tabId, b.this.eod, b.this.ejW);
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
        this.enS = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.esO = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.enT = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.enU = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.enV = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.esP = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.esQ = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.enS.setBorderSurroundContent(true);
        this.enS.setDrawBorder(true);
        this.epP = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.eoh = new AlphaAnimation(0.0f, 1.0f);
        this.eoh.setDuration(200L);
        this.eoh.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                b.this.eoj = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                b.this.eoj = false;
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
        this.erx = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.ejW == null || cVar.ejW.aCH() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.esR != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.esR = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.enU.getLayoutParams();
            layoutParams.width = (this.esR - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.enU.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.ejW = cVar.ejW;
        this.tabId = cVar.tabId;
        this.eod = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.enS.getTag();
        if (this.eoi) {
            this.eog = true;
            this.eoi = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.ejW.aCH().cover) && !((String) tag).equals(this.ejW.aCH().cover)) {
            this.eog = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.ejW.aCH().cover) && !this.mCoverUrl.equals(this.ejW.aCH().cover)) {
            this.eog = true;
        } else {
            this.eog = false;
        }
        this.mCoverUrl = this.ejW.aCH().cover;
        this.enS.setTag(this.mCoverUrl);
        this.enS.startLoad(this.ejW.aCH().cover, 10, false);
        this.enS.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.eog && !b.this.eoj) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.enS.startAnimation(b.this.eoh);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.enT.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.numberUniformFormatExtra(this.ejW.aCH().audience_count)));
        if (this.ejW.aCo() != null) {
            String name_show = this.ejW.aCo().getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ad.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.enV.setText(name_show);
        }
        if (!StringUtils.isNull(this.ejW.mRecomExtra)) {
            this.esP.setVisibility(0);
            this.esQ.setVisibility(8);
            this.esP.setText(this.ejW.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.esP.setBackgroundDrawable(gradientDrawable);
        } else if (this.ejW.aCH().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.ejW.aCH().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.ejW.aCH().label.labelColor));
            }
            this.esP.setBackgroundDrawable(gradientDrawable2);
            this.esP.setText(this.ejW.aCH().label.labelName);
            this.esP.setVisibility(0);
            this.esQ.setVisibility(8);
        } else if (this.ejW.aCH().mChallengeInfoData != null && this.ejW.aCH().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.esQ.setBackground(gradientDrawable3);
            this.esQ.setVisibility(0);
            this.esP.setVisibility(8);
        } else {
            this.esP.setVisibility(8);
            this.esQ.setVisibility(8);
        }
        if (this.ejW.aCH().haveRedpkg) {
            this.epP.setVisibility(0);
        } else {
            this.epP.setVisibility(8);
        }
        if (this.ejW != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cy("tid", this.ejW.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cy("tid", this.ejW.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setBackgroundResource(this.enU, R.drawable.addresslist_item_bg);
            am.setViewTextColor(this.enT, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.enV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.esP, R.color.cp_cont_g, 1, 0);
            am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.enT.setCompoundDrawablesWithIntrinsicBounds(am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
