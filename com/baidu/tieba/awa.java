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
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.AutoHeightListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.IntentConstants;
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
import com.baidu.tieba.mva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class awa extends rwa<bxa> implements twa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public String g;
    @Nullable
    public FrsTabItemData h;
    @Nullable
    public AutoHeightListView i;
    @Nullable
    public mva j;
    public final mva.f k;
    public final xq5<GoodsEvent> l;
    public CustomMessageListener m;

    @Override // com.baidu.tieba.wwa
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.wwa
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.wwa
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements mva.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ awa a;

        public a(awa awaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {awaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = awaVar;
        }

        @Override // com.baidu.tieba.mva.f
        public void a(List<r25> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, list) == null) {
                ((bxa) this.a.d).a = 3;
                ((bxa) this.a.d).e = list;
                awa awaVar = this.a;
                awaVar.y(awaVar.d);
            }
        }

        @Override // com.baidu.tieba.mva.f
        public void b(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                ((bxa) this.a.d).a = 2;
                ((bxa) this.a.d).d = i;
                awa awaVar = this.a;
                awaVar.y(awaVar.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends xq5<GoodsEvent> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ awa c;

        public b(awa awaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {awaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = awaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qq5
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

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ awa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(awa awaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {awaVar, Integer.valueOf(i)};
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
            this.a = awaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.e != null && this.a.e.isCanGoods()) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_SHOW).param("obj_locate", 1).param("fid", this.a.e.getForumId()).param("fname", this.a.e.getForumName()));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements AdapterView.OnItemClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ awa a;

        public d(awa awaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {awaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = awaVar;
        }

        @Override // android.widget.AdapterView.OnItemClickListener
        public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{adapterView, view2, Integer.valueOf(i), Long.valueOf(j)}) == null) && this.a.j != null && (this.a.j.getItem(i) instanceof r25)) {
                r25 r25Var = (r25) this.a.j.getItem(i);
                int i2 = r25Var.b;
                if (i2 == 1) {
                    int i3 = r25Var.o;
                    if (i3 != 1 && i3 != 5) {
                        UrlManager urlManager = UrlManager.getInstance();
                        TbPageContext<?> tbPageContext = this.a.a;
                        urlManager.dealOneLink(tbPageContext, new String[]{tx4.a + xi.getUrlEncode(r25Var.g)});
                        return;
                    }
                    UrlManager.getInstance().dealOneLink(this.a.a, new String[]{r25Var.g});
                } else if (i2 == 2) {
                    if (!TextUtils.isEmpty(r25Var.j)) {
                        if (r25Var.j.startsWith("tiebaclient://")) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2921361, r25Var.j));
                            return;
                        }
                        Intent intent = new Intent(IntentConstants.ACTION_BOX_BROWSER, Uri.parse(r25Var.j));
                        intent.addFlags(268468224);
                        if (UtilHelper.isHaveActivityCanHandleIntent(intent) && this.a.a.getPageActivity() != null) {
                            this.a.a.getPageActivity().startActivity(intent);
                        } else if (!TextUtils.isEmpty(r25Var.k)) {
                            UrlManager urlManager2 = UrlManager.getInstance();
                            TbPageContext<?> tbPageContext2 = this.a.a;
                            urlManager2.dealOneLink(tbPageContext2, new String[]{tx4.a + xi.getUrlEncode(r25Var.k)});
                        }
                    } else if (!TextUtils.isEmpty(r25Var.k)) {
                        UrlManager urlManager3 = UrlManager.getInstance();
                        TbPageContext<?> tbPageContext3 = this.a.a;
                        urlManager3.dealOneLink(tbPageContext3, new String[]{tx4.a + xi.getUrlEncode(r25Var.k)});
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ p55 a;
        public final /* synthetic */ awa b;

        public e(awa awaVar, p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {awaVar, p55Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = awaVar;
            this.a = p55Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.dismiss();
                da5.p().A("commodity_goods_show_first_dialog", true);
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
    public awa(TbPageContext<?> tbPageContext) {
        super(tbPageContext, bxa.class);
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

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void j(@NonNull ywa ywaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ywaVar) == null) {
            super.j(ywaVar);
            this.a.registerListener(this.m);
            this.l.setPriority(1);
            wq5.f().n(GoodsEvent.class, this.l, this.a);
            i0(this.g);
        }
    }

    @Override // com.baidu.tieba.wwa
    public void onChangeSkinType(int i) {
        mva mvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048592, this, i) == null) && (mvaVar = this.j) != null) {
            mvaVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.twa
    public void onUpdate(Object obj) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, obj) == null) && (obj instanceof gxa)) {
            this.h = ((gxa) obj).b;
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void r(zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, zi5Var) == null) {
            super.r(zi5Var);
            if (zi5Var.a == 59) {
                h0();
            }
        }
    }

    public final boolean a0() {
        InterceptResult invokeV;
        ywa ywaVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            WriteData writeData = this.e;
            if ((writeData != null && writeData.isCanGoods()) || (ywaVar = this.b) == null || ywaVar.g() <= 0) {
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
            ywa ywaVar = this.b;
            if (ywaVar == null) {
                return 0;
            }
            return 10 - ywaVar.g();
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
        LinkedList<r25> d2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            g0();
            D d3 = this.d;
            ((bxa) d3).a = 3;
            bxa bxaVar = (bxa) d3;
            mva mvaVar = this.j;
            if (mvaVar == null) {
                d2 = null;
            } else {
                d2 = mvaVar.d();
            }
            bxaVar.e = d2;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            mva mvaVar = this.j;
            if (mvaVar != null && mvaVar.getCount() > 0) {
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
        mva mvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048585, this) == null) && this.i != null && (mvaVar = this.j) != null && this.b != null) {
            if (mvaVar.f() == null) {
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

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            if (!a0()) {
                TbPageContext<?> tbPageContext = this.a;
                tbPageContext.showToast(tbPageContext.getString(R.string.toast_cant_but_commodity));
                return false;
            }
            if (b0()) {
                int c0 = c0();
                if (c0 == 1) {
                    TbPageContext<?> tbPageContext2 = this.a;
                    tbPageContext2.showToast(tbPageContext2.getString(R.string.toast_no_commodity));
                    return false;
                } else if (c0 == 2) {
                    TbPageContext<?> tbPageContext3 = this.a;
                    tbPageContext3.showToast(tbPageContext3.getString(R.string.toast_no_haowu_tab));
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
            mva mvaVar = this.j;
            if (mvaVar != null && !mvaVar.e()) {
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
            BdToast b2 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.post_goods_no_tab_tip));
            b2.g(BdToast.ToastIcon.FAILURE);
            b2.q();
        } else if (!this.e.isCanGoods()) {
            BdToast b3 = BdToast.b(this.a.getPageActivity(), this.a.getString(R.string.post_goods_tip));
            b3.g(BdToast.ToastIcon.FAILURE);
            b3.q();
        } else {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_COMMODITY_ENTRANCE_CLICK).param("obj_locate", 2).param("fid", this.e.getForumId()).param("fname", this.e.getForumName()));
            if (!da5.p().l("commodity_goods_show_first_dialog", false)) {
                p55 p55Var = new p55(this.a.getPageActivity());
                p55Var.setContentViewSize(2);
                p55Var.setCanceledOnTouchOutside(false);
                FrsPublishFineGoodsDialogView frsPublishFineGoodsDialogView = new FrsPublishFineGoodsDialogView(this.a.getPageActivity());
                frsPublishFineGoodsDialogView.setConfirmButtonListener(new e(this, p55Var));
                p55Var.setContentView(frsPublishFineGoodsDialogView);
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
                p55Var.create(this.a).show();
                return;
            }
            f0();
        }
    }

    public final void i0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, str) == null) {
            ((bxa) this.d).b = new ArrayList();
            ((bxa) this.d).c = new ArrayList();
            if (!StringUtils.isNull(str)) {
                try {
                    JSONArray jSONArray = new JSONArray(str);
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        JSONObject jSONObject = jSONArray.getJSONObject(i);
                        ((bxa) this.d).c.add(string);
                        ((bxa) this.d).b.add(hz7.g(jSONObject));
                    }
                    if (((bxa) this.d).b.size() > 0) {
                        ((bxa) this.d).a = 1;
                        y(this.d);
                        g0();
                    }
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048590, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (intent != null) {
                this.g = intent.getStringExtra(WriteActivityConfig.GOODS_LIST);
            }
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void q(@NonNull List<wwa<?>> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, list) == null) {
            super.q(list);
            for (wwa<?> wwaVar : list) {
                if (wwaVar instanceof bwa) {
                    w((bwa) wwaVar);
                } else if (wwaVar instanceof iwa) {
                    w((iwa) wwaVar);
                }
            }
        }
    }

    @Override // com.baidu.tieba.wwa
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048596, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0508, viewGroup, false);
            this.c = inflate;
            this.i = (AutoHeightListView) inflate.findViewById(R.id.obfuscated_res_0x7f090765);
            mva mvaVar = new mva(this.a);
            this.j = mvaVar;
            mvaVar.j(this.k);
            e0();
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
