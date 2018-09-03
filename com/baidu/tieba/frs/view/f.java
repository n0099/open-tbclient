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
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.core.util.w;
import com.baidu.tieba.f;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.g;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class f extends BaseAdapter implements com.baidu.tieba.frs.e.c {
    private n dKZ;
    public boolean dLb;
    private o dLc;
    private FrsFragment dnP;
    private Context mContext;
    private List<h> mData;
    private boolean dLa = false;
    protected HashSet<String> dJT = new HashSet<>();
    private com.baidu.tieba.frs.e.a dtV = new com.baidu.tieba.frs.e.a();
    protected final View.OnClickListener dKb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            g gVar;
            if ((f.this.mContext == null || bb.aU(f.this.mContext)) && view != null) {
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
                            l.showToast(f.this.mContext, f.j.book_plugin_not_install_tip);
                            return;
                        }
                        az.zI().c(f.this.dnP.aiB(), new String[]{url});
                        a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.btX(), f.this.dnP.getForumId(), f.this.dnP.getForumName(), null);
                        b.cm("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bYF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            com.baidu.tbadk.core.data.bb bbVar;
            view.setPressed(false);
            if (f.this.dKZ != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                h hVar = (h) w.d(f.this.mData, aVar.position);
                if ((hVar instanceof com.baidu.tbadk.core.data.bb) && (bbVar = (com.baidu.tbadk.core.data.bb) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.ub(bbVar.getId());
                        am.h(aVar.titleText, f.d.cp_cont_c);
                    }
                    f.this.dKZ.a(view, bbVar, BdUniqueId.gen(), null, f.this.dLb ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").f(ImageViewerConfig.FORUM_ID, bbVar.getFid()).ae("tid", bbVar.getTid()).ae("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener cRN = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.dLc == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.dLc.b(view, (h) w.d(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.dnP = frsFragment;
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
            view = LayoutInflater.from(this.mContext).inflate(f.h.frs_header_top_item, (ViewGroup) null, false);
            aVar.bzd = view;
            aVar.dLe = (TextView) view.findViewById(f.g.top_item_type);
            aVar.titleText = (TextView) view.findViewById(f.g.top_item_title);
            aVar.dLf = (TextView) view.findViewById(f.g.top_item_rank);
            aVar.divider = view.findViewById(f.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h hVar = (h) w.d(this.mData, i);
        if (hVar instanceof com.baidu.tbadk.core.data.bb) {
            com.baidu.tbadk.core.data.bb bbVar = (com.baidu.tbadk.core.data.bb) hVar;
            if (bbVar != null) {
                a(aVar, bbVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.aAa().a(this.dtV, bbVar);
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
            am.h(aVar.dLe, f.d.cp_link_tip_c);
            if (z) {
                am.h(aVar.titleText, f.d.cp_cont_j);
            } else {
                am.h(aVar.titleText, f.d.cp_cont_b);
            }
            am.i(aVar.bzd, f.C0146f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(am.getColor(f.d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.dKZ = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a axg() {
        return this.dtV;
    }

    /* loaded from: classes2.dex */
    public class a {
        View bzd;
        TextView dLe;
        TextView dLf;
        View divider;
        int position;
        TextView titleText;

        public a() {
        }
    }

    private void a(a aVar, com.baidu.tbadk.core.data.bb bbVar, int i) {
        if (aVar != null && bbVar != null) {
            aVar.dLe.setText(TbadkCoreApplication.getInst().getString(f.j.top));
            bbVar.vS();
            SpannableStringBuilder vI = bbVar.vI();
            aVar.titleText.setOnTouchListener(new k(vI));
            aVar.titleText.setText(vI);
            aVar.bzd.setOnClickListener(this.bYF);
            aVar.bzd.setOnLongClickListener(this.cRN);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.uc(bbVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.titleText.setText(gVar.getTitle());
        aVar.dLe.setText(a2);
        if (gVar.btW() != 0) {
            aVar.dLf.setVisibility(0);
            if (gVar.btW() == -1) {
                aVar.dLf.setText(this.mContext.getString(f.j.no_rank));
            } else if (gVar.btW() > 999) {
                aVar.dLf.setText(this.mContext.getString(f.j.rang_orer_thousand));
            } else {
                aVar.dLf.setText(this.mContext.getString(f.j.rang_identify) + String.valueOf(gVar.btW()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.titleText.setText(ap.d(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dLf.setVisibility(8);
        }
        am.h(aVar.dLe, f.d.cp_link_tip_c);
        am.h(aVar.dLf, f.d.cp_link_tip_c);
        am.i(aVar.bzd, f.C0146f.home_thread_card_item_bg);
        am.j(aVar.divider, f.d.cp_bg_line_c);
        am.h(aVar.titleText, f.d.cp_cont_b);
        aVar.titleText.setTag(gVar);
        if (this.dKb != null) {
            aVar.bzd.setOnClickListener(this.dKb);
        }
        if (this.dJT != null && this.dJT.add(gVar.btX())) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.btX(), this.dnP.getForumId(), this.dnP.getForumName(), null);
            b.cm("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.btV() == 1) {
            return TbadkCoreApplication.getInst().getString(f.j.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.btY()) || gVar.btY().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(f.j.top_announcement);
        }
        return gVar.btY();
    }

    public void a(HashSet<String> hashSet) {
        this.dJT = hashSet;
    }
}
