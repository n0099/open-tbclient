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
    private int Kf;
    private j Kg;
    private boolean[] aBx;
    private int[] aBy;
    private int ane;
    private int mType;
    public static int aBz = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aBx = new boolean[5];
        this.aBy = new int[2];
        this.ane = 0;
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
                        this.aBx[0] = false;
                        break;
                    } else {
                        this.aBx[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aBx[0] = false;
                    this.aBx[1] = false;
                    this.aBx[2] = false;
                    this.aBx[3] = false;
                    this.aBx[4] = false;
                    this.aBy[0] = 0;
                    this.aBy[1] = 0;
                    break;
                case 10:
                    this.aBx[2] = true;
                    break;
                case 11:
                    this.aBx[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azU != null) {
                            if (aVar2.azU.getChosedFiles() != null) {
                                this.aBy[0] = aVar2.azU.getChosedFiles().size();
                            } else {
                                this.aBy[0] = 0;
                            }
                        }
                        if (this.aBy[0] > 0) {
                            this.aBx[1] = true;
                            break;
                        } else {
                            this.aBx[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aBy;
                    iArr[0] = iArr[0] - 1;
                    if (this.aBy[0] > 0) {
                        this.aBx[1] = true;
                        break;
                    } else {
                        this.aBx[1] = false;
                        break;
                    }
                case 28:
                case w.n.PullToRefresh_headerBackground /* 39 */:
                    this.aBx[3] = true;
                    break;
                case 29:
                    this.aBx[3] = false;
                    break;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.aBx[4] = true;
                        break;
                    } else {
                        this.aBx[4] = false;
                        break;
                    }
            }
            eI(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.Kg = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kg != null) {
            this.Kg.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Kf = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Kf;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lW() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.ane = i;
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

    public void eI(int i) {
        if (i == ALL) {
            if (this.aBx[0] || this.aBx[1] || this.aBx[2] || this.aBx[3] || this.aBx[4]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.ane);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        } else if (i == aBz) {
            if (this.aBx[1]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.ane);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
    }
}
