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
    private boolean fCC;
    private boolean fCD;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fCC = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.fCD = z;
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
        if (uVar.cpd()) {
            String cpe = uVar.cpe();
            if (cpe != null) {
                aVar.fCF.setText(cpe);
            } else if (this.ftR != null && this.ftR.getForum() != null && this.ftR.getForum().getName() != null) {
                TextView textView = aVar.fCF;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.ftR == null ? "" : this.ftR.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fCE.setTag(Integer.valueOf(i));
            aVar.fCE.setOnClickListener(this);
            aVar.fCE.setVisibility(0);
        } else {
            aVar.fCE.setVisibility(8);
            aVar.fCL.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cpf = uVar.cpf();
        if (cpf != null && cpf.coW() && !TextUtils.isEmpty(cpf.coX())) {
            aVar.fCH.setText(cpf.coX());
            aVar.fCG.setTag(Integer.valueOf(i));
            aVar.fCG.setOnClickListener(this);
            aVar.fCG.setVisibility(0);
        } else {
            aVar.fCG.setVisibility(8);
            aVar.fCM.setVisibility(8);
        }
        if (this.fCD) {
            aVar.fCI.setVisibility(0);
        } else {
            aVar.fCI.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.ftR == null || this.ftR.getUserData() == null || !this.ftR.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fCJ.setVisibility(0);
            am.k(aVar.fCJ, R.drawable.frs_top_item_bg);
            aVar.fCI.setVisibility(0);
            aVar.fCJ.setOnClickListener(this);
            aVar.fCJ.setTag(Integer.valueOf(i));
        } else {
            aVar.fCJ.setVisibility(8);
            aVar.fCN.setVisibility(8);
        }
        if (!this.fCC && !uVar.cpd()) {
            if (z) {
                aVar.fCE.setVisibility(8);
                aVar.fCG.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fCO;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ftS != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bh) {
                View s = s(this.eZn.getListView(), intValue);
                this.ftS.a(id, intValue, view, s, (bh) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fCE;
        TextView fCF;
        View fCG;
        TextView fCH;
        View fCI;
        View fCJ;
        TextView fCK;
        View fCL;
        View fCM;
        View fCN;
        List<View> fCO;

        a(View view) {
            super(view);
            this.fCO = new ArrayList();
            this.fCF = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fCE = view.findViewById(R.id.frs_fortune_bag_item);
            this.fCG = view.findViewById(R.id.frs_my_service_item);
            this.fCH = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fCI = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fCJ = view.findViewById(R.id.frs_bawu_center);
            this.fCK = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fCL = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fCM = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fCN = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fCO.add(this.fCL);
            this.fCO.add(this.fCM);
            this.fCO.add(this.fCN);
        }
    }
}
