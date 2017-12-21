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
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private com.baidu.tieba.frs.g cIC;
    private com.baidu.adp.widget.ListView.h dbV;
    public boolean def;
    private i deg;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean dee = false;
    protected HashSet<String> ddv = new HashSet<>();
    protected final View.OnClickListener ddD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.f fVar;
            if ((g.this.mContext == null || ax.aS(g.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.f) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.f) {
                        fVar = (com.baidu.tieba.tbadkCore.f) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.del != null && (aVar.del.getTag() instanceof com.baidu.tieba.tbadkCore.f)) {
                                fVar = (com.baidu.tieba.tbadkCore.f) aVar.del.getTag();
                            }
                        }
                        fVar = null;
                    }
                    if (fVar != null && !StringUtils.isNull(fVar.getUrl())) {
                        String url = fVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(g.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        av.vI().c(g.this.cIC.xR(), new String[]{url});
                        a.C0142a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.buM(), g.this.cIC.getForumId(), g.this.cIC.getForumName(), null);
                        b.cg("obj_url", fVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bDC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (g.this.dbV != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(g.this.mData, aVar.position);
                if ((fVar instanceof bd) && (bdVar = (bd) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tn(bdVar.getId());
                        aj.i(aVar.del, d.C0095d.cp_cont_c);
                    }
                    g.this.dbV.a(view, bdVar, BdUniqueId.gen(), null, g.this.def ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener deh = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.g.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (g.this.deg == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return g.this.deg.b(view, (com.baidu.adp.widget.ListView.f) v.c(g.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public g(com.baidu.tieba.frs.g gVar) {
        this.cIC = gVar;
        this.mContext = gVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.v(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.c(this.mData, i);
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
            aVar.dej = view;
            aVar.dek = (TextView) view.findViewById(d.g.top_item_type);
            aVar.del = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dem = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(this.mData, i);
        if (fVar instanceof bd) {
            bd bdVar = (bd) fVar;
            if (bdVar != null) {
                a(aVar, bdVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.aqw().a(cZc, bdVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.f) {
            a(aVar, (com.baidu.tieba.tbadkCore.f) fVar);
        }
        if (v.c(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.dek, d.C0095d.cp_link_tip_c);
            if (z) {
                aj.i(aVar.del, d.C0095d.cp_cont_c);
            } else {
                aj.i(aVar.del, d.C0095d.cp_cont_b);
            }
            aj.j(aVar.dej, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_c));
            }
        }
    }

    public void c(com.baidu.adp.widget.ListView.h hVar) {
        this.dbV = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    /* loaded from: classes.dex */
    public class a {
        View dej;
        TextView dek;
        TextView del;
        TextView dem;
        View divider;
        int position;

        public a() {
        }
    }

    public View V(bd bdVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.dej = inflate;
        aVar.dek = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.del = (TextView) inflate.findViewById(d.g.top_item_title);
        a(aVar, bdVar, 0);
        inflate.setTag(aVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_c));
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.f fVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.dej = inflate;
        aVar.dek = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.del = (TextView) inflate.findViewById(d.g.top_item_title);
        aVar.dem = (TextView) inflate.findViewById(d.g.top_item_rank);
        a(aVar, fVar);
        inflate.setTag(fVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0095d.cp_bg_line_c));
        return inflate;
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dek.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.sf();
            SpannableStringBuilder rV = bdVar.rV();
            aVar.del.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            aVar.del.setText(rV);
            aVar.dej.setOnClickListener(this.bDC);
            aVar.dej.setOnLongClickListener(this.deh);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.to(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.f fVar) {
        String lI = lI(fVar.aKZ());
        aVar.del.setText(fVar.getTitle());
        aVar.dek.setText(lI);
        if (fVar.aRT() != 0) {
            aVar.dem.setVisibility(0);
            if (fVar.aRT() == -1) {
                aVar.dem.setText(this.mContext.getString(d.j.no_rank));
            } else if (fVar.aRT() > 999) {
                aVar.dem.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dem.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(fVar.aRT()));
            }
            if (!StringUtils.isNull(fVar.getTitle())) {
                aVar.del.setText(am.e(fVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dem.setVisibility(8);
        }
        aj.i(aVar.dek, d.C0095d.cp_link_tip_c);
        aj.i(aVar.dem, d.C0095d.cp_link_tip_c);
        aj.j(aVar.dej, d.f.home_thread_card_item_bg);
        aj.k(aVar.divider, d.C0095d.cp_bg_line_c);
        aj.i(aVar.del, d.C0095d.cp_cont_b);
        aVar.del.setTag(fVar);
        if (this.ddD != null) {
            aVar.dej.setOnClickListener(this.ddD);
        }
        if (this.ddv != null && this.ddv.add(fVar.buM())) {
            a.C0142a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", fVar.buM(), this.cIC.getForumId(), this.cIC.getForumName(), null);
            b.cg("obj_url", fVar.getUrl());
            b.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bd) {
            return V((bd) fVar);
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.f) {
            return a((com.baidu.tieba.tbadkCore.f) fVar);
        }
        return null;
    }

    private String lI(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.ddv = hashSet;
    }
}
