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
    private ViewGroup gKj;
    private ImageView gKk;
    private TextView gKl;
    private TextView gKm;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.gKj = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.gKk = (ImageView) this.mView.findViewById(R.id.image);
        this.gKl = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.gKm = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.gKl.setText(R.string.no_like_forum_hint_1);
        this.gKm.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void WT() {
        am.setImageResource(this.gKk, R.drawable.cp_mask_attention_a);
        am.setViewTextColor(this.gKl, (int) R.color.cp_cont_d);
        am.setViewTextColor(this.gKm, (int) R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.aPu().kL(0).kM(R.color.cp_bg_line_g).R(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).Q(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).T(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).S(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aR(this.gKj);
    }
}
