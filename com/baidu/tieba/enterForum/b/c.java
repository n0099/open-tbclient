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
    private ViewGroup gKp;
    private ImageView gKq;
    private TextView gKr;
    private TextView gKs;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.gKp = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.gKq = (ImageView) this.mView.findViewById(R.id.image);
        this.gKr = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.gKs = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.gKr.setText(R.string.no_like_forum_hint_1);
        this.gKs.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void WS() {
        am.setImageResource(this.gKq, R.drawable.cp_mask_attention_a);
        am.setViewTextColor(this.gKr, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gKs, (int) R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.aPr().kL(0).kM(R.color.cp_bg_line_g).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Q(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).T(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aR(this.gKp);
    }
}
