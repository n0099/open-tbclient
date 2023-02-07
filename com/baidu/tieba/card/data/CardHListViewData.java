package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tieba.Cdo;
import com.baidu.tieba.dj;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.GuessLikeThreadInfo;
import tbclient.PbPage.GuessLikeStruct;
/* loaded from: classes4.dex */
public class CardHListViewData extends BaseCardInfo implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int MAX_COUNT = 9;
    public static final int MIN_COUNT = 3;
    public static final BdUniqueId TYPE;
    public static final long serialVersionUID = 6577771607010727691L;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<Cdo> mList;
    public boolean showBottomDivider;
    public boolean showTopDivider;
    public String threadId;
    public String title;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(605065290, "Lcom/baidu/tieba/card/data/CardHListViewData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(605065290, "Lcom/baidu/tieba/card/data/CardHListViewData;");
                return;
            }
        }
        TYPE = BdUniqueId.gen();
    }

    public CardHListViewData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.showTopDivider = true;
        this.showBottomDivider = true;
        this.mList = new ArrayList();
    }

    public final List<Cdo> getDataList() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.mList;
        }
        return (List) invokeV.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.baidu.tieba.Cdo
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void parseProtobuf(GuessLikeStruct guessLikeStruct) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, guessLikeStruct) == null) && guessLikeStruct != null && ListUtils.getCount(guessLikeStruct.thread_list) >= 3) {
            this.title = StringHelper.trim(guessLikeStruct.title);
            List<GuessLikeThreadInfo> list = guessLikeStruct.thread_list;
            if (ListUtils.getCount(list) > 9) {
                list = ListUtils.subList(list, 0, 9);
            }
            if (ListUtils.isEmpty(list)) {
                return;
            }
            this.mList.clear();
            for (GuessLikeThreadInfo guessLikeThreadInfo : list) {
                if (guessLikeThreadInfo != null && guessLikeThreadInfo.thread_id.longValue() >= 0 && !dj.isEmptyStringAfterTrim(guessLikeThreadInfo.recom_cover) && !dj.isEmptyStringAfterTrim(guessLikeThreadInfo.title)) {
                    CardHListViewNormalItemData cardHListViewNormalItemData = new CardHListViewNormalItemData();
                    cardHListViewNormalItemData.parseProtobuf(guessLikeThreadInfo);
                    this.mList.add(cardHListViewNormalItemData);
                }
            }
        }
    }
}
