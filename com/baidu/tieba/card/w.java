package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.m;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class w extends b<com.baidu.tieba.card.a.m> {
    private a[] aSL;
    private String aSM;
    private String aSN;
    private final LinearLayout.LayoutParams awA;
    private View.OnClickListener mOnClickListener;

    public void at(String str, String str2) {
        this.aSM = str;
        this.aSN = str2;
    }

    public w(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aSL = new a[4];
        this.awA = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.aSM = null;
        this.aSN = null;
        this.mOnClickListener = new x(this);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds24);
        int dimensionPixelOffset2 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds24);
        this.aRx.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        int dimensionPixelOffset3 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds4);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(2.0f);
        a Lk = Lk();
        a Lk2 = Lk();
        Lk.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        Lk2.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout.addView(Lk.view, this.awA);
        linearLayout.addView(Lk2.view, this.awA);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(2.0f);
        a Lk3 = Lk();
        a Lk4 = Lk();
        Lk3.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        Lk4.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout2.addView(Lk3.view, this.awA);
        linearLayout2.addView(Lk4.view, this.awA);
        this.aSL[0] = Lk;
        this.aSL[1] = Lk2;
        this.aSL[2] = Lk3;
        this.aSL[3] = Lk4;
        int dimensionPixelOffset4 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dimensionPixelOffset4;
        this.aRx.addView(linearLayout, layoutParams);
        this.aRx.addView(linearLayout2, layoutParams);
        this.aRp.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.m mVar) {
        super.a((w) mVar);
        if (mVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<m.a> FZ = mVar.FZ();
        int p = com.baidu.tbadk.core.util.y.p(FZ);
        if (p > 0) {
            getView().setVisibility(0);
            List<m.a> subList = p > 4 ? FZ.subList(0, 4) : FZ;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aSL[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    m.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    aVar.view.setOnClickListener(this.mOnClickListener);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                    aVar.view.setOnClickListener(null);
                }
            }
            d(Lb(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aSL) {
            com.baidu.tbadk.core.util.at.b(aVar.apE, t.d.cp_cont_i, 1);
        }
        super.d(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aSP;
        public TextView apE;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a Lk() {
        View inflate = LayoutInflater.from(getContext()).inflate(t.h.card_group_choice_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aSP = (TbImageView) inflate.findViewById(t.g.iv_logo);
        aVar.apE = (TextView) inflate.findViewById(t.g.tv_title);
        aVar.view = inflate;
        return aVar;
    }

    private void a(a aVar, m.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.apE.setText(aVar2.title);
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.aSP.c(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aRp == view) {
            com.baidu.tbadk.core.util.bg wM = com.baidu.tbadk.core.util.bg.wM();
            TbPageContext<?> Lb = Lb();
            String[] strArr = new String[3];
            strArr[0] = "http://tieba.baidu.com/mo/q/threadList";
            wM.c(Lb, strArr);
            if (!TextUtils.isEmpty(this.aSN)) {
                TiebaStatic.log(this.aSN);
            }
        }
    }
}
