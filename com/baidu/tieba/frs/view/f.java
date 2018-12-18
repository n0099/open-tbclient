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
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.o;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.e;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes6.dex */
public class f extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private FrsFragment dJE;
    private n eij;
    public boolean eil;
    private o eim;
    private Context mContext;
    private List<h> mData;
    private boolean eik = false;
    protected HashSet<String> egV = new HashSet<>();
    private com.baidu.tieba.frs.e.a dQi = new com.baidu.tieba.frs.e.a();
    protected final View.OnClickListener ehd = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if ((f.this.mContext == null || ba.bJ(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof g) {
                        gVar = (g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.titleText != null && (aVar.titleText.getTag() instanceof g)) {
                                gVar = (g) aVar.titleText.getTag();
                            }
                        }
                        gVar = null;
                    }
                    if (gVar != null && !StringUtils.isNull(gVar.getUrl())) {
                        String url = gVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(f.this.mContext, e.j.book_plugin_not_install_tip);
                            return;
                        }
                        ay.Ef().c(f.this.dJE.getTbPageContext(), new String[]{url});
                        a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bBh(), f.this.dJE.getForumId(), f.this.dJE.getForumName(), null);
                        b.cM("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener crg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bb bbVar;
            view.setPressed(false);
            if (f.this.eij != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                h hVar = (h) v.d(f.this.mData, aVar.position);
                if ((hVar instanceof bb) && (bbVar = (bb) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.vQ(bbVar.getId());
                        al.h(aVar.titleText, e.d.cp_cont_c);
                    }
                    f.this.eij.a(view, bbVar, BdUniqueId.gen(), null, f.this.eil ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new am("c13124").i(ImageViewerConfig.FORUM_ID, bbVar.getFid()).aA("tid", bbVar.getTid()).aA("uid", TbadkCoreApplication.getCurrentAccount()).x("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener dnI = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.eim == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.eim.b(view, (h) v.d(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.dJE = frsFragment;
        this.mContext = frsFragment.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.H(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.d(this.mData, i);
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
            view = LayoutInflater.from(this.mContext).inflate(e.h.frs_header_top_item, (ViewGroup) null, false);
            aVar.bRX = view;
            aVar.eio = (TextView) view.findViewById(e.g.top_item_type);
            aVar.titleText = (TextView) view.findViewById(e.g.top_item_title);
            aVar.eip = (TextView) view.findViewById(e.g.top_item_rank);
            aVar.divider = view.findViewById(e.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h hVar = (h) v.d(this.mData, i);
        if (hVar instanceof bb) {
            bb bbVar = (bb) hVar;
            if (bbVar != null) {
                a(aVar, bbVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.aGK().a(this.dQi, bbVar);
        } else if (hVar instanceof g) {
            a(aVar, (g) hVar);
        }
        if (v.d(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            al.h(aVar.eio, e.d.cp_link_tip_c);
            if (z) {
                al.h(aVar.titleText, e.d.cp_cont_j);
            } else {
                al.h(aVar.titleText, e.d.cp_cont_b);
            }
            al.i(aVar.bRX, e.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(al.getColor(e.d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.eij = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a aDT() {
        return this.dQi;
    }

    /* loaded from: classes6.dex */
    public class a {
        View bRX;
        View divider;
        TextView eio;
        TextView eip;
        int position;
        TextView titleText;

        public a() {
        }
    }

    private void a(a aVar, bb bbVar, int i) {
        if (aVar != null && bbVar != null) {
            aVar.eio.setText(TbadkCoreApplication.getInst().getString(e.j.top));
            bbVar.Ar();
            SpannableStringBuilder Ag = bbVar.Ag();
            aVar.titleText.setOnTouchListener(new k(Ag));
            aVar.titleText.setText(Ag);
            aVar.bRX.setOnClickListener(this.crg);
            aVar.bRX.setOnLongClickListener(this.dnI);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.vR(bbVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.titleText.setText(gVar.getTitle());
        aVar.eio.setText(a2);
        if (gVar.bBg() != 0) {
            aVar.eip.setVisibility(0);
            if (gVar.bBg() == -1) {
                aVar.eip.setText(this.mContext.getString(e.j.no_rank));
            } else if (gVar.bBg() > 999) {
                aVar.eip.setText(this.mContext.getString(e.j.rang_orer_thousand));
            } else {
                aVar.eip.setText(this.mContext.getString(e.j.rang_identify) + String.valueOf(gVar.bBg()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.titleText.setText(ao.d(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.eip.setVisibility(8);
        }
        al.h(aVar.eio, e.d.cp_link_tip_c);
        al.h(aVar.eip, e.d.cp_link_tip_c);
        al.i(aVar.bRX, e.f.home_thread_card_item_bg);
        al.j(aVar.divider, e.d.cp_bg_line_c);
        al.h(aVar.titleText, e.d.cp_cont_b);
        aVar.titleText.setTag(gVar);
        if (this.ehd != null) {
            aVar.bRX.setOnClickListener(this.ehd);
        }
        if (this.egV != null && this.egV.add(gVar.bBh())) {
            a.C0316a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bBh(), this.dJE.getForumId(), this.dJE.getForumName(), null);
            b.cM("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.bBf() == 1) {
            return TbadkCoreApplication.getInst().getString(e.j.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.bBi()) || gVar.bBi().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(e.j.top_announcement);
        }
        return gVar.bBi();
    }

    public void b(HashSet<String> hashSet) {
        this.egV = hashSet;
    }
}
