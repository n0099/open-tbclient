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
    private int Ja;
    private i Jb;
    private boolean[] aDP;
    private int[] aDQ;
    private int aph;
    private int mType;
    public static int aDR = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aDP = new boolean[]{false, false, false, false, false};
        this.aDQ = new int[]{0, 0};
        this.aph = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0080d.cp_cont_e));
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
                        this.aDP[0] = false;
                        break;
                    } else {
                        this.aDP[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aDP[0] = false;
                    this.aDP[1] = false;
                    this.aDP[2] = false;
                    this.aDP[3] = false;
                    this.aDP[4] = false;
                    this.aDQ[0] = 0;
                    this.aDQ[1] = 0;
                    break;
                case 10:
                    this.aDP[2] = true;
                    break;
                case 11:
                    this.aDP[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCk != null) {
                            if (aVar2.aCk.getChosedFiles() != null) {
                                this.aDQ[0] = aVar2.aCk.getChosedFiles().size();
                            } else {
                                this.aDQ[0] = 0;
                            }
                        }
                        if (this.aDQ[0] > 0) {
                            this.aDP[1] = true;
                            break;
                        } else {
                            this.aDP[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aDQ;
                    iArr[0] = iArr[0] - 1;
                    if (this.aDQ[0] > 0) {
                        this.aDP[1] = true;
                        break;
                    } else {
                        this.aDP[1] = false;
                        break;
                    }
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aDP[3] = true;
                    break;
                case 29:
                    this.aDP[3] = false;
                    break;
            }
            eZ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jb = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jb != null) {
            this.Jb.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Ja = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Ja;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lG() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.aph = i;
        if (isEnabled()) {
            aj.b(this, d.C0080d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.C0080d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eZ(int i) {
        if (i == ALL) {
            if (this.aDP[0] || this.aDP[1] || this.aDP[2] || this.aDP[3] || this.aDP[4]) {
                setEnabled(true);
                aj.b(this, d.C0080d.cp_link_tip_a, 1, this.aph);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0080d.cp_cont_e, 1);
        } else if (i == aDR) {
            if (this.aDP[1]) {
                setEnabled(true);
                aj.b(this, d.C0080d.cp_link_tip_a, 1, this.aph);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0080d.cp_cont_e, 1);
        }
    }
}
