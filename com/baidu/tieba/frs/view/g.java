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
    private com.baidu.tieba.frs.g cIy;
    private com.baidu.adp.widget.ListView.h dbR;
    public boolean deb;
    private i dec;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean dea = false;
    protected HashSet<String> ddq = new HashSet<>();
    protected final View.OnClickListener ddz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
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
                            if (aVar.deh != null && (aVar.deh.getTag() instanceof com.baidu.tieba.tbadkCore.f)) {
                                fVar = (com.baidu.tieba.tbadkCore.f) aVar.deh.getTag();
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
                        av.vI().c(g.this.cIy.xR(), new String[]{url});
                        a.C0143a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.buL(), g.this.cIy.getForumId(), g.this.cIy.getForumName(), null);
                        b.cg("obj_url", fVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bDy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (g.this.dbR != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(g.this.mData, aVar.position);
                if ((fVar instanceof bd) && (bdVar = (bd) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tn(bdVar.getId());
                        aj.i(aVar.deh, d.C0096d.cp_cont_c);
                    }
                    g.this.dbR.a(view, bdVar, BdUniqueId.gen(), null, g.this.deb ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener ded = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.g.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (g.this.dec == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return g.this.dec.b(view, (com.baidu.adp.widget.ListView.f) v.c(g.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public g(com.baidu.tieba.frs.g gVar) {
        this.cIy = gVar;
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
            aVar.def = view;
            aVar.deg = (TextView) view.findViewById(d.g.top_item_type);
            aVar.deh = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dei = (TextView) view.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.e.b.aqv().a(cYY, bdVar);
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
            aj.i(aVar.deg, d.C0096d.cp_link_tip_c);
            if (z) {
                aj.i(aVar.deh, d.C0096d.cp_cont_c);
            } else {
                aj.i(aVar.deh, d.C0096d.cp_cont_b);
            }
            aj.j(aVar.def, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_c));
            }
        }
    }

    public void c(com.baidu.adp.widget.ListView.h hVar) {
        this.dbR = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    /* loaded from: classes.dex */
    public class a {
        View def;
        TextView deg;
        TextView deh;
        TextView dei;
        View divider;
        int position;

        public a() {
        }
    }

    public View V(bd bdVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.def = inflate;
        aVar.deg = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.deh = (TextView) inflate.findViewById(d.g.top_item_title);
        a(aVar, bdVar, 0);
        inflate.setTag(aVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_c));
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.f fVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.def = inflate;
        aVar.deg = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.deh = (TextView) inflate.findViewById(d.g.top_item_title);
        aVar.dei = (TextView) inflate.findViewById(d.g.top_item_rank);
        a(aVar, fVar);
        inflate.setTag(fVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0096d.cp_bg_line_c));
        return inflate;
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.deg.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.sf();
            SpannableStringBuilder rV = bdVar.rV();
            aVar.deh.setOnTouchListener(new com.baidu.tieba.view.l(rV));
            aVar.deh.setText(rV);
            aVar.def.setOnClickListener(this.bDy);
            aVar.def.setOnLongClickListener(this.ded);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.to(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.f fVar) {
        String lI = lI(fVar.aKY());
        aVar.deh.setText(fVar.getTitle());
        aVar.deg.setText(lI);
        if (fVar.aRS() != 0) {
            aVar.dei.setVisibility(0);
            if (fVar.aRS() == -1) {
                aVar.dei.setText(this.mContext.getString(d.j.no_rank));
            } else if (fVar.aRS() > 999) {
                aVar.dei.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dei.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(fVar.aRS()));
            }
            if (!StringUtils.isNull(fVar.getTitle())) {
                aVar.deh.setText(am.e(fVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dei.setVisibility(8);
        }
        aj.i(aVar.deg, d.C0096d.cp_link_tip_c);
        aj.i(aVar.dei, d.C0096d.cp_link_tip_c);
        aj.j(aVar.def, d.f.home_thread_card_item_bg);
        aj.k(aVar.divider, d.C0096d.cp_bg_line_c);
        aj.i(aVar.deh, d.C0096d.cp_cont_b);
        aVar.deh.setTag(fVar);
        if (this.ddz != null) {
            aVar.def.setOnClickListener(this.ddz);
        }
        if (this.ddq != null && this.ddq.add(fVar.buL())) {
            a.C0143a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", fVar.buL(), this.cIy.getForumId(), this.cIy.getForumName(), null);
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
        this.ddq = hashSet;
    }
}
