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
    private ViewGroup gZb;
    private ImageView gZc;
    private TextView gZd;
    private TextView gZe;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.gZb = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.gZc = (ImageView) this.mView.findViewById(R.id.image);
        this.gZd = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.gZe = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.gZd.setText(R.string.no_like_forum_hint_1);
        this.gZe.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void ZE() {
        am.setImageResource(this.gZc, R.drawable.cp_mask_attention_a);
        am.setViewTextColor(this.gZd, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gZe, (int) R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.aVv().ln(0).lo(R.color.cp_bg_line_g).Q(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).P(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aR(this.gZb);
    }
}
