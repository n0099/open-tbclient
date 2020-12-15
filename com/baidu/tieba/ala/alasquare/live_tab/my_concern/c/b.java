package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.special_forum.data.e> {
    private View eOv;
    private View egT;
    private TextView gtI;
    private ImageView gtJ;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.egT = getView();
        this.gtI = (TextView) getView().findViewById(R.id.tv_empty);
        this.gtJ = (ImageView) getView().findViewById(R.id.iv_empty);
        this.eOv = getView().findViewById(R.id.id_tab_live_sub_empty_divider);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.egT, R.color.CAM_X0201);
        ap.setViewTextColor(this.gtI, (int) R.color.CAM_X0109);
        ap.setImageResource(this.gtJ, R.drawable.new_pic_emotion_08);
        ap.setBackgroundResource(this.eOv, R.color.CAM_X0204);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_concern_empty;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.special_forum.data.e eVar) {
        if (eVar.followStatus == 1) {
            this.gtI.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_no_attention_txt));
            ap.setImageResource(this.gtJ, R.drawable.new_pic_emotion_07);
            return;
        }
        this.gtI.setText(this.mTbPageContext.getResources().getString(R.string.live_sub_tab_empty_txt));
        ap.setImageResource(this.gtJ, R.drawable.new_pic_emotion_06);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
