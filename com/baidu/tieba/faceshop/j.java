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
/* loaded from: classes8.dex */
public class j extends Dialog {
    private TextView bZF;
    private TbPageContext eWx;
    private SpannableString iWy;
    private TextView iWz;
    private View mLoadingView;
    int mSkinType;

    public j(TbPageContext tbPageContext, int i) {
        super(tbPageContext.getContext(), i);
        this.eWx = tbPageContext;
    }

    public void cyS() {
        this.mLoadingView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.face_buy_loading, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        setContentView(this.mLoadingView, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds282)));
        setCancelable(false);
        cyU();
    }

    public void cyT() {
        this.mLoadingView = LayoutInflater.from(this.eWx.getPageActivity()).inflate(R.layout.face_buy_fail, (ViewGroup) null);
        this.mSkinType = TbadkApplication.getInst().getSkinType();
        String string = getContext().getResources().getString(R.string.query_buy_fail_tel);
        this.iWy = new SpannableString(string);
        this.iWy.setSpan(new ForegroundColorSpan(ap.getColor(R.color.common_color_10159)), 5, string.length(), 33);
        setContentView(this.mLoadingView, new LinearLayout.LayoutParams(getContext().getResources().getDimensionPixelSize(R.dimen.ds522), getContext().getResources().getDimensionPixelSize(R.dimen.ds364)));
        this.iWz = (TextView) findViewById(R.id.telphone);
        this.iWz.setText(this.iWy);
        this.bZF = (TextView) findViewById(R.id.confirm);
        this.bZF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.j.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                com.baidu.adp.lib.f.g.b(j.this, j.this.eWx);
            }
        });
        setCancelable(true);
        cyU();
    }

    private void cyU() {
        if (this.eWx != null) {
            this.eWx.getLayoutMode().setNightMode(this.mSkinType == 1);
            this.eWx.getLayoutMode().onModeChanged(this.mLoadingView);
        }
    }
}
