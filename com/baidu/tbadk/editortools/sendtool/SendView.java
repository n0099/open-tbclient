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
    private int arr;
    private boolean[] aub;
    private int[] auc;

    public SendView(Context context) {
        super(context);
        this.aub = new boolean[5];
        this.auc = new int[2];
        this.arr = 0;
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
                        this.aub[0] = false;
                        break;
                    } else {
                        this.aub[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aub[0] = false;
                    this.aub[1] = false;
                    this.aub[2] = false;
                    this.aub[3] = false;
                    this.aub[4] = false;
                    this.auc[0] = 0;
                    this.auc[1] = 0;
                    break;
                case 10:
                    this.aub[2] = true;
                    break;
                case 11:
                    this.aub[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.asG != null) {
                            if (aVar2.asG.getChosedFiles() != null) {
                                this.auc[0] = aVar2.asG.getChosedFiles().size();
                            } else {
                                this.auc[0] = 0;
                            }
                        }
                        if (this.auc[0] > 0) {
                            this.aub[1] = true;
                            break;
                        } else {
                            this.aub[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.auc;
                    iArr[0] = iArr[0] - 1;
                    if (this.auc[0] > 0) {
                        this.aub[1] = true;
                        break;
                    } else {
                        this.aub[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.asG != null) {
                            if (aVar3.asG.getChosedFiles() != null) {
                                this.auc[1] = aVar3.asG.getChosedFiles().size();
                            } else {
                                this.auc[1] = 0;
                            }
                        }
                        if (this.auc[1] > 0) {
                            this.aub[3] = true;
                            break;
                        } else {
                            this.aub[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.aub[3] = false;
                    break;
                case 28:
                    this.aub[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.aub[4] = false;
                    break;
            }
            if (this.aub[0] || this.aub[1] || this.aub[2] || this.aub[3] || this.aub[4]) {
                setEnabled(true);
                al.a(this, i.c.cp_cont_f, 1, this.arr);
                return;
            }
            setEnabled(false);
            al.a(this, i.c.black_alpha40, 1, this.arr);
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
    public void ov() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.arr = i;
        if (isEnabled()) {
            al.a(this, i.c.cp_cont_f, 1, i);
        } else {
            al.a(this, i.c.black_alpha40, 1, i);
        }
        al.c(this, i.e.btn_pb_editor_post_btn, i);
    }
}
