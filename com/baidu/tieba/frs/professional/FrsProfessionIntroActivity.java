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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private RelativeLayout aHM;
    private View aIm;
    private View bWb;
    private View cUA;
    private View.OnClickListener ccC = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.bWb) {
                if (view != FrsProfessionIntroActivity.this.fsb) {
                    if (view == FrsProfessionIntroActivity.this.fsc) {
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
    private TextView fsb;
    private View fsc;
    private View fsd;
    private View fse;
    private TbImageView fsf;
    private LinearGradientView fsg;
    private View fsh;
    private View fsi;
    private View fsj;
    private View fsk;
    private View fsl;
    private View fsm;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.layout_frs_profession);
        this.aHM = (RelativeLayout) findViewById(d.g.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.profession_intro_navigation_bar);
        this.fsg = (LinearGradientView) findViewById(d.g.profession_intro_background);
        this.fsb = (TextView) findViewById(d.g.profession_intro_go_publish);
        this.fsc = findViewById(d.g.profession_intro_got_it);
        this.cUA = findViewById(d.g.bottom_view);
        this.fsd = findViewById(d.g.profession_intro_desc);
        this.bWb = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ccC);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.profession_intro_title));
        this.fsf = (TbImageView) findViewById(d.g.profession_intro_content);
        this.fsf.setDefaultBgResource(d.C0277d.transparent);
        this.fsf.setDefaultResource(d.f.pic_frs_head_default);
        this.aIm = findViewById(d.g.profession_intro_container);
        this.fse = findViewById(d.g.profession_intro_top_corner);
        this.fsh = findViewById(d.g.profession_intro_first_index);
        this.fsl = findViewById(d.g.profession_intro_first_intro);
        this.fsj = findViewById(d.g.profession_intro_first_title);
        this.fsi = findViewById(d.g.profession_intro_second_index);
        this.fsm = findViewById(d.g.profession_intro_second_intro);
        this.fsk = findViewById(d.g.profession_intro_second_title);
        this.fsb.setEnabled(true);
        this.fsb.setOnClickListener(this.ccC);
        this.fsc.setOnClickListener(this.ccC);
        bhZ();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fsg.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fsf.startLoad(stringExtra, 10, false);
    }

    private void bhZ() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int h = l.h(TbadkCoreApplication.getInst(), d.e.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aHM.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = h;
                ViewGroup.LayoutParams layoutParams2 = this.fsg.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).height = h;
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        al.j(this.mNavigationBar.mCenterText, d.C0277d.cp_btn_a);
        al.j(this.fsd, d.C0277d.cp_btn_a);
        al.j(this.fsh, d.C0277d.cp_cont_g);
        al.j(this.fsj, d.C0277d.cp_cont_b);
        al.j(this.fsl, d.C0277d.cp_cont_f);
        al.j(this.fsi, d.C0277d.cp_cont_g);
        al.j(this.fsk, d.C0277d.cp_cont_b);
        al.j(this.fsm, d.C0277d.cp_cont_f);
        al.j(this.fsc, d.C0277d.cp_btn_a);
        al.l(this.aIm, d.C0277d.cp_bg_line_d);
        al.k(this.fse, d.f.bg_top_corner_white);
        al.c(this.mNavigationBar.getBackImageView(), d.f.btn_sml_back_selector_s);
        al.k(this.fsc, d.f.frs_profession_button_bg);
        al.j(this.fsb, d.C0277d.cp_link_tip_a);
        al.l(this.cUA, d.C0277d.cp_bg_line_d);
        this.fsg.changeSkinType(i);
    }
}
