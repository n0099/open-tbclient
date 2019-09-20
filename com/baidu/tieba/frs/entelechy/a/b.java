package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.u, a> implements View.OnClickListener {
    private boolean fEp;
    private boolean fEq;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fEp = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fEq = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aJ */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.u uVar, a aVar) {
        boolean z = true;
        super.onFillViewHolder(i, view, viewGroup, uVar, aVar);
        if (uVar.cpR()) {
            String cpS = uVar.cpS();
            if (cpS != null) {
                aVar.fEs.setText(cpS);
            } else if (this.fvE != null && this.fvE.getForum() != null && this.fvE.getForum().getName() != null) {
                TextView textView = aVar.fEs;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fvE == null ? "" : this.fvE.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fEr.setTag(Integer.valueOf(i));
            aVar.fEr.setOnClickListener(this);
            aVar.fEr.setVisibility(0);
        } else {
            aVar.fEr.setVisibility(8);
            aVar.fEy.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cpT = uVar.cpT();
        if (cpT != null && cpT.cpK() && !TextUtils.isEmpty(cpT.cpL())) {
            aVar.fEu.setText(cpT.cpL());
            aVar.fEt.setTag(Integer.valueOf(i));
            aVar.fEt.setOnClickListener(this);
            aVar.fEt.setVisibility(0);
        } else {
            aVar.fEt.setVisibility(8);
            aVar.fEz.setVisibility(8);
        }
        if (this.fEq) {
            aVar.fEv.setVisibility(0);
        } else {
            aVar.fEv.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fvE == null || this.fvE.getUserData() == null || !this.fvE.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fEw.setVisibility(0);
            am.k(aVar.fEw, R.drawable.frs_top_item_bg);
            aVar.fEv.setVisibility(0);
            aVar.fEw.setOnClickListener(this);
            aVar.fEw.setTag(Integer.valueOf(i));
        } else {
            aVar.fEw.setVisibility(8);
            aVar.fEA.setVisibility(8);
        }
        if (!this.fEp && !uVar.cpR()) {
            if (z) {
                aVar.fEr.setVisibility(8);
                aVar.fEt.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fEB;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fvF != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bh) {
                View s = s(this.faT.getListView(), intValue);
                this.fvF.a(id, intValue, view, s, (bh) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fEA;
        List<View> fEB;
        View fEr;
        TextView fEs;
        View fEt;
        TextView fEu;
        View fEv;
        View fEw;
        TextView fEx;
        View fEy;
        View fEz;

        a(View view) {
            super(view);
            this.fEB = new ArrayList();
            this.fEs = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fEr = view.findViewById(R.id.frs_fortune_bag_item);
            this.fEt = view.findViewById(R.id.frs_my_service_item);
            this.fEu = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fEv = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fEw = view.findViewById(R.id.frs_bawu_center);
            this.fEx = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fEy = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fEz = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fEA = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fEB.add(this.fEy);
            this.fEB.add(this.fEz);
            this.fEB.add(this.fEA);
        }
    }
}
