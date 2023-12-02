package com.baidu.tieba.card.ala.secondfloor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ImageViewerConfig;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.dimen.TbDimenManager;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.lottie.TBLottieAnimationView;
import com.baidu.tieba.R;
import com.baidu.tieba.a5;
import com.baidu.tieba.pm6;
import com.baidu.tieba.rm6;
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
/* loaded from: classes5.dex */
public class AlaRecommendListAdapter extends RecyclerView.Adapter<AlaUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public List<rm6> c;
    public HashSet<Long> d;
    public int e;
    public String f;
    public boolean g;

    /* loaded from: classes5.dex */
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
            this.a = view2.findViewById(R.id.ala_recommend_container);
            this.b = view2.findViewById(R.id.ala_header_image_view);
            TBLottieAnimationView tBLottieAnimationView = (TBLottieAnimationView) view2.findViewById(R.id.ala_animation_background);
            this.f = tBLottieAnimationView;
            SkinManager.setLottieAnimation(tBLottieAnimationView, R.raw.card_live_header_bg);
            this.f.setSpeed(0.8f);
            this.f.loop(true);
            this.f.setLifecycleEnable(true);
            HeadImageView headImageView = (HeadImageView) view2.findViewById(R.id.ala_protrait);
            this.c = headImageView;
            headImageView.setRadius(BdUtilHelper.getDimens(alaRecommendListAdapter.a, R.dimen.tbds65));
            this.e = (TextView) view2.findViewById(R.id.ala_recommend_user_name);
            this.d = (TextView) view2.findViewById(R.id.ala_sign_icon);
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
                EMManager.from(this.d).setCorner(R.string.J_X01).setTextSize(R.dimen.T_X10).setTextStyle(R.string.F_X01).setBorderWidth(R.dimen.L_X02).setRealBorderColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0201)).setBackGroundRealColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0310));
                this.d.setTextColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0101));
                this.e.setTextColor(SkinManager.getColor(this.g.b, (int) R.color.CAM_X0105));
                SkinManager.setLottieAnimation(this.f, R.raw.card_live_header_bg);
                if (i2 == 0) {
                    SkinManager.setBackgroundShapeDrawable(this.c, BdUtilHelper.getDimens(this.g.a, R.dimen.tbds65), R.color.transparent, R.color.transparent, R.color.CAM_X0401, R.color.CAM_X0401, 4, this.g.b);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ rm6 a;
        public final /* synthetic */ long b;
        public final /* synthetic */ AlaRecommendListAdapter c;

        public a(AlaRecommendListAdapter alaRecommendListAdapter, rm6 rm6Var, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {alaRecommendListAdapter, rm6Var, Long.valueOf(j)};
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
            this.a = rm6Var;
            this.b = j;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                AlaRecommendListAdapter alaRecommendListAdapter = this.c;
                rm6 rm6Var = this.a;
                alaRecommendListAdapter.r(rm6Var.i, rm6Var.a);
                rm6 rm6Var2 = this.a;
                pm6.a("c13623", rm6Var2.i, 0, rm6Var2.e(), this.a.b(), this.a.d(), this.b, 5, "", this.c.e);
            }
        }
    }

    /* loaded from: classes5.dex */
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
            List<rm6> list = this.c;
            if (list != null && list.get(i) != null) {
                return this.c.get(i).f();
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: x */
    public void onViewDetachedFromWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, alaUserInfoViewHolder) == null) {
            super.onViewDetachedFromWindow(alaUserInfoViewHolder);
            if (alaUserInfoViewHolder != null && alaUserInfoViewHolder.f != null) {
                alaUserInfoViewHolder.f.cancelAnimation();
            }
        }
    }

    public void y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048587, this, z) == null) {
            this.g = z;
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* renamed from: t */
    public AlaUserInfoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i)) == null) {
            return new AlaUserInfoViewHolder(this, LayoutInflater.from(this.a).inflate(R.layout.ala_recommend_item, viewGroup, false));
        }
        return (AlaUserInfoViewHolder) invokeLI.objValue;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            List<rm6> list = this.c;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    public void r(YyExtData yyExtData, String str) {
        String str2;
        String str3;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048582, this, yyExtData, str) != null) || yyExtData == null) {
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
            YYLiveUtil.jumpToYYLiveRoom((TbPageContext) a5.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, null, str3, z);
        } else {
            str2 = "";
        }
        str3 = str2;
        z = false;
        YYLiveUtil.jumpToYYLiveRoom((TbPageContext) a5.a(TbadkCoreApplication.getInst().getCurrentActivity()), yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, str, null, str3, z);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: s */
    public void onBindViewHolder(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder, int i) {
        List<rm6> list;
        rm6 rm6Var;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLI(1048583, this, alaUserInfoViewHolder, i) != null) || alaUserInfoViewHolder == null || (list = this.c) == null || list.size() <= i || (rm6Var = this.c.get(i)) == null) {
            return;
        }
        if (rm6Var.f() == 0) {
            alaUserInfoViewHolder.d.setText(TbadkCoreApplication.getInst().getString(R.string.live_in));
            alaUserInfoViewHolder.c.setPlaceHolder(1);
            alaUserInfoViewHolder.c.setDefaultResource(R.drawable.transparent_bg);
            if (!StringUtils.isNull(rm6Var.c())) {
                alaUserInfoViewHolder.c.startLoad(rm6Var.c(), 10, false);
            }
            if (StringHelper.getChineseAndEnglishLength(rm6Var.g()) > 8) {
                alaUserInfoViewHolder.e.setText(StringHelper.cutChineseAndEnglishWithSuffix(rm6Var.g(), 8, "..."));
            } else {
                alaUserInfoViewHolder.e.setText(rm6Var.g());
            }
            long a2 = rm6Var.a();
            alaUserInfoViewHolder.a.setOnClickListener(new a(this, rm6Var, a2));
            if (!this.d.contains(Long.valueOf(a2))) {
                pm6.a("c13622", rm6Var.i, 0, rm6Var.e(), rm6Var.b(), rm6Var.d(), a2, 5, "", this.e);
                this.d.add(Long.valueOf(a2));
            }
        }
        alaUserInfoViewHolder.g(TbadkCoreApplication.getInst().getSkinType(), rm6Var.f());
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* renamed from: u */
    public void onViewAttachedToWindow(@NonNull AlaUserInfoViewHolder alaUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, alaUserInfoViewHolder) == null) {
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
                layoutParams.width = BdUtilHelper.getDimens(this.a, R.dimen.tbds172);
                layoutParams.height = BdUtilHelper.getDimens(this.a, R.dimen.tbds172);
                alaUserInfoViewHolder.b.setLayoutParams(layoutParams);
            }
        }
    }

    public void z(List<AlaLiveInfo> list, String str) {
        AlaUserInfo alaUserInfo;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048588, this, list, str) != null) || ListUtils.isEmpty(list)) {
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
                rm6 rm6Var = new rm6();
                rm6Var.m(0);
                rm6Var.j(alaLiveInfo.user_info.portrait);
                rm6Var.n(alaLiveInfo.user_info.user_name);
                rm6Var.h(alaLiveInfo.live_id.longValue());
                rm6Var.l(alaLiveInfo.thread_id.longValue());
                rm6Var.k(alaLiveInfo.user_info.ala_id.longValue());
                rm6Var.i(alaLiveInfo.live_type.intValue());
                YyExtData yyExtData = new YyExtData();
                rm6Var.i = yyExtData;
                yyExtData.parseProtoBuf(alaLiveInfo.yy_ext);
                this.c.add(rm6Var);
            }
        }
        this.f = str;
        this.e = pm6.f(str);
    }
}
