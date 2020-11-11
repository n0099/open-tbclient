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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View dcl;
    private RelativeLayout doV;
    private View dpq;
    private View.OnClickListener fii = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jex) {
                    if (view == FrsProfessionIntroActivity.this.jey) {
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
    private View jeA;
    private TbImageView jeB;
    private LinearGradientView jeC;
    private View jeD;
    private View jeE;
    private View jeF;
    private View jeG;
    private View jeH;
    private View jeI;
    private TextView jex;
    private View jey;
    private View jez;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.doV = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jeC = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jex = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jey = findViewById(R.id.profession_intro_got_it);
        this.dcl = findViewById(R.id.bottom_view);
        this.jez = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fii);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jeB = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jeB.setDefaultBgResource(R.color.transparent);
        this.jeB.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dpq = findViewById(R.id.profession_intro_container);
        this.jeA = findViewById(R.id.profession_intro_top_corner);
        this.jeD = findViewById(R.id.profession_intro_first_index);
        this.jeH = findViewById(R.id.profession_intro_first_intro);
        this.jeF = findViewById(R.id.profession_intro_first_title);
        this.jeE = findViewById(R.id.profession_intro_second_index);
        this.jeI = findViewById(R.id.profession_intro_second_intro);
        this.jeG = findViewById(R.id.profession_intro_second_title);
        this.jex.setEnabled(true);
        this.jex.setOnClickListener(this.fii);
        this.jey.setOnClickListener(this.fii);
        cEJ();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jeC.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jeB.startLoad(stringExtra, 10, false);
    }

    private void cEJ() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.doV.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jeC.getLayoutParams();
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
        ap.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.jez, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.jeD, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.jeF, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.jeH, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.jeE, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.jeG, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.jeI, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.jey, (int) R.color.cp_cont_a);
        ap.setBackgroundColor(this.dpq, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.jeA, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.jey, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.jex, (int) R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.dcl, R.color.cp_bg_line_d);
        this.jeC.changeSkinType(i);
    }
}
