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
    private EditorTools TB;
    private int TC;
    private int ccI;
    private boolean[] csP;
    private int[] csQ;
    private int mType;
    public static int csR = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.csP = new boolean[]{false, false, false, false, false};
        this.csQ = new int[]{0, 0};
        this.ccI = 0;
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
                        this.csP[0] = false;
                        break;
                    } else {
                        this.csP[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.csP[0] = false;
                    this.csP[1] = false;
                    this.csP[2] = false;
                    this.csP[3] = false;
                    this.csP[4] = false;
                    this.csQ[0] = 0;
                    this.csQ[1] = 0;
                    break;
                case 10:
                    this.csP[2] = true;
                    break;
                case 11:
                    this.csP[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.crF != null) {
                            if (aVar2.crF.getChosedFiles() != null) {
                                this.csQ[0] = aVar2.crF.getChosedFiles().size();
                            } else {
                                this.csQ[0] = 0;
                            }
                        }
                        if (this.csQ[0] > 0) {
                            this.csP[1] = true;
                            break;
                        } else {
                            this.csP[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.csQ;
                    iArr[0] = iArr[0] - 1;
                    if (this.csQ[0] > 0) {
                        this.csP[1] = true;
                        break;
                    } else {
                        this.csP[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.csP[3] = true;
                    break;
                case 29:
                    this.csP[3] = false;
                    break;
            }
            kr(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TB = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TB != null) {
            this.TB.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TC = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TC;
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
        this.ccI = i;
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
            if (this.csP[0] || this.csP[1] || this.csP[2] || this.csP[3] || this.csP[4]) {
                setEnabled(true);
                al.c(this, R.color.cp_link_tip_a, 1, this.ccI);
                return;
            }
            setEnabled(false);
            al.f(this, R.color.cp_cont_e, 1);
        } else if (i == csR) {
            if (this.csP[1]) {
                setEnabled(true);
                al.c(this, R.color.cp_link_tip_a, 1, this.ccI);
                return;
            }
            setEnabled(false);
            al.f(this, R.color.cp_cont_e, 1);
        }
    }
}
