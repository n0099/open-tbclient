package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.d;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools Qh;
    private int Qi;
    private boolean[] aNq;
    private int[] aNr;
    private int ayX;
    private int mType;
    public static int aNs = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.aNq = new boolean[]{false, false, false, false, false};
        this.aNr = new int[]{0, 0};
        this.ayX = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(d.e.ds17), context.getResources().getDimensionPixelSize(d.e.ds28), context.getResources().getDimensionPixelSize(d.e.ds10), context.getResources().getDimensionPixelSize(d.e.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(d.e.fontsize28));
        setTextColor(getContext().getResources().getColor(d.C0141d.cp_cont_e));
        setText(d.k.send_post);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tbadk.editortools.sendtool.SendView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SendView.this.b(new com.baidu.tbadk.editortools.a(8, -1, null));
            }
        });
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.aNq[0] = false;
                        break;
                    } else {
                        this.aNq[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.aNq[0] = false;
                    this.aNq[1] = false;
                    this.aNq[2] = false;
                    this.aNq[3] = false;
                    this.aNq[4] = false;
                    this.aNr[0] = 0;
                    this.aNr[1] = 0;
                    break;
                case 10:
                    this.aNq[2] = true;
                    break;
                case 11:
                    this.aNq[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.aMi != null) {
                            if (aVar2.aMi.getChosedFiles() != null) {
                                this.aNr[0] = aVar2.aMi.getChosedFiles().size();
                            } else {
                                this.aNr[0] = 0;
                            }
                        }
                        if (this.aNr[0] > 0) {
                            this.aNq[1] = true;
                            break;
                        } else {
                            this.aNq[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.aNr;
                    iArr[0] = iArr[0] - 1;
                    if (this.aNr[0] > 0) {
                        this.aNq[1] = true;
                        break;
                    } else {
                        this.aNq[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.aNq[3] = true;
                    break;
                case 29:
                    this.aNq[3] = false;
                    break;
            }
            eU(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.Qh = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Qh != null) {
            this.Qh.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.Qi = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.Qi;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ayX = i;
        if (isEnabled()) {
            al.b(this, d.C0141d.cp_link_tip_a, 1, i);
        } else {
            al.c(this, d.C0141d.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void eU(int i) {
        if (i == ALL) {
            if (this.aNq[0] || this.aNq[1] || this.aNq[2] || this.aNq[3] || this.aNq[4]) {
                setEnabled(true);
                al.b(this, d.C0141d.cp_link_tip_a, 1, this.ayX);
                return;
            }
            setEnabled(false);
            al.c(this, d.C0141d.cp_cont_e, 1);
        } else if (i == aNs) {
            if (this.aNq[1]) {
                setEnabled(true);
                al.b(this, d.C0141d.cp_link_tip_a, 1, this.ayX);
                return;
            }
            setEnabled(false);
            al.c(this, d.C0141d.cp_cont_e, 1);
        }
    }
}
