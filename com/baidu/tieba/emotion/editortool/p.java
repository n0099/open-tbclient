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
    private int Cv;
    private com.baidu.tbadk.editortools.l Cw;
    private CustomMessageListener LT;
    private int afy;
    private int aue;
    private EmotionTabContentView btP;
    private EmotionTabWidgetView btQ;
    private View btR;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> btS;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> btT;
    private String btU;
    private boolean btV;
    private boolean btW;
    private int btX;

    public p(Context context) {
        super(context);
        this.btS = new ArrayList<>();
        this.btT = new ArrayList<>();
        this.aue = -1;
        this.btU = null;
        this.afy = -1;
        this.btW = true;
        this.btX = 0;
        this.Cv = 0;
        this.LT = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(u.h.emotion_tab_host, (ViewGroup) this, true);
        this.btP = (EmotionTabContentView) findViewById(u.g.face_tab_content);
        this.btQ = (EmotionTabWidgetView) findViewById(u.g.face_tab_widget);
        this.btR = findViewById(u.g.emotion_tab_widget_div_line);
        this.btQ.setOnTabSelectedListener(this);
        this.btP.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.afy = TbadkCoreApplication.m10getInst().getSkinType();
        onChangeSkinType(this.afy);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.btQ != null) {
            this.btQ.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> RX() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Sh().Sj().iterator();
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
        this.btS = x.Sh().Sj();
        if (!this.btW) {
            this.btT = RX();
        } else {
            this.btT = x.Sh().Sj();
        }
        if ((this.btS == null || this.btS.size() <= 0) && this.btX < 3) {
            this.btX++;
            x.Sh().Si();
            return;
        }
        this.btQ.setDatas(this.btS);
        int size = this.btS.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.btS.get(i2);
            if (this.btU != null && this.btU.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.LT);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.LT);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m10getInst().getSkinType();
        if (skinType != this.afy) {
            this.afy = skinType;
            onChangeSkinType(this.afy);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.btQ.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.btT.size() && i != this.aue) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.btT.get(i);
            this.btP.h(this.btT, i);
            if (this.btV) {
                if (cVar.BF() == EmotionGroupType.LOCAL) {
                    this.btQ.setShowDelete(true);
                } else {
                    this.btQ.setShowDelete(false);
                }
            }
            this.btQ.setCurrentTab(i);
            this.aue = i;
            this.btU = cVar.getGroupId();
        }
    }

    public void reset() {
        this.aue = -1;
        this.btS.clear();
        this.btP.reset();
        this.btQ.reset();
    }

    public void setIsInChat(boolean z) {
        this.btV = z;
        this.btQ.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.btW = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eA(int i) {
        if (i >= 0 && i < this.btS.size() && i != this.aue && this.btP != null) {
            this.btP.gA(i);
            this.aue = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.btQ.onChangeSkinType(i);
        this.btP.onChangeSkinType(i);
        av.e(this.btR, u.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void gB(int i) {
        if (this.btQ != null && i != this.aue) {
            this.btQ.setCurrentTab(i);
            this.aue = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.b
    public void a(com.baidu.tbadk.editortools.a aVar) {
        if (aVar != null) {
            switch (aVar.code) {
                case u.l.PullToRefresh_tb_ptrRotateDrawableWhilePulling /* 34 */:
                    if (aVar.data instanceof Integer) {
                        setFrom(((Integer) aVar.data).intValue());
                        return;
                    }
                    return;
                case 35:
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
        this.Cw = lVar;
        this.btP.setOnDataSelected(lVar);
        this.btQ.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.Cw != null) {
            this.Cw.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.Cv = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.Cv;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void kB() {
        if (!this.btW) {
            int size = this.btS.size();
            for (int i = 0; i < size; i++) {
                this.btQ.z(i, this.btW);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
