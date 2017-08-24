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
import com.baidu.tieba.frs.e.c;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.l;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes.dex */
public class f extends BaseAdapter implements c {
    private h cAB;
    public boolean cCs;
    private i cCu;
    private com.baidu.tieba.frs.f cla;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cCr = false;
    protected HashSet<String> cBJ = new HashSet<>();
    protected final View.OnClickListener cBQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.e eVar;
            if ((f.this.mContext == null || aw.aO(f.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.e) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.e) {
                        eVar = (com.baidu.tieba.tbadkCore.e) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.cCz != null && (aVar.cCz.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cCz.getTag();
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
                        at.wg().c(f.this.cla.yg(), new String[]{url});
                        a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqW(), f.this.cla.getForumId(), f.this.cla.getForumName(), null);
                        a2.ck("obj_url", eVar.getUrl());
                        a2.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cCt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bl blVar;
            view.setPressed(false);
            if (f.this.cAB != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position);
                if ((fVar instanceof bl) && (blVar = (bl) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sr(blVar.getId());
                        ai.i(aVar.cCz, d.e.cp_cont_c);
                    }
                    f.this.cAB.a(view, blVar, BdUniqueId.gen(), null, f.this.cCs ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cCv = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cCu == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cCu.b(view, (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.cla = fVar;
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
            aVar.cCx = view;
            aVar.cCy = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cCz = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cCA = (TextView) view.findViewById(d.h.top_item_rank);
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
            com.baidu.tieba.frs.e.b.ajz().a(cxO, blVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ai.i(aVar.cCy, d.e.cp_link_tip_c);
            if (z) {
                ai.i(aVar.cCz, d.e.cp_cont_c);
            } else {
                ai.i(aVar.cCz, d.e.cp_cont_b);
            }
            ai.j(aVar.cCx, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cAB = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void fi(boolean z) {
        this.cCr = z;
    }

    /* loaded from: classes.dex */
    public class a {
        TextView cCA;
        View cCx;
        TextView cCy;
        TextView cCz;
        int position;

        public a() {
        }
    }

    public View Q(bl blVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cCx = inflate;
        aVar.cCy = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cCz = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, blVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cCx = inflate;
        aVar.cCy = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cCz = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cCA = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bl blVar, int i) {
        if (aVar != null && blVar != null) {
            aVar.cCy.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            blVar.sq();
            SpannableStringBuilder sg = blVar.sg();
            aVar.cCz.setOnTouchListener(new l(sg));
            aVar.cCz.setText(sg);
            aVar.cCx.setOnClickListener(this.cCt);
            aVar.cCx.setOnLongClickListener(this.cCv);
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.ss(blVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kH = kH(eVar.aGY());
        aVar.cCz.setText(eVar.getTitle());
        aVar.cCy.setText(kH);
        if (eVar.aQm() != 0) {
            aVar.cCA.setVisibility(0);
            if (eVar.aQm() == -1) {
                aVar.cCA.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aQm() > 999) {
                aVar.cCA.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cCA.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aQm()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cCz.setText(al.e(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cCA.setVisibility(8);
        }
        ai.i(aVar.cCy, d.e.cp_link_tip_d);
        ai.i(aVar.cCA, d.e.cp_link_tip_d);
        ai.j(aVar.cCx, d.g.home_thread_card_item_bg);
        ai.i(aVar.cCz, d.e.cp_cont_b);
        aVar.cCz.setTag(eVar);
        if (this.cBQ != null) {
            aVar.cCx.setOnClickListener(this.cBQ);
        }
        if (this.cBJ != null && this.cBJ.add(eVar.bqW())) {
            a.C0121a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bqW(), this.cla.getForumId(), this.cla.getForumName(), null);
            a2.ck("obj_url", eVar.getUrl());
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

    private String kH(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.frs_forum_member_icon_text);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.cBJ = hashSet;
    }
}
