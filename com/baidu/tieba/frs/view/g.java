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
    private i dCx;
    private o dVc;
    public boolean dVe;
    private p dVf;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.i> mData;
    private boolean dVd = false;
    protected HashSet<String> dUt = new HashSet<>();
    protected final View.OnClickListener dUB = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((g.this.mContext == null || ax.be(g.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) {
                        gVar = (com.baidu.tieba.tbadkCore.g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dVk != null && (aVar.dVk.getTag() instanceof com.baidu.tieba.tbadkCore.g)) {
                                gVar = (com.baidu.tieba.tbadkCore.g) aVar.dVk.getTag();
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
                        av.CZ().c(g.this.dCx.aka(), new String[]{url});
                        a.C0154a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btv(), g.this.dCx.getForumId(), g.this.dCx.getForumName(), null);
                        b.cd("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener csc = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (g.this.dVc != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position);
                if ((iVar instanceof bd) && (bdVar = (bd) iVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sG(bdVar.getId());
                        aj.r(aVar.dVk, d.C0107d.cp_cont_c);
                    }
                    g.this.dVc.a(view, bdVar, BdUniqueId.gen(), null, g.this.dVe ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener dVg = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.g.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (g.this.dVf == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return g.this.dVf.b(view, (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public g(i iVar) {
        this.dCx = iVar;
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
            aVar.dVi = view;
            aVar.dVj = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dVk = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dVl = (TextView) view.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.d.b.ayK().a(dQJ, bdVar);
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
            aj.r(aVar.dVj, d.C0107d.cp_link_tip_c);
            if (z) {
                aj.r(aVar.dVk, d.C0107d.cp_cont_j);
            } else {
                aj.r(aVar.dVk, d.C0107d.cp_cont_b);
            }
            aj.s(aVar.dVi, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0107d.cp_bg_line_c));
            }
        }
    }

    public void c(o oVar) {
        this.dVc = oVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.i> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View dVi;
        TextView dVj;
        TextView dVk;
        TextView dVl;
        View divider;
        int position;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dVj.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.zC();
            SpannableStringBuilder zs = bdVar.zs();
            aVar.dVk.setOnTouchListener(new m(zs));
            aVar.dVk.setText(zs);
            aVar.dVi.setOnClickListener(this.csc);
            aVar.dVi.setOnLongClickListener(this.dVg);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sH(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.g gVar) {
        String ma = ma(gVar.aSf());
        aVar.dVk.setText(gVar.getTitle());
        aVar.dVj.setText(ma);
        if (gVar.aZj() != 0) {
            aVar.dVl.setVisibility(0);
            if (gVar.aZj() == -1) {
                aVar.dVl.setText(this.mContext.getString(d.j.no_rank));
            } else if (gVar.aZj() > 999) {
                aVar.dVl.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dVl.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(gVar.aZj()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dVk.setText(am.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dVl.setVisibility(8);
        }
        aj.r(aVar.dVj, d.C0107d.cp_link_tip_c);
        aj.r(aVar.dVl, d.C0107d.cp_link_tip_c);
        aj.s(aVar.dVi, d.f.home_thread_card_item_bg);
        aj.t(aVar.divider, d.C0107d.cp_bg_line_c);
        aj.r(aVar.dVk, d.C0107d.cp_cont_b);
        aVar.dVk.setTag(gVar);
        if (this.dUB != null) {
            aVar.dVi.setOnClickListener(this.dUB);
        }
        if (this.dUt != null && this.dUt.add(gVar.btv())) {
            a.C0154a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.btv(), this.dCx.getForumId(), this.dCx.getForumName(), null);
            b.cd("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String ma(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.dUt = hashSet;
    }
}
