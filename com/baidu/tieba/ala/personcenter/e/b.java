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
    private TextView gXh;
    private TextView gXi;
    private TextView gXj;
    private TextView gXk;
    private TextView gXl;
    private ImageView gXm;
    private ImageView gXn;
    private ProgressBar gXo;
    private FrameLayout gXp;
    private View gXq;
    private e gXr;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ak(getView());
    }

    private void ak(View view) {
        this.gXp = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gXh = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gXi = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gXj = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gXk = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gXl = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gXm = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gXo = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gXn = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gXq = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bYD() != null) {
            this.gXr = eVar;
            if (personCenterData.bYD().live_status != 1 && !personCenterData.isHost()) {
                this.gXq.setVisibility(8);
                this.gXk.setVisibility(8);
                this.gXl.setVisibility(8);
            } else {
                this.gXq.setVisibility(0);
                this.gXk.setVisibility(0);
                this.gXl.setVisibility(0);
            }
            int i = personCenterData.bYD().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gXh.setText("Lv" + Integer.toString(i));
            this.gXi.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gXj.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gXj.setVisibility(8);
            }
            if (i <= 10) {
                this.gXm.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gXh.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gXm.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gXh.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gXm.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gXh.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gXm.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gXh.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gXh.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gXm.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gXo.setMax(personCenterData.bYD().next_exp);
            this.gXo.setProgress(personCenterData.bYD().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bYD().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bYD().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gXk.setText(spannableString);
            if (i >= 40) {
                this.gXl.setText(R.string.ala_level_max_tips);
            } else {
                this.gXl.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bYD().next_exp - personCenterData.bYD().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.gXp, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.gXn, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gXi.setAlpha(0.7f);
            this.gXj.setAlpha(0.7f);
            this.gXl.setAlpha(0.7f);
            this.gXk.setAlpha(0.7f);
            this.gXo.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbz() != null) {
            cbz().a(view, this.gXr);
        }
    }
}
