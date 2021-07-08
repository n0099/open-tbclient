package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.a;
/* loaded from: classes4.dex */
public class EmotionCategoryAdapter extends a<d.a.p0.p0.y.c.a, EmotionCategoryViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public View f15076a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f15077b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f15078c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f15079d;

        /* renamed from: e  reason: collision with root package name */
        public View f15080e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionCategoryViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((View) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f15076a = view;
            b();
        }

        public final void b() {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.f15076a) == null) {
                return;
            }
            this.f15077b = (TextView) view.findViewById(R.id.emotion_title);
            this.f15078c = (ImageView) this.f15076a.findViewById(R.id.emotion_change_iv);
            this.f15079d = (TextView) this.f15076a.findViewById(R.id.emotion_function);
            this.f15077b.setText(this.f15076a.getResources().getText(R.string.emotion_center_quality_recommend));
            this.f15078c.setVisibility(8);
            this.f15079d.setVisibility(8);
            this.f15080e = this.f15076a.findViewById(R.id.category_line_top);
        }

        public void c(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
                SkinManager.setBackgroundColor(this.f15080e, R.color.common_color_10312);
                SkinManager.setViewTextColor(this.f15077b, R.color.CAM_X0107);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public EmotionCategoryAdapter(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext.getPageActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: f0 */
    public EmotionCategoryViewHolder Q(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.f41837e).inflate(R.layout.emotion_category_layout, viewGroup, false));
            emotionCategoryViewHolder.c(TbadkCoreApplication.getInst().getSkinType());
            return emotionCategoryViewHolder;
        }
        return (EmotionCategoryViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.c.k.e.a
    /* renamed from: g0 */
    public View X(int i2, View view, ViewGroup viewGroup, d.a.p0.p0.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, aVar, emotionCategoryViewHolder})) == null) ? emotionCategoryViewHolder.a() : (View) invokeCommon.objValue;
    }
}
