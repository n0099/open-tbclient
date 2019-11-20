package com.baidu.tieba.ala.guardclub;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.baidu.ala.AlaCmdConfigCustom;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.BaseActivity;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.atomdata.GuardClubInfoActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.IntentConfig;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.megapp.ma.Util;
/* loaded from: classes6.dex */
public class GuardClubInfoActivity extends BaseActivity<GuardClubInfoActivity> {
    private long Of;
    private boolean Pr;
    private String WE;
    private b dKh;
    private boolean dKi;
    private boolean isFullScreen;
    private long liveId;
    private String otherParams;
    private long roomId;
    private Handler mHandler = new Handler();
    CustomMessageListener afT = new CustomMessageListener(AlaCmdConfigCustom.CMD_ALA_IMAGE_FRAME_PLAYER_CONTROLLER) { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            GuardClubInfoActivity.this.closeActivity();
        }
    };
    CustomMessageListener notifyDialogDismissListener = new CustomMessageListener(2913097) { // from class: com.baidu.tieba.ala.guardclub.GuardClubInfoActivity.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage.getData() != null && (customResponsedMessage.getData() instanceof String) && TextUtils.equals((String) customResponsedMessage.getData(), "into_end_view")) {
                GuardClubInfoActivity.this.closeActivity();
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        boolean booleanExtra = getIntent().getBooleanExtra("is_translucent", false);
        if (booleanExtra) {
            setTheme(a.j.DialogStyleBottom);
        }
        super.onCreate(bundle);
        this.Of = getIntent().getLongExtra("anchor_id", 0L);
        this.liveId = getIntent().getLongExtra("live_id", 0L);
        this.roomId = getIntent().getLongExtra("room_id", 0L);
        this.WE = getIntent().getStringExtra("feed_id");
        this.Pr = getIntent().getBooleanExtra("is_live_owner", false);
        this.otherParams = getIntent().getStringExtra(IntentConfig.OTHER_PARAMS);
        this.isFullScreen = getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_FULLSCREEN, true);
        this.dKi = getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_CLUB_MEMBER, true);
        String stringExtra = getIntent().getStringExtra(GuardClubInfoActivityConfig.FROM_LOC_INFO);
        this.dKh = new b(this, this.Of, this.liveId, this.roomId, this.WE, this.Pr, this.otherParams, this.isFullScreen, this.dKi, getIntent().getBooleanExtra(GuardClubInfoActivityConfig.IS_HIDE_RANK, false), stringExtra, booleanExtra);
        if (this.dKh.getView() != null) {
            setContentView(this.dKh.getView());
        }
        if (!this.isFullScreen) {
            registerListener(this.afT);
        }
        registerListener(this.notifyDialogDismissListener);
        if (UtilHelper.getRealScreenOrientation(getActivity()) == 2) {
            com.baidu.live.utils.g.P(this.dKh.getView());
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.dKh.getView() != null) {
            this.dKh.qa();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        if (this.isFullScreen) {
            UtilHelper.changeStatusBarIconAndTextColor(true, getActivity());
        }
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void enterExitAnimation() {
        aIF();
    }

    @Override // com.baidu.live.tbadk.BaseActivity
    public void closeAnimation() {
        aIF();
    }

    public void aIF() {
        int hostResourcesId;
        int hostResourcesId2;
        if (UtilHelper.getRealScreenOrientation(getPageContext().getPageActivity()) == 2) {
            if (this instanceof Activity) {
                hostResourcesId = a.C0068a.sdk_activity_open_translate_from_right;
                hostResourcesId2 = a.C0068a.sdk_activity_close_translate_to_right;
            } else {
                hostResourcesId = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_right", "anim");
                hostResourcesId2 = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_right", "anim");
            }
        } else if (this instanceof Activity) {
            hostResourcesId = a.C0068a.sdk_activity_open_translate_from_bottom;
            hostResourcesId2 = a.C0068a.sdk_activity_close_translate_from_top;
        } else {
            hostResourcesId = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_in_from_bottom", "anim");
            hostResourcesId2 = Util.getHostResourcesId(getActivity(), TbConfig.PACKAGE_NAME, "slide_out_to_bottom", "anim");
        }
        overridePendingTransition(hostResourcesId, hostResourcesId2);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, com.baidu.live.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        this.mHandler.removeCallbacksAndMessages(null);
        if (this.dKh != null) {
            this.dKh.onDestroy();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1) {
            if ((i == 25045 || i == 25046) && this.dKh != null) {
                this.dKh.aLg();
            }
            if (i == 25046 && intent != null) {
                if (intent.getBooleanExtra("guard_club_rank_hit", false)) {
                    setResult(-1);
                    finish();
                } else if (intent.getBooleanExtra("guard_club_rank_back_to_room", false)) {
                    finish();
                }
            }
        }
    }
}
