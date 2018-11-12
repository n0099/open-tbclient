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
    private int aIf;
    private boolean[] aWR;
    private int[] aWS;
    private int mType;
    public static int aWT = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aWR = new boolean[]{false, false, false, false, false};
        this.aWS = new int[]{0, 0};
        this.aIf = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(e.C0200e.ds17), context.getResources().getDimensionPixelSize(e.C0200e.ds28), context.getResources().getDimensionPixelSize(e.C0200e.ds10), context.getResources().getDimensionPixelSize(e.C0200e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(e.C0200e.fontsize28));
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
                        this.aWR[0] = false;
                        break;
                    } else {
                        this.aWR[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aWR[0] = false;
                    this.aWR[1] = false;
                    this.aWR[2] = false;
                    this.aWR[3] = false;
                    this.aWR[4] = false;
                    this.aWS[0] = 0;
                    this.aWS[1] = 0;
                    break;
                case 10:
                    this.aWR[2] = true;
                    break;
                case 11:
                    this.aWR[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aVK != null) {
                            if (aVar2.aVK.getChosedFiles() != null) {
                                this.aWS[0] = aVar2.aVK.getChosedFiles().size();
                            } else {
                                this.aWS[0] = 0;
                            }
                        }
                        if (this.aWS[0] > 0) {
                            this.aWR[1] = true;
                            break;
                        } else {
                            this.aWR[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aWS;
                    iArr[0] = iArr[0] - 1;
                    if (this.aWS[0] > 0) {
                        this.aWR[1] = true;
                        break;
                    } else {
                        this.aWR[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aWR[3] = true;
                    break;
                case 29:
                    this.aWR[3] = false;
                    break;
            }
            fE(this.mType);
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
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.aIf = i;
        if (isEnabled()) {
            al.b(this, e.d.cp_link_tip_a, 1, i);
        } else {
            al.c(this, e.d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fE(int i) {
        if (i == ALL) {
            if (this.aWR[0] || this.aWR[1] || this.aWR[2] || this.aWR[3] || this.aWR[4]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aIf);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        } else if (i == aWT) {
            if (this.aWR[1]) {
                setEnabled(true);
                al.b(this, e.d.cp_link_tip_a, 1, this.aIf);
                return;
            }
            setEnabled(false);
            al.c(this, e.d.cp_cont_e, 1);
        }
    }
}
