package com.baidu.tieba.frs.gamesubpb;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.frs.gamesubpb.model.d;
import com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView;
/* loaded from: classes2.dex */
public class a extends com.baidu.adp.widget.ListView.a<d, GameSubCommentView.GameSubCommentViewHolder> {
    private TbPageContext jzN;
    private InterfaceC0747a jzO;

    /* renamed from: com.baidu.tieba.frs.gamesubpb.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public interface InterfaceC0747a {
        void a(d dVar);

        void b(d dVar);

        void c(d dVar);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        this.jzN = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: bK */
    public GameSubCommentView.GameSubCommentViewHolder e(ViewGroup viewGroup) {
        GameSubCommentView gameSubCommentView = new GameSubCommentView(this.jzN);
        gameSubCommentView.setClickListener(this.jzO);
        return new GameSubCommentView.GameSubCommentViewHolder(gameSubCommentView);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, d dVar, GameSubCommentView.GameSubCommentViewHolder gameSubCommentViewHolder) {
        if (dVar != null) {
            gameSubCommentViewHolder.f(dVar);
        }
        return gameSubCommentViewHolder.getView();
    }

    public void setClickListener(InterfaceC0747a interfaceC0747a) {
        this.jzO = interfaceC0747a;
    }
}
