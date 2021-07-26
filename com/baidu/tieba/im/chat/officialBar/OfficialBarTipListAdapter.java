package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.e.p.l;
import d.a.p0.t.d.d;
import d.a.q0.i1.f.i.c;
import org.apache.http.message.BasicNameValuePair;
/* loaded from: classes4.dex */
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

    @Override // d.a.q0.i1.f.i.c
    public boolean d(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, imMessageCenterShowItemData)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.i1.f.i.c
    public boolean e(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, imMessageCenterShowItemData)) == null) {
            return true;
        }
        return invokeL.booleanValue;
    }

    @Override // d.a.q0.i1.f.i.c
    public void g(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f58915b.setVisibility(8);
            aVar.f58917d.setVisibility(0);
            aVar.f58917d.setShowOval(true);
            aVar.f58917d.setAutoChangeStyle(true);
            aVar.f58917d.setStrokeWith(l.g(this.f58911e, R.dimen.tbds1));
            aVar.f58917d.setStrokeColorResId(R.color.CAM_X0401);
            aVar.f58917d.setTag(null);
            aVar.f58917d.setPlaceHolder(1);
            if (TextUtils.isEmpty(imMessageCenterShowItemData.getFriendPortrait())) {
                return;
            }
            aVar.f58917d.setTag(imMessageCenterShowItemData.getFriendPortrait());
            aVar.f58917d.M(imMessageCenterShowItemData.getFriendPortrait(), 10, false);
        }
    }

    @Override // d.a.q0.i1.f.i.c
    public void i(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f58918e.setText(this.f58911e.getString(R.string.chosen_pb_original_bar, imMessageCenterShowItemData.getFriendName()));
        }
    }

    @Override // d.a.q0.i1.f.i.c
    public void m(c.a aVar, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, aVar, imMessageCenterShowItemData) == null) {
            aVar.f58921h.setVisibility(8);
            SkinManager.setViewTextColor(aVar.f58918e, R.color.CAM_X0105, 1);
            SkinManager.setViewTextColor(aVar.f58919f, R.color.CAM_X0109, 1);
            SkinManager.setViewTextColor(aVar.f58920g, R.color.CAM_X0109, 1);
        }
    }

    @Override // d.a.q0.i1.f.i.c
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
