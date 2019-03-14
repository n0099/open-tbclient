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
    private RelativeLayout aHJ;
    private View aIj;
    private View bVZ;
    private View cUy;
    private View.OnClickListener ccA = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.bVZ) {
                if (view != FrsProfessionIntroActivity.this.fsp) {
                    if (view == FrsProfessionIntroActivity.this.fsq) {
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
    private View fsA;
    private TextView fsp;
    private View fsq;
    private View fsr;
    private View fss;
    private TbImageView fst;
    private LinearGradientView fsu;
    private View fsv;
    private View fsw;
    private View fsx;
    private View fsy;
    private View fsz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(d.h.layout_frs_profession);
        this.aHJ = (RelativeLayout) findViewById(d.g.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(d.g.profession_intro_navigation_bar);
        this.fsu = (LinearGradientView) findViewById(d.g.profession_intro_background);
        this.fsp = (TextView) findViewById(d.g.profession_intro_go_publish);
        this.fsq = findViewById(d.g.profession_intro_got_it);
        this.cUy = findViewById(d.g.bottom_view);
        this.fsr = findViewById(d.g.profession_intro_desc);
        this.bVZ = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ccA);
        this.mNavigationBar.setCenterTextTitle(getString(d.j.profession_intro_title));
        this.fst = (TbImageView) findViewById(d.g.profession_intro_content);
        this.fst.setDefaultBgResource(d.C0277d.transparent);
        this.fst.setDefaultResource(d.f.pic_frs_head_default);
        this.aIj = findViewById(d.g.profession_intro_container);
        this.fss = findViewById(d.g.profession_intro_top_corner);
        this.fsv = findViewById(d.g.profession_intro_first_index);
        this.fsz = findViewById(d.g.profession_intro_first_intro);
        this.fsx = findViewById(d.g.profession_intro_first_title);
        this.fsw = findViewById(d.g.profession_intro_second_index);
        this.fsA = findViewById(d.g.profession_intro_second_intro);
        this.fsy = findViewById(d.g.profession_intro_second_title);
        this.fsp.setEnabled(true);
        this.fsp.setOnClickListener(this.ccA);
        this.fsq.setOnClickListener(this.ccA);
        bib();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fsu.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fst.startLoad(stringExtra, 10, false);
    }

    private void bib() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int h = l.h(TbadkCoreApplication.getInst(), d.e.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aHJ.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = h;
                ViewGroup.LayoutParams layoutParams2 = this.fsu.getLayoutParams();
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
        al.j(this.fsr, d.C0277d.cp_btn_a);
        al.j(this.fsv, d.C0277d.cp_cont_g);
        al.j(this.fsx, d.C0277d.cp_cont_b);
        al.j(this.fsz, d.C0277d.cp_cont_f);
        al.j(this.fsw, d.C0277d.cp_cont_g);
        al.j(this.fsy, d.C0277d.cp_cont_b);
        al.j(this.fsA, d.C0277d.cp_cont_f);
        al.j(this.fsq, d.C0277d.cp_btn_a);
        al.l(this.aIj, d.C0277d.cp_bg_line_d);
        al.k(this.fss, d.f.bg_top_corner_white);
        al.c(this.mNavigationBar.getBackImageView(), d.f.btn_sml_back_selector_s);
        al.k(this.fsq, d.f.frs_profession_button_bg);
        al.j(this.fsp, d.C0277d.cp_link_tip_a);
        al.l(this.cUy, d.C0277d.cp_bg_line_d);
        this.fsu.changeSkinType(i);
    }
}
