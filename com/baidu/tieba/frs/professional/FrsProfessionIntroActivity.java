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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    private RelativeLayout aJG;
    private View aKg;
    private View cdY;
    private View.OnClickListener ckI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.cdY) {
                if (view != FrsProfessionIntroActivity.this.fIz) {
                    if (view == FrsProfessionIntroActivity.this.fIA) {
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
    private View dda;
    private View fIA;
    private View fIB;
    private View fIC;
    private TbImageView fID;
    private LinearGradientView fIE;
    private View fIF;
    private View fIG;
    private View fIH;
    private View fII;
    private View fIJ;
    private View fIK;
    private TextView fIz;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.aJG = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.fIE = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.fIz = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.fIA = findViewById(R.id.profession_intro_got_it);
        this.dda = findViewById(R.id.bottom_view);
        this.fIB = findViewById(R.id.profession_intro_desc);
        this.cdY = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.ckI);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.fID = (TbImageView) findViewById(R.id.profession_intro_content);
        this.fID.setDefaultBgResource(R.color.transparent);
        this.fID.setDefaultResource(R.drawable.pic_frs_head_default);
        this.aKg = findViewById(R.id.profession_intro_container);
        this.fIC = findViewById(R.id.profession_intro_top_corner);
        this.fIF = findViewById(R.id.profession_intro_first_index);
        this.fIJ = findViewById(R.id.profession_intro_first_intro);
        this.fIH = findViewById(R.id.profession_intro_first_title);
        this.fIG = findViewById(R.id.profession_intro_second_index);
        this.fIK = findViewById(R.id.profession_intro_second_intro);
        this.fII = findViewById(R.id.profession_intro_second_title);
        this.fIz.setEnabled(true);
        this.fIz.setOnClickListener(this.ckI);
        this.fIA.setOnClickListener(this.ckI);
        bpx();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.fIE.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR));
        this.fID.startLoad(stringExtra, 10, false);
    }

    private void bpx() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int g = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.aJG.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = g;
                ViewGroup.LayoutParams layoutParams2 = this.fIE.getLayoutParams();
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
        al.j(this.mNavigationBar.mCenterText, R.color.cp_btn_a);
        al.j(this.fIB, R.color.cp_btn_a);
        al.j(this.fIF, R.color.cp_cont_g);
        al.j(this.fIH, R.color.cp_cont_b);
        al.j(this.fIJ, R.color.cp_cont_f);
        al.j(this.fIG, R.color.cp_cont_g);
        al.j(this.fII, R.color.cp_cont_b);
        al.j(this.fIK, R.color.cp_cont_f);
        al.j(this.fIA, R.color.cp_btn_a);
        al.l(this.aKg, R.color.cp_bg_line_d);
        al.k(this.fIC, R.drawable.bg_top_corner_white);
        al.c(this.mNavigationBar.getBackImageView(), (int) R.drawable.btn_sml_back_selector_s);
        al.k(this.fIA, R.drawable.frs_profession_button_bg);
        al.j(this.fIz, R.color.cp_link_tip_a);
        al.l(this.dda, R.color.cp_bg_line_d);
        this.fIE.changeSkinType(i);
    }
}
