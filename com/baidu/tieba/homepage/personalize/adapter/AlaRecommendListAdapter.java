package com.baidu.tieba.homepage.personalize.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveTabMyConcernActivityConfig;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.i17;
import com.baidu.tieba.i9;
import com.baidu.tieba.os4;
import com.baidu.tieba.py4;
import com.baidu.tieba.ri;
import com.baidu.tieba.rw6;
import com.baidu.tieba.v17;
import com.baidu.tieba.w07;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import tbclient.AlaLiveInfo;
import tbclient.AlaUserInfo;
/* loaded from: classes4.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<w07> c;
    public HashSet<Long> d;
    public int e;
    public String f;

    /* loaded from: classes4.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public HeadImageView c;
        public TbImageView d;
        public TextView e;
        public TextView f;
        public TBLottieAnimationView g;
        public final /* synthetic */ AlaRecommendListAdapter h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AlaUserInfoViewHolder(AlaRecommendListAdapter alaRecommendListAdapter, View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.h = alaRecommendListAdapter;
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090224);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0901e3);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901c2);
            this.g = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            this.g.setSpeed(0.8f);
            this.g.loop(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090223);
            this.c = headImageView;
            headImageView.setRadius(ri.f(alaRecommendListAdapter.a, R.dimen.tbds65));
            this.d = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f090227);
            this.f = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090228);
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09022c);
        }

        public void h(int i, int i2) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) || i == this.h.b) {
                return;
            }
            this.c.setSkinType(i);
            this.d.setSkinType(i);
            os4 d = os4.d(this.e);
            d.n(R.string.J_X01);
            d.z(R.dimen.T_X09);
            d.A(R.string.F_X01);
            d.v(R.color.CAM_X0101);
            d.l(R.dimen.L_X03);
            d.k(R.color.CAM_X0201);
            d.f(R.color.CAM_X0310);
            os4 d2 = os4.d(this.f);
            d2.A(R.string.F_X01);
            d2.z(R.dimen.T_X09);
            d2.v(R.color.CAM_X0105);
            SkinManager.setLottieAnimation(this.g, R.raw.card_live_header_bg);
            if (i2 == 1) {
                SkinManager.setImageResource(this.c, R.drawable.pic_live_hand_n);
                return;
            }
            SkinManager.setImageResource(this.d, R.drawable.icon_pure_live_moe22);
            SkinManager.setBackgroundShapeDrawable(this.c, ri.f(this.h.a, R.dimen.tbds65), R.color.transparent, R.color.transparent, R.color.CAM_X0401, R.color.CAM_X0401, 4);
        }
    }

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaRecommendListAdapter a;

        public a(AlaRecommendListAdapter alaRecommendListAdapter) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaRecommendListAdapter;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.l();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w07 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlaRecommendListAdapter c;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, w07 w07Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, w07Var, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = alaRecommendListAdapter;
            this.a = w07Var;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.c;
                w07 w07Var = this.a;
                alaRecommendListAdapter.k(w07Var.i, w07Var.a);
                w07 w07Var2 = this.a;
                i17.b("c13623", w07Var2.i, 0, w07Var2.e(), this.a.b(), this.a.d(), this.b, 5, "", this.c.e);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ w07 a;
        public final /* synthetic */ AlaRecommendListAdapter b;

        public c(AlaRecommendListAdapter alaRecommendListAdapter, w07 w07Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, w07Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = alaRecommendListAdapter;
            this.a = w07Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.b.j(this.a.i);
                i17.a("c14717", this.a.i);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaUserInfoViewHolder a;

        public d(AlaRecommendListAdapter alaRecommendListAdapter, AlaUserInfoViewHolder alaUserInfoViewHolder) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, alaUserInfoViewHolder};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = alaUserInfoViewHolder;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.a.g.playAnimation();
            }
        }
    }

    public AlaRecommendListAdapter(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = 3;
        this.a = context;
        this.d = new HashSet<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<w07> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<w07> list = this.c;
            if (list == null || list.get(i) == null) {
                return 0;
            }
            return this.c.get(i).getType();
        }
        return invokeI.intValue;
    }

    public final boolean i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            List<py4> h = new rw6().h();
            if (ListUtils.isEmpty(h)) {
                return false;
            }
            for (py4 py4Var : h) {
                if (py4Var != null && !py4Var.e() && 6 == py4Var.a && "直播".equals(py4Var.b)) {
                    return true;
                }
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void j(YyExtData yyExtData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, yyExtData) == null) && ViewHelper.checkUpIsLogin(this.a)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveTabMyConcernActivityConfig(this.a)));
            TiebaStatic.log(v17.l("c13624", this.e, YYLiveUtil.calculateLiveType(yyExtData), TiebaStatic.YYValues.YY_LIVE));
        }
    }

    public void k(YyExtData yyExtData, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048580, this, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) i9.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, ImageViewerConfig.FROM_CONCERN.equals(this.f) ? YYLiveUtil.SOURCE_HOME_CONCERN_SECOND_FLOOR : YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR);
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921445));
            TiebaStatic.log(v17.k("c13621", this.e));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        List<w07> list;
        w07 w07Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048582, this, alaUserInfoViewHolder, i) == null) || alaUserInfoViewHolder == null || (list = this.c) == null || list.size() <= i || (w07Var = this.c.get(i)) == null) {
            return;
        }
        if (w07Var.getType() == 1) {
            alaUserInfoViewHolder.e.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fab));
            alaUserInfoViewHolder.c.setImageResource(R.drawable.pic_live_hand_n);
            alaUserInfoViewHolder.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0fae));
            alaUserInfoViewHolder.a.setOnClickListener(new a(this));
        } else if (w07Var.getType() == 0) {
            alaUserInfoViewHolder.e.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a14));
            alaUserInfoViewHolder.c.setPlaceHolder(1);
            alaUserInfoViewHolder.c.setDefaultResource(R.drawable.obfuscated_res_0x7f081211);
            if (!StringUtils.isNull(w07Var.c())) {
                alaUserInfoViewHolder.c.K(w07Var.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(w07Var.f()) <= 10) {
                alaUserInfoViewHolder.f.setText(w07Var.f());
            } else {
                alaUserInfoViewHolder.f.setText(StringHelper.cutChineseAndEnglishWithSuffix(w07Var.f(), 8, StringHelper.STRING_MORE));
            }
            long a2 = w07Var.a();
            alaUserInfoViewHolder.a.setOnClickListener(new b(this, w07Var, a2));
            if (!this.d.contains(Long.valueOf(a2))) {
                i17.b("c13622", w07Var.i, 0, w07Var.e(), w07Var.b(), w07Var.d(), a2, 5, "", this.e);
                this.d.add(Long.valueOf(a2));
            }
        } else if (w07Var.getType() == 2) {
            alaUserInfoViewHolder.e.setVisibility(8);
            alaUserInfoViewHolder.g.setVisibility(4);
            alaUserInfoViewHolder.f.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f02ad));
            alaUserInfoViewHolder.d.setVisibility(0);
            alaUserInfoViewHolder.c.setPlaceHolder(0);
            alaUserInfoViewHolder.d.setImageResource(R.drawable.icon_pure_live_moe22);
            alaUserInfoViewHolder.a.setOnClickListener(new c(this, w07Var));
            i17.a("c14716", w07Var.i);
        }
        alaUserInfoViewHolder.h(TbadkCoreApplication.getInst().getSkinType(), w07Var.getType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: n */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, viewGroup, i)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0106, viewGroup, false)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: o */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.g != null) {
                alaUserInfoViewHolder.g.post(new d(this, alaUserInfoViewHolder));
            }
            if (TbDimenManager.getInstance().needAdapt()) {
                TbDimenManager.getInstance().adaptDimen(this.a);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) alaUserInfoViewHolder.b.getLayoutParams();
                layoutParams.width = ri.f(this.a, R.dimen.tbds230);
                layoutParams.height = ri.f(this.a, R.dimen.tbds230);
                alaUserInfoViewHolder.b.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: p */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || alaUserInfoViewHolder.g == null) {
                return;
            }
            alaUserInfoViewHolder.g.cancelAnimation();
        }
    }

    public void q(List<AlaLiveInfo> list, String str) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, list, str) == null) || ListUtils.isEmpty(list)) {
            return;
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.clear();
        if (list != null && list.size() > 12) {
            list = ListUtils.subList(list, 0, 12);
        }
        for (AlaLiveInfo alaLiveInfo : list) {
            if (alaLiveInfo != null && (alaUserInfo = alaLiveInfo.user_info) != null && !StringUtils.isNull(alaUserInfo.user_name) && alaLiveInfo.yy_ext != null) {
                w07 w07Var = new w07();
                w07Var.l(0);
                w07Var.i(alaLiveInfo.user_info.portrait);
                w07Var.m(alaLiveInfo.user_info.user_name);
                w07Var.g(alaLiveInfo.live_id.longValue());
                w07Var.k(alaLiveInfo.thread_id.longValue());
                w07Var.j(alaLiveInfo.user_info.ala_id.longValue());
                w07Var.h(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                w07Var.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.c.add(w07Var);
            }
        }
        this.f = str;
        this.e = "recommend".equals(str) ? 1 : 2;
        if (this.c.size() >= 12) {
            w07 w07Var2 = new w07();
            w07Var2.l(2);
            this.c.add(w07Var2);
        }
        if ("recommend".equals(str)) {
            w07 w07Var3 = new w07();
            w07Var3.l(1);
            if (i()) {
                this.c.add(0, w07Var3);
            }
        }
    }
}
