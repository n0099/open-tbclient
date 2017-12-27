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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.p;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.i;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.view.m;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.c {
    private o dQo;
    public boolean dQq;
    private p dQr;
    private i dxW;
    private Context mContext;
    private List<com.baidu.adp.widget.ListView.i> mData;
    private boolean dQp = false;
    protected HashSet<String> dPF = new HashSet<>();
    protected final View.OnClickListener dPN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            com.baidu.tieba.tbadkCore.g gVar;
            if ((g.this.mContext == null || ax.be(g.this.mContext)) && view != null) {
                if ((view.getTag() instanceof com.baidu.tieba.tbadkCore.g) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof com.baidu.tieba.tbadkCore.g) {
                        gVar = (com.baidu.tieba.tbadkCore.g) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.dQw != null && (aVar.dQw.getTag() instanceof com.baidu.tieba.tbadkCore.g)) {
                                gVar = (com.baidu.tieba.tbadkCore.g) aVar.dQw.getTag();
                            }
                        }
                        gVar = null;
                    }
                    if (gVar != null && !StringUtils.isNull(gVar.getUrl())) {
                        String url = gVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(g.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        av.Di().c(g.this.dxW.aiX(), new String[]{url});
                        a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", gVar.bzZ(), g.this.dxW.getForumId(), g.this.dxW.getForumName(), null);
                        b.ch("obj_url", gVar.getUrl());
                        b.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener crS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            be beVar;
            view.setPressed(false);
            if (g.this.dQo != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position);
                if ((iVar instanceof be) && (beVar = (be) iVar) != null) {
                    com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
                    if (readThreadHistory != null) {
                        readThreadHistory.tm(beVar.getId());
                        aj.r(aVar.dQw, d.C0108d.cp_cont_c);
                    }
                    g.this.dQo.a(view, beVar, BdUniqueId.gen(), null, g.this.dQq ? aVar.position + 1 : aVar.position, 0L);
                }
            }
        }
    };
    private View.OnLongClickListener dQs = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.g.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (g.this.dQr == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return g.this.dQr.b(view, (com.baidu.adp.widget.ListView.i) v.f(g.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };

    public g(i iVar) {
        this.dxW = iVar;
        this.mContext = iVar.getPageContext().getPageActivity();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.F(this.mData);
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.f(this.mData, i);
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
            aVar.dQu = view;
            aVar.dQv = (TextView) view.findViewById(d.g.top_item_type);
            aVar.dQw = (TextView) view.findViewById(d.g.top_item_title);
            aVar.dQx = (TextView) view.findViewById(d.g.top_item_rank);
            aVar.divider = view.findViewById(d.g.top_item_divider);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        com.baidu.adp.widget.ListView.i iVar = (com.baidu.adp.widget.ListView.i) v.f(this.mData, i);
        if (iVar instanceof be) {
            be beVar = (be) iVar;
            if (beVar != null) {
                a(aVar, beVar, i);
            }
            aVar.position = i;
            com.baidu.tieba.frs.d.b.axH().a(dMh, beVar);
        } else if (iVar instanceof com.baidu.tieba.tbadkCore.g) {
            a(aVar, (com.baidu.tieba.tbadkCore.g) iVar);
        }
        if (v.f(this.mData, i + 1) == null) {
            aVar.divider.setVisibility(8);
        } else {
            aVar.divider.setVisibility(0);
        }
        return view;
    }

    private void a(a aVar, boolean z) {
        if (aVar != null) {
            aj.r(aVar.dQv, d.C0108d.cp_link_tip_c);
            if (z) {
                aj.r(aVar.dQw, d.C0108d.cp_cont_j);
            } else {
                aj.r(aVar.dQw, d.C0108d.cp_cont_b);
            }
            aj.s(aVar.dQu, d.f.home_thread_card_item_bg);
            if (aVar.divider != null) {
                aVar.divider.setBackgroundColor(aj.getColor(d.C0108d.cp_bg_line_c));
            }
        }
    }

    public void c(o oVar) {
        this.dQo = oVar;
    }

    public void setData(List<com.baidu.adp.widget.ListView.i> list) {
        this.mData = list;
    }

    /* loaded from: classes2.dex */
    public class a {
        View dQu;
        TextView dQv;
        TextView dQw;
        TextView dQx;
        View divider;
        int position;

        public a() {
        }
    }

    private void a(a aVar, be beVar, int i) {
        if (aVar != null && beVar != null) {
            aVar.dQv.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            beVar.zH();
            SpannableStringBuilder zx = beVar.zx();
            aVar.dQw.setOnTouchListener(new m(zx));
            aVar.dQw.setText(zx);
            aVar.dQu.setOnClickListener(this.crS);
            aVar.dQu.setOnLongClickListener(this.dQs);
            com.baidu.tieba.tbadkCore.util.e readThreadHistory = TbadkCoreApplication.getInst().getReadThreadHistory();
            a(aVar, readThreadHistory != null && readThreadHistory.tn(beVar.getId()));
        }
    }

    private void a(a aVar, com.baidu.tieba.tbadkCore.g gVar) {
        String lS = lS(gVar.aSa());
        aVar.dQw.setText(gVar.getTitle());
        aVar.dQv.setText(lS);
        if (gVar.aZf() != 0) {
            aVar.dQx.setVisibility(0);
            if (gVar.aZf() == -1) {
                aVar.dQx.setText(this.mContext.getString(d.j.no_rank));
            } else if (gVar.aZf() > 999) {
                aVar.dQx.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                aVar.dQx.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(gVar.aZf()));
            }
            if (!StringUtils.isNull(gVar.getTitle())) {
                aVar.dQw.setText(am.e(gVar.getTitle(), 22, "..."));
            }
        } else {
            aVar.dQx.setVisibility(8);
        }
        aj.r(aVar.dQv, d.C0108d.cp_link_tip_c);
        aj.r(aVar.dQx, d.C0108d.cp_link_tip_c);
        aj.s(aVar.dQu, d.f.home_thread_card_item_bg);
        aj.t(aVar.divider, d.C0108d.cp_bg_line_c);
        aj.r(aVar.dQw, d.C0108d.cp_cont_b);
        aVar.dQw.setTag(gVar);
        if (this.dPN != null) {
            aVar.dQu.setOnClickListener(this.dPN);
        }
        if (this.dPF != null && this.dPF.add(gVar.bzZ())) {
            a.C0155a b = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", gVar.bzZ(), this.dxW.getForumId(), this.dxW.getForumName(), null);
            b.ch("obj_url", gVar.getUrl());
            b.save();
        }
    }

    private String lS(String str) {
        if (TextUtils.isEmpty(str) || str.trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return str;
    }

    public void a(HashSet<String> hashSet) {
        this.dPF = hashSet;
    }
}
