package com.baidu.tieba.ala.guardclub.view;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes4.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aBx;
    public TextView fVc;
    public TextView gdW;
    public HeadImageView ggD;
    public TbImageView ggE;
    public ImageView ggF;
    public ImageView ggG;
    public TextView ggH;
    public ProgressBar ggI;
    public TextView ggJ;
    public LinearLayout ggK;
    public TextView ggL;
    public TextView ggM;
    public LinearLayout ggN;
    public TextView ggO;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aBx.setTypeface(Typeface.defaultFromStyle(0));
                this.gdW.setTypeface(Typeface.defaultFromStyle(0));
                this.ggJ.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.ggM.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fVc.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aBx.setTypeface(Typeface.defaultFromStyle(1));
                this.gdW.setTypeface(Typeface.defaultFromStyle(1));
                this.ggJ.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.ggM.setTextColor(-11337753);
                this.fVc.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.ggD = (HeadImageView) findViewById(a.g.header_imageView);
        this.ggE = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aBx = (TextView) findViewById(a.g.name_textView);
        this.gdW = (TextView) findViewById(a.g.nameSuffix_textView);
        this.ggF = (ImageView) findViewById(a.g.edit_imageView);
        this.ggG = (ImageView) findViewById(a.g.explain_imageView);
        this.ggH = (TextView) findViewById(a.g.score_textView);
        this.ggI = (ProgressBar) findViewById(a.g.score_progressBar);
        this.ggJ = (TextView) findViewById(a.g.next_textView);
        this.ggK = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.ggL = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.ggM = (TextView) findViewById(a.g.memberNum_textView);
        this.ggN = (LinearLayout) findViewById(a.g.rank_layout);
        this.ggO = (TextView) findViewById(a.g.rankTitle_textView);
        this.fVc = (TextView) findViewById(a.g.rank_textView);
    }
}
