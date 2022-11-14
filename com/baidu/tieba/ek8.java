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
public class ek8 extends dk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context S;
    public dn8 T;
    public RoundRelativeLayout U;
    public TbImageView V;
    public TextView W;
    public TextView X;
    public RoundRelativeLayout Y;
    public TbImageView Z;
    public TextView a0;
    public TextView b0;
    public ImageView c0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ek8(Context context, boolean z, int i, dn8 dn8Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), dn8Var};
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
        this.S = context;
        this.T = dn8Var;
        z0();
        h0(2);
    }

    public final void A0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048576, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        if (this.T.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080ab1);
        } else if (this.T.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080c27);
        } else if (this.T.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080ab2);
        } else if (this.T.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080ab5);
        } else {
            tbImageView.K(this.T.c(), 10, false);
        }
    }

    @Override // com.baidu.tieba.dk8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d081a, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            int l = (yi.l(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (l * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.U.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = l;
                layoutParams.height = i;
            }
            this.U.setLayoutParams(layoutParams);
            int i2 = (l * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.V.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.V.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.dk8
    public ShareItem D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048579, this, i)) == null) {
            ShareItem shareItem = this.B.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.o0 = false;
            shareItem.n0 = false;
            shareItem.w = "";
            shareItem.h0 = 1;
            shareItem.i(y0(this.U));
            shareItem.g();
            this.B.put(1, shareItem);
            return super.D(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.dk8
    public void k0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final Bitmap y0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dk8
    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.T != null) {
                A0(this.V);
                this.Z.setImageBitmap(this.T.a());
                this.W.setText(this.T.d());
            }
            WebPManager.setPureDrawable(this.c0, R.drawable.obfuscated_res_0x7f0809fd, R.color.CAM_X0101, null);
            pw4.d(this.a0).v(R.color.CAM_X0101);
            pw4.d(this.b0).v(R.color.CAM_X0101);
            pw4 d = pw4.d(this.W);
            d.A(R.string.F_X02);
            d.v(R.color.CAM_X0102);
            pw4.d(this.X).v(R.color.CAM_X0103);
            super.m0();
        }
    }

    public final void z0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.U = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091fc3);
            this.V = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091fc2);
            this.Y = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0912de);
            this.Z = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091fc6);
            this.W = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091fc5);
            this.X = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091fc4);
            this.a0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09245d);
            this.b0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09245c);
            this.c0 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090f39);
            B0();
            this.U.setRoundLayoutRadius(nw4.z(R.string.J_X06));
            this.Y.setRoundLayoutRadius(nw4.z(R.string.J_X04));
        }
    }
}
