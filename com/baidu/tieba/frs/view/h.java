package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.m;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class h extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private com.baidu.tieba.frs.i dFD;
    private o dZA;
    public boolean dZC;
    private p dZD;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.i> mData;
    private boolean dZB = false;
    protected HashSet<String> dYr = new HashSet<>();
    protected final View.OnClickListener dYz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((h.this.mContext == null || ay.ba(h.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) {
                        gVar = (com.baidu.tieba.tbadkCore.g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dRX != null && (aVar.dRX.getTag() instanceof com.baidu.tieba.tbadkCore.g)) {
                                gVar = (com.baidu.tieba.tbadkCore.g) aVar.dRX.getTag();
                            }
                        }
                        gVar = null;
                    }
                    if (gVar != null && !StringUtils.isNull(gVar.getUrl())) {
                        String url = gVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(h.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        aw.Dt().c(h.this.dFD.akN(), new String[]{url});
                        a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.buL(), h.this.dFD.getForumId(), h.this.dFD.getForumName(), null);
                        b.ce("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cwi = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.h.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (h.this.dZA != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(h.this.mData, aVar.position);
                if ((iVar instanceof bd) && (bdVar = (bd) iVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sV(bdVar.getId());
                        aj.r(aVar.dRX, d.C0141d.cp_cont_c);
                    }
                    h.this.dZA.a(view, bdVar, BdUniqueId.gen(), null, h.this.dZC ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener dZE = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.h.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (h.this.dZD == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return h.this.dZD.b(view, (com.baidu.adp.widget.ListView.i) v.f(h.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public h(com.baidu.tieba.frs.i iVar) {
        this.dFD = iVar;
        this.mContext = iVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.D(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.mData, i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            aVar = new a();
            view = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null, false);
            aVar.cex = view;
            aVar.dZG = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dRX = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dZH = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(this.mData, i);
        if (iVar instanceof bd) {
            bd bdVar = (bd) iVar;
            if (bdVar != null) {
                a(aVar, bdVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.azQ().a(dUe, bdVar);
        } else if (iVar instanceof com.baidu.tieba.tbadkCore.g) {
            a(aVar, (com.baidu.tieba.tbadkCore.g) iVar);
        }
        if (v.f(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.r(aVar.dZG, d.C0141d.cp_link_tip_c);
            if (z) {
                aj.r(aVar.dRX, d.C0141d.cp_cont_j);
            } else {
                aj.r(aVar.dRX, d.C0141d.cp_cont_b);
            }
            aj.s(aVar.cex, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0141d.cp_bg_line_c));
            }
        }
    }

    public void c(o oVar) {
        this.dZA = oVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.i> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View cex;
        TextView dRX;
        TextView dZG;
        TextView dZH;
        View divider;
        int position;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dZG.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.zX();
            SpannableStringBuilder zN = bdVar.zN();
            aVar.dRX.setOnTouchListener(new m(zN));
            aVar.dRX.setText(zN);
            aVar.cex.setOnClickListener(this.cwi);
            aVar.cex.setOnLongClickListener(this.dZE);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sW(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.g gVar) {
        String a2 = a(gVar);
        aVar.dRX.setText(gVar.getTitle());
        aVar.dZG.setText(a2);
        if (gVar.buK() != 0) {
            aVar.dZH.setVisibility(0);
            if (gVar.buK() == -1) {
                aVar.dZH.setText(this.mContext.getString(d.j.no_rank));
            } else if (gVar.buK() > 999) {
                aVar.dZH.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dZH.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(gVar.buK()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dRX.setText(am.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dZH.setVisibility(8);
        }
        aj.r(aVar.dZG, d.C0141d.cp_link_tip_c);
        aj.r(aVar.dZH, d.C0141d.cp_link_tip_c);
        aj.s(aVar.cex, d.f.home_thread_card_item_bg);
        aj.t(aVar.divider, d.C0141d.cp_bg_line_c);
        aj.r(aVar.dRX, d.C0141d.cp_cont_b);
        aVar.dRX.setTag(gVar);
        if (this.dYz != null) {
            aVar.cex.setOnClickListener(this.dYz);
        }
        if (this.dYr != null && this.dYr.add(gVar.buL())) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.buL(), this.dFD.getForumId(), this.dFD.getForumName(), null);
            b.ce("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(com.baidu.tieba.tbadkCore.g gVar) {
        if (gVar.buJ() == 1) {
            return TbadkCoreApplication.getInst().getString(d.j.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.aTS()) || gVar.aTS().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return gVar.aTS();
    }

    public void a(HashSet<String> hashSet) {
        this.dYr = hashSet;
    }
}
