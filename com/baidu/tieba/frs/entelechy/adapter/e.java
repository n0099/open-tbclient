package com.baidu.tieba.frs.entelechy.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.x, a> implements View.OnClickListener {
    private boolean jqI;
    private boolean jqJ;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jqI = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jqJ = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bt */
    public a e(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.x xVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) xVar, (com.baidu.tieba.tbadkCore.x) aVar);
        if (xVar.dMY()) {
            String dMZ = xVar.dMZ();
            if (dMZ != null) {
                aVar.jqL.setText(dMZ);
            } else if (this.jfU != null && this.jfU.getForum() != null && this.jfU.getForum().getName() != null) {
                TextView textView = aVar.jqL;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.jfU == null ? "" : this.jfU.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.jqK.setTag(Integer.valueOf(i));
            aVar.jqK.setOnClickListener(this);
            aVar.jqK.setVisibility(0);
        } else {
            aVar.jqK.setVisibility(8);
            aVar.jqR.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dNa = xVar.dNa();
        if (dNa != null && dNa.dMR() && !TextUtils.isEmpty(dNa.dMS())) {
            aVar.jqN.setText(dNa.dMS());
            aVar.jqM.setTag(Integer.valueOf(i));
            aVar.jqM.setOnClickListener(this);
            aVar.jqM.setVisibility(0);
        } else {
            aVar.jqM.setVisibility(8);
            aVar.jqS.setVisibility(8);
        }
        if (this.jqJ) {
            aVar.jqO.setVisibility(0);
        } else {
            aVar.jqO.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.jfU == null || this.jfU.getUserData() == null || !this.jfU.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jqP.setVisibility(0);
            ap.setBackgroundResource(aVar.jqP, R.drawable.frs_top_item_bg);
            aVar.jqO.setVisibility(0);
            aVar.jqP.setOnClickListener(this);
            aVar.jqP.setTag(Integer.valueOf(i));
        } else {
            aVar.jqP.setVisibility(8);
            aVar.jqT.setVisibility(8);
        }
        if (!this.jqI && !xVar.dMY()) {
            if (z) {
                aVar.jqK.setVisibility(8);
                aVar.jqM.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jqU;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jfV != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof cb) {
                View C = C(this.iLY.getListView(), intValue);
                this.jfV.a(id, intValue, view, C, (cb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        View jqK;
        TextView jqL;
        View jqM;
        TextView jqN;
        View jqO;
        View jqP;
        TextView jqQ;
        View jqR;
        View jqS;
        View jqT;
        List<View> jqU;

        a(View view) {
            super(view);
            this.jqU = new ArrayList();
            this.jqL = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jqK = view.findViewById(R.id.frs_fortune_bag_item);
            this.jqM = view.findViewById(R.id.frs_my_service_item);
            this.jqN = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jqO = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jqP = view.findViewById(R.id.frs_bawu_center);
            this.jqQ = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jqR = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jqS = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jqT = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jqU.add(this.jqR);
            this.jqU.add(this.jqS);
            this.jqU.add(this.jqT);
        }
    }
}
