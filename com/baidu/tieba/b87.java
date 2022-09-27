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
/* loaded from: classes3.dex */
public class b87 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<MsglistActivity<?>> a;
    public List<ChatMessage> b;
    public BdTypeListView c;
    public MsgLeftViewItemAdapter d;
    public MsgRightViewItemAdapter e;
    public MsgMidViewItemAdapter f;
    public MsgIceBreakItemAdapter g;
    public List<MsgCommonItemAdapter> h;
    public CustomMessageListener i;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b87 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(b87 b87Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b87Var, Integer.valueOf(i)};
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
            this.a = b87Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.b == null || aVar.a == null) {
                return;
            }
            this.a.h.addAll(aVar.b);
            this.a.c.a(new ArrayList(this.a.h));
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public b87(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView) {
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

    public List<ChatMessage> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.b : (List) invokeV.objValue;
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
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
            this.h.add(this.d);
            this.h.add(this.e);
            this.h.add(this.f);
            this.h.add(this.g);
            this.h.add(new MsgStrangerTipItemAdapter(this.a));
            e();
            MsgAdapterScanMessage.a aVar = new MsgAdapterScanMessage.a();
            aVar.b = new ArrayList();
            aVar.a = this.a;
            MessageManager.getInstance().dispatchResponsedMessage(new MsgAdapterScanMessage(aVar));
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.i.setPriority(Integer.MAX_VALUE);
            this.a.registerListener(this.i);
        }
    }

    public void f() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (this.c.getAdapter2() instanceof un)) {
            this.c.getAdapter2().notifyDataSetChanged();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (this.c.getAdapter2() instanceof un)) {
            this.c.getAdapter2().notifyDataSetInvalidated();
        }
    }

    public void h(ChatMessage chatMessage) {
        a87 itemView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, chatMessage) == null) || chatMessage == null || (itemView = chatMessage.getItemView()) == null || itemView.h == null || chatMessage.getMsgId() != itemView.h.longValue()) {
            return;
        }
        itemView.F(null, chatMessage);
    }

    public void i(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.d.E(i);
            this.e.F(i);
        }
    }

    public void j() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048583, this) == null) || this.i == null) {
            return;
        }
        MessageManager.getInstance().unRegisterListener(this.i);
        this.i = null;
    }

    public void k(List<ChatMessage> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
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
                }
                arrayList.addAll(this.b);
            }
            this.c.setData(arrayList);
        }
    }

    public void l(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
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

    public void m(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
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

    public void n(boolean z) {
        MsgRightViewItemAdapter msgRightViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048587, this, z) == null) || (msgRightViewItemAdapter = this.e) == null) {
            return;
        }
        msgRightViewItemAdapter.I(z);
    }

    public void o(boolean z) {
        MsgLeftViewItemAdapter msgLeftViewItemAdapter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048588, this, z) == null) || (msgLeftViewItemAdapter = this.d) == null) {
            return;
        }
        msgLeftViewItemAdapter.H(z);
    }

    public void p(xf xfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, xfVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.h) {
                if (msgCommonItemAdapter.t()) {
                    msgCommonItemAdapter.z(xfVar);
                }
            }
        }
    }

    public void q(yf yfVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, yfVar) == null) {
            for (MsgCommonItemAdapter msgCommonItemAdapter : this.h) {
                if (msgCommonItemAdapter.u()) {
                    msgCommonItemAdapter.A(yfVar);
                }
            }
        }
    }

    public void r(ArrayList<ReportPrivateMsgData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, arrayList) == null) {
            this.e.B(arrayList);
            this.d.B(arrayList);
        }
    }

    public void s(AbsMsglistView.j jVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, jVar) == null) {
            this.d.D(jVar);
            this.e.D(jVar);
        }
    }

    public b87(TbPageContext<MsglistActivity<?>> tbPageContext, BdTypeListView bdTypeListView, int i) {
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
        this.h = new ArrayList();
        this.i = new a(this, 2001275);
        this.a = tbPageContext;
        this.c = bdTypeListView;
        d();
        this.d.C(i);
        this.e.C(i);
    }
}
