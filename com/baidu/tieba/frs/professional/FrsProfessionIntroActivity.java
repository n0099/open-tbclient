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
    private View cfb;
    private View.OnClickListener clU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.cfb) {
                if (view != FrsProfessionIntroActivity.this.fNx) {
                    if (view == FrsProfessionIntroActivity.this.fNy) {
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
    private View deB;
    private View fNA;
    private TbImageView fNB;
    private LinearGradientView fNC;
    private View fND;
    private View fNE;
    private View fNF;
    private View fNG;
    private View fNH;
    private View fNI;
    private TextView fNx;
    private View fNy;
    private View fNz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.aKo = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fNC = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fNx = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fNy = findViewById(R.id.profession_intro_got_it);
        this.deB = findViewById(R.id.bottom_view);
        this.fNz = findViewById(R.id.profession_intro_desc);
        this.cfb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.clU);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fNB = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fNB.setDefaultBgResource(R.color.transparent);
        this.fNB.setDefaultResource(R.drawable.pic_frs_head_default);
        this.aKO = findViewById(R.id.profession_intro_container);
        this.fNA = findViewById(R.id.profession_intro_top_corner);
        this.fND = findViewById(R.id.profession_intro_first_index);
        this.fNH = findViewById(R.id.profession_intro_first_intro);
        this.fNF = findViewById(R.id.profession_intro_first_title);
        this.fNE = findViewById(R.id.profession_intro_second_index);
        this.fNI = findViewById(R.id.profession_intro_second_intro);
        this.fNG = findViewById(R.id.profession_intro_second_title);
        this.fNx.setEnabled(true);
        this.fNx.setOnClickListener(this.clU);
        this.fNy.setOnClickListener(this.clU);
        bry();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fNC.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fNB.startLoad(stringExtra, 10, false);
    }

    private void bry() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aKo.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = g;
                ViewGroup.LayoutParams layoutParams2 = this.fNC.getLayoutParams();
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
        am.j(this.fNz, R.color.cp_btn_a);
        am.j(this.fND, R.color.cp_cont_g);
        am.j(this.fNF, R.color.cp_cont_b);
        am.j(this.fNH, R.color.cp_cont_f);
        am.j(this.fNE, R.color.cp_cont_g);
        am.j(this.fNG, R.color.cp_cont_b);
        am.j(this.fNI, R.color.cp_cont_f);
        am.j(this.fNy, R.color.cp_btn_a);
        am.l(this.aKO, R.color.cp_bg_line_d);
        am.k(this.fNA, R.drawable.bg_top_corner_white);
        am.c(this.mNavigationBar.getBackImageView(), (int) R.drawable.btn_sml_back_selector_s);
        am.k(this.fNy, R.drawable.frs_profession_button_bg);
        am.j(this.fNx, R.color.cp_link_tip_a);
        am.l(this.deB, R.color.cp_bg_line_d);
        this.fNC.changeSkinType(i);
    }
}
