package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.f<s, a> implements View.OnClickListener {
    private boolean deA;
    private boolean dez;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dez = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.deA = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view2, viewGroup, sVar, aVar);
        if (sVar.brq()) {
            String brr = sVar.brr();
            if (brr != null) {
                aVar.deC.setText(brr);
            } else if (this.cXS != null && this.cXS.aVq() != null && this.cXS.aVq().getName() != null) {
                TextView textView = aVar.deC;
                Context context = this.mContext;
                int i2 = d.k.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.cXS == null ? "" : this.cXS.aVq().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.deB.setTag(Integer.valueOf(i));
            aVar.deB.setOnClickListener(this);
            aVar.deB.setVisibility(0);
        } else {
            aVar.deB.setVisibility(8);
            aVar.deI.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m brs = sVar.brs();
        if (brs != null && brs.brj() && !TextUtils.isEmpty(brs.brk())) {
            aVar.deE.setText(brs.brk());
            aVar.deD.setTag(Integer.valueOf(i));
            aVar.deD.setOnClickListener(this);
            aVar.deD.setVisibility(0);
        } else {
            aVar.deD.setVisibility(8);
            aVar.deJ.setVisibility(8);
        }
        if (this.deA) {
            aVar.deF.setVisibility(0);
        } else {
            aVar.deF.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().u(view2);
        if (this.cXS == null || this.cXS.getUserData() == null || !this.cXS.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.deG.setVisibility(0);
            ak.i(aVar.deG, d.f.frs_top_item_bg);
            aVar.deF.setVisibility(0);
            aVar.deG.setOnClickListener(this);
            aVar.deG.setTag(Integer.valueOf(i));
        } else {
            aVar.deG.setVisibility(8);
            aVar.deK.setVisibility(8);
        }
        if (!this.dez && !sVar.brq()) {
            if (z) {
                aVar.deB.setVisibility(8);
                aVar.deD.setVisibility(8);
                a(aVar);
                return view2;
            }
            return new View(this.mContext);
        }
        return view2;
    }

    private void a(a aVar) {
        List<View> list = aVar.deL;
        for (View view2 : list) {
            view2.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.cXT != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View j = j(this.cXU.getListView(), intValue);
                this.cXT.a(id, intValue, view2, j, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View deB;
        TextView deC;
        View deD;
        TextView deE;
        View deF;
        View deG;
        TextView deH;
        View deI;
        View deJ;
        View deK;
        List<View> deL;

        a(View view2) {
            super(view2);
            this.deL = new ArrayList();
            this.deC = (TextView) view2.findViewById(d.g.frs_fortune_bag_content);
            this.deB = view2.findViewById(d.g.frs_fortune_bag_item);
            this.deD = view2.findViewById(d.g.frs_my_service_item);
            this.deE = (TextView) view2.findViewById(d.g.frs_my_service_content);
            this.deF = view2.findViewById(d.g.frs_list_item_official_buttom_line);
            this.deG = view2.findViewById(d.g.frs_bawu_center);
            this.deH = (TextView) view2.findViewById(d.g.frs_bawu_center_inner);
            this.deI = view2.findViewById(d.g.official_account_text_divider_fortune_top);
            this.deJ = view2.findViewById(d.g.official_account_text_divider_service_top);
            this.deK = view2.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.deL.add(this.deI);
            this.deL.add(this.deJ);
            this.deL.add(this.deK);
        }
    }
}
