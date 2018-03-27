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
import com.baidu.tieba.tbadkCore.t;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class e extends com.baidu.tieba.frs.g<t, a> implements View.OnClickListener {
    private boolean dKs;
    private boolean dKt;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dKs = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dKt = z;
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
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, t tVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, tVar, aVar);
        if (tVar.bws()) {
            String bwt = tVar.bwt();
            if (bwt != null) {
                aVar.dKv.setText(bwt);
            } else if (this.dDS != null && this.dDS.bas() != null && this.dDS.bas().getName() != null) {
                TextView textView = aVar.dKv;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dDS == null ? "" : this.dDS.bas().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dKu.setTag(Integer.valueOf(i));
            aVar.dKu.setOnClickListener(this);
            aVar.dKu.setVisibility(0);
        } else {
            aVar.dKu.setVisibility(8);
            aVar.dKB.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.n bwu = tVar.bwu();
        if (bwu != null && bwu.bwl() && !TextUtils.isEmpty(bwu.bwm())) {
            aVar.dKx.setText(bwu.bwm());
            aVar.dKw.setTag(Integer.valueOf(i));
            aVar.dKw.setOnClickListener(this);
            aVar.dKw.setVisibility(0);
        } else {
            aVar.dKw.setVisibility(8);
            aVar.dKC.setVisibility(8);
        }
        if (this.dKt) {
            aVar.dKy.setVisibility(0);
        } else {
            aVar.dKy.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (this.dDS == null || this.dDS.getUserData() == null || !this.dDS.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dKz.setVisibility(0);
            aj.s(aVar.dKz, d.f.frs_top_item_bg);
            aVar.dKy.setVisibility(0);
            aVar.dKz.setOnClickListener(this);
            aVar.dKz.setTag(Integer.valueOf(i));
        } else {
            aVar.dKz.setVisibility(8);
            aVar.dKD.setVisibility(8);
        }
        if (!this.dKs && !tVar.bws()) {
            if (z) {
                aVar.dKu.setVisibility(8);
                aVar.dKw.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dKE;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dDT != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View i = i(this.dDU.getListView(), intValue);
                this.dDT.a(id, intValue, view, i, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends r.a {
        TextView dKA;
        View dKB;
        View dKC;
        View dKD;
        List<View> dKE;
        View dKu;
        TextView dKv;
        View dKw;
        TextView dKx;
        View dKy;
        View dKz;

        a(View view) {
            super(view);
            this.dKE = new ArrayList();
            this.dKv = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dKu = view.findViewById(d.g.frs_fortune_bag_item);
            this.dKw = view.findViewById(d.g.frs_my_service_item);
            this.dKx = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.dKy = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.dKz = view.findViewById(d.g.frs_bawu_center);
            this.dKA = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.dKB = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.dKC = view.findViewById(d.g.official_account_text_divider_service_top);
            this.dKD = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dKE.add(this.dKB);
            this.dKE.add(this.dKC);
            this.dKE.add(this.dKD);
        }
    }
}
