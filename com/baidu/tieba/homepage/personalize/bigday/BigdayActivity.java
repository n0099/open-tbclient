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
    private String bvM;
    private long bvO;
    private TbImageView fMI;
    private ImageView fMJ;
    private String imgUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(d.h.bigday_activity);
        this.fMI = (TbImageView) findViewById(d.g.bigday_img);
        this.fMI.setAutoChangeStyle(false);
        this.fMJ = (ImageView) findViewById(d.g.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.fMJ.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(d.e.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.bvM = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.bvO = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.fMI.setTag(getPageContext().getUniqueId());
        this.fMI.startLoad(this.imgUrl, 41, false);
        this.fMI.setOnClickListener(this);
        this.fMJ.setOnClickListener(this);
        TiebaStatic.log(new am("c13111").k(VideoPlayActivityConfig.OBJ_ID, this.bvO).bJ("obj_to", this.bvM));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.fMI.getId()) {
            if (!StringUtils.isNULL(this.bvM)) {
                ba.adA().c(getPageContext(), new String[]{this.bvM});
                TiebaStatic.log(new am("c13112").k(VideoPlayActivityConfig.OBJ_ID, this.bvO).bJ("obj_to", this.bvM));
                finish();
            }
        } else if (view.getId() == this.fMJ.getId()) {
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
