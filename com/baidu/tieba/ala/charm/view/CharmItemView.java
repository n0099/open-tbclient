package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes11.dex */
public class CharmItemView extends LinearLayout {
    public TextView aDM;
    public TextView gPr;
    public ImageView gPs;
    public HeadImageView gPt;
    public TbImageView gPu;
    public ALALevelView gPv;
    public TextView gPw;

    public CharmItemView(Context context) {
        this(context, null);
    }

    public CharmItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2) {
        float dimensionPixelSize;
        if (i == 2 && i2 >= 1 && i2 <= 3 && j > 0) {
            this.gPr.setTextColor(-838860801);
            this.gPu.setVisibility(0);
        } else {
            this.gPr.setTextColor(1728053247);
            this.gPu.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gPr.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gPr.setVisibility(0);
            this.gPs.setVisibility(8);
        } else {
            this.gPr.setVisibility(8);
            this.gPs.setVisibility(0);
        }
        if (this.gPr.getText() != null) {
            TextView textView = this.gPr;
            if (this.gPr.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        m.a(this.gPt, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gPu.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gPu.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gPu.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aDM.setText(str);
        switch (i) {
            case 1:
                this.gPw.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gPw.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gPw.setText("");
                    return;
                }
            default:
                return;
        }
    }

    protected final void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Ge();
        initView();
    }

    protected void Ge() {
        this.gPr = (TextView) findViewById(a.f.tv_rank);
        this.gPs = (ImageView) findViewById(a.f.iv_rank);
        this.gPt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gPu = (TbImageView) findViewById(a.f.iv_pendant);
        this.gPv = (ALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPw = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gPt.setAutoChangeStyle(false);
        this.gPt.setDrawBorder(false);
        this.gPt.setIsRound(true);
        this.gPu.setDefaultBgResource(a.c.sdk_transparent);
        this.gPu.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
