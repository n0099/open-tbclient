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
    private TextView iRA;
    private ViewGroup iRx;
    private ImageView iRy;
    private TextView iRz;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iRx = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iRy = (ImageView) this.mView.findViewById(R.id.image);
        this.iRz = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iRA = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iRz.setText(R.string.no_like_forum_hint_1);
        this.iRA.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aqj() {
        ap.setImageResource(this.iRy, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.iRz, R.color.CAM_X0109);
        ap.setViewTextColor(this.iRA, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.f.a.btv().oO(0).oP(R.color.CAM_X0206).ah(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ag(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).aj(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ai(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bv(this.iRx);
    }
}
