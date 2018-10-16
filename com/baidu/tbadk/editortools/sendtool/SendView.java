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
    private EditorTools SY;
    private int SZ;
    private int aHp;
    private boolean[] aWb;
    private int[] aWc;
    private int mType;
    public static int aWd = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aWb = new boolean[]{false, false, false, false, false};
        this.aWc = new int[]{0, 0};
        this.aHp = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(e.C0175e.ds17), context.getResources().getDimensionPixelSize(e.C0175e.ds28), context.getResources().getDimensionPixelSize(e.C0175e.ds10), context.getResources().getDimensionPixelSize(e.C0175e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(e.C0175e.fontsize28));
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
                        this.aWb[0] = false;
                        break;
                    } else {
                        this.aWb[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aWb[0] = false;
                    this.aWb[1] = false;
                    this.aWb[2] = false;
                    this.aWb[3] = false;
                    this.aWb[4] = false;
                    this.aWc[0] = 0;
                    this.aWc[1] = 0;
                    break;
                case 10:
                    this.aWb[2] = true;
                    break;
                case 11:
                    this.aWb[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aUU != null) {
                            if (aVar2.aUU.getChosedFiles() != null) {
                                this.aWc[0] = aVar2.aUU.getChosedFiles().size();
                            } else {
                                this.aWc[0] = 0;
                            }
                        }
                        if (this.aWc[0] > 0) {
                            this.aWb[1] = true;
                            break;
                        } else {
                            this.aWb[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aWc;
                    iArr[0] = iArr[0] - 1;
                    if (this.aWc[0] > 0) {
                        this.aWb[1] = true;
                        break;
                    } else {
                        this.aWb[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aWb[3] = true;
                    break;
                case 29:
                    this.aWb[3] = false;
                    break;
            }
            fq(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.SY = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.SY != null) {
            this.SY.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.SZ = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.SZ;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pQ() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aHp = i;
        if (isEnabled()) {
            al.b(this, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this, e.d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fq(int i) {
        if (i == ALL) {
            if (this.aWb[0] || this.aWb[1] || this.aWb[2] || this.aWb[3] || this.aWb[4]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aHp);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        } else if (i == aWd) {
            if (this.aWb[1]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aHp);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        }
    }
}
