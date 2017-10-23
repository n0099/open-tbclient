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
    private int JG;
    private i JH;
    private boolean[] aCX;
    private int[] aCY;
    private int aoN;
    private int mType;
    public static int aCZ = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aCX = new boolean[]{false, false, false, false, false};
        this.aCY = new int[]{0, 0};
        this.aoN = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.f.ds17), context.getResources().getDimensionPixelSize(d.f.ds28), context.getResources().getDimensionPixelSize(d.f.ds10), context.getResources().getDimensionPixelSize(d.f.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.f.fontsize28));
        setTextColor(getContext().getResources().getColor(d.e.cp_cont_e));
        setText(d.l.send_post);
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
                        this.aCX[0] = false;
                        break;
                    } else {
                        this.aCX[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aCX[0] = false;
                    this.aCX[1] = false;
                    this.aCX[2] = false;
                    this.aCX[3] = false;
                    this.aCX[4] = false;
                    this.aCY[0] = 0;
                    this.aCY[1] = 0;
                    break;
                case 10:
                    this.aCX[2] = true;
                    break;
                case 11:
                    this.aCX[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aBt != null) {
                            if (aVar2.aBt.getChosedFiles() != null) {
                                this.aCY[0] = aVar2.aBt.getChosedFiles().size();
                            } else {
                                this.aCY[0] = 0;
                            }
                        }
                        if (this.aCY[0] > 0) {
                            this.aCX[1] = true;
                            break;
                        } else {
                            this.aCX[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aCY;
                    iArr[0] = iArr[0] - 1;
                    if (this.aCY[0] > 0) {
                        this.aCX[1] = true;
                        break;
                    } else {
                        this.aCX[1] = false;
                        break;
                    }
                case 28:
                case d.n.View_filterTouchesWhenObscured /* 39 */:
                    this.aCX[3] = true;
                    break;
                case 29:
                    this.aCX[3] = false;
                    break;
            }
            eZ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JH != null) {
            this.JH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JG = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JG;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.aoN = i;
        if (isEnabled()) {
            aj.b(this, d.e.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eZ(int i) {
        if (i == ALL) {
            if (this.aCX[0] || this.aCX[1] || this.aCX[2] || this.aCX[3] || this.aCX[4]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.aoN);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        } else if (i == aCZ) {
            if (this.aCX[1]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.aoN);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }
}
