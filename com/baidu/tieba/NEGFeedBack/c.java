package com.baidu.tieba.NEGFeedBack;

import android.content.Context;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.al;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class c extends ImageView {
    private int aEf;
    private int aEg;
    private long aVB;
    d aVC;
    private View.OnClickListener aVD;
    private Context mContext;

    /* loaded from: classes.dex */
    public interface a {
        void a(al alVar);

        void a(al alVar, CompoundButton compoundButton, boolean z);

        void a(ArrayList<Integer> arrayList, al alVar);
    }

    public c(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        this.mContext = null;
        this.aVB = 0L;
        this.aVD = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.KH();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.aVB > 500) {
                    c.this.KG();
                }
                c.this.aVB = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.aVC = new d(tbPageContext, this);
        setOnClickListener(this.aVD);
        aj.c(this, d.f.icon_home_feedback_selector);
        this.aEf = l.f(this.mContext, d.e.ds60);
        this.aEg = l.f(this.mContext, d.e.ds4);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aVC.setUniqueId(bdUniqueId);
    }

    public void KF() {
        int f = l.f(this.mContext, d.e.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = f;
        layoutParams.gravity = 48;
        setLayoutParams(layoutParams);
        setPadding(this.aEf, 0, this.aEg, 0);
    }

    public void setLeftPadding(int i) {
        this.aEf = i;
        setPadding(i, 0, this.aEg, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void KG() {
        this.aVC.KG();
    }

    public void KH() {
        this.aVC.KH();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aVC.onDetachedFromWindow();
    }

    public void setData(al alVar) {
        this.aVC.setData(alVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVC.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aVC.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVC.setDefaultReasonArray(strArr);
    }
}
