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
    private static final float gDg = TbadkCoreApplication.getInst().getResources().getDimension(R.dimen.tbds20);
    private static final float[] gFw = {0.0f, 0.0f, 0.0f, 0.0f, gDg, gDg, gDg, gDg};
    private TextView eIO;
    private int[] gDk;
    private TbImageView gFp;
    private HeadImageView gFq;
    private View gFr;
    private TextView gFs;
    private View gFt;
    private TabLiveStageLiveZanLottieView gFu;
    private SdkLiveInfoData gFv;
    private TextView mTitle;
    private int mType;

    public TabLiveStageLiveView(Context context) {
        super(context);
        this.mType = 101;
        this.gDk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mType = 101;
        this.gDk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    public TabLiveStageLiveView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mType = 101;
        this.gDk = new int[]{TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha0), TbadkCoreApplication.getInst().getResources().getColor(R.color.black_alpha50)};
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.tab_stage_view, this);
        setRoundLayoutRadius(new float[]{gDg, gDg, gDg, gDg, gDg, gDg, gDg, gDg});
        this.gFu = (TabLiveStageLiveZanLottieView) findViewById(R.id.zan_lottie_view);
        this.gFu.setForbidAutoUpdateState(true);
        this.gFp = (TbImageView) findViewById(R.id.cover);
        this.gFp.setBackgroundColor(0);
        this.gFp.setRadius(getContext().getResources().getDimensionPixelSize(R.dimen.tbds20));
        this.gFp.setConrers(15);
        this.gFq = (HeadImageView) findViewById(R.id.head_img);
        this.gFq.setAutoChangeStyle(false);
        this.gFq.setClickable(true);
        this.gFq.setIsRound(true);
        this.gFq.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
        this.gFr = findViewById(R.id.head_mask_view);
        this.mTitle = (TextView) findViewById(R.id.title);
        this.eIO = (TextView) findViewById(R.id.user_name);
        this.gFs = (TextView) findViewById(R.id.audience_count);
        this.gFt = findViewById(R.id.bottom_gradient_bg);
        GradientDrawable gradientDrawable = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, this.gDk);
        gradientDrawable.setCornerRadii(gFw);
        this.gFt.setBackgroundDrawable(gradientDrawable);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.TabLiveStageLiveView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.tieba.ala.alasquare.live_tab.c.a(TabLiveStageLiveView.this.getContext(), TabLiveStageLiveView.this.gFv);
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
        bSd();
    }

    public void setData(SdkLiveInfoData sdkLiveInfoData, int i) {
        if (sdkLiveInfoData == null || sdkLiveInfoData.liveInfo == null) {
            setVisibility(4);
            return;
        }
        this.gFv = sdkLiveInfoData;
        this.mType = i;
        this.gFp.setPlaceHolder(3);
        this.gFp.startLoad(sdkLiveInfoData.liveInfo.cover, 10, false);
        if (sdkLiveInfoData.liveAuthor != null) {
            String name_show = sdkLiveInfoData.liveAuthor.getName_show();
            if (ag.getTextLengthWithEmoji(name_show) > 16) {
                name_show = ag.subStringWithEmoji(name_show, 16) + StringHelper.STRING_MORE;
            }
            this.eIO.setText(name_show);
            AlaUtilHelper.startLoadPortrait(this.gFq, sdkLiveInfoData.liveAuthor.portrait, false);
            if (1 == TbadkCoreApplication.getInst().getSkinType()) {
                this.gFr.setVisibility(0);
            } else {
                this.gFr.setVisibility(8);
            }
        }
        this.mTitle.setText(sdkLiveInfoData.title);
        this.gFs.setText(getContext().getResources().getString(R.string.square_sub_live_audience_label, au.eb(sdkLiveInfoData.liveInfo.audienceCount)));
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.eIO, R.color.CAM_X0101);
        ap.setViewTextColor(this.gFs, R.color.CAM_X0101);
        Drawable drawable = ap.getDrawable(getContext().getResources(), R.drawable.tab_icon_living_seeding);
        drawable.setBounds(0, 0, getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18), getContext().getResources().getDimensionPixelOffset(R.dimen.tbds18));
        this.gFs.setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        this.gFs.setCompoundDrawablePadding(getContext().getResources().getDimensionPixelOffset(R.dimen.tbds8));
    }

    private void bSd() {
        try {
            this.gFu.setAnimation("zan_lottie_anim.json");
            this.gFu.setImageAssetsFolder("images/");
            this.gFu.loop(true);
            this.gFu.playAnimation();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (this.gFu != null && !this.gFu.isAnimating()) {
            this.gFu.playAnimation();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gFu != null && this.gFu.isAnimating()) {
            this.gFu.pauseAnimation();
        }
        super.onDetachedFromWindow();
    }
}
