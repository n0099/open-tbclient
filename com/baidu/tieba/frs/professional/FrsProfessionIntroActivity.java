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
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.FrsProfessionIntroActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.widget.LinearGradientView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsProfessionIntroActivity extends BaseActivity<FrsProfessionIntroActivity> {
    public static final String PROFESSION_THREAD_ID = "5977226324";
    public View mBack;
    public TbImageView mBackgroundContent;
    public View mBottomView;
    public View mContainer;
    public View mFirstIndex;
    public View mFirstIntro;
    public View mFirstTitle;
    public TextView mGoPublishButton;
    public View mGotItButton;
    public LinearGradientView mGradientView;
    public RelativeLayout mHeaderContainer;
    public NavigationBar mNavigationBar;
    public View mProfessionDesc;
    public View mSecondIndex;
    public View mSecondIntro;
    public View mSecondTitle;
    public View mTopCorner;
    public View.OnClickListener onClickListener = new a();

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view != FrsProfessionIntroActivity.this.mBack) {
                if (view != FrsProfessionIntroActivity.this.mGoPublishButton) {
                    if (view == FrsProfessionIntroActivity.this.mGotItButton) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2004001, new PbActivityConfig(FrsProfessionIntroActivity.this.getActivity()).createNormalCfg(FrsProfessionIntroActivity.PROFESSION_THREAD_ID, null, "frs")));
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
    }

    private void handleNotchScreen() {
        if (UtilHelper.isMiNotchDevice()) {
            int g2 = l.g(TbadkCoreApplication.getInst(), R.dimen.tbds690);
            ViewGroup.LayoutParams layoutParams = this.mHeaderContainer.getLayoutParams();
            if (layoutParams instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) layoutParams).height = g2;
                ViewGroup.LayoutParams layoutParams2 = this.mGradientView.getLayoutParams();
                if (layoutParams2 instanceof RelativeLayout.LayoutParams) {
                    ((RelativeLayout.LayoutParams) layoutParams2).height = g2;
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        SkinManager.setViewTextColor(this.mNavigationBar.mCenterText, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.mProfessionDesc, R.color.CAM_X0101);
        SkinManager.setViewTextColor(this.mFirstIndex, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.mFirstTitle, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mFirstIntro, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.mSecondIndex, R.color.CAM_X0111);
        SkinManager.setViewTextColor(this.mSecondTitle, R.color.CAM_X0105);
        SkinManager.setViewTextColor(this.mSecondIntro, R.color.CAM_X0106);
        SkinManager.setViewTextColor(this.mGotItButton, R.color.CAM_X0101);
        SkinManager.setBackgroundColor(this.mContainer, R.color.CAM_X0201);
        SkinManager.setBackgroundResource(this.mTopCorner, R.drawable.bg_top_corner_white);
        SkinManager.setImageResource(this.mNavigationBar.getBackImageView(), R.drawable.btn_sml_back_selector_s);
        SkinManager.setBackgroundResource(this.mGotItButton, R.drawable.frs_profession_button_bg);
        SkinManager.setViewTextColor(this.mGoPublishButton, R.color.CAM_X0302);
        SkinManager.setBackgroundColor(this.mBottomView, R.color.CAM_X0201);
        this.mGradientView.a(i2);
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.layout_frs_profession);
        this.mHeaderContainer = (RelativeLayout) findViewById(R.id.profession_header_container);
        this.mNavigationBar = (NavigationBar) findViewById(R.id.profession_intro_navigation_bar);
        this.mGradientView = (LinearGradientView) findViewById(R.id.profession_intro_background);
        this.mGoPublishButton = (TextView) findViewById(R.id.profession_intro_go_publish);
        this.mGotItButton = findViewById(R.id.profession_intro_got_it);
        this.mBottomView = findViewById(R.id.bottom_view);
        this.mProfessionDesc = findViewById(R.id.profession_intro_desc);
        this.mBack = this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, this.onClickListener);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.profession_intro_title));
        TbImageView tbImageView = (TbImageView) findViewById(R.id.profession_intro_content);
        this.mBackgroundContent = tbImageView;
        tbImageView.setDefaultBgResource(R.color.transparent);
        this.mBackgroundContent.setDefaultResource(R.drawable.pic_frs_head_default);
        this.mContainer = findViewById(R.id.profession_intro_container);
        this.mTopCorner = findViewById(R.id.profession_intro_top_corner);
        this.mFirstIndex = findViewById(R.id.profession_intro_first_index);
        this.mFirstIntro = findViewById(R.id.profession_intro_first_intro);
        this.mFirstTitle = findViewById(R.id.profession_intro_first_title);
        this.mSecondIndex = findViewById(R.id.profession_intro_second_index);
        this.mSecondIntro = findViewById(R.id.profession_intro_second_intro);
        this.mSecondTitle = findViewById(R.id.profession_intro_second_title);
        this.mGoPublishButton.setEnabled(true);
        this.mGoPublishButton.setOnClickListener(this.onClickListener);
        this.mGotItButton.setOnClickListener(this.onClickListener);
        handleNotchScreen();
        String stringExtra = getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_PATTEN_BACKGROUND);
        this.mGradientView.setGradientColor(getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DAY_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_NIGHT_DARK_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_LIGHT_COLOR), getIntent().getStringExtra(FrsProfessionIntroActivityConfig.KEY_DARK_DARK_COLOR));
        this.mBackgroundContent.U(stringExtra, 10, false);
    }
}
