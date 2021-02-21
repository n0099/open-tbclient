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
    private SpannableTextView jBS;
    private a.InterfaceC0731a jBc;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.jBS = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ap.setViewTextColor(this.jBS, R.color.CAM_X0106);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.jBS.f(dVar);
            this.jBS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameSubCommentView.this.jBc != null) {
                        GameSubCommentView.this.jBc.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0731a interfaceC0731a) {
        this.jBc = interfaceC0731a;
        this.jBS.setClickListener(interfaceC0731a);
    }

    /* loaded from: classes2.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {
        private GameSubCommentView jBU;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.getRootView());
            this.jBU = gameSubCommentView;
        }

        public void f(d dVar) {
            this.jBU.f(dVar);
        }
    }
}
