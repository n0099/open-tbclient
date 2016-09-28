package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int EI;
    private l EJ;
    private int ahV;
    private boolean[] awr;
    private int[] aws;
    private int mType;
    public static int awt = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.awr = new boolean[6];
        this.aws = new int[2];
        this.ahV = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(r.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(r.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(r.e.fontsize28));
        setTextColor(getContext().getResources().getColor(r.d.common_color_10050));
        setText(r.j.send_post);
        setBackgroundResource(r.f.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.awr[0] = false;
                        break;
                    } else {
                        this.awr[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.awr[0] = false;
                    this.awr[1] = false;
                    this.awr[2] = false;
                    this.awr[3] = false;
                    this.awr[4] = false;
                    this.awr[5] = false;
                    this.aws[0] = 0;
                    this.aws[1] = 0;
                    break;
                case 10:
                    this.awr[2] = true;
                    break;
                case 11:
                    this.awr[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auN != null) {
                            if (aVar2.auN.getChosedFiles() != null) {
                                this.aws[0] = aVar2.auN.getChosedFiles().size();
                            } else {
                                this.aws[0] = 0;
                            }
                        }
                        if (this.aws[0] > 0) {
                            this.awr[1] = true;
                            break;
                        } else {
                            this.awr[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aws;
                    iArr[0] = iArr[0] - 1;
                    if (this.aws[0] > 0) {
                        this.awr[1] = true;
                        break;
                    } else {
                        this.awr[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.auN != null) {
                            if (aVar3.auN.getChosedFiles() != null) {
                                this.aws[1] = aVar3.auN.getChosedFiles().size();
                            } else {
                                this.aws[1] = 0;
                            }
                        }
                        if (this.aws[1] > 0) {
                            this.awr[3] = true;
                            break;
                        } else {
                            this.awr[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.awr[3] = false;
                    break;
                case 28:
                case r.l.PullToRefresh_headerBackground /* 39 */:
                    this.awr[4] = true;
                    break;
                case 29:
                    this.awr[4] = false;
                    break;
                case r.l.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.awr[5] = true;
                        break;
                    } else {
                        this.awr[5] = false;
                        break;
                    }
            }
            eJ(this.mType);
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
        this.ahV = i;
        if (isEnabled()) {
            av.b(this, r.d.cp_cont_f, 1, i);
        } else {
            av.b(this, r.d.common_color_10050, 1, 0);
        }
        av.d(this, r.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eJ(int i) {
        if (i == ALL) {
            if (this.awr[0] || this.awr[1] || this.awr[2] || this.awr[3] || this.awr[4] || this.awr[5]) {
                setEnabled(true);
                av.b(this, r.d.cp_cont_f, 1, this.ahV);
                return;
            }
            setEnabled(false);
            av.b(this, r.d.common_color_10050, 1, 0);
        } else if (i == awt) {
            if (this.awr[1]) {
                setEnabled(true);
                av.b(this, r.d.cp_cont_f, 1, this.ahV);
                return;
            }
            setEnabled(false);
            av.b(this, r.d.common_color_10050, 1, 0);
        }
    }
}
