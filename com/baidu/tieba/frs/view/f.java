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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
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
    private n dLd;
    public boolean dLf;
    private o dLg;
    private FrsFragment dnR;
    private Context mContext;
    private List<h> mData;
    private boolean dLe = false;
    protected HashSet<String> dJX = new HashSet<>();
    private com.baidu.tieba.frs.e.a dtY = new com.baidu.tieba.frs.e.a();
    protected final View.OnClickListener dKf = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if ((f.this.mContext == null || ba.aV(f.this.mContext)) && view != null) {
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
                            l.showToast(f.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        ay.zK().c(f.this.dnR.aiy(), new String[]{url});
                        a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btW(), f.this.dnR.getForumId(), f.this.dnR.getForumName(), null);
                        b.cm("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bYH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bb bbVar;
            view.setPressed(false);
            if (f.this.dLd != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                h hVar = (h) w.d(f.this.mData, aVar.position);
                if ((hVar instanceof bb) && (bbVar = (bb) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tX(bbVar.getId());
                        am.h(aVar.titleText, d.C0140d.cp_cont_c);
                    }
                    f.this.dLd.a(view, bbVar, BdUniqueId.gen(), null, f.this.dLf ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).af("tid", bbVar.getTid()).af("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener cRQ = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.dLg == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.dLg.b(view, (h) w.d(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.dnR = frsFragment;
        this.mContext = frsFragment.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.y(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.d(this.mData, i);
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
            aVar.bzb = view;
            aVar.dLi = (TextView) view.findViewById(d.g.top_item_type);
            aVar.titleText = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dLj = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h hVar = (h) w.d(this.mData, i);
        if (hVar instanceof bb) {
            bb bbVar = (bb) hVar;
            if (bbVar != null) {
                a(aVar, bbVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.aAd().a(this.dtY, bbVar);
        } else if (hVar instanceof g) {
            a(aVar, (g) hVar);
        }
        if (w.d(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            am.h(aVar.dLi, d.C0140d.cp_link_tip_c);
            if (z) {
                am.h(aVar.titleText, d.C0140d.cp_cont_j);
            } else {
                am.h(aVar.titleText, d.C0140d.cp_cont_b);
            }
            am.i(aVar.bzb, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(am.getColor(d.C0140d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.dLd = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axh() {
        return this.dtY;
    }

    /* loaded from: classes2.dex */
    public class a {
        View bzb;
        TextView dLi;
        TextView dLj;
        View divider;
        int position;
        TextView titleText;

        public a() {
        }
    }

    private void a(a aVar, bb bbVar, int i) {
        if (aVar != null && bbVar != null) {
            aVar.dLi.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bbVar.vT();
            SpannableStringBuilder vJ = bbVar.vJ();
            aVar.titleText.setOnTouchListener(new k(vJ));
            aVar.titleText.setText(vJ);
            aVar.bzb.setOnClickListener(this.bYH);
            aVar.bzb.setOnLongClickListener(this.cRQ);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.tY(bbVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.titleText.setText(gVar.getTitle());
        aVar.dLi.setText(a2);
        if (gVar.btV() != 0) {
            aVar.dLj.setVisibility(0);
            if (gVar.btV() == -1) {
                aVar.dLj.setText(this.mContext.getString(d.j.no_rank));
            } else if (gVar.btV() > 999) {
                aVar.dLj.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dLj.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(gVar.btV()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.titleText.setText(ap.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dLj.setVisibility(8);
        }
        am.h(aVar.dLi, d.C0140d.cp_link_tip_c);
        am.h(aVar.dLj, d.C0140d.cp_link_tip_c);
        am.i(aVar.bzb, d.f.home_thread_card_item_bg);
        am.j(aVar.divider, d.C0140d.cp_bg_line_c);
        am.h(aVar.titleText, d.C0140d.cp_cont_b);
        aVar.titleText.setTag(gVar);
        if (this.dKf != null) {
            aVar.bzb.setOnClickListener(this.dKf);
        }
        if (this.dJX != null && this.dJX.add(gVar.btW())) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.btW(), this.dnR.getForumId(), this.dnR.getForumName(), null);
            b.cm("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.btU() == 1) {
            return TbadkCoreApplication.getInst().getString(d.j.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.btX()) || gVar.btX().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return gVar.btX();
    }

    public void a(HashSet<String> hashSet) {
        this.dJX = hashSet;
    }
}
