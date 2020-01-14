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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bj;
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
import com.baidu.tieba.view.h;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes7.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private s gPg;
    public boolean gPi;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int gPh = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> gNX = new HashSet<>();
    private com.baidu.tieba.frs.d.b gun = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener gPj = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            if ((e.this.mContext == null || bc.checkUpIsLogin(e.this.mContext)) && view != null) {
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
                    if (jVar != null && jVar.cIE() == 2) {
                        if (!StringUtils.isNull(jVar.getUrl())) {
                            String url = jVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aEt().b(e.this.mPageContext, new String[]{url});
                            a.C0604a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", jVar.cIF(), e.this.mForumId, e.this.mForumName, null);
                            b2.ev(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                            b2.save();
                        }
                    } else if (jVar != null && jVar.cIE() == 3) {
                        new an("c13442").cp("forum_id", e.this.mForumId).aEm();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fcW = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.gPg != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.getItem(e.this.mData, aVar.position);
                if (mVar instanceof bj) {
                    bj bjVar = (bj) mVar;
                    e.this.gPg.a(view, bjVar, BdUniqueId.gen(), null, e.this.gPi ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").s("fid", bjVar.getFid()).cp("tid", bjVar.getTid()).cp("uid", TbadkCoreApplication.getCurrentAccount()).Z("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private TbPageContext mPageContext = getTbPageContext();

    public e(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return v.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.mData, i);
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
                cVar.cqd = view;
                cVar.Ei = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.gPl = (TextView) view.findViewById(R.id.top_item_type);
                cVar.gPm = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.cqd = view;
                bVar.gPl = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.gPm = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.cRQ = view.findViewById(R.id.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.getItem(this.mData, i);
            if (mVar instanceof bj) {
                a(bVar, (bj) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof j) {
                a(bVar, (j) mVar);
            }
            if (i > 0) {
                bVar.cRQ.setVisibility(0);
            } else {
                bVar.cRQ.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.cqd, R.color.cp_bg_line_h);
            if ((aVar instanceof b) && ((b) aVar).cRQ != null) {
                ((b) aVar).cRQ.setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void d(s sVar) {
        this.gPg = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bFt() {
        return this.gun;
    }

    /* loaded from: classes7.dex */
    public class a {
        View cqd;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes7.dex */
    public class b extends a {
        View cRQ;
        TextView gPl;
        TextView gPm;

        public b() {
            super();
        }
    }

    /* loaded from: classes7.dex */
    public class c extends a {
        TbImageView Ei;
        TextView gPl;
        TextView gPm;

        public c() {
            super();
        }
    }

    private void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bjVar != null) {
            bVar.gPl.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.gPl.setTextColor(this.gPh);
            bjVar.aAU();
            SpannableStringBuilder aAE = bjVar.aAE();
            if ((aAE == null || aq.isEmptyStringAfterTrim(aAE.toString())) && bjVar.azy() != null) {
                aAE = new SpannableStringBuilder(bjVar.azy());
            }
            bVar.titleText.setOnTouchListener(new h(aAE));
            bVar.titleText.setText(aAE);
            bVar.cqd.setOnClickListener(this.fcW);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                bjVar.aAU();
                SpannableStringBuilder aAE = bjVar.aAE();
                if ((aAE == null || aq.isEmptyStringAfterTrim(aAE.toString())) && bjVar.azy() != null) {
                    aAE = new SpannableStringBuilder(bjVar.azy());
                }
                cVar.gPl.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new h(aAE));
                cVar.titleText.setText(aAE);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.Ei.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.gPl.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.Ei.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.gPl.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.Ei.startLoad(this.imageUrl, 10, false);
                }
                cVar.gPl.setTextColor(this.gPh);
                cVar.cqd.setOnClickListener(this.fcW);
                a(cVar);
            } else if (mVar instanceof j) {
                j jVar = (j) mVar;
                String a2 = a(jVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.gPl.setText(a2);
                    cVar.gPl.setVisibility(0);
                    cVar.titleText.setText(jVar.getTitle());
                    cVar.Ei.setVisibility(8);
                } else {
                    cVar.gPl.setVisibility(8);
                    cVar.Ei.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + jVar.getTitle());
                    cVar.Ei.startLoad(this.imageUrl, 10, false);
                }
                if (jVar.cID() != 0) {
                    cVar.gPm.setVisibility(0);
                    if (jVar.cID() == -1) {
                        cVar.gPm.setText(this.mContext.getString(R.string.no_rank));
                    } else if (jVar.cID() > 999) {
                        cVar.gPm.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.gPm.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cID()));
                    }
                    if (!StringUtils.isNull(jVar.getTitle())) {
                        cVar.titleText.setText(jVar.getTitle());
                    }
                } else {
                    cVar.gPm.setVisibility(8);
                }
                cVar.gPl.setTextColor(this.gPh);
                a(cVar);
                cVar.titleText.setTag(jVar);
                if (this.gPj != null) {
                    cVar.cqd.setOnClickListener(this.gPj);
                }
                if (this.gNX != null && this.gNX.add(jVar.cIF())) {
                    a.C0604a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cIF(), this.mForumId, this.mForumName, null);
                    b2.ev(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, j jVar) {
        String a2 = a(jVar);
        bVar.titleText.setText(jVar.getTitle());
        bVar.gPl.setText(a2);
        bVar.gPl.setTextColor(this.gPh);
        if (jVar.cID() != 0) {
            bVar.gPm.setVisibility(0);
            if (jVar.cID() == -1) {
                bVar.gPm.setText(this.mContext.getString(R.string.no_rank));
            } else if (jVar.cID() > 999) {
                bVar.gPm.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.gPm.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cID()));
            }
            if (!StringUtils.isNull(jVar.getTitle())) {
                bVar.titleText.setText(jVar.getTitle());
            }
        } else {
            bVar.gPm.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(jVar);
        if (this.gPj != null) {
            bVar.cqd.setOnClickListener(this.gPj);
        }
        if (this.gNX != null && this.gNX.add(jVar.cIF())) {
            a.C0604a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cIF(), this.mForumId, this.mForumName, null);
            b2.ev(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
            b2.save();
        }
    }

    private String a(j jVar) {
        if (TextUtils.isEmpty(jVar.cIG()) || jVar.cIG().trim().length() == 0) {
            if (jVar.cIC() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return jVar.cIG();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void dn(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void uC(int i) {
        this.gPh = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
