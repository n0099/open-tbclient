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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.view.j;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private FrsFragment cYC;
    public boolean duA;
    private o duB;
    private n duy;
    private Context mContext;
    private List<h> mData;
    private boolean duz = false;
    protected HashSet<String> dtx = new HashSet<>();
    protected final View.OnClickListener dtF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            g gVar;
            if ((f.this.mContext == null || az.aK(f.this.mContext)) && view2 != null) {
                if ((view2.getTag() instanceof g) || (view2.getTag() instanceof a)) {
                    if (view2.getTag() instanceof g) {
                        gVar = (g) view2.getTag();
                    } else {
                        if (view2.getTag() instanceof a) {
                            a aVar = (a) view2.getTag();
                            if (aVar.dmj != null && (aVar.dmj.getTag() instanceof g)) {
                                gVar = (g) aVar.dmj.getTag();
                            }
                        }
                        gVar = null;
                    }
                    if (gVar != null && !StringUtils.isNull(gVar.getUrl())) {
                        String url = gVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(f.this.mContext, d.k.book_plugin_not_install_tip);
                            return;
                        }
                        ax.wg().c(f.this.cYC.aeY(), new String[]{url});
                        a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bpU(), f.this.cYC.getForumId(), f.this.cYC.getForumName(), null);
                        b.cd("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bMv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            a aVar;
            bd bdVar;
            view2.setPressed(false);
            if (f.this.duy != null && (view2.getTag() instanceof a) && (aVar = (a) view2.getTag()) != null) {
                h hVar = (h) v.c(f.this.mData, aVar.position);
                if ((hVar instanceof bd) && (bdVar = (bd) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tc(bdVar.getId());
                        ak.h(aVar.dmj, d.C0126d.cp_cont_c);
                    }
                    f.this.duy.a(view2, bdVar, BdUniqueId.gen(), null, f.this.duA ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cGW = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            if (f.this.duB == null || !(view2.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view2.getTag();
            return f.this.duB.b(view2, (h) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.cYC = frsFragment;
        this.mContext = frsFragment.getPageContext().getPageActivity();
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
    public View getView(int i, View view2, ViewGroup viewGroup) {
        a aVar;
        if (view2 == null) {
            aVar = new a();
            view2 = LayoutInflater.from(this.mContext).inflate(d.i.frs_header_top_item, (ViewGroup) null, false);
            aVar.root = view2;
            aVar.duD = (TextView) view2.findViewById(d.g.top_item_type);
            aVar.dmj = (TextView) view2.findViewById(d.g.top_item_title);
            aVar.duE = (TextView) view2.findViewById(d.g.top_item_rank);
            aVar.divider = view2.findViewById(d.g.top_item_divider);
            view2.setTag(aVar);
        } else {
            aVar = (a) view2.getTag();
        }
        h hVar = (h) v.c(this.mData, i);
        if (hVar instanceof bd) {
            bd bdVar = (bd) hVar;
            if (bdVar != null) {
                a(aVar, bdVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.auH().a(dov, bdVar);
        } else if (hVar instanceof g) {
            a(aVar, (g) hVar);
        }
        if (v.c(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view2;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ak.h(aVar.duD, d.C0126d.cp_link_tip_c);
            if (z) {
                ak.h(aVar.dmj, d.C0126d.cp_cont_j);
            } else {
                ak.h(aVar.dmj, d.C0126d.cp_cont_b);
            }
            ak.i(aVar.root, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.duy = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View divider;
        TextView dmj;
        TextView duD;
        TextView duE;
        int position;
        View root;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.duD.setText(TbadkCoreApplication.getInst().getString(d.k.top));
            bdVar.sy();
            SpannableStringBuilder so = bdVar.so();
            aVar.dmj.setOnTouchListener(new j(so));
            aVar.dmj.setText(so);
            aVar.root.setOnClickListener(this.bMv);
            aVar.root.setOnLongClickListener(this.cGW);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.td(bdVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.dmj.setText(gVar.getTitle());
        aVar.duD.setText(a2);
        if (gVar.bpT() != 0) {
            aVar.duE.setVisibility(0);
            if (gVar.bpT() == -1) {
                aVar.duE.setText(this.mContext.getString(d.k.no_rank));
            } else if (gVar.bpT() > 999) {
                aVar.duE.setText(this.mContext.getString(d.k.rang_orer_thousand));
            } else {
                aVar.duE.setText(this.mContext.getString(d.k.rang_identify) + String.valueOf(gVar.bpT()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dmj.setText(an.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.duE.setVisibility(8);
        }
        ak.h(aVar.duD, d.C0126d.cp_link_tip_c);
        ak.h(aVar.duE, d.C0126d.cp_link_tip_c);
        ak.i(aVar.root, d.f.home_thread_card_item_bg);
        ak.j(aVar.divider, d.C0126d.cp_bg_line_c);
        ak.h(aVar.dmj, d.C0126d.cp_cont_b);
        aVar.dmj.setTag(gVar);
        if (this.dtF != null) {
            aVar.root.setOnClickListener(this.dtF);
        }
        if (this.dtx != null && this.dtx.add(gVar.bpU())) {
            a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bpU(), this.cYC.getForumId(), this.cYC.getForumName(), null);
            b.cd("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.bpS() == 1) {
            return TbadkCoreApplication.getInst().getString(d.k.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.aOQ()) || gVar.aOQ().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.k.top_announcement);
        }
        return gVar.aOQ();
    }

    public void a(HashSet<String> hashSet) {
        this.dtx = hashSet;
    }
}
