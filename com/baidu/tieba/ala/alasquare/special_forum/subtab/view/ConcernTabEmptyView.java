package com.baidu.tieba.ala.alasquare.special_forum.subtab.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.special_forum.data.e;
/* loaded from: classes9.dex */
public class ConcernTabEmptyView extends com.baidu.tieba.card.b<e> {
    private ViewHolder gFn;

    public ConcernTabEmptyView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gFn = new ViewHolder(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gFn.textView, R.color.CAM_X0109);
        ao.setBackgroundColor(this.gFn.bPy, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.special_bar_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(e eVar) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* loaded from: classes9.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public View bPy;
        public View elg;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.elg = view;
            this.textView = (TextView) this.elg.findViewById(R.id.tv_empty);
            this.bPy = this.elg.findViewById(R.id.devider_line);
        }
    }
}
