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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.c;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.m;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter implements c {
    private h cHL;
    public boolean cJC;
    private i cJE;
    private com.baidu.tieba.frs.f crm;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cJB = false;
    protected HashSet<String> cIT = new HashSet<>();
    protected final View.OnClickListener cJa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((f.this.mContext == null || ax.aU(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.e) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) {
                        eVar = (com.baidu.tieba.tbadkCore.e) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.cJJ != null && (aVar.cJJ.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cJJ.getTag();
                            }
                        }
                        eVar = null;
                    }
                    if (eVar != null && !StringUtils.isNull(eVar.getUrl())) {
                        String url = eVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            k.showToast(f.this.mContext, d.l.book_plugin_not_install_tip);
                            return;
                        }
                        au.wd().c(f.this.crm.yi(), new String[]{url});
                        a.C0123a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqw(), f.this.crm.getForumId(), f.this.crm.getForumName(), null);
                        b.cj("obj_url", eVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cJD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bj bjVar;
            view.setPressed(false);
            if (f.this.cHL != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bj) && (bjVar = (bj) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.so(bjVar.getId());
                        aj.i(aVar.cJJ, d.e.cp_cont_c);
                    }
                    f.this.cHL.a(view, bjVar, BdUniqueId.gen(), null, f.this.cJC ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cJF = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cJE == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cJE.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.crm = fVar;
        this.mContext = fVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.u(this.mData);
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
            aVar.cJH = view;
            aVar.cJI = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cJJ = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cJK = (TextView) view.findViewById(d.h.top_item_rank);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(this.mData, i);
        if (fVar instanceof bj) {
            bj bjVar = (bj) fVar;
            if (bjVar != null) {
                a(aVar, bjVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.f.b.alu().a(cFj, bjVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.cJI, d.e.cp_link_tip_c);
            if (z) {
                aj.i(aVar.cJJ, d.e.cp_cont_c);
            } else {
                aj.i(aVar.cJJ, d.e.cp_cont_b);
            }
            aj.j(aVar.cJH, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cHL = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fr(boolean z) {
        this.cJB = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View cJH;
        TextView cJI;
        TextView cJJ;
        TextView cJK;
        int position;

        public a() {
        }
    }

    public View U(bj bjVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cJH = inflate;
        aVar.cJI = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cJJ = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, bjVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cJH = inflate;
        aVar.cJI = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cJJ = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cJK = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bj bjVar, int i) {
        if (aVar != null && bjVar != null) {
            aVar.cJI.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            bjVar.sl();
            SpannableStringBuilder sb = bjVar.sb();
            aVar.cJJ.setOnTouchListener(new m(sb));
            aVar.cJJ.setText(sb);
            aVar.cJH.setOnClickListener(this.cJD);
            aVar.cJH.setOnLongClickListener(this.cJF);
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sp(bjVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String la = la(eVar.aIW());
        aVar.cJJ.setText(eVar.getTitle());
        aVar.cJI.setText(la);
        if (eVar.aPJ() != 0) {
            aVar.cJK.setVisibility(0);
            if (eVar.aPJ() == -1) {
                aVar.cJK.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aPJ() > 999) {
                aVar.cJK.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cJK.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aPJ()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cJJ.setText(am.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cJK.setVisibility(8);
        }
        aj.i(aVar.cJI, d.e.cp_link_tip_d);
        aj.i(aVar.cJK, d.e.cp_link_tip_d);
        aj.j(aVar.cJH, d.g.home_thread_card_item_bg);
        aj.i(aVar.cJJ, d.e.cp_cont_b);
        aVar.cJJ.setTag(eVar);
        if (this.cJa != null) {
            aVar.cJH.setOnClickListener(this.cJa);
        }
        if (this.cIT != null && this.cIT.add(eVar.bqw())) {
            a.C0123a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bqw(), this.crm.getForumId(), this.crm.getForumName(), null);
            b.cj("obj_url", eVar.getUrl());
            b.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bj) {
            return U((bj) fVar);
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            return a((com.baidu.tieba.tbadkCore.e) fVar);
        }
        return null;
    }

    private String la(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cIT = hashSet;
    }
}
