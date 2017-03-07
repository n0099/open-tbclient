package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int Lk;
    private com.baidu.tbadk.editortools.j Ll;
    private CustomMessageListener Sw;
    private int aBB;
    private int amL;
    private EmotionTabContentView bDd;
    private EmotionTabWidgetView bDe;
    private View bDf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDg;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bDh;
    private String bDi;
    private boolean bDj;
    private boolean bDk;
    private int bDl;

    public p(Context context) {
        super(context);
        this.bDg = new ArrayList<>();
        this.bDh = new ArrayList<>();
        this.aBB = -1;
        this.bDi = null;
        this.amL = -1;
        this.bDk = true;
        this.bDl = 0;
        this.Lk = 0;
        this.Sw = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bDd = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bDe = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bDf = findViewById(w.h.emotion_tab_widget_div_line);
        this.bDe.setOnTabSelectedListener(this);
        this.bDd.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.amL = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.amL);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bDe != null) {
            this.bDe.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> UJ() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.UT().UV().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.De() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bDg = x.UT().UV();
        if (!this.bDk) {
            this.bDh = UJ();
        } else {
            this.bDh = x.UT().UV();
        }
        if ((this.bDg == null || this.bDg.size() <= 0) && this.bDl < 3) {
            this.bDl++;
            x.UT().UU();
            return;
        }
        this.bDe.setDatas(this.bDg);
        int size = this.bDg.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bDg.get(i2);
            if (this.bDi != null && this.bDi.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Sw);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Sw);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amL) {
            this.amL = skinType;
            onChangeSkinType(this.amL);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bDe.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bDh.size() && i != this.aBB) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bDh.get(i);
            this.bDd.h(this.bDh, i);
            if (this.bDj) {
                if (cVar.De() == EmotionGroupType.LOCAL) {
                    this.bDe.setShowDelete(true);
                } else {
                    this.bDe.setShowDelete(false);
                }
            }
            this.bDe.setCurrentTab(i);
            this.aBB = i;
            this.bDi = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aBB = -1;
        this.bDg.clear();
        this.bDd.reset();
        this.bDe.reset();
    }

    public void setIsInChat(boolean z) {
        this.bDj = z;
        this.bDe.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bDk = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eN(int i) {
        if (i >= 0 && i < this.bDg.size() && i != this.aBB && this.bDd != null) {
            this.bDd.gZ(i);
            this.aBB = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bDe.onChangeSkinType(i);
        this.bDd.onChangeSkinType(i);
        aq.e(this.bDf, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void ha(int i) {
        if (this.bDe != null && i != this.aBB) {
            this.bDe.setCurrentTab(i);
            this.aBB = i;
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
                case 35:
                    if (aVar.data instanceof Boolean) {
                        boolean booleanValue = ((Boolean) aVar.data).booleanValue();
                        setShowBigEmotion(booleanValue);
                        if (!booleanValue) {
                            ArrayList arrayList = new ArrayList();
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bDh.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Dd()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bDd.h(arrayList, 0);
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Ll = jVar;
        this.bDd.setOnDataSelected(jVar);
        this.bDe.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Ll != null) {
            this.Ll.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.Lk = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.Lk;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void ml() {
        if (this.bDe != null) {
            int size = this.bDg.size();
            for (int i = 0; i < size; i++) {
                this.bDe.l(i, this.bDk);
            }
            this.bDe.setTabWidgetBigEmontionVisibility(this.bDk);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
