package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class SendView extends TextView implements n {
    private EditorTools acn;
    private int aco;
    private int aku;
    private boolean[] fwU;
    private int[] fwV;
    private int mType;
    public static int fwW = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.fwU = new boolean[]{false, false, false, false, false};
        this.fwV = new int[]{0, 0};
        this.aku = 0;
        this.mType = ALL;
        setPadding(context.getResources().getDimensionPixelSize(R.dimen.ds17), context.getResources().getDimensionPixelSize(R.dimen.ds28), context.getResources().getDimensionPixelSize(R.dimen.ds10), context.getResources().getDimensionPixelSize(R.dimen.ds28));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(R.dimen.fontsize28));
        setTextColor(getContext().getResources().getColor(R.color.CAM_X0110));
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
                        this.fwU[0] = false;
                        break;
                    } else {
                        this.fwU[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.fwU[0] = false;
                    this.fwU[1] = false;
                    this.fwU[2] = false;
                    this.fwU[3] = false;
                    this.fwU[4] = false;
                    this.fwV[0] = 0;
                    this.fwV[1] = 0;
                    break;
                case 10:
                    this.fwU[2] = true;
                    break;
                case 11:
                    this.fwU[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fvi != null) {
                            if (aVar2.fvi.getChosedFiles() != null) {
                                this.fwV[0] = aVar2.fvi.getChosedFiles().size();
                            } else {
                                this.fwV[0] = 0;
                            }
                        }
                        if (this.fwV[0] > 0) {
                            this.fwU[1] = true;
                            break;
                        } else {
                            this.fwU[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fwV;
                    iArr[0] = iArr[0] - 1;
                    if (this.fwV[0] > 0) {
                        this.fwU[1] = true;
                        break;
                    } else {
                        this.fwU[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.fwU[3] = true;
                    break;
                case 29:
                    this.fwU[3] = false;
                    break;
            }
            sv(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acn = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acn != null) {
            this.acn.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.aco = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.aco;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void su() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.aku = i;
        int color = ap.getColor(i, R.color.CAM_X0302);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.m(color, ap.eTL), c.m(color, ap.eTK), color}));
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void sv(int i) {
        if (i == ALL) {
            if (this.fwU[0] || this.fwU[1] || this.fwU[2] || this.fwU[3] || this.fwU[4]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        } else if (i == fwW) {
            if (this.fwU[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }
}
