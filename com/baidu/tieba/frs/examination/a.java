package com.baidu.tieba.frs.examination;

import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.ab;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
/* loaded from: classes9.dex */
public class a {
    private NewWriteModel emH;
    private final BaseFragmentActivity gRG;
    private final ForumWriteData hyK;
    private final SerializableItemInfo hyL;
    private final EditText hyM;
    private final EditText hyN;
    private WriteData hyO;
    private InputMethodManager mInputManager;
    private com.baidu.tbadk.core.view.a euw = null;
    private final NewWriteModel.d emV = new NewWriteModel.d() { // from class: com.baidu.tieba.frs.examination.a.1
        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ab abVar, WriteData writeData, AntiData antiData) {
            a.this.closeLoadingDialog();
            if (postWriteCallBackData != null) {
                if (!z) {
                    a.this.gRG.showToast(postWriteCallBackData.getErrorString());
                    return;
                }
                TiebaStatic.log(new an("c13723").dh("tid", postWriteCallBackData.getThreadId()).dh("fid", a.this.hyK.forumId).dh("fname", a.this.hyK.forumName).dh("uid", TbadkCoreApplication.getCurrentAccount()));
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putSerializable("post_write_callback_data", postWriteCallBackData);
                intent.putExtras(bundle);
                a.this.gRG.setResult(-1, intent);
                a.this.gRG.finish();
            }
        }
    };

    public a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId, ForumWriteData forumWriteData, SerializableItemInfo serializableItemInfo, EditText editText, EditText editText2) {
        this.mInputManager = null;
        this.gRG = baseFragmentActivity;
        this.hyK = forumWriteData;
        this.hyL = serializableItemInfo;
        this.hyM = editText;
        this.hyN = editText2;
        this.mInputManager = (InputMethodManager) baseFragmentActivity.getSystemService("input_method");
        initUI();
        initData();
    }

    private void initUI() {
        this.euw = new com.baidu.tbadk.core.view.a(this.gRG);
    }

    private void initData() {
        this.emH = new NewWriteModel();
        this.hyO = new WriteData();
        this.emH.b(this.emV);
    }

    public void a(String str, String str2, ForumWriteData forumWriteData) {
        if (!j.isNetWorkAvailable()) {
            l.showToast(this.gRG, (int) R.string.neterror);
        }
        if (this.hyL != null) {
            this.hyO.setItem_id(String.valueOf(this.hyL.id));
        }
        this.hyO.setForumName(forumWriteData.forumName);
        this.hyO.setContent(str);
        this.hyO.setComment_head(str2);
        this.hyO.setForumId(forumWriteData.forumId);
        this.hyO.setTitle("");
        this.hyO.setIsNoTitle(true);
        this.gRG.HidenSoftKeyPad(this.mInputManager, this.hyM);
        this.gRG.HidenSoftKeyPad(this.mInputManager, this.hyN);
        bYH();
    }

    private void bYH() {
        this.emH.d(this.hyO);
        this.emH.dfc();
        showLoadingDialog();
    }

    public void showLoadingDialog() {
        this.euw.setCancelListener(null);
        this.euw.setTipString(R.string.sending);
        this.euw.setDialogVisiable(true);
    }

    public void closeLoadingDialog() {
        this.euw.setDialogVisiable(false);
    }
}
