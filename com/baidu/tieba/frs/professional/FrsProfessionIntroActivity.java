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
/* loaded from: classes2.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View dhG;
    private RelativeLayout dvL;
    private View dwh;
    private TextView jAE;
    private View jAF;
    private View jAG;
    private View jAH;
    private TbImageView jAI;
    private LinearGradientView jAJ;
    private View jAK;
    private View jAL;
    private View jAM;
    private View jAN;
    private View jAO;
    private View jAP;
    private View mBack;
    private NavigationBar mNavigationBar;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jAE) {
                    if (view == FrsProfessionIntroActivity.this.jAF) {
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

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.dvL = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jAJ = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jAE = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jAF = findViewById(R.id.profession_intro_got_it);
        this.dhG = findViewById(R.id.bottom_view);
        this.jAG = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jAI = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jAI.setDefaultBgResource(R.color.transparent);
        this.jAI.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dwh = findViewById(R.id.profession_intro_container);
        this.jAH = findViewById(R.id.profession_intro_top_corner);
        this.jAK = findViewById(R.id.profession_intro_first_index);
        this.jAO = findViewById(R.id.profession_intro_first_intro);
        this.jAM = findViewById(R.id.profession_intro_first_title);
        this.jAL = findViewById(R.id.profession_intro_second_index);
        this.jAP = findViewById(R.id.profession_intro_second_intro);
        this.jAN = findViewById(R.id.profession_intro_second_title);
        this.jAE.setEnabled(true);
        this.jAE.setOnClickListener(this.onClickListener);
        this.jAF.setOnClickListener(this.onClickListener);
        cIK();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jAJ.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jAI.startLoad(stringExtra, 10, false);
    }

    private void cIK() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dvL.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jAJ.getLayoutParams();
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
        ao.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        ao.setViewTextColor(this.jAG, R.color.CAM_X0101);
        ao.setViewTextColor(this.jAK, R.color.CAM_X0111);
        ao.setViewTextColor(this.jAM, R.color.CAM_X0105);
        ao.setViewTextColor(this.jAO, R.color.CAM_X0106);
        ao.setViewTextColor(this.jAL, R.color.CAM_X0111);
        ao.setViewTextColor(this.jAN, R.color.CAM_X0105);
        ao.setViewTextColor(this.jAP, R.color.CAM_X0106);
        ao.setViewTextColor(this.jAF, R.color.CAM_X0101);
        ao.setBackgroundColor(this.dwh, R.color.CAM_X0201);
        ao.setBackgroundResource(this.jAH, R.drawable.bg_top_corner_white);
        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ao.setBackgroundResource(this.jAF, R.drawable.frs_profession_button_bg);
        ao.setViewTextColor(this.jAE, R.color.CAM_X0302);
        ao.setBackgroundColor(this.dhG, R.color.CAM_X0201);
        this.jAJ.changeSkinType(i);
    }
}
