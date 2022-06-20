package com.baidu.tieba.im.mygroup;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.SocketResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateGroupStepActivityConfig;
import com.baidu.tbadk.core.atomData.GroupChatActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.ShareFromGameCenterMsgData;
import com.baidu.tbadk.mainTab.FragmentTabIndicator;
import com.baidu.tbadk.message.http.JsonHttpResponsedMessage;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tbadk.util.BdListViewHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.im.data.GroupInfoData;
import com.baidu.tieba.im.data.GroupPermData;
import com.baidu.tieba.im.message.ResponseUserPermissionMessage;
import com.baidu.tieba.im.util.MessageUtils;
import com.baidu.tieba.im.widget.Game2GroupShareDialogView;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.a67;
import com.repackage.b35;
import com.repackage.bb;
import com.repackage.ng;
import com.repackage.ni;
import com.repackage.nq4;
import com.repackage.oi;
import com.repackage.pi;
import com.repackage.qm4;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes3.dex */
public class PersonGroupActivity extends BaseFragmentActivity implements ViewPager.OnPageChangeListener {
    public static /* synthetic */ Interceptable $ic;
    public static final int[] s;
    public static final int[] t;
    public static final int[] u;
    public static final int[] v;
    public transient /* synthetic */ FieldHolder $fh;
    public int a;
    public int[] b;
    public int c;
    public String d;
    public String e;
    public int f;
    public boolean g;
    public NavigationBar h;
    public View i;
    public ImageView j;
    public LinearLayout k;
    public ImageView l;
    public int m;
    public int n;
    public FragmentTabHost o;
    public PersonGroupAdapter p;
    public PersonGroupModel q;
    public List<GroupInfoData> r;

    /* loaded from: classes3.dex */
    public class a implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ long a;
        public final /* synthetic */ ShareFromGameCenterMsgData b;
        public final /* synthetic */ Game2GroupShareDialogView c;
        public final /* synthetic */ PersonGroupActivity d;

        public a(PersonGroupActivity personGroupActivity, long j, ShareFromGameCenterMsgData shareFromGameCenterMsgData, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Long.valueOf(j), shareFromGameCenterMsgData, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = personGroupActivity;
            this.a = j;
            this.b = shareFromGameCenterMsgData;
            this.c = game2GroupShareDialogView;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                long t = a67.o().t(String.valueOf(this.a), 1);
                MessageUtils.createGroupChatMessage(t, 9, this.b.toChatMessageContent(), this.a);
                MessageUtils.createGroupChatMessage(t + 1, 1, this.c.getLeaveMsg(), this.a);
                nq4Var.dismiss();
                this.d.setResult(-1);
                if (!ni.z()) {
                    PersonGroupActivity personGroupActivity = this.d;
                    personGroupActivity.showToast(personGroupActivity.getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0c70));
                }
                this.d.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements nq4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Game2GroupShareDialogView a;
        public final /* synthetic */ PersonGroupActivity b;

        public b(PersonGroupActivity personGroupActivity, Game2GroupShareDialogView game2GroupShareDialogView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, game2GroupShareDialogView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = personGroupActivity;
            this.a = game2GroupShareDialogView;
        }

