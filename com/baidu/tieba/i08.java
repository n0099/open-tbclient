package com.baidu.tieba;

import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.widget.ListView.BdTypeRecyclerView;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.AbsDelegateAdapterList;
import com.baidu.tieba.frs.good.FrsGoodFragment;
import com.baidu.tieba.lego.card.model.ICardInfo;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes6.dex */
public class i08 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public FrsGoodFragment a;
    public BdTypeRecyclerView b;
    public List<ci> c;
    public List<ci> d;
    public final HashMap<Integer, ThreadData> e;
    public ArrayList<pi> f;
    public ArrayList<pi> g;
    public FrsViewData h;
    public CustomMessageListener i;
    public CustomMessageListener j;

    public void r(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(i08 i08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var, Integer.valueOf(i)};
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
            this.a = i08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && customResponsedMessage.getCmd() == 2003008 && (customResponsedMessage.getData() instanceof AbsDelegateAdapterList)) {
                AbsDelegateAdapterList absDelegateAdapterList = (AbsDelegateAdapterList) customResponsedMessage.getData();
                Iterator<ci<?, ?>> it = absDelegateAdapterList.iterator();
                while (it.hasNext()) {
                    ci<?, ?> next = it.next();
                    if (next instanceof gs7) {
                        ((gs7) next).n(this.a.a.getPageContext(), this.a.a.getUniqueId());
                    }
                }
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(absDelegateAdapterList);
                if (this.a.d != null) {
                    this.a.d.addAll(arrayList);
                }
                if (this.a.b != null) {
                    this.a.b.addAdapters(arrayList);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i08 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i08 i08Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i08Var, Integer.valueOf(i)};
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
            this.a = i08Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && ListUtils.isEmpty(this.a.c)) {
                i08 i08Var = this.a;
                i08Var.i(i08Var.b);
                i08 i08Var2 = this.a;
                i08Var2.w(i08Var2.f, this.a.h);
            }
        }
    }

    public i08(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {frsGoodFragment, bdTypeRecyclerView};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new LinkedList();
        this.i = new a(this, 2003008);
        this.j = new b(this, 2016470);
        n(frsGoodFragment, bdTypeRecyclerView);
        this.b = bdTypeRecyclerView;
        this.e = new HashMap<>();
    }

    public void w(ArrayList<pi> arrayList, FrsViewData frsViewData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048595, this, arrayList, frsViewData) == null) {
            if (frsViewData != null && arrayList != null && arrayList.size() == 1 && (arrayList.get(0) instanceof os7)) {
                frsViewData.setThreadList(arrayList);
            }
            z(frsViewData);
            y();
            u(arrayList);
            nva.f(arrayList, 1);
            k(arrayList);
            ArrayList<pi> switchThreadDataToThreadCardInfo = frsViewData.switchThreadDataToThreadCardInfo();
            this.b.setData(switchThreadDataToThreadCardInfo);
            this.g = switchThreadDataToThreadCardInfo;
            this.f = arrayList;
            this.h = frsViewData;
            C();
        }
    }

    public final void h(BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048580, this, bdTypeRecyclerView) == null) && this.a != null && bdTypeRecyclerView != null && !i(bdTypeRecyclerView)) {
            this.a.registerListener(this.j);
        }
    }

    public final void v(String str) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048594, this, str) != null) || (list = this.d) == null) {
            return;
        }
        for (ci ciVar : list) {
            if (ciVar instanceof e26) {
                ((e26) ciVar).g(str);
            }
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof km6) {
                    ((km6) ciVar).q(3);
                }
            }
        }
    }

    public HashMap<Integer, ThreadData> j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (HashMap) invokeV.objValue;
    }

    public List<pi> l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.f;
        }
        return (List) invokeV.objValue;
    }

    public List<pi> m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.g;
        }
        return (List) invokeV.objValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void q() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            this.b.getAdapter().notifyDataSetChanged();
        }
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048592, this) == null) {
            this.b.setData(this.g);
            p();
        }
    }

    public void B(zi ziVar) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, ziVar) == null) && (list = this.d) != null && list.size() != 0) {
            for (ci ciVar : this.d) {
                if (ciVar != null && (ciVar instanceof gs7)) {
                    ((gs7) ciVar).setOnAdapterItemClickListener(ziVar);
                }
            }
        }
    }

    public final void k(ArrayList<pi> arrayList) {
        HashMap<Integer, ThreadData> hashMap;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, arrayList) == null) && arrayList != null && arrayList.size() != 0) {
            for (int i = 0; i < arrayList.size(); i++) {
                pi piVar = arrayList.get(i);
                if ((piVar instanceof AdvertAppInfo) && (hashMap = this.e) != null && !hashMap.containsValue(piVar)) {
                    this.e.put(Integer.valueOf(i), (ThreadData) piVar);
                }
            }
        }
    }

    public boolean o(BdUniqueId bdUniqueId) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, bdUniqueId)) == null) {
            if (bdUniqueId == null) {
                return false;
            }
            for (ci ciVar : this.d) {
                if (ciVar != null && ciVar.getType() == bdUniqueId) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void u(ArrayList<pi> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, arrayList) == null) && arrayList != null && arrayList.size() > 0) {
            Iterator<pi> it = arrayList.iterator();
            while (it.hasNext()) {
                if (it.next().getType() == ThreadData.TYPE_TOP) {
                    it.remove();
                }
            }
        }
    }

    public void x(boolean z) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048596, this, z) == null) && (list = this.d) != null && list.size() != 0) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    ((gs7) ciVar).setFromCDN(z);
                }
            }
        }
    }

    public void z(FrsViewData frsViewData) {
        List<ci> list;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048598, this, frsViewData) == null) && (list = this.d) != null && list.size() != 0) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    ((gs7) ciVar).B(frsViewData);
                }
            }
        }
    }

    public final void C() {
        u38 i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.h == null) {
            return;
        }
        for (ci ciVar : this.d) {
            if ((ciVar instanceof w38) && (i = ((w38) ciVar).i()) != null) {
                if (this.h.needLog == 1) {
                    i.a = true;
                } else {
                    i.a = false;
                }
                if (this.h.getForum() != null) {
                    i.c = this.h.getForum().getId();
                    i.d = this.h.getForum().getName();
                }
                if (this.a != null) {
                    i.b = 5;
                }
            }
        }
    }

    public void D() {
        BdTypeRecyclerView bdTypeRecyclerView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048579, this) == null) && (bdTypeRecyclerView = this.b) != null && bdTypeRecyclerView.getData() != null && this.b.getData().size() != 0) {
            for (pi piVar : this.b.getData()) {
                if (piVar instanceof mz4) {
                    mz4 mz4Var = (mz4) piVar;
                    if (mz4Var.t.getIs_top() != 0) {
                        mz4Var.t.parser_title();
                    }
                }
            }
        }
    }

    public final boolean i(BdTypeRecyclerView bdTypeRecyclerView) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bdTypeRecyclerView)) == null) {
            if (this.a != null && bdTypeRecyclerView != null) {
                this.c = new ArrayList();
                ArrayList<BdUniqueId> g = nva.g();
                if (g != null && g.size() > 0) {
                    int size = g.size();
                    for (int i = 0; i < size; i++) {
                        gs7<ICardInfo, ? extends TypeAdapter.ViewHolder> b2 = as7.e().b(this.a.getPageContext(), g.get(i), this.a.getUniqueId());
                        if (b2 != null) {
                            this.d.add(b2);
                            this.c.add(b2);
                        }
                    }
                    if (!ListUtils.isEmpty(this.c)) {
                        bdTypeRecyclerView.addAdapters(this.c);
                        return true;
                    }
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void n(FrsGoodFragment frsGoodFragment, BdTypeRecyclerView bdTypeRecyclerView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, frsGoodFragment, bdTypeRecyclerView) == null) {
            this.a = frsGoodFragment;
            this.i.setPriority(1);
            this.i.setSelfListener(true);
            this.a.registerListener(this.i);
            ax7 ax7Var = new ax7(frsGoodFragment.I(), ThreadData.TYPE_USER_NORMAL, this.a.getUniqueId());
            mw7 mw7Var = new mw7(frsGoodFragment.I(), ThreadData.TYPE_CONTENT_TEXT_NORMAL, this.a.getUniqueId());
            xw7 xw7Var = new xw7(frsGoodFragment.I(), ThreadData.TYPE_CONTENT_SINGLE_V_NORMAL, this.a.getUniqueId());
            uw7 uw7Var = new uw7(frsGoodFragment.I(), ThreadData.TYPE_CONTENT_MULTI_PIC_NORMMAL, this.a.getUniqueId());
            lw7 lw7Var = new lw7(frsGoodFragment.I(), ThreadData.TYPE_BOTTOM_NORMAL, this.a.getUniqueId());
            ow7 ow7Var = new ow7(frsGoodFragment.I(), ThreadData.TYPE_GODREPLY_NORMAL, this.a.getUniqueId());
            cx7 cx7Var = new cx7(frsGoodFragment.I(), ThreadData.TYPE_VOTE, this.a.getUniqueId());
            yw7 yw7Var = new yw7(frsGoodFragment.I(), ThreadData.TYPE_SMART_APP, this.a.getUniqueId());
            ww7 ww7Var = new ww7(frsGoodFragment.I(), ThreadData.TYPE_SINGLE_LINK, this.a.getUniqueId());
            tw7 tw7Var = new tw7(frsGoodFragment.I(), ThreadData.TYPE_MULTI_LINK, this.a.getUniqueId());
            bx7 bx7Var = new bx7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO, this.a.getUniqueId());
            rw7 rw7Var = new rw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_LINK, this.a.getUniqueId());
            vw7 vw7Var = new vw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_GOD_NORMAL, this.a.getUniqueId());
            bx7 bx7Var2 = new bx7(frsGoodFragment.getPageContext(), ThreadData.TYPE_VIDEO_GOD, this.a.getUniqueId());
            ns7 ns7Var = new ns7(frsGoodFragment.getPageContext(), os7.b);
            ci<? extends mz4, ? extends TypeAdapter.ViewHolder> a2 = as7.e().a(frsGoodFragment.getPageContext(), this.a.getUniqueId(), true);
            ci<? extends ThreadData, ? extends TypeAdapter.ViewHolder> d = as7.e().d(frsGoodFragment.getPageContext(), ThreadData.TYPE_LOTTERY, this.a.getUniqueId());
            ci<?, ?> e = vha.m().e(this.a, AdvertAppInfo.y);
            ci<?, ?> e2 = vha.m().e(this.a, AdvertAppInfo.B);
            zw7 zw7Var = new zw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_SHARE_THREAD, this.a.getUniqueId());
            zv7 zv7Var = new zv7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ARTICLE_SHARE_THREAD, this.a.getUniqueId());
            gw7 gw7Var = new gw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_NORMAL_SHARE_THREAD, this.a.getUniqueId());
            hw7 hw7Var = new hw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_NEW_VIDEO_SHARE_THREAD, this.a.getUniqueId());
            ew7 ew7Var = new ew7(frsGoodFragment.getPageContext(), ThreadData.TYPE_ITEM, this.a.getUniqueId());
            ew7Var.y(bdTypeRecyclerView);
            kw7 kw7Var = new kw7(frsGoodFragment.getPageContext(), ThreadData.TYPE_RECOMMEND_INFO, this.a.getUniqueId());
            this.d.add(ax7Var);
            this.d.add(mw7Var);
            this.d.add(xw7Var);
            this.d.add(uw7Var);
            this.d.add(lw7Var);
            this.d.add(ow7Var);
            this.d.add(yw7Var);
            this.d.add(cx7Var);
            this.d.add(ww7Var);
            this.d.add(tw7Var);
            this.d.add(bx7Var);
            this.d.add(rw7Var);
            this.d.add(rw7Var);
            this.d.add(vw7Var);
            this.d.add(ns7Var);
            this.d.add(bx7Var);
            this.d.add(bx7Var2);
            this.d.add(zw7Var);
            this.d.add(zv7Var);
            this.d.add(gw7Var);
            this.d.add(hw7Var);
            this.d.add(ew7Var);
            this.d.add(kw7Var);
            if (a2 != null) {
                this.d.add(a2);
            }
            if (d != null) {
                this.d.add(d);
            }
            this.d.add(e);
            this.d.add(e2);
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2003008, new AbsDelegateAdapterList());
            CustomMessage customMessage = new CustomMessage(2003008);
            customMessage.setTag(this.a.getUniqueId());
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            h(bdTypeRecyclerView);
            this.d.add(q88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.J, null));
            this.d.add(q88.h().g(this.a.getBaseFragmentActivity(), AdvertAppInfo.I, null));
            b16 b16Var = new b16(this.a, 1);
            b16Var.u(this.d);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016515, b16Var));
            bdTypeRecyclerView.addAdapters(this.d);
            v("page_frs_good");
            for (ci ciVar : this.d) {
                if (ciVar instanceof lm6) {
                    ((lm6) ciVar).j(true);
                }
            }
        }
    }

    public void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            for (ci ciVar : this.d) {
                if (ciVar instanceof gs7) {
                    ((gs7) ciVar).y();
                }
            }
            MessageManager.getInstance().unRegisterListener(this.i);
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048597, this) != null) || ListUtils.isEmpty(this.d) || this.a == null) {
            return;
        }
        for (ci ciVar : this.d) {
            if (ciVar instanceof gs7) {
                ((gs7) ciVar).F(this.a.getTbPageTag());
            }
        }
    }
}
