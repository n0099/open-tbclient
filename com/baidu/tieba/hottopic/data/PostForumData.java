package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e06;
import com.repackage.on;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes3.dex */
public class PostForumData extends e06 implements Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId TYPE_POST_FORUM;
    public static final long serialVersionUID = -2078662294751243784L;
    public transient /* synthetic */ FieldHolder $fh;
    public List<on> mRelateForumDataList;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-407777450, "Lcom/baidu/tieba/hottopic/data/PostForumData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-407777450, "Lcom/baidu/tieba/hottopic/data/PostForumData;");
                return;
            }
        }
        TYPE_POST_FORUM = BdUniqueId.gen();
    }

    public PostForumData() {
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
        this.mRelateForumDataList = null;
    }

    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? ListUtils.getCount(this.mRelateForumDataList) : invokeV.intValue;
    }

    public on getForumData(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) ? (on) ListUtils.getItem(this.mRelateForumDataList, i) : (on) invokeI.objValue;
    }

    @Override // com.baidu.tieba.card.data.BaseCardInfo, com.repackage.on
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? TYPE_POST_FORUM : (BdUniqueId) invokeV.objValue;
    }

    public void parserProtobuf(List<RelateForum> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, list) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        this.showTopDivider = true;
        this.mGroupTitle = TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fae);
        this.mRelateForumDataList = new ArrayList();
        for (RelateForum relateForum : list) {
            if (relateForum != null && !StringUtils.isNull(relateForum.forum_name)) {
                RelateForumItemData relateForumItemData = new RelateForumItemData();
                relateForumItemData.parserProtobuf(relateForum);
                this.mRelateForumDataList.add(relateForumItemData);
            }
        }
    }
}
