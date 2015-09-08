package com.baidu.tbadk.editortools.emotiontool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView;
import com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView;
import com.baidu.tbadk.editortools.w;
import com.baidu.tieba.i;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class j extends NoPressedLinearLayout implements EmotionTabContentView.c, EmotionTabWidgetView.a, w {
    private int Ky;
    private com.baidu.tbadk.editortools.j Kz;
    private CustomMessageListener TF;
    private EmotionTabContentView arN;
    private EmotionTabWidgetView arO;
    private View arP;
    private ArrayList<v> arQ;
    private ArrayList<v> arR;
    private String arS;
    private boolean arT;
    private boolean arU;
    private int arV;
    private int arr;
    private int ary;

    public j(Context context) {
        super(context);
        this.arQ = new ArrayList<>();
        this.arR = new ArrayList<>();
        this.ary = -1;
        this.arS = null;
        this.arr = -1;
        this.arU = true;
        this.arV = 0;
        this.Ky = 0;
        this.TF = new k(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.emotion_tab_host, (ViewGroup) this, true);
        this.arN = (EmotionTabContentView) findViewById(i.f.face_tab_content);
        this.arO = (EmotionTabWidgetView) findViewById(i.f.face_tab_widget);
        this.arP = findViewById(i.f.emotion_tab_widget_div_line);
        this.arO.setOnTabSelectedListener(this);
        this.arN.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.arr = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.arr);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.arO != null) {
            this.arO.setFrom(i);
        }
    }

    private ArrayList<v> Bc() {
        ArrayList<v> arrayList = new ArrayList<>();
        Iterator<v> it = t.Bp().Br().iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.Bm() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.arQ = t.Bp().Br();
        if (!this.arU) {
            this.arR = Bc();
        } else {
            this.arR = t.Bp().Br();
        }
        if ((this.arQ == null || this.arQ.size() <= 0) && this.arV < 3) {
            this.arV++;
            t.Bp().Bq();
            return;
        }
        this.arO.setDatas(this.arQ);
        int size = this.arQ.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = this.arQ.get(i2);
            if (this.arS != null && this.arS.equals(vVar.getGroupId())) {
                i = i2;
            }
            d(vVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TF);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TF);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.arr) {
            this.arr = skinType;
            onChangeSkinType(this.arr);
        }
    }

    private void d(v vVar) {
        this.arO.c(vVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.arR.size() && i != this.ary) {
            v vVar = this.arR.get(i);
            this.arN.b(this.arR, i);
            if (this.arT) {
                if (vVar.Bm() == EmotionGroupType.LOCAL) {
                    this.arO.setShowDelete(true);
                } else {
                    this.arO.setShowDelete(false);
                }
            }
            this.arO.setCurrentTab(i);
            this.ary = i;
            this.arS = vVar.getGroupId();
        }
    }

    public void reset() {
        this.ary = -1;
        this.arQ.clear();
        this.arN.reset();
        this.arO.reset();
    }

    public void setIsInChat(boolean z) {
        this.arT = z;
        this.arO.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.arU = z;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView.a
    public void dZ(int i) {
        if (i >= 0 && i < this.arQ.size() && i != this.ary && this.arN != null) {
            this.arN.dX(i);
            this.ary = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.arO.onChangeSkinType(i);
        this.arN.onChangeSkinType(i);
        al.d(this.arP, i.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView.c
    public void dY(int i) {
        if (this.arO != null && i != this.ary) {
            this.arO.setCurrentTab(i);
            this.ary = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.arN.setOnDataSelected(jVar);
        this.arO.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Kz != null) {
            this.Kz.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Ky = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Ky;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ov() {
        if (!this.arU) {
            int size = this.arQ.size();
            for (int i = 0; i < size; i++) {
                this.arO.g(i, this.arU);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }
}
