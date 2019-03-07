package com.baidu.tieba.frs.view;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.d.d;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements d {
    private s fAq;
    public boolean fAt;
    private t fAv;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private boolean fAr = false;
    private int fAs = al.getColor(d.C0236d.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> fzu = new HashSet<>();
    private com.baidu.tieba.frs.d.b fhf = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener fAu = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            if ((e.this.mContext == null || bc.cZ(e.this.mContext)) && view != null) {
                if ((view.getTag() instanceof h) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof h) {
                        hVar = (h) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.titleText != null && (aVar.titleText.getTag() instanceof h)) {
                                hVar = (h) aVar.titleText.getTag();
                            }
                        }
                        hVar = null;
                    }
                    if (hVar != null && !StringUtils.isNull(hVar.getUrl())) {
                        String url = hVar.getUrl();
                        if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                            l.showToast(e.this.mContext, d.j.book_plugin_not_install_tip);
                            return;
                        }
                        ba.adD().c(e.this.mPageContext, new String[]{url});
                        a.C0309a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.cdw(), e.this.mForumId, e.this.mForumName, null);
                        b2.dY("obj_url", hVar.getUrl());
                        b2.save();
                    }
                }
            }
        }
    };
    private View.OnClickListener dHs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.fAq != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.c(e.this.mData, aVar.position);
                if (mVar instanceof bg) {
                    bg bgVar = (bg) mVar;
                    e.this.fAq.a(view, bgVar, BdUniqueId.gen(), null, e.this.fAt ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new am("c13124").k(ImageViewerConfig.FORUM_ID, bgVar.getFid()).bJ("tid", bgVar.getTid()).bJ("uid", TbadkCoreApplication.getCurrentAccount()).T("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener eBu = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.e.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (e.this.fAv == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return e.this.fAv.b(view, (m) v.c(e.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };
    private TbPageContext mPageContext = getTbPageContext();

    public e(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.S(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mData.size();
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        c cVar;
        if (getItemViewType(i) == 1) {
            if (view == null || !(view.getTag() instanceof c)) {
                cVar = new c();
                view = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item_single, (ViewGroup) null, false);
                cVar.dcP = view;
                cVar.Uy = (TbImageView) view.findViewById(d.g.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(d.g.frs_header_top_item_title);
                cVar.fAx = (TextView) view.findViewById(d.g.top_item_type);
                cVar.fAy = (TextView) view.findViewById(d.g.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.c(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(d.h.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dcP = view;
                bVar.fAx = (TextView) view.findViewById(d.g.top_item_type);
                bVar.titleText = (TextView) view.findViewById(d.g.top_item_title);
                bVar.fAy = (TextView) view.findViewById(d.g.top_item_rank);
                bVar.divider = view.findViewById(d.g.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.c(this.mData, i);
            if (mVar instanceof bg) {
                a(bVar, (bg) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof h) {
                a(bVar, (h) mVar);
            }
            if (i > 0) {
                bVar.divider.setVisibility(0);
            } else {
                bVar.divider.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            al.j(aVar.titleText, d.C0236d.cp_cont_b);
            al.k(aVar.dcP, d.f.home_thread_card_item_bg);
            if ((aVar instanceof b) && ((b) aVar).divider != null) {
                ((b) aVar).divider.setBackgroundColor(al.getColor(d.C0236d.cp_bg_line_c));
            }
        }
    }

    public void c(s sVar) {
        this.fAq = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bfz() {
        return this.fhf;
    }

    /* loaded from: classes4.dex */
    public class a {
        View dcP;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a {
        View divider;
        TextView fAx;
        TextView fAy;

        public b() {
            super();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {
        TbImageView Uy;
        TextView fAx;
        TextView fAy;

        public c() {
            super();
        }
    }

    private void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bgVar != null) {
            bVar.fAx.setText(TbadkCoreApplication.getInst().getString(d.j.top));
            bVar.fAx.setTextColor(this.fAs);
            bgVar.ZI();
            SpannableStringBuilder Zx = bgVar.Zx();
            if ((Zx == null || ap.bw(Zx.toString())) && bgVar.Yt() != null) {
                Zx = new SpannableStringBuilder(bgVar.Yt());
            }
            bVar.titleText.setOnTouchListener(new k(Zx));
            bVar.titleText.setText(Zx);
            bVar.dcP.setOnClickListener(this.dHs);
            bVar.dcP.setOnLongClickListener(this.eBu);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bg) {
                bg bgVar = (bg) mVar;
                bgVar.ZI();
                SpannableStringBuilder Zx = bgVar.Zx();
                if ((Zx == null || ap.bw(Zx.toString())) && bgVar.Yt() != null) {
                    Zx = new SpannableStringBuilder(bgVar.Yt());
                }
                cVar.fAx.setText(TbadkCoreApplication.getInst().getString(d.j.top));
                cVar.titleText.setOnTouchListener(new k(Zx));
                cVar.titleText.setText(Zx);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.Uy.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.fAx.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(d.e.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.Uy.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fAx.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(d.e.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.Uy.startLoad(this.imageUrl, 10, false);
                }
                cVar.fAx.setTextColor(this.fAs);
                cVar.dcP.setOnClickListener(this.dHs);
                cVar.dcP.setOnLongClickListener(this.eBu);
                a(cVar);
            } else if (mVar instanceof h) {
                h hVar = (h) mVar;
                String a2 = a(hVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.fAx.setText(a2);
                    cVar.fAx.setVisibility(0);
                    cVar.titleText.setText(hVar.getTitle());
                    cVar.Uy.setVisibility(8);
                } else {
                    cVar.fAx.setVisibility(8);
                    cVar.Uy.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + hVar.getTitle());
                    cVar.Uy.startLoad(this.imageUrl, 10, false);
                }
                hVar.zj(6);
                if (hVar.cdv() != 0) {
                    cVar.fAy.setVisibility(0);
                    if (hVar.cdv() == -1) {
                        cVar.fAy.setText(this.mContext.getString(d.j.no_rank));
                    } else if (hVar.cdv() > 999) {
                        cVar.fAy.setText(this.mContext.getString(d.j.rang_orer_thousand));
                    } else {
                        cVar.fAy.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(hVar.cdv()));
                    }
                    if (!StringUtils.isNull(hVar.getTitle())) {
                        cVar.titleText.setText(ap.g(hVar.getTitle(), 22, "..."));
                    }
                } else {
                    cVar.fAy.setVisibility(8);
                }
                cVar.fAx.setTextColor(this.fAs);
                a(cVar);
                cVar.titleText.setTag(hVar);
                if (this.fAu != null) {
                    cVar.dcP.setOnClickListener(this.fAu);
                }
                if (this.fzu != null && this.fzu.add(hVar.cdw())) {
                    a.C0309a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.cdw(), this.mForumId, this.mForumName, null);
                    b2.dY("obj_url", hVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, h hVar) {
        String a2 = a(hVar);
        bVar.titleText.setText(hVar.getTitle());
        bVar.fAx.setText(a2);
        bVar.fAx.setTextColor(this.fAs);
        if (hVar.cdv() != 0) {
            bVar.fAy.setVisibility(0);
            if (hVar.cdv() == -1) {
                bVar.fAy.setText(this.mContext.getString(d.j.no_rank));
            } else if (hVar.cdv() > 999) {
                bVar.fAy.setText(this.mContext.getString(d.j.rang_orer_thousand));
            } else {
                bVar.fAy.setText(this.mContext.getString(d.j.rang_identify) + String.valueOf(hVar.cdv()));
            }
            if (!StringUtils.isNull(hVar.getTitle())) {
                bVar.titleText.setText(ap.g(hVar.getTitle(), 22, "..."));
            }
        } else {
            bVar.fAy.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(hVar);
        if (this.fAu != null) {
            bVar.dcP.setOnClickListener(this.fAu);
        }
        if (this.fzu != null && this.fzu.add(hVar.cdw())) {
            a.C0309a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.cdw(), this.mForumId, this.mForumName, null);
            b2.dY("obj_url", hVar.getUrl());
            b2.save();
        }
    }

    private String a(h hVar) {
        if (hVar.cdu() == 1) {
            return TbadkCoreApplication.getInst().getString(d.j.thread_recruit);
        }
        if (TextUtils.isEmpty(hVar.cdx()) || hVar.cdx().trim().length() == 0) {
            return TbadkCoreApplication.getInst().getString(d.j.top_announcement);
        }
        return hVar.cdx();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void setForum(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void rU(int i) {
        this.fAs = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
