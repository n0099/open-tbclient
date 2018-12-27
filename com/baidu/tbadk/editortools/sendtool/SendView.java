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
    private EditorTools Ta;
    private int Tb;
    private int aLH;
    private boolean[] bas;
    private int[] bat;
    private int mType;
    public static int bau = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.bas = new boolean[]{false, false, false, false, false};
        this.bat = new int[]{0, 0};
        this.aLH = 0;
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
                        this.bas[0] = false;
                        break;
                    } else {
                        this.bas[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.bas[0] = false;
                    this.bas[1] = false;
                    this.bas[2] = false;
                    this.bas[3] = false;
                    this.bas[4] = false;
                    this.bat[0] = 0;
                    this.bat[1] = 0;
                    break;
                case 10:
                    this.bas[2] = true;
                    break;
                case 11:
                    this.bas[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aZk != null) {
                            if (aVar2.aZk.getChosedFiles() != null) {
                                this.bat[0] = aVar2.aZk.getChosedFiles().size();
                            } else {
                                this.bat[0] = 0;
                            }
                        }
                        if (this.bat[0] > 0) {
                            this.bas[1] = true;
                            break;
                        } else {
                            this.bas[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bat;
                    iArr[0] = iArr[0] - 1;
                    if (this.bat[0] > 0) {
                        this.bas[1] = true;
                        break;
                    } else {
                        this.bas[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.bas[3] = true;
                    break;
                case 29:
                    this.bas[3] = false;
                    break;
            }
            fT(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Ta = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ta != null) {
            this.Ta.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Tb = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Tb;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pN() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aLH = i;
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
            if (this.bas[0] || this.bas[1] || this.bas[2] || this.bas[3] || this.bas[4]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aLH);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        } else if (i == bau) {
            if (this.bas[1]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aLH);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        }
    }
}
