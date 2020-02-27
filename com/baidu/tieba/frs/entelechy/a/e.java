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
    private boolean gwr;
    private boolean gws;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.gwr = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gws = z;
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
        if (uVar.cKv()) {
            String cKw = uVar.cKw();
            if (cKw != null) {
                aVar.gwu.setText(cKw);
            } else if (this.gnK != null && this.gnK.getForum() != null && this.gnK.getForum().getName() != null) {
                TextView textView = aVar.gwu;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.gnK == null ? "" : this.gnK.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.gwt.setTag(Integer.valueOf(i));
            aVar.gwt.setOnClickListener(this);
            aVar.gwt.setVisibility(0);
        } else {
            aVar.gwt.setVisibility(8);
            aVar.gwA.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cKx = uVar.cKx();
        if (cKx != null && cKx.cKo() && !TextUtils.isEmpty(cKx.cKp())) {
            aVar.gww.setText(cKx.cKp());
            aVar.gwv.setTag(Integer.valueOf(i));
            aVar.gwv.setOnClickListener(this);
            aVar.gwv.setVisibility(0);
        } else {
            aVar.gwv.setVisibility(8);
            aVar.gwB.setVisibility(8);
        }
        if (this.gws) {
            aVar.gwx.setVisibility(0);
        } else {
            aVar.gwx.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.gnK == null || this.gnK.getUserData() == null || !this.gnK.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gwy.setVisibility(0);
            am.setBackgroundResource(aVar.gwy, R.drawable.frs_top_item_bg);
            aVar.gwx.setVisibility(0);
            aVar.gwy.setOnClickListener(this);
            aVar.gwy.setTag(Integer.valueOf(i));
        } else {
            aVar.gwy.setVisibility(8);
            aVar.gwC.setVisibility(8);
        }
        if (!this.gwr && !uVar.cKv()) {
            if (z) {
                aVar.gwt.setVisibility(8);
                aVar.gwv.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.gwD;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnL != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fWB.getListView(), intValue);
                this.gnL.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends v.a {
        View gwA;
        View gwB;
        View gwC;
        List<View> gwD;
        View gwt;
        TextView gwu;
        View gwv;
        TextView gww;
        View gwx;
        View gwy;
        TextView gwz;

        a(View view) {
            super(view);
            this.gwD = new ArrayList();
            this.gwu = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.gwt = view.findViewById(R.id.frs_fortune_bag_item);
            this.gwv = view.findViewById(R.id.frs_my_service_item);
            this.gww = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.gwx = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gwy = view.findViewById(R.id.frs_bawu_center);
            this.gwz = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.gwA = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.gwB = view.findViewById(R.id.official_account_text_divider_service_top);
            this.gwC = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.gwD.add(this.gwA);
            this.gwD.add(this.gwB);
            this.gwD.add(this.gwC);
        }
    }
}
