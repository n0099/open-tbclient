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
    private CustomMessageListener TE;
    private int apH;
    private int apO;
    private EmotionTabContentView aqd;
    private EmotionTabWidgetView aqe;
    private View aqf;
    private ArrayList<v> aqg;
    private ArrayList<v> aqh;
    private String aqi;
    private boolean aqj;
    private boolean aqk;
    private int aql;

    public j(Context context) {
        super(context);
        this.aqg = new ArrayList<>();
        this.aqh = new ArrayList<>();
        this.apO = -1;
        this.aqi = null;
        this.apH = -1;
        this.aqk = true;
        this.aql = 0;
        this.Ky = 0;
        this.TE = new k(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(i.g.emotion_tab_host, (ViewGroup) this, true);
        this.aqd = (EmotionTabContentView) findViewById(i.f.face_tab_content);
        this.aqe = (EmotionTabWidgetView) findViewById(i.f.face_tab_widget);
        this.aqf = findViewById(i.f.emotion_tab_widget_div_line);
        this.aqe.setOnTabSelectedListener(this);
        this.aqd.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.apH = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.apH);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aqe != null) {
            this.aqe.setFrom(i);
        }
    }

    private ArrayList<v> AP() {
        ArrayList<v> arrayList = new ArrayList<>();
        Iterator<v> it = t.Bc().Be().iterator();
        while (it.hasNext()) {
            v next = it.next();
            if (next.AZ() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aqg = t.Bc().Be();
        if (!this.aqk) {
            this.aqh = AP();
        } else {
            this.aqh = t.Bc().Be();
        }
        if ((this.aqg == null || this.aqg.size() <= 0) && this.aql < 3) {
            this.aql++;
            t.Bc().Bd();
            return;
        }
        this.aqe.setDatas(this.aqg);
        int size = this.aqg.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            v vVar = this.aqg.get(i2);
            if (this.aqi != null && this.aqi.equals(vVar.getGroupId())) {
                i = i2;
            }
            d(vVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TE);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TE);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.apH) {
            this.apH = skinType;
            onChangeSkinType(this.apH);
        }
    }

    private void d(v vVar) {
        this.aqe.c(vVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aqh.size() && i != this.apO) {
            v vVar = this.aqh.get(i);
            this.aqd.b(this.aqh, i);
            if (this.aqj) {
                if (vVar.AZ() == EmotionGroupType.LOCAL) {
                    this.aqe.setShowDelete(true);
                } else {
                    this.aqe.setShowDelete(false);
                }
            }
            this.aqe.setCurrentTab(i);
            this.apO = i;
            this.aqi = vVar.getGroupId();
        }
    }

    public void reset() {
        this.apO = -1;
        this.aqg.clear();
        this.aqd.reset();
        this.aqe.reset();
    }

    public void setIsInChat(boolean z) {
        this.aqj = z;
        this.aqe.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aqk = z;
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabWidgetView.a
    public void dR(int i) {
        if (i >= 0 && i < this.aqg.size() && i != this.apO && this.aqd != null) {
            this.aqd.dP(i);
            this.apO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.w
    public void onChangeSkinType(int i) {
        this.aqe.onChangeSkinType(i);
        this.aqd.onChangeSkinType(i);
        al.d(this.aqf, i.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tbadk.editortools.emotiontool.EmotionTabContentView.c
    public void dQ(int i) {
        if (this.aqe != null && i != this.apO) {
            this.aqe.setCurrentTab(i);
            this.apO = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
    }

    @Override // com.baidu.tbadk.editortools.w
    public void setEditorTools(com.baidu.tbadk.editortools.j jVar) {
        this.Kz = jVar;
        this.aqd.setOnDataSelected(jVar);
        this.aqe.setOnDataSelected(jVar);
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
    public void oy() {
        if (!this.aqk) {
            int size = this.aqg.size();
            for (int i = 0; i < size; i++) {
                this.aqe.f(i, this.aqk);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.w
    public void hide() {
        setVisibility(8);
    }
}
