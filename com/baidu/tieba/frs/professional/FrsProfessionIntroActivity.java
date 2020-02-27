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
    private View bLI;
    private RelativeLayout bLm;
    private View.OnClickListener drh = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gIf) {
                    if (view == FrsProfessionIntroActivity.this.gIg) {
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
    private TextView gIf;
    private View gIg;
    private View gIh;
    private View gIi;
    private TbImageView gIj;
    private LinearGradientView gIk;
    private View gIl;
    private View gIm;
    private View gIn;
    private View gIo;
    private View gIp;
    private View gIq;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bLm = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gIk = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gIf = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gIg = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gIh = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.drh);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gIj = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gIj.setDefaultBgResource(R.color.transparent);
        this.gIj.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bLI = findViewById(R.id.profession_intro_container);
        this.gIi = findViewById(R.id.profession_intro_top_corner);
        this.gIl = findViewById(R.id.profession_intro_first_index);
        this.gIp = findViewById(R.id.profession_intro_first_intro);
        this.gIn = findViewById(R.id.profession_intro_first_title);
        this.gIm = findViewById(R.id.profession_intro_second_index);
        this.gIq = findViewById(R.id.profession_intro_second_intro);
        this.gIo = findViewById(R.id.profession_intro_second_title);
        this.gIf.setEnabled(true);
        this.gIf.setOnClickListener(this.drh);
        this.gIg.setOnClickListener(this.drh);
        bJA();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gIk.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gIj.startLoad(stringExtra, 10, false);
    }

    private void bJA() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bLm.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gIk.getLayoutParams();
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
        am.setViewTextColor(this.gIh, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gIl, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIn, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gIp, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIm, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIo, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gIq, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIg, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bLI, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gIi, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gIg, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gIf, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gIk.changeSkinType(i);
    }
}
