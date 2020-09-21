package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c {
    private ViewGroup hLi;
    private ImageView hLj;
    private TextView hLk;
    private TextView hLl;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.hLi = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.hLj = (ImageView) this.mView.findViewById(R.id.image);
        this.hLk = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.hLl = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.hLk.setText(R.string.no_like_forum_hint_1);
        this.hLl.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aiI() {
        ap.setImageResource(this.hLj, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.hLk, R.color.cp_cont_d);
        ap.setViewTextColor(this.hLl, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.bkL().oq(0).or(R.color.cp_bg_line_g).X(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).W(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Z(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Y(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bb(this.hLi);
    }
}
