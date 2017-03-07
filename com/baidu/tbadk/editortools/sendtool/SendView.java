package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.w;
/* loaded from: classes.dex */
public class SendView extends TextView implements y {
    private int Lk;
    private j Ll;
    private boolean[] aBg;
    private int[] aBh;
    private int amL;
    private int mType;
    public static int aBi = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aBg = new boolean[5];
        this.aBh = new int[2];
        this.amL = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(w.f.ds100));
        setHeight(context.getResources().getDimensionPixelSize(w.f.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(w.f.fontsize28));
        setTextColor(getContext().getResources().getColor(w.e.common_color_10050));
        setText(w.l.send_post);
        setBackgroundResource(w.g.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aBg[0] = false;
                        break;
                    } else {
                        this.aBg[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aBg[0] = false;
                    this.aBg[1] = false;
                    this.aBg[2] = false;
                    this.aBg[3] = false;
                    this.aBg[4] = false;
                    this.aBh[0] = 0;
                    this.aBh[1] = 0;
                    break;
                case 10:
                    this.aBg[2] = true;
                    break;
                case 11:
                    this.aBg[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azE != null) {
                            if (aVar2.azE.getChosedFiles() != null) {
                                this.aBh[0] = aVar2.azE.getChosedFiles().size();
                            } else {
                                this.aBh[0] = 0;
                            }
                        }
                        if (this.aBh[0] > 0) {
                            this.aBg[1] = true;
                            break;
                        } else {
                            this.aBg[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aBh;
                    iArr[0] = iArr[0] - 1;
                    if (this.aBh[0] > 0) {
                        this.aBg[1] = true;
                        break;
                    } else {
                        this.aBg[1] = false;
                        break;
                    }
                case 28:
                case w.n.PullToRefresh_headerBackground /* 39 */:
                    this.aBg[3] = true;
                    break;
                case 29:
                    this.aBg[3] = false;
                    break;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.aBg[4] = true;
                        break;
                    } else {
                        this.aBg[4] = false;
                        break;
                    }
            }
            eJ(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Ll = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void ml() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.amL = i;
        if (isEnabled()) {
            aq.b(this, w.e.cp_cont_f, 1, i);
        } else {
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
        aq.d(this, w.g.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eJ(int i) {
        if (i == ALL) {
            if (this.aBg[0] || this.aBg[1] || this.aBg[2] || this.aBg[3] || this.aBg[4]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.amL);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        } else if (i == aBi) {
            if (this.aBg[1]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.amL);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
    }
}
