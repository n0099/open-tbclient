package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.TbCheckBox;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.write.write.AtListActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class ci9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final Context a;
    public AtListActivity b;
    public ArrayList<MetaData> c;
    public TbCheckBox.b d;
    public c e;
    public ViewGroup f;
    public boolean g;

    /* loaded from: classes4.dex */
    public interface c {
        void O0(View view2, MetaData metaData);
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

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ ci9 b;

        public a(ci9 ci9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ci9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = ci9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, view2) != null) || this.b.f(this.a)) {
                return;
            }
            this.b.b.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.b.b.getPageContext().getPageActivity(), this.a.getUserId(), this.a.getUserName())));
        }
    }

    /* loaded from: classes4.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public LinearLayout b;
        public HeadImageView c;
        public TextView d;
        public TbCheckBox e;
        public ImageView f;
        public TextView g;
        public TextView h;

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

    public ci9(AtListActivity atListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {atListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.e = null;
        this.f = null;
        this.g = true;
        this.b = atListActivity;
        this.a = atListActivity.getPageContext().getContext();
        this.g = z;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: e */
    public MetaData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ArrayList<MetaData> arrayList = this.c;
            if (arrayList == null || i >= arrayList.size()) {
                return null;
            }
            return this.c.get(i);
        }
        return (MetaData) invokeI.objValue;
    }

    public void g(TbCheckBox.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public void h(ArrayList<MetaData> arrayList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, arrayList) == null) {
            this.c = arrayList;
        }
    }

    public void i(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cVar) == null) {
            this.e = cVar;
        }
    }

    public final b c(Object obj, MetaData metaData) {
        InterceptResult invokeLL;
        b bVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, obj, metaData)) == null) {
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (obj == null) {
                bVar = d(metaData);
            } else {
                bVar = (b) obj;
            }
            bVar.b.setOnClickListener(new a(this, metaData));
            c cVar = this.e;
            if (cVar != null) {
                cVar.O0(bVar.a, metaData);
            }
            String avater = metaData.getAvater();
            bVar.d.setText(metaData.getName_show());
            boolean z = true;
            if (metaData.getIsNearlyAt() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(this.a.getString(R.string.obfuscated_res_0x7f0f02b2));
            } else if (metaData.getIsFollower() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(R.string.obfuscated_res_0x7f0f02b0);
            } else if (metaData.getIsMyFollower() == 1) {
                bVar.g.setVisibility(0);
                bVar.g.setText(R.string.obfuscated_res_0x7f0f02b1);
            } else {
                bVar.g.setVisibility(8);
            }
            bVar.e.setTagData(metaData);
            bVar.c.setTag(avater);
            bVar.c.setImageBitmap(null);
            if (this.g) {
                bVar.e.setVisibility(0);
            } else {
                bVar.e.setVisibility(8);
            }
            if (f(metaData)) {
                bVar.c.setDefaultResource(R.drawable.icon_at_all_user);
                avater = "";
            } else {
                bVar.c.setDefaultResource(0);
            }
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            bVar.c.K(avater, 12, false);
            if (this.b.u2(metaData.getUserId()) && this.b.M) {
                bVar.e.setVisibility(8);
                bVar.f.setVisibility(0);
                bVar.h.setText(R.string.obfuscated_res_0x7f0f02af);
                bVar.h.setVisibility(0);
                bVar.g.setVisibility(8);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(bVar.f, R.drawable.icon_pure_list_arrow16_right_svg, R.color.CAM_X0109, SvgManager.SvgResourceStateType.NORMAL);
            } else {
                bVar.e.setVisibility(0);
                bVar.f.setVisibility(8);
                bVar.h.setVisibility(8);
            }
            qv4 layoutMode = this.b.getPageContext().getLayoutMode();
            if (skinType != 1) {
                z = false;
            }
            layoutMode.l(z);
            this.b.getPageContext().getLayoutMode().k(bVar.a);
            return bVar;
        }
        return (b) invokeLL.objValue;
    }

    public final b d(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, metaData)) == null) {
            b bVar = new b(null);
            View inflate = LayoutInflater.from(this.a).inflate(R.layout.invite_friend_list_item, (ViewGroup) null);
            bVar.a = inflate;
            HeadImageView headImageView = (HeadImageView) inflate.findViewById(R.id.obfuscated_res_0x7f091a9b);
            bVar.c = headImageView;
            headImageView.setIsRound(true);
            UtilHelper.showHeadImageViewBigV(bVar.c, metaData);
            bVar.b = (LinearLayout) bVar.a.findViewById(R.id.photo_box);
            bVar.d = (TextView) bVar.a.findViewById(R.id.txt_user_name);
            TextView textView = (TextView) bVar.a.findViewById(R.id.label_user);
            bVar.g = textView;
            p15 d = p15.d(textView);
            d.v(R.color.CAM_X0108);
            d.z(R.dimen.T_X10);
            d.n(R.string.J_X04);
            d.l(R.dimen.L_X01);
            d.k(R.color.CAM_X0111);
            TextView textView2 = (TextView) bVar.a.findViewById(R.id.label_bot);
            bVar.h = textView2;
            p15 d2 = p15.d(textView2);
            d2.v(R.color.CAM_X0201);
            d2.z(R.dimen.T_X10);
            d2.n(R.string.J_X04);
            d2.l(R.dimen.L_X01);
            d2.f(R.color.CAM_X0334);
            bVar.h.setAlpha(0.7f);
            bVar.f = (ImageView) bVar.a.findViewById(R.id.bot_select_arrow);
            TbCheckBox tbCheckBox = (TbCheckBox) bVar.a.findViewById(R.id.ckb_select);
            bVar.e = tbCheckBox;
            tbCheckBox.setBackgroundDrawableIdIsWebP(true);
            bVar.e.setBackgroundDrawableId(R.drawable.icon_pure_strok324_select, R.drawable.icon_pure_strok324);
            TbCheckBox.b bVar2 = this.d;
            if (bVar2 != null) {
                bVar.e.setStatedChangedListener(bVar2);
            }
            bVar.a.setTag(bVar);
            return bVar;
        }
        return (b) invokeL.objValue;
    }

    public final boolean f(MetaData metaData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, metaData)) == null) {
            if (AtSelectData.AT_ALL_FAKE_UID.equals(metaData.getUserId()) && AtSelectData.AT_ALL_FAKE_NAME.equals(metaData.getName_show()) && AtSelectData.AT_ALL_FAKE_PORTRAIT.equals(metaData.getPortrait())) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            ArrayList<MetaData> arrayList = this.c;
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
        Object obj;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            if (this.f == null) {
                this.f = viewGroup;
            }
            MetaData item = getItem(i);
            if (item != null) {
                if (view2 != null) {
                    obj = view2.getTag();
                } else {
                    obj = null;
                }
                bVar = c(obj, item);
            } else {
                bVar = null;
            }
            if (bVar == null) {
                return null;
            }
            return bVar.a;
        }
        return (View) invokeILL.objValue;
    }
}
