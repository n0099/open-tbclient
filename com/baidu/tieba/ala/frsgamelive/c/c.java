package com.baidu.tieba.ala.frsgamelive.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.baidu.adp.widget.ListView.af;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.ala.gamelist.b.a> {
    private d fYo;
    private d fYp;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView();
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.fYo.onChangeSkinType(tbPageContext, i);
        this.fYp.onChangeSkinType(tbPageContext, i);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_sub_list_game_live;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.gamelist.b.a aVar) {
        if (aVar != null) {
            this.fYo.a(aVar.fZi);
            this.fYp.a(aVar.fZj);
        }
    }

    public void c(com.baidu.tieba.ala.e eVar) {
        this.fYo.d(eVar);
        this.fYp.d(eVar);
    }

    public void setLabelName(String str) {
        this.fYo.setLabelName(str);
        this.fYp.setLabelName(str);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    private void initView() {
        this.fYo = new d(getTbPageContext());
        this.fYp = new d(getTbPageContext());
        ViewGroup viewGroup = (ViewGroup) getView();
        View view = new View(getContext());
        viewGroup.addView(this.fYo.getView());
        viewGroup.addView(view, new LinearLayout.LayoutParams(getTbPageContext().getResources().getDimensionPixelSize(R.dimen.ds16), -1));
        viewGroup.addView(this.fYp.getView());
    }

    /* loaded from: classes4.dex */
    public static class a extends af.a {
        public c fYq;

        public a(c cVar) {
            super(cVar.getView());
            this.fYq = cVar;
        }
    }
}
