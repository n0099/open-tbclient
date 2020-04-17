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
    private boolean hgK;
    private boolean hgL;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hgK = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hgL = z;
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
        if (vVar.cVO()) {
            String cVP = vVar.cVP();
            if (cVP != null) {
                aVar.hgN.setText(cVP);
            } else if (this.gXO != null && this.gXO.getForum() != null && this.gXO.getForum().getName() != null) {
                TextView textView = aVar.hgN;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.gXO == null ? "" : this.gXO.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.hgM.setTag(Integer.valueOf(i));
            aVar.hgM.setOnClickListener(this);
            aVar.hgM.setVisibility(0);
        } else {
            aVar.hgM.setVisibility(8);
            aVar.hgT.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p cVQ = vVar.cVQ();
        if (cVQ != null && cVQ.cVH() && !TextUtils.isEmpty(cVQ.cVI())) {
            aVar.hgP.setText(cVQ.cVI());
            aVar.hgO.setTag(Integer.valueOf(i));
            aVar.hgO.setOnClickListener(this);
            aVar.hgO.setVisibility(0);
        } else {
            aVar.hgO.setVisibility(8);
            aVar.hgU.setVisibility(8);
        }
        if (this.hgL) {
            aVar.hgQ.setVisibility(0);
        } else {
            aVar.hgQ.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.gXO == null || this.gXO.getUserData() == null || !this.gXO.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hgR.setVisibility(0);
            am.setBackgroundResource(aVar.hgR, R.drawable.frs_top_item_bg);
            aVar.hgQ.setVisibility(0);
            aVar.hgR.setOnClickListener(this);
            aVar.hgR.setTag(Integer.valueOf(i));
        } else {
            aVar.hgR.setVisibility(8);
            aVar.hgV.setVisibility(8);
        }
        if (!this.hgK && !vVar.cVO()) {
            if (z) {
                aVar.hgM.setVisibility(8);
                aVar.hgO.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hgW;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gXP != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View u = u(this.gEc.getListView(), intValue);
                this.gXP.a(id, intValue, view, u, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends y.a {
        View hgM;
        TextView hgN;
        View hgO;
        TextView hgP;
        View hgQ;
        View hgR;
        TextView hgS;
        View hgT;
        View hgU;
        View hgV;
        List<View> hgW;

        a(View view) {
            super(view);
            this.hgW = new ArrayList();
            this.hgN = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hgM = view.findViewById(R.id.frs_fortune_bag_item);
            this.hgO = view.findViewById(R.id.frs_my_service_item);
            this.hgP = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hgQ = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hgR = view.findViewById(R.id.frs_bawu_center);
            this.hgS = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hgT = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hgU = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hgV = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hgW.add(this.hgT);
            this.hgW.add(this.hgU);
            this.hgW.add(this.hgV);
        }
    }
}
