package com.baidu.tbadk.coreExtra.c;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.view.NewUserRewardDialogView;
/* loaded from: classes.dex */
public class b {
    public static void a(TbPageContext tbPageContext, PostWriteCallBackData postWriteCallBackData) {
        final NewUserRewardDialogView newUserRewardDialogView = new NewUserRewardDialogView(tbPageContext.getPageActivity());
        newUserRewardDialogView.setData(postWriteCallBackData.getIconStampData());
        final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a(tbPageContext.getPageActivity());
        aVar.nA(5);
        aVar.bn(newUserRewardDialogView);
        aVar.jG(false);
        aVar.nB(R.style.picker_view_scale_anim);
        aVar.b(tbPageContext).bqx();
        newUserRewardDialogView.setCloseListener(new View.OnClickListener() { // from class: com.baidu.tbadk.coreExtra.c.b.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                NewUserRewardDialogView.this.onDestroy();
                aVar.dismiss();
            }
        });
    }
}
