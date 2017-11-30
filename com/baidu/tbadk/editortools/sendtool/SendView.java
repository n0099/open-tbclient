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
    private i IT;
    private int IU;
    private boolean[] aDY;
    private int[] aDZ;
    private int apA;
    private int mType;
    public static int aEa = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aDY = new boolean[]{false, false, false, false, false};
        this.aDZ = new int[]{0, 0};
        this.apA = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0082d.cp_cont_e));
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
                        this.aDY[0] = false;
                        break;
                    } else {
                        this.aDY[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aDY[0] = false;
                    this.aDY[1] = false;
                    this.aDY[2] = false;
                    this.aDY[3] = false;
                    this.aDY[4] = false;
                    this.aDZ[0] = 0;
                    this.aDZ[1] = 0;
                    break;
                case 10:
                    this.aDY[2] = true;
                    break;
                case 11:
                    this.aDY[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCN != null) {
                            if (aVar2.aCN.getChosedFiles() != null) {
                                this.aDZ[0] = aVar2.aCN.getChosedFiles().size();
                            } else {
                                this.aDZ[0] = 0;
                            }
                        }
                        if (this.aDZ[0] > 0) {
                            this.aDY[1] = true;
                            break;
                        } else {
                            this.aDY[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aDZ;
                    iArr[0] = iArr[0] - 1;
                    if (this.aDZ[0] > 0) {
                        this.aDY[1] = true;
                        break;
                    } else {
                        this.aDY[1] = false;
                        break;
                    }
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aDY[3] = true;
                    break;
                case 29:
                    this.aDY[3] = false;
                    break;
            }
            eY(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IT = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IT != null) {
            this.IT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IU = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IU;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lE() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.apA = i;
        if (isEnabled()) {
            aj.b(this, d.C0082d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.C0082d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eY(int i) {
        if (i == ALL) {
            if (this.aDY[0] || this.aDY[1] || this.aDY[2] || this.aDY[3] || this.aDY[4]) {
                setEnabled(true);
                aj.b(this, d.C0082d.cp_link_tip_a, 1, this.apA);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0082d.cp_cont_e, 1);
        } else if (i == aEa) {
            if (this.aDY[1]) {
                setEnabled(true);
                aj.b(this, d.C0082d.cp_link_tip_a, 1, this.apA);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0082d.cp_cont_e, 1);
        }
    }
}
