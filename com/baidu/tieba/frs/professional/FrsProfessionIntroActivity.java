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
/* loaded from: classes21.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private View cBQ;
    private View cOO;
    private RelativeLayout cOt;
    private View.OnClickListener eHN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.ixl) {
                    if (view == FrsProfessionIntroActivity.this.ixm) {
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
    private TextView ixl;
    private View ixm;
    private View ixn;
    private View ixo;
    private TbImageView ixp;
    private LinearGradientView ixq;
    private View ixr;
    private View ixs;
    private View ixt;
    private View ixu;
    private View ixv;
    private View ixw;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.cOt = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.ixq = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.ixl = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.ixm = findViewById(R.id.profession_intro_got_it);
        this.cBQ = findViewById(R.id.bottom_view);
        this.ixn = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.eHN);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.ixp = (TbImageView) findViewById(R.id.profession_intro_content);
        this.ixp.setDefaultBgResource(R.color.transparent);
        this.ixp.setDefaultResource(R.drawable.pic_frs_head_default);
        this.cOO = findViewById(R.id.profession_intro_container);
        this.ixo = findViewById(R.id.profession_intro_top_corner);
        this.ixr = findViewById(R.id.profession_intro_first_index);
        this.ixv = findViewById(R.id.profession_intro_first_intro);
        this.ixt = findViewById(R.id.profession_intro_first_title);
        this.ixs = findViewById(R.id.profession_intro_second_index);
        this.ixw = findViewById(R.id.profession_intro_second_intro);
        this.ixu = findViewById(R.id.profession_intro_second_title);
        this.ixl.setEnabled(true);
        this.ixl.setOnClickListener(this.eHN);
        this.ixm.setOnClickListener(this.eHN);
        cvE();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.ixq.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.ixp.startLoad(stringExtra, 10, false);
    }

    private void cvE() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.cOt.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.ixq.getLayoutParams();
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
        ap.setViewTextColor(this.ixn, (int) R.color.cp_cont_a);
        ap.setViewTextColor(this.ixr, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ixt, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ixv, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.ixs, (int) R.color.cp_cont_g);
        ap.setViewTextColor(this.ixu, (int) R.color.cp_cont_b);
        ap.setViewTextColor(this.ixw, (int) R.color.cp_cont_f);
        ap.setViewTextColor(this.ixm, (int) R.color.cp_cont_a);
        ap.setBackgroundColor(this.cOO, R.color.cp_bg_line_d);
        ap.setBackgroundResource(this.ixo, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.ixm, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.ixl, (int) R.color.cp_link_tip_a);
        ap.setBackgroundColor(this.cBQ, R.color.cp_bg_line_d);
        this.ixq.changeSkinType(i);
    }
}
