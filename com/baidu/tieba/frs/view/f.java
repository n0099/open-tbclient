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
    private h cGR;
    public boolean cII;
    private i cIK;
    private com.baidu.tieba.frs.f cqt;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cIH = false;
    protected HashSet<String> cHZ = new HashSet<>();
    protected final View.OnClickListener cIg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            if (aVar.cIP != null && (aVar.cIP.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cIP.getTag();
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
                        au.wd().c(f.this.cqt.yi(), new String[]{url});
                        a.C0124a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bql(), f.this.cqt.getForumId(), f.this.cqt.getForumName(), null);
                        b.cj("obj_url", eVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cIJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bj bjVar;
            view.setPressed(false);
            if (f.this.cGR != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bj) && (bjVar = (bj) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sm(bjVar.getId());
                        aj.i(aVar.cIP, d.e.cp_cont_c);
                    }
                    f.this.cGR.a(view, bjVar, BdUniqueId.gen(), null, f.this.cII ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cIL = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cIK == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cIK.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.cqt = fVar;
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
            aVar.cIN = view;
            aVar.cIO = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cIP = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cIQ = (TextView) view.findViewById(d.h.top_item_rank);
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
            com.baidu.tieba.frs.f.b.alj().a(cEr, bjVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.cIO, d.e.cp_link_tip_c);
            if (z) {
                aj.i(aVar.cIP, d.e.cp_cont_c);
            } else {
                aj.i(aVar.cIP, d.e.cp_cont_b);
            }
            aj.j(aVar.cIN, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cGR = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fq(boolean z) {
        this.cIH = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View cIN;
        TextView cIO;
        TextView cIP;
        TextView cIQ;
        int position;

        public a() {
        }
    }

    public View U(bj bjVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cIN = inflate;
        aVar.cIO = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cIP = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, bjVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cIN = inflate;
        aVar.cIO = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cIP = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cIQ = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bj bjVar, int i) {
        if (aVar != null && bjVar != null) {
            aVar.cIO.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            bjVar.sl();
            SpannableStringBuilder sb = bjVar.sb();
            aVar.cIP.setOnTouchListener(new m(sb));
            aVar.cIP.setText(sb);
            aVar.cIN.setOnClickListener(this.cIJ);
            aVar.cIN.setOnLongClickListener(this.cIL);
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sn(bjVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kY = kY(eVar.aIL());
        aVar.cIP.setText(eVar.getTitle());
        aVar.cIO.setText(kY);
        if (eVar.aPy() != 0) {
            aVar.cIQ.setVisibility(0);
            if (eVar.aPy() == -1) {
                aVar.cIQ.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aPy() > 999) {
                aVar.cIQ.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cIQ.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aPy()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cIP.setText(am.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cIQ.setVisibility(8);
        }
        aj.i(aVar.cIO, d.e.cp_link_tip_d);
        aj.i(aVar.cIQ, d.e.cp_link_tip_d);
        aj.j(aVar.cIN, d.g.home_thread_card_item_bg);
        aj.i(aVar.cIP, d.e.cp_cont_b);
        aVar.cIP.setTag(eVar);
        if (this.cIg != null) {
            aVar.cIN.setOnClickListener(this.cIg);
        }
        if (this.cHZ != null && this.cHZ.add(eVar.bql())) {
            a.C0124a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bql(), this.cqt.getForumId(), this.cqt.getForumName(), null);
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

    private String kY(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cHZ = hashSet;
    }
}
