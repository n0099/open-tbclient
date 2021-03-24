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
import d.b.b.e.p.l;
import d.b.h0.r.s.a;
import d.b.i0.l0.d;
import d.b.i0.l0.o;
import d.b.i0.l0.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class UserCollectManageActivity extends ProxyAdkBaseActivity<UserCollectManageActivity> implements u.l, d.e, d.InterfaceC1326d, o.c {

    /* renamed from: e  reason: collision with root package name */
    public NavigationBar f15710e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15711f;

    /* renamed from: g  reason: collision with root package name */
    public GridView f15712g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.i0.l0.d f15713h;
    public RelativeLayout i;
    public TextView j;
    public TextView k;
    public TextView l;
    public View m;
    public View n;
    public boolean o;
    public d.b.h0.r.s.a p;
    public o q;
    public d.b.h0.r.f0.a r;
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
            List<CollectEmotionData> n = d.b.i0.l0.g.k().n(TbadkCoreApplication.getCurrentAccount());
            if (n == null || n.size() < 1) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (CollectEmotionData collectEmotionData : n) {
                if (!d.b.h0.a0.d.f49682d.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                    String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + d.b.h0.a0.d.b() + "/" + collectEmotionData.pid + "_s.jpg";
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
            UserCollectManageActivity.this.f15713h.i(list);
            UserCollectManageActivity.this.f15713h.notifyDataSetChanged();
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
            if (d.b.i0.x1.d.m().n()) {
                l.K(view.getContext(), R.string.face_collect_is_syncing);
                return;
            }
            UserCollectManageActivity userCollectManageActivity = UserCollectManageActivity.this;
            userCollectManageActivity.o = !userCollectManageActivity.o;
            if (UserCollectManageActivity.this.o) {
                SkinManager.setNavbarTitleColor(UserCollectManageActivity.this.f15711f, R.color.CAM_X0302, R.color.s_navbar_title_color);
                UserCollectManageActivity.this.f15711f.setText(R.string.done);
                UserCollectManageActivity.this.i.setVisibility(0);
                UserCollectManageActivity.this.m.setVisibility(0);
            } else {
                SkinManager.setViewTextColor(UserCollectManageActivity.this.f15711f, R.color.CAM_X0105, 1);
                UserCollectManageActivity.this.f15711f.setText(R.string.collect_manage);
                UserCollectManageActivity.this.i.setVisibility(8);
                UserCollectManageActivity.this.l.setText(R.string.delete);
            }
            UserCollectManageActivity.this.f15713h.j(UserCollectManageActivity.this.o);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (UserCollectManageActivity.this.o) {
                ArrayList arrayList = new ArrayList(UserCollectManageActivity.this.f15713h.g());
                if (arrayList.size() == 0) {
                    return;
                }
                if (view == UserCollectManageActivity.this.l) {
                    UserCollectManageActivity.this.u();
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
                UserCollectManageActivity.this.f15713h.e();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f implements a.e {
        public f() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            u.s().l(new ArrayList(UserCollectManageActivity.this.f15713h.g()), true, UserCollectManageActivity.this);
            aVar.dismiss();
            UserCollectManageActivity.this.f15713h.e();
            UserCollectManageActivity.this.l.setText(R.string.delete);
        }
    }

    /* loaded from: classes4.dex */
    public class g implements a.e {
        public g() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    @Override // d.b.i0.l0.o.c
    public void b() {
        closeLoadingDialog();
    }

    @Override // d.b.i0.l0.d.e
    public void c(List<CollectEmotionData> list) {
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

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.r.h(false);
    }

    @Override // d.b.i0.l0.d.InterfaceC1326d
    public void d() {
        sendMessage(new CustomMessage(2002001, new UserAlbumActivityConfig(getPageContext().getPageActivity(), 25030)));
    }

    @Override // d.b.i0.l0.o.c
    public void e(List<String> list) {
        if (!ListUtils.isEmpty(list)) {
            u.s().j(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
            ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
            if (ListUtils.isEmpty(arrayList)) {
                return;
            }
            v(arrayList);
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        super.onChangeSkinType(i);
        getLayoutMode().k(i == 1);
        this.f15713h.k(i);
        this.f15710e.onChangeSkinType(getPageContext(), i);
        SkinManager.setBackgroundColor(this.i, R.color.CAM_X0201, i);
        SkinManager.setBackgroundColor(this.f15712g, R.color.CAM_X0201, i);
        if (i != 1 && i != 4) {
            SkinManager.setBackgroundColor(this.m, R.color.white_alpha70, i);
        } else {
            SkinManager.setBackgroundColor(this.m, R.color.common_color_10311, i);
        }
        SkinManager.setBackgroundColor(this.n, R.color.CAM_X0204, i);
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
        this.f15713h.h(null);
    }

    @Override // d.b.i0.l0.u.l
    public void onResult(int i, int i2, int i3) {
        if (i == 1) {
            l.L(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
        } else if (i == 2) {
            l.L(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
        } else if (i == 3) {
            String format = String.format(getResources().getString(R.string.save_collect_success), Integer.valueOf(i2));
            if (i3 != 0) {
                format = String.format(getResources().getString(R.string.save_collect_success_and_fail), Integer.valueOf(i2), Integer.valueOf(i3));
            }
            l.L(TbadkCoreApplication.getInst().getContext(), format);
        } else if (i == 4) {
            closeLoadingDialog();
            if (i2 > 0) {
                l.L(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_success));
            } else {
                l.L(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_failed));
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
        this.f15710e = navigationBar;
        navigationBar.setCenterTextTitle(getString(R.string.collect_manage_title));
        this.f15710e.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new c());
        if (this.f15710e.getBackImageView() != null) {
            SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f15710e.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        TextView addTextButton = this.f15710e.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new d());
        this.f15711f = addTextButton;
        SkinManager.setViewTextColor(addTextButton, R.color.CAM_X0105);
        this.f15712g = (GridView) findViewById(R.id.collect_image_gridview);
        this.i = (RelativeLayout) findViewById(R.id.controller_layout);
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
        this.f15712g = (GridView) findViewById(R.id.collect_image_gridview);
        d.b.i0.l0.d dVar = new d.b.i0.l0.d(this);
        this.f15713h = dVar;
        dVar.h(this);
        this.f15713h.notifyDataSetChanged();
        this.f15712g.setAdapter((ListAdapter) this.f15713h);
        this.r = new d.b.h0.r.f0.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.r.e(null);
        this.r.j(getPageContext().getString(R.string.collect_uploading));
        this.r.h(true);
    }

    public final void u() {
        if (this.p == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(getPageContext().getPageActivity());
            this.p = aVar;
            aVar.setMessageId(R.string.collect_delete_confirm_tip);
            this.p.setPositiveButton(R.string.dialog_ok, new f());
            this.p.setNegativeButton(R.string.dialog_cancel, new g());
            this.p.setCancelable(true);
            this.p.create(getPageContext());
        }
        this.p.show();
    }

    public final void v(ArrayList<ImageFileInfo> arrayList) {
        if (ListUtils.isEmpty(arrayList)) {
            return;
        }
        TiebaStatic.log(new StatisticItem("c12491").param("obj_param1", arrayList.size()));
        showLoadingDialog(getPageContext().getString(R.string.sending), this.s);
        this.q.a(arrayList, this);
    }
}
