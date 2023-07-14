package com.baidu.tieba.addresslist.im.searchfriend;

import android.os.Bundle;
import android.view.View;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.atomData.OfficalBarChatActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.UserIconBox;
import com.baidu.tbadk.coreExtra.search.ResponseSearchFriendMessage;
import com.baidu.tbadk.data.SearchFriendResult;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.kg5;
import com.baidu.tieba.ng;
import com.baidu.tieba.p86;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes5.dex */
public class SearchFriendActivity extends BaseActivity<SearchFriendActivity> implements UserIconBox.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public p86 a;
    public NavigationBar b;
    public View c;
    public View d;
    public p86.c e;
    public CustomMessageListener f;
    public final HttpMessageListener g;

    /* loaded from: classes5.dex */
    public class a implements p86.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchFriendActivity a;

        public a(SearchFriendActivity searchFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchFriendActivity;
        }

        @Override // com.baidu.tieba.p86.c
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SEARCH_FRIEND_CMD);
                httpMessage.addParam("search_key", str);
                this.a.sendMessage(httpMessage);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(SearchFriendActivity searchFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchFriendActivity, Integer.valueOf(i)};
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
            this.a = searchFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            SearchFriendResult.UserInfo userInfo;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof ArrayList) || !(customResponsedMessage.getOrginalMessage() instanceof CustomMessage)) {
                return;
            }
            CustomMessage customMessage = (CustomMessage) customResponsedMessage.getOrginalMessage();
            if (!(customMessage.getData() instanceof SearchFriendResult.UserInfo) || (userInfo = (SearchFriendResult.UserInfo) customMessage.getData()) == null) {
                return;
            }
            ArrayList arrayList = (ArrayList) customResponsedMessage.getData();
            if (arrayList != null && arrayList.size() != 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    Object next = it.next();
                    if ((next instanceof kg5) && userInfo.getUserId() == ((kg5) next).d()) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002006, new OfficalBarChatActivityConfig(this.a.getPageContext().getPageActivity(), userInfo.getUserId(), userInfo.getUserName(), userInfo.getPortrait(), 0, 4)));
                        return;
                    }
                }
                this.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
                return;
            }
            this.a.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.getPageContext().getPageActivity(), String.valueOf(userInfo.getUserId()), userInfo.getUserName(), null, "search")));
        }
    }

    /* loaded from: classes5.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchFriendActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(SearchFriendActivity searchFriendActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchFriendActivity, Integer.valueOf(i)};
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
            this.a = searchFriendActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) && httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1001521) {
                this.a.a.j(true);
                int statusCode = httpResponsedMessage.getStatusCode();
                int error = httpResponsedMessage.getError();
                if (!(httpResponsedMessage instanceof ResponseSearchFriendMessage)) {
                    return;
                }
                ResponseSearchFriendMessage responseSearchFriendMessage = (ResponseSearchFriendMessage) httpResponsedMessage;
                if (statusCode == 200 && error == 0 && responseSearchFriendMessage.getSearchFriendResult() != null) {
                    List<SearchFriendResult.UserInfo> userInfo = responseSearchFriendMessage.getSearchFriendResult().getUserInfo();
                    if (userInfo != null && userInfo.size() > 0) {
                        this.a.a.k(null);
                        SearchFriendResult.UserInfo userInfo2 = userInfo.get(0);
                        if (userInfo2 == null) {
                            SearchFriendActivity searchFriendActivity = this.a;
                            searchFriendActivity.showToast(searchFriendActivity.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1f));
                            return;
                        }
                        this.a.sendMessage(new CustomMessage(2001265, userInfo2));
                        return;
                    }
                    SearchFriendActivity searchFriendActivity2 = this.a;
                    searchFriendActivity2.showToast(searchFriendActivity2.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1f));
                } else if (StringUtils.isNull(httpResponsedMessage.getErrorString())) {
                    SearchFriendActivity searchFriendActivity3 = this.a;
                    searchFriendActivity3.showToast(searchFriendActivity3.getPageContext().getString(R.string.obfuscated_res_0x7f0f0e1f));
                } else {
                    this.a.showToast(httpResponsedMessage.getErrorString());
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchFriendActivity a;

        public d(SearchFriendActivity searchFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.a.g();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ SearchFriendActivity a;

        public e(SearchFriendActivity searchFriendActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {searchFriendActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = searchFriendActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    public SearchFriendActivity() {
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
        this.e = new a(this);
        this.f = new b(this, 2001265);
        this.g = new c(this, CmdConfigHttp.SEARCH_FRIEND_CMD);
    }

    public final void v1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            MessageManager messageManager = MessageManager.getInstance();
            TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SEARCH_FRIEND_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SEARCH_FRIEND);
            tbHttpMessageTask.setResponsedClass(ResponseSearchFriendMessage.class);
            messageManager.registerTask(tbHttpMessageTask);
            registerListener(this.g);
        }
    }

    @Override // com.baidu.tbadk.core.view.UserIconBox.c
    public ng<TbImageView> I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return UserIconBox.c(getPageContext().getPageActivity(), 8);
        }
        return (ng) invokeV.objValue;
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onDestroy();
            this.a.h();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.b.onChangeSkinType(getPageContext(), i);
            this.a.f(i);
            getLayoutMode().k(this.d);
            getLayoutMode().k(this.c);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0052);
            this.c = findViewById(R.id.obfuscated_res_0x7f09190b);
            d dVar = new d(this);
            this.c.setOnClickListener(dVar);
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f09190a);
            this.b = navigationBar;
            navigationBar.setTitleText(R.string.find_new_friend);
            this.b.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new e(this));
            this.d = findViewById(R.id.obfuscated_res_0x7f09190d);
            this.a = new p86(getPageContext(), this.d);
            this.d.setOnClickListener(dVar);
            this.a.l(this.e);
            TiebaStatic.log("add_new");
            registerListener(this.f);
            v1();
        }
    }
}
