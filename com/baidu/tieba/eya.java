package com.baidu.tieba;

import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.write.data.QuestionTagListData;
import com.baidu.tieba.write.write.message.QuestionTagListRequestMessage;
import com.baidu.tieba.write.write.message.QuestionTagListResponseMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class eya {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final List<ym> a;
    public b b;
    public String c;
    public String d;
    public boolean e;
    public int f;
    public final HttpMessageListener g;

    /* loaded from: classes5.dex */
    public interface b {
        void a(boolean z, List<ym> list);

        void b(boolean z);

        void c(boolean z, String str);
    }

    /* loaded from: classes5.dex */
    public class a extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eya a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(eya eyaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eyaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eyaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, httpResponsedMessage) != null) || !(httpResponsedMessage instanceof QuestionTagListResponseMessage)) {
                return;
            }
            QuestionTagListData questionTagListData = ((QuestionTagListResponseMessage) httpResponsedMessage).data;
            boolean z = false;
            if (httpResponsedMessage.getError() == 0 && questionTagListData != null) {
                if (!ListUtils.isEmpty(questionTagListData.b)) {
                    this.a.a.addAll(questionTagListData.b);
                }
                eya eyaVar = this.a;
                if (questionTagListData.a == 1) {
                    z = true;
                }
                eyaVar.e = z;
                if (this.a.e) {
                    eya.c(this.a);
                }
                if (this.a.b != null) {
                    this.a.b.a(this.a.e, this.a.a);
                }
            } else if (this.a.b != null) {
                b bVar = this.a.b;
                if (this.a.f != 1) {
                    z = true;
                }
                bVar.c(z, TbadkApplication.getInst().getString(R.string.new_text_no_search_result));
            }
        }
    }

    public eya() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
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
        this.f = 1;
        this.g = new a(this, CmdConfigHttp.CMD_QUESTION_THREAD_TAG_LIST);
        g();
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_QUESTION_THREAD_TAG_LIST, TbConfig.SERVER_ADDRESS + TbConfig.QUESTION_THREAD_TAG_LIST);
            tbHttpMessageTask.setResponsedClass(QuestionTagListResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
        }
    }

    public static /* synthetic */ int c(eya eyaVar) {
        int i = eyaVar.f;
        eyaVar.f = i + 1;
        return i;
    }

    public boolean h(boolean z) {
        InterceptResult invokeZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeZ = interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z)) == null) {
            if (!z && !this.e) {
                return false;
            }
            k();
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(false);
                return true;
            }
            return true;
        }
        return invokeZ.booleanValue;
    }

    public void i(@Nullable String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.c = str;
            this.f = 1;
            this.e = false;
            this.a.clear();
            k();
            b bVar = this.b;
            if (bVar != null) {
                bVar.b(true);
            }
        }
    }

    public void l(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public void m(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.d = str;
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            MessageManager.getInstance().registerListener(this.g);
        }
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager.getInstance().sendMessage(new QuestionTagListRequestMessage().setSearchWords(this.c).setCategory(this.d).setPage(this.f));
        }
    }

    public void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            MessageManager.getInstance().unRegisterListener(this.g);
        }
    }
}
