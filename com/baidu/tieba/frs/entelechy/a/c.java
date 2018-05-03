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
    private boolean ddq;
    private boolean ddr;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.ddq = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.ddr = z;
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
        if (sVar.brs()) {
            String brt = sVar.brt();
            if (brt != null) {
                aVar.ddt.setText(brt);
            } else if (this.cWL != null && this.cWL.aVq() != null && this.cWL.aVq().getName() != null) {
                TextView textView = aVar.ddt;
                Context context = this.mContext;
                int i2 = d.k.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.cWL == null ? "" : this.cWL.aVq().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dds.setTag(Integer.valueOf(i));
            aVar.dds.setOnClickListener(this);
            aVar.dds.setVisibility(0);
        } else {
            aVar.dds.setVisibility(8);
            aVar.ddA.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bru = sVar.bru();
        if (bru != null && bru.brl() && !TextUtils.isEmpty(bru.brm())) {
            aVar.ddw.setText(bru.brm());
            aVar.ddv.setTag(Integer.valueOf(i));
            aVar.ddv.setOnClickListener(this);
            aVar.ddv.setVisibility(0);
        } else {
            aVar.ddv.setVisibility(8);
            aVar.ddB.setVisibility(8);
        }
        if (this.ddr) {
            aVar.ddx.setVisibility(0);
        } else {
            aVar.ddx.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().u(view2);
        if (this.cWL == null || this.cWL.getUserData() == null || !this.cWL.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.ddy.setVisibility(0);
            ak.i(aVar.ddy, d.f.frs_top_item_bg);
            aVar.ddx.setVisibility(0);
            aVar.ddy.setOnClickListener(this);
            aVar.ddy.setTag(Integer.valueOf(i));
        } else {
            aVar.ddy.setVisibility(8);
            aVar.ddC.setVisibility(8);
        }
        if (!this.ddq && !sVar.brs()) {
            if (z) {
                aVar.dds.setVisibility(8);
                aVar.ddv.setVisibility(8);
                a(aVar);
                return view2;
            }
            return new View(this.mContext);
        }
        return view2;
    }

    private void a(a aVar) {
        List<View> list = aVar.ddD;
        for (View view2 : list) {
            view2.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        if (this.cWM != null) {
            int id = view2.getId();
            int intValue = ((Integer) view2.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View j = j(this.cWN.getListView(), intValue);
                this.cWM.a(id, intValue, view2, j, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View ddA;
        View ddB;
        View ddC;
        List<View> ddD;
        View dds;
        TextView ddt;
        View ddv;
        TextView ddw;
        View ddx;
        View ddy;
        TextView ddz;

        a(View view2) {
            super(view2);
            this.ddD = new ArrayList();
            this.ddt = (TextView) view2.findViewById(d.g.frs_fortune_bag_content);
            this.dds = view2.findViewById(d.g.frs_fortune_bag_item);
            this.ddv = view2.findViewById(d.g.frs_my_service_item);
            this.ddw = (TextView) view2.findViewById(d.g.frs_my_service_content);
            this.ddx = view2.findViewById(d.g.frs_list_item_official_buttom_line);
            this.ddy = view2.findViewById(d.g.frs_bawu_center);
            this.ddz = (TextView) view2.findViewById(d.g.frs_bawu_center_inner);
            this.ddA = view2.findViewById(d.g.official_account_text_divider_fortune_top);
            this.ddB = view2.findViewById(d.g.official_account_text_divider_service_top);
            this.ddC = view2.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.ddD.add(this.ddA);
            this.ddD.add(this.ddB);
            this.ddD.add(this.ddC);
        }
    }
}
