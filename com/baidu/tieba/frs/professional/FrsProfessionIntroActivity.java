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
/* loaded from: classes16.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View cMO;
    private RelativeLayout cMt;
    private View czP;
    private View.OnClickListener eFG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.ipV) {
                    if (view == FrsProfessionIntroActivity.this.ipW) {
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
    private TextView ipV;
    private View ipW;
    private View ipX;
    private View ipY;
    private TbImageView ipZ;
    private LinearGradientView iqa;
    private View iqb;
    private View iqc;
    private View iqd;
    private View iqe;
    private View iqf;
    private View iqg;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cMt = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.iqa = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.ipV = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.ipW = findViewById(R.id.profession_intro_got_it);
        this.czP = findViewById(R.id.bottom_view);
        this.ipX = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eFG);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.ipZ = (TbImageView) findViewById(R.id.profession_intro_content);
        this.ipZ.setDefaultBgResource(R.color.transparent);
        this.ipZ.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cMO = findViewById(R.id.profession_intro_container);
        this.ipY = findViewById(R.id.profession_intro_top_corner);
        this.iqb = findViewById(R.id.profession_intro_first_index);
        this.iqf = findViewById(R.id.profession_intro_first_intro);
        this.iqd = findViewById(R.id.profession_intro_first_title);
        this.iqc = findViewById(R.id.profession_intro_second_index);
        this.iqg = findViewById(R.id.profession_intro_second_intro);
        this.iqe = findViewById(R.id.profession_intro_second_title);
        this.ipV.setEnabled(true);
        this.ipV.setOnClickListener(this.eFG);
        this.ipW.setOnClickListener(this.eFG);
        csp();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.iqa.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.ipZ.startLoad(stringExtra, 10, false);
    }

    private void csp() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cMt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.iqa.getLayoutParams();
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
        ap.setViewTextColor(this.ipX, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.iqb, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iqd, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iqf, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.iqc, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iqe, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iqg, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.ipW, (int) R.color.cp_cont_a);
        ap.setBackgroundColor(this.cMO, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.ipY, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.ipW, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.ipV, (int) R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.czP, R.color.cp_bg_line_d);
        this.iqa.changeSkinType(i);
    }
}
