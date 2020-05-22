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
/* loaded from: classes9.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View clc;
    private RelativeLayout cvT;
    private View cwp;
    private View.OnClickListener ege = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.hHI) {
                    if (view == FrsProfessionIntroActivity.this.hHJ) {
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
    private TextView hHI;
    private View hHJ;
    private View hHK;
    private View hHL;
    private TbImageView hHM;
    private LinearGradientView hHN;
    private View hHO;
    private View hHP;
    private View hHQ;
    private View hHR;
    private View hHS;
    private View hHT;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cvT = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.hHN = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.hHI = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.hHJ = findViewById(R.id.profession_intro_got_it);
        this.clc = findViewById(R.id.bottom_view);
        this.hHK = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ege);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.hHM = (TbImageView) findViewById(R.id.profession_intro_content);
        this.hHM.setDefaultBgResource(R.color.transparent);
        this.hHM.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cwp = findViewById(R.id.profession_intro_container);
        this.hHL = findViewById(R.id.profession_intro_top_corner);
        this.hHO = findViewById(R.id.profession_intro_first_index);
        this.hHS = findViewById(R.id.profession_intro_first_intro);
        this.hHQ = findViewById(R.id.profession_intro_first_title);
        this.hHP = findViewById(R.id.profession_intro_second_index);
        this.hHT = findViewById(R.id.profession_intro_second_intro);
        this.hHR = findViewById(R.id.profession_intro_second_title);
        this.hHI.setEnabled(true);
        this.hHI.setOnClickListener(this.ege);
        this.hHJ.setOnClickListener(this.ege);
        caJ();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.hHN.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.hHM.startLoad(stringExtra, 10, false);
    }

    private void caJ() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cvT.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.hHN.getLayoutParams();
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
        am.setViewTextColor(this.hHK, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hHO, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hHQ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hHS, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.hHP, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hHR, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hHT, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.hHJ, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.cwp, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.hHL, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.hHJ, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.hHI, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.clc, R.color.cp_bg_line_d);
        this.hHN.changeSkinType(i);
    }
}
