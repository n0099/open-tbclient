package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SendView extends TextView implements w {
    private int Ky;
    private j Kz;
    private int apR;
    private boolean[] asy;
    private int[] asz;

    public SendView(Context context) {
        super(context);
        this.asy = new boolean[5];
        this.asz = new int[2];
        this.apR = 0;
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
                        this.asy[0] = false;
                        break;
                    } else {
                        this.asy[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.asy[0] = false;
                    this.asy[1] = false;
                    this.asy[2] = false;
                    this.asy[3] = false;
                    this.asy[4] = false;
                    this.asz[0] = 0;
                    this.asz[1] = 0;
                    break;
                case 10:
                    this.asy[2] = true;
                    break;
                case 11:
                    this.asy[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.arc != null) {
                            if (aVar2.arc.getChosedFiles() != null) {
                                this.asz[0] = aVar2.arc.getChosedFiles().size();
                            } else {
                                this.asz[0] = 0;
                            }
                        }
                        if (this.asz[0] > 0) {
                            this.asy[1] = true;
                            break;
                        } else {
                            this.asy[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.asz;
                    iArr[0] = iArr[0] - 1;
                    if (this.asz[0] > 0) {
                        this.asy[1] = true;
                        break;
                    } else {
                        this.asy[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.arc != null) {
                            if (aVar3.arc.getChosedFiles() != null) {
                                this.asz[1] = aVar3.arc.getChosedFiles().size();
                            } else {
                                this.asz[1] = 0;
                            }
                        }
                        if (this.asz[1] > 0) {
                            this.asy[3] = true;
                            break;
                        } else {
                            this.asy[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.asy[3] = false;
                    break;
                case 28:
                    this.asy[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.asy[4] = false;
                    break;
            }
            if (this.asy[0] || this.asy[1] || this.asy[2] || this.asy[3] || this.asy[4]) {
                setEnabled(true);
                am.a(this, i.c.cp_cont_f, 1, this.apR);
                return;
            }
            setEnabled(false);
            am.a(this, i.c.black_alpha40, 1, this.apR);
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
    public void ow() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.apR = i;
        if (isEnabled()) {
            am.a(this, i.c.cp_cont_f, 1, i);
        } else {
            am.a(this, i.c.black_alpha40, 1, i);
        }
        am.c(this, i.e.btn_pb_editor_post_btn, i);
    }
}
