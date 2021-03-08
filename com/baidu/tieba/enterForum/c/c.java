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
    private ViewGroup iTu;
    private ImageView iTv;
    private TextView iTw;
    private TextView iTx;
    private TbPageContext<?> mPageContext;
    private View mView;

    public c(TbPageContext<?> tbPageContext) {
        this.mPageContext = tbPageContext;
        this.mView = tbPageContext.getPageActivity().getLayoutInflater().inflate(R.layout.no_like_forum_emotion_item_view, (ViewGroup) null);
        this.iTu = (ViewGroup) this.mView.findViewById(R.id.item_group);
        this.iTv = (ImageView) this.mView.findViewById(R.id.image);
        this.iTw = (TextView) this.mView.findViewById(R.id.hint_text_1);
        this.iTx = (TextView) this.mView.findViewById(R.id.hint_text_2);
        this.iTw.setText(R.string.no_like_forum_hint_1);
        this.iTx.setText(R.string.no_like_forum_hint_2);
    }

    public View getView() {
        return this.mView;
    }

    public void aqm() {
        ap.setImageResource(this.iTv, R.drawable.cp_mask_attention_a);
        ap.setViewTextColor(this.iTw, R.color.CAM_X0109);
        ap.setViewTextColor(this.iTx, R.color.CAM_X0109);
        com.baidu.tbadk.core.util.f.a.bty().oP(0).oQ(R.color.CAM_X0206).al(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).ak(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).an(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).am(l.getDimens(this.mPageContext.getPageActivity(), R.dimen.tbds21)).bv(this.iTu);
    }
}
