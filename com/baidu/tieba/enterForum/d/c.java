package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class c {
    private ViewGroup imE;
    private ImageView imF;
    private TextView imG;
    private TextView imH;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.imE = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.imF = (ImageView) this.mView.findViewById(R.id.image);
        this.imG = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.imH = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.imG.setText(R.string.no_like_forum_hint_1);
        this.imH.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void ann() {
        ap.setImageResource(this.imF, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.imG, R.color.cp_cont_d);
        ap.setViewTextColor(this.imH, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.bpo().oZ(0).pa(R.color.cp_bg_line_g).ab(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aa(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ad(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ac(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bg(this.imE);
    }
}
