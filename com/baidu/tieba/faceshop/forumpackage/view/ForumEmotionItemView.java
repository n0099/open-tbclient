package com.baidu.tieba.faceshop.forumpackage.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.EmotionPackageData;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class ForumEmotionItemView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView a;
    public TextView b;
    public TextView c;
    public TextView d;
    public TextView e;
    public TextView f;
    public View g;
    public View h;
    public TextView i;
    public ViewGroup j;
    public TextView k;
    public a l;
    public TbPageContext m;

    /* loaded from: classes4.dex */
    public static class a extends BaseAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<EmotionPackageData.SingleEmotionData> a;
        public TbPageContext b;
        public boolean c;
        public boolean d;

        @Override // android.widget.Adapter
        public long getItemId(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) ? i : invokeI.longValue;
        }

        /* renamed from: com.baidu.tieba.faceshop.forumpackage.view.ForumEmotionItemView$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public static class C0260a {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public View a;
            public TbImageView b;
            public TextView c;
            public View d;

            public C0260a(View view2) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {view2};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = view2;
                view2.setEnabled(false);
                this.b = (TbImageView) this.a.findViewById(R.id.obfuscated_res_0x7f0908c5);
                this.c = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f0908ea);
                View findViewById = this.a.findViewById(R.id.obfuscated_res_0x7f0908b2);
                this.d = findViewById;
                findViewById.setVisibility(8);
            }

            public void a(EmotionPackageData.SingleEmotionData singleEmotionData, boolean z, boolean z2, int i) {
                Interceptable interceptable = $ic;
                if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{singleEmotionData, Boolean.valueOf(z), Boolean.valueOf(z2), Integer.valueOf(i)}) != null) || singleEmotionData == null) {
                    return;
                }
                if (!TextUtils.isEmpty(singleEmotionData.thumbnail)) {
                    this.b.setDefaultResource(R.drawable.obfuscated_res_0x7f080c0d);
                    this.b.K(singleEmotionData.thumbnail, 10, false);
                }
                if (z) {
                    this.c.setVisibility(0);
                } else {
                    this.c.setVisibility(8);
                }
                if (i == 7 && z2) {
                    this.d.setVisibility(0);
                } else {
                    this.d.setVisibility(8);
                }
            }
        }

        public a(TbPageContext tbPageContext) {
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
            this.a = new ArrayList();
            this.c = false;
            this.d = false;
            this.b = tbPageContext;
        }

        public void a(List<EmotionPackageData.SingleEmotionData> list, boolean z) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLZ(1048576, this, list, z) != null) || ListUtils.isEmpty(list)) {
                return;
            }
            this.c = z;
            if (list.size() > 8) {
                this.a = list.subList(0, 8);
                this.d = true;
            } else {
                this.a = list;
                this.d = false;
            }
            notifyDataSetChanged();
        }

        @Override // android.widget.Adapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return 0;
                }
                return list.size();
            }
            return invokeV.intValue;
        }

        @Override // android.widget.Adapter
        public Object getItem(int i) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
                List<EmotionPackageData.SingleEmotionData> list = this.a;
                if (list == null) {
                    return null;
                }
                return list.get(i);
            }
            return invokeI.objValue;
        }

        @Override // android.widget.Adapter
        public View getView(int i, View view2, ViewGroup viewGroup) {
            InterceptResult invokeILL;
            C0260a c0260a;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeILL = interceptable.invokeILL(1048580, this, i, view2, viewGroup)) == null) {
                if (view2 == null) {
                    view2 = LayoutInflater.from(this.b.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0257, (ViewGroup) null);
                    c0260a = new C0260a(view2);
                    view2.setTag(c0260a);
                } else {
                    c0260a = (C0260a) view2.getTag();
                }
                EmotionPackageData.SingleEmotionData singleEmotionData = this.a.get(i);
                if (i == 0 && this.c) {
                    z = true;
                } else {
                    z = false;
                }
                c0260a.a(singleEmotionData, z, this.d, i);
                return view2;
            }
            return (View) invokeILL.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumEmotionItemView(TbPageContext tbPageContext) {
        super(tbPageContext.getPageActivity());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.m = tbPageContext;
        a();
    }

    public final void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            LayoutInflater.from(getContext()).inflate(R.layout.obfuscated_res_0x7f0d02b0, this);
            this.a = (HListView) findViewById(R.id.obfuscated_res_0x7f090a7c);
            this.h = findViewById(R.id.obfuscated_res_0x7f090a7e);
            this.i = (TextView) findViewById(R.id.obfuscated_res_0x7f090a7a);
            this.j = (ViewGroup) findViewById(R.id.obfuscated_res_0x7f090a7b);
            this.f = (TextView) findViewById(R.id.obfuscated_res_0x7f090a80);
            this.b = (TextView) findViewById(R.id.obfuscated_res_0x7f090a82);
            this.c = (TextView) findViewById(R.id.obfuscated_res_0x7f090a78);
            this.d = (TextView) findViewById(R.id.obfuscated_res_0x7f090a81);
            this.e = (TextView) findViewById(R.id.obfuscated_res_0x7f090a79);
            this.g = findViewById(R.id.obfuscated_res_0x7f091339);
            this.k = (TextView) findViewById(R.id.obfuscated_res_0x7f090a76);
            this.a.setDividerWidth(getContext().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f0701d5));
            this.a.setSelector(this.m.getResources().getDrawable(R.drawable.obfuscated_res_0x7f08126e));
            a aVar = new a(this.m);
            this.l = aVar;
            this.a.setAdapter((ListAdapter) aVar);
        }
    }

    public void b(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            SkinManager.setViewTextColor(this.b, (int) R.color.CAM_X0105);
            SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.d, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.e, (int) R.color.CAM_X0109);
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0105);
            SkinManager.setBackgroundColor(this.g, R.color.CAM_X0204);
            SkinManager.setViewTextColor(this.j.getChildAt(0), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.j.getChildAt(0), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.j.getChildAt(1), (int) R.color.CAM_X0107);
            SkinManager.setBackgroundColor(this.j.getChildAt(1), R.color.CAM_X0201);
            SkinManager.setViewTextColor(this.k, (int) R.color.CAM_X0107);
            SkinManager.setViewTextColor(this.i, (int) R.color.CAM_X0107);
        }
    }

    public a getAdapter() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.l;
        }
        return (a) invokeV.objValue;
    }

    public TextView getDownLoadView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.e;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getDownloadNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.c;
        }
        return (TextView) invokeV.objValue;
    }

    public ViewGroup getFilterDropDownView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.j;
        }
        return (ViewGroup) invokeV.objValue;
    }

    public TextView getFilterView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.i;
        }
        return (TextView) invokeV.objValue;
    }

    public View getHeaderView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.h;
        }
        return (View) invokeV.objValue;
    }

    public View getLineView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.g;
        }
        return (View) invokeV.objValue;
    }

    public HListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.a;
        }
        return (HListView) invokeV.objValue;
    }

    public TextView getRankView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.f;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getShareNumView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.d;
        }
        return (TextView) invokeV.objValue;
    }

    public TextView getTitleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.b;
        }
        return (TextView) invokeV.objValue;
    }
}
