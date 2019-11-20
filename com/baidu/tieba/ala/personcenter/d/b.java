package com.baidu.tieba.ala.personcenter.d;

import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.personcenter.c.d;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<d> {
    private TextView eAF;
    private TextView eAG;
    private TextView eAH;
    private TextView eAI;
    private TextView eAJ;
    private ImageView eAK;
    private ImageView eAL;
    private ProgressBar eAM;
    private FrameLayout eAN;
    private View eAO;
    private d eAP;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        W(getView());
    }

    private void W(View view) {
        this.eAN = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.eAF = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.eAG = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.eAH = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.eAI = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.eAJ = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.eAK = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.eAM = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.eAL = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.eAO = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(d dVar) {
        com.baidu.tieba.ala.personcenter.c.b personCenterData = dVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.aXC() != null) {
            this.eAP = dVar;
            if (personCenterData.aXC().live_status != 1 && !personCenterData.isHost()) {
                this.eAO.setVisibility(8);
                this.eAI.setVisibility(8);
                this.eAJ.setVisibility(8);
            } else {
                this.eAO.setVisibility(0);
                this.eAI.setVisibility(0);
                this.eAJ.setVisibility(0);
            }
            int i = personCenterData.aXC().level_id;
            if (i > 40) {
                i = 40;
            }
            this.eAF.setText("Lv" + Integer.toString(i));
            this.eAG.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.eAH.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.eAH.setVisibility(8);
            }
            if (i <= 10) {
                this.eAK.setBackgroundResource(R.drawable.icon_live_level_1);
                this.eAF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.eAK.setBackgroundResource(R.drawable.icon_live_level_2);
                this.eAF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.eAK.setBackgroundResource(R.drawable.icon_live_level_3);
                this.eAF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.eAK.setBackgroundResource(R.drawable.icon_live_level_4);
                this.eAF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.eAF.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.eAK.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.eAM.setMax(personCenterData.aXC().next_exp);
            this.eAM.setProgress(personCenterData.aXC().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.aXC().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.aXC().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.eAI.setText(spannableString);
            if (i >= 40) {
                this.eAJ.setText(R.string.ala_level_max_tips);
            } else {
                this.eAJ.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.aXC().next_exp - personCenterData.aXC().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.eAN, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.eAL, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.eAG.setAlpha(0.7f);
            this.eAH.setAlpha(0.7f);
            this.eAJ.setAlpha(0.7f);
            this.eAI.setAlpha(0.7f);
            this.eAM.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.eAP);
        }
    }
}
