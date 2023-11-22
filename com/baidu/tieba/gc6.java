package com.baidu.tieba;

import android.annotation.SuppressLint;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdNetTypeUtil;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.card.view.CardUserInfoLayout;
import com.baidu.card.view.TbLiveContainer;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.abtest.UbsABTestHelper;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AlaInfoData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.YyExtData;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.YYLiveUtil;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tbadk.core.view.ThreadCommentAndPraiseInfoLayout;
import com.baidu.tbadk.core.view.ThreadSourceShareAndPraiseLayout;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.CardLiveLabelView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.recapp.localads.LocationCacheData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.cea.Cea708Decoder;
import org.json.JSONException;
import org.json.JSONObject;
import tbclient.AppPosInfo;
/* loaded from: classes6.dex */
public class gc6 extends yk6<ThreadData> implements wl6, s16 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TextView A;
    public TbImageView B;
    public RelativeLayout C;
    public TbImageView D;
    public TextView E;
    public FrameLayout F;
    public LinearLayout G;
    public TextView H;
    public ImageView I;
    public TbLiveContainer J;
    public CardLiveLabelView K;
    public String L;
    public boolean M;
    public String N;
    public View O;
    public boolean P;
    public int Q;
    public zb6 R;
    public final View.OnClickListener S;
    public CardUserInfoLayout v;
    public ThreadSourceShareAndPraiseLayout w;
    public View x;
    public LinearLayout y;
    public RelativeLayout z;

    @Override // com.baidu.tieba.zk6
    public int e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? R.layout.obfuscated_res_0x7f0d0361 : invokeV.intValue;
    }

    @Override // com.baidu.tieba.wl6
    public void q(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gc6 a;

        public a(gc6 gc6Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gc6Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gc6Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f() != null) {
                this.a.f().a(view2, this.a.k);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gc6(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.M = false;
        this.Q = 0;
        this.S = new a(this);
        n(bdUniqueId);
        this.i = tbPageContext;
        View i3 = i();
        RelativeLayout relativeLayout = (RelativeLayout) i3.findViewById(R.id.layout_root);
        this.z = relativeLayout;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams.topMargin = UtilHelper.getDimenPixelSize(R.dimen.M_H_X003);
        layoutParams.bottomMargin = 0;
        this.y = (LinearLayout) i3.findViewById(R.id.video_card_content_layout);
        this.z.setOnClickListener(this);
        TbImageView tbImageView = (TbImageView) i3.findViewById(R.id.obfuscated_res_0x7f092926);
        this.B = tbImageView;
        tbImageView.setDefaultResource(R.drawable.pic_frs_studio_photo);
        this.B.setDefaultBgResource(R.color.transparent);
        CardUserInfoLayout cardUserInfoLayout = (CardUserInfoLayout) i3.findViewById(R.id.obfuscated_res_0x7f090596);
        this.v = cardUserInfoLayout;
        cardUserInfoLayout.setUserAfterClickListener(this.S);
        this.A = (TextView) i3.findViewById(R.id.obfuscated_res_0x7f09252f);
        this.C = (RelativeLayout) i3.findViewById(R.id.frame_video);
        TbImageView tbImageView2 = (TbImageView) i3.findViewById(R.id.image_video);
        this.D = tbImageView2;
        tbImageView2.setDrawCorner(true);
        this.D.setPlaceHolder(3);
        this.D.setDefaultResource(0);
        this.D.setRadiusById(R.string.J_X05);
        this.D.setConrers(15);
        this.D.setBorderWidth(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds1));
        this.D.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
        this.D.setBorderSurroundContent(true);
        this.D.setDrawBorder(true);
        this.E = (TextView) i3.findViewById(R.id.ala_live_recom_reason);
        this.F = (FrameLayout) i3.findViewById(R.id.obfuscated_res_0x7f092507);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout = (ThreadCommentAndPraiseInfoLayout) i3.findViewById(R.id.text_bottom);
        this.l = threadCommentAndPraiseInfoLayout;
        x(threadCommentAndPraiseInfoLayout);
        this.l.setSelectVisible(false);
        this.l.setIsBarViewVisible(false);
        this.l.setCommentNumEnable(true);
        this.l.setLiveShareEnable(false);
        this.l.setFrom(2);
        this.l.getCommentContainer().setOnClickListener(this);
        this.l.hideDisagree();
        hw4 hw4Var = new hw4();
        hw4Var.b = 2;
        hw4Var.h = 2;
        this.l.setAgreeStatisticData(hw4Var);
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = (ThreadCommentAndPraiseInfoLayout) i3.findViewById(R.id.card_bottom_op_weight_layout);
        this.m = threadCommentAndPraiseInfoLayout2;
        x(threadCommentAndPraiseInfoLayout2);
        this.m.setFrom(2);
        this.m.setShareReportFrom(1);
        ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = (ThreadSourceShareAndPraiseLayout) i3.findViewById(R.id.obfuscated_res_0x7f092506);
        this.w = threadSourceShareAndPraiseLayout;
        threadSourceShareAndPraiseLayout.b.setOnClickListener(this);
        this.w.b.getCommentContainer().setOnClickListener(this);
        this.w.setFrom(2);
        this.w.setShareReportFrom(1);
        this.w.setSourceFromForPb(3);
        this.w.setStType("frs_page");
        this.w.setHideBarName(true);
        this.x = i3.findViewById(R.id.divider_below_reply_number_layout);
        View findViewById = i3.findViewById(R.id.thread_multi_del_mask_view);
        this.O = findViewById;
        findViewById.setClickable(true);
        zb6 zb6Var = new zb6(tbPageContext, this.v.getSuffixContainer());
        this.R = zb6Var;
        zb6Var.d(g());
        this.G = (LinearLayout) i3.findViewById(R.id.forum_friends_now_looking);
        this.H = (TextView) i3.findViewById(R.id.tv_forum_friends_now_looking);
        this.I = (ImageView) i3.findViewById(R.id.image_forum_friends_now_looking);
        this.J = (TbLiveContainer) i3.findViewById(R.id.tb_live_container);
        this.u = i3.findViewById(R.id.card_bottom_margin);
        CardLiveLabelView cardLiveLabelView = (CardLiveLabelView) i3.findViewById(R.id.label_view);
        this.K = cardLiveLabelView;
        cardLiveLabelView.setViewType(UbsABTestHelper.isFeedLiveCardStyleA() ? 2 : 1);
        this.K.setVisibility(0);
    }

    public int Q(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i)) == null) {
            return r16.c().b(this.N, i);
        }
        return invokeI.intValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.zk6
    /* renamed from: U */
    public void k(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, threadData) == null) {
            this.k = threadData;
            C(true);
            W();
        }
    }

    public void X(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, bdUniqueId) == null) && bdUniqueId != null && this.l != null) {
            CardUserInfoLayout cardUserInfoLayout = this.v;
            if (cardUserInfoLayout != null) {
                cardUserInfoLayout.setPageUniqueId(bdUniqueId);
            }
            n(bdUniqueId);
            B(bdUniqueId);
        }
    }

    public void Y(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048586, this, z) == null) {
            this.M = z;
        }
    }

    @Override // com.baidu.tieba.wl6
    public void a(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, str) == null) {
            this.L = str;
        }
    }

    @Override // com.baidu.tieba.s16
    public void b(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, str) == null) {
            this.N = str;
        }
    }

    public final void O(ThreadData threadData, String str) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, threadData, str) == null) {
            StatisticItem param = new StatisticItem("c12126").param("tid", threadData.getId());
            if (this.M) {
                i = 2;
            } else {
                i = 1;
            }
            TiebaStatic.log(param.param("obj_locate", i).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
            if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
                TiebaStatic.log(new StatisticItem("c12801").param("tid", threadData.getId()));
            }
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (str.equals(AlaLiveRoomActivityConfig.FROM_TYPE_FRS_LIVE_PLAY)) {
                if (threadData.getForum_name().equals(this.L)) {
                    TiebaStatic.log(new StatisticItem("c11843").param("uid", currentAccount).param("fid", threadData.getFid()));
                } else {
                    TiebaStatic.log(new StatisticItem("c11845").param("uid", currentAccount).param("fid", threadData.getFid()));
                }
            }
        }
    }

    public final void P(ThreadData threadData) {
        int i;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData) != null) || threadData == null) {
            return;
        }
        StatisticItem param = new StatisticItem("c12125").param("tid", threadData.getId());
        if (this.M) {
            i = 2;
        } else {
            i = 1;
        }
        TiebaStatic.log(param.param("obj_locate", i).param("obj_id", threadData.getThreadAlaInfo().live_id).param("obj_type", 2));
        if (threadData.getThreadAlaInfo() != null && threadData.getThreadAlaInfo().user_info != null && threadData.getThreadAlaInfo().user_info.is_official == 2) {
            TiebaStatic.log(new StatisticItem("c12800").param("tid", threadData.getId()));
        }
    }

    public TbLiveContainer R() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.J;
        }
        return (TbLiveContainer) invokeV.objValue;
    }

    public void S() {
        T t;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (lv4.c().g() && (t = this.k) != 0 && ((ThreadData) t).getThreadData() != null && ((ThreadData) this.k).getThreadData().getThreadAlaInfo() != null) {
                this.D.setPlaceHolder(3);
                this.D.startLoad(((ThreadData) this.k).getThreadData().getThreadAlaInfo().cover, 10, false);
                this.C.setVisibility(0);
                return;
            }
            this.C.setVisibility(8);
        }
    }

    public void T(Context context, ThreadData threadData) {
        String str;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048581, this, context, threadData) == null) && context != null && threadData != null && threadData.getThreadAlaInfo() != null) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                BdUtilHelper.showToast(context, (int) R.string.no_network_guide);
                return;
            }
            if (this.P) {
                str = AlaLiveRoomActivityConfig.FREM_TYPE_LIVE_FRS_STAGE_LIVE;
            } else {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_FRS_PLAY;
            }
            if (threadData.getFromType() != null) {
                str = threadData.getFromType();
            }
            int frsCurTabType = TbSingleton.getInstance().getFrsCurTabType();
            if (frsCurTabType == 14) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_NEW + threadData.getFid();
            } else if (frsCurTabType == 13) {
                str = AlaLiveRoomActivityConfig.FRS_LIVE_FROM_PREFIX_HOT + threadData.getFid();
            }
            O(threadData, str);
            AlaInfoData threadAlaInfo = threadData.getThreadAlaInfo();
            if (threadAlaInfo.isLegalYYLiveData()) {
                TbPageContext<?> tbPageContext = this.i;
                YyExtData yyExtData = threadAlaInfo.mYyExtData;
                YYLiveUtil.jumpToYYLiveRoom(tbPageContext, yyExtData.mSid, yyExtData.mSsid, yyExtData.mTemplateId, "" + threadAlaInfo.roomId, threadAlaInfo.mYyExtData.streamInfo, YYLiveUtil.SOURCE_FRS_LIVE_CARD_TAB);
                V(((ThreadData) this.k).getTid(), String.valueOf(((ThreadData) this.k).getFid()), String.valueOf(threadAlaInfo.roomId), String.valueOf(threadAlaInfo.live_id), threadAlaInfo.mYyExtData.mSid);
            }
        }
    }

    @Override // com.baidu.tieba.zk6
    @SuppressLint({"ResourceAsColor"})
    public void l(TbPageContext<?> tbPageContext, int i) {
        ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048592, this, tbPageContext, i) == null) {
            if (this.a != i) {
                A(tbPageContext, i);
                EMManager.from(this.z).setCorner(R.string.J_X06).setBackGroundSelectorColor(R.color.CAM_X0205, R.color.CAM_X0206);
                EMManager.from(this.C).setBorderWidth(R.dimen.L_X01).setBorderColor(R.color.CAM_X0401).setCorner(R.string.J_X05).setBackGroundColor(R.color.CAM_X0611);
                SkinManager.setViewTextColor(this.E, (int) R.color.CAM_X0101);
                TBSelector.makeDrawableSelector().setShape(0).setType(1).radius(BdUtilHelper.getDimens(c(), R.dimen.tbds31)).defaultStrokeColor(R.color.CAM_X0304).strokeWidth(BdUtilHelper.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds2)).into(this.G);
                SkinManager.setViewTextColor(this.H, (int) R.color.CAM_X0304);
                WebPManager.setPureDrawable(this.I, R.drawable.icon_ala_watching, R.color.CAM_X0304, WebPManager.ResourceStateType.NORMAL_PRESS);
                this.v.onChangeSkinType(h(), TbadkCoreApplication.getInst().getSkinType());
                this.D.setPlaceHolder(3);
                this.l.onChangeSkinType();
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout2 = this.l;
                if (threadCommentAndPraiseInfoLayout2 != null) {
                    threadCommentAndPraiseInfoLayout2.setUseDynamicLikeResImmediately();
                }
                ThreadCommentAndPraiseInfoLayout threadCommentAndPraiseInfoLayout3 = this.m;
                if (threadCommentAndPraiseInfoLayout3 != null) {
                    threadCommentAndPraiseInfoLayout3.setUseDynamicLikeResImmediately();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout = this.w;
                if (threadSourceShareAndPraiseLayout != null && threadSourceShareAndPraiseLayout.getVisibility() == 0) {
                    this.w.f();
                }
                ThreadSourceShareAndPraiseLayout threadSourceShareAndPraiseLayout2 = this.w;
                if (threadSourceShareAndPraiseLayout2 != null && (threadCommentAndPraiseInfoLayout = threadSourceShareAndPraiseLayout2.b) != null) {
                    threadCommentAndPraiseInfoLayout.setUseDynamicLikeResImmediately();
                }
                this.K.f();
                this.a = i;
            }
            T t = this.k;
            if (t != 0 && jl6.k(((ThreadData) t).getId())) {
                SkinManager.setViewTextColor(this.A, (int) R.color.CAM_X0109);
            } else {
                SkinManager.setViewTextColor(this.A, (int) R.color.CAM_X0105);
            }
            SkinManager.setBackgroundColor(this.O, R.color.CAM_X0201);
            this.R.c();
            this.J.d(i);
        }
    }

    public final void V(String str, String str2, String str3, String str4, String str5) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048583, this, str, str2, str3, str4, str5) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("tid", str);
                jSONObject.put("fid", str2);
                if (TextUtils.equals("0", str3)) {
                    str3 = null;
                }
                jSONObject.put("roomId", str3);
                if (TextUtils.equals("0", str4)) {
                    str4 = null;
                }
                jSONObject.put("liveId", str4);
                jSONObject.put("sid", str5);
                jSONObject.put("roomInfo", "roomInfo");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921547, jSONObject));
        }
    }

    public final void W() {
        SparseArray<String> sparseArray;
        int dimenPixelSize;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            T t = this.k;
            int i2 = 8;
            if (t != 0 && ((ThreadData) t).getAuthor() != null) {
                this.z.setVisibility(0);
                int equipmentWidth = BdUtilHelper.getEquipmentWidth(this.i.getPageActivity());
                if (equipmentWidth != this.Q) {
                    boolean isFeedLiveCardStyleA = UbsABTestHelper.isFeedLiveCardStyleA();
                    if (isFeedLiveCardStyleA) {
                        dimenPixelSize = (int) (equipmentWidth * 0.6d);
                    } else {
                        dimenPixelSize = equipmentWidth - ((UtilHelper.getDimenPixelSize(R.dimen.M_W_X004) + UtilHelper.getDimenPixelSize(R.dimen.M_W_X005)) * 2);
                    }
                    LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.C.getLayoutParams();
                    layoutParams.width = dimenPixelSize;
                    if (isFeedLiveCardStyleA) {
                        i = (dimenPixelSize * 5) / 4;
                    } else {
                        i = (dimenPixelSize * 9) / 16;
                    }
                    layoutParams.height = i;
                    this.C.setLayoutParams(layoutParams);
                    this.Q = equipmentWidth;
                }
                if (((ThreadData) this.k).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().user_info != null && ((ThreadData) this.k).getThreadAlaInfo().user_info.is_official == 2) {
                    this.P = true;
                    sparseArray = ((ThreadData) this.k).getThreadAlaInfo().dislikeInfo;
                    this.B.setVisibility(0);
                    int[] screenDimensions = BdUtilHelper.getScreenDimensions(c());
                    ViewGroup.LayoutParams layoutParams2 = this.B.getLayoutParams();
                    layoutParams2.width = screenDimensions[0];
                    layoutParams2.height = (screenDimensions[0] * Cea708Decoder.COMMAND_DS4) / 1080;
                    this.B.setLayoutParams(layoutParams2);
                    if (!TextUtils.isEmpty(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl)) {
                        this.B.startLoad(((ThreadData) this.k).getThreadAlaInfo().liveStagePicUrl, 10, false);
                    }
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds24);
                    this.v.setLayoutParams(marginLayoutParams);
                } else {
                    this.P = false;
                    this.B.setVisibility(8);
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) this.v.getLayoutParams();
                    marginLayoutParams2.topMargin = this.i.getResources().getDimensionPixelSize(R.dimen.tbds44);
                    this.v.setLayoutParams(marginLayoutParams2);
                    sparseArray = null;
                }
                if (this.P && sparseArray != null && sparseArray.size() > 0) {
                    this.R.b((ThreadData) this.k, "ala_frs_demo_hell_live_feed_back_type");
                } else if (this.R.a() != null) {
                    this.R.a().setVisibility(8);
                }
                ((ThreadData) this.k).parserSpecTitleForFrsAndPb(false, true);
                this.v.setData((ThreadData) this.k);
                SpannableStringBuilder span_str = ((ThreadData) this.k).getSpan_str();
                if (span_str != null && !StringUtils.isNull(span_str.toString())) {
                    this.A.setText(((ThreadData) this.k).getSpan_str());
                    this.A.setVisibility(0);
                } else {
                    this.A.setVisibility(8);
                }
                T t2 = this.k;
                if (t2 != 0 && ((ThreadData) t2).getThreadAlaInfo() != null && ((ThreadData) this.k).getThreadAlaInfo().audience_count > 0) {
                    this.K.g(String.format(this.i.getResources().getString(R.string.ala_audience_count_prefix), StringHelper.numFormatOverWan(((ThreadData) this.k).getThreadAlaInfo().audience_count)));
                } else {
                    this.K.g(null);
                }
                this.E.setVisibility(8);
                if (!UbsABTestHelper.isFeedLiveCardStyleA() && ((ThreadData) this.k).getThreadAlaInfo().openRecomReason == 1) {
                    String str = ((ThreadData) this.k).getThreadAlaInfo().recomReason;
                    if (!StringUtils.isNull(str)) {
                        this.E.setVisibility(0);
                        this.E.setText(str);
                    } else {
                        String latitude = ((ThreadData) this.k).getLatitude();
                        String longtitude = ((ThreadData) this.k).getLongtitude();
                        if (UtilHelper.isDecimal(latitude) && UtilHelper.isDecimal(longtitude) && UtilHelper.isSystemLocationProviderEnabled(TbadkCoreApplication.getInst())) {
                            AppPosInfo createRecReqAppPosInfo = LocationCacheData.getInstance().createRecReqAppPosInfo();
                            String str2 = createRecReqAppPosInfo.latitude;
                            String str3 = createRecReqAppPosInfo.longitude;
                            if (UtilHelper.isDecimal(str2) && UtilHelper.isDecimal(str3) && BdUtilHelper.getDistance(Double.parseDouble(str2), Double.parseDouble(str3), Double.parseDouble(latitude), Double.parseDouble(longtitude)) <= 50.0d) {
                                this.E.setText(TbadkCoreApplication.getInst().getResources().getString(R.string.ala_recom_reason));
                                this.E.setVisibility(0);
                            }
                        }
                    }
                }
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.F.getLayoutParams();
                if (((ThreadData) this.k).getThreadAlaInfo() != null && !StringUtils.isNull(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg)) {
                    this.G.setVisibility(0);
                    this.H.setText(StringHelper.cutChineseAndEnglishWithSuffix(((ThreadData) this.k).getThreadAlaInfo().forumUserLiveMsg, 10, "...") + TbadkCoreApplication.getInst().getResources().getString(R.string.ala_forum_live_suffix));
                    layoutParams3.addRule(3, R.id.forum_friends_now_looking);
                } else {
                    this.G.setVisibility(8);
                    layoutParams3.addRule(3, R.id.video_card_content_layout);
                }
                this.F.setLayoutParams(layoutParams3);
                Z(Q(1));
                P((ThreadData) this.k);
                this.O.setVisibility((hp7.f().i() || gp7.h().j()) ? 0 : 0);
                l(this.i, TbadkCoreApplication.getInst().getSkinType());
                S();
                H(this.z);
                this.J.b((ThreadData) this.k);
                this.J.setStaticsLocationPage("2");
                return;
            }
            this.z.setVisibility(8);
        }
    }

    public void Z(int i) {
        T t;
        int i2;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeI(1048587, this, i) != null) || (t = this.k) == 0) {
            return;
        }
        if (i == 1) {
            this.l.setVisibility(8);
            this.w.g((ThreadData) this.k);
            return;
        }
        boolean data = this.l.setData((ThreadData) t);
        View view2 = this.x;
        if (data) {
            i2 = 8;
        } else {
            i2 = 0;
        }
        view2.setVisibility(i2);
        this.w.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048593, this, view2) == null) && !hp7.f().i() && !gp7.h().j()) {
            if (view2 != this.z && view2 != this.l.getCommentContainer() && view2 != this.y && view2 != this.w.b.getCommentContainer() && view2 != this.m.getCommentContainer() && view2 != this.G) {
                if (view2.getId() == R.id.video_container) {
                    if (f() != null) {
                        f().a(view2, this.k);
                    }
                    T(c(), (ThreadData) this.k);
                    return;
                }
                return;
            }
            T t = this.k;
            if (t != 0) {
                jl6.a(((ThreadData) t).getId());
            }
            if (f() != null) {
                f().a(this.z, this.k);
            }
            T(c(), (ThreadData) this.k);
            if (this.k != 0) {
                if (view2 == this.l.getCommentContainer() || view2 == this.w.b.getCommentContainer()) {
                    StatisticItem statisticItem = new StatisticItem("c12942");
                    statisticItem.param("obj_locate", 2);
                    statisticItem.param("obj_type", 5);
                    statisticItem.param("tid", ((ThreadData) this.k).getTid());
                    statisticItem.param("nid", ((ThreadData) this.k).getNid());
                    lo5 findPageExtraByView = TbPageExtraHelper.findPageExtraByView(view2);
                    if (findPageExtraByView != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, findPageExtraByView.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }
}
