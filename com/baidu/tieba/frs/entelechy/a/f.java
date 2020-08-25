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
    private boolean icP;
    private boolean icQ;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.icP = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.icQ = z;
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
        if (wVar.dwb()) {
            String dwc = wVar.dwc();
            if (dwc != null) {
                aVar.icS.setText(dwc);
            } else if (this.hSn != null && this.hSn.getForum() != null && this.hSn.getForum().getName() != null) {
                TextView textView = aVar.icS;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hSn == null ? "" : this.hSn.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.icR.setTag(Integer.valueOf(i));
            aVar.icR.setOnClickListener(this);
            aVar.icR.setVisibility(0);
        } else {
            aVar.icR.setVisibility(8);
            aVar.icY.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.q dwd = wVar.dwd();
        if (dwd != null && dwd.dvU() && !TextUtils.isEmpty(dwd.dvV())) {
            aVar.icU.setText(dwd.dvV());
            aVar.icT.setTag(Integer.valueOf(i));
            aVar.icT.setOnClickListener(this);
            aVar.icT.setVisibility(0);
        } else {
            aVar.icT.setVisibility(8);
            aVar.icZ.setVisibility(8);
        }
        if (this.icQ) {
            aVar.icV.setVisibility(0);
        } else {
            aVar.icV.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hSn == null || this.hSn.getUserData() == null || !this.hSn.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.icW.setVisibility(0);
            ap.setBackgroundResource(aVar.icW, R.drawable.frs_top_item_bg);
            aVar.icV.setVisibility(0);
            aVar.icW.setOnClickListener(this);
            aVar.icW.setTag(Integer.valueOf(i));
        } else {
            aVar.icW.setVisibility(8);
            aVar.ida.setVisibility(8);
        }
        if (!this.icP && !wVar.dwb()) {
            if (z) {
                aVar.icR.setVisibility(8);
                aVar.icT.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.idb;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hSo != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bw) {
                View t = t(this.hyl.getListView(), intValue);
                this.hSo.a(id, intValue, view, t, (bw) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes16.dex */
    public static class a extends af.a {
        View icR;
        TextView icS;
        View icT;
        TextView icU;
        View icV;
        View icW;
        TextView icX;
        View icY;
        View icZ;
        View ida;
        List<View> idb;

        a(View view) {
            super(view);
            this.idb = new ArrayList();
            this.icS = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.icR = view.findViewById(R.id.frs_fortune_bag_item);
            this.icT = view.findViewById(R.id.frs_my_service_item);
            this.icU = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.icV = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.icW = view.findViewById(R.id.frs_bawu_center);
            this.icX = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.icY = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.icZ = view.findViewById(R.id.official_account_text_divider_service_top);
            this.ida = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.idb.add(this.icY);
            this.idb.add(this.icZ);
            this.idb.add(this.ida);
        }
    }
}
