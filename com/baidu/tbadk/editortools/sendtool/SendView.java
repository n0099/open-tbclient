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
    private i axP;
    private int axQ;
    private int bfL;
    private boolean[] buF;
    private int[] buG;
    private int mType;
    public static int buH = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.buF = new boolean[]{false, false, false, false, false};
        this.buG = new int[]{0, 0};
        this.bfL = 0;
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
                        this.buF[0] = false;
                        break;
                    } else {
                        this.buF[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.buF[0] = false;
                    this.buF[1] = false;
                    this.buF[2] = false;
                    this.buF[3] = false;
                    this.buF[4] = false;
                    this.buG[0] = 0;
                    this.buG[1] = 0;
                    break;
                case 10:
                    this.buF[2] = true;
                    break;
                case 11:
                    this.buF[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.btw != null) {
                            if (aVar2.btw.getChosedFiles() != null) {
                                this.buG[0] = aVar2.btw.getChosedFiles().size();
                            } else {
                                this.buG[0] = 0;
                            }
                        }
                        if (this.buG[0] > 0) {
                            this.buF[1] = true;
                            break;
                        } else {
                            this.buF[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.buG;
                    iArr[0] = iArr[0] - 1;
                    if (this.buG[0] > 0) {
                        this.buF[1] = true;
                        break;
                    } else {
                        this.buF[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.buF[3] = true;
                    break;
                case 29:
                    this.buF[3] = false;
                    break;
            }
            hQ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axP = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axP != null) {
            this.axP.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axQ = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axQ;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void th() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.bfL = i;
        if (isEnabled()) {
            aj.b(this, d.C0140d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this, d.C0140d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hQ(int i) {
        if (i == ALL) {
            if (this.buF[0] || this.buF[1] || this.buF[2] || this.buF[3] || this.buF[4]) {
                setEnabled(true);
                aj.b(this, d.C0140d.cp_link_tip_a, 1, this.bfL);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0140d.cp_cont_e, 1);
        } else if (i == buH) {
            if (this.buF[1]) {
                setEnabled(true);
                aj.b(this, d.C0140d.cp_link_tip_a, 1, this.bfL);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0140d.cp_cont_e, 1);
        }
    }
}
