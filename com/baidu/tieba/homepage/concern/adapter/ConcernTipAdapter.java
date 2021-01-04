package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class ConcernTipAdapter extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.concern.a.b, ConcernTipViewHolder> {
    private static int jYp;
    private static int jYq;

    public ConcernTipAdapter(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.jYB);
        jYp = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        jYq = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
    public ConcernTipViewHolder e(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), R.layout.concern_tip_layout, null);
        ao.setBackgroundColor(inflate, R.color.CAM_X0205);
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
        concernTipViewHolder.jYr.setText(bVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.jYr.getLayoutParams();
        if (bVar.jYE) {
            layoutParams.height = jYq;
            concernTipViewHolder.bRR.setVisibility(0);
        } else if (bVar.jYF) {
            layoutParams.height = jYp;
        }
        concernTipViewHolder.jYr.setLayoutParams(layoutParams);
        concernTipViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        private int akW;
        public View bRR;
        public TextView jYr;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.akW = 3;
            this.jYr = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.bRR = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.akW != i) {
                ao.setBackgroundColor(getView(), R.color.CAM_X0205);
                ao.setViewTextColor(this.jYr, R.color.CAM_X0109);
                ao.setBackgroundResource(this.bRR, R.color.CAM_X0205);
            }
        }
    }
}
