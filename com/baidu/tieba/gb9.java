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
/* loaded from: classes5.dex */
public class gb9 extends in<ey9, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public j39 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public q79 g;
    public boolean h;
    public boolean i;
    public boolean j;
    public boolean k;
    public String l;
    public View.OnClickListener m;
    public CustomMessageListener n;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb9 a;

        public a(gb9 gb9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gb9Var;
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
                if (view2.getId() == R.id.obfuscated_res_0x7f09284c) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092847) {
                    if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                        return;
                    }
                    qx4.x(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f09283a) {
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092846) {
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
                        statisticItem3.param("tid", this.a.b.P());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str, str2, str3, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092835 && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.l());
                    statisticItem4.param("tid", this.a.b.P());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.i().O());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).q3());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092815) {
                    if (this.a.mContext == null) {
                        return;
                    }
                    qx4.v(this.a.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true);
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092842 && this.a.mContext != null && this.a.b != null && this.a.b.N() != null && this.a.b.N().getAuthor() != null && StringUtils.isNotNull(this.a.b.N().getAuthor().getPortrait())) {
                    tx5.d(this.a.b.l(), this.a.b.N().getAuthor().getPortrait(), "2", this.a.mContext);
                    ux5.c("c15281", this.a.b.l(), "2");
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MetaData a;
        public final /* synthetic */ gb9 b;

        public b(gb9 gb9Var, MetaData metaData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb9Var, metaData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = gb9Var;
            this.a = metaData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.getPortrait() != null && !TextUtils.isEmpty(this.a.getPortrait())) {
                z26.a(this.b.a.getPageContext(), this.a.getPortrait(), null, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class c extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gb9 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(gb9 gb9Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gb9Var, Integer.valueOf(i)};
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
            this.a = gb9Var;
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
    public gb9(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
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

    public final void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, ey9 ey9Var) {
        j39 j39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, ey9Var) == null) && (j39Var = this.b) != null && j39Var.N() != null && ey9Var != null) {
            videoTabPbFloatUserInfoViewHolder.s(this.b.N().getRichTitle(), this.b.N().getTitle(), this.b.N(), K(ey9Var), this.b.x0());
            videoTabPbFloatUserInfoViewHolder.r(this.mContext, ey9Var);
        }
    }

    public final void T(TextView textView, ey9 ey9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048589, this, textView, ey9Var) == null) && textView != null && ey9Var != null) {
            textView.setTag(ey9Var);
            if (ey9Var.p() != null && StringHelper.equals(this.l, ey9Var.p().getUserId())) {
                textView.setVisibility(0);
                m75 d = m75.d(textView);
                d.w(R.color.CAM_X0101);
                d.o(R.string.J_X04);
                d.f(R.color.CAM_X0302);
                textView.setText(R.string.host_name);
                return;
            }
            textView.setVisibility(8);
        }
    }

    public final void W(TbImageView tbImageView, ey9 ey9Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, tbImageView, ey9Var) == null) && tbImageView != null && ey9Var != null && TbSingleton.getInstance().isUserGrowthOpen() && ey9Var.p().getUserGrowthData() != null) {
            int a2 = ey9Var.p().getUserGrowthData().a();
            if (a2 >= 0 && a2 <= 10) {
                tbImageView.setImageResource(yx.b(a2));
                tbImageView.setVisibility(0);
                return;
            }
            tbImageView.setVisibility(8);
        }
    }

    public final void Y(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
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

    public final void b0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) && this.b != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoTabPbFloatUserInfoViewHolder.l.setTag(R.id.tag_user_id, metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.l.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final boolean K(ey9 ey9Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, ey9Var)) == null) {
            if (ey9Var != null && ListUtils.getCount(ey9Var.i0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void Q(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.k = z;
        }
    }

    public void R(j39 j39Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, j39Var) == null) {
            this.b = j39Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.l = str;
        }
    }

    public final void F(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, ey9 ey9Var) {
        j39 j39Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, ey9Var) == null) && (j39Var = this.b) != null && j39Var.N() != null && this.b.N().getAuthor() != null && ey9Var != null) {
            X(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor(), ey9Var);
            c0(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            a0(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            T(videoTabPbFloatUserInfoViewHolder.i, ey9Var);
            W(videoTabPbFloatUserInfoViewHolder.j, ey9Var);
            V(videoTabPbFloatUserInfoViewHolder, ey9Var);
            b0(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            S(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            Z(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor(), ey9Var);
            Y(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            I(videoTabPbFloatUserInfoViewHolder, this.b.N().getAuthor());
            videoTabPbFloatUserInfoViewHolder.d(this.b.N().getAuthor());
        }
    }

    public final void c0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048598, this, videoTabPbFloatUserInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.g.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams.setMargins(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.h.getLayoutParams();
            layoutParams2.setMargins(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.g.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public final void H(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, ey9 ey9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, ey9Var) == null) {
            videoTabPbFloatUserInfoViewHolder.q(8, null);
            j39 j39Var = this.b;
            if (j39Var != null && j39Var.N() != null && ey9Var != null) {
                if (ey9Var.S) {
                    videoTabPbFloatUserInfoViewHolder.q(0, ey9Var.O());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).O4(ey9Var.S);
                }
            }
        }
    }

    public final void I(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
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

    public final void a0(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
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

    public final int J(j39 j39Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, j39Var)) == null) {
            if (j39Var == null || j39Var.N() == null) {
                return 0;
            }
            if (j39Var.N().isMutiForumThread()) {
                if (ListUtils.isEmpty(j39Var.o()) && (j39Var.g() == null || StringUtils.isNull(j39Var.g().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void U(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        j39 j39Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, videoTabPbFloatUserInfoViewHolder) != null) || (j39Var = this.b) == null) {
            return;
        }
        this.d = j39Var.j;
        if (j39Var.N() != null) {
            boolean z2 = false;
            if (this.b.N().getIs_good() == 1) {
                z = true;
            } else {
                z = false;
            }
            this.f = z;
            if (this.b.N().getIs_top() == 1) {
                z2 = true;
            }
            this.e = z2;
        }
        videoTabPbFloatUserInfoViewHolder.m(this.d, this.f, this.e);
    }

    public void M(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
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
    @Override // com.baidu.tieba.in
    /* renamed from: N */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0773, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, absVideoPbFragment);
            videoTabPbFloatUserInfoViewHolder.p(this.m);
            M(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View O(int i, View view2, ViewGroup viewGroup, ey9 ey9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, ey9Var, videoTabPbFloatUserInfoViewHolder})) == null) {
            j39 j39Var = this.b;
            if (j39Var != null && j39Var.N() != null && ey9Var != null) {
                ya9.d(this.a.getUniqueId(), this.b, ey9Var, 1, 1);
                U(videoTabPbFloatUserInfoViewHolder);
                F(videoTabPbFloatUserInfoViewHolder, ey9Var);
                G(videoTabPbFloatUserInfoViewHolder, ey9Var);
                H(videoTabPbFloatUserInfoViewHolder, ey9Var);
                M(videoTabPbFloatUserInfoViewHolder);
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

    public final void P(ey9 ey9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, ey9Var) == null) && ey9Var != null && ey9Var.p() != null) {
            String userId = ey9Var.p().getUserId();
            j39 j39Var = this.b;
            String str2 = "";
            if (j39Var == null) {
                str = "";
            } else {
                str = j39Var.l();
            }
            j39 j39Var2 = this.b;
            if (j39Var2 != null) {
                str2 = j39Var2.m();
            }
            int D = ey9Var.D();
            String O = ey9Var.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, D);
            if (ey9Var.p().getAlaInfo() != null) {
                AlaInfoData alaInfo = ey9Var.p().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
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
                layoutParams.setMargins(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.m.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.m.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.n.getLayoutParams();
            layoutParams2.setMargins(vi.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.m.setVisibility(8);
        }
    }

    public final void V(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, ey9 ey9Var) {
        j39 j39Var;
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048591, this, videoTabPbFloatUserInfoViewHolder, ey9Var) == null) && (j39Var = this.b) != null && j39Var.N() != null) {
            this.c = 0;
            if (!this.b.N().isMutiForumThread()) {
                if (ey9Var != null && ey9Var.p() != null) {
                    this.c = ey9Var.p().getLevel_id();
                    str = ey9Var.p().getLevelName();
                } else {
                    str = "";
                }
                if (!this.b.i0()) {
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

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, ey9 ey9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData, ey9Var) == null) && this.b != null && metaData != null && ey9Var != null) {
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserId(metaData.getUserId());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setUserName(metaData.getUserName());
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setTid(ey9Var.O());
            j39 j39Var = this.b;
            String str2 = "";
            if (j39Var == null) {
                str = "";
            } else {
                str = j39Var.l();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFid(str);
            j39 j39Var2 = this.b;
            if (j39Var2 != null) {
                str2 = j39Var2.m();
            }
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setFName(str2);
            videoTabPbFloatUserInfoViewHolder.e.i(metaData);
            videoTabPbFloatUserInfoViewHolder.e.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoTabPbFloatUserInfoViewHolder.h(true);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(1);
                videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(ey9Var.p().getAlaInfo());
                P(ey9Var);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.h(false);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setLiveStatus(0);
            videoTabPbFloatUserInfoViewHolder.e.getHeadView().setAlaInfo(null);
        }
    }

    public final void Z(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, ey9 ey9Var) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData, ey9Var) == null) && this.b != null && ey9Var != null && ey9Var.p() != null) {
            j39 j39Var = this.b;
            if (j39Var == null) {
                str = "";
            } else {
                str = j39Var.P();
            }
            int J = J(this.b);
            int i = 4;
            if (this.b.N() != null && this.b.N().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.g == null) {
                q79 q79Var = new q79(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.o, i);
                this.g = q79Var;
                q79Var.l(this.a.getUniqueId());
            }
            ey9Var.p().setIsLike(ey9Var.p().hadConcerned());
            this.g.n(ey9Var.p());
            this.g.z(str);
            this.g.x(this.b.N());
            q79 q79Var2 = this.g;
            q79Var2.p = true;
            q79Var2.y(J);
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
            if (ey9Var.p().getIsLike()) {
                videoTabPbFloatUserInfoViewHolder.o.setVisibility(8);
                videoTabPbFloatUserInfoViewHolder.o.setText("");
                videoTabPbFloatUserInfoViewHolder.f();
            }
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, ey9 ey9Var, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        O(i, view2, viewGroup, ey9Var, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
