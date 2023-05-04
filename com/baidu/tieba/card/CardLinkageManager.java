package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.ax4;
import com.baidu.tieba.card.data.BaseCardInfo;
import com.baidu.tieba.eq5;
import com.baidu.tieba.g35;
import com.baidu.tieba.in;
import com.baidu.tieba.on;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
public final class CardLinkageManager {
    public static final /* synthetic */ CardLinkageManager[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final CardLinkageManager INSTANCE;
    public transient /* synthetic */ FieldHolder $fh;

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

    public static CardLinkageManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            return (CardLinkageManager[]) $VALUES.clone();
        }
        return (CardLinkageManager[]) invokeV.objValue;
    }

    public CardLinkageManager(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            return (CardLinkageManager) Enum.valueOf(CardLinkageManager.class, str);
        }
        return (CardLinkageManager) invokeL.objValue;
    }

    public void cancelHighLight(on onVar, BaseCardInfo baseCardInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048576, this, onVar, baseCardInfo) != null) || !baseCardInfo.isHighLight()) {
            return;
        }
        if (baseCardInfo instanceof ax4) {
            ((ax4) baseCardInfo).getThreadData().cancelHighLight();
        }
        if (onVar != null && onVar.getListAdapter() != null) {
            onVar.getListAdapter().notifyDataSetChanged();
        }
    }

    public void pressLinkage(on onVar, int i, boolean z) {
        int i2;
        int i3;
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{onVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (onVar instanceof BdTypeRecyclerView)) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) onVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            List<in> data = bdTypeRecyclerView.getData();
            Object item = ListUtils.getItem(data, i);
            if (!(item instanceof BaseCardInfo)) {
                return;
            }
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
            if (baseCardInfo.isHighLight()) {
                if (z) {
                    i2 = R.color.CAM_X0337;
                } else {
                    i2 = R.color.CAM_X0313;
                }
            } else if (z) {
                i2 = R.color.CAM_X0206;
            } else {
                i2 = R.color.CAM_X0205;
            }
            if (firstVisiblePosition > headerViewsCount) {
                i3 = firstVisiblePosition - headerViewsCount;
            } else {
                i3 = headerViewsCount;
            }
            while (i3 <= lastVisiblePosition) {
                Object item2 = ListUtils.getItem(data, i3 - headerViewsCount);
                if (item2 instanceof BaseCardInfo) {
                    BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                    if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i3)) != null) {
                        if (baseCardInfo2.isSupportFull()) {
                            g35 d = g35.d(findViewByPosition);
                            d.n(0);
                            d.o(R.string.J_X06);
                            d.f(i2);
                        } else if (baseCardInfo2.isSupportTop()) {
                            g35 d2 = g35.d(findViewByPosition);
                            d2.n(1);
                            d2.o(R.string.J_X06);
                            d2.f(i2);
                        } else if (baseCardInfo2.isSupportBottom()) {
                            g35 d3 = g35.d(findViewByPosition);
                            d3.n(2);
                            d3.o(R.string.J_X06);
                            d3.f(i2);
                        } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                            SkinManager.setBackgroundColor(findViewByPosition, i2);
                        }
                    }
                }
                i3++;
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i, float f) {
        View findViewByPosition;
        View findViewByPosition2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{bdTypeRecyclerView, Integer.valueOf(i), Float.valueOf(f)}) != null) || bdTypeRecyclerView == null) {
            return;
        }
        int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
        RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        List<in> data = bdTypeRecyclerView.getData();
        Object item = ListUtils.getItem(data, i - headerViewsCount);
        if (!(item instanceof BaseCardInfo)) {
            return;
        }
        BaseCardInfo baseCardInfo = (BaseCardInfo) item;
        for (int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
            Object item2 = ListUtils.getItem(data, firstVisiblePosition - headerViewsCount);
            if (!eq5.p(item2)) {
                if (!(item2 instanceof BaseCardInfo)) {
                    if ((item2 instanceof in) && (findViewByPosition2 = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                        findViewByPosition2.setTranslationY(f);
                    }
                } else if (baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                    findViewByPosition.setTranslationY(f);
                }
            }
        }
    }
}
