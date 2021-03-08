package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ConcernTipAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.b, ConcernTipViewHolder> {
    private static int kdB;
    private static int kdC;

    public ConcernTipAdapter(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.kdN);
        kdB = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        kdC = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bR */
    public ConcernTipViewHolder e(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        ap.setBackgroundColor(inflate, R.color.CAM_X0205);
        ConcernTipViewHolder concernTipViewHolder = new ConcernTipViewHolder(inflate);
        ViewGroup.LayoutParams generateLayoutParamsByParent = generateLayoutParamsByParent(viewGroup);
        generateLayoutParamsByParent.width = -1;
        generateLayoutParamsByParent.height = -2;
        inflate.setLayoutParams(generateLayoutParamsByParent);
        return concernTipViewHolder;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.concern.a.b bVar, ConcernTipViewHolder concernTipViewHolder) {
        concernTipViewHolder.kdD.setText(bVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.kdD.getLayoutParams();
        if (bVar.kdQ) {
            layoutParams.height = kdC;
            concernTipViewHolder.bSv.setVisibility(0);
        } else if (bVar.kdR) {
            layoutParams.height = kdB;
        }
        concernTipViewHolder.kdD.setLayoutParams(layoutParams);
        concernTipViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        private int aln;
        public View bSv;
        public TextView kdD;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.aln = 3;
            this.kdD = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.bSv = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.aln != i) {
                ap.setBackgroundColor(getView(), R.color.CAM_X0205);
                ap.setViewTextColor(this.kdD, R.color.CAM_X0109);
                ap.setBackgroundResource(this.bSv, R.color.CAM_X0205);
            }
        }
    }
}
