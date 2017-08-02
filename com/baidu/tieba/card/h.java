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
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
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
    private HTypeListView aXy;
    private TbPageContext<?> ako;
    private CardGroupDividerView bFn;
    private View bFo;
    private e bFp;
    private String bFq;
    private CardHListViewData bFr;
    private int mSkinType;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ako = tbPageContext;
        this.bFn = (CardGroupDividerView) getView().findViewById(d.h.header_divider);
        this.bFo = getView().findViewById(d.h.card_bottom_divider);
        this.aXy = (HTypeListView) getView().findViewById(d.h.hlistview);
        this.aXy.setHeaderDividersEnabled(false);
        this.aXy.setFooterDividersEnabled(false);
        this.aXy.setSelector(d.g.list_selector_transparent);
        this.bFn.d(0, com.baidu.adp.lib.util.k.g(this.ako.getPageActivity(), d.f.ds28));
        this.bFq = this.ako.getString(d.l.frs_guess_like);
        this.bFn.A(this.bFq, true);
        this.bFp = new e(tbPageContext, this.aXy);
    }

    @Override // com.baidu.tieba.card.a
    public void a(x<CardHListViewData> xVar) {
        super.a(xVar);
        this.bFp.a(xVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(getView(), d.e.cp_bg_line_d);
            ai.k(this.bFo, d.e.cp_bg_line_c);
            if (this.bFn != null) {
                this.bFn.onChangeSkinType();
            }
            if (this.bFp != null) {
                this.bFp.onChangeSkinType(i);
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
            if (this.bFn != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bFn.A(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bFq, true);
                } else {
                    this.bFn.WW();
                }
            }
            if (this.bFo != null) {
                this.bFo.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bFp != null) {
                this.bFp.setDatas(aj(cardHListViewData.getDataList()));
                if (this.bFr != cardHListViewData) {
                    this.bFr = cardHListViewData;
                    this.aXy.setSelection(0);
                }
            }
            d(this.ako, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> aj(List<com.baidu.adp.widget.ListView.f> list) {
        if (com.baidu.tbadk.core.util.u.u(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.u.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.u.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView aXy;
        private c bFv;
        private a bFw;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.aXy = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bFv = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bFw = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.bFv);
            this.mAdapters.add(this.bFw);
            this.aXy.addAdapters(this.mAdapters);
        }

        public void a(x<CardHListViewData> xVar) {
            this.bFv.a(xVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
            if (this.aXy != null) {
                this.aXy.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.aXy.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.aXy.getChildAt(i2);
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
        private x<CardHListViewData> bCu;
        private View.OnClickListener mOnClickListener;

        public void a(x<CardHListViewData> xVar) {
            this.bCu = xVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bCu != null) {
                        if (view.getId() == d.h.hlistview_item_layout_root) {
                            if (view.getTag(d.h.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                                c.this.bCu.a(view, null, (CardHListViewNormalItemData) view.getTag(d.h.hlistview_item_layout_root));
                            }
                        } else if (view.getId() == d.h.fourm_name && (view.getTag(d.h.fourm_name) instanceof CardHListViewNormalItemData)) {
                            c.this.bCu.a(view, null, (CardHListViewNormalItemData) view.getTag(d.h.fourm_name));
                        }
                    }
                }
            };
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: y */
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
            dVar.bFu.setClickable(false);
            dVar.bFu.c(cardHListViewNormalItemData.recomCover, 10, false);
            d(dVar.bEn, cardHListViewNormalItemData.title);
            c(dVar.bEo, cardHListViewNormalItemData.forumName);
            c(dVar.amS, cardHListViewNormalItemData.replyNum);
            dVar.bEo.setTag(d.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(d.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bEo.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String u = al.u(j);
                    textView.setText(String.format(this.mContext.getString(d.l.reply_num_tip), u));
                    textView.setContentDescription(this.mContext.getString(d.l.reply_num) + u);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void c(TextView textView, String str) {
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
    public static class d extends j.a {
        public TextView amS;
        public TextView bEn;
        public TextView bEo;
        public TbImageView bFu;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(d.h.hlistview_item_layout_root);
            this.bEn = (TextView) view.findViewById(d.h.text_title);
            this.bEo = (TextView) view.findViewById(d.h.fourm_name);
            this.amS = (TextView) view.findViewById(d.h.thread_commont_num);
            this.bFu = (TbImageView) view.findViewById(d.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                ai.i(this.bEn, d.e.cp_cont_b);
                ai.i(this.bEo, d.e.cp_cont_c);
                ai.i(this.amS, d.e.cp_cont_c);
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
        /* renamed from: x */
        public b onCreateViewHolder(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.j.card_hlistview_interval_item, viewGroup, false);
            int g = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds420);
            int g2 = com.baidu.adp.lib.util.k.g(this.mContext, d.f.ds12);
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
                bVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends j.a {
        public View bFs;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bFs = view.findViewById(d.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
