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
    private ab jjn;
    public boolean jjp;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jjm = null;
    private int jjo = ap.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> jhn = new HashSet<>();
    private com.baidu.tieba.frs.d.b iLo = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener jjq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
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
                    if (kVar != null && kVar.dGF() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            be.boR().b(g.this.mPageContext, new String[]{url});
                            a.C0838a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dGG(), g.this.mForumId, g.this.mForumName, null);
                            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dGF() == 3) {
                        new aq("c13442").dR("forum_id", g.this.mForumId).boK();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener eSC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.jjn != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bw) {
                    bw bwVar = (bw) qVar;
                    g.this.jjn.a(view, bwVar, BdUniqueId.gen(), null, g.this.jjp ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new aq("c13124").w("fid", bwVar.getFid()).dR("tid", bwVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aj("obj_locate", aVar.position + 1));
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
                cVar.dVJ = view;
                cVar.ZW = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jjv = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jjw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dVJ = view;
                bVar.jjv = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jjw = (TextView) view.findViewById(R.id.top_item_rank);
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
            ap.setBackgroundColor(aVar.dVJ, R.color.cp_bg_line_d);
        }
    }

    public void d(ab abVar) {
        this.jjn = abVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iLo;
    }

    /* loaded from: classes22.dex */
    public class a {
        View dVJ;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes22.dex */
    public class b extends a {
        TextView jjv;
        TextView jjw;

        public b() {
            super();
        }
    }

    /* loaded from: classes22.dex */
    public class c extends a {
        TbImageView ZW;
        TextView jjv;
        TextView jjw;

        public c() {
            super();
        }
    }

    private void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bwVar != null) {
            bVar.jjv.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.jjv.setTextColor(this.jjo);
            bwVar.bkZ();
            SpannableStringBuilder bkK = bwVar.bkK();
            if ((bkK == null || at.isEmptyStringAfterTrim(bkK.toString())) && bwVar.bjB() != null) {
                bkK = new SpannableStringBuilder(bwVar.bjB());
            }
            bVar.titleText.setOnTouchListener(new i(bkK));
            bVar.titleText.setText(bkK);
            bVar.dVJ.setOnClickListener(this.eSC);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                bwVar.bkZ();
                SpannableStringBuilder bkK = bwVar.bkK();
                if ((bkK == null || at.isEmptyStringAfterTrim(bkK.toString())) && bwVar.bjB() != null) {
                    bkK = new SpannableStringBuilder(bwVar.bjB());
                }
                cVar.jjv.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bkK));
                cVar.titleText.setText(bkK);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.ZW.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jjv.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.ZW.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jjv.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.ZW.startLoad(this.imageUrl, 10, false);
                }
                cVar.jjv.setTextColor(this.jjo);
                cVar.dVJ.setOnClickListener(this.eSC);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jjv.setText(a2);
                    cVar.jjv.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.ZW.setVisibility(8);
                } else {
                    cVar.jjv.setVisibility(8);
                    cVar.ZW.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.ZW.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dGE() != 0) {
                    cVar.jjw.setVisibility(0);
                    if (kVar.dGE() == -1) {
                        cVar.jjw.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dGE() > 999) {
                        cVar.jjw.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jjw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dGE()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jjw.setVisibility(8);
                }
                cVar.jjv.setTextColor(this.jjo);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jjq != null) {
                    cVar.dVJ.setOnClickListener(this.jjq);
                }
                if (this.jhn != null && this.jhn.add(kVar.dGG())) {
                    a.C0838a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dGG(), this.mForumId, this.mForumName, null);
                    b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jjv.setText(a2);
        bVar.jjv.setTextColor(this.jjo);
        if (kVar.dGE() != 0) {
            bVar.jjw.setVisibility(0);
            if (kVar.dGE() == -1) {
                bVar.jjw.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dGE() > 999) {
                bVar.jjw.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jjw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dGE()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jjw.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jjq != null) {
            bVar.dVJ.setOnClickListener(this.jjq);
        }
        if (this.jhn != null && this.jhn.add(kVar.dGG())) {
            a.C0838a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dGG(), this.mForumId, this.mForumName, null);
            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bya() == null) {
            return false;
        }
        ForumData bya = oVar.bya();
        boolean z = oVar.dGL() && !y.isEmpty(bya.getTipInfos());
        String riskTipNotice = z ? bya.getTipInfos().get(0).tip_notice : bya.getRiskTipNotice();
        final String riskTipPopTitle = z ? bya.getTipInfos().get(0).tip_pop_title : bya.getRiskTipPopTitle();
        final String riskTipPop = z ? bya.getTipInfos().get(0).tip_pop : bya.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jjv.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jjv.setTextColor(this.jjo);
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
            aVar.AZ(str2);
            aVar.setTitleShowCenter(true);
            aVar.Ba(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bmC();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dGH()) || kVar.dGH().trim().length() == 0) {
            if (kVar.dGD() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dGH();
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
        this.jjm = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void AK(int i) {
        this.jjo = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
