package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.MessageRedDotView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class c69 extends wx8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final BaseFragment f;
    public HeadImageView g;
    public LinearLayout h;
    public TextView i;
    public TextView j;
    public TextView k;
    public MessageRedDotView l;
    public ImMessageCenterShowItemData m;
    public String n;
    public Map<String, Integer> o;
    public final Map<String, Integer> p;
    public final View.OnClickListener q;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c69(BaseFragment mRootFragment) {
        super(R.layout.obfuscated_res_0x7f0d0661);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {mRootFragment};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(mRootFragment, "mRootFragment");
        this.f = mRootFragment;
        this.n = "";
        this.o = new LinkedHashMap();
        this.p = new LinkedHashMap();
        this.q = new View.OnClickListener() { // from class: com.baidu.tieba.s59
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, view2) == null) {
                    c69.a0(c69.this, view2);
                }
            }
        };
    }

    public static final void a0(c69 this$0, View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, view2) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (this$0.f.getContext() != null) {
                Context requireContext = this$0.f.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "mRootFragment.requireContext()");
                a79.a.d(this$0.X(), requireContext);
                StatisticItem statisticItem = new StatisticItem("c13720");
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                String ownerName = this$0.X().getOwnerName();
                if (Intrinsics.areEqual(ownerName, "5")) {
                    TiebaStatic.log("c12931");
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new OfficialBarFeedActivityConfig(requireContext)));
                } else if (Intrinsics.areEqual(ownerName, "8")) {
                    long j = JavaTypesHelper.toLong(this$0.X().getFriendId(), 0L);
                    OfficalBarChatActivityConfig officalBarChatActivityConfig = new OfficalBarChatActivityConfig(requireContext, j, this$0.X().getFriendNameShow(), this$0.X().getFriendPortrait(), 0, this$0.X().getUserType());
                    a79.a.g(j);
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002006, officalBarChatActivityConfig));
                }
                if (!TextUtils.isEmpty(this$0.X().getFriendName())) {
                    String friendName = this$0.X().getFriendName();
                    if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cf8))) {
                        statisticItem.param("obj_type", 8);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cfb))) {
                        statisticItem.param("obj_type", 9);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cf9))) {
                        statisticItem.param("obj_type", 10);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cf4))) {
                        statisticItem.param("obj_type", 4);
                    } else if (Intrinsics.areEqual(friendName, requireContext.getString(R.string.obfuscated_res_0x7f0f0cf6))) {
                        statisticItem.param("obj_type", 5);
                    }
                }
                TiebaStatic.log(statisticItem);
                a79.a.b(this$0.X(), requireContext);
                if (this$0.X().getUnReadCount() > 0) {
                    this$0.X().setUnReadCount(0);
                    this$0.R(this$0.X());
                }
            }
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            h0((HeadImageView) l(R.id.obfuscated_res_0x7f090613));
            e0((LinearLayout) l(R.id.obfuscated_res_0x7f090643));
            f0((TextView) l(R.id.obfuscated_res_0x7f090665));
            c0((TextView) l(R.id.obfuscated_res_0x7f090593));
            d0((TextView) l(R.id.obfuscated_res_0x7f090642));
            i0((MessageRedDotView) l(R.id.obfuscated_res_0x7f090645));
        }
    }

    public final void R(ImMessageCenterShowItemData data) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, data) == null) {
            Intrinsics.checkNotNullParameter(data, "data");
            g0(data);
            W().setText(data.getFriendNameShow());
            T().setText(data.getMsgContent());
            if (data.getUnReadCount() > 0) {
                Z().setVisibility(0);
                if (TextUtils.equals(data.getFriendNameShow(), this.n)) {
                    Z().refresh("", false);
                } else {
                    Z().refresh(data.getUnReadCount());
                }
            } else {
                Z().setVisibility(8);
            }
            S(data);
            b0(data);
        }
    }

    @Override // com.baidu.tieba.vx8
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            Y().setScaleType(ImageView.ScaleType.CENTER_CROP);
            EMManager.from(W()).setTextColor(R.color.CAM_X0105).setTextSize(R.dimen.T_X05).setTextStyle(R.string.F_X01);
            EMManager.from(T()).setTextColor(R.color.CAM_X0109).setTextSize(R.dimen.T_X08).setTextStyle(R.string.F_X01);
            EMManager.from(U()).setTextColor(R.color.CAM_X0111).setTextSize(R.dimen.T_X09).setTextStyle(R.string.F_X01);
            b0(X());
        }
    }

    public final void S(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, imMessageCenterShowItemData) == null) {
            Date date = new Date();
            date.setTime(imMessageCenterShowItemData.getServerTime());
            if (imMessageCenterShowItemData.getServerTime() != 0) {
                str = StringHelper.getChatTimeString(date);
            } else {
                str = "";
            }
            U().setText(str);
        }
    }

    public final void b0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Map<String, Integer> map;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, imMessageCenterShowItemData) == null) {
            if (TbadkApplication.getInst().getSkinType() == 4) {
                map = this.o;
            } else {
                map = this.p;
            }
            Integer num = map.get(imMessageCenterShowItemData.getFriendNameShow());
            if (num != null) {
                Y().setImageResource(num.intValue());
            }
        }
    }

    public final TextView T() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            TextView textView = this.j;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardAbs");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final TextView U() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TextView textView = this.k;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgTime");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final LinearLayout V() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            LinearLayout linearLayout = this.h;
            if (linearLayout != null) {
                return linearLayout;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardMsgView");
            return null;
        }
        return (LinearLayout) invokeV.objValue;
    }

    public final TextView W() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            TextView textView = this.i;
            if (textView != null) {
                return textView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mCardTitle");
            return null;
        }
        return (TextView) invokeV.objValue;
    }

    public final ImMessageCenterShowItemData X() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.m;
            if (imMessageCenterShowItemData != null) {
                return imMessageCenterShowItemData;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mData");
            return null;
        }
        return (ImMessageCenterShowItemData) invokeV.objValue;
    }

    public final HeadImageView Y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            HeadImageView headImageView = this.g;
            if (headImageView != null) {
                return headImageView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mHeadView");
            return null;
        }
        return (HeadImageView) invokeV.objValue;
    }

    public final MessageRedDotView Z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            MessageRedDotView messageRedDotView = this.l;
            if (messageRedDotView != null) {
                return messageRedDotView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("mRedDot");
            return null;
        }
        return (MessageRedDotView) invokeV.objValue;
    }

    public final void c0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.j = textView;
        }
    }

    public final void d0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.k = textView;
        }
    }

    public final void e0(LinearLayout linearLayout) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, linearLayout) == null) {
            Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
            this.h = linearLayout;
        }
    }

    public final void f0(TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, textView) == null) {
            Intrinsics.checkNotNullParameter(textView, "<set-?>");
            this.i = textView;
        }
    }

    public final void g0(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, imMessageCenterShowItemData) == null) {
            Intrinsics.checkNotNullParameter(imMessageCenterShowItemData, "<set-?>");
            this.m = imMessageCenterShowItemData;
        }
    }

    public final void h0(HeadImageView headImageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, headImageView) == null) {
            Intrinsics.checkNotNullParameter(headImageView, "<set-?>");
            this.g = headImageView;
        }
    }

    public final void i0(MessageRedDotView messageRedDotView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, messageRedDotView) == null) {
            Intrinsics.checkNotNullParameter(messageRedDotView, "<set-?>");
            this.l = messageRedDotView;
        }
    }

    @Override // com.baidu.tieba.immessagecenter.arch.view.BaseView
    public void r(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            Z().setThreeDotMode(2);
            HeadImageView Y = Y();
            Y.setOnClickListener(this.q);
            Y.setConrers(15);
            Y.setPlaceHolder(1);
            Y.setAutoChangeStyle(true);
            Y.setIsRound(true);
            Y.setDrawBorder(true);
            V().setOnClickListener(this.q);
            W().setOnClickListener(this.q);
            T().setOnClickListener(this.q);
            U().setOnClickListener(this.q);
            String string = context.getResources().getString(R.string.obfuscated_res_0x7f0f0cf6);
            Intrinsics.checkNotNullExpressionValue(string, "context.resources.getStr…ring.msg_tieba_broadcast)");
            this.n = string;
            Map<String, Integer> map = this.o;
            String string2 = context.getString(R.string.obfuscated_res_0x7f0f0cf6);
            Intrinsics.checkNotNullExpressionValue(string2, "context.getString(R.string.msg_tieba_broadcast)");
            map.put(string2, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ce4));
            String string3 = context.getString(R.string.obfuscated_res_0x7f0f0cf5);
            Intrinsics.checkNotNullExpressionValue(string3, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map.put(string3, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ff2));
            String string4 = context.getString(R.string.obfuscated_res_0x7f0f0cf7);
            Intrinsics.checkNotNullExpressionValue(string4, "context.getString(R.string.msg_tieba_group_notify)");
            map.put(string4, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080940));
            String string5 = context.getString(R.string.obfuscated_res_0x7f0f0cfa);
            Intrinsics.checkNotNullExpressionValue(string5, "context.getString(R.stri….msg_tieba_system_notify)");
            map.put(string5, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ce6));
            String string6 = context.getString(R.string.obfuscated_res_0x7f0f0cfc);
            Intrinsics.checkNotNullExpressionValue(string6, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map.put(string6, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d99));
            Map<String, Integer> map2 = this.p;
            String string7 = context.getString(R.string.obfuscated_res_0x7f0f0cf6);
            Intrinsics.checkNotNullExpressionValue(string7, "context.getString(R.string.msg_tieba_broadcast)");
            map2.put(string7, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ce3));
            String string8 = context.getString(R.string.obfuscated_res_0x7f0f0cf5);
            Intrinsics.checkNotNullExpressionValue(string8, "context.getString(R.string.msg_tieba_bazhu_notify)");
            map2.put(string8, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ff1));
            String string9 = context.getString(R.string.obfuscated_res_0x7f0f0cf7);
            Intrinsics.checkNotNullExpressionValue(string9, "context.getString(R.string.msg_tieba_group_notify)");
            map2.put(string9, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f08093f));
            String string10 = context.getString(R.string.obfuscated_res_0x7f0f0cfa);
            Intrinsics.checkNotNullExpressionValue(string10, "context.getString(R.stri….msg_tieba_system_notify)");
            map2.put(string10, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080ce5));
            String string11 = context.getString(R.string.obfuscated_res_0x7f0f0cfc);
            Intrinsics.checkNotNullExpressionValue(string11, "context.getString(R.stri….msg_tieba_zhanwu_notify)");
            map2.put(string11, Integer.valueOf((int) R.drawable.obfuscated_res_0x7f080d98));
        }
    }
}
