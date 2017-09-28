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
    private int aDA;
    private int aDz;
    private long aVw;
    d aVx;
    private View.OnClickListener aVy;
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
        this.aVw = 0L;
        this.aVy = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Kt();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.aVw > 500) {
                    c.this.Ks();
                }
                c.this.aVw = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.aVx = new d(tbPageContext, this);
        setOnClickListener(this.aVy);
        aj.c(this, d.g.icon_home_feedback_selector);
        this.aDz = l.f(this.mContext, d.f.ds60);
        this.aDA = l.f(this.mContext, d.f.ds4);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aVx.setUniqueId(bdUniqueId);
    }

    public void Kr() {
        int f = l.f(this.mContext, d.f.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = f;
        layoutParams.gravity = 48;
        setLayoutParams(layoutParams);
        setPadding(this.aDz, 0, this.aDA, 0);
    }

    public void setLeftPadding(int i) {
        this.aDz = i;
        setPadding(i, 0, this.aDA, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ks() {
        this.aVx.Ks();
    }

    public void Kt() {
        this.aVx.Kt();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aVx.onDetachedFromWindow();
    }

    public void setData(al alVar) {
        this.aVx.setData(alVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVx.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aVx.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVx.setDefaultReasonArray(strArr);
    }
}
