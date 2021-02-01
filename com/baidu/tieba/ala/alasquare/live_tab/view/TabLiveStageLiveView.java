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
/* loaded from: classes10.dex */
public class TabLiveStageLiveView extends AlaRoundRelativeLayout {
    private static final float gCS = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gFi = {0.0f, 0.0f, 0.0f, 0.0f, gCS, gCS, gCS, gCS};
    private TextView eIO;
    private int[] gCW;
    private TbImageView gFb;
    private HeadImageView gFc;
    private View gFd;
    private TextView gFe;
    private View gFf;
    private TabLiveStageLiveZanLottieView gFg;
    private SdkLiveInfoData gFh;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gCW = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gCW = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gCW = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{gCS, gCS, gCS, gCS, gCS, gCS, gCS, gCS});
        this.gFg = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gFg.setForbidAutoUpdateState(true);
        this.gFb = (TbImageView) findViewById(R.id.cover);
        this.gFb.setBackgroundColor(0);
        this.gFb.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gFb.setConrers(15);
        this.gFc = (HeadImageView) findViewById(R.id.head_img);
        this.gFc.setAutoChangeStyle(false);
        this.gFc.setClickable(true);
        this.gFc.setIsRound(true);
        this.gFc.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.gFd = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eIO = (TextView) findViewById(R.id.user_name);
        this.gFe = (TextView) findViewById(R.id.audience_count);
        this.gFf = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gCW);
        gradientDrawable.setCornerRadii(gFi);
        this.gFf.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gFh);
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
        bRW();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gFh = sdkLiveInfoData;
        this.mType = i;
        this.gFb.setPlaceHolder(3);
        this.gFb.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ag.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eIO.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gFc, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gFd.setVisibility(0);
            } else {
                this.gFd.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gFe.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, au.eb(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
        ap.setViewTextColor(this.gFe, R.color.CAM_X0101);
        Drawable drawable = ap.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gFe.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gFe.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bRW() {
        try {
            this.gFg.setAnimation("zan_lottie_anim.json");
            this.gFg.setImageAssetsFolder("images/");
            this.gFg.loop(true);
            this.gFg.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gFg != null && !this.gFg.isAnimating()) {
            this.gFg.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gFg != null && this.gFg.isAnimating()) {
            this.gFg.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
