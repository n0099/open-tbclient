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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.l;
import com.baidu.tieba.t;
import java.util.List;
/* loaded from: classes.dex */
public class u extends b<com.baidu.tieba.card.a.l> {
    private a[] aPQ;
    private String aPR;
    private String aPS;
    private final LinearLayout.LayoutParams avT;
    private View.OnClickListener mOnClickListener;

    public void an(String str, String str2) {
        this.aPR = str;
        this.aPS = str2;
    }

    public u(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aPQ = new a[4];
        this.avT = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.aPR = null;
        this.aPS = null;
        this.mOnClickListener = new v(this);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds24);
        int dimensionPixelOffset2 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds24);
        this.aOI.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        int dimensionPixelOffset3 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds4);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(2.0f);
        a JS = JS();
        a JS2 = JS();
        JS.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        JS2.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout.addView(JS.view, this.avT);
        linearLayout.addView(JS2.view, this.avT);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(2.0f);
        a JS3 = JS();
        a JS4 = JS();
        JS3.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        JS4.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout2.addView(JS3.view, this.avT);
        linearLayout2.addView(JS4.view, this.avT);
        this.aPQ[0] = JS;
        this.aPQ[1] = JS2;
        this.aPQ[2] = JS3;
        this.aPQ[3] = JS4;
        int dimensionPixelOffset4 = tbPageContext.getResources().getDimensionPixelOffset(t.e.ds8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dimensionPixelOffset4;
        this.aOI.addView(linearLayout, layoutParams);
        this.aOI.addView(linearLayout2, layoutParams);
        this.aOA.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.l lVar) {
        super.a((u) lVar);
        if (lVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<l.a> Fm = lVar.Fm();
        int o = com.baidu.tbadk.core.util.x.o(Fm);
        if (o > 0) {
            getView().setVisibility(0);
            List<l.a> subList = o > 4 ? Fm.subList(0, 4) : Fm;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aPQ[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    l.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    aVar.view.setOnClickListener(this.mOnClickListener);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                    aVar.view.setOnClickListener(null);
                }
            }
            d(JK(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void d(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aPQ) {
            com.baidu.tbadk.core.util.ar.b(aVar.apm, t.d.cp_cont_i, 1);
        }
        super.d(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aPU;
        public TextView apm;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a JS() {
        View inflate = LayoutInflater.from(getContext()).inflate(t.h.card_group_choice_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aPU = (TbImageView) inflate.findViewById(t.g.iv_logo);
        aVar.apm = (TextView) inflate.findViewById(t.g.tv_title);
        aVar.view = inflate;
        return aVar;
    }

    private void a(a aVar, l.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.apm.setText(aVar2.title);
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.aPU.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aOA == view) {
            be wt = be.wt();
            TbPageContext<?> JK = JK();
            String[] strArr = new String[3];
            strArr[0] = "http://tieba.baidu.com/mo/q/threadList";
            wt.c(JK, strArr);
            if (!TextUtils.isEmpty(this.aPS)) {
                TiebaStatic.log(this.aPS);
            }
        }
    }
}
