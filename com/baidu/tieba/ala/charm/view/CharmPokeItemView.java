package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.m;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes11.dex */
public class CharmPokeItemView extends LinearLayout {
    public TextView aDM;
    public TextView gPF;
    public ImageView gPG;
    public HeadImageView gPH;
    public TbImageView gPI;
    public ALALevelView gPJ;
    public TextView gPK;
    public TextView gPL;

    public CharmPokeItemView(Context context) {
        this(context, null);
    }

    public CharmPokeItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2, int i3, final long j3, final String str3) {
        float dimensionPixelSize;
        this.gPF.setVisibility(8);
        this.gPG.setVisibility(8);
        this.gPI.setVisibility(0);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gPG.setVisibility(0);
                    this.gPG.setBackgroundResource(a.e.sdk_icon_live_list_first);
                    this.gPI.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gPG.setVisibility(0);
                    this.gPG.setBackgroundResource(a.e.sdk_icon_live_list_second);
                    this.gPI.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gPG.setVisibility(0);
                    this.gPG.setBackgroundResource(a.e.sdk_icon_live_list_third);
                    this.gPI.setImageResource(a.e.pic_live_list_top3);
                    break;
                default:
                    this.gPF.setVisibility(0);
                    this.gPF.setTextColor(1728053247);
                    this.gPF.setText(i2 + "");
                    this.gPI.setVisibility(8);
                    if (this.gPF.getText() != null) {
                        TextView textView = this.gPF;
                        if (this.gPF.getText().length() > 3) {
                            dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize24);
                        } else {
                            dimensionPixelSize = getResources().getDimensionPixelSize(a.d.sdk_fontsize36);
                        }
                        textView.setTextSize(0, dimensionPixelSize);
                        break;
                    }
                    break;
            }
        } else {
            this.gPI.setVisibility(8);
            this.gPG.setBackgroundResource(a.e.sdk_charm_no_listed);
            this.gPG.setVisibility(0);
        }
        m.a(this.gPH, str2, true, false);
        this.aDM.setText(str);
        switch (i) {
            case 1:
                this.gPK.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                break;
            case 2:
                this.gPK.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                break;
        }
        if (i3 == 0) {
            this.gPL.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.gPL.setEnabled(false);
            this.gPL.setText(getResources().getString(a.h.sdk_poke_had_poked));
        }
        if (i3 == 2) {
            this.gPL.setEnabled(true);
            this.gPL.setText(getResources().getString(a.h.sdk_poke_not_poke));
        }
        this.gPL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.CharmPokeItemView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913267, ""));
                UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", UbcStatConstant.Value.VALUE_HOST_POKE));
                HttpMessage httpMessage = new HttpMessage(1021227);
                httpMessage.addParam("poke_user_id", j3);
                httpMessage.addParam("live_id", str3);
                MessageManager.getInstance().sendMessage(httpMessage);
            }
        });
    }

    protected final void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_poke_item, (ViewGroup) this, true);
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
        this.gPL = (TextView) findViewById(a.f.poke);
    }

    protected void initView() {
        this.gPH.setAutoChangeStyle(false);
        this.gPH.setDrawBorder(false);
        this.gPH.setIsRound(true);
        this.gPI.setDefaultBgResource(a.c.sdk_transparent);
        this.gPI.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
