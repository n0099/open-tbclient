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
    private ViewGroup isC;
    private ImageView isD;
    private TextView isE;
    private TextView isF;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.isC = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.isD = (ImageView) this.mView.findViewById(R.id.image);
        this.isE = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.isF = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.isE.setText(R.string.no_like_forum_hint_1);
        this.isF.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void apO() {
        ap.setImageResource(this.isD, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.isE, R.color.cp_cont_d);
        ap.setViewTextColor(this.isF, R.color.cp_cont_d);
        com.baidu.tbadk.core.util.e.a.brO().pj(0).pk(R.color.cp_bg_line_g).ad(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ac(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).af(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ae(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bk(this.isC);
    }
}
