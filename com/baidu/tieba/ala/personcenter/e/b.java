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
    private TextView gdk;
    private TextView gdl;
    private TextView gdm;
    private TextView gdn;
    private TextView gdo;
    private ImageView gdp;
    private ImageView gdq;
    private ProgressBar gdr;
    private FrameLayout gds;
    private View gdt;
    private e gdu;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gds = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gdk = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gdl = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gdm = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gdn = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gdo = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gdp = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gdr = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gdq = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gdt = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bBW() != null) {
            this.gdu = eVar;
            if (personCenterData.bBW().live_status != 1 && !personCenterData.isHost()) {
                this.gdt.setVisibility(8);
                this.gdn.setVisibility(8);
                this.gdo.setVisibility(8);
            } else {
                this.gdt.setVisibility(0);
                this.gdn.setVisibility(0);
                this.gdo.setVisibility(0);
            }
            int i = personCenterData.bBW().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gdk.setText("Lv" + Integer.toString(i));
            this.gdl.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gdm.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gdm.setVisibility(8);
            }
            if (i <= 10) {
                this.gdp.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gdk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gdp.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gdk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gdp.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gdk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gdp.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gdk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gdk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gdp.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gdr.setMax(personCenterData.bBW().next_exp);
            this.gdr.setProgress(personCenterData.bBW().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bBW().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bBW().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gdn.setText(spannableString);
            if (i >= 40) {
                this.gdo.setText(R.string.ala_level_max_tips);
            } else {
                this.gdo.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bBW().next_exp - personCenterData.bBW().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.gds, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.gdq, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gdl.setAlpha(0.7f);
            this.gdm.setAlpha(0.7f);
            this.gdo.setAlpha(0.7f);
            this.gdn.setAlpha(0.7f);
            this.gdr.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bEy() != null) {
            bEy().a(view, this.gdu);
        }
    }
}
