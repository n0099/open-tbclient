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
    private HTypeListView aYu;
    private CardGroupDividerView bKR;
    private View bKS;
    private e bKT;
    private String bKU;
    private CardHListViewData bKV;
    private TbPageContext<?> mF;
    private int mSkinType;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mF = tbPageContext;
        this.bKR = (CardGroupDividerView) getView().findViewById(d.h.header_divider);
        this.bKS = getView().findViewById(d.h.card_bottom_divider);
        this.aYu = (HTypeListView) getView().findViewById(d.h.hlistview);
        this.aYu.setHeaderDividersEnabled(false);
        this.aYu.setFooterDividersEnabled(false);
        this.aYu.setSelector(d.g.list_selector_transparent);
        this.bKR.c(0, com.baidu.adp.lib.util.k.f(this.mF.getPageActivity(), d.f.ds28));
        this.bKU = this.mF.getString(d.l.frs_guess_like);
        this.bKR.B(this.bKU, true);
        this.bKT = new e(tbPageContext, this.aYu);
    }

    @Override // com.baidu.tieba.card.a
    public void b(x<CardHListViewData> xVar) {
        super.b(xVar);
        this.bKT.b(xVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.e.cp_bg_line_d);
            aj.k(this.bKS, d.e.cp_bg_line_c);
            if (this.bKR != null) {
                this.bKR.onChangeSkinType();
            }
            if (this.bKT != null) {
                this.bKT.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.j.card_hlistview_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.bKR != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bKR.B(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bKU, true);
                } else {
                    this.bKR.YI();
                }
            }
            if (this.bKS != null) {
                this.bKS.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bKT != null) {
                this.bKT.setDatas(aj(cardHListViewData.getDataList()));
                if (this.bKV != cardHListViewData) {
                    this.bKV = cardHListViewData;
                    this.aYu.setSelection(0);
                }
            }
            d(this.mF, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> aj(List<com.baidu.adp.widget.ListView.f> list) {
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
        private HTypeListView aYu;
        private c bKZ;
        private a bLa;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.aYu = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bKZ = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bLa = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.bKZ);
            this.mAdapters.add(this.bLa);
            this.aYu.addAdapters(this.mAdapters);
        }

        public void b(x<CardHListViewData> xVar) {
            this.bKZ.b(xVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
            if (this.aYu != null) {
                this.aYu.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.aYu.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.aYu.getChildAt(i2);
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
        private x<CardHListViewData> bHZ;
        private View.OnClickListener mOnClickListener;

        public void b(x<CardHListViewData> xVar) {
            this.bHZ = xVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bHZ != null) {
                        if (view.getId() == d.h.hlistview_item_layout_root) {
                            if (view.getTag(d.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                                c.this.bHZ.a(view, null, (CardHListViewNormalItemData) view.getTag(d.h.hlistview_item_layout_root));
                            }
                        } else if (view.getId() == d.h.fourm_name && (view.getTag(d.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                            c.this.bHZ.a(view, null, (CardHListViewNormalItemData) view.getTag(d.h.fourm_name));
                        }
                    }
                }
            };
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: B */
        public d onCreateViewHolder(ViewGroup viewGroup) {
            return new d(LayoutInflater.from(this.mContext).inflate(d.j.card_hlistview_normal_item, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewNormalItemData cardHListViewNormalItemData, d dVar) {
            if (dVar == null || cardHListViewNormalItemData == null) {
                return null;
            }
            dVar.bKY.setClickable(false);
            dVar.bKY.c(cardHListViewNormalItemData.recomCover, 10, false);
            c(dVar.bJS, cardHListViewNormalItemData.title);
            b(dVar.bJT, cardHListViewNormalItemData.forumName);
            c(dVar.anE, cardHListViewNormalItemData.replyNum);
            dVar.bJT.setTag(d.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(d.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bJT.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String u = am.u(j);
                    textView.setText(String.format(this.mContext.getString(d.l.reply_num_tip), u));
                    textView.setContentDescription(this.mContext.getString(d.l.reply_num) + u);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void b(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                String string = this.mContext.getString(d.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 5, true));
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
        public TextView anE;
        public TextView bJS;
        public TextView bJT;
        public TbImageView bKY;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(d.h.hlistview_item_layout_root);
            this.bJS = (TextView) view.findViewById(d.h.text_title);
            this.bJT = (TextView) view.findViewById(d.h.fourm_name);
            this.anE = (TextView) view.findViewById(d.h.thread_commont_num);
            this.bKY = (TbImageView) view.findViewById(d.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.e.cp_bg_line_d);
                aj.i(this.bJS, d.e.cp_cont_b);
                aj.i(this.bJT, d.e.cp_cont_c);
                aj.i(this.anE, d.e.cp_cont_c);
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
        /* renamed from: A */
        public b onCreateViewHolder(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.card_hlistview_interval_item, viewGroup, false);
            int f = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds420);
            int f2 = com.baidu.adp.lib.util.k.f(this.mContext, d.f.ds12);
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
        public View bKW;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bKW = view.findViewById(d.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
