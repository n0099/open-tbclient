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
    private boolean dPT;
    private boolean dPU;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dPT = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dPU = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
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
        if (sVar.bCK()) {
            String bCL = sVar.bCL();
            if (bCL != null) {
                aVar.dPW.setText(bCL);
            } else if (this.dHF != null && this.dHF.bgi() != null && this.dHF.bgi().getName() != null) {
                TextView textView = aVar.dPW;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dHF == null ? "" : this.dHF.bgi().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dPV.setTag(Integer.valueOf(i));
            aVar.dPV.setOnClickListener(this);
            aVar.dPV.setVisibility(0);
        } else {
            aVar.dPV.setVisibility(8);
            aVar.dQc.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bCM = sVar.bCM();
        if (bCM != null && bCM.bCD() && !TextUtils.isEmpty(bCM.bCE())) {
            aVar.dPY.setText(bCM.bCE());
            aVar.dPX.setTag(Integer.valueOf(i));
            aVar.dPX.setOnClickListener(this);
            aVar.dPX.setVisibility(0);
        } else {
            aVar.dPX.setVisibility(8);
            aVar.dQd.setVisibility(8);
        }
        if (this.dPU) {
            aVar.dPZ.setVisibility(0);
        } else {
            aVar.dPZ.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dHF == null || this.dHF.getUserData() == null || !this.dHF.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dQa.setVisibility(0);
            al.i(aVar.dQa, e.f.frs_top_item_bg);
            aVar.dPZ.setVisibility(0);
            aVar.dQa.setOnClickListener(this);
            aVar.dQa.setTag(Integer.valueOf(i));
        } else {
            aVar.dQa.setVisibility(8);
            aVar.dQe.setVisibility(8);
        }
        if (!this.dPT && !sVar.bCK()) {
            if (z) {
                aVar.dPV.setVisibility(8);
                aVar.dPX.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dQf;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dHG != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dHH.getListView(), intValue);
                this.dHG.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dPV;
        TextView dPW;
        View dPX;
        TextView dPY;
        View dPZ;
        View dQa;
        TextView dQb;
        View dQc;
        View dQd;
        View dQe;
        List<View> dQf;

        a(View view) {
            super(view);
            this.dQf = new ArrayList();
            this.dPW = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dPV = view.findViewById(e.g.frs_fortune_bag_item);
            this.dPX = view.findViewById(e.g.frs_my_service_item);
            this.dPY = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dPZ = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dQa = view.findViewById(e.g.frs_bawu_center);
            this.dQb = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dQc = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dQd = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dQe = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dQf.add(this.dQc);
            this.dQf.add(this.dQd);
            this.dQf.add(this.dQe);
        }
    }
}
