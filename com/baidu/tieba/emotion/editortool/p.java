package com.baidu.tieba.emotion.editortool;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.NoPressedLinearLayout;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.editortools.z;
import com.baidu.tieba.emotion.editortool.EmotionTabContentView;
import com.baidu.tieba.emotion.editortool.EmotionTabWidgetView;
import com.baidu.tieba.n;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class p extends NoPressedLinearLayout implements z, EmotionTabContentView.c, EmotionTabWidgetView.a {
    private int KR;
    private com.baidu.tbadk.editortools.k KS;
    private CustomMessageListener TI;
    private EmotionTabContentView aPj;
    private EmotionTabWidgetView aPk;
    private View aPl;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aPm;
    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> aPn;
    private String aPo;
    private boolean aPp;
    private boolean aPq;
    private int aPr;
    private int afY;
    private int atv;

    public p(Context context) {
        super(context);
        this.aPm = new ArrayList<>();
        this.aPn = new ArrayList<>();
        this.atv = -1;
        this.aPo = null;
        this.afY = -1;
        this.aPq = true;
        this.aPr = 0;
        this.KR = 0;
        this.TI = new q(this, CmdConfigCustom.CMD_EMOTIONS_GROUP_CHANGED);
        init(context);
    }

    private void init(Context context) {
        removeAllViews();
        LayoutInflater.from(context).inflate(n.g.emotion_tab_host, (ViewGroup) this, true);
        this.aPj = (EmotionTabContentView) findViewById(n.f.face_tab_content);
        this.aPk = (EmotionTabWidgetView) findViewById(n.f.face_tab_widget);
        this.aPl = findViewById(n.f.emotion_tab_widget_div_line);
        this.aPk.setOnTabSelectedListener(this);
        this.aPj.setOnEmotionSwitchedListener(this);
        setOrientation(1);
        this.afY = TbadkCoreApplication.m411getInst().getSkinType();
        onChangeSkinType(this.afY);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        requestDisallowInterceptTouchEvent(true);
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setFrom(int i) {
        if (this.aPk != null) {
            this.aPk.setFrom(i);
        }
    }

    private ArrayList<com.baidu.tbadk.editortools.emotiontool.c> Jk() {
        ArrayList<com.baidu.tbadk.editortools.emotiontool.c> arrayList = new ArrayList<>();
        Iterator<com.baidu.tbadk.editortools.emotiontool.c> it = x.Ju().Jw().iterator();
        while (it.hasNext()) {
            com.baidu.tbadk.editortools.emotiontool.c next = it.next();
            if (next.BN() != EmotionGroupType.BIG_EMOTION) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setup() {
        this.aPm = x.Ju().Jw();
        if (!this.aPq) {
            this.aPn = Jk();
        } else {
            this.aPn = x.Ju().Jw();
        }
        if ((this.aPm == null || this.aPm.size() <= 0) && this.aPr < 3) {
            this.aPr++;
            x.Ju().Jv();
            return;
        }
        this.aPk.setDatas(this.aPm);
        int size = this.aPm.size();
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aPm.get(i2);
            if (this.aPo != null && this.aPo.equals(cVar.getGroupId())) {
                i = i2;
            }
            d(cVar);
        }
        setCurrentEmotionGroup(i);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        MessageManager.getInstance().registerListener(this.TI);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        MessageManager.getInstance().unRegisterListener(this.TI);
    }

    @Override // android.view.View
    public void setVisibility(int i) {
        super.setVisibility(i);
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (skinType != this.afY) {
            this.afY = skinType;
            onChangeSkinType(this.afY);
        }
    }

    private void d(com.baidu.tbadk.editortools.emotiontool.c cVar) {
        this.aPk.c(cVar);
    }

    public void setCurrentEmotionGroup(int i) {
        if (i >= 0 && i < this.aPn.size() && i != this.atv) {
            com.baidu.tbadk.editortools.emotiontool.c cVar = this.aPn.get(i);
            this.aPj.c(this.aPn, i);
            if (this.aPp) {
                if (cVar.BN() == EmotionGroupType.LOCAL) {
                    this.aPk.setShowDelete(true);
                } else {
                    this.aPk.setShowDelete(false);
                }
            }
            this.aPk.setCurrentTab(i);
            this.atv = i;
            this.aPo = cVar.getGroupId();
        }
    }

    public void reset() {
        this.atv = -1;
        this.aPm.clear();
        this.aPj.reset();
        this.aPk.reset();
    }

    public void setIsInChat(boolean z) {
        this.aPp = z;
        this.aPk.setIsInChat(z);
    }

    public void setShowBigEmotion(boolean z) {
        this.aPq = z;
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabWidgetView.a
    public void ew(int i) {
        if (i >= 0 && i < this.aPm.size() && i != this.atv && this.aPj != null) {
            this.aPj.fk(i);
            this.atv = i;
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void onChangeSkinType(int i) {
        this.aPk.onChangeSkinType(i);
        this.aPj.onChangeSkinType(i);
        as.d(this.aPl, n.c.emotion_tab_div_line_color, i);
    }

    @Override // com.baidu.tieba.emotion.editortool.EmotionTabContentView.c
    public void fl(int i) {
        if (this.aPk != null && i != this.atv) {
            this.aPk.setCurrentTab(i);
            this.atv = i;
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
                case TbConfig.FRS_NOABSTRACT_ITEM_NUMBER /* 35 */:
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

    @Override // com.baidu.tbadk.editortools.z
    public void setEditorTools(com.baidu.tbadk.editortools.k kVar) {
        this.KS = kVar;
        this.aPj.setOnDataSelected(kVar);
        this.aPk.setOnDataSelected(kVar);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void b(com.baidu.tbadk.editortools.a aVar) {
        if (this.KS != null) {
            this.KS.b(aVar);
        }
    }

    @Override // com.baidu.tbadk.editortools.z
    public void setToolId(int i) {
        this.KR = i;
    }

    @Override // com.baidu.tbadk.editortools.z
    public int getToolId() {
        return this.KR;
    }

    @Override // com.baidu.tbadk.editortools.z
    public void init() {
        setup();
    }

    @Override // com.baidu.tbadk.editortools.z
    public void oD() {
        if (!this.aPq) {
            int size = this.aPm.size();
            for (int i = 0; i < size; i++) {
                this.aPk.h(i, this.aPq);
            }
        }
        setVisibility(0);
    }

    @Override // com.baidu.tbadk.editortools.z
    public void hide() {
        setVisibility(8);
    }
}
