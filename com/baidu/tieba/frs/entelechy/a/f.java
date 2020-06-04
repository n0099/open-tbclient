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
    private boolean hvP;
    private boolean hvQ;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hvP = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hvQ = z;
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
        if (vVar.ddf()) {
            String ddg = vVar.ddg();
            if (ddg != null) {
                aVar.hvS.setText(ddg);
            } else if (this.hmR != null && this.hmR.getForum() != null && this.hmR.getForum().getName() != null) {
                TextView textView = aVar.hvS;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hmR == null ? "" : this.hmR.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.hvR.setTag(Integer.valueOf(i));
            aVar.hvR.setOnClickListener(this);
            aVar.hvR.setVisibility(0);
        } else {
            aVar.hvR.setVisibility(8);
            aVar.hvY.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p ddh = vVar.ddh();
        if (ddh != null && ddh.dcY() && !TextUtils.isEmpty(ddh.dcZ())) {
            aVar.hvU.setText(ddh.dcZ());
            aVar.hvT.setTag(Integer.valueOf(i));
            aVar.hvT.setOnClickListener(this);
            aVar.hvT.setVisibility(0);
        } else {
            aVar.hvT.setVisibility(8);
            aVar.hvZ.setVisibility(8);
        }
        if (this.hvQ) {
            aVar.hvV.setVisibility(0);
        } else {
            aVar.hvV.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hmR == null || this.hmR.getUserData() == null || !this.hmR.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hvW.setVisibility(0);
            am.setBackgroundResource(aVar.hvW, R.drawable.frs_top_item_bg);
            aVar.hvV.setVisibility(0);
            aVar.hvW.setOnClickListener(this);
            aVar.hvW.setTag(Integer.valueOf(i));
        } else {
            aVar.hvW.setVisibility(8);
            aVar.hwa.setVisibility(8);
        }
        if (!this.hvP && !vVar.ddf()) {
            if (z) {
                aVar.hvR.setVisibility(8);
                aVar.hvT.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hwb;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hmS != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bk) {
                View s = s(this.gTb.getListView(), intValue);
                this.hmS.a(id, intValue, view, s, (bk) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends aa.a {
        View hvR;
        TextView hvS;
        View hvT;
        TextView hvU;
        View hvV;
        View hvW;
        TextView hvX;
        View hvY;
        View hvZ;
        View hwa;
        List<View> hwb;

        a(View view) {
            super(view);
            this.hwb = new ArrayList();
            this.hvS = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hvR = view.findViewById(R.id.frs_fortune_bag_item);
            this.hvT = view.findViewById(R.id.frs_my_service_item);
            this.hvU = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hvV = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hvW = view.findViewById(R.id.frs_bawu_center);
            this.hvX = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hvY = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hvZ = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hwa = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hwb.add(this.hvY);
            this.hwb.add(this.hvZ);
            this.hwb.add(this.hwa);
        }
    }
}
