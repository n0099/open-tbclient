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
    private int KN;
    private j KO;
    private boolean[] aBy;
    private int[] aBz;
    private int amZ;
    private int mType;
    public static int aBA = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aBy = new boolean[5];
        this.aBz = new int[2];
        this.amZ = 0;
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
                        this.aBy[0] = false;
                        break;
                    } else {
                        this.aBy[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aBy[0] = false;
                    this.aBy[1] = false;
                    this.aBy[2] = false;
                    this.aBy[3] = false;
                    this.aBy[4] = false;
                    this.aBz[0] = 0;
                    this.aBz[1] = 0;
                    break;
                case 10:
                    this.aBy[2] = true;
                    break;
                case 11:
                    this.aBy[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.azW != null) {
                            if (aVar2.azW.getChosedFiles() != null) {
                                this.aBz[0] = aVar2.azW.getChosedFiles().size();
                            } else {
                                this.aBz[0] = 0;
                            }
                        }
                        if (this.aBz[0] > 0) {
                            this.aBy[1] = true;
                            break;
                        } else {
                            this.aBy[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aBz;
                    iArr[0] = iArr[0] - 1;
                    if (this.aBz[0] > 0) {
                        this.aBy[1] = true;
                        break;
                    } else {
                        this.aBy[1] = false;
                        break;
                    }
                case 28:
                case w.n.PullToRefresh_headerBackground /* 39 */:
                    this.aBy[3] = true;
                    break;
                case 29:
                    this.aBy[3] = false;
                    break;
                case w.n.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.aBy[4] = true;
                        break;
                    } else {
                        this.aBy[4] = false;
                        break;
                    }
            }
            eM(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.KO = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.amZ = i;
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

    public void eM(int i) {
        if (i == ALL) {
            if (this.aBy[0] || this.aBy[1] || this.aBy[2] || this.aBy[3] || this.aBy[4]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.amZ);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        } else if (i == aBA) {
            if (this.aBy[1]) {
                setEnabled(true);
                aq.b(this, w.e.cp_cont_f, 1, this.amZ);
                return;
            }
            setEnabled(false);
            aq.b(this, w.e.common_color_10050, 1, 0);
        }
    }
}
