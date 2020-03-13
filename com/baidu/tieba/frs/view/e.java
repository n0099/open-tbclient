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
import com.baidu.tieba.tbadkCore.j;
import com.baidu.tieba.view.h;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes9.dex */
public class e extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private s gRu;
    public boolean gRw;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<m> mData;
    private String mForumId = "";
    private String mForumName = "";
    private int gRv = am.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> gQl = new HashSet<>();
    private com.baidu.tieba.frs.d.b gwC = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener gRx = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j jVar;
            if ((e.this.mContext == null || bc.checkUpIsLogin(e.this.mContext)) && view != null) {
                if ((view.getTag() instanceof j) || (view.getTag() instanceof a)) {
                    if (view.getTag() instanceof j) {
                        jVar = (j) view.getTag();
                    } else {
                        if (view.getTag() instanceof a) {
                            a aVar = (a) view.getTag();
                            if (aVar.titleText != null && (aVar.titleText.getTag() instanceof j)) {
                                jVar = (j) aVar.titleText.getTag();
                            }
                        }
                        jVar = null;
                    }
                    if (jVar != null && jVar.cKl() == 2) {
                        if (!StringUtils.isNull(jVar.getUrl())) {
                            String url = jVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(e.this.mContext, (int) R.string.book_plugin_not_install_tip);
                                return;
                            }
                            ba.aGG().b(e.this.mPageContext, new String[]{url});
                            a.C0612a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", jVar.cKm(), e.this.mForumId, e.this.mForumName, null);
                            b2.eE(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                            b2.save();
                        }
                    } else if (jVar != null && jVar.cKl() == 3) {
                        new an("c13442").cy("forum_id", e.this.mForumId).aGz();
                        if (e.this.mPageContext != null && !TextUtils.isEmpty(e.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(e.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(e.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener fgt = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.e.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (e.this.gRu != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                m mVar = (m) v.getItem(e.this.mData, aVar.position);
                if (mVar instanceof bj) {
                    bj bjVar = (bj) mVar;
                    e.this.gRu.a(view, bjVar, BdUniqueId.gen(), null, e.this.gRw ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new an("c13124").s("fid", bjVar.getFid()).cy("tid", bjVar.getTid()).cy("uid", TbadkCoreApplication.getCurrentAccount()).X("obj_locate", aVar.position + 1));
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
                cVar.cug = view;
                cVar.EB = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.gRz = (TextView) view.findViewById(R.id.top_item_type);
                cVar.gRA = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (m) v.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.cug = view;
                bVar.gRz = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.gRA = (TextView) view.findViewById(R.id.top_item_rank);
                bVar.cVU = view.findViewById(R.id.top_item_divider);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            m mVar = (m) v.getItem(this.mData, i);
            if (mVar instanceof bj) {
                a(bVar, (bj) mVar, i);
                bVar.position = i;
            } else if (mVar instanceof j) {
                a(bVar, (j) mVar);
            }
            if (i > 0) {
                bVar.cVU.setVisibility(0);
            } else {
                bVar.cVU.setVisibility(8);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            am.setViewTextColor(aVar.titleText, (int) R.color.cp_cont_b);
            am.setBackgroundColor(aVar.cug, R.color.cp_bg_line_h);
            if ((aVar instanceof b) && ((b) aVar).cVU != null) {
                ((b) aVar).cVU.setBackgroundColor(am.getColor(R.color.cp_bg_line_c));
            }
        }
    }

    public void d(s sVar) {
        this.gRu = sVar;
    }

    public void setData(List<m> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b bGY() {
        return this.gwC;
    }

    /* loaded from: classes9.dex */
    public class a {
        View cug;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes9.dex */
    public class b extends a {
        View cVU;
        TextView gRA;
        TextView gRz;

        public b() {
            super();
        }
    }

    /* loaded from: classes9.dex */
    public class c extends a {
        TbImageView EB;
        TextView gRA;
        TextView gRz;

        public c() {
            super();
        }
    }

    private void a(b bVar, bj bjVar, int i) {
        if (bVar != null && bjVar != null) {
            bVar.gRz.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
            bVar.gRz.setTextColor(this.gRv);
            bjVar.aDk();
            SpannableStringBuilder aCV = bjVar.aCV();
            if ((aCV == null || aq.isEmptyStringAfterTrim(aCV.toString())) && bjVar.aBQ() != null) {
                aCV = new SpannableStringBuilder(bjVar.aBQ());
            }
            bVar.titleText.setOnTouchListener(new h(aCV));
            bVar.titleText.setText(aCV);
            bVar.cug.setOnClickListener(this.fgt);
            a(bVar);
        }
    }

    private void a(c cVar, m mVar) {
        if (cVar != null && mVar != null) {
            if (mVar instanceof bj) {
                bj bjVar = (bj) mVar;
                bjVar.aDk();
                SpannableStringBuilder aCV = bjVar.aCV();
                if ((aCV == null || aq.isEmptyStringAfterTrim(aCV.toString())) && bjVar.aBQ() != null) {
                    aCV = new SpannableStringBuilder(bjVar.aBQ());
                }
                cVar.gRz.setText(TbadkCoreApplication.getInst().getString(R.string.f1281top));
                cVar.titleText.setOnTouchListener(new h(aCV));
                cVar.titleText.setText(aCV);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.EB.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.gRz.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.EB.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.gRz.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.EB.startLoad(this.imageUrl, 10, false);
                }
                cVar.gRz.setTextColor(this.gRv);
                cVar.cug.setOnClickListener(this.fgt);
                a(cVar);
            } else if (mVar instanceof j) {
                j jVar = (j) mVar;
                String a2 = a(jVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.gRz.setText(a2);
                    cVar.gRz.setVisibility(0);
                    cVar.titleText.setText(jVar.getTitle());
                    cVar.EB.setVisibility(8);
                } else {
                    cVar.gRz.setVisibility(8);
                    cVar.EB.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + jVar.getTitle());
                    cVar.EB.startLoad(this.imageUrl, 10, false);
                }
                if (jVar.cKk() != 0) {
                    cVar.gRA.setVisibility(0);
                    if (jVar.cKk() == -1) {
                        cVar.gRA.setText(this.mContext.getString(R.string.no_rank));
                    } else if (jVar.cKk() > 999) {
                        cVar.gRA.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.gRA.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cKk()));
                    }
                    if (!StringUtils.isNull(jVar.getTitle())) {
                        cVar.titleText.setText(jVar.getTitle());
                    }
                } else {
                    cVar.gRA.setVisibility(8);
                }
                cVar.gRz.setTextColor(this.gRv);
                a(cVar);
                cVar.titleText.setTag(jVar);
                if (this.gRx != null) {
                    cVar.cug.setOnClickListener(this.gRx);
                }
                if (this.gQl != null && this.gQl.add(jVar.cKm())) {
                    a.C0612a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cKm(), this.mForumId, this.mForumName, null);
                    b2.eE(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, j jVar) {
        String a2 = a(jVar);
        bVar.titleText.setText(jVar.getTitle());
        bVar.gRz.setText(a2);
        bVar.gRz.setTextColor(this.gRv);
        if (jVar.cKk() != 0) {
            bVar.gRA.setVisibility(0);
            if (jVar.cKk() == -1) {
                bVar.gRA.setText(this.mContext.getString(R.string.no_rank));
            } else if (jVar.cKk() > 999) {
                bVar.gRA.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.gRA.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(jVar.cKk()));
            }
            if (!StringUtils.isNull(jVar.getTitle())) {
                bVar.titleText.setText(jVar.getTitle());
            }
        } else {
            bVar.gRA.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(jVar);
        if (this.gRx != null) {
            bVar.cug.setOnClickListener(this.gRx);
        }
        if (this.gQl != null && this.gQl.add(jVar.cKm())) {
            a.C0612a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", jVar.cKm(), this.mForumId, this.mForumName, null);
            b2.eE(TiebaInitialize.Params.OBJ_URL, jVar.getUrl());
            b2.save();
        }
    }

    private String a(j jVar) {
        if (TextUtils.isEmpty(jVar.cKn()) || jVar.cKn().trim().length() == 0) {
            if (jVar.cKj() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return jVar.cKn();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void dw(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void uI(int i) {
        this.gRv = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
