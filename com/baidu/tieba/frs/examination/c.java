package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ad;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class c {
    private com.baidu.tbadk.core.view.a eDA = null;
    private final NewWriteModel.d evL = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.c.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ad adVar, WriteData writeData, AntiData antiData) {
            c.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    c.this.hep.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new ao("c13723").dk("tid", postWriteCallBackData.getThreadId()).dk("fid", c.this.hLG.forumId).dk("fname", c.this.hLG.forumName).dk("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                c.this.hep.setResult(-1, intent);
                c.this.hep.finish();
            }
        }
    };
    private NewWriteModel evx;
    private final ForumWriteData hLG;
    private final SerializableItemInfo hLI;
    private WriteData hLV;
    private a hLW;
    private final BaseFragmentActivity hep;
    private InputMethodManager mInputManager;

    /* loaded from: classes9.dex */
    public interface a {
        void a(InputMethodManager inputMethodManager);
    }

    public c(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo) {
        this.mInputManager = null;
        this.hep = baseFragmentActivity;
        this.hLG = forumWriteData;
        this.hLI = serializableItemInfo;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.eDA = new com.baidu.tbadk.core.view.a(this.hep);
    }

    private void initData() {
        this.evx = new NewWriteModel();
        this.hLV = new WriteData();
        this.evx.b(this.evL);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.hep, (int) R.string.neterror);
        }
        if (this.hLI != null) {
            this.hLV.setItem_id(String.valueOf(this.hLI.id));
        }
        this.hLV.setForumName(forumWriteData.forumName);
        this.hLV.setContent(str);
        this.hLV.setComment_head(str2);
        this.hLV.setForumId(forumWriteData.forumId);
        this.hLV.setTitle("");
        this.hLV.setIsNoTitle(true);
        if (this.hLW != null) {
            this.hLW.a(this.mInputManager);
        }
        ccb();
    }

    private void ccb() {
        this.evx.d(this.hLV);
        this.evx.djn();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.eDA.setCancelListener(null);
        this.eDA.setTipString(R.string.sending);
        this.eDA.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.eDA.setDialogVisiable(false);
    }

    public void a(a aVar) {
        this.hLW = aVar;
    }
}
