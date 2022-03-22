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
import c.a.d.f.p.n;
import c.a.o0.r.t.a;
import c.a.p0.a1.d;
import c.a.p0.a1.o;
import c.a.p0.a1.u;
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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class UserCollectManageActivity extends BaseActivity<UserCollectManageActivity> implements u.l, d.e, d.InterfaceC0912d, o.c {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String KEY_SELECT_ALBUM_LIST = "selected_album_list";
    public transient /* synthetic */ FieldHolder $fh;
    public View coverView;
    public boolean isManageState;
    public c.a.p0.a1.d mAdapter;
    public RelativeLayout mControllerView;
    public TextView mDelete;
    public c.a.o0.r.t.a mDeleteDialog;
    public DialogInterface.OnCancelListener mDialogCancelListener;
    public GridView mGridView;
    public c.a.o0.r.l0.a mLoadingDialog;
    public TextView mManage;
    public TextView mMoveFirst;
    public NavigationBar mNavigationBar;
    public View.OnClickListener mOnClickListener;
    public PermissionJudgePolicy mPermissionJudgement;
    public TextView mSaveLocal;
    public o mUpLoadController;
    public int skinType;
    public View verticalLine;

    /* loaded from: classes5.dex */
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
                List<CollectEmotionData> n = c.a.p0.a1.g.k().n(TbadkCoreApplication.getCurrentAccount());
                if (n == null || n.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : n) {
                    if (!c.a.o0.b0.d.f9862d.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + c.a.o0.b0.d.b() + "/" + collectEmotionData.pid + "_s.jpg";
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
                this.a.mAdapter.i(list);
                this.a.mAdapter.notifyDataSetChanged();
            }
        }
    }

    /* loaded from: classes5.dex */
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

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                this.a.finish();
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
                if (c.a.p0.r2.d.m().n()) {
                    n.M(view.getContext(), R.string.obfuscated_res_0x7f0f05c8);
                    return;
                }
                UserCollectManageActivity userCollectManageActivity = this.a;
                userCollectManageActivity.isManageState = !userCollectManageActivity.isManageState;
                if (this.a.isManageState) {
                    SkinManager.setNavbarTitleColor(this.a.mManage, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    this.a.mManage.setText(R.string.obfuscated_res_0x7f0f04e0);
                    this.a.mControllerView.setVisibility(0);
                    this.a.coverView.setVisibility(0);
                } else {
                    SkinManager.setViewTextColor(this.a.mManage, R.color.CAM_X0105, 1);
                    this.a.mManage.setText(R.string.obfuscated_res_0x7f0f03e9);
                    this.a.mControllerView.setVisibility(8);
                    this.a.mDelete.setText(R.string.obfuscated_res_0x7f0f048e);
                }
                this.a.mAdapter.j(this.a.isManageState);
            }
        }
    }

    /* loaded from: classes5.dex */
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
        public void onClick(View view) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view) == null) && this.a.isManageState) {
                ArrayList arrayList = new ArrayList(this.a.mAdapter.g());
                if (arrayList.size() == 0) {
                    return;
                }
                if (view == this.a.mDelete) {
                    this.a.showDialog();
                    return;
                }
                if (view != this.a.mMoveFirst) {
                    if (view == this.a.mSaveLocal) {
                        Activity pageActivity = this.a.getPageContext().getPageActivity();
                        if (this.a.mPermissionJudgement == null) {
                            this.a.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        this.a.mPermissionJudgement.clearRequestPermissionList();
                        this.a.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (this.a.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            return;
                        }
                        u.s().v(arrayList, this.a);
                    }
                } else {
                    u.s().t(arrayList, true, this.a);
                }
                this.a.mAdapter.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class f implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) {
                u.s().l(new ArrayList(this.a.mAdapter.g()), true, this.a);
                aVar.dismiss();
                this.a.mAdapter.e();
                this.a.mDelete.setText(R.string.obfuscated_res_0x7f0f048e);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class g implements a.e {
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

        @Override // c.a.o0.r.t.a.e
        public void onClick(c.a.o0.r.t.a aVar) {
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mOnClickListener = new e(this);
    }

    private void initData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65549, this) == null) {
            new a(this).execute(new Void[0]);
            this.mDialogCancelListener = new b(this);
        }
    }

    private void initUI() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65550, this) == null) {
            NavigationBar navigationBar = (NavigationBar) findViewById(R.id.obfuscated_res_0x7f0923cf);
            this.mNavigationBar = navigationBar;
            navigationBar.setCenterTextTitle(getString(R.string.obfuscated_res_0x7f0f03ea));
            this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c(this));
            if (this.mNavigationBar.getBackImageView() != null) {
                SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.mNavigationBar.getBackImageView(), R.drawable.obfuscated_res_0x7f0809b1, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
            }
            TextView addTextButton = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.obfuscated_res_0x7f0f03e9), new d(this));
            this.mManage = addTextButton;
            SkinManager.setViewTextColor(addTextButton, (int) R.color.CAM_X0105);
            this.mGridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090677);
            this.mControllerView = (RelativeLayout) findViewById(R.id.obfuscated_res_0x7f0906f0);
            TextView textView = (TextView) findViewById(R.id.obfuscated_res_0x7f091452);
            this.mMoveFirst = textView;
            textView.setOnClickListener(this.mOnClickListener);
            TextView textView2 = (TextView) findViewById(R.id.obfuscated_res_0x7f091bf0);
            this.mSaveLocal = textView2;
            textView2.setOnClickListener(this.mOnClickListener);
            View findViewById = findViewById(R.id.obfuscated_res_0x7f0922f3);
            this.verticalLine = findViewById;
            SkinManager.setBackgroundColor(findViewById, R.color.CAM_X0204);
            TextView textView3 = (TextView) findViewById(R.id.obfuscated_res_0x7f09076f);
            this.mDelete = textView3;
            textView3.setOnClickListener(this.mOnClickListener);
            this.coverView = findViewById(R.id.obfuscated_res_0x7f090705);
            this.mGridView = (GridView) findViewById(R.id.obfuscated_res_0x7f090677);
            c.a.p0.a1.d dVar = new c.a.p0.a1.d(this);
            this.mAdapter = dVar;
            dVar.h(this);
            this.mAdapter.notifyDataSetChanged();
            this.mGridView.setAdapter((ListAdapter) this.mAdapter);
            this.mLoadingDialog = new c.a.o0.r.l0.a(getPageContext());
            TiebaStatic.log("c12225");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65551, this) == null) {
            if (this.mDeleteDialog == null) {
                c.a.o0.r.t.a aVar = new c.a.o0.r.t.a(getPageContext().getPageActivity());
                this.mDeleteDialog = aVar;
                aVar.setMessageId(R.string.obfuscated_res_0x7f0f03e7);
                this.mDeleteDialog.setPositiveButton(R.string.obfuscated_res_0x7f0f04d6, new f(this));
                this.mDeleteDialog.setNegativeButton(R.string.obfuscated_res_0x7f0f04d1, new g(this));
                this.mDeleteDialog.setCancelable(true);
                this.mDeleteDialog.create(getPageContext());
            }
            this.mDeleteDialog.show();
        }
    }

    private void startUpload2Cdn(ArrayList<ImageFileInfo> arrayList) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65552, this, arrayList) == null) || ListUtils.isEmpty(arrayList)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12491").param("obj_param1", arrayList.size()));
        showLoadingDialog(getPageContext().getString(R.string.obfuscated_res_0x7f0f10e8), this.mDialogCancelListener);
        this.mUpLoadController.a(arrayList, this);
    }

    @Override // c.a.p0.a1.o.c
    public void cdnFail() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            closeLoadingDialog();
        }
    }

    @Override // c.a.p0.a1.o.c
    public void cdnSuccess(List<String> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, list) == null) {
            if (!ListUtils.isEmpty(list)) {
                u.s().j(list, this);
            } else {
                closeLoadingDialog();
            }
        }
    }

    @Override // c.a.p0.a1.d.InterfaceC0912d
    public void clickAdd() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            sendMessage(new CustomMessage(2002001, new UserAlbumActivityConfig(getPageContext().getPageActivity(), 25030)));
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void closeLoadingDialog() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.mLoadingDialog.h(false);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, android.app.Activity
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 == -1 && i == 25030 && intent.getSerializableExtra(KEY_SELECT_ALBUM_LIST) != null) {
                ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra(KEY_SELECT_ALBUM_LIST);
                if (ListUtils.isEmpty(arrayList)) {
                    return;
                }
                startUpload2Cdn(arrayList);
            }
        }
    }

    @Override // c.a.p0.a1.d.e
    public void onChange(List<CollectEmotionData> list) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, list) == null) || list == null) {
            return;
        }
        if (list.size() == 0) {
            this.coverView.setVisibility(0);
            this.mDelete.setText(R.string.obfuscated_res_0x7f0f048e);
            return;
        }
        this.coverView.setVisibility(8);
        this.mDelete.setText(String.format(getResources().getString(R.string.obfuscated_res_0x7f0f03e8), Integer.valueOf(list.size())));
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            this.skinType = i;
            super.onChangeSkinType(i);
            getLayoutMode().k(i == 1);
            this.mAdapter.k(i);
            this.mNavigationBar.onChangeSkinType(getPageContext(), i);
            SkinManager.setBackgroundColor(this.mControllerView, R.color.CAM_X0201, i);
            SkinManager.setBackgroundColor(this.mGridView, R.color.CAM_X0201, i);
            if (i != 1 && i != 4) {
                SkinManager.setBackgroundColor(this.coverView, R.color.white_alpha70, i);
            } else {
                SkinManager.setBackgroundColor(this.coverView, R.color.common_color_10311, i);
            }
            SkinManager.setBackgroundColor(this.verticalLine, R.color.CAM_X0204, i);
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bundle) == null) {
            super.onCreate(bundle);
            setContentView(R.layout.obfuscated_res_0x7f0d01ee);
            this.mUpLoadController = new o();
            initUI();
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity, com.baidu.adp.base.BdBaseActivity, android.app.Activity
    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.onDestroy();
            this.mAdapter.h(null);
        }
    }

    @Override // c.a.p0.a1.u.l
    public void onResult(int i, int i2, int i3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIII(1048585, this, i, i2, i3) == null) {
            if (i == 1) {
                n.N(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.obfuscated_res_0x7f0f0cda));
            } else if (i == 2) {
                n.N(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.obfuscated_res_0x7f0f0cda));
            } else if (i == 3) {
                String format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f105e), Integer.valueOf(i2));
                if (i3 != 0) {
                    format = String.format(getResources().getString(R.string.obfuscated_res_0x7f0f105f), Integer.valueOf(i2), Integer.valueOf(i3));
                }
                n.N(TbadkCoreApplication.getInst().getContext(), format);
            } else if (i == 4) {
                closeLoadingDialog();
                if (i2 > 0) {
                    n.N(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.obfuscated_res_0x7f0f05d9));
                } else {
                    n.N(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.obfuscated_res_0x7f0f05d8));
                }
            }
            initData();
        }
    }

    @Override // com.baidu.tbadk.BaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048586, this, str, onCancelListener) == null) {
            this.mLoadingDialog.e(null);
            this.mLoadingDialog.j(getPageContext().getString(R.string.obfuscated_res_0x7f0f03ed));
            this.mLoadingDialog.h(true);
        }
    }
}
