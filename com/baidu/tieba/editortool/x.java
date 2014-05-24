package com.baidu.tieba.editortool;

import com.baidu.tbadk.BaseActivity;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x implements com.baidu.tbadk.editortool.x {
    final /* synthetic */ PbEditor a;
    private final /* synthetic */ com.baidu.tbadk.editortool.x b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public x(PbEditor pbEditor, com.baidu.tbadk.editortool.x xVar) {
        this.a = pbEditor;
        this.b = xVar;
    }

    @Override // com.baidu.tbadk.editortool.x
    public void a(int i, Object obj) {
        boolean v;
        Pattern pattern;
        if (i == 20) {
            if (obj != null && (obj instanceof com.baidu.tbadk.coreExtra.data.d)) {
                com.baidu.tbadk.coreExtra.data.d dVar = (com.baidu.tbadk.coreExtra.data.d) obj;
                if (dVar.a() != null) {
                    if (PbEditor.a(this.a.b.getEditText().getText().toString()) >= 10 && (this.a.a instanceof BaseActivity)) {
                        ((BaseActivity) this.a.a).showToast(this.a.a.getResources().getString(com.baidu.tieba.y.too_many_face));
                        return;
                    } else {
                        this.a.b.getEditText().getText().insert(this.a.b.getEditText().getSelectionStart(), dVar.a());
                    }
                }
                if (this.a.c()) {
                    this.a.b.e();
                } else {
                    this.a.b.f();
                }
            }
        } else if (i == 21) {
            if (this.a.b.getEditText().getSelectionStart() > 0) {
                String substring = this.a.b.getEditText().getText().toString().substring(0, this.a.b.getEditText().getSelectionStart());
                pattern = PbEditor.f;
                Matcher matcher = pattern.matcher(substring);
                if (matcher.find()) {
                    this.a.b.getEditText().getText().delete(this.a.b.getEditText().getSelectionStart() - (substring.length() - matcher.replaceFirst("").length()), this.a.b.getEditText().getSelectionStart());
                    return;
                }
                this.a.b.getEditText().getText().delete(this.a.b.getEditText().getSelectionStart() - 1, this.a.b.getEditText().getSelectionStart());
            }
        } else if (i == 14) {
            this.a.b.g();
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
        } else if (i == 15) {
            this.a.b.h();
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
        } else if (i == 2) {
            this.a.b(i);
            this.a.b.k();
        } else if (i == 23) {
            this.a.b.k();
            if (this.a.c.t()) {
                this.a.b(i);
            } else {
                this.b.a(i, obj);
            }
        } else if (i == 22) {
            this.a.b.k();
            this.b.a(i, obj);
        } else if (i == 13) {
            if (this.a.c.t()) {
                this.a.b.i();
            } else {
                this.a.b.j();
            }
            if (this.a.c()) {
                this.a.b.e();
            } else {
                this.a.b.f();
            }
            this.b.a(i, obj);
        } else if (i == 0) {
            v = this.a.v();
            if (v) {
                com.baidu.adp.lib.util.k.a(this.a.getContext(), com.baidu.tieba.y.over_limit_tip);
            } else {
                this.b.a(i, obj);
            }
        } else if (i == 44) {
            this.a.b(i);
            this.a.b.k();
        } else if (i == 46) {
            this.a.b.i();
        } else if (i == 47) {
            if (!this.a.c.t()) {
                this.a.b.j();
            }
        } else {
            this.b.a(i, obj);
        }
    }
}
