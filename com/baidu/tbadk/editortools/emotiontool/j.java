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
import com.baidu.tbadk.core.util.am;
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
    private CustomMessageListener Tr;
    private int apR;
    private int apY;
    private EmotionTabContentView aqn;
    private EmotionTabWidgetView aqo;
    private View aqp;
    private ArrayList<t> aqq;
    private ArrayList<t> aqr;
    private String aqs;
    private boolean aqt;
    private boolean aqu;
    private int aqv;

    public j(Context context) {
        super(context);
        this.aqq = new ArrayList<>();
        this.aqr = new ArrayList<>();
        this.apY = -1;
        this.aqs = null;
        this.apR = -1;
        this.aqu = true;
        this.aqv = 0;
        this.Ky = 0;
        this.Tr = new k(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.emotion_tab_host, (ViewGroup) this, true);
        this.aqn = (EmotionTabContentView) findViewById(i.f.face_tab_content);
        this.aqo = (EmotionTabWidgetView) findViewById(i.f.face_tab_widget);
        this.aqp = findViewById(i.f.emotion_tab_widget_div_line);
        this.aqo.setOnTabSelectedListener(this);
        this.aqn.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apR = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.apR);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aqo != null) {
            this.aqo.setFrom(i);
        }
    }

    private ArrayList<t> AP() {
        ArrayList<t> arrayList = new ArrayList<>();
        Iterator<t> it = r.Bc().Be().iterator();
        while (it.hasNext()) {
            t next = it.next();
            if (next.AZ() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aqq = r.Bc().Be();
        if (!this.aqu) {
            this.aqr = AP();
        } else {
            this.aqr = r.Bc().Be();
        }
        if ((this.aqq == null || this.aqq.size() <= 0) && this.aqv < 3) {
            this.aqv++;
            r.Bc().Bd();
            return;
        }
        this.aqo.setDatas(this.aqq);
        int size = this.aqq.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            t tVar = this.aqq.get(i2);
            if (this.aqs != null && this.aqs.equals(tVar.getGroupId())) {
                i = i2;
            }
            d(tVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Tr);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Tr);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apR) {
            this.apR = skinType;
            onChangeSkinType(this.apR);
        }
    }

    private void d(t tVar) {
        this.aqo.c(tVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aqr.size() && i != this.apY) {
            t tVar = this.aqr.get(i);
            this.aqn.c(this.aqr, i);
            if (this.aqt) {
                if (tVar.AZ() == EmotionGroupType.LOCAL) {
                    this.aqo.setShowDelete(true);
                } else {
                    this.aqo.setShowDelete(false);
                }
            }
            this.aqo.setCurrentTab(i);
            this.apY = i;
            this.aqs = tVar.getGroupId();
        }
    }

    public void reset() {
        this.apY = -1;
        this.aqq.clear();
        this.aqn.reset();
        this.aqo.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqt = z;
        this.aqo.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aqu = z;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView.a
    public void ea(int i) {
        if (i >= 0 && i < this.aqq.size() && i != this.apY && this.aqn != null) {
            this.aqn.dY(i);
            this.apY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.aqo.onChangeSkinType(i);
        this.aqn.onChangeSkinType(i);
        am.d(this.aqp, i.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView.c
    public void dZ(int i) {
        if (this.aqo != null && i != this.apY) {
            this.aqo.setCurrentTab(i);
            this.apY = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.aqn.setOnDataSelected(jVar);
        this.aqo.setOnDataSelected(jVar);
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
    public void ow() {
        if (!this.aqu) {
            int size = this.aqq.size();
            for (int i = 0; i < size; i++) {
                this.aqo.g(i, this.aqu);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }
}
