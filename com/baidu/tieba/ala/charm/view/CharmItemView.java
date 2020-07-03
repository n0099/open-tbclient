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
/* loaded from: classes3.dex */
public class CharmItemView extends LinearLayout {
    public TextView aXZ;
    public TextView fBm;
    public ImageView fBn;
    public HeadImageView fBo;
    public TbImageView fBp;
    public ALALevelView fBq;
    public TextView fBr;

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
            this.fBm.setTextColor(-838860801);
            this.fBp.setVisibility(0);
        } else {
            this.fBm.setTextColor(1728053247);
            this.fBp.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.fBm.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.fBm.setVisibility(0);
            this.fBn.setVisibility(8);
        } else {
            this.fBm.setVisibility(8);
            this.fBn.setVisibility(0);
        }
        if (this.fBm.getText() != null) {
            TextView textView = this.fBm;
            if (this.fBm.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        k.a(this.fBo, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.fBp.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.fBp.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.fBp.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aXZ.setText(str);
        switch (i) {
            case 1:
                this.fBr.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.fBr.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.fBr.setText("");
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
        zB();
        initView();
    }

    private void zB() {
        this.fBm = (TextView) findViewById(a.g.tv_rank);
        this.fBn = (ImageView) findViewById(a.g.iv_rank);
        this.fBo = (HeadImageView) findViewById(a.g.iv_avatar);
        this.fBp = (TbImageView) findViewById(a.g.iv_pendant);
        this.fBq = (ALALevelView) findViewById(a.g.level);
        this.aXZ = (TextView) findViewById(a.g.tv_name);
        this.fBr = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.fBo.setAutoChangeStyle(false);
        this.fBo.setDrawBorder(false);
        this.fBo.setIsRound(true);
        this.fBp.setDefaultBgResource(a.d.sdk_transparent);
        this.fBp.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
