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
import com.baidu.live.utils.k;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmItemView extends LinearLayout {
    public TextView avN;
    public ALALevelView fGA;
    public TextView fGB;
    public TextView fGw;
    public ImageView fGx;
    public HeadImageView fGy;
    public TbImageView fGz;

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
            this.fGw.setTextColor(-838860801);
            this.fGz.setVisibility(0);
        } else {
            this.fGw.setTextColor(1728053247);
            this.fGz.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fGw.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fGw.setVisibility(0);
            this.fGx.setVisibility(8);
        } else {
            this.fGw.setVisibility(8);
            this.fGx.setVisibility(0);
        }
        if (this.fGw.getText() != null) {
            TextView textView = this.fGw;
            if (this.fGw.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fGy, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fGz.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fGz.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fGz.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.avN.setText(str);
        switch (i) {
            case 1:
                this.fGB.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fGB.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fGB.setText("");
                    return;
                }
            default:
                return;
        }
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(a.h.sdk_charm_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.e.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.e.sdk_ds36), dimensionPixelOffset);
        Ad();
        initView();
    }

    private void Ad() {
        this.fGw = (TextView) findViewById(a.g.tv_rank);
        this.fGx = (ImageView) findViewById(a.g.iv_rank);
        this.fGy = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fGz = (TbImageView) findViewById(a.g.iv_pendant);
        this.fGA = (ALALevelView) findViewById(a.g.level);
        this.avN = (TextView) findViewById(a.g.tv_name);
        this.fGB = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fGy.setAutoChangeStyle(false);
        this.fGy.setDrawBorder(false);
        this.fGy.setIsRound(true);
        this.fGz.setDefaultBgResource(a.d.sdk_transparent);
        this.fGz.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
