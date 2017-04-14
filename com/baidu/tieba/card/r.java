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
    private TbPageContext<?> ajT;
    private CardGroupDividerView bsk;
    private View bsl;
    private HTypeListView bsm;
    private e bsn;
    private String bso;
    private CardHListViewData bsp;
    private int mSkinType;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajT = tbPageContext;
        this.bsk = (CardGroupDividerView) getView().findViewById(w.h.header_divider);
        this.bsl = getView().findViewById(w.h.card_bottom_divider);
        this.bsm = (HTypeListView) getView().findViewById(w.h.hlistview);
        this.bsm.setHeaderDividersEnabled(false);
        this.bsm.setFooterDividersEnabled(false);
        this.bsm.setSelector(w.g.list_selector_transparent);
        this.bsk.d(0, com.baidu.adp.lib.util.k.g(this.ajT.getPageActivity(), w.f.ds28));
        this.bso = this.ajT.getString(w.l.frs_guess_like);
        this.bsk.B(this.bso, true);
        this.bsn = new e(tbPageContext, this.bsm);
    }

    @Override // com.baidu.tieba.card.a
    public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
        super.setOnSubCardOnClickListenner(cfVar);
        this.bsn.setOnSubCardOnClickListenner(cfVar);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.bsl, w.e.cp_bg_line_c);
            if (this.bsk != null) {
                this.bsk.onChangeSkinType();
            }
            if (this.bsn != null) {
                this.bsn.onChangeSkinType(i);
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
            if (this.bsk != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bsk.B(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bso, true);
                } else {
                    this.bsk.Ty();
                }
            }
            if (this.bsl != null) {
                this.bsl.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bsn != null) {
                this.bsn.setDatas(W(cardHListViewData.getDataList()));
                if (this.bsp != cardHListViewData) {
                    this.bsp = cardHListViewData;
                    this.bsm.setSelection(0);
                }
            }
            onChangeSkinType(this.ajT, TbadkCoreApplication.m9getInst().getSkinType());
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
        private HTypeListView bsm;
        private c bsu;
        private a bsv;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bsm = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bsu = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bsv = new a(this.mTbPageContext, com.baidu.tieba.card.data.l.TYPE);
            this.mAdapters.add(this.bsu);
            this.mAdapters.add(this.bsv);
            this.bsm.addAdapters(this.mAdapters);
        }

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.bsu.setOnSubCardOnClickListenner(cfVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.bsm != null) {
                this.bsm.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bsm.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bsm.getChildAt(i2);
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
        private cf<CardHListViewData> bqY;
        private View.OnClickListener mOnClickListener;

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.bqY = cfVar;
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
            dVar.bst.setClickable(false);
            dVar.bst.c(cardHListViewNormalItemData.recomCover, 10, false);
            d(dVar.aRU, cardHListViewNormalItemData.title);
            c(dVar.bss, cardHListViewNormalItemData.forumName);
            c(dVar.alM, cardHListViewNormalItemData.replyNum);
            dVar.bss.setTag(w.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(w.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bss.setOnClickListener(this.mOnClickListener);
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

        private void c(TextView textView, String str) {
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

        private void d(TextView textView, String str) {
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
        public TextView aRU;
        public TextView alM;
        public TextView bss;
        public TbImageView bst;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(w.h.hlistview_item_layout_root);
            this.aRU = (TextView) view.findViewById(w.h.text_title);
            this.bss = (TextView) view.findViewById(w.h.fourm_name);
            this.alM = (TextView) view.findViewById(w.h.thread_commont_num);
            this.bst = (TbImageView) view.findViewById(w.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.i(this.aRU, w.e.cp_cont_b);
                com.baidu.tbadk.core.util.aq.i(this.bss, w.e.cp_cont_c);
                com.baidu.tbadk.core.util.aq.i(this.alM, w.e.cp_cont_c);
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
        public View bsq;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bsq = view.findViewById(w.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
