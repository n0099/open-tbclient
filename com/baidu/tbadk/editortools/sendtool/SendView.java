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
    private i axH;
    private int axI;
    private int bfC;
    private boolean[] buv;
    private int[] buw;
    private int mType;
    public static int bux = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.buv = new boolean[]{false, false, false, false, false};
        this.buw = new int[]{0, 0};
        this.bfC = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_e));
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
                        this.buv[0] = false;
                        break;
                    } else {
                        this.buv[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.buv[0] = false;
                    this.buv[1] = false;
                    this.buv[2] = false;
                    this.buv[3] = false;
                    this.buv[4] = false;
                    this.buw[0] = 0;
                    this.buw[1] = 0;
                    break;
                case 10:
                    this.buv[2] = true;
                    break;
                case 11:
                    this.buv[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.btl != null) {
                            if (aVar2.btl.getChosedFiles() != null) {
                                this.buw[0] = aVar2.btl.getChosedFiles().size();
                            } else {
                                this.buw[0] = 0;
                            }
                        }
                        if (this.buw[0] > 0) {
                            this.buv[1] = true;
                            break;
                        } else {
                            this.buv[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.buw;
                    iArr[0] = iArr[0] - 1;
                    if (this.buw[0] > 0) {
                        this.buv[1] = true;
                        break;
                    } else {
                        this.buv[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.buv[3] = true;
                    break;
                case 29:
                    this.buv[3] = false;
                    break;
            }
            hQ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axH = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axH != null) {
            this.axH.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axI = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axI;
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
        this.bfC = i;
        if (isEnabled()) {
            aj.b(this, d.C0141d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this, d.C0141d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hQ(int i) {
        if (i == ALL) {
            if (this.buv[0] || this.buv[1] || this.buv[2] || this.buv[3] || this.buv[4]) {
                setEnabled(true);
                aj.b(this, d.C0141d.cp_link_tip_a, 1, this.bfC);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0141d.cp_cont_e, 1);
        } else if (i == bux) {
            if (this.buv[1]) {
                setEnabled(true);
                aj.b(this, d.C0141d.cp_link_tip_a, 1, this.bfC);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0141d.cp_cont_e, 1);
        }
    }
}
