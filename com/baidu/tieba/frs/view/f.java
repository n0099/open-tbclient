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
    private h cIB;
    public boolean cKs;
    private i cKu;
    private com.baidu.tieba.frs.f crI;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cKr = false;
    protected HashSet<String> cJJ = new HashSet<>();
    protected final View.OnClickListener cJQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            if (aVar.cKz != null && (aVar.cKz.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cKz.getTag();
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
                        av.vH().c(f.this.crI.xH(), new String[]{url});
                        a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bpr(), f.this.crI.getForumId(), f.this.crI.getForumName(), null);
                        b.ce("obj_url", eVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cKt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bh bhVar;
            view.setPressed(false);
            if (f.this.cIB != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bh) && (bhVar = (bh) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.rY(bhVar.getId());
                        aj.i(aVar.cKz, d.e.cp_cont_c);
                    }
                    f.this.cIB.a(view, bhVar, BdUniqueId.gen(), null, f.this.cKs ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cKv = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cKu == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cKu.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.crI = fVar;
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
            aVar.cKx = view;
            aVar.cKy = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cKz = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cKA = (TextView) view.findViewById(d.h.top_item_rank);
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
            com.baidu.tieba.frs.f.b.aly().a(cGc, bhVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.cKy, d.e.cp_link_tip_c);
            if (z) {
                aj.i(aVar.cKz, d.e.cp_cont_c);
            } else {
                aj.i(aVar.cKz, d.e.cp_cont_b);
            }
            aj.j(aVar.cKx, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cIB = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fl(boolean z) {
        this.cKr = z;
    }

    /* loaded from: classes.dex */
    public class a {
        TextView cKA;
        View cKx;
        TextView cKy;
        TextView cKz;
        int position;

        public a() {
        }
    }

    public View P(bh bhVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cKx = inflate;
        aVar.cKy = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cKz = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, bhVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cKx = inflate;
        aVar.cKy = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cKz = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cKA = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bh bhVar, int i) {
        if (aVar != null && bhVar != null) {
            aVar.cKy.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            bhVar.sf();
            SpannableStringBuilder rV = bhVar.rV();
            aVar.cKz.setOnTouchListener(new k(rV));
            aVar.cKz.setText(rV);
            aVar.cKx.setOnClickListener(this.cKt);
            aVar.cKx.setOnLongClickListener(this.cKv);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.rZ(bhVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kX = kX(eVar.aHM());
        aVar.cKz.setText(eVar.getTitle());
        aVar.cKy.setText(kX);
        if (eVar.aND() != 0) {
            aVar.cKA.setVisibility(0);
            if (eVar.aND() == -1) {
                aVar.cKA.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aND() > 999) {
                aVar.cKA.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cKA.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aND()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cKz.setText(am.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cKA.setVisibility(8);
        }
        aj.i(aVar.cKy, d.e.cp_link_tip_d);
        aj.i(aVar.cKA, d.e.cp_link_tip_d);
        aj.j(aVar.cKx, d.g.home_thread_card_item_bg);
        aj.i(aVar.cKz, d.e.cp_cont_b);
        aVar.cKz.setTag(eVar);
        if (this.cJQ != null) {
            aVar.cKx.setOnClickListener(this.cJQ);
        }
        if (this.cJJ != null && this.cJJ.add(eVar.bpr())) {
            a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bpr(), this.crI.getForumId(), this.crI.getForumName(), null);
            b.ce("obj_url", eVar.getUrl());
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

    private String kX(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cJJ = hashSet;
    }
}
