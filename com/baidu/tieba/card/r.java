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
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class r extends com.baidu.tieba.card.a<CardHListViewData> {
    private TbPageContext<?> FY;
    private View blA;
    private HTypeListView blB;
    private e blC;
    private String blD;
    private CardHListViewData blE;
    private CardGroupDividerView blz;
    private int mSkinType;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.FY = tbPageContext;
        this.blz = (CardGroupDividerView) getView().findViewById(r.h.header_divider);
        this.blA = getView().findViewById(r.h.card_bottom_divider);
        this.blB = (HTypeListView) getView().findViewById(r.h.hlistview);
        this.blB.setHeaderDividersEnabled(false);
        this.blB.setFooterDividersEnabled(false);
        this.blB.setSelector(r.g.list_selector_transparent);
        this.blz.d(0, com.baidu.adp.lib.util.k.e(this.FY.getPageActivity(), r.f.ds28));
        this.blD = this.FY.getString(r.l.frs_guess_like_title);
        this.blz.A(this.blD, true);
        this.blC = new e(tbPageContext, this.blB);
    }

    @Override // com.baidu.tieba.card.a
    public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
        super.setOnSubCardOnClickListenner(cfVar);
        this.blC.setOnSubCardOnClickListenner(cfVar);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
            com.baidu.tbadk.core.util.ap.k(this.blA, r.e.cp_bg_line_c);
            if (this.blz != null) {
                this.blz.tg();
            }
            if (this.blC != null) {
                this.blC.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.j.card_hlistview_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.blz != null) {
                if (cardHListViewData.showTopDivider) {
                    this.blz.A(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.blD, true);
                } else {
                    this.blz.Sc();
                }
            }
            if (this.blA != null) {
                this.blA.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.blC != null) {
                this.blC.setDatas(Z(cardHListViewData.getDataList()));
                if (this.blE != cardHListViewData) {
                    this.blE = cardHListViewData;
                    this.blB.setSelection(0);
                }
            }
            onChangeSkinType(this.FY, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> Z(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.w.r(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.w.a(arrayList, 0, new com.baidu.tieba.card.data.l());
            com.baidu.tbadk.core.util.w.b(arrayList, new com.baidu.tieba.card.data.l());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView blB;
        private c blJ;
        private a blK;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.blB = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.blJ = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.blK = new a(this.mTbPageContext, com.baidu.tieba.card.data.l.TYPE);
            this.mAdapters.add(this.blJ);
            this.mAdapters.add(this.blK);
            this.blB.addAdapters(this.mAdapters);
        }

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.blJ.setOnSubCardOnClickListenner(cfVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.blB != null) {
                this.blB.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.blB.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.blB.getChildAt(i2);
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
        private cf<CardHListViewData> bko;
        private View.OnClickListener mOnClickListener;

        public void setOnSubCardOnClickListenner(cf<CardHListViewData> cfVar) {
            this.bko = cfVar;
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
            return new d(LayoutInflater.from(this.mContext).inflate(r.j.card_hlistview_normal_item, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: a */
        public View onFillViewHolder(int i, View view, ViewGroup viewGroup, CardHListViewNormalItemData cardHListViewNormalItemData, d dVar) {
            if (dVar == null || cardHListViewNormalItemData == null) {
                return null;
            }
            dVar.blI.setClickable(false);
            dVar.blI.c(cardHListViewNormalItemData.recomCover, 10, false);
            f(dVar.aLR, cardHListViewNormalItemData.title);
            e(dVar.blH, cardHListViewNormalItemData.forumName);
            c(dVar.agg, cardHListViewNormalItemData.replyNum);
            dVar.blH.setTag(r.h.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(r.h.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.blH.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String u = com.baidu.tbadk.core.util.at.u(j);
                    textView.setText(String.format(this.mContext.getString(r.l.reply_num_tip), u));
                    textView.setContentDescription(String.valueOf(this.mContext.getString(r.l.reply_num)) + u);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void e(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                String string = this.mContext.getString(r.l.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 5, true));
                textView.setText(string);
                textView.setContentDescription(string);
                textView.setClickable(true);
                return;
            }
            textView.setVisibility(8);
        }

        private void f(TextView textView, String str) {
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
        public TextView aLR;
        public TextView agg;
        public TextView blH;
        public TbImageView blI;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(r.h.hlistview_item_layout_root);
            this.aLR = (TextView) view.findViewById(r.h.text_title);
            this.blH = (TextView) view.findViewById(r.h.fourm_name);
            this.agg = (TextView) view.findViewById(r.h.thread_commont_num);
            this.blI = (TbImageView) view.findViewById(r.h.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
                com.baidu.tbadk.core.util.ap.i((View) this.aLR, r.e.cp_cont_b);
                com.baidu.tbadk.core.util.ap.i((View) this.blH, r.e.cp_cont_c);
                com.baidu.tbadk.core.util.ap.i((View) this.agg, r.e.cp_cont_c);
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
            View inflate = LayoutInflater.from(this.mContext).inflate(r.j.card_hlistview_interval_item, viewGroup, false);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds420);
            int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.f.ds12);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            layoutParams.height = e;
            layoutParams.width = e2;
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
        public View blF;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.blF = view.findViewById(r.h.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.ap.k(getView(), r.e.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