        @Override // com.repackage.nq4.e
        public void onClick(nq4 nq4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nq4Var) == null) {
                nq4Var.dismiss();
                ((InputMethodManager) this.b.getSystemService("input_method")).hideSoftInputFromWindow(this.a.getWindowToken(), 2);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends HttpMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGroupActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(PersonGroupActivity personGroupActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Integer.valueOf(i)};
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
            this.a = personGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, httpResponsedMessage) == null) {
                if (httpResponsedMessage.isSuccess()) {
                    if (httpResponsedMessage.getError() == 0) {
                        qm4.c(3, PersonGroupActivity.v[this.a.c]);
                        SkinManager.setNavbarIconSrc(this.a.j, PersonGroupActivity.t[this.a.c], PersonGroupActivity.s[this.a.c]);
                        PersonGroupActivity personGroupActivity = this.a;
                        personGroupActivity.showToastWithIcon(personGroupActivity.getPageContext().getContext().getString(PersonGroupActivity.u[this.a.c]), R.drawable.obfuscated_res_0x7f080a7c);
                        this.a.j.setContentDescription(this.a.getPageContext().getString(PersonGroupActivity.u[qm4.a(3) % 3]));
                        return;
                    }
                    this.a.showToast(StringUtils.isNull(httpResponsedMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37) : httpResponsedMessage.getErrorString());
                    return;
                }
                PersonGroupActivity personGroupActivity2 = this.a;
                personGroupActivity2.showToast(personGroupActivity2.getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0c37));
            }
        }
    }

    /* loaded from: classes3.dex */
    public class d extends bb {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGroupActivity a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(PersonGroupActivity personGroupActivity, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity, Integer.valueOf(i)};
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
            this.a = personGroupActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(SocketResponsedMessage socketResponsedMessage) {
            ResponseUserPermissionMessage responseUserPermissionMessage;
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, socketResponsedMessage) == null) && socketResponsedMessage != null && socketResponsedMessage.getCmd() == 103008 && (socketResponsedMessage instanceof ResponseUserPermissionMessage)) {
                try {
                    responseUserPermissionMessage = (ResponseUserPermissionMessage) socketResponsedMessage;
                } catch (Exception unused) {
                } catch (Throwable th) {
                    this.a.hideProgressBar();
                    throw th;
                }
                if (responseUserPermissionMessage.getError() > 0) {
                    this.a.showToast(StringUtils.isNull(responseUserPermissionMessage.getErrorString()) ? this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0c37) : responseUserPermissionMessage.getErrorString());
                    this.a.hideProgressBar();
                    return;
                }
                GroupPermData groupPermData = responseUserPermissionMessage.getGroupPermData();
                if (groupPermData != null) {
                    if (groupPermData.isCreatePersonal()) {
                        this.a.sendMessage(new CustomMessage(2002001, new CreateGroupStepActivityConfig(this.a.getPageContext().getContext(), 2, 0, 1012, groupPermData.getCanCreateNormalNum(), groupPermData.getCanCreateOfficialNum(), groupPermData.getCanCreatePersonalNum())));
                    } else if (!TextUtils.isEmpty(groupPermData.getCreatePersonalTip())) {
                        this.a.showToast(groupPermData.getCreatePersonalTip());
                    }
                }
                this.a.hideProgressBar();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGroupActivity a;

        public e(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class f implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGroupActivity a;

        public f(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.L0();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class g implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PersonGroupActivity a;

        public g(PersonGroupActivity personGroupActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {personGroupActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = personGroupActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.c = qm4.a(3) % 3;
                HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.SET_PRIVATE_CMD);
                httpMessage.addParam("opt", "group");
                httpMessage.addParam("val", String.valueOf(this.a.c + 1));
                this.a.sendMessage(httpMessage);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1079891931, "Lcom/baidu/tieba/im/mygroup/PersonGroupActivity;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1079891931, "Lcom/baidu/tieba/im/mygroup/PersonGroupActivity;");
                return;
            }
        }
        s = new int[]{R.drawable.icon_pop_key_all_bg, R.drawable.icon_pop_key_f_bg, R.drawable.icon_pop_key_d_bg};
        t = new int[]{R.drawable.obfuscated_res_0x7f0808bd, R.drawable.obfuscated_res_0x7f0808c1, R.drawable.obfuscated_res_0x7f0808bf};
        u = new int[]{R.string.obfuscated_res_0x7f0f08e2, R.string.obfuscated_res_0x7f0f08e3, R.string.obfuscated_res_0x7f0f08e4};
        v = new int[]{1, 2, 3};
    }

    public PersonGroupActivity() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.a = -1;
        this.c = 0;
        this.g = false;
        this.i = null;
        this.q = null;
    }

    public int B0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.a == 0 ? 0 : 1 : invokeV.intValue;
    }

    public boolean C0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.g : invokeV.booleanValue;
    }

    public PersonGroupModel D0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.q : (PersonGroupModel) invokeV.objValue;
    }

    public String E0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public final void F0(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, bundle) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0917b1);
            this.h = navigationBar;
            navigationBar.setCenterTextTitle(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0e3a), this.e));
            this.h.showBottomLine();
            View view2 = (View) this.h.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON).getParent();
            this.i = view2;
            view2.setOnClickListener(new e(this));
            if (this.n == 1) {
                this.h.setCenterTextTitle(getResources().getString(R.string.obfuscated_res_0x7f0f07f2));
                LinearLayout linearLayout = (LinearLayout) this.h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08ab, (View.OnClickListener) null);
                this.k = linearLayout;
                this.l = (ImageView) linearLayout.findViewById(R.id.obfuscated_res_0x7f090c99);
                if (TbadkCoreApplication.getInst().getIntentClass(CreateGroupStepActivityConfig.class) == null) {
                    this.k.setVisibility(4);
                } else {
                    this.k.setVisibility(0);
                }
                this.k.setOnClickListener(new f(this));
            } else if (this.g && this.m != 23003) {
                ImageView imageView = (ImageView) this.h.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.obfuscated_res_0x7f0d08ae, (View.OnClickListener) null);
                this.j = imageView;
                SkinManager.setNavbarIconSrc(imageView, t[qm4.a(3) - 1], s[qm4.a(3) - 1]);
                this.c = qm4.a(3) % 3;
                this.j.setContentDescription(getPageContext().getString(u[this.c]));
                this.j.setOnClickListener(new g(this));
            }
            this.b = new int[]{0, 1};
            this.p = new PersonGroupAdapter(this, this.g);
            FragmentTabHost fragmentTabHost = (FragmentTabHost) findViewById(R.id.obfuscated_res_0x7f0917b2);
            this.o = fragmentTabHost;
            fragmentTabHost.setup(getSupportFragmentManager());
            this.o.setTabWidgetViewHeight(pi.f(getApplicationContext(), R.dimen.obfuscated_res_0x7f070275));
            this.o.setTabWidgetBackgroundColor(getResources().getColor(R.color.common_color_10002));
            this.o.setOnPageChangeListener(this);
            this.o.u();
            if (this.o.getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ((ViewGroup.MarginLayoutParams) this.o.getLayoutParams()).topMargin = BdListViewHelper.a(BdListViewHelper.HeadType.DEFAULT);
            }
            initTabSpec();
            if (this.g) {
                this.o.getTabWrapper().setVisibility(8);
            }
            this.o.setCurrentTab(this.a);
        }
    }

    public boolean G0(long j) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048581, this, j)) == null) {
            List<GroupInfoData> list = this.r;
            if (list == null || list.size() <= 0) {
                return false;
            }
            Iterator<GroupInfoData> it = this.r.iterator();
            while (it.hasNext()) {
                if (j == it.next().getGroupId()) {
                    return true;
                }
            }
            return false;
        }
        return invokeJ.booleanValue;
    }

    public boolean K0(GroupInfoData groupInfoData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, groupInfoData)) == null) {
            if (groupInfoData == null || this.m != 23003) {
                return false;
            }
            if (2 == this.n) {
                O0(b35.d().e(), groupInfoData.getGroupId(), groupInfoData.getName());
                return true;
            }
            Intent intent = new Intent();
            intent.putExtra("group_id", groupInfoData.getGroupId());
            intent.putExtra("group_name", groupInfoData.getName());
            intent.putExtra(GroupChatActivityConfig.GROUP_AUTHOR_ID, groupInfoData.getAuthorId());
            setResult(-1, intent);
            finish();
            return true;
        }
        return invokeL.booleanValue;
    }

    public final void L0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            showProgressBar();
            this.q.A(0L);
        }
    }

    public void M0(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, list) == null) {
            this.r = list;
        }
    }

    public void N0(List<GroupInfoData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, list) == null) {
        }
    }

    public final void O0(ShareFromGameCenterMsgData shareFromGameCenterMsgData, long j, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{shareFromGameCenterMsgData, Long.valueOf(j), str}) == null) {
            nq4 nq4Var = new nq4(getPageContext().getPageActivity());
            nq4Var.setContentViewSize(1);
            Game2GroupShareDialogView game2GroupShareDialogView = new Game2GroupShareDialogView(getPageContext().getContext());
            game2GroupShareDialogView.setData(shareFromGameCenterMsgData);
            nq4Var.setContentView(game2GroupShareDialogView);
            nq4Var.setPositiveButton(R.string.obfuscated_res_0x7f0f1145, new a(this, j, shareFromGameCenterMsgData, game2GroupShareDialogView));
            nq4Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0366, new b(this, game2GroupShareDialogView));
            nq4Var.create(getPageContext()).show();
        }
    }

    public void P0(int i, int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeII(1048587, this, i, i2) == null) || this.g || this.p == null) {
            return;
        }
        FragmentTabIndicator fragmentTabIndicator = (FragmentTabIndicator) this.o.j(0).b;
        if (i <= 0) {
            fragmentTabIndicator.setText(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0e3e));
        } else {
            fragmentTabIndicator.setText(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0e3f), Integer.valueOf(i)));
        }
        FragmentTabIndicator fragmentTabIndicator2 = (FragmentTabIndicator) this.o.j(1).b;
        if (i2 <= 0) {
            fragmentTabIndicator2.setText(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0409));
        } else {
            fragmentTabIndicator2.setText(String.format(getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0e3b), Integer.valueOf(i2)));
        }
    }

    public final void initTabSpec() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || this.p == null) {
            return;
        }
        char c2 = this.g ? (char) 1 : (char) 2;
        Fragment item = this.p.getItem(0);
        int b2 = this.p.b(0);
        if (item != null) {
            z0(item, b2, getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0e3e));
        }
        if (c2 == 2) {
            Fragment item2 = this.p.getItem(1);
            int b3 = this.p.b(1);
            if (item2 != null) {
                z0(item2, b3, getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0409));
            }
        }
        this.o.m();
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.h.onChangeSkinType(getPageContext(), i);
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.l, R.drawable.obfuscated_res_0x7f0809cd, R.color.CAM_X0105, null);
            this.o.s(i);
            SkinManager.setBackgroundResource(this.o, R.color.common_color_10173);
            if (this.p != null) {
                int i2 = this.g ? 1 : 2;
                for (int i3 = 0; i3 < i2; i3++) {
                    Fragment item = this.p.getItem(i3);
                    if (item != null && (item instanceof BaseFragment)) {
                        ((BaseFragment) item).changeSkinType(i);
                    }
                }
            }
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d0048);
            if (bundle != null) {
                this.d = bundle.getString("key_uid");
                this.f = bundle.getInt("key_sex", 0);
                this.a = bundle.getInt("key_current_tab", 0);
                this.m = bundle.getInt("tb_request_code", 0);
                this.n = bundle.getInt("key_from_where", 0);
            } else if (getIntent() != null) {
                this.d = getIntent().getStringExtra("key_uid");
                this.f = getIntent().getIntExtra("key_sex", 0);
                this.a = getIntent().getIntExtra("key_current_tab", 0);
                this.m = getIntent().getIntExtra("tb_request_code", 0);
                this.n = getIntent().getIntExtra("key_from_where", 0);
            } else {
                finish();
            }
            String str = this.d;
            if (str == null) {
                str = TbadkCoreApplication.getCurrentAccount();
            }
            this.d = str;
            if (TextUtils.equals(str, TbadkCoreApplication.getCurrentAccount())) {
                this.e = getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0aab);
                this.g = true;
            } else {
                this.g = false;
                int i = this.f;
                if (i == 1) {
                    this.e = getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f0824);
                } else if (i != 2) {
                    this.e = getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f135e);
                } else {
                    this.e = getPageContext().getContext().getString(R.string.obfuscated_res_0x7f0f1190);
                }
            }
            if (this.q == null) {
                if (!this.g) {
                    this.q = new PersonGroupModel(this, ng.g(this.d, 0L));
                } else {
                    this.q = new PersonGroupModel(this);
                }
            }
            if (oi.isEmpty(this.d)) {
                finish();
            } else {
                F0(bundle);
            }
            if (this.n != 1) {
                TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.SET_PRIVATE_CMD, TbConfig.SERVER_ADDRESS + TbConfig.SET_PRIVATE);
                tbHttpMessageTask.setIsNeedLogin(true);
                tbHttpMessageTask.setResponsedClass(JsonHttpResponsedMessage.class);
                MessageManager.getInstance().registerTask(tbHttpMessageTask);
                registerListener(new c(this, CmdConfigHttp.SET_PRIVATE_CMD));
                return;
            }
            registerListener(103008, new d(this, 0));
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048592, this, new Object[]{Integer.valueOf(i), Float.valueOf(f2), Integer.valueOf(i2)}) == null) {
        }
    }

    @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048593, this, i) == null) || i < 0 || i >= 2 || i == this.a) {
            return;
        }
        this.a = i;
        if (this.g || this.b[i] != 1) {
            return;
        }
        TiebaStatic.eventStat(getPageContext().getContext(), "common_group", "click", 1, new Object[0]);
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, com.baidu.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            super.onResume();
            onChangeSkinType(TbadkApplication.getInst().getSkinType());
            if (this.q == null) {
                this.q = new PersonGroupModel(this);
            }
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, bundle) == null) {
            bundle.putInt("CurrTabIndex", this.a);
            super.onSaveInstanceState(bundle);
        }
    }

    @Override // com.baidu.tbadk.core.BaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onStart() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048596, this) == null) {
            super.onStart();
        }
    }

    public final void z0(Fragment fragment, int i, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048597, this, fragment, i, str) == null) || fragment == null) {
            return;
        }
        FragmentTabHost.b bVar = new FragmentTabHost.b();
        FragmentTabIndicator fragmentTabIndicator = new FragmentTabIndicator(getPageContext().getContext());
        bVar.c = fragment;
        bVar.a = i;
        fragmentTabIndicator.setText(str);
        fragmentTabIndicator.h = R.color.s_actionbar_text_color;
        fragmentTabIndicator.setTextSize(0, getResources().getDimension(R.dimen.obfuscated_res_0x7f0702b7));
        bVar.b = fragmentTabIndicator;
        this.o.c(bVar);
    }
}
