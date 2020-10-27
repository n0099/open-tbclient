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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.af;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float ggk = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] giw = {0.0f, 0.0f, 0.0f, 0.0f, ggk, ggk, ggk, ggk};
    private TextView eqE;
    private int[] ggo;
    private TbImageView gip;
    private HeadImageView giq;
    private View gir;
    private TextView gis;
    private View git;
    private TabLiveStageLiveZanLottieView giu;
    private SdkLiveInfoData giv;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.ggo = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.ggo = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.ggo = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{ggk, ggk, ggk, ggk, ggk, ggk, ggk, ggk});
        this.giu = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.giu.setForbidAutoUpdateState(true);
        this.gip = (TbImageView) findViewById(R.id.cover);
        this.gip.setBackgroundColor(0);
        this.gip.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gip.setConrers(15);
        this.giq = (HeadImageView) findViewById(R.id.head_img);
        this.giq.setAutoChangeStyle(false);
        this.giq.setClickable(true);
        this.giq.setIsRound(true);
        this.giq.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.gir = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eqE = (TextView) findViewById(R.id.user_name);
        this.gis = (TextView) findViewById(R.id.audience_count);
        this.git = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.ggo);
        gradientDrawable.setCornerRadii(giw);
        this.git.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.giv);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dR("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dR("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bNb();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.giv = sdkLiveInfoData;
        this.mType = i;
        this.gip.setPlaceHolder(3);
        this.gip.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (af.getTextLengthWithEmoji(name_show) > 16) {
                name_show = af.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eqE.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.giq, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gir.setVisibility(0);
            } else {
                this.gir.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gis.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.da(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ap.setViewTextColor(this.eqE, R.color.cp_cont_a);
        ap.setViewTextColor(this.gis, R.color.cp_cont_a);
        Drawable drawable = ap.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gis.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gis.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bNb() {
        try {
            this.giu.setAnimation("zan_lottie_anim.json");
            this.giu.setImageAssetsFolder("images/");
            this.giu.loop(true);
            this.giu.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.giu != null && !this.giu.isAnimating()) {
            this.giu.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.giu != null && this.giu.isAnimating()) {
            this.giu.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
