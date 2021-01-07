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
import com.baidu.adp.widget.ListView.n;
import com.baidu.adp.widget.ListView.w;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.tbadkCore.p;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes2.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.b.d {
    private w jPV;
    public boolean jPY;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<n> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jPU = null;
    private int jPW = ao.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jPX = new HashSet<>();
    private com.baidu.tieba.frs.b.b jpq = new com.baidu.tieba.frs.b.b();
    protected final View.OnClickListener jPZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((e.this.mContext == null || bg.checkUpIsLogin(e.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dOi() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            be.bwv().b(e.this.mPageContext, new String[]{url});
                            a.C0886a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dOj(), e.this.mForumId, e.this.mForumName, null);
                            b2.gt(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dOi() == 3) {
                        new aq("c13442").dX("forum_id", e.this.mForumId).bwo();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener foD = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.jPV != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                n nVar = (n) x.getItem(e.this.mData, aVar.position);
                if (nVar instanceof bz) {
                    bz bzVar = (bz) nVar;
                    e.this.jPV.a(view, bzVar, BdUniqueId.gen(), null, e.this.jPY ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new aq("c13124").w("fid", bzVar.getFid()).dX("tid", bzVar.getTid()).dX("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_locate", aVar.position + 1));
                } else if (nVar instanceof p) {
                    e.this.jPV.a(view, (p) nVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
        return x.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return x.getItem(this.mData, i);
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
                cVar.epV = view;
                cVar.abI = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jQe = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jQf = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (n) x.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.epV = view;
                bVar.jQe = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jQf = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            n nVar = (n) x.getItem(this.mData, i);
            if (nVar instanceof bz) {
                a(bVar, (bz) nVar, i);
                bVar.position = i;
            } else if (nVar instanceof k) {
                a(bVar, (k) nVar);
            } else if (nVar instanceof o) {
                a((o) nVar, bVar, i);
            } else if (nVar instanceof p) {
                bVar.position = i;
                a(bVar, (p) nVar, i);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ao.setViewTextColor(aVar.titleText, R.color.CAM_X0105);
            ao.setViewTextColor(aVar.jQe, R.color.CAM_X0101);
        }
    }

    public void d(w wVar) {
        this.jPV = wVar;
    }

    public void setData(List<n> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    public List<n> getData() {
        return this.mData;
    }

    @Override // com.baidu.tieba.frs.b.d
    public com.baidu.tieba.frs.b.b getStatisticMetaData() {
        return this.jpq;
    }

    /* loaded from: classes2.dex */
    public class a {
        View epV;
        TextView jQe;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a {
        TextView jQf;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a {
        TbImageView abI;
        TextView jQf;

        public c() {
            super();
        }
    }

    private void a(b bVar, bz bzVar, int i) {
        if (bVar != null && bzVar != null) {
            bVar.jQe.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qx(l.getDimens(this.mContext, R.dimen.tbds10)).qu(this.jPW).bz(bVar.jQe);
            bzVar.bss();
            SpannableStringBuilder bsa = bzVar.bsa();
            if ((bsa == null || at.isEmptyStringAfterTrim(bsa.toString())) && bzVar.bqS() != null) {
                bsa = new SpannableStringBuilder(bzVar.bqS());
            }
            bVar.titleText.setOnTouchListener(new i(bsa));
            bVar.titleText.setText(bsa);
            bVar.epV.setOnClickListener(this.foD);
            a(bVar);
        }
    }

    private void a(b bVar, p pVar, int i) {
        if (bVar != null && pVar != null && pVar.dOp() != null && this.mUserData != null) {
            bVar.jQe.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.f.a.bwV().qq(0).qx(l.getDimens(this.mContext, R.dimen.tbds10)).qu(this.jPW).bz(bVar.jQe);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dOp().audit_status.intValue() == 0 && pVar.dOp().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dOp().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dOp().title);
                } else if (pVar.dOp().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dOp().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dOp().title);
            }
            bVar.epV.setOnClickListener(this.foD);
            a(bVar);
        }
    }

    private void a(c cVar, n nVar) {
        if (cVar != null && nVar != null) {
            if (nVar instanceof bz) {
                bz bzVar = (bz) nVar;
                bzVar.bss();
                SpannableStringBuilder bsa = bzVar.bsa();
                if ((bsa == null || at.isEmptyStringAfterTrim(bsa.toString())) && bzVar.bqS() != null) {
                    bsa = new SpannableStringBuilder(bzVar.bqS());
                }
                cVar.jQe.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bsa));
                cVar.titleText.setText(bsa);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.abI.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jQe.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.abI.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jQe.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.abI.startLoad(this.imageUrl, 10, false);
                }
                cVar.jQe.setTextColor(this.jPW);
                cVar.epV.setOnClickListener(this.foD);
                a(cVar);
            } else if (nVar instanceof k) {
                k kVar = (k) nVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jQe.setText(a2);
                    cVar.jQe.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.abI.setVisibility(8);
                } else {
                    cVar.jQe.setVisibility(8);
                    cVar.abI.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.abI.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dOh() != 0) {
                    cVar.jQf.setVisibility(0);
                    if (kVar.dOh() == -1) {
                        cVar.jQf.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dOh() > 999) {
                        cVar.jQf.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jQf.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOh());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jQf.setVisibility(8);
                }
                cVar.jQe.setTextColor(this.jPW);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jPZ != null) {
                    cVar.epV.setOnClickListener(this.jPZ);
                }
                if (this.jPX != null && this.jPX.add(kVar.dOj())) {
                    a.C0886a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOj(), this.mForumId, this.mForumName, null);
                    b2.gt(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jQe.setText(a2);
        com.baidu.tbadk.core.util.f.a.bwV().qq(0).qx(l.getDimens(this.mContext, R.dimen.tbds10)).qu(this.jPW).bz(bVar.jQe);
        if (kVar.dOh() != 0) {
            bVar.jQf.setVisibility(0);
            if (kVar.dOh() == -1) {
                bVar.jQf.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dOh() > 999) {
                bVar.jQf.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jQf.setText(this.mContext.getString(R.string.rang_identify) + kVar.dOh());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jQf.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jPZ != null) {
            bVar.epV.setOnClickListener(this.jPZ);
        }
        if (this.jPX != null && this.jPX.add(kVar.dOj())) {
            a.C0886a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dOj(), this.mForumId, this.mForumName, null);
            b2.gt(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bFL() == null) {
            return false;
        }
        ForumData bFL = oVar.bFL();
        boolean z = oVar.dOo() && !x.isEmpty(bFL.getTipInfos());
        String riskTipNotice = z ? bFL.getTipInfos().get(0).tip_notice : bFL.getRiskTipNotice();
        final String riskTipPopTitle = z ? bFL.getTipInfos().get(0).tip_pop_title : bFL.getRiskTipPopTitle();
        final String riskTipPop = z ? bFL.getTipInfos().get(0).tip_pop : bFL.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jQe.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jQe.setTextColor(this.jPW);
        bVar.titleText.setText(riskTipNotice);
        bVar.titleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.titleText.getLayout().getEllipsisCount(bVar.titleText.getLineCount() - 1) > 0) {
                    e.this.fp(riskTipPop, riskTipPopTitle);
                }
            }
        });
        a(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fp(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.Bn(str2);
            aVar.setTitleShowCenter(true);
            aVar.Bo(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.e.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).btY();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dOk()) || kVar.dOk().trim().length() == 0) {
            if (kVar.dOg() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dOk();
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
        this.jPU = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Cw(int i) {
        this.jPW = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
