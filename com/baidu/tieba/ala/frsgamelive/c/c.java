package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.v;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes3.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.ala.gamelist.b.a> {
    private d eCX;
    private d eCY;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.eCX.onChangeSkinType(tbPageContext, i);
        this.eCY.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.eCX.a(aVar.eDR);
            this.eCY.a(aVar.eDS);
        }
    }

    public void c(com.baidu.tieba.ala.d dVar) {
        this.eCX.d(dVar);
        this.eCY.d(dVar);
    }

    public void setLabelName(String str) {
        this.eCX.setLabelName(str);
        this.eCY.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.eCX = new d(getTbPageContext());
        this.eCY = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.eCX.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.eCY.getView());
    }

    /* loaded from: classes3.dex */
    public static class a extends v.a {
        public c eCZ;

        public a(c cVar) {
            super(cVar.getView());
            this.eCZ = cVar;
        }
    }
}
