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
    private View caz;
    private View ckL;
    private RelativeLayout ckp;
    private View.OnClickListener dRK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.hsU) {
                    if (view == FrsProfessionIntroActivity.this.hsV) {
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
    private TextView hsU;
    private View hsV;
    private View hsW;
    private View hsX;
    private TbImageView hsY;
    private LinearGradientView hsZ;
    private View hta;
    private View htb;
    private View htc;
    private View htd;
    private View hte;
    private View htf;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.ckp = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.hsZ = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.hsU = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.hsV = findViewById(R.id.profession_intro_got_it);
        this.caz = findViewById(R.id.bottom_view);
        this.hsW = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dRK);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.hsY = (TbImageView) findViewById(R.id.profession_intro_content);
        this.hsY.setDefaultBgResource(R.color.transparent);
        this.hsY.setDefaultResource(R.drawable.pic_frs_head_default);
        this.ckL = findViewById(R.id.profession_intro_container);
        this.hsX = findViewById(R.id.profession_intro_top_corner);
        this.hta = findViewById(R.id.profession_intro_first_index);
        this.hte = findViewById(R.id.profession_intro_first_intro);
        this.htc = findViewById(R.id.profession_intro_first_title);
        this.htb = findViewById(R.id.profession_intro_second_index);
        this.htf = findViewById(R.id.profession_intro_second_intro);
        this.htd = findViewById(R.id.profession_intro_second_title);
        this.hsU.setEnabled(true);
        this.hsU.setOnClickListener(this.dRK);
        this.hsV.setOnClickListener(this.dRK);
        bUl();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.hsZ.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.hsY.startLoad(stringExtra, 10, false);
    }

    private void bUl() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.ckp.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.hsZ.getLayoutParams();
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
        am.setViewTextColor(this.hsW, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.hta, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.htc, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.hte, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.htb, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.htd, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.htf, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.hsV, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.ckL, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.hsX, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.hsV, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.hsU, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.caz, R.color.cp_bg_line_d);
        this.hsZ.changeSkinType(i);
    }
}
