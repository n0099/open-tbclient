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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes16.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View cDM;
    private RelativeLayout cDr;
    private View crW;
    private View.OnClickListener eve = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.ibG) {
                    if (view == FrsProfessionIntroActivity.this.ibH) {
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
    private TextView ibG;
    private View ibH;
    private View ibI;
    private View ibJ;
    private TbImageView ibK;
    private LinearGradientView ibL;
    private View ibM;
    private View ibN;
    private View ibO;
    private View ibP;
    private View ibQ;
    private View ibR;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cDr = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.ibL = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.ibG = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.ibH = findViewById(R.id.profession_intro_got_it);
        this.crW = findViewById(R.id.bottom_view);
        this.ibI = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eve);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.ibK = (TbImageView) findViewById(R.id.profession_intro_content);
        this.ibK.setDefaultBgResource(R.color.transparent);
        this.ibK.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cDM = findViewById(R.id.profession_intro_container);
        this.ibJ = findViewById(R.id.profession_intro_top_corner);
        this.ibM = findViewById(R.id.profession_intro_first_index);
        this.ibQ = findViewById(R.id.profession_intro_first_intro);
        this.ibO = findViewById(R.id.profession_intro_first_title);
        this.ibN = findViewById(R.id.profession_intro_second_index);
        this.ibR = findViewById(R.id.profession_intro_second_intro);
        this.ibP = findViewById(R.id.profession_intro_second_title);
        this.ibG.setEnabled(true);
        this.ibG.setOnClickListener(this.eve);
        this.ibH.setOnClickListener(this.eve);
        chK();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.ibL.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.ibK.startLoad(stringExtra, 10, false);
    }

    private void chK() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cDr.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.ibL.getLayoutParams();
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
        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        ao.setViewTextColor(this.ibI, R.color.cp_cont_a);
        ao.setViewTextColor(this.ibM, R.color.cp_cont_g);
        ao.setViewTextColor(this.ibO, R.color.cp_cont_b);
        ao.setViewTextColor(this.ibQ, R.color.cp_cont_f);
        ao.setViewTextColor(this.ibN, R.color.cp_cont_g);
        ao.setViewTextColor(this.ibP, R.color.cp_cont_b);
        ao.setViewTextColor(this.ibR, R.color.cp_cont_f);
        ao.setViewTextColor(this.ibH, R.color.cp_cont_a);
        ao.setBackgroundColor(this.cDM, R.color.cp_bg_line_d);
        ao.setBackgroundResource(this.ibJ, R.drawable.bg_top_corner_white);
        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ao.setBackgroundResource(this.ibH, R.drawable.frs_profession_button_bg);
        ao.setViewTextColor(this.ibG, R.color.cp_link_tip_a);
        ao.setBackgroundColor(this.crW, R.color.cp_bg_line_d);
        this.ibL.changeSkinType(i);
    }
}
