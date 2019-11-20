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
    private EditorTools CJ;
    private int CK;
    private boolean[] cGA;
    private int[] cGB;
    private int csg;
    private int mType;
    public static int cGC = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.cGA = new boolean[]{false, false, false, false, false};
        this.cGB = new int[]{0, 0};
        this.csg = 0;
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
                        this.cGA[0] = false;
                        break;
                    } else {
                        this.cGA[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.cGA[0] = false;
                    this.cGA[1] = false;
                    this.cGA[2] = false;
                    this.cGA[3] = false;
                    this.cGA[4] = false;
                    this.cGB[0] = 0;
                    this.cGB[1] = 0;
                    break;
                case 10:
                    this.cGA[2] = true;
                    break;
                case 11:
                    this.cGA[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cFo != null) {
                            if (aVar2.cFo.getChosedFiles() != null) {
                                this.cGB[0] = aVar2.cFo.getChosedFiles().size();
                            } else {
                                this.cGB[0] = 0;
                            }
                        }
                        if (this.cGB[0] > 0) {
                            this.cGA[1] = true;
                            break;
                        } else {
                            this.cGA[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cGB;
                    iArr[0] = iArr[0] - 1;
                    if (this.cGB[0] > 0) {
                        this.cGA[1] = true;
                        break;
                    } else {
                        this.cGA[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.cGA[3] = true;
                    break;
                case 29:
                    this.cGA[3] = false;
                    break;
            }
            jS(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.CJ = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.CJ != null) {
            this.CJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.CK = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.CK;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void le() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.csg = i;
        int color = am.getColor(R.color.cp_link_tip_a);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.k(color, 0.3f), c.k(color, 0.5f), color}));
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void jS(int i) {
        if (i == ALL) {
            if (this.cGA[0] || this.cGA[1] || this.cGA[2] || this.cGA[3] || this.cGA[4]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        } else if (i == cGC) {
            if (this.cGA[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }
}
