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
import com.baidu.adp.widget.ListView.s;
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
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.h;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private s gSB;
    public boolean gSD;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int gSC = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> gRs = new HashSet<>();
    private com.baidu.tieba.frs.d.b gxl = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener gSE = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((e.this.mContext == null || bc.checkUpIsLogin(e.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.cKF() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aGK().b(e.this.mPageContext, new String[]{url});
                            a.C0613a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.cKG(), e.this.mForumId, e.this.mForumName, null);
                            b2.eC(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.cKF() == 3) {
                        new an("c13442").cx("forum_id", e.this.mForumId).aGD();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fgS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.gSB != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.getItem(e.this.mData, aVar.position);
                if (mVar instanceof bj) {
                    bj bjVar = (bj) mVar;
                    e.this.gSB.a(view, bjVar, BdUniqueId.gen(), null, e.this.gSD ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").s("fid", bjVar.getFid()).cx("tid", bjVar.getTid()).cx("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_locate", aVar.position + 1));
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
        return v.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return v.getItem(this.mData, i);
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
                cVar.cus = view;
                cVar.EB = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.gSG = (TextView) view.findViewById(R.id.top_item_type);
                cVar.gSH = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.cus = view;
                bVar.gSG = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.gSH = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.cWh = view.findViewById(R.id.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.getItem(this.mData, i);
            if (mVar instanceof bj) {
                a(bVar, (bj) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof k) {
                a(bVar, (k) mVar);
            }
            if (i > 0) {
                bVar.cWh.setVisibility(0);
            } else {
                bVar.cWh.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.cus, R.color.cp_bg_line_h);
            if ((aVar instanceof b) && ((b) aVar).cWh != null) {
                ((b) aVar).cWh.setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void d(s sVar) {
        this.gSB = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bHn() {
        return this.gxl;
    }

    /* loaded from: classes9.dex */
    public class a {
        View cus;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes9.dex */
    public class b extends a {
        View cWh;
        TextView gSG;
        TextView gSH;

        public b() {
            super();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a {
        TbImageView EB;
        TextView gSG;
        TextView gSH;

        public c() {
            super();
        }
    }

    private void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bjVar != null) {
            bVar.gSG.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
            bVar.gSG.setTextColor(this.gSC);
            bjVar.aDn();
            SpannableStringBuilder aCY = bjVar.aCY();
            if ((aCY == null || aq.isEmptyStringAfterTrim(aCY.toString())) && bjVar.aBT() != null) {
                aCY = new SpannableStringBuilder(bjVar.aBT());
            }
            bVar.titleText.setOnTouchListener(new h(aCY));
            bVar.titleText.setText(aCY);
            bVar.cus.setOnClickListener(this.fgS);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                bjVar.aDn();
                SpannableStringBuilder aCY = bjVar.aCY();
                if ((aCY == null || aq.isEmptyStringAfterTrim(aCY.toString())) && bjVar.aBT() != null) {
                    aCY = new SpannableStringBuilder(bjVar.aBT());
                }
                cVar.gSG.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
                cVar.titleText.setOnTouchListener(new h(aCY));
                cVar.titleText.setText(aCY);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.EB.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.gSG.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.EB.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.gSG.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.EB.startLoad(this.imageUrl, 10, false);
                }
                cVar.gSG.setTextColor(this.gSC);
                cVar.cus.setOnClickListener(this.fgS);
                a(cVar);
            } else if (mVar instanceof k) {
                k kVar = (k) mVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.gSG.setText(a2);
                    cVar.gSG.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.EB.setVisibility(8);
                } else {
                    cVar.gSG.setVisibility(8);
                    cVar.EB.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.EB.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.cKE() != 0) {
                    cVar.gSH.setVisibility(0);
                    if (kVar.cKE() == -1) {
                        cVar.gSH.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.cKE() > 999) {
                        cVar.gSH.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.gSH.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.cKE()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.gSH.setVisibility(8);
                }
                cVar.gSG.setTextColor(this.gSC);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.gSE != null) {
                    cVar.cus.setOnClickListener(this.gSE);
                }
                if (this.gRs != null && this.gRs.add(kVar.cKG())) {
                    a.C0613a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.cKG(), this.mForumId, this.mForumName, null);
                    b2.eC(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.gSG.setText(a2);
        bVar.gSG.setTextColor(this.gSC);
        if (kVar.cKE() != 0) {
            bVar.gSH.setVisibility(0);
            if (kVar.cKE() == -1) {
                bVar.gSH.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.cKE() > 999) {
                bVar.gSH.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.gSH.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.cKE()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.gSH.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.gSE != null) {
            bVar.cus.setOnClickListener(this.gSE);
        }
        if (this.gRs != null && this.gRs.add(kVar.cKG())) {
            a.C0613a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.cKG(), this.mForumId, this.mForumName, null);
            b2.eC(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.cKH()) || kVar.cKH().trim().length() == 0) {
            if (kVar.cKD() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.cKH();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void du(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void uP(int i) {
        this.gSC = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
