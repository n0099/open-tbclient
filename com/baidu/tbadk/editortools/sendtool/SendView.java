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
    private int Cv;
    private l Cw;
    private int afy;
    private boolean[] atH;
    private int[] atI;
    private int mType;
    public static int atJ = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.atH = new boolean[6];
        this.atI = new int[2];
        this.afy = 0;
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
                        this.atH[0] = false;
                        break;
                    } else {
                        this.atH[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.atH[0] = false;
                    this.atH[1] = false;
                    this.atH[2] = false;
                    this.atH[3] = false;
                    this.atH[4] = false;
                    this.atH[5] = false;
                    this.atI[0] = 0;
                    this.atI[1] = 0;
                    break;
                case 10:
                    this.atH[2] = true;
                    break;
                case 11:
                    this.atH[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.asd != null) {
                            if (aVar2.asd.getChosedFiles() != null) {
                                this.atI[0] = aVar2.asd.getChosedFiles().size();
                            } else {
                                this.atI[0] = 0;
                            }
                        }
                        if (this.atI[0] > 0) {
                            this.atH[1] = true;
                            break;
                        } else {
                            this.atH[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.atI;
                    iArr[0] = iArr[0] - 1;
                    if (this.atI[0] > 0) {
                        this.atH[1] = true;
                        break;
                    } else {
                        this.atH[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.asd != null) {
                            if (aVar3.asd.getChosedFiles() != null) {
                                this.atI[1] = aVar3.asd.getChosedFiles().size();
                            } else {
                                this.atI[1] = 0;
                            }
                        }
                        if (this.atI[1] > 0) {
                            this.atH[3] = true;
                            break;
                        } else {
                            this.atH[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.atH[3] = false;
                    break;
                case 28:
                case u.l.PullToRefresh_headerBackground /* 39 */:
                    this.atH[4] = true;
                    break;
                case 29:
                    this.atH[4] = false;
                    break;
                case u.l.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.atH[5] = true;
                        break;
                    } else {
                        this.atH[5] = false;
                        break;
                    }
            }
            ew(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.Cw = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kB() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.afy = i;
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
            if (this.atH[0] || this.atH[1] || this.atH[2] || this.atH[3] || this.atH[4] || this.atH[5]) {
                setEnabled(true);
                av.b(this, u.d.cp_cont_f, 1, this.afy);
                return;
            }
            setEnabled(false);
            av.b(this, u.d.common_color_10050, 1, 0);
        } else if (i == atJ) {
            if (this.atH[1]) {
                setEnabled(true);
                av.b(this, u.d.cp_cont_f, 1, this.afy);
                return;
            }
            setEnabled(false);
            av.b(this, u.d.common_color_10050, 1, 0);
        }
    }
}
