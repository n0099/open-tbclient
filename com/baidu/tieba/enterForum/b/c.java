package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private TextView hlA;
    private ViewGroup hlx;
    private ImageView hly;
    private TextView hlz;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.hlx = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.hly = (ImageView) this.mView.findViewById(R.id.image);
        this.hlz = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.hlA = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.hlz.setText(R.string.no_like_forum_hint_1);
        this.hlA.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aaK() {
        an.setImageResource(this.hly, R.drawable.cp_mask_attention_a);
        an.setViewTextColor(this.hlz, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.hlA, (int) R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.aXq().lG(0).lH(R.color.cp_bg_line_g).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).U(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).T(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aR(this.hlx);
    }
}
