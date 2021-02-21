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
/* loaded from: classes2.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View djU;
    private RelativeLayout dxS;
    private View dyo;
    private TbImageView jGA;
    private LinearGradientView jGB;
    private View jGC;
    private View jGD;
    private View jGE;
    private View jGF;
    private View jGG;
    private View jGH;
    private TextView jGw;
    private View jGx;
    private View jGy;
    private View jGz;
    private View mBack;
    private NavigationBar mNavigationBar;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jGw) {
                    if (view == FrsProfessionIntroActivity.this.jGx) {
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
        this.dxS = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jGB = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jGw = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jGx = findViewById(R.id.profession_intro_got_it);
        this.djU = findViewById(R.id.bottom_view);
        this.jGy = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jGA = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jGA.setDefaultBgResource(R.color.transparent);
        this.jGA.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dyo = findViewById(R.id.profession_intro_container);
        this.jGz = findViewById(R.id.profession_intro_top_corner);
        this.jGC = findViewById(R.id.profession_intro_first_index);
        this.jGG = findViewById(R.id.profession_intro_first_intro);
        this.jGE = findViewById(R.id.profession_intro_first_title);
        this.jGD = findViewById(R.id.profession_intro_second_index);
        this.jGH = findViewById(R.id.profession_intro_second_intro);
        this.jGF = findViewById(R.id.profession_intro_second_title);
        this.jGw.setEnabled(true);
        this.jGw.setOnClickListener(this.onClickListener);
        this.jGx.setOnClickListener(this.onClickListener);
        cKe();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jGB.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jGA.startLoad(stringExtra, 10, false);
    }

    private void cKe() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dxS.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jGB.getLayoutParams();
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
        ap.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        ap.setViewTextColor(this.jGy, R.color.CAM_X0101);
        ap.setViewTextColor(this.jGC, R.color.CAM_X0111);
        ap.setViewTextColor(this.jGE, R.color.CAM_X0105);
        ap.setViewTextColor(this.jGG, R.color.CAM_X0106);
        ap.setViewTextColor(this.jGD, R.color.CAM_X0111);
        ap.setViewTextColor(this.jGF, R.color.CAM_X0105);
        ap.setViewTextColor(this.jGH, R.color.CAM_X0106);
        ap.setViewTextColor(this.jGx, R.color.CAM_X0101);
        ap.setBackgroundColor(this.dyo, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jGz, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.jGx, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.jGw, R.color.CAM_X0302);
        ap.setBackgroundColor(this.djU, R.color.CAM_X0201);
        this.jGB.changeSkinType(i);
    }
}
