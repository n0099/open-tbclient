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
    public TextView gPF;
    public ImageView gPG;
    public HeadImageView gPH;
    public TbImageView gPI;
    public ALALevelView gPJ;
    public TextView gPK;

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
            this.gPF.setTextColor(-838860801);
            this.gPI.setVisibility(0);
        } else {
            this.gPF.setTextColor(1728053247);
            this.gPI.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gPF.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gPF.setVisibility(0);
            this.gPG.setVisibility(8);
        } else {
            this.gPF.setVisibility(8);
            this.gPG.setVisibility(0);
        }
        if (this.gPF.getText() != null) {
            TextView textView = this.gPF;
            if (this.gPF.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        m.a(this.gPH, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gPI.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gPI.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gPI.setImageResource(a.e.pic_live_list_top3);
                    break;
            }
        }
        this.aDM.setText(str);
        switch (i) {
            case 1:
                this.gPK.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.gPK.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.gPK.setText("");
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
        this.gPF = (TextView) findViewById(a.f.tv_rank);
        this.gPG = (ImageView) findViewById(a.f.iv_rank);
        this.gPH = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gPI = (TbImageView) findViewById(a.f.iv_pendant);
        this.gPJ = (ALALevelView) findViewById(a.f.level);
        this.aDM = (TextView) findViewById(a.f.tv_name);
        this.gPK = (TextView) findViewById(a.f.tv_value);
    }

    protected void initView() {
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setIsRound(true);
        this.gPI.setDefaultBgResource(a.c.sdk_transparent);
        this.gPI.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
