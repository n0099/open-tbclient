package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.ala.utils.AlaUtilHelper;
import com.baidu.ala.view.AlaRoundRelativeLayout;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ad;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gHe = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private TextView eLt;
    private int[] gET;
    private TbImageView gGX;
    private HeadImageView gGY;
    private View gGZ;
    private TextView gHa;
    private View gHb;
    private TabLiveStageLiveZanLottieView gHc;
    private SdkLiveInfoData gHd;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gET = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gET = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gET = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{gEP, gEP, gEP, gEP, gEP, gEP, gEP, gEP});
        this.gHc = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gHc.setForbidAutoUpdateState(true);
        this.gGX = (TbImageView) findViewById(R.id.cover);
        this.gGX.setBackgroundColor(0);
        this.gGX.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gGX.setConrers(15);
        this.gGY = (HeadImageView) findViewById(R.id.head_img);
        this.gGY.setAutoChangeStyle(false);
        this.gGY.setClickable(true);
        this.gGY.setIsRound(true);
        this.gGY.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.gGZ = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eLt = (TextView) findViewById(R.id.user_name);
        this.gHa = (TextView) findViewById(R.id.audience_count);
        this.gHb = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        gradientDrawable.setCornerRadii(gHe);
        this.gHb.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gHd);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dX("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dX("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bVl();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gHd = sdkLiveInfoData;
        this.mType = i;
        this.gGX.setPlaceHolder(3);
        this.gGX.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ad.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ad.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eLt.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gGY, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gGZ.setVisibility(0);
            } else {
                this.gGZ.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gHa.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.dV(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ao.setViewTextColor(this.eLt, R.color.CAM_X0101);
        ao.setViewTextColor(this.gHa, R.color.CAM_X0101);
        Drawable drawable = ao.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gHa.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gHa.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bVl() {
        try {
            this.gHc.setAnimation("zan_lottie_anim.json");
            this.gHc.setImageAssetsFolder("images/");
            this.gHc.loop(true);
            this.gHc.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gHc != null && !this.gHc.isAnimating()) {
            this.gHc.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gHc != null && this.gHc.isAnimating()) {
            this.gHc.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
