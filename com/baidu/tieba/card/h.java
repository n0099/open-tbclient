package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.d;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class h extends com.baidu.tieba.card.a<CardHListViewData> {
    private e bRA;
    private String bRB;
    private CardHListViewData bRC;
    private CardGroupDividerView bRy;
    private View bRz;
    private HTypeListView bak;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.bRy = (CardGroupDividerView) getView().findViewById(d.g.header_divider);
        this.bRz = getView().findViewById(d.g.card_bottom_divider);
        this.bak = (HTypeListView) getView().findViewById(d.g.hlistview);
        this.bak.setHeaderDividersEnabled(false);
        this.bak.setFooterDividersEnabled(false);
        this.bak.setSelector(d.f.list_selector_transparent);
        this.bRy.d(0, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds28));
        this.bRB = this.mPageContext.getString(d.j.frs_guess_like);
        this.bRy.w(this.bRB, true);
        this.bRA = new e(tbPageContext, this.bak);
    }

    @Override // com.baidu.tieba.card.a
    public void b(x<CardHListViewData> xVar) {
        super.b(xVar);
        this.bRA.b(xVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0080d.cp_bg_line_d);
            aj.k(this.bRz, d.C0080d.cp_bg_line_c);
            if (this.bRy != null) {
                this.bRy.onChangeSkinType();
            }
            if (this.bRA != null) {
                this.bRA.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.card_hlistview_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.bRy != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bRy.w(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bRB, true);
                } else {
                    this.bRy.aaw();
                }
            }
            if (this.bRz != null) {
                this.bRz.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bRA != null) {
                this.bRA.setDatas(ak(cardHListViewData.getDataList()));
                if (this.bRC != cardHListViewData) {
                    this.bRC = cardHListViewData;
                    this.bak.setSelection(0);
                }
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> ak(List<com.baidu.adp.widget.ListView.f> list) {
        if (com.baidu.tbadk.core.util.v.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.v.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.v.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private c bRI;
        private a bRJ;
        private HTypeListView bak;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bak = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bRI = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bRJ = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.bRI);
            this.mAdapters.add(this.bRJ);
            this.bak.addAdapters(this.mAdapters);
        }

        public void b(x<CardHListViewData> xVar) {
            this.bRI.b(xVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
            if (this.bak != null) {
                this.bak.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bak.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bak.getChildAt(i2);
                    if (childAt != null) {
                        if (childAt.getTag() instanceof d) {
                            ((d) childAt.getTag()).onChangeSkinType(i);
                        } else if (childAt.getTag() instanceof b) {
                            ((b) childAt.getTag()).onChangeSkinType(i);
                        }
                    }
                }
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class c extends com.baidu.adp.widget.ListView.a<CardHListViewNormalItemData, d> {
        private x<CardHListViewData> bQC;
        private View.OnClickListener mOnClickListener;

        public void b(x<CardHListViewData> xVar) {
            this.bQC = xVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bQC != null) {
                        if (view.getId() == d.g.hlistview_item_layout_root) {
                            if (view.getTag(d.g.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                                c.this.bQC.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.hlistview_item_layout_root));
                            }
                        } else if (view.getId() == d.g.fourm_name && (view.getTag(d.g.fourm_name) instanceof CardHListViewNormalItemData)) {
                            c.this.bQC.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.fourm_name));
                        }
                    }
                }
            };
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: R */
        public d onCreateViewHolder(ViewGroup viewGroup) {
            return new d(LayoutInflater.from(this.mContext).inflate(d.h.card_hlistview_normal_item, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewNormalItemData cardHListViewNormalItemData, d dVar) {
            if (dVar == null || cardHListViewNormalItemData == null) {
                return null;
            }
            dVar.bRH.setClickable(false);
            dVar.bRH.startLoad(cardHListViewNormalItemData.recomCover, 10, false);
            c(dVar.bRF, cardHListViewNormalItemData.title);
            b(dVar.bRG, cardHListViewNormalItemData.forumName);
            c(dVar.amX, cardHListViewNormalItemData.replyNum);
            dVar.bRG.setTag(d.g.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(d.g.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bRG.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String u = am.u(j);
                    textView.setText(String.format(this.mContext.getString(d.j.reply_num_tip), u));
                    textView.setContentDescription(this.mContext.getString(d.j.reply_num) + u);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void b(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                String string = this.mContext.getString(d.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 5, true));
                textView.setText(string);
                textView.setContentDescription(string);
                textView.setClickable(true);
                return;
            }
            textView.setVisibility(8);
        }

        private void c(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                textView.setText(str);
                textView.setContentDescription(str);
                textView.setClickable(false);
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* loaded from: classes.dex */
    public static class d extends j.a {
        public TextView amX;
        public TextView bRF;
        public TextView bRG;
        public TbImageView bRH;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(d.g.hlistview_item_layout_root);
            this.bRF = (TextView) view.findViewById(d.g.text_title);
            this.bRG = (TextView) view.findViewById(d.g.fourm_name);
            this.amX = (TextView) view.findViewById(d.g.thread_commont_num);
            this.bRH = (TbImageView) view.findViewById(d.g.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.C0080d.cp_bg_line_d);
                aj.i(this.bRF, d.C0080d.cp_cont_b);
                aj.i(this.bRG, d.C0080d.cp_cont_c);
                aj.i(this.amX, d.C0080d.cp_cont_c);
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.j, b> {
        public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: Q */
        public b onCreateViewHolder(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.card_hlistview_interval_item, viewGroup, false);
            int f = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds420);
            int f2 = com.baidu.adp.lib.util.l.f(this.mContext, d.e.ds12);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            layoutParams.height = f;
            layoutParams.width = f2;
            inflate.setLayoutParams(layoutParams);
            inflate.setEnabled(false);
            return new b(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, b bVar) {
            if (jVar != null && bVar != null) {
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends j.a {
        public View bRD;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bRD = view.findViewById(d.g.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.C0080d.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
