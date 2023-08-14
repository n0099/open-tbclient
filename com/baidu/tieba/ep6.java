package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.ItemData;
import com.baidu.tbadk.core.util.ItemClickJumpUtil;
import com.baidu.tbadk.core.view.ItemCardView;
import com.baidu.tieba.k37;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class ep6 implements k37.i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n47 a;
        public final /* synthetic */ ItemData b;

        public a(ep6 ep6Var, n47 n47Var, ItemData itemData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep6Var, n47Var, itemData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = n47Var;
            this.b = itemData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                int i = 1;
                int i2 = 2;
                if (this.a.c() != null) {
                    if (ImageViewerConfig.FROM_CONCERN.equals(this.a.c().b)) {
                        i = 2;
                    } else if ("recommend".equals(this.a.c().b)) {
                        i2 = 1;
                    }
                    ItemData itemData = this.b;
                    ItemClickJumpUtil.itemClickJump(itemData.forumName, String.valueOf(itemData.itemId), i, Integer.valueOf(i2));
                }
                i = 0;
                i2 = 0;
                ItemData itemData2 = this.b;
                ItemClickJumpUtil.itemClickJump(itemData2.forumName, String.valueOf(itemData2.itemId), i, Integer.valueOf(i2));
            }
        }
    }

    public ep6() {
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

    @Override // com.baidu.tieba.k37.r
    public void a(@NonNull ViewGroup viewGroup) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, viewGroup) == null) && (viewGroup instanceof ItemCardView)) {
            ((ItemCardView) viewGroup).G();
        }
    }

    @Override // com.baidu.tieba.k37.i
    @NonNull
    public ViewGroup create(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
            return new ItemCardView(context);
        }
        return (ViewGroup) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k37.i
    public void update(@NonNull ViewGroup viewGroup, @NonNull n47 n47Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, n47Var) == null) && viewGroup != null && n47Var != null && n47Var.a() != null) {
            u67 a2 = n47Var.a();
            ItemData itemData = new ItemData();
            itemData.itemId = a2.a;
            itemData.buttonName = a2.h;
            itemData.buttonLink = a2.i;
            int i = 2;
            itemData.buttonLinkType = 2;
            itemData.mIconUrl = a2.b;
            itemData.mTitle = a2.d;
            itemData.mTags = a2.g;
            itemData.mScore = a2.f;
            itemData.mStar = a2.e;
            itemData.mIconSize = a2.c;
            itemData.forumName = a2.k;
            int i2 = a2.j;
            if (i2 != 0) {
                ((ItemCardView) viewGroup).setBackGroundColor(i2);
            }
            if (n47Var.c() != null) {
                str = n47Var.c().a;
            } else {
                str = "";
            }
            if (n47Var.c() != null) {
                if (!ImageViewerConfig.FROM_CONCERN.equals(n47Var.c().b)) {
                    if ("recommend".equals(n47Var.c().b)) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                }
                ((ItemCardView) viewGroup).setPosition(i);
            }
            ItemCardView itemCardView = (ItemCardView) viewGroup;
            itemCardView.setIsShowRightBtn(true);
            itemCardView.setData(itemData, 13, str);
            if (n47Var.b()) {
                viewGroup.setOnClickListener(new a(this, n47Var, itemData));
            } else {
                viewGroup.setClickable(false);
            }
        }
    }
}
