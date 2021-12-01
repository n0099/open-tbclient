package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import c.a.d.m.e.n;
import c.a.d.m.e.s;
import c.a.q0.s.u.c;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes10.dex */
public final class CardLinkageManager {
    public static final /* synthetic */ CardLinkageManager[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CardLinkageManager INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;
    public List<Long> mThreadIdList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(480451858, "Lcom/baidu/tieba/card/CardLinkageManager;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(480451858, "Lcom/baidu/tieba/card/CardLinkageManager;");
                return;
            }
        }
        CardLinkageManager cardLinkageManager = new CardLinkageManager("INSTANCE", 0);
        INSTANCE = cardLinkageManager;
        $VALUES = new CardLinkageManager[]{cardLinkageManager};
    }

    public CardLinkageManager(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str2 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static CardLinkageManager valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CardLinkageManager) Enum.valueOf(CardLinkageManager.class, str) : (CardLinkageManager) invokeL.objValue;
    }

    public static CardLinkageManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CardLinkageManager[]) $VALUES.clone() : (CardLinkageManager[]) invokeV.objValue;
    }

    public void addThreadId(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j2) == null) {
            if (this.mThreadIdList == null) {
                this.mThreadIdList = new ArrayList();
            }
            this.mThreadIdList.add(Long.valueOf(j2));
        }
    }

    public void deleteThreadIds() {
        List<Long> list;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) || (list = this.mThreadIdList) == null) {
            return;
        }
        list.clear();
    }

    public void pressLinkage(s sVar, int i2, boolean z) {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{sVar, Integer.valueOf(i2), Boolean.valueOf(z)}) == null) && (sVar instanceof BdTypeRecyclerView)) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) sVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            List<n> data = bdTypeRecyclerView.getData();
            Object item = ListUtils.getItem(data, i2);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i3 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i3 <= lastVisiblePosition; i3++) {
                    Object item2 = ListUtils.getItem(data, i3 - headerViewsCount);
                    if (item2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                        if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i3)) != null) {
                            if (baseCardInfo2.isSupportFull()) {
                                c d2 = c.d(findViewByPosition);
                                d2.m(0);
                                d2.n(R.string.J_X06);
                                d2.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportTop()) {
                                c d3 = c.d(findViewByPosition);
                                d3.m(1);
                                d3.n(R.string.J_X06);
                                d3.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportBottom()) {
                                c d4 = c.d(findViewByPosition);
                                d4.m(2);
                                d4.n(R.string.J_X06);
                                d4.f(z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                SkinManager.setBackgroundColor(findViewByPosition, z ? R.color.CAM_X0206 : R.color.CAM_X0205);
                            }
                        }
                    }
                }
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i2, float f2) {
        View findViewByPosition;
        View findViewByPosition2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdTypeRecyclerView, Integer.valueOf(i2), Float.valueOf(f2)}) == null) || bdTypeRecyclerView == null) {
            return;
        }
        int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
        RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        List<n> data = bdTypeRecyclerView.getData();
        Object item = ListUtils.getItem(data, i2 - headerViewsCount);
        if (item instanceof BaseCardInfo) {
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            for (int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                Object item2 = ListUtils.getItem(data, firstVisiblePosition - headerViewsCount);
                if (!(item2 instanceof BaseCardInfo)) {
                    if ((item2 instanceof n) && (findViewByPosition2 = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                        findViewByPosition2.setTranslationY(f2);
                    }
                } else if (baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                    findViewByPosition.setTranslationY(f2);
                }
            }
        }
    }
}
