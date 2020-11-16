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
import com.baidu.tbadk.core.data.bx;
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
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes21.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private ab jpR;
    public boolean jpU;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jpQ = null;
    private int jpS = ap.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jpT = new HashSet<>();
    private com.baidu.tieba.frs.d.b iRY = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener jpV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
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
                    if (kVar != null && kVar.dIY() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bf.bqF().b(g.this.mPageContext, new String[]{url});
                            a.C0855a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dIZ(), g.this.mForumId, g.this.mForumName, null);
                            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dIY() == 3) {
                        new ar("c13442").dR("forum_id", g.this.mForumId).bqy();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener eXy = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.jpR != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bx) {
                    bx bxVar = (bx) qVar;
                    g.this.jpR.a(view, bxVar, BdUniqueId.gen(), null, g.this.jpU ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ar("c13124").w("fid", bxVar.getFid()).dR("tid", bxVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ak("obj_locate", aVar.position + 1));
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
                cVar.dZT = view;
                cVar.aab = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jqa = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jqb = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dZT = view;
                bVar.jqa = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jqb = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) y.getItem(this.mData, i);
            if (qVar instanceof bx) {
                a(bVar, (bx) qVar, i);
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
            ap.setViewTextColor(aVar.titleText, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.jqa, R.color.CAM_X0101);
        }
    }

    public void d(ab abVar) {
        this.jpR = abVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.iRY;
    }

    /* loaded from: classes21.dex */
    public class a {
        View dZT;
        TextView jqa;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes21.dex */
    public class b extends a {
        TextView jqb;

        public b() {
            super();
        }
    }

    /* loaded from: classes21.dex */
    public class c extends a {
        TbImageView aab;
        TextView jqb;

        public c() {
            super();
        }
    }

    private void a(b bVar, bx bxVar, int i) {
        if (bVar != null && bxVar != null) {
            bVar.jqa.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.e.a.brc().pF(0).pM(l.getDimens(this.mContext, R.dimen.tbds10)).pJ(this.jpS).bn(bVar.jqa);
            bxVar.bmD();
            SpannableStringBuilder bmm = bxVar.bmm();
            if ((bmm == null || au.isEmptyStringAfterTrim(bmm.toString())) && bxVar.bld() != null) {
                bmm = new SpannableStringBuilder(bxVar.bld());
            }
            bVar.titleText.setOnTouchListener(new i(bmm));
            bVar.titleText.setText(bmm);
            bVar.dZT.setOnClickListener(this.eXy);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bx) {
                bx bxVar = (bx) qVar;
                bxVar.bmD();
                SpannableStringBuilder bmm = bxVar.bmm();
                if ((bmm == null || au.isEmptyStringAfterTrim(bmm.toString())) && bxVar.bld() != null) {
                    bmm = new SpannableStringBuilder(bxVar.bld());
                }
                cVar.jqa.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bmm));
                cVar.titleText.setText(bmm);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.aab.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jqa.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.aab.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jqa.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.aab.startLoad(this.imageUrl, 10, false);
                }
                cVar.jqa.setTextColor(this.jpS);
                cVar.dZT.setOnClickListener(this.eXy);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jqa.setText(a2);
                    cVar.jqa.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.aab.setVisibility(8);
                } else {
                    cVar.jqa.setVisibility(8);
                    cVar.aab.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.aab.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dIX() != 0) {
                    cVar.jqb.setVisibility(0);
                    if (kVar.dIX() == -1) {
                        cVar.jqb.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dIX() > 999) {
                        cVar.jqb.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jqb.setText(this.mContext.getString(R.string.rang_identify) + kVar.dIX());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jqb.setVisibility(8);
                }
                cVar.jqa.setTextColor(this.jpS);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jpV != null) {
                    cVar.dZT.setOnClickListener(this.jpV);
                }
                if (this.jpT != null && this.jpT.add(kVar.dIZ())) {
                    a.C0855a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dIZ(), this.mForumId, this.mForumName, null);
                    b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jqa.setText(a2);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).pM(l.getDimens(this.mContext, R.dimen.tbds10)).pJ(this.jpS).bn(bVar.jqa);
        if (kVar.dIX() != 0) {
            bVar.jqb.setVisibility(0);
            if (kVar.dIX() == -1) {
                bVar.jqb.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dIX() > 999) {
                bVar.jqb.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jqb.setText(this.mContext.getString(R.string.rang_identify) + kVar.dIX());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jqb.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jpV != null) {
            bVar.dZT.setOnClickListener(this.jpV);
        }
        if (this.jpT != null && this.jpT.add(kVar.dIZ())) {
            a.C0855a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dIZ(), this.mForumId, this.mForumName, null);
            b2.gr(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bzP() == null) {
            return false;
        }
        ForumData bzP = oVar.bzP();
        boolean z = oVar.dJe() && !y.isEmpty(bzP.getTipInfos());
        String riskTipNotice = z ? bzP.getTipInfos().get(0).tip_notice : bzP.getRiskTipNotice();
        final String riskTipPopTitle = z ? bzP.getTipInfos().get(0).tip_pop_title : bzP.getRiskTipPopTitle();
        final String riskTipPop = z ? bzP.getTipInfos().get(0).tip_pop : bzP.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jqa.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jqa.setTextColor(this.jpS);
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
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.AI(str2);
            aVar.setTitleShowCenter(true);
            aVar.AJ(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bog();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dJa()) || kVar.dJa().trim().length() == 0) {
            if (kVar.dIW() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dJa();
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
        this.jpQ = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Bv(int i) {
        this.jpS = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
