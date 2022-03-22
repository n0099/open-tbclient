package com.baidu.tieba.faceshop.emotioncenter.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import c.a.d.o.e.a;
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
/* loaded from: classes5.dex */
public class EmotionCategoryAdapter extends a<c.a.p0.a1.y.c.a, EmotionCategoryViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class EmotionCategoryViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public View a;

        /* renamed from: b  reason: collision with root package name */
        public TextView f32096b;

        /* renamed from: c  reason: collision with root package name */
        public ImageView f32097c;

        /* renamed from: d  reason: collision with root package name */
        public TextView f32098d;

        /* renamed from: e  reason: collision with root package name */
        public View f32099e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public EmotionCategoryViewHolder(View view) {
            super(view);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view};
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
            this.a = view;
            c();
        }

        public final void c() {
            View view;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || (view = this.a) == null) {
                return;
            }
            this.f32096b = (TextView) view.findViewById(R.id.obfuscated_res_0x7f0908b2);
            this.f32097c = (ImageView) this.a.findViewById(R.id.obfuscated_res_0x7f090872);
            this.f32098d = (TextView) this.a.findViewById(R.id.obfuscated_res_0x7f090881);
            this.f32096b.setText(this.a.getResources().getText(R.string.obfuscated_res_0x7f0f0528));
            this.f32097c.setVisibility(8);
            this.f32098d.setVisibility(8);
            this.f32099e = this.a.findViewById(R.id.obfuscated_res_0x7f0905a0);
        }

        public void d(int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
                SkinManager.setBackgroundColor(this.f32099e, R.color.common_color_10312);
                SkinManager.setViewTextColor(this.f32096b, (int) R.color.CAM_X0107);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: Z */
    public EmotionCategoryViewHolder M(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            EmotionCategoryViewHolder emotionCategoryViewHolder = new EmotionCategoryViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d0256, viewGroup, false));
            emotionCategoryViewHolder.d(TbadkCoreApplication.getInst().getSkinType());
            return emotionCategoryViewHolder;
        }
        return (EmotionCategoryViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // c.a.d.o.e.a
    /* renamed from: a0 */
    public View S(int i, View view, ViewGroup viewGroup, c.a.p0.a1.y.c.a aVar, EmotionCategoryViewHolder emotionCategoryViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view, viewGroup, aVar, emotionCategoryViewHolder})) == null) ? emotionCategoryViewHolder.b() : (View) invokeCommon.objValue;
    }
}
