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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
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
    private RelativeLayout bdH;
    private View bef;
    private View.OnClickListener cze = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.fOE) {
                    if (view == FrsProfessionIntroActivity.this.fOF) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(FrsProfessionIntroActivity.this.getActivity()).createNormalCfg("5977226324", null, "frs")));
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
    private View doY;
    private TextView fOE;
    private View fOF;
    private View fOG;
    private View fOH;
    private TbImageView fOI;
    private LinearGradientView fOJ;
    private View fOK;
    private View fOL;
    private View fOM;
    private View fON;
    private View fOO;
    private View fOP;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bdH = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fOJ = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fOE = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fOF = findViewById(R.id.profession_intro_got_it);
        this.doY = findViewById(R.id.bottom_view);
        this.fOG = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cze);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fOI = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fOI.setDefaultBgResource(R.color.transparent);
        this.fOI.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bef = findViewById(R.id.profession_intro_container);
        this.fOH = findViewById(R.id.profession_intro_top_corner);
        this.fOK = findViewById(R.id.profession_intro_first_index);
        this.fOO = findViewById(R.id.profession_intro_first_intro);
        this.fOM = findViewById(R.id.profession_intro_first_title);
        this.fOL = findViewById(R.id.profession_intro_second_index);
        this.fOP = findViewById(R.id.profession_intro_second_intro);
        this.fON = findViewById(R.id.profession_intro_second_title);
        this.fOE.setEnabled(true);
        this.fOE.setOnClickListener(this.cze);
        this.fOF.setOnClickListener(this.cze);
        bpA();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fOJ.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fOI.startLoad(stringExtra, 10, false);
    }

    private void bpA() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bdH.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.fOJ.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).height = dimens;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fOG, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fOK, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fOM, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fOO, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fOL, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fON, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fOP, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fOF, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bef, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fOH, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.fOF, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.fOE, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.doY, R.color.cp_bg_line_d);
        this.fOJ.changeSkinType(i);
    }
}
