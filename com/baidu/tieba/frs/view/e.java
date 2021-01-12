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
    private w jLp;
    public boolean jLs;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<n> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jLo = null;
    private int jLq = ao.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jLr = new HashSet<>();
    private com.baidu.tieba.frs.b.b jkJ = new com.baidu.tieba.frs.b.b();
    protected final View.OnClickListener jLt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
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
                    if (kVar != null && kVar.dKq() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            be.bsB().b(e.this.mPageContext, new String[]{url});
                            a.C0869a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dKr(), e.this.mForumId, e.this.mForumName, null);
                            b2.gs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dKq() == 3) {
                        new aq("c13442").dW("forum_id", e.this.mForumId).bsu();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fjU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.jLp != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                n nVar = (n) x.getItem(e.this.mData, aVar.position);
                if (nVar instanceof bz) {
                    bz bzVar = (bz) nVar;
                    e.this.jLp.a(view, bzVar, BdUniqueId.gen(), null, e.this.jLs ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new aq("c13124").w("fid", bzVar.getFid()).dW("tid", bzVar.getTid()).dW("uid", TbadkCoreApplication.getCurrentAccount()).an("obj_locate", aVar.position + 1));
                } else if (nVar instanceof p) {
                    e.this.jLp.a(view, (p) nVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.elg = view;
                cVar.abG = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jLy = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jLz = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (n) x.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.elg = view;
                bVar.jLy = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jLz = (TextView) view.findViewById(R.id.top_item_rank);
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
            ao.setViewTextColor(aVar.jLy, R.color.CAM_X0101);
        }
    }

    public void d(w wVar) {
        this.jLp = wVar;
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
        return this.jkJ;
    }

    /* loaded from: classes2.dex */
    public class a {
        View elg;
        TextView jLy;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a {
        TextView jLz;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a {
        TbImageView abG;
        TextView jLz;

        public c() {
            super();
        }
    }

    private void a(b bVar, bz bzVar, int i) {
        if (bVar != null && bzVar != null) {
            bVar.jLy.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oQ(l.getDimens(this.mContext, R.dimen.tbds10)).oN(this.jLq).bz(bVar.jLy);
            bzVar.boy();
            SpannableStringBuilder bog = bzVar.bog();
            if ((bog == null || at.isEmptyStringAfterTrim(bog.toString())) && bzVar.bmY() != null) {
                bog = new SpannableStringBuilder(bzVar.bmY());
            }
            bVar.titleText.setOnTouchListener(new i(bog));
            bVar.titleText.setText(bog);
            bVar.elg.setOnClickListener(this.fjU);
            a(bVar);
        }
    }

    private void a(b bVar, p pVar, int i) {
        if (bVar != null && pVar != null && pVar.dKx() != null && this.mUserData != null) {
            bVar.jLy.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.f.a.btb().oJ(0).oQ(l.getDimens(this.mContext, R.dimen.tbds10)).oN(this.jLq).bz(bVar.jLy);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dKx().audit_status.intValue() == 0 && pVar.dKx().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dKx().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dKx().title);
                } else if (pVar.dKx().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dKx().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dKx().title);
            }
            bVar.elg.setOnClickListener(this.fjU);
            a(bVar);
        }
    }

    private void a(c cVar, n nVar) {
        if (cVar != null && nVar != null) {
            if (nVar instanceof bz) {
                bz bzVar = (bz) nVar;
                bzVar.boy();
                SpannableStringBuilder bog = bzVar.bog();
                if ((bog == null || at.isEmptyStringAfterTrim(bog.toString())) && bzVar.bmY() != null) {
                    bog = new SpannableStringBuilder(bzVar.bmY());
                }
                cVar.jLy.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bog));
                cVar.titleText.setText(bog);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.abG.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jLy.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.abG.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jLy.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.abG.startLoad(this.imageUrl, 10, false);
                }
                cVar.jLy.setTextColor(this.jLq);
                cVar.elg.setOnClickListener(this.fjU);
                a(cVar);
            } else if (nVar instanceof k) {
                k kVar = (k) nVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jLy.setText(a2);
                    cVar.jLy.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.abG.setVisibility(8);
                } else {
                    cVar.jLy.setVisibility(8);
                    cVar.abG.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.abG.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dKp() != 0) {
                    cVar.jLz.setVisibility(0);
                    if (kVar.dKp() == -1) {
                        cVar.jLz.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dKp() > 999) {
                        cVar.jLz.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jLz.setText(this.mContext.getString(R.string.rang_identify) + kVar.dKp());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jLz.setVisibility(8);
                }
                cVar.jLy.setTextColor(this.jLq);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jLt != null) {
                    cVar.elg.setOnClickListener(this.jLt);
                }
                if (this.jLr != null && this.jLr.add(kVar.dKr())) {
                    a.C0869a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dKr(), this.mForumId, this.mForumName, null);
                    b2.gs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jLy.setText(a2);
        com.baidu.tbadk.core.util.f.a.btb().oJ(0).oQ(l.getDimens(this.mContext, R.dimen.tbds10)).oN(this.jLq).bz(bVar.jLy);
        if (kVar.dKp() != 0) {
            bVar.jLz.setVisibility(0);
            if (kVar.dKp() == -1) {
                bVar.jLz.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dKp() > 999) {
                bVar.jLz.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jLz.setText(this.mContext.getString(R.string.rang_identify) + kVar.dKp());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jLz.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jLt != null) {
            bVar.elg.setOnClickListener(this.jLt);
        }
        if (this.jLr != null && this.jLr.add(kVar.dKr())) {
            a.C0869a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dKr(), this.mForumId, this.mForumName, null);
            b2.gs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bBS() == null) {
            return false;
        }
        ForumData bBS = oVar.bBS();
        boolean z = oVar.dKw() && !x.isEmpty(bBS.getTipInfos());
        String riskTipNotice = z ? bBS.getTipInfos().get(0).tip_notice : bBS.getRiskTipNotice();
        final String riskTipPopTitle = z ? bBS.getTipInfos().get(0).tip_pop_title : bBS.getRiskTipPopTitle();
        final String riskTipPop = z ? bBS.getTipInfos().get(0).tip_pop : bBS.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jLy.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jLy.setTextColor(this.jLq);
        bVar.titleText.setText(riskTipNotice);
        bVar.titleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.titleText.getLayout().getEllipsisCount(bVar.titleText.getLineCount() - 1) > 0) {
                    e.this.fo(riskTipPop, riskTipPopTitle);
                }
            }
        });
        a(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fo(String str, String str2) {
        if (!at.isEmpty(str) && !at.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.Ac(str2);
            aVar.setTitleShowCenter(true);
            aVar.Ad(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.e.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqe();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dKs()) || kVar.dKs().trim().length() == 0) {
            if (kVar.dKo() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dKs();
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
        this.jLo = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void AQ(int i) {
        this.jLq = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
