package com.baidu.tieba.editortool;

import com.baidu.tbadk.BaseActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditor ark;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.ark = pbEditor;
        this.arn = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                if (this.ark.Ch()) {
                    com.baidu.adp.lib.util.m.showToast(this.ark.getContext(), com.baidu.tieba.y.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.getName() != null) {
                    if (PbEditor.eI(this.ark.ard.getEditText().getText().toString()) >= 10 && (this.ark.mContext instanceof BaseActivity)) {
                        ((BaseActivity) this.ark.mContext).showToast(this.ark.mContext.getResources().getString(com.baidu.tieba.y.too_many_face));
                        return;
                    } else {
                        this.ark.ard.getEditText().getText().insert(this.ark.ard.getEditText().getSelectionStart(), dVar.getName());
                    }
                }
                if (this.ark.BZ()) {
                    this.ark.ard.BX();
                } else {
                    this.ark.ard.BY();
                }
            }
        } else if (i == 21) {
            if (this.ark.ard.getEditText().getSelectionStart() > 0) {
                String substring = this.ark.ard.getEditText().getText().toString().substring(0, this.ark.ard.getEditText().getSelectionStart());
                pattern = PbEditor.arg;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.ark.ard.getEditText().getText().delete(this.ark.ard.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.ark.ard.getEditText().getSelectionStart());
                    return;
                }
                this.ark.ard.getEditText().getText().delete(this.ark.ard.getEditText().getSelectionStart() - 1, this.ark.ard.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.ark.ard.Cl();
            if (this.ark.BZ()) {
                this.ark.ard.BX();
            } else {
                this.ark.ard.BY();
            }
        } else if (i == 15) {
            this.ark.ard.Cm();
            if (this.ark.BZ()) {
                this.ark.ard.BX();
            } else {
                this.ark.ard.BY();
            }
        } else if (i == 2) {
            this.ark.er(i);
            this.ark.ard.Bg();
        } else if (i == 23) {
            this.ark.ard.Bg();
            if (this.ark.are.BL()) {
                this.ark.er(i);
            } else {
                this.arn.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.ark.ard.Bg();
            this.arn.handleAction(i, obj);
        } else if (i == 13) {
            this.ark.refresh();
            if (this.ark.BZ()) {
                this.ark.ard.BX();
            } else {
                this.ark.ard.BY();
            }
            this.arn.handleAction(i, obj);
        } else if (i == 0) {
            if (this.ark.Ch()) {
                com.baidu.adp.lib.util.m.showToast(this.ark.getContext(), com.baidu.tieba.y.over_limit_tip);
            } else {
                this.arn.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.ark.er(i);
            this.ark.ard.Bg();
        } else if (i == 46) {
            this.ark.ard.Cn();
        } else if (i == 47) {
            if (!this.ark.are.BL()) {
                this.ark.ard.Co();
            }
        } else if (i == 48) {
            this.ark.ard.Bg();
            if (this.ark.are.BM()) {
                this.ark.er(i);
                return;
            }
            this.ark.are.rK();
            this.arn.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.ark.are.BM()) {
                this.ark.are.BF();
            }
            this.ark.refresh();
            if (this.ark.BZ()) {
                this.ark.ard.BX();
            } else {
                this.ark.ard.BY();
            }
            this.arn.handleAction(i, obj);
        } else {
            this.arn.handleAction(i, obj);
        }
    }
}
