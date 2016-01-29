package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendView extends TextView implements z {
    private int Lw;
    private k Lx;
    private int ahU;
    private boolean[] avC;
    private int[] avD;
    private int mType;
    public static int avE = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.avC = new boolean[5];
        this.avD = new int[2];
        this.ahU = 0;
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
                        this.avC[0] = false;
                        break;
                    } else {
                        this.avC[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.avC[0] = false;
                    this.avC[1] = false;
                    this.avC[2] = false;
                    this.avC[3] = false;
                    this.avC[4] = false;
                    this.avD[0] = 0;
                    this.avD[1] = 0;
                    break;
                case 10:
                    this.avC[2] = true;
                    break;
                case 11:
                    this.avC[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.atZ != null) {
                            if (aVar2.atZ.getChosedFiles() != null) {
                                this.avD[0] = aVar2.atZ.getChosedFiles().size();
                            } else {
                                this.avD[0] = 0;
                            }
                        }
                        if (this.avD[0] > 0) {
                            this.avC[1] = true;
                            break;
                        } else {
                            this.avC[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.avD;
                    iArr[0] = iArr[0] - 1;
                    if (this.avD[0] > 0) {
                        this.avC[1] = true;
                        break;
                    } else {
                        this.avC[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.atZ != null) {
                            if (aVar3.atZ.getChosedFiles() != null) {
                                this.avD[1] = aVar3.atZ.getChosedFiles().size();
                            } else {
                                this.avD[1] = 0;
                            }
                        }
                        if (this.avD[1] > 0) {
                            this.avC[3] = true;
                            break;
                        } else {
                            this.avC[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.avC[3] = false;
                    break;
                case 28:
                case 39:
                    this.avC[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.avC[4] = false;
                    break;
            }
            eH(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Lx = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Lx != null) {
            this.Lx.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lw = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lw;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.ahU = i;
        if (isEnabled()) {
            ar.a(this, t.d.cp_cont_f, 1, i);
        } else {
            ar.a(this, t.d.black_alpha40, 1, i);
        }
        ar.c(this, t.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eH(int i) {
        if (i == ALL) {
            if (this.avC[0] || this.avC[1] || this.avC[2] || this.avC[3] || this.avC[4]) {
                setEnabled(true);
                ar.a(this, t.d.cp_cont_f, 1, this.ahU);
                return;
            }
            setEnabled(false);
            ar.a(this, t.d.black_alpha40, 1, this.ahU);
        } else if (i == avE) {
            if (this.avC[1]) {
                setEnabled(true);
                ar.a(this, t.d.cp_cont_f, 1, this.ahU);
                return;
            }
            setEnabled(false);
            ar.a(this, t.d.black_alpha40, 1, this.ahU);
        }
    }
}
