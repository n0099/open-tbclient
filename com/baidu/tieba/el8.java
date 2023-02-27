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
import com.baidu.tieba.tbadkCore.data.PostData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Date;
/* loaded from: classes4.dex */
public class el8 extends qn<PostData, VideoPbVideoInfoViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BaseFragment a;
    @Nullable
    public tk8 b;
    public hd8 c;
    public int d;
    public boolean e;
    public boolean f;
    public boolean g;
    public ih8 h;
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
        public final /* synthetic */ el8 a;

        public a(el8 el8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = el8Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            String str;
            String str2;
            long j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (view2.getId() != R.id.obfuscated_res_0x7f0904bf && view2.getId() != R.id.obfuscated_res_0x7f092741) {
                    String str3 = null;
                    if (view2.getId() == R.id.obfuscated_res_0x7f0927a3) {
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
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f092686) {
                        if (!(view2.getTag(R.id.tag_user_id) instanceof String)) {
                            return;
                        }
                        zu4.x(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getString(R.string.user_icon_web_view_title), TbConfig.SERVER_ADDRESS_WEB_VIEW + "mo/q/icon/panelIcon?user_id=" + ((String) view2.getTag(R.id.tag_user_id)) + "&opacity=0", true, true, true);
                        TiebaStatic.log(new StatisticItem(CommonStatisticKey.USER_ICON_VISIT).param("obj_type", 2));
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f090e5d) {
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
                    } else if (view2.getId() == R.id.obfuscated_res_0x7f092660) {
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

        public b(el8 el8Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
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

        public c(el8 el8Var, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var, videoPbVideoInfoViewHolder, Integer.valueOf(i)};
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
        public final /* synthetic */ el8 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(el8 el8Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {el8Var, Integer.valueOf(i)};
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
            this.a = el8Var;
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
    public el8(BaseFragment baseFragment, @Nullable tk8 tk8Var, BdUniqueId bdUniqueId) {
        super(baseFragment.getActivity(), bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {baseFragment, tk8Var, bdUniqueId};
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
        this.b = tk8Var;
        baseFragment.registerListener(dVar);
    }

    public final boolean O(PostData postData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, postData)) == null) {
            if (postData != null && ListUtils.getCount(postData.i0) >= 2) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void U(hd8 hd8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, hd8Var) == null) {
            this.c = hd8Var;
        }
    }

    public void o(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.l = str;
        }
    }

    public final void H(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, hd8 hd8Var, int i) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLI(1048576, this, videoPbVideoInfoViewHolder, hd8Var, i) == null) && hd8Var != null) {
            videoPbVideoInfoViewHolder.o(hd8Var, i);
        }
    }

    public final void J(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, videoPbVideoInfoViewHolder, postData) == null) && (hd8Var = this.c) != null && hd8Var.Q() != null && this.c.Q().getAuthor() != null && postData != null) {
            Z(videoPbVideoInfoViewHolder, this.c.Q().getAuthor(), postData);
            d0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            b0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            W(videoPbVideoInfoViewHolder.h, this.c.j());
            Y(videoPbVideoInfoViewHolder, postData);
            c0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            V(videoPbVideoInfoViewHolder, this.c.Q().getAuthor());
            a0(videoPbVideoInfoViewHolder, this.c.Q().getAuthor(), postData);
        }
    }

    public final void V(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
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
                layoutParams.setMargins(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds32), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
                videoPbVideoInfoViewHolder.k.setText(authInfo);
                videoPbVideoInfoViewHolder.k.setVisibility(0);
                return;
            }
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.l.getLayoutParams();
            layoutParams2.setMargins(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds20), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
            videoPbVideoInfoViewHolder.k.setVisibility(8);
        }
    }

    public final void K(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        hd8 hd8Var;
        String formatTime;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, videoPbVideoInfoViewHolder, postData) == null) && (hd8Var = this.c) != null && hd8Var.Q() != null && postData != null) {
            videoPbVideoInfoViewHolder.s(this.c.Q().getRichTitle(), this.c.Q().getTitle(), this.c.Q(), O(postData), this.c.z0());
            if (this.c.Q().getThreadVideoInfo() != null) {
                String numberUniformFormatExtra = StringHelper.numberUniformFormatExtra(this.c.Q().getThreadVideoInfo().play_count.intValue());
                TextView textView = videoPbVideoInfoViewHolder.v;
                textView.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0f61));
                TextView textView2 = videoPbVideoInfoViewHolder.C;
                textView2.setText(numberUniformFormatExtra + this.mContext.getString(R.string.obfuscated_res_0x7f0f0f61));
            }
            if (StringUtils.SimpleDateFormat(new Date(), "yyyy").equals(StringUtils.SimpleDateFormat(new Date(postData.k0()), "yyyy"))) {
                formatTime = StringHelper.getFormatTimeShort(postData.k0());
            } else {
                formatTime = StringHelper.getFormatTime(postData.k0());
            }
            TextView textView3 = videoPbVideoInfoViewHolder.w;
            textView3.setText(formatTime + this.mContext.getString(R.string.send_post));
            TextView textView4 = videoPbVideoInfoViewHolder.D;
            textView4.setText(formatTime + this.mContext.getString(R.string.send_post));
            bc5 V = postData.V();
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
            hd8 hd8Var2 = this.c;
            if (hd8Var2 != null && hd8Var2.Q() != null && !P(this.c.Q()) && (!ListUtils.isEmpty(this.c.Q().getLinkDataList()) || !ListUtils.isEmpty(this.c.Q().getGoodsDataList()))) {
                ir5 ir5Var = new ir5();
                PbLinkGoodsRootView pbLinkGoodsRootView = new PbLinkGoodsRootView(this.mContext);
                hd8 hd8Var3 = this.c;
                pbLinkGoodsRootView.j(hd8Var3, ir5Var.a(hd8Var3.Q().getLinkDataList(), this.c.Q().getGoodsDataList()), this.c.n(), (AbsVideoPbFragment) this.a, ir5Var.c());
                videoPbVideoInfoViewHolder.N.addView(pbLinkGoodsRootView);
                videoPbVideoInfoViewHolder.N.setVisibility(0);
            } else {
                videoPbVideoInfoViewHolder.N.setVisibility(8);
            }
            videoPbVideoInfoViewHolder.r(this.mContext, postData);
        }
    }

    public final void L(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, videoPbVideoInfoViewHolder, postData) == null) {
            videoPbVideoInfoViewHolder.q(8, null);
            hd8 hd8Var = this.c;
            if (hd8Var != null && hd8Var.Q() != null && postData != null) {
                if (postData.S) {
                    videoPbVideoInfoViewHolder.q(0, postData.O());
                }
                BaseFragment baseFragment = this.a;
                if (baseFragment instanceof AbsVideoPbFragment) {
                    ((AbsVideoPbFragment) baseFragment).c6(postData.S);
                }
            }
        }
    }

    public final void b0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
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

    public final int M() {
        InterceptResult invokeV;
        PbModel M;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            tk8 tk8Var = this.b;
            if (tk8Var != null && (M = tk8Var.M()) != null) {
                return M.r1();
            }
            return 0;
        }
        return invokeV.intValue;
    }

    public final int N(hd8 hd8Var) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, hd8Var)) == null) {
            if (hd8Var == null || hd8Var.Q() == null) {
                return 0;
            }
            if (hd8Var.Q().isMutiForumThread()) {
                if (ListUtils.isEmpty(hd8Var.p()) && (hd8Var.h() == null || StringUtils.isNull(hd8Var.h().d()))) {
                    return 0;
                }
                return 2;
            }
            return 1;
        }
        return invokeL.intValue;
    }

    public final void X(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        hd8 hd8Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048591, this, videoPbVideoInfoViewHolder) != null) || (hd8Var = this.c) == null) {
            return;
        }
        this.e = hd8Var.j;
        if (hd8Var.Q() != null) {
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

    public final boolean P(ThreadData threadData) {
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

    public void Q(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
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
    @Override // com.baidu.tieba.qn
    /* renamed from: R */
    public VideoPbVideoInfoViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        AbsVideoPbFragment absVideoPbFragment;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d071e, viewGroup, false);
            Context context = this.mContext;
            BaseFragment baseFragment = this.a;
            if (baseFragment instanceof AbsVideoPbFragment) {
                absVideoPbFragment = (AbsVideoPbFragment) baseFragment;
            } else {
                absVideoPbFragment = null;
            }
            VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder = new VideoPbVideoInfoViewHolder(context, inflate, absVideoPbFragment);
            videoPbVideoInfoViewHolder.p(this.m);
            Q(videoPbVideoInfoViewHolder);
            this.viewholder = videoPbVideoInfoViewHolder;
            return videoPbVideoInfoViewHolder;
        }
        return (VideoPbVideoInfoViewHolder) invokeL.objValue;
    }

    public View S(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), view2, viewGroup, postData, videoPbVideoInfoViewHolder})) == null) {
            hd8 hd8Var = this.c;
            if (hd8Var != null && hd8Var.Q() != null && postData != null) {
                jk8.d(this.a.getUniqueId(), this.c, postData, 1, 1);
                X(videoPbVideoInfoViewHolder);
                J(videoPbVideoInfoViewHolder, postData);
                K(videoPbVideoInfoViewHolder, postData);
                L(videoPbVideoInfoViewHolder, postData);
                H(videoPbVideoInfoViewHolder, this.c, M());
                Q(videoPbVideoInfoViewHolder);
                videoPbVideoInfoViewHolder.G.setVisibility(8);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void T(PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048587, this, postData) == null) && postData != null && postData.r() != null) {
            String userId = postData.r().getUserId();
            hd8 hd8Var = this.c;
            String str2 = "";
            if (hd8Var == null) {
                str = "";
            } else {
                str = hd8Var.m();
            }
            hd8 hd8Var2 = this.c;
            if (hd8Var2 != null) {
                str2 = hd8Var2.n();
            }
            int F = postData.F();
            String O = postData.O();
            StatisticItem statisticItem = new StatisticItem("c13714");
            statisticItem.param("fid", str);
            statisticItem.param("fname", str2);
            statisticItem.param("obj_param1", userId);
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            statisticItem.param("tid", O);
            statisticItem.param(TiebaStatic.Params.OBJ_PARAM2, F);
            if (postData.r().getAlaInfo() != null) {
                AlaInfoData alaInfo = postData.r().getAlaInfo();
                statisticItem.param(TiebaStatic.Params.OBJ_PARAM3, YYLiveUtil.calculateLiveType(alaInfo));
                if (alaInfo.mYyExtData != null) {
                    statisticItem.param(TiebaStatic.Params.OBJ_PARAM4, TiebaStatic.YYValues.YY_LIVE);
                    TiebaStaticHelper.addYYParam(statisticItem, alaInfo.mYyExtData);
                }
            }
            TiebaStatic.log(statisticItem);
        }
    }

    public final void W(TextView textView, PostData postData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, textView, postData) == null) {
            if (textView == null && postData == null) {
                return;
            }
            textView.setTag(postData);
            hd8 hd8Var = this.c;
            if (hd8Var != null && hd8Var.l0()) {
                textView.setVisibility(8);
                textView.setTag(null);
            } else if (postData.r() != null) {
                MetaData r = postData.r();
                String str = this.l;
                if (str != null && !str.equals("0") && this.l.equals(r.getUserId())) {
                    textView.setVisibility(0);
                    textView.setText(R.string.host_name);
                    textView.setBackgroundColor(0);
                    b35 d2 = b35.d(textView);
                    d2.v(R.color.CAM_X0302);
                    d2.n(R.string.J_X04);
                    d2.l(R.dimen.L_X01);
                    d2.k(R.color.CAM_X0302);
                } else if (r.getIs_bawu() == 1 && postData.u0()) {
                    b35 d3 = b35.d(textView);
                    d3.v(R.color.CAM_X0101);
                    d3.n(R.string.J_X04);
                    d3.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.brand_official);
                } else if (r.getIs_bawu() == 1 && "manager".equals(r.getBawu_type())) {
                    b35 d4 = b35.d(textView);
                    d4.v(R.color.CAM_X0101);
                    d4.n(R.string.J_X04);
                    d4.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_bazhu_tip);
                } else if (r.getIs_bawu() == 1 && PushDialogActivity.HomeWatcherReceiver.SYSTEM_DIALOG_REASON_ASSIST.equals(r.getBawu_type())) {
                    b35 d5 = b35.d(textView);
                    d5.v(R.color.CAM_X0101);
                    d5.n(R.string.J_X04);
                    d5.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_member_xbazhu_tip);
                } else if (r.getIs_bawu() == 1 && "pri_content_assist".equals(r.getBawu_type())) {
                    b35 d6 = b35.d(textView);
                    d6.v(R.color.CAM_X0101);
                    d6.n(R.string.J_X04);
                    d6.f(R.color.CAM_X0302);
                    textView.setVisibility(0);
                    textView.setText(R.string.bawu_content_assist_tip);
                } else if (r.getIs_bawu() == 1 && "pri_manage_assist".equals(r.getBawu_type())) {
                    b35 d7 = b35.d(textView);
                    d7.v(R.color.CAM_X0101);
                    d7.n(R.string.J_X04);
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

    public final void Y(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, PostData postData) {
        hd8 hd8Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048592, this, videoPbVideoInfoViewHolder, postData) == null) && (hd8Var = this.c) != null && hd8Var.Q() != null) {
            this.d = 0;
            if (!this.c.Q().isMutiForumThread()) {
                if (postData != null && postData.r() != null) {
                    this.d = postData.r().getLevel_id();
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

    public final void c0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048596, this, videoPbVideoInfoViewHolder, metaData) == null) && this.c != null && metaData != null) {
            ArrayList<IconData> iconInfo = metaData.getIconInfo();
            videoPbVideoInfoViewHolder.j.setTag(R.id.tag_user_id, metaData.getUserId());
            videoPbVideoInfoViewHolder.j.g(iconInfo, 4, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10));
        }
    }

    public final void Z(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048593, this, videoPbVideoInfoViewHolder, metaData, postData) == null) && this.c != null && metaData != null && postData != null) {
            videoPbVideoInfoViewHolder.d.getHeadView().setUserId(metaData.getUserId());
            videoPbVideoInfoViewHolder.d.getHeadView().setUserName(metaData.getUserName());
            videoPbVideoInfoViewHolder.d.getHeadView().setTid(postData.O());
            hd8 hd8Var = this.c;
            String str2 = "";
            if (hd8Var == null) {
                str = "";
            } else {
                str = hd8Var.m();
            }
            videoPbVideoInfoViewHolder.d.getHeadView().setFid(str);
            hd8 hd8Var2 = this.c;
            if (hd8Var2 != null) {
                str2 = hd8Var2.n();
            }
            videoPbVideoInfoViewHolder.d.getHeadView().setFName(str2);
            videoPbVideoInfoViewHolder.d.j(metaData, 4);
            videoPbVideoInfoViewHolder.d.o(metaData);
            if (metaData.getAlaInfo() != null && metaData.getAlaUserData() != null && metaData.getAlaUserData().live_status == 1) {
                videoPbVideoInfoViewHolder.h(true);
                videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(1);
                videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(postData.r().getAlaInfo());
                T(postData);
                return;
            }
            videoPbVideoInfoViewHolder.h(false);
            videoPbVideoInfoViewHolder.d.getHeadView().setLiveStatus(0);
            videoPbVideoInfoViewHolder.d.getHeadView().setAlaInfo(null);
        }
    }

    public final void a0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData, PostData postData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLL(1048594, this, videoPbVideoInfoViewHolder, metaData, postData) == null) && this.c != null && postData != null && postData.r() != null) {
            hd8 hd8Var = this.c;
            if (hd8Var != null) {
                str = hd8Var.S();
            } else {
                str = "";
            }
            int N = N(this.c);
            int i = 4;
            if (this.c.Q() != null && this.c.Q().isVideoWorksInfo()) {
                i = 8;
            }
            if (this.h == null) {
                ih8 ih8Var = new ih8(this.a.getPageContext(), videoPbVideoInfoViewHolder.m, i);
                this.h = ih8Var;
                ih8Var.l(this.a.getUniqueId());
            }
            postData.r().setIsLike(postData.r().hadConcerned());
            this.h.n(postData.r());
            this.h.x(str);
            this.h.v(this.c.Q());
            ih8 ih8Var2 = this.h;
            ih8Var2.p = true;
            ih8Var2.w(N);
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

    public final void d0(VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder, MetaData metaData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048597, this, videoPbVideoInfoViewHolder, metaData) != null) || metaData == null) {
            return;
        }
        ArrayList<IconData> tShowInfoNew = metaData.getTShowInfoNew();
        if (tShowInfoNew != null && tShowInfoNew.size() > 0 && tShowInfoNew.get(0) != null) {
            this.i = true;
            videoPbVideoInfoViewHolder.f.setTag(tShowInfoNew.get(0).getUrl());
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams.setMargins(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams.topMargin, layoutParams.rightMargin, layoutParams.bottomMargin);
        } else {
            this.i = false;
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) videoPbVideoInfoViewHolder.g.getLayoutParams();
            layoutParams2.setMargins(ej.g(TbadkCoreApplication.getInst(), R.dimen.tbds10), layoutParams2.topMargin, layoutParams2.rightMargin, layoutParams2.bottomMargin);
        }
        videoPbVideoInfoViewHolder.f.h(tShowInfoNew, 3, TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds36), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds10), true);
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.qn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, PostData postData, VideoPbVideoInfoViewHolder videoPbVideoInfoViewHolder) {
        S(i, view2, viewGroup, postData, videoPbVideoInfoViewHolder);
        return view2;
    }
}
