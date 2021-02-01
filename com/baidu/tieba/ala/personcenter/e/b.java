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
import com.baidu.tieba.ala.personcenter.c.f;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<f> {
    private TextView idk;
    private TextView idm;
    private TextView idn;
    private TextView ido;
    private TextView idp;
    private ImageView idq;
    private ImageView idr;
    private ProgressBar idu;
    private FrameLayout idv;
    private View idw;
    private f idy;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        am(getView());
    }

    private void am(View view) {
        this.idv = (FrameLayout) view.findViewById(R.id.ala_person_center_header_bg);
        this.idk = (TextView) view.findViewById(R.id.ala_person_center_level);
        this.idm = (TextView) view.findViewById(R.id.ala_person_center_level_cur_text);
        this.idn = (TextView) view.findViewById(R.id.ala_person_center_level_next_text);
        this.ido = (TextView) view.findViewById(R.id.ala_person_center_exp_txt);
        this.idp = (TextView) view.findViewById(R.id.ala_person_center_tips);
        this.idq = (ImageView) view.findViewById(R.id.ala_person_center_level_img);
        this.idu = (ProgressBar) view.findViewById(R.id.ala_person_center_level_progress);
        this.idr = (ImageView) view.findViewById(R.id.ala_person_center_bg_aiglet);
        this.idw = view.findViewById(R.id.ala_person_center_level_layout);
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
        if (personCenterData != null && personCenterData.cmP() != null) {
            this.idy = fVar;
            if (personCenterData.cmP().live_status != 1 && !personCenterData.isHost()) {
                this.idw.setVisibility(8);
                this.ido.setVisibility(8);
                this.idp.setVisibility(8);
            } else {
                this.idw.setVisibility(0);
                this.ido.setVisibility(0);
                this.idp.setVisibility(0);
            }
            int i = personCenterData.cmP().level_id;
            if (i > 40) {
                i = 40;
            }
            this.idk.setText("Lv" + Integer.toString(i));
            this.idm.setText("Lv" + Integer.toString(i));
            if (i < 40) {
                this.idn.setText("Lv" + Integer.toString(i + 1));
            } else {
                this.idn.setVisibility(8);
            }
            if (i <= 10) {
                this.idq.setBackgroundResource(R.drawable.icon_live_level_1);
                this.idk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_1));
            } else if (i <= 20) {
                this.idq.setBackgroundResource(R.drawable.icon_live_level_2);
                this.idk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_2));
            } else if (i <= 30) {
                this.idq.setBackgroundResource(R.drawable.icon_live_level_3);
                this.idk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_3));
            } else if (i <= 40) {
                this.idq.setBackgroundResource(R.drawable.icon_live_level_4);
                this.idk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_4));
            } else {
                this.idk.setTextColor(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_color_level_5));
                this.idq.setBackgroundResource(R.drawable.icon_live_level_5);
            }
            this.idu.setMax(personCenterData.cmP().next_exp);
            this.idu.setProgress(personCenterData.cmP().level_exp);
            StringBuilder sb = new StringBuilder();
            sb.append(Integer.toString(personCenterData.cmP().level_exp));
            int length = sb.length();
            sb.append("/").append(Integer.toString(personCenterData.cmP().next_exp));
            SpannableString spannableString = new SpannableString(sb.toString());
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.ala_person_center_exp_text)), 0, length, 33);
            spannableString.setSpan(new ForegroundColorSpan(this.mTbPageContext.getPageActivity().getResources().getColor(R.color.CAM_X0111)), length, sb.length(), 33);
            this.ido.setText(spannableString);
            if (i >= 40) {
                this.idp.setText("");
            } else {
                this.idp.setText(String.format(this.mTbPageContext.getPageActivity().getResources().getString(R.string.ala_level_next_tips), Integer.valueOf(personCenterData.cmP().next_exp - personCenterData.cmP().level_exp)));
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.idv, R.drawable.bg_live_mine);
        ap.setBackgroundResource(this.idr, R.drawable.bg1_live_mine);
        if (i == 1) {
            this.idm.setAlpha(0.7f);
            this.idn.setAlpha(0.7f);
            this.idp.setAlpha(0.7f);
            this.ido.setAlpha(0.7f);
            this.idu.setAlpha(0.7f);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (crV() != null) {
            crV().a(view, this.idy);
        }
    }
}
