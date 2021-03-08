package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes2.dex */
public class GameSubCommentView {
    private a.InterfaceC0737a jCL;
    private SpannableTextView jDB;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.jDB = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.jDB, R.color.CAM_X0106);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.jDB.f(dVar);
            this.jDB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameSubCommentView.this.jCL != null) {
                        GameSubCommentView.this.jCL.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0737a interfaceC0737a) {
        this.jCL = interfaceC0737a;
        this.jDB.setClickListener(interfaceC0737a);
    }

    /* loaded from: classes2.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {
        private GameSubCommentView jDD;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.getRootView());
            this.jDD = gameSubCommentView;
        }

        public void f(d dVar) {
            this.jDD.f(dVar);
        }
    }
}
