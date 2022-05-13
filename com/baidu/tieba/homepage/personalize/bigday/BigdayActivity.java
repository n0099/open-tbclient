package com.baidu.tieba.homepage.personalize.bigday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ActivityPendingTransitionFactory;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.BigdayActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.iu4;
import java.util.Calendar;
/* loaded from: classes3.dex */
public class BigdayActivity extends BaseActivity {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImageView bigdayClose;
    public long bigdayId;
    public TbImageView bigdayImg;
    public String imgUrl;
    public String jumpUrl;

    public BigdayActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            ActivityPendingTransitionFactory.closeAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void enterExitAnimation() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            ActivityPendingTransitionFactory.enterExitAnimation(getPageContext(), 0);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            if (view2.getId() == this.bigdayImg.getId()) {
                if (StringUtils.isNULL(this.jumpUrl)) {
                    return;
                }
                UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{this.jumpUrl});
                TiebaStatic.log(new StatisticItem("c13112").param("obj_id", this.bigdayId).param(TiebaStatic.Params.OBJ_TO, this.jumpUrl));
                finish();
            } else if (view2.getId() == this.bigdayClose.getId()) {
                Calendar calendar = Calendar.getInstance();
                calendar.set(11, 23);
                calendar.set(12, 59);
                calendar.set(13, 59);
                calendar.set(14, 0);
                iu4.k().x("key_bigday_next_showtime_home", calendar.getTimeInMillis());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921349, null));
                finish();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            setIsAddSwipeBackLayout(false);
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0159);
            TbImageView tbImageView = (TbImageView) findViewById(R.id.obfuscated_res_0x7f090371);
            this.bigdayImg = tbImageView;
            tbImageView.setAutoChangeStyle(false);
            this.bigdayClose = (ImageView) findViewById(R.id.obfuscated_res_0x7f090370);
            if (UtilHelper.canUseStyleImmersiveSticky()) {
                ((FrameLayout.LayoutParams) this.bigdayClose.getLayoutParams()).topMargin = (int) (UtilHelper.getStatusBarHeight() + getResources().getDimension(R.dimen.obfuscated_res_0x7f07028a));
            }
            Intent intent = getIntent();
            if (intent != null) {
                this.imgUrl = intent.getStringExtra(BigdayActivityConfig.IMG_URL);
                this.jumpUrl = intent.getStringExtra(BigdayActivityConfig.JUMP_URL);
                this.bigdayId = intent.getLongExtra(BigdayActivityConfig.BIGDAY_ID, 0L);
            }
            this.bigdayImg.setTag(getPageContext().getUniqueId());
            this.bigdayImg.K(this.imgUrl, 41, false);
            this.bigdayImg.setOnClickListener(this);
            this.bigdayClose.setOnClickListener(this);
            TiebaStatic.log(new StatisticItem("c13111").param("obj_id", this.bigdayId).param(TiebaStatic.Params.OBJ_TO, this.jumpUrl));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onPause();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921348, Boolean.TRUE));
        }
    }
}
