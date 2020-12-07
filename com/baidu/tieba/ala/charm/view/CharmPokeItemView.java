package com.baidu.tieba.ala.charm.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
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
import com.baidu.live.utils.l;
import com.baidu.live.view.ALALevelView;
/* loaded from: classes4.dex */
public class CharmPokeItemView extends LinearLayout {
    public TextView aGv;
    public TextView gFE;
    public ImageView gFF;
    public HeadImageView gFG;
    public TbImageView gFH;
    public ALALevelView gFI;
    public TextView gFJ;
    public TextView gFK;

    public CharmPokeItemView(Context context) {
        this(context, null);
    }

    public CharmPokeItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2, int i3, final long j3, final String str3) {
        float dimensionPixelSize;
        this.gFE.setVisibility(8);
        this.gFF.setVisibility(8);
        this.gFH.setVisibility(0);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gFF.setVisibility(0);
                    this.gFF.setBackgroundResource(a.e.sdk_icon_live_list_first);
                    this.gFH.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gFF.setVisibility(0);
                    this.gFF.setBackgroundResource(a.e.sdk_icon_live_list_second);
                    this.gFH.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gFF.setVisibility(0);
                    this.gFF.setBackgroundResource(a.e.sdk_icon_live_list_third);
                    this.gFH.setImageResource(a.e.pic_live_list_top3);
                    break;
                default:
                    this.gFE.setVisibility(0);
                    this.gFE.setTextColor(1728053247);
                    this.gFE.setText(i2 + "");
                    this.gFH.setVisibility(8);
                    if (this.gFE.getText() != null) {
                        TextView textView = this.gFE;
                        if (this.gFE.getText().length() > 3) {
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
            this.gFH.setVisibility(8);
            this.gFF.setBackgroundResource(a.e.sdk_charm_no_listed);
            this.gFF.setVisibility(0);
        }
        l.a(this.gFG, str2, true, false);
        this.aGv.setText(str);
        switch (i) {
            case 1:
                this.gFJ.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                break;
            case 2:
                this.gFJ.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                break;
        }
        if (i3 == 0) {
            this.gFK.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.gFK.setEnabled(false);
            this.gFK.setText(getResources().getString(a.h.sdk_poke_had_poked));
        }
        if (i3 == 2) {
            this.gFK.setEnabled(true);
            this.gFK.setText(getResources().getString(a.h.sdk_poke_not_poke));
        }
        this.gFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.CharmPokeItemView.1
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

    protected void init() {
        LayoutInflater.from(getContext()).inflate(a.g.sdk_charm_poke_item, (ViewGroup) this, true);
        setOrientation(0);
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds8);
        setPadding(getResources().getDimensionPixelOffset(a.d.sdk_ds18), dimensionPixelOffset, getResources().getDimensionPixelOffset(a.d.sdk_ds36), dimensionPixelOffset);
        Jh();
        initView();
    }

    protected void Jh() {
        this.gFE = (TextView) findViewById(a.f.tv_rank);
        this.gFF = (ImageView) findViewById(a.f.iv_rank);
        this.gFG = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gFH = (TbImageView) findViewById(a.f.iv_pendant);
        this.gFI = (ALALevelView) findViewById(a.f.level);
        this.aGv = (TextView) findViewById(a.f.tv_name);
        this.gFJ = (TextView) findViewById(a.f.tv_value);
        this.gFK = (TextView) findViewById(a.f.poke);
    }

    protected void initView() {
        this.gFG.setAutoChangeStyle(false);
        this.gFG.setDrawBorder(false);
        this.gFG.setIsRound(true);
        this.gFH.setDefaultBgResource(a.c.sdk_transparent);
        this.gFH.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
