package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class SendView extends TextView implements y {
    private int JT;
    private j JU;
    private boolean[] aBj;
    private int[] aBk;
    private int ana;
    private int mType;
    public static int aBl = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aBj = new boolean[5];
        this.aBk = new int[2];
        this.ana = 0;
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
                        this.aBj[0] = false;
                        break;
                    } else {
                        this.aBj[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aBj[0] = false;
                    this.aBj[1] = false;
                    this.aBj[2] = false;
                    this.aBj[3] = false;
                    this.aBj[4] = false;
                    this.aBk[0] = 0;
                    this.aBk[1] = 0;
                    break;
                case 10:
                    this.aBj[2] = true;
                    break;
                case 11:
                    this.aBj[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azG != null) {
                            if (aVar2.azG.getChosedFiles() != null) {
                                this.aBk[0] = aVar2.azG.getChosedFiles().size();
                            } else {
                                this.aBk[0] = 0;
                            }
                        }
                        if (this.aBk[0] > 0) {
                            this.aBj[1] = true;
                            break;
                        } else {
                            this.aBj[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aBk;
                    iArr[0] = iArr[0] - 1;
                    if (this.aBk[0] > 0) {
                        this.aBj[1] = true;
                        break;
                    } else {
                        this.aBj[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aBj[3] = true;
                    break;
                case 29:
                    this.aBj[3] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.aBj[4] = true;
                        break;
                    } else {
                        this.aBj[4] = false;
                        break;
                    }
            }
            eJ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.JU = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.ana = i;
        if (isEnabled()) {
            aq.b(this, w.e.cp_cont_f, 1, i);
        } else {
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
        aq.d(this, w.g.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eJ(int i) {
        if (i == ALL) {
            if (this.aBj[0] || this.aBj[1] || this.aBj[2] || this.aBj[3] || this.aBj[4]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.ana);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        } else if (i == aBl) {
            if (this.aBj[1]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.ana);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
    }
}
