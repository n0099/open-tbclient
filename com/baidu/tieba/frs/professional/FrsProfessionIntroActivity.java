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
    private View cat;
    private View ckF;
    private RelativeLayout ckj;
    private View.OnClickListener dRF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.hsO) {
                    if (view == FrsProfessionIntroActivity.this.hsP) {
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
    private TextView hsO;
    private View hsP;
    private View hsQ;
    private View hsR;
    private TbImageView hsS;
    private LinearGradientView hsT;
    private View hsU;
    private View hsV;
    private View hsW;
    private View hsX;
    private View hsY;
    private View hsZ;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.ckj = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.hsT = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.hsO = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.hsP = findViewById(R.id.profession_intro_got_it);
        this.cat = findViewById(R.id.bottom_view);
        this.hsQ = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dRF);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.hsS = (TbImageView) findViewById(R.id.profession_intro_content);
        this.hsS.setDefaultBgResource(R.color.transparent);
        this.hsS.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ckF = findViewById(R.id.profession_intro_container);
        this.hsR = findViewById(R.id.profession_intro_top_corner);
        this.hsU = findViewById(R.id.profession_intro_first_index);
        this.hsY = findViewById(R.id.profession_intro_first_intro);
        this.hsW = findViewById(R.id.profession_intro_first_title);
        this.hsV = findViewById(R.id.profession_intro_second_index);
        this.hsZ = findViewById(R.id.profession_intro_second_intro);
        this.hsX = findViewById(R.id.profession_intro_second_title);
        this.hsO.setEnabled(true);
        this.hsO.setOnClickListener(this.dRF);
        this.hsP.setOnClickListener(this.dRF);
        bUn();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.hsT.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.hsS.startLoad(stringExtra, 10, false);
    }

    private void bUn() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.ckj.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.hsT.getLayoutParams();
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
        am.setViewTextColor(this.hsQ, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hsU, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hsW, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hsY, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.hsV, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.hsX, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hsZ, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.hsP, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.ckF, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.hsR, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.hsP, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.hsO, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.cat, R.color.cp_bg_line_d);
        this.hsT.changeSkinType(i);
    }
}
