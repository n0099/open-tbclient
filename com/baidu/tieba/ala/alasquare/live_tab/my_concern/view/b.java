package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View bTo;
    private View eno;
    private TextView gCK;
    private ImageView gCL;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.eno = getView();
        this.gCK = (TextView) getView().findViewById(R.id.tv_empty);
        this.gCL = (ImageView) getView().findViewById(R.id.iv_empty);
        this.bTo = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.eno, R.color.CAM_X0201);
        ap.setViewTextColor(this.gCK, R.color.CAM_X0109);
        ap.setImageResource(this.gCL, R.drawable.new_pic_emotion_08);
        ap.setBackgroundResource(this.bTo, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.gCK.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            ap.setImageResource(this.gCL, R.drawable.new_pic_emotion_07);
            return;
        }
        this.gCK.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        ap.setImageResource(this.gCL, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
