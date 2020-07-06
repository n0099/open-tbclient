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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private RelativeLayout cAE;
    private View cAZ;
    private View cpS;
    private View.OnClickListener eoP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.hVH) {
                    if (view == FrsProfessionIntroActivity.this.hVI) {
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
    private TextView hVH;
    private View hVI;
    private View hVJ;
    private View hVK;
    private TbImageView hVL;
    private LinearGradientView hVM;
    private View hVN;
    private View hVO;
    private View hVP;
    private View hVQ;
    private View hVR;
    private View hVS;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cAE = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.hVM = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.hVH = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.hVI = findViewById(R.id.profession_intro_got_it);
        this.cpS = findViewById(R.id.bottom_view);
        this.hVJ = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eoP);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.hVL = (TbImageView) findViewById(R.id.profession_intro_content);
        this.hVL.setDefaultBgResource(R.color.transparent);
        this.hVL.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cAZ = findViewById(R.id.profession_intro_container);
        this.hVK = findViewById(R.id.profession_intro_top_corner);
        this.hVN = findViewById(R.id.profession_intro_first_index);
        this.hVR = findViewById(R.id.profession_intro_first_intro);
        this.hVP = findViewById(R.id.profession_intro_first_title);
        this.hVO = findViewById(R.id.profession_intro_second_index);
        this.hVS = findViewById(R.id.profession_intro_second_intro);
        this.hVQ = findViewById(R.id.profession_intro_second_title);
        this.hVH.setEnabled(true);
        this.hVH.setOnClickListener(this.eoP);
        this.hVI.setOnClickListener(this.eoP);
        cel();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.hVM.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.hVL.startLoad(stringExtra, 10, false);
    }

    private void cel() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cAE.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.hVM.getLayoutParams();
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
        an.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hVJ, (int) R.color.cp_cont_a);
        an.setViewTextColor(this.hVN, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hVP, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hVR, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.hVO, (int) R.color.cp_cont_g);
        an.setViewTextColor(this.hVQ, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.hVS, (int) R.color.cp_cont_f);
        an.setViewTextColor(this.hVI, (int) R.color.cp_cont_a);
        an.setBackgroundColor(this.cAZ, R.color.cp_bg_line_d);
        an.setBackgroundResource(this.hVK, R.drawable.bg_top_corner_white);
        an.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        an.setBackgroundResource(this.hVI, R.drawable.frs_profession_button_bg);
        an.setViewTextColor(this.hVH, (int) R.color.cp_link_tip_a);
        an.setBackgroundColor(this.cpS, R.color.cp_bg_line_d);
        this.hVM.changeSkinType(i);
    }
}
