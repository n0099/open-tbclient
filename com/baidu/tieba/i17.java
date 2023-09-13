package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.enterForum.message.ForumGuideHttpResponseMessage;
import com.baidu.tieba.enterForum.model.EnterForumModel;
import com.baidu.tieba.tt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes6.dex */
public class i17 implements tt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public EnterForumModel a;
    public tt6.a b;
    public final EnterForumModel.f c;
    public NetMessageListener d;

    /* loaded from: classes6.dex */
    public class a implements EnterForumModel.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i17 a;

        public a(i17 i17Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i17Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i17Var;
        }

        @Override // com.baidu.tieba.enterForum.model.EnterForumModel.f
        public void a(EnterForumModel.e eVar) {
            u07 u07Var;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, eVar) != null) || this.a.b == null) {
                return;
            }
            if (eVar != null && eVar.b && (u07Var = eVar.d) != null && u07Var.e() != null) {
                ArrayList<TransmitForumData> arrayList = new ArrayList<>();
                ArrayList<w07> b = eVar.d.e().b();
                if (ListUtils.getCount(b) > 0) {
                    Iterator<w07> it = b.iterator();
                    while (it.hasNext()) {
                        w07 next = it.next();
                        if (next != null && !StringUtils.isNull(next.getId()) && !StringUtils.isNull(next.i())) {
                            TransmitForumData transmitForumData = new TransmitForumData(Long.valueOf(next.getId()).longValue(), next.i(), false, 1, next.e());
                            transmitForumData.tabItemDatas = next.m();
                            arrayList.add(transmitForumData);
                        }
                    }
                }
                this.a.b.callback(arrayList, true, 1, 0);
                return;
            }
            this.a.b.callback(null, false, 1, 0);
        }
    }

    /* loaded from: classes6.dex */
    public class b extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i17 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i17 i17Var, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i17Var, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i17Var;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || !(responsedMessage instanceof ForumGuideHttpResponseMessage) || this.a.a.getUniqueId() != responsedMessage.getOrginalMessage().getTag() || responsedMessage.hasError()) {
                return;
            }
            this.a.a.c0((ForumGuideHttpResponseMessage) responsedMessage);
        }
    }

    public i17() {
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
        this.a = null;
        this.c = new a(this);
        this.d = new b(this, CmdConfigHttp.CMD_ENTER_FORUM_DATA, 309683);
        EnterForumModel enterForumModel = new EnterForumModel(null);
        this.a = enterForumModel;
        enterForumModel.i0(this.c);
        MessageManager.getInstance().registerListener(this.d);
    }

    @Override // com.baidu.tieba.tt6
    public void a(tt6.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.b = aVar;
        }
    }

    @Override // com.baidu.tieba.tt6
    public void b() {
        EnterForumModel enterForumModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.b != null && (enterForumModel = this.a) != null) {
            enterForumModel.X(true);
        }
    }
}
