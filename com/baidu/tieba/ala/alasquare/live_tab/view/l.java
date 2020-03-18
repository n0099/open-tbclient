package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
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
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class l {
    private static final float eoq = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] eor = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, eoq, eoq};
    private static final float[] eos = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq};
    private static final float[] eot = {0.0f, 0.0f, 0.0f, 0.0f, eoq, eoq, 0.0f, 0.0f};
    public TbImageView eok;
    public TextView eol;
    public TextView eon;
    public LinearLayout eoo;
    private AlphaAnimation eoy;
    public TbImageView eqk;
    public ImageView eql;
    private com.baidu.tieba.ala.alasquare.a.a eqm;
    private SdkLiveInfoData eqp;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabType;
    public int mSkinType = 3;
    private int[] eou = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean eox = false;
    private boolean eoz = true;
    private boolean eoA = false;
    private int eqn = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.c.a(l.this.mTbPageContext.getPageActivity(), l.this.eqp);
            if (l.this.eqm != null && l.this.eqp != null) {
                if (l.this.eqm.cUE) {
                    an anVar = new an("c13611");
                    anVar.cx("obj_param1", l.this.eqp.liveId);
                    anVar.cx("fid", l.this.eqm.fid);
                    anVar.cx("fname", l.this.eqm.fname);
                    anVar.X("obj_locate", l.this.eqm.position);
                    TiebaStatic.log(anVar);
                    return;
                }
                an anVar2 = new an("c13557");
                String str = "";
                if (101 == l.this.tabType) {
                    str = "推荐";
                } else if (102 == l.this.tabType) {
                    str = "颜值";
                }
                anVar2.cx("obj_param1", l.this.eqp.liveId);
                anVar2.cx("entryname", str);
                TiebaStatic.log(anVar2);
            }
        }
    };

    public l(TbPageContext<?> tbPageContext, int i) {
        this.mTbPageContext = tbPageContext;
        this.tabType = i;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.eok = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.eok.setBorderSurroundContent(true);
        this.eok.setDrawBorder(true);
        this.eok.setPlaceHolder(2);
        this.eok.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.eol = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.eon = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.eoo = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.eqk = (TbImageView) this.mRootView.findViewById(R.id.live_label);
        this.eql = (ImageView) this.mRootView.findViewById(R.id.live_redpacket_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.eoy = new AlphaAnimation(0.0f, 1.0f);
        this.eoy.setDuration(200L);
        this.eoy.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                l.this.eoA = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                l.this.eoA = false;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }

    public View getView() {
        return this.mRootView;
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar) {
        a(aVar, -1);
    }

    public void a(com.baidu.tieba.ala.alasquare.a.a aVar, int i) {
        String str;
        int equipmentWidth = com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.eqn) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (com.baidu.adp.lib.util.l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.eqn = equipmentWidth;
        }
        if (aVar == null || aVar.ekj == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.eqm = aVar;
        this.eqp = aVar.ekj;
        Object tag = this.eok.getTag();
        if (this.eoz) {
            this.eox = true;
            this.eoz = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.eqp.liveInfo.cover) && !((String) tag).equals(this.eqp.liveInfo.cover)) {
            this.eox = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.eqp.liveInfo.cover) && !this.mCoverUrl.equals(this.eqp.liveInfo.cover)) {
            this.eox = true;
        } else {
            this.eox = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.eou);
        this.mCoverUrl = this.eqp.liveInfo.cover;
        this.eok.setTag(this.mCoverUrl);
        if (aVar.isLeft) {
            this.eok.setConrers(5);
            gradientDrawable.setCornerRadii(eos);
            this.eok.setPlaceHolder(2);
        } else if (aVar.isRight) {
            this.eok.setConrers(10);
            gradientDrawable.setCornerRadii(eot);
            this.eok.setPlaceHolder(2);
        } else if (aVar.ekk) {
            this.eok.setConrers(15);
            gradientDrawable.setCornerRadii(eor);
            this.eok.setPlaceHolder(2);
        }
        this.eok.setRadius((int) eoq);
        this.eok.startLoad(this.eqp.liveInfo.cover, 10, false);
        this.eoo.setBackgroundDrawable(gradientDrawable);
        this.eok.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.l.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && l.this.eox && !l.this.eoA) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        l.this.eok.startAnimation(l.this.eoy);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.eol.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.bE(this.eqp.liveInfo.audienceCount)));
        this.eon.setText(this.eqp.title);
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.eqp.recom_extra_img_night;
        } else {
            str = this.eqp.recom_extra_img;
        }
        if (!StringUtils.isNull(str) && this.eqp.recom_extra_img_width > 0 && this.eqp.recom_extra_img_height > 0) {
            if (aVar.isLeft) {
                this.eqk.setConrers(1);
            } else if (aVar.isRight) {
                this.eqk.setConrers(0);
            } else if (aVar.ekk) {
                this.eqk.setConrers(1);
            } else {
                this.eqk.setConrers(0);
            }
            this.eqk.setRadius((int) eoq);
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.eqk.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = (int) ((this.eqp.recom_extra_img_width / this.eqp.recom_extra_img_height) * dimensionPixelSize);
                this.eqk.setLayoutParams(layoutParams2);
            }
            this.eqk.startLoad(str, 10, false);
            this.eqk.setVisibility(0);
        } else {
            this.eqk.setVisibility(8);
        }
        if (this.eqp.liveInfo.haveRedpkg) {
            this.eql.setVisibility(0);
        } else {
            this.eql.setVisibility(8);
        }
        if (this.eqp != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").cx("tid", this.eqp.tid));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").cx("tid", this.eqp.tid));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        if (aVar.cUE) {
            an anVar = new an("c13610");
            anVar.cx("obj_param1", this.eqp != null ? this.eqp.liveId : "");
            anVar.cx("fid", aVar.fid);
            anVar.cx("fname", aVar.fname);
            anVar.X("obj_locate", aVar.position);
            TiebaStatic.log(anVar);
            return;
        }
        an anVar2 = new an("c13544");
        String str2 = "";
        if (101 == this.tabType) {
            str2 = "推荐";
        } else if (102 == this.tabType) {
            str2 = "颜值";
        }
        anVar2.cx("obj_param1", this.eqp == null ? "" : this.eqp.liveId);
        anVar2.cx("entryname", str2);
        TiebaStatic.log(anVar2);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.eol, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.eon, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.eol.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.eol.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
