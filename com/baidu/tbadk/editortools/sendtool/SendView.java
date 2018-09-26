package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.e;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools SG;
    private int SH;
    private int aCJ;
    private boolean[] aRA;
    private int[] aRB;
    private int mType;
    public static int aRC = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aRA = new boolean[]{false, false, false, false, false};
        this.aRB = new int[]{0, 0};
        this.aCJ = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(e.C0141e.ds17), context.getResources().getDimensionPixelSize(e.C0141e.ds28), context.getResources().getDimensionPixelSize(e.C0141e.ds10), context.getResources().getDimensionPixelSize(e.C0141e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(e.C0141e.fontsize28));
        setTextColor(getContext().getResources().getColor(e.d.cp_cont_e));
        setText(e.j.send_post);
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
                        this.aRA[0] = false;
                        break;
                    } else {
                        this.aRA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aRA[0] = false;
                    this.aRA[1] = false;
                    this.aRA[2] = false;
                    this.aRA[3] = false;
                    this.aRA[4] = false;
                    this.aRB[0] = 0;
                    this.aRB[1] = 0;
                    break;
                case 10:
                    this.aRA[2] = true;
                    break;
                case 11:
                    this.aRA[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aQt != null) {
                            if (aVar2.aQt.getChosedFiles() != null) {
                                this.aRB[0] = aVar2.aQt.getChosedFiles().size();
                            } else {
                                this.aRB[0] = 0;
                            }
                        }
                        if (this.aRB[0] > 0) {
                            this.aRA[1] = true;
                            break;
                        } else {
                            this.aRA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aRB;
                    iArr[0] = iArr[0] - 1;
                    if (this.aRB[0] > 0) {
                        this.aRA[1] = true;
                        break;
                    } else {
                        this.aRA[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aRA[3] = true;
                    break;
                case 29:
                    this.aRA[3] = false;
                    break;
            }
            fh(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SG = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SG != null) {
            this.SG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SH = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SH;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pI() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aCJ = i;
        if (isEnabled()) {
            al.b(this, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this, e.d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fh(int i) {
        if (i == ALL) {
            if (this.aRA[0] || this.aRA[1] || this.aRA[2] || this.aRA[3] || this.aRA[4]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aCJ);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        } else if (i == aRC) {
            if (this.aRA[1]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aCJ);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        }
    }
}
