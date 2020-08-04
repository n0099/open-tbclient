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
import com.baidu.adp.widget.ListView.q;
import com.baidu.adp.widget.ListView.z;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bv;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private z imw;
    public boolean imy;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int imx = ao.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> ikv = new HashSet<>();
    private com.baidu.tieba.frs.d.b hOG = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener imz = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((g.this.mContext == null || bf.checkUpIsLogin(g.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dkr() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bd.baV().b(g.this.mPageContext, new String[]{url});
                            a.C0755a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dks(), g.this.mForumId, g.this.mForumName, null);
                            b2.fB(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dkr() == 3) {
                        new ap("c13442").dn("forum_id", g.this.mForumId).baO();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener elT = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.imw != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) x.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bv) {
                    bv bvVar = (bv) qVar;
                    g.this.imw.a(view, bvVar, BdUniqueId.gen(), null, g.this.imy ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ap("c13124").t("fid", bvVar.getFid()).dn("tid", bvVar.getTid()).dn("uid", TbadkCoreApplication.getCurrentAccount()).ah("obj_locate", aVar.position + 1));
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
                cVar.dpe = view;
                cVar.YF = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.imB = (TextView) view.findViewById(R.id.top_item_type);
                cVar.imC = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) x.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dpe = view;
                bVar.imB = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.imC = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) x.getItem(this.mData, i);
            if (qVar instanceof bv) {
                a(bVar, (bv) qVar, i);
                bVar.position = i;
            } else if (qVar instanceof k) {
                a(bVar, (k) qVar);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ao.setViewTextColor(aVar.titleText, R.color.cp_cont_b);
            ao.setBackgroundColor(aVar.dpe, R.color.cp_bg_line_d);
        }
    }

    public void d(z zVar) {
        this.imw = zVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hOG;
    }

    /* loaded from: classes16.dex */
    public class a {
        View dpe;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes16.dex */
    public class b extends a {
        TextView imB;
        TextView imC;

        public b() {
            super();
        }
    }

    /* loaded from: classes16.dex */
    public class c extends a {
        TbImageView YF;
        TextView imB;
        TextView imC;

        public c() {
            super();
        }
    }

    private void a(b bVar, bv bvVar, int i) {
        if (bVar != null && bvVar != null) {
            bVar.imB.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.imB.setTextColor(this.imx);
            bvVar.aXk();
            SpannableStringBuilder aWV = bvVar.aWV();
            if ((aWV == null || as.isEmptyStringAfterTrim(aWV.toString())) && bvVar.aVM() != null) {
                aWV = new SpannableStringBuilder(bvVar.aVM());
            }
            bVar.titleText.setOnTouchListener(new i(aWV));
            bVar.titleText.setText(aWV);
            bVar.dpe.setOnClickListener(this.elT);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bv) {
                bv bvVar = (bv) qVar;
                bvVar.aXk();
                SpannableStringBuilder aWV = bvVar.aWV();
                if ((aWV == null || as.isEmptyStringAfterTrim(aWV.toString())) && bvVar.aVM() != null) {
                    aWV = new SpannableStringBuilder(bvVar.aVM());
                }
                cVar.imB.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(aWV));
                cVar.titleText.setText(aWV);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.YF.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.imB.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.YF.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.imB.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.YF.startLoad(this.imageUrl, 10, false);
                }
                cVar.imB.setTextColor(this.imx);
                cVar.dpe.setOnClickListener(this.elT);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.imB.setText(a2);
                    cVar.imB.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.YF.setVisibility(8);
                } else {
                    cVar.imB.setVisibility(8);
                    cVar.YF.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.YF.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dkq() != 0) {
                    cVar.imC.setVisibility(0);
                    if (kVar.dkq() == -1) {
                        cVar.imC.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dkq() > 999) {
                        cVar.imC.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.imC.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dkq()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.imC.setVisibility(8);
                }
                cVar.imB.setTextColor(this.imx);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.imz != null) {
                    cVar.dpe.setOnClickListener(this.imz);
                }
                if (this.ikv != null && this.ikv.add(kVar.dks())) {
                    a.C0755a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dks(), this.mForumId, this.mForumName, null);
                    b2.fB(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.imB.setText(a2);
        bVar.imB.setTextColor(this.imx);
        if (kVar.dkq() != 0) {
            bVar.imC.setVisibility(0);
            if (kVar.dkq() == -1) {
                bVar.imC.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dkq() > 999) {
                bVar.imC.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.imC.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dkq()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.imC.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.imz != null) {
            bVar.dpe.setOnClickListener(this.imz);
        }
        if (this.ikv != null && this.ikv.add(kVar.dks())) {
            a.C0755a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dks(), this.mForumId, this.mForumName, null);
            b2.fB(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dkt()) || kVar.dkt().trim().length() == 0) {
            if (kVar.dkp() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dkt();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void es(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void wT(int i) {
        this.imx = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
