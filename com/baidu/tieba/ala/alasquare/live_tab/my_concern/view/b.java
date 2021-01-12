package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View bPy;
    private View elg;
    private TextView gAa;
    private ImageView gAb;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.elg = getView();
        this.gAa = (TextView) getView().findViewById(R.id.tv_empty);
        this.gAb = (ImageView) getView().findViewById(R.id.iv_empty);
        this.bPy = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.elg, R.color.CAM_X0201);
        ao.setViewTextColor(this.gAa, R.color.CAM_X0109);
        ao.setImageResource(this.gAb, R.drawable.new_pic_emotion_08);
        ao.setBackgroundResource(this.bPy, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.gAa.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            ao.setImageResource(this.gAb, R.drawable.new_pic_emotion_07);
            return;
        }
        this.gAa.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        ao.setImageResource(this.gAb, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
