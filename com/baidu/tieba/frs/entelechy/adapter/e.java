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
    private boolean jsr;
    private boolean jss;

    public e(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        this.jsr = TbadkCoreApplication.getInst().appResponseToCmd(CmdConfigCustom.START_OFFICIAL_BAR_CHAT);
        this.jss = z;
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
        if (xVar.dNg()) {
            String dNh = xVar.dNh();
            if (dNh != null) {
                aVar.jsu.setText(dNh);
            } else if (this.jhD != null && this.jhD.getForum() != null && this.jhD.getForum().getName() != null) {
                TextView textView = aVar.jsu;
                Context context = this.mContext;
                int i2 = R.string.get_fortune_hint_format;
                Object[] objArr = new Object[1];
                objArr[0] = this.jhD == null ? "" : this.jhD.getForum().getName();
                textView.setText(context.getString(i2, objArr));
            }
            aVar.jst.setTag(Integer.valueOf(i));
            aVar.jst.setOnClickListener(this);
            aVar.jst.setVisibility(0);
        } else {
            aVar.jst.setVisibility(8);
            aVar.jsA.setVisibility(8);
        }
        com.baidu.tieba.tbadkCore.r dNi = xVar.dNi();
        if (dNi != null && dNi.dMZ() && !TextUtils.isEmpty(dNi.dNa())) {
            aVar.jsw.setText(dNi.dNa());
            aVar.jsv.setTag(Integer.valueOf(i));
            aVar.jsv.setOnClickListener(this);
            aVar.jsv.setVisibility(0);
        } else {
            aVar.jsv.setVisibility(8);
            aVar.jsB.setVisibility(8);
        }
        if (this.jss) {
            aVar.jsx.setVisibility(0);
        } else {
            aVar.jsx.setVisibility(8);
        }
        this.mPageContext.getLayoutMode().setNightMode(this.mSkinType == 1);
        this.mPageContext.getLayoutMode().onModeChanged(view);
        if (this.jhD == null || this.jhD.getUserData() == null || !this.jhD.getUserData().isBawu()) {
            z = false;
        }
        if (z) {
            aVar.jsy.setVisibility(0);
            ap.setBackgroundResource(aVar.jsy, R.drawable.frs_top_item_bg);
            aVar.jsx.setVisibility(0);
            aVar.jsy.setOnClickListener(this);
            aVar.jsy.setTag(Integer.valueOf(i));
        } else {
            aVar.jsy.setVisibility(8);
            aVar.jsC.setVisibility(8);
        }
        if (!this.jsr && !xVar.dNg()) {
            if (z) {
                aVar.jst.setVisibility(8);
                aVar.jsv.setVisibility(8);
                a(aVar);
                return view;
            }
            return new View(this.mContext);
        }
        return view;
    }

    private void a(a aVar) {
        List<View> list = aVar.jsD;
        for (View view : list) {
            view.setVisibility(8);
        }
        list.get(0).setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.jhE != null) {
            int id = view.getId();
            int intValue = ((Integer) view.getTag()).intValue();
            if (getItem(intValue) instanceof cb) {
                View C = C(this.iNH.getListView(), intValue);
                this.jhE.a(id, intValue, view, C, (cb) getItem(intValue));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        View jsA;
        View jsB;
        View jsC;
        List<View> jsD;
        View jst;
        TextView jsu;
        View jsv;
        TextView jsw;
        View jsx;
        View jsy;
        TextView jsz;

        a(View view) {
            super(view);
            this.jsD = new ArrayList();
            this.jsu = (TextView) view.findViewById(R.id.frs_fortune_bag_content);
            this.jst = view.findViewById(R.id.frs_fortune_bag_item);
            this.jsv = view.findViewById(R.id.frs_my_service_item);
            this.jsw = (TextView) view.findViewById(R.id.frs_my_service_content);
            this.jsx = view.findViewById(R.id.frs_list_item_official_buttom_line);
            this.jsy = view.findViewById(R.id.frs_bawu_center);
            this.jsz = (TextView) view.findViewById(R.id.frs_bawu_center_inner);
            this.jsA = view.findViewById(R.id.official_account_text_divider_fortune_top);
            this.jsB = view.findViewById(R.id.official_account_text_divider_service_top);
            this.jsC = view.findViewById(R.id.official_account_text_divider_bawucenter_top);
            this.jsD.add(this.jsA);
            this.jsD.add(this.jsB);
            this.jsD.add(this.jsC);
        }
    }
}
