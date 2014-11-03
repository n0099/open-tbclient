package com.baidu.tieba.editortool;

import com.baidu.tbadk.BaseActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ad implements com.baidu.tbadk.editortool.w {
    final /* synthetic */ PbEditor art;
    private final /* synthetic */ com.baidu.tbadk.editortool.w arw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(PbEditor pbEditor, com.baidu.tbadk.editortool.w wVar) {
        this.art = pbEditor;
        this.arw = wVar;
    }

    @Override // com.baidu.tbadk.editortool.w
    public void handleAction(int i, Object obj) {
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                if (this.art.Cj()) {
                    com.baidu.adp.lib.util.m.showToast(this.art.getContext(), com.baidu.tieba.y.over_limit_tip);
                    return;
                }
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.getName() != null) {
                    if (PbEditor.eI(this.art.arm.getEditText().getText().toString()) >= 10 && (this.art.mContext instanceof BaseActivity)) {
                        ((BaseActivity) this.art.mContext).showToast(this.art.mContext.getResources().getString(com.baidu.tieba.y.too_many_face));
                        return;
                    } else {
                        this.art.arm.getEditText().getText().insert(this.art.arm.getEditText().getSelectionStart(), dVar.getName());
                    }
                }
                if (this.art.Cb()) {
                    this.art.arm.BZ();
                } else {
                    this.art.arm.Ca();
                }
            }
        } else if (i == 21) {
            if (this.art.arm.getEditText().getSelectionStart() > 0) {
                String substring = this.art.arm.getEditText().getText().toString().substring(0, this.art.arm.getEditText().getSelectionStart());
                pattern = PbEditor.arp;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.art.arm.getEditText().getText().delete(this.art.arm.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.art.arm.getEditText().getSelectionStart());
                    return;
                }
                this.art.arm.getEditText().getText().delete(this.art.arm.getEditText().getSelectionStart() - 1, this.art.arm.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.art.arm.Cn();
            if (this.art.Cb()) {
                this.art.arm.BZ();
            } else {
                this.art.arm.Ca();
            }
        } else if (i == 15) {
            this.art.arm.Co();
            if (this.art.Cb()) {
                this.art.arm.BZ();
            } else {
                this.art.arm.Ca();
            }
        } else if (i == 2) {
            this.art.er(i);
            this.art.arm.Bi();
        } else if (i == 23) {
            this.art.arm.Bi();
            if (this.art.arn.BN()) {
                this.art.er(i);
            } else {
                this.arw.handleAction(i, obj);
            }
        } else if (i == 22) {
            this.art.arm.Bi();
            this.arw.handleAction(i, obj);
        } else if (i == 13) {
            this.art.refresh();
            if (this.art.Cb()) {
                this.art.arm.BZ();
            } else {
                this.art.arm.Ca();
            }
            this.arw.handleAction(i, obj);
        } else if (i == 0) {
            if (this.art.Cj()) {
                com.baidu.adp.lib.util.m.showToast(this.art.getContext(), com.baidu.tieba.y.over_limit_tip);
            } else {
                this.arw.handleAction(i, obj);
            }
        } else if (i == 44) {
            this.art.er(i);
            this.art.arm.Bi();
        } else if (i == 46) {
            this.art.arm.Cp();
        } else if (i == 47) {
            if (!this.art.arn.BN()) {
                this.art.arm.Cq();
            }
        } else if (i == 48) {
            this.art.arm.Bi();
            if (this.art.arn.BO()) {
                this.art.er(i);
                return;
            }
            this.art.arn.rM();
            this.arw.handleAction(i, obj);
        } else if (i == 51) {
            if (!this.art.arn.BO()) {
                this.art.arn.BH();
            }
            this.art.refresh();
            if (this.art.Cb()) {
                this.art.arm.BZ();
            } else {
                this.art.arm.Ca();
            }
            this.arw.handleAction(i, obj);
        } else {
            this.arw.handleAction(i, obj);
        }
    }
}
