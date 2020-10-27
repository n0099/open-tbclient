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
    public TextView aEK;
    public TextView gAr;
    public HeadImageView gCW;
    public TbImageView gCX;
    public ImageView gCY;
    public ImageView gCZ;
    public TextView gDa;
    public ProgressBar gDb;
    public TextView gDc;
    public LinearLayout gDd;
    public TextView gDe;
    public TextView gDf;
    public LinearLayout gDg;
    public TextView gDh;
    public TextView gry;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aEK.setTypeface(Typeface.defaultFromStyle(0));
                this.gAr.setTypeface(Typeface.defaultFromStyle(0));
                this.gDc.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.gDf.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.gry.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aEK.setTypeface(Typeface.defaultFromStyle(1));
                this.gAr.setTypeface(Typeface.defaultFromStyle(1));
                this.gDc.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.gDf.setTextColor(-11337753);
                this.gry.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gCW = (HeadImageView) findViewById(a.g.header_imageView);
        this.gCX = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aEK = (TextView) findViewById(a.g.name_textView);
        this.gAr = (TextView) findViewById(a.g.nameSuffix_textView);
        this.gCY = (ImageView) findViewById(a.g.edit_imageView);
        this.gCZ = (ImageView) findViewById(a.g.explain_imageView);
        this.gDa = (TextView) findViewById(a.g.score_textView);
        this.gDb = (ProgressBar) findViewById(a.g.score_progressBar);
        this.gDc = (TextView) findViewById(a.g.next_textView);
        this.gDd = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.gDe = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.gDf = (TextView) findViewById(a.g.memberNum_textView);
        this.gDg = (LinearLayout) findViewById(a.g.rank_layout);
        this.gDh = (TextView) findViewById(a.g.rankTitle_textView);
        this.gry = (TextView) findViewById(a.g.rank_textView);
    }
}
