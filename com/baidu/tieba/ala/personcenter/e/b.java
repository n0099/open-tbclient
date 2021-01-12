package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.f;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView hYQ;
    private TextView hYR;
    private TextView hYS;
    private TextView hYT;
    private TextView hYU;
    private ImageView hYV;
    private ImageView hYW;
    private ProgressBar hYX;
    private FrameLayout hYY;
    private View hYZ;
    private f hZa;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.hYY = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hYQ = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hYR = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hYS = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hYT = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hYU = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hYV = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hYX = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hYW = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hYZ = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(f fVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = fVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.clR() != null) {
            this.hZa = fVar;
            if (personCenterData.clR().live_status != 1 && !personCenterData.isHost()) {
                this.hYZ.setVisibility(8);
                this.hYT.setVisibility(8);
                this.hYU.setVisibility(8);
            } else {
                this.hYZ.setVisibility(0);
                this.hYT.setVisibility(0);
                this.hYU.setVisibility(0);
            }
            int i = personCenterData.clR().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hYQ.setText("Lv" + Integer.toString(i));
            this.hYR.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hYS.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hYS.setVisibility(8);
            }
            if (i <= 10) {
                this.hYV.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hYQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hYV.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hYQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hYV.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hYQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hYV.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hYQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hYQ.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hYV.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hYX.setMax(personCenterData.clR().next_exp);
            this.hYX.setProgress(personCenterData.clR().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.clR().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.clR().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.hYT.setText(spannableString);
            if (i >= 40) {
                this.hYU.setText("");
            } else {
                this.hYU.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.clR().next_exp - personCenterData.clR().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.hYY, R.drawable.bg_live_mine);
        ao.setBackgroundResource(this.hYW, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hYR.setAlpha(0.7f);
            this.hYS.setAlpha(0.7f);
            this.hYU.setAlpha(0.7f);
            this.hYT.setAlpha(0.7f);
            this.hYX.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cqL() != null) {
            cqL().a(view, this.hZa);
        }
    }
}
