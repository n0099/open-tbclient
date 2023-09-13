package com.baidu.tieba;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.p0b;
import com.baidu.tieba.tt6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.FrsTabInfo;
import tbclient.SimpleForum;
/* loaded from: classes5.dex */
public class dza implements tt6 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p0b a;
    public ArrayList<TransmitForumData> b;
    public List<SimpleForum> c;
    public tt6.a d;
    public boolean e;
    public int f;
    public p0b.b g;

    /* loaded from: classes5.dex */
    public class a implements p0b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ dza a;

        public a(dza dzaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dzaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = dzaVar;
        }

        @Override // com.baidu.tieba.p0b.b
        public void a(List<SimpleForum> list, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeLI(1048576, this, list, i) != null) {
                return;
            }
            this.a.c = list;
            this.a.f = i;
            this.a.h();
        }

        @Override // com.baidu.tieba.p0b.b
        public void onError() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.g();
            }
        }
    }

    public dza() {
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
        this.b = new ArrayList<>();
        this.g = new a(this);
        BdUniqueId gen = BdUniqueId.gen();
        p0b p0bVar = new p0b(gen);
        this.a = p0bVar;
        p0bVar.i(this.g);
        this.a.j(gen);
    }

    @Override // com.baidu.tieba.tt6
    public void a(tt6.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            this.d = aVar;
        }
    }

    @Override // com.baidu.tieba.tt6
    public void b() {
        p0b p0bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && this.d != null && (p0bVar = this.a) != null) {
            this.e = false;
            p0bVar.l(null);
            this.a.k(null);
            this.a.h();
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) != null) || this.e) {
            return;
        }
        tt6.a aVar = this.d;
        if (aVar != null) {
            aVar.callback(null, false, 2, 0);
        }
        this.e = true;
    }

    public final void h() {
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.b.clear();
            if (ListUtils.getCount(this.c) > 0) {
                for (SimpleForum simpleForum : this.c) {
                    if (simpleForum != null && (l = simpleForum.id) != null && l.longValue() > 0 && !StringUtils.isNull(simpleForum.name)) {
                        TransmitForumData transmitForumData = new TransmitForumData(simpleForum.id.longValue(), simpleForum.name, false, 1, simpleForum.avatar);
                        transmitForumData.tabItemDatas = new ArrayList<>();
                        for (FrsTabInfo frsTabInfo : simpleForum.tab_info) {
                            if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                                transmitForumData.tabItemDatas.add(new FrsTabItemData(frsTabInfo));
                            }
                        }
                        this.b.add(transmitForumData);
                    }
                }
            }
            tt6.a aVar = this.d;
            if (aVar != null) {
                aVar.callback(this.b, true, 2, this.f);
            }
        }
    }
}
