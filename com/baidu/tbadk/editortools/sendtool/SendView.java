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
    private EditorTools VN;
    private int VO;
    private int bUM;
    private boolean[] ckG;
    private int[] ckH;
    private int mType;
    public static int ckI = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.ckG = new boolean[]{false, false, false, false, false};
        this.ckH = new int[]{0, 0};
        this.bUM = 0;
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
                        this.ckG[0] = false;
                        break;
                    } else {
                        this.ckG[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.ckG[0] = false;
                    this.ckG[1] = false;
                    this.ckG[2] = false;
                    this.ckG[3] = false;
                    this.ckG[4] = false;
                    this.ckH[0] = 0;
                    this.ckH[1] = 0;
                    break;
                case 10:
                    this.ckG[2] = true;
                    break;
                case 11:
                    this.ckG[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cjw != null) {
                            if (aVar2.cjw.getChosedFiles() != null) {
                                this.ckH[0] = aVar2.cjw.getChosedFiles().size();
                            } else {
                                this.ckH[0] = 0;
                            }
                        }
                        if (this.ckH[0] > 0) {
                            this.ckG[1] = true;
                            break;
                        } else {
                            this.ckG[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ckH;
                    iArr[0] = iArr[0] - 1;
                    if (this.ckH[0] > 0) {
                        this.ckG[1] = true;
                        break;
                    } else {
                        this.ckG[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.ckG[3] = true;
                    break;
                case 29:
                    this.ckG[3] = false;
                    break;
            }
            jD(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.VN = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.VN != null) {
            this.VN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.VO = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.VO;
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
        this.bUM = i;
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
            if (this.ckG[0] || this.ckG[1] || this.ckG[2] || this.ckG[3] || this.ckG[4]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUM);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        } else if (i == ckI) {
            if (this.ckG[1]) {
                setEnabled(true);
                al.c(this, d.C0277d.cp_link_tip_a, 1, this.bUM);
                return;
            }
            setEnabled(false);
            al.d(this, d.C0277d.cp_cont_e, 1);
        }
    }
}
