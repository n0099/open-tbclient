package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.z;
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
    private TbPageContext<?> ajP;
    private CardGroupDividerView bBg;
    private View bBh;
    private HTypeListView bBi;
    private e bBj;
    private String bBk;
    private CardHListViewData bBl;
    private int mSkinType;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajP = tbPageContext;
        this.bBg = (CardGroupDividerView) getView().findViewById(w.h.header_divider);
        this.bBh = getView().findViewById(w.h.card_bottom_divider);
        this.bBi = (HTypeListView) getView().findViewById(w.h.hlistview);
        this.bBi.setHeaderDividersEnabled(false);
        this.bBi.setFooterDividersEnabled(false);
        this.bBi.setSelector(w.g.list_selector_transparent);
        this.bBg.d(0, com.baidu.adp.lib.util.k.g(this.ajP.getPageActivity(), w.f.ds28));
        this.bBk = this.ajP.getString(w.l.frs_guess_like);
        this.bBg.A(this.bBk, true);
        this.bBj = new e(tbPageContext, this.bBi);
    }

    @Override // com.baidu.tieba.card.a
    public void a(ci<CardHListViewData> ciVar) {
        super.a(ciVar);
        this.bBj.a(ciVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.as.k(this.bBh, w.e.cp_bg_line_c);
            if (this.bBg != null) {
                this.bBg.onChangeSkinType();
            }
            if (this.bBj != null) {
                this.bBj.onChangeSkinType(i);
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
    public void a(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.bBg != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bBg.A(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bBk, true);
                } else {
                    this.bBg.Wo();
                }
            }
            if (this.bBh != null) {
                this.bBh.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bBj != null) {
                this.bBj.setDatas(ad(cardHListViewData.getDataList()));
                if (this.bBl != cardHListViewData) {
                    this.bBl = cardHListViewData;
                    this.bBi.setSelection(0);
                }
            }
            d(this.ajP, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> ad(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.z.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.z.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.z.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView bBi;
        private c bBp;
        private a bBq;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bBi = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bBp = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bBq = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.bBp);
            this.mAdapters.add(this.bBq);
            this.bBi.addAdapters(this.mAdapters);
        }

        public void a(ci<CardHListViewData> ciVar) {
            this.bBp.a(ciVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.bBi != null) {
                this.bBi.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bBi.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bBi.getChildAt(i2);
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
        private ci<CardHListViewData> byn;
        private View.OnClickListener mOnClickListener;

        public void a(ci<CardHListViewData> ciVar) {
            this.byn = ciVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new s(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: p */
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
            dVar.bBo.setClickable(false);
            dVar.bBo.c(cardHListViewNormalItemData.recomCover, 10, false);
            d(dVar.bAg, cardHListViewNormalItemData.title);
            c(dVar.bAh, cardHListViewNormalItemData.forumName);
            c(dVar.amm, cardHListViewNormalItemData.replyNum);
            dVar.bAh.setTag(w.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(w.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bAh.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String t = com.baidu.tbadk.core.util.aw.t(j);
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
    public static class d extends z.a {
        public TextView amm;
        public TextView bAg;
        public TextView bAh;
        public TbImageView bBo;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(w.h.hlistview_item_layout_root);
            this.bAg = (TextView) view.findViewById(w.h.text_title);
            this.bAh = (TextView) view.findViewById(w.h.fourm_name);
            this.amm = (TextView) view.findViewById(w.h.thread_commont_num);
            this.bBo = (TbImageView) view.findViewById(w.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.as.i(this.bAg, w.e.cp_cont_b);
                com.baidu.tbadk.core.util.as.i(this.bAh, w.e.cp_cont_c);
                com.baidu.tbadk.core.util.as.i(this.amm, w.e.cp_cont_c);
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
        /* renamed from: o */
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
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.j jVar, b bVar) {
            if (jVar != null && bVar != null) {
                bVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends z.a {
        public View bBm;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bBm = view.findViewById(w.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.as.k(getView(), w.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
