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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class r extends NoPressedLinearLayout implements com.baidu.tbadk.editortools.y, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int JS;
    private com.baidu.tbadk.editortools.j JT;
    private CustomMessageListener RR;
    private int aCI;
    private int aoa;
    private EmotionTabContentView bRH;
    private EmotionTabWidgetView bRI;
    private View bRJ;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bRK;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bRL;
    private String bRM;
    private boolean bRN;
    private boolean bRO;
    private boolean bRP;
    private int bRQ;

    public r(Context context) {
        super(context);
        this.bRK = new ArrayList<>();
        this.bRL = new ArrayList<>();
        this.aCI = -1;
        this.bRM = null;
        this.aoa = -1;
        this.bRO = true;
        this.bRP = true;
        this.bRQ = 0;
        this.JS = 0;
        this.RR = new s(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bRH = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bRI = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bRJ = findViewById(w.h.emotion_tab_widget_div_line);
        this.bRI.setOnTabSelectedListener(this);
        this.bRH.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.aoa = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.aoa);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bRI != null) {
            this.bRI.setFrom(i);
        }
    }

    public void setShowUserCollect(boolean z) {
        this.bRP = z;
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aac() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = z.aam().aao().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.CV() != EmotionGroupType.BIG_EMOTION || this.bRO) {
                if (next.CV() != EmotionGroupType.USER_COLLECT || this.bRP) {
                    arrayList.add(next);
                }
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bRK = z.aam().aao();
        if (!this.bRO || !this.bRP) {
            this.bRL = aac();
            if (!this.bRP && this.bRK != null) {
                this.bRK = new ArrayList<>(z.aam().aao());
                int i = 0;
                while (true) {
                    if (i < this.bRK.size()) {
                        if (this.bRK.get(i).CV() != EmotionGroupType.USER_COLLECT) {
                            i++;
                        } else {
                            this.bRK.remove(i);
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        } else {
            this.bRL = z.aam().aao();
        }
        if ((this.bRK == null || this.bRK.size() <= 0) && this.bRQ < 3) {
            this.bRQ++;
            z.aam().aan();
            return;
        }
        this.bRI.setDatas(this.bRK);
        int size = this.bRK.size();
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bRK.get(i3);
            if (this.bRM != null && this.bRM.equals(cVar.getGroupId())) {
                i2 = i3;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i2);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.RR);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.RR);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.aoa) {
            this.aoa = skinType;
            onChangeSkinType(this.aoa);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bRI.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bRL.size() && i != this.aCI) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bRL.get(i);
            this.bRH.h(this.bRL, i);
            if (this.bRN) {
                if (cVar.CV() == EmotionGroupType.LOCAL) {
                    this.bRI.setShowDelete(true);
                } else {
                    this.bRI.setShowDelete(false);
                }
            }
            this.bRI.setCurrentTab(i);
            this.aCI = i;
            this.bRM = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aCI = -1;
        this.bRK.clear();
        this.bRH.reset();
        this.bRI.reset();
    }

    public void setIsInChat(boolean z) {
        this.bRN = z;
        this.bRI.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bRO = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eP(int i) {
        if (i >= 0 && i < this.bRK.size() && i != this.aCI && this.bRH != null) {
            this.bRH.hM(i);
            this.aCI = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bRI.onChangeSkinType(i);
        this.bRH.onChangeSkinType(i);
        as.e(this.bRJ, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hN(int i) {
        if (this.bRI != null && i != this.aCI) {
            this.bRI.setCurrentTab(i);
            this.aCI = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bRL.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.CU()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bRH.h(arrayList, 0);
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
        this.JT = jVar;
        this.bRH.setOnDataSelected(jVar);
        this.bRI.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.JT != null) {
            this.JT.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.JS = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.JS;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void lM() {
        if (this.bRI != null) {
            int size = this.bRK.size();
            for (int i = 0; i < size; i++) {
                this.bRI.m(i, this.bRO);
            }
            this.bRI.setTabWidgetBigEmontionVisibility(this.bRO);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
