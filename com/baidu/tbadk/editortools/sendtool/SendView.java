package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int LD;
    private l LE;
    private int aik;
    private boolean[] awd;
    private int[] awe;
    private int mType;
    public static int awf = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.awd = new boolean[6];
        this.awe = new int[2];
        this.aik = 0;
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
                        this.awd[0] = false;
                        break;
                    } else {
                        this.awd[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.awd[0] = false;
                    this.awd[1] = false;
                    this.awd[2] = false;
                    this.awd[3] = false;
                    this.awd[4] = false;
                    this.awd[5] = false;
                    this.awe[0] = 0;
                    this.awe[1] = 0;
                    break;
                case 10:
                    this.awd[2] = true;
                    break;
                case 11:
                    this.awd[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auz != null) {
                            if (aVar2.auz.getChosedFiles() != null) {
                                this.awe[0] = aVar2.auz.getChosedFiles().size();
                            } else {
                                this.awe[0] = 0;
                            }
                        }
                        if (this.awe[0] > 0) {
                            this.awd[1] = true;
                            break;
                        } else {
                            this.awd[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.awe;
                    iArr[0] = iArr[0] - 1;
                    if (this.awe[0] > 0) {
                        this.awd[1] = true;
                        break;
                    } else {
                        this.awd[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.auz != null) {
                            if (aVar3.auz.getChosedFiles() != null) {
                                this.awe[1] = aVar3.auz.getChosedFiles().size();
                            } else {
                                this.awe[1] = 0;
                            }
                        }
                        if (this.awe[1] > 0) {
                            this.awd[3] = true;
                            break;
                        } else {
                            this.awd[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.awd[3] = false;
                    break;
                case 28:
                case 39:
                    this.awd[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.awd[4] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.awd[5] = true;
                        break;
                    } else {
                        this.awd[5] = false;
                        break;
                    }
            }
            eM(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.LE = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.LE != null) {
            this.LE.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.LD = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.LD;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void op() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aik = i;
        if (isEnabled()) {
            at.a(this, t.d.cp_cont_f, 1, i);
        } else {
            at.a(this, t.d.black_alpha40, 1, i);
        }
        at.c(this, t.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eM(int i) {
        if (i == ALL) {
            if (this.awd[0] || this.awd[1] || this.awd[2] || this.awd[3] || this.awd[4] || this.awd[5]) {
                setEnabled(true);
                at.a(this, t.d.cp_cont_f, 1, this.aik);
                return;
            }
            setEnabled(false);
            at.a(this, t.d.black_alpha40, 1, this.aik);
        } else if (i == awf) {
            if (this.awd[1]) {
                setEnabled(true);
                at.a(this, t.d.cp_cont_f, 1, this.aik);
                return;
            }
            setEnabled(false);
            at.a(this, t.d.black_alpha40, 1, this.aik);
        }
    }
}
