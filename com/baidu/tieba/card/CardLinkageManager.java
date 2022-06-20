package com.baidu.tieba.card;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
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
import com.repackage.fr4;
import com.repackage.nn;
import com.repackage.sb5;
import com.repackage.tn;
import java.util.ArrayList;
import java.util.List;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes3.dex */
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (CardLinkageManager) Enum.valueOf(CardLinkageManager.class, str) : (CardLinkageManager) invokeL.objValue;
    }

    public static CardLinkageManager[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (CardLinkageManager[]) $VALUES.clone() : (CardLinkageManager[]) invokeV.objValue;
    }

    public void addThreadId(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048576, this, j) == null) {
            if (this.mThreadIdList == null) {
                this.mThreadIdList = new ArrayList();
            }
            this.mThreadIdList.add(Long.valueOf(j));
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

    public void pressLinkage(tn tnVar, int i, boolean z) {
        View findViewByPosition;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{tnVar, Integer.valueOf(i), Boolean.valueOf(z)}) == null) && (tnVar instanceof BdTypeRecyclerView)) {
            BdTypeRecyclerView bdTypeRecyclerView = (BdTypeRecyclerView) tnVar;
            int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition();
            int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
            RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
            if (layoutManager == null) {
                return;
            }
            List<nn> data = bdTypeRecyclerView.getData();
            Object item = ListUtils.getItem(data, i);
            if (item instanceof BaseCardInfo) {
                BaseCardInfo baseCardInfo = (BaseCardInfo) item;
                int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
                for (int i2 = firstVisiblePosition > headerViewsCount ? firstVisiblePosition - headerViewsCount : headerViewsCount; i2 <= lastVisiblePosition; i2++) {
                    Object item2 = ListUtils.getItem(data, i2 - headerViewsCount);
                    if (item2 instanceof BaseCardInfo) {
                        BaseCardInfo baseCardInfo2 = (BaseCardInfo) item2;
                        if (baseCardInfo.position == baseCardInfo2.position && (findViewByPosition = layoutManager.findViewByPosition(i2)) != null) {
                            boolean isSupportFull = baseCardInfo2.isSupportFull();
                            int i3 = R.color.CAM_X0206;
                            if (isSupportFull) {
                                fr4 d = fr4.d(findViewByPosition);
                                d.m(0);
                                d.n(R.string.J_X06);
                                if (!z) {
                                    i3 = R.color.CAM_X0205;
                                }
                                d.f(i3);
                            } else if (baseCardInfo2.isSupportTop()) {
                                fr4 d2 = fr4.d(findViewByPosition);
                                d2.m(1);
                                d2.n(R.string.J_X06);
                                if (!z) {
                                    i3 = R.color.CAM_X0205;
                                }
                                d2.f(i3);
                            } else if (baseCardInfo2.isSupportBottom()) {
                                fr4 d3 = fr4.d(findViewByPosition);
                                d3.m(2);
                                d3.n(R.string.J_X06);
                                if (!z) {
                                    i3 = R.color.CAM_X0205;
                                }
                                d3.f(i3);
                            } else if (baseCardInfo2.isSupportContent() || baseCardInfo2.isSupportExtend()) {
                                if (!z) {
                                    i3 = R.color.CAM_X0205;
                                }
                                SkinManager.setBackgroundColor(findViewByPosition, i3);
                            }
                        }
                    }
                }
            }
        }
    }

    public void translationY(BdTypeRecyclerView bdTypeRecyclerView, int i, float f) {
        View findViewByPosition;
        View findViewByPosition2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048579, this, new Object[]{bdTypeRecyclerView, Integer.valueOf(i), Float.valueOf(f)}) == null) || bdTypeRecyclerView == null) {
            return;
        }
        int lastVisiblePosition = bdTypeRecyclerView.getLastVisiblePosition();
        RecyclerView.LayoutManager layoutManager = bdTypeRecyclerView.getLayoutManager();
        if (layoutManager == null) {
            return;
        }
        int headerViewsCount = bdTypeRecyclerView.getHeaderViewsCount();
        List<nn> data = bdTypeRecyclerView.getData();
        Object item = ListUtils.getItem(data, i - headerViewsCount);
        if (item instanceof BaseCardInfo) {
            BaseCardInfo baseCardInfo = (BaseCardInfo) item;
            for (int firstVisiblePosition = bdTypeRecyclerView.getFirstVisiblePosition(); firstVisiblePosition <= lastVisiblePosition; firstVisiblePosition++) {
                Object item2 = ListUtils.getItem(data, firstVisiblePosition - headerViewsCount);
                if (!sb5.p(item2)) {
                    if (!(item2 instanceof BaseCardInfo)) {
                        if ((item2 instanceof nn) && (findViewByPosition2 = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                            findViewByPosition2.setTranslationY(f);
                        }
                    } else if (baseCardInfo.position == ((BaseCardInfo) item2).position && (findViewByPosition = layoutManager.findViewByPosition(firstVisiblePosition)) != null) {
                        findViewByPosition.setTranslationY(f);
                    }
                }
            }
        }
    }
}
