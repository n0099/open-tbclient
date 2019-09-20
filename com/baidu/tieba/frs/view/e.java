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
import com.baidu.tbadk.core.data.bh;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.view.k;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes4.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private s fYH;
    public boolean fYK;
    private t fYM;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private boolean fYI = false;
    private int fYJ = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> fXI = new HashSet<>();
    private com.baidu.tieba.frs.d.b fEI = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener fYL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            if ((e.this.mContext == null || bc.cF(e.this.mContext)) && view != null) {
                if ((view.getTag() instanceof j) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof j) {
                        jVar = (j) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.titleText != null && (aVar.titleText.getTag() instanceof j)) {
                                jVar = (j) aVar.titleText.getTag();
                            }
                        }
                        jVar = null;
                    }
                    if (jVar != null && jVar.cpD() == 2) {
                        if (!StringUtils.isNull(jVar.getUrl())) {
                            String url = jVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.ajK().c(e.this.mPageContext, new String[]{url});
                            a.C0425a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", jVar.cpE(), e.this.mForumId, e.this.mForumName, null);
                            b2.eo("obj_url", jVar.getUrl());
                            b2.save();
                        }
                    } else if (jVar != null && jVar.cpD() == 3) {
                        new an("c13442").bT("forum_id", e.this.mForumId).ajq();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.e(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener dWL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.fYH != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.c(e.this.mData, aVar.position);
                if (mVar instanceof bh) {
                    bh bhVar = (bh) mVar;
                    e.this.fYH.a(view, bhVar, BdUniqueId.gen(), null, e.this.fYK ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").n("fid", bhVar.getFid()).bT("tid", bhVar.getTid()).bT("uid", TbadkCoreApplication.getCurrentAccount()).P("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener eXv = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.e.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (e.this.fYM == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return e.this.fYM.b(view, (m) v.c(e.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.bnp = view;
                cVar.SC = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.fYO = (TextView) view.findViewById(R.id.top_item_type);
                cVar.fYP = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.c(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.bnp = view;
                bVar.fYO = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.fYP = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.divider = view.findViewById(R.id.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.c(this.mData, i);
            if (mVar instanceof bh) {
                a(bVar, (bh) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof j) {
                a(bVar, (j) mVar);
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
            am.j(aVar.titleText, R.color.cp_cont_b);
            am.l(aVar.bnp, R.color.cp_bg_line_h);
            if ((aVar instanceof b) && ((b) aVar).divider != null) {
                ((b) aVar).divider.setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void c(s sVar) {
        this.fYH = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bpS() {
        return this.fEI;
    }

    /* loaded from: classes4.dex */
    public class a {
        View bnp;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a {
        View divider;
        TextView fYO;
        TextView fYP;

        public b() {
            super();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {
        TbImageView SC;
        TextView fYO;
        TextView fYP;

        public c() {
            super();
        }
    }

    private void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bhVar != null) {
            bVar.fYO.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.fYO.setTextColor(this.fYJ);
            bhVar.aft();
            SpannableStringBuilder afi = bhVar.afi();
            if ((afi == null || aq.bh(afi.toString())) && bhVar.aee() != null) {
                afi = new SpannableStringBuilder(bhVar.aee());
            }
            bVar.titleText.setOnTouchListener(new k(afi));
            bVar.titleText.setText(afi);
            bVar.bnp.setOnClickListener(this.dWL);
            bVar.bnp.setOnLongClickListener(this.eXv);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bh) {
                bh bhVar = (bh) mVar;
                bhVar.aft();
                SpannableStringBuilder afi = bhVar.afi();
                if ((afi == null || aq.bh(afi.toString())) && bhVar.aee() != null) {
                    afi = new SpannableStringBuilder(bhVar.aee());
                }
                cVar.fYO.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new k(afi));
                cVar.titleText.setText(afi);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.SC.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.fYO.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.SC.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fYO.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.SC.startLoad(this.imageUrl, 10, false);
                }
                cVar.fYO.setTextColor(this.fYJ);
                cVar.bnp.setOnClickListener(this.dWL);
                cVar.bnp.setOnLongClickListener(this.eXv);
                a(cVar);
            } else if (mVar instanceof j) {
                j jVar = (j) mVar;
                String a2 = a(jVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.fYO.setText(a2);
                    cVar.fYO.setVisibility(0);
                    cVar.titleText.setText(jVar.getTitle());
                    cVar.SC.setVisibility(8);
                } else {
                    cVar.fYO.setVisibility(8);
                    cVar.SC.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + jVar.getTitle());
                    cVar.SC.startLoad(this.imageUrl, 10, false);
                }
                if (jVar.cpC() != 0) {
                    cVar.fYP.setVisibility(0);
                    if (jVar.cpC() == -1) {
                        cVar.fYP.setText(this.mContext.getString(R.string.no_rank));
                    } else if (jVar.cpC() > 999) {
                        cVar.fYP.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.fYP.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cpC()));
                    }
                    if (!StringUtils.isNull(jVar.getTitle())) {
                        cVar.titleText.setText(jVar.getTitle());
                    }
                } else {
                    cVar.fYP.setVisibility(8);
                }
                cVar.fYO.setTextColor(this.fYJ);
                a(cVar);
                cVar.titleText.setTag(jVar);
                if (this.fYL != null) {
                    cVar.bnp.setOnClickListener(this.fYL);
                }
                if (this.fXI != null && this.fXI.add(jVar.cpE())) {
                    a.C0425a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cpE(), this.mForumId, this.mForumName, null);
                    b2.eo("obj_url", jVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, j jVar) {
        String a2 = a(jVar);
        bVar.titleText.setText(jVar.getTitle());
        bVar.fYO.setText(a2);
        bVar.fYO.setTextColor(this.fYJ);
        if (jVar.cpC() != 0) {
            bVar.fYP.setVisibility(0);
            if (jVar.cpC() == -1) {
                bVar.fYP.setText(this.mContext.getString(R.string.no_rank));
            } else if (jVar.cpC() > 999) {
                bVar.fYP.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.fYP.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cpC()));
            }
            if (!StringUtils.isNull(jVar.getTitle())) {
                bVar.titleText.setText(jVar.getTitle());
            }
        } else {
            bVar.fYP.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(jVar);
        if (this.fYL != null) {
            bVar.bnp.setOnClickListener(this.fYL);
        }
        if (this.fXI != null && this.fXI.add(jVar.cpE())) {
            a.C0425a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cpE(), this.mForumId, this.mForumName, null);
            b2.eo("obj_url", jVar.getUrl());
            b2.save();
        }
    }

    private String a(j jVar) {
        if (TextUtils.isEmpty(jVar.cpF()) || jVar.cpF().trim().length() == 0) {
            if (jVar.cpB() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return jVar.cpF();
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

    public void tw(int i) {
        this.fYJ = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
