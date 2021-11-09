package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import b.a.e.l.e.a;
import b.a.r0.h1.c.f.b;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class ConcernEmotionTipAdapter extends a<b, ConcernEmotionTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public int f49404a;
        public ViewGroup concernEmotionTipLayout;
        public ImageView emotionPic;
        public TextView tipText;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernEmotionTipViewHolder(View view) {
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
            this.f49404a = 3;
            this.concernEmotionTipLayout = (ViewGroup) view.findViewById(R.id.ll_concern_emotion_tip);
            this.emotionPic = (ImageView) view.findViewById(R.id.iv_concern_emotion_tip_pic);
            this.tipText = (TextView) view.findViewById(R.id.tv_concern_emotion_tip);
        }

        public void onChangeSkinType(int i2, int i3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i2, i3) == null) {
                if (this.f49404a != i2) {
                    SkinManager.setViewTextColor(this.tipText, R.color.CAM_X0107);
                }
                SkinManager.setImageResource(this.emotionPic, i3);
                this.f49404a = i2;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(Context context) {
        super(context, b.k);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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
    @Override // b.a.e.l.e.a
    /* renamed from: g0 */
    public ConcernEmotionTipViewHolder T(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) ? new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.concern_emotion_tip_layout, viewGroup, false)) : (ConcernEmotionTipViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // b.a.e.l.e.a
    /* renamed from: h0 */
    public View Z(int i2, View view, ViewGroup viewGroup, b bVar, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i2), view, viewGroup, bVar, concernEmotionTipViewHolder})) == null) {
            String str = bVar.f17027f;
            if (str != null) {
                concernEmotionTipViewHolder.tipText.setText(str);
            }
            if (bVar.getType() == b.j) {
                if (bVar.f17026e == 2) {
                    concernEmotionTipViewHolder.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_person_no_data_title));
                } else {
                    concernEmotionTipViewHolder.tipText.setText(TbadkCoreApplication.getInst().getString(R.string.concern_no_data_title));
                }
            }
            int i3 = bVar.f17026e;
            if (i3 == 2) {
                concernEmotionTipViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
            } else if (i3 == 3) {
                concernEmotionTipViewHolder.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
            }
            return concernEmotionTipViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }
}
