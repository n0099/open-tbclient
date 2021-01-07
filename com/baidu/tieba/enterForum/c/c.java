package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c {
    private ViewGroup iQw;
    private ImageView iQx;
    private TextView iQy;
    private TextView iQz;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iQw = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iQx = (ImageView) this.mView.findViewById(R.id.image);
        this.iQy = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iQz = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iQy.setText(R.string.no_like_forum_hint_1);
        this.iQz.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void atG() {
        ao.setImageResource(this.iQx, R.drawable.cp_mask_attention_a);
        ao.setViewTextColor(this.iQy, R.color.CAM_X0109);
        ao.setViewTextColor(this.iQz, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.f.a.bwV().qq(0).qr(R.color.CAM_X0206).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).af(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ai(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ah(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bz(this.iQw);
    }
}
