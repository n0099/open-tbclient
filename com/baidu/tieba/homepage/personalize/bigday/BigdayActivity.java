package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.atomData.VideoPlayActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class BigdayActivity extends BaseActivity {
    private String bvG;
    private long bvI;
    private TbImageView fMV;
    private ImageView fMW;
    private String imgUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.bigday_activity);
        this.fMV = (TbImageView) findViewById(d.g.bigday_img);
        this.fMV.setAutoChangeStyle(false);
        this.fMW = (ImageView) findViewById(d.g.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.fMW.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(d.e.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.bvG = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.bvI = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.fMV.setTag(getPageContext().getUniqueId());
        this.fMV.startLoad(this.imgUrl, 41, false);
        this.fMV.setOnClickListener(this);
        this.fMW.setOnClickListener(this);
        TiebaStatic.log(new am("c13111").k(VideoPlayActivityConfig.OBJ_ID, this.bvI).bJ("obj_to", this.bvG));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.fMV.getId()) {
            if (!StringUtils.isNULL(this.bvG)) {
                ba.adD().c(getPageContext(), new String[]{this.bvG});
                TiebaStatic.log(new am("c13112").k(VideoPlayActivityConfig.OBJ_ID, this.bvI).bJ("obj_to", this.bvG));
                finish();
            }
        } else if (view.getId() == this.fMW.getId()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 0);
            com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("key_bigday_next_showtime_home", calendar.getTimeInMillis());
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
