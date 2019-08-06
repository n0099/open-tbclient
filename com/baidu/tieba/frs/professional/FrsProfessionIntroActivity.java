package com.baidu.tieba.frs.professional;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View aKO;
    private RelativeLayout aKo;
    private View cfi;
    private View.OnClickListener cmb = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.cfi) {
                if (view != FrsProfessionIntroActivity.this.fOl) {
                    if (view == FrsProfessionIntroActivity.this.fOm) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FrsProfessionIntroActivity.this.getActivity()).createNormalCfg("5977226324", null, "frs")));
                        Intent intent = new Intent();
                        intent.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
                        FrsProfessionIntroActivity.this.setResult(-1, intent);
                        FrsProfessionIntroActivity.this.finish();
                        return;
                    }
                    return;
                }
                Intent intent2 = new Intent();
                intent2.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, 1);
                FrsProfessionIntroActivity.this.setResult(-1, intent2);
                FrsProfessionIntroActivity.this.finish();
                return;
            }
            Intent intent3 = new Intent();
            intent3.putExtra(FrsProfessionIntroActivityConfig.KEY_RESULT, -1);
            FrsProfessionIntroActivity.this.setResult(-1, intent3);
            FrsProfessionIntroActivity.this.finish();
        }
    };
    private View deI;
    private TextView fOl;
    private View fOm;
    private View fOn;
    private View fOo;
    private TbImageView fOp;
    private LinearGradientView fOq;
    private View fOr;
    private View fOs;
    private View fOt;
    private View fOu;
    private View fOv;
    private View fOw;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.aKo = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fOq = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fOl = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fOm = findViewById(R.id.profession_intro_got_it);
        this.deI = findViewById(R.id.bottom_view);
        this.fOn = findViewById(R.id.profession_intro_desc);
        this.cfi = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cmb);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fOp = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fOp.setDefaultBgResource(R.color.transparent);
        this.fOp.setDefaultResource(R.drawable.pic_frs_head_default);
        this.aKO = findViewById(R.id.profession_intro_container);
        this.fOo = findViewById(R.id.profession_intro_top_corner);
        this.fOr = findViewById(R.id.profession_intro_first_index);
        this.fOv = findViewById(R.id.profession_intro_first_intro);
        this.fOt = findViewById(R.id.profession_intro_first_title);
        this.fOs = findViewById(R.id.profession_intro_second_index);
        this.fOw = findViewById(R.id.profession_intro_second_intro);
        this.fOu = findViewById(R.id.profession_intro_second_title);
        this.fOl.setEnabled(true);
        this.fOl.setOnClickListener(this.cmb);
        this.fOm.setOnClickListener(this.cmb);
        brL();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fOq.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fOp.startLoad(stringExtra, 10, false);
    }

    private void brL() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aKo.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = g;
                ViewGroup.LayoutParams layoutParams2 = this.fOq.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).height = g;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        am.j(this.fOn, R.color.cp_btn_a);
        am.j(this.fOr, R.color.cp_cont_g);
        am.j(this.fOt, R.color.cp_cont_b);
        am.j(this.fOv, R.color.cp_cont_f);
        am.j(this.fOs, R.color.cp_cont_g);
        am.j(this.fOu, R.color.cp_cont_b);
        am.j(this.fOw, R.color.cp_cont_f);
        am.j(this.fOm, R.color.cp_btn_a);
        am.l(this.aKO, R.color.cp_bg_line_d);
        am.k(this.fOo, R.drawable.bg_top_corner_white);
        am.c(this.mNavigationBar.getBackImageView(), (int) R.drawable.btn_sml_back_selector_s);
        am.k(this.fOm, R.drawable.frs_profession_button_bg);
        am.j(this.fOl, R.color.cp_link_tip_a);
        am.l(this.deI, R.color.cp_bg_line_d);
        this.fOq.changeSkinType(i);
    }
}
