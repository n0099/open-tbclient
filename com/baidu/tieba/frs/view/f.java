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
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.c;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter implements c {
    private h cIp;
    public boolean cKg;
    private i cKi;
    private com.baidu.tieba.frs.f crw;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cKf = false;
    protected HashSet<String> cJx = new HashSet<>();
    protected final View.OnClickListener cJE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((f.this.mContext == null || ax.aT(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.e) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) {
                        eVar = (com.baidu.tieba.tbadkCore.e) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.cKn != null && (aVar.cKn.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cKn.getTag();
                            }
                        }
                        eVar = null;
                    }
                    if (eVar != null && !StringUtils.isNull(eVar.getUrl())) {
                        String url = eVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(f.this.mContext, d.l.book_plugin_not_install_tip);
                            return;
                        }
                        av.vA().c(f.this.crw.xA(), new String[]{url});
                        a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bpk(), f.this.crw.getForumId(), f.this.crw.getForumName(), null);
                        b.cd("obj_url", eVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cKh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bh bhVar;
            view.setPressed(false);
            if (f.this.cIp != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bh) && (bhVar = (bh) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.rX(bhVar.getId());
                        aj.i(aVar.cKn, d.e.cp_cont_c);
                    }
                    f.this.cIp.a(view, bhVar, BdUniqueId.gen(), null, f.this.cKg ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cKj = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cKi == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cKi.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.crw = fVar;
        this.mContext = fVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.t(this.mData);
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
            view = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
            aVar.cKl = view;
            aVar.cKm = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cKn = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cKo = (TextView) view.findViewById(d.h.top_item_rank);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(this.mData, i);
        if (fVar instanceof bh) {
            bh bhVar = (bh) fVar;
            if (bhVar != null) {
                a(aVar, bhVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.f.b.alt().a(cFQ, bhVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.cKm, d.e.cp_link_tip_c);
            if (z) {
                aj.i(aVar.cKn, d.e.cp_cont_c);
            } else {
                aj.i(aVar.cKn, d.e.cp_cont_b);
            }
            aj.j(aVar.cKl, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cIp = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fk(boolean z) {
        this.cKf = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View cKl;
        TextView cKm;
        TextView cKn;
        TextView cKo;
        int position;

        public a() {
        }
    }

    public View P(bh bhVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cKl = inflate;
        aVar.cKm = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cKn = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, bhVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cKl = inflate;
        aVar.cKm = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cKn = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cKo = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bh bhVar, int i) {
        if (aVar != null && bhVar != null) {
            aVar.cKm.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            bhVar.rY();
            SpannableStringBuilder rO = bhVar.rO();
            aVar.cKn.setOnTouchListener(new k(rO));
            aVar.cKn.setText(rO);
            aVar.cKl.setOnClickListener(this.cKh);
            aVar.cKl.setOnLongClickListener(this.cKj);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.rY(bhVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kW = kW(eVar.aHH());
        aVar.cKn.setText(eVar.getTitle());
        aVar.cKm.setText(kW);
        if (eVar.aNy() != 0) {
            aVar.cKo.setVisibility(0);
            if (eVar.aNy() == -1) {
                aVar.cKo.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aNy() > 999) {
                aVar.cKo.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cKo.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aNy()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cKn.setText(am.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cKo.setVisibility(8);
        }
        aj.i(aVar.cKm, d.e.cp_link_tip_d);
        aj.i(aVar.cKo, d.e.cp_link_tip_d);
        aj.j(aVar.cKl, d.g.home_thread_card_item_bg);
        aj.i(aVar.cKn, d.e.cp_cont_b);
        aVar.cKn.setTag(eVar);
        if (this.cJE != null) {
            aVar.cKl.setOnClickListener(this.cJE);
        }
        if (this.cJx != null && this.cJx.add(eVar.bpk())) {
            a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bpk(), this.crw.getForumId(), this.crw.getForumName(), null);
            b.cd("obj_url", eVar.getUrl());
            b.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bh) {
            return P((bh) fVar);
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            return a((com.baidu.tieba.tbadkCore.e) fVar);
        }
        return null;
    }

    private String kW(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cJx = hashSet;
    }
}
