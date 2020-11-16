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
    private View daD;
    private View dnH;
    private RelativeLayout dnl;
    private View.OnClickListener fhp = new View.OnClickListener() { // from class: com.baidu.tieba.frs.professional.FrsProfessionIntroActivity.1
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.jfk) {
                    if (view == FrsProfessionIntroActivity.this.jfl) {
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
    private TextView jfk;
    private View jfl;
    private View jfm;
    private View jfn;
    private TbImageView jfo;
    private LinearGradientView jfp;
    private View jfq;
    private View jfr;
    private View jfs;
    private View jft;
    private View jfu;
    private View jfv;
    private View mBack;
    private NavigationBar mNavigationBar;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.dnl = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.jfp = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.jfk = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.jfl = findViewById(R.id.profession_intro_got_it);
        this.daD = findViewById(R.id.bottom_view);
        this.jfm = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.fhp);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        this.jfo = (TbImageView) findViewById(R.id.profession_intro_content);
        this.jfo.setDefaultBgResource(R.color.transparent);
        this.jfo.setDefaultResource(R.drawable.pic_frs_head_default);
        this.dnH = findViewById(R.id.profession_intro_container);
        this.jfn = findViewById(R.id.profession_intro_top_corner);
        this.jfq = findViewById(R.id.profession_intro_first_index);
        this.jfu = findViewById(R.id.profession_intro_first_intro);
        this.jfs = findViewById(R.id.profession_intro_first_title);
        this.jfr = findViewById(R.id.profession_intro_second_index);
        this.jfv = findViewById(R.id.profession_intro_second_intro);
        this.jft = findViewById(R.id.profession_intro_second_title);
        this.jfk.setEnabled(true);
        this.jfk.setOnClickListener(this.fhp);
        this.jfl.setOnClickListener(this.fhp);
        cEn();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.jfp.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.jfo.startLoad(stringExtra, 10, false);
    }

    private void cEn() {
        boolean z = false;
        if (UtilHelper.isMiNotchDevice()) {
            z = true;
        }
        if (z) {
            int dimens = l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.dnl.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = dimens;
                ViewGroup.LayoutParams layoutParams2 = this.jfp.getLayoutParams();
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
        ap.setViewTextColor(this.mNavigationBar.mCenterText, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.jfm, (int) R.color.CAM_X0101);
        ap.setViewTextColor(this.jfq, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jfs, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jfu, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.jfr, (int) R.color.CAM_X0111);
        ap.setViewTextColor(this.jft, (int) R.color.CAM_X0105);
        ap.setViewTextColor(this.jfv, (int) R.color.CAM_X0106);
        ap.setViewTextColor(this.jfl, (int) R.color.CAM_X0101);
        ap.setBackgroundColor(this.dnH, R.color.CAM_X0201);
        ap.setBackgroundResource(this.jfn, R.drawable.bg_top_corner_white);
        ap.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        ap.setBackgroundResource(this.jfl, R.drawable.frs_profession_button_bg);
        ap.setViewTextColor(this.jfk, (int) R.color.CAM_X0302);
        ap.setBackgroundColor(this.daD, R.color.CAM_X0201);
        this.jfp.changeSkinType(i);
    }
}
