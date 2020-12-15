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
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b {
    public TextView bAG;
    private by gpH;
    public TbImageView gtL;
    public TextView gtM;
    public RelativeLayout gtN;
    private String gtV;
    private AlphaAnimation gtY;
    public ImageView gvO;
    private com.baidu.tieba.ala.alasquare.subtablist.c.i gxu;
    public TextView gyL;
    public TextView gyM;
    public LinearLayout gyN;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private boolean gtX = false;
    private boolean gtZ = true;
    private boolean mIsAnimating = false;
    private BdUniqueId mBdUniqueId = BdUniqueId.gen();
    private int gyO = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (com.baidu.adp.lib.util.j.isNetWorkAvailable()) {
                if (b.this.gpH != null && b.this.gpH.bpj() != null && b.this.gxu != null) {
                    b.this.gxu.a(b.this.tabId, b.this.gtV, b.this.gpH);
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
        this.gtL = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.gyL = (TextView) this.mRootView.findViewById(R.id.tvLiveFrom);
        this.gtM = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.gtN = (RelativeLayout) this.mRootView.findViewById(R.id.rlSquareLivePanel);
        this.bAG = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.gyM = (TextView) this.mRootView.findViewById(R.id.tv_extra);
        this.gyN = (LinearLayout) this.mRootView.findViewById(R.id.challenge_root);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.gtL.setBorderSurroundContent(true);
        this.gtL.setDrawBorder(true);
        this.gvO = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.gtY = new AlphaAnimation(0.0f, 1.0f);
        this.gtY.setDuration(200L);
        this.gtY.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.1
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
        this.gxu = iVar;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        if (cVar == null || cVar.gpH == null || cVar.gpH.bpj() == null) {
            getView().setVisibility(4);
            return;
        }
        if (this.gyO != l.getEquipmentWidth(this.mRootView.getContext())) {
            this.gyO = l.getEquipmentWidth(this.mRootView.getContext());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtN.getLayoutParams();
            layoutParams.width = (this.gyO - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds6) * 3)) / 2;
            layoutParams.height = layoutParams.width;
            this.gtN.setLayoutParams(layoutParams);
        }
        getView().setVisibility(0);
        this.gpH = cVar.gpH;
        this.tabId = cVar.tabId;
        this.gtV = !TextUtils.isEmpty(cVar.labelName) ? cVar.labelName : cVar.entryName;
        Object tag = this.gtL.getTag();
        if (this.gtZ) {
            this.gtX = true;
            this.gtZ = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.gpH.bpj().cover) && !((String) tag).equals(this.gpH.bpj().cover)) {
            this.gtX = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.gpH.bpj().cover) && !this.mCoverUrl.equals(this.gpH.bpj().cover)) {
            this.gtX = true;
        } else {
            this.gtX = false;
        }
        this.mCoverUrl = this.gpH.bpj().cover;
        this.gtL.setTag(this.mCoverUrl);
        this.gtL.startLoad(this.gpH.bpj().cover, 10, false);
        this.gtL.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.special_forum.subtab.a.b.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str, boolean z) {
                if (z && b.this.gtX && !b.this.mIsAnimating) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str)) {
                        b.this.gtL.startAnimation(b.this.gtY);
                        this.url = str;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.gtM.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, au.numberUniformFormatExtra(this.gpH.bpj().audience_count)));
        if (this.gpH.boP() != null) {
            String name_show = this.gpH.boP().getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 10) {
                name_show = ae.subStringWithEmoji(name_show, 10) + StringHelper.STRING_MORE;
            }
            this.bAG.setText(name_show);
        }
        if (!StringUtils.isNull(this.gpH.mRecomExtra)) {
            this.gyM.setVisibility(0);
            this.gyN.setVisibility(8);
            this.gyM.setText(this.gpH.mRecomExtra);
            GradientDrawable gradientDrawable = new GradientDrawable();
            float dimensionPixelSize = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize, dimensionPixelSize, 0.0f, 0.0f});
            gradientDrawable.setColor(-50901);
            this.gyM.setBackgroundDrawable(gradientDrawable);
        } else if (this.gpH.bpj().label != null) {
            GradientDrawable gradientDrawable2 = new GradientDrawable();
            float dimensionPixelSize2 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable2.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize2, dimensionPixelSize2, 0.0f, 0.0f});
            if (!StringUtils.isNull(this.gpH.bpj().label.labelColor)) {
                gradientDrawable2.setColor(Color.parseColor(this.gpH.bpj().label.labelColor));
            }
            this.gyM.setBackgroundDrawable(gradientDrawable2);
            this.gyM.setText(this.gpH.bpj().label.labelName);
            this.gyM.setVisibility(0);
            this.gyN.setVisibility(8);
        } else if (this.gpH.bpj().mChallengeInfoData != null && this.gpH.bpj().mChallengeInfoData.challenge_id > 0) {
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            float dimensionPixelSize3 = this.mTbPageContext.getPageActivity().getResources().getDimensionPixelSize(R.dimen.tbds9);
            gradientDrawable3.setCornerRadii(new float[]{0.0f, 0.0f, 0.0f, 0.0f, dimensionPixelSize3, dimensionPixelSize3, 0.0f, 0.0f});
            gradientDrawable3.setColor(-50901);
            this.gyN.setBackground(gradientDrawable3);
            this.gyN.setVisibility(0);
            this.gyM.setVisibility(8);
        } else {
            this.gyM.setVisibility(8);
            this.gyN.setVisibility(8);
        }
        if (this.gpH.bpj().haveRedpkg) {
            this.gvO.setVisibility(0);
        } else {
            this.gvO.setVisibility(8);
        }
        if (this.gpH != null) {
            if (i == 2) {
                TiebaStatic.log(new ar("c12899").dY("tid", this.gpH.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new ar("c12903").dY("tid", this.gpH.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.setBackgroundResource(this.gtN, R.drawable.addresslist_item_bg);
            ap.setViewTextColor(this.gtM, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.bAG, (int) R.color.CAM_X0101);
            ap.setViewTextColor(this.gyM, R.color.CAM_X0111, 1, 0);
            ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding).setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds14));
            this.gtM.setCompoundDrawablesWithIntrinsicBounds(ap.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.icon_video_direct_seeding), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mSkinType = i;
        }
    }
}
