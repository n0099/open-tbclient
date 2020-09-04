package com.baidu.tieba.frs.entelechy.a;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.af;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes16.dex */
public class f extends com.baidu.tieba.frs.k<com.baidu.tieba.tbadkCore.w, a> implements View.OnClickListener {
    private boolean icV;
    private boolean icW;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.icV = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.icW = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bg */
    public a b(ViewGroup viewGroup) {
        return new a(LayoutInflater.from(this.mContext).inflate(R.layout.frs_extra_account_item, (ViewGroup) null));
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.frs.k, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.w wVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) wVar, (com.baidu.tieba.tbadkCore.w) aVar);
        if (wVar.dwg()) {
            String dwh = wVar.dwh();
            if (dwh != null) {
                aVar.icY.setText(dwh);
            } else if (this.hSt != null && this.hSt.getForum() != null && this.hSt.getForum().getName() != null) {
                TextView textView = aVar.icY;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hSt == null ? "" : this.hSt.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.icX.setTag(Integer.valueOf(i));
            aVar.icX.setOnClickListener(this);
            aVar.icX.setVisibility(0);
        } else {
            aVar.icX.setVisibility(8);
            aVar.ide.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dwi = wVar.dwi();
        if (dwi != null && dwi.dvZ() && !TextUtils.isEmpty(dwi.dwa())) {
            aVar.ida.setText(dwi.dwa());
            aVar.icZ.setTag(Integer.valueOf(i));
            aVar.icZ.setOnClickListener(this);
            aVar.icZ.setVisibility(0);
        } else {
            aVar.icZ.setVisibility(8);
            aVar.idf.setVisibility(8);
        }
        if (this.icW) {
            aVar.idb.setVisibility(0);
        } else {
            aVar.idb.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hSt == null || this.hSt.getUserData() == null || !this.hSt.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.idc.setVisibility(0);
            ap.setBackgroundResource(aVar.idc, R.drawable.frs_top_item_bg);
            aVar.idb.setVisibility(0);
            aVar.idc.setOnClickListener(this);
            aVar.idc.setTag(Integer.valueOf(i));
        } else {
            aVar.idc.setVisibility(8);
            aVar.idg.setVisibility(8);
        }
        if (!this.icV && !wVar.dwg()) {
            if (z) {
                aVar.icX.setVisibility(8);
                aVar.icZ.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.idh;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSu != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View t = t(this.hyr.getListView(), intValue);
                this.hSu.a(id, intValue, view, t, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends af.a {
        View icX;
        TextView icY;
        View icZ;
        TextView ida;
        View idb;
        View idc;
        TextView idd;
        View ide;
        View idf;
        View idg;
        List<View> idh;

        a(View view) {
            super(view);
            this.idh = new ArrayList();
            this.icY = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.icX = view.findViewById(R.id.frs_fortune_bag_item);
            this.icZ = view.findViewById(R.id.frs_my_service_item);
            this.ida = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.idb = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.idc = view.findViewById(R.id.frs_bawu_center);
            this.idd = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.ide = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.idf = view.findViewById(R.id.official_account_text_divider_service_top);
            this.idg = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.idh.add(this.ide);
            this.idh.add(this.idf);
            this.idh.add(this.idg);
        }
    }
}
