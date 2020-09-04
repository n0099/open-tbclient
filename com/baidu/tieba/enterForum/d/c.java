package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c {
    private ViewGroup hEg;
    private ImageView hEh;
    private TextView hEi;
    private TextView hEj;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.hEg = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.hEh = (ImageView) this.mView.findViewById(R.id.image);
        this.hEi = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.hEj = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.hEi.setText(R.string.no_like_forum_hint_1);
        this.hEj.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void ahY() {
        ap.setImageResource(this.hEh, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.hEi, R.color.cp_cont_d);
        ap.setViewTextColor(this.hEj, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.bjQ().oe(0).of(R.color.cp_bg_line_g).X(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).W(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Z(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Y(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aZ(this.hEg);
    }
}
