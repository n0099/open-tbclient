package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int BU;
    private l BV;
    private int aej;
    private boolean[] asc;
    private int[] asd;
    private int mType;
    public static int ase = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.asc = new boolean[6];
        this.asd = new int[2];
        this.aej = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(t.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(t.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize28));
        setTextColor(getContext().getResources().getColor(t.d.black_alpha40));
        setText(t.j.send_post);
        setBackgroundResource(t.f.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.asc[0] = false;
                        break;
                    } else {
                        this.asc[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.asc[0] = false;
                    this.asc[1] = false;
                    this.asc[2] = false;
                    this.asc[3] = false;
                    this.asc[4] = false;
                    this.asc[5] = false;
                    this.asd[0] = 0;
                    this.asd[1] = 0;
                    break;
                case 10:
                    this.asc[2] = true;
                    break;
                case 11:
                    this.asc[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aqy != null) {
                            if (aVar2.aqy.getChosedFiles() != null) {
                                this.asd[0] = aVar2.aqy.getChosedFiles().size();
                            } else {
                                this.asd[0] = 0;
                            }
                        }
                        if (this.asd[0] > 0) {
                            this.asc[1] = true;
                            break;
                        } else {
                            this.asc[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.asd;
                    iArr[0] = iArr[0] - 1;
                    if (this.asd[0] > 0) {
                        this.asc[1] = true;
                        break;
                    } else {
                        this.asc[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.aqy != null) {
                            if (aVar3.aqy.getChosedFiles() != null) {
                                this.asd[1] = aVar3.aqy.getChosedFiles().size();
                            } else {
                                this.asd[1] = 0;
                            }
                        }
                        if (this.asd[1] > 0) {
                            this.asc[3] = true;
                            break;
                        } else {
                            this.asc[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.asc[3] = false;
                    break;
                case 28:
                case 39:
                    this.asc[4] = true;
                    break;
                case 29:
                    this.asc[4] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.asc[5] = true;
                        break;
                    } else {
                        this.asc[5] = false;
                        break;
                    }
            }
            er(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BV = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aej = i;
        if (isEnabled()) {
            at.b(this, t.d.cp_cont_f, 1, i);
        } else {
            at.b(this, t.d.black_alpha40, 1, i);
        }
        at.d(this, t.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void er(int i) {
        if (i == ALL) {
            if (this.asc[0] || this.asc[1] || this.asc[2] || this.asc[3] || this.asc[4] || this.asc[5]) {
                setEnabled(true);
                at.b(this, t.d.cp_cont_f, 1, this.aej);
                return;
            }
            setEnabled(false);
            at.b(this, t.d.black_alpha40, 1, this.aej);
        } else if (i == ase) {
            if (this.asc[1]) {
                setEnabled(true);
                at.b(this, t.d.cp_cont_f, 1, this.aej);
                return;
            }
            setEnabled(false);
            at.b(this, t.d.black_alpha40, 1, this.aej);
        }
    }
}
