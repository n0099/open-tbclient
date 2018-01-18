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
    private i axN;
    private int axO;
    private int bdK;
    private boolean[] bsj;
    private int[] bsk;
    private int mType;
    public static int bsl = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.bsj = new boolean[]{false, false, false, false, false};
        this.bsk = new int[]{0, 0};
        this.bdK = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0107d.cp_cont_e));
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
                        this.bsj[0] = false;
                        break;
                    } else {
                        this.bsj[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.bsj[0] = false;
                    this.bsj[1] = false;
                    this.bsj[2] = false;
                    this.bsj[3] = false;
                    this.bsj[4] = false;
                    this.bsk[0] = 0;
                    this.bsk[1] = 0;
                    break;
                case 10:
                    this.bsj[2] = true;
                    break;
                case 11:
                    this.bsj[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.bqZ != null) {
                            if (aVar2.bqZ.getChosedFiles() != null) {
                                this.bsk[0] = aVar2.bqZ.getChosedFiles().size();
                            } else {
                                this.bsk[0] = 0;
                            }
                        }
                        if (this.bsk[0] > 0) {
                            this.bsj[1] = true;
                            break;
                        } else {
                            this.bsj[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.bsk;
                    iArr[0] = iArr[0] - 1;
                    if (this.bsk[0] > 0) {
                        this.bsj[1] = true;
                        break;
                    } else {
                        this.bsj[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.bsj[3] = true;
                    break;
                case 29:
                    this.bsj[3] = false;
                    break;
            }
            hS(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.axN = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.axN != null) {
            this.axN.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.axO = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.axO;
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
        this.bdK = i;
        if (isEnabled()) {
            aj.b(this, d.C0107d.cp_link_tip_a, 1, i);
        } else {
            aj.e(this, d.C0107d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void hS(int i) {
        if (i == ALL) {
            if (this.bsj[0] || this.bsj[1] || this.bsj[2] || this.bsj[3] || this.bsj[4]) {
                setEnabled(true);
                aj.b(this, d.C0107d.cp_link_tip_a, 1, this.bdK);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0107d.cp_cont_e, 1);
        } else if (i == bsl) {
            if (this.bsj[1]) {
                setEnabled(true);
                aj.b(this, d.C0107d.cp_link_tip_a, 1, this.bdK);
                return;
            }
            setEnabled(false);
            aj.e(this, d.C0107d.cp_cont_e, 1);
        }
    }
}
