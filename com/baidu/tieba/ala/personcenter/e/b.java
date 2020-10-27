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
    private TextView hBO;
    private TextView hBP;
    private TextView hBQ;
    private TextView hBR;
    private TextView hBS;
    private ImageView hBT;
    private ImageView hBU;
    private ProgressBar hBV;
    private FrameLayout hBW;
    private View hBX;
    private f hBY;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ah(getView());
    }

    private void ah(View view) {
        this.hBW = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.hBO = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.hBP = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.hBQ = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.hBR = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.hBS = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.hBT = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.hBV = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.hBU = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hBX = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cha() != null) {
            this.hBY = fVar;
            if (personCenterData.cha().live_status != 1 && !personCenterData.isHost()) {
                this.hBX.setVisibility(8);
                this.hBR.setVisibility(8);
                this.hBS.setVisibility(8);
            } else {
                this.hBX.setVisibility(0);
                this.hBR.setVisibility(0);
                this.hBS.setVisibility(0);
            }
            int i = personCenterData.cha().level_id;
            if (i > 40) {
                i = 40;
            }
            this.hBO.setText("Lv" + Integer.toString(i));
            this.hBP.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.hBQ.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.hBQ.setVisibility(8);
            }
            if (i <= 10) {
                this.hBT.setBackgroundResource(R.drawable.icon_live_level_1);
                this.hBO.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.hBT.setBackgroundResource(R.drawable.icon_live_level_2);
                this.hBO.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.hBT.setBackgroundResource(R.drawable.icon_live_level_3);
                this.hBO.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.hBT.setBackgroundResource(R.drawable.icon_live_level_4);
                this.hBO.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.hBO.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.hBT.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.hBV.setMax(personCenterData.cha().next_exp);
            this.hBV.setProgress(personCenterData.cha().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cha().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cha().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.hBR.setText(spannableString);
            if (i >= 40) {
                this.hBS.setText(R.string.ala_level_max_tips);
            } else {
                this.hBS.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cha().next_exp - personCenterData.cha().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hBW, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.hBU, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.hBP.setAlpha(0.7f);
            this.hBQ.setAlpha(0.7f);
            this.hBS.setAlpha(0.7f);
            this.hBR.setAlpha(0.7f);
            this.hBV.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.hBY);
        }
    }
}
