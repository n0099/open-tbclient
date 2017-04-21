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
    private int KN;
    private com.baidu.tbadk.editortools.j KO;
    private CustomMessageListener SQ;
    private int aBT;
    private int amZ;
    private EmotionTabContentView bFn;
    private EmotionTabWidgetView bFo;
    private View bFp;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFq;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFr;
    private String bFs;
    private boolean bFt;
    private boolean bFu;
    private int bFv;

    public q(Context context) {
        super(context);
        this.bFq = new ArrayList<>();
        this.bFr = new ArrayList<>();
        this.aBT = -1;
        this.bFs = null;
        this.amZ = -1;
        this.bFu = true;
        this.bFv = 0;
        this.KN = 0;
        this.SQ = new r(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(w.j.emotion_tab_host, (ViewGroup) this, true);
        this.bFn = (EmotionTabContentView) findViewById(w.h.face_tab_content);
        this.bFo = (EmotionTabWidgetView) findViewById(w.h.face_tab_widget);
        this.bFp = findViewById(w.h.emotion_tab_widget_div_line);
        this.bFo.setOnTabSelectedListener(this);
        this.bFn.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.amZ = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.amZ);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bFo != null) {
            this.bFo.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Wi() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Ws().Wu().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.DC() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bFq = x.Ws().Wu();
        if (!this.bFu) {
            this.bFr = Wi();
        } else {
            this.bFr = x.Ws().Wu();
        }
        if ((this.bFq == null || this.bFq.size() <= 0) && this.bFv < 3) {
            this.bFv++;
            x.Ws().Wt();
            return;
        }
        this.bFo.setDatas(this.bFq);
        int size = this.bFq.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFq.get(i2);
            if (this.bFs != null && this.bFs.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.SQ);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.SQ);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.amZ) {
            this.amZ = skinType;
            onChangeSkinType(this.amZ);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFo.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bFr.size() && i != this.aBT) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFr.get(i);
            this.bFn.h(this.bFr, i);
            if (this.bFt) {
                if (cVar.DC() == EmotionGroupType.LOCAL) {
                    this.bFo.setShowDelete(true);
                } else {
                    this.bFo.setShowDelete(false);
                }
            }
            this.bFo.setCurrentTab(i);
            this.aBT = i;
            this.bFs = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aBT = -1;
        this.bFq.clear();
        this.bFn.reset();
        this.bFo.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFt = z;
        this.bFo.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bFu = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eQ(int i) {
        if (i >= 0 && i < this.bFq.size() && i != this.aBT && this.bFn != null) {
            this.bFn.hi(i);
            this.aBT = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void onChangeSkinType(int i) {
        this.bFo.onChangeSkinType(i);
        this.bFn.onChangeSkinType(i);
        aq.e(this.bFp, w.e.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hj(int i) {
        if (this.bFo != null && i != this.aBT) {
            this.bFo.setCurrentTab(i);
            this.aBT = i;
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
                            Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = this.bFr.iterator();
                            while (it.hasNext()) {
                                com.baidu.tbadk.editortools.emotiontool.c next = it.next();
                                if (next != null && next.DB()) {
                                    arrayList.add(next);
                                }
                            }
                            this.bFn.h(arrayList, 0);
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
        this.KO = jVar;
        this.bFn.setOnDataSelected(jVar);
        this.bFo.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KO != null) {
            this.KO.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.y
    public void setToolId(int i) {
        this.KN = i;
    }

    @Override // com.baidu.tbadk.editortools.y
    public int getToolId() {
        return this.KN;
    }

    @Override // com.baidu.tbadk.editortools.y
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.y
    public void mp() {
        if (this.bFo != null) {
            int size = this.bFq.size();
            for (int i = 0; i < size; i++) {
                this.bFo.l(i, this.bFu);
            }
            this.bFo.setTabWidgetBigEmontionVisibility(this.bFu);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.y
    public void hide() {
        setVisibility(8);
    }
}
