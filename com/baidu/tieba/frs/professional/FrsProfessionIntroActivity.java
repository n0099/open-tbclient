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
    private View dhB;
    private View duK;
    private RelativeLayout duo;
    private View.OnClickListener foP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jsP) {
                    if (view == FrsProfessionIntroActivity.this.jsQ) {
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
    private TextView jsP;
    private View jsQ;
    private View jsR;
    private View jsS;
    private TbImageView jsT;
    private LinearGradientView jsU;
    private View jsV;
    private View jsW;
    private View jsX;
    private View jsY;
    private View jsZ;
    private View jta;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.duo = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jsU = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jsP = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jsQ = findViewById(R.id.profession_intro_got_it);
        this.dhB = findViewById(R.id.bottom_view);
        this.jsR = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.foP);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jsT = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jsT.setDefaultBgResource(R.color.transparent);
        this.jsT.setDefaultResource(R.drawable.pic_frs_head_default);
        this.duK = findViewById(R.id.profession_intro_container);
        this.jsS = findViewById(R.id.profession_intro_top_corner);
        this.jsV = findViewById(R.id.profession_intro_first_index);
        this.jsZ = findViewById(R.id.profession_intro_first_intro);
        this.jsX = findViewById(R.id.profession_intro_first_title);
        this.jsW = findViewById(R.id.profession_intro_second_index);
        this.jta = findViewById(R.id.profession_intro_second_intro);
        this.jsY = findViewById(R.id.profession_intro_second_title);
        this.jsP.setEnabled(true);
        this.jsP.setOnClickListener(this.foP);
        this.jsQ.setOnClickListener(this.foP);
        cJB();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jsU.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jsT.startLoad(stringExtra, 10, false);
    }

    private void cJB() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.duo.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jsU.getLayoutParams();
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
        ap.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.jsR, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.jsV, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jsX, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jsZ, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.jsW, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jsY, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jta, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.jsQ, (int) R.color.CAM_X0101);
        ap.setBackgroundColor(this.duK, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jsS, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.jsQ, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.jsP, (int) R.color.CAM_X0302);
        ap.setBackgroundColor(this.dhB, R.color.CAM_X0201);
        this.jsU.changeSkinType(i);
    }
}
