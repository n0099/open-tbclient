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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float feL = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fgT = {0.0f, 0.0f, 0.0f, 0.0f, feL, feL, feL, feL};
    private TextView dXU;
    private int[] feP;
    private TbImageView fgM;
    private HeadImageView fgN;
    private View fgO;
    private TextView fgP;
    private View fgQ;
    private TabLiveStageLiveZanLottieView fgR;
    private SdkLiveInfoData fgS;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.feP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.feP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.feP = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{feL, feL, feL, feL, feL, feL, feL, feL});
        this.fgR = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fgR.setForbidAutoUpdateState(true);
        this.fgM = (TbImageView) findViewById(R.id.cover);
        this.fgM.setBackgroundColor(0);
        this.fgM.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fgM.setConrers(15);
        this.fgN = (HeadImageView) findViewById(R.id.head_img);
        this.fgN.setAutoChangeStyle(false);
        this.fgN.setClickable(true);
        this.fgN.setIsRound(true);
        this.fgN.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fgO = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dXU = (TextView) findViewById(R.id.user_name);
        this.fgP = (TextView) findViewById(R.id.audience_count);
        this.fgQ = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.feP);
        gradientDrawable.setCornerRadii(fgT);
        this.fgQ.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fgS);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        an anVar = new an("c13559");
                        anVar.dh("entryname", "推荐");
                        TiebaStatic.log(anVar);
                        return;
                    }
                    return;
                }
                an anVar2 = new an("c13556");
                anVar2.dh("entryname", "推荐");
                TiebaStatic.log(anVar2);
            }
        });
        brr();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fgS = sdkLiveInfoData;
        this.mType = i;
        this.fgM.setPlaceHolder(3);
        this.fgM.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dXU.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fgN, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fgO.setVisibility(0);
            } else {
                this.fgO.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fgP.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, aq.cl(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dXU, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fgP, (int) R.color.cp_cont_a);
        Drawable drawable = am.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fgP.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fgP.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void brr() {
        try {
            this.fgR.setAnimation("zan_lottie_anim.json");
            this.fgR.setImageAssetsFolder("images/");
            this.fgR.loop(true);
            this.fgR.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fgR != null && !this.fgR.isAnimating()) {
            this.fgR.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fgR != null && this.fgR.isAnimating()) {
            this.fgR.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
