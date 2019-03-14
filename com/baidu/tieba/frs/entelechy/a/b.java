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
    private boolean fgM;
    private boolean fgN;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fgM = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fgN = z;
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
        if (sVar.cdL()) {
            String cdM = sVar.cdM();
            if (cdM != null) {
                aVar.fgP.setText(cdM);
            } else if (this.eYv != null && this.eYv.getForum() != null && this.eYv.getForum().getName() != null) {
                TextView textView = aVar.fgP;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.eYv == null ? "" : this.eYv.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.fgO.setTag(Integer.valueOf(i));
            aVar.fgO.setOnClickListener(this);
            aVar.fgO.setVisibility(0);
        } else {
            aVar.fgO.setVisibility(8);
            aVar.fgV.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m cdN = sVar.cdN();
        if (cdN != null && cdN.cdE() && !TextUtils.isEmpty(cdN.cdF())) {
            aVar.fgR.setText(cdN.cdF());
            aVar.fgQ.setTag(Integer.valueOf(i));
            aVar.fgQ.setOnClickListener(this);
            aVar.fgQ.setVisibility(0);
        } else {
            aVar.fgQ.setVisibility(8);
            aVar.fgW.setVisibility(8);
        }
        if (this.fgN) {
            aVar.fgS.setVisibility(0);
        } else {
            aVar.fgS.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.eYv == null || this.eYv.getUserData() == null || !this.eYv.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fgT.setVisibility(0);
            al.k(aVar.fgT, d.f.frs_top_item_bg);
            aVar.fgS.setVisibility(0);
            aVar.fgT.setOnClickListener(this);
            aVar.fgT.setTag(Integer.valueOf(i));
        } else {
            aVar.fgT.setVisibility(8);
            aVar.fgX.setVisibility(8);
        }
        if (!this.fgM && !sVar.cdL()) {
            if (z) {
                aVar.fgO.setVisibility(8);
                aVar.fgQ.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fgY;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.eYw != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bg) {
                View p = p(this.eEr.getListView(), intValue);
                this.eYw.a(id, intValue, view, p, (bg) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fgO;
        TextView fgP;
        View fgQ;
        TextView fgR;
        View fgS;
        View fgT;
        TextView fgU;
        View fgV;
        View fgW;
        View fgX;
        List<View> fgY;

        a(View view) {
            super(view);
            this.fgY = new ArrayList();
            this.fgP = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.fgO = view.findViewById(d.g.frs_fortune_bag_item);
            this.fgQ = view.findViewById(d.g.frs_my_service_item);
            this.fgR = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.fgS = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.fgT = view.findViewById(d.g.frs_bawu_center);
            this.fgU = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.fgV = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.fgW = view.findViewById(d.g.official_account_text_divider_service_top);
            this.fgX = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.fgY.add(this.fgV);
            this.fgY.add(this.fgW);
            this.fgY.add(this.fgX);
        }
    }
}
