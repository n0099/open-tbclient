package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.u, a> implements View.OnClickListener {
    private boolean grh;
    private boolean gri;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.grh = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gri = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.u uVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tieba.tbadkCore.u) aVar);
        if (uVar.cHL()) {
            String cHM = uVar.cHM();
            if (cHM != null) {
                aVar.grk.setText(cHM);
            } else if (this.giA != null && this.giA.getForum() != null && this.giA.getForum().getName() != null) {
                TextView textView = aVar.grk;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.giA == null ? "" : this.giA.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.grj.setTag(Integer.valueOf(i));
            aVar.grj.setOnClickListener(this);
            aVar.grj.setVisibility(0);
        } else {
            aVar.grj.setVisibility(8);
            aVar.grq.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cHN = uVar.cHN();
        if (cHN != null && cHN.cHE() && !TextUtils.isEmpty(cHN.cHF())) {
            aVar.grm.setText(cHN.cHF());
            aVar.grl.setTag(Integer.valueOf(i));
            aVar.grl.setOnClickListener(this);
            aVar.grl.setVisibility(0);
        } else {
            aVar.grl.setVisibility(8);
            aVar.grr.setVisibility(8);
        }
        if (this.gri) {
            aVar.grn.setVisibility(0);
        } else {
            aVar.grn.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.giA == null || this.giA.getUserData() == null || !this.giA.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gro.setVisibility(0);
            am.setBackgroundResource(aVar.gro, R.drawable.frs_top_item_bg);
            aVar.grn.setVisibility(0);
            aVar.gro.setOnClickListener(this);
            aVar.gro.setTag(Integer.valueOf(i));
        } else {
            aVar.gro.setVisibility(8);
            aVar.grs.setVisibility(8);
        }
        if (!this.grh && !uVar.cHL()) {
            if (z) {
                aVar.grj.setVisibility(8);
                aVar.grl.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.grt;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.giB != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fRq.getListView(), intValue);
                this.giB.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a extends v.a {
        View grj;
        TextView grk;
        View grl;
        TextView grm;
        View grn;
        View gro;
        TextView grp;
        View grq;
        View grr;
        View grs;
        List<View> grt;

        a(View view) {
            super(view);
            this.grt = new ArrayList();
            this.grk = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.grj = view.findViewById(R.id.frs_fortune_bag_item);
            this.grl = view.findViewById(R.id.frs_my_service_item);
            this.grm = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.grn = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gro = view.findViewById(R.id.frs_bawu_center);
            this.grp = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.grq = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.grr = view.findViewById(R.id.official_account_text_divider_service_top);
            this.grs = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.grt.add(this.grq);
            this.grt.add(this.grr);
            this.grt.add(this.grs);
        }
    }
}
