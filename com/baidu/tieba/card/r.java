package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.card.data.CardHListViewData;
import com.baidu.tieba.card.data.CardHListViewNormalItemData;
import com.baidu.tieba.card.divider.CardGroupDividerView;
import com.baidu.tieba.horizonalList.widget.HTypeListView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.card.a<CardHListViewData> {
    private TbPageContext<?> ajF;
    private CardGroupDividerView bss;
    private View bst;
    private HTypeListView bsu;
    private e bsv;
    private String bsw;
    private CardHListViewData bsx;
    private int mSkinType;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajF = tbPageContext;
        this.bss = (CardGroupDividerView) getView().findViewById(w.h.header_divider);
        this.bst = getView().findViewById(w.h.card_bottom_divider);
        this.bsu = (HTypeListView) getView().findViewById(w.h.hlistview);
        this.bsu.setHeaderDividersEnabled(false);
        this.bsu.setFooterDividersEnabled(false);
        this.bsu.setSelector(w.g.list_selector_transparent);
        this.bss.d(0, com.baidu.adp.lib.util.k.g(this.ajF.getPageActivity(), w.f.ds28));
        this.bsw = this.ajF.getString(w.l.frs_guess_like_title);
        this.bss.B(this.bsw, true);
        this.bsv = new e(tbPageContext, this.bsu);
    }

    @Override // com.baidu.tieba.card.a
    public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
        super.setOnSubCardOnClickListenner(cfVar);
        this.bsv.setOnSubCardOnClickListenner(cfVar);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.bst, w.e.cp_bg_line_c);
            if (this.bss != null) {
                this.bss.tD();
            }
            if (this.bsv != null) {
                this.bsv.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return w.j.card_hlistview_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.bss != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bss.B(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bsw, true);
                } else {
                    this.bss.Ta();
                }
            }
            if (this.bst != null) {
                this.bst.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bsv != null) {
                this.bsv.setDatas(W(cardHListViewData.getDataList()));
                if (this.bsx != cardHListViewData) {
                    this.bsx = cardHListViewData;
                    this.bsu.setSelection(0);
                }
            }
            onChangeSkinType(this.ajF, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> W(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.p(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.x.a(arrayList, 0, new com.baidu.tieba.card.data.l());
            com.baidu.tbadk.core.util.x.b(arrayList, new com.baidu.tieba.card.data.l());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private c bsC;
        private a bsD;
        private HTypeListView bsu;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bsu = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bsC = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bsD = new a(this.mTbPageContext, com.baidu.tieba.card.data.l.TYPE);
            this.mAdapters.add(this.bsC);
            this.mAdapters.add(this.bsD);
            this.bsu.addAdapters(this.mAdapters);
        }

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.bsC.setOnSubCardOnClickListenner(cfVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.bsu != null) {
                this.bsu.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bsu.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bsu.getChildAt(i2);
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
        private cf<CardHListViewData> brg;
        private View.OnClickListener mOnClickListener;

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.brg = cfVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new s(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: j */
        public d onCreateViewHolder(ViewGroup viewGroup) {
            return new d(LayoutInflater.from(this.mContext).inflate(w.j.card_hlistview_normal_item, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewNormalItemData cardHListViewNormalItemData, d dVar) {
            if (dVar == null || cardHListViewNormalItemData == null) {
                return null;
            }
            dVar.bsB.setClickable(false);
            dVar.bsB.c(cardHListViewNormalItemData.recomCover, 10, false);
            e(dVar.aRE, cardHListViewNormalItemData.title);
            d(dVar.bsA, cardHListViewNormalItemData.forumName);
            c(dVar.aly, cardHListViewNormalItemData.replyNum);
            dVar.bsA.setTag(w.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(w.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bsA.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String t = com.baidu.tbadk.core.util.au.t(j);
                    textView.setText(String.format(this.mContext.getString(w.l.reply_num_tip), t));
                    textView.setContentDescription(String.valueOf(this.mContext.getString(w.l.reply_num)) + t);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void d(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                String string = this.mContext.getString(w.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 5, true));
                textView.setText(string);
                textView.setContentDescription(string);
                textView.setClickable(true);
                return;
            }
            textView.setVisibility(8);
        }

        private void e(TextView textView, String str) {
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
    public static class d extends y.a {
        public TextView aRE;
        public TextView aly;
        public TextView bsA;
        public TbImageView bsB;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(w.h.hlistview_item_layout_root);
            this.aRE = (TextView) view.findViewById(w.h.text_title);
            this.bsA = (TextView) view.findViewById(w.h.fourm_name);
            this.aly = (TextView) view.findViewById(w.h.thread_commont_num);
            this.bsB = (TbImageView) view.findViewById(w.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.i((View) this.aRE, w.e.cp_cont_b);
                com.baidu.tbadk.core.util.aq.i((View) this.bsA, w.e.cp_cont_c);
                com.baidu.tbadk.core.util.aq.i((View) this.aly, w.e.cp_cont_c);
                this.mSkinType = i;
            }
        }
    }

    /* loaded from: classes.dex */
    public static class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.data.l, b> {
        public a(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: i */
        public b onCreateViewHolder(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(w.j.card_hlistview_interval_item, viewGroup, false);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds420);
            int g2 = com.baidu.adp.lib.util.k.g(this.mContext, w.f.ds12);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            layoutParams.height = g;
            layoutParams.width = g2;
            inflate.setLayoutParams(layoutParams);
            inflate.setEnabled(false);
            return new b(inflate);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, b bVar) {
            if (lVar != null && bVar != null) {
                bVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends y.a {
        public View bsy;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bsy = view.findViewById(w.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
