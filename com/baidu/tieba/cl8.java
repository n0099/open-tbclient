package com.baidu.tieba;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.BarImageView;
import com.baidu.tieba.mainentrance.ForumSuggestModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class cl8 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseActivity<?> a;
    public final boolean b;
    public ArrayList<ForumSuggestModel.Forum> c;
    public String d;

    /* loaded from: classes5.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes5.dex */
    public class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public TextView b;
        public BarImageView c;
        public TextView d;
        public TextView e;
        public TextView f;

        public b(cl8 cl8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cl8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ b(cl8 cl8Var, a aVar) {
            this(cl8Var);
        }
    }

    public cl8(BaseActivity<?> baseActivity, ArrayList<ForumSuggestModel.Forum> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseActivity, arrayList};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = baseActivity;
        this.b = true;
        this.c = arrayList;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public ForumSuggestModel.Forum getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            int count = getCount();
            if (count > 0 && i < count) {
                return this.c.get(i);
            }
            return null;
        }
        return (ForumSuggestModel.Forum) invokeI.objValue;
    }

    public void d(ArrayList<ForumSuggestModel.Forum> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, arrayList) == null) {
            this.c = arrayList;
            if (arrayList != null) {
                notifyDataSetChanged();
            }
        }
    }

    public void e(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.d = str;
        }
    }

    public String b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            if (i >= 100000) {
                return String.valueOf(i / 10000) + this.a.getPageContext().getString(R.string.member_count_unit);
            }
            return String.valueOf(i);
        }
        return (String) invokeI.objValue;
    }

    public void c(TextView textView, String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, textView, str) == null) && textView != null && !TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.d)) {
            String lowerCase = str.toLowerCase();
            String lowerCase2 = this.d.toLowerCase();
            if (!lowerCase.contains(lowerCase2)) {
                textView.setText(str);
                return;
            }
            int indexOf = lowerCase.indexOf(lowerCase2);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(SkinManager.getColor(R.color.CAM_X0301));
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
            spannableStringBuilder.setSpan(foregroundColorSpan, indexOf, this.d.length() + indexOf, 33);
            textView.setText(spannableStringBuilder);
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<ForumSuggestModel.Forum> arrayList = this.c;
            if (arrayList == null) {
                return 0;
            }
            return arrayList.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            boolean z = false;
            if (view2 == null) {
                view2 = LayoutInflater.from(this.a.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d088f, (ViewGroup) null);
                bVar = new b(this, null);
                BarImageView barImageView = (BarImageView) view2.findViewById(R.id.forum_avatar);
                bVar.c = barImageView;
                barImageView.setGifIconSupport(false);
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0917fa);
                bVar.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090bbb);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090be7);
                bVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09213d);
                bVar.a = view2.findViewById(R.id.obfuscated_res_0x7f091904);
                view2.setTag(bVar);
            } else {
                bVar = (b) view2.getTag();
            }
            ForumSuggestModel.Forum item = getItem(i);
            if (item == null) {
                return view2;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            String str2 = item.avatar;
            bVar.c.setTag(str2);
            bVar.c.N(str2, 10, false);
            bVar.c.invalidate();
            if (this.b) {
                str = this.a.getPageContext().getPageActivity().getString(R.string.chosen_pb_original_bar, new Object[]{item.forum_name});
            } else {
                str = item.forum_name;
            }
            c(bVar.b, str);
            bVar.c.setTag(item.avatar);
            TextView textView = bVar.d;
            textView.setText(this.a.getPageContext().getString(R.string.obfuscated_res_0x7f0f02e1) + " " + b(item.member_num));
            TextView textView2 = bVar.e;
            textView2.setText(this.a.getPageContext().getString(R.string.text_post) + " " + b(item.thread_num));
            if (!this.b && TextUtils.isEmpty(item.slogan)) {
                bVar.f.setVisibility(8);
            } else {
                bVar.f.setVisibility(0);
                bVar.f.setText(item.slogan);
            }
            if (item.is_offical == 1) {
                bVar.a.setVisibility(0);
                SkinManager.setBackgroundResource(bVar.a, R.drawable.icon_search_official);
            } else {
                bVar.a.setVisibility(8);
            }
            hx4 layoutMode = this.a.getLayoutMode();
            if (skinType == 4) {
                z = true;
            }
            layoutMode.l(z);
            this.a.getLayoutMode().k(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
