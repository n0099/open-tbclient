package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ListView;
import androidx.core.view.InputDeviceCompat;
import b.a.e.e.p.j;
import b.a.e.e.p.k;
import b.a.e.e.p.l;
import b.a.q0.s.q.b1;
import b.a.q0.s.q.y0;
import b.a.r0.b0.m;
import b.a.r0.b0.u;
import b.a.r0.j1.h;
import b.a.r0.j1.l.f;
import b.a.r0.j1.l.i;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbDomainConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonalChatActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.data.HotTopicBussinessData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.hottopic.controller.HotRelateThreadModel;
import com.baidu.tieba.hottopic.controller.HotTopicModel;
import com.baidu.tieba.hottopic.data.ShareFromTopicMsgData;
import com.baidu.tieba.hottopic.holder.HotThreadItemHolder;
import com.baidu.tieba.tbadkCore.FrsCommonImageLayout;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes9.dex */
public class HotTopicActivity extends BaseActivity<HotTopicActivity> implements HotTopicModel.b, HotRelateThreadModel.c, FrsCommonImageLayout.e, UserIconBox.c, BdListView.p, HotRelateThreadModel.b, b.a.r0.j1.k.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public BlessModel blessModel;
    public long fid;
    public String firstDir;
    public HotRelateThreadModel hotRelateThreadModel;
    public b.a.e.e.k.b<TbImageView> hotThreadCommonImagePool;
    public HotTopicModel hotTopicModel;
    public b.a.r0.j1.k.b hotTopicShareModel;
    public long lastResumeTime;
    public LikeModel likeModel;
    public AntiHelper.k mAntiInjectListener;
    public b.a.r0.j1.k.a mBusinessStatistic;
    public List<HotTopicBussinessData> mDataList;
    public String mFrom;
    public final b.a.e.c.g.a mGetMyPostNetListener;
    public List<b.a.r0.j1.l.e> mHotTopicDataList;
    public int mIsGlobalBlock;
    public boolean mIsLoadComplete;
    public b.a.e.a.e mLikeModelCallback;
    public long mTid;
    public b.a.e.e.k.b<TbImageView> mUserIconPool;
    public b.a.r0.j1.o.c mainView;
    public String secondDir;
    public String topicId;
    public String topicName;

    /* loaded from: classes9.dex */
    public class a implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicActivity f50004a;

        public a(HotTopicActivity hotTopicActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50004a = hotTopicActivity;
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(b.a.q0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends b.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicActivity f50005a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(HotTopicActivity hotTopicActivity, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicActivity, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50005a = hotTopicActivity;
        }

        @Override // b.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String errorString;
            String errorString2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                    GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostHttpResponseMessage.getErrorString())) {
                        errorString2 = this.f50005a.getResources().getString(h.neterror);
                    } else {
                        errorString2 = getMyPostHttpResponseMessage.getErrorString();
                    }
                    this.f50005a.handleGetMyPostResponse(getMyPostHttpResponseMessage.getError(), errorString2, getMyPostHttpResponseMessage.getResponseData());
                } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                    GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                    if (StringUtils.isNull(getMyPostSocketResponseMessage.getErrorString())) {
                        errorString = this.f50005a.getResources().getString(h.neterror);
                    } else {
                        errorString = getMyPostSocketResponseMessage.getErrorString();
                    }
                    this.f50005a.handleGetMyPostResponse(getMyPostSocketResponseMessage.getError(), errorString, getMyPostSocketResponseMessage.getResponseData());
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends b.a.e.a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ HotTopicActivity f50006a;

        public c(HotTopicActivity hotTopicActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50006a = hotTopicActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (!AntiHelper.m(this.f50006a.likeModel.getErrorCode(), this.f50006a.likeModel.getErrorString())) {
                    if (StringUtils.isNull(this.f50006a.likeModel.getErrorString())) {
                        return;
                    }
                    l.M(TbadkCoreApplication.getInst(), this.f50006a.likeModel.getErrorString());
                } else if (AntiHelper.w(this.f50006a.getActivity(), this.f50006a.likeModel.getErrorString(), this.f50006a.likeModel.getErrorCode(), this.f50006a.mAntiInjectListener) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_LIKE_PERSON));
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class d implements View.OnTouchListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicActivity f50007e;

        public d(HotTopicActivity hotTopicActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50007e = hotTopicActivity;
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, view, motionEvent)) == null) {
                if (!ViewHelper.checkUpIsLogin(this.f50007e.getActivity())) {
                }
                return true;
            }
            return invokeLL.booleanValue;
        }
    }

    /* loaded from: classes9.dex */
    public class e implements NoNetworkView.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ HotTopicActivity f50008e;

        public e(HotTopicActivity hotTopicActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hotTopicActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50008e = hotTopicActivity;
        }

        @Override // com.baidu.tbadk.core.view.NoNetworkView.b
        public void onNetworkChange(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f50008e.mainView.E(!z);
                if (!z || this.f50008e.hotTopicModel == null || ListUtils.getItem(this.f50008e.mHotTopicDataList, this.f50008e.mainView.q()) == null) {
                    return;
                }
                b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) this.f50008e.mHotTopicDataList.get(this.f50008e.mainView.q());
                if (eVar == null || ListUtils.isEmpty(eVar.i())) {
                    this.f50008e.mainView.x();
                    this.f50008e.mainView.N();
                    this.f50008e.loadHotTopicData();
                }
            }
        }
    }

    public HotTopicActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mainView = null;
        this.hotTopicModel = null;
        this.hotRelateThreadModel = null;
        this.topicId = null;
        this.topicName = null;
        this.mFrom = "";
        this.lastResumeTime = 0L;
        this.mIsGlobalBlock = 0;
        this.mIsLoadComplete = true;
        this.mAntiInjectListener = new a(this);
        this.mGetMyPostNetListener = new b(this, CmdConfigHttp.CMD_GET_MY_POST, 303111);
        this.mLikeModelCallback = new c(this);
    }

    private boolean checkVideoEasterEgg(PostWriteCallBackData postWriteCallBackData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, this, postWriteCallBackData)) == null) {
            if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
                return false;
            }
            if (b.a.q0.s.e0.b.j().g(b.a.q0.s.e0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this).createNormalConfig("from_hottopic", postWriteCallBackData.getVideoEasterEggData())));
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    private void firstTimeLoadHotTopicData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            showLoadingView(this.mainView.u(), false);
            if (!j.A()) {
                hideLoadingView(this.mainView.u());
                showNetRefreshView(this.mainView.u(), getResources().getString(h.neterror), true);
                setNetRefreshViewTopMargin(l.g(TbadkCoreApplication.getInst(), b.a.r0.j1.c.tbds530));
                this.mainView.I(8);
                return;
            }
            this.mainView.I(0);
            loadHotTopicData();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleGetMyPostResponse(int i2, String str, GetMyPostResIdl getMyPostResIdl) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65545, this, i2, str, getMyPostResIdl) == null) {
            if (i2 != 0) {
                showToast(str);
                return;
            }
            b.a.r0.j1.o.c cVar = this.mainView;
            if (cVar == null || ListUtils.getItem(this.mHotTopicDataList, cVar.q()) == null || this.mainView.r() == null) {
                return;
            }
            b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) ListUtils.getItem(this.mHotTopicDataList, this.mainView.q());
            y0 y0Var = new y0();
            ThreadInfo.Builder builder = new ThreadInfo.Builder(getMyPostResIdl.data.thread_info);
            User.Builder builder2 = new User.Builder(builder.author);
            parseUserData(builder2, getMyPostResIdl.data.user_info);
            builder.author = builder2.build(true);
            y0Var.Y2(builder.build(true));
            eVar.b(y0Var);
            this.mainView.r().refreshView(eVar);
        }
    }

    private void initListeners() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65546, this) == null) {
            this.mainView.K(new d(this));
            this.mainView.J(new e(this));
            this.mGetMyPostNetListener.getSocketMessageListener().setSelfListener(true);
            this.mGetMyPostNetListener.getHttpMessageListener().setSelfListener(true);
            registerListener(this.mGetMyPostNetListener);
        }
    }

    private void initParamsFromIntent(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65547, this, bundle) == null) {
            Intent intent = getIntent();
            if (intent != null) {
                this.topicId = intent.getStringExtra("topic_id");
                this.topicName = intent.getStringExtra(IntentConfig.TOPIC_NAME);
                this.fid = intent.getLongExtra(IntentConfig.TOPIC_FID, 0L);
                this.firstDir = intent.getStringExtra(IntentConfig.TOPIC_FIRST_DIR);
                this.secondDir = intent.getStringExtra(IntentConfig.TOPIC_SECOND_DIR);
                this.mFrom = intent.getStringExtra("from");
                this.mTid = intent.getLongExtra(IntentConfig.TOPIC_TID, 0L);
            } else if (bundle != null) {
                this.topicId = bundle.getString("topic_id");
                this.topicName = bundle.getString(IntentConfig.TOPIC_NAME);
                this.fid = bundle.getLong(IntentConfig.TOPIC_FID, 0L);
                this.firstDir = bundle.getString(IntentConfig.TOPIC_FIRST_DIR);
                this.secondDir = bundle.getString(IntentConfig.TOPIC_SECOND_DIR);
                this.mFrom = bundle.getString("from");
                this.mFrom = bundle.getString("from");
                this.mTid = bundle.getLong(IntentConfig.TOPIC_TID, 0L);
            }
        }
    }

    private void parseUserData(User.Builder builder, User_Info user_Info) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65548, this, builder, user_Info) == null) || user_Info == null) {
            return;
        }
        builder.id = user_Info.id;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        builder.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
        builder.fans_nickname = user_Info.fans_nickname;
        builder.is_bawu = user_Info.is_bawu;
        builder.bawu_type = user_Info.bawu_type;
    }

    private void parserWriteData(b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65549, this, eVar) == null) {
            List<HotTopicBussinessData> list = this.mDataList;
            if (list == null) {
                this.mDataList = new ArrayList();
            } else {
                list.clear();
            }
            this.mDataList.add(new HotTopicBussinessData(0L, "", eVar.h().f18448f, this.mIsGlobalBlock));
        }
    }

    private void updateLoadingMoreForNetError() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            int tabPosBySortType = getTabPosBySortType(getSortType());
            b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) ListUtils.getItem(this.mHotTopicDataList, tabPosBySortType);
            if (eVar != null && eVar.j() != null) {
                if (eVar.j().b() != 0) {
                    this.mainView.w(tabPosBySortType);
                    return;
                }
                this.mainView.w(tabPosBySortType);
                this.mainView.O(tabPosBySortType);
                return;
            }
            this.mainView.w(tabPosBySortType);
        }
    }

    private void updateReqPageInfo(int i2, b1 b1Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeIL(65551, this, i2, b1Var) == null) || b1Var == null) {
            return;
        }
        int tabPosBySortType = getTabPosBySortType(i2);
        b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) ListUtils.getItem(this.mHotTopicDataList, tabPosBySortType);
        if (eVar != null) {
            eVar.q(b1Var);
        }
        if (b1Var.b() != 0) {
            this.mainView.M(tabPosBySortType);
            return;
        }
        this.mainView.w(tabPosBySortType);
        this.mainView.O(tabPosBySortType);
    }

    public void businessStatisticForTopic(b.a.r0.b0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        StatisticItem statisticItem = new StatisticItem("c13021");
        statisticItem.param("tid", bVar.getThreadData().s1()).param("fid", bVar.getThreadData().T()).param("obj_source", bVar.getThreadData().X0).param("obj_locate", getFrom()).param("obj_name", getTopicName()).param(TiebaStatic.Params.OBJ_PARAM3, m.e()).param("ab_tag", bVar.g());
        u.b().a(statisticItem);
    }

    public void businessStatisticForTopicClick(b.a.r0.b0.e0.b bVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) || bVar == null || bVar.getThreadData() == null) {
            return;
        }
        b.a.r0.j1.n.b.a(bVar.getThreadData(), getTopicName(), getFrom(), bVar.k);
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.b
    public void complete() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.mIsLoadComplete = true;
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, b.a.q0.o0.a
    public String getCurrentPageKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? "a010" : (String) invokeV.objValue;
    }

    public String getFrom() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mFrom : (String) invokeV.objValue;
    }

    @Override // com.baidu.tieba.tbadkCore.FrsCommonImageLayout.e
    public b.a.e.e.k.b<TbImageView> getFrsCommonImageLayoutPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.hotThreadCommonImagePool == null) {
                this.hotThreadCommonImagePool = FrsCommonImageLayout.createFrsCommonIamgeLayoutPool(getPageContext().getPageActivity(), 12);
            }
            return this.hotThreadCommonImagePool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public String getHotTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? this.topicId : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    public ListView getListView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return null;
        }
        return (ListView) invokeV.objValue;
    }

    public ShareFromTopicMsgData getShareFromTopicMsgData() {
        InterceptResult invokeV;
        f h2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (ListUtils.isEmpty(this.mHotTopicDataList) || (h2 = this.mHotTopicDataList.get(0).h()) == null) {
                return null;
            }
            StringBuilder sb = new StringBuilder();
            ShareFromTopicMsgData shareFromTopicMsgData = new ShareFromTopicMsgData();
            shareFromTopicMsgData.setContent(h2.j);
            shareFromTopicMsgData.setImageUrl(h2.k);
            shareFromTopicMsgData.setTitle(h2.f18448f);
            shareFromTopicMsgData.setHotTopicID(h2.f18447e);
            shareFromTopicMsgData.setHotTopicName(h2.f18448f);
            sb.append(TbDomainConfig.DOMAIN_HTTPS_TIEBA);
            sb.append("mo/q/hotMessage?topic_id=");
            sb.append(h2.f18447e);
            sb.append("&topic_name=");
            sb.append(h2.f18448f);
            shareFromTopicMsgData.setLinkUrl(sb.toString());
            return shareFromTopicMsgData;
        }
        return (ShareFromTopicMsgData) invokeV.objValue;
    }

    public int getSortType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? this.mainView.q() == 0 ? 1 : 0 : invokeV.intValue;
    }

    public int getTabPosBySortType(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048587, this, i2)) == null) ? i2 == 1 ? 0 : 1 : invokeI.intValue;
    }

    public String getTopicName() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) ? this.topicName : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public b.a.e.e.k.b<TbImageView> getUserIconPool() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            if (this.mUserIconPool == null) {
                this.mUserIconPool = UserIconBox.createUserIconPool(getPageContext().getPageActivity(), 8);
            }
            return this.mUserIconPool;
        }
        return (b.a.e.e.k.b) invokeV.objValue;
    }

    public int getUserIconViewId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) ? HotThreadItemHolder.getUserIconId() : invokeV.intValue;
    }

    @Override // com.baidu.tieba.hottopic.controller.HotRelateThreadModel.c
    public void hotRelateThreadCallback(boolean z, b.a.r0.j1.l.d dVar, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), dVar, Integer.valueOf(i2)}) == null) {
            if (z && dVar != null && !ListUtils.isEmpty(this.mHotTopicDataList) && ListUtils.getCount(dVar.X3) != 0) {
                b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) ListUtils.getItem(this.mHotTopicDataList, getTabPosBySortType(i2));
                if (eVar == null) {
                    this.mainView.w(getTabPosBySortType(i2));
                    return;
                }
                eVar.a(dVar);
                this.mainView.A(this.mHotTopicDataList);
                updateReqPageInfo(i2, dVar.Y3);
                return;
            }
            this.mainView.w(getTabPosBySortType(i2));
        }
    }

    @Override // com.baidu.tieba.hottopic.controller.HotTopicModel.b
    public void hotTopicDataCallback(boolean z, b.a.r0.j1.l.e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZL(1048592, this, z, eVar) == null) {
            hideLoadingView(this.mainView.u());
            if (this.mainView == null) {
                return;
            }
            if (this.mHotTopicDataList == null) {
                this.mHotTopicDataList = new ArrayList();
            }
            if (this.mHotTopicDataList.size() != 2) {
                this.mHotTopicDataList.clear();
            }
            if (this.mHotTopicDataList.size() == 0) {
                b.a.r0.j1.l.e eVar2 = new b.a.r0.j1.l.e();
                b.a.r0.j1.l.e eVar3 = new b.a.r0.j1.l.e();
                eVar2.s = 1;
                eVar3.s = 0;
                this.mHotTopicDataList.add(eVar2);
                this.mHotTopicDataList.add(eVar3);
            }
            if (eVar.s == 1) {
                this.mHotTopicDataList.set(0, eVar);
            } else {
                this.mHotTopicDataList.set(1, eVar);
            }
            this.mIsGlobalBlock = eVar.f();
            if (eVar.c() != null && eVar.d() != null) {
                this.mainView.y(8, true, 0L, 0);
            } else if (eVar.c() != null) {
                this.mainView.y(0, true, eVar.c().f18423e, eVar.c().f18424f);
            } else if (eVar.d() != null) {
                this.mainView.y(0, false, eVar.d().f18423e, eVar.d().f18424f);
            }
            this.mainView.A(this.mHotTopicDataList);
            this.mainView.L(eVar);
            this.mainView.C();
            updateReqPageInfo(eVar.s, eVar.j());
        }
    }

    public void loadHotTopicData() {
        HotTopicModel hotTopicModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048593, this) == null) && j.z() && (hotTopicModel = this.hotTopicModel) != null) {
            hotTopicModel.z(this.topicId, this.topicName, getSortType(), this.fid, this.firstDir, this.secondDir, this.mFrom, this.mTid);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048594, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1) {
                if (i2 == 13003) {
                    if (intent == null) {
                        return;
                    }
                    PostWriteCallBackData postWriteCallBackData = null;
                    try {
                        postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                    } catch (Exception unused) {
                    }
                    if (postWriteCallBackData != null) {
                        long g2 = b.a.e.e.m.b.g(postWriteCallBackData.getPostId(), 0L);
                        long g3 = b.a.e.e.m.b.g(postWriteCallBackData.getThreadId(), 0L);
                        b.a.r0.j1.o.c cVar = this.mainView;
                        long g4 = (cVar == null || ListUtils.getItem(this.mDataList, cVar.q()) == null) ? 0L : b.a.e.e.m.b.g(String.valueOf(((HotTopicBussinessData) ListUtils.getItem(this.mDataList, this.mainView.q())).mForumId), 0L);
                        if (g2 != 0 && g3 != 0) {
                            int k = l.k(TbadkCoreApplication.getInst());
                            int i4 = l.i(TbadkCoreApplication.getInst());
                            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
                            int i5 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
                            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
                            requestGetMyPostNetMessage.setParams(g3, g2, g4, k, i4, f2, i5);
                            sendMessage(requestGetMyPostNetMessage);
                        }
                    }
                    checkVideoEasterEgg(postWriteCallBackData);
                } else if (i2 == 18003) {
                    String stringExtra = intent.getStringExtra("tid");
                    if (stringExtra != null) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001390, stringExtra));
                    }
                } else if (i2 != 23003) {
                    if (i2 != 23007 || intent == null || ListUtils.isEmpty(this.mHotTopicDataList)) {
                        return;
                    }
                    this.hotTopicShareModel.d(getShareFromTopicMsgData(), intent.getLongExtra(PersonalChatActivityConfig.KEY_USER_ID, -1L), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_NAME), intent.getStringExtra("name_show"), intent.getStringExtra(PersonalChatActivityConfig.KEY_USER_PORTAIT), this.mHotTopicDataList.get(0));
                } else if (intent == null || ListUtils.isEmpty(this.mHotTopicDataList)) {
                } else {
                    this.hotTopicShareModel.c(getShareFromTopicMsgData(), intent.getLongExtra("group_id", 0L), intent.getStringExtra("group_name"), intent.getLongExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, 0L), this.mHotTopicDataList.get(0));
                }
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mainView.B(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, bundle) == null) {
            super.onCreate(bundle);
            initParamsFromIntent(bundle);
            this.mainView = new b.a.r0.j1.o.c(getPageContext(), this.topicId);
            HotTopicModel hotTopicModel = new HotTopicModel(this);
            this.hotTopicModel = hotTopicModel;
            hotTopicModel.C(this);
            LikeModel likeModel = new LikeModel(getPageContext());
            this.likeModel = likeModel;
            likeModel.setLoadDataCallBack(this.mLikeModelCallback);
            HotRelateThreadModel hotRelateThreadModel = new HotRelateThreadModel(this);
            this.hotRelateThreadModel = hotRelateThreadModel;
            hotRelateThreadModel.E(this);
            this.hotRelateThreadModel.D(this);
            this.hotTopicShareModel = new b.a.r0.j1.k.b(this);
            this.blessModel = new BlessModel(this);
            initListeners();
            firstTimeLoadHotTopicData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048597, this) == null) {
            u.b().c();
            b.a.r0.j1.o.c cVar = this.mainView;
            if (cVar != null) {
                cVar.p();
            }
            super.onDestroy();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onNetRefreshButtonClicked() {
        b.a.r0.j1.o.c cVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048598, this) == null) && j.z() && (cVar = this.mainView) != null) {
            cVar.x();
            this.mainView.I(0);
            loadHotTopicData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onPause() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048599, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004011));
            TiebaStatic.log(new StatisticItem("c10817").param(TiebaStatic.Params.OBJ_DURATION, String.valueOf(System.currentTimeMillis() - this.lastResumeTime)));
            setRequestedOrientation(1);
            b.a.r0.j1.o.c cVar = this.mainView;
            if (cVar != null) {
                cVar.D();
            }
            super.onPause();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048600, this) == null) {
            this.lastResumeTime = System.currentTimeMillis();
            super.onResume();
            b.a.r0.j1.o.c cVar = this.mainView;
            if (cVar != null) {
                cVar.F();
            }
        }
    }

    @Override // android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            if (StringUtils.isNull(this.topicName) && StringUtils.isNull(this.topicId)) {
                return;
            }
            bundle.putString("topic_id", this.topicId);
            bundle.putString(IntentConfig.TOPIC_NAME, this.topicName);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            if (this.mainView != null && !ListUtils.isEmpty(this.mHotTopicDataList) && j.z()) {
                b.a.r0.j1.l.e eVar = (b.a.r0.j1.l.e) ListUtils.getItem(this.mHotTopicDataList, this.mainView.q());
                if (eVar != null && eVar.j() != null) {
                    if (eVar.r && this.mIsLoadComplete) {
                        this.hotRelateThreadModel.A(eVar, getSortType());
                        this.mIsLoadComplete = false;
                        return;
                    }
                    return;
                }
                updateLoadingMoreForNetError();
                return;
            }
            updateLoadingMoreForNetError();
        }
    }

    public void sendBlessData() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048603, this) == null) || this.blessModel == null || ListUtils.isEmpty(this.mHotTopicDataList) || !j.z()) {
            return;
        }
        b.a.r0.j1.l.a c2 = this.mHotTopicDataList.get(0).c();
        b.a.r0.j1.l.a d2 = this.mHotTopicDataList.get(0).d();
        if (c2 != null) {
            this.blessModel.w(c2.f18425g, Long.parseLong(this.topicId), 1, 0, 1, c2.f18426h);
        } else if (d2 != null) {
            this.blessModel.w(d2.f18425g, Long.parseLong(this.topicId), 1, 0, 1, d2.f18426h);
        }
    }

    public void sendPkData() {
        i g2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048604, this) == null) || this.blessModel == null || ListUtils.isEmpty(this.mHotTopicDataList) || !j.z() || (g2 = this.mHotTopicDataList.get(0).g()) == null) {
            return;
        }
        this.blessModel.w(g2.l, Long.parseLong(this.topicId), g2.k, 0, 0, g2.m);
    }

    public void shareTopic() {
        f h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048605, this) == null) || ListUtils.isEmpty(this.mHotTopicDataList) || (h2 = this.mHotTopicDataList.get(0).h()) == null) {
            return;
        }
        this.hotTopicShareModel.e(h2.f18447e, h2.f18448f, null, h2.k, h2.j, true);
    }
}
