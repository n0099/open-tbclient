package com.baidu.tieba.ala.alasquare.live_tab.fragment;

import android.content.Context;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.p.m;
import c.a.s0.g0.h;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public abstract class LiveTabBaseSubFragment extends BaseFragment {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String ARG_AFTER_LAZY_LOADED = "arg_after_lazy_loaded";
    public static final String ARG_TAB_ID = "arg_tab_id";
    public transient /* synthetic */ FieldHolder $fh;
    public final String FRS_DYNAMIC_FRAGMENT_SHOW;

    /* renamed from: e  reason: collision with root package name */
    public h f43436e;
    public boolean isAfterLazyLoaded;
    public boolean isHideTopHeader;
    public Context mContext;
    public String mFid;
    public String mFname;
    public LinearLayout mTopContainer;
    public CustomMessageListener mTopHeaderListener;
    public int tabId;

    /* loaded from: classes12.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ LiveTabBaseSubFragment a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(LiveTabBaseSubFragment liveTabBaseSubFragment, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {liveTabBaseSubFragment, Integer.valueOf(i2)};
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
            this.a = liveTabBaseSubFragment;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Boolean bool;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (bool = (Boolean) customResponsedMessage.getData()) != null && bool.booleanValue()) {
                this.a.isHideTopHeader = false;
            }
        }
    }

    public LiveTabBaseSubFragment() {
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
        this.FRS_DYNAMIC_FRAGMENT_SHOW = "c13008";
        this.isAfterLazyLoaded = false;
        this.isHideTopHeader = false;
        this.mTopHeaderListener = new a(this, 2921442);
    }

    public void hideEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.mTopContainer.setVisibility(8);
        }
    }

    public void hideTopHeader() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921441, Boolean.FALSE));
            this.isHideTopHeader = true;
        }
    }

    public boolean isFromFrs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? (m.isEmpty(this.mFid) || m.isEmpty(this.mFname)) ? false : true : invokeV.booleanValue;
    }

    public abstract void loadData();

    public abstract void notifyListViewChanged();

    @Override // com.baidu.tbadk.core.BaseFragment
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            super.onChangeSkinType(i2);
            h hVar = this.f43436e;
            if (hVar != null) {
                hVar.onChangeSkinType();
            }
        }
    }

    public abstract void refreshPage();

    public void setForumInfo(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, str, str2) == null) {
            this.mFid = str;
            this.mFname = str2;
        }
    }

    public void showEmptyView() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.mTopContainer.setVisibility(0);
            if (this.f43436e == null) {
                this.f43436e = new h(this.mContext, null);
            }
            this.f43436e.e();
            this.f43436e.i(R.drawable.new_pic_emotion_03);
            this.f43436e.o(this.mContext.getResources().getString(R.string.no_data_common_txt));
            this.f43436e.onChangeSkinType();
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            if (this.f43436e.b() == null || this.f43436e.b().getParent() != null) {
                return;
            }
            this.mTopContainer.addView(this.f43436e.b(), layoutParams);
        }
    }
}
