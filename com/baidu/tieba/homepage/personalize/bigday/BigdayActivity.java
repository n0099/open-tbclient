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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import java.util.Calendar;
/* loaded from: classes6.dex */
public class BigdayActivity extends BaseActivity {
    private String aou;
    private long aow;
    private TbImageView ewv;
    private ImageView eww;
    private String imgUrl;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(e.h.bigday_activity);
        this.ewv = (TbImageView) findViewById(e.g.bigday_img);
        this.ewv.setAutoChangeStyle(false);
        this.eww = (ImageView) findViewById(e.g.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.eww.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(e.C0210e.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.aou = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
            this.aow = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.ewv.setTag(getPageContext().getUniqueId());
        this.ewv.startLoad(this.imgUrl, 41, false);
        this.ewv.setOnClickListener(this);
        this.eww.setOnClickListener(this);
        TiebaStatic.log(new am("c13111").i(VideoPlayActivityConfig.OBJ_ID, this.aow).aA("obj_to", this.aou));
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.ewv.getId()) {
            if (!StringUtils.isNULL(this.aou)) {
                ay.Ef().c(getPageContext(), new String[]{this.aou});
                TiebaStatic.log(new am("c13112").i(VideoPlayActivityConfig.OBJ_ID, this.aow).aA("obj_to", this.aou));
                finish();
            }
        } else if (view.getId() == this.eww.getId()) {
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
