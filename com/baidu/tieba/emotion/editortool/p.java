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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.u;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements ab, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int BV;
    private com.baidu.tbadk.editortools.l BW;
    private CustomMessageListener LV;
    private int aeK;
    private int atp;
    private EmotionTabContentView brA;
    private EmotionTabWidgetView brB;
    private View brC;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> brD;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> brE;
    private String brF;
    private boolean brG;
    private boolean brH;
    private int brI;

    public p(Context context) {
        super(context);
        this.brD = new ArrayList<>();
        this.brE = new ArrayList<>();
        this.atp = -1;
        this.brF = null;
        this.aeK = -1;
        this.brH = true;
        this.brI = 0;
        this.BV = 0;
        this.LV = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.emotion_tab_host, (ViewGroup) this, true);
        this.brA = (EmotionTabContentView) findViewById(u.g.face_tab_content);
        this.brB = (EmotionTabWidgetView) findViewById(u.g.face_tab_widget);
        this.brC = findViewById(u.g.emotion_tab_widget_div_line);
        this.brB.setOnTabSelectedListener(this);
        this.brA.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aeK = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.aeK);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.brB != null) {
            this.brB.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Rq() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.RA().RC().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.BF() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.brD = x.RA().RC();
        if (!this.brH) {
            this.brE = Rq();
        } else {
            this.brE = x.RA().RC();
        }
        if ((this.brD == null || this.brD.size() <= 0) && this.brI < 3) {
            this.brI++;
            x.RA().RB();
            return;
        }
        this.brB.setDatas(this.brD);
        int size = this.brD.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.brD.get(i2);
            if (this.brF != null && this.brF.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.LV);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.LV);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aeK) {
            this.aeK = skinType;
            onChangeSkinType(this.aeK);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.brB.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.brE.size() && i != this.atp) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.brE.get(i);
            this.brA.g(this.brE, i);
            if (this.brG) {
                if (cVar.BF() == EmotionGroupType.LOCAL) {
                    this.brB.setShowDelete(true);
                } else {
                    this.brB.setShowDelete(false);
                }
            }
            this.brB.setCurrentTab(i);
            this.atp = i;
            this.brF = cVar.getGroupId();
        }
    }

    public void reset() {
        this.atp = -1;
        this.brD.clear();
        this.brA.reset();
        this.brB.reset();
    }

    public void setIsInChat(boolean z) {
        this.brG = z;
        this.brB.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.brH = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eA(int i) {
        if (i >= 0 && i < this.brD.size() && i != this.atp && this.brA != null) {
            this.brA.gA(i);
            this.atp = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.brB.onChangeSkinType(i);
        this.brA.onChangeSkinType(i);
        av.e(this.brC, u.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void gB(int i) {
        if (this.brB != null && i != this.atp) {
            this.brB.setCurrentTab(i);
            this.atp = i;
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

    @Override // com.baidu.tbadk.editortools.ab
    public void setEditorTools(com.baidu.tbadk.editortools.l lVar) {
        this.BW = lVar;
        this.brA.setOnDataSelected(lVar);
        this.brB.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BW != null) {
            this.BW.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BV = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BV;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kF() {
        if (!this.brH) {
            int size = this.brD.size();
            for (int i = 0; i < size; i++) {
                this.brB.y(i, this.brH);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
