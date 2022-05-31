package com.baidu.tieba.frs.forumRule;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tbadk.widget.tiejia.TiebaPlusRecommendCard;
import com.baidu.tieba.frs.forumRule.model.ForumRulesShowModel;
import com.baidu.tieba.view.BdTopToast;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.ag;
import com.repackage.fh6;
import com.repackage.se5;
import com.repackage.ug6;
import com.repackage.wg6;
import com.repackage.xg6;
import com.repackage.yg6;
import java.util.List;
/* loaded from: classes3.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ug6 callback;
    public String mFrom;
    public ForumRulesShowModel mModel;
    public fh6 mView;
    public CustomMessageListener richTextIntentClickListener;

    /* loaded from: classes3.dex */
    public class a implements ug6 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowActivity a;

        public a(ForumRulesShowActivity forumRulesShowActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRulesShowActivity;
        }

        @Override // com.repackage.ug6
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.m();
            this.a.mView.y();
            ForumRulesShowActivity forumRulesShowActivity = this.a;
            forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.mView.k(), "");
        }

        @Override // com.repackage.ug6
        public void b(wg6 wg6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, wg6Var) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.g(wg6Var);
        }

        @Override // com.repackage.ug6
        public void c(List<yg6> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.h(list);
        }

        @Override // com.repackage.ug6
        public void d(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) || this.a.mView == null) {
                return;
            }
            if (z) {
                this.a.mView.A(str);
            } else {
                this.a.mView.q();
            }
        }

        @Override // com.repackage.ug6
        public void e(xg6 xg6Var) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, xg6Var) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.e(xg6Var);
        }

        @Override // com.repackage.ug6
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.a.mView == null) {
                return;
            }
            this.a.mView.i(str);
        }

        @Override // com.repackage.ug6
        public void finish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.a.mView == null) {
                return;
            }
            ForumRulesShowActivity forumRulesShowActivity = this.a;
            forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.mView.k());
            this.a.mView.n();
            this.a.mView.x();
            this.a.mView.u();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumRulesShowActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumRulesShowActivity forumRulesShowActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumRulesShowActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof se5.a)) {
                se5.a aVar = (se5.a) customResponsedMessage.getData();
                se5.b(this.a.getPageContext(), aVar.a, aVar.b, aVar.c);
            }
        }
    }

    public ForumRulesShowActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.callback = new a(this);
        this.richTextIntentClickListener = new b(this, 2001332);
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65538, this, bundle) == null) {
            this.mModel = new ForumRulesShowModel(this);
            setModelCallback();
        }
    }

    private void initView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65539, this) == null) {
            if (getIntent() != null) {
                this.mFrom = getIntent().getStringExtra("from");
            }
            fh6 fh6Var = new fh6(this, this.mFrom);
            this.mView = fh6Var;
            fh6Var.v(getRefreshView());
        }
    }

    private void setModelCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mModel.K(this.callback);
        }
    }

    public ag<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public ag<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public ag<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public ag<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public ag<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public ag<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public ag<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    public fh6 getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mView : (fh6) invokeV.objValue;
    }

    public ag<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (ag) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25053) {
                String stringExtra = intent.getStringExtra("group_name");
                if (!intent.getBooleanExtra("from", true)) {
                    this.mView.t();
                    this.mView.n.clear();
                    this.mModel.J();
                }
                BdTopToast bdTopToast = new BdTopToast(this, 3000);
                bdTopToast.i(true);
                bdTopToast.h(stringExtra);
                bdTopToast.j(this.mView.l());
            }
        }
    }

    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            super.onChangeSkinType(i);
            fh6 fh6Var = this.mView;
            if (fh6Var != null) {
                fh6Var.onChangeSkinType(i);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            initData(bundle);
            initView();
            this.mModel.E(bundle);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            super.onDestroy();
            ForumRulesShowModel forumRulesShowModel = this.mModel;
            if (forumRulesShowModel != null) {
                forumRulesShowModel.destory();
            }
            fh6 fh6Var = this.mView;
            if (fh6Var != null) {
                fh6Var.j();
            }
        }
    }

    public void onLinkButtonClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048592, this, context, str) == null) {
        }
    }

    public void onLinkClicked(Context context, String str, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLZ(1048593, this, context, str, z) == null) {
            UrlManager.getInstance().dealOneLink(getPageContext(), new String[]{str});
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onPause();
            MessageManager.getInstance().unRegisterListener(this.richTextIntentClickListener);
        }
    }

    public void onPhoneClicked(Context context, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048595, this, context, str, str2) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onResume();
            registerListener(this.richTextIntentClickListener);
        }
    }

    public void onSongClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048597, this, context, str) == null) {
        }
    }

    public void onVideoClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048598, this, context, str) == null) {
        }
    }

    public void onVideoP2PClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048599, this, context, str) == null) {
        }
    }

    public void requestNet() {
        ForumRulesShowModel forumRulesShowModel;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048600, this) == null) || (forumRulesShowModel = this.mModel) == null) {
            return;
        }
        forumRulesShowModel.J();
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mFrom = str;
            fh6 fh6Var = this.mView;
            if (fh6Var != null) {
                fh6Var.setFrom(str);
            }
        }
    }
}
