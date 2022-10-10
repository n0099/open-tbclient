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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddFriendActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
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
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.pb.videopb.AbsVideoPbFragment;
import com.baidu.tieba.pb.videopb.VideoPbCommentFloatFragment;
import com.baidu.tieba.pb.videopb.viewholder.VideoTabPbFloatUserInfoViewHolder;
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g38 extends qn<PostData, VideoTabPbFloatUserInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    public jv7 b;
    public int c;
    public boolean d;
    public boolean e;
    public boolean f;
    public kz7 g;
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
        public final /* synthetic */ g38 a;

        public a(g38 g38Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g38Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = g38Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() == R.id.obfuscated_res_0x7f092587) {
                    if (ViewHelper.checkUpIsLogin(TbadkCoreApplication.getInst())) {
                        String str = view2.getTag() != null ? (String) view2.getTag() : null;
                        if (str != null) {
                            UrlManager.getInstance().dealOneLink(this.a.a.getPageContext(), new String[]{str});
                        }
                        TiebaStatic.eventStat(this.a.a.getPageContext().getPageActivity(), "consume_2", "click", 1, new Object[0]);
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092582) {
                    if (view2.getTag(R.id.obfuscated_res_0x7f092092) instanceof String) {
                        yo4.s(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150a), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.obfuscated_res_0x7f092092)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092575) {
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
                        statisticItem.param("obj_param1", alaUserInfoData != null ? alaUserInfoData.user_id : 0L);
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
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092581) {
                    TiebaStatic.log(new StatisticItem("c11923").param("obj_id", 2));
                    String str2 = view2.getTag(R.id.obfuscated_res_0x7f092092) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f092092) : null;
                    String str3 = view2.getTag(R.id.obfuscated_res_0x7f09209a) instanceof String ? (String) view2.getTag(R.id.obfuscated_res_0x7f09209a) : null;
                    String name = (this.a.b == null || this.a.b.l() == null) ? null : this.a.b.l().getName();
                    StatisticItem statisticItem3 = new StatisticItem("c13267");
                    statisticItem3.param("uid", str2);
                    if (this.a.b != null) {
                        statisticItem3.param("fid", this.a.b.m());
                        statisticItem3.param("tid", this.a.b.Q());
                    }
                    statisticItem3.param("obj_source", TbadkCoreApplication.getInst().getTaskId());
                    TiebaStatic.log(statisticItem3);
                    if (str2 != null) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, str2, str3, name, AddFriendActivityConfig.TYPE_PB_HEAD)));
                    }
                } else if (view2.getId() == R.id.obfuscated_res_0x7f092570 && (this.a.a instanceof VideoPbCommentFloatFragment)) {
                    StatisticItem statisticItem4 = new StatisticItem(TbadkCoreStatisticKey.KEY_VIDEO_TAB_COMMENT_FLOAT_CLICK);
                    statisticItem4.param("fid", this.a.b.m());
                    statisticItem4.param("tid", this.a.b.Q());
                    statisticItem4.param("uid", TbadkCoreApplication.getCurrentAccount());
                    statisticItem4.param("post_id", this.a.b.j().L());
                    statisticItem4.param("obj_source", 1);
                    statisticItem4.param("obj_type", 15);
                    statisticItem4.param("obj_locate", ((VideoPbCommentFloatFragment) this.a.a).L3());
                    TiebaStatic.log(statisticItem4);
                } else if (view2.getId() != R.id.obfuscated_res_0x7f09254d || this.a.mContext == null) {
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(this.a.mContext, null, TbConfig.USER_GROWTH_TASK_CENTER_MAIN_URL, true)));
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ g38 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(g38 g38Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g38Var, Integer.valueOf(i)};
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
            this.a = g38Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || this.a.viewholder == null || ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).p == null) {
                return;
            }
            ((VideoTabPbFloatUserInfoViewHolder) this.a.viewholder).p.setTextSize(TbConfig.getContentSize());
            this.a.notifyDataSetChanged();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g38(BaseFragment baseFragment, BdUniqueId bdUniqueId) {
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
        b bVar = new b(this, 2004018);
        this.n = bVar;
        this.a = baseFragment;
        baseFragment.registerListener(bVar);
    }

    public final void B(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (jv7Var = this.b) == null || jv7Var.O() == null || this.b.O().getAuthor() == null || postData == null) {
            return;
        }
        S(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor(), postData);
        X(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
        V(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
        O(videoTabPbFloatUserInfoViewHolder.h, postData);
        R(videoTabPbFloatUserInfoViewHolder.i, postData);
        Q(videoTabPbFloatUserInfoViewHolder, postData);
        W(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
        N(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
        U(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor(), postData);
        T(videoTabPbFloatUserInfoViewHolder, this.b.O().getAuthor());
    }

    public final void C(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (jv7Var = this.b) == null || jv7Var.O() == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.m(this.b.O().getRichTitle(), this.b.O().getTitle(), this.b.O(), F(postData), this.b.v0());
        videoTabPbFloatUserInfoViewHolder.l(this.mContext, postData);
    }

    public final void D(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoTabPbFloatUserInfoViewHolder, postData) == null) {
            videoTabPbFloatUserInfoViewHolder.k(8, null);
            jv7 jv7Var = this.b;
            if (jv7Var == null || jv7Var.O() == null || postData == null) {
                return;
            }
            if (postData.R) {
                videoTabPbFloatUserInfoViewHolder.k(0, postData.L());
            }
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                ((AbsVideoPbFragment) baseFragment).R5(postData.R);
            }
        }
    }

    public final int E(jv7 jv7Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, jv7Var)) == null) {
            if (jv7Var == null || jv7Var.O() == null) {
                return 0;
            }
            if (jv7Var.O().isMutiForumThread()) {
                return (ListUtils.isEmpty(jv7Var.p()) && (jv7Var.h() == null || StringUtils.isNull(jv7Var.h().c()))) ? 0 : 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final boolean F(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, postData)) == null) ? postData != null && ListUtils.getCount(postData.h0) >= 2 : invokeL.booleanValue;
    }

    public void G(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, videoTabPbFloatUserInfoViewHolder) == null) || videoTabPbFloatUserInfoViewHolder == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.f(this.c);
        videoTabPbFloatUserInfoViewHolder.i(this.h || this.i || this.j);
        videoTabPbFloatUserInfoViewHolder.h(this.d, this.f, this.e);
        videoTabPbFloatUserInfoViewHolder.g();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.qn
    /* renamed from: H */
    public VideoTabPbFloatUserInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d06d8, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder = new VideoTabPbFloatUserInfoViewHolder(context, inflate, baseFragment instanceof AbsVideoPbFragment ? (AbsVideoPbFragment) baseFragment : null);
            videoTabPbFloatUserInfoViewHolder.j(this.m);
            G(videoTabPbFloatUserInfoViewHolder);
            this.viewholder = videoTabPbFloatUserInfoViewHolder;
            return videoTabPbFloatUserInfoViewHolder;
        }
        return (VideoTabPbFloatUserInfoViewHolder) invokeL.objValue;
    }

    public View I(int i, View view2, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, videoTabPbFloatUserInfoViewHolder})) == null) {
            jv7 jv7Var = this.b;
            if (jv7Var != null && jv7Var.O() != null && postData != null) {
                j28.d(this.a.getUniqueId(), this.b, postData, 1, 1);
                P(videoTabPbFloatUserInfoViewHolder);
                B(videoTabPbFloatUserInfoViewHolder, postData);
                C(videoTabPbFloatUserInfoViewHolder, postData);
                D(videoTabPbFloatUserInfoViewHolder, postData);
                G(videoTabPbFloatUserInfoViewHolder);
                videoTabPbFloatUserInfoViewHolder.r.setVisibility(8);
                if (this.k) {
                    videoTabPbFloatUserInfoViewHolder.s.setVisibility(0);
                    ViewGroup.LayoutParams layoutParams = videoTabPbFloatUserInfoViewHolder.s.getLayoutParams();
                    layoutParams.height = view2.getHeight();
                    videoTabPbFloatUserInfoViewHolder.s.setLayoutParams(layoutParams);
                    videoTabPbFloatUserInfoViewHolder.s.bringToFront();
                } else {
                    videoTabPbFloatUserInfoViewHolder.s.setVisibility(8);
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void K(PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, postData) == null) || postData == null || postData.s() == null) {
            return;
        }
        String userId = postData.s().getUserId();
        jv7 jv7Var = this.b;
        String m = jv7Var != null ? jv7Var.m() : "";
        jv7 jv7Var2 = this.b;
        String n = jv7Var2 != null ? jv7Var2.n() : "";
        int C = postData.C();
        String L = postData.L();
        StatisticItem statisticItem = new StatisticItem("c13714");
        statisticItem.param("fid", m);
        statisticItem.param("fname", n);
        statisticItem.param("obj_param1", userId);
        statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
        statisticItem.param("tid", L);
        statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, C);
        if (postData.s().getAlaInfo() != null) {
            AlaInfoData alaInfo = postData.s().getAlaInfo();
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
            if (alaInfo.mYyExtData != null) {
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
            }
        }
        TiebaStatic.log(statisticItem);
    }

    public void L(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048585, this, z) == null) {
            this.k = z;
        }
    }

    public void M(jv7 jv7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, jv7Var) == null) {
            this.b = jv7Var;
        }
    }

    public final void N(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) {
            if (this.b != null && metaData != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(metaData.getFansNum());
                TextView textView = videoTabPbFloatUserInfoViewHolder.m;
                textView.setText(numberUniformFormatExtra + TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f0611));
            }
            String authInfo = UtilHelper.getAuthInfo(metaData, false, 24);
            if (!TextUtils.isEmpty(authInfo)) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.m.getLayoutParams();
                layoutParams.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoTabPbFloatUserInfoViewHolder.l.setText(authInfo);
                videoTabPbFloatUserInfoViewHolder.l.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.m.getLayoutParams();
            layoutParams2.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoTabPbFloatUserInfoViewHolder.l.setVisibility(8);
        }
    }

    public final void O(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048588, this, textView, postData) == null) || textView == null || postData == null) {
            return;
        }
        textView.setTag(postData);
        if (postData.s() != null && StringHelper.equals(this.l, postData.s().getUserId())) {
            textView.setVisibility(0);
            hv4 d = hv4.d(textView);
            d.v(R.color.CAM_X0101);
            d.n(R.string.J_X04);
            d.f(R.color.CAM_X0302);
            textView.setText(R.string.obfuscated_res_0x7f0f087d);
            return;
        }
        textView.setVisibility(8);
    }

    public final void P(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, videoTabPbFloatUserInfoViewHolder) == null) || (jv7Var = this.b) == null) {
            return;
        }
        this.d = jv7Var.j;
        if (jv7Var.O() != null) {
            this.f = this.b.O().getIs_good() == 1;
            this.e = this.b.O().getIs_top() == 1;
        }
        videoTabPbFloatUserInfoViewHolder.h(this.d, this.f, this.e);
    }

    public final void Q(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, PostData postData) {
        jv7 jv7Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048590, this, videoTabPbFloatUserInfoViewHolder, postData) == null) || (jv7Var = this.b) == null || jv7Var.O() == null) {
            return;
        }
        this.c = 0;
        if (!this.b.O().isMutiForumThread()) {
            if (postData != null && postData.s() != null) {
                this.c = postData.s().getLevel_id();
            }
            if (!this.b.i0()) {
                videoTabPbFloatUserInfoViewHolder.j.setVisibility(0);
                videoTabPbFloatUserInfoViewHolder.f(this.c);
                return;
            }
            videoTabPbFloatUserInfoViewHolder.j.setVisibility(8);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.j.setVisibility(8);
    }

    public final void R(TbImageView tbImageView, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048591, this, tbImageView, postData) == null) || tbImageView == null || postData == null || !TbSingleton.getInstance().isUserGrowthOpen() || postData.s().getUserGrowthData() == null) {
            return;
        }
        int a2 = postData.s().getUserGrowthData().a();
        if (a2 >= 0 && a2 <= 10) {
            tbImageView.setImageResource(kx.b(a2));
            tbImageView.setVisibility(0);
            return;
        }
        tbImageView.setVisibility(8);
    }

    public final void S(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048592, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.b == null || metaData == null || postData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setTid(postData.L());
        jv7 jv7Var = this.b;
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFid(jv7Var != null ? jv7Var.m() : "");
        jv7 jv7Var2 = this.b;
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setFName(jv7Var2 != null ? jv7Var2.n() : "");
        videoTabPbFloatUserInfoViewHolder.d.j(metaData, 4);
        videoTabPbFloatUserInfoViewHolder.d.n(metaData);
        if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
            videoTabPbFloatUserInfoViewHolder.c(true);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(1);
            videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(postData.s().getAlaInfo());
            K(postData);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.c(false);
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setLiveStatus(0);
        videoTabPbFloatUserInfoViewHolder.d.getHeadView().setAlaInfo(null);
    }

    public final void T(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048593, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || videoTabPbFloatUserInfoViewHolder == null || metaData == null || this.b == null) {
            return;
        }
        String ipAddress = metaData.getIpAddress();
        if (!TextUtils.isEmpty(ipAddress)) {
            TextView textView = videoTabPbFloatUserInfoViewHolder.t;
            textView.setText(TbadkCoreApplication.getInst().getString(R.string.obfuscated_res_0x7f0f150b) + ipAddress);
            return;
        }
        videoTabPbFloatUserInfoViewHolder.t.setVisibility(8);
    }

    public final void U(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData, PostData postData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048594, this, videoTabPbFloatUserInfoViewHolder, metaData, postData) == null) || this.b == null || postData == null || postData.s() == null) {
            return;
        }
        jv7 jv7Var = this.b;
        String Q = jv7Var != null ? jv7Var.Q() : "";
        int E = E(this.b);
        int i = 4;
        if (this.b.O() != null && this.b.O().isVideoWorksInfo()) {
            i = 8;
        }
        if (this.g == null) {
            kz7 kz7Var = new kz7(this.a.getPageContext(), videoTabPbFloatUserInfoViewHolder.n, i);
            this.g = kz7Var;
            kz7Var.l(this.a.getUniqueId());
        }
        postData.s().setIsLike(postData.s().hadConcerned());
        this.g.n(postData.s());
        this.g.x(Q);
        this.g.v(this.b.O());
        kz7 kz7Var2 = this.g;
        kz7Var2.p = true;
        kz7Var2.w(E);
        this.g.k(true);
        if (StringHelper.equals(TbadkCoreApplication.getCurrentAccount(), metaData.getUserId())) {
            videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.n.setText("");
        } else if (!PbNormalLikeButtonSwitch.getIsOn()) {
            videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.n.setText("");
        }
        if (this.b.i) {
            videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.n.setText("");
        }
        if (postData.s().getIsLike()) {
            videoTabPbFloatUserInfoViewHolder.n.setVisibility(8);
            videoTabPbFloatUserInfoViewHolder.n.setText("");
        }
    }

    public final void V(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048595, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        videoTabPbFloatUserInfoViewHolder.g.setText(metaData.getName_show());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f092092, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.g.setTag(R.id.obfuscated_res_0x7f09209a, metaData.getName_show());
        this.i = metaData.isBigV();
        this.j = metaData.isNewGod();
    }

    public final void W(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048596, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || this.b == null || metaData == null) {
            return;
        }
        ArrayList<IconData> iconInfo = metaData.getIconInfo();
        videoTabPbFloatUserInfoViewHolder.k.setTag(R.id.obfuscated_res_0x7f092092, metaData.getUserId());
        videoTabPbFloatUserInfoViewHolder.k.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
    }

    public final void X(VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048597, this, videoTabPbFloatUserInfoViewHolder, metaData) == null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.h = true;
            videoTabPbFloatUserInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.h = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoTabPbFloatUserInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(ej.f(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoTabPbFloatUserInfoViewHolder.f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.l = str;
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, VideoTabPbFloatUserInfoViewHolder videoTabPbFloatUserInfoViewHolder) {
        I(i, view2, viewGroup, postData, videoTabPbFloatUserInfoViewHolder);
        return view2;
    }
}
