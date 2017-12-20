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
    private CardGroupDividerView bZN;
    private View bZO;
    private e bZP;
    private String bZQ;
    private CardHListViewData bZR;
    private HTypeListView bdE;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.bZN = (CardGroupDividerView) getView().findViewById(d.g.header_divider);
        this.bZO = getView().findViewById(d.g.card_bottom_divider);
        this.bdE = (HTypeListView) getView().findViewById(d.g.hlistview);
        this.bdE.setHeaderDividersEnabled(false);
        this.bdE.setFooterDividersEnabled(false);
        this.bdE.setSelector(d.f.list_selector_transparent);
        this.bZN.d(0, com.baidu.adp.lib.util.l.f(this.mPageContext.getPageActivity(), d.e.ds28));
        this.bZQ = this.mPageContext.getString(d.j.frs_guess_like);
        this.bZN.z(this.bZQ, true);
        this.bZP = new e(tbPageContext, this.bdE);
    }

    @Override // com.baidu.tieba.card.a
    public void b(v<CardHListViewData> vVar) {
        super.b(vVar);
        this.bZP.b(vVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.k(getView(), d.C0096d.cp_bg_line_d);
            aj.k(this.bZO, d.C0096d.cp_bg_line_c);
            if (this.bZN != null) {
                this.bZN.onChangeSkinType();
            }
            if (this.bZP != null) {
                this.bZP.onChangeSkinType(i);
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
            if (this.bZN != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bZN.z(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bZQ, true);
                } else {
                    this.bZN.acA();
                }
            }
            if (this.bZO != null) {
                this.bZO.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bZP != null) {
                this.bZP.setDatas(aw(cardHListViewData.getDataList()));
                if (this.bZR != cardHListViewData) {
                    this.bZR = cardHListViewData;
                    this.bdE.setSelection(0);
                }
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.f> aw(List<com.baidu.adp.widget.ListView.f> list) {
        if (com.baidu.tbadk.core.util.v.v(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.v.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.v.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private c bZW;
        private a bZX;
        private HTypeListView bdE;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bdE = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.bZW = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bZX = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.bZW);
            this.mAdapters.add(this.bZX);
            this.bdE.addAdapters(this.mAdapters);
        }

        public void b(v<CardHListViewData> vVar) {
            this.bZW.b(vVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.f> list) {
            if (this.bdE != null) {
                this.bdE.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bdE.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bdE.getChildAt(i2);
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
        private v<CardHListViewData> bYS;
        private View.OnClickListener mOnClickListener;

        public void b(v<CardHListViewData> vVar) {
            this.bYS = vVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.bYS != null) {
                        if (view.getId() == d.g.hlistview_item_layout_root) {
                            if (view.getTag(d.g.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                                c.this.bYS.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.hlistview_item_layout_root));
                            }
                        } else if (view.getId() == d.g.fourm_name && (view.getTag(d.g.fourm_name) instanceof CardHListViewNormalItemData)) {
                            c.this.bYS.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.fourm_name));
                        }
                    }
                }
            };
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: T */
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
            dVar.bZV.setClickable(false);
            dVar.bZV.startLoad(cardHListViewNormalItemData.recomCover, 10, false);
            c(dVar.bZU, cardHListViewNormalItemData.title);
            b(dVar.aoG, cardHListViewNormalItemData.forumName);
            c(dVar.ann, cardHListViewNormalItemData.replyNum);
            dVar.aoG.setTag(d.g.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(d.g.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.aoG.setOnClickListener(this.mOnClickListener);
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
        public TextView ann;
        public TextView aoG;
        public TextView bZU;
        public TbImageView bZV;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(d.g.hlistview_item_layout_root);
            this.bZU = (TextView) view.findViewById(d.g.text_title);
            this.aoG = (TextView) view.findViewById(d.g.fourm_name);
            this.ann = (TextView) view.findViewById(d.g.thread_commont_num);
            this.bZV = (TbImageView) view.findViewById(d.g.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.C0096d.cp_bg_line_d);
                aj.i(this.bZU, d.C0096d.cp_cont_b);
                aj.i(this.aoG, d.C0096d.cp_cont_c);
                aj.i(this.ann, d.C0096d.cp_cont_c);
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
        /* renamed from: S */
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
        public View bZS;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bZS = view.findViewById(d.g.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.k(getView(), d.C0096d.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
