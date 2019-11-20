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
    private boolean fCP;
    private boolean fCQ;

    public b(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.fCP = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.fCQ = z;
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
        if (uVar.cnG()) {
            String cnH = uVar.cnH();
            if (cnH != null) {
                aVar.fCS.setText(cnH);
            } else if (this.fua != null && this.fua.getForum() != null && this.fua.getForum().getName() != null) {
                TextView textView = aVar.fCS;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.fua == null ? "" : this.fua.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.fCR.setTag(Integer.valueOf(i));
            aVar.fCR.setOnClickListener(this);
            aVar.fCR.setVisibility(0);
        } else {
            aVar.fCR.setVisibility(8);
            aVar.fCY.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cnI = uVar.cnI();
        if (cnI != null && cnI.cnz() && !TextUtils.isEmpty(cnI.cnA())) {
            aVar.fCU.setText(cnI.cnA());
            aVar.fCT.setTag(Integer.valueOf(i));
            aVar.fCT.setOnClickListener(this);
            aVar.fCT.setVisibility(0);
        } else {
            aVar.fCT.setVisibility(8);
            aVar.fCZ.setVisibility(8);
        }
        if (this.fCQ) {
            aVar.fCV.setVisibility(0);
        } else {
            aVar.fCV.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.fua == null || this.fua.getUserData() == null || !this.fua.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.fCW.setVisibility(0);
            am.setBackgroundResource(aVar.fCW, R.drawable.frs_top_item_bg);
            aVar.fCV.setVisibility(0);
            aVar.fCW.setOnClickListener(this);
            aVar.fCW.setTag(Integer.valueOf(i));
        } else {
            aVar.fCW.setVisibility(8);
            aVar.fDa.setVisibility(8);
        }
        if (!this.fCP && !uVar.cnG()) {
            if (z) {
                aVar.fCR.setVisibility(8);
                aVar.fCT.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.fDb;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.fub != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bh) {
                View q = q(this.fcN.getListView(), intValue);
                this.fub.a(id, intValue, view, q, (bh) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a extends v.a {
        View fCR;
        TextView fCS;
        View fCT;
        TextView fCU;
        View fCV;
        View fCW;
        TextView fCX;
        View fCY;
        View fCZ;
        View fDa;
        List<View> fDb;

        a(View view) {
            super(view);
            this.fDb = new ArrayList();
            this.fCS = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.fCR = view.findViewById(R.id.frs_fortune_bag_item);
            this.fCT = view.findViewById(R.id.frs_my_service_item);
            this.fCU = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.fCV = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.fCW = view.findViewById(R.id.frs_bawu_center);
            this.fCX = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.fCY = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.fCZ = view.findViewById(R.id.official_account_text_divider_service_top);
            this.fDa = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.fDb.add(this.fCY);
            this.fDb.add(this.fCZ);
            this.fDb.add(this.fDa);
        }
    }
}
