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
    private ViewGroup iLP;
    private ImageView iLQ;
    private TextView iLR;
    private TextView iLS;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iLP = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iLQ = (ImageView) this.mView.findViewById(R.id.image);
        this.iLR = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iLS = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iLR.setText(R.string.no_like_forum_hint_1);
        this.iLS.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void apL() {
        ao.setImageResource(this.iLQ, R.drawable.cp_mask_attention_a);
        ao.setViewTextColor(this.iLR, R.color.CAM_X0109);
        ao.setViewTextColor(this.iLS, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.f.a.btb().oJ(0).oK(R.color.CAM_X0206).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).af(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ai(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ah(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bz(this.iLP);
    }
}
