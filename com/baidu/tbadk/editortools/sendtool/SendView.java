package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements s {
    private i IR;
    private int IS;
    private boolean[] aEd;
    private int[] aEe;
    private int apD;
    private int mType;
    public static int aEf = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aEd = new boolean[]{false, false, false, false, false};
        this.aEe = new int[]{0, 0};
        this.apD = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0096d.cp_cont_e));
        setText(d.j.send_post);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.sendtool.SendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SendView.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aEd[0] = false;
                        break;
                    } else {
                        this.aEd[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aEd[0] = false;
                    this.aEd[1] = false;
                    this.aEd[2] = false;
                    this.aEd[3] = false;
                    this.aEd[4] = false;
                    this.aEe[0] = 0;
                    this.aEe[1] = 0;
                    break;
                case 10:
                    this.aEd[2] = true;
                    break;
                case 11:
                    this.aEd[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCS != null) {
                            if (aVar2.aCS.getChosedFiles() != null) {
                                this.aEe[0] = aVar2.aCS.getChosedFiles().size();
                            } else {
                                this.aEe[0] = 0;
                            }
                        }
                        if (this.aEe[0] > 0) {
                            this.aEd[1] = true;
                            break;
                        } else {
                            this.aEd[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEe;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEe[0] > 0) {
                        this.aEd[1] = true;
                        break;
                    } else {
                        this.aEd[1] = false;
                        break;
                    }
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aEd[3] = true;
                    break;
                case 29:
                    this.aEd[3] = false;
                    break;
            }
            eY(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IR = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IR != null) {
            this.IR.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IS = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IS;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.apD = i;
        if (isEnabled()) {
            aj.b(this, d.C0096d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.C0096d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eY(int i) {
        if (i == ALL) {
            if (this.aEd[0] || this.aEd[1] || this.aEd[2] || this.aEd[3] || this.aEd[4]) {
                setEnabled(true);
                aj.b(this, d.C0096d.cp_link_tip_a, 1, this.apD);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0096d.cp_cont_e, 1);
        } else if (i == aEf) {
            if (this.aEd[1]) {
                setEnabled(true);
                aj.b(this, d.C0096d.cp_link_tip_a, 1, this.apD);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0096d.cp_cont_e, 1);
        }
    }
}
