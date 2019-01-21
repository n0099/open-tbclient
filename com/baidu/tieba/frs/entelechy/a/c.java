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
    private boolean dTr;
    private boolean dTs;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dTr = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dTs = z;
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
        if (sVar.bEk()) {
            String bEl = sVar.bEl();
            if (bEl != null) {
                aVar.dTu.setText(bEl);
            } else if (this.dLd != null && this.dLd.bhx() != null && this.dLd.bhx().getName() != null) {
                TextView textView = aVar.dTu;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dLd == null ? "" : this.dLd.bhx().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dTt.setTag(Integer.valueOf(i));
            aVar.dTt.setOnClickListener(this);
            aVar.dTt.setVisibility(0);
        } else {
            aVar.dTt.setVisibility(8);
            aVar.dTA.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bEm = sVar.bEm();
        if (bEm != null && bEm.bEd() && !TextUtils.isEmpty(bEm.bEe())) {
            aVar.dTw.setText(bEm.bEe());
            aVar.dTv.setTag(Integer.valueOf(i));
            aVar.dTv.setOnClickListener(this);
            aVar.dTv.setVisibility(0);
        } else {
            aVar.dTv.setVisibility(8);
            aVar.dTB.setVisibility(8);
        }
        if (this.dTs) {
            aVar.dTx.setVisibility(0);
        } else {
            aVar.dTx.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dLd == null || this.dLd.getUserData() == null || !this.dLd.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dTy.setVisibility(0);
            al.i(aVar.dTy, e.f.frs_top_item_bg);
            aVar.dTx.setVisibility(0);
            aVar.dTy.setOnClickListener(this);
            aVar.dTy.setTag(Integer.valueOf(i));
        } else {
            aVar.dTy.setVisibility(8);
            aVar.dTC.setVisibility(8);
        }
        if (!this.dTr && !sVar.bEk()) {
            if (z) {
                aVar.dTt.setVisibility(8);
                aVar.dTv.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dTD;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dLe != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dLf.getListView(), intValue);
                this.dLe.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dTA;
        View dTB;
        View dTC;
        List<View> dTD;
        View dTt;
        TextView dTu;
        View dTv;
        TextView dTw;
        View dTx;
        View dTy;
        TextView dTz;

        a(View view) {
            super(view);
            this.dTD = new ArrayList();
            this.dTu = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dTt = view.findViewById(e.g.frs_fortune_bag_item);
            this.dTv = view.findViewById(e.g.frs_my_service_item);
            this.dTw = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dTx = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dTy = view.findViewById(e.g.frs_bawu_center);
            this.dTz = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dTA = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dTB = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dTC = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dTD.add(this.dTA);
            this.dTD.add(this.dTB);
            this.dTD.add(this.dTC);
        }
    }
}
