package com.baidu.tieba.faceshop;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserAlbumActivityConfig;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.dd6;
import com.baidu.tieba.ej;
import com.baidu.tieba.i85;
import com.baidu.tieba.jd6;
import com.baidu.tieba.lr7;
import com.baidu.tieba.nu4;
import com.baidu.tieba.sx4;
import com.baidu.tieba.uc6;
import com.baidu.tieba.zc6;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserCollectManageActivity extends BaseActivity<UserCollectManageActivity> implements jd6.l, uc6.e, uc6.d, dd6.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public NavigationBar a;
    public TextView b;
    public GridView c;
    public uc6 d;
    public RelativeLayout e;
    public TextView f;
    public TextView g;
    public TextView h;
    public View i;
    public View j;
    public boolean k;
    public nu4 l;
    public dd6 m;
    public sx4 n;
    public DialogInterface.OnCancelListener o;
    public PermissionJudgePolicy p;
    public View.OnClickListener q;

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public a(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> q = zc6.o().q(TbadkCoreApplication.getCurrentAccount());
                if (q == null || q.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : q) {
                    if (!i85.f.equals(collectEmotionData.getSharpText()) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + i85.d() + "/" + collectEmotionData.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0) {
                            imageFileInfo.setModifyTime(StringHelper.getChineseFormatTimeString(file.lastModified()));
                            collectEmotionData.imageFileInfo = imageFileInfo;
                            arrayList.add(collectEmotionData);
                        }
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
                this.a.d.i(list);
                this.a.d.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public b(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.a.destroyWaitingDialog();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public c(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public d(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (lr7.o().p()) {
                    ej.M(view2.getContext(), R.string.obfuscated_res_0x7f0f05f2);
                    return;
                }
                UserCollectManageActivity userCollectManageActivity = this.a;
                userCollectManageActivity.k = !userCollectManageActivity.k;
                if (this.a.k) {
                    SkinManager.setNavbarTitleColor(this.a.b, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    this.a.b.setText(R.string.obfuscated_res_0x7f0f0505);
                    this.a.e.setVisibility(0);
                    this.a.i.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(this.a.b, R.color.CAM_X0105, 1);
                    this.a.b.setText(R.string.obfuscated_res_0x7f0f03ff);
                    this.a.e.setVisibility(8);
                    this.a.h.setText(R.string.obfuscated_res_0x7f0f04b0);
                }
                this.a.d.j(this.a.k);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public e(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.k) {
                ArrayList arrayList = new ArrayList(this.a.d.g());
                if (arrayList.size() == 0) {
                    return;
                }
                if (view2 == this.a.h) {
                    this.a.M1();
                    return;
                }
                if (view2 != this.a.f) {
                    if (view2 == this.a.g) {
                        Activity pageActivity = this.a.getPageContext().getPageActivity();
                        if (this.a.p == null) {
                            this.a.p = new PermissionJudgePolicy();
                        }
                        this.a.p.clearRequestPermissionList();
                        this.a.p.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.p.startRequestPermission(pageActivity)) {
                            return;
                        }
                        jd6.t().w(arrayList, this.a);
                    }
                } else {
                    jd6.t().u(arrayList, true, this.a);
                }
                this.a.d.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public f(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                jd6.t().m(new ArrayList(this.a.d.g()), true, this.a);
                nu4Var.dismiss();
                this.a.d.e();
                this.a.h.setText(R.string.obfuscated_res_0x7f0f04b0);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements nu4.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ UserCollectManageActivity a;

        public g(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = userCollectManageActivity;
        }

        @Override // com.baidu.tieba.nu4.e
        public void onClick(nu4 nu4Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, nu4Var) == null) {
                nu4Var.dismiss();
            }
        }
    }

    public UserCollectManageActivity() {
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
        this.q = new e(this);
    }

    @Override // com.baidu.tieba.uc6.e
    public void A(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        if (list.size() == 0) {
            this.i.setVisibility(0);
            this.h.setText(R.string.obfuscated_res_0x7f0f04b0);
            return;
        }
        this.i.setVisibility(8);
        this.h.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f03fe), Integer.valueOf(list.size())));
    }

    @Override // com.baidu.tieba.dd6.c
    public void B0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            closeLoadingDialog();
        }
    }

    public final void L1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0925c4);
            this.a = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f0400));
            this.a.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.a.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.a.getBackImageView(), R.drawable.obfuscated_res_0x7f080a12, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.a.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f03ff), new d(this));
            this.b = addTextButton;
            SkinManager.setViewTextColor(addTextButton, (int) R.color.CAM_X0105);
            this.c = (GridView) findViewById(R.id.obfuscated_res_0x7f09066f);
            this.e = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906fd);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f09156f);
            this.f = textView;
            textView.setOnClickListener(this.q);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091db3);
            this.g = textView2;
            textView2.setOnClickListener(this.q);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0924ee);
            this.j = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f09078c);
            this.h = textView3;
            textView3.setOnClickListener(this.q);
            this.i = findViewById(R.id.obfuscated_res_0x7f090713);
            this.c = (GridView) findViewById(R.id.obfuscated_res_0x7f09066f);
            uc6 uc6Var = new uc6(this);
            this.d = uc6Var;
            uc6Var.h(this);
            this.d.notifyDataSetChanged();
            this.c.setAdapter((ListAdapter) this.d);
            this.n = new sx4(getPageContext());
            TiebaStatic.log("c12225");
        }
    }

    public final void M1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.l == null) {
                nu4 nu4Var = new nu4(getPageContext().getPageActivity());
                this.l = nu4Var;
                nu4Var.setMessageId(R.string.obfuscated_res_0x7f0f03fd);
                this.l.setPositiveButton(R.string.dialog_ok, new f(this));
                this.l.setNegativeButton(R.string.dialog_cancel, new g(this));
                this.l.setCancelable(true);
                this.l.create(getPageContext());
            }
            this.l.show();
        }
    }

    public final void N1(ArrayList<ImageFileInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12491").param("obj_param1", arrayList.size()));
        showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f1133), this.o);
        this.m.a(arrayList, this);
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.n.h(false);
        }
    }

    @Override // com.baidu.tieba.dd6.c
    public void d0(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                jd6.t().k(list, this);
            } else {
                closeLoadingDialog();
            }
        }
    }

    public final void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            new a(this).execute(new Void[0]);
            this.o = new b(this);
        }
    }

    @Override // com.baidu.tieba.uc6.d
    public void j1() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            sendMessage(new CustomMessage(2002001, new UserAlbumActivityConfig(getPageContext().getPageActivity(), 25030)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048585, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
                ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                N1(arrayList);
            }
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            super.onChangeSkinType(i);
            getLayoutMode().l(i == 1);
            this.d.k(i);
            this.a.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.e, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.c, R.color.CAM_X0201, i);
            if (i != 1 && i != 4) {
                SkinManager.setBackgroundColor(this.i, R.color.white_alpha70, i);
            } else {
                SkinManager.setBackgroundColor(this.i, R.color.common_color_10311, i);
            }
            SkinManager.setBackgroundColor(this.j, R.color.CAM_X0204, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01e3);
            this.m = new dd6();
            L1();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            super.onDestroy();
            this.d.h(null);
        }
    }

    @Override // com.baidu.tieba.jd6.l
    public void onResult(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048589, this, i, i2, i3) == null) {
            if (i == 1) {
                ej.N(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.obfuscated_res_0x7f0f0d23));
            } else if (i == 2) {
                ej.N(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.obfuscated_res_0x7f0f0d23));
            } else if (i == 3) {
                String format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f10a3), Integer.valueOf(i2));
                if (i3 != 0) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f10a4), Integer.valueOf(i2), Integer.valueOf(i3));
                }
                ej.N(TbadkCoreApplication.getInst().getContext(), format);
            } else if (i == 4) {
                closeLoadingDialog();
                if (i2 > 0) {
                    ej.N(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0603));
                } else {
                    ej.N(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.obfuscated_res_0x7f0f0602));
                }
            }
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048590, this, str, onCancelListener) == null) {
            this.n.e(null);
            this.n.j(getPageContext().getString(R.string.obfuscated_res_0x7f0f0404));
            this.n.h(true);
        }
    }
}
