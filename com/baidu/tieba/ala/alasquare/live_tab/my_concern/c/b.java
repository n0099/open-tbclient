package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View eIO;
    private View ebB;
    private TextView glQ;
    private ImageView glR;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.ebB = getView();
        this.glQ = (TextView) getView().findViewById(R.id.tv_empty);
        this.glR = (ImageView) getView().findViewById(R.id.iv_empty);
        this.eIO = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.ebB, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.glQ, (int) R.color.cp_cont_d);
        ap.setImageResource(this.glR, R.drawable.new_pic_emotion_08);
        ap.setBackgroundResource(this.eIO, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.glQ.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            ap.setImageResource(this.glR, R.drawable.new_pic_emotion_07);
            return;
        }
        this.glQ.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        ap.setImageResource(this.glR, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
