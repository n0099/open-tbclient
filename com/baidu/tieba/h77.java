package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.pageInfo.TbPageTag;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class h77 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<qn> a;

    public h77(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        dh6 dh6Var;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new ArrayList();
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921336, dh6.class, tbPageContext);
        if (runTask != null && (dh6Var = (dh6) runTask.getData()) != null) {
            this.a.add(dh6Var);
        }
        this.a.add(new i77(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC));
        this.a.add(new g77(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC_VIDEO));
        bdTypeRecyclerView.a(this.a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, tbPageTag) == null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        for (qn qnVar : this.a) {
            if (qnVar instanceof dh6) {
                ((dh6) qnVar).C(tbPageTag);
            }
        }
    }
}
