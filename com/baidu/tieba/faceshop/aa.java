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
/* loaded from: classes9.dex */
public class aa extends ProxyAdkBaseActivity<aa> implements ab.c, d.a, d.b, u.a {
    private int akW;
    private GridView dlY;
    private com.baidu.tbadk.core.view.a fOA;
    private TextView giF;
    private boolean iRV;
    private com.baidu.tbadk.core.dialog.a iTa;
    private TextView iVR;
    private d iVS;
    private RelativeLayout iVT;
    private TextView iVU;
    private TextView iVV;
    private View iVW;
    private View iVX;
    private u iVY;
    private DialogInterface.OnCancelListener iVZ;
    private NavigationBar mNavigationBar;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.5
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            ArrayList arrayList;
            if (aa.this.iRV && (arrayList = new ArrayList(aa.this.iVS.cAW())) != null && arrayList.size() != 0) {
                if (view == aa.this.giF) {
                    aa.this.SY();
                    return;
                }
                if (view != aa.this.iVU) {
                    if (view == aa.this.iVV) {
                        Activity pageActivity = aa.this.getPageContext().getPageActivity();
                        if (aa.this.mPermissionJudgement == null) {
                            aa.this.mPermissionJudgement = new PermissionJudgePolicy();
                        }
                        aa.this.mPermissionJudgement.clearRequestPermissionList();
                        aa.this.mPermissionJudgement.appendRequestPermission(pageActivity, "android.permission.WRITE_EXTERNAL_STORAGE");
                        if (!aa.this.mPermissionJudgement.startRequestPermission(pageActivity)) {
                            ab.cCn().b(arrayList, aa.this);
                        } else {
                            return;
                        }
                    }
                } else {
                    ab.cCn().c(arrayList, true, aa.this);
                }
                aa.this.iVS.clearSelect();
            }
        }
    };
    private PermissionJudgePolicy mPermissionJudgement;

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.collect_manage_activity);
        this.iVY = new u();
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
                List<CollectEmotionData> Kf = i.cBl().Kf(TbadkCoreApplication.getCurrentAccount());
                if (Kf == null || Kf.size() < 1) {
                    return null;
                }
                ArrayList arrayList = new ArrayList();
                for (CollectEmotionData collectEmotionData : Kf) {
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
                aa.this.iVS.db(list);
                aa.this.iVS.notifyDataSetChanged();
            }
        }.execute(new Void[0]);
        this.iVZ = new DialogInterface.OnCancelListener() { // from class: com.baidu.tieba.faceshop.aa.2
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
            SvgManager.bwr().a(this.mNavigationBar.getBackImageView(), R.drawable.icon_pure_topbar_close44_svg, R.color.CAM_X0106, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        }
        this.iVR = this.mNavigationBar.addTextButton(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, getPageContext().getString(R.string.collect_manage), new View.OnClickListener() { // from class: com.baidu.tieba.faceshop.aa.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (com.baidu.tieba.newfaceshop.d.dkg().dkk()) {
                    com.baidu.adp.lib.util.l.showToast(view.getContext(), R.string.face_collect_is_syncing);
                    return;
                }
                aa.this.iRV = !aa.this.iRV;
                if (aa.this.iRV) {
                    ao.setNavbarTitleColor(aa.this.iVR, R.color.CAM_X0302, R.color.s_navbar_title_color);
                    aa.this.iVR.setText(R.string.done);
                    aa.this.iVT.setVisibility(0);
                    aa.this.iVW.setVisibility(0);
                } else {
                    ao.setViewTextColor(aa.this.iVR, R.color.CAM_X0105, 1);
                    aa.this.iVR.setText(R.string.collect_manage);
                    aa.this.iVT.setVisibility(8);
                    aa.this.giF.setText(R.string.delete);
                }
                aa.this.iVS.pZ(aa.this.iRV);
            }
        });
        ao.setViewTextColor(this.iVR, R.color.CAM_X0105);
        this.dlY = (GridView) findViewById(R.id.collect_image_gridview);
        this.iVT = (RelativeLayout) findViewById(R.id.controller_layout);
        this.iVU = (TextView) findViewById(R.id.move_to_first);
        this.iVU.setOnClickListener(this.mOnClickListener);
        this.iVV = (TextView) findViewById(R.id.save_to_local);
        this.iVV.setOnClickListener(this.mOnClickListener);
        this.iVX = findViewById(R.id.vertical_div_line);
        ao.setBackgroundColor(this.iVX, R.color.CAM_X0204);
        this.giF = (TextView) findViewById(R.id.delete_collect_image);
        this.giF.setOnClickListener(this.mOnClickListener);
        this.iVW = findViewById(R.id.cover);
        this.dlY = (GridView) findViewById(R.id.collect_image_gridview);
        this.iVS = new d(this);
        this.iVS.a(this);
        this.iVS.notifyDataSetChanged();
        this.dlY.setAdapter((ListAdapter) this.iVS);
        this.fOA = new com.baidu.tbadk.core.view.a(getPageContext());
        TiebaStatic.log("c12225");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity, com.baidu.adp.plugin.pluginBase.PluginAdpBaseActivity, com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onDestroy() {
        super.onDestroy();
        this.iVS.a((d.b) null);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void onChangeSkinType(int i) {
        this.akW = i;
        super.onChangeSkinType(i);
        getLayoutMode().setNightMode(i == 1);
        this.iVS.setSkinType(i);
        this.mNavigationBar.onChangeSkinType(getPageContext(), i);
        ao.setBackgroundColor(this.iVT, R.color.CAM_X0201, i);
        ao.setBackgroundColor(this.dlY, R.color.CAM_X0201, i);
        if (i == 1 || i == 4) {
            ao.setBackgroundColor(this.iVW, R.color.common_color_10311, i);
        } else {
            ao.setBackgroundColor(this.iVW, R.color.white_alpha70, i);
        }
        ao.setBackgroundColor(this.iVX, R.color.CAM_X0204, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SY() {
        if (this.iTa == null) {
            this.iTa = new com.baidu.tbadk.core.dialog.a(getPageContext().getPageActivity());
            this.iTa.pa(R.string.collect_delete_confirm_tip);
            this.iTa.a(R.string.dialog_ok, new a.b() { // from class: com.baidu.tieba.faceshop.aa.6
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    ab.cCn().d(new ArrayList(aa.this.iVS.cAW()), true, aa.this);
                    aVar.dismiss();
                    aa.this.iVS.clearSelect();
                    aa.this.giF.setText(R.string.delete);
                }
            });
            this.iTa.b(R.string.dialog_cancel, new a.b() { // from class: com.baidu.tieba.faceshop.aa.7
                @Override // com.baidu.tbadk.core.dialog.a.b
                public void onClick(com.baidu.tbadk.core.dialog.a aVar) {
                    aVar.dismiss();
                }
            });
            this.iTa.jH(true);
            this.iTa.b(getPageContext());
        }
        this.iTa.btY();
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
                this.iVW.setVisibility(0);
                this.giF.setText(R.string.delete);
                return;
            }
            this.iVW.setVisibility(8);
            this.giF.setText(String.format(getResources().getString(R.string.collect_delete_tip), Integer.valueOf(list.size())));
        }
    }

    @Override // com.baidu.tieba.faceshop.d.a
    public void cAX() {
        sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new UserAlbumActivityConfig(getPageContext().getPageActivity(), RequestResponseCode.COLLECT_SELECT_ALBUM)));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.plugin.pluginBase.PluginBaseActivity
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i2 == -1 && i == 25030 && intent.getSerializableExtra("selected_album_list") != null) {
            ArrayList<ImageFileInfo> arrayList = (ArrayList) intent.getSerializableExtra("selected_album_list");
            if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
                au(arrayList);
            }
        }
    }

    private void au(ArrayList<ImageFileInfo> arrayList) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(arrayList)) {
            TiebaStatic.log(new aq("c12491").an("obj_param1", arrayList.size()));
            showLoadingDialog(getPageContext().getString(R.string.sending), this.iVZ);
            this.iVY.a(arrayList, this);
        }
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void df(List<String> list) {
        if (!com.baidu.tbadk.core.util.x.isEmpty(list)) {
            ab.cCn().a(list, this);
        } else {
            closeLoadingDialog();
        }
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void showLoadingDialog(String str, DialogInterface.OnCancelListener onCancelListener) {
        this.fOA.setCancelListener(null);
        this.fOA.setTipString(getPageContext().getString(R.string.collect_uploading));
        this.fOA.setDialogVisiable(true);
    }

    @Override // com.baidu.tbadk.ProxyAdkBaseActivity
    public void closeLoadingDialog() {
        this.fOA.setDialogVisiable(false);
    }

    @Override // com.baidu.tieba.faceshop.u.a
    public void cCe() {
        closeLoadingDialog();
    }
}
