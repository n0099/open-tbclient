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
    private int JF;
    private i JG;
    private boolean[] aDk;
    private int[] aDl;
    private int aoZ;
    private int mType;
    public static int aDm = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aDk = new boolean[]{false, false, false, false, false};
        this.aDl = new int[]{0, 0};
        this.aoZ = 0;
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
                        this.aDk[0] = false;
                        break;
                    } else {
                        this.aDk[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aDk[0] = false;
                    this.aDk[1] = false;
                    this.aDk[2] = false;
                    this.aDk[3] = false;
                    this.aDk[4] = false;
                    this.aDl[0] = 0;
                    this.aDl[1] = 0;
                    break;
                case 10:
                    this.aDk[2] = true;
                    break;
                case 11:
                    this.aDk[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aBG != null) {
                            if (aVar2.aBG.getChosedFiles() != null) {
                                this.aDl[0] = aVar2.aBG.getChosedFiles().size();
                            } else {
                                this.aDl[0] = 0;
                            }
                        }
                        if (this.aDl[0] > 0) {
                            this.aDk[1] = true;
                            break;
                        } else {
                            this.aDk[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aDl;
                    iArr[0] = iArr[0] - 1;
                    if (this.aDl[0] > 0) {
                        this.aDk[1] = true;
                        break;
                    } else {
                        this.aDk[1] = false;
                        break;
                    }
                case 28:
                case d.n.View_filterTouchesWhenObscured /* 39 */:
                    this.aDk[3] = true;
                    break;
                case 29:
                    this.aDk[3] = false;
                    break;
            }
            fa(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.JG = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JG != null) {
            this.JG.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.JF = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.JF;
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
        this.aoZ = i;
        if (isEnabled()) {
            aj.b(this, d.e.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void fa(int i) {
        if (i == ALL) {
            if (this.aDk[0] || this.aDk[1] || this.aDk[2] || this.aDk[3] || this.aDk[4]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.aoZ);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        } else if (i == aDm) {
            if (this.aDk[1]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.aoZ);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }
}
