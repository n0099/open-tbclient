package com.baidu.tieba;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.NinePatchDrawable;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.BitmapHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tieba.feed.widget.AutoDegradeTagView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.AbilityItem;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatAdapter;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseChatMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.BaseMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.CommonMsgField;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.EnableDegradeUserData;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.base.ReMsgInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.helper.BotEffectUIAssist;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextGenImageMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.itemdata.TextMsg;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.chatpage.view.ReplyContentView;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.BubbleInfo;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.ChatRoomDetail;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.repo.entity.UserIdentificationConf;
import com.baidu.tieba.immessagecenter.chatgroup.utility.tag.MaxHeightRecycleView;
import com.baidu.tieba.pg8;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public class eh8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public static class a implements AutoDegradeTagView.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public a(CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonMsgField;
        }

        @Override // com.baidu.tieba.feed.widget.AutoDegradeTagView.a
        public void a(@NonNull r57 r57Var, @NonNull View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLL(1048576, this, r57Var, view2) == null) && (r57Var instanceof s57)) {
                fh8.a(this.a.getUserId(), this.a.getRoomId(), ((s57) r57Var).i());
                if (!StringUtils.isNull(r57Var.I())) {
                    ux4.y(view2.getContext(), "", r57Var.I(), false, true, true, null);
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ BaseChatAdapter.SelfHolder a;
        public final /* synthetic */ CommonMsgField b;

        public b(BaseChatAdapter.SelfHolder selfHolder, CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {selfHolder, commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = selfHolder;
            this.b = commonMsgField;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getView() != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getView().getContext(), String.valueOf(this.b.getUserId()), this.b.getUserName())));
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class c implements View.OnLongClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public c(CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonMsgField;
        }

        @Override // android.view.View.OnLongClickListener
        public boolean onLongClick(View view2) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, view2)) == null) {
                if (TbadkCoreApplication.getCurrentAccount().equals(String.valueOf(this.a.getUserId()))) {
                    return false;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921777, new AtSelectData(this.a.getPortrait(), this.a.getUserName(), String.valueOf(this.a.getUserId()), this.a.isRobot())));
                return true;
            }
            return invokeL.booleanValue;
        }
    }

    /* loaded from: classes5.dex */
    public static class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CommonMsgField a;

        public d(CommonMsgField commonMsgField) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {commonMsgField};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = commonMsgField;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                fh8.a(this.a.getUserId(), this.a.getRoomId(), "5");
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class e implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ View a;
        public final /* synthetic */ BaseMsg b;

        public e(View view2, BaseMsg baseMsg) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {view2, baseMsg};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = view2;
            this.b = baseMsg;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                s75.d(this.a).f(R.color.transparent);
                this.b.setShowLocatedColor(Boolean.FALSE);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static class f extends qg<in> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eg8 a;
        public final /* synthetic */ View b;
        public final /* synthetic */ BaseChatMsg c;
        public final /* synthetic */ int d;

        public f(eg8 eg8Var, View view2, BaseChatMsg baseChatMsg, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eg8Var, view2, baseChatMsg, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eg8Var;
            this.b = view2;
            this.c = baseChatMsg;
            this.d = i;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.qg
        public void onLoaded(in inVar, String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLI(1048576, this, inVar, str, i) == null) {
                if (inVar == null) {
                    this.a.onFailed();
                    return;
                }
                NinePatchDrawable ninePatchDrawable = new NinePatchDrawable(this.b.getResources(), inVar.p(), inVar.p().getNinePatchChunk(), inVar.o(), null);
                if (this.c.getItemStatus() == 5) {
                    oj8.h("c15182", this.d, this.c.getCommonMsgField().getRoomId(), !this.c.isLeft());
                }
                this.a.a(ninePatchDrawable);
            }
        }
    }

    public static void a(@NonNull CommonMsgField commonMsgField, @NonNull TextView textView) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65536, null, commonMsgField, textView) == null) {
            int role = commonMsgField.getRole();
            if (!commonMsgField.isRobot() && (role <= 0 || role > 4)) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            Resources resources = TbadkCoreApplication.getInst().getResources();
            int i = R.color.CAM_X0334;
            int i2 = R.string.A_X05;
            if (commonMsgField.isRobot()) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f0947);
            } else if (role > 0 && role < 4) {
                str = resources.getString(R.string.obfuscated_res_0x7f0f0948);
                i = R.color.CAM_X0302;
                i2 = R.string.A_X01;
            } else {
                str = "";
            }
            s75 d2 = s75.d(textView);
            d2.o(R.string.J_X04);
            d2.x(R.color.CAM_X0101);
            d2.e(i2);
            d2.f(i);
            textView.setText(str);
        }
    }

    public static void b(@NonNull CommonMsgField commonMsgField, @NonNull ImageView imageView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, commonMsgField, imageView) == null) {
            int level = commonMsgField.getLevel();
            if (level >= 1 && level <= 18) {
                imageView.setVisibility(0);
                imageView.setBackground(TbadkCoreApplication.getInst().getResources().getDrawable(BitmapHelper.getGradeResourceIdInEnterForum(level)));
                return;
            }
            imageView.setVisibility(8);
        }
    }

    public static void c(@NonNull CommonMsgField commonMsgField, @NonNull TextView textView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, null, commonMsgField, textView) == null) {
            String userName = commonMsgField.getUserName();
            if (StringUtils.isNull(userName)) {
                textView.setVisibility(8);
            } else {
                textView.setVisibility(0);
            }
            s75.d(textView).x(R.color.CAM_X0107);
            textView.setText(userName);
        }
    }

    public static void n(@NonNull List<EnableDegradeUserData> list, @NonNull CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65549, null, list, commonMsgField) == null) {
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    fh8.b(commonMsgField.getUserId(), commonMsgField.getRoomId(), enableDegradeUserData.getIcon().getType());
                }
            }
        }
    }

    public static View d(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, context)) == null) {
            RecyclerView recyclerView = new RecyclerView(context);
            recyclerView.setTag(R.id.obfuscated_res_0x7f092340, new uj8(context, recyclerView, new ri8(), new ti8(), xi.g(context, R.dimen.M_W_X004), 1));
            recyclerView.setId(R.id.obfuscated_res_0x7f090e60);
            return recyclerView;
        }
        return (View) invokeL.objValue;
    }

    public static ReplyContentView e(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, context)) == null) {
            ReplyContentView replyContentView = new ReplyContentView(context);
            replyContentView.setId(R.id.obfuscated_res_0x7f090e87);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.M_W_X004);
            layoutParams.setMargins(dimenPixelSize, UtilHelper.getDimenPixelSize(R.dimen.M_H_X003), dimenPixelSize, 0);
            replyContentView.setLayoutParams(layoutParams);
            return replyContentView;
        }
        return (ReplyContentView) invokeL.objValue;
    }

    public static boolean q(@NonNull CommonMsgField commonMsgField) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65552, null, commonMsgField)) == null) {
            if (commonMsgField.getUserExtraInfo() == null) {
                return false;
            }
            UserIdentificationConf userIdentificationConf = commonMsgField.getUserExtraInfo().getUserIdentificationConf();
            if (!"user_banned".equals(userIdentificationConf.getResourceKey())) {
                return false;
            }
            if (StringUtils.isNull(userIdentificationConf.getImageUrl()) && StringUtils.isNull(userIdentificationConf.getContent())) {
                return false;
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public static MaxHeightRecycleView f(@NonNull Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, context)) == null) {
            MaxHeightRecycleView maxHeightRecycleView = new MaxHeightRecycleView(context);
            maxHeightRecycleView.setId(R.id.obfuscated_res_0x7f0920d4);
            maxHeightRecycleView.setLayoutParams(new FrameLayout.LayoutParams(UtilHelper.getDimenPixelSize(R.dimen.tbds782), -2));
            return maxHeightRecycleView;
        }
        return (MaxHeightRecycleView) invokeL.objValue;
    }

    public static void u(@NonNull NoNetworkView noNetworkView) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65556, null, noNetworkView) == null) {
            if (BdNetTypeUtil.isNetWorkAvailable()) {
                noNetworkView.setVisibility(8);
            } else {
                noNetworkView.setVisibility(0);
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void g(@NonNull pg8.c cVar, @NonNull ChildItemData childitemdata, @NonNull View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65542, null, cVar, childitemdata, view2) == null) {
            if (childitemdata.getShowLocatedColor()) {
                s75 d2 = s75.d(view2);
                d2.e(R.string.A_X06);
                d2.f(R.color.CAM_X0313);
                cVar.d(new e(view2, childitemdata), 1000L);
                return;
            }
            s75.d(view2).f(R.color.transparent);
        }
    }

    public static void m(@NonNull TextView textView, @NonNull BaseChatMsg<?> baseChatMsg, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(65548, null, textView, baseChatMsg, i) == null) {
            int s = s(baseChatMsg, i);
            if (s != 0) {
                textView.setTextColor(s);
            } else if (baseChatMsg.isLeft()) {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0105));
            } else {
                textView.setTextColor(SkinManager.getColor(R.color.CAM_X0610));
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void h(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65543, null, childitemdata, selfHolder) == null) {
            int itemStatus = childitemdata.getItemStatus();
            if (itemStatus != 0) {
                if (itemStatus != 1) {
                    if (itemStatus != 2) {
                        if (itemStatus != 3) {
                            if (itemStatus != 4) {
                                if (itemStatus != 5) {
                                    return;
                                }
                            }
                        }
                    }
                    selfHolder.f.setVisibility(8);
                    selfHolder.e.setVisibility(0);
                    return;
                }
                selfHolder.f.setVisibility(0);
                selfHolder.e.setVisibility(8);
                return;
            }
            selfHolder.f.setVisibility(8);
            selfHolder.e.setVisibility(8);
        }
    }

    public static <ChildItemData extends BaseMsg> void l(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65547, null, childitemdata, selfHolder) == null) {
            ReMsgInfo reMsgInfo = childitemdata.getReMsgInfo();
            View findViewById = selfHolder.j.findViewById(R.id.obfuscated_res_0x7f090e87);
            if (findViewById instanceof ReplyContentView) {
                if (reMsgInfo != null) {
                    if (childitemdata instanceof TextGenImageMsg) {
                        ((ReplyContentView) findViewById).setFixedWidth(true, -2);
                    } else {
                        ((ReplyContentView) findViewById).setFixedWidth(false, -1);
                    }
                    if (childitemdata.isLeft()) {
                        ((ReplyContentView) findViewById).d(reMsgInfo);
                        return;
                    } else {
                        ((ReplyContentView) findViewById).e(reMsgInfo);
                        return;
                    }
                }
                findViewById.setVisibility(8);
                ((ReplyContentView) findViewById).setFixedWidth(false, -2);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0035  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x003a A[ORIG_RETURN, RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int s(@NonNull BaseChatMsg<?> baseChatMsg, int i) {
        InterceptResult invokeLI;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65554, null, baseChatMsg, i)) == null) {
            BubbleInfo bubbleInfo = baseChatMsg.getCommonMsgField().getBubbleInfo();
            if (baseChatMsg.needBubbleInfo() && bubbleInfo != null && bubbleInfo.getColorInfo() != null) {
                BubbleInfo.ColorInfo colorInfo = bubbleInfo.getColorInfo();
                if (i == 0) {
                    str = colorInfo.getTextColor();
                } else if (i == 4) {
                    str = colorInfo.getTextColorDark();
                }
                if (StringUtils.isNull(str)) {
                    return s2a.f(str);
                }
                return 0;
            }
            str = "";
            if (StringUtils.isNull(str)) {
            }
        } else {
            return invokeLI.intValue;
        }
    }

    public static <ChildItemData extends BaseMsg> void i(@NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65544, null, childitemdata, selfHolder) == null) {
            CommonMsgField commonMsgField = childitemdata.getCommonMsgField();
            boolean isLeft = childitemdata.isLeft();
            List<EnableDegradeUserData> enableDegradeUserDataList = commonMsgField.getEnableDegradeUserDataList();
            if (enableDegradeUserDataList != null && enableDegradeUserDataList.size() > 0) {
                List<r57> v = v(enableDegradeUserDataList);
                n(enableDegradeUserDataList, commonMsgField);
                if (isLeft) {
                    selfHolder.q.setGravity(16);
                } else {
                    selfHolder.q.setGravity(5);
                    selfHolder.s.setGravity(5);
                }
                selfHolder.q.j(v);
                selfHolder.b.setVisibility(8);
                selfHolder.c.setVisibility(8);
                selfHolder.d.setVisibility(8);
                selfHolder.q.setVisibility(0);
                selfHolder.q.setOnTagClickListener(new a(commonMsgField));
            } else {
                selfHolder.q.setVisibility(8);
                c(commonMsgField, selfHolder.b);
                a(commonMsgField, selfHolder.c);
                if (!commonMsgField.isRobot()) {
                    b(commonMsgField, selfHolder.d);
                } else {
                    selfHolder.d.setVisibility(8);
                }
            }
            List<EnableDegradeUserData> secondDegradeUserDataList = commonMsgField.getSecondDegradeUserDataList();
            if (secondDegradeUserDataList != null) {
                t(secondDegradeUserDataList, selfHolder, commonMsgField);
                s75 d2 = s75.d(selfHolder.r);
                d2.x(R.color.CAM_X0109);
                d2.C(R.dimen.T_X10);
                d2.D(R.string.F_X01);
            } else {
                selfHolder.r.setVisibility(8);
            }
            HeadImageView headImageView = selfHolder.a;
            headImageView.setAlpha(1.0f);
            selfHolder.m.setVisibility(8);
            headImageView.setDefaultResource(17170445);
            headImageView.setPlaceHolder(1);
            headImageView.setIsRound(true);
            headImageView.setBorderWidth(R.dimen.L_X02);
            headImageView.setBorderColor(R.color.CAM_X0602);
            headImageView.setDrawBorder(true);
            headImageView.N(commonMsgField.getPortrait(), 12, false);
            headImageView.setOnClickListener(new b(selfHolder, commonMsgField));
            headImageView.setOnLongClickListener(new c(commonMsgField));
            if (q(commonMsgField)) {
                UserIdentificationConf userIdentificationConf = commonMsgField.getUserExtraInfo().getUserIdentificationConf();
                selfHolder.o.setText(userIdentificationConf.getContent());
                selfHolder.n.N(userIdentificationConf.getImageUrl(), 10, false);
                headImageView.setAlpha(0.5f);
                selfHolder.m.setVisibility(0);
                s75 d3 = s75.d(selfHolder.m);
                d3.o(R.string.J_X01);
                d3.f(R.color.CAM_X0625);
                s75.d(selfHolder.o).x(R.color.CAM_X0101);
            }
            if (isLeft && commonMsgField.isRobot()) {
                TiebaStatic.log(new StatisticItem("c15194").param("fid", commonMsgField.getForumId()).param("obj_id", commonMsgField.getUserId()).param("obj_name", commonMsgField.getUserName()).param("room_id", commonMsgField.getRoomId()).param("uid", TbadkCoreApplication.getCurrentAccount()));
            }
        }
    }

    public static <ChildItemData extends BaseMsg> void j(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, mg8 mg8Var, lg8 lg8Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLLLLL(65545, null, context, childitemdata, selfHolder, mg8Var, lg8Var) != null) || selfHolder.l == null) {
            return;
        }
        List<AbilityItem> quickOperate = childitemdata.getCommonMsgField().getQuickOperate();
        uj8 uj8Var = (uj8) ((RecyclerView) selfHolder.l.findViewById(R.id.obfuscated_res_0x7f090e60)).getTag(R.id.obfuscated_res_0x7f092340);
        if (!ListUtils.isEmpty(o(quickOperate)) && uj8Var != null) {
            selfHolder.l.setVisibility(0);
            uj8Var.f(mg8Var, lg8Var);
            uj8Var.d(Collections.singletonList(childitemdata));
            return;
        }
        selfHolder.l.setVisibility(8);
    }

    public static <ChildItemData extends BaseMsg> void k(@NonNull Context context, @NonNull ChildItemData childitemdata, @NonNull BaseChatAdapter.SelfHolder selfHolder, @NonNull pg8.c cVar, @Nullable mg8 mg8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(65546, null, context, childitemdata, selfHolder, cVar, mg8Var) == null) {
            if (((childitemdata instanceof TextMsg) || selfHolder.g == null) && selfHolder.h != null && selfHolder.i != null) {
                BotEffectUIAssist botEffectUIAssist = new BotEffectUIAssist(context, childitemdata, selfHolder, cVar, mg8Var);
                botEffectUIAssist.k(childitemdata.getCommonMsgField().getRoomId());
                botEffectUIAssist.j(childitemdata.getCommonMsgField().getForumId());
                botEffectUIAssist.c();
                childitemdata.getCommonMsgField().setAbilityEffectItem(null);
            }
        }
    }

    public static List<AbilityItem> o(List<AbilityItem> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                AbilityItem abilityItem = list.get(i);
                if (abilityItem != null && abilityItem.getStyleConf() != null && abilityItem.getStyleConf().shouldShow()) {
                    arrayList.add(abilityItem);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }

    public static boolean p(@NonNull ChatRoomDetail chatRoomDetail) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, chatRoomDetail)) == null) {
            if (chatRoomDetail.getExtraInfo() == null || chatRoomDetail.getUserInfo() == null) {
                return true;
            }
            if (chatRoomDetail.getExtraInfo().getIsFreezing() == 1 || chatRoomDetail.getExtraInfo().getIsTalkBanned() == 1 || chatRoomDetail.getUserInfo().getIsBeenTalkBanned() == 1) {
                return false;
            }
            if (chatRoomDetail.getExtraInfo().getTalkType() == 1 && chatRoomDetail.getUserInfo().getIdentityRole() != 3) {
                return false;
            }
            int talkThresholdLevel = chatRoomDetail.getExtraInfo().getTalkThresholdLevel();
            int forumLevel = chatRoomDetail.getUserInfo().getForumLevel();
            if (talkThresholdLevel <= 1 || talkThresholdLevel <= forumLevel) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public static void r(BdUniqueId bdUniqueId, @NonNull BaseChatMsg<?> baseChatMsg, @NonNull View view2, @NonNull eg8 eg8Var) {
        String androidRightDark;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65553, null, bdUniqueId, baseChatMsg, view2, eg8Var) == null) {
            BubbleInfo bubbleInfo = baseChatMsg.getCommonMsgField().getBubbleInfo();
            if (baseChatMsg.needBubbleInfo() && bubbleInfo != null) {
                int id = bubbleInfo.getId();
                int skinType = TbadkApplication.getInst().getSkinType();
                BubbleInfo.ImgInfo imgInfo = bubbleInfo.getImgInfo();
                if (baseChatMsg.isLeft()) {
                    if (skinType == 0) {
                        androidRightDark = imgInfo.getAndroidLeft();
                    } else {
                        if (skinType == 4) {
                            androidRightDark = imgInfo.getAndroidLeftDark();
                        }
                        androidRightDark = "";
                    }
                } else if (skinType == 0) {
                    androidRightDark = imgInfo.getAndroidRight();
                } else {
                    if (skinType == 4) {
                        androidRightDark = imgInfo.getAndroidRightDark();
                    }
                    androidRightDark = "";
                }
                if (!StringUtils.isNull(androidRightDark)) {
                    rg.h().m(androidRightDark, 19, new f(eg8Var, view2, baseChatMsg, id), bdUniqueId);
                    return;
                } else {
                    eg8Var.onFailed();
                    return;
                }
            }
            eg8Var.onFailed();
        }
    }

    public static void t(@NonNull List<EnableDegradeUserData> list, @NonNull BaseChatAdapter.SelfHolder selfHolder, @NonNull CommonMsgField commonMsgField) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65555, null, list, selfHolder, commonMsgField) == null) {
            if (list.size() > 0) {
                EnableDegradeUserData enableDegradeUserData = list.get(0);
                boolean z = true;
                if ((enableDegradeUserData.getType() != 1 || enableDegradeUserData.getText() == null || StringUtils.isNull(enableDegradeUserData.getText().getStr())) ? false : false) {
                    selfHolder.r.setText(enableDegradeUserData.getText().getStr());
                    selfHolder.r.setVisibility(0);
                    fh8.b(commonMsgField.getUserId(), commonMsgField.getRoomId(), "5");
                    selfHolder.r.setOnClickListener(new d(commonMsgField));
                    return;
                }
                selfHolder.r.setVisibility(8);
                return;
            }
            selfHolder.r.setVisibility(8);
        }
    }

    public static List<r57> v(@NonNull List<EnableDegradeUserData> list) {
        InterceptResult invokeL;
        p57 p57Var;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65557, null, list)) == null) {
            ArrayList arrayList = new ArrayList();
            for (EnableDegradeUserData enableDegradeUserData : list) {
                if (enableDegradeUserData.getType() == 1) {
                    if (enableDegradeUserData.getText() != null) {
                        if (enableDegradeUserData.getText().getTextColor() != null) {
                            p57Var = new p57(enableDegradeUserData.getText().getTextColor().getType(), enableDegradeUserData.getText().getTextColor().getDay(), enableDegradeUserData.getText().getTextColor().getNight());
                        } else {
                            p57Var = new p57(2, "CAM_X0107", null);
                        }
                        p57 p57Var2 = p57Var;
                        String str = enableDegradeUserData.getText().getStr();
                        String schema = enableDegradeUserData.getText().getSchema();
                        int priority = enableDegradeUserData.getText().getPriority();
                        if (enableDegradeUserData.getText().getDegradeEnable() == 1) {
                            z = true;
                        } else {
                            z = false;
                        }
                        t57 t57Var = new t57(str, p57Var2, schema, priority, z, enableDegradeUserData.getText().getDegradeLength(), enableDegradeUserData.getText().getSuffix(), enableDegradeUserData.getText().getDegradePriority());
                        t57Var.h(enableDegradeUserData.getText().getType());
                        arrayList.add(t57Var);
                    }
                } else if (enableDegradeUserData.getType() == 2 && enableDegradeUserData.getIcon() != null) {
                    s57 s57Var = new s57(enableDegradeUserData.getIcon().getUrl(), enableDegradeUserData.getIcon().getSchema(), enableDegradeUserData.getIcon().getWidth(), enableDegradeUserData.getIcon().getHeight(), enableDegradeUserData.getIcon().getPriority(), false, null, null, null, null);
                    s57Var.l(enableDegradeUserData.getIcon().getType());
                    arrayList.add(s57Var);
                }
            }
            return arrayList;
        }
        return (List) invokeL.objValue;
    }
}
