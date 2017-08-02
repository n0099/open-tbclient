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
import com.baidu.adp.lib.util.k;
import com.baidu.adp.widget.ListView.h;
import com.baidu.adp.widget.ListView.i;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.u;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.f.c;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.l;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter implements c {
    private com.baidu.tieba.frs.f cjg;
    private h cxj;
    public boolean cza;
    private i czc;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cyZ = false;
    protected HashSet<String> cyr = new HashSet<>();
    protected final View.OnClickListener cyy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((f.this.mContext == null || aw.aN(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.e) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) {
                        eVar = (com.baidu.tieba.tbadkCore.e) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.czh != null && (aVar.czh.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.czh.getTag();
                            }
                        }
                        eVar = null;
                    }
                    if (eVar != null && !StringUtils.isNull(eVar.getUrl())) {
                        String url = eVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            k.showToast(f.this.mContext, d.l.book_plugin_not_install_tip);
                            return;
                        }
                        at.vV().c(f.this.cjg.xY(), new String[]{url});
                        a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqo(), f.this.cjg.getForumId(), f.this.cjg.getForumName(), null);
                        a2.ch("obj_url", eVar.getUrl());
                        a2.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener czb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bl blVar;
            view.setPressed(false);
            if (f.this.cxj != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position);
                if ((fVar instanceof bl) && (blVar = (bl) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sf(blVar.getId());
                        ai.i(aVar.czh, d.e.cp_cont_c);
                    }
                    f.this.cxj.a(view, blVar, BdUniqueId.gen(), null, f.this.cza ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener czd = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.czc == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.czc.b(view, (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.cjg = fVar;
        this.mContext = fVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return u.u(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return u.c(this.mData, i);
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
            view = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
            aVar.czf = view;
            aVar.czg = (TextView) view.findViewById(d.h.top_item_type);
            aVar.czh = (TextView) view.findViewById(d.h.top_item_title);
            aVar.czi = (TextView) view.findViewById(d.h.top_item_rank);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(this.mData, i);
        if (fVar instanceof bl) {
            bl blVar = (bl) fVar;
            if (blVar != null) {
                a(aVar, blVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.f.b.aiM().a(cut, blVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ai.i(aVar.czg, d.e.cp_link_tip_c);
            if (z) {
                ai.i(aVar.czh, d.e.cp_cont_c);
            } else {
                ai.i(aVar.czh, d.e.cp_cont_b);
            }
            ai.j(aVar.czf, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cxj = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void ff(boolean z) {
        this.cyZ = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View czf;
        TextView czg;
        TextView czh;
        TextView czi;
        int position;

        public a() {
        }
    }

    public View Q(bl blVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.czf = inflate;
        aVar.czg = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.czh = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, blVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.czf = inflate;
        aVar.czg = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.czh = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.czi = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bl blVar, int i) {
        if (aVar != null && blVar != null) {
            aVar.czg.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            blVar.sf();
            SpannableStringBuilder rV = blVar.rV();
            aVar.czh.setOnTouchListener(new l(rV));
            aVar.czh.setText(rV);
            aVar.czf.setOnClickListener(this.czb);
            aVar.czf.setOnLongClickListener(this.czd);
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sg(blVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kw = kw(eVar.aGl());
        aVar.czh.setText(eVar.getTitle());
        aVar.czg.setText(kw);
        if (eVar.aPz() != 0) {
            aVar.czi.setVisibility(0);
            if (eVar.aPz() == -1) {
                aVar.czi.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aPz() > 999) {
                aVar.czi.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.czi.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aPz()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.czh.setText(al.d(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.czi.setVisibility(8);
        }
        ai.i(aVar.czg, d.e.cp_link_tip_d);
        ai.i(aVar.czi, d.e.cp_link_tip_d);
        ai.j(aVar.czf, d.g.home_thread_card_item_bg);
        ai.i(aVar.czh, d.e.cp_cont_b);
        aVar.czh.setTag(eVar);
        if (this.cyy != null) {
            aVar.czf.setOnClickListener(this.cyy);
        }
        if (this.cyr != null && this.cyr.add(eVar.bqo())) {
            a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bqo(), this.cjg.getForumId(), this.cjg.getForumName(), null);
            a2.ch("obj_url", eVar.getUrl());
            a2.save();
        }
    }

    public View g(com.baidu.adp.widget.ListView.f fVar) {
        if (fVar instanceof bl) {
            return Q((bl) fVar);
        }
        if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            return a((com.baidu.tieba.tbadkCore.e) fVar);
        }
        return null;
    }

    private String kw(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.frs_forum_member_icon_text);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cyr = hashSet;
    }
}
