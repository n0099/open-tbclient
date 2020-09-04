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
import com.baidu.adp.widget.ListView.ab;
import com.baidu.adp.widget.ListView.q;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.BarVoteActivityConfig;
import com.baidu.tbadk.core.atomData.BookCoverActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.bw;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.d.a;
import com.baidu.tieba.tbadkCore.k;
import com.baidu.tieba.tbadkCore.o;
import com.baidu.tieba.view.i;
import java.util.HashSet;
import java.util.List;
/* loaded from: classes16.dex */
public class g extends BaseAdapter implements com.baidu.tieba.frs.d.d {
    private ab iAF;
    public boolean iAH;
    public BdUniqueId mBdUniqueId;
    private Context mContext;
    private List<q> mData;
    private String mForumId = "";
    private String mForumName = "";
    private ForumData iAE = null;
    private int iAG = ap.getColor(R.color.cp_link_tip_a);
    private String imageUrl = "";
    protected HashSet<String> iyF = new HashSet<>();
    private com.baidu.tieba.frs.d.b icR = new com.baidu.tieba.frs.d.b();
    protected final View.OnClickListener iAI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            k kVar;
            if ((g.this.mContext == null || bg.checkUpIsLogin(g.this.mContext)) && view != null) {
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
                    if (kVar != null && kVar.dvT() == 2) {
                        if (!StringUtils.isNull(kVar.getUrl())) {
                            String url = kVar.getUrl();
                            if ((url.contains("nohead:url") || url.contains("booktown")) && !TbadkCoreApplication.getInst().appResponseToIntentClass(BookCoverActivityConfig.class)) {
                                l.showToast(g.this.mContext, R.string.book_plugin_not_install_tip);
                                return;
                            }
                            be.bju().b(g.this.mPageContext, new String[]{url});
                            a.C0808a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "CLICK", kVar.dvU(), g.this.mForumId, g.this.mForumName, null);
                            b2.fT(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                            b2.save();
                        }
                    } else if (kVar != null && kVar.dvT() == 3) {
                        new aq("c13442").dD("forum_id", g.this.mForumId).bjn();
                        if (g.this.mPageContext != null && !TextUtils.isEmpty(g.this.mForumId)) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921408, new BarVoteActivityConfig(g.this.mPageContext.getPageActivity()).createNormalConfig(com.baidu.adp.lib.f.b.toLong(g.this.mForumId, 0L), 1)));
                        }
                    }
                }
            }
        }
    };
    private View.OnClickListener evS = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a aVar;
            view.setPressed(false);
            if (g.this.iAF != null && (view.getTag() instanceof a) && (aVar = (a) view.getTag()) != null) {
                q qVar = (q) y.getItem(g.this.mData, aVar.position);
                if (qVar instanceof bw) {
                    bw bwVar = (bw) qVar;
                    g.this.iAF.a(view, bwVar, BdUniqueId.gen(), null, g.this.iAH ? aVar.position + 1 : aVar.position, 0L);
                    TiebaStatic.log(new aq("c13124").u("fid", bwVar.getFid()).dD("tid", bwVar.getTid()).dD("uid", TbadkCoreApplication.getCurrentAccount()).ai("obj_locate", aVar.position + 1));
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
                cVar.dzk = view;
                cVar.Zn = (TbImageView) view.findViewById(R.id.frs_header_top_item_image);
                cVar.titleText = (TextView) view.findViewById(R.id.frs_header_top_item_title);
                cVar.iAL = (TextView) view.findViewById(R.id.top_item_type);
                cVar.iAM = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(cVar);
            } else {
                cVar = (c) view.getTag();
            }
            a(cVar, (q) y.getItem(this.mData, i));
        } else if (getItemViewType(i) == 2) {
            if (view == null || !(view.getTag() instanceof b)) {
                bVar = new b();
                view = LayoutInflater.from(this.mContext).inflate(R.layout.frs_header_top_item_double, (ViewGroup) null, false);
                bVar.dzk = view;
                bVar.iAL = (TextView) view.findViewById(R.id.top_item_type);
                bVar.titleText = (TextView) view.findViewById(R.id.top_item_title);
                bVar.iAM = (TextView) view.findViewById(R.id.top_item_rank);
                view.setTag(bVar);
            } else {
                bVar = (b) view.getTag();
            }
            q qVar = (q) y.getItem(this.mData, i);
            if (qVar instanceof bw) {
                a(bVar, (bw) qVar, i);
                bVar.position = i;
            } else if (qVar instanceof k) {
                a(bVar, (k) qVar);
            } else if (qVar instanceof o) {
                a(bVar, i);
            }
        }
        return view;
    }

    private void a(a aVar) {
        if (aVar != null) {
            ap.setViewTextColor(aVar.titleText, R.color.cp_cont_b);
            ap.setBackgroundColor(aVar.dzk, R.color.cp_bg_line_d);
        }
    }

    public void d(ab abVar) {
        this.iAF = abVar;
    }

    public void setData(List<q> list) {
        this.mData = list;
        notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.frs.d.d
    public com.baidu.tieba.frs.d.b getStatisticMetaData() {
        return this.icR;
    }

    /* loaded from: classes16.dex */
    public class a {
        View dzk;
        int position;
        TextView titleText;

        public a() {
        }
    }

    /* loaded from: classes16.dex */
    public class b extends a {
        TextView iAL;
        TextView iAM;

        public b() {
            super();
        }
    }

    /* loaded from: classes16.dex */
    public class c extends a {
        TbImageView Zn;
        TextView iAL;
        TextView iAM;

        public c() {
            super();
        }
    }

    private void a(b bVar, bw bwVar, int i) {
        if (bVar != null && bwVar != null) {
            bVar.iAL.setText(TbadkCoreApplication.getInst().getString(R.string.top));
            bVar.iAL.setTextColor(this.iAG);
            bwVar.bfD();
            SpannableStringBuilder bfo = bwVar.bfo();
            if ((bfo == null || at.isEmptyStringAfterTrim(bfo.toString())) && bwVar.bef() != null) {
                bfo = new SpannableStringBuilder(bwVar.bef());
            }
            bVar.titleText.setOnTouchListener(new i(bfo));
            bVar.titleText.setText(bfo);
            bVar.dzk.setOnClickListener(this.evS);
            a(bVar);
        }
    }

    private void a(c cVar, q qVar) {
        if (cVar != null && qVar != null) {
            if (qVar instanceof bw) {
                bw bwVar = (bw) qVar;
                bwVar.bfD();
                SpannableStringBuilder bfo = bwVar.bfo();
                if ((bfo == null || at.isEmptyStringAfterTrim(bfo.toString())) && bwVar.bef() != null) {
                    bfo = new SpannableStringBuilder(bwVar.bef());
                }
                cVar.iAL.setText(TbadkCoreApplication.getInst().getString(R.string.top));
                cVar.titleText.setOnTouchListener(new i(bfo));
                cVar.titleText.setText(bfo);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.Zn.setVisibility(8);
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) cVar.iAL.getLayoutParams();
                    layoutParams.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds56), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                } else {
                    cVar.Zn.setVisibility(0);
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) cVar.iAL.getLayoutParams();
                    layoutParams2.setMargins((int) this.mContext.getResources().getDimension(R.dimen.tbds26), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
                    cVar.Zn.startLoad(this.imageUrl, 10, false);
                }
                cVar.iAL.setTextColor(this.iAG);
                cVar.dzk.setOnClickListener(this.evS);
                a(cVar);
            } else if (qVar instanceof k) {
                k kVar = (k) qVar;
                String a2 = a(kVar);
                if (StringUtils.isNull(this.imageUrl)) {
                    cVar.iAL.setText(a2);
                    cVar.iAL.setVisibility(0);
                    cVar.titleText.setText(kVar.getTitle());
                    cVar.Zn.setVisibility(8);
                } else {
                    cVar.iAL.setVisibility(8);
                    cVar.Zn.setVisibility(0);
                    cVar.titleText.setText(a2 + "：" + kVar.getTitle());
                    cVar.Zn.startLoad(this.imageUrl, 10, false);
                }
                if (kVar.dvS() != 0) {
                    cVar.iAM.setVisibility(0);
                    if (kVar.dvS() == -1) {
                        cVar.iAM.setText(this.mContext.getString(R.string.no_rank));
                    } else if (kVar.dvS() > 999) {
                        cVar.iAM.setText(this.mContext.getString(R.string.rang_orer_thousand));
                    } else {
                        cVar.iAM.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dvS()));
                    }
                    if (!StringUtils.isNull(kVar.getTitle())) {
                        cVar.titleText.setText(kVar.getTitle());
                    }
                } else {
                    cVar.iAM.setVisibility(8);
                }
                cVar.iAL.setTextColor(this.iAG);
                a(cVar);
                cVar.titleText.setTag(kVar);
                if (this.iAI != null) {
                    cVar.dzk.setOnClickListener(this.iAI);
                }
                if (this.iyF != null && this.iyF.add(kVar.dvU())) {
                    a.C0808a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dvU(), this.mForumId, this.mForumName, null);
                    b2.fT(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
                    b2.save();
                }
            }
        }
    }

    private void a(b bVar, k kVar) {
        String a2 = a(kVar);
        bVar.titleText.setText(kVar.getTitle());
        bVar.iAL.setText(a2);
        bVar.iAL.setTextColor(this.iAG);
        if (kVar.dvS() != 0) {
            bVar.iAM.setVisibility(0);
            if (kVar.dvS() == -1) {
                bVar.iAM.setText(this.mContext.getString(R.string.no_rank));
            } else if (kVar.dvS() > 999) {
                bVar.iAM.setText(this.mContext.getString(R.string.rang_orer_thousand));
            } else {
                bVar.iAM.setText(this.mContext.getString(R.string.rang_identify) + String.valueOf(kVar.dvS()));
            }
            if (!StringUtils.isNull(kVar.getTitle())) {
                bVar.titleText.setText(kVar.getTitle());
            }
        } else {
            bVar.iAM.setVisibility(8);
        }
        a(bVar);
        bVar.titleText.setTag(kVar);
        if (this.iAI != null) {
            bVar.dzk.setOnClickListener(this.iAI);
        }
        if (this.iyF != null && this.iyF.add(kVar.dvU())) {
            a.C0808a b2 = com.baidu.tieba.tbadkCore.d.a.b("ad_tpoint", "PT", "FRS", "c0128", "ad_plat", "VIEW_TRUE", kVar.dvU(), this.mForumId, this.mForumName, null);
            b2.fT(TiebaInitialize.Params.OBJ_URL, kVar.getUrl());
            b2.save();
        }
    }

    private boolean a(final b bVar, int i) {
        if (this.iAE == null || at.isEmpty(this.iAE.getRiskTipNotice()) || i != 0) {
            return false;
        }
        bVar.iAL.setText(TbadkCoreApplication.getInst().getString(R.string.risk_notice_title));
        bVar.iAL.setTextColor(this.iAG);
        bVar.titleText.setText(this.iAE.getRiskTipNotice());
        bVar.titleText.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.g.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bVar.titleText.getLayout().getEllipsisCount(bVar.titleText.getLineCount() - 1) > 0) {
                    g.this.b(g.this.iAE);
                }
            }
        });
        a(bVar);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(ForumData forumData) {
        if (!at.isEmpty(forumData.getRiskTipPop()) && !at.isEmpty(forumData.getRiskTipPopTitle())) {
            final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((BaseFragmentActivity) this.mContext);
            aVar.zz(forumData.getRiskTipPopTitle());
            aVar.setTitleShowCenter(true);
            aVar.zA(forumData.getRiskTipPop());
            aVar.a(R.string.frs_risk_dialog_button_text, new a.b() { // from class: com.baidu.tieba.frs.view.g.4
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                    aVar.dismiss();
                }
            });
            aVar.b(getTbPageContext()).bhg();
        }
    }

    private String a(k kVar) {
        if (TextUtils.isEmpty(kVar.dvV()) || kVar.dvV().trim().length() == 0) {
            if (kVar.dvR() == 1) {
                return TbadkCoreApplication.getInst().getString(R.string.thread_recruit);
            }
            return TbadkCoreApplication.getInst().getString(R.string.top_announcement);
        }
        return kVar.dvV();
    }

    public TbPageContext getTbPageContext() {
        if (this.mContext instanceof BaseFragmentActivity) {
            return ((BaseFragmentActivity) this.mContext).getPageContext();
        }
        return null;
    }

    public void eK(String str, String str2) {
        this.mForumId = str;
        this.mForumName = str2;
    }

    public void a(ForumData forumData) {
        this.iAE = forumData;
    }

    public void setBdUniqueId(BdUniqueId bdUniqueId) {
        this.mBdUniqueId = bdUniqueId;
    }

    public void zn(int i) {
        this.iAG = i;
    }

    public void setImageUrl(String str) {
        this.imageUrl = str;
    }
}
