package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.y;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean hgQ;
    private boolean hgR;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hgQ = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hgR = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aR */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.cVL()) {
            String cVM = vVar.cVM();
            if (cVM != null) {
                aVar.hgT.setText(cVM);
            } else if (this.gXU != null && this.gXU.getForum() != null && this.gXU.getForum().getName() != null) {
                TextView textView = aVar.hgT;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.gXU == null ? "" : this.gXU.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.hgS.setTag(Integer.valueOf(i));
            aVar.hgS.setOnClickListener(this);
            aVar.hgS.setVisibility(0);
        } else {
            aVar.hgS.setVisibility(8);
            aVar.hgZ.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p cVN = vVar.cVN();
        if (cVN != null && cVN.cVE() && !TextUtils.isEmpty(cVN.cVF())) {
            aVar.hgV.setText(cVN.cVF());
            aVar.hgU.setTag(Integer.valueOf(i));
            aVar.hgU.setOnClickListener(this);
            aVar.hgU.setVisibility(0);
        } else {
            aVar.hgU.setVisibility(8);
            aVar.hha.setVisibility(8);
        }
        if (this.hgR) {
            aVar.hgW.setVisibility(0);
        } else {
            aVar.hgW.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.gXU == null || this.gXU.getUserData() == null || !this.gXU.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hgX.setVisibility(0);
            am.setBackgroundResource(aVar.hgX, R.drawable.frs_top_item_bg);
            aVar.hgW.setVisibility(0);
            aVar.hgX.setOnClickListener(this);
            aVar.hgX.setTag(Integer.valueOf(i));
        } else {
            aVar.hgX.setVisibility(8);
            aVar.hhb.setVisibility(8);
        }
        if (!this.hgQ && !vVar.cVL()) {
            if (z) {
                aVar.hgS.setVisibility(8);
                aVar.hgU.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hhc;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gXV != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View u = u(this.gEi.getListView(), intValue);
                this.gXV.a(id, intValue, view, u, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends y.a {
        View hgS;
        TextView hgT;
        View hgU;
        TextView hgV;
        View hgW;
        View hgX;
        TextView hgY;
        View hgZ;
        View hha;
        View hhb;
        List<View> hhc;

        a(View view) {
            super(view);
            this.hhc = new ArrayList();
            this.hgT = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hgS = view.findViewById(R.id.frs_fortune_bag_item);
            this.hgU = view.findViewById(R.id.frs_my_service_item);
            this.hgV = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hgW = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hgX = view.findViewById(R.id.frs_bawu_center);
            this.hgY = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hgZ = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hha = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hhb = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hhc.add(this.hgZ);
            this.hhc.add(this.hha);
            this.hhc.add(this.hhb);
        }
    }
}
