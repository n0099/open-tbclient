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
    public TextView aGM;
    public TextView gRr;
    public ImageView gRs;
    public HeadImageView gRt;
    public TbImageView gRu;
    public ALALevelView gRv;
    public TextView gRw;
    public TextView gRx;

    public CharmPokeItemView(Context context) {
        this(context, null);
    }

    public CharmPokeItemView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public void setData(int i, int i2, String str, String str2, long j, long j2, int i3, final long j3, final String str3) {
        float dimensionPixelSize;
        this.gRr.setVisibility(8);
        this.gRs.setVisibility(8);
        this.gRu.setVisibility(0);
        if (i == 2 && j > 0) {
            switch (i2) {
                case 1:
                    this.gRs.setVisibility(0);
                    this.gRs.setBackgroundResource(a.e.sdk_icon_live_list_first);
                    this.gRu.setImageResource(a.e.pic_live_list_top1);
                    break;
                case 2:
                    this.gRs.setVisibility(0);
                    this.gRs.setBackgroundResource(a.e.sdk_icon_live_list_second);
                    this.gRu.setImageResource(a.e.pic_live_list_top2);
                    break;
                case 3:
                    this.gRs.setVisibility(0);
                    this.gRs.setBackgroundResource(a.e.sdk_icon_live_list_third);
                    this.gRu.setImageResource(a.e.pic_live_list_top3);
                    break;
                default:
                    this.gRr.setVisibility(0);
                    this.gRr.setTextColor(1728053247);
                    this.gRr.setText(i2 + "");
                    this.gRu.setVisibility(8);
                    if (this.gRr.getText() != null) {
                        TextView textView = this.gRr;
                        if (this.gRr.getText().length() > 3) {
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
            this.gRu.setVisibility(8);
            this.gRs.setBackgroundResource(a.e.sdk_charm_no_listed);
            this.gRs.setVisibility(0);
        }
        m.a(this.gRt, str2, true, false);
        this.aGM.setText(str);
        switch (i) {
            case 1:
                this.gRw.setText(String.format(getResources().getString(a.h.sdk_charm_rank_forward_diff), StringHelper.formatValue(j2)));
                break;
            case 2:
                this.gRw.setText(String.format("%s 魅力", StringHelper.formatValue(j)));
                break;
        }
        if (i3 == 0) {
            this.gRx.setVisibility(8);
            return;
        }
        if (i3 == 1) {
            this.gRx.setEnabled(false);
            this.gRx.setText(getResources().getString(a.h.sdk_poke_had_poked));
        }
        if (i3 == 2) {
            this.gRx.setEnabled(true);
            this.gRx.setText(getResources().getString(a.h.sdk_poke_not_poke));
        }
        this.gRx.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.charm.view.CharmPokeItemView.1
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
        IJ();
        initView();
    }

    protected void IJ() {
        this.gRr = (TextView) findViewById(a.f.tv_rank);
        this.gRs = (ImageView) findViewById(a.f.iv_rank);
        this.gRt = (HeadImageView) findViewById(a.f.iv_avatar);
        this.gRu = (TbImageView) findViewById(a.f.iv_pendant);
        this.gRv = (ALALevelView) findViewById(a.f.level);
        this.aGM = (TextView) findViewById(a.f.tv_name);
        this.gRw = (TextView) findViewById(a.f.tv_value);
        this.gRx = (TextView) findViewById(a.f.poke);
    }

    protected void initView() {
        this.gRt.setAutoChangeStyle(false);
        this.gRt.setDrawBorder(false);
        this.gRt.setIsRound(true);
        this.gRu.setDefaultBgResource(a.c.sdk_transparent);
        this.gRu.setDefaultErrorResource(a.e.sdk_shape_transparent);
    }
}
