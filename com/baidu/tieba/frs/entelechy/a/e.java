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
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.u, a> implements View.OnClickListener {
    private boolean gwF;
    private boolean gwG;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.gwF = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gwG = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aN */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.u uVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) uVar, (com.baidu.tieba.tbadkCore.u) aVar);
        if (uVar.cKy()) {
            String cKz = uVar.cKz();
            if (cKz != null) {
                aVar.gwI.setText(cKz);
            } else if (this.gnZ != null && this.gnZ.getForum() != null && this.gnZ.getForum().getName() != null) {
                TextView textView = aVar.gwI;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.gnZ == null ? "" : this.gnZ.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.gwH.setTag(Integer.valueOf(i));
            aVar.gwH.setOnClickListener(this);
            aVar.gwH.setVisibility(0);
        } else {
            aVar.gwH.setVisibility(8);
            aVar.gwO.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cKA = uVar.cKA();
        if (cKA != null && cKA.cKr() && !TextUtils.isEmpty(cKA.cKs())) {
            aVar.gwK.setText(cKA.cKs());
            aVar.gwJ.setTag(Integer.valueOf(i));
            aVar.gwJ.setOnClickListener(this);
            aVar.gwJ.setVisibility(0);
        } else {
            aVar.gwJ.setVisibility(8);
            aVar.gwP.setVisibility(8);
        }
        if (this.gwG) {
            aVar.gwL.setVisibility(0);
        } else {
            aVar.gwL.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.gnZ == null || this.gnZ.getUserData() == null || !this.gnZ.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gwM.setVisibility(0);
            am.setBackgroundResource(aVar.gwM, R.drawable.frs_top_item_bg);
            aVar.gwL.setVisibility(0);
            aVar.gwM.setOnClickListener(this);
            aVar.gwM.setTag(Integer.valueOf(i));
        } else {
            aVar.gwM.setVisibility(8);
            aVar.gwQ.setVisibility(8);
        }
        if (!this.gwF && !uVar.cKy()) {
            if (z) {
                aVar.gwH.setVisibility(8);
                aVar.gwJ.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.gwR;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.goa != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fWQ.getListView(), intValue);
                this.goa.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends v.a {
        View gwH;
        TextView gwI;
        View gwJ;
        TextView gwK;
        View gwL;
        View gwM;
        TextView gwN;
        View gwO;
        View gwP;
        View gwQ;
        List<View> gwR;

        a(View view) {
            super(view);
            this.gwR = new ArrayList();
            this.gwI = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.gwH = view.findViewById(R.id.frs_fortune_bag_item);
            this.gwJ = view.findViewById(R.id.frs_my_service_item);
            this.gwK = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.gwL = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gwM = view.findViewById(R.id.frs_bawu_center);
            this.gwN = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.gwO = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.gwP = view.findViewById(R.id.official_account_text_divider_service_top);
            this.gwQ = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.gwR.add(this.gwO);
            this.gwR.add(this.gwP);
            this.gwR.add(this.gwQ);
        }
    }
}
