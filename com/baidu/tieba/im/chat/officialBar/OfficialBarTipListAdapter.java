package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import c.a.d.f.p.m;
import c.a.r0.t.d.d;
import c.a.s0.s1.f.i.c;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes12.dex */
public class OfficialBarTipListAdapter extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OfficialBarTipListAdapter(OfficialBarTipActivity officialBarTipActivity) {
        super(officialBarTipActivity.getPageContext().getContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {officialBarTipActivity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // c.a.s0.s1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.s1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // c.a.s0.s1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f22071b.setVisibility(8);
            aVar.f22073d.setVisibility(0);
            aVar.f22073d.setShowOval(true);
            aVar.f22073d.setAutoChangeStyle(true);
            aVar.f22073d.setStrokeWith(m.f(this.f22068e, R.dimen.tbds1));
            aVar.f22073d.setStrokeColorResId(R.color.CAM_X0401);
            aVar.f22073d.setTag(null);
            aVar.f22073d.setPlaceHolder(1);
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                return;
            }
            aVar.f22073d.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f22073d.startLoad(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // c.a.s0.s1.f.i.c
    public void i(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f22074e.setText(this.f22068e.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
        }
    }

    @Override // c.a.s0.s1.f.i.c
    public void m(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f22077h.setVisibility(8);
            SkinManager.setViewTextColor(aVar.f22074e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f22075f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.f22076g, R.color.CAM_X0109, 1);
        }
    }

    @Override // c.a.s0.s1.f.i.c
    public BasicNameValuePair p(ImMessageCenterShowItemData imMessageCenterShowItemData, int i2, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048581, this, imMessageCenterShowItemData, i2, str)) == null) {
            String str2 = "";
            int i3 = 0;
            if (!d.d().l()) {
                str = "";
                i2 = 0;
            }
            if (imMessageCenterShowItemData.getGroupSetting().isAcceptNotify()) {
                i3 = i2;
                str2 = str;
            }
            return new BasicNameValuePair(String.valueOf(i3), str2);
        }
        return (BasicNameValuePair) invokeLIL.objValue;
    }
}
