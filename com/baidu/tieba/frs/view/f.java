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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private n dET;
    public boolean dEV;
    private o dEW;
    private FrsFragment diZ;
    private Context mContext;
    private List<h> mData;
    private boolean dEU = false;
    protected HashSet<String> dDS = new HashSet<>();
    protected final View.OnClickListener dEa = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if ((f.this.mContext == null || ba.aU(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof g) {
                        gVar = (g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dwI != null && (aVar.dwI.getTag() instanceof g)) {
                                gVar = (g) aVar.dwI.getTag();
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
                        ay.zG().c(f.this.diZ.aiH(), new String[]{url});
                        a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.buT(), f.this.diZ.getForumId(), f.this.diZ.getForumName(), null);
                        b.cl("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bVm = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bd bdVar;
            view.setPressed(false);
            if (f.this.dET != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                h hVar = (h) w.c(f.this.mData, aVar.position);
                if ((hVar instanceof bd) && (bdVar = (bd) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tZ(bdVar.getId());
                        al.h(aVar.dwI, d.C0141d.cp_cont_c);
                    }
                    f.this.dET.a(view, bdVar, BdUniqueId.gen(), null, f.this.dEV ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cRm = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.dEW == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.dEW.b(view, (h) w.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.diZ = frsFragment;
        this.mContext = frsFragment.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.c(this.mData, i);
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.frs_header_top_item, (ViewGroup) null, false);
            aVar.root = view;
            aVar.dEY = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dwI = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dEZ = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h hVar = (h) w.c(this.mData, i);
        if (hVar instanceof bd) {
            bd bdVar = (bd) hVar;
            if (bdVar != null) {
                a(aVar, bdVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.ayQ().a(dyP, bdVar);
        } else if (hVar instanceof g) {
            a(aVar, (g) hVar);
        }
        if (w.c(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            al.h(aVar.dEY, d.C0141d.cp_link_tip_c);
            if (z) {
                al.h(aVar.dwI, d.C0141d.cp_cont_j);
            } else {
                al.h(aVar.dwI, d.C0141d.cp_cont_b);
            }
            al.i(aVar.root, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(al.getColor(d.C0141d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.dET = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        TextView dEY;
        TextView dEZ;
        View divider;
        TextView dwI;
        int position;
        View root;

        public a() {
        }
    }

    private void a(a aVar, bd bdVar, int i) {
        if (aVar != null && bdVar != null) {
            aVar.dEY.setText(TbadkCoreApplication.getInst().getString(d.k.top));
            bdVar.vU();
            SpannableStringBuilder vK = bdVar.vK();
            aVar.dwI.setOnTouchListener(new k(vK));
            aVar.dwI.setText(vK);
            aVar.root.setOnClickListener(this.bVm);
            aVar.root.setOnLongClickListener(this.cRm);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.ua(bdVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.dwI.setText(gVar.getTitle());
        aVar.dEY.setText(a2);
        if (gVar.buS() != 0) {
            aVar.dEZ.setVisibility(0);
            if (gVar.buS() == -1) {
                aVar.dEZ.setText(this.mContext.getString(d.k.no_rank));
            } else if (gVar.buS() > 999) {
                aVar.dEZ.setText(this.mContext.getString(d.k.rang_orer_thousand));
            } else {
                aVar.dEZ.setText(this.mContext.getString(d.k.rang_identify) + String.valueOf(gVar.buS()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dwI.setText(ao.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dEZ.setVisibility(8);
        }
        al.h(aVar.dEY, d.C0141d.cp_link_tip_c);
        al.h(aVar.dEZ, d.C0141d.cp_link_tip_c);
        al.i(aVar.root, d.f.home_thread_card_item_bg);
        al.j(aVar.divider, d.C0141d.cp_bg_line_c);
        al.h(aVar.dwI, d.C0141d.cp_cont_b);
        aVar.dwI.setTag(gVar);
        if (this.dEa != null) {
            aVar.root.setOnClickListener(this.dEa);
        }
        if (this.dDS != null && this.dDS.add(gVar.buT())) {
            a.C0234a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.buT(), this.diZ.getForumId(), this.diZ.getForumName(), null);
            b.cl("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.buR() == 1) {
            return TbadkCoreApplication.getInst().getString(d.k.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.aTM()) || gVar.aTM().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.k.top_announcement);
        }
        return gVar.aTM();
    }

    public void a(HashSet<String> hashSet) {
        this.dDS = hashSet;
    }
}
