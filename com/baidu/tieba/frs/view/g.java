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
import com.baidu.tbadk.core.data.bu;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private z igq;
    public boolean igs;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int igr = an.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> iev = new HashSet<>();
    private com.baidu.tieba.frs.d.b hIE = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener igt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((g.this.mContext == null || be.checkUpIsLogin(g.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dhh() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            bc.aWU().b(g.this.mPageContext, new String[]{url});
                            a.C0745a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dhi(), g.this.mForumId, g.this.mForumName, null);
                            b2.fz(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dhh() == 3) {
                        new ao("c13442").dk("forum_id", g.this.mForumId).aWN();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener efJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.igq != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) w.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bu) {
                    bu buVar = (bu) qVar;
                    g.this.igq.a(view, buVar, BdUniqueId.gen(), null, g.this.igs ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new ao("c13124").s("fid", buVar.getFid()).dk("tid", buVar.getTid()).dk("uid", TbadkCoreApplication.getCurrentAccount()).ag("obj_locate", aVar.position + 1));
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
        return w.getCount(this.mData);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        return 2;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return w.getItem(this.mData, i);
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
                cVar.djj = view;
                cVar.YP = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.igv = (TextView) view.findViewById(R.id.top_item_type);
                cVar.igw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) w.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.djj = view;
                bVar.igv = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.igw = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) w.getItem(this.mData, i);
            if (qVar instanceof bu) {
                a(bVar, (bu) qVar, i);
                bVar.position = i;
            } else if (qVar instanceof k) {
                a(bVar, (k) qVar);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            an.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            an.setBackgroundColor(aVar.djj, R.color.cp_bg_line_d);
        }
    }

    public void d(z zVar) {
        this.igq = zVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.hIE;
    }

    /* loaded from: classes9.dex */
    public class a {
        View djj;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes9.dex */
    public class b extends a {
        TextView igv;
        TextView igw;

        public b() {
            super();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a {
        TbImageView YP;
        TextView igv;
        TextView igw;

        public c() {
            super();
        }
    }

    private void a(b bVar, bu buVar, int i) {
        if (bVar != null && buVar != null) {
            bVar.igv.setText(TbadkCoreApplication.getInst().getString(R.string.f1302top));
            bVar.igv.setTextColor(this.igr);
            buVar.aTo();
            SpannableStringBuilder aSZ = buVar.aSZ();
            if ((aSZ == null || ar.isEmptyStringAfterTrim(aSZ.toString())) && buVar.aRQ() != null) {
                aSZ = new SpannableStringBuilder(buVar.aRQ());
            }
            bVar.titleText.setOnTouchListener(new i(aSZ));
            bVar.titleText.setText(aSZ);
            bVar.djj.setOnClickListener(this.efJ);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bu) {
                bu buVar = (bu) qVar;
                buVar.aTo();
                SpannableStringBuilder aSZ = buVar.aSZ();
                if ((aSZ == null || ar.isEmptyStringAfterTrim(aSZ.toString())) && buVar.aRQ() != null) {
                    aSZ = new SpannableStringBuilder(buVar.aRQ());
                }
                cVar.igv.setText(TbadkCoreApplication.getInst().getString(R.string.f1302top));
                cVar.titleText.setOnTouchListener(new i(aSZ));
                cVar.titleText.setText(aSZ);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.YP.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.igv.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.YP.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.igv.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.YP.startLoad(this.imageUrl, 10, false);
                }
                cVar.igv.setTextColor(this.igr);
                cVar.djj.setOnClickListener(this.efJ);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.igv.setText(a2);
                    cVar.igv.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.YP.setVisibility(8);
                } else {
                    cVar.igv.setVisibility(8);
                    cVar.YP.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.YP.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dhg() != 0) {
                    cVar.igw.setVisibility(0);
                    if (kVar.dhg() == -1) {
                        cVar.igw.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dhg() > 999) {
                        cVar.igw.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.igw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dhg()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.igw.setVisibility(8);
                }
                cVar.igv.setTextColor(this.igr);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.igt != null) {
                    cVar.djj.setOnClickListener(this.igt);
                }
                if (this.iev != null && this.iev.add(kVar.dhi())) {
                    a.C0745a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dhi(), this.mForumId, this.mForumName, null);
                    b2.fz(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.igv.setText(a2);
        bVar.igv.setTextColor(this.igr);
        if (kVar.dhg() != 0) {
            bVar.igw.setVisibility(0);
            if (kVar.dhg() == -1) {
                bVar.igw.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dhg() > 999) {
                bVar.igw.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.igw.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dhg()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.igw.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.igt != null) {
            bVar.djj.setOnClickListener(this.igt);
        }
        if (this.iev != null && this.iev.add(kVar.dhi())) {
            a.C0745a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dhi(), this.mForumId, this.mForumName, null);
            b2.fz(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dhj()) || kVar.dhj().trim().length() == 0) {
            if (kVar.dhf() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dhj();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void eq(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void wB(int i) {
        this.igr = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
