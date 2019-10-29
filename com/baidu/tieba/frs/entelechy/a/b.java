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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.u, a> implements View.OnClickListener {
    private boolean fDG;
    private boolean fDH;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fDG = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.fDH = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aL */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.u uVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tieba.tbadkCore.u) aVar);
        if (uVar.cnI()) {
            String cnJ = uVar.cnJ();
            if (cnJ != null) {
                aVar.fDJ.setText(cnJ);
            } else if (this.fuR != null && this.fuR.getForum() != null && this.fuR.getForum().getName() != null) {
                TextView textView = aVar.fDJ;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fuR == null ? "" : this.fuR.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fDI.setTag(Integer.valueOf(i));
            aVar.fDI.setOnClickListener(this);
            aVar.fDI.setVisibility(0);
        } else {
            aVar.fDI.setVisibility(8);
            aVar.fDP.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cnK = uVar.cnK();
        if (cnK != null && cnK.cnB() && !TextUtils.isEmpty(cnK.cnC())) {
            aVar.fDL.setText(cnK.cnC());
            aVar.fDK.setTag(Integer.valueOf(i));
            aVar.fDK.setOnClickListener(this);
            aVar.fDK.setVisibility(0);
        } else {
            aVar.fDK.setVisibility(8);
            aVar.fDQ.setVisibility(8);
        }
        if (this.fDH) {
            aVar.fDM.setVisibility(0);
        } else {
            aVar.fDM.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fuR == null || this.fuR.getUserData() == null || !this.fuR.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fDN.setVisibility(0);
            am.setBackgroundResource(aVar.fDN, R.drawable.frs_top_item_bg);
            aVar.fDM.setVisibility(0);
            aVar.fDN.setOnClickListener(this);
            aVar.fDN.setTag(Integer.valueOf(i));
        } else {
            aVar.fDN.setVisibility(8);
            aVar.fDR.setVisibility(8);
        }
        if (!this.fDG && !uVar.cnI()) {
            if (z) {
                aVar.fDI.setVisibility(8);
                aVar.fDK.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fDS;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fuS != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bh) {
                View q = q(this.fdE.getListView(), intValue);
                this.fuS.a(id, intValue, view, q, (bh) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fDI;
        TextView fDJ;
        View fDK;
        TextView fDL;
        View fDM;
        View fDN;
        TextView fDO;
        View fDP;
        View fDQ;
        View fDR;
        List<View> fDS;

        a(View view) {
            super(view);
            this.fDS = new ArrayList();
            this.fDJ = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fDI = view.findViewById(R.id.frs_fortune_bag_item);
            this.fDK = view.findViewById(R.id.frs_my_service_item);
            this.fDL = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fDM = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fDN = view.findViewById(R.id.frs_bawu_center);
            this.fDO = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fDP = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fDQ = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fDR = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fDS.add(this.fDP);
            this.fDS.add(this.fDQ);
            this.fDS.add(this.fDR);
        }
    }
}
