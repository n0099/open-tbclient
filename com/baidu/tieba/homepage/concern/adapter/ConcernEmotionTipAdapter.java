package com.baidu.tieba.homepage.concern.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.jd7;
import com.baidu.tieba.tm;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ConcernEmotionTipAdapter extends tm<jd7, ConcernEmotionTipViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class ConcernEmotionTipViewHolder extends TypeAdapter.ViewHolder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public ViewGroup a;
        public ImageView b;
        public TextView c;
        public int d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ConcernEmotionTipViewHolder(View view2) {
            super(view2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2};
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
            this.d = 3;
            this.a = (ViewGroup) view2.findViewById(R.id.obfuscated_res_0x7f09155a);
            this.b = (ImageView) view2.findViewById(R.id.obfuscated_res_0x7f091162);
            this.c = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f092571);
        }

        public void a(int i, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
                if (this.d != i) {
                    SkinManager.setViewTextColor(this.c, (int) R.color.CAM_X0107);
                }
                SkinManager.setImageResource(this.b, i2);
                this.d = i;
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(Context context) {
        super(context, jd7.g);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConcernEmotionTipAdapter(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: s */
    public ConcernEmotionTipViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, viewGroup)) == null) {
            return new ConcernEmotionTipViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d01ff, viewGroup, false));
        }
        return (ConcernEmotionTipViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: t */
    public View onFillViewHolder(int i, View view2, ViewGroup viewGroup, jd7 jd7Var, ConcernEmotionTipViewHolder concernEmotionTipViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, jd7Var, concernEmotionTipViewHolder})) == null) {
            String str = jd7Var.b;
            if (str != null) {
                concernEmotionTipViewHolder.c.setText(str);
            }
            if (jd7Var.getType() == jd7.f) {
                if (jd7Var.a == 2) {
                    concernEmotionTipViewHolder.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0458));
                } else {
                    concernEmotionTipViewHolder.c.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0457));
                }
            }
            int i2 = jd7Var.a;
            if (i2 != 2) {
                if (i2 == 3) {
                    concernEmotionTipViewHolder.a(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_06);
                }
            } else {
                concernEmotionTipViewHolder.a(TbadkCoreApplication.getInst().getSkinType(), R.drawable.new_pic_emotion_07);
            }
            return concernEmotionTipViewHolder.getView();
        }
        return (View) invokeCommon.objValue;
    }
}
