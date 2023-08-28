package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.fxa;
import com.baidu.tieba.write.WritePrefixItemLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class i2b extends m2b<i3b> implements o2b, fxa.a, PopupWindow.OnDismissListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public LinearLayout g;
    @Nullable
    public TextView h;
    @Nullable
    public View i;
    @Nullable
    public ImageView j;
    @Nullable
    public fxa k;
    @Nullable
    public us6 l;
    public ArrayList<WritePrefixItemLayout> m;

    @Override // com.baidu.tieba.r2b
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, writeData) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ LinearLayout b;
        public final /* synthetic */ ImageView c;
        public final /* synthetic */ fxa d;
        public final /* synthetic */ i2b e;

        public a(i2b i2bVar, TextView textView, LinearLayout linearLayout, ImageView imageView, fxa fxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i2bVar, textView, linearLayout, imageView, fxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.e = i2bVar;
            this.a = textView;
            this.b = linearLayout;
            this.c = imageView;
            this.d = fxaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13013");
                if (this.e.e != null) {
                    str = this.e.e.getForumId();
                } else {
                    str = "";
                }
                TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setVisibility(0);
                this.b.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.c, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                if (this.e.b != null) {
                    this.e.b.B();
                    this.e.b.p(false);
                }
                jg.l(this.d, view2, 0, BdUtilHelper.dip2px(this.e.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ TextView a;
        public final /* synthetic */ ImageView b;
        public final /* synthetic */ fxa c;
        public final /* synthetic */ i2b d;

        public b(i2b i2bVar, TextView textView, ImageView imageView, fxa fxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i2bVar, textView, imageView, fxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = i2bVar;
            this.a = textView;
            this.b = imageView;
            this.c = fxaVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                StatisticItem statisticItem = new StatisticItem("c13013");
                if (this.d.e != null) {
                    str = this.d.e.getForumId();
                } else {
                    str = "";
                }
                TiebaStatic.log(statisticItem.param("fid", str).param("uid", TbadkCoreApplication.getCurrentAccountId()));
                this.a.setSelected(true);
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.b, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                if (this.d.b != null) {
                    this.d.b.B();
                    this.d.b.p(false);
                }
                jg.l(this.c, view2, 0, BdUtilHelper.dip2px(this.d.a.getPageActivity(), 1.0f));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, i3b.class);
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
        this.m = new ArrayList<>();
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048583, this, i) != null) || i >= this.m.size()) {
            return;
        }
        for (int i2 = 0; i2 < this.m.size(); i2++) {
            this.m.get(i2).b(false);
        }
        this.m.get(i).b(true);
    }

    public final void L(@NonNull WriteData writeData, @NonNull fxa fxaVar, @NonNull TextView textView) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048576, this, writeData, fxaVar, textView) == null) {
            this.m.clear();
            ArrayList<String> prefixs = writeData.getPrefixData().getPrefixs();
            int size = prefixs.size();
            int color = SkinManager.getColor(R.color.CAM_X0105);
            for (int i = 0; i < size; i++) {
                WritePrefixItemLayout writePrefixItemLayout = new WritePrefixItemLayout(this.a.getPageActivity());
                this.m.add(writePrefixItemLayout);
                writePrefixItemLayout.setPrefixText(prefixs.get(i));
                writePrefixItemLayout.setPrefixTextColor(color);
                int i2 = size - 1;
                boolean z2 = true;
                if (i == i2) {
                    z = true;
                } else {
                    z = false;
                }
                writePrefixItemLayout.c(z);
                if (i != i2) {
                    z2 = false;
                }
                writePrefixItemLayout.setDividerStyle(z2);
                fxaVar.a(writePrefixItemLayout);
            }
            fxaVar.c(0);
            textView.setText(prefixs.get(0));
        }
    }

    public final void M(@NonNull TextView textView, @NonNull ImageView imageView, @NonNull fxa fxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, textView, imageView, fxaVar) == null) {
            textView.setOnClickListener(new b(this, textView, imageView, fxaVar));
        }
    }

    @Override // com.baidu.tieba.fxa.a
    public void M0(int i) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) && this.k != null && this.h != null && (writeData = this.e) != null && writeData.getPrefixData() != null) {
            if (i == ListUtils.getCount(this.e.getPrefixData().getPrefixs()) - 1) {
                TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 1));
            } else {
                TiebaStatic.log(new StatisticItem("c13014").param("obj_type", 2));
            }
            this.k.c(i);
            R(i);
            if (this.h.getText() != null) {
                this.h.setText(this.e.getPrefixData().getPrefixs().get(i));
                if (this.h.getText() != null && !this.h.getText().toString().equals(this.a.getString(R.string.write_no_prefix))) {
                    this.e.setPostPrefix(this.h.getText().toString());
                }
            }
            t2b t2bVar = this.b;
            if (t2bVar != null) {
                t2bVar.j();
            }
            jg.d(this.k, this.a.getPageActivity());
        }
    }

    public final void N() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            Q();
            P();
            if (this.h != null && this.g != null && this.i != null && this.j != null && this.k != null) {
                WriteData writeData = this.e;
                if (writeData != null && writeData.getPrefixData() != null) {
                    if (this.e.getPrefixData().getPrefixs().size() > 1) {
                        this.g.setVisibility(0);
                        this.i.setVisibility(0);
                        S();
                        O(this.g, this.h, this.j, this.k);
                        M(this.h, this.j, this.k);
                        L(this.e, this.k, this.h);
                        R(0);
                        return;
                    }
                    this.g.setVisibility(8);
                    this.i.setVisibility(8);
                    return;
                }
                this.g.setVisibility(8);
                this.i.setVisibility(8);
            }
        }
    }

    public final void Q() {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048582, this) == null) && this.a.getPageActivity() != null && (writeData = this.e) != null && writeData.getPrefixData() != null && this.e.getPrefixData().getPrefixs().size() > 1) {
            fxa fxaVar = new fxa(this.a.getPageActivity());
            this.k = fxaVar;
            fxaVar.e(this);
            this.k.d(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f0703f0));
            this.k.setOutsideTouchable(true);
            this.k.setFocusable(true);
            this.k.setOnDismissListener(this);
            this.k.setBackgroundDrawable(SkinManager.getDrawable(R.color.CAM_X0201));
        }
    }

    public final void O(@NonNull LinearLayout linearLayout, @NonNull TextView textView, @NonNull ImageView imageView, @NonNull fxa fxaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048580, this, linearLayout, textView, imageView, fxaVar) == null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(imageView, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            linearLayout.setOnClickListener(new a(this, textView, linearLayout, imageView, fxaVar));
        }
    }

    public final void P() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048581, this) == null) && this.a.getPageActivity() != null && this.l == null) {
            us6 us6Var = new us6(this.a, this.g);
            this.l = us6Var;
            us6Var.L(R.drawable.bg_tip_blue_up_left);
            this.l.o(16);
            this.l.x(true);
            this.l.N(true);
            this.l.Q(BdUtilHelper.getDimens(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070207));
        }
    }

    public final void S() {
        us6 us6Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && (us6Var = this.l) != null) {
            us6Var.U(this.a.getString(R.string.obfuscated_res_0x7f0f18e3), "write_title_prefix_tip_key", true);
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.b();
            us6 us6Var = this.l;
            if (us6Var != null) {
                us6Var.h();
            }
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public boolean g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            fxa fxaVar = this.k;
            if (fxaVar != null && fxaVar.isShowing()) {
                jg.d(this.k, this.a.getPageActivity());
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r2b
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048590, this, i) == null) {
            SkinManager.setBackgroundColor(this.i, R.color.CAM_X0210);
            EMManager.from(this.h).setTextColor(R.color.CAM_X0105).setTextStyle(R.string.F_X02).setBackGroundColor(R.color.CAM_X0201);
            if (this.j != null) {
                fxa fxaVar = this.k;
                if (fxaVar != null && fxaVar.isShowing()) {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_fold12_svg, R.color.CAM_X0105, null);
                } else {
                    SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
                }
            }
        }
    }

    @Override // com.baidu.tieba.o2b
    public void onUpdate(Object obj) {
        WriteData writeData;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, obj) == null) && (obj instanceof SelectForumData) && (writeData = this.e) != null) {
            writeData.setPrefixData(null);
            SelectForumData selectForumData = (SelectForumData) obj;
            PostPrefixData postPrefixData = selectForumData.postPrefix;
            if (postPrefixData != null && !ListUtils.isEmpty(postPrefixData.getPrefixs())) {
                selectForumData.postPrefix.getPrefixs().add(this.a.getString(R.string.write_no_prefix));
                this.e.setPrefixData(selectForumData.postPrefix);
            }
            N();
        }
    }

    @Override // com.baidu.tieba.r2b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054a, viewGroup, false);
            this.c = inflate;
            this.g = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f091d22);
            this.h = (TextView) this.c.findViewById(R.id.obfuscated_res_0x7f091d21);
            this.i = this.c.findViewById(R.id.obfuscated_res_0x7f091d42);
            this.j = (ImageView) this.c.findViewById(R.id.obfuscated_res_0x7f091d43);
            N();
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // android.widget.PopupWindow.OnDismissListener
    public void onDismiss() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048591, this) == null) {
            LinearLayout linearLayout = this.g;
            if (linearLayout != null) {
                linearLayout.setSelected(false);
            }
            if (this.j != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.j, R.drawable.icon_pure_unfold12_svg, R.color.CAM_X0105, null);
            }
            t2b t2bVar = this.b;
            if (t2bVar != null) {
                t2bVar.p(true);
            }
        }
    }
}
