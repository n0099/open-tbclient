package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendView extends TextView implements ab {
    private int EK;
    private l EL;
    private int aiA;
    private boolean[] axk;
    private int[] axl;
    private int mType;
    public static int axm = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.axk = new boolean[5];
        this.axl = new int[2];
        this.aiA = 0;
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
                        this.axk[0] = false;
                        break;
                    } else {
                        this.axk[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.axk[0] = false;
                    this.axk[1] = false;
                    this.axk[2] = false;
                    this.axk[3] = false;
                    this.axk[4] = false;
                    this.axl[0] = 0;
                    this.axl[1] = 0;
                    break;
                case 10:
                    this.axk[2] = true;
                    break;
                case 11:
                    this.axk[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.avH != null) {
                            if (aVar2.avH.getChosedFiles() != null) {
                                this.axl[0] = aVar2.avH.getChosedFiles().size();
                            } else {
                                this.axl[0] = 0;
                            }
                        }
                        if (this.axl[0] > 0) {
                            this.axk[1] = true;
                            break;
                        } else {
                            this.axk[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.axl;
                    iArr[0] = iArr[0] - 1;
                    if (this.axl[0] > 0) {
                        this.axk[1] = true;
                        break;
                    } else {
                        this.axk[1] = false;
                        break;
                    }
                case 28:
                case r.l.PullToRefresh_headerBackground /* 39 */:
                    this.axk[3] = true;
                    break;
                case 29:
                    this.axk[3] = false;
                    break;
                case r.l.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.axk[4] = true;
                        break;
                    } else {
                        this.axk[4] = false;
                        break;
                    }
            }
            eM(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(l lVar) {
        this.EL = lVar;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EL != null) {
            this.EL.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EK = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EK;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lz() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aiA = i;
        if (isEnabled()) {
            at.b(this, r.d.cp_cont_f, 1, i);
        } else {
            at.b(this, r.d.common_color_10050, 1, 0);
        }
        at.d(this, r.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eM(int i) {
        if (i == ALL) {
            if (this.axk[0] || this.axk[1] || this.axk[2] || this.axk[3] || this.axk[4]) {
                setEnabled(true);
                at.b(this, r.d.cp_cont_f, 1, this.aiA);
                return;
            }
            setEnabled(false);
            at.b(this, r.d.common_color_10050, 1, 0);
        } else if (i == axm) {
            if (this.axk[1]) {
                setEnabled(true);
                at.b(this, r.d.cp_cont_f, 1, this.aiA);
                return;
            }
            setEnabled(false);
            at.b(this, r.d.common_color_10050, 1, 0);
        }
    }
}
