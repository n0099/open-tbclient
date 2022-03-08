package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import c.a.d.c.g.c;
import c.a.d.f.m.b;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.atomData.GroupInfoActivityConfig;
import com.baidu.tbadk.core.data.BaseGroupData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.im.message.ResponseSearchGroupMessage;
import com.baidu.tieba.im.model.SearchGroupModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public c.a.r0.s1.r.a addGroupView;
    public c searchGroupCallback;
    public SearchGroupModel searchGroupModel;

    /* loaded from: classes5.dex */
    public class a extends c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddGroupActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddGroupActivity addGroupActivity, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addGroupActivity, Integer.valueOf(i2)};
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
            this.a = addGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.addGroupView.l(false);
                if (socketResponsedMessage == null || socketResponsedMessage.getCmd() != 103007) {
                    this.a.groupNotSearched();
                } else if (!(socketResponsedMessage instanceof ResponseSearchGroupMessage)) {
                    this.a.groupNotSearched();
                } else {
                    ResponseSearchGroupMessage responseSearchGroupMessage = (ResponseSearchGroupMessage) socketResponsedMessage;
                    if (responseSearchGroupMessage.getError() != 0) {
                        this.a.showError(responseSearchGroupMessage.getErrorString(), responseSearchGroupMessage.getError());
                        return;
                    }
                    List<BaseGroupData> searchResult = responseSearchGroupMessage.getSearchResult();
                    if (searchResult == null || searchResult.size() <= 0) {
                        this.a.groupNotSearched();
                    } else {
                        this.a.groupSearched(searchResult.get(0));
                    }
                }
            }
        }
    }

    public AddGroupActivity() {
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
        this.addGroupView = null;
        this.searchGroupModel = null;
        this.searchGroupCallback = new a(this, 103007);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void groupNotSearched() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65541, this) == null) {
            showToast(R.string.add_group_toast_noresult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void groupSearched(BaseGroupData baseGroupData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65542, this, baseGroupData) == null) || baseGroupData == null) {
            return;
        }
        sendMessage(new CustomMessage(2008011, new GroupInfoActivityConfig(getPageContext().getContext(), baseGroupData.getGroupId(), 0)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showError(String str, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, this, str, i2) == null) {
            if (i2 < 0) {
                showToast(R.string.neterror);
            } else if (!TextUtils.isEmpty(str)) {
                showToast(str);
            } else {
                showToast(getResources().getString(R.string.neterror));
            }
        }
    }

    public void doSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                try {
                    this.addGroupView.l(true);
                    this.searchGroupModel.sendMessage(b.g(str, 0L));
                    return;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    this.addGroupView.l(false);
                    showToast(R.string.groupid_error);
                    return;
                }
            }
            showToast(R.string.please_input_groupid);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            super.onChangeSkinType(i2);
            this.addGroupView.f(i2);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view) == null) {
            super.onClick(view);
            if (view == this.addGroupView.h()) {
                finish();
            } else if (view == this.addGroupView.j()) {
                TiebaStatic.log("add_group_searchbtn_click");
                if (view.getTag() instanceof String) {
                    doSearch((String) view.getTag());
                }
            } else if (view == this.addGroupView.i()) {
                this.addGroupView.g();
            } else if (view == this.addGroupView.k()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902030, new IntentConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.addGroupView = new c.a.r0.s1.r.a(this);
            this.searchGroupModel = new SearchGroupModel(this);
            registerListener(this.searchGroupCallback);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            releaseResouce();
            super.onDestroy();
            SearchGroupModel searchGroupModel = this.searchGroupModel;
            if (searchGroupModel != null) {
                searchGroupModel.cancelLoadData();
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i2, keyEvent)) == null) {
            if (i2 == 4 && keyEvent.getRepeatCount() == 0) {
                finish();
            }
            return super.onKeyDown(i2, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
