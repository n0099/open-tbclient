package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class SendView extends TextView implements y {
    private int JS;
    private j JT;
    private boolean[] aCm;
    private int[] aCn;
    private int aoa;
    private int mType;
    public static int aCo = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aCm = new boolean[5];
        this.aCn = new int[2];
        this.aoa = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(w.f.ds100));
        setHeight(context.getResources().getDimensionPixelSize(w.f.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(w.f.fontsize28));
        setTextColor(getContext().getResources().getColor(w.e.common_color_10050));
        setText(w.l.send_post);
        setBackgroundResource(w.g.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aCm[0] = false;
                        break;
                    } else {
                        this.aCm[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aCm[0] = false;
                    this.aCm[1] = false;
                    this.aCm[2] = false;
                    this.aCm[3] = false;
                    this.aCm[4] = false;
                    this.aCn[0] = 0;
                    this.aCn[1] = 0;
                    break;
                case 10:
                    this.aCm[2] = true;
                    break;
                case 11:
                    this.aCm[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aAJ != null) {
                            if (aVar2.aAJ.getChosedFiles() != null) {
                                this.aCn[0] = aVar2.aAJ.getChosedFiles().size();
                            } else {
                                this.aCn[0] = 0;
                            }
                        }
                        if (this.aCn[0] > 0) {
                            this.aCm[1] = true;
                            break;
                        } else {
                            this.aCm[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aCn;
                    iArr[0] = iArr[0] - 1;
                    if (this.aCn[0] > 0) {
                        this.aCm[1] = true;
                        break;
                    } else {
                        this.aCm[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aCm[3] = true;
                    break;
                case 29:
                    this.aCm[3] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.aCm[4] = true;
                        break;
                    } else {
                        this.aCm[4] = false;
                        break;
                    }
            }
            eL(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JT = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.aoa = i;
        if (isEnabled()) {
            as.b(this, w.e.cp_cont_f, 1, i);
        } else {
            as.b(this, w.e.common_color_10050, 1, 0);
        }
        as.d(this, w.g.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eL(int i) {
        if (i == ALL) {
            if (this.aCm[0] || this.aCm[1] || this.aCm[2] || this.aCm[3] || this.aCm[4]) {
                setEnabled(true);
                as.b(this, w.e.cp_cont_f, 1, this.aoa);
                return;
            }
            setEnabled(false);
            as.b(this, w.e.common_color_10050, 1, 0);
        } else if (i == aCo) {
            if (this.aCm[1]) {
                setEnabled(true);
                as.b(this, w.e.cp_cont_f, 1, this.aoa);
                return;
            }
            setEnabled(false);
            as.b(this, w.e.common_color_10050, 1, 0);
        }
    }
}
