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
    public boolean cAu;
    private i cAx;
    private com.baidu.tieba.frs.f ckn;
    private h cyB;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.f> mData;
    private boolean cAt = false;
    protected HashSet<String> czP = new HashSet<>();
    protected final View.OnClickListener cAv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.1
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
                            if (aVar.cAC != null && (aVar.cAC.getTag() instanceof com.baidu.tieba.tbadkCore.e)) {
                                eVar = (com.baidu.tieba.tbadkCore.e) aVar.cAC.getTag();
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
                        at.wf().c(f.this.ckn.yg(), new String[]{url});
                        a.C0120a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", eVar.bqv(), f.this.ckn.getForumId(), f.this.ckn.getForumName(), null);
                        a2.ch("obj_url", eVar.getUrl());
                        a2.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener cAw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            bl blVar;
            view.setPressed(false);
            if (f.this.cyB != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.f fVar = (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position);
                if ((fVar instanceof bl) && (blVar = (bl) fVar) != null) {
                    com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.sk(blVar.getId());
                        ai.i(aVar.cAC, d.e.cp_cont_c);
                    }
                    f.this.cyB.a(view, blVar, BdUniqueId.gen(), null, f.this.cAu ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener cAy = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.f.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (f.this.cAx == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return f.this.cAx.b(view, (com.baidu.adp.widget.ListView.f) u.c(f.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public f(com.baidu.tieba.frs.f fVar) {
        this.ckn = fVar;
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
            aVar.cAA = view;
            aVar.cAB = (TextView) view.findViewById(d.h.top_item_type);
            aVar.cAC = (TextView) view.findViewById(d.h.top_item_title);
            aVar.cAD = (TextView) view.findViewById(d.h.top_item_rank);
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
            com.baidu.tieba.frs.e.b.aiY().a(cvL, blVar);
        } else if (fVar instanceof com.baidu.tieba.tbadkCore.e) {
            a(aVar, (com.baidu.tieba.tbadkCore.e) fVar);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            ai.i(aVar.cAB, d.e.cp_link_tip_c);
            if (z) {
                ai.i(aVar.cAC, d.e.cp_cont_c);
            } else {
                ai.i(aVar.cAC, d.e.cp_cont_b);
            }
            ai.j(aVar.cAA, d.g.home_thread_card_item_bg);
        }
    }

    public void b(h hVar) {
        this.cyB = hVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.f> list) {
        this.mData = list;
    }

    public void ff(boolean z) {
        this.cAt = z;
    }

    /* loaded from: classes.dex */
    public class a {
        View cAA;
        TextView cAB;
        TextView cAC;
        TextView cAD;
        int position;

        public a() {
        }
    }

    public View Q(bl blVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cAA = inflate;
        aVar.cAB = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cAC = (TextView) inflate.findViewById(d.h.top_item_title);
        a(aVar, blVar, 0);
        inflate.setTag(aVar);
        return inflate;
    }

    public View a(com.baidu.tieba.tbadkCore.e eVar) {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.frs_header_top_item, (ViewGroup) null);
        aVar.cAA = inflate;
        aVar.cAB = (TextView) inflate.findViewById(d.h.top_item_type);
        aVar.cAC = (TextView) inflate.findViewById(d.h.top_item_title);
        aVar.cAD = (TextView) inflate.findViewById(d.h.top_item_rank);
        a(aVar, eVar);
        inflate.setTag(eVar);
        return inflate;
    }

    private void a(a aVar, bl blVar, int i) {
        if (aVar != null && blVar != null) {
            aVar.cAB.setText(TbadkCoreApplication.getInst().getString(d.l.top));
            blVar.sp();
            SpannableStringBuilder sf = blVar.sf();
            aVar.cAC.setOnTouchListener(new l(sf));
            aVar.cAC.setText(sf);
            aVar.cAA.setOnClickListener(this.cAw);
            aVar.cAA.setOnLongClickListener(this.cAy);
            com.baidu.tieba.tbadkCore.util.f readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.sl(blVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.e eVar) {
        String kA = kA(eVar.aGw());
        aVar.cAC.setText(eVar.getTitle());
        aVar.cAB.setText(kA);
        if (eVar.aPK() != 0) {
            aVar.cAD.setVisibility(0);
            if (eVar.aPK() == -1) {
                aVar.cAD.setText(this.mContext.getString(d.l.no_rank));
            } else if (eVar.aPK() > 999) {
                aVar.cAD.setText(this.mContext.getString(d.l.rang_orer_thousand));
            } else {
                aVar.cAD.setText(this.mContext.getString(d.l.rang_identify) + String.valueOf(eVar.aPK()));
            }
            if (!StringUtils.isNull(eVar.getTitle())) {
                aVar.cAC.setText(al.d(eVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.cAD.setVisibility(8);
        }
        ai.i(aVar.cAB, d.e.cp_link_tip_d);
        ai.i(aVar.cAD, d.e.cp_link_tip_d);
        ai.j(aVar.cAA, d.g.home_thread_card_item_bg);
        ai.i(aVar.cAC, d.e.cp_cont_b);
        aVar.cAC.setTag(eVar);
        if (this.cAv != null) {
            aVar.cAA.setOnClickListener(this.cAv);
        }
        if (this.czP != null && this.czP.add(eVar.bqv())) {
            a.C0120a a2 = com.baidu.tieba.tbadkCore.d.a.a("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", eVar.bqv(), this.ckn.getForumId(), this.ckn.getForumName(), null);
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

    private String kA(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.l.frs_forum_member_icon_text);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.czP = hashSet;
    }
}
