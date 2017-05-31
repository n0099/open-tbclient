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
public class q extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int JT;
    private com.baidu.tbadk.editortools.j JU;
    private CustomMessageListener RW;
    private int aBF;
    private int ana;
    private EmotionTabContentView bLj;
    private EmotionTabWidgetView bLk;
    private View bLl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bLm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bLn;
    private String bLo;
    private boolean bLp;
    private boolean bLq;
    private int bLr;

    public q(Context context) {
        super(context);
        this.bLm = new ArrayList<>();
        this.bLn = new ArrayList<>();
        this.aBF = -1;
        this.bLo = null;
        this.ana = -1;
        this.bLq = true;
        this.bLr = 0;
        this.JT = 0;
        this.RW = new r(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bLj = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bLk = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bLl = findViewById(w.h.emotion_tab_widget_div_line);
        this.bLk.setOnTabSelectedListener(this);
        this.bLj.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ana = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.ana);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bLk != null) {
            this.bLk.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> WG() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.WQ().WS().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CA() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bLm = x.WQ().WS();
        if (!this.bLq) {
            this.bLn = WG();
        } else {
            this.bLn = x.WQ().WS();
        }
        if ((this.bLm == null || this.bLm.size() <= 0) && this.bLr < 3) {
            this.bLr++;
            x.WQ().WR();
            return;
        }
        this.bLk.setDatas(this.bLm);
        int size = this.bLm.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bLm.get(i2);
            if (this.bLo != null && this.bLo.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.RW);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.RW);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ana) {
            this.ana = skinType;
            onChangeSkinType(this.ana);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bLk.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bLn.size() && i != this.aBF) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bLn.get(i);
            this.bLj.h(this.bLn, i);
            if (this.bLp) {
                if (cVar.CA() == EmotionGroupType.LOCAL) {
                    this.bLk.setShowDelete(true);
                } else {
                    this.bLk.setShowDelete(false);
                }
            }
            this.bLk.setCurrentTab(i);
            this.aBF = i;
            this.bLo = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aBF = -1;
        this.bLm.clear();
        this.bLj.reset();
        this.bLk.reset();
    }

    public void setIsInChat(boolean z) {
        this.bLp = z;
        this.bLk.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bLq = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eN(int i) {
        if (i >= 0 && i < this.bLm.size() && i != this.aBF && this.bLj != null) {
            this.bLj.hD(i);
            this.aBF = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bLk.onChangeSkinType(i);
        this.bLj.onChangeSkinType(i);
        aq.e(this.bLl, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hE(int i) {
        if (this.bLk != null && i != this.aBF) {
            this.bLk.setCurrentTab(i);
            this.aBF = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bLn.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.Cz()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bLj.h(arrayList, 0);
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
        this.JU = jVar;
        this.bLj.setOnDataSelected(jVar);
        this.bLk.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JU != null) {
            this.JU.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JT = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JT;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lO() {
        if (this.bLk != null) {
            int size = this.bLm.size();
            for (int i = 0; i < size; i++) {
                this.bLk.m(i, this.bLq);
            }
            this.bLk.setTabWidgetBigEmontionVisibility(this.bLq);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
