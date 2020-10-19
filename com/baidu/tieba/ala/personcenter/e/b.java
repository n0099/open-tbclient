package com.baidu.tieba.ala.personcenter.e;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.f;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView hpT;
    private TextView hpU;
    private TextView hpV;
    private TextView hpW;
    private TextView hpX;
    private ImageView hpY;
    private ImageView hpZ;
    private ProgressBar hqa;
    private FrameLayout hqb;
    private View hqc;
    private f hqd;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        an(getView());
    }

    private void an(View view) {
        this.hqb = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hpT = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hpU = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hpV = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hpW = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hpX = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hpY = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hqa = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hpZ = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hqc = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cdY() != null) {
            this.hqd = fVar;
            if (personCenterData.cdY().live_status != 1 && !personCenterData.isHost()) {
                this.hqc.setVisibility(8);
                this.hpW.setVisibility(8);
                this.hpX.setVisibility(8);
            } else {
                this.hqc.setVisibility(0);
                this.hpW.setVisibility(0);
                this.hpX.setVisibility(0);
            }
            int i = personCenterData.cdY().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hpT.setText("Lv" + Integer.toString(i));
            this.hpU.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hpV.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hpV.setVisibility(8);
            }
            if (i <= 10) {
                this.hpY.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hpT.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hpY.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hpT.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hpY.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hpT.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hpY.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hpT.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hpT.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hpY.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hqa.setMax(personCenterData.cdY().next_exp);
            this.hqa.setProgress(personCenterData.cdY().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cdY().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cdY().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.hpW.setText(spannableString);
            if (i >= 40) {
                this.hpX.setText(R.string.ala_level_max_tips);
            } else {
                this.hpX.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cdY().next_exp - personCenterData.cdY().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hqb, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hpZ, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hpU.setAlpha(0.7f);
            this.hpV.setAlpha(0.7f);
            this.hpX.setAlpha(0.7f);
            this.hpW.setAlpha(0.7f);
            this.hqa.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cil() != null) {
            cil().a(view, this.hqd);
        }
    }
}
