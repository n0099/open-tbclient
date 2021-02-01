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
    private w jSm;
    public boolean jSp;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<n> mData;
    private UserData mUserData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData jSl = null;
    private int jSn = ap.getColor(R.color.CAM_X0302);
    private String imageUrl = "";
    protected HashSet<String> jSo = new HashSet<>();
    private com.baidu.tieba.frs.b.b jqq = new com.baidu.tieba.frs.b.b();
    protected final View.OnClickListener jSq = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
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
                    if (kVar != null && kVar.dMB() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bf.bsV().b(e.this.mPageContext, new String[]{url});
                            a.C0872a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dMC(), e.this.mForumId, e.this.mForumName, null);
                            b2.gy(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dMB() == 3) {
                        new ar("c13442").dR("forum_id", e.this.mForumId).bsO();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fml = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.jSm != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                n nVar = (n) y.getItem(e.this.mData, aVar.position);
                if (nVar instanceof cb) {
                    cb cbVar = (cb) nVar;
                    e.this.jSm.a(view, cbVar, BdUniqueId.gen(), null, e.this.jSp ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ar("c13124").v("fid", cbVar.getFid()).dR("tid", cbVar.getTid()).dR("uid", TbadkCoreApplication.getCurrentAccount()).ap("obj_locate", aVar.position + 1));
                } else if (nVar instanceof p) {
                    e.this.jSm.a(view, (p) nVar, BdUniqueId.gen(), null, aVar.position, 0L);
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
                cVar.eno = view;
                cVar.abB = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.jSv = (TextView) view.findViewById(R.id.top_item_type);
                cVar.jSw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (n) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.eno = view;
                bVar.jSv = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.jSw = (TextView) view.findViewById(R.id.top_item_rank);
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
            ap.setViewTextColor(aVar.jSv, R.color.CAM_X0101);
        }
    }

    public void d(w wVar) {
        this.jSm = wVar;
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
        return this.jqq;
    }

    /* loaded from: classes2.dex */
    public class a {
        View eno;
        TextView jSv;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes2.dex */
    public class b extends a {
        TextView jSw;

        public b() {
            super();
        }
    }

    /* loaded from: classes2.dex */
    public class c extends a {
        TbImageView abB;
        TextView jSw;

        public c() {
            super();
        }
    }

    private void a(b bVar, cb cbVar, int i) {
        if (bVar != null && cbVar != null) {
            bVar.jSv.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oV(l.getDimens(this.mContext, R.dimen.tbds10)).oS(this.jSn).bv(bVar.jSv);
            cbVar.boQ();
            SpannableStringBuilder boz = cbVar.boz();
            if ((boz == null || au.isEmptyStringAfterTrim(boz.toString())) && cbVar.bnr() != null) {
                boz = new SpannableStringBuilder(cbVar.bnr());
            }
            bVar.titleText.setOnTouchListener(new i(boz));
            bVar.titleText.setText(boz);
            bVar.eno.setOnClickListener(this.fml);
            a(bVar);
        }
    }

    private void a(b bVar, p pVar, int i) {
        if (bVar != null && pVar != null && pVar.dMI() != null && this.mUserData != null) {
            bVar.jSv.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules));
            com.baidu.tbadk.core.util.f.a.btv().oO(0).oV(l.getDimens(this.mContext, R.dimen.tbds10)).oS(this.jSn).bv(bVar.jSv);
            if (this.mUserData.getIs_manager() == 1) {
                if (pVar.dMI().audit_status.intValue() == 0 && pVar.dMI().has_forum_rule.intValue() == 0) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_none));
                } else if (pVar.dMI().audit_status.intValue() == 0) {
                    bVar.titleText.setText(pVar.dMI().title);
                } else if (pVar.dMI().audit_status.intValue() == 1) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_chenking));
                } else if (pVar.dMI().audit_status.intValue() == 2) {
                    bVar.titleText.setText(TbadkCoreApplication.getInst().getString(R.string.frs_top_forum_rules_refuse));
                }
            } else {
                bVar.titleText.setText(pVar.dMI().title);
            }
            bVar.eno.setOnClickListener(this.fml);
            a(bVar);
        }
    }

    private void a(c cVar, n nVar) {
        if (cVar != null && nVar != null) {
            if (nVar instanceof cb) {
                cb cbVar = (cb) nVar;
                cbVar.boQ();
                SpannableStringBuilder boz = cbVar.boz();
                if ((boz == null || au.isEmptyStringAfterTrim(boz.toString())) && cbVar.bnr() != null) {
                    boz = new SpannableStringBuilder(cbVar.bnr());
                }
                cVar.jSv.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(boz));
                cVar.titleText.setText(boz);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.abB.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.jSv.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.abB.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.jSv.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.abB.startLoad(this.imageUrl, 10, false);
                }
                cVar.jSv.setTextColor(this.jSn);
                cVar.eno.setOnClickListener(this.fml);
                a(cVar);
            } else if (nVar instanceof k) {
                k kVar = (k) nVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.jSv.setText(a2);
                    cVar.jSv.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.abB.setVisibility(8);
                } else {
                    cVar.jSv.setVisibility(8);
                    cVar.abB.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.abB.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dMA() != 0) {
                    cVar.jSw.setVisibility(0);
                    if (kVar.dMA() == -1) {
                        cVar.jSw.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dMA() > 999) {
                        cVar.jSw.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.jSw.setText(this.mContext.getString(R.string.rang_identify) + kVar.dMA());
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.jSw.setVisibility(8);
                }
                cVar.jSv.setTextColor(this.jSn);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.jSq != null) {
                    cVar.eno.setOnClickListener(this.jSq);
                }
                if (this.jSo != null && this.jSo.add(kVar.dMC())) {
                    a.C0872a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dMC(), this.mForumId, this.mForumName, null);
                    b2.gy(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.jSv.setText(a2);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oV(l.getDimens(this.mContext, R.dimen.tbds10)).oS(this.jSn).bv(bVar.jSv);
        if (kVar.dMA() != 0) {
            bVar.jSw.setVisibility(0);
            if (kVar.dMA() == -1) {
                bVar.jSw.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dMA() > 999) {
                bVar.jSw.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.jSw.setText(this.mContext.getString(R.string.rang_identify) + kVar.dMA());
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.jSw.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.jSq != null) {
            bVar.eno.setOnClickListener(this.jSq);
        }
        if (this.jSo != null && this.jSo.add(kVar.dMC())) {
            a.C0872a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dMC(), this.mForumId, this.mForumName, null);
            b2.gy(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(o oVar, final b bVar, int i) {
        if (i != 0 || oVar == null || oVar.bCk() == null) {
            return false;
        }
        ForumData bCk = oVar.bCk();
        boolean z = oVar.dMH() && !y.isEmpty(bCk.getTipInfos());
        String riskTipNotice = z ? bCk.getTipInfos().get(0).tip_notice : bCk.getRiskTipNotice();
        final String riskTipPopTitle = z ? bCk.getTipInfos().get(0).tip_pop_title : bCk.getRiskTipPopTitle();
        final String riskTipPop = z ? bCk.getTipInfos().get(0).tip_pop : bCk.getRiskTipPop();
        if (StringUtils.isNull(riskTipNotice)) {
            return false;
        }
        bVar.jSv.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.jSv.setTextColor(this.jSn);
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
            aVar.At(str2);
            aVar.setTitleShowCenter(true);
            aVar.Au(str);
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.e.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bqx();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dMD()) || kVar.dMD().trim().length() == 0) {
            if (kVar.dMz() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dMD();
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
        this.jSl = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void Bf(int i) {
        this.jSn = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
