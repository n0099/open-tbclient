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
import com.baidu.tbadk.core.util.an;
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
    private com.baidu.tbadk.editortools.j KA;
    private int Kz;
    private CustomMessageListener Ts;
    private int apS;
    private int apZ;
    private EmotionTabContentView aqo;
    private EmotionTabWidgetView aqp;
    private View aqq;
    private ArrayList<t> aqr;
    private ArrayList<t> aqs;
    private String aqt;
    private boolean aqu;
    private boolean aqv;
    private int aqw;

    public j(Context context) {
        super(context);
        this.aqr = new ArrayList<>();
        this.aqs = new ArrayList<>();
        this.apZ = -1;
        this.aqt = null;
        this.apS = -1;
        this.aqv = true;
        this.aqw = 0;
        this.Kz = 0;
        this.Ts = new k(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.emotion_tab_host, (ViewGroup) this, true);
        this.aqo = (EmotionTabContentView) findViewById(i.f.face_tab_content);
        this.aqp = (EmotionTabWidgetView) findViewById(i.f.face_tab_widget);
        this.aqq = findViewById(i.f.emotion_tab_widget_div_line);
        this.aqp.setOnTabSelectedListener(this);
        this.aqo.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apS = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.apS);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aqp != null) {
            this.aqp.setFrom(i);
        }
    }

    private ArrayList<t> AM() {
        ArrayList<t> arrayList = new ArrayList<>();
        Iterator<t> it = r.AZ().Bb().iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.AW() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aqr = r.AZ().Bb();
        if (!this.aqv) {
            this.aqs = AM();
        } else {
            this.aqs = r.AZ().Bb();
        }
        if ((this.aqr == null || this.aqr.size() <= 0) && this.aqw < 3) {
            this.aqw++;
            r.AZ().Ba();
            return;
        }
        this.aqp.setDatas(this.aqr);
        int size = this.aqr.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            t tVar = this.aqr.get(i2);
            if (this.aqt != null && this.aqt.equals(tVar.getGroupId())) {
                i = i2;
            }
            d(tVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Ts);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Ts);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apS) {
            this.apS = skinType;
            onChangeSkinType(this.apS);
        }
    }

    private void d(t tVar) {
        this.aqp.c(tVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aqs.size() && i != this.apZ) {
            t tVar = this.aqs.get(i);
            this.aqo.c(this.aqs, i);
            if (this.aqu) {
                if (tVar.AW() == EmotionGroupType.LOCAL) {
                    this.aqp.setShowDelete(true);
                } else {
                    this.aqp.setShowDelete(false);
                }
            }
            this.aqp.setCurrentTab(i);
            this.apZ = i;
            this.aqt = tVar.getGroupId();
        }
    }

    public void reset() {
        this.apZ = -1;
        this.aqr.clear();
        this.aqo.reset();
        this.aqp.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqu = z;
        this.aqp.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aqv = z;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView.a
    public void ea(int i) {
        if (i >= 0 && i < this.aqr.size() && i != this.apZ && this.aqo != null) {
            this.aqo.dY(i);
            this.apZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.aqp.onChangeSkinType(i);
        this.aqo.onChangeSkinType(i);
        an.d(this.aqq, i.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView.c
    public void dZ(int i) {
        if (this.aqp != null && i != this.apZ) {
            this.aqp.setCurrentTab(i);
            this.apZ = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.KA = jVar;
        this.aqo.setOnDataSelected(jVar);
        this.aqp.setOnDataSelected(jVar);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KA != null) {
            this.KA.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setToolId(int i) {
        this.Kz = i;
    }

    @Override // com.baidu.tbadk.editortools.w
    public int getToolId() {
        return this.Kz;
    }

    @Override // com.baidu.tbadk.editortools.w
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.w
    public void ow() {
        if (!this.aqv) {
            int size = this.aqr.size();
            for (int i = 0; i < size; i++) {
                this.aqp.g(i, this.aqv);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }
}
