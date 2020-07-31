package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class c {
    private ViewGroup hrj;
    private ImageView hrk;
    private TextView hrl;
    private TextView hrm;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.hrj = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.hrk = (ImageView) this.mView.findViewById(R.id.image);
        this.hrl = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.hrm = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.hrl.setText(R.string.no_like_forum_hint_1);
        this.hrm.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void abM() {
        ao.setImageResource(this.hrk, R.drawable.cp_mask_attention_a);
        ao.setViewTextColor(this.hrl, R.color.cp_cont_d);
        ao.setViewTextColor(this.hrm, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.bbr().ma(0).mb(R.color.cp_bg_line_g).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).U(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).T(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aX(this.hrj);
    }
}
