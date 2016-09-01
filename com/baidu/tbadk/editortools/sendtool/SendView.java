package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int EI;
    private l EJ;
    private int ait;
    private boolean[] awO;
    private int[] awP;
    private int mType;
    public static int awQ = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.awO = new boolean[6];
        this.awP = new int[2];
        this.ait = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(t.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(t.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(t.e.fontsize28));
        setTextColor(getContext().getResources().getColor(t.d.common_color_10050));
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
                        this.awO[0] = false;
                        break;
                    } else {
                        this.awO[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.awO[0] = false;
                    this.awO[1] = false;
                    this.awO[2] = false;
                    this.awO[3] = false;
                    this.awO[4] = false;
                    this.awO[5] = false;
                    this.awP[0] = 0;
                    this.awP[1] = 0;
                    break;
                case 10:
                    this.awO[2] = true;
                    break;
                case 11:
                    this.awO[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.avk != null) {
                            if (aVar2.avk.getChosedFiles() != null) {
                                this.awP[0] = aVar2.avk.getChosedFiles().size();
                            } else {
                                this.awP[0] = 0;
                            }
                        }
                        if (this.awP[0] > 0) {
                            this.awO[1] = true;
                            break;
                        } else {
                            this.awO[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.awP;
                    iArr[0] = iArr[0] - 1;
                    if (this.awP[0] > 0) {
                        this.awO[1] = true;
                        break;
                    } else {
                        this.awO[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.avk != null) {
                            if (aVar3.avk.getChosedFiles() != null) {
                                this.awP[1] = aVar3.avk.getChosedFiles().size();
                            } else {
                                this.awP[1] = 0;
                            }
                        }
                        if (this.awP[1] > 0) {
                            this.awO[3] = true;
                            break;
                        } else {
                            this.awO[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.awO[3] = false;
                    break;
                case 28:
                case t.l.PullToRefresh_headerBackground /* 39 */:
                    this.awO[4] = true;
                    break;
                case 29:
                    this.awO[4] = false;
                    break;
                case t.l.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.awO[5] = true;
                        break;
                    } else {
                        this.awO[5] = false;
                        break;
                    }
            }
            eK(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EJ = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.ait = i;
        if (isEnabled()) {
            av.b(this, t.d.cp_cont_f, 1, i);
        } else {
            av.b(this, t.d.common_color_10050, 1, 0);
        }
        av.d(this, t.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eK(int i) {
        if (i == ALL) {
            if (this.awO[0] || this.awO[1] || this.awO[2] || this.awO[3] || this.awO[4] || this.awO[5]) {
                setEnabled(true);
                av.b(this, t.d.cp_cont_f, 1, this.ait);
                return;
            }
            setEnabled(false);
            av.b(this, t.d.common_color_10050, 1, 0);
        } else if (i == awQ) {
            if (this.awO[1]) {
                setEnabled(true);
                av.b(this, t.d.cp_cont_f, 1, this.ait);
                return;
            }
            setEnabled(false);
            av.b(this, t.d.common_color_10050, 1, 0);
        }
    }
}
