package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.f;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools Qg;
    private int Qh;
    private boolean[] aOi;
    private int[] aOj;
    private int azF;
    private int mType;
    public static int aOk = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aOi = new boolean[]{false, false, false, false, false};
        this.aOj = new int[]{0, 0};
        this.azF = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(f.e.ds17), context.getResources().getDimensionPixelSize(f.e.ds28), context.getResources().getDimensionPixelSize(f.e.ds10), context.getResources().getDimensionPixelSize(f.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(f.e.fontsize28));
        setTextColor(getContext().getResources().getColor(f.d.cp_cont_e));
        setText(f.j.send_post);
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
                        this.aOi[0] = false;
                        break;
                    } else {
                        this.aOi[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aOi[0] = false;
                    this.aOi[1] = false;
                    this.aOi[2] = false;
                    this.aOi[3] = false;
                    this.aOi[4] = false;
                    this.aOj[0] = 0;
                    this.aOj[1] = 0;
                    break;
                case 10:
                    this.aOi[2] = true;
                    break;
                case 11:
                    this.aOi[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNb != null) {
                            if (aVar2.aNb.getChosedFiles() != null) {
                                this.aOj[0] = aVar2.aNb.getChosedFiles().size();
                            } else {
                                this.aOj[0] = 0;
                            }
                        }
                        if (this.aOj[0] > 0) {
                            this.aOi[1] = true;
                            break;
                        } else {
                            this.aOi[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOj;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOj[0] > 0) {
                        this.aOi[1] = true;
                        break;
                    } else {
                        this.aOi[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aOi[3] = true;
                    break;
                case 29:
                    this.aOi[3] = false;
                    break;
            }
            eV(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qg = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qg != null) {
            this.Qg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qh = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qh;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azF = i;
        if (isEnabled()) {
            am.b(this, f.d.cp_link_tip_a, 1, i);
        } else {
            am.c(this, f.d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eV(int i) {
        if (i == ALL) {
            if (this.aOi[0] || this.aOi[1] || this.aOi[2] || this.aOi[3] || this.aOi[4]) {
                setEnabled(true);
                am.b(this, f.d.cp_link_tip_a, 1, this.azF);
                return;
            }
            setEnabled(false);
            am.c(this, f.d.cp_cont_e, 1);
        } else if (i == aOk) {
            if (this.aOi[1]) {
                setEnabled(true);
                am.b(this, f.d.cp_link_tip_a, 1, this.azF);
                return;
            }
            setEnabled(false);
            am.c(this, f.d.cp_cont_e, 1);
        }
    }
}
