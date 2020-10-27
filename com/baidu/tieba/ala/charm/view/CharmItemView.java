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
    public TextView aEK;
    public HeadImageView grA;
    public TbImageView grB;
    public ALALevelView grC;
    public TextView grD;
    public TextView gry;
    public ImageView grz;

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
            this.gry.setTextColor(-838860801);
            this.grB.setVisibility(0);
        } else {
            this.gry.setTextColor(1728053247);
            this.grB.setVisibility(8);
        }
        if (i == 1 || (i == 2 && i2 >= 1 && j > 0)) {
            this.gry.setText(i2 <= 100 ? String.valueOf(i2) : "100+");
            this.gry.setVisibility(0);
            this.grz.setVisibility(8);
        } else {
            this.gry.setVisibility(8);
            this.grz.setVisibility(0);
        }
        if (this.gry.getText() != null) {
            TextView textView = this.gry;
            if (this.gry.getText().length() > 3) {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize24);
            } else {
                dimensionPixelSize = getResources().getDimensionPixelSize(a.e.sdk_fontsize36);
            }
            textView.setTextSize(0, dimensionPixelSize);
        }
        l.a(this.grA, str2, true, false);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.grB.setImageResource(a.f.pic_live_list_top1);
                    break;
                case 2:
                    this.grB.setImageResource(a.f.pic_live_list_top2);
                    break;
                case 3:
                    this.grB.setImageResource(a.f.pic_live_list_top3);
                    break;
            }
        }
        this.aEK.setText(str);
        switch (i) {
            case 1:
                this.grD.setText(String.format(getResources().getString(a.i.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                return;
            case 2:
                if (j > 0) {
                    this.grD.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                    return;
                } else {
                    this.grD.setText("");
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
        Hy();
        initView();
    }

    private void Hy() {
        this.gry = (TextView) findViewById(a.g.tv_rank);
        this.grz = (ImageView) findViewById(a.g.iv_rank);
        this.grA = (HeadImageView) findViewById(a.g.iv_avatar);
        this.grB = (TbImageView) findViewById(a.g.iv_pendant);
        this.grC = (ALALevelView) findViewById(a.g.level);
        this.aEK = (TextView) findViewById(a.g.tv_name);
        this.grD = (TextView) findViewById(a.g.tv_value);
    }

    private void initView() {
        this.grA.setAutoChangeStyle(false);
        this.grA.setDrawBorder(false);
        this.grA.setIsRound(true);
        this.grB.setDefaultBgResource(a.d.sdk_transparent);
        this.grB.setDefaultErrorResource(a.f.sdk_shape_transparent);
    }
}
