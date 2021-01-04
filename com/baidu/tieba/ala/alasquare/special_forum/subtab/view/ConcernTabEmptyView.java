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
/* loaded from: classes10.dex */
public class ConcernTabEmptyView extends com.baidu.tieba.card.b<e> {
    private ViewHolder gJT;

    public ConcernTabEmptyView(TbPageContext<?> tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gJT = new ViewHolder(getView());
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setViewTextColor(this.gJT.textView, R.color.CAM_X0109);
        ao.setBackgroundColor(this.gJT.bUk, R.color.CAM_X0204);
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

    /* loaded from: classes10.dex */
    public static class ViewHolder extends TypeAdapter.ViewHolder {
        public View bUk;
        public View epV;
        public TextView textView;

        public ViewHolder(View view) {
            super(view);
            this.epV = view;
            this.textView = (TextView) this.epV.findViewById(R.id.tv_empty);
            this.bUk = this.epV.findViewById(R.id.devider_line);
        }
    }
}
