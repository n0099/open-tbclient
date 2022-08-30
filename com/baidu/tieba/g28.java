package com.baidu.tieba;

import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.PraiseData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.pb.pb.main.PbFragment;
import com.baidu.tieba.pbextra.adapter.PbInterviewLiveNormalItemViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class g28 extends iw7<PostData, PbInterviewLiveNormalItemViewHolder> implements View.OnClickListener, bv7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public int g;
    public boolean h;
    public boolean i;
    public mt7 j;
    public boolean k;
    public View.OnClickListener l;
    public TbRichTextView.y m;
    public ou7 n;
    public View.OnLongClickListener o;
    public int p;
    public int q;
    public boolean r;
    public final boolean s;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a(g28 g28Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g28Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g28(PbFragment pbFragment, BdUniqueId bdUniqueId) {
        super(pbFragment, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {pbFragment, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a18) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        boolean z = false;
        this.g = 0;
        this.h = true;
        this.i = true;
        this.j = null;
        this.k = true;
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = null;
        this.r = false;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 14 && i3 <= 16) {
            z = true;
        }
        this.s = z;
        t(pbFragment);
    }

    @Override // com.baidu.tieba.bv7
    public void c(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.h = z;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void d(View.OnLongClickListener onLongClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, onLongClickListener) == null) {
            this.o = onLongClickListener;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void e(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, onClickListener) == null) {
            this.l = onClickListener;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void f(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.k = z;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void k(View.OnClickListener onClickListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, onClickListener) == null) {
        }
    }

    @Override // com.baidu.tieba.bv7
    public void l(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.g = i;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void n(TbRichTextView.y yVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, yVar) == null) {
            this.m = yVar;
        }
    }

    @Override // com.baidu.tieba.bv7
    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, view2) == null) {
        }
    }

    @Override // com.baidu.tieba.iw7, com.baidu.tieba.cn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        y(i, view2, viewGroup, (PostData) obj, (PbInterviewLiveNormalItemViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.bv7
    public void q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
        }
    }

    @Override // com.baidu.tieba.bv7
    public void r(mt7 mt7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, mt7Var) == null) {
            this.j = mt7Var;
        }
    }

    @Override // com.baidu.tieba.iw7
    public void t(a18 a18Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, a18Var) == null) {
            super.t(a18Var);
            if (a18Var != null) {
                this.p = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070201);
                this.q = ri.k(this.mContext) - TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.obfuscated_res_0x7f070253);
            }
        }
    }

    public final void u(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, pbInterviewLiveNormalItemViewHolder, postData) == null) {
            if (!TextUtils.isEmpty(postData.t()) && this.h) {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(this.l);
            } else {
                pbInterviewLiveNormalItemViewHolder.b.setOnClickListener(null);
            }
            pbInterviewLiveNormalItemViewHolder.b.setTextViewCheckSelection(false);
            pbInterviewLiveNormalItemViewHolder.b.setTextViewOnClickListener(new a(this));
        }
    }

    public final void v(TbRichTextView tbRichTextView, int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048591, this, tbRichTextView, i) == null) || tbRichTextView == null) {
            return;
        }
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) tbRichTextView.getLayoutParams();
        layoutParams.leftMargin = i;
        tbRichTextView.getLayoutStrategy().q(this.q - (i - this.p));
        tbRichTextView.setLayoutParams(layoutParams);
    }

    public final void w(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder, PostData postData) {
        ir4 taskInfoData;
        String str;
        String str2;
        long j;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048592, this, pbInterviewLiveNormalItemViewHolder, postData) == null) || pbInterviewLiveNormalItemViewHolder == null || postData == null) {
            return;
        }
        v(pbInterviewLiveNormalItemViewHolder.b, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.b.getLayoutParams();
        layoutParams.bottomMargin = 0;
        layoutParams.topMargin = 0;
        pbInterviewLiveNormalItemViewHolder.b.setLayoutParams(layoutParams);
        pbInterviewLiveNormalItemViewHolder.b.setPadding(0, 0, 0, 0);
        pbInterviewLiveNormalItemViewHolder.b.k0(null);
        postData.h1();
        if (postData.B() == 1) {
            pbInterviewLiveNormalItemViewHolder.d.setVisibility(0);
            if (postData.s() != null) {
                long userIdLong = postData.s().getUserIdLong();
                String userName = postData.s().getUserName();
                str2 = postData.s().getName_show();
                str = userName;
                j = userIdLong;
            } else {
                str = null;
                str2 = null;
                j = 0;
            }
            pbInterviewLiveNormalItemViewHolder.d.g(postData.I(), str, str2, j, pg.g(this.j.O().getId(), 0L), pg.g(postData.K(), 0L));
            pbInterviewLiveNormalItemViewHolder.d.i();
            if (this.k) {
                PraiseData praise = this.j.O().getPraise();
                if (praise != null && praise.getUser() != null && praise.getUser().size() > 0) {
                    pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
                    pbInterviewLiveNormalItemViewHolder.e.setIsFromPb(true);
                    pbInterviewLiveNormalItemViewHolder.e.setData(praise, this.j.O().getId(), praise.getPostId(), true);
                    pbInterviewLiveNormalItemViewHolder.e.i(this.d);
                } else {
                    pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                    pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
                }
            } else {
                pbInterviewLiveNormalItemViewHolder.e.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.c.setVisibility(8);
                pbInterviewLiveNormalItemViewHolder.f.setVisibility(8);
            }
            pbInterviewLiveNormalItemViewHolder.e.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.c.setVisibility(0);
            pbInterviewLiveNormalItemViewHolder.f.setVisibility(0);
            v(pbInterviewLiveNormalItemViewHolder.b, (int) this.mContext.getResources().getDimension(R.dimen.obfuscated_res_0x7f070201));
        } else {
            pbInterviewLiveNormalItemViewHolder.d.setVisibility(8);
        }
        pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().x(R.drawable.pic_video);
        pbInterviewLiveNormalItemViewHolder.b.setTextColor(SkinManager.getColor(R.color.common_color_10039));
        pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        pbInterviewLiveNormalItemViewHolder.b.setLinkTextColor(SkinManager.getColor(R.color.CAM_X0304));
        if (this.h) {
            pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().g(R.drawable.obfuscated_res_0x7f081211);
        } else {
            pbInterviewLiveNormalItemViewHolder.b.getLayoutStrategy().g(R.drawable.icon_click);
        }
        pbInterviewLiveNormalItemViewHolder.b.setIsFromCDN(this.e);
        TbRichText V = postData.V();
        if (!this.r && this.s) {
            pbInterviewLiveNormalItemViewHolder.b.setText(V, true);
        } else {
            pbInterviewLiveNormalItemViewHolder.b.setText(V, false);
        }
        if (this.j.O().getTaskInfoData() != null) {
            pbInterviewLiveNormalItemViewHolder.a.K(this.j.O().getTaskInfoData().i(), this.e ? 17 : 18, false);
            int k = ri.k(this.mContext);
            float h = taskInfoData.h() / taskInfoData.j();
            int i = (int) (h > 1.0f ? k * 1.0f : h < 0.2f ? k * 0.2f : k * h);
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) pbInterviewLiveNormalItemViewHolder.a.getLayoutParams();
            layoutParams2.height = i;
            layoutParams2.width = k;
            pbInterviewLiveNormalItemViewHolder.a.setLayoutParams(layoutParams2);
        } else {
            pbInterviewLiveNormalItemViewHolder.a.setVisibility(8);
        }
        u(pbInterviewLiveNormalItemViewHolder, postData);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.cn
    /* renamed from: x */
    public PbInterviewLiveNormalItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, viewGroup)) == null) ? new PbInterviewLiveNormalItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06b4, viewGroup, false), this.i, this.h, this.g, false) : (PbInterviewLiveNormalItemViewHolder) invokeL.objValue;
    }

    public View y(int i, View view2, ViewGroup viewGroup, PostData postData, PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048594, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, pbInterviewLiveNormalItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, postData, pbInterviewLiveNormalItemViewHolder);
            SkinManager.setBackgroundColor(view2, R.color.CAM_X0201);
            z(pbInterviewLiveNormalItemViewHolder);
            w(pbInterviewLiveNormalItemViewHolder, postData);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void z(PbInterviewLiveNormalItemViewHolder pbInterviewLiveNormalItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, pbInterviewLiveNormalItemViewHolder) == null) {
            pbInterviewLiveNormalItemViewHolder.b.setOnLongClickListener(this.o);
            pbInterviewLiveNormalItemViewHolder.b.setOnTouchListener(this.n);
            pbInterviewLiveNormalItemViewHolder.b.setOnImageClickListener(this.m);
            a18 a18Var = this.a;
            if (a18Var == null || a18Var.P() == null) {
                return;
            }
            pbInterviewLiveNormalItemViewHolder.b.setOnEmotionClickListener(this.a.P().d.f);
        }
    }
}
