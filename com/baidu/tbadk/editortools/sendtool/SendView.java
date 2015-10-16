package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SendView extends TextView implements w {
    private j KA;
    private int Kz;
    private int apS;
    private int[] asA;
    private boolean[] asz;

    public SendView(Context context) {
        super(context);
        this.asz = new boolean[5];
        this.asA = new int[2];
        this.apS = 0;
        setWidth(context.getResources().getDimensionPixelSize(i.d.ds100));
        setHeight(context.getResources().getDimensionPixelSize(i.d.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(i.d.fontsize28));
        setTextColor(getContext().getResources().getColor(i.c.black_alpha40));
        setText(i.h.send_post);
        setBackgroundResource(i.e.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.asz[0] = false;
                        break;
                    } else {
                        this.asz[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.asz[0] = false;
                    this.asz[1] = false;
                    this.asz[2] = false;
                    this.asz[3] = false;
                    this.asz[4] = false;
                    this.asA[0] = 0;
                    this.asA[1] = 0;
                    break;
                case 10:
                    this.asz[2] = true;
                    break;
                case 11:
                    this.asz[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ard != null) {
                            if (aVar2.ard.getChosedFiles() != null) {
                                this.asA[0] = aVar2.ard.getChosedFiles().size();
                            } else {
                                this.asA[0] = 0;
                            }
                        }
                        if (this.asA[0] > 0) {
                            this.asz[1] = true;
                            break;
                        } else {
                            this.asz[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.asA;
                    iArr[0] = iArr[0] - 1;
                    if (this.asA[0] > 0) {
                        this.asz[1] = true;
                        break;
                    } else {
                        this.asz[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.ard != null) {
                            if (aVar3.ard.getChosedFiles() != null) {
                                this.asA[1] = aVar3.ard.getChosedFiles().size();
                            } else {
                                this.asA[1] = 0;
                            }
                        }
                        if (this.asA[1] > 0) {
                            this.asz[3] = true;
                            break;
                        } else {
                            this.asz[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.asz[3] = false;
                    break;
                case 28:
                    this.asz[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asz[4] = false;
                    break;
            }
            if (this.asz[0] || this.asz[1] || this.asz[2] || this.asz[3] || this.asz[4]) {
                setEnabled(true);
                an.a(this, i.c.cp_cont_f, 1, this.apS);
                return;
            }
            setEnabled(false);
            an.a(this, i.c.black_alpha40, 1, this.apS);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(j jVar) {
        this.KA = jVar;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Kz = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Kz;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.apS = i;
        if (isEnabled()) {
            an.a(this, i.c.cp_cont_f, 1, i);
        } else {
            an.a(this, i.c.black_alpha40, 1, i);
        }
        an.c(this, i.e.btn_pb_editor_post_btn, i);
    }
}
