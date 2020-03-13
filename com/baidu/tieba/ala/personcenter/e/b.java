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
import com.baidu.tieba.ala.personcenter.c.d;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<d> {
    private TextView fye;
    private TextView fyf;
    private TextView fyg;
    private TextView fyh;
    private TextView fyi;
    private ImageView fyj;
    private ImageView fyk;
    private ProgressBar fyl;
    private FrameLayout fym;
    private View fyn;
    private d fyo;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        initView(getView());
    }

    private void initView(View view) {
        this.fym = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.fye = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.fyf = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.fyg = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.fyh = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.fyi = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.fyj = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.fyl = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.fyk = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.fyn = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bsi() != null) {
            this.fyo = dVar;
            if (personCenterData.bsi().live_status != 1 && !personCenterData.isHost()) {
                this.fyn.setVisibility(8);
                this.fyh.setVisibility(8);
                this.fyi.setVisibility(8);
            } else {
                this.fyn.setVisibility(0);
                this.fyh.setVisibility(0);
                this.fyi.setVisibility(0);
            }
            int i = personCenterData.bsi().level_id;
            if (i > 40) {
                i = 40;
            }
            this.fye.setText("Lv" + Integer.toString(i));
            this.fyf.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.fyg.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.fyg.setVisibility(8);
            }
            if (i <= 10) {
                this.fyj.setBackgroundResource(R.drawable.icon_live_level_1);
                this.fye.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.fyj.setBackgroundResource(R.drawable.icon_live_level_2);
                this.fye.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.fyj.setBackgroundResource(R.drawable.icon_live_level_3);
                this.fye.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.fyj.setBackgroundResource(R.drawable.icon_live_level_4);
                this.fye.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.fye.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.fyj.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.fyl.setMax(personCenterData.bsi().next_exp);
            this.fyl.setProgress(personCenterData.bsi().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bsi().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bsi().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.fyh.setText(spannableString);
            if (i >= 40) {
                this.fyi.setText(R.string.ala_level_max_tips);
            } else {
                this.fyi.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bsi().next_exp - personCenterData.bsi().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.fym, R.drawable.bg_live_mine);
        am.setBackgroundResource(this.fyk, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.fyf.setAlpha(0.7f);
            this.fyg.setAlpha(0.7f);
            this.fyi.setAlpha(0.7f);
            this.fyh.setAlpha(0.7f);
            this.fyl.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (buH() != null) {
            buH().a(view, this.fyo);
        }
    }
}
