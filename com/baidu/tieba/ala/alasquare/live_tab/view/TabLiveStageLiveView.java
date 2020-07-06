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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.util.ae;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float fpW = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] fsh = {0.0f, 0.0f, 0.0f, 0.0f, fpW, fpW, fpW, fpW};
    private TextView dEL;
    private int[] fqa;
    private TbImageView fsa;
    private HeadImageView fsb;
    private View fsc;
    private TextView fsd;
    private View fse;
    private TabLiveStageLiveZanLottieView fsf;
    private SdkLiveInfoData fsg;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.fqa = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.fqa = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.fqa = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{fpW, fpW, fpW, fpW, fpW, fpW, fpW, fpW});
        this.fsf = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.fsf.setForbidAutoUpdateState(true);
        this.fsa = (TbImageView) findViewById(R.id.cover);
        this.fsa.setBackgroundColor(0);
        this.fsa.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.fsa.setConrers(15);
        this.fsb = (HeadImageView) findViewById(R.id.head_img);
        this.fsb.setAutoChangeStyle(false);
        this.fsb.setClickable(true);
        this.fsb.setIsRound(true);
        this.fsb.setBorderWidth(com.baidu.adp.lib.util.l.getDimens(getContext(), R.dimen.tbds1));
        this.fsc = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.dEL = (TextView) findViewById(R.id.user_name);
        this.fsd = (TextView) findViewById(R.id.audience_count);
        this.fse = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.fqa);
        gradientDrawable.setCornerRadii(fsh);
        this.fse.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.fsg);
                if (TabLiveStageLiveView.this.mType != 101) {
                    if (TabLiveStageLiveView.this.mType == 102) {
                        ao aoVar = new ao("c13559");
                        aoVar.dk("entryname", "推荐");
                        TiebaStatic.log(aoVar);
                        return;
                    }
                    return;
                }
                ao aoVar2 = new ao("c13556");
                aoVar2.dk("entryname", "推荐");
                TiebaStatic.log(aoVar2);
            }
        });
        buo();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.fsg = sdkLiveInfoData;
        this.mType = i;
        this.fsa.setPlaceHolder(3);
        this.fsa.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ae.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ae.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.dEL.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.fsb, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.fsc.setVisibility(0);
            } else {
                this.fsc.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.fsd.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, ar.cm(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.dEL, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.fsd, (int) R.color.cp_cont_a);
        Drawable drawable = an.getDrawable(getContext().getResources(), (int) R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.fsd.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.fsd.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void buo() {
        try {
            this.fsf.setAnimation("zan_lottie_anim.json");
            this.fsf.setImageAssetsFolder("images/");
            this.fsf.loop(true);
            this.fsf.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.fsf != null && !this.fsf.isAnimating()) {
            this.fsf.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fsf != null && this.fsf.isAnimating()) {
            this.fsf.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
