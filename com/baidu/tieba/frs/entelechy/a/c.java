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
    private boolean dIm;
    private boolean dIn;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dIm = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dIn = z;
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
        if (sVar.bBt()) {
            String bBu = sVar.bBu();
            if (bBu != null) {
                aVar.dIp.setText(bBu);
            } else if (this.dzP != null && this.dzP.beT() != null && this.dzP.beT().getName() != null) {
                TextView textView = aVar.dIp;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dzP == null ? "" : this.dzP.beT().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dIo.setTag(Integer.valueOf(i));
            aVar.dIo.setOnClickListener(this);
            aVar.dIo.setVisibility(0);
        } else {
            aVar.dIo.setVisibility(8);
            aVar.dIv.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bBv = sVar.bBv();
        if (bBv != null && bBv.bBm() && !TextUtils.isEmpty(bBv.bBn())) {
            aVar.dIr.setText(bBv.bBn());
            aVar.dIq.setTag(Integer.valueOf(i));
            aVar.dIq.setOnClickListener(this);
            aVar.dIq.setVisibility(0);
        } else {
            aVar.dIq.setVisibility(8);
            aVar.dIw.setVisibility(8);
        }
        if (this.dIn) {
            aVar.dIs.setVisibility(0);
        } else {
            aVar.dIs.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dzP == null || this.dzP.getUserData() == null || !this.dzP.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dIt.setVisibility(0);
            al.i(aVar.dIt, e.f.frs_top_item_bg);
            aVar.dIs.setVisibility(0);
            aVar.dIt.setOnClickListener(this);
            aVar.dIt.setTag(Integer.valueOf(i));
        } else {
            aVar.dIt.setVisibility(8);
            aVar.dIx.setVisibility(8);
        }
        if (!this.dIm && !sVar.bBt()) {
            if (z) {
                aVar.dIo.setVisibility(8);
                aVar.dIq.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dIy;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dzQ != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dzR.getListView(), intValue);
                this.dzQ.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dIo;
        TextView dIp;
        View dIq;
        TextView dIr;
        View dIs;
        View dIt;
        TextView dIu;
        View dIv;
        View dIw;
        View dIx;
        List<View> dIy;

        a(View view) {
            super(view);
            this.dIy = new ArrayList();
            this.dIp = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dIo = view.findViewById(e.g.frs_fortune_bag_item);
            this.dIq = view.findViewById(e.g.frs_my_service_item);
            this.dIr = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dIs = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dIt = view.findViewById(e.g.frs_bawu_center);
            this.dIu = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dIv = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dIw = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dIx = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dIy.add(this.dIv);
            this.dIy.add(this.dIw);
            this.dIy.add(this.dIx);
        }
    }
}
