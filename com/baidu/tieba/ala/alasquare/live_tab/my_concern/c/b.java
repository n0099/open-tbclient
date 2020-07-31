package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View dWz;
    private View dpe;
    private TextView fuX;
    private ImageView fuY;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.dpe = getView();
        this.fuX = (TextView) getView().findViewById(R.id.tv_empty);
        this.fuY = (ImageView) getView().findViewById(R.id.iv_empty);
        this.dWz = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.dpe, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.fuX, R.color.cp_cont_d);
        ao.setImageResource(this.fuY, R.drawable.new_pic_emotion_08);
        ao.setBackgroundResource(this.dWz, R.color.cp_bg_line_c);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.fuX.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            ao.setImageResource(this.fuY, R.drawable.new_pic_emotion_07);
            return;
        }
        this.fuX.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        ao.setImageResource(this.fuY, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
