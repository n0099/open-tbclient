package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.im.chat.AbsMsglistView;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.MsgIceBreakItemAdapter;
import com.baidu.tieba.im.chat.MsgLeftViewItemAdapter;
import com.baidu.tieba.im.chat.MsgMidViewItemAdapter;
import com.baidu.tieba.im.chat.MsgRightViewItemAdapter;
import com.baidu.tieba.im.chat.MsgStrangerTipItemAdapter;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.data.MsgCacheData;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.message.chat.ReportPrivateMsgData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class fa7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;
    public List<ChatMessage> b;
    public BdTypeListView c;
    public MsgLeftViewItemAdapter d;
    public MsgRightViewItemAdapter e;
    public MsgMidViewItemAdapter f;
    public MsgIceBreakItemAdapter g;
    public boolean h;
    public List<MsgCommonItemAdapter> i;
    public CustomMessageListener j;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fa7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(fa7 fa7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fa7Var, Integer.valueOf(i)};
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
            this.a = fa7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getData() != null) {
                MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
                if (aVar.b != null && aVar.a != null) {
                    this.a.i.addAll(aVar.b);
                    this.a.c.a(new ArrayList(this.a.i));
                }
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public fa7(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
        this(tbPageContext, bdTypeListView, 0);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                this((TbPageContext) objArr2[0], (BdTypeListView) objArr2[1], ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public fa7(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, Integer.valueOf(i)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.b = null;
        this.i = new ArrayList();
        this.j = new a(this, 2001275);
        this.a = tbPageContext;
        this.c = bdTypeListView;
        e();
        this.d.C(i);
        this.e.C(i);
    }

    public void i(ChatMessage chatMessage) {
        ea7 itemView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048582, this, chatMessage) == null) && chatMessage != null && (itemView = chatMessage.getItemView()) != null && itemView.h != null && chatMessage.getMsgId() == itemView.h.longValue()) {
            itemView.G(null, chatMessage);
        }
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048583, this, i) == null) {
            this.d.E(i);
            this.e.F(i);
        }
    }

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.d;
            if (msgLeftViewItemAdapter != null) {
                msgLeftViewItemAdapter.w(z);
            }
            MsgRightViewItemAdapter msgRightViewItemAdapter = this.e;
            if (msgRightViewItemAdapter != null) {
                msgRightViewItemAdapter.w(z);
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = this.d;
            if (msgLeftViewItemAdapter != null) {
                msgLeftViewItemAdapter.G(z);
            }
            MsgRightViewItemAdapter msgRightViewItemAdapter = this.e;
            if (msgRightViewItemAdapter != null) {
                msgRightViewItemAdapter.H(z);
            }
        }
    }

    public void o(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048588, this, z) == null) && (msgRightViewItemAdapter = this.e) != null) {
            msgRightViewItemAdapter.I(z);
        }
    }

    public void p(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && (msgLeftViewItemAdapter = this.d) != null) {
            msgLeftViewItemAdapter.H(z);
        }
    }

    public void q(rf rfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, rfVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.i) {
                if (msgCommonItemAdapter.t()) {
                    msgCommonItemAdapter.z(rfVar);
                }
            }
        }
    }

    public void r(sf sfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, sfVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.i) {
                if (msgCommonItemAdapter.u()) {
                    msgCommonItemAdapter.A(sfVar);
                }
            }
        }
    }

    public void s(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, arrayList) == null) {
            this.e.B(arrayList);
            this.d.B(arrayList);
        }
    }

    public void t(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, jVar) == null) {
            this.d.D(jVar);
            this.e.D(jVar);
        }
    }

    public List<ChatMessage> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.b;
        }
        return (List) invokeV.objValue;
    }

    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.h;
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.j.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.j);
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.c.getAdapter2() instanceof on)) {
            this.c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void h() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && (this.c.getAdapter2() instanceof on)) {
            this.c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void k() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.j != null) {
            MessageManager.getInstance().unRegisterListener(this.j);
            this.j = null;
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            MsgLeftViewItemAdapter msgLeftViewItemAdapter = new MsgLeftViewItemAdapter(this.a, ChatMessage.TYPE_MSG_LEFT);
            this.d = msgLeftViewItemAdapter;
            msgLeftViewItemAdapter.x(true);
            this.d.y(true);
            MsgRightViewItemAdapter msgRightViewItemAdapter = new MsgRightViewItemAdapter(this.a, ChatMessage.TYPE_MSG_RIGHT);
            this.e = msgRightViewItemAdapter;
            msgRightViewItemAdapter.x(true);
            this.e.y(true);
            this.f = new MsgMidViewItemAdapter(this.a, ChatMessage.TYPE_MSG_MID);
            MsgIceBreakItemAdapter msgIceBreakItemAdapter = new MsgIceBreakItemAdapter(this.a);
            this.g = msgIceBreakItemAdapter;
            msgIceBreakItemAdapter.x(true);
            this.i.add(this.d);
            this.i.add(this.e);
            this.i.add(this.f);
            this.i.add(this.g);
            this.i.add(new MsgStrangerTipItemAdapter(this.a));
            f();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public void l(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
            this.h = false;
            this.b = list;
            ArrayList arrayList = new ArrayList();
            if (this.b != null) {
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    if (i > 0) {
                        if (list.get(i).getCacheData() == null) {
                            list.get(i).setCacheData(new MsgCacheData());
                        }
                        list.get(i).getCacheData().setLastMsgTime(list.get(i - 1).getTime());
                    }
                    if (list.get(i).getMsgType() == 2) {
                        this.h = true;
                    }
                }
                arrayList.addAll(this.b);
            }
            this.c.setData(arrayList);
        }
    }
}
