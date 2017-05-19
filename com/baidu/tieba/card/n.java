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
public class n extends com.baidu.tieba.card.a<CardHListViewData> {
    private TbPageContext<?> ajr;
    private CardGroupDividerView buA;
    private View buB;
    private HTypeListView buC;
    private e buD;
    private String buE;
    private CardHListViewData buF;
    private int mSkinType;

    public n(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ajr = tbPageContext;
        this.buA = (CardGroupDividerView) getView().findViewById(w.h.header_divider);
        this.buB = getView().findViewById(w.h.card_bottom_divider);
        this.buC = (HTypeListView) getView().findViewById(w.h.hlistview);
        this.buC.setHeaderDividersEnabled(false);
        this.buC.setFooterDividersEnabled(false);
        this.buC.setSelector(w.g.list_selector_transparent);
        this.buA.d(0, com.baidu.adp.lib.util.k.g(this.ajr.getPageActivity(), w.f.ds28));
        this.buE = this.ajr.getString(w.l.frs_guess_like);
        this.buA.B(this.buE, true);
        this.buD = new e(tbPageContext, this.buC);
    }

    @Override // com.baidu.tieba.card.a
    public void setOnSubCardOnClickListenner(cd<CardHListViewData> cdVar) {
        super.setOnSubCardOnClickListenner(cdVar);
        this.buD.setOnSubCardOnClickListenner(cdVar);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.aq.k(this.buB, w.e.cp_bg_line_c);
            if (this.buA != null) {
                this.buA.onChangeSkinType();
            }
            if (this.buD != null) {
                this.buD.onChangeSkinType(i);
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
            if (this.buA != null) {
                if (cardHListViewData.showTopDivider) {
                    this.buA.B(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.buE, true);
                } else {
                    this.buA.TT();
                }
            }
            if (this.buB != null) {
                this.buB.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.buD != null) {
                this.buD.setDatas(Z(cardHListViewData.getDataList()));
                if (this.buF != cardHListViewData) {
                    this.buF = cardHListViewData;
                    this.buC.setSelection(0);
                }
            }
            onChangeSkinType(this.ajr, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> Z(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.q(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.x.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.x.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView buC;
        private c buK;
        private a buL;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.buC = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.buK = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.buL = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.buK);
            this.mAdapters.add(this.buL);
            this.buC.addAdapters(this.mAdapters);
        }

        public void setOnSubCardOnClickListenner(cd<CardHListViewData> cdVar) {
            this.buK.setOnSubCardOnClickListenner(cdVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.buC != null) {
                this.buC.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.buC.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.buC.getChildAt(i2);
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
        private cd<CardHListViewData> btJ;
        private View.OnClickListener mOnClickListener;

        public void setOnSubCardOnClickListenner(cd<CardHListViewData> cdVar) {
            this.btJ = cdVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new o(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: l */
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
            dVar.buJ.setClickable(false);
            dVar.buJ.c(cardHListViewNormalItemData.recomCover, 10, false);
            d(dVar.aSr, cardHListViewNormalItemData.title);
            c(dVar.buI, cardHListViewNormalItemData.forumName);
            c(dVar.alI, cardHListViewNormalItemData.replyNum);
            dVar.buI.setTag(w.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(w.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.buI.setOnClickListener(this.mOnClickListener);
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
        public TextView aSr;
        public TextView alI;
        public TextView buI;
        public TbImageView buJ;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(w.h.hlistview_item_layout_root);
            this.aSr = (TextView) view.findViewById(w.h.text_title);
            this.buI = (TextView) view.findViewById(w.h.fourm_name);
            this.alI = (TextView) view.findViewById(w.h.thread_commont_num);
            this.buJ = (TbImageView) view.findViewById(w.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.aq.i(this.aSr, w.e.cp_cont_b);
                com.baidu.tbadk.core.util.aq.i(this.buI, w.e.cp_cont_c);
                com.baidu.tbadk.core.util.aq.i(this.alI, w.e.cp_cont_c);
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
        /* renamed from: k */
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
    public static class b extends y.a {
        public View buG;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.buG = view.findViewById(w.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.aq.k(getView(), w.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
