package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int BV;
    private l BW;
    private int aeK;
    private boolean[] asS;
    private int[] asT;
    private int mType;
    public static int asU = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.asS = new boolean[6];
        this.asT = new int[2];
        this.aeK = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(u.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(u.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(u.e.fontsize28));
        setTextColor(getContext().getResources().getColor(u.d.common_color_10050));
        setText(u.j.send_post);
        setBackgroundResource(u.f.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.asS[0] = false;
                        break;
                    } else {
                        this.asS[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.asS[0] = false;
                    this.asS[1] = false;
                    this.asS[2] = false;
                    this.asS[3] = false;
                    this.asS[4] = false;
                    this.asS[5] = false;
                    this.asT[0] = 0;
                    this.asT[1] = 0;
                    break;
                case 10:
                    this.asS[2] = true;
                    break;
                case 11:
                    this.asS[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aro != null) {
                            if (aVar2.aro.getChosedFiles() != null) {
                                this.asT[0] = aVar2.aro.getChosedFiles().size();
                            } else {
                                this.asT[0] = 0;
                            }
                        }
                        if (this.asT[0] > 0) {
                            this.asS[1] = true;
                            break;
                        } else {
                            this.asS[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.asT;
                    iArr[0] = iArr[0] - 1;
                    if (this.asT[0] > 0) {
                        this.asS[1] = true;
                        break;
                    } else {
                        this.asS[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.aro != null) {
                            if (aVar3.aro.getChosedFiles() != null) {
                                this.asT[1] = aVar3.aro.getChosedFiles().size();
                            } else {
                                this.asT[1] = 0;
                            }
                        }
                        if (this.asT[1] > 0) {
                            this.asS[3] = true;
                            break;
                        } else {
                            this.asS[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.asS[3] = false;
                    break;
                case 28:
                case 39:
                    this.asS[4] = true;
                    break;
                case 29:
                    this.asS[4] = false;
                    break;
                case 40:
                    if (aVar.data instanceof String) {
                        this.asS[5] = true;
                        break;
                    } else {
                        this.asS[5] = false;
                        break;
                    }
            }
            ew(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.BW = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kF() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aeK = i;
        if (isEnabled()) {
            av.b(this, u.d.cp_cont_f, 1, i);
        } else {
            av.b(this, u.d.common_color_10050, 1, 0);
        }
        av.d(this, u.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ew(int i) {
        if (i == ALL) {
            if (this.asS[0] || this.asS[1] || this.asS[2] || this.asS[3] || this.asS[4] || this.asS[5]) {
                setEnabled(true);
                av.b(this, u.d.cp_cont_f, 1, this.aeK);
                return;
            }
            setEnabled(false);
            av.b(this, u.d.common_color_10050, 1, 0);
        } else if (i == asU) {
            if (this.asS[1]) {
                setEnabled(true);
                av.b(this, u.d.cp_cont_f, 1, this.aeK);
                return;
            }
            setEnabled(false);
            av.b(this, u.d.common_color_10050, 1, 0);
        }
    }
}
