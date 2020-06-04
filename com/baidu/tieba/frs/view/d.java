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
import com.baidu.adp.widget.ListView.o;
import com.baidu.adp.widget.ListView.x;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.bk;
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
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class d extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private x hRW;
    public boolean hRY;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<o> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int hRX = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> hRa = new HashSet<>();
    private com.baidu.tieba.frs.d.b hvL = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener hRZ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.1
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
                    if (kVar != null && kVar.dcS() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(d.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aVa().b(d.this.mPageContext, new String[]{url});
                            a.C0729a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dcT(), d.this.mForumId, d.this.mForumName, null);
                            b2.fs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dcS() == 3) {
                        new an("c13442").dh("forum_id", d.this.mForumId).aUT();
                        if (d.this.mPageContext != null && !TextUtils.isEmpty(d.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(d.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(d.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fZs = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.d.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (d.this.hRW != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                o oVar = (o) v.getItem(d.this.mData, aVar.position);
                if (oVar instanceof bk) {
                    bk bkVar = (bk) oVar;
                    d.this.hRW.a(view, bkVar, BdUniqueId.gen(), null, d.this.hRY ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").s("fid", bkVar.getFid()).dh("tid", bkVar.getTid()).dh("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_locate", aVar.position + 1));
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
        return v.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
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
                cVar.dex = view;
                cVar.Yl = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.hSb = (TextView) view.findViewById(R.id.top_item_type);
                cVar.hSc = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (o) v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dex = view;
                bVar.hSb = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.hSc = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            o oVar = (o) v.getItem(this.mData, i);
            if (oVar instanceof bk) {
                a(bVar, (bk) oVar, i);
                bVar.position = i;
            } else if (oVar instanceof k) {
                a(bVar, (k) oVar);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.dex, R.color.cp_bg_line_d);
        }
    }

    public void d(x xVar) {
        this.hRW = xVar;
    }

    public void setData(List<o> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hvL;
    }

    /* loaded from: classes9.dex */
    public class a {
        View dex;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes9.dex */
    public class b extends a {
        TextView hSb;
        TextView hSc;

        public b() {
            super();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a {
        TbImageView Yl;
        TextView hSb;
        TextView hSc;

        public c() {
            super();
        }
    }

    private void a(b bVar, bk bkVar, int i) {
        if (bVar != null && bkVar != null) {
            bVar.hSb.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
            bVar.hSb.setTextColor(this.hRX);
            bkVar.aRx();
            SpannableStringBuilder aRi = bkVar.aRi();
            if ((aRi == null || aq.isEmptyStringAfterTrim(aRi.toString())) && bkVar.aPZ() != null) {
                aRi = new SpannableStringBuilder(bkVar.aPZ());
            }
            bVar.titleText.setOnTouchListener(new i(aRi));
            bVar.titleText.setText(aRi);
            bVar.dex.setOnClickListener(this.fZs);
            a(bVar);
        }
    }

    private void a(c cVar, o oVar) {
        if (cVar != null && oVar != null) {
            if (oVar instanceof bk) {
                bk bkVar = (bk) oVar;
                bkVar.aRx();
                SpannableStringBuilder aRi = bkVar.aRi();
                if ((aRi == null || aq.isEmptyStringAfterTrim(aRi.toString())) && bkVar.aPZ() != null) {
                    aRi = new SpannableStringBuilder(bkVar.aPZ());
                }
                cVar.hSb.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
                cVar.titleText.setOnTouchListener(new i(aRi));
                cVar.titleText.setText(aRi);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.Yl.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.hSb.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.Yl.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.hSb.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.Yl.startLoad(this.imageUrl, 10, false);
                }
                cVar.hSb.setTextColor(this.hRX);
                cVar.dex.setOnClickListener(this.fZs);
                a(cVar);
            } else if (oVar instanceof k) {
                k kVar = (k) oVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.hSb.setText(a2);
                    cVar.hSb.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.Yl.setVisibility(8);
                } else {
                    cVar.hSb.setVisibility(8);
                    cVar.Yl.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.Yl.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dcR() != 0) {
                    cVar.hSc.setVisibility(0);
                    if (kVar.dcR() == -1) {
                        cVar.hSc.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dcR() > 999) {
                        cVar.hSc.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.hSc.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dcR()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.hSc.setVisibility(8);
                }
                cVar.hSb.setTextColor(this.hRX);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.hRZ != null) {
                    cVar.dex.setOnClickListener(this.hRZ);
                }
                if (this.hRa != null && this.hRa.add(kVar.dcT())) {
                    a.C0729a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dcT(), this.mForumId, this.mForumName, null);
                    b2.fs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.hSb.setText(a2);
        bVar.hSb.setTextColor(this.hRX);
        if (kVar.dcR() != 0) {
            bVar.hSc.setVisibility(0);
            if (kVar.dcR() == -1) {
                bVar.hSc.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dcR() > 999) {
                bVar.hSc.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.hSc.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dcR()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.hSc.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.hRZ != null) {
            bVar.dex.setOnClickListener(this.hRZ);
        }
        if (this.hRa != null && this.hRa.add(kVar.dcT())) {
            a.C0729a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dcT(), this.mForumId, this.mForumName, null);
            b2.fs(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dcU()) || kVar.dcU().trim().length() == 0) {
            if (kVar.dcQ() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dcU();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void ek(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void vV(int i) {
        this.hRX = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
