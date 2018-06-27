package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools Qj;
    private int Qk;
    private boolean[] aOm;
    private int[] aOn;
    private int azP;
    private int mType;
    public static int aOo = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aOm = new boolean[]{false, false, false, false, false};
        this.aOn = new int[]{0, 0};
        this.azP = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0142d.cp_cont_e));
        setText(d.k.send_post);
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
                        this.aOm[0] = false;
                        break;
                    } else {
                        this.aOm[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aOm[0] = false;
                    this.aOm[1] = false;
                    this.aOm[2] = false;
                    this.aOm[3] = false;
                    this.aOm[4] = false;
                    this.aOn[0] = 0;
                    this.aOn[1] = 0;
                    break;
                case 10:
                    this.aOm[2] = true;
                    break;
                case 11:
                    this.aOm[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNe != null) {
                            if (aVar2.aNe.getChosedFiles() != null) {
                                this.aOn[0] = aVar2.aNe.getChosedFiles().size();
                            } else {
                                this.aOn[0] = 0;
                            }
                        }
                        if (this.aOn[0] > 0) {
                            this.aOm[1] = true;
                            break;
                        } else {
                            this.aOm[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOn;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOn[0] > 0) {
                        this.aOm[1] = true;
                        break;
                    } else {
                        this.aOm[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aOm[3] = true;
                    break;
                case 29:
                    this.aOm[3] = false;
                    break;
            }
            eV(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qj != null) {
            this.Qj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azP = i;
        if (isEnabled()) {
            am.b(this, d.C0142d.cp_link_tip_a, 1, i);
        } else {
            am.c(this, d.C0142d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eV(int i) {
        if (i == ALL) {
            if (this.aOm[0] || this.aOm[1] || this.aOm[2] || this.aOm[3] || this.aOm[4]) {
                setEnabled(true);
                am.b(this, d.C0142d.cp_link_tip_a, 1, this.azP);
                return;
            }
            setEnabled(false);
            am.c(this, d.C0142d.cp_cont_e, 1);
        } else if (i == aOo) {
            if (this.aOm[1]) {
                setEnabled(true);
                am.b(this, d.C0142d.cp_link_tip_a, 1, this.azP);
                return;
            }
            setEnabled(false);
            am.c(this, d.C0142d.cp_cont_e, 1);
        }
    }
}
