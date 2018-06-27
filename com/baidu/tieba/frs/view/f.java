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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.core.util.bb;
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
    private n dIo;
    public boolean dIq;
    private o dIr;
    private FrsFragment dla;
    private Context mContext;
    private List<h> mData;
    private boolean dIp = false;
    protected HashSet<String> dHi = new HashSet<>();
    private com.baidu.tieba.frs.e.a drl = new com.baidu.tieba.frs.e.a();
    protected final View.OnClickListener dHq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            l.showToast(f.this.mContext, d.k.book_plugin_not_install_tip);
                            return;
                        }
                        az.zV().c(f.this.dla.ahZ(), new String[]{url});
                        a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bvt(), f.this.dla.getForumId(), f.this.dla.getForumName(), null);
                        b.cp("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener bXw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bc bcVar;
            view.setPressed(false);
            if (f.this.dIo != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                h hVar = (h) w.d(f.this.mData, aVar.position);
                if ((hVar instanceof bc) && (bcVar = (bc) hVar) != null) {
                    com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tZ(bcVar.getId());
                        am.h(aVar.titleText, d.C0142d.cp_cont_c);
                    }
                    f.this.dIo.a(view, bcVar, BdUniqueId.gen(), null, f.this.dIq ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").f(ImageViewerConfig.FORUM_ID, bcVar.getFid()).ah("tid", bcVar.getTid()).ah("uid", TbadkCoreApplication.getCurrentAccount()).r("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener cPh = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.dIr == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.dIr.b(view, (h) w.d(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(FrsFragment frsFragment) {
        this.dla = frsFragment;
        this.mContext = frsFragment.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return w.z(this.mData);
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
            view = LayoutInflater.from(this.mContext).inflate(d.i.frs_header_top_item, (ViewGroup) null, false);
            aVar.root = view;
            aVar.dIt = (TextView) view.findViewById(d.g.top_item_type);
            aVar.titleText = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dIu = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        h hVar = (h) w.d(this.mData, i);
        if (hVar instanceof bc) {
            bc bcVar = (bc) hVar;
            if (bcVar != null) {
                a(aVar, bcVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.e.b.azw().a(this.drl, bcVar);
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
            am.h(aVar.dIt, d.C0142d.cp_link_tip_c);
            if (z) {
                am.h(aVar.titleText, d.C0142d.cp_cont_j);
            } else {
                am.h(aVar.titleText, d.C0142d.cp_cont_b);
            }
            am.i(aVar.root, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(am.getColor(d.C0142d.cp_bg_line_c));
            }
        }
    }

    public void c(n nVar) {
        this.dIo = nVar;
    }

    public void setData(List<h> list) {
        this.mData = list;
    }

    @Override // com.baidu.tieba.frs.e.c
    public com.baidu.tieba.frs.e.a awC() {
        return this.drl;
    }

    /* loaded from: classes2.dex */
    public class a {
        TextView dIt;
        TextView dIu;
        View divider;
        int position;
        View root;
        TextView titleText;

        public a() {
        }
    }

    private void a(a aVar, bc bcVar, int i) {
        if (aVar != null && bcVar != null) {
            aVar.dIt.setText(TbadkCoreApplication.getInst().getString(d.k.top));
            bcVar.we();
            SpannableStringBuilder vU = bcVar.vU();
            aVar.titleText.setOnTouchListener(new k(vU));
            aVar.titleText.setText(vU);
            aVar.root.setOnClickListener(this.bXw);
            aVar.root.setOnLongClickListener(this.cPh);
            com.baidu.tieba.tbadkCore.util.d readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.ua(bcVar.getId()));
        }
    }

    private void a(a aVar, g gVar) {
        String a2 = a(gVar);
        aVar.titleText.setText(gVar.getTitle());
        aVar.dIt.setText(a2);
        if (gVar.bvs() != 0) {
            aVar.dIu.setVisibility(0);
            if (gVar.bvs() == -1) {
                aVar.dIu.setText(this.mContext.getString(d.k.no_rank));
            } else if (gVar.bvs() > 999) {
                aVar.dIu.setText(this.mContext.getString(d.k.rang_orer_thousand));
            } else {
                aVar.dIu.setText(this.mContext.getString(d.k.rang_identify) + String.valueOf(gVar.bvs()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.titleText.setText(ap.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dIu.setVisibility(8);
        }
        am.h(aVar.dIt, d.C0142d.cp_link_tip_c);
        am.h(aVar.dIu, d.C0142d.cp_link_tip_c);
        am.i(aVar.root, d.f.home_thread_card_item_bg);
        am.j(aVar.divider, d.C0142d.cp_bg_line_c);
        am.h(aVar.titleText, d.C0142d.cp_cont_b);
        aVar.titleText.setTag(gVar);
        if (this.dHq != null) {
            aVar.root.setOnClickListener(this.dHq);
        }
        if (this.dHi != null && this.dHi.add(gVar.bvt())) {
            a.C0236a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bvt(), this.dla.getForumId(), this.dla.getForumName(), null);
            b.cp("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String a(g gVar) {
        if (gVar.bvr() == 1) {
            return TbadkCoreApplication.getInst().getString(d.k.thread_recruit);
        }
        if (TextUtils.isEmpty(gVar.aUt()) || gVar.aUt().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.k.top_announcement);
        }
        return gVar.aUt();
    }

    public void a(HashSet<String> hashSet) {
        this.dHi = hashSet;
    }
}
