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
/* loaded from: classes6.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View bGT;
    private RelativeLayout bGx;
    private View.OnClickListener dmK = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gCR) {
                    if (view == FrsProfessionIntroActivity.this.gCS) {
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
    private TextView gCR;
    private View gCS;
    private View gCT;
    private View gCU;
    private TbImageView gCV;
    private LinearGradientView gCW;
    private View gCX;
    private View gCY;
    private View gCZ;
    private View gDa;
    private View gDb;
    private View gDc;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bGx = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gCW = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gCR = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gCS = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gCT = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dmK);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gCV = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gCV.setDefaultBgResource(R.color.transparent);
        this.gCV.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bGT = findViewById(R.id.profession_intro_container);
        this.gCU = findViewById(R.id.profession_intro_top_corner);
        this.gCX = findViewById(R.id.profession_intro_first_index);
        this.gDb = findViewById(R.id.profession_intro_first_intro);
        this.gCZ = findViewById(R.id.profession_intro_first_title);
        this.gCY = findViewById(R.id.profession_intro_second_index);
        this.gDc = findViewById(R.id.profession_intro_second_intro);
        this.gDa = findViewById(R.id.profession_intro_second_title);
        this.gCR.setEnabled(true);
        this.gCR.setOnClickListener(this.dmK);
        this.gCS.setOnClickListener(this.dmK);
        bGW();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gCW.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gCV.startLoad(stringExtra, 10, false);
    }

    private void bGW() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bGx.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gCW.getLayoutParams();
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
        am.setViewTextColor(this.gCT, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gCX, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gCZ, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gDb, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gCY, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gDa, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gDc, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gCS, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bGT, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gCU, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gCS, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gCR, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gCW.changeSkinType(i);
    }
}
