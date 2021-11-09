package com.baidu.tieba.im;

import android.net.Uri;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.q0.d1.i0;
import b.a.q0.d1.l0;
import b.a.q0.d1.u0;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.framework.task.CustomMessageTask;
import com.baidu.adp.framework.task.SocketMessageTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.atomData.AddGroupActivityConfig;
import com.baidu.tbadk.core.atomData.ForumBroadCastMajorHistoryActivityConfig;
import com.baidu.tbadk.core.atomData.ForumDetailActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarFeedActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialBarTipActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialHistoryImageActivityConfig;
import com.baidu.tbadk.core.atomData.OfficialMsgImageActivityConfig;
import com.baidu.tbadk.core.atomData.PersonGroupActivityConfig;
import com.baidu.tbadk.core.atomData.RecommendDetailActivityConfig;
import com.baidu.tbadk.core.atomData.SingleForumBroadcastFeedActivityConfig;
import com.baidu.tbadk.core.atomData.UpdatesActivityConfig;
import com.baidu.tbadk.core.atomData.ValidateActivityConfig;
import com.baidu.tbadk.core.atomData.VideoListActivityConfig;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.flutter.base.util.OpenFlutter;
import com.baidu.tieba.forumMember.tbtitle.TbTitleActivityConfig;
import com.baidu.tieba.im.chat.GroupChatActivity;
import com.baidu.tieba.im.chat.MsgActivityViewItemAdapter;
import com.baidu.tieba.im.chat.MsgAdapterScanMessage;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.OfficialMsgImageActivity;
import com.baidu.tieba.im.chat.officialBar.MsgMultiImageTextViewItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarChatActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarTipActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialHistoryImageActivity;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.tieba.im.chat.officialBar.ResponseOfficialBarInfoMessage;
import com.baidu.tieba.im.chat.officialBar.SingleForumBroadcastFeedActivity;
import com.baidu.tieba.im.chat.photolive.MsgPhotoLiveItemAdapter;
import com.baidu.tieba.im.data.OfficialBarHistoryActivityConfig;
import com.baidu.tieba.im.data.UpdatesItemData;
import com.baidu.tieba.im.data.ValidateItemData;
import com.baidu.tieba.im.db.pojo.GroupNewsPojo;
import com.baidu.tieba.im.forum.detail.ForumDetailActivity;
import com.baidu.tieba.im.forum.detail.ForumDetailHttpResponse;
import com.baidu.tieba.im.forum.detail.ForumDetailSocketResponse;
import com.baidu.tieba.im.groupUpdates.UpdatesActivity;
import com.baidu.tieba.im.message.MemoryModifyVisibilityMessage;
import com.baidu.tieba.im.message.RequestSendPVTJMessage;
import com.baidu.tieba.im.message.ResponseAddGroupMessage;
import com.baidu.tieba.im.message.ResponseGroupsByUidMessage;
import com.baidu.tieba.im.message.ResponseOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponsePushCountMessage;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.message.ResponseSendOfficialBarMenuMessage;
import com.baidu.tieba.im.message.ResponseSendPVTJMessage;
import com.baidu.tieba.im.message.chat.ChatMessage;
import com.baidu.tieba.im.model.IUpdatesModel;
import com.baidu.tieba.im.model.IValidateModel;
import com.baidu.tieba.im.model.UpdatesModel;
import com.baidu.tieba.im.model.ValidateModel;
import com.baidu.tieba.im.mygroup.PersonGroupActivity;
import com.baidu.tieba.im.recommend.detail.RecommendDetailActivity;
import com.baidu.tieba.im.recommend.detail.RecommendDetailHttpResponseMessage;
import com.baidu.tieba.im.recommend.detail.RecommendDetailSocketResponseMessage;
import com.baidu.tieba.im.searchGroup.AddGroupActivity;
import com.baidu.tieba.im.validate.ValidateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes9.dex */
public class TiebaIMActivityStatic {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes9.dex */
    public static class a implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<Boolean> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null) {
                    return null;
                }
                String data = customMessage.getData();
                if (TextUtils.isEmpty(data)) {
                    return null;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new MemoryModifyVisibilityMessage(new MemoryModifyVisibilityMessage.a(data, 4, false)));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class b implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001299, new q()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class c implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (strArr != null && strArr[0] != null) {
                    String lowerCase = strArr[0].toLowerCase();
                    StringBuilder sb = new StringBuilder();
                    StringBuilder sb2 = new StringBuilder();
                    if (UtilHelper.parsePushMidPageUrl(lowerCase, sb, sb2)) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016486));
                        tbPageContext.sendMessage(new CustomMessage(2002001, new VideoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(sb.toString(), sb2.toString(), "push")));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class d implements CustomMessageTask.CustomRunnable<OfficialBarTipActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public d() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<OfficialBarTipActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(OfficialBarTipActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class e implements CustomMessageTask.CustomRunnable<UpdatesActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<UpdatesActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().getIntent().setFlags(268435456);
                    customMessage.getData().startActivity(UpdatesActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class f implements CustomMessageTask.CustomRunnable<ValidateActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public f() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<ValidateActivityConfig> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    customMessage.getData().startActivity(ValidateActivity.class);
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class g extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public g(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbPageContext<MsglistActivity<?>> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f50188b == null || (tbPageContext = aVar.f50187a) == null) {
                return;
            }
            MsgMultiImageTextViewItemAdapter msgMultiImageTextViewItemAdapter = new MsgMultiImageTextViewItemAdapter(tbPageContext, ChatMessage.TYPE_MSG_MULTI_PIC_TEXT);
            msgMultiImageTextViewItemAdapter.l0(true);
            aVar.f50188b.add(msgMultiImageTextViewItemAdapter);
        }
    }

    /* loaded from: classes9.dex */
    public static class h implements CustomMessageTask.CustomRunnable<OfficalBarChatActivityConfig> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* loaded from: classes9.dex */
        public class a extends i0<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ LinkedList f50153a;

            public a(h hVar, LinkedList linkedList) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, linkedList};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50153a = linkedList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.d1.i0
            /* renamed from: a */
            public Void doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? b.a.r0.l1.h.l.t().a(this.f50153a) : (Void) invokeV.objValue;
            }
        }

        /* loaded from: classes9.dex */
        public class b implements b.a.q0.d1.q<Void> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CustomMessage f50154a;

            public b(h hVar, CustomMessage customMessage) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {hVar, customMessage};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f50154a = customMessage;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // b.a.q0.d1.q
            /* renamed from: a */
            public void onReturnDataInUI(Void r5) {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeL(1048576, this, r5) == null) || ((OfficalBarChatActivityConfig) this.f50154a.getData()).getUserData().getUserIdLong() == 0) {
                    return;
                }
                ((OfficalBarChatActivityConfig) this.f50154a.getData()).startActivity(OfficialBarChatActivity.class);
            }
        }

        public h() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<OfficalBarChatActivityConfig> run(CustomMessage<OfficalBarChatActivityConfig> customMessage) {
            InterceptResult invokeL;
            UserData userData;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage == null || customMessage.getData() == null || (userData = customMessage.getData().getUserData()) == null) {
                    return null;
                }
                LinkedList linkedList = new LinkedList();
                linkedList.add(String.valueOf(userData.getUserId()));
                l0.c(new a(this, linkedList), new b(this, customMessage));
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class i implements UrlManager.UrlDealListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public i() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tbadk.core.util.UrlManager.UrlDealListener
        public int deal(TbPageContext<?> tbPageContext, String[] strArr) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, tbPageContext, strArr)) == null) {
                if (tbPageContext != null && strArr != null && strArr.length != 0) {
                    String str = strArr[0];
                    if (str.contains(TbConfig.WEB_VIEW_JUMP2NATIVE) && str.contains(UrlSchemaHelper.GOTO_OFFICIAL_CHAT)) {
                        String c2 = u0.c(str, "barid=");
                        String c3 = u0.c(str, "barname=");
                        String c4 = u0.c(str, "portrait=");
                        if (c2 == null || c2.length() <= 0) {
                            return 1;
                        }
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(tbPageContext.getPageActivity(), b.a.e.e.m.b.g(c2, 0L), c3, c4, 0)));
                        return 1;
                    } else if (str.contains(UrlSchemaHelper.SCHEMA_FORUM_BROADCAST_SINGLE_FEED)) {
                        Uri parse = Uri.parse(str);
                        String queryParameter = parse.getQueryParameter("id");
                        String queryParameter2 = parse.getQueryParameter("name");
                        String queryParameter3 = parse.getQueryParameter("from_yunpush");
                        SingleForumBroadcastFeedActivityConfig singleForumBroadcastFeedActivityConfig = new SingleForumBroadcastFeedActivityConfig(tbPageContext.getPageActivity(), queryParameter, queryParameter2);
                        singleForumBroadcastFeedActivityConfig.setSource(StringUtils.isNull(queryParameter3) ? (byte) 3 : (byte) 2);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, singleForumBroadcastFeedActivityConfig));
                        return 0;
                    } else if (str.contains(UrlSchemaHelper.SCHEMA_FORUM_BROADCAST_REVIEWED)) {
                        Uri parse2 = Uri.parse(str);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForumBroadCastMajorHistoryActivityConfig(tbPageContext.getPageActivity(), parse2.getQueryParameter("id"), parse2.getQueryParameter("name"))));
                        return 0;
                    } else if (str.contains(UrlSchemaHelper.SCHEMA_FORUM_DETAIL_FLUTTER)) {
                        String queryParameter4 = Uri.parse(str).getQueryParameter(TbTitleActivityConfig.FORUM_ID);
                        HashMap hashMap = new HashMap();
                        hashMap.put("forum_id", queryParameter4);
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(tbPageContext.getPageActivity(), OpenFlutter.ACTIVITY_FORUM_DETAIL, hashMap)));
                        return 0;
                    } else if (str.contains(UrlSchemaHelper.SCHEMA_VIDEO_CREATE_CENTER)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new b.a.r0.l3.j0.n(tbPageContext.getPageActivity(), "CreateCenter", new HashMap())));
                        return 0;
                    }
                }
                return 3;
            }
            return invokeLL.intValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class j implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public j() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001289, Integer.valueOf(R.drawable.icon_im_subscribe)) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class k implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public k() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001290, Integer.valueOf(R.drawable.icon_im_tie)) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class l implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public l() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001286, Integer.valueOf(R.drawable.icon_new_trends)) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class m implements CustomMessageTask.CustomRunnable<Void> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public m() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<?> run(CustomMessage<Void> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) ? new CustomResponsedMessage<>(2001298, new p()) : (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class n extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            TbPageContext<MsglistActivity<?>> tbPageContext;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof MsgAdapterScanMessage.a)) {
                return;
            }
            MsgAdapterScanMessage.a aVar = (MsgAdapterScanMessage.a) customResponsedMessage.getData();
            if (aVar.f50188b == null || (tbPageContext = aVar.f50187a) == null) {
                return;
            }
            MsgPhotoLiveItemAdapter msgPhotoLiveItemAdapter = new MsgPhotoLiveItemAdapter(tbPageContext, ChatMessage.TYPE_MSG_PHOTOLIVE);
            msgPhotoLiveItemAdapter.k0(true);
            aVar.f50188b.add(msgPhotoLiveItemAdapter);
            MsgActivityViewItemAdapter msgActivityViewItemAdapter = new MsgActivityViewItemAdapter(aVar.f50187a, ChatMessage.TYPE_MSG_GROUP_ACTIVITY);
            msgActivityViewItemAdapter.k0(true);
            msgActivityViewItemAdapter.l0(true);
            aVar.f50188b.add(msgActivityViewItemAdapter);
        }
    }

    /* loaded from: classes9.dex */
    public static class o implements CustomMessageTask.CustomRunnable<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public o() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.adp.framework.task.CustomMessageTask.CustomRunnable
        public CustomResponsedMessage<String> run(CustomMessage<String> customMessage) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, customMessage)) == null) {
                if (customMessage != null && customMessage.getData() != null) {
                    RequestSendPVTJMessage.sendOfficialBarPVTJ(RequestSendPVTJMessage.TYPE_KD_MREAD, customMessage.getData());
                }
                return null;
            }
            return (CustomResponsedMessage) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class p implements IUpdatesModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public p() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.im.model.IUpdatesModel
        public UpdatesItemData convertToUpdatesItem(GroupNewsPojo groupNewsPojo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, groupNewsPojo)) == null) ? UpdatesModel.convertToUpdatesItem(groupNewsPojo) : (UpdatesItemData) invokeL.objValue;
        }
    }

    /* loaded from: classes9.dex */
    public static class q implements IValidateModel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public q() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public ValidateItemData convertToValidateItemData(GroupNewsPojo groupNewsPojo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, groupNewsPojo)) == null) ? ValidateModel.convertToValidateItemData(groupNewsPojo) : (ValidateItemData) invokeL.objValue;
        }

        @Override // com.baidu.tieba.im.model.IValidateModel
        public List<ValidateItemData> convertToValidateItemDataList(LinkedList<GroupNewsPojo> linkedList) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, linkedList)) == null) ? ValidateModel.convertToValidateItemDataList(linkedList) : (List) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1767267800, "Lcom/baidu/tieba/im/TiebaIMActivityStatic;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1767267800, "Lcom/baidu/tieba/im/TiebaIMActivityStatic;");
                return;
            }
        }
        TbadkApplication.getInst().RegisterIntent(GroupChatActivityConfig.class, GroupChatActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialMsgImageActivityConfig.class, OfficialMsgImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialBarHistoryActivityConfig.class, OfficialBarHistoryActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialHistoryImageActivityConfig.class, OfficialHistoryImageActivity.class);
        TbadkApplication.getInst().RegisterIntent(PersonGroupActivityConfig.class, PersonGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(AddGroupActivityConfig.class, AddGroupActivity.class);
        TbadkApplication.getInst().RegisterIntent(ForumDetailActivityConfig.class, ForumDetailActivity.class);
        TbadkApplication.getInst().RegisterIntent(RecommendDetailActivityConfig.class, RecommendDetailActivity.class);
        TbadkApplication.getInst().RegisterIntent(OfficialBarFeedActivityConfig.class, OfficialBarFeedActivity.class);
        TbadkApplication.getInst().RegisterIntent(SingleForumBroadcastFeedActivityConfig.class, SingleForumBroadcastFeedActivity.class);
        d();
        j();
        b();
        a();
        h();
        c();
        e();
        g();
        f();
        MessageManager.getInstance().registerListener(new g(2001275));
        OfficalBarChatActivityConfig.IS_SUPPORT_OFFICIAL_CHAT = true;
        CustomMessageTask customMessageTask = new CustomMessageTask(2002006, new h());
        customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask);
        UrlManager.getInstance().addListener(new i());
        CustomMessageTask customMessageTask2 = new CustomMessageTask(2001289, new j());
        customMessageTask2.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask2);
        CustomMessageTask customMessageTask3 = new CustomMessageTask(2001290, new k());
        customMessageTask3.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask3);
        CustomMessageTask customMessageTask4 = new CustomMessageTask(2001286, new l());
        customMessageTask4.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask4);
        CustomMessageTask customMessageTask5 = new CustomMessageTask(2001298, new m());
        customMessageTask5.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask5);
        MessageManager.getInstance().registerListener(new n(2001275));
        CustomMessageTask customMessageTask6 = new CustomMessageTask(2012110, new o());
        customMessageTask6.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask6);
        CustomMessageTask customMessageTask7 = new CustomMessageTask(2003004, new a());
        customMessageTask7.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask7);
        CustomMessageTask customMessageTask8 = new CustomMessageTask(2001306, new b.a.r0.l1.q.a.a());
        customMessageTask8.setType(CustomMessageTask.TASK_TYPE.ASYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask8);
        CustomMessageTask customMessageTask9 = new CustomMessageTask(2001299, new b());
        customMessageTask9.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
        MessageManager.getInstance().registerTask(customMessageTask9);
    }

    public TiebaIMActivityStatic() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            i(2001106, b.a.r0.l1.v.a.n.class);
            i(2001205, b.a.r0.l1.v.a.p.class);
            i(2001206, b.a.r0.l1.v.a.o.class);
            i(2001207, b.a.r0.l1.v.a.q.class);
            i(2001144, b.a.r0.l1.v.a.g.class);
            i(2001147, b.a.r0.l1.v.a.m.class);
            i(2001154, b.a.r0.l1.v.a.j.class);
            i(2001150, b.a.r0.l1.v.a.h.class);
            i(2001151, b.a.r0.l1.v.a.i.class);
            i(2001152, b.a.r0.l1.v.a.k.class);
            i(2001177, b.a.r0.l1.v.a.l.class);
            return true;
        }
        return invokeV.booleanValue;
    }

    public static boolean b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) {
            k(103003, ResponseGroupsByUidMessage.class, false);
            k(202101, ResponsePushCountMessage.class, false);
            k(103101, ResponseAddGroupMessage.class, false);
            k(208001, ResponseOfficialBarInfoMessage.class, false);
            k(208002, ResponseHistoryMessage.class, false);
            k(104001, ResponseSendPVTJMessage.class, false);
            k(103007, ResponseSearchGroupMessage.class, false).f(SocketMessageTask.DupLicateMode.REMOVE_WAITING);
            k(303006, ResponseOfficialBarMenuMessage.class, false);
            k(208003, ResponseSendOfficialBarMenuMessage.class, false);
            return true;
        }
        return invokeV.booleanValue;
    }

    public static void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2008022, new d());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null) == null) {
            UrlManager.getInstance().addListener(new c());
        }
    }

    public static void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2008013, new e());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65543, null) == null) {
            CustomMessageTask customMessageTask = new CustomMessageTask(2008021, new f());
            customMessageTask.setType(CustomMessageTask.TASK_TYPE.SYNCHRONIZED);
            MessageManager.getInstance().registerTask(customMessageTask);
        }
    }

    public static void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_RECOMMEND_DETAIL, b.a.r0.l3.f0.a.a(RecommendDetailActivity.RECOMMEND_DETAIL_URL, 303025));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(RecommendDetailHttpResponseMessage.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            b.a.r0.l3.f0.a.f(303025, RecommendDetailSocketResponseMessage.class, false);
        }
    }

    public static boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, null)) == null) {
            MessageManager.getInstance().addResponsedMessageRule(new b.a.r0.l1.l.a());
            MessageManager.getInstance().addResponsedMessageRule(new b.a.r0.l1.l.b());
            return true;
        }
        return invokeV.booleanValue;
    }

    public static b.a.q0.z0.a i(int i2, Class<? extends CustomMessageTask.CustomRunnable<?>> cls) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeIL = interceptable.invokeIL(65546, null, i2, cls)) == null) ? b.a.r0.l1.c.a(i2, cls) : (b.a.q0.z0.a) invokeIL.objValue;
    }

    public static void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65547, null) == null) {
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.MSG_FORUM_DETAIL_CMD, b.a.r0.l3.f0.a.a(TbConfig.GET_FORUM_DETAIL, 303021));
            tbHttpMessageTask.setIsNeedLogin(false);
            tbHttpMessageTask.setIsNeedTbs(false);
            tbHttpMessageTask.setIsNeedAddCommenParam(false);
            tbHttpMessageTask.setIsUseCurrentBDUSS(false);
            tbHttpMessageTask.setResponsedClass(ForumDetailHttpResponse.class);
            MessageManager.getInstance().registerTask(tbHttpMessageTask);
            b.a.r0.l3.f0.a.f(303021, ForumDetailSocketResponse.class, false);
        }
    }

    public static b.a.q0.z0.b k(int i2, Class<? extends SocketResponsedMessage> cls, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65548, null, new Object[]{Integer.valueOf(i2), cls, Boolean.valueOf(z)})) == null) ? b.a.r0.l1.c.b(i2, cls, z) : (b.a.q0.z0.b) invokeCommon.objValue;
    }
}
