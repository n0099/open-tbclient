package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ak;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools JO;
    private int JP;
    private boolean[] aEU;
    private int[] aEV;
    private int aqQ;
    private int mType;
    public static int aEW = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aEU = new boolean[]{false, false, false, false, false};
        this.aEV = new int[]{0, 0};
        this.aqQ = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0126d.cp_cont_e));
        setText(d.k.send_post);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.sendtool.SendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
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
                        this.aEU[0] = false;
                        break;
                    } else {
                        this.aEU[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aEU[0] = false;
                    this.aEU[1] = false;
                    this.aEU[2] = false;
                    this.aEU[3] = false;
                    this.aEU[4] = false;
                    this.aEV[0] = 0;
                    this.aEV[1] = 0;
                    break;
                case 10:
                    this.aEU[2] = true;
                    break;
                case 11:
                    this.aEU[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aDM != null) {
                            if (aVar2.aDM.getChosedFiles() != null) {
                                this.aEV[0] = aVar2.aDM.getChosedFiles().size();
                            } else {
                                this.aEV[0] = 0;
                            }
                        }
                        if (this.aEV[0] > 0) {
                            this.aEU[1] = true;
                            break;
                        } else {
                            this.aEU[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEV;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEV[0] > 0) {
                        this.aEU[1] = true;
                        break;
                    } else {
                        this.aEU[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aEU[3] = true;
                    break;
                case 29:
                    this.aEU[3] = false;
                    break;
            }
            eQ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.JO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JO != null) {
            this.JO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.JP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.JP;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aqQ = i;
        if (isEnabled()) {
            ak.b(this, d.C0126d.cp_link_tip_a, 1, i);
        } else {
            ak.c(this, d.C0126d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eQ(int i) {
        if (i == ALL) {
            if (this.aEU[0] || this.aEU[1] || this.aEU[2] || this.aEU[3] || this.aEU[4]) {
                setEnabled(true);
                ak.b(this, d.C0126d.cp_link_tip_a, 1, this.aqQ);
                return;
            }
            setEnabled(false);
            ak.c(this, d.C0126d.cp_cont_e, 1);
        } else if (i == aEW) {
            if (this.aEU[1]) {
                setEnabled(true);
                ak.b(this, d.C0126d.cp_link_tip_a, 1, this.aqQ);
                return;
            }
            setEnabled(false);
            ak.c(this, d.C0126d.cp_cont_e, 1);
        }
    }
}
