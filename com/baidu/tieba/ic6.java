package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ala.livecard.holder.FrsPageAlaVideoHolder;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class ic6 extends hs7<mz4, FrsPageAlaVideoHolder> implements km6, e26 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public sc6 l;
    public String m;
    public String n;
    public mm6<ThreadData> o;

    @Override // com.baidu.tieba.km6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends mm6<ThreadData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ic6 b;

        public a(ic6 ic6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ic6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ic6Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.mm6
        /* renamed from: d */
        public void a(View view2, ThreadData threadData) {
            CustomMessage customMessage;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, threadData) == null) {
                if (view2.getId() == R.id.layout_root) {
                    customMessage = new CustomMessage(2921018);
                } else if (view2.getId() != R.id.card_home_page_normal_thread_user_name && view2.getId() != R.id.card_home_page_normal_thread_user_header && view2.getId() != R.id.user_avatar) {
                    if (view2.getId() == R.id.video_container) {
                        customMessage = new CustomMessage(2921019);
                    } else {
                        customMessage = null;
                    }
                } else {
                    customMessage = new CustomMessage(2921016);
                }
                if (customMessage != null && this.b.c != null) {
                    customMessage.setData(threadData);
                    this.b.c.sendMessage(customMessage);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ic6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, BdUniqueId bdUniqueId2) {
        super(tbPageContext, bdUniqueId, bdUniqueId2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, bdUniqueId2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1], (BdUniqueId) objArr2[2]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.o = new a(this);
    }

    @Override // com.baidu.tieba.km6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.m = str;
        }
    }

    @Override // com.baidu.tieba.e26
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.n = str;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.ci
    /* renamed from: J */
    public FrsPageAlaVideoHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            TbPageContext<?> tbPageContext = this.c;
            if (tbPageContext == null) {
                return null;
            }
            sc6 sc6Var = new sc6(tbPageContext, this.mPageId);
            this.l = sc6Var;
            sc6Var.X(this.mPageId);
            this.l.a(this.m);
            this.l.l(this.o);
            return new FrsPageAlaVideoHolder(this.l);
        }
        return (FrsPageAlaVideoHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.hs7, com.baidu.tieba.ci
    /* renamed from: K */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, mz4 mz4Var, FrsPageAlaVideoHolder frsPageAlaVideoHolder) {
        InterceptResult invokeCommon;
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, mz4Var, frsPageAlaVideoHolder})) == null) {
            TiebaStatic.log("c11842");
            CustomMessage customMessage = new CustomMessage(2921017);
            FrsViewData frsViewData = this.b;
            if (frsViewData != null) {
                i2 = frsViewData.getTopThreadSize();
            } else {
                i2 = 0;
            }
            ThreadData threadData = mz4Var.t;
            threadData.statFloor = (i + 1) - i2;
            customMessage.setData(threadData);
            this.c.sendMessage(customMessage);
            if (mz4Var != null) {
                sc6 sc6Var = frsPageAlaVideoHolder.b;
                if (sc6Var instanceof d26) {
                    sc6Var.b(this.n);
                }
                frsPageAlaVideoHolder.b.a(this.m);
                frsPageAlaVideoHolder.b.Y(x());
                frsPageAlaVideoHolder.b.j(mz4Var.t);
                mz4Var.t.updateShowStatus();
            }
            this.e = (vi) viewGroup;
            return frsPageAlaVideoHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.hs7
    public void n(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, tbPageContext, bdUniqueId) == null) {
            super.n(tbPageContext, bdUniqueId);
        }
    }
}
