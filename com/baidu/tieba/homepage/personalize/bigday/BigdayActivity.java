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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.f;
import java.util.Calendar;
/* loaded from: classes2.dex */
public class BigdayActivity extends BaseActivity {
    private String acH;
    private long acJ;
    private TbImageView dYR;
    private ImageView dYS;
    private String imgUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(f.h.bigday_activity);
        this.dYR = (TbImageView) findViewById(f.g.bigday_img);
        this.dYR.setAutoChangeStyle(false);
        this.dYS = (ImageView) findViewById(f.g.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.dYS.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(f.e.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.acH = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.acJ = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.dYR.setTag(getPageContext().getUniqueId());
        this.dYR.startLoad(this.imgUrl, 41, false);
        this.dYR.setOnClickListener(this);
        this.dYS.setOnClickListener(this);
        TiebaStatic.log(new an("c13111").f(VideoPlayActivityConfig.OBJ_ID, this.acJ).ae("obj_to", this.acH));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.dYR.getId()) {
            if (!StringUtils.isNULL(this.acH)) {
                az.zI().c(getPageContext(), new String[]{this.acH});
                TiebaStatic.log(new an("c13112").f(VideoPlayActivityConfig.OBJ_ID, this.acJ).ae("obj_to", this.acH));
                finish();
            }
        } else if (view.getId() == this.dYS.getId()) {
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
