package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import c.a.e.c.g.c;
import c.a.r0.l1.f.j.d;
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
import java.util.List;
/* loaded from: classes7.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRefreshing;
    public List<ResponseHistoryMessage.a> mDataList;
    public a mListener;
    public b mLocalListener;
    public d mView;
    public int mforumId;

    /* loaded from: classes7.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarHistoryActivity f53012a;

        /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes7.dex */
        public class RunnableC1769a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ a f53013e;

            public RunnableC1769a(a aVar) {
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
                this.f53013e = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f53013e.f53012a.mView.e()) {
                    return;
                }
                this.f53013e.f53012a.getNextPage();
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
            this.f53012a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.f53012a.hideProgressBar();
                this.f53012a.isRefreshing = false;
                if (socketResponsedMessage == null) {
                    this.f53012a.showToast(R.string.neterror);
                    this.f53012a.mView.h(this.f53012a.mDataList);
                } else if (socketResponsedMessage.getError() != 0) {
                    this.f53012a.showToast(socketResponsedMessage.getErrorString());
                    this.f53012a.mView.h(this.f53012a.mDataList);
                } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                    this.f53012a.mView.h(this.f53012a.mDataList);
                    this.f53012a.showToast(R.string.neterror);
                } else {
                    ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                    if (responseHistoryMessage.getMsg().isEmpty()) {
                        this.f53012a.mView.h(this.f53012a.mDataList);
                        return;
                    }
                    RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                    if (requestHistoryMessage == null) {
                        this.f53012a.mView.h(this.f53012a.mDataList);
                        return;
                    }
                    if (requestHistoryMessage.getRequestId() != 0) {
                        this.f53012a.mDataList.addAll(responseHistoryMessage.getMsg());
                    } else {
                        this.f53012a.mDataList = responseHistoryMessage.getMsg();
                    }
                    this.f53012a.mView.f(this.f53012a.mDataList);
                    if (responseHistoryMessage.getMsg().size() == 0) {
                        this.f53012a.mView.h(this.f53012a.mDataList);
                    } else {
                        new Handler().post(new RunnableC1769a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OfficialBarHistoryActivity f53014a;

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
            this.f53014a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.f53014a.hideProgressBar();
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001152 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
                    ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
                    if (responseLocalHistoryMessage.getData().isEmpty()) {
                        return;
                    }
                    if (this.f53014a.mDataList == null || this.f53014a.mDataList.isEmpty()) {
                        this.f53014a.mDataList = responseLocalHistoryMessage.getData();
                        this.f53014a.mView.f(this.f53014a.mDataList);
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
                i2 = list2.get(list2.size() - 1).f53059d;
            }
            this.isRefreshing = true;
            MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.mforumId, c.a.e.e.m.b.g(TbadkCoreApplication.getCurrentAccount(), 0L), i2));
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
            dVar.g(this);
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
