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
    private View bLJ;
    private RelativeLayout bLn;
    private View.OnClickListener dri = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gIh) {
                    if (view == FrsProfessionIntroActivity.this.gIi) {
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
    private TextView gIh;
    private View gIi;
    private View gIj;
    private View gIk;
    private TbImageView gIl;
    private LinearGradientView gIm;
    private View gIn;
    private View gIo;
    private View gIp;
    private View gIq;
    private View gIr;
    private View gIs;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bLn = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gIm = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gIh = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gIi = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gIj = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.dri);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gIl = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gIl.setDefaultBgResource(R.color.transparent);
        this.gIl.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bLJ = findViewById(R.id.profession_intro_container);
        this.gIk = findViewById(R.id.profession_intro_top_corner);
        this.gIn = findViewById(R.id.profession_intro_first_index);
        this.gIr = findViewById(R.id.profession_intro_first_intro);
        this.gIp = findViewById(R.id.profession_intro_first_title);
        this.gIo = findViewById(R.id.profession_intro_second_index);
        this.gIs = findViewById(R.id.profession_intro_second_intro);
        this.gIq = findViewById(R.id.profession_intro_second_title);
        this.gIh.setEnabled(true);
        this.gIh.setOnClickListener(this.dri);
        this.gIi.setOnClickListener(this.dri);
        bJC();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gIm.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gIl.startLoad(stringExtra, 10, false);
    }

    private void bJC() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bLn.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gIm.getLayoutParams();
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
        am.setViewTextColor(this.gIj, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gIn, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIp, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gIr, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIo, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIq, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gIs, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIi, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bLJ, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gIk, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gIi, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gIh, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gIm.changeSkinType(i);
    }
}
