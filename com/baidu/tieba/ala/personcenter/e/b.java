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
import com.baidu.tieba.ala.personcenter.c.e;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.b<e> {
    private TextView haS;
    private TextView haT;
    private TextView haU;
    private TextView haV;
    private TextView haW;
    private ImageView haX;
    private ImageView haY;
    private ProgressBar haZ;
    private FrameLayout hba;
    private View hbb;
    private e hbc;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.hba = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.haS = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.haT = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.haU = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.haV = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.haW = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.haX = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.haZ = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.haY = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.hbb = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    /* renamed from: b */
    public void a(e eVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = eVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.caA() != null) {
            this.hbc = eVar;
            if (personCenterData.caA().live_status != 1 && !personCenterData.isHost()) {
                this.hbb.setVisibility(8);
                this.haV.setVisibility(8);
                this.haW.setVisibility(8);
            } else {
                this.hbb.setVisibility(0);
                this.haV.setVisibility(0);
                this.haW.setVisibility(0);
            }
            int i = personCenterData.caA().level_id;
            if (i > 40) {
                i = 40;
            }
            this.haS.setText("Lv" + Integer.toString(i));
            this.haT.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.haU.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.haU.setVisibility(8);
            }
            if (i <= 10) {
                this.haX.setBackgroundResource(R.drawable.icon_live_level_1);
                this.haS.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.haX.setBackgroundResource(R.drawable.icon_live_level_2);
                this.haS.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.haX.setBackgroundResource(R.drawable.icon_live_level_3);
                this.haS.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.haX.setBackgroundResource(R.drawable.icon_live_level_4);
                this.haS.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.haS.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.haX.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.haZ.setMax(personCenterData.caA().next_exp);
            this.haZ.setProgress(personCenterData.caA().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.caA().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.caA().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.haV.setText(spannableString);
            if (i >= 40) {
                this.haW.setText(R.string.ala_level_max_tips);
            } else {
                this.haW.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.caA().next_exp - personCenterData.caA().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.hba, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.haY, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.haT.setAlpha(0.7f);
            this.haU.setAlpha(0.7f);
            this.haW.setAlpha(0.7f);
            this.haV.setAlpha(0.7f);
            this.haZ.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (ceP() != null) {
            ceP().a(view, this.hbc);
        }
    }
}
