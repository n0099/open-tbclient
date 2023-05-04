package com.baidu.tieba.im.chat;

import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.g35;
import com.baidu.tieba.ii;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class MsgStrangerTipItemAdapter extends MsgCommonItemAdapter<TextView> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class a extends MsgCommonItemAdapter.MsgViewHolder<TextView> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(View view2, TextView textView) {
            super(view2, textView);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, textView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MsgStrangerTipItemAdapter(TbPageContext<MsglistActivity<?>> tbPageContext) {
        super(tbPageContext, ChatMessage.TYPE_MSG_STRANGER_TIP);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: G */
    public MsgCommonItemAdapter.MsgViewHolder<TextView> onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            FrameLayout frameLayout = new FrameLayout(viewGroup.getContext());
            frameLayout.setPadding(ii.g(viewGroup.getContext(), R.dimen.M_W_X022), ii.g(viewGroup.getContext(), R.dimen.M_H_X005), ii.g(viewGroup.getContext(), R.dimen.M_W_X022), ii.g(viewGroup.getContext(), R.dimen.M_H_X008));
            TextView textView = new TextView(viewGroup.getContext());
            textView.setPadding(ii.g(viewGroup.getContext(), R.dimen.M_W_X006), ii.g(viewGroup.getContext(), R.dimen.M_H_X002), ii.g(viewGroup.getContext(), R.dimen.M_W_X006), ii.g(viewGroup.getContext(), R.dimen.M_H_X002));
            textView.setGravity(17);
            frameLayout.addView(textView, new ViewGroup.LayoutParams(-1, -2));
            return new a(frameLayout, textView);
        }
        return (MsgCommonItemAdapter.MsgViewHolder) invokeL.objValue;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter, com.baidu.tieba.vm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, TypeAdapter.ViewHolder viewHolder) {
        x(i, view2, viewGroup, chatMessage, (MsgCommonItemAdapter.MsgViewHolder) viewHolder);
        return view2;
    }

    @Override // com.baidu.tieba.im.chat.MsgCommonItemAdapter
    public View x(int i, View view2, ViewGroup viewGroup, ChatMessage chatMessage, MsgCommonItemAdapter.MsgViewHolder<TextView> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), view2, viewGroup, chatMessage, msgViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, chatMessage, msgViewHolder);
            TextView a2 = msgViewHolder.a();
            g35 d = g35.d(a2);
            d.B(R.dimen.T_X09);
            d.C(R.string.F_X01);
            d.w(R.color.CAM_X0101);
            d.o(R.string.J_X05);
            d.f(R.color.CAM_X0603);
            a2.setText(R.string.personal_no_follow_mid_tip);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
