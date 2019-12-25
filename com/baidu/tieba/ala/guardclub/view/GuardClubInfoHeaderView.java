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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class GuardClubInfoHeaderView extends LinearLayout {
    public TextView aqC;
    public TextView eAY;
    public HeadImageView eCJ;
    public TbImageView eCK;
    public ImageView eCL;
    public ImageView eCM;
    public TextView eCN;
    public ProgressBar eCO;
    public TextView eCP;
    public LinearLayout eCQ;
    public TextView eCR;
    public TextView eCS;
    public LinearLayout eCT;
    public TextView eCU;
    public TextView ezB;

    public GuardClubInfoHeaderView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setStyle(int i) {
        switch (i) {
            case 0:
                setBackgroundColor(0);
                setPadding(0, 0, 0, 0);
                this.aqC.setTypeface(Typeface.defaultFromStyle(0));
                this.ezB.setTypeface(Typeface.defaultFromStyle(0));
                this.eCP.setTextColor(getResources().getColor(a.d.sdk_white_alpha60));
                this.eCS.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                this.eAY.setTextColor(getResources().getColor(a.d.sdk_white_alpha100));
                return;
            case 1:
                setBackgroundResource(a.f.guard_club_info_header_card_bg);
                setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds30), getResources().getDimensionPixelOffset(a.e.sdk_ds32), getResources().getDimensionPixelOffset(a.e.sdk_ds56), getResources().getDimensionPixelOffset(a.e.sdk_ds30));
                this.aqC.setTypeface(Typeface.defaultFromStyle(1));
                this.ezB.setTypeface(Typeface.defaultFromStyle(1));
                this.eCP.setTextColor(getResources().getColor(a.d.sdk_white_alpha80));
                this.eCS.setTextColor(-11337753);
                this.eAY.setTextColor(-11337753);
                return;
            default:
                return;
        }
    }

    private void init() {
        setOrientation(0);
        LayoutInflater.from(getContext()).inflate(a.h.live_guard_club_widget_info_header, (ViewGroup) this, true);
        this.eCJ = (HeadImageView) findViewById(a.g.header_imageView);
        this.eCK = (TbImageView) findViewById(a.g.headwear_imageView);
        this.aqC = (TextView) findViewById(a.g.name_textView);
        this.ezB = (TextView) findViewById(a.g.nameSuffix_textView);
        this.eCL = (ImageView) findViewById(a.g.edit_imageView);
        this.eCM = (ImageView) findViewById(a.g.explain_imageView);
        this.eCN = (TextView) findViewById(a.g.score_textView);
        this.eCO = (ProgressBar) findViewById(a.g.score_progressBar);
        this.eCP = (TextView) findViewById(a.g.next_textView);
        this.eCQ = (LinearLayout) findViewById(a.g.memberNum_layout);
        this.eCR = (TextView) findViewById(a.g.memberNumTitle_textView);
        this.eCS = (TextView) findViewById(a.g.memberNum_textView);
        this.eCT = (LinearLayout) findViewById(a.g.rank_layout);
        this.eCU = (TextView) findViewById(a.g.rankTitle_textView);
        this.eAY = (TextView) findViewById(a.g.rank_textView);
    }
}
