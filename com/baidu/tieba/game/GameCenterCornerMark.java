package com.baidu.tieba.game;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class GameCenterCornerMark extends View {
    private String Dn;
    private RectF aGZ;
    private float aHa;
    private Rect aHb;
    private int aHc;
    private int aHd;
    private int aHe;
    private Context mContext;
    private int mFontSize;
    private Path ry;
    private Paint tR;

    public GameCenterCornerMark(Context context) {
        this(context, null);
    }

    public GameCenterCornerMark(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GameCenterCornerMark(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aHc = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_link_tip_d);
        this.aHd = com.baidu.adp.lib.util.m.c(TbadkApplication.m251getInst().getApplicationContext(), com.baidu.tieba.t.ds8);
        this.mFontSize = com.baidu.adp.lib.util.m.c(TbadkApplication.m251getInst().getApplicationContext(), com.baidu.tieba.t.ds16);
        this.aHe = com.baidu.adp.lib.util.m.c(TbadkApplication.m251getInst().getApplicationContext(), com.baidu.tieba.t.ds58);
        this.mContext = context;
        init();
    }

    private void init() {
        this.tR = new Paint();
        this.ry = new Path();
        this.aHa = com.baidu.adp.lib.util.m.c(TbadkApplication.m251getInst().getApplicationContext(), com.baidu.tieba.t.ds26);
        this.aGZ = new RectF(0.0f, 0.0f, this.aHa * 2.0f, this.aHa * 2.0f);
        this.aHb = new Rect();
    }

    public void setBgColorTag(String str) {
        switch (com.baidu.adp.lib.g.c.f(str, 0)) {
            case 2:
                this.aHc = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_link_tip_a);
                return;
            default:
                this.aHc = com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_link_tip_d);
                return;
        }
    }

    public void setText(String str) {
        this.Dn = str;
    }

    public void setFontSize(int i) {
        this.mFontSize = i;
    }

    public void setFontOffset(int i) {
        this.aHd = i;
    }

    public void setTriangleHeight(int i) {
        this.aHe = i;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(0);
        this.tR.setAntiAlias(true);
        this.tR.setStyle(Paint.Style.FILL);
        this.tR.setColor(this.aHc);
        this.ry.moveTo(0.0f, this.aHa);
        this.ry.arcTo(this.aGZ, 180.0f, 90.0f);
        this.ry.lineTo(this.aHe, 0.0f);
        this.ry.lineTo(0.0f, this.aHe);
        this.ry.close();
        canvas.drawPath(this.ry, this.tR);
        if (TextUtils.isEmpty(this.Dn) || com.baidu.tieba.game.a.g.fy(this.Dn) > 4) {
            this.Dn = this.mContext.getString(com.baidu.tieba.y.game_superscript_default_text);
        }
        this.tR.reset();
        this.tR.setTypeface(Typeface.DEFAULT_BOLD);
        this.tR.setColor(com.baidu.tbadk.core.util.aw.getColor(com.baidu.tieba.s.cp_cont_i));
        this.tR.setTextSize(this.mFontSize);
        this.tR.getTextBounds(this.Dn, 0, this.Dn.length(), this.aHb);
        canvas.save();
        canvas.translate(0.0f, this.aHe);
        canvas.rotate(-45.0f);
        canvas.drawText(this.Dn, (((float) (this.aHe * 1.41d)) - this.aHb.width()) / 2.0f, -this.aHd, this.tR);
        canvas.restore();
    }
}
