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
    private RelativeLayout bdZ;
    private View bez;
    private View.OnClickListener czV = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.fPv) {
                    if (view == FrsProfessionIntroActivity.this.fPw) {
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
    private View dpP;
    private LinearGradientView fPA;
    private View fPB;
    private View fPC;
    private View fPD;
    private View fPE;
    private View fPF;
    private View fPG;
    private TextView fPv;
    private View fPw;
    private View fPx;
    private View fPy;
    private TbImageView fPz;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bdZ = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fPA = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fPv = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fPw = findViewById(R.id.profession_intro_got_it);
        this.dpP = findViewById(R.id.bottom_view);
        this.fPx = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.czV);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fPz = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fPz.setDefaultBgResource(R.color.transparent);
        this.fPz.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bez = findViewById(R.id.profession_intro_container);
        this.fPy = findViewById(R.id.profession_intro_top_corner);
        this.fPB = findViewById(R.id.profession_intro_first_index);
        this.fPF = findViewById(R.id.profession_intro_first_intro);
        this.fPD = findViewById(R.id.profession_intro_first_title);
        this.fPC = findViewById(R.id.profession_intro_second_index);
        this.fPG = findViewById(R.id.profession_intro_second_intro);
        this.fPE = findViewById(R.id.profession_intro_second_title);
        this.fPv.setEnabled(true);
        this.fPv.setOnClickListener(this.czV);
        this.fPw.setOnClickListener(this.czV);
        bpC();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fPA.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fPz.startLoad(stringExtra, 10, false);
    }

    private void bpC() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bdZ.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.fPA.getLayoutParams();
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
        am.setViewTextColor(this.fPx, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.fPB, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fPD, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPF, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fPC, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.fPE, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.fPG, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.fPw, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bez, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.fPy, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.fPw, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.fPv, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.dpP, R.color.cp_bg_line_d);
        this.fPA.changeSkinType(i);
    }
}
