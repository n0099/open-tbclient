package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.editortools.i;
import com.baidu.tbadk.editortools.s;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements s {
    private int Lq;
    private i Lr;
    private boolean[] aED;
    private int[] aEE;
    private int aql;
    private int mType;
    public static int aEF = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aED = new boolean[]{false, false, false, false, false};
        this.aEE = new int[]{0, 0};
        this.aql = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(d.f.ds100));
        setHeight(context.getResources().getDimensionPixelSize(d.f.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.f.fontsize28));
        setTextColor(getContext().getResources().getColor(d.e.common_color_10050));
        setText(d.l.send_post);
        setBackgroundResource(d.g.btn_pb_editor_post_btn);
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
                        this.aED[0] = false;
                        break;
                    } else {
                        this.aED[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aED[0] = false;
                    this.aED[1] = false;
                    this.aED[2] = false;
                    this.aED[3] = false;
                    this.aED[4] = false;
                    this.aEE[0] = 0;
                    this.aEE[1] = 0;
                    break;
                case 10:
                    this.aED[2] = true;
                    break;
                case 11:
                    this.aED[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aDa != null) {
                            if (aVar2.aDa.getChosedFiles() != null) {
                                this.aEE[0] = aVar2.aDa.getChosedFiles().size();
                            } else {
                                this.aEE[0] = 0;
                            }
                        }
                        if (this.aEE[0] > 0) {
                            this.aED[1] = true;
                            break;
                        } else {
                            this.aED[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aEE;
                    iArr[0] = iArr[0] - 1;
                    if (this.aEE[0] > 0) {
                        this.aED[1] = true;
                        break;
                    } else {
                        this.aED[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aED[3] = true;
                    break;
                case 29:
                    this.aED[3] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.aED[4] = true;
                        break;
                    } else {
                        this.aED[4] = false;
                        break;
                    }
            }
            eP(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setEditorTools(i iVar) {
        this.Lr = iVar;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lr != null) {
            this.Lr.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.s
    public void setToolId(int i) {
        this.Lq = i;
    }

    @Override // com.baidu.tbadk.editortools.s
    public int getToolId() {
        return this.Lq;
    }

    @Override // com.baidu.tbadk.editortools.s
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void lT() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.s
    public void onChangeSkinType(int i) {
        this.aql = i;
        if (isEnabled()) {
            ai.b(this, d.e.cp_cont_f, 1, i);
        } else {
            ai.b(this, d.e.common_color_10050, 1, 0);
        }
        ai.d(this, d.g.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eP(int i) {
        if (i == ALL) {
            if (this.aED[0] || this.aED[1] || this.aED[2] || this.aED[3] || this.aED[4]) {
                setEnabled(true);
                ai.b(this, d.e.cp_cont_f, 1, this.aql);
                return;
            }
            setEnabled(false);
            ai.b(this, d.e.common_color_10050, 1, 0);
        } else if (i == aEF) {
            if (this.aED[1]) {
                setEnabled(true);
                ai.b(this, d.e.cp_cont_f, 1, this.aql);
                return;
            }
            setEnabled(false);
            ai.b(this, d.e.common_color_10050, 1, 0);
        }
    }
}
