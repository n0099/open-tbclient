package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class BigdayActivity extends BaseActivity {
    private String aEU;
    private long eHU;
    private String imgUrl;
    private TbImageView kcM;
    private ImageView kcN;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.bigday_activity);
        this.kcM = (TbImageView) findViewById(R.id.bigday_img);
        this.kcM.setAutoChangeStyle(false);
        this.kcN = (ImageView) findViewById(R.id.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.kcN.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(R.dimen.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.aEU = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.eHU = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.kcM.setTag(getPageContext().getUniqueId());
        this.kcM.startLoad(this.imgUrl, 41, false);
        this.kcM.setOnClickListener(this);
        this.kcN.setOnClickListener(this);
        TiebaStatic.log(new aq("c13111").w("obj_id", this.eHU).dW(TiebaInitialize.Params.OBJ_TO, this.aEU));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.kcM.getId()) {
            if (!StringUtils.isNULL(this.aEU)) {
                be.bsB().b(getPageContext(), new String[]{this.aEU});
                TiebaStatic.log(new aq("c13112").w("obj_id", this.eHU).dW(TiebaInitialize.Params.OBJ_TO, this.aEU));
                finish();
            }
        } else if (view.getId() == this.kcN.getId()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 0);
            com.baidu.tbadk.core.sharedPref.b.brx().putLong("key_bigday_next_showtime_home", calendar.getTimeInMillis());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_BC_CHAT, null));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GET_LIVE_IS_MIX, true));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }
}
