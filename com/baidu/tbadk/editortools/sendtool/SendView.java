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
    private EditorTools VO;
    private int VP;
    private int bUN;
    private boolean[] ckH;
    private int[] ckI;
    private int mType;
    public static int ckJ = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.ckH = new boolean[]{false, false, false, false, false};
        this.ckI = new int[]{0, 0};
        this.bUN = 0;
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
                        this.ckH[0] = false;
                        break;
                    } else {
                        this.ckH[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.ckH[0] = false;
                    this.ckH[1] = false;
                    this.ckH[2] = false;
                    this.ckH[3] = false;
                    this.ckH[4] = false;
                    this.ckI[0] = 0;
                    this.ckI[1] = 0;
                    break;
                case 10:
                    this.ckH[2] = true;
                    break;
                case 11:
                    this.ckH[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cjx != null) {
                            if (aVar2.cjx.getChosedFiles() != null) {
                                this.ckI[0] = aVar2.cjx.getChosedFiles().size();
                            } else {
                                this.ckI[0] = 0;
                            }
                        }
                        if (this.ckI[0] > 0) {
                            this.ckH[1] = true;
                            break;
                        } else {
                            this.ckH[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckI;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckI[0] > 0) {
                        this.ckH[1] = true;
                        break;
                    } else {
                        this.ckH[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.ckH[3] = true;
                    break;
                case 29:
                    this.ckH[3] = false;
                    break;
            }
            jD(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VO = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VO != null) {
            this.VO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VP = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VP;
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
        this.bUN = i;
        if (isEnabled()) {
            al.c(this, d.C0277d.cp_link_tip_a, 1, i);
        } else {
            al.d(this, d.C0277d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jD(int i) {
        if (i == ALL) {
            if (this.ckH[0] || this.ckH[1] || this.ckH[2] || this.ckH[3] || this.ckH[4]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUN);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        } else if (i == ckJ) {
            if (this.ckH[1]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUN);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        }
    }
}
