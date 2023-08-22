package com.baidu.tieba;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.mutiprocess.location.LocationEvent;
import com.baidu.tieba.location.data.SearchLocationActivityConfig;
import com.baidu.tieba.location.selectpoi.SelectLocationActivity;
import com.baidu.tieba.tbadkCore.location.LocationData;
import com.baidu.tieba.tbadkCore.location.ResponsedSelectLocation;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class f49 implements dt5, View.OnClickListener, AdapterView.OnItemClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<SelectLocationActivity> a;
    public NavigationBar b;
    public ImageView c;
    public LinearLayout d;
    public BdListView e;
    public e49 f;
    public Intent g;

    @Override // com.baidu.tieba.dt5
    public boolean Z0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    public f49(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = tbPageContext;
        this.d = linearLayout;
        this.b = navigationBar;
        b();
        a();
    }

    @Override // com.baidu.tieba.dt5
    public boolean C() {
        InterceptResult invokeV;
        View childAt;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            BdListView bdListView = this.e;
            if (bdListView == null || bdListView.getFirstVisiblePosition() != 0 || (childAt = this.e.getChildAt(0)) == null || childAt.getTop() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.dt5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.g;
        }
        return (Intent) invokeV.objValue;
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d089e, (ViewGroup) this.d, true);
            this.e = (BdListView) this.d.findViewById(R.id.obfuscated_res_0x7f092181);
            e49 e49Var = new e49(this.a);
            this.f = e49Var;
            this.e.setAdapter((ListAdapter) e49Var);
            this.e.setOnItemClickListener(this);
        }
    }

    public final void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f134d));
            ImageView imageView = (ImageView) this.b.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.c = imageView;
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            layoutParams.setMargins(0, 0, BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070359), 0);
            this.c.setLayoutParams(layoutParams);
            this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.c.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048581, this, view2) == null) && view2 == this.c) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002012, new SearchLocationActivityConfig(this.a.getPageActivity(), 23009)));
        }
    }

    @Override // com.baidu.tieba.dt5
    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.c.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_topbar_search40, SkinManager.getColor(R.color.CAM_X0105), WebPManager.ResourceStateType.NORMAL_PRESS));
            this.f.notifyDataSetChanged();
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048582, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) != null) || this.f == null) {
            return;
        }
        MessageManager messageManager = MessageManager.getInstance();
        LocationEvent locationEvent = new LocationEvent();
        locationEvent.setType(1);
        locationEvent.eventType = 2;
        if (i == 0) {
            messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(false, null, null, null));
            locationEvent.isShowLocation = false;
            this.a.getOrignalPage().publishEvent(locationEvent);
            this.a.getOrignalPage().finish();
            return;
        }
        Object item = this.f.getItem(i);
        if (!(item instanceof LocationData.NearByAddressData)) {
            return;
        }
        LocationData.NearByAddressData nearByAddressData = (LocationData.NearByAddressData) item;
        messageManager.dispatchResponsedMessage(new ResponsedSelectLocation(true, nearByAddressData.getName(), nearByAddressData.getAddr(), nearByAddressData.getSn()));
        locationEvent.locName = nearByAddressData.getName();
        locationEvent.locAddr = nearByAddressData.getAddr();
        locationEvent.locSn = nearByAddressData.getSn();
        locationEvent.isShowLocation = true;
        this.a.getOrignalPage().publishEvent(locationEvent);
        this.a.getOrignalPage().finish();
    }
}
