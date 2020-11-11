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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private ab jpl;
    public boolean jpn;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jpk = null;
    private int jpm = ap.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> jnm = new HashSet<>();
    private com.baidu.tieba.frs.d.b iRl = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener jpo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((g.this.mContext == null || bg.checkUpIsLogin(g.this.mContext)) && view != null) {
                if ((view.getTag() instanceof k) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof k) {
                        kVar = (k) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.titleText != null && (aVar.titleText.getTag() instanceof k)) {
                                kVar = (k) aVar.titleText.getTag();
                            }
                        }
                        kVar = null;
                    }
                    if (kVar != null && kVar.dJh() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            be.brr().b(g.this.mPageContext, new String[]{url});
                            a.C0853a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dJi(), g.this.mForumId, g.this.mForumName, null);
                            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dJh() == 3) {
                        new aq("c13442").dR("forum_id", g.this.mForumId).brk();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener eYr = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.jpl != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bw) {
                    bw bwVar = (bw) qVar;
                    g.this.jpl.a(view, bwVar, BdUniqueId.gen(), null, g.this.jpn ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new aq("c13124").w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private TbPageContext mPageContext = getTbPageContext();

    public g(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return y.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return y.getItem(this.mData, i);
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
                cVar.ebB = view;
                cVar.ZW = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jpt = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jpu = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.ebB = view;
                bVar.jpt = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jpu = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) y.getItem(this.mData, i);
            if (qVar instanceof bw) {
                a(bVar, (bw) qVar, i);
                bVar.position = i;
            } else if (qVar instanceof k) {
                a(bVar, (k) qVar);
            } else if (qVar instanceof o) {
                a((o) qVar, bVar, i);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setViewTextColor(aVar.titleText, R.color.cp_cont_b);
            ap.setBackgroundColor(aVar.ebB, R.color.cp_bg_line_d);
        }
    }

    public void d(ab abVar) {
        this.jpl = abVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRl;
    }

    /* loaded from: classes22.dex */
    public class a {
        View ebB;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes22.dex */
    public class b extends a {
        TextView jpt;
        TextView jpu;

        public b() {
            super();
        }
    }

    /* loaded from: classes22.dex */
    public class c extends a {
        TbImageView ZW;
        TextView jpt;
        TextView jpu;

        public c() {
            super();
        }
    }

    private void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bwVar != null) {
            bVar.jpt.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.jpt.setTextColor(this.jpm);
            bwVar.bnz();
            SpannableStringBuilder bnk = bwVar.bnk();
            if ((bnk == null || at.isEmptyStringAfterTrim(bnk.toString())) && bwVar.bmb() != null) {
                bnk = new SpannableStringBuilder(bwVar.bmb());
            }
            bVar.titleText.setOnTouchListener(new i(bnk));
            bVar.titleText.setText(bnk);
            bVar.ebB.setOnClickListener(this.eYr);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                bwVar.bnz();
                SpannableStringBuilder bnk = bwVar.bnk();
                if ((bnk == null || at.isEmptyStringAfterTrim(bnk.toString())) && bwVar.bmb() != null) {
                    bnk = new SpannableStringBuilder(bwVar.bmb());
                }
                cVar.jpt.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bnk));
                cVar.titleText.setText(bnk);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.ZW.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jpt.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.ZW.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jpt.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.ZW.startLoad(this.imageUrl, 10, false);
                }
                cVar.jpt.setTextColor(this.jpm);
                cVar.ebB.setOnClickListener(this.eYr);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jpt.setText(a2);
                    cVar.jpt.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.ZW.setVisibility(8);
                } else {
                    cVar.jpt.setVisibility(8);
                    cVar.ZW.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.ZW.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dJg() != 0) {
                    cVar.jpu.setVisibility(0);
                    if (kVar.dJg() == -1) {
                        cVar.jpu.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dJg() > 999) {
                        cVar.jpu.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jpu.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dJg()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jpu.setVisibility(8);
                }
                cVar.jpt.setTextColor(this.jpm);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jpo != null) {
                    cVar.ebB.setOnClickListener(this.jpo);
                }
                if (this.jnm != null && this.jnm.add(kVar.dJi())) {
                    a.C0853a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dJi(), this.mForumId, this.mForumName, null);
                    b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jpt.setText(a2);
        bVar.jpt.setTextColor(this.jpm);
        if (kVar.dJg() != 0) {
            bVar.jpu.setVisibility(0);
            if (kVar.dJg() == -1) {
                bVar.jpu.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dJg() > 999) {
                bVar.jpu.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jpu.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dJg()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jpu.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jpo != null) {
            bVar.ebB.setOnClickListener(this.jpo);
        }
        if (this.jnm != null && this.jnm.add(kVar.dJi())) {
            a.C0853a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dJi(), this.mForumId, this.mForumName, null);
            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bAz() == null) {
            return false;
        }
        ForumData bAz = oVar.bAz();
        boolean z = oVar.dJn() && !y.isEmpty(bAz.getTipInfos());
        String riskTipNotice = z ? bAz.getTipInfos().get(0).tip_notice : bAz.getRiskTipNotice();
        final String riskTipPopTitle = z ? bAz.getTipInfos().get(0).tip_pop_title : bAz.getRiskTipPopTitle();
        final String riskTipPop = z ? bAz.getTipInfos().get(0).tip_pop : bAz.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jpt.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jpt.setTextColor(this.jpm);
        bVar.titleText.setText(riskTipNotice);
        bVar.titleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.titleText.getLayout().getEllipsisCount(bVar.titleText.getLineCount() - 1) > 0) {
                    g.this.fi(riskTipPop, riskTipPopTitle);
                }
            }
        });
        a(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fi(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.Bn(str2);
            aVar.setTitleShowCenter(true);
            aVar.Bo(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bpc();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dJj()) || kVar.dJj().trim().length() == 0) {
            if (kVar.dJf() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dJj();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void fj(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void a(ForumData forumData) {
        this.jpk = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void AX(int i) {
        this.jpm = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
