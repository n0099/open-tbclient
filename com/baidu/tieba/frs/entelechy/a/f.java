package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.aa;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bk;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.frs.h<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean hvE;
    private boolean hvF;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hvE = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hvF = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bc */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.h, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.dcQ()) {
            String dcR = vVar.dcR();
            if (dcR != null) {
                aVar.hvH.setText(dcR);
            } else if (this.hmG != null && this.hmG.getForum() != null && this.hmG.getForum().getName() != null) {
                TextView textView = aVar.hvH;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hmG == null ? "" : this.hmG.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.hvG.setTag(Integer.valueOf(i));
            aVar.hvG.setOnClickListener(this);
            aVar.hvG.setVisibility(0);
        } else {
            aVar.hvG.setVisibility(8);
            aVar.hvN.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p dcS = vVar.dcS();
        if (dcS != null && dcS.dcJ() && !TextUtils.isEmpty(dcS.dcK())) {
            aVar.hvJ.setText(dcS.dcK());
            aVar.hvI.setTag(Integer.valueOf(i));
            aVar.hvI.setOnClickListener(this);
            aVar.hvI.setVisibility(0);
        } else {
            aVar.hvI.setVisibility(8);
            aVar.hvO.setVisibility(8);
        }
        if (this.hvF) {
            aVar.hvK.setVisibility(0);
        } else {
            aVar.hvK.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hmG == null || this.hmG.getUserData() == null || !this.hmG.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hvL.setVisibility(0);
            am.setBackgroundResource(aVar.hvL, R.drawable.frs_top_item_bg);
            aVar.hvK.setVisibility(0);
            aVar.hvL.setOnClickListener(this);
            aVar.hvL.setTag(Integer.valueOf(i));
        } else {
            aVar.hvL.setVisibility(8);
            aVar.hvP.setVisibility(8);
        }
        if (!this.hvE && !vVar.dcQ()) {
            if (z) {
                aVar.hvG.setVisibility(8);
                aVar.hvI.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hvQ;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hmH != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bk) {
                View s = s(this.gSQ.getListView(), intValue);
                this.hmH.a(id, intValue, view, s, (bk) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        View hvG;
        TextView hvH;
        View hvI;
        TextView hvJ;
        View hvK;
        View hvL;
        TextView hvM;
        View hvN;
        View hvO;
        View hvP;
        List<View> hvQ;

        a(View view) {
            super(view);
            this.hvQ = new ArrayList();
            this.hvH = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hvG = view.findViewById(R.id.frs_fortune_bag_item);
            this.hvI = view.findViewById(R.id.frs_my_service_item);
            this.hvJ = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hvK = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hvL = view.findViewById(R.id.frs_bawu_center);
            this.hvM = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hvN = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hvO = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hvP = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hvQ.add(this.hvN);
            this.hvQ.add(this.hvO);
            this.hvQ.add(this.hvP);
        }
    }
}
