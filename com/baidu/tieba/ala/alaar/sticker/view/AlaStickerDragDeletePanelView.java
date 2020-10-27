package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private TextView fYA;
    private TextView fYB;
    private View fYC;
    private View fYD;
    private View fYE;
    private RelativeLayout fYx;
    private View fYy;
    private ImageView fYz;

    public AlaStickerDragDeletePanelView(Context context) {
        super(context);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public AlaStickerDragDeletePanelView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(getContext()).inflate(a.h.ala_sticker_delete_panel, this);
        this.fYx = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fYy = findViewById(a.g.delete_panel_top_bg);
        this.fYC = findViewById(a.g.delete_panel_delete_info);
        this.fYz = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fYA = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fYD = findViewById(a.g.delete_panel_im);
        this.fYE = findViewById(a.g.delete_panel_im_right);
        this.fYB = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void lk(boolean z) {
        if (z) {
            this.fYy.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fYz.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fYA.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fYy.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fYz.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fYA.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYx.getLayoutParams();
            layoutParams.height = i;
            this.fYx.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fYx.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fYx.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fYC.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fYC.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fYC.getLayoutParams();
        layoutParams4.addRule(15);
        this.fYC.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fYx.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYB.getLayoutParams();
            layoutParams.height = i;
            this.fYB.setLayoutParams(layoutParams);
        }
    }

    public int getTopDeletePanelHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.e.sdk_ds184);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return getResources().getDimensionPixelOffset(a.e.sdk_ds184) + UtilHelper.getImmersiveStickyBarHeight();
        }
        return dimensionPixelOffset;
    }

    public void setImMsgViewSize(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fYD.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fYD.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fYE.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fYE.setLayoutParams(layoutParams2);
    }
}
