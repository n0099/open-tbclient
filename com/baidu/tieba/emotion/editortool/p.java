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
import com.baidu.tieba.t;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements ab, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int EI;
    private com.baidu.tbadk.editortools.l EJ;
    private CustomMessageListener Oh;
    private int ait;
    private int axl;
    private EmotionTabContentView bFc;
    private EmotionTabWidgetView bFd;
    private View bFe;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFf;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> bFg;
    private String bFh;
    private boolean bFi;
    private boolean bFj;
    private int bFk;

    public p(Context context) {
        super(context);
        this.bFf = new ArrayList<>();
        this.bFg = new ArrayList<>();
        this.axl = -1;
        this.bFh = null;
        this.ait = -1;
        this.bFj = true;
        this.bFk = 0;
        this.EI = 0;
        this.Oh = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(t.h.emotion_tab_host, (ViewGroup) this, true);
        this.bFc = (EmotionTabContentView) findViewById(t.g.face_tab_content);
        this.bFd = (EmotionTabWidgetView) findViewById(t.g.face_tab_widget);
        this.bFe = findViewById(t.g.emotion_tab_widget_div_line);
        this.bFd.setOnTabSelectedListener(this);
        this.bFc.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.ait = TbadkCoreApplication.m9getInst().getSkinType();
        onChangeSkinType(this.ait);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.bFd != null) {
            this.bFd.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> WJ() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.WT().WV().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.Da() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.bFf = x.WT().WV();
        if (!this.bFj) {
            this.bFg = WJ();
        } else {
            this.bFg = x.WT().WV();
        }
        if ((this.bFf == null || this.bFf.size() <= 0) && this.bFk < 3) {
            this.bFk++;
            x.WT().WU();
            return;
        }
        this.bFd.setDatas(this.bFf);
        int size = this.bFf.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFf.get(i2);
            if (this.bFh != null && this.bFh.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.Oh);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.Oh);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m9getInst().getSkinType();
        if (skinType != this.ait) {
            this.ait = skinType;
            onChangeSkinType(this.ait);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.bFd.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.bFg.size() && i != this.axl) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.bFg.get(i);
            this.bFc.h(this.bFg, i);
            if (this.bFi) {
                if (cVar.Da() == EmotionGroupType.LOCAL) {
                    this.bFd.setShowDelete(true);
                } else {
                    this.bFd.setShowDelete(false);
                }
            }
            this.bFd.setCurrentTab(i);
            this.axl = i;
            this.bFh = cVar.getGroupId();
        }
    }

    public void reset() {
        this.axl = -1;
        this.bFf.clear();
        this.bFc.reset();
        this.bFd.reset();
    }

    public void setIsInChat(boolean z) {
        this.bFi = z;
        this.bFd.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.bFj = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void eO(int i) {
        if (i >= 0 && i < this.bFf.size() && i != this.axl && this.bFc != null) {
            this.bFc.hc(i);
            this.axl = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void onChangeSkinType(int i) {
        this.bFd.onChangeSkinType(i);
        this.bFc.onChangeSkinType(i);
        av.e(this.bFe, t.d.common_color_10288, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void hd(int i) {
        if (this.bFd != null && i != this.axl) {
            this.bFd.setCurrentTab(i);
            this.axl = i;
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
        this.EJ = lVar;
        this.bFc.setOnDataSelected(lVar);
        this.bFd.setOnDataSelected(lVar);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.EJ != null) {
            this.EJ.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void setToolId(int i) {
        this.EI = i;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public int getToolId() {
        return this.EI;
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void lw() {
        if (this.bFd != null) {
            int size = this.bFf.size();
            for (int i = 0; i < size; i++) {
                this.bFd.z(i, this.bFj);
            }
            this.bFd.setTabWidgetBigEmontionVisibility(this.bFj);
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.ab
    public void hide() {
        setVisibility(8);
    }
}
