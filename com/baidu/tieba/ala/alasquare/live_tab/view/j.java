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
import com.baidu.adp.lib.util.l;
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
public class j {
    private static final float eiM = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eiN = {0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM, eiM, eiM};
    private static final float[] eiO = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM};
    private static final float[] eiP = {0.0f, 0.0f, 0.0f, 0.0f, eiM, eiM, 0.0f, 0.0f};
    private bj eft;
    public TbImageView eiG;
    public TextView eiH;
    public TextView eiJ;
    public LinearLayout eiK;
    private String eiR;
    private AlphaAnimation eiU;
    public TbImageView eku;
    public ImageView ekv;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] eiQ = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eiT = false;
    private boolean eiV = true;
    private boolean eiW = false;
    private int ekw = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.b.a(j.this.mTbPageContext.getPageActivity(), j.this.eft);
            if (j.this.eft != null && j.this.eft.azX() != null) {
                an anVar = new an("c13557");
                anVar.s("obj_param1", j.this.eft.azX().live_id);
                TiebaStatic.log(anVar);
            }
        }
    };

    public j(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.eiG = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eiG.setBorderSurroundContent(true);
        this.eiG.setDrawBorder(true);
        this.eiG.setPlaceHolder(2);
        this.eiG.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eiH = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eiJ = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eiK = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eku = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.ekv = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eiU = new AlphaAnimation(0.0f, 1.0f);
        this.eiU.setDuration(200L);
        this.eiU.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                j.this.eiW = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                j.this.eiW = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void b(com.baidu.tieba.ala.alasquare.a.b bVar) {
        a(bVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.b bVar, int i) {
        String str;
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.ekw) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.ekw = equipmentWidth;
        }
        if (bVar == null || bVar.eft == null || bVar.eft.azX() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eft = bVar.eft;
        this.tabId = bVar.tabId;
        this.eiR = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.eiG.getTag();
        if (this.eiV) {
            this.eiT = true;
            this.eiV = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eft.azX().cover) && !((String) tag).equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eft.azX().cover) && !this.mCoverUrl.equals(this.eft.azX().cover)) {
            this.eiT = true;
        } else {
            this.eiT = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eiQ);
        this.mCoverUrl = this.eft.azX().cover;
        this.eiG.setTag(this.mCoverUrl);
        if (bVar.isLeft) {
            this.eiG.setConrers(5);
            gradientDrawable.setCornerRadii(eiO);
            this.eiG.setPlaceHolder(2);
        } else if (bVar.isRight) {
            this.eiG.setConrers(10);
            gradientDrawable.setCornerRadii(eiP);
            this.eiG.setPlaceHolder(2);
        } else if (bVar.efw) {
            this.eiG.setConrers(15);
            gradientDrawable.setCornerRadii(eiN);
            this.eiG.setPlaceHolder(2);
        }
        this.eiG.setRadius((int) eiM);
        this.eiG.startLoad(this.eft.azX().cover, 10, false);
        this.eiK.setBackgroundDrawable(gradientDrawable);
        this.eiG.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && j.this.eiT && !j.this.eiW) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        j.this.eiG.startAnimation(j.this.eiU);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eiH.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bx(this.eft.azX().audience_count)));
        this.eiJ.setText(this.eft.getTitle());
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eft.cPi;
        } else {
            str = this.eft.cPf;
        }
        if (!StringUtils.isNull(str) && this.eft.cPg > 0 && this.eft.cPh > 0) {
            if (bVar.isLeft) {
                this.eku.setConrers(1);
            } else if (bVar.isRight) {
                this.eku.setConrers(0);
            } else if (bVar.efw) {
                this.eku.setConrers(1);
            } else {
                this.eku.setConrers(0);
            }
            this.eku.setRadius((int) eiM);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eku.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.eft.cPg / this.eft.cPh) * dimensionPixelSize);
                this.eku.setLayoutParams(layoutParams2);
            }
            this.eku.startLoad(str, 10, false);
            this.eku.setVisibility(0);
        } else {
            this.eku.setVisibility(8);
        }
        if (this.eft.azX().haveRedpkg) {
            this.ekv.setVisibility(0);
        } else {
            this.ekv.setVisibility(8);
        }
        if (this.eft != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cp("tid", this.eft.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cp("tid", this.eft.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        an anVar = new an("c13544");
        anVar.s("obj_param1", this.eft.azX().live_id);
        TiebaStatic.log(anVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eiH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eiJ, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eiH.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eiH.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
