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
    private EditorTools Qg;
    private int Qh;
    private boolean[] aOl;
    private int[] aOm;
    private int azI;
    private int mType;
    public static int aOn = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aOl = new boolean[]{false, false, false, false, false};
        this.aOm = new int[]{0, 0};
        this.azI = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0140d.cp_cont_e));
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
                        this.aOl[0] = false;
                        break;
                    } else {
                        this.aOl[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aOl[0] = false;
                    this.aOl[1] = false;
                    this.aOl[2] = false;
                    this.aOl[3] = false;
                    this.aOl[4] = false;
                    this.aOm[0] = 0;
                    this.aOm[1] = 0;
                    break;
                case 10:
                    this.aOl[2] = true;
                    break;
                case 11:
                    this.aOl[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aNe != null) {
                            if (aVar2.aNe.getChosedFiles() != null) {
                                this.aOm[0] = aVar2.aNe.getChosedFiles().size();
                            } else {
                                this.aOm[0] = 0;
                            }
                        }
                        if (this.aOm[0] > 0) {
                            this.aOl[1] = true;
                            break;
                        } else {
                            this.aOl[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aOm;
                    iArr[0] = iArr[0] - 1;
                    if (this.aOm[0] > 0) {
                        this.aOl[1] = true;
                        break;
                    } else {
                        this.aOl[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aOl[3] = true;
                    break;
                case 29:
                    this.aOl[3] = false;
                    break;
            }
            eW(this.mType);
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
    public void oF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.azI = i;
        if (isEnabled()) {
            am.b(this, d.C0140d.cp_link_tip_a, 1, i);
        } else {
            am.c(this, d.C0140d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eW(int i) {
        if (i == ALL) {
            if (this.aOl[0] || this.aOl[1] || this.aOl[2] || this.aOl[3] || this.aOl[4]) {
                setEnabled(true);
                am.b(this, d.C0140d.cp_link_tip_a, 1, this.azI);
                return;
            }
            setEnabled(false);
            am.c(this, d.C0140d.cp_cont_e, 1);
        } else if (i == aOn) {
            if (this.aOl[1]) {
                setEnabled(true);
                am.b(this, d.C0140d.cp_link_tip_a, 1, this.azI);
                return;
            }
            setEnabled(false);
            am.c(this, d.C0140d.cp_cont_e, 1);
        }
    }
}
