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
import com.baidu.tbadk.core.data.cb;
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
/* loaded from: classes2.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.b.d {
    private w jUj;
    public boolean jUm;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<n> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jUi = null;
    private int jUk = ap.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jUl = new HashSet<>();
    private com.baidu.tieba.frs.b.b jsn = new com.baidu.tieba.frs.b.b();
    protected final View.OnClickListener jUn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((e.this.mContext == null || bh.checkUpIsLogin(e.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dMR() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bf.bsY().b(e.this.mPageContext, new String[]{url});
                            a.C0880a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dMS(), e.this.mForumId, e.this.mForumName, null);
                            b2.gA(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dMR() == 3) {
                        new ar("c13442").dR("forum_id", e.this.mForumId).bsR();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fnL = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.jUj != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                n nVar = (n) y.getItem(e.this.mData, aVar.position);
                if (nVar instanceof cb) {
                    cb cbVar = (cb) nVar;
                    e.this.jUj.a(view, cbVar, BdUniqueId.gen(), null, e.this.jUm ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ar("c13124").v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).aq("obj_locate", aVar.position + 1));
                } else if (nVar instanceof p) {
                    e.this.jUj.a(view, (p) nVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.eoR = view;
                cVar.acX = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jUs = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jUt = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (n) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.eoR = view;
                bVar.jUs = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jUt = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            n nVar = (n) y.getItem(this.mData, i);
            if (nVar instanceof cb) {
                a(bVar, (cb) nVar, i);
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
            ap.setViewTextColor(aVar.titleText, R.color.CAM_X0105);
            ap.setViewTextColor(aVar.jUs, R.color.CAM_X0101);
        }
    }

    public void d(w wVar) {
        this.jUj = wVar;
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
        return this.jsn;
    }

    /* loaded from: classes2.dex */
    public class a {
        View eoR;
        TextView jUs;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a {
        TextView jUt;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a {
        TbImageView acX;
        TextView jUt;

        public c() {
            super();
        }
    }

    private void a(b bVar, cb cbVar, int i) {
        if (bVar != null && cbVar != null) {
            bVar.jUs.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oW(l.getDimens(this.mContext, R.dimen.tbds10)).oT(this.jUk).bv(bVar.jUs);
            cbVar.boS();
            SpannableStringBuilder boB = cbVar.boB();
            if ((boB == null || au.isEmptyStringAfterTrim(boB.toString())) && cbVar.bnt() != null) {
                boB = new SpannableStringBuilder(cbVar.bnt());
            }
            bVar.titleText.setOnTouchListener(new i(boB));
            bVar.titleText.setText(boB);
            bVar.eoR.setOnClickListener(this.fnL);
            a(bVar);
        }
    }

    private void a(b bVar, p pVar, int i) {
        if (bVar != null && pVar != null && pVar.dMY() != null && this.mUserData != null) {
            bVar.jUs.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.f.a.bty().oP(0).oW(l.getDimens(this.mContext, R.dimen.tbds10)).oT(this.jUk).bv(bVar.jUs);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dMY().audit_status.intValue() == 0 && pVar.dMY().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dMY().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dMY().title);
                } else if (pVar.dMY().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dMY().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dMY().title);
            }
            bVar.eoR.setOnClickListener(this.fnL);
            a(bVar);
        }
    }

    private void a(c cVar, n nVar) {
        if (cVar != null && nVar != null) {
            if (nVar instanceof cb) {
                cb cbVar = (cb) nVar;
                cbVar.boS();
                SpannableStringBuilder boB = cbVar.boB();
                if ((boB == null || au.isEmptyStringAfterTrim(boB.toString())) && cbVar.bnt() != null) {
                    boB = new SpannableStringBuilder(cbVar.bnt());
                }
                cVar.jUs.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(boB));
                cVar.titleText.setText(boB);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.acX.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jUs.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.acX.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jUs.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.acX.startLoad(this.imageUrl, 10, false);
                }
                cVar.jUs.setTextColor(this.jUk);
                cVar.eoR.setOnClickListener(this.fnL);
                a(cVar);
            } else if (nVar instanceof k) {
                k kVar = (k) nVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jUs.setText(a2);
                    cVar.jUs.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.acX.setVisibility(8);
                } else {
                    cVar.jUs.setVisibility(8);
                    cVar.acX.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.acX.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dMQ() != 0) {
                    cVar.jUt.setVisibility(0);
                    if (kVar.dMQ() == -1) {
                        cVar.jUt.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dMQ() > 999) {
                        cVar.jUt.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jUt.setText(this.mContext.getString(R.string.rang_identify) + kVar.dMQ());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jUt.setVisibility(8);
                }
                cVar.jUs.setTextColor(this.jUk);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jUn != null) {
                    cVar.eoR.setOnClickListener(this.jUn);
                }
                if (this.jUl != null && this.jUl.add(kVar.dMS())) {
                    a.C0880a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dMS(), this.mForumId, this.mForumName, null);
                    b2.gA(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jUs.setText(a2);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oW(l.getDimens(this.mContext, R.dimen.tbds10)).oT(this.jUk).bv(bVar.jUs);
        if (kVar.dMQ() != 0) {
            bVar.jUt.setVisibility(0);
            if (kVar.dMQ() == -1) {
                bVar.jUt.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dMQ() > 999) {
                bVar.jUt.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jUt.setText(this.mContext.getString(R.string.rang_identify) + kVar.dMQ());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jUt.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jUn != null) {
            bVar.eoR.setOnClickListener(this.jUn);
        }
        if (this.jUl != null && this.jUl.add(kVar.dMS())) {
            a.C0880a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dMS(), this.mForumId, this.mForumName, null);
            b2.gA(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bCn() == null) {
            return false;
        }
        ForumData bCn = oVar.bCn();
        boolean z = oVar.dMX() && !y.isEmpty(bCn.getTipInfos());
        String riskTipNotice = z ? bCn.getTipInfos().get(0).tip_notice : bCn.getRiskTipNotice();
        final String riskTipPopTitle = z ? bCn.getTipInfos().get(0).tip_pop_title : bCn.getRiskTipPopTitle();
        final String riskTipPop = z ? bCn.getTipInfos().get(0).tip_pop : bCn.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jUs.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jUs.setTextColor(this.jUk);
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
        if (!au.isEmpty(str) && !au.isEmpty(str2)) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.AA(str2);
            aVar.setTitleShowCenter(true);
            aVar.AB(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.e.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqz();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dMT()) || kVar.dMT().trim().length() == 0) {
            if (kVar.dMP() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dMT();
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
        this.jUi = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Bg(int i) {
        this.jUk = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
