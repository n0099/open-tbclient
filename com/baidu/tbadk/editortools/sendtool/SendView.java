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
    private int Lh;
    private k Li;
    private int ahf;
    private boolean[] auK;
    private int[] auL;
    private int mType;
    public static int auM = 1;
    public static int ALL = 0;

    public SendView(Context context) {
        super(context);
        this.auK = new boolean[5];
        this.auL = new int[2];
        this.ahf = 0;
        this.mType = ALL;
        setWidth(context.getResources().getDimensionPixelSize(n.e.ds100));
        setHeight(context.getResources().getDimensionPixelSize(n.e.ds88));
        setGravity(17);
        setIncludeFontPadding(false);
        setEnabled(false);
        setTextSize(0, context.getResources().getDimensionPixelSize(n.e.fontsize28));
        setTextColor(getContext().getResources().getColor(n.d.black_alpha40));
        setText(n.j.send_post);
        setBackgroundResource(n.f.btn_pb_editor_post_btn);
        setOnClickListener(new b(this));
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 4:
                    if (aVar.data == null || ((aVar.data instanceof String) && StringUtils.isNull((String) aVar.data))) {
                        this.auK[0] = false;
                        break;
                    } else {
                        this.auK[0] = true;
                        break;
                    }
                    break;
                case 9:
                    this.auK[0] = false;
                    this.auK[1] = false;
                    this.auK[2] = false;
                    this.auK[3] = false;
                    this.auK[4] = false;
                    this.auL[0] = 0;
                    this.auL[1] = 0;
                    break;
                case 10:
                    this.auK[2] = true;
                    break;
                case 11:
                    this.auK[2] = false;
                    break;
                case 12:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar2 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar2.ath != null) {
                            if (aVar2.ath.getChosedFiles() != null) {
                                this.auL[0] = aVar2.ath.getChosedFiles().size();
                            } else {
                                this.auL[0] = 0;
                            }
                        }
                        if (this.auL[0] > 0) {
                            this.auK[1] = true;
                            break;
                        } else {
                            this.auK[1] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 13:
                    int[] iArr = this.auL;
                    iArr[0] = iArr[0] - 1;
                    if (this.auL[0] > 0) {
                        this.auK[1] = true;
                        break;
                    } else {
                        this.auK[1] = false;
                        break;
                    }
                case 22:
                    if (aVar.data instanceof com.baidu.tbadk.editortools.imagetool.a) {
                        com.baidu.tbadk.editortools.imagetool.a aVar3 = (com.baidu.tbadk.editortools.imagetool.a) aVar.data;
                        if (aVar3.ath != null) {
                            if (aVar3.ath.getChosedFiles() != null) {
                                this.auL[1] = aVar3.ath.getChosedFiles().size();
                            } else {
                                this.auL[1] = 0;
                            }
                        }
                        if (this.auL[1] > 0) {
                            this.auK[3] = true;
                            break;
                        } else {
                            this.auK[3] = false;
                            break;
                        }
                    } else {
                        return;
                    }
                case 23:
                    this.auK[3] = false;
                    break;
                case 28:
                case 39:
                    this.auK[4] = true;
                    break;
                case DealIntentService.CLASS_TYPE_PUSH_RECOMMEND_PB /* 29 */:
                    this.auK[4] = false;
                    break;
            }
            en(this.mType);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(k kVar) {
        this.Li = kVar;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Li != null) {
            this.Li.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.Lh = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.Lh;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
        setClickable(false);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.ahf = i;
        if (isEnabled()) {
            as.a(this, n.d.cp_cont_f, 1, i);
        } else {
            as.a(this, n.d.black_alpha40, 1, i);
        }
        as.c(this, n.f.btn_pb_editor_post_btn, i);
    }

    public void setType(int i) {
        this.mType = i;
    }

    public void en(int i) {
        if (i == ALL) {
            if (this.auK[0] || this.auK[1] || this.auK[2] || this.auK[3] || this.auK[4]) {
                setEnabled(true);
                as.a(this, n.d.cp_cont_f, 1, this.ahf);
                return;
            }
            setEnabled(false);
            as.a(this, n.d.black_alpha40, 1, this.ahf);
        } else if (i == auM) {
            if (this.auK[1]) {
                setEnabled(true);
                as.a(this, n.d.cp_cont_f, 1, this.ahf);
                return;
            }
            setEnabled(false);
            as.a(this, n.d.black_alpha40, 1, this.ahf);
        }
    }
}
