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
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.n0.r.d0.b;
import java.util.Calendar;
/* loaded from: classes4.dex */
public class BigdayActivity extends BaseActivity {
    public ImageView bigdayClose;
    public long bigdayId;
    public TbImageView bigdayImg;
    public String imgUrl;
    public String jumpUrl;

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == this.bigdayImg.getId()) {
            if (StringUtils.isNULL(this.jumpUrl)) {
                return;
            }
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.jumpUrl});
            TiebaStatic.log(new StatisticItem("c13112").param("obj_id", this.bigdayId).param(TiebaStatic.Params.OBJ_TO, this.jumpUrl));
            finish();
        } else if (view.getId() == this.bigdayClose.getId()) {
            Calendar calendar = Calendar.getInstance();
            calendar.set(11, 23);
            calendar.set(12, 59);
            calendar.set(13, 59);
            calendar.set(14, 0);
            b.j().w("key_bigday_next_showtime_home", calendar.getTimeInMillis());
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, null));
            finish();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        super.onCreate(bundle);
        setContentView(R.layout.bigday_activity);
        TbImageView tbImageView = (TbImageView) findViewById(R.id.bigday_img);
        this.bigdayImg = tbImageView;
        tbImageView.setAutoChangeStyle(false);
        this.bigdayClose = (ImageView) findViewById(R.id.bigday_close);
        if (UtilHelper.canUseStyleImmersiveSticky()) {
            ((FrameLayout.LayoutParams) this.bigdayClose.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(R.dimen.ds25));
        }
        Intent intent = getIntent();
        if (intent != null) {
            this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
            this.jumpUrl = intent.getStringExtra("jump_url");
            this.bigdayId = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
        }
        this.bigdayImg.setTag(getPageContext().getUniqueId());
        this.bigdayImg.U(this.imgUrl, 41, false);
        this.bigdayImg.setOnClickListener(this);
        this.bigdayClose.setOnClickListener(this);
        TiebaStatic.log(new StatisticItem("c13111").param("obj_id", this.bigdayId).param(TiebaStatic.Params.OBJ_TO, this.jumpUrl));
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
    }
}
