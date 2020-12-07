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
    private ViewGroup iEi;
    private ImageView iEj;
    private TextView iEk;
    private TextView iEl;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iEi = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iEj = (ImageView) this.mView.findViewById(R.id.image);
        this.iEk = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iEl = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iEk.setText(R.string.no_like_forum_hint_1);
        this.iEl.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aso() {
        ap.setImageResource(this.iEj, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.iEk, R.color.CAM_X0109);
        ap.setViewTextColor(this.iEl, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.e.a.buz().qf(0).qg(R.color.CAM_X0206).ae(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ad(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).af(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bq(this.iEi);
    }
}
