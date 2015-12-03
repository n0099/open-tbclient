package com.baidu.tieba.a;

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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.a.a.g;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class m extends b<com.baidu.tieba.a.a.g> {
    private a[] aMm;
    private String aMn;
    private String aMo;
    private final LinearLayout.LayoutParams atx;
    private View.OnClickListener mOnClickListener;

    public void ao(String str, String str2) {
        this.aMn = str;
        this.aMo = str2;
    }

    public m(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aMm = new a[4];
        this.atx = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.aMn = null;
        this.aMo = null;
        this.mOnClickListener = new n(this);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(n.d.ds24);
        int dimensionPixelOffset2 = tbPageContext.getResources().getDimensionPixelOffset(n.d.ds24);
        this.aLV.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        int dimensionPixelOffset3 = tbPageContext.getResources().getDimensionPixelOffset(n.d.ds4);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(2.0f);
        a It = It();
        a It2 = It();
        It.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        It2.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout.addView(It.view, this.atx);
        linearLayout.addView(It2.view, this.atx);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(2.0f);
        a It3 = It();
        a It4 = It();
        It3.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        It4.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout2.addView(It3.view, this.atx);
        linearLayout2.addView(It4.view, this.atx);
        this.aMm[0] = It;
        this.aMm[1] = It2;
        this.aMm[2] = It3;
        this.aMm[3] = It4;
        int dimensionPixelOffset4 = tbPageContext.getResources().getDimensionPixelOffset(n.d.ds8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dimensionPixelOffset4;
        this.aLV.addView(linearLayout, layoutParams);
        this.aLV.addView(linearLayout2, layoutParams);
        this.aLN.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.a.b
    public void a(com.baidu.tieba.a.a.g gVar) {
        super.a((m) gVar);
        if (gVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<g.a> Ed = gVar.Ed();
        int k = y.k(Ed);
        if (k > 0) {
            getView().setVisibility(0);
            List<g.a> subList = k > 4 ? Ed.subList(0, 4) : Ed;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aMm[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    g.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    aVar.view.setOnClickListener(this.mOnClickListener);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                    aVar.view.setOnClickListener(null);
                }
            }
            onChangeSkinType(Io(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.a.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aMm) {
            as.b(aVar.agd, n.c.cp_cont_i, 1);
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aMq;
        public TextView agd;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a It() {
        View inflate = LayoutInflater.from(getContext()).inflate(n.g.card_group_choice_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aMq = (TbImageView) inflate.findViewById(n.f.iv_logo);
        aVar.agd = (TextView) inflate.findViewById(n.f.tv_title);
        aVar.view = inflate;
        return aVar;
    }

    private void a(a aVar, g.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.agd.setText(aVar2.title);
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.aMq.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.a.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aLN == view) {
            bf vD = bf.vD();
            TbPageContext<?> Io = Io();
            String[] strArr = new String[3];
            strArr[0] = "http://tieba.baidu.com/mo/q/threadList";
            vD.b(Io, strArr);
            if (!TextUtils.isEmpty(this.aMo)) {
                TiebaStatic.log(this.aMo);
            }
        }
    }
}
