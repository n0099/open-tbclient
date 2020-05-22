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
    private TextView gsj;
    private TextView gsk;
    private TextView gsl;
    private TextView gsm;
    private TextView gsn;
    private ImageView gso;
    private ImageView gsp;
    private ProgressBar gsq;
    private FrameLayout gsr;
    private View gss;
    private e gst;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ag(getView());
    }

    private void ag(View view) {
        this.gsr = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gsj = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gsk = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gsl = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gsm = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gsn = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gso = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gsq = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gsp = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gss = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bIn() != null) {
            this.gst = eVar;
            if (personCenterData.bIn().live_status != 1 && !personCenterData.isHost()) {
                this.gss.setVisibility(8);
                this.gsm.setVisibility(8);
                this.gsn.setVisibility(8);
            } else {
                this.gss.setVisibility(0);
                this.gsm.setVisibility(0);
                this.gsn.setVisibility(0);
            }
            int i = personCenterData.bIn().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gsj.setText("Lv" + Integer.toString(i));
            this.gsk.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gsl.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gsl.setVisibility(8);
            }
            if (i <= 10) {
                this.gso.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gsj.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gso.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gsj.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gso.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gsj.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gso.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gsj.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gsj.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gso.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gsq.setMax(personCenterData.bIn().next_exp);
            this.gsq.setProgress(personCenterData.bIn().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bIn().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bIn().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gsm.setText(spannableString);
            if (i >= 40) {
                this.gsn.setText(R.string.ala_level_max_tips);
            } else {
                this.gsn.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bIn().next_exp - personCenterData.bIn().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.gsr, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.gsp, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gsk.setAlpha(0.7f);
            this.gsl.setAlpha(0.7f);
            this.gsn.setAlpha(0.7f);
            this.gsm.setAlpha(0.7f);
            this.gsq.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (bKS() != null) {
            bKS().a(view, this.gst);
        }
    }
}
