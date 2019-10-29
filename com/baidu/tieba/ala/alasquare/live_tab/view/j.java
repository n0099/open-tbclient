package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.graphics.Bitmap;
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
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class j {
    private static final float dyB = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] dyC = {0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB, dyB, dyB};
    private static final float[] dyD = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB};
    private static final float[] dyE = {0.0f, 0.0f, 0.0f, 0.0f, dyB, dyB, 0.0f, 0.0f};
    public ImageView dAk;
    private bh dvi;
    private String dyG;
    private AlphaAnimation dyJ;
    public TbImageView dyv;
    public TextView dyw;
    public TextView dyy;
    public LinearLayout dyz;
    private String mCoverUrl;
    public View mRootView;
    private TbPageContext<?> mTbPageContext;
    private int tabId;
    public int mSkinType = 3;
    private int[] dyF = {TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha40)};
    private boolean dyI = false;
    private boolean dyK = true;
    private boolean dyL = false;
    private int dAl = 0;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.4
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.ala.alasquare.live_tab.b.a(j.this.mTbPageContext.getPageActivity(), j.this.dvi);
            if (j.this.dvi != null && j.this.dvi.aiZ() != null) {
                an anVar = new an("c13557");
                anVar.p("obj_param1", j.this.dvi.aiZ().live_id);
                TiebaStatic.log(anVar);
            }
        }
    };

    public j(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(this.mTbPageContext.getPageActivity()).inflate(R.layout.tab_live_item_view, (ViewGroup) null, false);
        this.dyv = (TbImageView) this.mRootView.findViewById(R.id.imgSquareView);
        this.dyv.setBorderSurroundContent(true);
        this.dyv.setDrawBorder(true);
        this.dyv.setBorderWidth(l.getDimens(tbPageContext.getPageActivity(), R.dimen.tbds1));
        this.dyw = (TextView) this.mRootView.findViewById(R.id.tvLiveCount);
        this.dyy = (TextView) this.mRootView.findViewById(R.id.tvUserName);
        this.dyz = (LinearLayout) this.mRootView.findViewById(R.id.tvUserNameWrapper);
        this.dAk = (ImageView) this.mRootView.findViewById(R.id.live_label);
        this.mRootView.setOnClickListener(this.mOnClickListener);
        this.dyJ = new AlphaAnimation(0.0f, 1.0f);
        this.dyJ.setDuration(200L);
        this.dyJ.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.1
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                j.this.dyL = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                j.this.dyL = false;
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
        final int i2;
        final int i3 = 0;
        int equipmentWidth = l.getEquipmentWidth(this.mRootView.getContext());
        if (equipmentWidth != this.dAl) {
            ViewGroup.LayoutParams layoutParams = this.mRootView.getLayoutParams();
            int equipmentWidth2 = (l.getEquipmentWidth(this.mRootView.getContext()) - this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds12)) - (this.mRootView.getContext().getResources().getDimensionPixelSize(R.dimen.tbds44) * 2);
            if (layoutParams == null) {
                layoutParams = new ViewGroup.LayoutParams(equipmentWidth2 / 2, equipmentWidth2 / 2);
            } else {
                layoutParams.width = equipmentWidth2 / 2;
                layoutParams.height = layoutParams.width;
            }
            this.mRootView.setLayoutParams(layoutParams);
            this.dAl = equipmentWidth;
        }
        if (bVar == null || bVar.dvi == null || bVar.dvi.aiZ() == null) {
            getView().setVisibility(4);
            return;
        }
        getView().setVisibility(0);
        this.dvi = bVar.dvi;
        this.tabId = bVar.tabId;
        this.dyG = !TextUtils.isEmpty(bVar.labelName) ? bVar.labelName : bVar.entryName;
        Object tag = this.dyv.getTag();
        if (this.dyK) {
            this.dyI = true;
            this.dyK = false;
        } else if ((tag instanceof String) && !StringUtils.isNull(this.dvi.aiZ().cover) && !((String) tag).equals(this.dvi.aiZ().cover)) {
            this.dyI = true;
        } else if (!StringUtils.isNull(this.mCoverUrl) && !StringUtils.isNull(this.dvi.aiZ().cover) && !this.mCoverUrl.equals(this.dvi.aiZ().cover)) {
            this.dyI = true;
        } else {
            this.dyI = false;
        }
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.dyF);
        this.mCoverUrl = this.dvi.aiZ().cover;
        this.dyv.setTag(this.mCoverUrl);
        if (bVar.isLeft) {
            this.dyv.setConrers(5);
            gradientDrawable.setCornerRadii(dyD);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_left);
        } else if (bVar.isRight) {
            this.dyv.setConrers(10);
            gradientDrawable.setCornerRadii(dyE);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_right);
        } else if (bVar.dvl) {
            this.dyv.setConrers(15);
            gradientDrawable.setCornerRadii(dyC);
            this.dyv.setDefaultBgResource(R.drawable.tab_live_card_round_bg_only_left);
        }
        this.dyv.setRadius((int) dyB);
        this.dyv.startLoad(this.dvi.aiZ().cover, 10, false);
        this.dyz.setBackgroundDrawable(gradientDrawable);
        this.dyv.setEvent(new TbImageView.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.2
            String url;

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onComplete(String str2, boolean z) {
                if (z && j.this.dyI && !j.this.dyL) {
                    if (StringUtils.isNull(this.url) || !this.url.equals(str2)) {
                        j.this.dyv.startAnimation(j.this.dyJ);
                        this.url = str2;
                    }
                }
            }

            @Override // com.baidu.tbadk.widget.TbImageView.a
            public void onCancel() {
            }
        });
        this.dyw.setText(this.mTbPageContext.getPageActivity().getResources().getString(R.string.square_sub_live_audience_label, aq.aT(this.dvi.aiZ().audience_count)));
        this.dyy.setText(this.dvi.getTitle());
        if (TbadkCoreApplication.getInst().getSkinType() == 1 || TbadkCoreApplication.getInst().getSkinType() == 4) {
            str = this.dvi.cdD;
        } else {
            str = this.dvi.cdA;
        }
        if (!StringUtils.isNull(str) && this.dvi.cdB > 0 && this.dvi.cdC > 0) {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.dAk.getLayoutParams();
            if (layoutParams2 != null) {
                int dimensionPixelSize = this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.ds42);
                int i4 = (int) ((this.dvi.cdB / this.dvi.cdC) * dimensionPixelSize);
                layoutParams2.height = dimensionPixelSize;
                layoutParams2.width = i4;
                this.dAk.setLayoutParams(layoutParams2);
                i2 = i4;
                i3 = dimensionPixelSize;
            } else {
                i2 = 0;
            }
            com.baidu.adp.lib.f.c.fT().a(str, 10, new com.baidu.adp.lib.f.b<com.baidu.adp.widget.ImageView.a>() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.j.3
                /* JADX DEBUG: Method merged with bridge method */
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.baidu.adp.lib.f.b
                public void onLoaded(com.baidu.adp.widget.ImageView.a aVar, String str2, int i5) {
                    Bitmap rawBitmap;
                    Bitmap copy;
                    Bitmap copy2;
                    super.onLoaded((AnonymousClass3) aVar, str2, i5);
                    if (aVar != null && (rawBitmap = aVar.getRawBitmap()) != null) {
                        try {
                            if (rawBitmap.getConfig() == null) {
                                copy2 = rawBitmap.copy(Bitmap.Config.ARGB_8888, false);
                            } else {
                                copy2 = rawBitmap.copy(rawBitmap.getConfig(), false);
                            }
                            copy = copy2;
                        } catch (OutOfMemoryError e) {
                            BdLog.e(e);
                            if (rawBitmap.getConfig() == null) {
                                try {
                                    copy = rawBitmap.copy(Bitmap.Config.RGB_565, false);
                                } catch (OutOfMemoryError e2) {
                                    BdLog.e(e2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        }
                        if (copy != null) {
                            try {
                                Bitmap resizeBitmap = com.baidu.adp.lib.util.d.gW().resizeBitmap(copy, i2, i3);
                                if (resizeBitmap != copy) {
                                    copy.recycle();
                                }
                                if (resizeBitmap != null) {
                                    j.this.dAk.setVisibility(0);
                                    j.this.dAk.setImageBitmap(resizeBitmap);
                                    return;
                                }
                                j.this.dAk.setVisibility(8);
                            } catch (OutOfMemoryError e3) {
                                BdLog.e(e3);
                                if (copy != null) {
                                    copy.recycle();
                                }
                            }
                        }
                    }
                }
            }, null);
        } else {
            this.dAk.setVisibility(8);
        }
        if (this.dvi != null) {
            if (i == 2) {
                TiebaStatic.log(new an("c12899").bS("tid", this.dvi.getTid()));
            } else if (i == 1) {
                TiebaStatic.log(new an("c12903").bS("tid", this.dvi.getTid()));
            }
        }
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
        an anVar = new an("c13544");
        anVar.p("obj_param1", this.dvi.aiZ().live_id);
        TiebaStatic.log(anVar);
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            am.setViewTextColor(this.dyw, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.dyy, (int) R.color.cp_cont_a);
            Drawable drawable = am.getDrawable(this.mTbPageContext.getResources(), (int) R.drawable.tab_icon_living_seeding);
            drawable.setBounds(0, 0, this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18), this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds18));
            this.dyw.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            this.dyw.setCompoundDrawablePadding(this.mTbPageContext.getResources().getDimensionPixelOffset(R.dimen.tbds8));
            this.mSkinType = i;
        }
    }
}
