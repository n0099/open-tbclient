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
    private RelativeLayout foi;
    private View foj;
    private ImageView fok;
    private TextView fol;
    private TextView fom;
    private View fon;
    private View foo;
    private View fop;

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
        this.foi = (RelativeLayout) findViewById(a.g.delete_panel_top);
        this.foj = findViewById(a.g.delete_panel_top_bg);
        this.fon = findViewById(a.g.delete_panel_delete_info);
        this.fok = (ImageView) findViewById(a.g.delete_panel_delete_img);
        this.fol = (TextView) findViewById(a.g.delete_panel_delete_text);
        this.foo = findViewById(a.g.delete_panel_im);
        this.fop = findViewById(a.g.delete_panel_im_right);
        this.fom = (TextView) findViewById(a.g.delete_panel_bottom);
    }

    public void jV(boolean z) {
        if (z) {
            this.foj.setBackgroundResource(a.d.color_live_sticker_red_40);
            this.fok.setBackgroundResource(a.f.icon_live_paste_delete_on_n);
            this.fol.setText(a.i.ala_live_sticker_delete);
            return;
        }
        this.foj.setBackgroundResource(a.d.color_live_sticker_red_50);
        this.fok.setBackgroundResource(a.f.icon_live_paste_delete_n);
        this.fol.setText(a.i.ala_live_sticker_delete_move);
    }

    public void setTopDeletePanelHeight(int i) {
        if (i > getResources().getDimensionPixelOffset(a.e.sdk_ds30)) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foi.getLayoutParams();
            layoutParams.height = i;
            this.foi.setLayoutParams(layoutParams);
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.foi.getLayoutParams();
            layoutParams2.height = getTopDeletePanelHeight();
            this.foi.setLayoutParams(layoutParams2);
        }
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.fon.getLayoutParams();
            layoutParams3.addRule(12);
            layoutParams3.bottomMargin = getResources().getDimensionPixelOffset(a.e.sdk_ds40);
            this.fon.setLayoutParams(layoutParams3);
            return;
        }
        RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.fon.getLayoutParams();
        layoutParams4.addRule(15);
        this.fon.setLayoutParams(layoutParams4);
    }

    public int getTopDeletePanelBottom() {
        return this.foi.getBottom();
    }

    public void setDeleteBottomHeight(int i) {
        if (i > 0) {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fom.getLayoutParams();
            layoutParams.height = i;
            this.fom.setLayoutParams(layoutParams);
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
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.foo.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        this.foo.setLayoutParams(layoutParams);
        RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.fop.getLayoutParams();
        layoutParams2.width = BdUtilHelper.getEquipmentWidth(getContext()) - i;
        layoutParams2.height = i2;
        this.fop.setLayoutParams(layoutParams2);
    }
}
