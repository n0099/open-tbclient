package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.n;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class SendView extends TextView implements n {
    private EditorTools acX;
    private int acY;
    private int akf;
    private boolean[] fBT;
    private int[] fBU;
    private int mType;
    public static int fBV = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.fBT = new boolean[]{false, false, false, false, false};
        this.fBU = new int[]{0, 0};
        this.akf = 0;
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
                        this.fBT[0] = false;
                        break;
                    } else {
                        this.fBT[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.fBT[0] = false;
                    this.fBT[1] = false;
                    this.fBT[2] = false;
                    this.fBT[3] = false;
                    this.fBT[4] = false;
                    this.fBU[0] = 0;
                    this.fBU[1] = 0;
                    break;
                case 10:
                    this.fBT[2] = true;
                    break;
                case 11:
                    this.fBT[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.fAg != null) {
                            if (aVar2.fAg.getChosedFiles() != null) {
                                this.fBU[0] = aVar2.fAg.getChosedFiles().size();
                            } else {
                                this.fBU[0] = 0;
                            }
                        }
                        if (this.fBU[0] > 0) {
                            this.fBT[1] = true;
                            break;
                        } else {
                            this.fBT[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.fBU;
                    iArr[0] = iArr[0] - 1;
                    if (this.fBU[0] > 0) {
                        this.fBT[1] = true;
                        break;
                    } else {
                        this.fBT[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.fBT[3] = true;
                    break;
                case 29:
                    this.fBT[3] = false;
                    break;
            }
            rb(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setEditorTools(EditorTools editorTools) {
        this.acX = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.acX != null) {
            this.acX.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.n
    public void setToolId(int i) {
        this.acY = i;
    }

    @Override // com.baidu.tbadk.editortools.n
    public int getToolId() {
        return this.acY;
    }

    @Override // com.baidu.tbadk.editortools.n
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void rV() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.n
    public void onChangeSkinType(int i) {
        this.akf = i;
        int color = ao.getColor(i, R.color.CAM_X0302);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.m(color, ao.eYz), c.m(color, ao.eYy), color}));
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void rb(int i) {
        if (i == ALL) {
            if (this.fBT[0] || this.fBT[1] || this.fBT[2] || this.fBT[3] || this.fBT[4]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        } else if (i == fBV) {
            if (this.fBT[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }
}
