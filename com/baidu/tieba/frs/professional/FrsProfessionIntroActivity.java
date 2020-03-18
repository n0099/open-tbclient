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
    private View bLV;
    private RelativeLayout bLz;
    private View.OnClickListener drJ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gJy) {
                    if (view == FrsProfessionIntroActivity.this.gJz) {
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
    private View gJA;
    private View gJB;
    private TbImageView gJC;
    private LinearGradientView gJD;
    private View gJE;
    private View gJF;
    private View gJG;
    private View gJH;
    private View gJI;
    private View gJJ;
    private TextView gJy;
    private View gJz;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bLz = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gJD = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gJy = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gJz = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gJA = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.drJ);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gJC = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gJC.setDefaultBgResource(R.color.transparent);
        this.gJC.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bLV = findViewById(R.id.profession_intro_container);
        this.gJB = findViewById(R.id.profession_intro_top_corner);
        this.gJE = findViewById(R.id.profession_intro_first_index);
        this.gJI = findViewById(R.id.profession_intro_first_intro);
        this.gJG = findViewById(R.id.profession_intro_first_title);
        this.gJF = findViewById(R.id.profession_intro_second_index);
        this.gJJ = findViewById(R.id.profession_intro_second_intro);
        this.gJH = findViewById(R.id.profession_intro_second_title);
        this.gJy.setEnabled(true);
        this.gJy.setOnClickListener(this.drJ);
        this.gJz.setOnClickListener(this.drJ);
        bJQ();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gJD.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gJC.startLoad(stringExtra, 10, false);
    }

    private void bJQ() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bLz.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gJD.getLayoutParams();
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
        am.setViewTextColor(this.gJA, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gJE, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gJG, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJI, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gJF, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gJH, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gJJ, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gJz, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bLV, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gJB, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gJz, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gJy, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gJD.changeSkinType(i);
    }
}
