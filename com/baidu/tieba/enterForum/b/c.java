package com.baidu.tieba.enterForum.b;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class c {
    private ViewGroup gZm;
    private ImageView gZn;
    private TextView gZo;
    private TextView gZp;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.gZm = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.gZn = (ImageView) this.mView.findViewById(R.id.image);
        this.gZo = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.gZp = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.gZo.setText(R.string.no_like_forum_hint_1);
        this.gZp.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void ZE() {
        am.setImageResource(this.gZn, R.drawable.cp_mask_attention_a);
        am.setViewTextColor(this.gZo, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gZp, (int) R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.aVw().lp(0).lq(R.color.cp_bg_line_g).Q(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).P(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aR(this.gZm);
    }
}
