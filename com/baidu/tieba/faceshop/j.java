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
/* loaded from: classes9.dex */
public class j extends Dialog {
    private TextView bYS;
    private TbPageContext eXu;
    private View eso;
    private SpannableString iTB;
    private TextView iTC;
    int mSkinType;

    public j(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        this.eXu = tbPageContext;
    }

    public void cBm() {
        this.eso = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        setContentView(this.eso, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        cBo();
    }

    public void cBn() {
        this.eso = LayoutInflater.from(this.eXu.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.iTB = new SpannableString(string);
        this.iTB.setSpan(new ForegroundColorSpan(ao.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.eso, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        this.iTC = (TextView) findViewById(R.id.telphone);
        this.iTC.setText(this.iTB);
        this.bYS = (TextView) findViewById(R.id.confirm);
        this.bYS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.b(j.this, j.this.eXu);
            }
        });
        setCancelable(true);
        cBo();
    }

    private void cBo() {
        if (this.eXu != null) {
            this.eXu.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.eXu.getLayoutMode().onModeChanged(this.eso);
        }
    }
}
