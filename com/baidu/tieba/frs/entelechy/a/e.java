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
    private boolean gwt;
    private boolean gwu;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.gwt = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.gwu = z;
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
        if (uVar.cKx()) {
            String cKy = uVar.cKy();
            if (cKy != null) {
                aVar.gww.setText(cKy);
            } else if (this.gnM != null && this.gnM.getForum() != null && this.gnM.getForum().getName() != null) {
                TextView textView = aVar.gww;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.gnM == null ? "" : this.gnM.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.gwv.setTag(Integer.valueOf(i));
            aVar.gwv.setOnClickListener(this);
            aVar.gwv.setVisibility(0);
        } else {
            aVar.gwv.setVisibility(8);
            aVar.gwC.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.o cKz = uVar.cKz();
        if (cKz != null && cKz.cKq() && !TextUtils.isEmpty(cKz.cKr())) {
            aVar.gwy.setText(cKz.cKr());
            aVar.gwx.setTag(Integer.valueOf(i));
            aVar.gwx.setOnClickListener(this);
            aVar.gwx.setVisibility(0);
        } else {
            aVar.gwx.setVisibility(8);
            aVar.gwD.setVisibility(8);
        }
        if (this.gwu) {
            aVar.gwz.setVisibility(0);
        } else {
            aVar.gwz.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.gnM == null || this.gnM.getUserData() == null || !this.gnM.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.gwA.setVisibility(0);
            am.setBackgroundResource(aVar.gwA, R.drawable.frs_top_item_bg);
            aVar.gwz.setVisibility(0);
            aVar.gwA.setOnClickListener(this);
            aVar.gwA.setTag(Integer.valueOf(i));
        } else {
            aVar.gwA.setVisibility(8);
            aVar.gwE.setVisibility(8);
        }
        if (!this.gwt && !uVar.cKx()) {
            if (z) {
                aVar.gwv.setVisibility(8);
                aVar.gwx.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.gwF;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.gnN != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bj) {
                View t = t(this.fWD.getListView(), intValue);
                this.gnN.a(id, intValue, view, t, (bj) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends v.a {
        View gwA;
        TextView gwB;
        View gwC;
        View gwD;
        View gwE;
        List<View> gwF;
        View gwv;
        TextView gww;
        View gwx;
        TextView gwy;
        View gwz;

        a(View view) {
            super(view);
            this.gwF = new ArrayList();
            this.gww = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.gwv = view.findViewById(R.id.frs_fortune_bag_item);
            this.gwx = view.findViewById(R.id.frs_my_service_item);
            this.gwy = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.gwz = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.gwA = view.findViewById(R.id.frs_bawu_center);
            this.gwB = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.gwC = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.gwD = view.findViewById(R.id.official_account_text_divider_service_top);
            this.gwE = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.gwF.add(this.gwC);
            this.gwF.add(this.gwD);
            this.gwF.add(this.gwE);
        }
    }
}
