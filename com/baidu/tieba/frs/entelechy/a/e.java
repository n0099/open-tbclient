package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.r;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.g<com.baidu.tieba.tbadkCore.s, a> implements View.OnClickListener {
    private boolean dKA;
    private boolean dKz;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dKz = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dKA = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: av */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.g, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bwo()) {
            String bwp = sVar.bwp();
            if (bwp != null) {
                aVar.dKC.setText(bwp);
            } else if (this.dEb != null && this.dEb.bas() != null && this.dEb.bas().getName() != null) {
                TextView textView = aVar.dKC;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dEb == null ? "" : this.dEb.bas().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dKB.setTag(Integer.valueOf(i));
            aVar.dKB.setOnClickListener(this);
            aVar.dKB.setVisibility(0);
        } else {
            aVar.dKB.setVisibility(8);
            aVar.dKI.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bwq = sVar.bwq();
        if (bwq != null && bwq.bwh() && !TextUtils.isEmpty(bwq.bwi())) {
            aVar.dKE.setText(bwq.bwi());
            aVar.dKD.setTag(Integer.valueOf(i));
            aVar.dKD.setOnClickListener(this);
            aVar.dKD.setVisibility(0);
        } else {
            aVar.dKD.setVisibility(8);
            aVar.dKJ.setVisibility(8);
        }
        if (this.dKA) {
            aVar.dKF.setVisibility(0);
        } else {
            aVar.dKF.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (this.dEb == null || this.dEb.getUserData() == null || !this.dEb.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dKG.setVisibility(0);
            aj.s(aVar.dKG, d.f.frs_top_item_bg);
            aVar.dKF.setVisibility(0);
            aVar.dKG.setOnClickListener(this);
            aVar.dKG.setTag(Integer.valueOf(i));
        } else {
            aVar.dKG.setVisibility(8);
            aVar.dKK.setVisibility(8);
        }
        if (!this.dKz && !sVar.bwo()) {
            if (z) {
                aVar.dKB.setVisibility(8);
                aVar.dKD.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dKL;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dEc != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View i = i(this.dEd.getListView(), intValue);
                this.dEc.a(id, intValue, view, i, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends r.a {
        View dKB;
        TextView dKC;
        View dKD;
        TextView dKE;
        View dKF;
        View dKG;
        TextView dKH;
        View dKI;
        View dKJ;
        View dKK;
        List<View> dKL;

        a(View view) {
            super(view);
            this.dKL = new ArrayList();
            this.dKC = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dKB = view.findViewById(d.g.frs_fortune_bag_item);
            this.dKD = view.findViewById(d.g.frs_my_service_item);
            this.dKE = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.dKF = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.dKG = view.findViewById(d.g.frs_bawu_center);
            this.dKH = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.dKI = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.dKJ = view.findViewById(d.g.official_account_text_divider_service_top);
            this.dKK = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dKL.add(this.dKI);
            this.dKL.add(this.dKJ);
            this.dKL.add(this.dKK);
        }
    }
}
