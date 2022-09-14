package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.tbadkCore.FrsViewData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public class ck6 extends qg6<xl8, a> implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean l;
    public boolean m;

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public View c;
        public TextView d;
        public View e;
        public View f;
        public TextView g;
        public View h;
        public View i;
        public View j;
        public List<View> k;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.k = new ArrayList();
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090b19);
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090b1b);
            this.c = view2.findViewById(R.id.obfuscated_res_0x7f090bc1);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bbf);
            this.e = view2.findViewById(R.id.obfuscated_res_0x7f090ba0);
            this.f = view2.findViewById(R.id.obfuscated_res_0x7f090af6);
            this.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090af7);
            this.h = view2.findViewById(R.id.obfuscated_res_0x7f091721);
            this.i = view2.findViewById(R.id.obfuscated_res_0x7f091722);
            this.j = view2.findViewById(R.id.obfuscated_res_0x7f091720);
            this.k.add(this.h);
            this.k.add(this.i);
            this.k.add(this.j);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck6(TbPageContext tbPageContext, BdUniqueId bdUniqueId, boolean z) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = TbadkCoreApplication.getInst().appResponseToCmd(2002006);
        this.m = z;
    }

    public final void E(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
            List<View> list = aVar.k;
            for (View view2 : list) {
                view2.setVisibility(8);
            }
            list.get(0).setVisibility(0);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: F */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) ? new a(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0303, (ViewGroup) null)) : (a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qg6, com.baidu.tieba.qn
    /* renamed from: G */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, xl8 xl8Var, a aVar) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, xl8Var, aVar})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, xl8Var, aVar);
            boolean z = true;
            if (xl8Var.h()) {
                String c = xl8Var.c();
                if (c != null) {
                    aVar.b.setText(c);
                } else {
                    FrsViewData frsViewData = this.b;
                    if (frsViewData != null && frsViewData.getForum() != null && this.b.getForum().getName() != null) {
                        TextView textView = aVar.b;
                        Context context = this.mContext;
                        Object[] objArr = new Object[1];
                        FrsViewData frsViewData2 = this.b;
                        objArr[0] = frsViewData2 == null ? "" : frsViewData2.getForum().getName();
                        textView.setText(context.getString(R.string.obfuscated_res_0x7f0f07c4, objArr));
                    }
                }
                aVar.a.setTag(Integer.valueOf(i));
                aVar.a.setOnClickListener(this);
                aVar.a.setVisibility(0);
            } else {
                aVar.a.setVisibility(8);
                aVar.h.setVisibility(8);
            }
            ql8 f = xl8Var.f();
            if (f != null && f.b() && !TextUtils.isEmpty(f.a())) {
                aVar.d.setText(f.a());
                aVar.c.setTag(Integer.valueOf(i));
                aVar.c.setOnClickListener(this);
                aVar.c.setVisibility(0);
            } else {
                aVar.c.setVisibility(8);
                aVar.i.setVisibility(8);
            }
            if (this.m) {
                aVar.e.setVisibility(0);
            } else {
                aVar.e.setVisibility(8);
            }
            this.c.getLayoutMode().l(this.f == 1);
            this.c.getLayoutMode().k(view2);
            FrsViewData frsViewData3 = this.b;
            z = (frsViewData3 == null || frsViewData3.getUserData() == null || !this.b.getUserData().isBawu()) ? false : false;
            if (z) {
                aVar.f.setVisibility(0);
                SkinManager.setBackgroundResource(aVar.f, R.drawable.frs_top_item_bg);
                aVar.e.setVisibility(0);
                aVar.f.setOnClickListener(this);
                aVar.f.setTag(Integer.valueOf(i));
            } else {
                aVar.f.setVisibility(8);
                aVar.j.setVisibility(8);
            }
            if (this.l || xl8Var.h()) {
                return view2;
            }
            if (z) {
                aVar.a.setVisibility(8);
                aVar.c.setVisibility(8);
                E(aVar);
                return view2;
            }
            return new View(this.mContext);
        }
        return (View) invokeCommon.objValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, view2) == null) || this.d == null) {
            return;
        }
        int id = view2.getId();
        int intValue = ((Integer) view2.getTag()).intValue();
        if (getItem(intValue) instanceof ThreadData) {
            ThreadData threadData = (ThreadData) getItem(intValue);
            this.d.a(id, intValue, view2, s(this.e.getListView(), intValue), threadData);
        }
    }
}
