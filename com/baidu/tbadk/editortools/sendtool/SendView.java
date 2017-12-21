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
    private i IS;
    private int IT;
    private boolean[] aEg;
    private int[] aEh;
    private int apG;
    private int mType;
    public static int aEi = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aEg = new boolean[]{false, false, false, false, false};
        this.aEh = new int[]{0, 0};
        this.apG = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0095d.cp_cont_e));
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
                        this.aEg[0] = false;
                        break;
                    } else {
                        this.aEg[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aEg[0] = false;
                    this.aEg[1] = false;
                    this.aEg[2] = false;
                    this.aEg[3] = false;
                    this.aEg[4] = false;
                    this.aEh[0] = 0;
                    this.aEh[1] = 0;
                    break;
                case 10:
                    this.aEg[2] = true;
                    break;
                case 11:
                    this.aEg[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCV != null) {
                            if (aVar2.aCV.getChosedFiles() != null) {
                                this.aEh[0] = aVar2.aCV.getChosedFiles().size();
                            } else {
                                this.aEh[0] = 0;
                            }
                        }
                        if (this.aEh[0] > 0) {
                            this.aEg[1] = true;
                            break;
                        } else {
                            this.aEg[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEh;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEh[0] > 0) {
                        this.aEg[1] = true;
                        break;
                    } else {
                        this.aEg[1] = false;
                        break;
                    }
                case 28:
                case d.l.View_filterTouchesWhenObscured /* 39 */:
                    this.aEg[3] = true;
                    break;
                case 29:
                    this.aEg[3] = false;
                    break;
            }
            eY(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.IS = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.IS != null) {
            this.IS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.IT = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.IT;
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
        this.apG = i;
        if (isEnabled()) {
            aj.b(this, d.C0095d.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.C0095d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eY(int i) {
        if (i == ALL) {
            if (this.aEg[0] || this.aEg[1] || this.aEg[2] || this.aEg[3] || this.aEg[4]) {
                setEnabled(true);
                aj.b(this, d.C0095d.cp_link_tip_a, 1, this.apG);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0095d.cp_cont_e, 1);
        } else if (i == aEi) {
            if (this.aEg[1]) {
                setEnabled(true);
                aj.b(this, d.C0095d.cp_link_tip_a, 1, this.apG);
                return;
            }
            setEnabled(false);
            aj.c(this, d.C0095d.cp_cont_e, 1);
        }
    }
}
