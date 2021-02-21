package com.baidu.tieba.enterForum.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class c {
    private ViewGroup iRL;
    private ImageView iRM;
    private TextView iRN;
    private TextView iRO;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iRL = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iRM = (ImageView) this.mView.findViewById(R.id.image);
        this.iRN = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iRO = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iRN.setText(R.string.no_like_forum_hint_1);
        this.iRO.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aqj() {
        ap.setImageResource(this.iRM, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.iRN, R.color.CAM_X0109);
        ap.setViewTextColor(this.iRO, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oP(R.color.CAM_X0206).ah(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aj(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ai(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bv(this.iRL);
    }
}
