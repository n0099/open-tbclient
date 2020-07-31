package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.ad;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.frs.j<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean hOI;
    private boolean hOJ;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hOI = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hOJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bh */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.dkD()) {
            String dkE = vVar.dkE();
            if (dkE != null) {
                aVar.hOL.setText(dkE);
            } else if (this.hEX != null && this.hEX.getForum() != null && this.hEX.getForum().getName() != null) {
                TextView textView = aVar.hOL;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.hEX == null ? "" : this.hEX.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.hOK.setTag(Integer.valueOf(i));
            aVar.hOK.setOnClickListener(this);
            aVar.hOK.setVisibility(0);
        } else {
            aVar.hOK.setVisibility(8);
            aVar.hOR.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p dkF = vVar.dkF();
        if (dkF != null && dkF.dkw() && !TextUtils.isEmpty(dkF.dkx())) {
            aVar.hON.setText(dkF.dkx());
            aVar.hOM.setTag(Integer.valueOf(i));
            aVar.hOM.setOnClickListener(this);
            aVar.hOM.setVisibility(0);
        } else {
            aVar.hOM.setVisibility(8);
            aVar.hOS.setVisibility(8);
        }
        if (this.hOJ) {
            aVar.hOO.setVisibility(0);
        } else {
            aVar.hOO.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hEX == null || this.hEX.getUserData() == null || !this.hEX.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hOP.setVisibility(0);
            ao.setBackgroundResource(aVar.hOP, R.drawable.frs_top_item_bg);
            aVar.hOO.setVisibility(0);
            aVar.hOP.setOnClickListener(this);
            aVar.hOP.setTag(Integer.valueOf(i));
        } else {
            aVar.hOP.setVisibility(8);
            aVar.hOT.setVisibility(8);
        }
        if (!this.hOI && !vVar.dkD()) {
            if (z) {
                aVar.hOK.setVisibility(8);
                aVar.hOM.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hOU;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hEY != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bv) {
                View t = t(this.hlu.getListView(), intValue);
                this.hEY.a(id, intValue, view, t, (bv) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends ad.a {
        View hOK;
        TextView hOL;
        View hOM;
        TextView hON;
        View hOO;
        View hOP;
        TextView hOQ;
        View hOR;
        View hOS;
        View hOT;
        List<View> hOU;

        a(View view) {
            super(view);
            this.hOU = new ArrayList();
            this.hOL = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hOK = view.findViewById(R.id.frs_fortune_bag_item);
            this.hOM = view.findViewById(R.id.frs_my_service_item);
            this.hON = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hOO = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hOP = view.findViewById(R.id.frs_bawu_center);
            this.hOQ = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hOR = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hOS = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hOT = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hOU.add(this.hOR);
            this.hOU.add(this.hOS);
            this.hOU.add(this.hOT);
        }
    }
}
