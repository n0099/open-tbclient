package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.j;
import com.baidu.tbadk.editortools.y;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class SendView extends TextView implements y {
    private int DW;
    private j DX;
    private int ahp;
    private boolean[] avL;
    private int[] avM;
    private int mType;
    public static int avN = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.avL = new boolean[5];
        this.avM = new int[2];
        this.ahp = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(r.f.ds100));
        setHeight(context.getResources().getDimensionPixelSize(r.f.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(r.f.fontsize28));
        setTextColor(getContext().getResources().getColor(r.e.common_color_10050));
        setText(r.l.send_post);
        setBackgroundResource(r.g.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.avL[0] = false;
                        break;
                    } else {
                        this.avL[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.avL[0] = false;
                    this.avL[1] = false;
                    this.avL[2] = false;
                    this.avL[3] = false;
                    this.avL[4] = false;
                    this.avM[0] = 0;
                    this.avM[1] = 0;
                    break;
                case 10:
                    this.avL[2] = true;
                    break;
                case 11:
                    this.avL[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.auj != null) {
                            if (aVar2.auj.getChosedFiles() != null) {
                                this.avM[0] = aVar2.auj.getChosedFiles().size();
                            } else {
                                this.avM[0] = 0;
                            }
                        }
                        if (this.avM[0] > 0) {
                            this.avL[1] = true;
                            break;
                        } else {
                            this.avL[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.avM;
                    iArr[0] = iArr[0] - 1;
                    if (this.avM[0] > 0) {
                        this.avL[1] = true;
                        break;
                    } else {
                        this.avL[1] = false;
                        break;
                    }
                case 28:
                case r.n.PullToRefresh_headerBackground /* 39 */:
                    this.avL[3] = true;
                    break;
                case 29:
                    this.avL[3] = false;
                    break;
                case r.n.PullToRefresh_headerTextColor /* 40 */:
                    if (aVar.data instanceof String) {
                        this.avL[4] = true;
                        break;
                    } else {
                        this.avL[4] = false;
                        break;
                    }
            }
            eO(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(j jVar) {
        this.DX = jVar;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.DX != null) {
            this.DX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.DW = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.DW;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lr() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.ahp = i;
        if (isEnabled()) {
            ap.b(this, r.e.cp_cont_f, 1, i);
        } else {
            ap.b(this, r.e.common_color_10050, 1, 0);
        }
        ap.d(this, r.g.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eO(int i) {
        if (i == ALL) {
            if (this.avL[0] || this.avL[1] || this.avL[2] || this.avL[3] || this.avL[4]) {
                setEnabled(true);
                ap.b(this, r.e.cp_cont_f, 1, this.ahp);
                return;
            }
            setEnabled(false);
            ap.b(this, r.e.common_color_10050, 1, 0);
        } else if (i == avN) {
            if (this.avL[1]) {
                setEnabled(true);
                ap.b(this, r.e.cp_cont_f, 1, this.ahp);
                return;
            }
            setEnabled(false);
            ap.b(this, r.e.common_color_10050, 1, 0);
        }
    }
}
