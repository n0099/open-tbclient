package com.baidu.tieba;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextImageInfo;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class ck8 extends dk8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public zx7 S;
    public View T;
    public View U;
    public View V;
    public View W;
    public TbImageView X;
    public LinearLayout Y;
    public TbImageView Z;
    public TextView a0;
    public View b0;
    public ImageView c0;
    public TextView d0;
    public TextView e0;
    public TbImageView f0;
    public View g0;
    public TextView h0;
    public TextView i0;
    public LinearLayout j0;
    public PlayVoiceBntNew q0;

    public final void E0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    public final int[] F0(int i, int i2, int i3) {
        InterceptResult invokeIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIII = interceptable.invokeIII(1048583, this, i, i2, i3)) == null) {
            int[] iArr = new int[2];
            iArr[0] = i3;
            float f = (i * 1.0f) / (i3 * 1.0f);
            iArr[1] = (int) (f <= 1.0f ? i2 / f : i2 * f);
            return iArr;
        }
        return (int[]) invokeIII.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ck8(Context context, boolean z, int i, zx7 zx7Var) {
        super(context, z, i);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z), Integer.valueOf(i), zx7Var};
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
        this.S = zx7Var;
        this.T = this.b.findViewById(R.id.obfuscated_res_0x7f0918b1);
        this.U = this.b.findViewById(R.id.obfuscated_res_0x7f0918af);
        this.V = this.b.findViewById(R.id.obfuscated_res_0x7f0918ae);
        this.W = this.b.findViewById(R.id.obfuscated_res_0x7f0918b0);
        this.X = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b2);
        this.Y = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f0918ba);
        TbImageView tbImageView = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b9);
        this.Z = tbImageView;
        tbImageView.setPlaceHolder(2);
        this.Z.setConrers(15);
        this.Z.setRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10));
        this.Z.setGifIconSupport(false);
        this.Z.setLongIconSupport(false);
        this.a0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091792);
        this.b0 = this.b.findViewById(R.id.obfuscated_res_0x7f0918b8);
        this.c0 = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f0918b3);
        this.d0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091aa0);
        this.e0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a9d);
        this.f0 = (TbImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091a9c);
        this.g0 = this.b.findViewById(R.id.obfuscated_res_0x7f091a9f);
        this.h0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a9e);
        this.i0 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091a9a);
        this.j0 = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091a99);
        this.q0 = (PlayVoiceBntNew) this.b.findViewById(R.id.obfuscated_res_0x7f091a9b);
        z0(context, zx7Var.c().X());
        E0();
        h0(2);
    }

    public final void A0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            int f = this.S.f();
            if (f != 0) {
                if (f != 11) {
                    if (f == 40) {
                        this.b0.setVisibility(0);
                        this.c0.setVisibility(0);
                        this.c0.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808da));
                        TBSelector.makeDrawableSelector().setShape(0).gradientLinear(R.color.CAM_X0601, R.color.CAM_X0604).cornerRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10)).into(this.b0);
                        this.Z.K(this.S.e(), 10, false);
                        return;
                    }
                    return;
                }
                this.Z.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808d9));
                this.Z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            } else if (!StringUtils.isNull(this.S.e())) {
                this.Z.K(this.S.e(), 10, false);
            } else {
                this.Z.setImageDrawable(TbadkCoreApplication.getInst().getResources().getDrawable(R.drawable.obfuscated_res_0x7f0808d8));
                this.Z.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }
        }
    }

    @Override // com.baidu.tieba.dk8
    public void m0() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048585, this) != null) || this.S == null) {
            return;
        }
        this.T.setBackgroundColor(SkinManager.getColor(R.color.CAM_X0209));
        SkinManager.setBackgroundShapeDrawable(this.W, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds31), R.color.CAM_X0211, R.color.CAM_X0211);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
        gradientDrawable.setColor(SkinManager.getColor(R.color.CAM_X0206));
        this.Y.setBackgroundDrawable(gradientDrawable);
        SkinManager.setViewTextColor(this.a0, (int) R.color.CAM_X0107);
        this.a0.setText(this.S.b());
        A0();
        SkinManager.setBackgroundColor(this.g0, R.color.CAM_X0109);
        String name_show = this.S.c().s().getName_show();
        if (name_show.length() > 10) {
            name_show = name_show.substring(0, 10) + StringHelper.STRING_MORE;
        }
        this.h0.setText(name_show);
        SkinManager.setViewTextColor(this.h0, (int) R.color.CAM_X0109);
        SkinManager.setViewTextColor(this.d0, (int) R.color.CAM_X0304);
        SkinManager.setViewTextColor(this.e0, (int) R.color.CAM_X0105);
        this.f0.setImageBitmap(this.S.d());
        SkinManager.setImageResource(this.X, R.drawable.obfuscated_res_0x7f080fb4);
        j0(false);
        super.m0();
    }

    @Override // com.baidu.tieba.dk8
    public View B() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return LayoutInflater.from(TbadkCoreApplication.getInst().getContext()).inflate(R.layout.obfuscated_res_0x7f0d06f7, (ViewGroup) null);
        }
        return (View) invokeV.objValue;
    }

    public final TbImageView B0(Context context, String str, TbRichTextImageInfo tbRichTextImageInfo, boolean z, boolean z2) {
        InterceptResult invokeCommon;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{context, str, tbRichTextImageInfo, Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) {
            int[] F0 = F0(tbRichTextImageInfo.getWidth(), tbRichTextImageInfo.getHeight(), yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds981));
            TbImageView tbImageView = new TbImageView(context);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(F0[0], F0[1]);
            if (!z) {
                layoutParams.setMargins(0, yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), 0, 0);
            }
            tbImageView.setLayoutParams(layoutParams);
            tbImageView.setScaleType(ImageView.ScaleType.FIT_XY);
            if (tbRichTextImageInfo.I()) {
                tbImageView.setLongIconSupport(true);
                tbImageView.setIsLongPic(true);
            }
            tbImageView.setConrers(15);
            tbImageView.setRadius(yi.g(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            if (z2) {
                i = 17;
            } else {
                i = 18;
            }
            tbImageView.K(str, i, false);
            return tbImageView;
        }
        return (TbImageView) invokeCommon.objValue;
    }

    public final String C0(TbRichTextImageInfo tbRichTextImageInfo, sm5 sm5Var) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, tbRichTextImageInfo, sm5Var)) == null) {
            if (sm5Var.c()) {
                return tbRichTextImageInfo.z();
            }
            return tbRichTextImageInfo.B();
        }
        return (String) invokeLL.objValue;
    }

    @Override // com.baidu.tieba.dk8
    public ShareItem D(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            ShareItem shareItem = this.B.get(1);
            if (shareItem == null) {
                shareItem = new ShareItem();
            }
            shareItem.o0 = false;
            shareItem.n0 = false;
            shareItem.w = "";
            shareItem.h0 = 1;
            shareItem.i(D0(this.U));
            shareItem.g();
            this.B.put(1, shareItem);
            return super.D(i);
        }
        return (ShareItem) invokeI.objValue;
    }

    public final Bitmap D0(View view2) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, view2)) == null) {
            if (view2 == null) {
                return null;
            }
            Bitmap createBitmap = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_4444);
            createBitmap.eraseColor(SkinManager.getColor(R.color.CAM_X0206));
            view2.draw(new Canvas(createBitmap));
            return createBitmap;
        }
        return (Bitmap) invokeL.objValue;
    }

    @Override // com.baidu.tieba.dk8
    public void k0(Window window) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, window) == null) {
            window.setLayout(-1, -1);
        }
    }

    public final void y0(Context context, List<TbRichTextImageInfo> list) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, context, list) == null) {
            for (int i = 0; i < list.size() && i != 9; i++) {
                LinearLayout linearLayout = this.j0;
                String C0 = C0(list.get(i), this.S.a());
                TbRichTextImageInfo tbRichTextImageInfo = list.get(i);
                if (i == 0) {
                    z = true;
                } else {
                    z = false;
                }
                linearLayout.addView(B0(context, C0, tbRichTextImageInfo, z, this.S.a().s));
            }
        }
    }

    public void z0(Context context, TbRichText tbRichText) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048587, this, context, tbRichText) == null) && tbRichText != null && tbRichText.B() != null && !tbRichText.B().isEmpty()) {
            Iterator<TbRichTextData> it = tbRichText.B().iterator();
            while (it.hasNext()) {
                TbRichTextData next = it.next();
                if (next != null) {
                    int type = next.getType();
                    if (type != 1) {
                        if (type == 512) {
                            this.q0.setVoiceModel((VoiceData.VoiceModel) next.P().B());
                            if (this.i0.getVisibility() == 0 || this.j0.getVisibility() == 0) {
                                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.q0.getLayoutParams();
                                if (this.i0.getVisibility() == 0 && this.j0.getVisibility() == 8) {
                                    layoutParams.topMargin = yi.g(context, R.dimen.tbds39);
                                } else {
                                    layoutParams.topMargin = yi.g(context, R.dimen.tbds42);
                                }
                                this.q0.setLayoutParams(layoutParams);
                            }
                            this.q0.setVisibility(0);
                        }
                    } else if (this.i0.getVisibility() == 8) {
                        SkinManager.setViewTextColor(this.i0, (int) R.color.CAM_X0105);
                        this.i0.setText(next.J());
                        this.i0.setVisibility(0);
                    }
                }
            }
            if (!tbRichText.D().isEmpty()) {
                if (this.i0.getVisibility() == 0) {
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.j0.getLayoutParams();
                    layoutParams2.topMargin = yi.g(context, R.dimen.tbds37);
                    this.j0.setLayoutParams(layoutParams2);
                }
                this.j0.setVisibility(0);
                y0(context, tbRichText.D());
            }
        }
    }
}
