package com.baidu.tieba.ala.personcenter.e;

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
import com.baidu.tieba.ala.personcenter.c.e;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.b<e> {
    private ImageView gsA;
    private ProgressBar gsB;
    private FrameLayout gsC;
    private View gsD;
    private e gsE;
    private TextView gsu;
    private TextView gsv;
    private TextView gsw;
    private TextView gsx;
    private TextView gsy;
    private ImageView gsz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gsC = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gsu = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gsv = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gsw = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gsx = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gsy = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gsz = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gsB = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gsA = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gsD = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bIp() != null) {
            this.gsE = eVar;
            if (personCenterData.bIp().live_status != 1 && !personCenterData.isHost()) {
                this.gsD.setVisibility(8);
                this.gsx.setVisibility(8);
                this.gsy.setVisibility(8);
            } else {
                this.gsD.setVisibility(0);
                this.gsx.setVisibility(0);
                this.gsy.setVisibility(0);
            }
            int i = personCenterData.bIp().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gsu.setText("Lv" + Integer.toString(i));
            this.gsv.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gsw.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gsw.setVisibility(8);
            }
            if (i <= 10) {
                this.gsz.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gsu.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gsz.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gsu.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gsz.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gsu.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gsz.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gsu.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gsu.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gsz.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gsB.setMax(personCenterData.bIp().next_exp);
            this.gsB.setProgress(personCenterData.bIp().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bIp().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bIp().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gsx.setText(spannableString);
            if (i >= 40) {
                this.gsy.setText(R.string.ala_level_max_tips);
            } else {
                this.gsy.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bIp().next_exp - personCenterData.bIp().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.gsC, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.gsA, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gsv.setAlpha(0.7f);
            this.gsw.setAlpha(0.7f);
            this.gsy.setAlpha(0.7f);
            this.gsx.setAlpha(0.7f);
            this.gsB.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKU() != null) {
            bKU().a(view, this.gsE);
        }
    }
}
