package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.view.RoundRelativeLayout;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class ag8 extends zf8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context R;
    public yi8 S;
    public RoundRelativeLayout T;
    public TbImageView U;
    public TextView V;
    public TextView W;
    public RoundRelativeLayout X;
    public TbImageView Y;
    public TextView Z;
    public TextView a0;
    public ImageView b0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag8(Context context, boolean z, int i, yi8 yi8Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), yi8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], ((Boolean) objArr2[1]).booleanValue(), ((Integer) objArr2[2]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.R = context;
        this.S = yi8Var;
        y0();
        g0(2);
    }

    @Override // com.baidu.tieba.zf8
    public View A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d07e6, (ViewGroup) null) : (View) invokeV.objValue;
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            int k = (ri.k(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (k * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.T.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = k;
                layoutParams.height = i;
            }
            this.T.setLayoutParams(layoutParams);
            int i2 = (k * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.U.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.U.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.zf8
    public ShareItem C(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            ShareItem shareItem = this.B.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.n0 = false;
            shareItem.m0 = false;
            shareItem.v = "";
            shareItem.g0 = 1;
            shareItem.i(x0(this.T));
            shareItem.g();
            this.B.put(1, shareItem);
            return super.C(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.zf8
    public void j0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    @Override // com.baidu.tieba.zf8
    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.S != null) {
                z0(this.U);
                this.Y.setImageBitmap(this.S.a());
                this.V.setText(this.S.d());
            }
            WebPManager.setPureDrawable(this.b0, R.drawable.obfuscated_res_0x7f0809c1, R.color.CAM_X0101, null);
            ns4.d(this.Z).v(R.color.CAM_X0101);
            ns4.d(this.a0).v(R.color.CAM_X0101);
            ns4 d = ns4.d(this.V);
            d.A(R.string.F_X02);
            d.v(R.color.CAM_X0102);
            ns4.d(this.W).v(R.color.CAM_X0103);
            super.l0();
        }
    }

    public final Bitmap x0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    public final void y0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            this.T = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091f19);
            this.U = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f18);
            this.X = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09128c);
            this.Y = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091f1c);
            this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091f1b);
            this.W = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091f1a);
            this.Z = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0923b1);
            this.a0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f0923b0);
            this.b0 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090eee);
            A0();
            this.T.setRoundLayoutRadius(ls4.y(R.string.J_X06));
            this.X.setRoundLayoutRadius(ls4.y(R.string.J_X04));
        }
    }

    public final void z0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, tbImageView) == null) || tbImageView == null) {
            return;
        }
        if (this.S.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a63);
        } else if (this.S.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080bd8);
        } else if (this.S.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a64);
        } else if (this.S.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080a67);
        } else {
            tbImageView.K(this.S.c(), 10, false);
        }
    }
}
