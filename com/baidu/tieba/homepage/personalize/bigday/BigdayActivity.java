package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
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
/* loaded from: classes21.dex */
public class BigdayActivity extends BaseActivity {
    private String aEb;
    private long dXq;
    private TbImageView iYh;
    private ImageView iYi;
    private String imgUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.bigday_activity);
        this.iYh = (TbImageView) findViewById(R.id.bigday_img);
        this.iYh.setAutoChangeStyle(false);
        this.iYi = (ImageView) findViewById(R.id.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.iYi.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(R.dimen.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.aEb = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.dXq = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.iYh.setTag(getPageContext().getUniqueId());
        this.iYh.startLoad(this.imgUrl, 41, false);
        this.iYh.setOnClickListener(this);
        this.iYi.setOnClickListener(this);
        TiebaStatic.log(new aq("c13111").u("obj_id", this.dXq).dF(TiebaInitialize.Params.OBJ_TO, this.aEb));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.iYh.getId()) {
            if (!StringUtils.isNULL(this.aEb)) {
                be.bkp().b(getPageContext(), new String[]{this.aEb});
                TiebaStatic.log(new aq("c13112").u("obj_id", this.dXq).dF(TiebaInitialize.Params.OBJ_TO, this.aEb));
                finish();
            }
        } else if (view.getId() == this.iYi.getId()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 0);
            com.baidu.tbadk.core.sharedPref.b.bjf().putLong("key_bigday_next_showtime_home", calendar.getTimeInMillis());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, null));
            finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, true));
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
