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
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.by;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes22.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private ab jDt;
    public boolean jDw;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jDs = null;
    private int jDu = ap.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jDv = new HashSet<>();
    private com.baidu.tieba.frs.d.b jcU = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener jDx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((g.this.mContext == null || bh.checkUpIsLogin(g.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dOp() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bf.bua().b(g.this.mPageContext, new String[]{url});
                            a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dOq(), g.this.mForumId, g.this.mForumName, null);
                            b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dOp() == 3) {
                        new ar("c13442").dY("forum_id", g.this.mForumId).btT();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener feV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.jDt != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof by) {
                    by byVar = (by) qVar;
                    g.this.jDt.a(view, byVar, BdUniqueId.gen(), null, g.this.jDw ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ar("c13124").w("fid", byVar.getFid()).dY("tid", byVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_locate", aVar.position + 1));
                } else if (qVar instanceof p) {
                    g.this.jDt.a(view, (p) qVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.egT = view;
                cVar.aaX = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jDC = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jDD = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.egT = view;
                bVar.jDC = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jDD = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) y.getItem(this.mData, i);
            if (qVar instanceof by) {
                a(bVar, (by) qVar, i);
                bVar.position = i;
            } else if (qVar instanceof k) {
                a(bVar, (k) qVar);
            } else if (qVar instanceof o) {
                a((o) qVar, bVar, i);
            } else if (qVar instanceof p) {
                bVar.position = i;
                a(bVar, (p) qVar, i);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setViewTextColor(aVar.titleText, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.jDC, R.color.CAM_X0101);
        }
    }

    public void d(ab abVar) {
        this.jDt = abVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public List<q> getData() {
        return this.mData;
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.jcU;
    }

    /* loaded from: classes22.dex */
    public class a {
        View egT;
        TextView jDC;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes22.dex */
    public class b extends a {
        TextView jDD;

        public b() {
            super();
        }
    }

    /* loaded from: classes22.dex */
    public class c extends a {
        TbImageView aaX;
        TextView jDD;

        public c() {
            super();
        }
    }

    private void a(b bVar, by byVar, int i) {
        if (bVar != null && byVar != null) {
            bVar.jDC.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDu).bq(bVar.jDC);
            byVar.bpQ();
            SpannableStringBuilder bpz = byVar.bpz();
            if ((bpz == null || au.isEmptyStringAfterTrim(bpz.toString())) && byVar.boq() != null) {
                bpz = new SpannableStringBuilder(byVar.boq());
            }
            bVar.titleText.setOnTouchListener(new i(bpz));
            bVar.titleText.setText(bpz);
            bVar.egT.setOnClickListener(this.feV);
            a(bVar);
        }
    }

    private void a(b bVar, p pVar, int i) {
        if (bVar != null && pVar != null && pVar.dOw() != null && this.mUserData != null) {
            bVar.jDC.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDu).bq(bVar.jDC);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dOw().audit_status.intValue() == 0 && pVar.dOw().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dOw().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dOw().title);
                } else if (pVar.dOw().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dOw().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dOw().title);
            }
            bVar.egT.setOnClickListener(this.feV);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof by) {
                by byVar = (by) qVar;
                byVar.bpQ();
                SpannableStringBuilder bpz = byVar.bpz();
                if ((bpz == null || au.isEmptyStringAfterTrim(bpz.toString())) && byVar.boq() != null) {
                    bpz = new SpannableStringBuilder(byVar.boq());
                }
                cVar.jDC.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bpz));
                cVar.titleText.setText(bpz);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.aaX.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jDC.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.aaX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jDC.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.aaX.startLoad(this.imageUrl, 10, false);
                }
                cVar.jDC.setTextColor(this.jDu);
                cVar.egT.setOnClickListener(this.feV);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jDC.setText(a2);
                    cVar.jDC.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.aaX.setVisibility(8);
                } else {
                    cVar.jDC.setVisibility(8);
                    cVar.aaX.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.aaX.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dOo() != 0) {
                    cVar.jDD.setVisibility(0);
                    if (kVar.dOo() == -1) {
                        cVar.jDD.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dOo() > 999) {
                        cVar.jDD.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jDD.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOo());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jDD.setVisibility(8);
                }
                cVar.jDC.setTextColor(this.jDu);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jDx != null) {
                    cVar.egT.setOnClickListener(this.jDx);
                }
                if (this.jDv != null && this.jDv.add(kVar.dOq())) {
                    a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOq(), this.mForumId, this.mForumName, null);
                    b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jDC.setText(a2);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDu).bq(bVar.jDC);
        if (kVar.dOo() != 0) {
            bVar.jDD.setVisibility(0);
            if (kVar.dOo() == -1) {
                bVar.jDD.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dOo() > 999) {
                bVar.jDD.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jDD.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOo());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jDD.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jDx != null) {
            bVar.egT.setOnClickListener(this.jDx);
        }
        if (this.jDv != null && this.jDv.add(kVar.dOq())) {
            a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOq(), this.mForumId, this.mForumName, null);
            b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bDp() == null) {
            return false;
        }
        ForumData bDp = oVar.bDp();
        boolean z = oVar.dOv() && !y.isEmpty(bDp.getTipInfos());
        String riskTipNotice = z ? bDp.getTipInfos().get(0).tip_notice : bDp.getRiskTipNotice();
        final String riskTipPopTitle = z ? bDp.getTipInfos().get(0).tip_pop_title : bDp.getRiskTipPopTitle();
        final String riskTipPop = z ? bDp.getTipInfos().get(0).tip_pop : bDp.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jDC.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jDC.setTextColor(this.jDu);
        bVar.titleText.setText(riskTipNotice);
        bVar.titleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.titleText.getLayout().getEllipsisCount(bVar.titleText.getLineCount() - 1) > 0) {
                    g.this.fo(riskTipPop, riskTipPopTitle);
                }
            }
        });
        a(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(String str, String str2) {
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.Bp(str2);
            aVar.setTitleShowCenter(true);
            aVar.Bq(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).brv();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dOr()) || kVar.dOr().trim().length() == 0) {
            if (kVar.dOn() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dOr();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void a(String str, String str2, UserData userData) {
        this.mForumId = str;
        this.mForumName = str2;
        this.mUserData = userData;
    }

    public void a(ForumData forumData) {
        this.jDs = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Ck(int i) {
        this.jDu = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
