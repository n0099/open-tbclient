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
    private int aDm;
    private int aDn;
    private long aVj;
    d aVk;
    private View.OnClickListener aVl;
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
        this.aVj = 0L;
        this.aVl = new View.OnClickListener() { // from class: com.baidu.tieba.NEGFeedBack.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.Kn();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - c.this.aVj > 500) {
                    c.this.Km();
                }
                c.this.aVj = currentTimeMillis;
            }
        };
        this.mContext = tbPageContext.getPageActivity();
        g(tbPageContext);
    }

    private void g(TbPageContext tbPageContext) {
        this.aVk = new d(tbPageContext, this);
        setOnClickListener(this.aVl);
        aj.c(this, d.g.icon_home_feedback_selector);
        this.aDm = l.f(this.mContext, d.f.ds60);
        this.aDn = l.f(this.mContext, d.f.ds4);
    }

    public void setUniqueId(BdUniqueId bdUniqueId) {
        this.aVk.setUniqueId(bdUniqueId);
    }

    public void Kl() {
        int f = l.f(this.mContext, d.f.ds48);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
        layoutParams.height = f;
        layoutParams.gravity = 48;
        setLayoutParams(layoutParams);
        setPadding(this.aDm, 0, this.aDn, 0);
    }

    public void setLeftPadding(int i) {
        this.aDm = i;
        setPadding(i, 0, this.aDn, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Km() {
        this.aVk.Km();
    }

    public void Kn() {
        this.aVk.Kn();
    }

    @Override // android.widget.ImageView, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.aVk.onDetachedFromWindow();
    }

    public void setData(al alVar) {
        this.aVk.setData(alVar);
    }

    public void setFirstRowSingleColumn(boolean z) {
        this.aVk.setFirstRowSingleColumn(z);
    }

    public void onChangeSkinType() {
        aj.c(this, d.g.icon_home_feedback_selector);
    }

    public void setEventCallback(a aVar) {
        this.aVk.setEventCallback(aVar);
    }

    public void setDefaultReasonArray(String[] strArr) {
        this.aVk.setDefaultReasonArray(strArr);
    }
}
