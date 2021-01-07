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
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView idB;
    private TextView idC;
    private TextView idD;
    private TextView idE;
    private TextView idF;
    private ImageView idG;
    private ImageView idH;
    private ProgressBar idI;
    private FrameLayout idJ;
    private View idK;
    private f idL;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ap(getView());
    }

    private void ap(View view) {
        this.idJ = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.idB = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.idC = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.idD = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.idE = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.idF = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.idG = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.idI = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.idH = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.idK = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cpJ() != null) {
            this.idL = fVar;
            if (personCenterData.cpJ().live_status != 1 && !personCenterData.isHost()) {
                this.idK.setVisibility(8);
                this.idE.setVisibility(8);
                this.idF.setVisibility(8);
            } else {
                this.idK.setVisibility(0);
                this.idE.setVisibility(0);
                this.idF.setVisibility(0);
            }
            int i = personCenterData.cpJ().level_id;
            if (i > 40) {
                i = 40;
            }
            this.idB.setText("Lv" + Integer.toString(i));
            this.idC.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.idD.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.idD.setVisibility(8);
            }
            if (i <= 10) {
                this.idG.setBackgroundResource(R.drawable.icon_live_level_1);
                this.idB.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.idG.setBackgroundResource(R.drawable.icon_live_level_2);
                this.idB.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.idG.setBackgroundResource(R.drawable.icon_live_level_3);
                this.idB.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.idG.setBackgroundResource(R.drawable.icon_live_level_4);
                this.idB.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.idB.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.idG.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.idI.setMax(personCenterData.cpJ().next_exp);
            this.idI.setProgress(personCenterData.cpJ().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cpJ().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cpJ().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.idE.setText(spannableString);
            if (i >= 40) {
                this.idF.setText("");
            } else {
                this.idF.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cpJ().next_exp - personCenterData.cpJ().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ao.setBackgroundResource(this.idJ, R.drawable.bg_live_mine);
        ao.setBackgroundResource(this.idH, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.idC.setAlpha(0.7f);
            this.idD.setAlpha(0.7f);
            this.idF.setAlpha(0.7f);
            this.idE.setAlpha(0.7f);
            this.idI.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cuD() != null) {
            cuD().a(view, this.idL);
        }
    }
}
