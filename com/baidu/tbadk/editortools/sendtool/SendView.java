package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SendView extends TextView implements w {
    private int Ky;
    private j Kz;
    private int apH;
    private boolean[] asr;
    private int[] ass;

    public SendView(Context context) {
        super(context);
        this.asr = new boolean[5];
        this.ass = new int[2];
        this.apH = 0;
        setWidth(context.getResources().getDimensionPixelSize(i.d.ds100));
        setHeight(context.getResources().getDimensionPixelSize(i.d.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize28));
        setTextColor(getContext().getResources().getColor(i.c.black_alpha40));
        setText(i.C0057i.send_post);
        setBackgroundResource(i.e.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.asr[0] = false;
                        break;
                    } else {
                        this.asr[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.asr[0] = false;
                    this.asr[1] = false;
                    this.asr[2] = false;
                    this.asr[3] = false;
                    this.asr[4] = false;
                    this.ass[0] = 0;
                    this.ass[1] = 0;
                    break;
                case 10:
                    this.asr[2] = true;
                    break;
                case 11:
                    this.asr[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aqW != null) {
                            if (aVar2.aqW.getChosedFiles() != null) {
                                this.ass[0] = aVar2.aqW.getChosedFiles().size();
                            } else {
                                this.ass[0] = 0;
                            }
                        }
                        if (this.ass[0] > 0) {
                            this.asr[1] = true;
                            break;
                        } else {
                            this.asr[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ass;
                    iArr[0] = iArr[0] - 1;
                    if (this.ass[0] > 0) {
                        this.asr[1] = true;
                        break;
                    } else {
                        this.asr[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.aqW != null) {
                            if (aVar3.aqW.getChosedFiles() != null) {
                                this.ass[1] = aVar3.aqW.getChosedFiles().size();
                            } else {
                                this.ass[1] = 0;
                            }
                        }
                        if (this.ass[1] > 0) {
                            this.asr[3] = true;
                            break;
                        } else {
                            this.asr[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.asr[3] = false;
                    break;
                case 28:
                    this.asr[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asr[4] = false;
                    break;
            }
            if (this.asr[0] || this.asr[1] || this.asr[2] || this.asr[3] || this.asr[4]) {
                setEnabled(true);
                al.a(this, i.c.cp_cont_f, 1, this.apH);
                return;
            }
            setEnabled(false);
            al.a(this, i.c.black_alpha40, 1, this.apH);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.Kz = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void oy() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.apH = i;
        if (isEnabled()) {
            al.a(this, i.c.cp_cont_f, 1, i);
        } else {
            al.a(this, i.c.black_alpha40, 1, i);
        }
        al.c(this, i.e.btn_pb_editor_post_btn, i);
    }
}
