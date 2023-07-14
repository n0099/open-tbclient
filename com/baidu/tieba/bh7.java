package com.baidu.tieba;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AlaWriteShareInBarActivityConfig;
import com.baidu.tbadk.core.atomData.SelectForumActivityConfig;
import com.baidu.tbadk.core.atomData.TransmitPostEditActivityConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.data.BaijiahaoData;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.dh7;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.FrsTabItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import tbclient.FrsTabInfo;
/* loaded from: classes5.dex */
public class bh7 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public final ch7 b;
    public final dh7 c;
    public final ah7 d;
    public ArrayList<yn> e;
    public String f;
    public int g;
    public long h;
    public String i;
    public BaijiahaoData j;
    public OriginalThreadInfo.ShareInfo k;
    public String l;
    public String m;
    public String n;
    public String o;
    public View.OnClickListener p;
    public Runnable q;
    public CustomMessageListener r;
    public CustomMessageListener s;
    public dh7.b t;

    public void A(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        public a(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || !(view2.getTag() instanceof gh7)) {
                return;
            }
            Intent intent = new Intent();
            this.a.a.getPageActivity().setResult(-1, intent);
            gh7 gh7Var = (gh7) view2.getTag();
            if (this.a.g != 1) {
                if (this.a.g != 2 && this.a.g != 4) {
                    if (this.a.g == 3) {
                        intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_ID, String.valueOf(gh7Var.e()));
                        intent.putExtra(SelectForumActivityConfig.SELECT_FORUM_NAME, gh7Var.f());
                        this.a.a.getPageActivity().finish();
                        return;
                    }
                    this.a.r(String.valueOf(gh7Var.e()), gh7Var.f());
                    return;
                }
                this.a.s(gh7Var);
                TiebaStatic.log(new StatisticItem("c12609").param("fid", gh7Var.e()));
                return;
            }
            this.a.q(gh7Var.e(), gh7Var.f());
        }
    }

    /* loaded from: classes5.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        public b(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                yi.P(this.a.a.getPageActivity(), this.a.b.d);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(bh7 bh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var, Integer.valueOf(i)};
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
            this.a = bh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof String)) {
                String str = (String) customResponsedMessage.getData();
                this.a.b.d.setText(str);
                this.a.b.d.setSelection(str.length());
                this.a.n();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(bh7 bh7Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var, Integer.valueOf(i)};
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
            this.a = bh7Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null) {
                this.a.H();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements dh7.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        public e(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // com.baidu.tieba.dh7.b
        public void a(boolean z, hh7 hh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZL(1048576, this, z, hh7Var) == null) {
                if (z && hh7Var != null && !ListUtils.isEmpty(hh7Var.a())) {
                    this.a.e = hh7Var.a();
                    bh7 bh7Var = this.a;
                    bh7Var.x(bh7Var.e);
                } else if (StringUtils.isNull(this.a.f)) {
                    this.a.H();
                } else {
                    this.a.I();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements TextView.OnEditorActionListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        public f(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // android.widget.TextView.OnEditorActionListener
        public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, textView, i, keyEvent)) == null) {
                if (i == 3) {
                    this.a.n();
                    return true;
                }
                return false;
            }
            return invokeLIL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public class g implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, charSequence, i, i2, i3) == null) {
            }
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIII(Constants.METHOD_SEND_USER_MSG, this, charSequence, i, i2, i3) == null) {
            }
        }

        public g(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, editable) != null) {
                return;
            }
            this.a.n();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements View.OnFocusChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bh7 a;

        public h(bh7 bh7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bh7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bh7Var;
        }

        @Override // android.view.View.OnFocusChangeListener
        public void onFocusChange(View view2, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLZ(1048576, this, view2, z) == null) {
                if (z) {
                    this.a.n();
                } else {
                    yi.A(this.a.a.getPageActivity(), view2);
                }
            }
        }
    }

    public bh7(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.p = new a(this);
        this.q = new b(this);
        this.r = new c(this, 2921021);
        this.s = new d(this, 2921020);
        this.t = new e(this);
        this.a = tbPageContext;
        this.b = new ch7(tbPageContext);
        m();
        dh7 dh7Var = new dh7(tbPageContext, tbPageContext.getUniqueId());
        this.c = dh7Var;
        dh7Var.e(this.t);
        this.e = new ArrayList<>();
        ah7 ah7Var = new ah7(tbPageContext, this.b.g);
        this.d = ah7Var;
        ah7Var.a(this.p);
        H();
        tbPageContext.registerListener(this.s);
        tbPageContext.registerListener(this.r);
        zg.a().postDelayed(this.q, 500L);
    }

    public void B(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
            this.o = str;
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.n = str;
        }
    }

    public void D(OriginalThreadInfo.ShareInfo shareInfo) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, shareInfo) == null) {
            this.k = shareInfo;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.l = str;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.m = str;
        }
    }

    public void G(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            this.i = str;
        }
    }

    public void u(BaijiahaoData baijiahaoData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048594, this, baijiahaoData) == null) {
            this.j = baijiahaoData;
        }
    }

    public void x(ArrayList<yn> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, arrayList) == null) {
            this.e = arrayList;
            this.b.g.setData(arrayList);
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048596, this, i) == null) {
            this.g = i;
        }
    }

    public void z(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048597, this, j) == null) {
            this.h = j;
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.c.c();
            this.e.clear();
            ArrayList<String> c2 = eh7.c();
            if (!ListUtils.isEmpty(c2)) {
                fh7 fh7Var = new fh7();
                fh7Var.d(fh7.d);
                this.e.add(fh7Var);
                this.e.add(new fh7(c2));
                x(this.e);
                return;
            }
            this.e.clear();
            x(this.e);
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            this.b.b.setOnClickListener(this);
            this.b.d.setOnEditorActionListener(new f(this));
            this.b.d.addTextChangedListener(new g(this));
            this.b.d.setOnFocusChangeListener(new h(this));
            this.b.d.setOnClickListener(this);
            this.b.e.setOnClickListener(this);
            this.b.f.setOnClickListener(this);
        }
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            this.e.clear();
            fh7 fh7Var = new fh7();
            fh7Var.d(fh7.e);
            this.e.add(fh7Var);
            x(this.e);
        }
    }

    public ch7 o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.b;
        }
        return (ch7) invokeV.objValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            zg.a().removeCallbacks(this.q);
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.r);
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            if (this.b.d.getText() != null && !StringUtils.isNull(this.b.d.getText().toString())) {
                yn ynVar = (yn) ListUtils.getItem(this.e, 0);
                if (ynVar != null && ynVar.getType() == fh7.d) {
                    this.e.clear();
                    x(this.e);
                }
                this.b.e.setVisibility(0);
                String obj = this.b.d.getText().toString();
                this.f = obj;
                this.c.d(obj);
                return;
            }
            this.b.e.setVisibility(8);
            this.f = null;
            H();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, view2) == null) {
            ch7 ch7Var = this.b;
            EditText editText = ch7Var.d;
            if (view2 == editText) {
                n();
            } else if (view2 == ch7Var.f) {
                yi.A(this.a.getPageActivity(), this.b.d);
                this.a.getPageActivity().finish();
            } else if (view2 == ch7Var.e) {
                editText.setText("");
            } else if (view2 == ch7Var.b) {
                x(this.e);
            }
        }
    }

    public final FrsTabInfoData p(gh7 gh7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048589, this, gh7Var)) == null) {
            if (gh7Var == null || ListUtils.isEmpty(gh7Var.g())) {
                return null;
            }
            ArrayList arrayList = new ArrayList(gh7Var.g().size());
            for (FrsTabInfo frsTabInfo : gh7Var.g()) {
                if (frsTabInfo != null && frsTabInfo.is_general_tab.intValue() == 1 && frsTabInfo.tab_id.intValue() > 0 && !StringUtils.isNull(frsTabInfo.tab_name)) {
                    arrayList.add(new FrsTabItemData(frsTabInfo));
                }
            }
            if (ListUtils.isEmpty(arrayList)) {
                return null;
            }
            FrsTabInfoData frsTabInfoData = new FrsTabInfoData();
            frsTabInfoData.tabList = arrayList;
            frsTabInfoData.selectedTabId = -1;
            return frsTabInfoData;
        }
        return (FrsTabInfoData) invokeL.objValue;
    }

    public final void s(gh7 gh7Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048592, this, gh7Var) != null) || gh7Var == null) {
            return;
        }
        TransmitPostEditActivityConfig transmitPostEditActivityConfig = new TransmitPostEditActivityConfig(this.a.getPageActivity(), 9, String.valueOf(gh7Var.e()), gh7Var.f(), null, null, 13011, null, null, this.k);
        transmitPostEditActivityConfig.setCallFrom("2");
        BaijiahaoData baijiahaoData = this.j;
        if (baijiahaoData != null) {
            transmitPostEditActivityConfig.setBaijiahaoData(baijiahaoData);
            transmitPostEditActivityConfig.setTransmitOriginThreadComment(this.l);
            transmitPostEditActivityConfig.setTransmitThreadAuthorNameShow(this.m);
        } else {
            transmitPostEditActivityConfig.setMoreForumTitle(this.o);
            transmitPostEditActivityConfig.setMoreForumUrl(this.n);
        }
        transmitPostEditActivityConfig.setFrsTabInfo(p(gh7Var));
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, transmitPostEditActivityConfig));
        this.a.getPageActivity().finish();
    }

    public final void q(long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJL(1048590, this, j, str) == null) {
            TransmitForumData transmitForumData = new TransmitForumData(j, str, true, 0);
            transmitForumData.tabItemDatas = new ArrayList<>();
            ArrayList arrayList = new ArrayList();
            arrayList.add(transmitForumData);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaWriteShareInBarActivityConfig(this.a.getPageActivity(), arrayList, String.valueOf(this.h), this.i)));
            this.a.getPageActivity().finish();
        }
    }

    public final void r(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048591, this, str, str2) != null) || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumId(str).setForumName(str2).setFrom(WriteActivityConfig.FROM_FORUM_SHARE).send();
        this.a.getPageActivity().finish();
    }
}
