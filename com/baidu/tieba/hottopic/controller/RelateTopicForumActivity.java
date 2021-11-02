package com.baidu.tieba.hottopic.controller;

import android.content.Intent;
import android.os.Bundle;
import b.a.e.a.e;
import b.a.e.e.p.l;
import b.a.r0.j1.j.j;
import b.a.r0.j1.o.d;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.hottopic.data.RelateForumItemData;
import com.baidu.tieba.tbadkCore.LikeModel;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class RelateTopicForumActivity extends BaseActivity<RelateTopicForumActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<RelateForumItemData> dataList;
    public CustomMessageListener likeForumListener;
    public LikeModel likeModel;
    public d mHotTopicMoreView;
    public e mLikeModelCallback;
    public String topicId;
    public CustomMessageListener unLikeForumListener;

    /* loaded from: classes9.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateTopicForumActivity f50014a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(RelateTopicForumActivity relateTopicForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateTopicForumActivity, Integer.valueOf(i2)};
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
            this.f50014a = relateTopicForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f50014a.dataList.isEmpty()) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData itemByForumId = this.f50014a.getItemByForumId(((Long) data).longValue());
                if (itemByForumId != null) {
                    itemByForumId.followNum++;
                    itemByForumId.setIsLiked(true);
                    j e2 = this.f50014a.mHotTopicMoreView.e();
                    if (e2 != null) {
                        e2.d(this.f50014a.dataList, this.f50014a.topicId);
                        e2.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateTopicForumActivity f50015a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(RelateTopicForumActivity relateTopicForumActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateTopicForumActivity, Integer.valueOf(i2)};
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
            this.f50015a = relateTopicForumActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || this.f50015a.dataList.isEmpty()) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Long) {
                RelateForumItemData itemByForumId = this.f50015a.getItemByForumId(((Long) data).longValue());
                if (itemByForumId != null) {
                    itemByForumId.followNum--;
                    itemByForumId.setIsLiked(false);
                    j e2 = this.f50015a.mHotTopicMoreView.e();
                    if (e2 != null) {
                        e2.d(this.f50015a.dataList, this.f50015a.topicId);
                        e2.notifyDataSetChanged();
                    }
                }
            }
        }
    }

    /* loaded from: classes9.dex */
    public class c extends e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RelateTopicForumActivity f50016a;

        public c(RelateTopicForumActivity relateTopicForumActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {relateTopicForumActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50016a = relateTopicForumActivity;
        }

        @Override // b.a.e.a.e
        public void c(Object obj) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, obj) == null) {
                if (AntiHelper.m(this.f50016a.likeModel.getErrorCode(), this.f50016a.likeModel.getErrorString())) {
                    AntiHelper.u(this.f50016a.getActivity(), this.f50016a.likeModel.getErrorString());
                } else if (StringUtils.isNull(this.f50016a.likeModel.getErrorString())) {
                } else {
                    l.M(TbadkCoreApplication.getInst(), this.f50016a.likeModel.getErrorString());
                }
            }
        }
    }

    public RelateTopicForumActivity() {
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
        this.dataList = new ArrayList<>();
        this.topicId = "";
        this.likeForumListener = new a(this, 2001335);
        this.unLikeForumListener = new b(this, 2001336);
        this.mLikeModelCallback = new c(this);
    }

    private void dealNoMoreView() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this) == null) || this.mHotTopicMoreView == null) {
            return;
        }
        if (this.dataList.isEmpty()) {
            this.mHotTopicMoreView.f();
        } else {
            this.mHotTopicMoreView.h();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RelateForumItemData getItemByForumId(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(AdIconUtil.BAIDU_LOGO_ID, this, j)) == null) {
            for (int i2 = 0; i2 < this.dataList.size(); i2++) {
                if (ListUtils.getItem(this.dataList, i2) != null && (this.dataList.get(i2) instanceof RelateForumItemData)) {
                    RelateForumItemData relateForumItemData = this.dataList.get(i2);
                    if (j == relateForumItemData.forumId) {
                        return relateForumItemData;
                    }
                }
            }
            return null;
        }
        return (RelateForumItemData) invokeJ.objValue;
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bundle) == null) {
            String str = "";
            try {
                if (bundle != null) {
                    if (bundle.getSerializable("data_list") == null || !(bundle.getSerializable("data_list") instanceof ArrayList)) {
                        return;
                    }
                    this.dataList = (ArrayList) bundle.getSerializable("data_list");
                    if (bundle.getString("topic_id") != null) {
                        str = bundle.getString("topic_id");
                    }
                    this.topicId = str;
                    return;
                }
                Intent intent = getIntent();
                if (intent == null || intent.getSerializableExtra("data_list") == null || !(intent.getSerializableExtra("data_list") instanceof ArrayList)) {
                    return;
                }
                this.dataList = (ArrayList) intent.getSerializableExtra("data_list");
                if (intent.getStringExtra("topic_id") != null) {
                    str = intent.getStringExtra("topic_id");
                }
                this.topicId = str;
            } catch (Exception unused) {
            }
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mHotTopicMoreView = new d(getPageContext().getOrignalPage(), this.dataList);
            dealNoMoreView();
        }
    }

    private void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            registerListener(this.likeForumListener);
            registerListener(this.unLikeForumListener);
        }
    }

    public String getTopicId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.topicId : (String) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mHotTopicMoreView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            initData(bundle);
            LikeModel likeModel = new LikeModel(getPageContext());
            this.likeModel = likeModel;
            likeModel.setLoadDataCallBack(this.mLikeModelCallback);
            registerListener();
            initUI();
            TiebaStatic.log("c10335a");
        }
    }
}
