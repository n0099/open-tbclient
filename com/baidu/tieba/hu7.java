package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hu7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public List<x25> b;
    public int c;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TbImageView b;
        public View c;
        public TextView d;
        public TextView e;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public hu7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public x25 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i >= 0 && i < getCount()) {
                return this.b.get(i);
            }
            return null;
        }
        return (x25) invokeI.objValue;
    }

    public void c(List<x25> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            this.b = list;
            notifyDataSetChanged();
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.c = i;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.c;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            List<x25> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (view2 != null && view2.getTag() != null) {
                bVar = (b) view2.getTag();
            } else {
                view2 = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d03c6, (ViewGroup) null);
                bVar = new b(null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091057);
                bVar.a = tbImageView;
                tbImageView.setDefaultBgResource(R.drawable.transparent_bg);
                TbImageView tbImageView2 = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0916a8);
                bVar.b = tbImageView2;
                tbImageView2.setDefaultBgResource(R.drawable.transparent_bg);
                bVar.b.setDefaultResource(R.drawable.transparent_bg);
                bVar.c = view2.findViewById(R.id.obfuscated_res_0x7f0916be);
                bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09186b);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091cf7);
                view2.setTag(bVar);
            }
            SkinManager.setViewTextColor(bVar.d, R.color.CAM_X0105, 1);
            if (i == this.c) {
                SkinManager.setBackgroundResource(bVar.c, R.drawable.chx_box_gift_s);
            } else {
                bVar.c.setBackgroundResource(R.color.common_color_10022);
            }
            x25 item = getItem(i);
            if (item != null) {
                bVar.d.setText(item.b);
                bVar.a.N(item.d, 10, false);
                bVar.b.N(item.g, 10, false);
                int i2 = item.f;
                if (i2 == 5) {
                    bVar.e.setVisibility(8);
                } else if (i2 == 3) {
                    bVar.e.setVisibility(0);
                    bVar.e.setText(mu7.b(item.a(), false, item.s));
                } else {
                    bVar.e.setVisibility(0);
                    bVar.e.setText(mu7.b(item.b(), false, item.s));
                }
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
