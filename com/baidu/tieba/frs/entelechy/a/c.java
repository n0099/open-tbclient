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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<s, a> implements View.OnClickListener {
    private boolean dqW;
    private boolean dqX;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dqW = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dqX = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(d.i.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bwT()) {
            String bwU = sVar.bwU();
            if (bwU != null) {
                aVar.dqZ.setText(bwU);
            } else if (this.djc != null && this.djc.baT() != null && this.djc.baT().getName() != null) {
                TextView textView = aVar.dqZ;
                Context context = this.mContext;
                int i2 = d.k.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.djc == null ? "" : this.djc.baT().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dqY.setTag(Integer.valueOf(i));
            aVar.dqY.setOnClickListener(this);
            aVar.dqY.setVisibility(0);
        } else {
            aVar.dqY.setVisibility(8);
            aVar.drf.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bwV = sVar.bwV();
        if (bwV != null && bwV.bwM() && !TextUtils.isEmpty(bwV.bwN())) {
            aVar.drb.setText(bwV.bwN());
            aVar.dra.setTag(Integer.valueOf(i));
            aVar.dra.setOnClickListener(this);
            aVar.dra.setVisibility(0);
        } else {
            aVar.dra.setVisibility(8);
            aVar.drg.setVisibility(8);
        }
        if (this.dqX) {
            aVar.drc.setVisibility(0);
        } else {
            aVar.drc.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.djc == null || this.djc.getUserData() == null || !this.djc.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.drd.setVisibility(0);
            am.i(aVar.drd, d.f.frs_top_item_bg);
            aVar.drc.setVisibility(0);
            aVar.drd.setOnClickListener(this);
            aVar.drd.setTag(Integer.valueOf(i));
        } else {
            aVar.drd.setVisibility(8);
            aVar.drh.setVisibility(8);
        }
        if (!this.dqW && !sVar.bwT()) {
            if (z) {
                aVar.dqY.setVisibility(8);
                aVar.dra.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dri;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.djd != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bc) {
                View n = n(this.dje.getListView(), intValue);
                this.djd.a(id, intValue, view, n, (bc) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dqY;
        TextView dqZ;
        View dra;
        TextView drb;
        View drc;
        View drd;
        TextView dre;
        View drf;
        View drg;
        View drh;
        List<View> dri;

        a(View view) {
            super(view);
            this.dri = new ArrayList();
            this.dqZ = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dqY = view.findViewById(d.g.frs_fortune_bag_item);
            this.dra = view.findViewById(d.g.frs_my_service_item);
            this.drb = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.drc = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.drd = view.findViewById(d.g.frs_bawu_center);
            this.dre = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.drf = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.drg = view.findViewById(d.g.official_account_text_divider_service_top);
            this.drh = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dri.add(this.drf);
            this.dri.add(this.drg);
            this.dri.add(this.drh);
        }
    }
}
