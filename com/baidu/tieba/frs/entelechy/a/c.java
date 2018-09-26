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
    private boolean dAm;
    private boolean dAn;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dAm = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dAn = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
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
        if (sVar.bye()) {
            String byf = sVar.byf();
            if (byf != null) {
                aVar.dAp.setText(byf);
            } else if (this.drN != null && this.drN.bbH() != null && this.drN.bbH().getName() != null) {
                TextView textView = aVar.dAp;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.drN == null ? "" : this.drN.bbH().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dAo.setTag(Integer.valueOf(i));
            aVar.dAo.setOnClickListener(this);
            aVar.dAo.setVisibility(0);
        } else {
            aVar.dAo.setVisibility(8);
            aVar.dAv.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m byg = sVar.byg();
        if (byg != null && byg.bxX() && !TextUtils.isEmpty(byg.bxY())) {
            aVar.dAr.setText(byg.bxY());
            aVar.dAq.setTag(Integer.valueOf(i));
            aVar.dAq.setOnClickListener(this);
            aVar.dAq.setVisibility(0);
        } else {
            aVar.dAq.setVisibility(8);
            aVar.dAw.setVisibility(8);
        }
        if (this.dAn) {
            aVar.dAs.setVisibility(0);
        } else {
            aVar.dAs.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.drN == null || this.drN.getUserData() == null || !this.drN.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dAt.setVisibility(0);
            al.i(aVar.dAt, e.f.frs_top_item_bg);
            aVar.dAs.setVisibility(0);
            aVar.dAt.setOnClickListener(this);
            aVar.dAt.setTag(Integer.valueOf(i));
        } else {
            aVar.dAt.setVisibility(8);
            aVar.dAx.setVisibility(8);
        }
        if (!this.dAm && !sVar.bye()) {
            if (z) {
                aVar.dAo.setVisibility(8);
                aVar.dAq.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dAy;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.drO != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View m = m(this.drP.getListView(), intValue);
                this.drO.a(id, intValue, view, m, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dAo;
        TextView dAp;
        View dAq;
        TextView dAr;
        View dAs;
        View dAt;
        TextView dAu;
        View dAv;
        View dAw;
        View dAx;
        List<View> dAy;

        a(View view) {
            super(view);
            this.dAy = new ArrayList();
            this.dAp = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dAo = view.findViewById(e.g.frs_fortune_bag_item);
            this.dAq = view.findViewById(e.g.frs_my_service_item);
            this.dAr = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dAs = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dAt = view.findViewById(e.g.frs_bawu_center);
            this.dAu = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dAv = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dAw = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dAx = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dAy.add(this.dAv);
            this.dAy.add(this.dAw);
            this.dAy.add(this.dAx);
        }
    }
}
