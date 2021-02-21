package com.baidu.tieba.ala.alaar.sticker.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes11.dex */
public class AlaStickerDragDeletePanelView extends RelativeLayout {
    private RelativeLayout guV;
    private View guW;
    private ImageView guX;
    private TextView guY;
    private TextView guZ;
    private View gva;
    private View gvb;
    private View gvc;

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
        LayoutInflater.from(getContext()).inflate(a.g.ala_sticker_delete_panel, this);
        this.guV = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.guW = findViewById(a.f.delete_panel_top_bg);
        this.gva = findViewById(a.f.delete_panel_delete_info);
        this.guX = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.guY = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gvb = findViewById(a.f.delete_panel_im);
        this.gvc = findViewById(a.f.delete_panel_im_right);
        this.guZ = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void mm(boolean z) {
        if (z) {
            this.guW.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.guX.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.guY.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.guW.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.guX.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.guY.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guV.getLayoutParams();
            layoutParams.height = i;
            this.guV.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.guV.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.guV.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.gva.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.gva.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.gva.getLayoutParams();
        layoutParams4.addRule(15);
        this.gva.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.guV.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.guZ.getLayoutParams();
            layoutParams.height = i;
            this.guZ.setLayoutParams(layoutParams);
        }
    }

    public int getTopDeletePanelHeight() {
        int dimensionPixelOffset = getResources().getDimensionPixelOffset(a.d.sdk_ds184);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            return getResources().getDimensionPixelOffset(a.d.sdk_ds184) + UtilHelper.getImmersiveStickyBarHeight();
        }
        return dimensionPixelOffset;
    }

    public void setImMsgViewSize(int i, int i2) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gvb.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gvb.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gvc.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gvc.setLayoutParams(layoutParams2);
    }
}
