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
    private View asM;
    private SpannableString asN;
    private TextView asO;
    private TextView asP;
    private Context mContext;
    int mSkinType;

    public v(Context context, int i) {
        super(context, i);
        this.mContext = context;
    }

    public void CO() {
        this.asM = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_buy_loading, null);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        setContentView(this.asM, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_height)));
        setCancelable(false);
        CQ();
    }

    public void CP() {
        this.asM = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, ca.face_buy_fail, null);
        this.mSkinType = TbadkApplication.m251getInst().getSkinType();
        String string = getContext().getResources().getString(cb.query_buy_fail_tel);
        this.asN = new SpannableString(string);
        this.asN.setSpan(new ForegroundColorSpan(com.baidu.tbadk.core.util.aw.getColor(bw.faceshop_package_price_text)), 5, string.length(), 33);
        setContentView(this.asM, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_width), getContext().getResources().getDimensionPixelSize(bx.faceshop_buy_dialog_fail_height)));
        this.asO = (TextView) findViewById(bz.telphone);
        this.asO.setText(this.asN);
        this.asP = (TextView) findViewById(bz.confirm);
        this.asP.setOnClickListener(new w(this));
        setCancelable(true);
        CQ();
    }

    private void CQ() {
        if (this.mContext instanceof BaseActivity) {
            ((BaseActivity) this.mContext).getLayoutMode().L(this.mSkinType == 1);
            ((BaseActivity) this.mContext).getLayoutMode().h(this.asM);
        }
    }
}
