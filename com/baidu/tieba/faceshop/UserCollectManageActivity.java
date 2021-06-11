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
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
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
import com.kwad.sdk.core.imageloader.utils.StorageUtils;
import d.a.c.e.p.l;
import d.a.m0.r.s.a;
import d.a.n0.m0.d;
import d.a.n0.m0.o;
import d.a.n0.m0.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserCollectManageActivity extends ProxyAdkBaseActivity<UserCollectManageActivity> implements u.l, d.e, d.InterfaceC1488d, o.c {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f14807e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f14808f;

    /* renamed from: g  reason: collision with root package name */
    public GridView f14809g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.n0.m0.d f14810h;

    /* renamed from: i  reason: collision with root package name */
    public RelativeLayout f14811i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public boolean o;
    public d.a.m0.r.s.a p;
    public o q;
    public d.a.m0.r.f0.a r;
    public DialogInterface.OnCancelListener s;
    public PermissionJudgePolicy t;
    public View.OnClickListener u = new e();

    /* loaded from: classes4.dex */
    public class a extends BdAsyncTask<Void, Void, List<CollectEmotionData>> {
        public a() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public List<CollectEmotionData> doInBackground(Void... voidArr) {
            List<CollectEmotionData> n = d.a.n0.m0.g.k().n(TbadkCoreApplication.getCurrentAccount());
            if (n == null || n.size() < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (CollectEmotionData collectEmotionData : n) {
                if (!d.a.m0.a0.d.f52490d.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                    String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.a.m0.a0.d.b() + "/" + collectEmotionData.pid + "_s.jpg";
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(List<CollectEmotionData> list) {
            UserCollectManageActivity.this.f14810h.i(list);
            UserCollectManageActivity.this.f14810h.notifyDataSetChanged();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements DialogInterface.OnCancelListener {
        public b() {
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            UserCollectManageActivity.this.destroyWaitingDialog();
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            UserCollectManageActivity.this.finish();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (d.a.n0.z1.d.m().n()) {
                l.L(view.getContext(), R.string.face_collect_is_syncing);
                return;
            }
            UserCollectManageActivity userCollectManageActivity = UserCollectManageActivity.this;
            userCollectManageActivity.o = !userCollectManageActivity.o;
            if (UserCollectManageActivity.this.o) {
                SkinManager.setNavbarTitleColor(UserCollectManageActivity.this.f14808f, R.color.CAM_X0302, R.color.s_navbar_title_color);
                UserCollectManageActivity.this.f14808f.setText(R.string.done);
                UserCollectManageActivity.this.f14811i.setVisibility(0);
                UserCollectManageActivity.this.m.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(UserCollectManageActivity.this.f14808f, R.color.CAM_X0105, 1);
                UserCollectManageActivity.this.f14808f.setText(R.string.collect_manage);
                UserCollectManageActivity.this.f14811i.setVisibility(8);
                UserCollectManageActivity.this.l.setText(R.string.delete);
            }
            UserCollectManageActivity.this.f14810h.j(UserCollectManageActivity.this.o);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserCollectManageActivity.this.o) {
                ArrayList arrayList = new ArrayList(UserCollectManageActivity.this.f14810h.g());
                if (arrayList.size() == 0) {
                    return;
                }
                if (view == UserCollectManageActivity.this.l) {
                    UserCollectManageActivity.this.t();
                    return;
                }
                if (view != UserCollectManageActivity.this.j) {
                    if (view == UserCollectManageActivity.this.k) {
                        Activity pageActivity = UserCollectManageActivity.this.getPageContext().getPageActivity();
                        if (UserCollectManageActivity.this.t == null) {
                            UserCollectManageActivity.this.t = new PermissionJudgePolicy();
                        }
                        UserCollectManageActivity.this.t.clearRequestPermissionList();
                        UserCollectManageActivity.this.t.appendRequestPermission(pageActivity, StorageUtils.EXTERNAL_STORAGE_PERMISSION);
                        if (UserCollectManageActivity.this.t.startRequestPermission(pageActivity)) {
                            return;
                        }
                        u.s().v(arrayList, UserCollectManageActivity.this);
                    }
                } else {
                    u.s().t(arrayList, true, UserCollectManageActivity.this);
                }
                UserCollectManageActivity.this.f14810h.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            u.s().l(new ArrayList(UserCollectManageActivity.this.f14810h.g()), true, UserCollectManageActivity.this);
            aVar.dismiss();
            UserCollectManageActivity.this.f14810h.e();
            UserCollectManageActivity.this.l.setText(R.string.delete);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    @Override // d.a.n0.m0.d.e
    public void b(List<CollectEmotionData> list) {
        if (list == null) {
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

    @Override // d.a.n0.m0.o.c
    public void c(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            u.s().j(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.r.h(false);
    }

    @Override // d.a.n0.m0.o.c
    public void d() {
        closeLoadingDialog();
    }

    @Override // d.a.n0.m0.d.InterfaceC1488d
    public void e() {
        sendMessage(new CustomMessage(2002001, new UserAlbumActivityConfig(getPageContext().getPageActivity(), 25030)));
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
            ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            u(arrayList);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i2) {
        super.onChangeSkinType(i2);
        getLayoutMode().k(i2 == 1);
        this.f14810h.k(i2);
        this.f14807e.onChangeSkinType(getPageContext(), i2);
        SkinManager.setBackgroundColor(this.f14811i, R.color.CAM_X0201, i2);
        SkinManager.setBackgroundColor(this.f14809g, R.color.CAM_X0201, i2);
        if (i2 != 1 && i2 != 4) {
            SkinManager.setBackgroundColor(this.m, R.color.white_alpha70, i2);
        } else {
            SkinManager.setBackgroundColor(this.m, R.color.common_color_10311, i2);
        }
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204, i2);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_manage_activity);
        this.q = new o();
        s();
        r();
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.f14810h.h(null);
    }

    @Override // d.a.n0.m0.u.l
    public void onResult(int i2, int i3, int i4) {
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

    public final void r() {
        new a().execute(new Void[0]);
        this.s = new b();
    }

    public final void s() {
        NavigationBar navigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.f14807e = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.collect_manage_title));
        this.f14807e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        if (this.f14807e.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f14807e.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TextView addTextButton = this.f14807e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new d());
        this.f14808f = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0105);
        this.f14809g = (GridView) findViewById(R.id.collect_image_gridview);
        this.f14811i = (RelativeLayout) findViewById(R.id.controller_layout);
        TextView textView = (TextView) findViewById(R.id.move_to_first);
        this.j = textView;
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
        this.f14809g = (GridView) findViewById(R.id.collect_image_gridview);
        d.a.n0.m0.d dVar = new d.a.n0.m0.d(this);
        this.f14810h = dVar;
        dVar.h(this);
        this.f14810h.notifyDataSetChanged();
        this.f14809g.setAdapter((ListAdapter) this.f14810h);
        this.r = new d.a.m0.r.f0.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.r.e(null);
        this.r.j(getPageContext().getString(R.string.collect_uploading));
        this.r.h(true);
    }

    public final void t() {
        if (this.p == null) {
            d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(getPageContext().getPageActivity());
            this.p = aVar;
            aVar.setMessageId(R.string.collect_delete_confirm_tip);
            this.p.setPositiveButton(R.string.dialog_ok, new f());
            this.p.setNegativeButton(R.string.dialog_cancel, new g());
            this.p.setCancelable(true);
            this.p.create(getPageContext());
        }
        this.p.show();
    }

    public final void u(ArrayList<ImageFileInfo> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12491").param("obj_param1", arrayList.size()));
        showLoadingDialog(getPageContext().getString(R.string.sending), this.s);
        this.q.a(arrayList, this);
    }
}
