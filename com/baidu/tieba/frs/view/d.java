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
import com.baidu.adp.widget.ListView.m;
import com.baidu.adp.widget.ListView.v;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private v hCq;
    public boolean hCs;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int hCr = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> hBu = new HashSet<>();
    private com.baidu.tieba.frs.d.b hgG = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener hCt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((d.this.mContext == null || bc.checkUpIsLogin(d.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.cVB() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(d.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aOY().b(d.this.mPageContext, new String[]{url});
                            a.C0654a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.cVC(), d.this.mForumId, d.this.mForumName, null);
                            b2.eR(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.cVB() == 3) {
                        new an("c13442").cI("forum_id", d.this.mForumId).aOR();
                        if (d.this.mPageContext != null && !TextUtils.isEmpty(d.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(d.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fLe = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (d.this.hCq != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) com.baidu.tbadk.core.util.v.getItem(d.this.mData, aVar.position);
                if (mVar instanceof bj) {
                    bj bjVar = (bj) mVar;
                    d.this.hCq.a(view, bjVar, BdUniqueId.gen(), null, d.this.hCs ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").t("fid", bjVar.getFid()).cI("tid", bjVar.getTid()).cI("uid", TbadkCoreApplication.getCurrentAccount()).af("obj_locate", aVar.position + 1));
                }
            }
        }
    };
    private TbPageContext mPageContext = getTbPageContext();

    public d(Context context) {
        this.mContext = context;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return com.baidu.tbadk.core.util.v.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return com.baidu.tbadk.core.util.v.getItem(this.mData, i);
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
                cVar.cTp = view;
                cVar.XS = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.hCv = (TextView) view.findViewById(R.id.top_item_type);
                cVar.hCw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) com.baidu.tbadk.core.util.v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.cTp = view;
                bVar.hCv = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.hCw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) com.baidu.tbadk.core.util.v.getItem(this.mData, i);
            if (mVar instanceof bj) {
                a(bVar, (bj) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof k) {
                a(bVar, (k) mVar);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.cTp, R.color.cp_bg_line_d);
        }
    }

    public void d(v vVar) {
        this.hCq = vVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hgG;
    }

    /* loaded from: classes9.dex */
    public class a {
        View cTp;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes9.dex */
    public class b extends a {
        TextView hCv;
        TextView hCw;

        public b() {
            super();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a {
        TbImageView XS;
        TextView hCv;
        TextView hCw;

        public c() {
            super();
        }
    }

    private void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bjVar != null) {
            bVar.hCv.setText(TbadkCoreApplication.getInst().getString(R.string.f1287top));
            bVar.hCv.setTextColor(this.hCr);
            bjVar.aLA();
            SpannableStringBuilder aLl = bjVar.aLl();
            if ((aLl == null || aq.isEmptyStringAfterTrim(aLl.toString())) && bjVar.aKg() != null) {
                aLl = new SpannableStringBuilder(bjVar.aKg());
            }
            bVar.titleText.setOnTouchListener(new i(aLl));
            bVar.titleText.setText(aLl);
            bVar.cTp.setOnClickListener(this.fLe);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                bjVar.aLA();
                SpannableStringBuilder aLl = bjVar.aLl();
                if ((aLl == null || aq.isEmptyStringAfterTrim(aLl.toString())) && bjVar.aKg() != null) {
                    aLl = new SpannableStringBuilder(bjVar.aKg());
                }
                cVar.hCv.setText(TbadkCoreApplication.getInst().getString(R.string.f1287top));
                cVar.titleText.setOnTouchListener(new i(aLl));
                cVar.titleText.setText(aLl);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.XS.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.hCv.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.XS.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hCv.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.XS.startLoad(this.imageUrl, 10, false);
                }
                cVar.hCv.setTextColor(this.hCr);
                cVar.cTp.setOnClickListener(this.fLe);
                a(cVar);
            } else if (mVar instanceof k) {
                k kVar = (k) mVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.hCv.setText(a2);
                    cVar.hCv.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.XS.setVisibility(8);
                } else {
                    cVar.hCv.setVisibility(8);
                    cVar.XS.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.XS.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.cVA() != 0) {
                    cVar.hCw.setVisibility(0);
                    if (kVar.cVA() == -1) {
                        cVar.hCw.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.cVA() > 999) {
                        cVar.hCw.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.hCw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.cVA()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.hCw.setVisibility(8);
                }
                cVar.hCv.setTextColor(this.hCr);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.hCt != null) {
                    cVar.cTp.setOnClickListener(this.hCt);
                }
                if (this.hBu != null && this.hBu.add(kVar.cVC())) {
                    a.C0654a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.cVC(), this.mForumId, this.mForumName, null);
                    b2.eR(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.hCv.setText(a2);
        bVar.hCv.setTextColor(this.hCr);
        if (kVar.cVA() != 0) {
            bVar.hCw.setVisibility(0);
            if (kVar.cVA() == -1) {
                bVar.hCw.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.cVA() > 999) {
                bVar.hCw.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.hCw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.cVA()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.hCw.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.hCt != null) {
            bVar.cTp.setOnClickListener(this.hCt);
        }
        if (this.hBu != null && this.hBu.add(kVar.cVC())) {
            a.C0654a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.cVC(), this.mForumId, this.mForumName, null);
            b2.eR(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.cVD()) || kVar.cVD().trim().length() == 0) {
            if (kVar.cVz() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.cVD();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void dJ(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void vn(int i) {
        this.hCr = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
