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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.ab;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements ab, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int BU;
    private com.baidu.tbadk.editortools.l BV;
    private CustomMessageListener LV;
    private EmotionTabContentView aVT;
    private EmotionTabWidgetView aVU;
    private View aVV;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVW;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aVX;
    private String aVY;
    private boolean aVZ;
    private boolean aWa;
    private int aWb;
    private int aej;
    private int asz;

    public p(Context context) {
        super(context);
        this.aVW = new ArrayList<>();
        this.aVX = new ArrayList<>();
        this.asz = -1;
        this.aVY = null;
        this.aej = -1;
        this.aWa = true;
        this.aWb = 0;
        this.BU = 0;
        this.LV = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.emotion_tab_host, (ViewGroup) this, true);
        this.aVT = (EmotionTabContentView) findViewById(t.g.face_tab_content);
        this.aVU = (EmotionTabWidgetView) findViewById(t.g.face_tab_widget);
        this.aVV = findViewById(t.g.emotion_tab_widget_div_line);
        this.aVU.setOnTabSelectedListener(this);
        this.aVT.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aej = TbadkCoreApplication.m11getInst().getSkinType();
        onChangeSkinType(this.aej);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aVU != null) {
            this.aVU.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> LO() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.LY().Ma().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Bw() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aVW = x.LY().Ma();
        if (!this.aWa) {
            this.aVX = LO();
        } else {
            this.aVX = x.LY().Ma();
        }
        if ((this.aVW == null || this.aVW.size() <= 0) && this.aWb < 3) {
            this.aWb++;
            x.LY().LZ();
            return;
        }
        this.aVU.setDatas(this.aVW);
        int size = this.aVW.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVW.get(i2);
            if (this.aVY != null && this.aVY.equals(cVar.getGroupId())) {
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
        int skinType = TbadkCoreApplication.m11getInst().getSkinType();
        if (skinType != this.aej) {
            this.aej = skinType;
            onChangeSkinType(this.aej);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aVU.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aVX.size() && i != this.asz) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aVX.get(i);
            this.aVT.g(this.aVX, i);
            if (this.aVZ) {
                if (cVar.Bw() == EmotionGroupType.LOCAL) {
                    this.aVU.setShowDelete(true);
                } else {
                    this.aVU.setShowDelete(false);
                }
            }
            this.aVU.setCurrentTab(i);
            this.asz = i;
            this.aVY = cVar.getGroupId();
        }
    }

    public void reset() {
        this.asz = -1;
        this.aVW.clear();
        this.aVT.reset();
        this.aVU.reset();
    }

    public void setIsInChat(boolean z) {
        this.aVZ = z;
        this.aVU.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aWa = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ev(int i) {
        if (i >= 0 && i < this.aVW.size() && i != this.asz && this.aVT != null) {
            this.aVT.fA(i);
            this.asz = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.aVU.onChangeSkinType(i);
        this.aVT.onChangeSkinType(i);
        at.e(this.aVV, t.d.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void fB(int i) {
        if (this.aVU != null && i != this.asz) {
            this.aVU.setCurrentTab(i);
            this.asz = i;
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
        this.BV = lVar;
        this.aVT.setOnDataSelected(lVar);
        this.aVU.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.BV != null) {
            this.BV.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.BU = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.BU;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kC() {
        if (!this.aWa) {
            int size = this.aVW.size();
            for (int i = 0; i < size; i++) {
                this.aVU.k(i, this.aWa);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
