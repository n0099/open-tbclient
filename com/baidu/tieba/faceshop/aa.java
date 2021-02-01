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
/* loaded from: classes9.dex */
public class aa extends ProxyAdkBaseActivity<aa> implements ab.c, d.a, d.b, u.a {
    private int ajU;
    private GridView djx;
    private com.baidu.tbadk.core.view.a fMe;
    private TextView ggl;
    private boolean iSV;
    private com.baidu.tbadk.core.dialog.a iUa;
    private TextView iWR;
    private d iWS;
    private RelativeLayout iWT;
    private TextView iWU;
    private TextView iWV;
    private View iWW;
    private View iWX;
    private u iWY;
    private DialogInterface.OnCancelListener iWZ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList;
            if (aa.this.iSV && (arrayList = new ArrayList(aa.this.iWS.cyp())) != null && arrayList.size() != 0) {
                if (view == aa.this.ggl) {
                    aa.this.QE();
                    return;
                }
                if (view != aa.this.iWU) {
                    if (view == aa.this.iWV) {
                        Activity pageActivity = aa.this.getPageContext().getPageActivity();
                        if (aa.this.mPermissionJudgement == null) {
                            aa.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        aa.this.mPermissionJudgement.clearRequestPermissionList();
                        aa.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aa.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            ab.czG().b(arrayList, aa.this);
                        } else {
                            return;
                        }
                    }
                } else {
                    ab.czG().c(arrayList, true, aa.this);
                }
                aa.this.iWS.clearSelect();
            }
        }
    };
    private PermissionJudgePolicy mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_manage_activity);
        this.iWY = new u();
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
                List<CollectEmotionData> JF = i.cyE().JF(TbadkCoreApplication.getCurrentAccount());
                if (JF == null || JF.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : JF) {
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
                aa.this.iWS.cW(list);
                aa.this.iWS.notifyDataSetChanged();
            }
        }.execute(new Void[0]);
        this.iWZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.faceshop.aa.2
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
            SvgManager.bsR().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iWR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.newfaceshop.d.dip().dit()) {
                    com.baidu.adp.lib.util.l.showToast(view.getContext(), R.string.face_collect_is_syncing);
                    return;
                }
                aa.this.iSV = !aa.this.iSV;
                if (aa.this.iSV) {
                    ap.setNavbarTitleColor(aa.this.iWR, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    aa.this.iWR.setText(R.string.done);
                    aa.this.iWT.setVisibility(0);
                    aa.this.iWW.setVisibility(0);
                } else {
                    ap.setViewTextColor(aa.this.iWR, R.color.CAM_X0105, 1);
                    aa.this.iWR.setText(R.string.collect_manage);
                    aa.this.iWT.setVisibility(8);
                    aa.this.ggl.setText(R.string.delete);
                }
                aa.this.iWS.qf(aa.this.iSV);
            }
        });
        ap.setViewTextColor(this.iWR, R.color.CAM_X0105);
        this.djx = (GridView) findViewById(R.id.collect_image_gridview);
        this.iWT = (RelativeLayout) findViewById(R.id.controller_layout);
        this.iWU = (TextView) findViewById(R.id.move_to_first);
        this.iWU.setOnClickListener(this.mOnClickListener);
        this.iWV = (TextView) findViewById(R.id.save_to_local);
        this.iWV.setOnClickListener(this.mOnClickListener);
        this.iWX = findViewById(R.id.vertical_div_line);
        ap.setBackgroundColor(this.iWX, R.color.CAM_X0204);
        this.ggl = (TextView) findViewById(R.id.delete_collect_image);
        this.ggl.setOnClickListener(this.mOnClickListener);
        this.iWW = findViewById(R.id.cover);
        this.djx = (GridView) findViewById(R.id.collect_image_gridview);
        this.iWS = new d(this);
        this.iWS.a(this);
        this.iWS.notifyDataSetChanged();
        this.djx.setAdapter((ListAdapter) this.iWS);
        this.fMe = new com.baidu.tbadk.core.view.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.iWS.a((d.b) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.ajU = i;
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.iWS.setSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ap.setBackgroundColor(this.iWT, R.color.CAM_X0201, i);
        ap.setBackgroundColor(this.djx, R.color.CAM_X0201, i);
        if (i == 1 || i == 4) {
            ap.setBackgroundColor(this.iWW, R.color.common_color_10311, i);
        } else {
            ap.setBackgroundColor(this.iWW, R.color.white_alpha70, i);
        }
        ap.setBackgroundColor(this.iWX, R.color.CAM_X0204, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QE() {
        if (this.iUa == null) {
            this.iUa = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iUa.nx(R.string.collect_delete_confirm_tip);
            this.iUa.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.faceshop.aa.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ab.czG().d(new ArrayList(aa.this.iWS.cyp()), true, aa.this);
                    aVar.dismiss();
                    aa.this.iWS.clearSelect();
                    aa.this.ggl.setText(R.string.delete);
                }
            });
            this.iUa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.aa.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iUa.jF(true);
            this.iUa.b(getPageContext());
        }
        this.iUa.bqx();
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
                this.iWW.setVisibility(0);
                this.ggl.setText(R.string.delete);
                return;
            }
            this.iWW.setVisibility(8);
            this.ggl.setText(String.format(getResources().getString(R.string.collect_delete_tip), Integer.valueOf(list.size())));
        }
    }

    @Override // com.baidu.tieba.faceshop.d.a
    public void cyq() {
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
            TiebaStatic.log(new ar("c12491").ap("obj_param1", arrayList.size()));
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iWZ);
            this.iWY.a(arrayList, this);
        }
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void da(List<String> list) {
        if (!com.baidu.tbadk.core.util.y.isEmpty(list)) {
            ab.czG().a(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fMe.setCancelListener(null);
        this.fMe.setTipString(getPageContext().getString(R.string.collect_uploading));
        this.fMe.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.fMe.setDialogVisiable(false);
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void czx() {
        closeLoadingDialog();
    }
}
