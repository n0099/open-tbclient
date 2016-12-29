package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendView extends TextView implements y {
    private int EL;
    private j EM;
    private int aib;
    private boolean[] awH;
    private int[] awI;
    private int mType;
    public static int awJ = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.awH = new boolean[5];
        this.awI = new int[2];
        this.aib = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(r.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(r.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(r.e.fontsize28));
        setTextColor(getContext().getResources().getColor(r.d.common_color_10050));
        setText(r.j.send_post);
        setBackgroundResource(r.f.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.awH[0] = false;
                        break;
                    } else {
                        this.awH[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.awH[0] = false;
                    this.awH[1] = false;
                    this.awH[2] = false;
                    this.awH[3] = false;
                    this.awH[4] = false;
                    this.awI[0] = 0;
                    this.awI[1] = 0;
                    break;
                case 10:
                    this.awH[2] = true;
                    break;
                case 11:
                    this.awH[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ave != null) {
                            if (aVar2.ave.getChosedFiles() != null) {
                                this.awI[0] = aVar2.ave.getChosedFiles().size();
                            } else {
                                this.awI[0] = 0;
                            }
                        }
                        if (this.awI[0] > 0) {
                            this.awH[1] = true;
                            break;
                        } else {
                            this.awH[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.awI;
                    iArr[0] = iArr[0] - 1;
                    if (this.awI[0] > 0) {
                        this.awH[1] = true;
                        break;
                    } else {
                        this.awH[1] = false;
                        break;
                    }
                case 28:
                case r.l.PullToRefresh_headerBackground /* 39 */:
                    this.awH[3] = true;
                    break;
                case 29:
                    this.awH[3] = false;
                    break;
                case r.l.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.awH[4] = true;
                        break;
                    } else {
                        this.awH[4] = false;
                        break;
                    }
            }
            eN(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.EM = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EM != null) {
            this.EM.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.EL = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.EL;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.aib = i;
        if (isEnabled()) {
            ar.b(this, r.d.cp_cont_f, 1, i);
        } else {
            ar.b(this, r.d.common_color_10050, 1, 0);
        }
        ar.d(this, r.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eN(int i) {
        if (i == ALL) {
            if (this.awH[0] || this.awH[1] || this.awH[2] || this.awH[3] || this.awH[4]) {
                setEnabled(true);
                ar.b(this, r.d.cp_cont_f, 1, this.aib);
                return;
            }
            setEnabled(false);
            ar.b(this, r.d.common_color_10050, 1, 0);
        } else if (i == awJ) {
            if (this.awH[1]) {
                setEnabled(true);
                ar.b(this, r.d.cp_cont_f, 1, this.aib);
                return;
            }
            setEnabled(false);
            ar.b(this, r.d.common_color_10050, 1, 0);
        }
    }
}
