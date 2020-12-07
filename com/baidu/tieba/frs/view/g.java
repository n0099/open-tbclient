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
    private ab jDr;
    public boolean jDu;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jDq = null;
    private int jDs = ap.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jDt = new HashSet<>();
    private com.baidu.tieba.frs.d.b jcS = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener jDv = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
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
                    if (kVar != null && kVar.dOo() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bf.bua().b(g.this.mPageContext, new String[]{url});
                            a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dOp(), g.this.mForumId, g.this.mForumName, null);
                            b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dOo() == 3) {
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
            if (g.this.jDr != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof by) {
                    by byVar = (by) qVar;
                    g.this.jDr.a(view, byVar, BdUniqueId.gen(), null, g.this.jDu ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ar("c13124").w("fid", byVar.getFid()).dY("tid", byVar.getTid()).dY("uid", TbadkCoreApplication.getCurrentAccount()).al("obj_locate", aVar.position + 1));
                } else if (qVar instanceof p) {
                    g.this.jDr.a(view, (p) qVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.jDA = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jDB = (TextView) view.findViewById(R.id.top_item_rank);
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
                bVar.jDA = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jDB = (TextView) view.findViewById(R.id.top_item_rank);
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
            ap.setViewTextColor(aVar.jDA, R.color.CAM_X0101);
        }
    }

    public void d(ab abVar) {
        this.jDr = abVar;
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
        return this.jcS;
    }

    /* loaded from: classes22.dex */
    public class a {
        View egT;
        TextView jDA;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes22.dex */
    public class b extends a {
        TextView jDB;

        public b() {
            super();
        }
    }

    /* loaded from: classes22.dex */
    public class c extends a {
        TbImageView aaX;
        TextView jDB;

        public c() {
            super();
        }
    }

    private void a(b bVar, by byVar, int i) {
        if (bVar != null && byVar != null) {
            bVar.jDA.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDs).bq(bVar.jDA);
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
        if (bVar != null && pVar != null && pVar.dOv() != null && this.mUserData != null) {
            bVar.jDA.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDs).bq(bVar.jDA);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dOv().audit_status.intValue() == 0 && pVar.dOv().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dOv().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dOv().title);
                } else if (pVar.dOv().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dOv().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dOv().title);
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
                cVar.jDA.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bpz));
                cVar.titleText.setText(bpz);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.aaX.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jDA.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.aaX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jDA.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.aaX.startLoad(this.imageUrl, 10, false);
                }
                cVar.jDA.setTextColor(this.jDs);
                cVar.egT.setOnClickListener(this.feV);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jDA.setText(a2);
                    cVar.jDA.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.aaX.setVisibility(8);
                } else {
                    cVar.jDA.setVisibility(8);
                    cVar.aaX.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.aaX.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dOn() != 0) {
                    cVar.jDB.setVisibility(0);
                    if (kVar.dOn() == -1) {
                        cVar.jDB.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dOn() > 999) {
                        cVar.jDB.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jDB.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOn());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jDB.setVisibility(8);
                }
                cVar.jDA.setTextColor(this.jDs);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jDv != null) {
                    cVar.egT.setOnClickListener(this.jDv);
                }
                if (this.jDt != null && this.jDt.add(kVar.dOp())) {
                    a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOp(), this.mForumId, this.mForumName, null);
                    b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jDA.setText(a2);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qm(l.getDimens(this.mContext, R.dimen.tbds10)).qj(this.jDs).bq(bVar.jDA);
        if (kVar.dOn() != 0) {
            bVar.jDB.setVisibility(0);
            if (kVar.dOn() == -1) {
                bVar.jDB.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dOn() > 999) {
                bVar.jDB.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jDB.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOn());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jDB.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jDv != null) {
            bVar.egT.setOnClickListener(this.jDv);
        }
        if (this.jDt != null && this.jDt.add(kVar.dOp())) {
            a.C0870a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOp(), this.mForumId, this.mForumName, null);
            b2.gw(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bDp() == null) {
            return false;
        }
        ForumData bDp = oVar.bDp();
        boolean z = oVar.dOu() && !y.isEmpty(bDp.getTipInfos());
        String riskTipNotice = z ? bDp.getTipInfos().get(0).tip_notice : bDp.getRiskTipNotice();
        final String riskTipPopTitle = z ? bDp.getTipInfos().get(0).tip_pop_title : bDp.getRiskTipPopTitle();
        final String riskTipPop = z ? bDp.getTipInfos().get(0).tip_pop : bDp.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jDA.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jDA.setTextColor(this.jDs);
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
        if (TextUtils.isEmpty(kVar.dOq()) || kVar.dOq().trim().length() == 0) {
            if (kVar.dOm() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dOq();
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
        this.jDq = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Ck(int i) {
        this.jDs = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
