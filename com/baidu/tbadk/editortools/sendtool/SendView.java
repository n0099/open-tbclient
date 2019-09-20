package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools TT;
    private int TU;
    private int ceL;
    private boolean[] cvh;
    private int[] cvi;
    private int mType;
    public static int cvj = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.cvh = new boolean[]{false, false, false, false, false};
        this.cvi = new int[]{0, 0};
        this.ceL = 0;
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
                        this.cvh[0] = false;
                        break;
                    } else {
                        this.cvh[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.cvh[0] = false;
                    this.cvh[1] = false;
                    this.cvh[2] = false;
                    this.cvh[3] = false;
                    this.cvh[4] = false;
                    this.cvi[0] = 0;
                    this.cvi[1] = 0;
                    break;
                case 10:
                    this.cvh[2] = true;
                    break;
                case 11:
                    this.cvh[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ctW != null) {
                            if (aVar2.ctW.getChosedFiles() != null) {
                                this.cvi[0] = aVar2.ctW.getChosedFiles().size();
                            } else {
                                this.cvi[0] = 0;
                            }
                        }
                        if (this.cvi[0] > 0) {
                            this.cvh[1] = true;
                            break;
                        } else {
                            this.cvh[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cvi;
                    iArr[0] = iArr[0] - 1;
                    if (this.cvi[0] > 0) {
                        this.cvh[1] = true;
                        break;
                    } else {
                        this.cvh[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.cvh[3] = true;
                    break;
                case 29:
                    this.cvh[3] = false;
                    break;
            }
            kB(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TT = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TT != null) {
            this.TT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TU = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TU;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void ql() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.ceL = i;
        int color = am.getColor(R.color.cp_link_tip_a);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.j(color, 0.3f), c.j(color, 0.5f), color}));
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void kB(int i) {
        if (i == ALL) {
            if (this.cvh[0] || this.cvh[1] || this.cvh[2] || this.cvh[3] || this.cvh[4]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        } else if (i == cvj) {
            if (this.cvh[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }
}
