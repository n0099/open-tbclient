package com.baidu.tieba.ala.floating.permission;

import android.app.Activity;
import com.baidu.live.adp.base.IScrollableHelper;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.tieba.ala.floating.permission.FloatPermissionUtil;
/* loaded from: classes10.dex */
public class a {
    public BdAlertDialog a(final Activity activity, final FloatPermissionUtil.a aVar) {
        BdAlertDialog bdAlertDialog = new BdAlertDialog(activity);
        bdAlertDialog.setCanceledOnTouchOutside(false);
        bdAlertDialog.setTitle(a.h.sdk_request_permission_default_title);
        bdAlertDialog.setMessageId(a.h.player_floating_video_message_video);
        bdAlertDialog.setPositiveButton(a.h.sdk_isopen, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.floating.permission.a.2
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                FloatPermissionUtil.b(activity, aVar);
            }
        }).setNegativeButton(a.h.sdk_cancel, new BdAlertDialog.OnClickListener() { // from class: com.baidu.tieba.ala.floating.permission.a.1
            @Override // com.baidu.live.tbadk.core.dialog.BdAlertDialog.OnClickListener
            public void onClick(BdAlertDialog bdAlertDialog2) {
                bdAlertDialog2.dismiss();
                aVar.onResult(1);
            }
        }).create(IScrollableHelper.getBbPageContext(activity));
        bdAlertDialog.getRealView().setBackgroundResource(a.e.sdk_dialog_background);
        return bdAlertDialog;
    }
}
