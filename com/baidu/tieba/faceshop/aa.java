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
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.ProxyAdkBaseActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UserAlbumActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.permission.PermissionJudgePolicy;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tieba.R;
import com.baidu.tieba.faceshop.ab;
import com.baidu.tieba.faceshop.d;
import com.baidu.tieba.faceshop.u;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes8.dex */
public class aa extends ProxyAdkBaseActivity<aa> implements ab.c, d.a, d.b, u.a {
    private int akf;
    private GridView dhj;
    private com.baidu.tbadk.core.view.a fJT;
    private TextView gdW;
    private boolean iNo;
    private com.baidu.tbadk.core.dialog.a iOt;
    private TextView iRk;
    private d iRl;
    private RelativeLayout iRm;
    private TextView iRn;
    private TextView iRo;
    private View iRp;
    private View iRq;
    private u iRr;
    private DialogInterface.OnCancelListener iRs;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList;
            if (aa.this.iNo && (arrayList = new ArrayList(aa.this.iRl.cxe())) != null && arrayList.size() != 0) {
                if (view == aa.this.gdW) {
                    aa.this.Pd();
                    return;
                }
                if (view != aa.this.iRn) {
                    if (view == aa.this.iRo) {
                        Activity pageActivity = aa.this.getPageContext().getPageActivity();
                        if (aa.this.mPermissionJudgement == null) {
                            aa.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        aa.this.mPermissionJudgement.clearRequestPermissionList();
                        aa.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aa.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            ab.cyv().b(arrayList, aa.this);
                        } else {
                            return;
                        }
                    }
                } else {
                    ab.cyv().c(arrayList, true, aa.this);
                }
                aa.this.iRl.clearSelect();
            }
        }
    };
    private PermissionJudgePolicy mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_manage_activity);
        this.iRr = new u();
        initUI();
        initData();
    }

    private void initData() {
        new BdAsyncTask<Void, Void, List<CollectEmotionData>>() { // from class: com.baidu.tieba.faceshop.aa.1
            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: c */
            public List<CollectEmotionData> doInBackground(Void... voidArr) {
                List<CollectEmotionData> IU = i.cxt().IU(TbadkCoreApplication.getCurrentAccount());
                if (IU == null || IU.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : IU) {
                    if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + collectEmotionData.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0) {
                            imageFileInfo.setModifyTime(at.getChineseFormatTimeString(file.lastModified()));
                            collectEmotionData.imageFileInfo = imageFileInfo;
                            arrayList.add(collectEmotionData);
                        }
                    }
                }
                return arrayList;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
            /* renamed from: B */
            public void onPostExecute(List<CollectEmotionData> list) {
                aa.this.iRl.db(list);
                aa.this.iRl.notifyDataSetChanged();
            }
        }.execute(new Void[0]);
        this.iRs = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.faceshop.aa.2
            @Override // android.content.DialogInterface.OnCancelListener
            public void onCancel(DialogInterface dialogInterface) {
                aa.this.destroyWaitingDialog();
            }
        };
    }

    private void initUI() {
        this.mNavigationBar = (NavigationBar) findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.setCenterTextTitle(getString(R.string.collect_manage_title));
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON, new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                aa.this.finish();
            }
        });
        if (this.mNavigationBar.getBackImageView() != null) {
            SvgManager.bsx().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iRk = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.newfaceshop.d.dgo().dgs()) {
                    com.baidu.adp.lib.util.l.showToast(view.getContext(), R.string.face_collect_is_syncing);
                    return;
                }
                aa.this.iNo = !aa.this.iNo;
                if (aa.this.iNo) {
                    ao.setNavbarTitleColor(aa.this.iRk, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    aa.this.iRk.setText(R.string.done);
                    aa.this.iRm.setVisibility(0);
                    aa.this.iRp.setVisibility(0);
                } else {
                    ao.setViewTextColor(aa.this.iRk, R.color.CAM_X0105, 1);
                    aa.this.iRk.setText(R.string.collect_manage);
                    aa.this.iRm.setVisibility(8);
                    aa.this.gdW.setText(R.string.delete);
                }
                aa.this.iRl.pV(aa.this.iNo);
            }
        });
        ao.setViewTextColor(this.iRk, R.color.CAM_X0105);
        this.dhj = (GridView) findViewById(R.id.collect_image_gridview);
        this.iRm = (RelativeLayout) findViewById(R.id.controller_layout);
        this.iRn = (TextView) findViewById(R.id.move_to_first);
        this.iRn.setOnClickListener(this.mOnClickListener);
        this.iRo = (TextView) findViewById(R.id.save_to_local);
        this.iRo.setOnClickListener(this.mOnClickListener);
        this.iRq = findViewById(R.id.vertical_div_line);
        ao.setBackgroundColor(this.iRq, R.color.CAM_X0204);
        this.gdW = (TextView) findViewById(R.id.delete_collect_image);
        this.gdW.setOnClickListener(this.mOnClickListener);
        this.iRp = findViewById(R.id.cover);
        this.dhj = (GridView) findViewById(R.id.collect_image_gridview);
        this.iRl = new d(this);
        this.iRl.a(this);
        this.iRl.notifyDataSetChanged();
        this.dhj.setAdapter((ListAdapter) this.iRl);
        this.fJT = new com.baidu.tbadk.core.view.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.iRl.a((d.b) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.akf = i;
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.iRl.setSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundColor(this.iRm, R.color.CAM_X0201, i);
        ao.setBackgroundColor(this.dhj, R.color.CAM_X0201, i);
        if (i == 1 || i == 4) {
            ao.setBackgroundColor(this.iRp, R.color.common_color_10311, i);
        } else {
            ao.setBackgroundColor(this.iRp, R.color.white_alpha70, i);
        }
        ao.setBackgroundColor(this.iRq, R.color.CAM_X0204, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Pd() {
        if (this.iOt == null) {
            this.iOt = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iOt.nu(R.string.collect_delete_confirm_tip);
            this.iOt.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.faceshop.aa.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ab.cyv().d(new ArrayList(aa.this.iRl.cxe()), true, aa.this);
                    aVar.dismiss();
                    aa.this.iRl.clearSelect();
                    aa.this.gdW.setText(R.string.delete);
                }
            });
            this.iOt.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.aa.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iOt.jD(true);
            this.iOt.b(getPageContext());
        }
        this.iOt.bqe();
    }

    @Override // com.baidu.tieba.faceshop.ab.c
    public void S(int i, int i2, int i3) {
        switch (i) {
            case 1:
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
                break;
            case 2:
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst().getContext(), getResources().getString(R.string.operation_success));
                break;
            case 3:
                String format = String.format(getResources().getString(R.string.save_collect_success), Integer.valueOf(i2));
                if (i3 != 0) {
                    format = String.format(getResources().getString(R.string.save_collect_success_and_fail), Integer.valueOf(i2), Integer.valueOf(i3));
                }
                com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst().getContext(), format);
                break;
            case 4:
                closeLoadingDialog();
                if (i2 > 0) {
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_success));
                    break;
                } else {
                    com.baidu.adp.lib.util.l.showToast(TbadkCoreApplication.getInst().getContext(), getPageContext().getString(R.string.face_group_upload_failed));
                    break;
                }
        }
        initData();
    }

    @Override // com.baidu.tieba.faceshop.d.b
    public void dc(List<CollectEmotionData> list) {
        if (list != null) {
            if (list.size() == 0) {
                this.iRp.setVisibility(0);
                this.gdW.setText(R.string.delete);
                return;
            }
            this.iRp.setVisibility(8);
            this.gdW.setText(String.format(getResources().getString(R.string.collect_delete_tip), Integer.valueOf(list.size())));
        }
    }

    @Override // com.baidu.tieba.faceshop.d.a
    public void cxf() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserAlbumActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.COLLECT_SELECT_ALBUM)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
            ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                ap(arrayList);
            }
        }
    }

    private void ap(ArrayList<ImageFileInfo> arrayList) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            TiebaStatic.log(new aq("c12491").an("obj_param1", arrayList.size()));
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iRs);
            this.iRr.a(arrayList, this);
        }
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void df(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ab.cyv().a(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fJT.setCancelListener(null);
        this.fJT.setTipString(getPageContext().getString(R.string.collect_uploading));
        this.fJT.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.fJT.setDialogVisiable(false);
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void cym() {
        closeLoadingDialog();
    }
}
