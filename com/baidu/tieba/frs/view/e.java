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
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.s;
import com.baidu.adp.widget.ListView.t;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.h;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private s fRa;
    public boolean fRd;
    private t fRf;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private boolean fRb = false;
    private int fRc = al.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> fQb = new HashSet<>();
    private com.baidu.tieba.frs.d.b fxk = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener fRe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h hVar;
            if ((e.this.mContext == null || bc.cE(e.this.mContext)) && view != null) {
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
                    if (hVar != null && hVar.clz() == 2) {
                        if (!StringUtils.isNull(hVar.getUrl())) {
                            String url = hVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aiz().c(e.this.mPageContext, new String[]{url});
                            a.C0409a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", hVar.clA(), e.this.mForumId, e.this.mForumName, null);
                            b2.em("obj_url", hVar.getUrl());
                            b2.save();
                        }
                    } else if (hVar != null && hVar.clz() == 3) {
                        new am("c13442").bT("forum_id", e.this.mForumId).aif();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.c(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener dRe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.fRa != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.c(e.this.mData, aVar.position);
                if (mVar instanceof bg) {
                    bg bgVar = (bg) mVar;
                    e.this.fRa.a(view, bgVar, BdUniqueId.gen(), null, e.this.fRd ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new am("c13124").l("fid", bgVar.getFid()).bT("tid", bgVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener eQH = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.e.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (e.this.fRf == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return e.this.fRf.b(view, (m) v.c(e.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
        }
    };
    private TbPageContext mPageContext = getTbPageContext();

    public e(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.Z(this.mData);
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
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_single, (ViewGroup) null, false);
                cVar.bmd = view;
                cVar.Sm = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.fRh = (TextView) view.findViewById(R.id.top_item_type);
                cVar.fRi = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.c(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.bmd = view;
                bVar.fRh = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.fRi = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.divider = view.findViewById(R.id.top_item_divider);
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
            al.j(aVar.titleText, R.color.cp_cont_b);
            al.k(aVar.bmd, R.drawable.home_thread_card_item_bg);
            if ((aVar instanceof b) && ((b) aVar).divider != null) {
                ((b) aVar).divider.setBackgroundColor(al.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void c(s sVar) {
        this.fRa = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmQ() {
        return this.fxk;
    }

    /* loaded from: classes4.dex */
    public class a {
        View bmd;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a {
        View divider;
        TextView fRh;
        TextView fRi;

        public b() {
            super();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {
        TbImageView Sm;
        TextView fRh;
        TextView fRi;

        public c() {
            super();
        }
    }

    private void a(b bVar, bg bgVar, int i) {
        if (bVar != null && bgVar != null) {
            bVar.fRh.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.fRh.setTextColor(this.fRc);
            bgVar.aem();
            SpannableStringBuilder aeb = bgVar.aeb();
            if ((aeb == null || ap.bg(aeb.toString())) && bgVar.acX() != null) {
                aeb = new SpannableStringBuilder(bgVar.acX());
            }
            bVar.titleText.setOnTouchListener(new k(aeb));
            bVar.titleText.setText(aeb);
            bVar.bmd.setOnClickListener(this.dRe);
            bVar.bmd.setOnLongClickListener(this.eQH);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bg) {
                bg bgVar = (bg) mVar;
                bgVar.aem();
                SpannableStringBuilder aeb = bgVar.aeb();
                if ((aeb == null || ap.bg(aeb.toString())) && bgVar.acX() != null) {
                    aeb = new SpannableStringBuilder(bgVar.acX());
                }
                cVar.fRh.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new k(aeb));
                cVar.titleText.setText(aeb);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.Sm.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.fRh.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.Sm.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fRh.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.Sm.startLoad(this.imageUrl, 10, false);
                }
                cVar.fRh.setTextColor(this.fRc);
                cVar.bmd.setOnClickListener(this.dRe);
                cVar.bmd.setOnLongClickListener(this.eQH);
                a(cVar);
            } else if (mVar instanceof h) {
                h hVar = (h) mVar;
                String a2 = a(hVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.fRh.setText(a2);
                    cVar.fRh.setVisibility(0);
                    cVar.titleText.setText(hVar.getTitle());
                    cVar.Sm.setVisibility(8);
                } else {
                    cVar.fRh.setVisibility(8);
                    cVar.Sm.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + hVar.getTitle());
                    cVar.Sm.startLoad(this.imageUrl, 10, false);
                }
                if (hVar.cly() != 0) {
                    cVar.fRi.setVisibility(0);
                    if (hVar.cly() == -1) {
                        cVar.fRi.setText(this.mContext.getString(R.string.no_rank));
                    } else if (hVar.cly() > 999) {
                        cVar.fRi.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.fRi.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(hVar.cly()));
                    }
                    if (!StringUtils.isNull(hVar.getTitle())) {
                        cVar.titleText.setText(hVar.getTitle());
                    }
                } else {
                    cVar.fRi.setVisibility(8);
                }
                cVar.fRh.setTextColor(this.fRc);
                a(cVar);
                cVar.titleText.setTag(hVar);
                if (this.fRe != null) {
                    cVar.bmd.setOnClickListener(this.fRe);
                }
                if (this.fQb != null && this.fQb.add(hVar.clA())) {
                    a.C0409a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.clA(), this.mForumId, this.mForumName, null);
                    b2.em("obj_url", hVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, h hVar) {
        String a2 = a(hVar);
        bVar.titleText.setText(hVar.getTitle());
        bVar.fRh.setText(a2);
        bVar.fRh.setTextColor(this.fRc);
        if (hVar.cly() != 0) {
            bVar.fRi.setVisibility(0);
            if (hVar.cly() == -1) {
                bVar.fRi.setText(this.mContext.getString(R.string.no_rank));
            } else if (hVar.cly() > 999) {
                bVar.fRi.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.fRi.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(hVar.cly()));
            }
            if (!StringUtils.isNull(hVar.getTitle())) {
                bVar.titleText.setText(hVar.getTitle());
            }
        } else {
            bVar.fRi.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(hVar);
        if (this.fRe != null) {
            bVar.bmd.setOnClickListener(this.fRe);
        }
        if (this.fQb != null && this.fQb.add(hVar.clA())) {
            a.C0409a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", hVar.clA(), this.mForumId, this.mForumName, null);
            b2.em("obj_url", hVar.getUrl());
            b2.save();
        }
    }

    private String a(h hVar) {
        if (TextUtils.isEmpty(hVar.clB()) || hVar.clB().trim().length() == 0) {
            if (hVar.clx() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return hVar.clB();
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

    public void sY(int i) {
        this.fRc = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
