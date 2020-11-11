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
    private RelativeLayout gep;
    private View geq;
    private ImageView ger;
    private TextView ges;
    private TextView get;
    private View geu;
    private View gev;
    private View gew;

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
        this.gep = (RelativeLayout) findViewById(a.f.delete_panel_top);
        this.geq = findViewById(a.f.delete_panel_top_bg);
        this.geu = findViewById(a.f.delete_panel_delete_info);
        this.ger = (ImageView) findViewById(a.f.delete_panel_delete_img);
        this.ges = (TextView) findViewById(a.f.delete_panel_delete_text);
        this.gev = findViewById(a.f.delete_panel_im);
        this.gew = findViewById(a.f.delete_panel_im_right);
        this.get = (TextView) findViewById(a.f.delete_panel_bottom);
    }

    public void lt(boolean z) {
        if (z) {
            this.geq.setBackgroundResource(a.c.color_live_sticker_red_40);
            this.ger.setBackgroundResource(a.e.icon_live_paste_delete_on_n);
            this.ges.setText(a.h.ala_live_sticker_delete);
            return;
        }
        this.geq.setBackgroundResource(a.c.color_live_sticker_red_50);
        this.ger.setBackgroundResource(a.e.icon_live_paste_delete_n);
        this.ges.setText(a.h.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.d.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gep.getLayoutParams();
            layoutParams.height = i;
            this.gep.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gep.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.gep.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.geu.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.d.sdk_ds40);
            this.geu.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.geu.getLayoutParams();
        layoutParams4.addRule(15);
        this.geu.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.gep.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.get.getLayoutParams();
            layoutParams.height = i;
            this.get.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gev.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.gev.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.gew.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.gew.setLayoutParams(layoutParams2);
    }
}
