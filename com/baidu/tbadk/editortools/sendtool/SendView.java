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
    private int Jo;
    private i Jp;
    private boolean[] aDW;
    private int[] aDX;
    private int apS;
    private int mType;
    public static int aDY = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aDW = new boolean[]{false, false, false, false, false};
        this.aDX = new int[]{0, 0};
        this.apS = 0;
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
                        this.aDW[0] = false;
                        break;
                    } else {
                        this.aDW[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aDW[0] = false;
                    this.aDW[1] = false;
                    this.aDW[2] = false;
                    this.aDW[3] = false;
                    this.aDW[4] = false;
                    this.aDX[0] = 0;
                    this.aDX[1] = 0;
                    break;
                case 10:
                    this.aDW[2] = true;
                    break;
                case 11:
                    this.aDW[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aCp != null) {
                            if (aVar2.aCp.getChosedFiles() != null) {
                                this.aDX[0] = aVar2.aCp.getChosedFiles().size();
                            } else {
                                this.aDX[0] = 0;
                            }
                        }
                        if (this.aDX[0] > 0) {
                            this.aDW[1] = true;
                            break;
                        } else {
                            this.aDW[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aDX;
                    iArr[0] = iArr[0] - 1;
                    if (this.aDX[0] > 0) {
                        this.aDW[1] = true;
                        break;
                    } else {
                        this.aDW[1] = false;
                        break;
                    }
                case 28:
                case d.n.View_filterTouchesWhenObscured /* 39 */:
                    this.aDW[3] = true;
                    break;
                case 29:
                    this.aDW[3] = false;
                    break;
                case d.n.View_drawingCacheQuality /* 40 */:
                    if (aVar.data instanceof String) {
                        this.aDW[4] = true;
                        break;
                    } else {
                        this.aDW[4] = false;
                        break;
                    }
            }
            eP(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Jp = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Jp != null) {
            this.Jp.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Jo = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Jo;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lK() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.apS = i;
        if (isEnabled()) {
            aj.b(this, d.e.cp_link_tip_a, 1, i);
        } else {
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eP(int i) {
        if (i == ALL) {
            if (this.aDW[0] || this.aDW[1] || this.aDW[2] || this.aDW[3] || this.aDW[4]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.apS);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        } else if (i == aDY) {
            if (this.aDW[1]) {
                setEnabled(true);
                aj.b(this, d.e.cp_link_tip_a, 1, this.apS);
                return;
            }
            setEnabled(false);
            aj.c(this, d.e.cp_cont_e, 1);
        }
    }
}
