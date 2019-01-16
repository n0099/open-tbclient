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
    private boolean dTq;
    private boolean dTr;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dTq = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dTr = z;
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
                aVar.dTt.setText(bEl);
            } else if (this.dLc != null && this.dLc.bhx() != null && this.dLc.bhx().getName() != null) {
                TextView textView = aVar.dTt;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dLc == null ? "" : this.dLc.bhx().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dTs.setTag(Integer.valueOf(i));
            aVar.dTs.setOnClickListener(this);
            aVar.dTs.setVisibility(0);
        } else {
            aVar.dTs.setVisibility(8);
            aVar.dTz.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bEm = sVar.bEm();
        if (bEm != null && bEm.bEd() && !TextUtils.isEmpty(bEm.bEe())) {
            aVar.dTv.setText(bEm.bEe());
            aVar.dTu.setTag(Integer.valueOf(i));
            aVar.dTu.setOnClickListener(this);
            aVar.dTu.setVisibility(0);
        } else {
            aVar.dTu.setVisibility(8);
            aVar.dTA.setVisibility(8);
        }
        if (this.dTr) {
            aVar.dTw.setVisibility(0);
        } else {
            aVar.dTw.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dLc == null || this.dLc.getUserData() == null || !this.dLc.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dTx.setVisibility(0);
            al.i(aVar.dTx, e.f.frs_top_item_bg);
            aVar.dTw.setVisibility(0);
            aVar.dTx.setOnClickListener(this);
            aVar.dTx.setTag(Integer.valueOf(i));
        } else {
            aVar.dTx.setVisibility(8);
            aVar.dTB.setVisibility(8);
        }
        if (!this.dTq && !sVar.bEk()) {
            if (z) {
                aVar.dTs.setVisibility(8);
                aVar.dTu.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dTC;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dLd != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dLe.getListView(), intValue);
                this.dLd.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dTA;
        View dTB;
        List<View> dTC;
        View dTs;
        TextView dTt;
        View dTu;
        TextView dTv;
        View dTw;
        View dTx;
        TextView dTy;
        View dTz;

        a(View view) {
            super(view);
            this.dTC = new ArrayList();
            this.dTt = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dTs = view.findViewById(e.g.frs_fortune_bag_item);
            this.dTu = view.findViewById(e.g.frs_my_service_item);
            this.dTv = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dTw = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dTx = view.findViewById(e.g.frs_bawu_center);
            this.dTy = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dTz = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dTA = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dTB = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dTC.add(this.dTz);
            this.dTC.add(this.dTA);
            this.dTC.add(this.dTB);
        }
    }
}
