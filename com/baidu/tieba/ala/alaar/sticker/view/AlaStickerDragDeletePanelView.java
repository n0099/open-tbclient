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
    private RelativeLayout fCV;
    private View fCW;
    private ImageView fCX;
    private TextView fCY;
    private TextView fCZ;
    private View fDa;
    private View fDb;
    private View fDc;

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
        this.fCV = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.fCW = findViewById(a.g.delete_panel_top_bg);
        this.fDa = findViewById(a.g.delete_panel_delete_info);
        this.fCX = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fCY = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.fDb = findViewById(a.g.delete_panel_im);
        this.fDc = findViewById(a.g.delete_panel_im_right);
        this.fCZ = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void kx(boolean z) {
        if (z) {
            this.fCW.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fCX.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fCY.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.fCW.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fCX.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fCY.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCV.getLayoutParams();
            layoutParams.height = i;
            this.fCV.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fCV.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.fCV.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fDa.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fDa.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fDa.getLayoutParams();
        layoutParams4.addRule(15);
        this.fDa.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.fCV.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fCZ.getLayoutParams();
            layoutParams.height = i;
            this.fCZ.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fDb.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.fDb.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fDc.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fDc.setLayoutParams(layoutParams2);
    }
}
