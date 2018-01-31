package com.baidu.tieba.card;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.r;
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
    private HTypeListView bRJ;
    private CardGroupDividerView cTs;
    private View cTt;
    private e cTu;
    private String cTv;
    private CardHListViewData cTw;
    private TbPageContext<?> mPageContext;
    private int mSkinType;

    public h(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mPageContext = tbPageContext;
        this.cTs = (CardGroupDividerView) getView().findViewById(d.g.header_divider);
        this.cTt = getView().findViewById(d.g.card_bottom_divider);
        this.bRJ = (HTypeListView) getView().findViewById(d.g.hlistview);
        this.bRJ.setHeaderDividersEnabled(false);
        this.bRJ.setFooterDividersEnabled(false);
        this.bRJ.setSelector(d.f.list_selector_transparent);
        this.cTs.i(0, com.baidu.adp.lib.util.l.s(this.mPageContext.getPageActivity(), d.e.ds28));
        this.cTv = this.mPageContext.getString(d.j.frs_guess_like);
        this.cTs.z(this.cTv, true);
        this.cTu = new e(tbPageContext, this.bRJ);
    }

    @Override // com.baidu.tieba.card.a
    public void b(v<CardHListViewData> vVar) {
        super.b(vVar);
        this.cTu.b(vVar);
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aj.t(getView(), d.C0108d.cp_bg_line_d);
            aj.t(this.cTt, d.C0108d.cp_bg_line_c);
            if (this.cTs != null) {
                this.cTs.onChangeSkinType();
            }
            if (this.cTu != null) {
                this.cTu.onChangeSkinType(i);
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
            if (this.cTs != null) {
                if (cardHListViewData.showTopDivider) {
                    this.cTs.z(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.cTv, true);
                } else {
                    this.cTs.alo();
                }
            }
            if (this.cTt != null) {
                this.cTt.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.cTu != null) {
                this.cTu.setDatas(aF(cardHListViewData.getDataList()));
                if (this.cTw != cardHListViewData) {
                    this.cTw = cardHListViewData;
                    this.bRJ.setSelection(0);
                }
            }
            d(this.mPageContext, TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.i> aF(List<com.baidu.adp.widget.ListView.i> list) {
        if (com.baidu.tbadk.core.util.v.D(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.v.a(arrayList, 0, new com.baidu.tieba.card.data.j());
            com.baidu.tbadk.core.util.v.b(arrayList, new com.baidu.tieba.card.data.j());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView bRJ;
        private c cTB;
        private a cTC;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> mAdapters = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bRJ = hTypeListView;
            initAdapters();
        }

        private void initAdapters() {
            this.cTB = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.cTC = new a(this.mTbPageContext, com.baidu.tieba.card.data.j.TYPE);
            this.mAdapters.add(this.cTB);
            this.mAdapters.add(this.cTC);
            this.bRJ.addAdapters(this.mAdapters);
        }

        public void b(v<CardHListViewData> vVar) {
            this.cTB.b(vVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.i> list) {
            if (this.bRJ != null) {
                this.bRJ.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bRJ.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bRJ.getChildAt(i2);
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
        private v<CardHListViewData> cSy;
        private View.OnClickListener mOnClickListener;

        public void b(v<CardHListViewData> vVar) {
            this.cSy = vVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.card.h.c.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (c.this.cSy != null) {
                        if (view.getId() == d.g.hlistview_item_layout_root) {
                            if (view.getTag(d.g.hlistview_item_layout_root) instanceof CardHListViewNormalItemData) {
                                c.this.cSy.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.hlistview_item_layout_root));
                            }
                        } else if (view.getId() == d.g.fourm_name && (view.getTag(d.g.fourm_name) instanceof CardHListViewNormalItemData)) {
                            c.this.cSy.a(view, null, (CardHListViewNormalItemData) view.getTag(d.g.fourm_name));
                        }
                    }
                }
            };
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: ab */
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
            dVar.cTA.setClickable(false);
            dVar.cTA.startLoad(cardHListViewNormalItemData.recomCover, 10, false);
            c(dVar.cTz, cardHListViewNormalItemData.title);
            b(dVar.bcW, cardHListViewNormalItemData.forumName);
            c(dVar.bbw, cardHListViewNormalItemData.replyNum);
            dVar.bcW.setTag(d.g.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(d.g.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bcW.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String C = am.C(j);
                    textView.setText(String.format(this.mContext.getString(d.j.reply_num_tip), C));
                    textView.setContentDescription(this.mContext.getString(d.j.reply_num) + C);
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
    public static class d extends r.a {
        public TextView bbw;
        public TextView bcW;
        public TbImageView cTA;
        public TextView cTz;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(d.g.hlistview_item_layout_root);
            this.cTz = (TextView) view.findViewById(d.g.text_title);
            this.bcW = (TextView) view.findViewById(d.g.fourm_name);
            this.bbw = (TextView) view.findViewById(d.g.thread_commont_num);
            this.cTA = (TbImageView) view.findViewById(d.g.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.t(getView(), d.C0108d.cp_bg_line_d);
                aj.r(this.cTz, d.C0108d.cp_cont_b);
                aj.r(this.bcW, d.C0108d.cp_cont_c);
                aj.r(this.bbw, d.C0108d.cp_cont_c);
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
        /* renamed from: aa */
        public b onCreateViewHolder(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(d.h.card_hlistview_interval_item, viewGroup, false);
            int s = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds420);
            int s2 = com.baidu.adp.lib.util.l.s(this.mContext, d.e.ds12);
            ViewGroup.LayoutParams layoutParams = inflate.getLayoutParams();
            layoutParams.height = s;
            layoutParams.width = s2;
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
    public static class b extends r.a {
        public View cTx;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.cTx = view.findViewById(d.g.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                aj.t(getView(), d.C0108d.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
