package com.baidu.tbadk.editortools.sendtool;

import android.content.Context;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.coreExtra.service.DealIntentService;
import com.baidu.tbadk.editortools.k;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class SendView extends TextView implements z {
    private int KR;
    private k KS;
    private int afY;
    private boolean[] atg;
    private int[] ath;
    private int mType;
    public static int ati = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.atg = new boolean[5];
        this.ath = new int[2];
        this.afY = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(n.d.ds100));
        setHeight(context.getResources().getDimensionPixelSize(n.d.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(n.d.fontsize28));
        setTextColor(getContext().getResources().getColor(n.c.black_alpha40));
        setText(n.i.send_post);
        setBackgroundResource(n.e.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.atg[0] = false;
                        break;
                    } else {
                        this.atg[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.atg[0] = false;
                    this.atg[1] = false;
                    this.atg[2] = false;
                    this.atg[3] = false;
                    this.atg[4] = false;
                    this.ath[0] = 0;
                    this.ath[1] = 0;
                    break;
                case 10:
                    this.atg[2] = true;
                    break;
                case 11:
                    this.atg[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.arD != null) {
                            if (aVar2.arD.getChosedFiles() != null) {
                                this.ath[0] = aVar2.arD.getChosedFiles().size();
                            } else {
                                this.ath[0] = 0;
                            }
                        }
                        if (this.ath[0] > 0) {
                            this.atg[1] = true;
                            break;
                        } else {
                            this.atg[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.ath;
                    iArr[0] = iArr[0] - 1;
                    if (this.ath[0] > 0) {
                        this.atg[1] = true;
                        break;
                    } else {
                        this.atg[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.arD != null) {
                            if (aVar3.arD.getChosedFiles() != null) {
                                this.ath[1] = aVar3.arD.getChosedFiles().size();
                            } else {
                                this.ath[1] = 0;
                            }
                        }
                        if (this.ath[1] > 0) {
                            this.atg[3] = true;
                            break;
                        } else {
                            this.atg[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.atg[3] = false;
                    break;
                case 28:
                case 39:
                    this.atg[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.atg[4] = false;
                    break;
            }
            et(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.KS = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.afY = i;
        if (isEnabled()) {
            as.a(this, n.c.cp_cont_f, 1, i);
        } else {
            as.a(this, n.c.black_alpha40, 1, i);
        }
        as.c(this, n.e.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void et(int i) {
        if (i == ALL) {
            if (this.atg[0] || this.atg[1] || this.atg[2] || this.atg[3] || this.atg[4]) {
                setEnabled(true);
                as.a(this, n.c.cp_cont_f, 1, this.afY);
                return;
            }
            setEnabled(false);
            as.a(this, n.c.black_alpha40, 1, this.afY);
        } else if (i == ati) {
            if (this.atg[1]) {
                setEnabled(true);
                as.a(this, n.c.cp_cont_f, 1, this.afY);
                return;
            }
            setEnabled(false);
            as.a(this, n.c.black_alpha40, 1, this.afY);
        }
    }
}
