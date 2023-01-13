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
public class ie7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<ln> a;

    public ie7(TbPageContext tbPageContext, BdTypeRecyclerView bdTypeRecyclerView) {
        pn6 pn6Var;
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
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2921336, pn6.class, tbPageContext);
        if (runTask != null && (pn6Var = (pn6) runTask.getData()) != null) {
            this.a.add(pn6Var);
        }
        this.a.add(new je7(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC));
        this.a.add(new he7(tbPageContext, ThreadData.TYPE_FRS_HOTTOPIC_VIDEO));
        bdTypeRecyclerView.a(this.a);
    }

    public void a(TbPageTag tbPageTag) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbPageTag) != null) || ListUtils.isEmpty(this.a)) {
            return;
        }
        for (ln lnVar : this.a) {
            if (lnVar instanceof pn6) {
                ((pn6) lnVar).C(tbPageTag);
            }
        }
    }
}
