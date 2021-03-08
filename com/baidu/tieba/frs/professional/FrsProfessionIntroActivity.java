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
    private View dlv;
    private View dzP;
    private RelativeLayout dzt;
    private TextView jIf;
    private View jIg;
    private View jIh;
    private View jIi;
    private TbImageView jIj;
    private LinearGradientView jIk;
    private View jIl;
    private View jIm;
    private View jIn;
    private View jIo;
    private View jIp;
    private View jIq;
    private View mBack;
    private NavigationBar mNavigationBar;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jIf) {
                    if (view == FrsProfessionIntroActivity.this.jIg) {
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
        this.dzt = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jIk = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jIf = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jIg = findViewById(R.id.profession_intro_got_it);
        this.dlv = findViewById(R.id.bottom_view);
        this.jIh = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jIj = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jIj.setDefaultBgResource(R.color.transparent);
        this.jIj.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dzP = findViewById(R.id.profession_intro_container);
        this.jIi = findViewById(R.id.profession_intro_top_corner);
        this.jIl = findViewById(R.id.profession_intro_first_index);
        this.jIp = findViewById(R.id.profession_intro_first_intro);
        this.jIn = findViewById(R.id.profession_intro_first_title);
        this.jIm = findViewById(R.id.profession_intro_second_index);
        this.jIq = findViewById(R.id.profession_intro_second_intro);
        this.jIo = findViewById(R.id.profession_intro_second_title);
        this.jIf.setEnabled(true);
        this.jIf.setOnClickListener(this.onClickListener);
        this.jIg.setOnClickListener(this.onClickListener);
        cKk();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jIk.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jIj.startLoad(stringExtra, 10, false);
    }

    private void cKk() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dzt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jIk.getLayoutParams();
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
        ap.setViewTextColor(this.jIh, R.color.CAM_X0101);
        ap.setViewTextColor(this.jIl, R.color.CAM_X0111);
        ap.setViewTextColor(this.jIn, R.color.CAM_X0105);
        ap.setViewTextColor(this.jIp, R.color.CAM_X0106);
        ap.setViewTextColor(this.jIm, R.color.CAM_X0111);
        ap.setViewTextColor(this.jIo, R.color.CAM_X0105);
        ap.setViewTextColor(this.jIq, R.color.CAM_X0106);
        ap.setViewTextColor(this.jIg, R.color.CAM_X0101);
        ap.setBackgroundColor(this.dzP, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jIi, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.jIg, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.jIf, R.color.CAM_X0302);
        ap.setBackgroundColor(this.dlv, R.color.CAM_X0201);
        this.jIk.changeSkinType(i);
    }
}
