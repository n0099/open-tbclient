package com.baidu.tieba.enterForum.d;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes21.dex */
public class c {
    private ViewGroup itq;
    private ImageView itr;
    private TextView its;
    private TextView itt;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.itq = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.itr = (ImageView) this.mView.findViewById(R.id.image);
        this.its = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.itt = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.its.setText(R.string.no_like_forum_hint_1);
        this.itt.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void apf() {
        ap.setImageResource(this.itr, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.its, R.color.CAM_X0109);
        ap.setViewTextColor(this.itt, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.e.a.brc().pF(0).pG(R.color.CAM_X0206).ae(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ad(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).af(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bn(this.itq);
    }
}
