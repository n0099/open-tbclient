package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.s, a> implements View.OnClickListener {
    private boolean fgy;
    private boolean fgz;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fgy = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fgz = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aF */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.cdH()) {
            String cdI = sVar.cdI();
            if (cdI != null) {
                aVar.fgB.setText(cdI);
            } else if (this.eYi != null && this.eYi.getForum() != null && this.eYi.getForum().getName() != null) {
                TextView textView = aVar.fgB;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.eYi == null ? "" : this.eYi.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.fgA.setTag(Integer.valueOf(i));
            aVar.fgA.setOnClickListener(this);
            aVar.fgA.setVisibility(0);
        } else {
            aVar.fgA.setVisibility(8);
            aVar.fgH.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m cdJ = sVar.cdJ();
        if (cdJ != null && cdJ.cdA() && !TextUtils.isEmpty(cdJ.cdB())) {
            aVar.fgD.setText(cdJ.cdB());
            aVar.fgC.setTag(Integer.valueOf(i));
            aVar.fgC.setOnClickListener(this);
            aVar.fgC.setVisibility(0);
        } else {
            aVar.fgC.setVisibility(8);
            aVar.fgI.setVisibility(8);
        }
        if (this.fgz) {
            aVar.fgE.setVisibility(0);
        } else {
            aVar.fgE.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.eYi == null || this.eYi.getUserData() == null || !this.eYi.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fgF.setVisibility(0);
            al.k(aVar.fgF, d.f.frs_top_item_bg);
            aVar.fgE.setVisibility(0);
            aVar.fgF.setOnClickListener(this);
            aVar.fgF.setTag(Integer.valueOf(i));
        } else {
            aVar.fgF.setVisibility(8);
            aVar.fgJ.setVisibility(8);
        }
        if (!this.fgy && !sVar.cdH()) {
            if (z) {
                aVar.fgA.setVisibility(8);
                aVar.fgC.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fgK;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eYj != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bg) {
                View p = p(this.eEd.getListView(), intValue);
                this.eYj.a(id, intValue, view, p, (bg) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fgA;
        TextView fgB;
        View fgC;
        TextView fgD;
        View fgE;
        View fgF;
        TextView fgG;
        View fgH;
        View fgI;
        View fgJ;
        List<View> fgK;

        a(View view) {
            super(view);
            this.fgK = new ArrayList();
            this.fgB = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.fgA = view.findViewById(d.g.frs_fortune_bag_item);
            this.fgC = view.findViewById(d.g.frs_my_service_item);
            this.fgD = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.fgE = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.fgF = view.findViewById(d.g.frs_bawu_center);
            this.fgG = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.fgH = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.fgI = view.findViewById(d.g.official_account_text_divider_service_top);
            this.fgJ = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.fgK.add(this.fgH);
            this.fgK.add(this.fgI);
            this.fgK.add(this.fgJ);
        }
    }
}
