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
/* loaded from: classes7.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View bHD;
    private RelativeLayout bHh;
    private View.OnClickListener dmY = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gGg) {
                    if (view == FrsProfessionIntroActivity.this.gGh) {
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
    private TextView gGg;
    private View gGh;
    private View gGi;
    private View gGj;
    private TbImageView gGk;
    private LinearGradientView gGl;
    private View gGm;
    private View gGn;
    private View gGo;
    private View gGp;
    private View gGq;
    private View gGr;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bHh = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gGl = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gGg = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gGh = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gGi = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dmY);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gGk = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gGk.setDefaultBgResource(R.color.transparent);
        this.gGk.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bHD = findViewById(R.id.profession_intro_container);
        this.gGj = findViewById(R.id.profession_intro_top_corner);
        this.gGm = findViewById(R.id.profession_intro_first_index);
        this.gGq = findViewById(R.id.profession_intro_first_intro);
        this.gGo = findViewById(R.id.profession_intro_first_title);
        this.gGn = findViewById(R.id.profession_intro_second_index);
        this.gGr = findViewById(R.id.profession_intro_second_intro);
        this.gGp = findViewById(R.id.profession_intro_second_title);
        this.gGg.setEnabled(true);
        this.gGg.setOnClickListener(this.dmY);
        this.gGh.setOnClickListener(this.dmY);
        bHY();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gGl.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gGk.startLoad(stringExtra, 10, false);
    }

    private void bHY() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bHh.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gGl.getLayoutParams();
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
        am.setViewTextColor(this.gGi, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gGm, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gGo, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gGq, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gGn, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gGp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gGr, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gGh, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bHD, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gGj, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gGh, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gGg, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gGl.changeSkinType(i);
    }
}
