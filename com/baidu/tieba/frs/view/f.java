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
import com.baidu.tbadk.core.data.bd;
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
    private com.baidu.tieba.frs.f cIp;
    private h daZ;
    public boolean dcU;
    private i dcV;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean dcT = false;
    protected HashSet<String> dcj = new HashSet<>();
    protected final View.OnClickListener dcr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.f fVar;
            if ((f.this.mContext == null || ax.aV(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.f) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.f) {
                        fVar = (com.baidu.tieba.tbadkCore.f) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dda != null && (aVar.dda.getTag() instanceof com.baidu.tieba.tbadkCore.f)) {
                                fVar = (com.baidu.tieba.tbadkCore.f) aVar.dda.getTag();
                            }
                        }
                        fVar = null;
                    }
                    if (fVar != null && !StringUtils.isNull(fVar.getUrl())) {
                        String url = fVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(f.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        av.vL().c(f.this.cIp.xQ(), new String[]{url});
                        a.C0128a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", fVar.bug(), f.this.cIp.getForumId(), f.this.cIp.getForumName(), null);
                        b.cf("obj_url", fVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bDu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (f.this.daZ != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position);
                if ((fVar instanceof bd) && (bdVar = (bd) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.ti(bdVar.getId());
                        aj.i(aVar.dda, d.C0082d.cp_cont_c);
                    }
                    f.this.daZ.a(view, bdVar, BdUniqueId.gen(), null, f.this.dcU ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener dcW = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.dcV == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.dcV.b(view, (com.baidu.adp.widget.ListView.f) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.cIp = fVar;
        this.mContext = fVar.getPageContext().getPageActivity();
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
            aVar.dcY = view;
            aVar.dcZ = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dda = (TextView) view.findViewById(d.g.top_item_title);
            aVar.ddb = (TextView) view.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.e.b.aqn().a(cYM, bdVar);
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
            aj.i(aVar.dcZ, d.C0082d.cp_link_tip_c);
            if (z) {
                aj.i(aVar.dda, d.C0082d.cp_cont_c);
            } else {
                aj.i(aVar.dda, d.C0082d.cp_cont_b);
            }
            aj.j(aVar.dcY, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_c));
            }
        }
    }

    public void c(h hVar) {
        this.daZ = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    /* loaded from: classes.dex */
    public class a {
        View dcY;
        TextView dcZ;
        TextView dda;
        TextView ddb;
        View divider;
        int position;

        public a() {
        }
    }

    public View T(bd bdVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.dcY = inflate;
        aVar.dcZ = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.dda = (TextView) inflate.findViewById(d.g.top_item_title);
        a(aVar, bdVar, 0);
        inflate.setTag(aVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_c));
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.f fVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item, (ViewGroup) null);
        aVar.dcY = inflate;
        aVar.dcZ = (TextView) inflate.findViewById(d.g.top_item_type);
        aVar.dda = (TextView) inflate.findViewById(d.g.top_item_title);
        aVar.ddb = (TextView) inflate.findViewById(d.g.top_item_rank);
        a(aVar, fVar);
        inflate.setTag(fVar);
        inflate.setTag(d.g.menu_tag, aVar);
        aVar.divider = inflate.findViewById(d.g.top_item_divider);
        aVar.divider.setVisibility(8);
        aVar.divider.setBackgroundColor(aj.getColor(d.C0082d.cp_bg_line_c));
        return inflate;
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dcZ.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bdVar.sh();
            SpannableStringBuilder rX = bdVar.rX();
            aVar.dda.setOnTouchListener(new com.baidu.tieba.view.l(rX));
            aVar.dda.setText(rX);
            aVar.dcY.setOnClickListener(this.bDu);
            aVar.dcY.setOnLongClickListener(this.dcW);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.tj(bdVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.f fVar) {
        String lI = lI(fVar.aKQ());
        aVar.dda.setText(fVar.getTitle());
        aVar.dcZ.setText(lI);
        if (fVar.aRK() != 0) {
            aVar.ddb.setVisibility(0);
            if (fVar.aRK() == -1) {
                aVar.ddb.setText(this.mContext.getString(d.j.no_rank));
            } else if (fVar.aRK() > 999) {
                aVar.ddb.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.ddb.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(fVar.aRK()));
            }
            if (!StringUtils.isNull(fVar.getTitle())) {
                aVar.dda.setText(am.e(fVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.ddb.setVisibility(8);
        }
        aj.i(aVar.dcZ, d.C0082d.cp_link_tip_c);
        aj.i(aVar.ddb, d.C0082d.cp_link_tip_c);
        aj.j(aVar.dcY, d.f.home_thread_card_item_bg);
        aj.k(aVar.divider, d.C0082d.cp_bg_line_c);
        aj.i(aVar.dda, d.C0082d.cp_cont_b);
        aVar.dda.setTag(fVar);
        if (this.dcr != null) {
            aVar.dcY.setOnClickListener(this.dcr);
        }
        if (this.dcj != null && this.dcj.add(fVar.bug())) {
            a.C0128a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", fVar.bug(), this.cIp.getForumId(), this.cIp.getForumName(), null);
            b.cf("obj_url", fVar.getUrl());
            b.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bd) {
            return T((bd) fVar);
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
        this.dcj = hashSet;
    }
}
