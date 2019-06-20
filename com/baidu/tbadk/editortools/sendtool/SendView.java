package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools TA;
    private int TB;
    private int ccJ;
    private boolean[] csQ;
    private int[] csR;
    private int mType;
    public static int csS = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.csQ = new boolean[]{false, false, false, false, false};
        this.csR = new int[]{0, 0};
        this.ccJ = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds17), context.getResources().getDimensionPixelSize(R.dimen.ds28), context.getResources().getDimensionPixelSize(R.dimen.ds10), context.getResources().getDimensionPixelSize(R.dimen.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        setTextColor(getContext().getResources().getColor(R.color.cp_cont_e));
        setText(R.string.send_post);
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
                        this.csQ[0] = false;
                        break;
                    } else {
                        this.csQ[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.csQ[0] = false;
                    this.csQ[1] = false;
                    this.csQ[2] = false;
                    this.csQ[3] = false;
                    this.csQ[4] = false;
                    this.csR[0] = 0;
                    this.csR[1] = 0;
                    break;
                case 10:
                    this.csQ[2] = true;
                    break;
                case 11:
                    this.csQ[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.crG != null) {
                            if (aVar2.crG.getChosedFiles() != null) {
                                this.csR[0] = aVar2.crG.getChosedFiles().size();
                            } else {
                                this.csR[0] = 0;
                            }
                        }
                        if (this.csR[0] > 0) {
                            this.csQ[1] = true;
                            break;
                        } else {
                            this.csQ[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.csR;
                    iArr[0] = iArr[0] - 1;
                    if (this.csR[0] > 0) {
                        this.csQ[1] = true;
                        break;
                    } else {
                        this.csQ[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.csQ[3] = true;
                    break;
                case 29:
                    this.csQ[3] = false;
                    break;
            }
            kr(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TA = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TA != null) {
            this.TA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TB = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TB;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void pO() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ccJ = i;
        if (isEnabled()) {
            al.c(this, R.color.cp_link_tip_a, 1, i);
        } else {
            al.f(this, R.color.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kr(int i) {
        if (i == ALL) {
            if (this.csQ[0] || this.csQ[1] || this.csQ[2] || this.csQ[3] || this.csQ[4]) {
                setEnabled(true);
                al.c(this, R.color.cp_link_tip_a, 1, this.ccJ);
                return;
            }
            setEnabled(false);
            al.f(this, R.color.cp_cont_e, 1);
        } else if (i == csS) {
            if (this.csQ[1]) {
                setEnabled(true);
                al.c(this, R.color.cp_link_tip_a, 1, this.ccJ);
                return;
            }
            setEnabled(false);
            al.f(this, R.color.cp_cont_e, 1);
        }
    }
}
