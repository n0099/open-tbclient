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
    private View cNV;
    private View daT;
    private RelativeLayout dax;
    private View.OnClickListener eTU = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.iMe) {
                    if (view == FrsProfessionIntroActivity.this.iMf) {
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
    private TextView iMe;
    private View iMf;
    private View iMg;
    private View iMh;
    private TbImageView iMi;
    private LinearGradientView iMj;
    private View iMk;
    private View iMl;
    private View iMm;
    private View iMn;
    private View iMo;
    private View iMp;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.dax = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.iMj = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.iMe = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.iMf = findViewById(R.id.profession_intro_got_it);
        this.cNV = findViewById(R.id.bottom_view);
        this.iMg = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eTU);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.iMi = (TbImageView) findViewById(R.id.profession_intro_content);
        this.iMi.setDefaultBgResource(R.color.transparent);
        this.iMi.setDefaultResource(R.drawable.pic_frs_head_default);
        this.daT = findViewById(R.id.profession_intro_container);
        this.iMh = findViewById(R.id.profession_intro_top_corner);
        this.iMk = findViewById(R.id.profession_intro_first_index);
        this.iMo = findViewById(R.id.profession_intro_first_intro);
        this.iMm = findViewById(R.id.profession_intro_first_title);
        this.iMl = findViewById(R.id.profession_intro_second_index);
        this.iMp = findViewById(R.id.profession_intro_second_intro);
        this.iMn = findViewById(R.id.profession_intro_second_title);
        this.iMe.setEnabled(true);
        this.iMe.setOnClickListener(this.eTU);
        this.iMf.setOnClickListener(this.eTU);
        czb();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.iMj.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.iMi.startLoad(stringExtra, 10, false);
    }

    private void czb() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dax.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.iMj.getLayoutParams();
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
        ap.setViewTextColor(this.iMg, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.iMk, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iMm, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iMo, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.iMl, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.iMn, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iMp, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.iMf, (int) R.color.cp_cont_a);
        ap.setBackgroundColor(this.daT, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.iMh, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.iMf, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.iMe, (int) R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.cNV, R.color.cp_bg_line_d);
        this.iMj.changeSkinType(i);
    }
}
