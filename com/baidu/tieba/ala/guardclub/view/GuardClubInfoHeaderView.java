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
/* loaded from: classes7.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aAP;
    public TextView fRN;
    public TextView gaF;
    public HeadImageView gdn;
    public TbImageView gdo;
    public ImageView gdp;
    public ImageView gdq;
    public TextView gdr;
    public ProgressBar gds;
    public TextView gdt;
    public LinearLayout gdu;
    public TextView gdv;
    public TextView gdw;
    public LinearLayout gdx;
    public TextView gdy;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aAP.setTypeface(Typeface.defaultFromStyle(0));
                this.gaF.setTypeface(Typeface.defaultFromStyle(0));
                this.gdt.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.gdw.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.fRN.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aAP.setTypeface(Typeface.defaultFromStyle(1));
                this.gaF.setTypeface(Typeface.defaultFromStyle(1));
                this.gdt.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.gdw.setTextColor(-11337753);
                this.fRN.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.gdn = (HeadImageView) findViewById(a.g.header_imageView);
        this.gdo = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aAP = (TextView) findViewById(a.g.name_textView);
        this.gaF = (TextView) findViewById(a.g.nameSuffix_textView);
        this.gdp = (ImageView) findViewById(a.g.edit_imageView);
        this.gdq = (ImageView) findViewById(a.g.explain_imageView);
        this.gdr = (TextView) findViewById(a.g.score_textView);
        this.gds = (ProgressBar) findViewById(a.g.score_progressBar);
        this.gdt = (TextView) findViewById(a.g.next_textView);
        this.gdu = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.gdv = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.gdw = (TextView) findViewById(a.g.memberNum_textView);
        this.gdx = (LinearLayout) findViewById(a.g.rank_layout);
        this.gdy = (TextView) findViewById(a.g.rankTitle_textView);
        this.fRN = (TextView) findViewById(a.g.rank_textView);
    }
}
