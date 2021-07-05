package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.c.g.c;
import d.a.s0.i1.f.j.d;
import java.util.List;
/* loaded from: classes5.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRefreshing;
    public List<ResponseHistoryMessage.a> mDataList;
    public a mListener;
    public b mLocalListener;
    public d mView;
    public int mforumId;

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarHistoryActivity f17352a;

        /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC0205a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f17353e;

            public RunnableC0205a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i2 = newInitContext.flag;
                    if ((i2 & 1) != 0) {
                        int i3 = i2 & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.f17353e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f17353e.f17352a.mView.f()) {
                    return;
                }
                this.f17353e.f17352a.getNextPage();
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(OfficialBarHistoryActivity officialBarHistoryActivity) {
            super(208002);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarHistoryActivity};
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
            this.f17352a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f17352a.hideProgressBar();
                this.f17352a.isRefreshing = false;
                if (socketResponsedMessage == null) {
                    this.f17352a.showToast(R.string.neterror);
                    this.f17352a.mView.i(this.f17352a.mDataList);
                } else if (socketResponsedMessage.getError() != 0) {
                    this.f17352a.showToast(socketResponsedMessage.getErrorString());
                    this.f17352a.mView.i(this.f17352a.mDataList);
                } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                    this.f17352a.mView.i(this.f17352a.mDataList);
                    this.f17352a.showToast(R.string.neterror);
                } else {
                    ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                    if (responseHistoryMessage.getMsg().isEmpty()) {
                        this.f17352a.mView.i(this.f17352a.mDataList);
                        return;
                    }
                    RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                    if (requestHistoryMessage == null) {
                        this.f17352a.mView.i(this.f17352a.mDataList);
                        return;
                    }
                    if (requestHistoryMessage.getRequestId() != 0) {
                        this.f17352a.mDataList.addAll(responseHistoryMessage.getMsg());
                    } else {
                        this.f17352a.mDataList = responseHistoryMessage.getMsg();
                    }
                    this.f17352a.mView.g(this.f17352a.mDataList);
                    if (responseHistoryMessage.getMsg().size() == 0) {
                        this.f17352a.mView.i(this.f17352a.mDataList);
                    } else {
                        new Handler().post(new RunnableC0205a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarHistoryActivity f17354a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OfficialBarHistoryActivity officialBarHistoryActivity) {
            super(2001152);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarHistoryActivity};
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
            this.f17354a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f17354a.hideProgressBar();
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001152 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
                    ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
                    if (responseLocalHistoryMessage.getData().isEmpty()) {
                        return;
                    }
                    if (this.f17354a.mDataList == null || this.f17354a.mDataList.isEmpty()) {
                        this.f17354a.mDataList = responseLocalHistoryMessage.getData();
                        this.f17354a.mView.g(this.f17354a.mDataList);
                    }
                }
            }
        }
    }

    public OfficialBarHistoryActivity() {
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
        this.mforumId = 0;
        this.isRefreshing = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getNextPage() {
        int i2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this) == null) {
            List<ResponseHistoryMessage.a> list = this.mDataList;
            if (list == null || list.isEmpty()) {
                i2 = 0;
            } else {
                List<ResponseHistoryMessage.a> list2 = this.mDataList;
                i2 = list2.get(list2.size() - 1).f17397d;
            }
            this.isRefreshing = true;
            MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.mforumId, d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), i2));
        }
    }

    private void initData(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65543, this, bundle) == null) {
            this.mforumId = getIntent().getIntExtra("forum_id", 0);
            MessageManager.getInstance().sendMessage(new RequestLocalHistoryMessage(String.valueOf(this.mforumId)));
            getNextPage();
        }
    }

    private void initListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65544, this) == null) {
            this.mListener = new a(this);
            this.mLocalListener = new b(this);
            registerListener(this.mListener);
            registerListener(this.mLocalListener);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65545, this) == null) {
            d dVar = new d(this);
            this.mView = dVar;
            dVar.h(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.mView.onChangeSkinType(i2);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            super.onCreate(bundle);
            initListener();
            initUI();
            initData(bundle);
        }
    }

    @Override // com.baidu.adp.widget.ListView.BdListView.p
    public void onScrollToBottom() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || this.isRefreshing) {
            return;
        }
        getNextPage();
    }
}
