package com.baidu.tieba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.AutoHeightListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.BdToast;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.mutiprocess.event.GoodsEvent;
import com.baidu.tieba.frs.FrsPublishFineGoodsDialogView;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.tieba.t39;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class h49 extends y49 implements a59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String g;
    public FrsTabItemData h;
    public AutoHeightListView i;
    public t39 j;
    public final t39.d k;
    public final sa5 l;
    public CustomMessageListener m;

    @Override // com.baidu.tieba.d59
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.d59
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.d59
    public void e(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements t39.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        public a(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h49Var;
        }

        @Override // com.baidu.tieba.t39.d
        public void a(List list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ((i59) this.a.d).a = 3;
                ((i59) this.a.d).e = list;
                h49 h49Var = this.a;
                h49Var.y(h49Var.d);
            }
        }

        @Override // com.baidu.tieba.t39.d
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ((i59) this.a.d).a = 2;
                ((i59) this.a.d).d = i;
                h49 h49Var = this.a;
                h49Var.y(h49Var.d);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends sa5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 c;

        public b(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = h49Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.la5
        /* renamed from: a */
        public boolean onEvent(GoodsEvent goodsEvent) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, goodsEvent)) == null) {
                if (goodsEvent == null) {
                    return false;
                }
                this.c.i0(goodsEvent.getGoodsList());
                goodsEvent.setDispost(true);
                if (this.c.b != null) {
                    this.c.b.w();
                }
                return false;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(h49 h49Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var, Integer.valueOf(i)};
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
            this.a = h49Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e != null && this.a.e.isCanGoods()) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.e.getForumId()).param("fname", this.a.e.getForumName()));
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h49 a;

        public d(h49 h49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = h49Var;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.j != null && (this.a.j.getItem(i) instanceof xr4)) {
                xr4 xr4Var = (xr4) this.a.j.getItem(i);
                int i2 = xr4Var.b;
                if (i2 == 1) {
                    if (xr4Var.o == 1) {
                        UrlManager.getInstance().dealOneLink(this.a.a, new String[]{xr4Var.g});
                        return;
                    }
                    UrlManager urlManager = UrlManager.getInstance();
                    TbPageContext tbPageContext = this.a.a;
                    urlManager.dealOneLink(tbPageContext, new String[]{ep4.a + ej.getUrlEncode(xr4Var.g)});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(xr4Var.j)) {
                        if (xr4Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, xr4Var.j));
                            return;
                        }
                        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(xr4Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent) && this.a.a.getPageActivity() != null) {
                            this.a.a.getPageActivity().startActivity(intent);
                        } else if (!TextUtils.isEmpty(xr4Var.k)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext tbPageContext2 = this.a.a;
                            urlManager2.dealOneLink(tbPageContext2, new String[]{ep4.a + ej.getUrlEncode(xr4Var.k)});
                        }
                    } else if (!TextUtils.isEmpty(xr4Var.k)) {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext tbPageContext3 = this.a.a;
                        urlManager3.dealOneLink(tbPageContext3, new String[]{ep4.a + ej.getUrlEncode(xr4Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ pu4 a;
        public final /* synthetic */ h49 b;

        public e(h49 h49Var, pu4 pu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {h49Var, pu4Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = h49Var;
            this.a = pu4Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                ux4.k().u("commodity_goods_show_first_dialog", true);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_CLICK).param("obj_locate", 2);
                String str2 = "";
                if (this.b.e == null) {
                    str = "";
                } else {
                    str = this.b.e.getForumId();
                }
                StatisticItem param2 = param.param("fid", str);
                if (this.b.e != null) {
                    str2 = this.b.e.getForumName();
                }
                TiebaStatic.log(param2.param("fname", str2));
                this.b.f0();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h49(TbPageContext tbPageContext) {
        super(tbPageContext, i59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = new a(this);
        this.l = new b(this);
        this.m = new c(this, 2921494);
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void j(f59 f59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, f59Var) == null) {
            super.j(f59Var);
            this.a.registerListener(this.m);
            this.l.setPriority(1);
            ra5.f().n(GoodsEvent.class, this.l, this.a);
            i0(this.g);
        }
    }

    @Override // com.baidu.tieba.d59
    public void onChangeSkinType(int i) {
        t39 t39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (t39Var = this.j) != null) {
            t39Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.a59
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, obj) == null) && (obj instanceof n59)) {
            this.h = ((n59) obj).b;
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void r(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, l55Var) == null) {
            super.r(l55Var);
            if (l55Var.a == 59) {
                h0();
            }
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        f59 f59Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.e;
            if ((writeData != null && writeData.isCanGoods()) || (f59Var = this.b) == null || f59Var.g() <= 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final int d0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            f59 f59Var = this.b;
            if (f59Var == null) {
                return 0;
            }
            return 10 - f59Var.g();
        }
        return invokeV.intValue;
    }

    public final void e0() {
        AutoHeightListView autoHeightListView;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048583, this) == null) && (autoHeightListView = this.i) != null) {
            autoHeightListView.setAdapter((ListAdapter) this.j);
            this.i.setOnItemClickListener(new d(this));
        }
    }

    public void j0() {
        LinkedList d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            g0();
            Object obj = this.d;
            ((i59) obj).a = 3;
            i59 i59Var = (i59) obj;
            t39 t39Var = this.j;
            if (t39Var == null) {
                d2 = null;
            } else {
                d2 = t39Var.d();
            }
            i59Var.e = d2;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            t39 t39Var = this.j;
            if (t39Var != null && t39Var.getCount() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final boolean b0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            WriteData writeData = this.e;
            if (writeData != null && writeData.getFrsTabInfoData() != null && !ListUtils.isEmpty(this.e.getFrsTabInfoData().tabList)) {
                for (FrsTabItemData frsTabItemData : this.e.getFrsTabInfoData().tabList) {
                    if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void g0() {
        t39 t39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.i != null && (t39Var = this.j) != null && this.b != null) {
            if (t39Var.f() == null) {
                this.j.i(this.b.F());
            }
            this.j.h();
            if (this.j.getCount() == 0) {
                this.i.setVisibility(8);
            } else {
                this.i.setVisibility(0);
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!a0()) {
                TbPageContext tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.obfuscated_res_0x7f0f1467));
                return false;
            }
            if (b0()) {
                int c0 = c0();
                if (c0 == 1) {
                    TbPageContext tbPageContext2 = this.a;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.obfuscated_res_0x7f0f146c));
                    return false;
                } else if (c0 == 2) {
                    TbPageContext tbPageContext3 = this.a;
                    tbPageContext3.showToast(tbPageContext3.getString(R.string.obfuscated_res_0x7f0f146d));
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final int c0() {
        InterceptResult invokeV;
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            t39 t39Var = this.j;
            if (t39Var != null && !t39Var.e()) {
                z = false;
            } else {
                z = true;
            }
            FrsTabItemData frsTabItemData = this.h;
            if (frsTabItemData != null && frsTabItemData.tabType == 3) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (z && z2) {
                return 1;
            }
            if (z || z2) {
                return 0;
            }
            return 2;
        }
        return invokeV.intValue;
    }

    public final void f0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            String uk = TbadkCoreApplication.getCurrentAccountInfo().getUk();
            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, "tiebaclient://swan/NazEnRDQ6crg3NRNiNtrB4uWEi6EFy4U/pages/shop-manage/index?subentry=3_2_1&uk=" + uk + "&max=" + d0()));
        }
    }

    public final void h0() {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048586, this) != null) || this.e == null) {
            return;
        }
        if (!b0()) {
            BdToast b2 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0f0c));
            b2.f(BdToast.ToastIcon.FAILURE);
            b2.i();
        } else if (!this.e.isCanGoods()) {
            BdToast b3 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.obfuscated_res_0x7f0f0f0d));
            b3.f(BdToast.ToastIcon.FAILURE);
            b3.i();
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.e.getForumId()).param("fname", this.e.getForumName()));
            if (!ux4.k().h("commodity_goods_show_first_dialog", false)) {
                pu4 pu4Var = new pu4(this.a.getPageActivity());
                pu4Var.setContentViewSize(2);
                pu4Var.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new e(this, pu4Var));
                pu4Var.setContentView(frsPublishFineGoodsDialogView);
                StatisticItem param = new StatisticItem(TbadkCoreStatisticKey.KEY_WRITE_GOODS_NEW_DIALOG_SHOW).param("obj_locate", 2);
                WriteData writeData = this.e;
                String str2 = "";
                if (writeData == null) {
                    str = "";
                } else {
                    str = writeData.getForumId();
                }
                StatisticItem param2 = param.param("fid", str);
                WriteData writeData2 = this.e;
                if (writeData2 != null) {
                    str2 = writeData2.getForumName();
                }
                TiebaStatic.log(param2.param("fname", str2));
                pu4Var.create(this.a).show();
                return;
            }
            f0();
        }
    }

    public final void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ((i59) this.d).b = new ArrayList();
            ((i59) this.d).c = new ArrayList();
            if (!StringUtils.isNull(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        ((i59) this.d).c.add(string);
                        ((i59) this.d).b.add(gw6.g(jSONObject));
                    }
                    if (((i59) this.d).b.size() > 0) {
                        ((i59) this.d).a = 1;
                        y(this.d);
                        g0();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void m(Bundle bundle, Intent intent, WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (intent != null) {
                this.g = intent.getStringExtra(WriteActivityConfig.GOODS_LIST);
            }
        }
    }

    @Override // com.baidu.tieba.y49, com.baidu.tieba.d59
    public void q(List list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.q(list);
            Iterator it = list.iterator();
            while (it.hasNext()) {
                d59 d59Var = (d59) it.next();
                if (d59Var instanceof i49) {
                    w((i49) d59Var);
                } else if (d59Var instanceof p49) {
                    w((p49) d59Var);
                }
            }
        }
    }

    @Override // com.baidu.tieba.d59
    public View s(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d048f, viewGroup, false);
            this.c = inflate;
            this.i = (AutoHeightListView) inflate.findViewById(R.id.obfuscated_res_0x7f09069a);
            t39 t39Var = new t39(this.a);
            this.j = t39Var;
            t39Var.j(this.k);
            e0();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
