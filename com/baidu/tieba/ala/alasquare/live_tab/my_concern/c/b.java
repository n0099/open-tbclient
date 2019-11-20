package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View bFk;
    private View cfh;
    private TextView dxB;
    private ImageView dxC;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.bFk = getView();
        this.dxB = (TextView) getView().findViewById(R.id.tv_empty);
        this.dxC = (ImageView) getView().findViewById(R.id.iv_empty);
        this.cfh = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.bFk, R.color.cp_bg_line_d);
        am.setViewTextColor(this.dxB, (int) R.color.cp_cont_d);
        am.setImageResource(this.dxC, R.drawable.new_pic_emotion_gray_09);
        am.setBackgroundResource(this.cfh, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.dxB.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            am.setImageResource(this.dxC, R.drawable.new_pic_emotion_gray_10);
            return;
        }
        this.dxB.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        am.setImageResource(this.dxC, R.drawable.new_pic_emotion_gray_09);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
