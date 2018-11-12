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
    private boolean dJq;
    private boolean dJr;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dJq = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dJr = z;
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
        if (sVar.bAP()) {
            String bAQ = sVar.bAQ();
            if (bAQ != null) {
                aVar.dJt.setText(bAQ);
            } else if (this.dBg != null && this.dBg.ber() != null && this.dBg.ber().getName() != null) {
                TextView textView = aVar.dJt;
                Context context = this.mContext;
                int i2 = e.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dBg == null ? "" : this.dBg.ber().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dJs.setTag(Integer.valueOf(i));
            aVar.dJs.setOnClickListener(this);
            aVar.dJs.setVisibility(0);
        } else {
            aVar.dJs.setVisibility(8);
            aVar.dJz.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bAR = sVar.bAR();
        if (bAR != null && bAR.bAI() && !TextUtils.isEmpty(bAR.bAJ())) {
            aVar.dJv.setText(bAR.bAJ());
            aVar.dJu.setTag(Integer.valueOf(i));
            aVar.dJu.setOnClickListener(this);
            aVar.dJu.setVisibility(0);
        } else {
            aVar.dJu.setVisibility(8);
            aVar.dJA.setVisibility(8);
        }
        if (this.dJr) {
            aVar.dJw.setVisibility(0);
        } else {
            aVar.dJw.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dBg == null || this.dBg.getUserData() == null || !this.dBg.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dJx.setVisibility(0);
            al.i(aVar.dJx, e.f.frs_top_item_bg);
            aVar.dJw.setVisibility(0);
            aVar.dJx.setOnClickListener(this);
            aVar.dJx.setTag(Integer.valueOf(i));
        } else {
            aVar.dJx.setVisibility(8);
            aVar.dJB.setVisibility(8);
        }
        if (!this.dJq && !sVar.bAP()) {
            if (z) {
                aVar.dJs.setVisibility(8);
                aVar.dJu.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dJC;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dBh != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View o = o(this.dBi.getListView(), intValue);
                this.dBh.a(id, intValue, view, o, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dJA;
        View dJB;
        List<View> dJC;
        View dJs;
        TextView dJt;
        View dJu;
        TextView dJv;
        View dJw;
        View dJx;
        TextView dJy;
        View dJz;

        a(View view) {
            super(view);
            this.dJC = new ArrayList();
            this.dJt = (TextView) view.findViewById(e.g.frs_fortune_bag_content);
            this.dJs = view.findViewById(e.g.frs_fortune_bag_item);
            this.dJu = view.findViewById(e.g.frs_my_service_item);
            this.dJv = (TextView) view.findViewById(e.g.frs_my_service_content);
            this.dJw = view.findViewById(e.g.frs_list_item_official_buttom_line);
            this.dJx = view.findViewById(e.g.frs_bawu_center);
            this.dJy = (TextView) view.findViewById(e.g.frs_bawu_center_inner);
            this.dJz = view.findViewById(e.g.official_account_text_divider_fortune_top);
            this.dJA = view.findViewById(e.g.official_account_text_divider_service_top);
            this.dJB = view.findViewById(e.g.official_account_text_divider_bawucenter_top);
            this.dJC.add(this.dJz);
            this.dJC.add(this.dJA);
            this.dJC.add(this.dJB);
        }
    }
}
