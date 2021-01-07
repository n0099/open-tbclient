package com.baidu.tieba.frs.gamesubpb.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.gamesubpb.a;
import com.baidu.tieba.frs.gamesubpb.model.d;
/* loaded from: classes2.dex */
public class GameSubCommentView {
    private SpannableTextView jAE;
    private a.InterfaceC0747a jzO;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.jAE = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ao.setViewTextColor(this.jAE, R.color.CAM_X0106);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.jAE.f(dVar);
            this.jAE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameSubCommentView.this.jzO != null) {
                        GameSubCommentView.this.jzO.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0747a interfaceC0747a) {
        this.jzO = interfaceC0747a;
        this.jAE.setClickListener(interfaceC0747a);
    }

    /* loaded from: classes2.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {
        private GameSubCommentView jAG;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.getRootView());
            this.jAG = gameSubCommentView;
        }

        public void f(d dVar) {
            this.jAG.f(dVar);
        }
    }
}
