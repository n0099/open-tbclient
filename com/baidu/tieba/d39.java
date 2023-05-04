package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.HeadWorldCupFlagLayout;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.AlaUserInfoData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
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
import com.baidu.tbadk.switchs.WorldCupEnableSwitch;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d39 extends vm<pp9, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public qv8 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public rz8 g;
    public boolean h;
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
        public final /* synthetic */ d39 a;

        public a(d39 d39Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d39Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d39Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            String str3;
            long j;
            String str4;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f0927a4) {
                    if (!ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        return;
                    }
                    if (view2.getTag() != null) {
                        str4 = (String) view2.getTag();
                    } else {
                        str4 = null;
                    }
                    if (str4 != null) {
                        UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str4});
                    }
                    TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09279f) {
                    if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                        return;
                    }
                    pt4.x(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092792) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09279e) {
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
                    if (this.a.b != null && this.a.b.k() != null) {
                        str3 = this.a.b.k().getName();
                    } else {
                        str3 = null;
                    }
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (this.a.b != null) {
                        statisticItem3.param("fid", this.a.b.l());
                        statisticItem3.param("tid", this.a.b.O());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09278d && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.l());
                    statisticItem4.param("tid", this.a.b.O());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.i().N());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).o3());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f09276e || this.a.mContext == null) {
                } else {
                    pt4.v(this.a.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ d39 b;

        public b(d39 d39Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d39Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = d39Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getPortrait() != null && !TextUtils.isEmpty(this.a.getPortrait())) {
                mx5.a(this.b.a.getPageContext(), this.a.getPortrait(), null, null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d39 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(d39 d39Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d39Var, Integer.valueOf(i)};
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
            this.a = d39Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && this.a.viewholder != null && ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q != null) {
                ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).q.setTextSize(TbConfig.getContentSize());
                this.a.notifyDataSetChanged();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d39(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, bdUniqueId};
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
        c cVar = new c(this, 2004018);
        this.n = cVar;
        this.a = baseFragment;
        baseFragment.registerListener(cVar);
    }

    public final void E(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, pp9 pp9Var) {
        qv8 qv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, pp9Var) == null) && (qv8Var = this.b) != null && qv8Var.M() != null && pp9Var != null) {
            videoTabPbFloatUserInfoViewHolder.s(this.b.M().getRichTitle(), this.b.M().getTitle(), this.b.M(), I(pp9Var), this.b.w0());
            videoTabPbFloatUserInfoViewHolder.r(this.mContext, pp9Var);
        }
    }

    public final void R(TextView textView, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, textView, pp9Var) == null) && textView != null && pp9Var != null) {
            textView.setTag(pp9Var);
            if (pp9Var.p() != null && StringHelper.equals(this.l, pp9Var.p().getUserId())) {
                textView.setVisibility(0);
                g35 d = g35.d(textView);
                d.w(R.color.CAM_X0101);
                d.o(R.string.J_X04);
                d.f(R.color.CAM_X0302);
                textView.setText(R.string.host_name);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void U(TbImageView tbImageView, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, tbImageView, pp9Var) == null) && tbImageView != null && pp9Var != null && TbSingleton.getInstance().isUserGrowthOpen() && pp9Var.p().getUserGrowthData() != null) {
            int a2 = pp9Var.p().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                tbImageView.setImageResource(vw.b(a2));
                tbImageView.setVisibility(0);
                return;
            }
            tbImageView.setVisibility(8);
        }
    }

    public final void W(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && metaData != null && this.b != null) {
            String ipAddress = metaData.getIpAddress();
            if (!TextUtils.isEmpty(ipAddress)) {
                TextView textView = videoTabPbFloatUserInfoViewHolder.u;
                textView.setText(TbadkCoreApplication.getInst().getString(R.string.user_ip_address) + ipAddress);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.u.setVisibility(8);
        }
    }

    public final void Z(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && this.b != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoTabPbFloatUserInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final boolean I(pp9 pp9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, pp9Var)) == null) {
            if (pp9Var != null && ListUtils.getCount(pp9Var.i0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void O(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public void P(qv8 qv8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, qv8Var) == null) {
            this.b = qv8Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public final void D(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, pp9 pp9Var) {
        qv8 qv8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, pp9Var) == null) && (qv8Var = this.b) != null && qv8Var.M() != null && this.b.M().getAuthor() != null && pp9Var != null) {
            V(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor(), pp9Var);
            a0(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            Y(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            R(videoTabPbFloatUserInfoViewHolder.i, pp9Var);
            U(videoTabPbFloatUserInfoViewHolder.j, pp9Var);
            T(videoTabPbFloatUserInfoViewHolder, pp9Var);
            Z(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            Q(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            X(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor(), pp9Var);
            W(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            G(videoTabPbFloatUserInfoViewHolder, this.b.M().getAuthor());
            videoTabPbFloatUserInfoViewHolder.d(this.b.M().getAuthor());
        }
    }

    public final void a0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.g.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams2.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.g.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public final void F(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, pp9 pp9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, pp9Var) == null) {
            videoTabPbFloatUserInfoViewHolder.q(8, null);
            qv8 qv8Var = this.b;
            if (qv8Var != null && qv8Var.M() != null && pp9Var != null) {
                if (pp9Var.S) {
                    videoTabPbFloatUserInfoViewHolder.q(0, pp9Var.N());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).M4(pp9Var.S);
                }
            }
        }
    }

    public final void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048579, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && videoTabPbFloatUserInfoViewHolder != null && WorldCupEnableSwitch.isOn() && metaData != null) {
            TbImageView tbImageView = videoTabPbFloatUserInfoViewHolder.z;
            if (tbImageView != null) {
                tbImageView.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.z.setImageResource(R.drawable.icon_mask_raise_flag_button);
                videoTabPbFloatUserInfoViewHolder.z.setOnClickListener(new b(this, metaData));
            }
            HeadWorldCupFlagLayout headWorldCupFlagLayout = videoTabPbFloatUserInfoViewHolder.A;
            if (headWorldCupFlagLayout != null) {
                headWorldCupFlagLayout.b(metaData);
            }
        }
    }

    public final void Y(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.h.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_id, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.h.setTag(R.id.tag_user_name, metaData.getName_show());
        this.i = metaData.isBigV();
        this.j = metaData.isNewGod();
    }

    public final int H(qv8 qv8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, qv8Var)) == null) {
            if (qv8Var == null || qv8Var.M() == null) {
                return 0;
            }
            if (qv8Var.M().isMutiForumThread()) {
                if (ListUtils.isEmpty(qv8Var.o()) && (qv8Var.g() == null || StringUtils.isNull(qv8Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        qv8 qv8Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, videoTabPbFloatUserInfoViewHolder) != null) || (qv8Var = this.b) == null) {
            return;
        }
        this.d = qv8Var.j;
        if (qv8Var.M() != null) {
            boolean z2 = false;
            if (this.b.M().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if (this.b.M().getIs_top() == 1) {
                z2 = true;
            }
            this.e = z2;
        }
        videoTabPbFloatUserInfoViewHolder.m(this.d, this.f, this.e);
    }

    public void J(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, videoTabPbFloatUserInfoViewHolder) != null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.k(this.c);
        if (!this.h && !this.i && !this.j) {
            z = false;
        } else {
            z = true;
        }
        videoTabPbFloatUserInfoViewHolder.n(z);
        videoTabPbFloatUserInfoViewHolder.m(this.d, this.f, this.e);
        videoTabPbFloatUserInfoViewHolder.l();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.vm
    /* renamed from: K */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d073b, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, absVideoPbFragment);
            videoTabPbFloatUserInfoViewHolder.p(this.m);
            J(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View M(int i, View view2, ViewGroup viewGroup, pp9 pp9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, pp9Var, videoTabPbFloatUserInfoViewHolder})) == null) {
            qv8 qv8Var = this.b;
            if (qv8Var != null && qv8Var.M() != null && pp9Var != null) {
                v29.d(this.a.getUniqueId(), this.b, pp9Var, 1, 1);
                S(videoTabPbFloatUserInfoViewHolder);
                D(videoTabPbFloatUserInfoViewHolder, pp9Var);
                E(videoTabPbFloatUserInfoViewHolder, pp9Var);
                F(videoTabPbFloatUserInfoViewHolder, pp9Var);
                J(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.s.setVisibility(8);
                if (this.k) {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = videoTabPbFloatUserInfoViewHolder.t.getLayoutParams();
                    layoutParams.height = view2.getHeight();
                    videoTabPbFloatUserInfoViewHolder.t.setLayoutParams(layoutParams);
                    videoTabPbFloatUserInfoViewHolder.t.bringToFront();
                } else {
                    videoTabPbFloatUserInfoViewHolder.t.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void N(pp9 pp9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, pp9Var) == null) && pp9Var != null && pp9Var.p() != null) {
            String userId = pp9Var.p().getUserId();
            qv8 qv8Var = this.b;
            String str2 = "";
            if (qv8Var == null) {
                str = "";
            } else {
                str = qv8Var.l();
            }
            qv8 qv8Var2 = this.b;
            if (qv8Var2 != null) {
                str2 = qv8Var2.m();
            }
            int D = pp9Var.D();
            String N = pp9Var.N();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", N);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (pp9Var.p().getAlaInfo() != null) {
                AlaInfoData alaInfo = pp9Var.p().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void Q(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.b != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.n;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.fans_default_name));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
                layoutParams.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.m.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.m.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
            layoutParams2.setMargins(ii.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void T(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, pp9 pp9Var) {
        qv8 qv8Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, videoTabPbFloatUserInfoViewHolder, pp9Var) == null) && (qv8Var = this.b) != null && qv8Var.M() != null) {
            this.c = 0;
            if (!this.b.M().isMutiForumThread()) {
                if (pp9Var != null && pp9Var.p() != null) {
                    this.c = pp9Var.p().getLevel_id();
                    str = pp9Var.p().getLevelName();
                } else {
                    str = "";
                }
                if (!this.b.h0()) {
                    videoTabPbFloatUserInfoViewHolder.k.setVisibility(0);
                    videoTabPbFloatUserInfoViewHolder.k.setLevel(this.c, str);
                    return;
                }
                videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void V(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, pp9 pp9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, pp9Var) == null) && this.b != null && metaData != null && pp9Var != null) {
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserId(metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserName(metaData.getUserName());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setTid(pp9Var.N());
            qv8 qv8Var = this.b;
            String str2 = "";
            if (qv8Var == null) {
                str = "";
            } else {
                str = qv8Var.l();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFid(str);
            qv8 qv8Var2 = this.b;
            if (qv8Var2 != null) {
                str2 = qv8Var2.m();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFName(str2);
            videoTabPbFloatUserInfoViewHolder.e.i(metaData);
            videoTabPbFloatUserInfoViewHolder.e.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoTabPbFloatUserInfoViewHolder.h(true);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(1);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(pp9Var.p().getAlaInfo());
                N(pp9Var);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.h(false);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(0);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(null);
        }
    }

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, pp9 pp9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData, pp9Var) == null) && this.b != null && pp9Var != null && pp9Var.p() != null) {
            qv8 qv8Var = this.b;
            if (qv8Var == null) {
                str = "";
            } else {
                str = qv8Var.O();
            }
            int H = H(this.b);
            int i = 4;
            if (this.b.M() != null && this.b.M().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.g == null) {
                rz8 rz8Var = new rz8(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.o, i);
                this.g = rz8Var;
                rz8Var.l(this.a.getUniqueId());
            }
            pp9Var.p().setIsLike(pp9Var.p().hadConcerned());
            this.g.n(pp9Var.p());
            this.g.z(str);
            this.g.x(this.b.M());
            rz8 rz8Var2 = this.g;
            rz8Var2.p = true;
            rz8Var2.y(H);
            this.g.k(true);
            if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
                videoTabPbFloatUserInfoViewHolder.f();
            } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
                videoTabPbFloatUserInfoViewHolder.f();
            }
            if (this.b.i) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
                videoTabPbFloatUserInfoViewHolder.f();
            }
            if (pp9Var.p().getIsLike()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
                videoTabPbFloatUserInfoViewHolder.f();
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.vm
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, pp9 pp9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        M(i, view2, viewGroup, pp9Var, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
