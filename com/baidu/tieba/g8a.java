package com.baidu.tieba;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumListActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.square.square.BarFolderFirstDirActivity;
import com.baidu.tieba.square.view.BestStringsFitTextView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class g8a extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Activity a;
    public ArrayList<j8a> b;
    public View.OnClickListener c;

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) {
            return null;
        }
        return invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) {
            return 0L;
        }
        return invokeI.longValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return 4;
        }
        return invokeV.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g8a a;

        public a(g8a g8aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g8aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g8aVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            j8a j8aVar;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                Object tag = view2.getTag();
                if (!(tag instanceof b) || (j8aVar = ((b) tag).d) == null) {
                    return;
                }
                if (j8aVar.a == null) {
                    BarFolderFirstDirActivity.z1(this.a.getContext(), null);
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2902025, new ForumListActivityConfig(this.a.getContext(), j8aVar.b, j8aVar.a, j8aVar.c)));
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public BarImageView a;
        public TextView b;
        public BestStringsFitTextView c;
        public j8a d;

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
    }

    public g8a(Activity activity, h8a h8aVar, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity, h8aVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = new a(this);
        this.a = activity;
        this.b = h8aVar.h();
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048585, this, i, view2, viewGroup)) == null) {
            int itemViewType = getItemViewType(i);
            if (view2 == null) {
                view2 = a(viewGroup, itemViewType);
                ViewHelper.prepareNewView(view2);
            }
            ViewHelper.processCurrentSkin(view2);
            if (itemViewType == 3) {
                return view2;
            }
            TbadkCoreApplication.getInst().getSkinType();
            View findViewById = view2.findViewById(R.id.obfuscated_res_0x7f0907b1);
            SkinManager.setBackgroundResource(findViewById, R.drawable.addresslist_item_bg);
            if (itemViewType == 2) {
                if (getCount() > 1) {
                    findViewById.setVisibility(0);
                }
            } else if (itemViewType == 1) {
                b(viewGroup, (b) view2.getTag(), i);
            }
            return view2;
        }
        return (View) invokeILL.objValue;
    }

    public final View a(ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 3) {
                return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0143, viewGroup, false);
            }
            if (i == 2) {
                return LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d013e, viewGroup, false);
            }
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d013f, viewGroup, false);
            inflate.setOnClickListener(this.c);
            b bVar = new b();
            bVar.a = (BarImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091ce9);
            bVar.b = (TextView) inflate.findViewById(R.id.obfuscated_res_0x7f091895);
            bVar.c = (BestStringsFitTextView) inflate.findViewById(R.id.obfuscated_res_0x7f09088a);
            inflate.setTag(bVar);
            return inflate;
        }
        return (View) invokeLI.objValue;
    }

    public final void b(ViewGroup viewGroup, b bVar, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup, bVar, i) == null) {
            j8a j8aVar = this.b.get(i / 2);
            bVar.d = j8aVar;
            bVar.b.setText(j8aVar.b);
            if (j8aVar.e != null) {
                bVar.c.setVisibility(0);
                String[] strArr = new String[j8aVar.e.size()];
                for (int i2 = 0; i2 < j8aVar.e.size(); i2++) {
                    strArr[i2] = j8aVar.e.get(i2).b;
                }
                bVar.c.setTextArray(strArr);
            } else {
                bVar.c.setVisibility(8);
            }
            if (j8aVar.d != null) {
                int dip2px = BdUtilHelper.dip2px(this.a, 45.0f);
                bVar.a.setTag(j8aVar.d);
                bVar.a.startLoad(j8aVar.d, 10, dip2px, dip2px, false);
            }
        }
    }

    public ArrayList<j8a> c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.b;
        }
        return (ArrayList) invokeV.objValue;
    }

    public Activity getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (Activity) invokeV.objValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<j8a> arrayList = this.b;
            if (arrayList == null) {
                return 0;
            }
            return (arrayList.size() * 2) + 1;
        }
        return invokeV.intValue;
    }

    public void d(ArrayList<j8a> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.b = arrayList;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (getCount() > 0 && i == getCount() - 1) {
                return 2;
            }
            if (Math.abs(i) % 2 != 1) {
                return 1;
            }
            return 3;
        }
        return invokeI.intValue;
    }
}
