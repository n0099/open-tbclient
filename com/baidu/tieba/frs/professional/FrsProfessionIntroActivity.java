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
    private View dAT;
    private RelativeLayout dAx;
    private View dmv;
    private TextView jFk;
    private View jFl;
    private View jFm;
    private View jFn;
    private TbImageView jFo;
    private LinearGradientView jFp;
    private View jFq;
    private View jFr;
    private View jFs;
    private View jFt;
    private View jFu;
    private View jFv;
    private View mBack;
    private NavigationBar mNavigationBar;
    private View.OnClickListener onClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jFk) {
                    if (view == FrsProfessionIntroActivity.this.jFl) {
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
        this.dAx = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jFp = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jFk = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jFl = findViewById(R.id.profession_intro_got_it);
        this.dmv = findViewById(R.id.bottom_view);
        this.jFm = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jFo = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jFo.setDefaultBgResource(R.color.transparent);
        this.jFo.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dAT = findViewById(R.id.profession_intro_container);
        this.jFn = findViewById(R.id.profession_intro_top_corner);
        this.jFq = findViewById(R.id.profession_intro_first_index);
        this.jFu = findViewById(R.id.profession_intro_first_intro);
        this.jFs = findViewById(R.id.profession_intro_first_title);
        this.jFr = findViewById(R.id.profession_intro_second_index);
        this.jFv = findViewById(R.id.profession_intro_second_intro);
        this.jFt = findViewById(R.id.profession_intro_second_title);
        this.jFk.setEnabled(true);
        this.jFk.setOnClickListener(this.onClickListener);
        this.jFl.setOnClickListener(this.onClickListener);
        cMB();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jFp.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jFo.startLoad(stringExtra, 10, false);
    }

    private void cMB() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dAx.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jFp.getLayoutParams();
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
        ao.setViewTextColor(this.jFm, R.color.CAM_X0101);
        ao.setViewTextColor(this.jFq, R.color.CAM_X0111);
        ao.setViewTextColor(this.jFs, R.color.CAM_X0105);
        ao.setViewTextColor(this.jFu, R.color.CAM_X0106);
        ao.setViewTextColor(this.jFr, R.color.CAM_X0111);
        ao.setViewTextColor(this.jFt, R.color.CAM_X0105);
        ao.setViewTextColor(this.jFv, R.color.CAM_X0106);
        ao.setViewTextColor(this.jFl, R.color.CAM_X0101);
        ao.setBackgroundColor(this.dAT, R.color.CAM_X0201);
        ao.setBackgroundResource(this.jFn, R.drawable.bg_top_corner_white);
        ao.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ao.setBackgroundResource(this.jFl, R.drawable.frs_profession_button_bg);
        ao.setViewTextColor(this.jFk, R.color.CAM_X0302);
        ao.setBackgroundColor(this.dmv, R.color.CAM_X0201);
        this.jFp.changeSkinType(i);
    }
}
