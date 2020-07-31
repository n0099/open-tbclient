package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float fvg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fxp = {0.0f, 0.0f, 0.0f, 0.0f, fvg, fvg, fvg, fvg};
    private TextView dKI;
    private int[] fvk;
    private TbImageView fxi;
    private HeadImageView fxj;
    private View fxk;
    private TextView fxl;
    private View fxm;
    private TabLiveStageLiveZanLottieView fxn;
    private SdkLiveInfoData fxo;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.fvk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.fvk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.fvk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{fvg, fvg, fvg, fvg, fvg, fvg, fvg, fvg});
        this.fxn = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fxn.setForbidAutoUpdateState(true);
        this.fxi = (TbImageView) findViewById(R.id.cover);
        this.fxi.setBackgroundColor(0);
        this.fxi.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fxi.setConrers(15);
        this.fxj = (HeadImageView) findViewById(R.id.head_img);
        this.fxj.setAutoChangeStyle(false);
        this.fxj.setClickable(true);
        this.fxj.setIsRound(true);
        this.fxj.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fxk = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dKI = (TextView) findViewById(R.id.user_name);
        this.fxl = (TextView) findViewById(R.id.audience_count);
        this.fxm = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fvk);
        gradientDrawable.setCornerRadii(fxp);
        this.fxm.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fxo);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        ap apVar = new ap("c13559");
                        apVar.dn("entryname", "推荐");
                        TiebaStatic.log(apVar);
                        return;
                    }
                    return;
                }
                ap apVar2 = new ap("c13556");
                apVar2.dn("entryname", "推荐");
                TiebaStatic.log(apVar2);
            }
        });
        bxx();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fxo = sdkLiveInfoData;
        this.mType = i;
        this.fxi.setPlaceHolder(3);
        this.fxi.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dKI.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fxj, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fxk.setVisibility(0);
            } else {
                this.fxk.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fxl.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, as.cE(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ao.setViewTextColor(this.dKI, R.color.cp_cont_a);
        ao.setViewTextColor(this.fxl, R.color.cp_cont_a);
        Drawable drawable = ao.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fxl.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fxl.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bxx() {
        try {
            this.fxn.setAnimation("zan_lottie_anim.json");
            this.fxn.setImageAssetsFolder("images/");
            this.fxn.loop(true);
            this.fxn.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fxn != null && !this.fxn.isAnimating()) {
            this.fxn.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fxn != null && this.fxn.isAnimating()) {
            this.fxn.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
