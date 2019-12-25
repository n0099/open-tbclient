package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.m;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.c;
/* loaded from: classes.dex */
public class SendView extends TextView implements m {
    private EditorTools Fq;
    private int Fr;
    private int MA;
    private boolean[] duu;
    private int[] duv;
    private int mType;
    public static int duw = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.duu = new boolean[]{false, false, false, false, false};
        this.duv = new int[]{0, 0};
        this.MA = 0;
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
                        this.duu[0] = false;
                        break;
                    } else {
                        this.duu[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.duu[0] = false;
                    this.duu[1] = false;
                    this.duu[2] = false;
                    this.duu[3] = false;
                    this.duu[4] = false;
                    this.duv[0] = 0;
                    this.duv[1] = 0;
                    break;
                case 10:
                    this.duu[2] = true;
                    break;
                case 11:
                    this.duu[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.dti != null) {
                            if (aVar2.dti.getChosedFiles() != null) {
                                this.duv[0] = aVar2.dti.getChosedFiles().size();
                            } else {
                                this.duv[0] = 0;
                            }
                        }
                        if (this.duv[0] > 0) {
                            this.duu[1] = true;
                            break;
                        } else {
                            this.duu[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.duv;
                    iArr[0] = iArr[0] - 1;
                    if (this.duv[0] > 0) {
                        this.duu[1] = true;
                        break;
                    } else {
                        this.duu[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.duu[3] = true;
                    break;
                case 29:
                    this.duu[3] = false;
                    break;
            }
            mf(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setEditorTools(EditorTools editorTools) {
        this.Fq = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Fq != null) {
            this.Fq.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.m
    public void setToolId(int i) {
        this.Fr = i;
    }

    @Override // com.baidu.tbadk.editortools.m
    public int getToolId() {
        return this.Fr;
    }

    @Override // com.baidu.tbadk.editortools.m
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void lw() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.m
    public void onChangeSkinType(int i) {
        this.MA = i;
        int color = am.getColor(R.color.cp_link_tip_a);
        setTextColor(new ColorStateList(new int[][]{new int[]{-16842910}, new int[]{16842910, 16842919}, new int[0]}, new int[]{c.n(color, 0.3f), c.n(color, 0.5f), color}));
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void mf(int i) {
        if (i == ALL) {
            if (this.duu[0] || this.duu[1] || this.duu[2] || this.duu[3] || this.duu[4]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        } else if (i == duw) {
            if (this.duu[1]) {
                setEnabled(true);
            } else {
                setEnabled(false);
            }
        }
    }
}
