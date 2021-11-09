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
import b.a.q0.f1.n.f;
import b.a.r0.x0.a2.f.c;
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
import java.util.List;
/* loaded from: classes9.dex */
public class ForumRulesShowActivity extends BaseActivity<ForumRulesShowActivity> implements Object {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public b.a.r0.x0.a2.b.a callback;
    public String mFrom;
    public ForumRulesShowModel mModel;
    public c mView;
    public CustomMessageListener richTextIntentClickListener;

    /* loaded from: classes9.dex */
    public class a implements b.a.r0.x0.a2.b.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumRulesShowActivity f48506a;

        public a(ForumRulesShowActivity forumRulesShowActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48506a = forumRulesShowActivity;
        }

        @Override // b.a.r0.x0.a2.b.a
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f48506a.mView == null) {
                return;
            }
            this.f48506a.mView.k();
            this.f48506a.mView.v();
            ForumRulesShowActivity forumRulesShowActivity = this.f48506a;
            forumRulesShowActivity.showNetRefreshView(forumRulesShowActivity.mView.i(), "");
        }

        @Override // b.a.r0.x0.a2.b.a
        public void b(b.a.r0.x0.a2.c.a aVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) || this.f48506a.mView == null) {
                return;
            }
            this.f48506a.mView.e(aVar);
        }

        @Override // b.a.r0.x0.a2.b.a
        public void c(List<b.a.r0.x0.a2.c.c> list) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) || this.f48506a.mView == null) {
                return;
            }
            this.f48506a.mView.f(list);
        }

        @Override // b.a.r0.x0.a2.b.a
        public void d(boolean z, String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeZL(1048579, this, z, str) == null) || this.f48506a.mView == null) {
                return;
            }
            if (z) {
                this.f48506a.mView.x(str);
            } else {
                this.f48506a.mView.n();
            }
        }

        @Override // b.a.r0.x0.a2.b.a
        public void e(b.a.r0.x0.a2.c.b bVar) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) || this.f48506a.mView == null) {
                return;
            }
            this.f48506a.mView.d(bVar);
        }

        @Override // b.a.r0.x0.a2.b.a
        public void f(String str) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048581, this, str) == null) || this.f48506a.mView == null) {
                return;
            }
            this.f48506a.mView.g(str);
        }

        @Override // b.a.r0.x0.a2.b.a
        public void finish() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048582, this) == null) || this.f48506a.mView == null) {
                return;
            }
            ForumRulesShowActivity forumRulesShowActivity = this.f48506a;
            forumRulesShowActivity.hideNetRefreshView(forumRulesShowActivity.mView.i());
            this.f48506a.mView.l();
            this.f48506a.mView.u();
            this.f48506a.mView.r();
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ForumRulesShowActivity f48507a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumRulesShowActivity forumRulesShowActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumRulesShowActivity, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48507a = forumRulesShowActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof f.a)) {
                f.a aVar = (f.a) customResponsedMessage.getData();
                f.b(this.f48507a.getPageContext(), aVar.f12438a, aVar.f12439b, aVar.f12440c);
            }
        }
    }

    public ForumRulesShowActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
            c cVar = new c(this, this.mFrom);
            this.mView = cVar;
            cVar.s(getRefreshView());
        }
    }

    private void setModelCallback() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, this) == null) {
            this.mModel.I(this.callback);
        }
    }

    public b.a.e.e.k.b<GifView> getGifViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public b.a.e.e.k.b<ImageView> getImageViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public b.a.e.e.k.b<ItemCardView> getItemCardViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public b.a.e.e.k.b<RelativeLayout> getRelativeLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public int getRichTextViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return 0;
        }
        return invokeV.intValue;
    }

    public b.a.e.e.k.b<TextView> getTextViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public b.a.e.e.k.b<LinearLayout> getTextVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public b.a.e.e.k.b<TiebaPlusRecommendCard> getTiejiaRecommendPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public c getView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) ? this.mView : (c) invokeV.objValue;
    }

    public b.a.e.e.k.b<View> getVoiceViewPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return null;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048587, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 25053) {
                String stringExtra = intent.getStringExtra("group_name");
                if (!intent.getBooleanExtra("from", true)) {
                    this.mView.q();
                    this.mView.r.clear();
                    this.mModel.H();
                }
                new BdTopToast(this, 3000).setIcon(true).setContent(stringExtra).show(this.mView.j());
            }
        }
    }

    public void onAtClicked(Context context, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, context, str) == null) {
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i2) == null) {
            super.onChangeSkinType(i2);
            c cVar = this.mView;
            if (cVar != null) {
                cVar.onChangeSkinType(i2);
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
            this.mModel.C(bundle);
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
            c cVar = this.mView;
            if (cVar != null) {
                cVar.h();
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
        forumRulesShowModel.H();
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.mFrom = str;
            c cVar = this.mView;
            if (cVar != null) {
                cVar.setFrom(str);
            }
        }
    }
}
