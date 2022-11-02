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
import com.baidu.tieba.c46;
import com.baidu.tieba.e46;
import com.baidu.tieba.kw4;
import com.baidu.tieba.w9;
import com.baidu.tieba.xi;
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
    public List<e46> c;
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
            this.a = view2.findViewById(R.id.obfuscated_res_0x7f090234);
            this.b = view2.findViewById(R.id.obfuscated_res_0x7f0901ec);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.obfuscated_res_0x7f0901cb);
            this.f = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            this.f.setSpeed(0.8f);
            this.f.loop(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.obfuscated_res_0x7f090233);
            this.c = headImageView;
            headImageView.setRadius(xi.g(alaRecommendListAdapter.a, R.dimen.tbds65));
            this.e = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f09023e);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f090242);
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
                kw4 d = kw4.d(this.d);
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
                    SkinManager.setBackgroundShapeDrawable(this.c, xi.g(this.g.a, R.dimen.tbds65), R.color.transparent, R.color.transparent, R.color.CAM_X0401, R.color.CAM_X0401, 4, this.g.b);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e46 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlaRecommendListAdapter c;

        public a(AlaRecommendListAdapter alaRecommendListAdapter, e46 e46Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, e46Var, Long.valueOf(j)};
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
            this.a = e46Var;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.c;
                e46 e46Var = this.a;
                alaRecommendListAdapter.i(e46Var.i, e46Var.a);
                e46 e46Var2 = this.a;
                c46.a("c13623", e46Var2.i, 0, e46Var2.e(), this.a.b(), this.a.d(), this.b, 5, "", this.c.e);
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
    public int getItemViewType(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<e46> list = this.c;
            if (list != null && list.get(i) != null) {
                return this.c.get(i).getType();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: m */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.f != null) {
                alaUserInfoViewHolder.f.cancelAnimation();
            }
        }
    }

    public void n(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.g = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: k */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048580, this, viewGroup, i)) == null) {
            return new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d010a, viewGroup, false));
        }
        return (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<e46> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void i(YyExtData yyExtData, String str) {
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, yyExtData, str) != null) || yyExtData == null) {
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
        } else if ("video_concern".equals(this.f)) {
            str2 = YYLiveUtil.SOURCE_VIDEO_CONCERN_SECOND_FLOOR;
        } else if ("big_pic".equals(this.f)) {
            str3 = YYLiveUtil.SOURCE_BIG_PIC_SECOND_FLOOR;
            z = true;
            YYLiveUtil.jumpToYYLiveRoom((TbPageContext) w9.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, null, str3, z);
        } else {
            str2 = "";
        }
        str3 = str2;
        z = false;
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) w9.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, null, str3, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: j */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        List<e46> list;
        e46 e46Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048579, this, alaUserInfoViewHolder, i) != null) || alaUserInfoViewHolder == null || (list = this.c) == null || list.size() <= i || (e46Var = this.c.get(i)) == null) {
            return;
        }
        if (e46Var.getType() == 0) {
            alaUserInfoViewHolder.d.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0a40));
            alaUserInfoViewHolder.c.setPlaceHolder(1);
            alaUserInfoViewHolder.c.setDefaultResource(R.drawable.obfuscated_res_0x7f08126e);
            if (!StringUtils.isNull(e46Var.c())) {
                alaUserInfoViewHolder.c.K(e46Var.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(e46Var.f()) > 8) {
                alaUserInfoViewHolder.e.setText(StringHelper.cutChineseAndEnglishWithSuffix(e46Var.f(), 8, StringHelper.STRING_MORE));
            } else {
                alaUserInfoViewHolder.e.setText(e46Var.f());
            }
            long a2 = e46Var.a();
            alaUserInfoViewHolder.a.setOnClickListener(new a(this, e46Var, a2));
            if (!this.d.contains(Long.valueOf(a2))) {
                c46.a("c13622", e46Var.i, 0, e46Var.e(), e46Var.b(), e46Var.d(), a2, 5, "", this.e);
                this.d.add(Long.valueOf(a2));
            }
        }
        alaUserInfoViewHolder.g(TbadkCoreApplication.getInst().getSkinType(), e46Var.getType());
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
                layoutParams.width = xi.g(this.a, R.dimen.tbds172);
                layoutParams.height = xi.g(this.a, R.dimen.tbds172);
                alaUserInfoViewHolder.b.setLayoutParams(layoutParams);
            }
        }
    }

    public void o(List<AlaLiveInfo> list, String str) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list, str) != null) || ListUtils.isEmpty(list)) {
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
                e46 e46Var = new e46();
                e46Var.l(0);
                e46Var.i(alaLiveInfo.user_info.portrait);
                e46Var.m(alaLiveInfo.user_info.user_name);
                e46Var.g(alaLiveInfo.live_id.longValue());
                e46Var.k(alaLiveInfo.thread_id.longValue());
                e46Var.j(alaLiveInfo.user_info.ala_id.longValue());
                e46Var.h(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                e46Var.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.c.add(e46Var);
            }
        }
        this.f = str;
        this.e = c46.f(str);
    }
}
