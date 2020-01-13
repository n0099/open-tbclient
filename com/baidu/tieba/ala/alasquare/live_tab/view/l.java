package com.baidu.tieba.ala.alasquare.live_tab.view;

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
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class l {
    private static final float ejA = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] ejB = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, ejA, ejA};
    private static final float[] ejC = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA};
    private static final float[] ejD = {0.0f, 0.0f, 0.0f, 0.0f, ejA, ejA, 0.0f, 0.0f};
    private bj efE;
    private String ejF;
    private AlphaAnimation ejI;
    public TbImageView eju;
    public TextView ejv;
    public TextView ejx;
    public LinearLayout ejy;
    public TbImageView elp;
    public ImageView elq;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    private int tabType;
    public int mSkinType = 3;
    private int[] ejE = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean ejH = false;
    private boolean ejJ = true;
    private boolean ejK = false;
    private int elr = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.efE);
            if (l.this.efE != null && l.this.efE.aAq() != null) {
                an anVar = new an("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 == l.this.tabType) {
                    str = "颜值";
                }
                anVar.s("obj_param1", l.this.efE.aAq().live_id);
                anVar.cp("entryname", str);
                TiebaStatic.log(anVar);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.eju = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eju.setBorderSurroundContent(true);
        this.eju.setDrawBorder(true);
        this.eju.setPlaceHolder(2);
        this.eju.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.ejv = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.ejx = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.ejy = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.elp = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.elq = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.ejI = new AlphaAnimation(0.0f, 1.0f);
        this.ejI.setDuration(200L);
        this.ejI.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.ejK = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.ejK = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.c cVar) {
        a(cVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.c cVar, int i) {
        String str;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.elr) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.elr = equipmentWidth;
        }
        if (cVar == null || cVar.efE == null || cVar.efE.aAq() == null) {
            getView().setVisibility(4);
            return;
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
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ejE);
        this.mCoverUrl = this.efE.aAq().cover;
        this.eju.setTag(this.mCoverUrl);
        if (cVar.isLeft) {
            this.eju.setConrers(5);
            gradientDrawable.setCornerRadii(ejC);
            this.eju.setPlaceHolder(2);
        } else if (cVar.isRight) {
            this.eju.setConrers(10);
            gradientDrawable.setCornerRadii(ejD);
            this.eju.setPlaceHolder(2);
        } else if (cVar.efC) {
            this.eju.setConrers(15);
            gradientDrawable.setCornerRadii(ejB);
            this.eju.setPlaceHolder(2);
        }
        this.eju.setRadius((int) ejA);
        this.eju.startLoad(this.efE.aAq().cover, 10, false);
        this.ejy.setBackgroundDrawable(gradientDrawable);
        this.eju.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.ejH && !l.this.ejK) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.eju.startAnimation(l.this.ejI);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.ejv.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bA(this.efE.aAq().audience_count)));
        this.ejx.setText(this.efE.getTitle());
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.efE.cPs;
        } else {
            str = this.efE.cPp;
        }
        if (!StringUtils.isNull(str) && this.efE.cPq > 0 && this.efE.cPr > 0) {
            if (cVar.isLeft) {
                this.elp.setConrers(1);
            } else if (cVar.isRight) {
                this.elp.setConrers(0);
            } else if (cVar.efC) {
                this.elp.setConrers(1);
            } else {
                this.elp.setConrers(0);
            }
            this.elp.setRadius((int) ejA);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.elp.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.efE.cPq / this.efE.cPr) * dimensionPixelSize);
                this.elp.setLayoutParams(layoutParams2);
            }
            this.elp.startLoad(str, 10, false);
            this.elp.setVisibility(0);
        } else {
            this.elp.setVisibility(8);
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
        an anVar = new an("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        }
        anVar.s("obj_param1", this.efE.aAq().live_id);
        anVar.cp("entryname", str2);
        TiebaStatic.log(anVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.ejv, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ejx, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.ejv.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.ejv.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
