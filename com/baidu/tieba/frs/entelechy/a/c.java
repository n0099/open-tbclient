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
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.f<s, a> implements View.OnClickListener {
    private boolean dnN;
    private boolean dnO;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dnN = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dnO = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aq */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.f, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bws()) {
            String bwt = sVar.bwt();
            if (bwt != null) {
                aVar.dnQ.setText(bwt);
            } else if (this.dhf != null && this.dhf.bam() != null && this.dhf.bam().getName() != null) {
                TextView textView = aVar.dnQ;
                Context context = this.mContext;
                int i2 = d.k.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dhf == null ? "" : this.dhf.bam().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dnP.setTag(Integer.valueOf(i));
            aVar.dnP.setOnClickListener(this);
            aVar.dnP.setVisibility(0);
        } else {
            aVar.dnP.setVisibility(8);
            aVar.dnW.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bwu = sVar.bwu();
        if (bwu != null && bwu.bwl() && !TextUtils.isEmpty(bwu.bwm())) {
            aVar.dnS.setText(bwu.bwm());
            aVar.dnR.setTag(Integer.valueOf(i));
            aVar.dnR.setOnClickListener(this);
            aVar.dnR.setVisibility(0);
        } else {
            aVar.dnR.setVisibility(8);
            aVar.dnX.setVisibility(8);
        }
        if (this.dnO) {
            aVar.dnT.setVisibility(0);
        } else {
            aVar.dnT.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dhf == null || this.dhf.getUserData() == null || !this.dhf.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dnU.setVisibility(0);
            al.i(aVar.dnU, d.f.frs_top_item_bg);
            aVar.dnT.setVisibility(0);
            aVar.dnU.setOnClickListener(this);
            aVar.dnU.setTag(Integer.valueOf(i));
        } else {
            aVar.dnU.setVisibility(8);
            aVar.dnY.setVisibility(8);
        }
        if (!this.dnN && !sVar.bws()) {
            if (z) {
                aVar.dnP.setVisibility(8);
                aVar.dnR.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dnZ;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dhg != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View j = j(this.dhh.getListView(), intValue);
                this.dhg.a(id, intValue, view, j, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dnP;
        TextView dnQ;
        View dnR;
        TextView dnS;
        View dnT;
        View dnU;
        TextView dnV;
        View dnW;
        View dnX;
        View dnY;
        List<View> dnZ;

        a(View view) {
            super(view);
            this.dnZ = new ArrayList();
            this.dnQ = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dnP = view.findViewById(d.g.frs_fortune_bag_item);
            this.dnR = view.findViewById(d.g.frs_my_service_item);
            this.dnS = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.dnT = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.dnU = view.findViewById(d.g.frs_bawu_center);
            this.dnV = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.dnW = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.dnX = view.findViewById(d.g.official_account_text_divider_service_top);
            this.dnY = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dnZ.add(this.dnW);
            this.dnZ.add(this.dnX);
            this.dnZ.add(this.dnY);
        }
    }
}
