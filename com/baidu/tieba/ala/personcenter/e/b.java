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
public class b extends com.baidu.tieba.card.a<e> {
    private TextView gdp;
    private TextView gdq;
    private TextView gdr;
    private TextView gds;
    private TextView gdt;
    private ImageView gdu;
    private ImageView gdv;
    private ProgressBar gdw;
    private FrameLayout gdx;
    private View gdy;
    private e gdz;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gdx = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gdp = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gdq = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gdr = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gds = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gdt = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gdu = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gdw = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gdv = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gdy = view.findViewById(R.id.ala_person_center_level_layout);
        getView().setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.ala_person_center_list_head_item;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    /* renamed from: b */
    public void a(e eVar) {
        com.baidu.tieba.ala.personcenter.c.c personCenterData = eVar.getPersonCenterData();
        if (personCenterData != null && personCenterData.bBU() != null) {
            this.gdz = eVar;
            if (personCenterData.bBU().live_status != 1 && !personCenterData.isHost()) {
                this.gdy.setVisibility(8);
                this.gds.setVisibility(8);
                this.gdt.setVisibility(8);
            } else {
                this.gdy.setVisibility(0);
                this.gds.setVisibility(0);
                this.gdt.setVisibility(0);
            }
            int i = personCenterData.bBU().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gdp.setText("Lv" + Integer.toString(i));
            this.gdq.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gdr.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gdr.setVisibility(8);
            }
            if (i <= 10) {
                this.gdu.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gdp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gdu.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gdp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gdu.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gdp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gdu.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gdp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gdp.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gdu.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gdw.setMax(personCenterData.bBU().next_exp);
            this.gdw.setProgress(personCenterData.bBU().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bBU().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bBU().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gds.setText(spannableString);
            if (i >= 40) {
                this.gdt.setText(R.string.ala_level_max_tips);
            } else {
                this.gdt.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bBU().next_exp - personCenterData.bBU().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.gdx, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.gdv, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gdq.setAlpha(0.7f);
            this.gdr.setAlpha(0.7f);
            this.gdt.setAlpha(0.7f);
            this.gds.setAlpha(0.7f);
            this.gdw.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEx() != null) {
            bEx().a(view, this.gdz);
        }
    }
}
