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
    private boolean dKn;
    private boolean dKo;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dKn = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dKo = z;
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
        if (sVar.bwn()) {
            String bwo = sVar.bwo();
            if (bwo != null) {
                aVar.dKq.setText(bwo);
            } else if (this.dDP != null && this.dDP.bar() != null && this.dDP.bar().getName() != null) {
                TextView textView = aVar.dKq;
                Context context = this.mContext;
                int i2 = d.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dDP == null ? "" : this.dDP.bar().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dKp.setTag(Integer.valueOf(i));
            aVar.dKp.setOnClickListener(this);
            aVar.dKp.setVisibility(0);
        } else {
            aVar.dKp.setVisibility(8);
            aVar.dKw.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bwp = sVar.bwp();
        if (bwp != null && bwp.bwg() && !TextUtils.isEmpty(bwp.bwh())) {
            aVar.dKs.setText(bwp.bwh());
            aVar.dKr.setTag(Integer.valueOf(i));
            aVar.dKr.setOnClickListener(this);
            aVar.dKr.setVisibility(0);
        } else {
            aVar.dKr.setVisibility(8);
            aVar.dKx.setVisibility(8);
        }
        if (this.dKo) {
            aVar.dKt.setVisibility(0);
        } else {
            aVar.dKt.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().aQ(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().aM(view);
        if (this.dDP == null || this.dDP.getUserData() == null || !this.dDP.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dKu.setVisibility(0);
            aj.s(aVar.dKu, d.f.frs_top_item_bg);
            aVar.dKt.setVisibility(0);
            aVar.dKu.setOnClickListener(this);
            aVar.dKu.setTag(Integer.valueOf(i));
        } else {
            aVar.dKu.setVisibility(8);
            aVar.dKy.setVisibility(8);
        }
        if (!this.dKn && !sVar.bwn()) {
            if (z) {
                aVar.dKp.setVisibility(8);
                aVar.dKr.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dKz;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dDQ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bd) {
                View i = i(this.dDR.getListView(), intValue);
                this.dDQ.a(id, intValue, view, i, (bd) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends r.a {
        View dKp;
        TextView dKq;
        View dKr;
        TextView dKs;
        View dKt;
        View dKu;
        TextView dKv;
        View dKw;
        View dKx;
        View dKy;
        List<View> dKz;

        a(View view) {
            super(view);
            this.dKz = new ArrayList();
            this.dKq = (TextView) view.findViewById(d.g.frs_fortune_bag_content);
            this.dKp = view.findViewById(d.g.frs_fortune_bag_item);
            this.dKr = view.findViewById(d.g.frs_my_service_item);
            this.dKs = (TextView) view.findViewById(d.g.frs_my_service_content);
            this.dKt = view.findViewById(d.g.frs_list_item_official_buttom_line);
            this.dKu = view.findViewById(d.g.frs_bawu_center);
            this.dKv = (TextView) view.findViewById(d.g.frs_bawu_center_inner);
            this.dKw = view.findViewById(d.g.official_account_text_divider_fortune_top);
            this.dKx = view.findViewById(d.g.official_account_text_divider_service_top);
            this.dKy = view.findViewById(d.g.official_account_text_divider_bawucenter_top);
            this.dKz.add(this.dKw);
            this.dKz.add(this.dKx);
            this.dKz.add(this.dKy);
        }
    }
}
