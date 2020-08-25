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
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float fGz = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fIH = {0.0f, 0.0f, 0.0f, 0.0f, fGz, fGz, fGz, fGz};
    private TextView dTQ;
    private int[] fGD;
    private TbImageView fIA;
    private HeadImageView fIB;
    private View fIC;
    private TextView fID;
    private View fIE;
    private TabLiveStageLiveZanLottieView fIF;
    private SdkLiveInfoData fIG;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.fGD = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.fGD = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.fGD = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{fGz, fGz, fGz, fGz, fGz, fGz, fGz, fGz});
        this.fIF = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fIF.setForbidAutoUpdateState(true);
        this.fIA = (TbImageView) findViewById(R.id.cover);
        this.fIA.setBackgroundColor(0);
        this.fIA.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fIA.setConrers(15);
        this.fIB = (HeadImageView) findViewById(R.id.head_img);
        this.fIB.setAutoChangeStyle(false);
        this.fIB.setClickable(true);
        this.fIB.setIsRound(true);
        this.fIB.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fIC = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dTQ = (TextView) findViewById(R.id.user_name);
        this.fID = (TextView) findViewById(R.id.audience_count);
        this.fIE = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fGD);
        gradientDrawable.setCornerRadii(fIH);
        this.fIE.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fIG);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        aq aqVar = new aq("c13559");
                        aqVar.dD("entryname", "推荐");
                        TiebaStatic.log(aqVar);
                        return;
                    }
                    return;
                }
                aq aqVar2 = new aq("c13556");
                aqVar2.dD("entryname", "推荐");
                TiebaStatic.log(aqVar2);
            }
        });
        bGw();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fIG = sdkLiveInfoData;
        this.mType = i;
        this.fIA.setPlaceHolder(3);
        this.fIA.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dTQ.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fIB, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fIC.setVisibility(0);
            } else {
                this.fIC.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fID.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, at.cP(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.dTQ, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.fID, (int) R.color.cp_cont_a);
        Drawable drawable = ap.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fID.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fID.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bGw() {
        try {
            this.fIF.setAnimation("zan_lottie_anim.json");
            this.fIF.setImageAssetsFolder("images/");
            this.fIF.loop(true);
            this.fIF.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fIF != null && !this.fIF.isAnimating()) {
            this.fIF.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fIF != null && this.fIF.isAnimating()) {
            this.fIF.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
