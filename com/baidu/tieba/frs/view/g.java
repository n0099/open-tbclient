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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.m;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.c {
    private i dCS;
    private p dVA;
    private o dVx;
    public boolean dVz;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.i> mData;
    private boolean dVy = false;
    protected HashSet<String> dUO = new HashSet<>();
    protected final View.OnClickListener dUW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((g.this.mContext == null || ax.bb(g.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) {
                        gVar = (com.baidu.tieba.tbadkCore.g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dVF != null && (aVar.dVF.getTag() instanceof com.baidu.tieba.tbadkCore.g)) {
                                gVar = (com.baidu.tieba.tbadkCore.g) aVar.dVF.getTag();
                            }
                        }
                        gVar = null;
                    }
                    if (gVar != null && !StringUtils.isNull(gVar.getUrl())) {
                        String url = gVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(g.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        av.Da().c(g.this.dCS.akf(), new String[]{url});
                        a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btx(), g.this.dCS.getForumId(), g.this.dCS.getForumName(), null);
                        b.cc("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener csl = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (g.this.dVx != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position);
                if ((iVar instanceof bd) && (bdVar = (bd) iVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sO(bdVar.getId());
                        aj.r(aVar.dVF, d.C0108d.cp_cont_c);
                    }
                    g.this.dVx.a(view, bdVar, BdUniqueId.gen(), null, g.this.dVz ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener dVB = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.g.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (g.this.dVA == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return g.this.dVA.b(view, (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public g(i iVar) {
        this.dCS = iVar;
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
            aVar.dVD = view;
            aVar.dVE = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dVF = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dVG = (TextView) view.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.d.b.ayP().a(dRe, bdVar);
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
            aj.r(aVar.dVE, d.C0108d.cp_link_tip_c);
            if (z) {
                aj.r(aVar.dVF, d.C0108d.cp_cont_j);
            } else {
                aj.r(aVar.dVF, d.C0108d.cp_cont_b);
            }
            aj.s(aVar.dVD, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_c));
            }
        }
    }

    public void c(o oVar) {
        this.dVx = oVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.i> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View dVD;
        TextView dVE;
        TextView dVF;
        TextView dVG;
        View divider;
        int position;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dVE.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.zD();
            SpannableStringBuilder zt = bdVar.zt();
            aVar.dVF.setOnTouchListener(new m(zt));
            aVar.dVF.setText(zt);
            aVar.dVD.setOnClickListener(this.csl);
            aVar.dVD.setOnLongClickListener(this.dVB);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sP(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.g gVar) {
        String mi = mi(gVar.aSk());
        aVar.dVF.setText(gVar.getTitle());
        aVar.dVE.setText(mi);
        if (gVar.aZo() != 0) {
            aVar.dVG.setVisibility(0);
            if (gVar.aZo() == -1) {
                aVar.dVG.setText(this.mContext.getString(d.j.no_rank));
            } else if (gVar.aZo() > 999) {
                aVar.dVG.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dVG.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(gVar.aZo()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dVF.setText(am.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dVG.setVisibility(8);
        }
        aj.r(aVar.dVE, d.C0108d.cp_link_tip_c);
        aj.r(aVar.dVG, d.C0108d.cp_link_tip_c);
        aj.s(aVar.dVD, d.f.home_thread_card_item_bg);
        aj.t(aVar.divider, d.C0108d.cp_bg_line_c);
        aj.r(aVar.dVF, d.C0108d.cp_cont_b);
        aVar.dVF.setTag(gVar);
        if (this.dUW != null) {
            aVar.dVD.setOnClickListener(this.dUW);
        }
        if (this.dUO != null && this.dUO.add(gVar.btx())) {
            a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.btx(), this.dCS.getForumId(), this.dCS.getForumName(), null);
            b.cc("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String mi(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.dUO = hashSet;
    }
}
