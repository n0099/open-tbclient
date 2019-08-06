package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.l;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class SendView extends TextView implements l {
    private EditorTools TU;
    private int TV;
    private int cdS;
    private boolean[] cuk;
    private int[] cul;
    private int mType;
    public static int cum = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.cuk = new boolean[]{false, false, false, false, false};
        this.cul = new int[]{0, 0};
        this.cdS = 0;
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
                        this.cuk[0] = false;
                        break;
                    } else {
                        this.cuk[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.cuk[0] = false;
                    this.cuk[1] = false;
                    this.cuk[2] = false;
                    this.cuk[3] = false;
                    this.cuk[4] = false;
                    this.cul[0] = 0;
                    this.cul[1] = 0;
                    break;
                case 10:
                    this.cuk[2] = true;
                    break;
                case 11:
                    this.cuk[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.cta != null) {
                            if (aVar2.cta.getChosedFiles() != null) {
                                this.cul[0] = aVar2.cta.getChosedFiles().size();
                            } else {
                                this.cul[0] = 0;
                            }
                        }
                        if (this.cul[0] > 0) {
                            this.cuk[1] = true;
                            break;
                        } else {
                            this.cuk[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.cul;
                    iArr[0] = iArr[0] - 1;
                    if (this.cul[0] > 0) {
                        this.cuk[1] = true;
                        break;
                    } else {
                        this.cuk[1] = false;
                        break;
                    }
                case 28:
                case 39:
                    this.cuk[3] = true;
                    break;
                case 29:
                    this.cuk[3] = false;
                    break;
            }
            ky(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setEditorTools(EditorTools editorTools) {
        this.TU = editorTools;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.TU != null) {
            this.TU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.l
    public void setToolId(int i) {
        this.TV = i;
    }

    @Override // com.baidu.tbadk.editortools.l
    public int getToolId() {
        return this.TV;
    }

    @Override // com.baidu.tbadk.editortools.l
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void qk() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.l
    public void onChangeSkinType(int i) {
        this.cdS = i;
        if (isEnabled()) {
            am.d(this, R.color.cp_link_tip_a, 1, i);
        } else {
            am.f(this, R.color.cp_cont_e, 1);
        }
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void ky(int i) {
        if (i == ALL) {
            if (this.cuk[0] || this.cuk[1] || this.cuk[2] || this.cuk[3] || this.cuk[4]) {
                setEnabled(true);
                am.d(this, R.color.cp_link_tip_a, 1, this.cdS);
                return;
            }
            setEnabled(false);
            am.f(this, R.color.cp_cont_e, 1);
        } else if (i == cum) {
            if (this.cuk[1]) {
                setEnabled(true);
                am.d(this, R.color.cp_link_tip_a, 1, this.cdS);
                return;
            }
            setEnabled(false);
            am.f(this, R.color.cp_cont_e, 1);
        }
    }
}
