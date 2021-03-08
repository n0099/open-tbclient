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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
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
    private int aln;
    private GridView dkY;
    private com.baidu.tbadk.core.view.a fNE;
    private TextView ghT;
    private boolean iUS;
    private com.baidu.tbadk.core.dialog.a iVX;
    private TextView iYO;
    private d iYP;
    private RelativeLayout iYQ;
    private TextView iYR;
    private TextView iYS;
    private View iYT;
    private View iYU;
    private u iYV;
    private DialogInterface.OnCancelListener iYW;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList;
            if (aa.this.iUS && (arrayList = new ArrayList(aa.this.iYP.cyC())) != null && arrayList.size() != 0) {
                if (view == aa.this.ghT) {
                    aa.this.QH();
                    return;
                }
                if (view != aa.this.iYR) {
                    if (view == aa.this.iYS) {
                        Activity pageActivity = aa.this.getPageContext().getPageActivity();
                        if (aa.this.mPermissionJudgement == null) {
                            aa.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        aa.this.mPermissionJudgement.clearRequestPermissionList();
                        aa.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aa.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            ab.czT().b(arrayList, aa.this);
                        } else {
                            return;
                        }
                    }
                } else {
                    ab.czT().c(arrayList, true, aa.this);
                }
                aa.this.iYP.clearSelect();
            }
        }
    };
    private PermissionJudgePolicy mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_manage_activity);
        this.iYV = new u();
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
                List<CollectEmotionData> JP = i.cyR().JP(TbadkCoreApplication.getCurrentAccount());
                if (JP == null || JP.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : JP) {
                    if (!com.baidu.tbadk.imageManager.d.SETTING_SHARP_TEXT.equals(collectEmotionData.sharpText) && !TextUtils.isEmpty(collectEmotionData.pid)) {
                        String str = TbadkCoreApplication.getInst().getFilesDir().getAbsolutePath() + "/.collect/" + com.baidu.tbadk.imageManager.d.getSaveDir() + "/" + collectEmotionData.pid + "_s.jpg";
                        ImageFileInfo imageFileInfo = new ImageFileInfo();
                        imageFileInfo.setFilePath(str);
                        File file = new File(str);
                        if (file.exists() && file.length() > 0) {
                            imageFileInfo.setModifyTime(au.getChineseFormatTimeString(file.lastModified()));
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
                aa.this.iYP.cW(list);
                aa.this.iYP.notifyDataSetChanged();
            }
        }.execute(new Void[0]);
        this.iYW = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.faceshop.aa.2
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
            SvgManager.bsU().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iYO = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.newfaceshop.d.diF().diJ()) {
                    com.baidu.adp.lib.util.l.showToast(view.getContext(), R.string.face_collect_is_syncing);
                    return;
                }
                aa.this.iUS = !aa.this.iUS;
                if (aa.this.iUS) {
                    ap.setNavbarTitleColor(aa.this.iYO, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    aa.this.iYO.setText(R.string.done);
                    aa.this.iYQ.setVisibility(0);
                    aa.this.iYT.setVisibility(0);
                } else {
                    ap.setViewTextColor(aa.this.iYO, R.color.CAM_X0105, 1);
                    aa.this.iYO.setText(R.string.collect_manage);
                    aa.this.iYQ.setVisibility(8);
                    aa.this.ghT.setText(R.string.delete);
                }
                aa.this.iYP.qf(aa.this.iUS);
            }
        });
        ap.setViewTextColor(this.iYO, R.color.CAM_X0105);
        this.dkY = (GridView) findViewById(R.id.collect_image_gridview);
        this.iYQ = (RelativeLayout) findViewById(R.id.controller_layout);
        this.iYR = (TextView) findViewById(R.id.move_to_first);
        this.iYR.setOnClickListener(this.mOnClickListener);
        this.iYS = (TextView) findViewById(R.id.save_to_local);
        this.iYS.setOnClickListener(this.mOnClickListener);
        this.iYU = findViewById(R.id.vertical_div_line);
        ap.setBackgroundColor(this.iYU, R.color.CAM_X0204);
        this.ghT = (TextView) findViewById(R.id.delete_collect_image);
        this.ghT.setOnClickListener(this.mOnClickListener);
        this.iYT = findViewById(R.id.cover);
        this.dkY = (GridView) findViewById(R.id.collect_image_gridview);
        this.iYP = new d(this);
        this.iYP.a(this);
        this.iYP.notifyDataSetChanged();
        this.dkY.setAdapter((ListAdapter) this.iYP);
        this.fNE = new com.baidu.tbadk.core.view.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.iYP.a((d.b) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.aln = i;
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.iYP.setSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundColor(this.iYQ, R.color.CAM_X0201, i);
        ap.setBackgroundColor(this.dkY, R.color.CAM_X0201, i);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.iYT, R.color.common_color_10311, i);
        } else {
            ap.setBackgroundColor(this.iYT, R.color.white_alpha70, i);
        }
        ap.setBackgroundColor(this.iYU, R.color.CAM_X0204, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (this.iVX == null) {
            this.iVX = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iVX.ny(R.string.collect_delete_confirm_tip);
            this.iVX.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.faceshop.aa.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ab.czT().d(new ArrayList(aa.this.iYP.cyC()), true, aa.this);
                    aVar.dismiss();
                    aa.this.iYP.clearSelect();
                    aa.this.ghT.setText(R.string.delete);
                }
            });
            this.iVX.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.aa.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iVX.jF(true);
            this.iVX.b(getPageContext());
        }
        this.iVX.bqz();
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
    public void cX(List<CollectEmotionData> list) {
        if (list != null) {
            if (list.size() == 0) {
                this.iYT.setVisibility(0);
                this.ghT.setText(R.string.delete);
                return;
            }
            this.iYT.setVisibility(8);
            this.ghT.setText(String.format(getResources().getString(R.string.collect_delete_tip), Integer.valueOf(list.size())));
        }
    }

    @Override // com.baidu.tieba.faceshop.d.a
    public void cyD() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserAlbumActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.COLLECT_SELECT_ALBUM)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
            ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
            if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
                ao(arrayList);
            }
        }
    }

    private void ao(ArrayList<ImageFileInfo> arrayList) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(arrayList)) {
            TiebaStatic.log(new ar("c12491").aq("obj_param1", arrayList.size()));
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iYW);
            this.iYV.a(arrayList, this);
        }
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void da(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ab.czT().a(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fNE.setCancelListener(null);
        this.fNE.setTipString(getPageContext().getString(R.string.collect_uploading));
        this.fNE.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.fNE.setDialogVisiable(false);
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void czK() {
        closeLoadingDialog();
    }
}
