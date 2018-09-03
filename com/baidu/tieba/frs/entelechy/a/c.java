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
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.s;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.frs.h<s, a> implements View.OnClickListener {
    private boolean dtG;
    private boolean dtH;

    public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.dtG = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.dtH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ap */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(f.h.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, s sVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, sVar, aVar);
        if (sVar.bvy()) {
            String bvz = sVar.bvz();
            if (bvz != null) {
                aVar.dtJ.setText(bvz);
            } else if (this.dlQ != null && this.dlQ.aZg() != null && this.dlQ.aZg().getName() != null) {
                TextView textView = aVar.dtJ;
                Context context = this.mContext;
                int i2 = f.j.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.dlQ == null ? "" : this.dlQ.aZg().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.dtI.setTag(Integer.valueOf(i));
            aVar.dtI.setOnClickListener(this);
            aVar.dtI.setVisibility(0);
        } else {
            aVar.dtI.setVisibility(8);
            aVar.dtP.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.m bvA = sVar.bvA();
        if (bvA != null && bvA.bvr() && !TextUtils.isEmpty(bvA.bvs())) {
            aVar.dtL.setText(bvA.bvs());
            aVar.dtK.setTag(Integer.valueOf(i));
            aVar.dtK.setOnClickListener(this);
            aVar.dtK.setVisibility(0);
        } else {
            aVar.dtK.setVisibility(8);
            aVar.dtQ.setVisibility(8);
        }
        if (this.dtH) {
            aVar.dtM.setVisibility(0);
        } else {
            aVar.dtM.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.dlQ == null || this.dlQ.getUserData() == null || !this.dlQ.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.dtN.setVisibility(0);
            am.i(aVar.dtN, f.C0146f.frs_top_item_bg);
            aVar.dtM.setVisibility(0);
            aVar.dtN.setOnClickListener(this);
            aVar.dtN.setTag(Integer.valueOf(i));
        } else {
            aVar.dtN.setVisibility(8);
            aVar.dtR.setVisibility(8);
        }
        if (!this.dtG && !sVar.bvy()) {
            if (z) {
                aVar.dtI.setVisibility(8);
                aVar.dtK.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.dtS;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.dlR != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bb) {
                View m = m(this.dlS.getListView(), intValue);
                this.dlR.a(id, intValue, view, m, (bb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a extends q.a {
        View dtI;
        TextView dtJ;
        View dtK;
        TextView dtL;
        View dtM;
        View dtN;
        TextView dtO;
        View dtP;
        View dtQ;
        View dtR;
        List<View> dtS;

        a(View view) {
            super(view);
            this.dtS = new ArrayList();
            this.dtJ = (TextView) view.findViewById(f.g.frs_fortune_bag_content);
            this.dtI = view.findViewById(f.g.frs_fortune_bag_item);
            this.dtK = view.findViewById(f.g.frs_my_service_item);
            this.dtL = (TextView) view.findViewById(f.g.frs_my_service_content);
            this.dtM = view.findViewById(f.g.frs_list_item_official_buttom_line);
            this.dtN = view.findViewById(f.g.frs_bawu_center);
            this.dtO = (TextView) view.findViewById(f.g.frs_bawu_center_inner);
            this.dtP = view.findViewById(f.g.official_account_text_divider_fortune_top);
            this.dtQ = view.findViewById(f.g.official_account_text_divider_service_top);
            this.dtR = view.findViewById(f.g.official_account_text_divider_bawucenter_top);
            this.dtS.add(this.dtP);
            this.dtS.add(this.dtQ);
            this.dtS.add(this.dtR);
        }
    }
}
