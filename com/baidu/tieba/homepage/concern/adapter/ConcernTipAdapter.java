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
    private static int kbl;
    private static int kbm;

    public ConcernTipAdapter(Context context) {
        super(context, com.baidu.tieba.homepage.concern.a.b.kbx);
        kbl = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds102);
        kbm = com.baidu.adp.lib.util.l.getDimens(context, R.dimen.tbds166);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bS */
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
        concernTipViewHolder.kbn.setText(bVar.tipString);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) concernTipViewHolder.kbn.getLayoutParams();
        if (bVar.kbA) {
            layoutParams.height = kbm;
            concernTipViewHolder.bQV.setVisibility(0);
        } else if (bVar.kbB) {
            layoutParams.height = kbl;
        }
        concernTipViewHolder.kbn.setLayoutParams(layoutParams);
        concernTipViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        return concernTipViewHolder.getView();
    }

    /* loaded from: classes2.dex */
    public static class ConcernTipViewHolder extends TypeAdapter.ViewHolder {
        private int ajU;
        public View bQV;
        public TextView kbn;

        public ConcernTipViewHolder(View view) {
            super(view);
            this.ajU = 3;
            this.kbn = (TextView) view.findViewById(R.id.concern_tip_txt);
            this.bQV = view.findViewById(R.id.concern_tip_top_line);
        }

        protected void onChangeSkinType(int i) {
            if (this.ajU != i) {
                ap.setBackgroundColor(getView(), R.color.CAM_X0205);
                ap.setViewTextColor(this.kbn, R.color.CAM_X0109);
                ap.setBackgroundResource(this.bQV, R.color.CAM_X0205);
            }
        }
    }
}
