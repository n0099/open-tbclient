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
    private View cMK;
    private RelativeLayout cMp;
    private View czL;
    private View.OnClickListener eFC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.ipP) {
                    if (view == FrsProfessionIntroActivity.this.ipQ) {
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
    private TextView ipP;
    private View ipQ;
    private View ipR;
    private View ipS;
    private TbImageView ipT;
    private LinearGradientView ipU;
    private View ipV;
    private View ipW;
    private View ipX;
    private View ipY;
    private View ipZ;
    private View iqa;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cMp = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.ipU = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.ipP = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.ipQ = findViewById(R.id.profession_intro_got_it);
        this.czL = findViewById(R.id.bottom_view);
        this.ipR = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eFC);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.ipT = (TbImageView) findViewById(R.id.profession_intro_content);
        this.ipT.setDefaultBgResource(R.color.transparent);
        this.ipT.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cMK = findViewById(R.id.profession_intro_container);
        this.ipS = findViewById(R.id.profession_intro_top_corner);
        this.ipV = findViewById(R.id.profession_intro_first_index);
        this.ipZ = findViewById(R.id.profession_intro_first_intro);
        this.ipX = findViewById(R.id.profession_intro_first_title);
        this.ipW = findViewById(R.id.profession_intro_second_index);
        this.iqa = findViewById(R.id.profession_intro_second_intro);
        this.ipY = findViewById(R.id.profession_intro_second_title);
        this.ipP.setEnabled(true);
        this.ipP.setOnClickListener(this.eFC);
        this.ipQ.setOnClickListener(this.eFC);
        cso();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.ipU.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.ipT.startLoad(stringExtra, 10, false);
    }

    private void cso() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cMp.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.ipU.getLayoutParams();
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
        ap.setViewTextColor(this.ipR, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.ipV, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ipX, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ipZ, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.ipW, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ipY, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.iqa, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.ipQ, (int) R.color.cp_cont_a);
        ap.setBackgroundColor(this.cMK, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.ipS, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.ipQ, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.ipP, (int) R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.czL, R.color.cp_bg_line_d);
        this.ipU.changeSkinType(i);
    }
}
