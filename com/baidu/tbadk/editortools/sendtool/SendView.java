package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.x;
import com.baidu.tieba.i;
/* loaded from: classes.dex */
public class SendView extends TextView implements x {
    private int KA;
    private j KB;
    private boolean[] ard;
    private int[] are;
    private int arf;
    private int mType;
    public static int arg = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.ard = new boolean[5];
        this.are = new int[2];
        this.arf = 0;
        this.mType = ALL;
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
                        this.ard[0] = false;
                        break;
                    } else {
                        this.ard[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.ard[0] = false;
                    this.ard[1] = false;
                    this.ard[2] = false;
                    this.ard[3] = false;
                    this.ard[4] = false;
                    this.are[0] = 0;
                    this.are[1] = 0;
                    break;
                case 10:
                    this.ard[2] = true;
                    break;
                case 11:
                    this.ard[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.apG != null) {
                            if (aVar2.apG.getChosedFiles() != null) {
                                this.are[0] = aVar2.apG.getChosedFiles().size();
                            } else {
                                this.are[0] = 0;
                            }
                        }
                        if (this.are[0] > 0) {
                            this.ard[1] = true;
                            break;
                        } else {
                            this.ard[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.are;
                    iArr[0] = iArr[0] - 1;
                    if (this.are[0] > 0) {
                        this.ard[1] = true;
                        break;
                    } else {
                        this.ard[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.apG != null) {
                            if (aVar3.apG.getChosedFiles() != null) {
                                this.are[1] = aVar3.apG.getChosedFiles().size();
                            } else {
                                this.are[1] = 0;
                            }
                        }
                        if (this.are[1] > 0) {
                            this.ard[3] = true;
                            break;
                        } else {
                            this.ard[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.ard[3] = false;
                    break;
                case 28:
                    this.ard[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.ard[4] = false;
                    break;
            }
            ef(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setEditorTools(j jVar) {
        this.KB = jVar;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KB != null) {
            this.KB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.x
    public void setToolId(int i) {
        this.KA = i;
    }

    @Override // com.baidu.tbadk.editortools.x
    public int getToolId() {
        return this.KA;
    }

    @Override // com.baidu.tbadk.editortools.x
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void ox() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.x
    public void onChangeSkinType(int i) {
        this.arf = i;
        if (isEnabled()) {
            an.a(this, i.c.cp_cont_f, 1, i);
        } else {
            an.a(this, i.c.black_alpha40, 1, i);
        }
        an.c(this, i.e.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ef(int i) {
        if (i == ALL) {
            if (this.ard[0] || this.ard[1] || this.ard[2] || this.ard[3] || this.ard[4]) {
                setEnabled(true);
                an.a(this, i.c.cp_cont_f, 1, this.arf);
                return;
            }
            setEnabled(false);
            an.a(this, i.c.black_alpha40, 1, this.arf);
        } else if (i == arg) {
            if (this.ard[1]) {
                setEnabled(true);
                an.a(this, i.c.cp_cont_f, 1, this.arf);
                return;
            }
            setEnabled(false);
            an.a(this, i.c.black_alpha40, 1, this.arf);
        }
    }
}
