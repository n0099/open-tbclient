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
import com.baidu.live.tbadk.core.util.TiebaInitialize;
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
    private s fYc;
    public boolean fYf;
    private t fYh;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private boolean fYd = false;
    private int fYe = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> fXd = new HashSet<>();
    private com.baidu.tieba.frs.d.b fDZ = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener fYg = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
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
                    if (jVar != null && jVar.cnu() == 2) {
                        if (!StringUtils.isNull(jVar.getUrl())) {
                            String url = jVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.amQ().b(e.this.mPageContext, new String[]{url});
                            a.C0520a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", jVar.cnv(), e.this.mForumId, e.this.mForumName, null);
                            b2.ea(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                            b2.save();
                        }
                    } else if (jVar != null && jVar.cnu() == 3) {
                        new an("c13442").bS("forum_id", e.this.mForumId).amK();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.g.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener ekL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.fYc != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.getItem(e.this.mData, aVar.position);
                if (mVar instanceof bh) {
                    bh bhVar = (bh) mVar;
                    e.this.fYc.a(view, bhVar, BdUniqueId.gen(), null, e.this.fYf ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").p("fid", bhVar.getFid()).bS("tid", bhVar.getTid()).bS("uid", TbadkCoreApplication.getCurrentAccount()).O("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private View.OnLongClickListener fah = new View.OnLongClickListener() { // from class: com.baidu.tieba.frs.view.e.3
        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view) {
            if (e.this.fYh == null || !(view.getTag() instanceof a)) {
                return false;
            }
            a aVar = (a) view.getTag();
            return e.this.fYh.b(view, (m) v.getItem(e.this.mData, aVar.position), BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.bGb = view;
                cVar.BX = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.fYj = (TextView) view.findViewById(R.id.top_item_type);
                cVar.fYk = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.bGb = view;
                bVar.fYj = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.fYk = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.cfY = view.findViewById(R.id.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.getItem(this.mData, i);
            if (mVar instanceof bh) {
                a(bVar, (bh) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof j) {
                a(bVar, (j) mVar);
            }
            if (i > 0) {
                bVar.cfY.setVisibility(0);
            } else {
                bVar.cfY.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.bGb, R.color.cp_bg_line_h);
            if ((aVar instanceof b) && ((b) aVar).cfY != null) {
                ((b) aVar).cfY.setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void d(s sVar) {
        this.fYc = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bmX() {
        return this.fDZ;
    }

    /* loaded from: classes4.dex */
    public class a {
        View bGb;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes4.dex */
    public class b extends a {
        View cfY;
        TextView fYj;
        TextView fYk;

        public b() {
            super();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends a {
        TbImageView BX;
        TextView fYj;
        TextView fYk;

        public c() {
            super();
        }
    }

    private void a(b bVar, bh bhVar, int i) {
        if (bVar != null && bhVar != null) {
            bVar.fYj.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.fYj.setTextColor(this.fYe);
            bhVar.ajx();
            SpannableStringBuilder ajm = bhVar.ajm();
            if ((ajm == null || aq.isEmptyStringAfterTrim(ajm.toString())) && bhVar.aii() != null) {
                ajm = new SpannableStringBuilder(bhVar.aii());
            }
            bVar.titleText.setOnTouchListener(new k(ajm));
            bVar.titleText.setText(ajm);
            bVar.bGb.setOnClickListener(this.ekL);
            bVar.bGb.setOnLongClickListener(this.fah);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bh) {
                bh bhVar = (bh) mVar;
                bhVar.ajx();
                SpannableStringBuilder ajm = bhVar.ajm();
                if ((ajm == null || aq.isEmptyStringAfterTrim(ajm.toString())) && bhVar.aii() != null) {
                    ajm = new SpannableStringBuilder(bhVar.aii());
                }
                cVar.fYj.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new k(ajm));
                cVar.titleText.setText(ajm);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.BX.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.fYj.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.BX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.fYj.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.BX.startLoad(this.imageUrl, 10, false);
                }
                cVar.fYj.setTextColor(this.fYe);
                cVar.bGb.setOnClickListener(this.ekL);
                cVar.bGb.setOnLongClickListener(this.fah);
                a(cVar);
            } else if (mVar instanceof j) {
                j jVar = (j) mVar;
                String a2 = a(jVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.fYj.setText(a2);
                    cVar.fYj.setVisibility(0);
                    cVar.titleText.setText(jVar.getTitle());
                    cVar.BX.setVisibility(8);
                } else {
                    cVar.fYj.setVisibility(8);
                    cVar.BX.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + jVar.getTitle());
                    cVar.BX.startLoad(this.imageUrl, 10, false);
                }
                if (jVar.cnt() != 0) {
                    cVar.fYk.setVisibility(0);
                    if (jVar.cnt() == -1) {
                        cVar.fYk.setText(this.mContext.getString(R.string.no_rank));
                    } else if (jVar.cnt() > 999) {
                        cVar.fYk.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.fYk.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cnt()));
                    }
                    if (!StringUtils.isNull(jVar.getTitle())) {
                        cVar.titleText.setText(jVar.getTitle());
                    }
                } else {
                    cVar.fYk.setVisibility(8);
                }
                cVar.fYj.setTextColor(this.fYe);
                a(cVar);
                cVar.titleText.setTag(jVar);
                if (this.fYg != null) {
                    cVar.bGb.setOnClickListener(this.fYg);
                }
                if (this.fXd != null && this.fXd.add(jVar.cnv())) {
                    a.C0520a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cnv(), this.mForumId, this.mForumName, null);
                    b2.ea(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, j jVar) {
        String a2 = a(jVar);
        bVar.titleText.setText(jVar.getTitle());
        bVar.fYj.setText(a2);
        bVar.fYj.setTextColor(this.fYe);
        if (jVar.cnt() != 0) {
            bVar.fYk.setVisibility(0);
            if (jVar.cnt() == -1) {
                bVar.fYk.setText(this.mContext.getString(R.string.no_rank));
            } else if (jVar.cnt() > 999) {
                bVar.fYk.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.fYk.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cnt()));
            }
            if (!StringUtils.isNull(jVar.getTitle())) {
                bVar.titleText.setText(jVar.getTitle());
            }
        } else {
            bVar.fYk.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(jVar);
        if (this.fYg != null) {
            bVar.bGb.setOnClickListener(this.fYg);
        }
        if (this.fXd != null && this.fXd.add(jVar.cnv())) {
            a.C0520a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cnv(), this.mForumId, this.mForumName, null);
            b2.ea(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
            b2.save();
        }
    }

    private String a(j jVar) {
        if (TextUtils.isEmpty(jVar.cnw()) || jVar.cnw().trim().length() == 0) {
            if (jVar.cns() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return jVar.cnw();
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

    public void sq(int i) {
        this.fYe = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
