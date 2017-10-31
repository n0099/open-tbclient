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
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.tbadkCore.d.a;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter implements c {
    private h cRB;
    public boolean cTs;
    private i cTt;
    private com.baidu.tieba.frs.f cyR;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cTr = false;
    protected HashSet<String> cSJ = new HashSet<>();
    protected final View.OnClickListener cSQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            if (aVar.cTy != null && (aVar.cTy.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cTy.getTag();
                            }
                        }
                        eVar = null;
                    }
                    if (eVar != null && !StringUtils.isNull(eVar.getUrl())) {
                        String url = eVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(f.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        av.vI().c(f.this.cyR.xH(), new String[]{url});
                        a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bso(), f.this.cyR.getForumId(), f.this.cyR.getForumName(), null);
                        b.ca("obj_url", eVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bwG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bh bhVar;
            view.setPressed(false);
            if (f.this.cRB != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bh) && (bhVar = (bh) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sF(bhVar.getId());
                        aj.i(aVar.cTy, d.C0080d.cp_cont_c);
                    }
                    f.this.cRB.a(view, bhVar, BdUniqueId.gen(), null, f.this.cTs ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cTu = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cTt == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cTt.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.cyR = fVar;
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
            view = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
            aVar.cTw = view;
            aVar.cTx = (TextView) view.findViewById(d.g.top_item_type);
            aVar.cTy = (TextView) view.findViewById(d.g.top_item_title);
            aVar.cTz = (TextView) view.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.e.b.aoe().a(cPd, bhVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.i(aVar.cTx, d.C0080d.cp_link_tip_c);
            if (z) {
                aj.i(aVar.cTy, d.C0080d.cp_cont_c);
            } else {
                aj.i(aVar.cTy, d.C0080d.cp_cont_b);
            }
            aj.j(aVar.cTw, d.f.home_thread_card_item_bg);
        }
    }

    public void c(h hVar) {
        this.cRB = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fj(boolean z) {
        this.cTr = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View cTw;
        TextView cTx;
        TextView cTy;
        TextView cTz;
        int position;

        public a() {
        }
    }

    public View R(bh bhVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.cTw = inflate;
        aVar.cTx = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.cTy = (TextView) inflate.findViewById(d.g.top_item_title);
        a(aVar, bhVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.cTw = inflate;
        aVar.cTx = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.cTy = (TextView) inflate.findViewById(d.g.top_item_title);
        aVar.cTz = (TextView) inflate.findViewById(d.g.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bh bhVar, int i) {
        if (aVar != null && bhVar != null) {
            aVar.cTx.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bhVar.se();
            SpannableStringBuilder rU = bhVar.rU();
            aVar.cTy.setOnTouchListener(new com.baidu.tieba.view.l(rU));
            aVar.cTy.setText(rU);
            aVar.cTw.setOnClickListener(this.bwG);
            aVar.cTw.setOnLongClickListener(this.cTu);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sG(bhVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String lx = lx(eVar.aKd());
        aVar.cTy.setText(eVar.getTitle());
        aVar.cTx.setText(lx);
        if (eVar.aQq() != 0) {
            aVar.cTz.setVisibility(0);
            if (eVar.aQq() == -1) {
                aVar.cTz.setText(this.mContext.getString(d.j.no_rank));
            } else if (eVar.aQq() > 999) {
                aVar.cTz.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.cTz.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(eVar.aQq()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cTy.setText(am.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cTz.setVisibility(8);
        }
        aj.i(aVar.cTx, d.C0080d.cp_link_tip_d);
        aj.i(aVar.cTz, d.C0080d.cp_link_tip_d);
        aj.j(aVar.cTw, d.f.home_thread_card_item_bg);
        aj.i(aVar.cTy, d.C0080d.cp_cont_b);
        aVar.cTy.setTag(eVar);
        if (this.cSQ != null) {
            aVar.cTw.setOnClickListener(this.cSQ);
        }
        if (this.cSJ != null && this.cSJ.add(eVar.bso())) {
            a.C0126a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bso(), this.cyR.getForumId(), this.cyR.getForumName(), null);
            b.ca("obj_url", eVar.getUrl());
            b.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bh) {
            return R((bh) fVar);
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            return a((com.baidu.tieba.tbadkCore.e) fVar);
        }
        return null;
    }

    private String lx(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.privilege);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cSJ = hashSet;
    }
}
