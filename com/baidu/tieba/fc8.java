package com.baidu.tieba;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.pb.video.PbVideoFullUserInfoLikeButton;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class fc8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public View b;
    public HeadImageView c;
    public TextView d;
    public RelativeLayout e;
    public TextView f;
    public ImageView g;
    public PbVideoFullUserInfoLikeButton h;
    public ec8 i;
    public View.OnClickListener j;
    public LinearLayout k;
    public View.OnClickListener l;

    public void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ fc8 a;

        public a(fc8 fc8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fc8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = fc8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2 != this.a.c && view2 != this.a.d && view2 != this.a.g) {
                    return;
                }
                this.a.l(view2);
            }
        }
    }

    public fc8(TbPageContext tbPageContext, FrameLayout frameLayout) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, frameLayout};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
        this.a = tbPageContext;
        this.b = g(tbPageContext);
        h();
        frameLayout.addView(this.b);
    }

    public final View g(TbPageContext<?> tbPageContext) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext)) == null) {
            if (tbPageContext == null) {
                return null;
            }
            return LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d090d, (ViewGroup) null);
        }
        return (View) invokeL.objValue;
    }

    public void j(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = this.h;
            if (pbVideoFullUserInfoLikeButton != null) {
                pbVideoFullUserInfoLikeButton.g(i);
            }
            SkinManager.setViewTextColor(this.f, (int) R.color.CAM_X0101);
            TextView textView = this.d;
            if (textView != null) {
                SkinManager.setViewTextColor(textView, (int) R.color.CAM_X0101);
            }
            ImageView imageView = this.g;
            if (imageView != null) {
                SkinManager.setBackgroundResource(imageView, R.drawable.icon_weiba);
            }
        }
    }

    public final void l(View view2) {
        View.OnClickListener onClickListener;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048583, this, view2) == null) && (onClickListener = this.j) != null) {
            onClickListener.onClick(view2);
        }
    }

    public void n(float f) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
            this.e.setAlpha(f);
        }
    }

    public void o(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, onClickListener) == null) {
            this.j = onClickListener;
        }
    }

    public final void e(PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, postData) == null) {
            this.g.setVisibility(8);
            this.c.setUserId(postData.r().getUserId());
            this.c.setUserName(postData.r().getUserName());
            this.c.setIsBigV(postData.r().isBigV());
            this.d.setText(postData.r().getName_show());
            this.d.setTag(postData.r().getUserId());
            this.c.K(postData.r().getAvater(), 28, false);
            this.i.n(postData.r());
        }
    }

    public View f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.e;
        }
        return (View) invokeV.objValue;
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.e = (RelativeLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091889);
            HeadImageView headImageView = (HeadImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091888);
            this.c = headImageView;
            headImageView.setOnClickListener(this.l);
            LinearLayout linearLayout = (LinearLayout) this.b.findViewById(R.id.obfuscated_res_0x7f091887);
            this.k = linearLayout;
            SkinManager.setBackgroundResource(linearLayout, R.drawable.video_author_bg);
            TextView textView = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f09188a);
            this.d = textView;
            textView.setOnClickListener(this.l);
            TextView textView2 = (TextView) this.b.findViewById(R.id.obfuscated_res_0x7f091884);
            this.f = textView2;
            textView2.setOnClickListener(this.l);
            this.g = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f091885);
            PbVideoFullUserInfoLikeButton pbVideoFullUserInfoLikeButton = (PbVideoFullUserInfoLikeButton) this.b.findViewById(R.id.obfuscated_res_0x7f091886);
            this.h = pbVideoFullUserInfoLikeButton;
            pbVideoFullUserInfoLikeButton.setTextSize(0, zi.g(this.a.getPageActivity(), R.dimen.tbds30));
            this.i = new ec8(this.a, this.h);
            this.c.setRadius(zi.g(this.a.getPageActivity(), R.dimen.obfuscated_res_0x7f070225));
        }
    }

    public final boolean i(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, threadData)) == null) {
            if (threadData != null && threadData.getAuthor() != null && threadData.getAuthor().getUserId() != null) {
                return TextUtils.equals(TbadkCoreApplication.getCurrentAccount(), threadData.getAuthor().getUserId());
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void m(PostData postData, ThreadData threadData, m58 m58Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData, threadData, m58Var) == null) {
            this.h.setVisibility(0);
            this.f.setVisibility(8);
            e(postData);
            if (i(threadData)) {
                this.f.setVisibility(8);
                this.h.setVisibility(8);
            }
        }
    }
}
