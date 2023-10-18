package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BDLayoutMode;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.eu7;
import com.baidu.tieba.gift.myGiftList.MyGiftListActivity;
import com.baidu.tieba.wallet.CurrencySwitchUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class fu7 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public List<eu7.a> b;
    public MyGiftListActivity c;
    public boolean d;
    public NoDataView e;
    public boolean f;
    public int g;
    public View.OnClickListener h;

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048582, this, i)) == null) ? i : invokeI.longValue;
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fu7 a;

        public a(fu7 fu7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fu7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fu7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (BdNetTypeUtil.isNetWorkAvailable()) {
                    this.a.c.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(TbadkApplication.getInst().getContext(), String.valueOf((Long) view2.getTag(R.id.tag_first)), (String) view2.getTag(R.id.tag_second))));
                    return;
                }
                this.a.c.showToast(R.string.obfuscated_res_0x7f0f0e4f);
            }
        }
    }

    /* loaded from: classes6.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public HeadImageView c;
        public TextView d;
        public TextView e;
        public TextView f;
        public TextView g;
        public TextView h;
        public TextView i;

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

    public fu7(MyGiftListActivity myGiftListActivity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {myGiftListActivity, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = 1;
        this.d = false;
        this.g = -1;
        this.h = new a(this);
        this.c = myGiftListActivity;
        this.f = z;
    }

    public final void b(View view2) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            int skinType = TbadkApplication.getInst().getSkinType();
            BDLayoutMode layoutMode = this.c.getLayoutMode();
            if (skinType == 4) {
                z = true;
            } else {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.getLayoutMode().onModeChanged(view2);
        }
    }

    public final View c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            NoDataViewFactory.c cVar = null;
            View inflate = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.buy_no_face_item, (ViewGroup) null);
            NoDataViewFactory.c a2 = NoDataViewFactory.c.a(new NoDataViewFactory.b(this.c.getResources().getString(R.string.send_gift), this.c.V0()));
            this.c.getResources().getDimension(R.dimen.tbds200);
            this.c.getResources().getDimension(R.dimen.obfuscated_res_0x7f07036f);
            String Z0 = this.c.Z0();
            this.c.getPageContext().getString(R.string.no_gift);
            String string = this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0486);
            boolean z = true;
            String format = String.format(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f1392), Z0);
            Activity pageActivity = this.c.getPageContext().getPageActivity();
            NoDataViewFactory.d a3 = NoDataViewFactory.d.a(NoDataViewFactory.ImgType.NODATA);
            if (!this.f) {
                string = format;
            }
            NoDataViewFactory.e d = NoDataViewFactory.e.d(null, string);
            if (!this.f && TbadkApplication.getInst().isGiftSwitchOn()) {
                cVar = a2;
            }
            this.e = NoDataViewFactory.a(pageActivity, inflate, a3, d, cVar);
            int skinType = TbadkApplication.getInst().getSkinType();
            BDLayoutMode layoutMode = this.c.getLayoutMode();
            if (skinType != 4) {
                z = false;
            }
            layoutMode.setNightMode(z);
            this.c.getLayoutMode().onModeChanged(inflate);
            this.e.f(this.c.getPageContext(), skinType);
            this.e.setVisibility(0);
            return inflate;
        }
        return (View) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: d */
    public eu7.a getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            if (this.d) {
                return null;
            }
            int itemId = (int) getItemId(i);
            List<eu7.a> list = this.b;
            if (list == null || list.size() == 0 || itemId < 0 || itemId >= this.b.size()) {
                return null;
            }
            return this.b.get(itemId);
        }
        return (eu7.a) invokeI.objValue;
    }

    public void e(List<eu7.a> list, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, list, i) == null) {
            if (list != null && list.size() > 0) {
                this.d = false;
            } else {
                this.d = true;
            }
            this.b = list;
            this.g = i;
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (this.d) {
                return 1;
            }
            List<eu7.a> list = this.b;
            if (list != null && list.size() != 0) {
                return this.b.size();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.a;
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        b bVar;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048583, this, i, view2, viewGroup)) == null) {
            if (this.d) {
                return c();
            }
            if (view2 != null && view2.getTag(R.id.tag_first) != null) {
                bVar = (b) view2.getTag(R.id.tag_first);
            } else {
                view2 = LayoutInflater.from(this.c.getPageContext().getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0675, viewGroup, false);
                bVar = new b(null);
                TbImageView tbImageView = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911dd);
                bVar.a = tbImageView;
                tbImageView.setRadius(BdUtilHelper.dip2px(this.c.getBaseContext(), 25.0f));
                bVar.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f0911df);
                HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f0911dc);
                bVar.c = headImageView;
                headImageView.setRadius(BdUtilHelper.dip2px(this.c.getBaseContext(), 50.0f));
                bVar.c.setOnClickListener(this.h);
                bVar.c.setPlaceHolder(1);
                bVar.d = (TextView) view2.findViewById(R.id.user_name);
                bVar.h = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e58);
                bVar.g = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e66);
                bVar.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090e57);
                bVar.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092570);
                bVar.i = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091a81);
                view2.setTag(R.id.tag_first, bVar);
            }
            if (!this.f) {
                bVar.e.setVisibility(8);
                bVar.i.setVisibility(8);
            } else {
                bVar.i.setVisibility(0);
            }
            eu7.a item = getItem(i);
            if (item != null) {
                if (this.c.j == 1) {
                    bVar.c.startLoad(item.c, 12, false);
                    int i2 = item.h;
                    if (i2 == 1) {
                        bVar.a.setVisibility(0);
                        bVar.a.setImageResource(R.drawable.icon_frs_no1);
                        bVar.b.setVisibility(8);
                    } else if (i2 == 2) {
                        bVar.a.setVisibility(0);
                        bVar.a.setImageResource(R.drawable.icon_frs_no2);
                        bVar.b.setVisibility(8);
                    } else if (i2 == 3) {
                        bVar.a.setVisibility(0);
                        bVar.a.setImageResource(R.drawable.icon_frs_no3);
                        bVar.b.setVisibility(8);
                    } else {
                        bVar.a.setVisibility(8);
                        bVar.b.setVisibility(0);
                        TextView textView = bVar.b;
                        textView.setText(item.h + "");
                    }
                } else {
                    bVar.c.startLoad(item.d, 10, false);
                    bVar.a.setVisibility(8);
                    bVar.b.setVisibility(8);
                }
                bVar.c.setDrawBorder(false);
                TextView textView2 = bVar.d;
                if (TextUtils.isEmpty(item.i)) {
                    str = item.b;
                } else {
                    str = item.i;
                }
                textView2.setText(str);
                bVar.c.setTag(R.id.tag_first, Long.valueOf(item.a));
                bVar.c.setTag(R.id.tag_second, item.b);
                bVar.f.setText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f139a));
                TextView textView3 = bVar.g;
                textView3.setText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0903) + item.g);
                if (item.f < 1) {
                    bVar.h.setVisibility(8);
                } else {
                    TextView textView4 = bVar.h;
                    textView4.setText(this.c.getPageContext().getString(R.string.obfuscated_res_0x7f0f0d2d) + item.f);
                    bVar.h.setVisibility(0);
                }
                String formatTime = StringHelper.getFormatTime(item.e * 1000);
                bVar.e.setText(formatTime);
                if (CurrencySwitchUtil.isYyIsConvert(this.g)) {
                    bVar.e.setVisibility(8);
                    bVar.g.setText(formatTime);
                    SkinManager.setViewTextColor(bVar.g, R.color.CAM_X0109, 1);
                } else {
                    SkinManager.setViewTextColor(bVar.g, R.color.CAM_X0301, 1);
                }
            }
            b(view2);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
