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
    private int aDX;
    private int aDY;
    private long aVt;
    d aVu;
    private View.OnClickListener aVv;
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
        this.aVt = 0L;
        this.aVv = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Kw();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.aVt > 500) {
                    c.this.Kv();
                }
                c.this.aVt = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.aVu = new d(tbPageContext, this);
        setOnClickListener(this.aVv);
        aj.c(this, d.f.icon_home_feedback_selector);
        this.aDX = l.f(this.mContext, d.e.ds60);
        this.aDY = l.f(this.mContext, d.e.ds4);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aVu.setUniqueId(bdUniqueId);
    }

    public void Ku() {
        int f = l.f(this.mContext, d.e.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = f;
        layoutParams.gravity = 48;
        setLayoutParams(layoutParams);
        setPadding(this.aDX, 0, this.aDY, 0);
    }

    public void setLeftPadding(int i) {
        this.aDX = i;
        setPadding(i, 0, this.aDY, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Kv() {
        this.aVu.Kv();
    }

    public void Kw() {
        this.aVu.Kw();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aVu.onDetachedFromWindow();
    }

    public void setData(al alVar) {
        this.aVu.setData(alVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVu.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.f.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aVu.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVu.setDefaultReasonArray(strArr);
    }
}
