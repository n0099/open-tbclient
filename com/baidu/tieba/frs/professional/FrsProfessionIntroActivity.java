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
    private View bLK;
    private RelativeLayout bLo;
    private View.OnClickListener drw = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.gIt) {
                    if (view == FrsProfessionIntroActivity.this.gIu) {
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
    private View gIA;
    private View gIB;
    private View gIC;
    private View gID;
    private View gIE;
    private TextView gIt;
    private View gIu;
    private View gIv;
    private View gIw;
    private TbImageView gIx;
    private LinearGradientView gIy;
    private View gIz;
    private View mBack;
    private View mBottomView;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.bLo = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.gIy = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.gIt = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.gIu = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.gIv = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.drw);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.gIx = (TbImageView) findViewById(R.id.profession_intro_content);
        this.gIx.setDefaultBgResource(R.color.transparent);
        this.gIx.setDefaultResource(R.drawable.pic_frs_head_default);
        this.bLK = findViewById(R.id.profession_intro_container);
        this.gIw = findViewById(R.id.profession_intro_top_corner);
        this.gIz = findViewById(R.id.profession_intro_first_index);
        this.gID = findViewById(R.id.profession_intro_first_intro);
        this.gIB = findViewById(R.id.profession_intro_first_title);
        this.gIA = findViewById(R.id.profession_intro_second_index);
        this.gIE = findViewById(R.id.profession_intro_second_intro);
        this.gIC = findViewById(R.id.profession_intro_second_title);
        this.gIt.setEnabled(true);
        this.gIt.setOnClickListener(this.drw);
        this.gIu.setOnClickListener(this.drw);
        bJD();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.gIy.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.gIx.startLoad(stringExtra, 10, false);
    }

    private void bJD() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.bLo.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.gIy.getLayoutParams();
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
        am.setViewTextColor(this.gIv, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.gIz, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIB, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gID, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIA, (int) R.color.cp_cont_g);
        am.setViewTextColor(this.gIC, (int) R.color.cp_cont_b);
        am.setViewTextColor(this.gIE, (int) R.color.cp_cont_f);
        am.setViewTextColor(this.gIu, (int) R.color.cp_cont_a);
        am.setBackgroundColor(this.bLK, R.color.cp_bg_line_d);
        am.setBackgroundResource(this.gIw, R.drawable.bg_top_corner_white);
        am.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        am.setBackgroundResource(this.gIu, R.drawable.frs_profession_button_bg);
        am.setViewTextColor(this.gIt, (int) R.color.cp_link_tip_a);
        am.setBackgroundColor(this.mBottomView, R.color.cp_bg_line_d);
        this.gIy.changeSkinType(i);
    }
}
