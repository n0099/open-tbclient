package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools VN;
    private int VO;
    private int bUK;
    private boolean[] ckE;
    private int[] ckF;
    private int mType;
    public static int ckG = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.ckE = new boolean[]{false, false, false, false, false};
        this.ckF = new int[]{0, 0};
        this.bUK = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0277d.cp_cont_e));
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
                        this.ckE[0] = false;
                        break;
                    } else {
                        this.ckE[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.ckE[0] = false;
                    this.ckE[1] = false;
                    this.ckE[2] = false;
                    this.ckE[3] = false;
                    this.ckE[4] = false;
                    this.ckF[0] = 0;
                    this.ckF[1] = 0;
                    break;
                case 10:
                    this.ckE[2] = true;
                    break;
                case 11:
                    this.ckE[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cju != null) {
                            if (aVar2.cju.getChosedFiles() != null) {
                                this.ckF[0] = aVar2.cju.getChosedFiles().size();
                            } else {
                                this.ckF[0] = 0;
                            }
                        }
                        if (this.ckF[0] > 0) {
                            this.ckE[1] = true;
                            break;
                        } else {
                            this.ckE[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckF;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckF[0] > 0) {
                        this.ckE[1] = true;
                        break;
                    } else {
                        this.ckE[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.ckE[3] = true;
                    break;
                case 29:
                    this.ckE[3] = false;
                    break;
            }
            jE(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.bUK = i;
        if (isEnabled()) {
            al.c(this, d.C0277d.cp_link_tip_a, 1, i);
        } else {
            al.d(this, d.C0277d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jE(int i) {
        if (i == ALL) {
            if (this.ckE[0] || this.ckE[1] || this.ckE[2] || this.ckE[3] || this.ckE[4]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUK);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        } else if (i == ckG) {
            if (this.ckE[1]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUK);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        }
    }
}
