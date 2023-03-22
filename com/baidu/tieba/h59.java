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
/* loaded from: classes4.dex */
public class h59 extends g59 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context M;
    public t99 N;
    public RoundRelativeLayout O;
    public TbImageView P;
    public TextView Q;
    public TextView R;
    public RoundRelativeLayout S;
    public TbImageView T;
    public TextView U;
    public TextView V;
    public ImageView W;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h59(Context context, boolean z, int i, t99 t99Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), t99Var};
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
        this.M = context;
        this.N = t99Var;
        C0();
        i0(2);
    }

    public final Bitmap B0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.g59
    public void l0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final void C0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            this.O = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f09214b);
            this.P = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09214a);
            this.S = (RoundRelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091412);
            this.T = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09214e);
            this.Q = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09214d);
            this.R = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09214c);
            this.U = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092609);
            this.V = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f092608);
            this.W = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f09106a);
            E0();
            this.O.setRoundLayoutRadius(l15.B(R.string.J_X06));
            this.S.setRoundLayoutRadius(l15.B(R.string.J_X04));
        }
    }

    @Override // com.baidu.tieba.g59
    public View D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d0872, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final void D0(TbImageView tbImageView) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, tbImageView) != null) || tbImageView == null) {
            return;
        }
        if (this.N.b() == 1) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080afe);
        } else if (this.N.b() == 2) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080c79);
        } else if (this.N.b() == 3) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080aff);
        } else if (this.N.b() == 4) {
            SkinManager.setImageResource(tbImageView, R.drawable.obfuscated_res_0x7f080b02);
        } else {
            tbImageView.M(this.N.c(), 10, false);
        }
    }

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int l = (hi.l(TbadkCoreApplication.getInst()) * 879) / 1076;
            int i = (l * 1342) / 879;
            ViewGroup.LayoutParams layoutParams = this.O.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = l;
                layoutParams.height = i;
            }
            this.O.setLayoutParams(layoutParams);
            int i2 = (l * 416) / 879;
            ViewGroup.LayoutParams layoutParams2 = this.P.getLayoutParams();
            if (layoutParams2 != null) {
                layoutParams2.width = i2;
                layoutParams2.height = i2;
            }
            this.P.setLayoutParams(layoutParams2);
        }
    }

    @Override // com.baidu.tieba.g59
    public ShareItem G(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            ShareItem shareItem = this.z.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.r0 = false;
            shareItem.q0 = false;
            shareItem.w = "";
            shareItem.k0 = 1;
            shareItem.j(B0(this.O));
            shareItem.h();
            this.z.put(1, shareItem);
            return super.G(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    @Override // com.baidu.tieba.g59
    public void p0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.b.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0202));
            if (this.N != null) {
                D0(this.P);
                this.T.setImageBitmap(this.N.a());
                this.Q.setText(this.N.d());
            }
            WebPManager.setPureDrawable(this.W, R.drawable.obfuscated_res_0x7f080a4d, R.color.CAM_X0101, null);
            n15.d(this.U).w(R.color.CAM_X0101);
            n15.d(this.V).w(R.color.CAM_X0101);
            n15 d = n15.d(this.Q);
            d.B(R.string.F_X02);
            d.w(R.color.CAM_X0102);
            n15.d(this.R).w(R.color.CAM_X0103);
            super.p0();
        }
    }
}
