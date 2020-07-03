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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes9.dex */
public class f extends com.baidu.tieba.frs.j<com.baidu.tieba.tbadkCore.v, a> implements View.OnClickListener {
    private boolean hII;
    private boolean hIJ;

    public f(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.hII = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.hIJ = z;
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
    @Override // com.baidu.tieba.frs.j, com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.tbadkCore.v vVar, a aVar) {
        boolean z = true;
        super.a(i, view, viewGroup, (ViewGroup) vVar, (com.baidu.tieba.tbadkCore.v) aVar);
        if (vVar.dhu()) {
            String dhv = vVar.dhv();
            if (dhv != null) {
                aVar.hIL.setText(dhv);
            } else if (this.hzi != null && this.hzi.getForum() != null && this.hzi.getForum().getName() != null) {
                TextView textView = aVar.hIL;
                Context context = this.mContext;
                Object[] objArr = new Object[1];
                objArr[0] = this.hzi == null ? "" : this.hzi.getForum().getName();
                textView.setText(context.getString(R.string.get_fortune_hint_format, objArr));
            }
            aVar.hIK.setTag(Integer.valueOf(i));
            aVar.hIK.setOnClickListener(this);
            aVar.hIK.setVisibility(0);
        } else {
            aVar.hIK.setVisibility(8);
            aVar.hIR.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.p dhw = vVar.dhw();
        if (dhw != null && dhw.dhn() && !TextUtils.isEmpty(dhw.dho())) {
            aVar.hIN.setText(dhw.dho());
            aVar.hIM.setTag(Integer.valueOf(i));
            aVar.hIM.setOnClickListener(this);
            aVar.hIM.setVisibility(0);
        } else {
            aVar.hIM.setVisibility(8);
            aVar.hIS.setVisibility(8);
        }
        if (this.hIJ) {
            aVar.hIO.setVisibility(0);
        } else {
            aVar.hIO.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.hzi == null || this.hzi.getUserData() == null || !this.hzi.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.hIP.setVisibility(0);
            an.setBackgroundResource(aVar.hIP, R.drawable.frs_top_item_bg);
            aVar.hIO.setVisibility(0);
            aVar.hIP.setOnClickListener(this);
            aVar.hIP.setTag(Integer.valueOf(i));
        } else {
            aVar.hIP.setVisibility(8);
            aVar.hIT.setVisibility(8);
        }
        if (!this.hII && !vVar.dhu()) {
            if (z) {
                aVar.hIK.setVisibility(8);
                aVar.hIM.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.hIU;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hzj != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof bu) {
                View t = t(this.hfK.getListView(), intValue);
                this.hzj.a(id, intValue, view, t, (bu) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes9.dex */
    public static class a extends ad.a {
        View hIK;
        TextView hIL;
        View hIM;
        TextView hIN;
        View hIO;
        View hIP;
        TextView hIQ;
        View hIR;
        View hIS;
        View hIT;
        List<View> hIU;

        a(View view) {
            super(view);
            this.hIU = new ArrayList();
            this.hIL = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.hIK = view.findViewById(R.id.frs_fortune_bag_item);
            this.hIM = view.findViewById(R.id.frs_my_service_item);
            this.hIN = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.hIO = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.hIP = view.findViewById(R.id.frs_bawu_center);
            this.hIQ = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.hIR = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.hIS = view.findViewById(R.id.official_account_text_divider_service_top);
            this.hIT = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.hIU.add(this.hIR);
            this.hIU.add(this.hIS);
            this.hIU.add(this.hIT);
        }
    }
}
