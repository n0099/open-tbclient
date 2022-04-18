package com.baidu.tieba.im.chat.officialBar;

import android.os.Bundle;
import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.widget.ListView.BdListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.im.chat.officialBar.ResponseHistoryMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mg;
import com.repackage.n57;
import com.repackage.ya;
import java.util.List;
/* loaded from: classes3.dex */
public class OfficialBarHistoryActivity extends BaseActivity<OfficialBarHistoryActivity> implements BdListView.p {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean isRefreshing;
    public List<ResponseHistoryMessage.a> mDataList;
    public a mListener;
    public b mLocalListener;
    public n57 mView;
    public int mforumId;

    /* loaded from: classes3.dex */
    public class a extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarHistoryActivity a;

        /* renamed from: com.baidu.tieba.im.chat.officialBar.OfficialBarHistoryActivity$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0197a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ a a;

            public RunnableC0197a(a aVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.a.mView.g()) {
                    return;
                }
                this.a.a.getNextPage();
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
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.hideProgressBar();
                this.a.isRefreshing = false;
                if (socketResponsedMessage == null) {
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                    this.a.mView.j(this.a.mDataList);
                } else if (socketResponsedMessage.getError() != 0) {
                    this.a.showToast(socketResponsedMessage.getErrorString());
                    this.a.mView.j(this.a.mDataList);
                } else if (socketResponsedMessage.getCmd() != 208002 || !(socketResponsedMessage instanceof ResponseHistoryMessage)) {
                    this.a.mView.j(this.a.mDataList);
                    this.a.showToast(R.string.obfuscated_res_0x7f0f0c17);
                } else {
                    ResponseHistoryMessage responseHistoryMessage = (ResponseHistoryMessage) socketResponsedMessage;
                    if (responseHistoryMessage.getMsg().isEmpty()) {
                        this.a.mView.j(this.a.mDataList);
                        return;
                    }
                    RequestHistoryMessage requestHistoryMessage = (RequestHistoryMessage) responseHistoryMessage.getOrginalMessage();
                    if (requestHistoryMessage == null) {
                        this.a.mView.j(this.a.mDataList);
                        return;
                    }
                    if (requestHistoryMessage.getRequestId() != 0) {
                        this.a.mDataList.addAll(responseHistoryMessage.getMsg());
                    } else {
                        this.a.mDataList = responseHistoryMessage.getMsg();
                    }
                    this.a.mView.h(this.a.mDataList);
                    if (responseHistoryMessage.getMsg().size() == 0) {
                        this.a.mView.j(this.a.mDataList);
                    } else {
                        new Handler().post(new RunnableC0197a(this));
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ OfficialBarHistoryActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(OfficialBarHistoryActivity officialBarHistoryActivity) {
            super(2001152);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {officialBarHistoryActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = officialBarHistoryActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) {
                this.a.hideProgressBar();
                if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2001152 && (customResponsedMessage instanceof ResponseLocalHistoryMessage)) {
                    ResponseLocalHistoryMessage responseLocalHistoryMessage = (ResponseLocalHistoryMessage) customResponsedMessage;
                    if (responseLocalHistoryMessage.getData().isEmpty()) {
                        return;
                    }
                    if (this.a.mDataList == null || this.a.mDataList.isEmpty()) {
                        this.a.mDataList = responseLocalHistoryMessage.getData();
                        this.a.mView.h(this.a.mDataList);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65542, this) == null) {
            List<ResponseHistoryMessage.a> list = this.mDataList;
            if (list == null || list.isEmpty()) {
                i = 0;
            } else {
                List<ResponseHistoryMessage.a> list2 = this.mDataList;
                i = list2.get(list2.size() - 1).d;
            }
            this.isRefreshing = true;
            MessageManager.getInstance().sendMessage(new RequestHistoryMessage(this.mforumId, mg.g(TbadkCoreApplication.getCurrentAccount(), 0L), i));
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
            n57 n57Var = new n57(this);
            this.mView = n57Var;
            n57Var.i(this);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            super.onChangeSkinType(i);
            this.mView.onChangeSkinType(i);
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
