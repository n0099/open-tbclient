package com.baidu.tieba.im.searchGroup;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
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
import com.repackage.k77;
import com.repackage.kg;
import com.repackage.ya;
import java.util.List;
/* loaded from: classes3.dex */
public class AddGroupActivity extends BaseActivity<AddGroupActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public k77 addGroupView;
    public ya searchGroupCallback;
    public SearchGroupModel searchGroupModel;

    /* loaded from: classes3.dex */
    public class a extends ya {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ AddGroupActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(AddGroupActivity addGroupActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {addGroupActivity, Integer.valueOf(i)};
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
            this.a = addGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) {
                this.a.addGroupView.q(false);
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
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
            showToast(R.string.obfuscated_res_0x7f0f00ca);
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
    public void showError(String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(65543, this, str, i) == null) {
            if (i < 0) {
                showToast(R.string.obfuscated_res_0x7f0f0c2d);
            } else if (!TextUtils.isEmpty(str)) {
                showToast(str);
            } else {
                showToast(getResources().getString(R.string.obfuscated_res_0x7f0f0c2d));
            }
        }
    }

    public void doSearch(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            if (!TextUtils.isEmpty(str) && TextUtils.isDigitsOnly(str)) {
                try {
                    this.addGroupView.q(true);
                    this.searchGroupModel.sendMessage(kg.g(str, 0L));
                    return;
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    this.addGroupView.q(false);
                    showToast(R.string.obfuscated_res_0x7f0f07ee);
                    return;
                }
            }
            showToast(R.string.obfuscated_res_0x7f0f0e76);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            super.onChangeSkinType(i);
            this.addGroupView.i(i);
        }
    }

    @Override // com.baidu.adp.base.BdBaseActivity, android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, view2) == null) {
            super.onClick(view2);
            if (view2 == this.addGroupView.k()) {
                finish();
            } else if (view2 == this.addGroupView.m()) {
                TiebaStatic.log("add_group_searchbtn_click");
                if (view2.getTag() instanceof String) {
                    doSearch((String) view2.getTag());
                }
            } else if (view2 == this.addGroupView.l()) {
                this.addGroupView.j();
            } else if (view2 == this.addGroupView.n()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2902030, new IntentConfig(getPageContext().getPageActivity())));
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, bundle) == null) {
            super.onCreate(bundle);
            this.addGroupView = new k77(this);
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
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048581, this, i, keyEvent)) == null) {
            if (i == 4 && keyEvent.getRepeatCount() == 0) {
                finish();
            }
            return super.onKeyDown(i, keyEvent);
        }
        return invokeIL.booleanValue;
    }
}
