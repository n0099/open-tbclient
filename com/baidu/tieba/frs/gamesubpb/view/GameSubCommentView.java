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
    private SpannableTextView jvY;
    private a.InterfaceC0730a jvi;
    private View mRootView;
    private TbPageContext<?> mTbPageContext;

    public GameSubCommentView(TbPageContext<?> tbPageContext) {
        this.mTbPageContext = tbPageContext;
        this.mRootView = LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.game_sub_comment_view, (ViewGroup) null);
        this.jvY = (SpannableTextView) this.mRootView.findViewById(R.id.sub_comment_tv);
        ao.setViewTextColor(this.jvY, R.color.CAM_X0106);
    }

    public void f(final d dVar) {
        if (dVar != null && dVar.userName != null) {
            this.jvY.f(dVar);
            this.jvY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.gamesubpb.view.GameSubCommentView.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (GameSubCommentView.this.jvi != null) {
                        GameSubCommentView.this.jvi.c(dVar);
                    }
                }
            });
        }
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void setClickListener(a.InterfaceC0730a interfaceC0730a) {
        this.jvi = interfaceC0730a;
        this.jvY.setClickListener(interfaceC0730a);
    }

    /* loaded from: classes2.dex */
    public static class GameSubCommentViewHolder extends TypeAdapter.ViewHolder {
        private GameSubCommentView jwa;

        public GameSubCommentViewHolder(GameSubCommentView gameSubCommentView) {
            super(gameSubCommentView.getRootView());
            this.jwa = gameSubCommentView;
        }

        public void f(d dVar) {
            this.jwa.f(dVar);
        }
    }
}
