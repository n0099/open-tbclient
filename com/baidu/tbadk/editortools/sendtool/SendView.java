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
    private EditorTools Tj;
    private int Tk;
    private int aMj;
    private boolean[] bbc;
    private int[] bbd;
    private int mType;
    public static int bbe = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.bbc = new boolean[]{false, false, false, false, false};
        this.bbd = new int[]{0, 0};
        this.aMj = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(e.C0210e.ds17), context.getResources().getDimensionPixelSize(e.C0210e.ds28), context.getResources().getDimensionPixelSize(e.C0210e.ds10), context.getResources().getDimensionPixelSize(e.C0210e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(e.C0210e.fontsize28));
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
                        this.bbc[0] = false;
                        break;
                    } else {
                        this.bbc[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.bbc[0] = false;
                    this.bbc[1] = false;
                    this.bbc[2] = false;
                    this.bbc[3] = false;
                    this.bbc[4] = false;
                    this.bbd[0] = 0;
                    this.bbd[1] = 0;
                    break;
                case 10:
                    this.bbc[2] = true;
                    break;
                case 11:
                    this.bbc[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZU != null) {
                            if (aVar2.aZU.getChosedFiles() != null) {
                                this.bbd[0] = aVar2.aZU.getChosedFiles().size();
                            } else {
                                this.bbd[0] = 0;
                            }
                        }
                        if (this.bbd[0] > 0) {
                            this.bbc[1] = true;
                            break;
                        } else {
                            this.bbc[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bbd;
                    iArr[0] = iArr[0] - 1;
                    if (this.bbd[0] > 0) {
                        this.bbc[1] = true;
                        break;
                    } else {
                        this.bbc[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.bbc[3] = true;
                    break;
                case 29:
                    this.bbc[3] = false;
                    break;
            }
            fT(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Tj = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Tj != null) {
            this.Tj.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tk = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tk;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pR() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aMj = i;
        if (isEnabled()) {
            al.b(this, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this, e.d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fT(int i) {
        if (i == ALL) {
            if (this.bbc[0] || this.bbc[1] || this.bbc[2] || this.bbc[3] || this.bbc[4]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aMj);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        } else if (i == bbe) {
            if (this.bbc[1]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aMj);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        }
    }
}
