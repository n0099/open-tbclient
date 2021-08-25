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
import c.a.e.e.p.l;
import c.a.p0.s.s.a;
import c.a.q0.q0.d;
import c.a.q0.q0.n;
import c.a.q0.q0.t;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.ProxyAdkBaseActivity;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes7.dex */
public class UserCollectManageActivity extends ProxyAdkBaseActivity<UserCollectManageActivity> implements t.l, d.e, d.InterfaceC1098d, n.c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f50383e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f50384f;

    /* renamed from: g  reason: collision with root package name */
    public GridView f50385g;

    /* renamed from: h  reason: collision with root package name */
    public c.a.q0.q0.d f50386h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f50387i;

    /* renamed from: j  reason: collision with root package name */
    public TextView f50388j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public boolean o;
    public c.a.p0.s.s.a p;
    public n q;
    public c.a.p0.s.f0.a r;
    public DialogInterface.OnCancelListener s;
    public PermissionJudgePolicy t;
    public View.OnClickListener u;

    /* loaded from: classes7.dex */
    public class a extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50389a;

        public a(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50389a = userCollectManageActivity;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, voidArr)) == null) {
                List<CollectEmotionData> n = c.a.q0.q0.g.k().n(TbadkCoreApplication.getCurrentAccount());
                if (n == null || n.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : n) {
                    if (!c.a.p0.b0.d.f12807d.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + c.a.p0.b0.d.b() + "/" + collectEmotionData.pid + "_s.jpg";
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
                this.f50389a.f50386h.i(list);
                this.f50389a.f50386h.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnCancelListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50390e;

        public b(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50390e = userCollectManageActivity;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, dialogInterface) == null) {
                this.f50390e.destroyWaitingDialog();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50391e;

        public c(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50391e = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.f50391e.finish();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50392e;

        public d(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50392e = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.q0.d2.d.m().n()) {
                    l.L(view.getContext(), R.string.face_collect_is_syncing);
                    return;
                }
                UserCollectManageActivity userCollectManageActivity = this.f50392e;
                userCollectManageActivity.o = !userCollectManageActivity.o;
                if (this.f50392e.o) {
                    SkinManager.setNavbarTitleColor(this.f50392e.f50384f, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    this.f50392e.f50384f.setText(R.string.done);
                    this.f50392e.f50387i.setVisibility(0);
                    this.f50392e.m.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(this.f50392e.f50384f, R.color.CAM_X0105, 1);
                    this.f50392e.f50384f.setText(R.string.collect_manage);
                    this.f50392e.f50387i.setVisibility(8);
                    this.f50392e.l.setText(R.string.delete);
                }
                this.f50392e.f50386h.j(this.f50392e.o);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class e implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50393e;

        public e(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50393e = userCollectManageActivity;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.f50393e.o) {
                ArrayList arrayList = new ArrayList(this.f50393e.f50386h.g());
                if (arrayList.size() == 0) {
                    return;
                }
                if (view == this.f50393e.l) {
                    this.f50393e.t();
                    return;
                }
                if (view != this.f50393e.f50388j) {
                    if (view == this.f50393e.k) {
                        Activity pageActivity = this.f50393e.getPageContext().getPageActivity();
                        if (this.f50393e.t == null) {
                            this.f50393e.t = new PermissionJudgePolicy();
                        }
                        this.f50393e.t.clearRequestPermissionList();
                        this.f50393e.t.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.f50393e.t.startRequestPermission(pageActivity)) {
                            return;
                        }
                        t.s().v(arrayList, this.f50393e);
                    }
                } else {
                    t.s().t(arrayList, true, this.f50393e);
                }
                this.f50393e.f50386h.e();
            }
        }
    }

    /* loaded from: classes7.dex */
    public class f implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50394e;

        public f(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50394e = userCollectManageActivity;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                t.s().l(new ArrayList(this.f50394e.f50386h.g()), true, this.f50394e);
                aVar.dismiss();
                this.f50394e.f50386h.e();
                this.f50394e.l.setText(R.string.delete);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class g implements a.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UserCollectManageActivity f50395e;

        public g(UserCollectManageActivity userCollectManageActivity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {userCollectManageActivity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50395e = userCollectManageActivity;
        }

        @Override // c.a.p0.s.s.a.e
        public void onClick(c.a.p0.s.s.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                aVar.dismiss();
            }
        }
    }

    public UserCollectManageActivity() {
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
        this.u = new e(this);
    }

    @Override // c.a.q0.q0.d.e
    public void b(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, list) == null) || list == null) {
            return;
        }
        if (list.size() == 0) {
            this.m.setVisibility(0);
            this.l.setText(R.string.delete);
            return;
        }
        this.m.setVisibility(8);
        this.l.setText(String.format(getResources().getString(R.string.collect_delete_tip), Integer.valueOf(list.size())));
    }

    @Override // c.a.q0.q0.n.c
    public void c(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                t.s().j(list, this);
            } else {
                closeLoadingDialog();
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.r.h(false);
        }
    }

    @Override // c.a.q0.q0.n.c
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            closeLoadingDialog();
        }
    }

    @Override // c.a.q0.q0.d.InterfaceC1098d
    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            sendMessage(new CustomMessage(2002001, new UserAlbumActivityConfig(getPageContext().getPageActivity(), 25030)));
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i2, i3, intent) == null) {
            super.onActivityResult(i2, i3, intent);
            if (i3 == -1 && i2 == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
                ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                u(arrayList);
            }
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i2) == null) {
            super.onChangeSkinType(i2);
            getLayoutMode().k(i2 == 1);
            this.f50386h.k(i2);
            this.f50383e.onChangeSkinType(getPageContext(), i2);
            SkinManager.setBackgroundColor(this.f50387i, R.color.CAM_X0201, i2);
            SkinManager.setBackgroundColor(this.f50385g, R.color.CAM_X0201, i2);
            if (i2 != 1 && i2 != 4) {
                SkinManager.setBackgroundColor(this.m, R.color.white_alpha70, i2);
            } else {
                SkinManager.setBackgroundColor(this.m, R.color.common_color_10311, i2);
            }
            SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204, i2);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.collect_manage_activity);
            this.q = new n();
            s();
            r();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.f50386h.h(null);
        }
    }

    @Override // c.a.q0.q0.t.l
    public void onResult(int i2, int i3, int i4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i2, i3, i4) == null) {
            if (i2 == 1) {
                l.M(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
            } else if (i2 == 2) {
                l.M(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
            } else if (i2 == 3) {
                String format = String.format(getResources().getString(R.string.save_collect_success), Integer.valueOf(i3));
                if (i4 != 0) {
                    format = String.format(getResources().getString(R.string.save_collect_success_and_fail), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                l.M(TbadkCoreApplication.getInst().getContext(), format);
            } else if (i2 == 4) {
                closeLoadingDialog();
                if (i3 > 0) {
                    l.M(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_success));
                } else {
                    l.M(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_failed));
                }
            }
            r();
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            new a(this).execute(new Void[0]);
            this.s = new b(this);
        }
    }

    public final void s() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
            this.f50383e = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.collect_manage_title));
            this.f50383e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.f50383e.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f50383e.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.f50383e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new d(this));
            this.f50384f = addTextButton;
            SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0105);
            this.f50385g = (GridView) findViewById(R.id.collect_image_gridview);
            this.f50387i = (RelativeLayout) findViewById(R.id.controller_layout);
            TextView textView = (TextView) findViewById(R.id.move_to_first);
            this.f50388j = textView;
            textView.setOnClickListener(this.u);
            TextView textView2 = (TextView) findViewById(R.id.save_to_local);
            this.k = textView2;
            textView2.setOnClickListener(this.u);
            View findViewById = findViewById(R.id.vertical_div_line);
            this.n = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            TextView textView3 = (TextView) findViewById(R.id.delete_collect_image);
            this.l = textView3;
            textView3.setOnClickListener(this.u);
            this.m = findViewById(R.id.cover);
            this.f50385g = (GridView) findViewById(R.id.collect_image_gridview);
            c.a.q0.q0.d dVar = new c.a.q0.q0.d(this);
            this.f50386h = dVar;
            dVar.h(this);
            this.f50386h.notifyDataSetChanged();
            this.f50385g.setAdapter((ListAdapter) this.f50386h);
            this.r = new c.a.p0.s.f0.a(getPageContext());
            TiebaStatic.log("c12225");
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048588, this, str, onCancelListener) == null) {
            this.r.e(null);
            this.r.j(getPageContext().getString(R.string.collect_uploading));
            this.r.h(true);
        }
    }

    public final void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            if (this.p == null) {
                c.a.p0.s.s.a aVar = new c.a.p0.s.s.a(getPageContext().getPageActivity());
                this.p = aVar;
                aVar.setMessageId(R.string.collect_delete_confirm_tip);
                this.p.setPositiveButton(R.string.dialog_ok, new f(this));
                this.p.setNegativeButton(R.string.dialog_cancel, new g(this));
                this.p.setCancelable(true);
                this.p.create(getPageContext());
            }
            this.p.show();
        }
    }

    public final void u(ArrayList<ImageFileInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12491").param("obj_param1", arrayList.size()));
        showLoadingDialog(getPageContext().getString(R.string.sending), this.s);
        this.q.a(arrayList, this);
    }
}
