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
    private TextView gXl;
    private TextView gXm;
    private TextView gXn;
    private TextView gXo;
    private TextView gXp;
    private ImageView gXq;
    private ImageView gXr;
    private ProgressBar gXs;
    private FrameLayout gXt;
    private View gXu;
    private e gXv;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        ak(getView());
    }

    private void ak(View view) {
        this.gXt = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.gXl = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.gXm = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.gXn = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.gXo = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.gXp = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.gXq = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.gXs = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.gXr = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.gXu = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.bYE() != null) {
            this.gXv = eVar;
            if (personCenterData.bYE().live_status != 1 && !personCenterData.isHost()) {
                this.gXu.setVisibility(8);
                this.gXo.setVisibility(8);
                this.gXp.setVisibility(8);
            } else {
                this.gXu.setVisibility(0);
                this.gXo.setVisibility(0);
                this.gXp.setVisibility(0);
            }
            int i = personCenterData.bYE().level_id;
            if (i > 40) {
                i = 40;
            }
            this.gXl.setText("Lv" + Integer.toString(i));
            this.gXm.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.gXn.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.gXn.setVisibility(8);
            }
            if (i <= 10) {
                this.gXq.setBackgroundResource(R.drawable.icon_live_level_1);
                this.gXl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.gXq.setBackgroundResource(R.drawable.icon_live_level_2);
                this.gXl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.gXq.setBackgroundResource(R.drawable.icon_live_level_3);
                this.gXl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.gXq.setBackgroundResource(R.drawable.icon_live_level_4);
                this.gXl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.gXl.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.gXq.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.gXs.setMax(personCenterData.bYE().next_exp);
            this.gXs.setProgress(personCenterData.bYE().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.bYE().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.bYE().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.cp_cont_g)), length, sb.length(), 33);
            this.gXo.setText(spannableString);
            if (i >= 40) {
                this.gXp.setText(R.string.ala_level_max_tips);
            } else {
                this.gXp.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.bYE().next_exp - personCenterData.bYE().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.gXt, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.gXr, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.gXm.setAlpha(0.7f);
            this.gXn.setAlpha(0.7f);
            this.gXp.setAlpha(0.7f);
            this.gXo.setAlpha(0.7f);
            this.gXs.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cbA() != null) {
            cbA().a(view, this.gXv);
        }
    }
}
