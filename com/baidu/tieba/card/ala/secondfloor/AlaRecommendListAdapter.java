package com.baidu.tieba.card.ala.secondfloor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.ej;
import com.baidu.tieba.hv4;
import com.baidu.tieba.l26;
import com.baidu.tieba.n26;
import com.baidu.tieba.w9;
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
/* loaded from: classes3.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<n26> c;
    public HashSet<Long> d;
    public int e;
    public String f;
    public boolean g;

    /* loaded from: classes3.dex */
    public class AlaUserInfoViewHolder extends RecyclerView.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;
        public View b;
        public HeadImageView c;
        public TextView d;
        public TextView e;
        public TBLottieAnimationView f;
        public final /* synthetic */ AlaRecommendListAdapter g;

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
            this.g = alaRecommendListAdapter;
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090225);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0901e4);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901c3);
            this.f = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            this.f.setSpeed(0.8f);
            this.f.loop(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090224);
            this.c = headImageView;
            headImageView.setRadius(ej.f(alaRecommendListAdapter.a, R.dimen.tbds65));
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09022f);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090233);
        }

        public void g(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.g.g) {
                    this.g.b = 4;
                } else {
                    this.g.b = i;
                }
                this.c.setSkinType(this.g.b);
                hv4 d = hv4.d(this.d);
                d.n(R.string.J_X01);
                d.z(R.dimen.T_X10);
                d.A(R.string.F_X01);
                d.l(R.dimen.L_X02);
                d.t(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0201));
                d.g(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0310));
                this.d.setTextColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0101));
                this.e.setTextColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0105));
                SkinManager.setLottieAnimation(this.f, R.raw.card_live_header_bg);
                if (i2 == 0) {
                    SkinManager.setBackgroundShapeDrawable(this.c, ej.f(this.g.a, R.dimen.tbds65), R.color.transparent, R.color.transparent, R.color.CAM_X0401, R.color.CAM_X0401, 4, this.g.b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ n26 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlaRecommendListAdapter c;

        public a(AlaRecommendListAdapter alaRecommendListAdapter, n26 n26Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, n26Var, Long.valueOf(j)};
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
            this.a = n26Var;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.c;
                n26 n26Var = this.a;
                alaRecommendListAdapter.i(n26Var.i, n26Var.a);
                n26 n26Var2 = this.a;
                l26.a("c13623", n26Var2.i, 0, n26Var2.e(), this.a.b(), this.a.d(), this.b, 5, "", this.c.e);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AlaUserInfoViewHolder a;

        public b(AlaRecommendListAdapter alaRecommendListAdapter, AlaUserInfoViewHolder alaUserInfoViewHolder) {
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
                this.a.f.playAnimation();
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
            List<n26> list = this.c;
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
            List<n26> list = this.c;
            if (list == null || list.get(i) == null) {
                return 0;
            }
            return this.c.get(i).getType();
        }
        return invokeI.intValue;
    }

    public void i(YyExtData yyExtData, String str) {
        String str2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yyExtData, str) == null) || yyExtData == null) {
            return;
        }
        if (ImageViewerConfig.FROM_CONCERN.equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_HOME_CONCERN_SECOND_FLOOR;
        } else if ("recommend".equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_HOME_RECOMMEND_SECOND_FLOOR;
        } else if ("ala_sub_tab".equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_FRS_ALA_TAB_SECOND_FLOOR;
        } else if ("ala_sub_list".equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_FRS_ALA_LIST_SECOND_FLOOR;
        } else if ("video_recommend".equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_VIDEO_RECOMMEND_SECOND_FLOOR;
        } else {
            str2 = "video_concern".equals(this.f) ? YYLiveUtil.SOURCE_VIDEO_CONCERN_SECOND_FLOOR : "";
        }
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) w9.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, str2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        List<n26> list;
        n26 n26Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLI(1048579, this, alaUserInfoViewHolder, i) == null) || alaUserInfoViewHolder == null || (list = this.c) == null || list.size() <= i || (n26Var = this.c.get(i)) == null) {
            return;
        }
        if (n26Var.getType() == 0) {
            alaUserInfoViewHolder.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a27));
            alaUserInfoViewHolder.c.setPlaceHolder(1);
            alaUserInfoViewHolder.c.setDefaultResource(R.drawable.obfuscated_res_0x7f081240);
            if (!StringUtils.isNull(n26Var.c())) {
                alaUserInfoViewHolder.c.K(n26Var.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(n26Var.f()) <= 8) {
                alaUserInfoViewHolder.e.setText(n26Var.f());
            } else {
                alaUserInfoViewHolder.e.setText(StringHelper.cutChineseAndEnglishWithSuffix(n26Var.f(), 8, StringHelper.STRING_MORE));
            }
            long a2 = n26Var.a();
            alaUserInfoViewHolder.a.setOnClickListener(new a(this, n26Var, a2));
            if (!this.d.contains(Long.valueOf(a2))) {
                l26.a("c13622", n26Var.i, 0, n26Var.e(), n26Var.b(), n26Var.d(), a2, 5, "", this.e);
                this.d.add(Long.valueOf(a2));
            }
        }
        alaUserInfoViewHolder.g(TbadkCoreApplication.getInst().getSkinType(), n26Var.getType());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) ? new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0108, viewGroup, false)) : (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: l */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, alaUserInfoViewHolder) == null) {
            super.onViewAttachedToWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null) {
                return;
            }
            if (alaUserInfoViewHolder.f != null) {
                alaUserInfoViewHolder.f.post(new b(this, alaUserInfoViewHolder));
            }
            if (TbDimenManager.getInstance().needAdapt()) {
                TbDimenManager.getInstance().adaptDimen(this.a);
                ViewGroup.LayoutParams layoutParams = alaUserInfoViewHolder.b.getLayoutParams();
                layoutParams.width = ej.f(this.a, R.dimen.tbds172);
                layoutParams.height = ej.f(this.a, R.dimen.tbds172);
                alaUserInfoViewHolder.b.setLayoutParams(layoutParams);
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder == null || alaUserInfoViewHolder.f == null) {
                return;
            }
            alaUserInfoViewHolder.f.cancelAnimation();
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g = z;
        }
    }

    public void o(List<AlaLiveInfo> list, String str) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) == null) || ListUtils.isEmpty(list)) {
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
                n26 n26Var = new n26();
                n26Var.l(0);
                n26Var.i(alaLiveInfo.user_info.portrait);
                n26Var.m(alaLiveInfo.user_info.user_name);
                n26Var.g(alaLiveInfo.live_id.longValue());
                n26Var.k(alaLiveInfo.thread_id.longValue());
                n26Var.j(alaLiveInfo.user_info.ala_id.longValue());
                n26Var.h(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                n26Var.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.c.add(n26Var);
            }
        }
        this.f = str;
        this.e = l26.f(str);
    }
}
