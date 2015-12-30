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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.a.i;
import com.baidu.tieba.n;
import java.util.List;
/* loaded from: classes.dex */
public class n extends b<com.baidu.tieba.card.a.i> {
    private a[] aNN;
    private String aNO;
    private String aNP;
    private final LinearLayout.LayoutParams avb;
    private View.OnClickListener mOnClickListener;

    public void an(String str, String str2) {
        this.aNO = str;
        this.aNP = str2;
    }

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.aNN = new a[4];
        this.avb = new LinearLayout.LayoutParams(0, -2, 1.0f);
        this.aNO = null;
        this.aNP = null;
        this.mOnClickListener = new o(this);
        int dimensionPixelOffset = tbPageContext.getResources().getDimensionPixelOffset(n.e.ds24);
        int dimensionPixelOffset2 = tbPageContext.getResources().getDimensionPixelOffset(n.e.ds24);
        this.aNu.setPadding(dimensionPixelOffset, dimensionPixelOffset2, dimensionPixelOffset, dimensionPixelOffset2);
        int dimensionPixelOffset3 = tbPageContext.getResources().getDimensionPixelOffset(n.e.ds4);
        LinearLayout linearLayout = new LinearLayout(getContext());
        linearLayout.setOrientation(0);
        linearLayout.setWeightSum(2.0f);
        a Ik = Ik();
        a Ik2 = Ik();
        Ik.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        Ik2.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout.addView(Ik.view, this.avb);
        linearLayout.addView(Ik2.view, this.avb);
        LinearLayout linearLayout2 = new LinearLayout(getContext());
        linearLayout2.setOrientation(0);
        linearLayout2.setWeightSum(2.0f);
        a Ik3 = Ik();
        a Ik4 = Ik();
        Ik3.view.setPadding(0, 0, dimensionPixelOffset3, 0);
        Ik4.view.setPadding(dimensionPixelOffset3, 0, 0, 0);
        linearLayout2.addView(Ik3.view, this.avb);
        linearLayout2.addView(Ik4.view, this.avb);
        this.aNN[0] = Ik;
        this.aNN[1] = Ik2;
        this.aNN[2] = Ik3;
        this.aNN[3] = Ik4;
        int dimensionPixelOffset4 = tbPageContext.getResources().getDimensionPixelOffset(n.e.ds8);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.bottomMargin = dimensionPixelOffset4;
        this.aNu.addView(linearLayout, layoutParams);
        this.aNu.addView(linearLayout2, layoutParams);
        this.aNm.setOnClickListener(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.card.a.i iVar) {
        super.a((n) iVar);
        if (iVar == null) {
            getView().setVisibility(8);
            return;
        }
        List<i.a> DS = iVar.DS();
        int l = com.baidu.tbadk.core.util.y.l(DS);
        if (l > 0) {
            getView().setVisibility(0);
            List<i.a> subList = l > 4 ? DS.subList(0, 4) : DS;
            int size = subList.size();
            for (int i = 0; i < 4; i++) {
                a aVar = this.aNN[i];
                if (i < size) {
                    aVar.view.setVisibility(0);
                    i.a aVar2 = subList.get(i);
                    aVar.view.setTag(aVar2);
                    aVar.view.setOnClickListener(this.mOnClickListener);
                    a(aVar, aVar2);
                } else {
                    aVar.view.setVisibility(8);
                    aVar.view.setOnClickListener(null);
                }
            }
            onChangeSkinType(Ie(), TbadkCoreApplication.m411getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        for (a aVar : this.aNN) {
            as.b(aVar.ahk, n.d.cp_cont_i, 1);
        }
        super.onChangeSkinType(tbPageContext, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public static class a {
        public TbImageView aNR;
        public TextView ahk;
        private View view;

        private a() {
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private a Ik() {
        View inflate = LayoutInflater.from(getContext()).inflate(n.h.card_group_choice_item, (ViewGroup) null);
        a aVar = new a(null);
        aVar.aNR = (TbImageView) inflate.findViewById(n.g.iv_logo);
        aVar.ahk = (TextView) inflate.findViewById(n.g.tv_title);
        aVar.view = inflate;
        return aVar;
    }

    private void a(a aVar, i.a aVar2) {
        if (aVar != null && aVar2 != null) {
            aVar.ahk.setText(aVar2.title);
            if (!StringUtils.isNULL(aVar2.url)) {
                aVar.aNR.d(aVar2.url, 10, false);
            }
        }
    }

    @Override // com.baidu.tieba.card.b, android.view.View.OnClickListener
    public void onClick(View view) {
        super.onClick(view);
        if (this.aNm == view) {
            bf vn = bf.vn();
            TbPageContext<?> Ie = Ie();
            String[] strArr = new String[3];
            strArr[0] = "http://tieba.baidu.com/mo/q/threadList";
            vn.b(Ie, strArr);
            if (!TextUtils.isEmpty(this.aNP)) {
                TiebaStatic.log(this.aNP);
            }
        }
    }
}
