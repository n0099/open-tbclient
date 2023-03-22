package com.baidu.tieba;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdRecyclerView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteItemData;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.write.write.vote.WriteVoteActivity;
import com.baidu.tieba.write.write.vote.WriteVoteViewAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes4.dex */
public class gx9 implements vl5, View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Intent A;
    public TbPageContext<WriteVoteActivity> a;
    public LinearLayout b;
    public NavigationBar c;
    public BdRecyclerView d;
    public WriteVoteViewAdapter e;
    public LinearLayout f;
    public LinearLayout g;
    public TextView h;
    public EditText i;
    public List<WriteVoteItemData> j;
    public WriteVoteData k;
    public ForumWriteData l;
    public String m;
    public TextView n;
    public TextView o;
    public TextView p;
    public TextView q;
    public TextView r;
    public TextView s;
    public TextView t;
    public TextView u;
    public TextView v;
    public int w;
    public int x;
    public boolean y;
    public boolean z;

    @Override // com.baidu.tieba.vl5
    public boolean L0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes4.dex */
    public class c implements WriteVoteViewAdapter.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx9 a;

        /* loaded from: classes4.dex */
        public class a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.e.setData(this.a.a.j);
                }
            }
        }

        /* loaded from: classes4.dex */
        public class b implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    this.a.a.e.setData(this.a.a.j);
                }
            }
        }

        public c(gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx9Var;
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void a(int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
                this.a.j.remove(i);
                this.a.d.post(new b(this));
                gx9 gx9Var = this.a;
                gx9Var.z = gx9Var.y();
                gx9 gx9Var2 = this.a;
                if (gx9Var2.y && this.a.z) {
                    z = true;
                } else {
                    z = false;
                }
                gx9Var2.L(z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void b() {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                this.a.j.add(new WriteVoteItemData());
                this.a.d.post(new a(this));
                gx9 gx9Var = this.a;
                gx9Var.z = gx9Var.y();
                gx9 gx9Var2 = this.a;
                if (gx9Var2.y && this.a.z) {
                    z = true;
                } else {
                    z = false;
                }
                gx9Var2.L(z);
            }
        }

        @Override // com.baidu.tieba.write.write.vote.WriteVoteViewAdapter.f
        public void c(WriteVoteItemData writeVoteItemData, int i) {
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, writeVoteItemData, i) == null) {
                this.a.j.set(i, writeVoteItemData);
                gx9 gx9Var = this.a;
                gx9Var.z = gx9Var.y();
                gx9 gx9Var2 = this.a;
                if (gx9Var2.y && this.a.z) {
                    z = true;
                } else {
                    z = false;
                }
                gx9Var2.L(z);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx9 a;

        public a(gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx9Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                hi.O(this.a.a.getPageActivity(), this.a.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements TextWatcher {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx9 a;

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

        public b(gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx9Var;
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable editable) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, editable) != null) || editable == null) {
                return;
            }
            String obj = editable.toString();
            if (!StringUtils.isNull(obj)) {
                String replace = obj.replace(" ", "");
                if (dq5.f(replace) > 40) {
                    this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1736), 20));
                }
                String n = dq5.n(replace, 40);
                if (!n.equals(editable.toString())) {
                    this.a.i.setText(n);
                    this.a.i.setSelection(n.length());
                }
                this.a.i.setTypeface(Typeface.defaultFromStyle(1));
                this.a.y = true;
                gx9 gx9Var = this.a;
                gx9Var.L(gx9Var.z);
                return;
            }
            this.a.i.setTypeface(Typeface.defaultFromStyle(0));
            this.a.y = false;
            this.a.L(false);
        }
    }

    /* loaded from: classes4.dex */
    public class d extends RecyclerView.OnScrollListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx9 a;

        public d(gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx9Var;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, recyclerView, i) == null) {
                super.onScrollStateChanged(recyclerView, i);
                if (i == 1 || i == 2) {
                    hi.z(this.a.a.getPageActivity(), recyclerView);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gx9 a;

        public e(gx9 gx9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gx9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gx9Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                List<WriteVoteItemData> x = this.a.x();
                HashMap hashMap = new HashMap();
                int size = x.size();
                for (int i = 0; i < size; i++) {
                    WriteVoteItemData writeVoteItemData = x.get(i);
                    if (!hashMap.containsKey(writeVoteItemData.getText())) {
                        hashMap.put(writeVoteItemData.getText(), Integer.valueOf(i));
                    } else {
                        this.a.a.showToast(String.format(this.a.a.getString(R.string.obfuscated_res_0x7f0f1734), Integer.valueOf(((Integer) hashMap.get(writeVoteItemData.getText())).intValue() + 1), Integer.valueOf(i + 1)));
                        return;
                    }
                }
                this.a.k = new WriteVoteData();
                this.a.k.setTitle(this.a.i.getText().toString());
                this.a.k.setExpire_type(this.a.x);
                this.a.k.setIs_multi(this.a.w);
                this.a.k.setOptions(x);
                this.a.A = new Intent();
                this.a.A.putExtra(IntentConfig.WRITE_VOTE_DATA, this.a.k);
                this.a.a.getPageActivity().finish();
                gx9 gx9Var = this.a;
                gx9Var.G(gx9Var.m);
            }
        }
    }

    public gx9(TbPageContext tbPageContext, LinearLayout linearLayout, NavigationBar navigationBar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, linearLayout, navigationBar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.w = 0;
        this.x = -1;
        this.y = false;
        this.z = false;
        this.a = tbPageContext;
        this.b = linearLayout;
        this.c = navigationBar;
        Intent intent = tbPageContext.getPageActivity().getIntent();
        if (intent != null) {
            Serializable serializableExtra = intent.getSerializableExtra(WriteVoteActivityConfig.EXTRA_DATA_KEY);
            if (serializableExtra instanceof WriteVoteData) {
                this.k = (WriteVoteData) serializableExtra;
            } else if (serializableExtra instanceof ForumWriteData) {
                this.l = (ForumWriteData) serializableExtra;
            }
            this.m = intent.getStringExtra("title");
        }
        WriteVoteData writeVoteData = this.k;
        if (writeVoteData != null && !ListUtils.isEmpty(writeVoteData.getOptions()) && this.k.getOptions().size() >= 2) {
            this.j = this.k.getOptions();
        } else {
            ArrayList arrayList = new ArrayList();
            this.j = arrayList;
            arrayList.add(new WriteVoteItemData());
            this.j.add(new WriteVoteItemData());
        }
        A();
    }

    public final void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            BdRecyclerView bdRecyclerView = new BdRecyclerView(this.a.getPageActivity());
            this.d = bdRecyclerView;
            bdRecyclerView.setLayoutManager(new LinearLayoutManager(this.a.getPageActivity()));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = hi.g(this.a.getPageActivity(), R.dimen.tbds27);
            this.b.addView(this.d, layoutParams);
            WriteVoteViewAdapter writeVoteViewAdapter = new WriteVoteViewAdapter(this.a);
            this.e = writeVoteViewAdapter;
            this.d.setAdapter(writeVoteViewAdapter);
            E();
            C();
            B();
            D();
            this.d.addHeaderView(this.f);
            this.d.addFooterView(this.g);
            this.e.setData(this.j);
            F();
            this.i.requestFocus();
            this.i.postDelayed(new a(this), 150L);
        }
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0976, (ViewGroup) null);
            this.g = linearLayout;
            this.n = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f0928e9);
            this.o = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092858);
            this.p = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092857);
            this.q = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f0928e8);
            this.r = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092854);
            this.s = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092851);
            this.t = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092853);
            this.u = (TextView) this.g.findViewById(R.id.obfuscated_res_0x7f092852);
        }
    }

    public final void C() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0977, (ViewGroup) null);
            this.f = linearLayout;
            this.h = (TextView) linearLayout.findViewById(R.id.obfuscated_res_0x7f092845);
            this.i = (EditText) this.f.findViewById(R.id.vote_title);
        }
    }

    public final void F() {
        WriteVoteData writeVoteData;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048581, this) != null) || (writeVoteData = this.k) == null) {
            return;
        }
        this.i.setText(writeVoteData.getTitle());
        this.w = this.k.getIs_multi();
        this.x = this.k.getExpire_type();
        J();
        I();
        boolean y = y();
        this.z = y;
        if (this.y && y) {
            z = true;
        } else {
            z = false;
        }
        L(z);
    }

    public final void I() {
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            TextView textView = this.r;
            boolean z4 = false;
            if (this.x == -1) {
                z = true;
            } else {
                z = false;
            }
            H(textView, z);
            TextView textView2 = this.s;
            if (this.x == 1) {
                z2 = true;
            } else {
                z2 = false;
            }
            H(textView2, z2);
            TextView textView3 = this.t;
            if (this.x == 7) {
                z3 = true;
            } else {
                z3 = false;
            }
            H(textView3, z3);
            TextView textView4 = this.u;
            if (this.x == 30) {
                z4 = true;
            }
            H(textView4, z4);
        }
    }

    public final List<WriteVoteItemData> x() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            ArrayList arrayList = new ArrayList();
            List<WriteVoteItemData> list = this.j;
            if (list == null) {
                return arrayList;
            }
            int size = list.size();
            int i = 0;
            while (i < size) {
                WriteVoteItemData writeVoteItemData = new WriteVoteItemData();
                int i2 = i + 1;
                writeVoteItemData.setId(i2);
                writeVoteItemData.setText(this.j.get(i).getText());
                arrayList.add(writeVoteItemData);
                i = i2;
            }
            return arrayList;
        }
        return (List) invokeV.objValue;
    }

    public final boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            int size = this.j.size();
            for (int i = 0; i < size; i++) {
                if (StringUtils.isNull(this.j.get(i).getText())) {
                    return false;
                }
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public final void D() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.o.setOnClickListener(this);
            this.p.setOnClickListener(this);
            this.r.setOnClickListener(this);
            this.s.setOnClickListener(this);
            this.t.setOnClickListener(this);
            this.u.setOnClickListener(this);
            this.i.addTextChangedListener(new b(this));
            this.e.h(new c(this));
            this.d.addOnScrollListener(new d(this));
            this.v.setOnClickListener(new e(this));
        }
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.c.setCenterTextTitle(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f1707));
            TextView addTextButton = this.c.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0532));
            this.v = addTextButton;
            addTextButton.setTextSize(0, hi.g(this.a.getPageActivity(), R.dimen.tbds44));
            this.v.setEnabled(false);
        }
    }

    public final void G(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, str) != null) || this.l == null || WriteActivityConfig.isAsyncWriting()) {
            return;
        }
        WriteActivityConfig.newInstance(this.a.getPageActivity()).setType(9).setForumWriteData(this.l).setShowVoteData(this.k).setTitle(str).send();
    }

    public final void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.v.setEnabled(z);
            if (z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(ga9.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
        }
    }

    public final void H(TextView textView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, textView, z) == null) {
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(this.a.getResources().getDimension(R.dimen.tbds10));
            if (z) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0302);
                gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0905));
                textView.setBackgroundDrawable(gradientDrawable);
                return;
            }
            SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0105);
            gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0209));
            textView.setBackgroundDrawable(gradientDrawable);
        }
    }

    public final void J() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            TextView textView = this.o;
            boolean z2 = false;
            if (this.w != 1) {
                z = true;
            } else {
                z = false;
            }
            H(textView, z);
            TextView textView2 = this.p;
            if (this.w == 1) {
                z2 = true;
            }
            H(textView2, z2);
        }
    }

    @Override // com.baidu.tieba.vl5
    public Intent getResultIntent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.A;
        }
        return (Intent) invokeV.objValue;
    }

    @Override // com.baidu.tieba.vl5
    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            LinearLayout linearLayout = this.f;
            if (linearLayout == null || this.d == null || linearLayout.getTop() != 0 || this.d.getFirstVisiblePosition() != 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.vl5
    public void m(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            SkinManager.setViewTextColor(this.h, (int) R.color.CAM_X0109);
            this.i.setHintTextColor(SkinManager.getColor(R.color.CAM_X0109));
            this.i.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.n.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            this.q.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            if (this.y && this.z) {
                this.v.setTextColor(SkinManager.getColor(R.color.CAM_X0302));
            } else {
                this.v.setTextColor(ga9.a(SkinManager.getColor(R.color.CAM_X0302), 0.5f));
            }
            J();
            I();
            WriteVoteViewAdapter writeVoteViewAdapter = this.e;
            if (writeVoteViewAdapter != null) {
                writeVoteViewAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, view2) == null) {
            if (view2.getId() == R.id.obfuscated_res_0x7f092858) {
                this.w = 0;
                J();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092857) {
                this.w = 1;
                J();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092854) {
                this.x = -1;
                I();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092851) {
                this.x = 1;
                I();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092853) {
                this.x = 7;
                I();
            } else if (view2.getId() == R.id.obfuscated_res_0x7f092852) {
                this.x = 30;
                I();
            }
        }
    }
}
