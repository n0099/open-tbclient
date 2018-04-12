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
    private FrsFragment cYF;
    private n duB;
    public boolean duD;
    private o duE;
    private Context mContext;
    private List<h> mData;
    private boolean duC = false;
    protected HashSet<String> dtA = new HashSet<>();
    protected final View.OnClickListener dtI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            if (aVar.dmm != null && (aVar.dmm.getTag() instanceof g)) {
                                gVar = (g) aVar.dmm.getTag();
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
                        ax.wg().c(f.this.cYF.aeY(), new String[]{url});
                        a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bpU(), f.this.cYF.getForumId(), f.this.cYF.getForumName(), null);
                        b.cd("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bMw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            a aVar;
            bd bdVar;
            view2.setPressed(false);
            if (f.this.duB != null && (view2.getTag() instanceof a) && (aVar = (a) view2.getTag()) != null) {
                h hVar = (h) v.c(f.this.mData, aVar.position);
                if ((hVar instanceof bd) && (bdVar = (bd) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tc(bdVar.getId());
                        ak.h(aVar.dmm, d.C0126d.cp_cont_c);
                    }
                    f.this.duB.a(view2, bdVar, BdUniqueId.gen(), null, f.this.duD ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cGZ = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            if (f.this.duE == null || !(view2.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view2.getTag();
            return f.this.duE.b(view2, (h) v.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.cYF = frsFragment;
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
            aVar.duG = (TextView) view2.findViewById(d.g.top_item_type);
            aVar.dmm = (TextView) view2.findViewById(d.g.top_item_title);
            aVar.duH = (TextView) view2.findViewById(d.g.top_item_rank);
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
            com.baidu.tieba.frs.e.b.auH().a(doy, bdVar);
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
            ak.h(aVar.duG, d.C0126d.cp_link_tip_c);
            if (z) {
                ak.h(aVar.dmm, d.C0126d.cp_cont_j);
            } else {
                ak.h(aVar.dmm, d.C0126d.cp_cont_b);
            }
            ak.i(aVar.root, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(ak.getColor(d.C0126d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.duB = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View divider;
        TextView dmm;
        TextView duG;
        TextView duH;
        int position;
        View root;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.duG.setText(TbadkCoreApplication.getInst().getString(d.k.top));
            bdVar.sy();
            SpannableStringBuilder so = bdVar.so();
            aVar.dmm.setOnTouchListener(new j(so));
            aVar.dmm.setText(so);
            aVar.root.setOnClickListener(this.bMw);
            aVar.root.setOnLongClickListener(this.cGZ);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.td(bdVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.dmm.setText(gVar.getTitle());
        aVar.duG.setText(a2);
        if (gVar.bpT() != 0) {
            aVar.duH.setVisibility(0);
            if (gVar.bpT() == -1) {
                aVar.duH.setText(this.mContext.getString(d.k.no_rank));
            } else if (gVar.bpT() > 999) {
                aVar.duH.setText(this.mContext.getString(d.k.rang_orer_thousand));
            } else {
                aVar.duH.setText(this.mContext.getString(d.k.rang_identify) + String.valueOf(gVar.bpT()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dmm.setText(an.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.duH.setVisibility(8);
        }
        ak.h(aVar.duG, d.C0126d.cp_link_tip_c);
        ak.h(aVar.duH, d.C0126d.cp_link_tip_c);
        ak.i(aVar.root, d.f.home_thread_card_item_bg);
        ak.j(aVar.divider, d.C0126d.cp_bg_line_c);
        ak.h(aVar.dmm, d.C0126d.cp_cont_b);
        aVar.dmm.setTag(gVar);
        if (this.dtI != null) {
            aVar.root.setOnClickListener(this.dtI);
        }
        if (this.dtA != null && this.dtA.add(gVar.bpU())) {
            a.C0217a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bpU(), this.cYF.getForumId(), this.cYF.getForumName(), null);
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
        this.dtA = hashSet;
    }
}
