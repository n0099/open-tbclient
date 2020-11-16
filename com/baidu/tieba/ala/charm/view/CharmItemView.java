package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmItemView extends LinearLayout {
    public TextView aDP;
    public TextView gwT;
    public ImageView gwU;
    public HeadImageView gwV;
    public TbImageView gwW;
    public ALALevelView gwX;
    public TextView gwY;

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
            this.gwT.setTextColor(-838860801);
            this.gwW.setVisibility(0);
        } else {
            this.gwT.setTextColor(1728053247);
            this.gwW.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gwT.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gwT.setVisibility(0);
            this.gwU.setVisibility(8);
        } else {
            this.gwT.setVisibility(8);
            this.gwU.setVisibility(0);
        }
        if (this.gwT.getText() != null) {
            TextView textView = this.gwT;
            if (this.gwT.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.gwV, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gwW.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gwW.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gwW.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aDP.setText(str);
        switch (i) {
            case 1:
                this.gwY.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gwY.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gwY.setText("");
                    return;
                }
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Hq();
        initView();
    }

    private void Hq() {
        this.gwT = (TextView) findViewById(a.f.tv_rank);
        this.gwU = (ImageView) findViewById(a.f.iv_rank);
        this.gwV = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gwW = (TbImageView) findViewById(a.f.iv_pendant);
        this.gwX = (ALALevelView) findViewById(a.f.level);
        this.aDP = (TextView) findViewById(a.f.tv_name);
        this.gwY = (TextView) findViewById(a.f.tv_value);
    }

    private void initView() {
        this.gwV.setAutoChangeStyle(false);
        this.gwV.setDrawBorder(false);
        this.gwV.setIsRound(true);
        this.gwW.setDefaultBgResource(a.c.sdk_transparent);
        this.gwW.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
