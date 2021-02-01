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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class j extends Dialog {
    private TextView bYf;
    private TbPageContext eUY;
    private SpannableString iUB;
    private TextView iUC;
    private View mLoadingView;
    int mSkinType;

    public j(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        this.eUY = tbPageContext;
    }

    public void cyF() {
        this.mLoadingView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        setContentView(this.mLoadingView, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        cyH();
    }

    public void cyG() {
        this.mLoadingView = LayoutInflater.from(this.eUY.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.iUB = new SpannableString(string);
        this.iUB.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.mLoadingView, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        this.iUC = (TextView) findViewById(R.id.telphone);
        this.iUC.setText(this.iUB);
        this.bYf = (TextView) findViewById(R.id.confirm);
        this.bYf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.b(j.this, j.this.eUY);
            }
        });
        setCancelable(true);
        cyH();
    }

    private void cyH() {
        if (this.eUY != null) {
            this.eUY.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.eUY.getLayoutMode().onModeChanged(this.mLoadingView);
        }
    }
}
