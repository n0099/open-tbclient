package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements z, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int Lh;
    private com.baidu.tbadk.editortools.k Li;
    private CustomMessageListener Uk;
    private EmotionTabContentView aTb;
    private EmotionTabWidgetView aTc;
    private View aTd;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aTe;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aTf;
    private String aTg;
    private boolean aTh;
    private boolean aTi;
    private int aTj;
    private int ahf;
    private int auZ;

    public p(Context context) {
        super(context);
        this.aTe = new ArrayList<>();
        this.aTf = new ArrayList<>();
        this.auZ = -1;
        this.aTg = null;
        this.ahf = -1;
        this.aTi = true;
        this.aTj = 0;
        this.Lh = 0;
        this.Uk = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(n.h.emotion_tab_host, (ViewGroup) this, true);
        this.aTb = (EmotionTabContentView) findViewById(n.g.face_tab_content);
        this.aTc = (EmotionTabWidgetView) findViewById(n.g.face_tab_widget);
        this.aTd = findViewById(n.g.emotion_tab_widget_div_line);
        this.aTc.setOnTabSelectedListener(this);
        this.aTb.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ahf = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.ahf);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aTc != null) {
            this.aTc.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> JB() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.JL().JN().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.BC() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aTe = x.JL().JN();
        if (!this.aTi) {
            this.aTf = JB();
        } else {
            this.aTf = x.JL().JN();
        }
        if ((this.aTe == null || this.aTe.size() <= 0) && this.aTj < 3) {
            this.aTj++;
            x.JL().JM();
            return;
        }
        this.aTc.setDatas(this.aTe);
        int size = this.aTe.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aTe.get(i2);
            if (this.aTg != null && this.aTg.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Uk);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Uk);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.ahf) {
            this.ahf = skinType;
            onChangeSkinType(this.ahf);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aTc.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aTf.size() && i != this.auZ) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aTf.get(i);
            this.aTb.c(this.aTf, i);
            if (this.aTh) {
                if (cVar.BC() == EmotionGroupType.LOCAL) {
                    this.aTc.setShowDelete(true);
                } else {
                    this.aTc.setShowDelete(false);
                }
            }
            this.aTc.setCurrentTab(i);
            this.auZ = i;
            this.aTg = cVar.getGroupId();
        }
    }

    public void reset() {
        this.auZ = -1;
        this.aTe.clear();
        this.aTb.reset();
        this.aTc.reset();
    }

    public void setIsInChat(boolean z) {
        this.aTh = z;
        this.aTc.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aTi = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eq(int i) {
        if (i >= 0 && i < this.aTe.size() && i != this.auZ && this.aTb != null) {
            this.aTb.ff(i);
            this.auZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.aTc.onChangeSkinType(i);
        this.aTb.onChangeSkinType(i);
        as.d(this.aTd, n.d.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void fg(int i) {
        if (this.aTc != null && i != this.auZ) {
            this.aTc.setCurrentTab(i);
            this.auZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case 34:
                    if (aVar.data instanceof Integer) {
                        setFrom(((Integer) aVar.data).intValue());
                        return;
                    }
                    return;
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
                    if (aVar.data instanceof Boolean) {
                        setShowBigEmotion(((Boolean) aVar.data).booleanValue());
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.Li = kVar;
        this.aTb.setOnDataSelected(kVar);
        this.aTc.setOnDataSelected(kVar);
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
        setup();
    }

    @Override // com.baidu.tbadk.editortools.z
    public void ob() {
        if (!this.aTi) {
            int size = this.aTe.size();
            for (int i = 0; i < size; i++) {
                this.aTc.h(i, this.aTi);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }
}
