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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<s, a> implements View.OnClickListener {
    private boolean dtJ;
    private boolean dtK;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dtJ = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dtK = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.h.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bvx()) {
            String bvy = sVar.bvy();
            if (bvy != null) {
                aVar.dtM.setText(bvy);
            } else if (this.dlS != null && this.dlS.aZl() != null && this.dlS.aZl().getName() != null) {
                TextView textView = aVar.dtM;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dlS == null ? "" : this.dlS.aZl().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dtL.setTag(Integer.valueOf(i));
            aVar.dtL.setOnClickListener(this);
            aVar.dtL.setVisibility(0);
        } else {
            aVar.dtL.setVisibility(8);
            aVar.dtS.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bvz = sVar.bvz();
        if (bvz != null && bvz.bvq() && !TextUtils.isEmpty(bvz.bvr())) {
            aVar.dtO.setText(bvz.bvr());
            aVar.dtN.setTag(Integer.valueOf(i));
            aVar.dtN.setOnClickListener(this);
            aVar.dtN.setVisibility(0);
        } else {
            aVar.dtN.setVisibility(8);
            aVar.dtT.setVisibility(8);
        }
        if (this.dtK) {
            aVar.dtP.setVisibility(0);
        } else {
            aVar.dtP.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dlS == null || this.dlS.getUserData() == null || !this.dlS.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dtQ.setVisibility(0);
            am.i(aVar.dtQ, d.f.frs_top_item_bg);
            aVar.dtP.setVisibility(0);
            aVar.dtQ.setOnClickListener(this);
            aVar.dtQ.setTag(Integer.valueOf(i));
        } else {
            aVar.dtQ.setVisibility(8);
            aVar.dtU.setVisibility(8);
        }
        if (!this.dtJ && !sVar.bvx()) {
            if (z) {
                aVar.dtL.setVisibility(8);
                aVar.dtN.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dtV;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dlT != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View m = m(this.dlU.getListView(), intValue);
                this.dlT.a(id, intValue, view, m, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dtL;
        TextView dtM;
        View dtN;
        TextView dtO;
        View dtP;
        View dtQ;
        TextView dtR;
        View dtS;
        View dtT;
        View dtU;
        List<View> dtV;

        a(View view) {
            super(view);
            this.dtV = new ArrayList();
            this.dtM = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dtL = view.findViewById(d.g.frs_fortune_bag_item);
            this.dtN = view.findViewById(d.g.frs_my_service_item);
            this.dtO = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.dtP = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.dtQ = view.findViewById(d.g.frs_bawu_center);
            this.dtR = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.dtS = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.dtT = view.findViewById(d.g.official_account_text_divider_service_top);
            this.dtU = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dtV.add(this.dtS);
            this.dtV.add(this.dtT);
            this.dtV.add(this.dtU);
        }
    }
}
