package com.baidu.tieba.faceshop;

import android.app.Dialog;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class j extends Dialog {
    private TextView bUg;
    private TbPageContext eSJ;
    private View enA;
    private SpannableString iOU;
    private TextView iOV;
    int mSkinType;

    public j(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        this.eSJ = tbPageContext;
    }

    public void cxu() {
        this.enA = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        setContentView(this.enA, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        cxw();
    }

    public void cxv() {
        this.enA = LayoutInflater.from(this.eSJ.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.iOU = new SpannableString(string);
        this.iOU.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.enA, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        this.iOV = (TextView) findViewById(R.id.telphone);
        this.iOV.setText(this.iOU);
        this.bUg = (TextView) findViewById(R.id.confirm);
        this.bUg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.b(j.this, j.this.eSJ);
            }
        });
        setCancelable(true);
        cxw();
    }

    private void cxw() {
        if (this.eSJ != null) {
            this.eSJ.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.eSJ.getLayoutMode().onModeChanged(this.enA);
        }
    }
}
