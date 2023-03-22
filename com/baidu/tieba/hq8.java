package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.PollData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.TiebaStaticHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.core.view.HeadPendantClickableView;
import com.baidu.tbadk.data.IconData;
import com.baidu.tbadk.switchs.PbNormalLikeButtonSwitch;
import com.baidu.tieba.pb.pb.main.PbLinkGoodsRootView;
import com.baidu.tieba.pb.pb.main.PbModel;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoPbVideoInfoViewHolder;
import com.baidu.tieba.pushdialog.PushDialogActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class hq8 extends tm<bc9, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    @Nullable
    public wp8 b;
    public ki8 c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public lm8 h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq8 a;

        public a(hq8 hq8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0904cf && view2.getId() != R.id.obfuscated_res_0x7f09279f) {
                    String str3 = null;
                    if (view2.getId() == R.id.obfuscated_res_0x7f092803) {
                        if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                            return;
                        }
                        if (view2.getTag() != null) {
                            str3 = (String) view2.getTag();
                        }
                        if (str3 != null) {
                            UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str3});
                        }
                        TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0926e4) {
                        if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                            return;
                        }
                        gt4.x(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090e8d) {
                        HeadImageView headView = ((HeadPendantClickableView) view2).getHeadView();
                        String userId = headView.getUserId();
                        String userName = headView.getUserName();
                        String fid = headView.getFid();
                        String tid = headView.getTid();
                        String fName = headView.getFName();
                        int floor = headView.getFloor();
                        AlaInfoData alaInfo = headView.getAlaInfo();
                        int liveStatus = headView.getLiveStatus();
                        if (alaInfo != null && (liveStatus == 1 || alaInfo.live_status == 1)) {
                            if (alaInfo.isLegalYYLiveData()) {
                                YYLiveUtil.jumpYYLiveRoom(this.a.a.getPageContext(), alaInfo, YYLiveUtil.SOURCE_PB_LIVE_HEAD);
                            }
                            StatisticItem statisticItem = new StatisticItem("c13715");
                            statisticItem.param("fid", fid);
                            statisticItem.param("fname", fName);
                            AlaUserInfoData alaUserInfoData = alaInfo.user_info;
                            if (alaUserInfoData != null) {
                                j = alaUserInfoData.user_id;
                            } else {
                                j = 0;
                            }
                            statisticItem.param("obj_param1", j);
                            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                            statisticItem.param("tid", tid);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, floor);
                            statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, YYLiveUtil.calculateLiveType(alaInfo));
                            if (alaInfo.mYyExtData != null) {
                                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, TiebaStatic.YYValues.YY_LIVE);
                                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                            }
                            TiebaStatic.log(statisticItem);
                            return;
                        }
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                        StatisticItem statisticItem2 = new StatisticItem("c13267");
                        statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                        statisticItem2.param("fid", fid);
                        statisticItem2.param("tid", tid);
                        statisticItem2.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem2);
                        if (userId != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, userId, userName, fName, AddFriendActivityConfig.TYPE_PB_HEAD)));
                        }
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f0926be) {
                        TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                        if (view2.getTag(R.id.tag_user_id) instanceof String) {
                            str = (String) view2.getTag(R.id.tag_user_id);
                        } else {
                            str = null;
                        }
                        if (view2.getTag(R.id.tag_user_name) instanceof String) {
                            str2 = (String) view2.getTag(R.id.tag_user_name);
                        } else {
                            str2 = null;
                        }
                        if (this.a.c != null && this.a.c.l() != null) {
                            str3 = this.a.c.l().getName();
                        }
                        String str4 = str3;
                        StatisticItem statisticItem3 = new StatisticItem("c13267");
                        statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                        if (this.a.c != null) {
                            statisticItem3.param("fid", this.a.c.m());
                            statisticItem3.param("tid", this.a.c.S());
                        }
                        statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                        TiebaStatic.log(statisticItem3);
                        if (str != null) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str4, AddFriendActivityConfig.TYPE_PB_HEAD)));
                        }
                    }
                } else if (this.a.viewholder != null) {
                    int f = ((VideoPbVideoInfoViewHolder) this.a.viewholder).f();
                    if (f == 1) {
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).a(2);
                    } else if (f == 2) {
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).a(1);
                    }
                    if (!this.a.c.l0() && f != 1) {
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).x.setVisibility(0);
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).B.setVisibility(0);
                    } else {
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).x.setVisibility(8);
                        ((VideoPbVideoInfoViewHolder) this.a.viewholder).B.setVisibility(8);
                    }
                    TiebaStatic.log("c13603");
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public b(hq8 hq8Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq8Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbVideoInfoViewHolder;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.a.y.getMeasuredWidth();
                int measuredWidth2 = this.a.v.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.a.w.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i = this.b;
                if (measuredWidth3 < i) {
                    this.a.B.setVisibility(8);
                    this.a.x.setVisibility(8);
                } else if (measuredWidth3 - i < dimenPixelSize3) {
                    this.a.x.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ VideoPbVideoInfoViewHolder a;
        public final /* synthetic */ int b;

        public c(hq8 hq8Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq8Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = videoPbVideoInfoViewHolder;
            this.b = i;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                int dimenPixelSize = UtilHelper.getDimenPixelSize(R.dimen.tbds27);
                int dimenPixelSize2 = UtilHelper.getDimenPixelSize(R.dimen.tbds29);
                int measuredWidth = this.a.u.getMeasuredWidth();
                int measuredWidth2 = this.a.C.getMeasuredWidth();
                int dimenPixelSize3 = UtilHelper.getDimenPixelSize(R.dimen.tbds120);
                int measuredWidth3 = (measuredWidth - measuredWidth2) - ((this.a.D.getMeasuredWidth() + dimenPixelSize) + dimenPixelSize2);
                int i = this.b;
                if (measuredWidth3 < i) {
                    this.a.F.setVisibility(8);
                    this.a.E.setVisibility(8);
                } else if (measuredWidth3 - i < dimenPixelSize3) {
                    this.a.E.setVisibility(8);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hq8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(hq8 hq8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hq8Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hq8Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && ((VideoPbVideoInfoViewHolder) this.a.viewholder).p != null) {
                ((VideoPbVideoInfoViewHolder) this.a.viewholder).p.setTextSize(TbConfig.getContentSize());
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hq8(BaseFragment baseFragment, @Nullable wp8 wp8Var, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, wp8Var, bdUniqueId};
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
        this.l = null;
        this.m = new a(this);
        d dVar = new d(this, 2004018);
        this.n = dVar;
        this.a = baseFragment;
        this.b = wp8Var;
        baseFragment.registerListener(dVar);
    }

    public final boolean Q(bc9 bc9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, bc9Var)) == null) {
            if (bc9Var != null && ListUtils.getCount(bc9Var.i0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void W(ki8 ki8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, ki8Var) == null) {
            this.c = ki8Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.l = str;
        }
    }

    public final void J(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, ki8 ki8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, videoPbVideoInfoViewHolder, ki8Var, i) == null) && ki8Var != null) {
            videoPbVideoInfoViewHolder.o(ki8Var, i);
        }
    }

    public final void L(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPbVideoInfoViewHolder, bc9Var) == null) && (ki8Var = this.c) != null && ki8Var.Q() != null && this.c.Q().getAuthor() != null && bc9Var != null) {
            b0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor(), bc9Var);
            f0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            d0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            Y(videoPbVideoInfoViewHolder.h, this.c.j());
            a0(videoPbVideoInfoViewHolder, bc9Var);
            e0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            X(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            c0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor(), bc9Var);
        }
    }

    public final void X(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048589, this, videoPbVideoInfoViewHolder, metaData) == null) {
            if (this.c != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoPbVideoInfoViewHolder.l;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
                layoutParams.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.k.setText(authInfo);
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void M(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        String formatTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoPbVideoInfoViewHolder, bc9Var) == null) && (ki8Var = this.c) != null && ki8Var.Q() != null && bc9Var != null) {
            videoPbVideoInfoViewHolder.s(this.c.Q().getRichTitle(), this.c.Q().getTitle(), this.c.Q(), Q(bc9Var), this.c.z0());
            if (this.c.Q().getThreadVideoInfo() != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.c.Q().getThreadVideoInfo().play_count.intValue());
                TextView textView = videoPbVideoInfoViewHolder.v;
                textView.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0f71));
                TextView textView2 = videoPbVideoInfoViewHolder.C;
                textView2.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0f71));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(bc9Var.k0()), "yyyy"))) {
                formatTime = StringHelper.getFormatTimeShort(bc9Var.k0());
            } else {
                formatTime = StringHelper.getFormatTime(bc9Var.k0());
            }
            TextView textView3 = videoPbVideoInfoViewHolder.w;
            textView3.setText(formatTime + this.mContext.getString(R.string.send_post));
            TextView textView4 = videoPbVideoInfoViewHolder.D;
            textView4.setText(formatTime + this.mContext.getString(R.string.send_post));
            oa5 V = bc9Var.V();
            if (V != null && !TextUtils.isEmpty(V.b()) && !TextUtils.isEmpty(V.b().trim())) {
                videoPbVideoInfoViewHolder.x.setText(V.b());
                videoPbVideoInfoViewHolder.E.setText(V.b());
                videoPbVideoInfoViewHolder.x.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.x.setVisibility(8);
            }
            if (V != null && !TextUtils.isEmpty(V.a())) {
                videoPbVideoInfoViewHolder.B.setText(V.a());
                videoPbVideoInfoViewHolder.F.setText(V.a());
                videoPbVideoInfoViewHolder.B.setVisibility(0);
                int measureText = (int) videoPbVideoInfoViewHolder.B.getPaint().measureText(V.a(), 0, V.a().length());
                videoPbVideoInfoViewHolder.y.post(new b(this, videoPbVideoInfoViewHolder, measureText));
                videoPbVideoInfoViewHolder.u.post(new c(this, videoPbVideoInfoViewHolder, measureText));
            } else {
                videoPbVideoInfoViewHolder.B.setVisibility(8);
            }
            PollData pollData = this.c.Q().getPollData();
            if (pollData != null && pollData.getOptions() != null && pollData.getOptions().size() > 0) {
                videoPbVideoInfoViewHolder.z.setPageContext(this.a.getPageContext());
                videoPbVideoInfoViewHolder.z.setDataForPb(pollData, this.c.S(), this.c.m());
                videoPbVideoInfoViewHolder.z.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.z.setVisibility(8);
            }
            LinearLayout linearLayout = videoPbVideoInfoViewHolder.N;
            if (linearLayout != null) {
                linearLayout.removeAllViews();
            }
            ki8 ki8Var2 = this.c;
            if (ki8Var2 != null && ki8Var2.Q() != null && !R(this.c.Q()) && (!ListUtils.isEmpty(this.c.Q().getLinkDataList()) || !ListUtils.isEmpty(this.c.Q().getGoodsDataList()))) {
                gq5 gq5Var = new gq5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                ki8 ki8Var3 = this.c;
                pbLinkGoodsRootView.j(ki8Var3, gq5Var.a(ki8Var3.Q().getLinkDataList(), this.c.Q().getGoodsDataList()), this.c.n(), (AbsVideoPbFragment) this.a, gq5Var.c());
                videoPbVideoInfoViewHolder.N.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.N.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.N.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.r(this.mContext, bc9Var);
        }
    }

    public final void N(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, videoPbVideoInfoViewHolder, bc9Var) == null) {
            videoPbVideoInfoViewHolder.q(8, null);
            ki8 ki8Var = this.c;
            if (ki8Var != null && ki8Var.Q() != null && bc9Var != null) {
                if (bc9Var.S) {
                    videoPbVideoInfoViewHolder.q(0, bc9Var.O());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).d6(bc9Var.S);
                }
            }
        }
    }

    public final void d0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048595, this, videoPbVideoInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        videoPbVideoInfoViewHolder.g.setText(metaData.getName_show());
        videoPbVideoInfoViewHolder.g.setTag(R.id.tag_user_id, metaData.getUserId());
        videoPbVideoInfoViewHolder.g.setTag(R.id.tag_user_name, metaData.getName_show());
        this.j = metaData.isBigV();
        this.k = metaData.isNewGod();
    }

    public final int O() {
        InterceptResult invokeV;
        PbModel L;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            wp8 wp8Var = this.b;
            if (wp8Var != null && (L = wp8Var.L()) != null) {
                return L.v1();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int P(ki8 ki8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ki8Var)) == null) {
            if (ki8Var == null || ki8Var.Q() == null) {
                return 0;
            }
            if (ki8Var.Q().isMutiForumThread()) {
                if (ListUtils.isEmpty(ki8Var.p()) && (ki8Var.h() == null || StringUtils.isNull(ki8Var.h().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void Z(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        ki8 ki8Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, videoPbVideoInfoViewHolder) != null) || (ki8Var = this.c) == null) {
            return;
        }
        this.e = ki8Var.j;
        if (ki8Var.Q() != null) {
            boolean z2 = false;
            if (this.c.Q().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.g = z;
            if (this.c.Q().getIs_top() == 1) {
                z2 = true;
            }
            this.f = z2;
        }
        videoPbVideoInfoViewHolder.m(this.e, this.g, this.f);
    }

    public final boolean R(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, threadData)) == null) {
            if (threadData != null && threadData.getPollData() != null && threadData.getPollData().getOptions() != null && threadData.getPollData().getOptions().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void S(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, videoPbVideoInfoViewHolder) != null) || videoPbVideoInfoViewHolder == null) {
            return;
        }
        videoPbVideoInfoViewHolder.k(this.d);
        if (!this.i && !this.j && !this.k) {
            z = false;
        } else {
            z = true;
        }
        videoPbVideoInfoViewHolder.n(z);
        videoPbVideoInfoViewHolder.m(this.e, this.g, this.f);
        videoPbVideoInfoViewHolder.l();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.tm
    /* renamed from: T */
    public VideoPbVideoInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d072f, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, absVideoPbFragment);
            videoPbVideoInfoViewHolder.p(this.m);
            S(videoPbVideoInfoViewHolder);
            this.viewholder = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View U(int i, View view2, ViewGroup viewGroup, bc9 bc9Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bc9Var, videoPbVideoInfoViewHolder})) == null) {
            ki8 ki8Var = this.c;
            if (ki8Var != null && ki8Var.Q() != null && bc9Var != null) {
                mp8.d(this.a.getUniqueId(), this.c, bc9Var, 1, 1);
                Z(videoPbVideoInfoViewHolder);
                L(videoPbVideoInfoViewHolder, bc9Var);
                M(videoPbVideoInfoViewHolder, bc9Var);
                N(videoPbVideoInfoViewHolder, bc9Var);
                J(videoPbVideoInfoViewHolder, this.c, O());
                S(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.G.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void V(bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, bc9Var) == null) && bc9Var != null && bc9Var.r() != null) {
            String userId = bc9Var.r().getUserId();
            ki8 ki8Var = this.c;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            ki8 ki8Var2 = this.c;
            if (ki8Var2 != null) {
                str2 = ki8Var2.n();
            }
            int E = bc9Var.E();
            String O = bc9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, E);
            if (bc9Var.r().getAlaInfo() != null) {
                AlaInfoData alaInfo = bc9Var.r().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Y(TextView textView, bc9 bc9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, textView, bc9Var) == null) {
            if (textView == null && bc9Var == null) {
                return;
            }
            textView.setTag(bc9Var);
            ki8 ki8Var = this.c;
            if (ki8Var != null && ki8Var.l0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (bc9Var.r() != null) {
                MetaData r = bc9Var.r();
                String str = this.l;
                if (str != null && !str.equals("0") && this.l.equals(r.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    n15 d2 = n15.d(textView);
                    d2.w(R.color.CAM_X0302);
                    d2.o(R.string.J_X04);
                    d2.m(R.dimen.L_X01);
                    d2.l(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && bc9Var.u0()) {
                    n15 d3 = n15.d(textView);
                    d3.w(R.color.CAM_X0101);
                    d3.o(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    n15 d4 = n15.d(textView);
                    d4.w(R.color.CAM_X0101);
                    d4.o(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    n15 d5 = n15.d(textView);
                    d5.w(R.color.CAM_X0101);
                    d5.o(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    n15 d6 = n15.d(textView);
                    d6.w(R.color.CAM_X0101);
                    d6.o(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    n15 d7 = n15.d(textView);
                    d7.w(R.color.CAM_X0101);
                    d7.o(R.string.J_X04);
                    d7.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_manage_assist_tip);
                } else {
                    textView.setVisibility(8);
                }
            } else {
                textView.setVisibility(8);
            }
        }
    }

    public final void a0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, bc9 bc9Var) {
        ki8 ki8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, bc9Var) == null) && (ki8Var = this.c) != null && ki8Var.Q() != null) {
            this.d = 0;
            if (!this.c.Q().isMutiForumThread()) {
                if (bc9Var != null && bc9Var.r() != null) {
                    this.d = bc9Var.r().getLevel_id();
                }
                if (!this.c.l0()) {
                    videoPbVideoInfoViewHolder.i.setVisibility(0);
                    videoPbVideoInfoViewHolder.k(this.d);
                    return;
                }
                videoPbVideoInfoViewHolder.i.setVisibility(8);
                return;
            }
            videoPbVideoInfoViewHolder.i.setVisibility(8);
        }
    }

    public final void e0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, videoPbVideoInfoViewHolder, metaData) == null) && this.c != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.j.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.j.h(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final void b0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoPbVideoInfoViewHolder, metaData, bc9Var) == null) && this.c != null && metaData != null && bc9Var != null) {
            videoPbVideoInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.d.getHeadView().setTid(bc9Var.O());
            ki8 ki8Var = this.c;
            String str2 = "";
            if (ki8Var == null) {
                str = "";
            } else {
                str = ki8Var.m();
            }
            videoPbVideoInfoViewHolder.d.getHeadView().setFid(str);
            ki8 ki8Var2 = this.c;
            if (ki8Var2 != null) {
                str2 = ki8Var2.n();
            }
            videoPbVideoInfoViewHolder.d.getHeadView().setFName(str2);
            videoPbVideoInfoViewHolder.d.i(metaData);
            videoPbVideoInfoViewHolder.d.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.h(true);
                videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(bc9Var.r().getAlaInfo());
                V(bc9Var);
                return;
            }
            videoPbVideoInfoViewHolder.h(false);
            videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(null);
        }
    }

    public final void c0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, bc9 bc9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, videoPbVideoInfoViewHolder, metaData, bc9Var) == null) && this.c != null && bc9Var != null && bc9Var.r() != null) {
            ki8 ki8Var = this.c;
            if (ki8Var != null) {
                str = ki8Var.S();
            } else {
                str = "";
            }
            int P = P(this.c);
            int i = 4;
            if (this.c.Q() != null && this.c.Q().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.h == null) {
                lm8 lm8Var = new lm8(this.a.getPageContext(), videoPbVideoInfoViewHolder.m, i);
                this.h = lm8Var;
                lm8Var.l(this.a.getUniqueId());
            }
            bc9Var.r().setIsLike(bc9Var.r().hadConcerned());
            this.h.n(bc9Var.r());
            this.h.z(str);
            this.h.x(this.c.Q());
            lm8 lm8Var2 = this.h;
            lm8Var2.p = true;
            lm8Var2.y(P);
            if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoPbVideoInfoViewHolder.m.setVisibility(8);
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoPbVideoInfoViewHolder.m.setVisibility(8);
            }
            if (this.c.i) {
                videoPbVideoInfoViewHolder.m.setVisibility(8);
            }
        }
    }

    public final void f0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048597, this, videoPbVideoInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.i = true;
            videoPbVideoInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.i = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(hi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f.i(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.tm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, bc9 bc9Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        U(i, view2, viewGroup, bc9Var, videoPbVideoInfoViewHolder);
        return view2;
    }
}
