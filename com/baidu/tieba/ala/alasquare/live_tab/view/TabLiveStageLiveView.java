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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ag;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float gEP = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gHf = {0.0f, 0.0f, 0.0f, 0.0f, gEP, gEP, gEP, gEP};
    private TextView eKp;
    private int[] gET;
    private TbImageView gGY;
    private HeadImageView gGZ;
    private View gHa;
    private TextView gHb;
    private View gHc;
    private TabLiveStageLiveZanLottieView gHd;
    private SdkLiveInfoData gHe;
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
        this.gHd = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gHd.setForbidAutoUpdateState(true);
        this.gGY = (TbImageView) findViewById(R.id.cover);
        this.gGY.setBackgroundColor(0);
        this.gGY.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gGY.setConrers(15);
        this.gGZ = (HeadImageView) findViewById(R.id.head_img);
        this.gGZ.setAutoChangeStyle(false);
        this.gGZ.setClickable(true);
        this.gGZ.setIsRound(true);
        this.gGZ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.gHa = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eKp = (TextView) findViewById(R.id.user_name);
        this.gHb = (TextView) findViewById(R.id.audience_count);
        this.gHc = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gET);
        gradientDrawable.setCornerRadii(gHf);
        this.gHc.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gHe);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        ar arVar = new ar("c13559");
                        arVar.dR("entryname", "推荐");
                        TiebaStatic.log(arVar);
                        return;
                    }
                    return;
                }
                ar arVar2 = new ar("c13556");
                arVar2.dR("entryname", "推荐");
                TiebaStatic.log(arVar2);
            }
        });
        bSj();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gHe = sdkLiveInfoData;
        this.mType = i;
        this.gGY.setPlaceHolder(3);
        this.gGY.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ag.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eKp.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gGZ, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gHa.setVisibility(0);
            } else {
                this.gHa.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gHb.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, au.eb(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.eKp, R.color.CAM_X0101);
        ap.setViewTextColor(this.gHb, R.color.CAM_X0101);
        Drawable drawable = ap.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gHb.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gHb.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bSj() {
        try {
            this.gHd.setAnimation("zan_lottie_anim.json");
            this.gHd.setImageAssetsFolder("images/");
            this.gHd.loop(true);
            this.gHd.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gHd != null && !this.gHd.isAnimating()) {
            this.gHd.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gHd != null && this.gHd.isAnimating()) {
            this.gHd.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
