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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<s, a> implements View.OnClickListener {
    private boolean dSK;
    private boolean dSL;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dSK = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dSL = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ar */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(e.h.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bDB()) {
            String bDC = sVar.bDC();
            if (bDC != null) {
                aVar.dSN.setText(bDC);
            } else if (this.dKt != null && this.dKt.bgT() != null && this.dKt.bgT().getName() != null) {
                TextView textView = aVar.dSN;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dKt == null ? "" : this.dKt.bgT().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dSM.setTag(Integer.valueOf(i));
            aVar.dSM.setOnClickListener(this);
            aVar.dSM.setVisibility(0);
        } else {
            aVar.dSM.setVisibility(8);
            aVar.dST.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bDD = sVar.bDD();
        if (bDD != null && bDD.bDu() && !TextUtils.isEmpty(bDD.bDv())) {
            aVar.dSP.setText(bDD.bDv());
            aVar.dSO.setTag(Integer.valueOf(i));
            aVar.dSO.setOnClickListener(this);
            aVar.dSO.setVisibility(0);
        } else {
            aVar.dSO.setVisibility(8);
            aVar.dSU.setVisibility(8);
        }
        if (this.dSL) {
            aVar.dSQ.setVisibility(0);
        } else {
            aVar.dSQ.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dKt == null || this.dKt.getUserData() == null || !this.dKt.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dSR.setVisibility(0);
            al.i(aVar.dSR, e.f.frs_top_item_bg);
            aVar.dSQ.setVisibility(0);
            aVar.dSR.setOnClickListener(this);
            aVar.dSR.setTag(Integer.valueOf(i));
        } else {
            aVar.dSR.setVisibility(8);
            aVar.dSV.setVisibility(8);
        }
        if (!this.dSK && !sVar.bDB()) {
            if (z) {
                aVar.dSM.setVisibility(8);
                aVar.dSO.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dSW;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dKu != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dKv.getListView(), intValue);
                this.dKu.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dSM;
        TextView dSN;
        View dSO;
        TextView dSP;
        View dSQ;
        View dSR;
        TextView dSS;
        View dST;
        View dSU;
        View dSV;
        List<View> dSW;

        a(View view) {
            super(view);
            this.dSW = new ArrayList();
            this.dSN = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dSM = view.findViewById(e.g.frs_fortune_bag_item);
            this.dSO = view.findViewById(e.g.frs_my_service_item);
            this.dSP = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dSQ = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dSR = view.findViewById(e.g.frs_bawu_center);
            this.dSS = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dST = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dSU = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dSV = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dSW.add(this.dST);
            this.dSW.add(this.dSU);
            this.dSW.add(this.dSV);
        }
    }
}
