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
    private TbPageContext<?> GO;
    private CardGroupDividerView bbM;
    private View bbN;
    private HTypeListView bbO;
    private e bbP;
    private String bbQ;
    private int mSkinType;

    public r(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.GO = tbPageContext;
        this.bbM = (CardGroupDividerView) getView().findViewById(r.g.header_divider);
        this.bbN = getView().findViewById(r.g.card_bottom_divider);
        this.bbO = (HTypeListView) getView().findViewById(r.g.hlistview);
        this.bbO.setHeaderDividersEnabled(false);
        this.bbO.setFooterDividersEnabled(false);
        this.bbO.setSelector(r.f.list_selector_transparent);
        this.bbM.c(0, com.baidu.adp.lib.util.k.e(this.GO.getPageActivity(), r.e.ds28));
        this.bbQ = this.GO.getString(r.j.frs_guess_like_title);
        this.bbM.y(this.bbQ, true);
        this.bbP = new e(tbPageContext, this.bbO);
    }

    @Override // com.baidu.tieba.card.a
    public void setOnSubCardOnClickListenner(cb<CardHListViewData> cbVar) {
        super.setOnSubCardOnClickListenner(cbVar);
        this.bbP.setOnSubCardOnClickListenner(cbVar);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
            com.baidu.tbadk.core.util.ar.l(this.bbN, r.d.cp_bg_line_c);
            if (this.bbM != null) {
                this.bbM.tm();
            }
            if (this.bbP != null) {
                this.bbP.onChangeSkinType(i);
            }
            this.mSkinType = i;
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return r.h.card_hlistview_thread_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: a */
    public void onBindDataToView(CardHListViewData cardHListViewData) {
        if (cardHListViewData != null) {
            if (this.bbM != null) {
                if (cardHListViewData.showTopDivider) {
                    this.bbM.y(!TextUtils.isEmpty(cardHListViewData.title) ? cardHListViewData.title : this.bbQ, true);
                } else {
                    this.bbM.Pn();
                }
            }
            if (this.bbN != null) {
                this.bbN.setVisibility(cardHListViewData.showBottomDivider ? 0 : 8);
            }
            if (this.bbP != null) {
                this.bbP.setDatas(X(cardHListViewData.getDataList()));
            }
            onChangeSkinType(this.GO, TbadkCoreApplication.m9getInst().getSkinType());
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private List<com.baidu.adp.widget.ListView.v> X(List<com.baidu.adp.widget.ListView.v> list) {
        if (com.baidu.tbadk.core.util.x.s(list) > 0) {
            ArrayList arrayList = new ArrayList(list);
            com.baidu.tbadk.core.util.x.a(arrayList, 0, new com.baidu.tieba.card.data.l());
            com.baidu.tbadk.core.util.x.b(arrayList, new com.baidu.tieba.card.data.l());
            return arrayList;
        }
        return list;
    }

    /* loaded from: classes.dex */
    public static class e {
        private HTypeListView bbO;
        private c bbW;
        private a bbX;
        private TbPageContext mTbPageContext;
        private int mSkinType = 3;
        private List<com.baidu.adp.widget.ListView.a> bbV = new ArrayList();

        public e(TbPageContext tbPageContext, HTypeListView hTypeListView) {
            this.mTbPageContext = tbPageContext;
            this.bbO = hTypeListView;
            Ou();
        }

        private void Ou() {
            this.bbW = new c(this.mTbPageContext, CardHListViewNormalItemData.TYPE);
            this.bbX = new a(this.mTbPageContext, com.baidu.tieba.card.data.l.TYPE);
            this.bbV.add(this.bbW);
            this.bbV.add(this.bbX);
            this.bbO.g(this.bbV);
        }

        public void setOnSubCardOnClickListenner(cb<CardHListViewData> cbVar) {
            this.bbW.setOnSubCardOnClickListenner(cbVar);
        }

        public void setDatas(List<com.baidu.adp.widget.ListView.v> list) {
            if (this.bbO != null) {
                this.bbO.setData(list);
            }
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                int count = this.bbO.getCount();
                for (int i2 = 0; i2 < count; i2++) {
                    View childAt = this.bbO.getChildAt(i2);
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
        private cb<CardHListViewData> baA;
        private View.OnClickListener mOnClickListener;

        public void setOnSubCardOnClickListenner(cb<CardHListViewData> cbVar) {
            this.baA = cbVar;
        }

        public c(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
            super(tbPageContext.getPageActivity(), bdUniqueId);
            this.mOnClickListener = new s(this);
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        /* renamed from: h */
        public d a(ViewGroup viewGroup) {
            return new d(LayoutInflater.from(this.mContext).inflate(r.h.card_hlistview_normal_item, viewGroup, false));
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.baidu.adp.widget.ListView.a
        public View a(int i, View view, ViewGroup viewGroup, CardHListViewNormalItemData cardHListViewNormalItemData, d dVar) {
            if (dVar == null || cardHListViewNormalItemData == null) {
                return null;
            }
            dVar.bbU.setClickable(false);
            dVar.bbU.c(cardHListViewNormalItemData.recomCover, 10, false);
            f(dVar.aMQ, cardHListViewNormalItemData.title);
            e(dVar.bbT, cardHListViewNormalItemData.forumName);
            c(dVar.agT, cardHListViewNormalItemData.replyNum);
            dVar.bbT.setTag(r.g.fourm_name, cardHListViewNormalItemData);
            dVar.mView.setTag(r.g.hlistview_item_layout_root, cardHListViewNormalItemData);
            dVar.mView.setOnClickListener(this.mOnClickListener);
            dVar.bbT.setOnClickListener(this.mOnClickListener);
            dVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            return dVar.getView();
        }

        private void c(TextView textView, long j) {
            if (textView != null) {
                if (j > 0) {
                    textView.setVisibility(0);
                    String v = com.baidu.tbadk.core.util.av.v(j);
                    textView.setText(String.format(this.mContext.getString(r.j.reply_num_tip), v));
                    textView.setContentDescription(String.valueOf(this.mContext.getString(r.j.reply_num)) + v);
                    return;
                }
                textView.setVisibility(4);
            }
        }

        private void e(TextView textView, String str) {
            if (!StringUtils.isNull(str)) {
                textView.setVisibility(0);
                String string = this.mContext.getString(r.j.chosen_pb_original_bar, UtilHelper.getFixedBarText(str, 5, true));
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
        public TextView aMQ;
        public TextView agT;
        public TextView bbT;
        public TbImageView bbU;
        private int mSkinType;
        public View mView;

        public d(View view) {
            super(view);
            this.mSkinType = 3;
            this.mView = view.findViewById(r.g.hlistview_item_layout_root);
            this.aMQ = (TextView) view.findViewById(r.g.text_title);
            this.bbT = (TextView) view.findViewById(r.g.fourm_name);
            this.agT = (TextView) view.findViewById(r.g.thread_commont_num);
            this.bbU = (TbImageView) view.findViewById(r.g.thread_image);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
                com.baidu.tbadk.core.util.ar.j((View) this.aMQ, r.d.cp_cont_b);
                com.baidu.tbadk.core.util.ar.j((View) this.bbT, r.d.cp_cont_c);
                com.baidu.tbadk.core.util.ar.j((View) this.agT, r.d.cp_cont_c);
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
        /* renamed from: g */
        public b a(ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(this.mContext).inflate(r.h.card_hlistview_interval_item, viewGroup, false);
            int e = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds420);
            int e2 = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds12);
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
        public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.data.l lVar, b bVar) {
            if (lVar != null && bVar != null) {
                bVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
            }
            return view;
        }
    }

    /* loaded from: classes.dex */
    public static class b extends y.a {
        public View bbR;
        private int mSkinType;

        public b(View view) {
            super(view);
            this.mSkinType = 3;
            this.bbR = view.findViewById(r.g.hlistview_interval_item);
        }

        public void onChangeSkinType(int i) {
            if (this.mSkinType != i) {
                com.baidu.tbadk.core.util.ar.l(getView(), r.d.cp_bg_line_d);
                this.mSkinType = i;
            }
        }
    }
}
