package com.baidu.tieba.faceshop;

import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class v extends Dialog {
    private View asV;
    private SpannableString asW;
    private TextView asX;
    private TextView asY;
    private Context mContext;
    int mSkinType;

    public v(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public void CQ() {
        this.asV = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_buy_loading, null);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        setContentView(this.asV, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_height)));
        setCancelable(false);
        CS();
    }

    public void CR() {
        this.asV = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_buy_fail, null);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        String string = getContext().getResources().getString(cb.query_buy_fail_tel);
        this.asW = new SpannableString(string);
        this.asW.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aw.getColor(bw.faceshop_package_price_text)), 5, string.length(), 33);
        setContentView(this.asV, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_fail_height)));
        this.asX = (TextView) findViewById(bz.telphone);
        this.asX.setText(this.asW);
        this.asY = (TextView) findViewById(bz.confirm);
        this.asY.setOnClickListener(new w(this));
        setCancelable(true);
        CS();
    }

    private void CS() {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(this.mSkinType == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.asV);
        }
    }
}
