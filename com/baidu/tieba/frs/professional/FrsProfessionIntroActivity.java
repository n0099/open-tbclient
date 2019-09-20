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
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private RelativeLayout aKM;
    private View aLm;
    private View cgb;
    private View.OnClickListener cmX = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.cgb) {
                if (view != FrsProfessionIntroActivity.this.fQb) {
                    if (view == FrsProfessionIntroActivity.this.fQc) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FrsProfessionIntroActivity.this.getActivity()).createNormalCfg("5977226324", null, "frs")));
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
    private View dgt;
    private TextView fQb;
    private View fQc;
    private View fQd;
    private View fQe;
    private TbImageView fQf;
    private LinearGradientView fQg;
    private View fQh;
    private View fQi;
    private View fQj;
    private View fQk;
    private View fQl;
    private View fQm;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.aKM = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fQg = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fQb = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fQc = findViewById(R.id.profession_intro_got_it);
        this.dgt = findViewById(R.id.bottom_view);
        this.fQd = findViewById(R.id.profession_intro_desc);
        this.cgb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.cmX);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fQf = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fQf.setDefaultBgResource(R.color.transparent);
        this.fQf.setDefaultResource(R.drawable.pic_frs_head_default);
        this.aLm = findViewById(R.id.profession_intro_container);
        this.fQe = findViewById(R.id.profession_intro_top_corner);
        this.fQh = findViewById(R.id.profession_intro_first_index);
        this.fQl = findViewById(R.id.profession_intro_first_intro);
        this.fQj = findViewById(R.id.profession_intro_first_title);
        this.fQi = findViewById(R.id.profession_intro_second_index);
        this.fQm = findViewById(R.id.profession_intro_second_intro);
        this.fQk = findViewById(R.id.profession_intro_second_title);
        this.fQb.setEnabled(true);
        this.fQb.setOnClickListener(this.cmX);
        this.fQc.setOnClickListener(this.cmX);
        bsy();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fQg.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fQf.startLoad(stringExtra, 10, false);
    }

    private void bsy() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aKM.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = g;
                ViewGroup.LayoutParams layoutParams2 = this.fQg.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).height = g;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        am.j(this.mNavigationBar.mCenterText, R.color.cp_cont_a);
        am.j(this.fQd, R.color.cp_cont_a);
        am.j(this.fQh, R.color.cp_cont_g);
        am.j(this.fQj, R.color.cp_cont_b);
        am.j(this.fQl, R.color.cp_cont_f);
        am.j(this.fQi, R.color.cp_cont_g);
        am.j(this.fQk, R.color.cp_cont_b);
        am.j(this.fQm, R.color.cp_cont_f);
        am.j(this.fQc, R.color.cp_cont_a);
        am.l(this.aLm, R.color.cp_bg_line_d);
        am.k(this.fQe, R.drawable.bg_top_corner_white);
        am.c(this.mNavigationBar.getBackImageView(), (int) R.drawable.btn_sml_back_selector_s);
        am.k(this.fQc, R.drawable.frs_profession_button_bg);
        am.j(this.fQb, R.color.cp_link_tip_a);
        am.l(this.dgt, R.color.cp_bg_line_d);
        this.fQg.changeSkinType(i);
    }
}
